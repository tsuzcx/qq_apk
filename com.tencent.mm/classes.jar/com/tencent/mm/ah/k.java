package com.tencent.mm.ah;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.cg.h;
import com.tencent.mm.model.r;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aky;
import com.tencent.mm.protocal.protobuf.akz;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import java.io.IOException;
import java.io.OutputStream;

final class k
  extends m
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.ai.f callback;
  private String frV;
  private int fsa;
  private String fsc;
  private int fsr;
  private String fss;
  private OutputStream output;
  private String username;
  
  public k(String paramString)
  {
    AppMethodBeat.i(77932);
    this.output = null;
    this.username = paramString;
    if (ad.nM(paramString)) {
      this.username = ad.ark(paramString);
    }
    ab.i("MicroMsg.NetSceneGetHDHeadImg", "init Headimage in_username:" + paramString + " out_username" + this.username);
    this.fsa = 480;
    this.fsr = 480;
    this.fsc = "jpg";
    AppMethodBeat.o(77932);
  }
  
  private int Q(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(77938);
    try
    {
      if (this.output == null) {
        this.output = com.tencent.mm.vfs.e.M(this.fss, false);
      }
      this.output.write(paramArrayOfByte);
      int i = paramArrayOfByte.length;
      AppMethodBeat.o(77938);
      return i;
    }
    catch (IOException paramArrayOfByte)
    {
      ab.e("MicroMsg.NetSceneGetHDHeadImg", "exception:%s", new Object[] { bo.l(paramArrayOfByte) });
      AppMethodBeat.o(77938);
    }
    return -1;
  }
  
  private void ada()
  {
    AppMethodBeat.i(77939);
    try
    {
      if (this.output != null)
      {
        this.output.flush();
        this.output.close();
        this.output = null;
      }
      AppMethodBeat.o(77939);
      return;
    }
    catch (IOException localIOException)
    {
      ab.e("MicroMsg.NetSceneGetHDHeadImg", "exception:%s", new Object[] { bo.l(localIOException) });
      AppMethodBeat.o(77939);
    }
  }
  
  public static void az(String paramString1, String paramString2)
  {
    AppMethodBeat.i(77936);
    o.acQ().ay(paramString1, paramString2);
    AppMethodBeat.o(77936);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(77937);
    super.cancel();
    ada();
    AppMethodBeat.o(77937);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ai.f paramf)
  {
    int j = 0;
    AppMethodBeat.i(77933);
    this.callback = paramf;
    if ((this.username == null) || (this.username.length() == 0))
    {
      ab.e("MicroMsg.NetSceneGetHDHeadImg", "username is null");
      AppMethodBeat.o(77933);
      return -1;
    }
    if (this.username.endsWith("@qqim"))
    {
      ab.e("MicroMsg.NetSceneGetHDHeadImg", "never try get qq user hd.");
      AppMethodBeat.o(77933);
      return -1;
    }
    Object localObject1 = o.adh();
    o.acQ();
    this.frV = d.D(this.username, true);
    if (com.tencent.mm.vfs.e.cN(this.frV))
    {
      ab.i("MicroMsg.NetSceneGetHDHeadImg", "The HDAvatar of " + this.username + " is already exists");
      AppMethodBeat.o(77933);
      return 0;
    }
    this.fss = (this.frV + ".tmp");
    paramf = ((g)localObject1).rh(this.username);
    Object localObject2;
    if (paramf == null)
    {
      com.tencent.mm.vfs.e.deleteFile(this.fss);
      paramf = new f();
      paramf.username = this.username;
      paramf.fsc = this.fsc;
      paramf.fsa = this.fsa;
      paramf.fsb = this.fsr;
      paramf.bsY = -1;
      localObject2 = paramf.convertTo();
      ((g)localObject1).fnw.a("hdheadimginfo", "username", (ContentValues)localObject2);
      localObject1 = new b.a();
      ((b.a)localObject1).fsX = new aky();
      ((b.a)localObject1).fsY = new akz();
      ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/gethdheadimg";
      ((b.a)localObject1).funcId = 158;
      ((b.a)localObject1).reqCmdId = 47;
      ((b.a)localObject1).respCmdId = 1000000047;
      localObject1 = ((b.a)localObject1).ado();
      localObject2 = (aky)((com.tencent.mm.ai.b)localObject1).fsV.fta;
      if (ad.nM(this.username)) {
        break label636;
      }
      ((aky)localObject2).jJA = this.username;
      ((aky)localObject2).xbX = 1;
    }
    for (;;)
    {
      ab.d("MicroMsg.NetSceneGetHDHeadImg", "inUser:" + this.username + " outUser:" + ((aky)localObject2).jJA + " outType:" + ((aky)localObject2).xbX);
      ((aky)localObject2).xbU = this.fsa;
      ((aky)localObject2).xbV = this.fsr;
      ((aky)localObject2).xbW = this.fsc;
      ((aky)localObject2).pIx = paramf.fsd;
      ((aky)localObject2).pIy = paramf.chT;
      int i = dispatch(parame, (q)localObject1, this);
      AppMethodBeat.o(77933);
      return i;
      localObject2 = this.fss;
      i = j;
      if (paramf != null)
      {
        i = j;
        if (localObject2 != null)
        {
          if (((String)localObject2).length() != 0) {
            break label569;
          }
          i = j;
        }
      }
      for (;;)
      {
        if (i == 0)
        {
          com.tencent.mm.vfs.e.deleteFile(this.fss);
          paramf.reset();
          paramf.username = this.username;
          paramf.fsc = this.fsc;
          paramf.fsa = this.fsa;
          paramf.fsb = this.fsr;
          ((g)localObject1).a(this.username, paramf);
        }
        break;
        label569:
        i = j;
        if (paramf.acV().equals(this.fsc))
        {
          i = j;
          if (paramf.fsa == this.fsa)
          {
            i = j;
            if (paramf.fsb == this.fsr)
            {
              i = j;
              if (com.tencent.mm.vfs.e.avI((String)localObject2) == paramf.chT) {
                i = 1;
              }
            }
          }
        }
      }
      label636:
      if (this.username.equals(r.Zn() + "@bottle"))
      {
        ((aky)localObject2).jJA = r.Zn();
        ((aky)localObject2).xbX = 2;
      }
      else
      {
        ((aky)localObject2).jJA = this.username;
        ((aky)localObject2).xbX = 2;
      }
    }
  }
  
  public final int getType()
  {
    return 158;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(77935);
    paramArrayOfByte = (akz)((com.tencent.mm.ai.b)paramq).fsW.fta;
    ab.d("MicroMsg.NetSceneGetHDHeadImg", "errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 4) && (paramInt3 != 0))
    {
      ab.e("MicroMsg.NetSceneGetHDHeadImg", "errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      ada();
      AppMethodBeat.o(77935);
      return;
    }
    if ((paramInt2 == 4) || (paramInt2 == 5))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      ab.e("MicroMsg.NetSceneGetHDHeadImg", "ErrType:".concat(String.valueOf(paramInt2)));
      ada();
      AppMethodBeat.o(77935);
      return;
    }
    paramInt1 = paramq.getRespObj().getRetCode();
    if ((paramInt1 == -4) || (paramInt1 == -54) || (paramInt1 == -55)) {
      ab.e("MicroMsg.NetSceneGetHDHeadImg", "retcode == ".concat(String.valueOf(paramInt1)));
    }
    for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
    {
      ab.e("MicroMsg.NetSceneGetHDHeadImg", "handleCertainError");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      ada();
      AppMethodBeat.o(77935);
      return;
    }
    int i = -1;
    paramInt1 = i;
    if (paramArrayOfByte.pIA != null)
    {
      paramInt1 = i;
      if (paramArrayOfByte.pIA.getBuffer() != null) {
        paramInt1 = Q(paramArrayOfByte.pIA.getBuffer().pW);
      }
    }
    if (paramInt1 < 0)
    {
      ab.e("MicroMsg.NetSceneGetHDHeadImg", "appendBuf fail");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      ada();
      AppMethodBeat.o(77935);
      return;
    }
    paramq = o.adh();
    f localf = paramq.rh(this.username);
    if (localf == null)
    {
      ab.e("MicroMsg.NetSceneGetHDHeadImg", "info == null");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      ada();
      AppMethodBeat.o(77935);
      return;
    }
    localf.chT = (paramInt1 + paramArrayOfByte.pIy);
    localf.fsd = paramArrayOfByte.pIx;
    paramq.a(this.username, localf);
    if (localf.chT >= localf.fsd) {}
    for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
    {
      ab.i("MicroMsg.NetSceneGetHDHeadImg", "%d doScene again info[%s %d %d]", new Object[] { Integer.valueOf(hashCode()), this.username, Integer.valueOf(localf.chT), Integer.valueOf(localf.fsd) });
      if (doScene(dispatcher(), this.callback) < 0) {
        this.callback.onSceneEnd(3, -1, "", this);
      }
      AppMethodBeat.o(77935);
      return;
    }
    com.tencent.mm.vfs.e.aT(this.fss, this.frV);
    az(this.frV, this.username);
    ada();
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(77935);
  }
  
  public final int securityLimitCount()
  {
    return 10;
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    AppMethodBeat.i(77934);
    if ((this.username == null) || (this.username.length() == 0))
    {
      paramq = m.b.ftv;
      AppMethodBeat.o(77934);
      return paramq;
    }
    paramq = m.b.ftu;
    AppMethodBeat.o(77934);
    return paramq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ah.k
 * JD-Core Version:    0.7.0.1
 */
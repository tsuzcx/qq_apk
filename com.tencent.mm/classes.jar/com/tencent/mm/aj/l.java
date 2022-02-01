package com.tencent.mm.aj;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.model.v;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bcm;
import com.tencent.mm.protocal.protobuf.bcn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.vfs.o;
import java.io.IOException;
import java.io.OutputStream;

final class l
  extends n
  implements k
{
  private f callback;
  private String hPB;
  private int hPF;
  private String hPH;
  private int hPW;
  private String hPX;
  private OutputStream output;
  private String username;
  
  public l(String paramString)
  {
    AppMethodBeat.i(150296);
    this.output = null;
    this.username = paramString;
    if (an.Ac(paramString)) {
      this.username = an.aUA(paramString);
    }
    ae.i("MicroMsg.NetSceneGetHDHeadImg", "init Headimage in_username:" + paramString + " out_username" + this.username);
    this.hPF = 480;
    this.hPW = 480;
    this.hPH = "jpg";
    AppMethodBeat.o(150296);
  }
  
  private int W(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150302);
    try
    {
      if (this.output == null) {
        this.output = o.db(this.hPX, false);
      }
      this.output.write(paramArrayOfByte);
      int i = paramArrayOfByte.length;
      AppMethodBeat.o(150302);
      return i;
    }
    catch (IOException paramArrayOfByte)
    {
      ae.e("MicroMsg.NetSceneGetHDHeadImg", "exception:%s", new Object[] { bu.o(paramArrayOfByte) });
      AppMethodBeat.o(150302);
    }
    return -1;
  }
  
  private void aEJ()
  {
    AppMethodBeat.i(150303);
    try
    {
      if (this.output != null)
      {
        this.output.flush();
        this.output.close();
        this.output = null;
      }
      AppMethodBeat.o(150303);
      return;
    }
    catch (IOException localIOException)
    {
      ae.e("MicroMsg.NetSceneGetHDHeadImg", "exception:%s", new Object[] { bu.o(localIOException) });
      AppMethodBeat.o(150303);
    }
  }
  
  public static void aY(String paramString1, String paramString2)
  {
    AppMethodBeat.i(150300);
    p.aEA().aX(paramString1, paramString2);
    AppMethodBeat.o(150300);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(150301);
    super.cancel();
    aEJ();
    AppMethodBeat.o(150301);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    int j = 0;
    AppMethodBeat.i(150297);
    this.callback = paramf;
    if ((this.username == null) || (this.username.length() == 0))
    {
      ae.e("MicroMsg.NetSceneGetHDHeadImg", "username is null");
      AppMethodBeat.o(150297);
      return -1;
    }
    if (this.username.endsWith("@qqim"))
    {
      ae.e("MicroMsg.NetSceneGetHDHeadImg", "never try get qq user hd.");
      AppMethodBeat.o(150297);
      return -1;
    }
    Object localObject1 = p.aEO();
    p.aEA();
    this.hPB = e.J(this.username, true);
    if (o.fB(this.hPB))
    {
      ae.i("MicroMsg.NetSceneGetHDHeadImg", "The HDAvatar of " + this.username + " is already exists");
      AppMethodBeat.o(150297);
      return 0;
    }
    this.hPX = (this.hPB + ".tmp");
    paramf = ((h)localObject1).DJ(this.username);
    Object localObject2;
    if (paramf == null)
    {
      o.deleteFile(this.hPX);
      paramf = new g();
      paramf.username = this.username;
      paramf.hPH = this.hPH;
      paramf.hPF = this.hPF;
      paramf.hPG = this.hPW;
      paramf.dEu = -1;
      localObject2 = paramf.convertTo();
      ((h)localObject1).hKK.a("hdheadimginfo", "username", (ContentValues)localObject2);
      localObject1 = new b.a();
      ((b.a)localObject1).hQF = new bcm();
      ((b.a)localObject1).hQG = new bcn();
      ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/gethdheadimg";
      ((b.a)localObject1).funcId = 158;
      ((b.a)localObject1).hQH = 47;
      ((b.a)localObject1).respCmdId = 1000000047;
      localObject1 = ((b.a)localObject1).aDS();
      localObject2 = (bcm)((com.tencent.mm.ak.b)localObject1).hQD.hQJ;
      if (an.Ac(this.username)) {
        break label636;
      }
      ((bcm)localObject2).nIJ = this.username;
      ((bcm)localObject2).GSk = 1;
    }
    for (;;)
    {
      ae.d("MicroMsg.NetSceneGetHDHeadImg", "inUser:" + this.username + " outUser:" + ((bcm)localObject2).nIJ + " outType:" + ((bcm)localObject2).GSk);
      ((bcm)localObject2).GSh = this.hPF;
      ((bcm)localObject2).GSi = this.hPW;
      ((bcm)localObject2).GSj = this.hPH;
      ((bcm)localObject2).xsB = paramf.hPI;
      ((bcm)localObject2).xsC = paramf.dgI;
      int i = dispatch(parame, (q)localObject1, this);
      AppMethodBeat.o(150297);
      return i;
      localObject2 = this.hPX;
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
          o.deleteFile(this.hPX);
          paramf.reset();
          paramf.username = this.username;
          paramf.hPH = this.hPH;
          paramf.hPF = this.hPF;
          paramf.hPG = this.hPW;
          ((h)localObject1).a(this.username, paramf);
        }
        break;
        label569:
        i = j;
        if (paramf.aEE().equals(this.hPH))
        {
          i = j;
          if (paramf.hPF == this.hPF)
          {
            i = j;
            if (paramf.hPG == this.hPW)
            {
              i = j;
              if (o.aZR((String)localObject2) == paramf.dgI) {
                i = 1;
              }
            }
          }
        }
      }
      label636:
      if (this.username.equals(v.aAC() + "@bottle"))
      {
        ((bcm)localObject2).nIJ = v.aAC();
        ((bcm)localObject2).GSk = 2;
      }
      else
      {
        ((bcm)localObject2).nIJ = this.username;
        ((bcm)localObject2).GSk = 2;
      }
    }
  }
  
  public final int getType()
  {
    return 158;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150299);
    paramArrayOfByte = (bcn)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
    ae.d("MicroMsg.NetSceneGetHDHeadImg", "errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 4) && (paramInt3 != 0))
    {
      ae.e("MicroMsg.NetSceneGetHDHeadImg", "errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      aEJ();
      AppMethodBeat.o(150299);
      return;
    }
    if ((paramInt2 == 4) || (paramInt2 == 5))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      ae.e("MicroMsg.NetSceneGetHDHeadImg", "ErrType:".concat(String.valueOf(paramInt2)));
      aEJ();
      AppMethodBeat.o(150299);
      return;
    }
    paramInt1 = paramq.getRespObj().getRetCode();
    if ((paramInt1 == -4) || (paramInt1 == -54) || (paramInt1 == -55)) {
      ae.e("MicroMsg.NetSceneGetHDHeadImg", "retcode == ".concat(String.valueOf(paramInt1)));
    }
    for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
    {
      ae.e("MicroMsg.NetSceneGetHDHeadImg", "handleCertainError");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      aEJ();
      AppMethodBeat.o(150299);
      return;
    }
    int i = -1;
    paramInt1 = i;
    if (paramArrayOfByte.xsE != null)
    {
      paramInt1 = i;
      if (paramArrayOfByte.xsE.getBuffer() != null) {
        paramInt1 = W(paramArrayOfByte.xsE.getBuffer().zr);
      }
    }
    if (paramInt1 < 0)
    {
      ae.e("MicroMsg.NetSceneGetHDHeadImg", "appendBuf fail");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      aEJ();
      AppMethodBeat.o(150299);
      return;
    }
    paramq = p.aEO();
    g localg = paramq.DJ(this.username);
    if (localg == null)
    {
      ae.e("MicroMsg.NetSceneGetHDHeadImg", "info == null");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      aEJ();
      AppMethodBeat.o(150299);
      return;
    }
    localg.dgI = (paramInt1 + paramArrayOfByte.xsC);
    localg.hPI = paramArrayOfByte.xsB;
    paramq.a(this.username, localg);
    if (localg.dgI >= localg.hPI) {}
    for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
    {
      ae.i("MicroMsg.NetSceneGetHDHeadImg", "%d doScene again info[%s %d %d]", new Object[] { Integer.valueOf(hashCode()), this.username, Integer.valueOf(localg.dgI), Integer.valueOf(localg.hPI) });
      if (doScene(dispatcher(), this.callback) < 0) {
        this.callback.onSceneEnd(3, -1, "", this);
      }
      AppMethodBeat.o(150299);
      return;
    }
    o.mG(this.hPX, this.hPB);
    aY(this.hPB, this.username);
    aEJ();
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(150299);
  }
  
  public final int securityLimitCount()
  {
    return 10;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    AppMethodBeat.i(150298);
    if ((this.username == null) || (this.username.length() == 0))
    {
      paramq = n.b.hRj;
      AppMethodBeat.o(150298);
      return paramq;
    }
    paramq = n.b.hRi;
    AppMethodBeat.o(150298);
    return paramq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.aj.l
 * JD-Core Version:    0.7.0.1
 */
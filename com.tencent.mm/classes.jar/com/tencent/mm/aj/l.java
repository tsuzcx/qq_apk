package com.tencent.mm.aj;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.bw.b;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bny;
import com.tencent.mm.protocal.protobuf.bnz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import java.io.IOException;
import java.io.OutputStream;

final class l
  extends q
  implements m
{
  private i callback;
  private String iKI;
  private int iKM;
  private String iKO;
  private int iLd;
  private String iLe;
  private OutputStream output;
  private String username;
  
  public l(String paramString)
  {
    AppMethodBeat.i(150296);
    this.output = null;
    this.username = paramString;
    if (as.IG(paramString)) {
      this.username = as.bjz(paramString);
    }
    Log.i("MicroMsg.NetSceneGetHDHeadImg", "init Headimage in_username:" + paramString + " out_username" + this.username);
    this.iKM = 480;
    this.iLd = 480;
    this.iKO = "jpg";
    AppMethodBeat.o(150296);
  }
  
  private void aYw()
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
      Log.e("MicroMsg.NetSceneGetHDHeadImg", "exception:%s", new Object[] { Util.stackTraceToString(localIOException) });
      AppMethodBeat.o(150303);
    }
  }
  
  private int ak(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150302);
    try
    {
      if (this.output == null) {
        this.output = com.tencent.mm.vfs.s.dw(this.iLe, false);
      }
      this.output.write(paramArrayOfByte);
      int i = paramArrayOfByte.length;
      AppMethodBeat.o(150302);
      return i;
    }
    catch (IOException paramArrayOfByte)
    {
      Log.e("MicroMsg.NetSceneGetHDHeadImg", "exception:%s", new Object[] { Util.stackTraceToString(paramArrayOfByte) });
      AppMethodBeat.o(150302);
    }
    return -1;
  }
  
  public static void bc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(150300);
    p.aYn().bb(paramString1, paramString2);
    AppMethodBeat.o(150300);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(150301);
    super.cancel();
    aYw();
    AppMethodBeat.o(150301);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    int j = 0;
    AppMethodBeat.i(150297);
    this.callback = parami;
    if ((this.username == null) || (this.username.length() == 0))
    {
      Log.e("MicroMsg.NetSceneGetHDHeadImg", "username is null");
      AppMethodBeat.o(150297);
      return -1;
    }
    if (this.username.endsWith("@qqim"))
    {
      Log.e("MicroMsg.NetSceneGetHDHeadImg", "never try get qq user hd.");
      AppMethodBeat.o(150297);
      return -1;
    }
    Object localObject1 = p.aYC();
    p.aYn();
    this.iKI = e.L(this.username, true);
    if (com.tencent.mm.vfs.s.YS(this.iKI))
    {
      Log.i("MicroMsg.NetSceneGetHDHeadImg", "The HDAvatar of " + this.username + " is already exists");
      AppMethodBeat.o(150297);
      return 0;
    }
    this.iLe = (this.iKI + ".tmp");
    parami = ((h)localObject1).Mu(this.username);
    Object localObject2;
    if (parami == null)
    {
      com.tencent.mm.vfs.s.deleteFile(this.iLe);
      parami = new g();
      parami.username = this.username;
      parami.iKO = this.iKO;
      parami.iKM = this.iKM;
      parami.iKN = this.iLd;
      parami.cSx = -1;
      localObject2 = parami.convertTo();
      ((h)localObject1).iFy.insert("hdheadimginfo", "username", (ContentValues)localObject2);
      localObject1 = new d.a();
      ((d.a)localObject1).iLN = new bny();
      ((d.a)localObject1).iLO = new bnz();
      ((d.a)localObject1).uri = "/cgi-bin/micromsg-bin/gethdheadimg";
      ((d.a)localObject1).funcId = 158;
      ((d.a)localObject1).iLP = 47;
      ((d.a)localObject1).respCmdId = 1000000047;
      localObject1 = ((d.a)localObject1).aXF();
      localObject2 = (bny)((d)localObject1).iLK.iLR;
      if (as.IG(this.username)) {
        break label636;
      }
      ((bny)localObject2).UserName = this.username;
      ((bny)localObject2).LWp = 1;
    }
    for (;;)
    {
      Log.d("MicroMsg.NetSceneGetHDHeadImg", "inUser:" + this.username + " outUser:" + ((bny)localObject2).UserName + " outType:" + ((bny)localObject2).LWp);
      ((bny)localObject2).LWm = this.iKM;
      ((bny)localObject2).LWn = this.iLd;
      ((bny)localObject2).LWo = this.iKO;
      ((bny)localObject2).BsF = parami.iKP;
      ((bny)localObject2).BsG = parami.bNu;
      int i = dispatch(paramg, (com.tencent.mm.network.s)localObject1, this);
      AppMethodBeat.o(150297);
      return i;
      localObject2 = this.iLe;
      i = j;
      if (parami != null)
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
          com.tencent.mm.vfs.s.deleteFile(this.iLe);
          parami.reset();
          parami.username = this.username;
          parami.iKO = this.iKO;
          parami.iKM = this.iKM;
          parami.iKN = this.iLd;
          ((h)localObject1).a(this.username, parami);
        }
        break;
        label569:
        i = j;
        if (parami.aYp().equals(this.iKO))
        {
          i = j;
          if (parami.iKM == this.iKM)
          {
            i = j;
            if (parami.iKN == this.iLd)
            {
              i = j;
              if (com.tencent.mm.vfs.s.boW((String)localObject2) == parami.bNu) {
                i = 1;
              }
            }
          }
        }
      }
      label636:
      if (this.username.equals(z.aTY() + "@bottle"))
      {
        ((bny)localObject2).UserName = z.aTY();
        ((bny)localObject2).LWp = 2;
      }
      else
      {
        ((bny)localObject2).UserName = this.username;
        ((bny)localObject2).LWp = 2;
      }
    }
  }
  
  public final int getType()
  {
    return 158;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150299);
    paramArrayOfByte = (bnz)((d)params).iLL.iLR;
    Log.d("MicroMsg.NetSceneGetHDHeadImg", "errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 4) && (paramInt3 != 0))
    {
      Log.e("MicroMsg.NetSceneGetHDHeadImg", "errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      aYw();
      AppMethodBeat.o(150299);
      return;
    }
    if ((paramInt2 == 4) || (paramInt2 == 5))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      Log.e("MicroMsg.NetSceneGetHDHeadImg", "ErrType:".concat(String.valueOf(paramInt2)));
      aYw();
      AppMethodBeat.o(150299);
      return;
    }
    paramInt1 = params.getRespObj().getRetCode();
    if ((paramInt1 == -4) || (paramInt1 == -54) || (paramInt1 == -55)) {
      Log.e("MicroMsg.NetSceneGetHDHeadImg", "retcode == ".concat(String.valueOf(paramInt1)));
    }
    for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
    {
      Log.e("MicroMsg.NetSceneGetHDHeadImg", "handleCertainError");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      aYw();
      AppMethodBeat.o(150299);
      return;
    }
    int i = -1;
    paramInt1 = i;
    if (paramArrayOfByte.BsI != null)
    {
      paramInt1 = i;
      if (paramArrayOfByte.BsI.getBuffer() != null) {
        paramInt1 = ak(paramArrayOfByte.BsI.getBuffer().zy);
      }
    }
    if (paramInt1 < 0)
    {
      Log.e("MicroMsg.NetSceneGetHDHeadImg", "appendBuf fail");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      aYw();
      AppMethodBeat.o(150299);
      return;
    }
    params = p.aYC();
    g localg = params.Mu(this.username);
    if (localg == null)
    {
      Log.e("MicroMsg.NetSceneGetHDHeadImg", "info == null");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      aYw();
      AppMethodBeat.o(150299);
      return;
    }
    localg.bNu = (paramInt1 + paramArrayOfByte.BsG);
    localg.iKP = paramArrayOfByte.BsF;
    params.a(this.username, localg);
    if (localg.bNu >= localg.iKP) {}
    for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
    {
      Log.i("MicroMsg.NetSceneGetHDHeadImg", "%d doScene again info[%s %d %d]", new Object[] { Integer.valueOf(hashCode()), this.username, Integer.valueOf(localg.bNu), Integer.valueOf(localg.iKP) });
      if (doScene(dispatcher(), this.callback) < 0) {
        this.callback.onSceneEnd(3, -1, "", this);
      }
      AppMethodBeat.o(150299);
      return;
    }
    com.tencent.mm.vfs.s.nx(this.iLe, this.iKI);
    bc(this.iKI, this.username);
    aYw();
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(150299);
  }
  
  public final int securityLimitCount()
  {
    return 10;
  }
  
  public final q.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(150298);
    if ((this.username == null) || (this.username.length() == 0))
    {
      params = q.b.iMr;
      AppMethodBeat.o(150298);
      return params;
    }
    params = q.b.iMq;
    AppMethodBeat.o(150298);
    return params;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aj.l
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.am;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q.b;
import com.tencent.mm.cd.b;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.bvo;
import com.tencent.mm.protocal.protobuf.bvp;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.vfs.u;
import java.io.IOException;
import java.io.OutputStream;

final class m
  extends com.tencent.mm.an.q
  implements com.tencent.mm.network.m
{
  private com.tencent.mm.an.i callback;
  private String lAO;
  private int lAT;
  private String lAV;
  private int lBk;
  private String lBl;
  private OutputStream output;
  private String username;
  
  public m(String paramString)
  {
    AppMethodBeat.i(150296);
    this.output = null;
    this.username = paramString;
    if (as.PY(paramString)) {
      this.username = as.bvW(paramString);
    }
    Log.i("MicroMsg.NetSceneGetHDHeadImg", "init Headimage in_username:" + paramString + " out_username" + this.username);
    this.lAT = 480;
    this.lBk = 480;
    this.lAV = "jpg";
    AppMethodBeat.o(150296);
  }
  
  private int au(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150302);
    try
    {
      if (this.output == null) {
        this.output = u.Te(this.lBl);
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
  
  public static void bh(String paramString1, String paramString2)
  {
    AppMethodBeat.i(150300);
    q.bhz().bg(paramString1, paramString2);
    AppMethodBeat.o(150300);
  }
  
  private void bhK()
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
  
  public final void cancel()
  {
    AppMethodBeat.i(150301);
    super.cancel();
    bhK();
    AppMethodBeat.o(150301);
  }
  
  public final int doScene(g paramg, com.tencent.mm.an.i parami)
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
    Object localObject1 = q.bhQ();
    q.bhz();
    this.lAO = f.N(this.username, true);
    if (u.agG(this.lAO))
    {
      Log.i("MicroMsg.NetSceneGetHDHeadImg", "The HDAvatar of " + this.username + " is already exists");
      AppMethodBeat.o(150297);
      return 0;
    }
    this.lBl = (this.lAO + ".tmp");
    parami = ((i)localObject1).TP(this.username);
    Object localObject2;
    if (parami == null)
    {
      u.deleteFile(this.lBl);
      parami = new h();
      parami.username = this.username;
      parami.lAV = this.lAV;
      parami.lAT = this.lAT;
      parami.lAU = this.lBk;
      parami.cUP = -1;
      localObject2 = parami.convertTo();
      ((i)localObject1).lvy.insert("hdheadimginfo", "username", (ContentValues)localObject2);
      localObject1 = new d.a();
      ((d.a)localObject1).lBU = new bvo();
      ((d.a)localObject1).lBV = new bvp();
      ((d.a)localObject1).uri = "/cgi-bin/micromsg-bin/gethdheadimg";
      ((d.a)localObject1).funcId = 158;
      ((d.a)localObject1).lBW = 47;
      ((d.a)localObject1).respCmdId = 1000000047;
      localObject1 = ((d.a)localObject1).bgN();
      localObject2 = (bvo)d.b.b(((d)localObject1).lBR);
      if (as.PY(this.username)) {
        break label636;
      }
      ((bvo)localObject2).UserName = this.username;
      ((bvo)localObject2).Tfx = 1;
    }
    for (;;)
    {
      Log.d("MicroMsg.NetSceneGetHDHeadImg", "inUser:" + this.username + " outUser:" + ((bvo)localObject2).UserName + " outType:" + ((bvo)localObject2).Tfx);
      ((bvo)localObject2).Tfu = this.lAT;
      ((bvo)localObject2).Tfv = this.lBk;
      ((bvo)localObject2).Tfw = this.lAV;
      ((bvo)localObject2).HmZ = parami.lAW;
      ((bvo)localObject2).Hna = parami.bPt;
      int i = dispatch(paramg, (s)localObject1, this);
      AppMethodBeat.o(150297);
      return i;
      localObject2 = this.lBl;
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
          u.deleteFile(this.lBl);
          parami.reset();
          parami.username = this.username;
          parami.lAV = this.lAV;
          parami.lAT = this.lAT;
          parami.lAU = this.lBk;
          ((i)localObject1).a(this.username, parami);
        }
        break;
        label569:
        i = j;
        if (parami.bhD().equals(this.lAV))
        {
          i = j;
          if (parami.lAT == this.lAT)
          {
            i = j;
            if (parami.lAU == this.lBk)
            {
              i = j;
              if (u.bBQ((String)localObject2) == parami.bPt) {
                i = 1;
              }
            }
          }
        }
      }
      label636:
      if (this.username.equals(z.bcZ() + "@bottle"))
      {
        ((bvo)localObject2).UserName = z.bcZ();
        ((bvo)localObject2).Tfx = 2;
      }
      else
      {
        ((bvo)localObject2).UserName = this.username;
        ((bvo)localObject2).Tfx = 2;
      }
    }
  }
  
  public final int getType()
  {
    return 158;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150299);
    paramArrayOfByte = (bvp)d.c.b(((d)params).lBS);
    Log.d("MicroMsg.NetSceneGetHDHeadImg", "errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 4) && (paramInt3 != 0))
    {
      Log.e("MicroMsg.NetSceneGetHDHeadImg", "errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      bhK();
      AppMethodBeat.o(150299);
      return;
    }
    if ((paramInt2 == 4) || (paramInt2 == 5))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      Log.e("MicroMsg.NetSceneGetHDHeadImg", "ErrType:".concat(String.valueOf(paramInt2)));
      bhK();
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
      bhK();
      AppMethodBeat.o(150299);
      return;
    }
    int i = -1;
    paramInt1 = i;
    if (paramArrayOfByte.Hnc != null)
    {
      paramInt1 = i;
      if (paramArrayOfByte.Hnc.Tkb != null) {
        paramInt1 = au(paramArrayOfByte.Hnc.Tkb.UH);
      }
    }
    if (paramInt1 < 0)
    {
      Log.e("MicroMsg.NetSceneGetHDHeadImg", "appendBuf fail");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      bhK();
      AppMethodBeat.o(150299);
      return;
    }
    params = q.bhQ();
    h localh = params.TP(this.username);
    if (localh == null)
    {
      Log.e("MicroMsg.NetSceneGetHDHeadImg", "info == null");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      bhK();
      AppMethodBeat.o(150299);
      return;
    }
    localh.bPt = (paramInt1 + paramArrayOfByte.Hna);
    localh.lAW = paramArrayOfByte.HmZ;
    params.a(this.username, localh);
    if (localh.bPt >= localh.lAW) {}
    for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
    {
      Log.i("MicroMsg.NetSceneGetHDHeadImg", "%d doScene again info[%s %d %d]", new Object[] { Integer.valueOf(hashCode()), this.username, Integer.valueOf(localh.bPt), Integer.valueOf(localh.lAW) });
      if (doScene(dispatcher(), this.callback) < 0) {
        this.callback.onSceneEnd(3, -1, "", this);
      }
      AppMethodBeat.o(150299);
      return;
    }
    u.oo(this.lBl, this.lAO);
    bh(this.lAO, this.username);
    bhK();
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(150299);
  }
  
  public final int securityLimitCount()
  {
    return 10;
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    AppMethodBeat.i(150298);
    if ((this.username == null) || (this.username.length() == 0))
    {
      params = q.b.lCy;
      AppMethodBeat.o(150298);
      return params;
    }
    params = q.b.lCx;
    AppMethodBeat.o(150298);
    return params;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.am.m
 * JD-Core Version:    0.7.0.1
 */
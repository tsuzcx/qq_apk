package com.tencent.mm.modelavatar;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.b;
import com.tencent.mm.bx.b;
import com.tencent.mm.model.z;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.ckq;
import com.tencent.mm.protocal.protobuf.ckr;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import java.io.OutputStream;

final class m
  extends p
  implements com.tencent.mm.network.m
{
  private com.tencent.mm.am.h callback;
  private int osT;
  private OutputStream osU;
  private String osV;
  private String osq;
  private int osv;
  private String osx;
  private String username;
  
  public m(String paramString)
  {
    AppMethodBeat.i(150296);
    this.osU = null;
    this.username = paramString;
    if (au.bwS(paramString)) {
      this.username = au.bxd(paramString);
    }
    Log.i("MicroMsg.NetSceneGetHDHeadImg", "init Headimage in_username:" + paramString + " out_username" + this.username);
    this.osv = 480;
    this.osT = 480;
    this.osx = "jpg";
    AppMethodBeat.o(150296);
  }
  
  private int au(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150302);
    try
    {
      if (this.osU == null) {
        this.osU = y.ev(this.osV, false);
      }
      this.osU.write(paramArrayOfByte);
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
  
  private void bFz()
  {
    AppMethodBeat.i(150303);
    try
    {
      if (this.osU != null)
      {
        this.osU.flush();
        this.osU.close();
        this.osU = null;
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
  
  public static void bs(String paramString1, String paramString2)
  {
    AppMethodBeat.i(150300);
    q.bFp().bq(paramString1, paramString2);
    AppMethodBeat.o(150300);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(150301);
    super.cancel();
    bFz();
    AppMethodBeat.o(150301);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    int j = 0;
    AppMethodBeat.i(150297);
    this.callback = paramh;
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
    Object localObject1 = q.bFF();
    q.bFp();
    this.osq = AvatarStorage.Q(this.username, true);
    if (y.ZC(this.osq))
    {
      Log.i("MicroMsg.NetSceneGetHDHeadImg", "The HDAvatar of " + this.username + " is already exists");
      AppMethodBeat.o(150297);
      return 0;
    }
    this.osV = (this.osq + ".tmp");
    paramh = ((h)localObject1).LP(this.username);
    Object localObject2;
    if (paramh == null)
    {
      y.deleteFile(this.osV);
      paramh = new g();
      paramh.username = this.username;
      paramh.osx = this.osx;
      paramh.osv = this.osv;
      paramh.osw = this.osT;
      paramh.eQp = -1;
      localObject2 = paramh.convertTo();
      ((h)localObject1).omV.insert("hdheadimginfo", "username", (ContentValues)localObject2);
      localObject1 = new c.a();
      ((c.a)localObject1).otE = new ckq();
      ((c.a)localObject1).otF = new ckr();
      ((c.a)localObject1).uri = "/cgi-bin/micromsg-bin/gethdheadimg";
      ((c.a)localObject1).funcId = 158;
      ((c.a)localObject1).otG = 47;
      ((c.a)localObject1).respCmdId = 1000000047;
      localObject1 = ((c.a)localObject1).bEF();
      localObject2 = (ckq)c.b.b(((c)localObject1).otB);
      if (au.bwS(this.username)) {
        break label633;
      }
      ((ckq)localObject2).UserName = this.username;
      ((ckq)localObject2).aasR = 1;
    }
    for (;;)
    {
      Log.d("MicroMsg.NetSceneGetHDHeadImg", "inUser:" + this.username + " outUser:" + ((ckq)localObject2).UserName + " outType:" + ((ckq)localObject2).aasR);
      ((ckq)localObject2).aasO = this.osv;
      ((ckq)localObject2).aasP = this.osT;
      ((ckq)localObject2).aasQ = this.osx;
      ((ckq)localObject2).NkN = paramh.osy;
      ((ckq)localObject2).NkO = paramh.dIY;
      int i = dispatch(paramg, (s)localObject1, this);
      AppMethodBeat.o(150297);
      return i;
      localObject2 = this.osV;
      i = j;
      if (paramh != null)
      {
        i = j;
        if (localObject2 != null)
        {
          if (((String)localObject2).length() != 0) {
            break label566;
          }
          i = j;
        }
      }
      for (;;)
      {
        if (i == 0)
        {
          y.deleteFile(this.osV);
          paramh.reset();
          paramh.username = this.username;
          paramh.osx = this.osx;
          paramh.osv = this.osv;
          paramh.osw = this.osT;
          ((h)localObject1).a(this.username, paramh);
        }
        break;
        label566:
        i = j;
        if (paramh.bFt().equals(this.osx))
        {
          i = j;
          if (paramh.osv == this.osv)
          {
            i = j;
            if (paramh.osw == this.osT)
            {
              i = j;
              if (y.bEl((String)localObject2) == paramh.dIY) {
                i = 1;
              }
            }
          }
        }
      }
      label633:
      if (this.username.equals(z.bAM() + "@bottle"))
      {
        ((ckq)localObject2).UserName = z.bAM();
        ((ckq)localObject2).aasR = 2;
      }
      else
      {
        ((ckq)localObject2).UserName = this.username;
        ((ckq)localObject2).aasR = 2;
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
    paramArrayOfByte = (ckr)c.c.b(((c)params).otC);
    Log.d("MicroMsg.NetSceneGetHDHeadImg", "errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 4) && (paramInt3 != 0))
    {
      Log.e("MicroMsg.NetSceneGetHDHeadImg", "errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      bFz();
      AppMethodBeat.o(150299);
      return;
    }
    if ((paramInt2 == 4) || (paramInt2 == 5))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      Log.e("MicroMsg.NetSceneGetHDHeadImg", "ErrType:".concat(String.valueOf(paramInt2)));
      bFz();
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
      bFz();
      AppMethodBeat.o(150299);
      return;
    }
    int i = -1;
    paramInt1 = i;
    if (paramArrayOfByte.NkQ != null)
    {
      paramInt1 = i;
      if (paramArrayOfByte.NkQ.aaxD != null) {
        paramInt1 = au(paramArrayOfByte.NkQ.aaxD.Op);
      }
    }
    if (paramInt1 < 0)
    {
      Log.e("MicroMsg.NetSceneGetHDHeadImg", "appendBuf fail");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      bFz();
      AppMethodBeat.o(150299);
      return;
    }
    params = q.bFF();
    g localg = params.LP(this.username);
    if (localg == null)
    {
      Log.e("MicroMsg.NetSceneGetHDHeadImg", "info == null");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      bFz();
      AppMethodBeat.o(150299);
      return;
    }
    localg.dIY = (paramInt1 + paramArrayOfByte.NkO);
    localg.osy = paramArrayOfByte.NkN;
    params.a(this.username, localg);
    if (localg.dIY >= localg.osy) {}
    for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
    {
      Log.i("MicroMsg.NetSceneGetHDHeadImg", "%d doScene again info[%s %d %d]", new Object[] { Integer.valueOf(hashCode()), this.username, Integer.valueOf(localg.dIY), Integer.valueOf(localg.osy) });
      if (doScene(dispatcher(), this.callback) < 0) {
        this.callback.onSceneEnd(3, -1, "", this);
      }
      AppMethodBeat.o(150299);
      return;
    }
    y.qn(this.osV, this.osq);
    bs(this.osq, this.username);
    bFz();
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(150299);
  }
  
  public final int securityLimitCount()
  {
    return 10;
  }
  
  public final p.b securityVerificationChecked(s params)
  {
    AppMethodBeat.i(150298);
    if ((this.username == null) || (this.username.length() == 0))
    {
      params = p.b.oui;
      AppMethodBeat.o(150298);
      return params;
    }
    params = p.b.ouh;
    AppMethodBeat.o(150298);
    return params;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelavatar.m
 * JD-Core Version:    0.7.0.1
 */
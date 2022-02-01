package com.tencent.mm.modelpackage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p.a;
import com.tencent.mm.am.p.b;
import com.tencent.mm.am.r;
import com.tencent.mm.autogen.a.sx;
import com.tencent.mm.kernel.f;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.protocal.protobuf.akv;
import com.tencent.mm.protocal.protobuf.akw;
import com.tencent.mm.protocal.protobuf.dzx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.vfs.y;
import java.io.IOException;

public final class o
  extends com.tencent.mm.am.p
  implements r, m
{
  private com.tencent.mm.am.h callback;
  private int hDq;
  public int oQV;
  private int offset;
  private com.tencent.mm.am.c rr;
  
  public o(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150807);
    this.oQV = paramInt1;
    this.hDq = paramInt2;
    this.offset = 0;
    Object localObject = u.bLH().eI(paramInt1, paramInt2);
    if (localObject == null)
    {
      Log.e("MicroMsg.NetSceneDownloadPackage", "doScene get info null, id:".concat(String.valueOf(paramInt1)));
      AppMethodBeat.o(150807);
      return;
    }
    ((s)localObject).status = 3;
    ((s)localObject).eQp = 64;
    u.bLH().b((s)localObject);
    if (paramInt2 == 5)
    {
      localObject = com.tencent.mm.kernel.h.baE().cachePath;
      y.deleteFile((String)localObject + "brand_i18n.apk");
      AppMethodBeat.o(150807);
      return;
    }
    localObject = u.bLH();
    y.deleteFile(t.bLE() + ((t)localObject).eK(paramInt1, paramInt2));
    AppMethodBeat.o(150807);
  }
  
  private static boolean bL(String paramString1, String paramString2)
  {
    boolean bool = true;
    AppMethodBeat.i(150812);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(150812);
      return false;
    }
    try
    {
      paramString1 = paramString1 + paramString2;
      paramString2 = y.bEn(paramString1);
      if (!Util.isNullOrNil(paramString2)) {
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acNQ, paramString2);
      }
    }
    catch (IOException paramString1)
    {
      for (;;)
      {
        try
        {
          y.deleteFile(paramString1);
          Log.i("MicroMsg.NetSceneDownloadPackage", "update sense where result[%b] filepath[%s] xml[%s] ", new Object[] { Boolean.valueOf(bool), paramString1, Util.secPrint(paramString2) });
          AppMethodBeat.o(150812);
          return bool;
        }
        catch (IOException paramString1)
        {
          continue;
        }
        paramString1 = paramString1;
        bool = false;
        Log.printErrStackTrace("MicroMsg.NetSceneDownloadPackage", paramString1, "", new Object[0]);
        continue;
        bool = false;
      }
    }
  }
  
  public final int bFO()
  {
    return this.hDq;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(150808);
    this.callback = paramh;
    Log.d("MicroMsg.NetSceneDownloadPackage", "dkregcode doScene pkgId:%d packageType:%d", new Object[] { Integer.valueOf(this.oQV), Integer.valueOf(this.hDq) });
    paramh = u.bLH().eI(this.oQV, this.hDq);
    if (paramh == null)
    {
      Log.e("MicroMsg.NetSceneDownloadPackage", "doScene get Theme failed id:" + this.oQV + " type:" + this.hDq);
      AppMethodBeat.o(150808);
      return -1;
    }
    if (paramh.status != 3)
    {
      Log.e("MicroMsg.NetSceneDownloadPackage", "doScene get Theme stat failed id:" + this.oQV + " stat:" + paramh.status);
      AppMethodBeat.o(150808);
      return -1;
    }
    if (paramh.size <= 0)
    {
      Log.e("MicroMsg.NetSceneDownloadPackage", "doScene Theme size err id:" + this.oQV + " size:" + paramh.size);
      AppMethodBeat.o(150808);
      return -1;
    }
    Object localObject = new c.a();
    ((c.a)localObject).otE = new akv();
    ((c.a)localObject).otF = new akw();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/downloadpackage";
    ((c.a)localObject).funcId = 160;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (akv)c.b.b(this.rr.otB);
    dzx localdzx = new dzx();
    localdzx.IMf = paramh.id;
    localdzx.crz = paramh.version;
    ((akv)localObject).Zsb = localdzx;
    ((akv)localObject).YYs = this.offset;
    ((akv)localObject).Zsc = 65536;
    ((akv)localObject).vhJ = this.hDq;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(150808);
    return i;
  }
  
  public final int getType()
  {
    return 160;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150811);
    Log.d("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd id:" + this.oQV + " + id:" + paramInt1 + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      Log.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd, errType = " + paramInt2 + ", errCode = " + paramInt3);
      u.bLH().eM(this.oQV, this.hDq);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(150811);
      return;
    }
    params = (akw)c.c.b(((com.tencent.mm.am.c)params).otC);
    if (params.vhJ != this.hDq)
    {
      Log.e("MicroMsg.NetSceneDownloadPackage", "packageType is not consistent");
      u.bLH().eM(this.oQV, this.hDq);
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(150811);
      return;
    }
    byte[] arrayOfByte = w.a(params.Zsd);
    if ((arrayOfByte == null) || (arrayOfByte.length == 0))
    {
      Log.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd get pkgBuf failed id:" + this.oQV);
      u.bLH().eM(this.oQV, this.hDq);
      this.callback.onSceneEnd(3, -1, paramString, this);
      AppMethodBeat.o(150811);
      return;
    }
    s locals = u.bLH().eI(this.oQV, this.hDq);
    if (locals == null)
    {
      Log.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd info is null, pkgId = " + this.oQV);
      u.bLH().eM(this.oQV, this.hDq);
      this.callback.onSceneEnd(3, -1, paramString, this);
      AppMethodBeat.o(150811);
      return;
    }
    if (locals.size != params.Zse)
    {
      Log.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd totalSize is incorrect");
      u.bLH().eM(this.oQV, this.hDq);
      params = new p(this.hDq);
      com.tencent.mm.kernel.h.baD().mCm.a(params, 0);
      this.callback.onSceneEnd(3, -1, paramString, this);
      AppMethodBeat.o(150811);
      return;
    }
    if (this.hDq == 5) {
      paramArrayOfByte = com.tencent.mm.kernel.h.baE().cachePath;
    }
    for (params = "brand_i18n.apk";; params = u.bLH().eK(this.oQV, this.hDq))
    {
      Log.d("MicroMsg.NetSceneDownloadPackage", "packagePath ".concat(String.valueOf(paramArrayOfByte)));
      Log.d("MicroMsg.NetSceneDownloadPackage", "packageName ".concat(String.valueOf(params)));
      y.bDX(paramArrayOfByte);
      paramInt1 = y.e(paramArrayOfByte + '/' + params, arrayOfByte, arrayOfByte.length);
      if (paramInt1 == 0) {
        break;
      }
      u.bLH().eM(this.oQV, this.hDq);
      Log.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd write file fail, ret = ".concat(String.valueOf(paramInt1)));
      this.callback.onSceneEnd(3, -1, paramString, this);
      AppMethodBeat.o(150811);
      return;
      u.bLH();
      paramArrayOfByte = t.bLE();
    }
    paramInt1 = this.offset;
    this.offset = (arrayOfByte.length + paramInt1);
    if (this.offset >= locals.size)
    {
      boolean bool = false;
      if (this.hDq == 1)
      {
        paramString = u.bLH().eL(this.oQV, this.hDq);
        paramInt1 = Util.UnZipFolder(paramArrayOfByte + params, paramString);
        if (paramInt1 < 0)
        {
          Log.e("MicroMsg.NetSceneDownloadPackage", "unzip fail, ret = " + paramInt1 + ", zipFilePath = " + paramArrayOfByte + params + ", unzipPath = " + paramString);
          u.bLH().eM(this.oQV, this.hDq);
          this.callback.onSceneEnd(3, 0, "unzip fail", this);
          bool = false;
        }
      }
      else
      {
        if (this.hDq == 23)
        {
          if ((!Util.isNullOrNil(paramArrayOfByte)) && (!Util.isNullOrNil(params))) {
            break label1263;
          }
          Log.e("MicroMsg.NetSceneDownloadPackage", "update permission pkg failed, packagePath: %s, packageName: %s", new Object[] { paramArrayOfByte, params });
          u.bLH().eM(this.oQV, this.hDq);
          this.callback.onSceneEnd(3, 0, "open permission pkg failed", this);
          bool = false;
        }
        label868:
        if (this.hDq == 7) {
          bool = true;
        }
        if (this.hDq == 9) {
          bool = true;
        }
        if (this.hDq == 5)
        {
          bool = true;
          Log.i("MicroMsg.NetSceneDownloadPackage", "resetResContextImp");
        }
        if (this.hDq == 12)
        {
          paramString = new sx();
          paramString.hWo.hWq = (paramArrayOfByte + params);
          paramString.publish();
          bool = true;
        }
        if (this.hDq == 18)
        {
          paramString = u.bLH().eL(this.oQV, this.hDq);
          paramInt1 = Util.UnZipFolder(paramArrayOfByte + params, paramString);
          if (paramInt1 >= 0) {
            break label1459;
          }
          Log.e("MicroMsg.NetSceneDownloadPackage", "unzip fail, ret = " + paramInt1 + ", zipFilePath = " + paramArrayOfByte + params + ", unzipPath = " + paramString);
          u.bLH().eM(this.oQV, this.hDq);
          this.callback.onSceneEnd(3, 0, "unzip fail", this);
          bool = false;
        }
        label1102:
        if (this.hDq == 20) {
          bool = true;
        }
        if (this.hDq == 21) {
          bool = true;
        }
        if (this.hDq == 26)
        {
          if ((!Util.isNullOrNil(paramArrayOfByte)) && (!Util.isNullOrNil(params))) {
            break label1482;
          }
          Log.e("MicroMsg.NetSceneDownloadPackage", "updateIPCallContryCodeConfigPkg failed, packagePath: %s, packageName: %s", new Object[] { paramArrayOfByte, params });
          this.callback.onSceneEnd(3, 0, "open IPCallContryCodeConfigs pkg failed", this);
          bool = false;
        }
      }
      for (;;)
      {
        if (this.hDq == 36) {
          bool = bL(paramArrayOfByte, params);
        }
        if (bool)
        {
          locals.status = 2;
          locals.eQp = 64;
          u.bLH().b(locals);
          this.callback.onSceneEnd(0, 0, "", this);
        }
        AppMethodBeat.o(150811);
        return;
        bool = true;
        break;
        label1263:
        if (!new com.tencent.mm.vfs.u(paramArrayOfByte + params).jKS())
        {
          Log.e("MicroMsg.NetSceneDownloadPackage", "update permission pkg failed, file no exist, path: %s, name: %s", new Object[] { paramArrayOfByte, params });
          u.bLH().eM(this.oQV, this.hDq);
          this.callback.onSceneEnd(3, 0, "file not exist", this);
          bool = false;
          break label868;
        }
        paramString = b.bmr() + "permissioncfg.cfg";
        if (-1L == y.O(paramArrayOfByte + params, paramString, false))
        {
          Log.e("MicroMsg.NetSceneDownloadPackage", "copy file failed");
          u.bLH().eM(this.oQV, this.hDq);
          this.callback.onSceneEnd(3, 0, "copy file failed", this);
          bool = false;
          break label868;
        }
        bool = true;
        break label868;
        label1459:
        Log.i("MicroMsg.NetSceneDownloadPackage", "Unzip Path %s", new Object[] { paramString });
        bool = true;
        break label1102;
        label1482:
        if (!new com.tencent.mm.vfs.u(paramArrayOfByte + params).jKS())
        {
          Log.e("MicroMsg.NetSceneDownloadPackage", "updateIPCallContryCodeConfigPkg failed, file not exist, packagePath: %s, packageName: %s", new Object[] { paramArrayOfByte, params });
          u.bLH().eM(this.oQV, this.hDq);
          this.callback.onSceneEnd(3, 0, "file not exist", this);
          bool = false;
        }
        else
        {
          paramString = b.bmr() + "ipcallCountryCodeConfig.cfg";
          if (-1L == y.O(paramArrayOfByte + params, paramString, false))
          {
            Log.e("MicroMsg.NetSceneDownloadPackage", "copy file failed");
            u.bLH().eM(this.oQV, this.hDq);
            this.callback.onSceneEnd(3, 0, "copy file failed", this);
            bool = false;
          }
          else
          {
            Log.d("MicroMsg.NetSceneDownloadPackage", "updateIPCallContryCodeConfigPkg success");
            bool = true;
          }
        }
      }
    }
    if (doScene(dispatcher(), this.callback) < 0)
    {
      u.bLH().eM(this.oQV, this.hDq);
      this.callback.onSceneEnd(3, -1, paramString, this);
    }
    AppMethodBeat.o(150811);
  }
  
  public final int securityLimitCount()
  {
    return 50;
  }
  
  public final p.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(150809);
    params = (akv)c.b.b(((com.tencent.mm.am.c)params).otB);
    s locals = u.bLH().eI(this.oQV, this.hDq);
    if (locals == null)
    {
      Log.e("MicroMsg.NetSceneDownloadPackage", "securityVerificationChecked get Theme failed id:" + this.oQV);
      params = p.b.oui;
      AppMethodBeat.o(150809);
      return params;
    }
    if ((params.Zsb.IMf != this.oQV) || (params.YYs != this.offset) || (params.YYs >= locals.size) || (params.Zsc != 65536) || (locals.size <= 0) || (locals.status != 3))
    {
      Log.e("MicroMsg.NetSceneDownloadPackage", "securityVerificationChecked Theme failed id:" + this.oQV);
      params = p.b.oui;
      AppMethodBeat.o(150809);
      return params;
    }
    params = p.b.ouh;
    AppMethodBeat.o(150809);
    return params;
  }
  
  public final void setSecurityCheckError(p.a parama)
  {
    AppMethodBeat.i(150810);
    u.bLH().eM(this.oQV, this.hDq);
    AppMethodBeat.o(150810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelpackage.o
 * JD-Core Version:    0.7.0.1
 */
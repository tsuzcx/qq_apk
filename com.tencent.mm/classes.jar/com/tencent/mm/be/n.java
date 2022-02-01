package com.tencent.mm.be;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q.a;
import com.tencent.mm.an.q.b;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.ri;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.aic;
import com.tencent.mm.protocal.protobuf.aid;
import com.tencent.mm.protocal.protobuf.dhn;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vfs.u;
import java.io.IOException;

public final class n
  extends com.tencent.mm.an.q
  implements com.tencent.mm.an.s, m
{
  private i callback;
  private int fyH;
  public int lXR;
  private int offset;
  private d rr;
  
  public n(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150807);
    this.lXR = paramInt1;
    this.fyH = paramInt2;
    this.offset = 0;
    Object localObject = w.bnU().dQ(paramInt1, paramInt2);
    if (localObject == null)
    {
      Log.e("MicroMsg.NetSceneDownloadPackage", "doScene get info null, id:".concat(String.valueOf(paramInt1)));
      AppMethodBeat.o(150807);
      return;
    }
    ((r)localObject).status = 3;
    ((r)localObject).cUP = 64;
    w.bnU().b((r)localObject);
    if (paramInt2 == 5)
    {
      localObject = h.aHG().cachePath;
      u.deleteFile((String)localObject + "brand_i18n.apk");
      AppMethodBeat.o(150807);
      return;
    }
    localObject = w.bnU();
    u.deleteFile(s.bnR() + ((s)localObject).dS(paramInt1, paramInt2));
    AppMethodBeat.o(150807);
  }
  
  private static boolean bA(String paramString1, String paramString2)
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
      paramString2 = u.bBS(paramString1);
      if (!Util.isNullOrNil(paramString2)) {
        h.aHG().aHp().set(ar.a.Vmv, paramString2);
      }
    }
    catch (IOException paramString1)
    {
      for (;;)
      {
        try
        {
          u.deleteFile(paramString1);
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
  
  public final int big()
  {
    return this.fyH;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(150808);
    this.callback = parami;
    Log.d("MicroMsg.NetSceneDownloadPackage", "dkregcode doScene pkgId:%d packageType:%d", new Object[] { Integer.valueOf(this.lXR), Integer.valueOf(this.fyH) });
    parami = w.bnU().dQ(this.lXR, this.fyH);
    if (parami == null)
    {
      Log.e("MicroMsg.NetSceneDownloadPackage", "doScene get Theme failed id:" + this.lXR + " type:" + this.fyH);
      AppMethodBeat.o(150808);
      return -1;
    }
    if (parami.status != 3)
    {
      Log.e("MicroMsg.NetSceneDownloadPackage", "doScene get Theme stat failed id:" + this.lXR + " stat:" + parami.status);
      AppMethodBeat.o(150808);
      return -1;
    }
    if (parami.size <= 0)
    {
      Log.e("MicroMsg.NetSceneDownloadPackage", "doScene Theme size err id:" + this.lXR + " size:" + parami.size);
      AppMethodBeat.o(150808);
      return -1;
    }
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new aic();
    ((d.a)localObject).lBV = new aid();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/downloadpackage";
    ((d.a)localObject).funcId = 160;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (aic)d.b.b(this.rr.lBR);
    dhn localdhn = new dhn();
    localdhn.CRP = parami.id;
    localdhn.rWt = parami.version;
    ((aic)localObject).SsS = localdhn;
    ((aic)localObject).Sat = this.offset;
    ((aic)localObject).SsT = 65536;
    ((aic)localObject).rWu = this.fyH;
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
    Log.d("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd id:" + this.lXR + " + id:" + paramInt1 + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      Log.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd, errType = " + paramInt2 + ", errCode = " + paramInt3);
      w.bnU().dU(this.lXR, this.fyH);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(150811);
      return;
    }
    params = (aid)d.c.b(((d)params).lBS);
    if (params.rWu != this.fyH)
    {
      Log.e("MicroMsg.NetSceneDownloadPackage", "packageType is not consistent");
      w.bnU().dU(this.lXR, this.fyH);
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(150811);
      return;
    }
    byte[] arrayOfByte = z.a(params.SsU);
    if ((arrayOfByte == null) || (arrayOfByte.length == 0))
    {
      Log.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd get pkgBuf failed id:" + this.lXR);
      w.bnU().dU(this.lXR, this.fyH);
      this.callback.onSceneEnd(3, -1, paramString, this);
      AppMethodBeat.o(150811);
      return;
    }
    r localr = w.bnU().dQ(this.lXR, this.fyH);
    if (localr == null)
    {
      Log.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd info is null, pkgId = " + this.lXR);
      w.bnU().dU(this.lXR, this.fyH);
      this.callback.onSceneEnd(3, -1, paramString, this);
      AppMethodBeat.o(150811);
      return;
    }
    if (localr.size != params.SsV)
    {
      Log.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd totalSize is incorrect");
      w.bnU().dU(this.lXR, this.fyH);
      params = new o(this.fyH);
      h.aHF().kcd.a(params, 0);
      this.callback.onSceneEnd(3, -1, paramString, this);
      AppMethodBeat.o(150811);
      return;
    }
    if (this.fyH == 5) {
      paramArrayOfByte = h.aHG().cachePath;
    }
    for (params = "brand_i18n.apk";; params = w.bnU().dS(this.lXR, this.fyH))
    {
      Log.d("MicroMsg.NetSceneDownloadPackage", "packagePath ".concat(String.valueOf(paramArrayOfByte)));
      Log.d("MicroMsg.NetSceneDownloadPackage", "packageName ".concat(String.valueOf(params)));
      u.bBD(paramArrayOfByte);
      paramInt1 = u.F(paramArrayOfByte + '/' + params, arrayOfByte);
      if (paramInt1 == 0) {
        break;
      }
      w.bnU().dU(this.lXR, this.fyH);
      Log.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd write file fail, ret = ".concat(String.valueOf(paramInt1)));
      this.callback.onSceneEnd(3, -1, paramString, this);
      AppMethodBeat.o(150811);
      return;
      w.bnU();
      paramArrayOfByte = s.bnR();
    }
    paramInt1 = this.offset;
    this.offset = (arrayOfByte.length + paramInt1);
    if (this.offset >= localr.size)
    {
      boolean bool = false;
      if (this.fyH == 1)
      {
        paramString = w.bnU().dT(this.lXR, this.fyH);
        paramInt1 = Util.UnZipFolder(paramArrayOfByte + params, paramString);
        if (paramInt1 < 0)
        {
          Log.e("MicroMsg.NetSceneDownloadPackage", "unzip fail, ret = " + paramInt1 + ", zipFilePath = " + paramArrayOfByte + params + ", unzipPath = " + paramString);
          w.bnU().dU(this.lXR, this.fyH);
          this.callback.onSceneEnd(3, 0, "unzip fail", this);
          bool = false;
        }
      }
      else
      {
        if (this.fyH == 23)
        {
          if ((!Util.isNullOrNil(paramArrayOfByte)) && (!Util.isNullOrNil(params))) {
            break label1263;
          }
          Log.e("MicroMsg.NetSceneDownloadPackage", "update permission pkg failed, packagePath: %s, packageName: %s", new Object[] { paramArrayOfByte, params });
          w.bnU().dU(this.lXR, this.fyH);
          this.callback.onSceneEnd(3, 0, "open permission pkg failed", this);
          bool = false;
        }
        label865:
        if (this.fyH == 7) {
          bool = true;
        }
        if (this.fyH == 9) {
          bool = true;
        }
        if (this.fyH == 5)
        {
          bool = true;
          Log.i("MicroMsg.NetSceneDownloadPackage", "resetResContextImp");
        }
        if (this.fyH == 12)
        {
          paramString = new ri();
          paramString.fQt.fQv = (paramArrayOfByte + params);
          EventCenter.instance.publish(paramString);
          bool = true;
        }
        if (this.fyH == 18)
        {
          paramString = w.bnU().dT(this.lXR, this.fyH);
          paramInt1 = Util.UnZipFolder(paramArrayOfByte + params, paramString);
          if (paramInt1 >= 0) {
            break label1458;
          }
          Log.e("MicroMsg.NetSceneDownloadPackage", "unzip fail, ret = " + paramInt1 + ", zipFilePath = " + paramArrayOfByte + params + ", unzipPath = " + paramString);
          w.bnU().dU(this.lXR, this.fyH);
          this.callback.onSceneEnd(3, 0, "unzip fail", this);
          bool = false;
        }
        label1102:
        if (this.fyH == 20) {
          bool = true;
        }
        if (this.fyH == 21) {
          bool = true;
        }
        if (this.fyH == 26)
        {
          if ((!Util.isNullOrNil(paramArrayOfByte)) && (!Util.isNullOrNil(params))) {
            break label1481;
          }
          Log.e("MicroMsg.NetSceneDownloadPackage", "updateIPCallContryCodeConfigPkg failed, packagePath: %s, packageName: %s", new Object[] { paramArrayOfByte, params });
          this.callback.onSceneEnd(3, 0, "open IPCallContryCodeConfigs pkg failed", this);
          bool = false;
        }
      }
      for (;;)
      {
        if (this.fyH == 36) {
          bool = bA(paramArrayOfByte, params);
        }
        if (bool)
        {
          localr.status = 2;
          localr.cUP = 64;
          w.bnU().b(localr);
          this.callback.onSceneEnd(0, 0, "", this);
        }
        AppMethodBeat.o(150811);
        return;
        bool = true;
        break;
        label1263:
        if (!new com.tencent.mm.vfs.q(paramArrayOfByte + params).ifE())
        {
          Log.e("MicroMsg.NetSceneDownloadPackage", "update permission pkg failed, file no exist, path: %s, name: %s", new Object[] { paramArrayOfByte, params });
          w.bnU().dU(this.lXR, this.fyH);
          this.callback.onSceneEnd(3, 0, "file not exist", this);
          bool = false;
          break label865;
        }
        paramString = b.aSD() + "permissioncfg.cfg";
        if (-1L == u.on(paramArrayOfByte + params, paramString))
        {
          Log.e("MicroMsg.NetSceneDownloadPackage", "copy file failed");
          w.bnU().dU(this.lXR, this.fyH);
          this.callback.onSceneEnd(3, 0, "copy file failed", this);
          bool = false;
          break label865;
        }
        bool = true;
        break label865;
        label1458:
        Log.i("MicroMsg.NetSceneDownloadPackage", "Unzip Path %s", new Object[] { paramString });
        bool = true;
        break label1102;
        label1481:
        if (!new com.tencent.mm.vfs.q(paramArrayOfByte + params).ifE())
        {
          Log.e("MicroMsg.NetSceneDownloadPackage", "updateIPCallContryCodeConfigPkg failed, file not exist, packagePath: %s, packageName: %s", new Object[] { paramArrayOfByte, params });
          w.bnU().dU(this.lXR, this.fyH);
          this.callback.onSceneEnd(3, 0, "file not exist", this);
          bool = false;
        }
        else
        {
          paramString = b.aSD() + "ipcallCountryCodeConfig.cfg";
          if (-1L == u.on(paramArrayOfByte + params, paramString))
          {
            Log.e("MicroMsg.NetSceneDownloadPackage", "copy file failed");
            w.bnU().dU(this.lXR, this.fyH);
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
      w.bnU().dU(this.lXR, this.fyH);
      this.callback.onSceneEnd(3, -1, paramString, this);
    }
    AppMethodBeat.o(150811);
  }
  
  public final int securityLimitCount()
  {
    return 50;
  }
  
  public final q.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(150809);
    params = (aic)d.b.b(((d)params).lBR);
    r localr = w.bnU().dQ(this.lXR, this.fyH);
    if (localr == null)
    {
      Log.e("MicroMsg.NetSceneDownloadPackage", "securityVerificationChecked get Theme failed id:" + this.lXR);
      params = q.b.lCy;
      AppMethodBeat.o(150809);
      return params;
    }
    if ((params.SsS.CRP != this.lXR) || (params.Sat != this.offset) || (params.Sat >= localr.size) || (params.SsT != 65536) || (localr.size <= 0) || (localr.status != 3))
    {
      Log.e("MicroMsg.NetSceneDownloadPackage", "securityVerificationChecked Theme failed id:" + this.lXR);
      params = q.b.lCy;
      AppMethodBeat.o(150809);
      return params;
    }
    params = q.b.lCx;
    AppMethodBeat.o(150809);
    return params;
  }
  
  public final void setSecurityCheckError(q.a parama)
  {
    AppMethodBeat.i(150810);
    w.bnU().dU(this.lXR, this.fyH);
    AppMethodBeat.o(150810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.be.n
 * JD-Core Version:    0.7.0.1
 */
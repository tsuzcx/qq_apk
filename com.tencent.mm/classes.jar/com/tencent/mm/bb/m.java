package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q.a;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.qi;
import com.tencent.mm.kernel.e;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.ahr;
import com.tencent.mm.protocal.protobuf.ahs;
import com.tencent.mm.protocal.protobuf.cyb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vfs.o;
import java.io.IOException;

public final class m
  extends com.tencent.mm.ak.q
  implements com.tencent.mm.ak.s, com.tencent.mm.network.m
{
  private i callback;
  public int jho;
  private int offset;
  private int packageType;
  private d rr;
  
  public m(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150807);
    this.jho = paramInt1;
    this.packageType = paramInt2;
    this.offset = 0;
    Object localObject = v.bev().dt(paramInt1, paramInt2);
    if (localObject == null)
    {
      Log.e("MicroMsg.NetSceneDownloadPackage", "doScene get info null, id:".concat(String.valueOf(paramInt1)));
      AppMethodBeat.o(150807);
      return;
    }
    ((q)localObject).status = 3;
    ((q)localObject).cSx = 64;
    v.bev().b((q)localObject);
    if (paramInt2 == 5)
    {
      localObject = com.tencent.mm.kernel.g.aAh().cachePath;
      com.tencent.mm.vfs.s.deleteFile((String)localObject + "brand_i18n.apk");
      AppMethodBeat.o(150807);
      return;
    }
    localObject = v.bev();
    com.tencent.mm.vfs.s.deleteFile(r.bes() + ((r)localObject).dv(paramInt1, paramInt2));
    AppMethodBeat.o(150807);
  }
  
  private static boolean bx(String paramString1, String paramString2)
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
      paramString2 = com.tencent.mm.vfs.s.boY(paramString1);
      if (!Util.isNullOrNil(paramString2)) {
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NYv, paramString2);
      }
    }
    catch (IOException paramString1)
    {
      for (;;)
      {
        try
        {
          com.tencent.mm.vfs.s.deleteFile(paramString1);
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
  
  public final int aYR()
  {
    return this.packageType;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(150808);
    this.callback = parami;
    Log.d("MicroMsg.NetSceneDownloadPackage", "dkregcode doScene pkgId:%d packageType:%d", new Object[] { Integer.valueOf(this.jho), Integer.valueOf(this.packageType) });
    parami = v.bev().dt(this.jho, this.packageType);
    if (parami == null)
    {
      Log.e("MicroMsg.NetSceneDownloadPackage", "doScene get Theme failed id:" + this.jho + " type:" + this.packageType);
      AppMethodBeat.o(150808);
      return -1;
    }
    if (parami.status != 3)
    {
      Log.e("MicroMsg.NetSceneDownloadPackage", "doScene get Theme stat failed id:" + this.jho + " stat:" + parami.status);
      AppMethodBeat.o(150808);
      return -1;
    }
    if (parami.size <= 0)
    {
      Log.e("MicroMsg.NetSceneDownloadPackage", "doScene Theme size err id:" + this.jho + " size:" + parami.size);
      AppMethodBeat.o(150808);
      return -1;
    }
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new ahr();
    ((d.a)localObject).iLO = new ahs();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/downloadpackage";
    ((d.a)localObject).funcId = 160;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (ahr)this.rr.iLK.iLR;
    cyb localcyb = new cyb();
    localcyb.xNF = parami.id;
    localcyb.Version = parami.version;
    ((ahr)localObject).Lrv = localcyb;
    ((ahr)localObject).KZk = this.offset;
    ((ahr)localObject).Lrw = 65536;
    ((ahr)localObject).oUv = this.packageType;
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
    Log.d("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd id:" + this.jho + " + id:" + paramInt1 + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      Log.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd, errType = " + paramInt2 + ", errCode = " + paramInt3);
      v.bev().dx(this.jho, this.packageType);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(150811);
      return;
    }
    params = (ahs)((d)params).iLL.iLR;
    if (params.oUv != this.packageType)
    {
      Log.e("MicroMsg.NetSceneDownloadPackage", "packageType is not consistent");
      v.bev().dx(this.jho, this.packageType);
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(150811);
      return;
    }
    byte[] arrayOfByte = z.a(params.Lrx);
    if ((arrayOfByte == null) || (arrayOfByte.length == 0))
    {
      Log.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd get pkgBuf failed id:" + this.jho);
      v.bev().dx(this.jho, this.packageType);
      this.callback.onSceneEnd(3, -1, paramString, this);
      AppMethodBeat.o(150811);
      return;
    }
    q localq = v.bev().dt(this.jho, this.packageType);
    if (localq == null)
    {
      Log.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd info is null, pkgId = " + this.jho);
      v.bev().dx(this.jho, this.packageType);
      this.callback.onSceneEnd(3, -1, paramString, this);
      AppMethodBeat.o(150811);
      return;
    }
    if (localq.size != params.Lry)
    {
      Log.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd totalSize is incorrect");
      v.bev().dx(this.jho, this.packageType);
      params = new n(this.packageType);
      com.tencent.mm.kernel.g.aAg().hqi.a(params, 0);
      this.callback.onSceneEnd(3, -1, paramString, this);
      AppMethodBeat.o(150811);
      return;
    }
    if (this.packageType == 5) {
      paramArrayOfByte = com.tencent.mm.kernel.g.aAh().cachePath;
    }
    for (params = "brand_i18n.apk";; params = v.bev().dv(this.jho, this.packageType))
    {
      Log.d("MicroMsg.NetSceneDownloadPackage", "packagePath ".concat(String.valueOf(paramArrayOfByte)));
      Log.d("MicroMsg.NetSceneDownloadPackage", "packageName ".concat(String.valueOf(params)));
      com.tencent.mm.vfs.s.boN(paramArrayOfByte);
      paramInt1 = com.tencent.mm.vfs.s.e(paramArrayOfByte + '/' + params, arrayOfByte, arrayOfByte.length);
      if (paramInt1 == 0) {
        break;
      }
      v.bev().dx(this.jho, this.packageType);
      Log.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd write file fail, ret = ".concat(String.valueOf(paramInt1)));
      this.callback.onSceneEnd(3, -1, paramString, this);
      AppMethodBeat.o(150811);
      return;
      v.bev();
      paramArrayOfByte = r.bes();
    }
    paramInt1 = this.offset;
    this.offset = (arrayOfByte.length + paramInt1);
    if (this.offset >= localq.size)
    {
      boolean bool = false;
      if (this.packageType == 1)
      {
        paramString = v.bev().dw(this.jho, this.packageType);
        paramInt1 = Util.UnZipFolder(paramArrayOfByte + params, paramString);
        if (paramInt1 < 0)
        {
          Log.e("MicroMsg.NetSceneDownloadPackage", "unzip fail, ret = " + paramInt1 + ", zipFilePath = " + paramArrayOfByte + params + ", unzipPath = " + paramString);
          v.bev().dx(this.jho, this.packageType);
          this.callback.onSceneEnd(3, 0, "unzip fail", this);
          bool = false;
        }
      }
      else
      {
        if (this.packageType == 23)
        {
          if ((!Util.isNullOrNil(paramArrayOfByte)) && (!Util.isNullOrNil(params))) {
            break label1266;
          }
          Log.e("MicroMsg.NetSceneDownloadPackage", "update permission pkg failed, packagePath: %s, packageName: %s", new Object[] { paramArrayOfByte, params });
          v.bev().dx(this.jho, this.packageType);
          this.callback.onSceneEnd(3, 0, "open permission pkg failed", this);
          bool = false;
        }
        label868:
        if (this.packageType == 7) {
          bool = true;
        }
        if (this.packageType == 9) {
          bool = true;
        }
        if (this.packageType == 5)
        {
          bool = true;
          Log.i("MicroMsg.NetSceneDownloadPackage", "resetResContextImp");
        }
        if (this.packageType == 12)
        {
          paramString = new qi();
          paramString.dWH.dWJ = (paramArrayOfByte + params);
          EventCenter.instance.publish(paramString);
          bool = true;
        }
        if (this.packageType == 18)
        {
          paramString = v.bev().dw(this.jho, this.packageType);
          paramInt1 = Util.UnZipFolder(paramArrayOfByte + params, paramString);
          if (paramInt1 >= 0) {
            break label1461;
          }
          Log.e("MicroMsg.NetSceneDownloadPackage", "unzip fail, ret = " + paramInt1 + ", zipFilePath = " + paramArrayOfByte + params + ", unzipPath = " + paramString);
          v.bev().dx(this.jho, this.packageType);
          this.callback.onSceneEnd(3, 0, "unzip fail", this);
          bool = false;
        }
        label1105:
        if (this.packageType == 20) {
          bool = true;
        }
        if (this.packageType == 21) {
          bool = true;
        }
        if (this.packageType == 26)
        {
          if ((!Util.isNullOrNil(paramArrayOfByte)) && (!Util.isNullOrNil(params))) {
            break label1484;
          }
          Log.e("MicroMsg.NetSceneDownloadPackage", "updateIPCallContryCodeConfigPkg failed, packagePath: %s, packageName: %s", new Object[] { paramArrayOfByte, params });
          this.callback.onSceneEnd(3, 0, "open IPCallContryCodeConfigs pkg failed", this);
          bool = false;
        }
      }
      for (;;)
      {
        if (this.packageType == 36) {
          bool = bx(paramArrayOfByte, params);
        }
        if (bool)
        {
          localq.status = 2;
          localq.cSx = 64;
          v.bev().b(localq);
          this.callback.onSceneEnd(0, 0, "", this);
        }
        AppMethodBeat.o(150811);
        return;
        bool = true;
        break;
        label1266:
        if (!new o(paramArrayOfByte + params).exists())
        {
          Log.e("MicroMsg.NetSceneDownloadPackage", "update permission pkg failed, file no exist, path: %s, name: %s", new Object[] { paramArrayOfByte, params });
          v.bev().dx(this.jho, this.packageType);
          this.callback.onSceneEnd(3, 0, "file not exist", this);
          bool = false;
          break label868;
        }
        paramString = com.tencent.mm.loader.j.b.aKB() + "permissioncfg.cfg";
        if (-1L == com.tencent.mm.vfs.s.nw(paramArrayOfByte + params, paramString))
        {
          Log.e("MicroMsg.NetSceneDownloadPackage", "copy file failed");
          v.bev().dx(this.jho, this.packageType);
          this.callback.onSceneEnd(3, 0, "copy file failed", this);
          bool = false;
          break label868;
        }
        bool = true;
        break label868;
        label1461:
        Log.i("MicroMsg.NetSceneDownloadPackage", "Unzip Path %s", new Object[] { paramString });
        bool = true;
        break label1105;
        label1484:
        if (!new o(paramArrayOfByte + params).exists())
        {
          Log.e("MicroMsg.NetSceneDownloadPackage", "updateIPCallContryCodeConfigPkg failed, file not exist, packagePath: %s, packageName: %s", new Object[] { paramArrayOfByte, params });
          v.bev().dx(this.jho, this.packageType);
          this.callback.onSceneEnd(3, 0, "file not exist", this);
          bool = false;
        }
        else
        {
          paramString = com.tencent.mm.loader.j.b.aKB() + "ipcallCountryCodeConfig.cfg";
          if (-1L == com.tencent.mm.vfs.s.nw(paramArrayOfByte + params, paramString))
          {
            Log.e("MicroMsg.NetSceneDownloadPackage", "copy file failed");
            v.bev().dx(this.jho, this.packageType);
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
      v.bev().dx(this.jho, this.packageType);
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
    params = (ahr)((d)params).iLK.iLR;
    q localq = v.bev().dt(this.jho, this.packageType);
    if (localq == null)
    {
      Log.e("MicroMsg.NetSceneDownloadPackage", "securityVerificationChecked get Theme failed id:" + this.jho);
      params = q.b.iMr;
      AppMethodBeat.o(150809);
      return params;
    }
    if ((params.Lrv.xNF != this.jho) || (params.KZk != this.offset) || (params.KZk >= localq.size) || (params.Lrw != 65536) || (localq.size <= 0) || (localq.status != 3))
    {
      Log.e("MicroMsg.NetSceneDownloadPackage", "securityVerificationChecked Theme failed id:" + this.jho);
      params = q.b.iMr;
      AppMethodBeat.o(150809);
      return params;
    }
    params = q.b.iMq;
    AppMethodBeat.o(150809);
    return params;
  }
  
  public final void setSecurityCheckError(q.a parama)
  {
    AppMethodBeat.i(150810);
    v.bev().dx(this.jho, this.packageType);
    AppMethodBeat.o(150810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bb.m
 * JD-Core Version:    0.7.0.1
 */
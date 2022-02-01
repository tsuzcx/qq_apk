package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.a;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.g.a.pf;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.ada;
import com.tencent.mm.protocal.protobuf.adb;
import com.tencent.mm.protocal.protobuf.ccj;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.vfs.i;
import java.io.IOException;

public final class k
  extends n
  implements com.tencent.mm.ak.p, com.tencent.mm.network.k
{
  private com.tencent.mm.ak.g callback;
  private int dcj;
  public int hPY;
  private int offset;
  private com.tencent.mm.ak.b rr;
  
  public k(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150807);
    this.hPY = paramInt1;
    this.dcj = paramInt2;
    this.offset = 0;
    Object localObject = t.aGO().dg(paramInt1, paramInt2);
    if (localObject == null)
    {
      ac.e("MicroMsg.NetSceneDownloadPackage", "doScene get info null, id:".concat(String.valueOf(paramInt1)));
      AppMethodBeat.o(150807);
      return;
    }
    ((o)localObject).status = 3;
    ((o)localObject).drx = 64;
    t.aGO().b((o)localObject);
    if (paramInt2 == 5)
    {
      localObject = com.tencent.mm.kernel.g.agR().cachePath;
      i.deleteFile((String)localObject + "brand_i18n.apk");
      AppMethodBeat.o(150807);
      return;
    }
    localObject = t.aGO();
    i.deleteFile(p.aGL() + ((p)localObject).di(paramInt1, paramInt2));
    AppMethodBeat.o(150807);
  }
  
  private static boolean bs(String paramString1, String paramString2)
  {
    boolean bool = true;
    AppMethodBeat.i(150812);
    if ((bs.isNullOrNil(paramString1)) || (bs.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(150812);
      return false;
    }
    try
    {
      paramString1 = paramString1 + paramString2;
      paramString2 = i.aSr(paramString1);
      if (!bs.isNullOrNil(paramString2)) {
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GJE, paramString2);
      }
    }
    catch (IOException paramString1)
    {
      for (;;)
      {
        try
        {
          i.deleteFile(paramString1);
          ac.i("MicroMsg.NetSceneDownloadPackage", "update sense where result[%b] filepath[%s] xml[%s] ", new Object[] { Boolean.valueOf(bool), paramString1, bs.aLJ(paramString2) });
          AppMethodBeat.o(150812);
          return bool;
        }
        catch (IOException paramString1)
        {
          continue;
        }
        paramString1 = paramString1;
        bool = false;
        ac.printErrStackTrace("MicroMsg.NetSceneDownloadPackage", paramString1, "", new Object[0]);
        continue;
        bool = false;
      }
    }
  }
  
  public final int aBJ()
  {
    return this.dcj;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(150808);
    this.callback = paramg;
    ac.d("MicroMsg.NetSceneDownloadPackage", "dkregcode doScene pkgId:%d packageType:%d", new Object[] { Integer.valueOf(this.hPY), Integer.valueOf(this.dcj) });
    paramg = t.aGO().dg(this.hPY, this.dcj);
    if (paramg == null)
    {
      ac.e("MicroMsg.NetSceneDownloadPackage", "doScene get Theme failed id:" + this.hPY + " type:" + this.dcj);
      AppMethodBeat.o(150808);
      return -1;
    }
    if (paramg.status != 3)
    {
      ac.e("MicroMsg.NetSceneDownloadPackage", "doScene get Theme stat failed id:" + this.hPY + " stat:" + paramg.status);
      AppMethodBeat.o(150808);
      return -1;
    }
    if (paramg.size <= 0)
    {
      ac.e("MicroMsg.NetSceneDownloadPackage", "doScene Theme size err id:" + this.hPY + " size:" + paramg.size);
      AppMethodBeat.o(150808);
      return -1;
    }
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new ada();
    ((b.a)localObject).hvu = new adb();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/downloadpackage";
    ((b.a)localObject).funcId = 160;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (ada)this.rr.hvr.hvw;
    ccj localccj = new ccj();
    localccj.tlI = paramg.id;
    localccj.Version = paramg.version;
    ((ada)localObject).EvM = localccj;
    ((ada)localObject).EfV = this.offset;
    ((ada)localObject).EvN = 65536;
    ((ada)localObject).ndI = this.dcj;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(150808);
    return i;
  }
  
  public final int getType()
  {
    return 160;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150811);
    ac.d("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd id:" + this.hPY + " + id:" + paramInt1 + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      ac.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd, errType = " + paramInt2 + ", errCode = " + paramInt3);
      t.aGO().dk(this.hPY, this.dcj);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(150811);
      return;
    }
    paramq = (adb)((com.tencent.mm.ak.b)paramq).hvs.hvw;
    if (paramq.ndI != this.dcj)
    {
      ac.e("MicroMsg.NetSceneDownloadPackage", "packageType is not consistent");
      t.aGO().dk(this.hPY, this.dcj);
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(150811);
      return;
    }
    byte[] arrayOfByte = z.a(paramq.EvO);
    if ((arrayOfByte == null) || (arrayOfByte.length == 0))
    {
      ac.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd get pkgBuf failed id:" + this.hPY);
      t.aGO().dk(this.hPY, this.dcj);
      this.callback.onSceneEnd(3, -1, paramString, this);
      AppMethodBeat.o(150811);
      return;
    }
    o localo = t.aGO().dg(this.hPY, this.dcj);
    if (localo == null)
    {
      ac.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd info is null, pkgId = " + this.hPY);
      t.aGO().dk(this.hPY, this.dcj);
      this.callback.onSceneEnd(3, -1, paramString, this);
      AppMethodBeat.o(150811);
      return;
    }
    if (localo.size != paramq.EvP)
    {
      ac.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd totalSize is incorrect");
      t.aGO().dk(this.hPY, this.dcj);
      paramq = new l(this.dcj);
      com.tencent.mm.kernel.g.agQ().ghe.a(paramq, 0);
      this.callback.onSceneEnd(3, -1, paramString, this);
      AppMethodBeat.o(150811);
      return;
    }
    if (this.dcj == 5) {
      paramArrayOfByte = com.tencent.mm.kernel.g.agR().cachePath;
    }
    for (paramq = "brand_i18n.apk";; paramq = t.aGO().di(this.hPY, this.dcj))
    {
      ac.d("MicroMsg.NetSceneDownloadPackage", "packagePath ".concat(String.valueOf(paramArrayOfByte)));
      ac.d("MicroMsg.NetSceneDownloadPackage", "packageName ".concat(String.valueOf(paramq)));
      i.aSh(paramArrayOfByte);
      paramInt1 = i.e(paramArrayOfByte + '/' + paramq, arrayOfByte, arrayOfByte.length);
      if (paramInt1 == 0) {
        break;
      }
      t.aGO().dk(this.hPY, this.dcj);
      ac.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd write file fail, ret = ".concat(String.valueOf(paramInt1)));
      this.callback.onSceneEnd(3, -1, paramString, this);
      AppMethodBeat.o(150811);
      return;
      t.aGO();
      paramArrayOfByte = p.aGL();
    }
    paramInt1 = this.offset;
    this.offset = (arrayOfByte.length + paramInt1);
    if (this.offset >= localo.size)
    {
      boolean bool = false;
      if (this.dcj == 1)
      {
        paramString = t.aGO().dj(this.hPY, this.dcj);
        paramInt1 = bs.lq(paramArrayOfByte + paramq, paramString);
        if (paramInt1 < 0)
        {
          ac.e("MicroMsg.NetSceneDownloadPackage", "unzip fail, ret = " + paramInt1 + ", zipFilePath = " + paramArrayOfByte + paramq + ", unzipPath = " + paramString);
          t.aGO().dk(this.hPY, this.dcj);
          this.callback.onSceneEnd(3, 0, "unzip fail", this);
          bool = false;
        }
      }
      else
      {
        if (this.dcj == 23)
        {
          if ((!bs.isNullOrNil(paramArrayOfByte)) && (!bs.isNullOrNil(paramq))) {
            break label1266;
          }
          ac.e("MicroMsg.NetSceneDownloadPackage", "update permission pkg failed, packagePath: %s, packageName: %s", new Object[] { paramArrayOfByte, paramq });
          t.aGO().dk(this.hPY, this.dcj);
          this.callback.onSceneEnd(3, 0, "open permission pkg failed", this);
          bool = false;
        }
        label868:
        if (this.dcj == 7) {
          bool = true;
        }
        if (this.dcj == 9) {
          bool = true;
        }
        if (this.dcj == 5)
        {
          bool = true;
          ac.i("MicroMsg.NetSceneDownloadPackage", "resetResContextImp");
        }
        if (this.dcj == 12)
        {
          paramString = new pf();
          paramString.drW.drY = (paramArrayOfByte + paramq);
          a.GpY.l(paramString);
          bool = true;
        }
        if (this.dcj == 18)
        {
          paramString = t.aGO().dj(this.hPY, this.dcj);
          paramInt1 = bs.lq(paramArrayOfByte + paramq, paramString);
          if (paramInt1 >= 0) {
            break label1461;
          }
          ac.e("MicroMsg.NetSceneDownloadPackage", "unzip fail, ret = " + paramInt1 + ", zipFilePath = " + paramArrayOfByte + paramq + ", unzipPath = " + paramString);
          t.aGO().dk(this.hPY, this.dcj);
          this.callback.onSceneEnd(3, 0, "unzip fail", this);
          bool = false;
        }
        label1105:
        if (this.dcj == 20) {
          bool = true;
        }
        if (this.dcj == 21) {
          bool = true;
        }
        if (this.dcj == 26)
        {
          if ((!bs.isNullOrNil(paramArrayOfByte)) && (!bs.isNullOrNil(paramq))) {
            break label1484;
          }
          ac.e("MicroMsg.NetSceneDownloadPackage", "updateIPCallContryCodeConfigPkg failed, packagePath: %s, packageName: %s", new Object[] { paramArrayOfByte, paramq });
          this.callback.onSceneEnd(3, 0, "open IPCallContryCodeConfigs pkg failed", this);
          bool = false;
        }
      }
      for (;;)
      {
        if (this.dcj == 36) {
          bool = bs(paramArrayOfByte, paramq);
        }
        if (bool)
        {
          localo.status = 2;
          localo.drx = 64;
          t.aGO().b(localo);
          this.callback.onSceneEnd(0, 0, "", this);
        }
        AppMethodBeat.o(150811);
        return;
        bool = true;
        break;
        label1266:
        if (!new com.tencent.mm.vfs.e(paramArrayOfByte + paramq).exists())
        {
          ac.e("MicroMsg.NetSceneDownloadPackage", "update permission pkg failed, file no exist, path: %s, name: %s", new Object[] { paramArrayOfByte, paramq });
          t.aGO().dk(this.hPY, this.dcj);
          this.callback.onSceneEnd(3, 0, "file not exist", this);
          bool = false;
          break label868;
        }
        paramString = com.tencent.mm.loader.j.b.aoZ() + "permissioncfg.cfg";
        if (-1L == i.lZ(paramArrayOfByte + paramq, paramString))
        {
          ac.e("MicroMsg.NetSceneDownloadPackage", "copy file failed");
          t.aGO().dk(this.hPY, this.dcj);
          this.callback.onSceneEnd(3, 0, "copy file failed", this);
          bool = false;
          break label868;
        }
        bool = true;
        break label868;
        label1461:
        ac.i("MicroMsg.NetSceneDownloadPackage", "Unzip Path %s", new Object[] { paramString });
        bool = true;
        break label1105;
        label1484:
        if (!new com.tencent.mm.vfs.e(paramArrayOfByte + paramq).exists())
        {
          ac.e("MicroMsg.NetSceneDownloadPackage", "updateIPCallContryCodeConfigPkg failed, file not exist, packagePath: %s, packageName: %s", new Object[] { paramArrayOfByte, paramq });
          t.aGO().dk(this.hPY, this.dcj);
          this.callback.onSceneEnd(3, 0, "file not exist", this);
          bool = false;
        }
        else
        {
          paramString = com.tencent.mm.loader.j.b.aoZ() + "ipcallCountryCodeConfig.cfg";
          if (-1L == i.lZ(paramArrayOfByte + paramq, paramString))
          {
            ac.e("MicroMsg.NetSceneDownloadPackage", "copy file failed");
            t.aGO().dk(this.hPY, this.dcj);
            this.callback.onSceneEnd(3, 0, "copy file failed", this);
            bool = false;
          }
          else
          {
            ac.d("MicroMsg.NetSceneDownloadPackage", "updateIPCallContryCodeConfigPkg success");
            bool = true;
          }
        }
      }
    }
    if (doScene(dispatcher(), this.callback) < 0)
    {
      t.aGO().dk(this.hPY, this.dcj);
      this.callback.onSceneEnd(3, -1, paramString, this);
    }
    AppMethodBeat.o(150811);
  }
  
  public final int securityLimitCount()
  {
    return 50;
  }
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    AppMethodBeat.i(150809);
    paramq = (ada)((com.tencent.mm.ak.b)paramq).hvr.hvw;
    o localo = t.aGO().dg(this.hPY, this.dcj);
    if (localo == null)
    {
      ac.e("MicroMsg.NetSceneDownloadPackage", "securityVerificationChecked get Theme failed id:" + this.hPY);
      paramq = n.b.hwb;
      AppMethodBeat.o(150809);
      return paramq;
    }
    if ((paramq.EvM.tlI != this.hPY) || (paramq.EfV != this.offset) || (paramq.EfV >= localo.size) || (paramq.EvN != 65536) || (localo.size <= 0) || (localo.status != 3))
    {
      ac.e("MicroMsg.NetSceneDownloadPackage", "securityVerificationChecked Theme failed id:" + this.hPY);
      paramq = n.b.hwb;
      AppMethodBeat.o(150809);
      return paramq;
    }
    paramq = n.b.hwa;
    AppMethodBeat.o(150809);
    return paramq;
  }
  
  public final void setSecurityCheckError(n.a parama)
  {
    AppMethodBeat.i(150810);
    t.aGO().dk(this.hPY, this.dcj);
    AppMethodBeat.o(150810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bb.k
 * JD-Core Version:    0.7.0.1
 */
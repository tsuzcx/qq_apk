package com.tencent.mm.bc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.a;
import com.tencent.mm.al.n.b;
import com.tencent.mm.g.a.ow;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.acb;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.protocal.protobuf.bxo;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.vfs.i;
import java.io.IOException;

public final class k
  extends n
  implements com.tencent.mm.al.p, com.tencent.mm.network.k
{
  private com.tencent.mm.al.g callback;
  private int deP;
  public int hpw;
  private int offset;
  private com.tencent.mm.al.b rr;
  
  public k(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150807);
    this.hpw = paramInt1;
    this.deP = paramInt2;
    this.offset = 0;
    Object localObject = t.azY().dg(paramInt1, paramInt2);
    if (localObject == null)
    {
      ad.e("MicroMsg.NetSceneDownloadPackage", "doScene get info null, id:".concat(String.valueOf(paramInt1)));
      AppMethodBeat.o(150807);
      return;
    }
    ((o)localObject).status = 3;
    ((o)localObject).dtM = 64;
    t.azY().b((o)localObject);
    if (paramInt2 == 5)
    {
      localObject = com.tencent.mm.kernel.g.afB().cachePath;
      i.deleteFile((String)localObject + "brand_i18n.apk");
      AppMethodBeat.o(150807);
      return;
    }
    localObject = t.azY();
    i.deleteFile(p.azV() + ((p)localObject).di(paramInt1, paramInt2));
    AppMethodBeat.o(150807);
  }
  
  private static boolean bk(String paramString1, String paramString2)
  {
    boolean bool = true;
    AppMethodBeat.i(150812);
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(150812);
      return false;
    }
    try
    {
      paramString1 = paramString1 + paramString2;
      paramString2 = i.aMP(paramString1);
      if (!bt.isNullOrNil(paramString2)) {
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.FlP, paramString2);
      }
    }
    catch (IOException paramString1)
    {
      for (;;)
      {
        try
        {
          i.deleteFile(paramString1);
          ad.i("MicroMsg.NetSceneDownloadPackage", "update sense where result[%b] filepath[%s] xml[%s] ", new Object[] { Boolean.valueOf(bool), paramString1, bt.aGs(paramString2) });
          AppMethodBeat.o(150812);
          return bool;
        }
        catch (IOException paramString1)
        {
          continue;
        }
        paramString1 = paramString1;
        bool = false;
        ad.printErrStackTrace("MicroMsg.NetSceneDownloadPackage", paramString1, "", new Object[0]);
        continue;
        bool = false;
      }
    }
  }
  
  public final int auQ()
  {
    return this.deP;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(150808);
    this.callback = paramg;
    ad.d("MicroMsg.NetSceneDownloadPackage", "dkregcode doScene pkgId:%d packageType:%d", new Object[] { Integer.valueOf(this.hpw), Integer.valueOf(this.deP) });
    paramg = t.azY().dg(this.hpw, this.deP);
    if (paramg == null)
    {
      ad.e("MicroMsg.NetSceneDownloadPackage", "doScene get Theme failed id:" + this.hpw + " type:" + this.deP);
      AppMethodBeat.o(150808);
      return -1;
    }
    if (paramg.status != 3)
    {
      ad.e("MicroMsg.NetSceneDownloadPackage", "doScene get Theme stat failed id:" + this.hpw + " stat:" + paramg.status);
      AppMethodBeat.o(150808);
      return -1;
    }
    if (paramg.size <= 0)
    {
      ad.e("MicroMsg.NetSceneDownloadPackage", "doScene Theme size err id:" + this.hpw + " size:" + paramg.size);
      AppMethodBeat.o(150808);
      return -1;
    }
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new acb();
    ((b.a)localObject).gUV = new acc();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/downloadpackage";
    ((b.a)localObject).funcId = 160;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (acb)this.rr.gUS.gUX;
    bxo localbxo = new bxo();
    localbxo.sdO = paramg.id;
    localbxo.Version = paramg.version;
    ((acb)localObject).DcF = localbxo;
    ((acb)localObject).CNt = this.offset;
    ((acb)localObject).DcG = 65536;
    ((acb)localObject).mBH = this.deP;
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
    ad.d("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd id:" + this.hpw + " + id:" + paramInt1 + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      ad.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd, errType = " + paramInt2 + ", errCode = " + paramInt3);
      t.azY().dk(this.hpw, this.deP);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(150811);
      return;
    }
    paramq = (acc)((com.tencent.mm.al.b)paramq).gUT.gUX;
    if (paramq.mBH != this.deP)
    {
      ad.e("MicroMsg.NetSceneDownloadPackage", "packageType is not consistent");
      t.azY().dk(this.hpw, this.deP);
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(150811);
      return;
    }
    byte[] arrayOfByte = z.a(paramq.DcH);
    if ((arrayOfByte == null) || (arrayOfByte.length == 0))
    {
      ad.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd get pkgBuf failed id:" + this.hpw);
      t.azY().dk(this.hpw, this.deP);
      this.callback.onSceneEnd(3, -1, paramString, this);
      AppMethodBeat.o(150811);
      return;
    }
    o localo = t.azY().dg(this.hpw, this.deP);
    if (localo == null)
    {
      ad.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd info is null, pkgId = " + this.hpw);
      t.azY().dk(this.hpw, this.deP);
      this.callback.onSceneEnd(3, -1, paramString, this);
      AppMethodBeat.o(150811);
      return;
    }
    if (localo.size != paramq.DcI)
    {
      ad.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd totalSize is incorrect");
      t.azY().dk(this.hpw, this.deP);
      paramq = new l(this.deP);
      com.tencent.mm.kernel.g.afA().gcy.a(paramq, 0);
      this.callback.onSceneEnd(3, -1, paramString, this);
      AppMethodBeat.o(150811);
      return;
    }
    if (this.deP == 5) {
      paramArrayOfByte = com.tencent.mm.kernel.g.afB().cachePath;
    }
    for (paramq = "brand_i18n.apk";; paramq = t.azY().di(this.hpw, this.deP))
    {
      ad.d("MicroMsg.NetSceneDownloadPackage", "packagePath ".concat(String.valueOf(paramArrayOfByte)));
      ad.d("MicroMsg.NetSceneDownloadPackage", "packageName ".concat(String.valueOf(paramq)));
      i.aMF(paramArrayOfByte);
      paramInt1 = i.e(paramArrayOfByte + '/' + paramq, arrayOfByte, arrayOfByte.length);
      if (paramInt1 == 0) {
        break;
      }
      t.azY().dk(this.hpw, this.deP);
      ad.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd write file fail, ret = ".concat(String.valueOf(paramInt1)));
      this.callback.onSceneEnd(3, -1, paramString, this);
      AppMethodBeat.o(150811);
      return;
      t.azY();
      paramArrayOfByte = p.azV();
    }
    paramInt1 = this.offset;
    this.offset = (arrayOfByte.length + paramInt1);
    if (this.offset >= localo.size)
    {
      boolean bool = false;
      if (this.deP == 1)
      {
        paramString = t.azY().dj(this.hpw, this.deP);
        paramInt1 = bt.kT(paramArrayOfByte + paramq, paramString);
        if (paramInt1 < 0)
        {
          ad.e("MicroMsg.NetSceneDownloadPackage", "unzip fail, ret = " + paramInt1 + ", zipFilePath = " + paramArrayOfByte + paramq + ", unzipPath = " + paramString);
          t.azY().dk(this.hpw, this.deP);
          this.callback.onSceneEnd(3, 0, "unzip fail", this);
          bool = false;
        }
      }
      else
      {
        if (this.deP == 23)
        {
          if ((!bt.isNullOrNil(paramArrayOfByte)) && (!bt.isNullOrNil(paramq))) {
            break label1266;
          }
          ad.e("MicroMsg.NetSceneDownloadPackage", "update permission pkg failed, packagePath: %s, packageName: %s", new Object[] { paramArrayOfByte, paramq });
          t.azY().dk(this.hpw, this.deP);
          this.callback.onSceneEnd(3, 0, "open permission pkg failed", this);
          bool = false;
        }
        label868:
        if (this.deP == 7) {
          bool = true;
        }
        if (this.deP == 9) {
          bool = true;
        }
        if (this.deP == 5)
        {
          bool = true;
          ad.i("MicroMsg.NetSceneDownloadPackage", "resetResContextImp");
        }
        if (this.deP == 12)
        {
          paramString = new ow();
          paramString.dul.dun = (paramArrayOfByte + paramq);
          a.ESL.l(paramString);
          bool = true;
        }
        if (this.deP == 18)
        {
          paramString = t.azY().dj(this.hpw, this.deP);
          paramInt1 = bt.kT(paramArrayOfByte + paramq, paramString);
          if (paramInt1 >= 0) {
            break label1461;
          }
          ad.e("MicroMsg.NetSceneDownloadPackage", "unzip fail, ret = " + paramInt1 + ", zipFilePath = " + paramArrayOfByte + paramq + ", unzipPath = " + paramString);
          t.azY().dk(this.hpw, this.deP);
          this.callback.onSceneEnd(3, 0, "unzip fail", this);
          bool = false;
        }
        label1105:
        if (this.deP == 20) {
          bool = true;
        }
        if (this.deP == 21) {
          bool = true;
        }
        if (this.deP == 26)
        {
          if ((!bt.isNullOrNil(paramArrayOfByte)) && (!bt.isNullOrNil(paramq))) {
            break label1484;
          }
          ad.e("MicroMsg.NetSceneDownloadPackage", "updateIPCallContryCodeConfigPkg failed, packagePath: %s, packageName: %s", new Object[] { paramArrayOfByte, paramq });
          this.callback.onSceneEnd(3, 0, "open IPCallContryCodeConfigs pkg failed", this);
          bool = false;
        }
      }
      for (;;)
      {
        if (this.deP == 36) {
          bool = bk(paramArrayOfByte, paramq);
        }
        if (bool)
        {
          localo.status = 2;
          localo.dtM = 64;
          t.azY().b(localo);
          this.callback.onSceneEnd(0, 0, "", this);
        }
        AppMethodBeat.o(150811);
        return;
        bool = true;
        break;
        label1266:
        if (!new com.tencent.mm.vfs.e(paramArrayOfByte + paramq).exists())
        {
          ad.e("MicroMsg.NetSceneDownloadPackage", "update permission pkg failed, file no exist, path: %s, name: %s", new Object[] { paramArrayOfByte, paramq });
          t.azY().dk(this.hpw, this.deP);
          this.callback.onSceneEnd(3, 0, "file not exist", this);
          bool = false;
          break label868;
        }
        paramString = com.tencent.mm.loader.j.b.ahZ() + "permissioncfg.cfg";
        if (-1L == i.lC(paramArrayOfByte + paramq, paramString))
        {
          ad.e("MicroMsg.NetSceneDownloadPackage", "copy file failed");
          t.azY().dk(this.hpw, this.deP);
          this.callback.onSceneEnd(3, 0, "copy file failed", this);
          bool = false;
          break label868;
        }
        bool = true;
        break label868;
        label1461:
        ad.i("MicroMsg.NetSceneDownloadPackage", "Unzip Path %s", new Object[] { paramString });
        bool = true;
        break label1105;
        label1484:
        if (!new com.tencent.mm.vfs.e(paramArrayOfByte + paramq).exists())
        {
          ad.e("MicroMsg.NetSceneDownloadPackage", "updateIPCallContryCodeConfigPkg failed, file not exist, packagePath: %s, packageName: %s", new Object[] { paramArrayOfByte, paramq });
          t.azY().dk(this.hpw, this.deP);
          this.callback.onSceneEnd(3, 0, "file not exist", this);
          bool = false;
        }
        else
        {
          paramString = com.tencent.mm.loader.j.b.ahZ() + "ipcallCountryCodeConfig.cfg";
          if (-1L == i.lC(paramArrayOfByte + paramq, paramString))
          {
            ad.e("MicroMsg.NetSceneDownloadPackage", "copy file failed");
            t.azY().dk(this.hpw, this.deP);
            this.callback.onSceneEnd(3, 0, "copy file failed", this);
            bool = false;
          }
          else
          {
            ad.d("MicroMsg.NetSceneDownloadPackage", "updateIPCallContryCodeConfigPkg success");
            bool = true;
          }
        }
      }
    }
    if (doScene(dispatcher(), this.callback) < 0)
    {
      t.azY().dk(this.hpw, this.deP);
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
    paramq = (acb)((com.tencent.mm.al.b)paramq).gUS.gUX;
    o localo = t.azY().dg(this.hpw, this.deP);
    if (localo == null)
    {
      ad.e("MicroMsg.NetSceneDownloadPackage", "securityVerificationChecked get Theme failed id:" + this.hpw);
      paramq = n.b.gVC;
      AppMethodBeat.o(150809);
      return paramq;
    }
    if ((paramq.DcF.sdO != this.hpw) || (paramq.CNt != this.offset) || (paramq.CNt >= localo.size) || (paramq.DcG != 65536) || (localo.size <= 0) || (localo.status != 3))
    {
      ad.e("MicroMsg.NetSceneDownloadPackage", "securityVerificationChecked Theme failed id:" + this.hpw);
      paramq = n.b.gVC;
      AppMethodBeat.o(150809);
      return paramq;
    }
    paramq = n.b.gVB;
    AppMethodBeat.o(150809);
    return paramq;
  }
  
  public final void setSecurityCheckError(n.a parama)
  {
    AppMethodBeat.i(150810);
    t.azY().dk(this.hpw, this.deP);
    AppMethodBeat.o(150810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bc.k
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.bc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.a;
import com.tencent.mm.al.n.b;
import com.tencent.mm.g.a.pp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.afb;
import com.tencent.mm.protocal.protobuf.afc;
import com.tencent.mm.protocal.protobuf.cha;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.vfs.i;
import java.io.IOException;

public final class k
  extends n
  implements com.tencent.mm.al.p, com.tencent.mm.network.k
{
  private f callback;
  private int dnF;
  public int ijm;
  private int offset;
  private com.tencent.mm.al.b rr;
  
  public k(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150807);
    this.ijm = paramInt1;
    this.dnF = paramInt2;
    this.offset = 0;
    Object localObject = t.aJZ().dj(paramInt1, paramInt2);
    if (localObject == null)
    {
      ad.e("MicroMsg.NetSceneDownloadPackage", "doScene get info null, id:".concat(String.valueOf(paramInt1)));
      AppMethodBeat.o(150807);
      return;
    }
    ((o)localObject).status = 3;
    ((o)localObject).dDp = 64;
    t.aJZ().b((o)localObject);
    if (paramInt2 == 5)
    {
      localObject = g.ajC().cachePath;
      i.deleteFile((String)localObject + "brand_i18n.apk");
      AppMethodBeat.o(150807);
      return;
    }
    localObject = t.aJZ();
    i.deleteFile(p.aJW() + ((p)localObject).dl(paramInt1, paramInt2));
    AppMethodBeat.o(150807);
  }
  
  private static boolean bt(String paramString1, String paramString2)
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
      paramString2 = i.aYq(paramString1);
      if (!bt.isNullOrNil(paramString2)) {
        g.ajC().ajl().set(al.a.IvW, paramString2);
      }
    }
    catch (IOException paramString1)
    {
      for (;;)
      {
        try
        {
          i.deleteFile(paramString1);
          ad.i("MicroMsg.NetSceneDownloadPackage", "update sense where result[%b] filepath[%s] xml[%s] ", new Object[] { Boolean.valueOf(bool), paramString1, bt.aRp(paramString2) });
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
  
  public final int aEM()
  {
    return this.dnF;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(150808);
    this.callback = paramf;
    ad.d("MicroMsg.NetSceneDownloadPackage", "dkregcode doScene pkgId:%d packageType:%d", new Object[] { Integer.valueOf(this.ijm), Integer.valueOf(this.dnF) });
    paramf = t.aJZ().dj(this.ijm, this.dnF);
    if (paramf == null)
    {
      ad.e("MicroMsg.NetSceneDownloadPackage", "doScene get Theme failed id:" + this.ijm + " type:" + this.dnF);
      AppMethodBeat.o(150808);
      return -1;
    }
    if (paramf.status != 3)
    {
      ad.e("MicroMsg.NetSceneDownloadPackage", "doScene get Theme stat failed id:" + this.ijm + " stat:" + paramf.status);
      AppMethodBeat.o(150808);
      return -1;
    }
    if (paramf.size <= 0)
    {
      ad.e("MicroMsg.NetSceneDownloadPackage", "doScene Theme size err id:" + this.ijm + " size:" + paramf.size);
      AppMethodBeat.o(150808);
      return -1;
    }
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new afb();
    ((b.a)localObject).hNN = new afc();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/downloadpackage";
    ((b.a)localObject).funcId = 160;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (afb)this.rr.hNK.hNQ;
    cha localcha = new cha();
    localcha.ukh = paramf.id;
    localcha.Version = paramf.version;
    ((afb)localObject).Gdi = localcha;
    ((afb)localObject).FMu = this.offset;
    ((afb)localObject).Gdj = 65536;
    ((afb)localObject).nEf = this.dnF;
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
    ad.d("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd id:" + this.ijm + " + id:" + paramInt1 + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      ad.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd, errType = " + paramInt2 + ", errCode = " + paramInt3);
      t.aJZ().dn(this.ijm, this.dnF);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(150811);
      return;
    }
    paramq = (afc)((com.tencent.mm.al.b)paramq).hNL.hNQ;
    if (paramq.nEf != this.dnF)
    {
      ad.e("MicroMsg.NetSceneDownloadPackage", "packageType is not consistent");
      t.aJZ().dn(this.ijm, this.dnF);
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(150811);
      return;
    }
    byte[] arrayOfByte = z.a(paramq.Gdk);
    if ((arrayOfByte == null) || (arrayOfByte.length == 0))
    {
      ad.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd get pkgBuf failed id:" + this.ijm);
      t.aJZ().dn(this.ijm, this.dnF);
      this.callback.onSceneEnd(3, -1, paramString, this);
      AppMethodBeat.o(150811);
      return;
    }
    o localo = t.aJZ().dj(this.ijm, this.dnF);
    if (localo == null)
    {
      ad.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd info is null, pkgId = " + this.ijm);
      t.aJZ().dn(this.ijm, this.dnF);
      this.callback.onSceneEnd(3, -1, paramString, this);
      AppMethodBeat.o(150811);
      return;
    }
    if (localo.size != paramq.Gdl)
    {
      ad.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd totalSize is incorrect");
      t.aJZ().dn(this.ijm, this.dnF);
      paramq = new l(this.dnF);
      g.ajB().gAO.a(paramq, 0);
      this.callback.onSceneEnd(3, -1, paramString, this);
      AppMethodBeat.o(150811);
      return;
    }
    if (this.dnF == 5) {
      paramArrayOfByte = g.ajC().cachePath;
    }
    for (paramq = "brand_i18n.apk";; paramq = t.aJZ().dl(this.ijm, this.dnF))
    {
      ad.d("MicroMsg.NetSceneDownloadPackage", "packagePath ".concat(String.valueOf(paramArrayOfByte)));
      ad.d("MicroMsg.NetSceneDownloadPackage", "packageName ".concat(String.valueOf(paramq)));
      i.aYg(paramArrayOfByte);
      paramInt1 = i.e(paramArrayOfByte + '/' + paramq, arrayOfByte, arrayOfByte.length);
      if (paramInt1 == 0) {
        break;
      }
      t.aJZ().dn(this.ijm, this.dnF);
      ad.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd write file fail, ret = ".concat(String.valueOf(paramInt1)));
      this.callback.onSceneEnd(3, -1, paramString, this);
      AppMethodBeat.o(150811);
      return;
      t.aJZ();
      paramArrayOfByte = p.aJW();
    }
    paramInt1 = this.offset;
    this.offset = (arrayOfByte.length + paramInt1);
    if (this.offset >= localo.size)
    {
      boolean bool = false;
      if (this.dnF == 1)
      {
        paramString = t.aJZ().dm(this.ijm, this.dnF);
        paramInt1 = bt.lP(paramArrayOfByte + paramq, paramString);
        if (paramInt1 < 0)
        {
          ad.e("MicroMsg.NetSceneDownloadPackage", "unzip fail, ret = " + paramInt1 + ", zipFilePath = " + paramArrayOfByte + paramq + ", unzipPath = " + paramString);
          t.aJZ().dn(this.ijm, this.dnF);
          this.callback.onSceneEnd(3, 0, "unzip fail", this);
          bool = false;
        }
      }
      else
      {
        if (this.dnF == 23)
        {
          if ((!bt.isNullOrNil(paramArrayOfByte)) && (!bt.isNullOrNil(paramq))) {
            break label1266;
          }
          ad.e("MicroMsg.NetSceneDownloadPackage", "update permission pkg failed, packagePath: %s, packageName: %s", new Object[] { paramArrayOfByte, paramq });
          t.aJZ().dn(this.ijm, this.dnF);
          this.callback.onSceneEnd(3, 0, "open permission pkg failed", this);
          bool = false;
        }
        label868:
        if (this.dnF == 7) {
          bool = true;
        }
        if (this.dnF == 9) {
          bool = true;
        }
        if (this.dnF == 5)
        {
          bool = true;
          ad.i("MicroMsg.NetSceneDownloadPackage", "resetResContextImp");
        }
        if (this.dnF == 12)
        {
          paramString = new pp();
          paramString.dDQ.dDS = (paramArrayOfByte + paramq);
          a.IbL.l(paramString);
          bool = true;
        }
        if (this.dnF == 18)
        {
          paramString = t.aJZ().dm(this.ijm, this.dnF);
          paramInt1 = bt.lP(paramArrayOfByte + paramq, paramString);
          if (paramInt1 >= 0) {
            break label1461;
          }
          ad.e("MicroMsg.NetSceneDownloadPackage", "unzip fail, ret = " + paramInt1 + ", zipFilePath = " + paramArrayOfByte + paramq + ", unzipPath = " + paramString);
          t.aJZ().dn(this.ijm, this.dnF);
          this.callback.onSceneEnd(3, 0, "unzip fail", this);
          bool = false;
        }
        label1105:
        if (this.dnF == 20) {
          bool = true;
        }
        if (this.dnF == 21) {
          bool = true;
        }
        if (this.dnF == 26)
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
        if (this.dnF == 36) {
          bool = bt(paramArrayOfByte, paramq);
        }
        if (bool)
        {
          localo.status = 2;
          localo.dDp = 64;
          t.aJZ().b(localo);
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
          t.aJZ().dn(this.ijm, this.dnF);
          this.callback.onSceneEnd(3, 0, "file not exist", this);
          bool = false;
          break label868;
        }
        paramString = com.tencent.mm.loader.j.b.arM() + "permissioncfg.cfg";
        if (-1L == i.mz(paramArrayOfByte + paramq, paramString))
        {
          ad.e("MicroMsg.NetSceneDownloadPackage", "copy file failed");
          t.aJZ().dn(this.ijm, this.dnF);
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
          t.aJZ().dn(this.ijm, this.dnF);
          this.callback.onSceneEnd(3, 0, "file not exist", this);
          bool = false;
        }
        else
        {
          paramString = com.tencent.mm.loader.j.b.arM() + "ipcallCountryCodeConfig.cfg";
          if (-1L == i.mz(paramArrayOfByte + paramq, paramString))
          {
            ad.e("MicroMsg.NetSceneDownloadPackage", "copy file failed");
            t.aJZ().dn(this.ijm, this.dnF);
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
      t.aJZ().dn(this.ijm, this.dnF);
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
    paramq = (afb)((com.tencent.mm.al.b)paramq).hNK.hNQ;
    o localo = t.aJZ().dj(this.ijm, this.dnF);
    if (localo == null)
    {
      ad.e("MicroMsg.NetSceneDownloadPackage", "securityVerificationChecked get Theme failed id:" + this.ijm);
      paramq = n.b.hOq;
      AppMethodBeat.o(150809);
      return paramq;
    }
    if ((paramq.Gdi.ukh != this.ijm) || (paramq.FMu != this.offset) || (paramq.FMu >= localo.size) || (paramq.Gdj != 65536) || (localo.size <= 0) || (localo.status != 3))
    {
      ad.e("MicroMsg.NetSceneDownloadPackage", "securityVerificationChecked Theme failed id:" + this.ijm);
      paramq = n.b.hOq;
      AppMethodBeat.o(150809);
      return paramq;
    }
    paramq = n.b.hOp;
    AppMethodBeat.o(150809);
    return paramq;
  }
  
  public final void setSecurityCheckError(n.a parama)
  {
    AppMethodBeat.i(150810);
    t.aJZ().dn(this.ijm, this.dnF);
    AppMethodBeat.o(150810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bc.k
 * JD-Core Version:    0.7.0.1
 */
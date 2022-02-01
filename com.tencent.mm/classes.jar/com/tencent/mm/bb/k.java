package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.a;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.g.a.pq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.afk;
import com.tencent.mm.protocal.protobuf.afl;
import com.tencent.mm.protocal.protobuf.chu;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.io.IOException;

public final class k
  extends n
  implements com.tencent.mm.ak.p, com.tencent.mm.network.k
{
  private f callback;
  private int doK;
  public int imf;
  private int offset;
  private com.tencent.mm.ak.b rr;
  
  public k(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150807);
    this.imf = paramInt1;
    this.doK = paramInt2;
    this.offset = 0;
    Object localObject = t.aKs().dj(paramInt1, paramInt2);
    if (localObject == null)
    {
      ae.e("MicroMsg.NetSceneDownloadPackage", "doScene get info null, id:".concat(String.valueOf(paramInt1)));
      AppMethodBeat.o(150807);
      return;
    }
    ((o)localObject).status = 3;
    ((o)localObject).dEu = 64;
    t.aKs().b((o)localObject);
    if (paramInt2 == 5)
    {
      localObject = g.ajR().cachePath;
      com.tencent.mm.vfs.o.deleteFile((String)localObject + "brand_i18n.apk");
      AppMethodBeat.o(150807);
      return;
    }
    localObject = t.aKs();
    com.tencent.mm.vfs.o.deleteFile(p.aKp() + ((p)localObject).dl(paramInt1, paramInt2));
    AppMethodBeat.o(150807);
  }
  
  private static boolean bt(String paramString1, String paramString2)
  {
    boolean bool = true;
    AppMethodBeat.i(150812);
    if ((bu.isNullOrNil(paramString1)) || (bu.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(150812);
      return false;
    }
    try
    {
      paramString1 = paramString1 + paramString2;
      paramString2 = com.tencent.mm.vfs.o.aZT(paramString1);
      if (!bu.isNullOrNil(paramString2)) {
        g.ajR().ajA().set(am.a.IQu, paramString2);
      }
    }
    catch (IOException paramString1)
    {
      for (;;)
      {
        try
        {
          com.tencent.mm.vfs.o.deleteFile(paramString1);
          ae.i("MicroMsg.NetSceneDownloadPackage", "update sense where result[%b] filepath[%s] xml[%s] ", new Object[] { Boolean.valueOf(bool), paramString1, bu.aSM(paramString2) });
          AppMethodBeat.o(150812);
          return bool;
        }
        catch (IOException paramString1)
        {
          continue;
        }
        paramString1 = paramString1;
        bool = false;
        ae.printErrStackTrace("MicroMsg.NetSceneDownloadPackage", paramString1, "", new Object[0]);
        continue;
        bool = false;
      }
    }
  }
  
  public final int aFc()
  {
    return this.doK;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(150808);
    this.callback = paramf;
    ae.d("MicroMsg.NetSceneDownloadPackage", "dkregcode doScene pkgId:%d packageType:%d", new Object[] { Integer.valueOf(this.imf), Integer.valueOf(this.doK) });
    paramf = t.aKs().dj(this.imf, this.doK);
    if (paramf == null)
    {
      ae.e("MicroMsg.NetSceneDownloadPackage", "doScene get Theme failed id:" + this.imf + " type:" + this.doK);
      AppMethodBeat.o(150808);
      return -1;
    }
    if (paramf.status != 3)
    {
      ae.e("MicroMsg.NetSceneDownloadPackage", "doScene get Theme stat failed id:" + this.imf + " stat:" + paramf.status);
      AppMethodBeat.o(150808);
      return -1;
    }
    if (paramf.size <= 0)
    {
      ae.e("MicroMsg.NetSceneDownloadPackage", "doScene Theme size err id:" + this.imf + " size:" + paramf.size);
      AppMethodBeat.o(150808);
      return -1;
    }
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new afk();
    ((b.a)localObject).hQG = new afl();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/downloadpackage";
    ((b.a)localObject).funcId = 160;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (afk)this.rr.hQD.hQJ;
    chu localchu = new chu();
    localchu.uvE = paramf.id;
    localchu.Version = paramf.version;
    ((afk)localObject).GvP = localchu;
    ((afk)localObject).GeT = this.offset;
    ((afk)localObject).GvQ = 65536;
    ((afk)localObject).nJA = this.doK;
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
    ae.d("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd id:" + this.imf + " + id:" + paramInt1 + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      ae.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd, errType = " + paramInt2 + ", errCode = " + paramInt3);
      t.aKs().dn(this.imf, this.doK);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(150811);
      return;
    }
    paramq = (afl)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
    if (paramq.nJA != this.doK)
    {
      ae.e("MicroMsg.NetSceneDownloadPackage", "packageType is not consistent");
      t.aKs().dn(this.imf, this.doK);
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(150811);
      return;
    }
    byte[] arrayOfByte = z.a(paramq.GvR);
    if ((arrayOfByte == null) || (arrayOfByte.length == 0))
    {
      ae.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd get pkgBuf failed id:" + this.imf);
      t.aKs().dn(this.imf, this.doK);
      this.callback.onSceneEnd(3, -1, paramString, this);
      AppMethodBeat.o(150811);
      return;
    }
    o localo = t.aKs().dj(this.imf, this.doK);
    if (localo == null)
    {
      ae.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd info is null, pkgId = " + this.imf);
      t.aKs().dn(this.imf, this.doK);
      this.callback.onSceneEnd(3, -1, paramString, this);
      AppMethodBeat.o(150811);
      return;
    }
    if (localo.size != paramq.GvS)
    {
      ae.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd totalSize is incorrect");
      t.aKs().dn(this.imf, this.doK);
      paramq = new l(this.doK);
      g.ajQ().gDv.a(paramq, 0);
      this.callback.onSceneEnd(3, -1, paramString, this);
      AppMethodBeat.o(150811);
      return;
    }
    if (this.doK == 5) {
      paramArrayOfByte = g.ajR().cachePath;
    }
    for (paramq = "brand_i18n.apk";; paramq = t.aKs().dl(this.imf, this.doK))
    {
      ae.d("MicroMsg.NetSceneDownloadPackage", "packagePath ".concat(String.valueOf(paramArrayOfByte)));
      ae.d("MicroMsg.NetSceneDownloadPackage", "packageName ".concat(String.valueOf(paramq)));
      com.tencent.mm.vfs.o.aZI(paramArrayOfByte);
      paramInt1 = com.tencent.mm.vfs.o.e(paramArrayOfByte + '/' + paramq, arrayOfByte, arrayOfByte.length);
      if (paramInt1 == 0) {
        break;
      }
      t.aKs().dn(this.imf, this.doK);
      ae.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd write file fail, ret = ".concat(String.valueOf(paramInt1)));
      this.callback.onSceneEnd(3, -1, paramString, this);
      AppMethodBeat.o(150811);
      return;
      t.aKs();
      paramArrayOfByte = p.aKp();
    }
    paramInt1 = this.offset;
    this.offset = (arrayOfByte.length + paramInt1);
    if (this.offset >= localo.size)
    {
      boolean bool = false;
      if (this.doK == 1)
      {
        paramString = t.aKs().dm(this.imf, this.doK);
        paramInt1 = bu.lW(paramArrayOfByte + paramq, paramString);
        if (paramInt1 < 0)
        {
          ae.e("MicroMsg.NetSceneDownloadPackage", "unzip fail, ret = " + paramInt1 + ", zipFilePath = " + paramArrayOfByte + paramq + ", unzipPath = " + paramString);
          t.aKs().dn(this.imf, this.doK);
          this.callback.onSceneEnd(3, 0, "unzip fail", this);
          bool = false;
        }
      }
      else
      {
        if (this.doK == 23)
        {
          if ((!bu.isNullOrNil(paramArrayOfByte)) && (!bu.isNullOrNil(paramq))) {
            break label1266;
          }
          ae.e("MicroMsg.NetSceneDownloadPackage", "update permission pkg failed, packagePath: %s, packageName: %s", new Object[] { paramArrayOfByte, paramq });
          t.aKs().dn(this.imf, this.doK);
          this.callback.onSceneEnd(3, 0, "open permission pkg failed", this);
          bool = false;
        }
        label868:
        if (this.doK == 7) {
          bool = true;
        }
        if (this.doK == 9) {
          bool = true;
        }
        if (this.doK == 5)
        {
          bool = true;
          ae.i("MicroMsg.NetSceneDownloadPackage", "resetResContextImp");
        }
        if (this.doK == 12)
        {
          paramString = new pq();
          paramString.dEV.dEX = (paramArrayOfByte + paramq);
          a.IvT.l(paramString);
          bool = true;
        }
        if (this.doK == 18)
        {
          paramString = t.aKs().dm(this.imf, this.doK);
          paramInt1 = bu.lW(paramArrayOfByte + paramq, paramString);
          if (paramInt1 >= 0) {
            break label1461;
          }
          ae.e("MicroMsg.NetSceneDownloadPackage", "unzip fail, ret = " + paramInt1 + ", zipFilePath = " + paramArrayOfByte + paramq + ", unzipPath = " + paramString);
          t.aKs().dn(this.imf, this.doK);
          this.callback.onSceneEnd(3, 0, "unzip fail", this);
          bool = false;
        }
        label1105:
        if (this.doK == 20) {
          bool = true;
        }
        if (this.doK == 21) {
          bool = true;
        }
        if (this.doK == 26)
        {
          if ((!bu.isNullOrNil(paramArrayOfByte)) && (!bu.isNullOrNil(paramq))) {
            break label1484;
          }
          ae.e("MicroMsg.NetSceneDownloadPackage", "updateIPCallContryCodeConfigPkg failed, packagePath: %s, packageName: %s", new Object[] { paramArrayOfByte, paramq });
          this.callback.onSceneEnd(3, 0, "open IPCallContryCodeConfigs pkg failed", this);
          bool = false;
        }
      }
      for (;;)
      {
        if (this.doK == 36) {
          bool = bt(paramArrayOfByte, paramq);
        }
        if (bool)
        {
          localo.status = 2;
          localo.dEu = 64;
          t.aKs().b(localo);
          this.callback.onSceneEnd(0, 0, "", this);
        }
        AppMethodBeat.o(150811);
        return;
        bool = true;
        break;
        label1266:
        if (!new com.tencent.mm.vfs.k(paramArrayOfByte + paramq).exists())
        {
          ae.e("MicroMsg.NetSceneDownloadPackage", "update permission pkg failed, file no exist, path: %s, name: %s", new Object[] { paramArrayOfByte, paramq });
          t.aKs().dn(this.imf, this.doK);
          this.callback.onSceneEnd(3, 0, "file not exist", this);
          bool = false;
          break label868;
        }
        paramString = com.tencent.mm.loader.j.b.asb() + "permissioncfg.cfg";
        if (-1L == com.tencent.mm.vfs.o.mF(paramArrayOfByte + paramq, paramString))
        {
          ae.e("MicroMsg.NetSceneDownloadPackage", "copy file failed");
          t.aKs().dn(this.imf, this.doK);
          this.callback.onSceneEnd(3, 0, "copy file failed", this);
          bool = false;
          break label868;
        }
        bool = true;
        break label868;
        label1461:
        ae.i("MicroMsg.NetSceneDownloadPackage", "Unzip Path %s", new Object[] { paramString });
        bool = true;
        break label1105;
        label1484:
        if (!new com.tencent.mm.vfs.k(paramArrayOfByte + paramq).exists())
        {
          ae.e("MicroMsg.NetSceneDownloadPackage", "updateIPCallContryCodeConfigPkg failed, file not exist, packagePath: %s, packageName: %s", new Object[] { paramArrayOfByte, paramq });
          t.aKs().dn(this.imf, this.doK);
          this.callback.onSceneEnd(3, 0, "file not exist", this);
          bool = false;
        }
        else
        {
          paramString = com.tencent.mm.loader.j.b.asb() + "ipcallCountryCodeConfig.cfg";
          if (-1L == com.tencent.mm.vfs.o.mF(paramArrayOfByte + paramq, paramString))
          {
            ae.e("MicroMsg.NetSceneDownloadPackage", "copy file failed");
            t.aKs().dn(this.imf, this.doK);
            this.callback.onSceneEnd(3, 0, "copy file failed", this);
            bool = false;
          }
          else
          {
            ae.d("MicroMsg.NetSceneDownloadPackage", "updateIPCallContryCodeConfigPkg success");
            bool = true;
          }
        }
      }
    }
    if (doScene(dispatcher(), this.callback) < 0)
    {
      t.aKs().dn(this.imf, this.doK);
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
    paramq = (afk)((com.tencent.mm.ak.b)paramq).hQD.hQJ;
    o localo = t.aKs().dj(this.imf, this.doK);
    if (localo == null)
    {
      ae.e("MicroMsg.NetSceneDownloadPackage", "securityVerificationChecked get Theme failed id:" + this.imf);
      paramq = n.b.hRj;
      AppMethodBeat.o(150809);
      return paramq;
    }
    if ((paramq.GvP.uvE != this.imf) || (paramq.GeT != this.offset) || (paramq.GeT >= localo.size) || (paramq.GvQ != 65536) || (localo.size <= 0) || (localo.status != 3))
    {
      ae.e("MicroMsg.NetSceneDownloadPackage", "securityVerificationChecked Theme failed id:" + this.imf);
      paramq = n.b.hRj;
      AppMethodBeat.o(150809);
      return paramq;
    }
    paramq = n.b.hRi;
    AppMethodBeat.o(150809);
    return paramq;
  }
  
  public final void setSecurityCheckError(n.a parama)
  {
    AppMethodBeat.i(150810);
    t.aKs().dn(this.imf, this.doK);
    AppMethodBeat.o(150810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bb.k
 * JD-Core Version:    0.7.0.1
 */
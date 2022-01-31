package com.tencent.mm.az;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m.a;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.ah.o;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.mo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.bcr;
import com.tencent.mm.protocal.c.ud;
import com.tencent.mm.protocal.c.ue;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.io.IOException;

public final class j
  extends com.tencent.mm.ah.m
  implements o, com.tencent.mm.network.k
{
  private int bIv;
  private com.tencent.mm.ah.b dmK;
  private f dmL;
  public int ewN;
  private int offset;
  
  public j(int paramInt1, int paramInt2)
  {
    this.ewN = paramInt1;
    this.bIv = paramInt2;
    this.offset = 0;
    Object localObject = r.PK().bp(paramInt1, paramInt2);
    if (localObject == null)
    {
      y.e("MicroMsg.NetSceneDownloadPackage", "doScene get info null, id:" + paramInt1);
      return;
    }
    ((m)localObject).status = 3;
    ((m)localObject).bcw = 64;
    r.PK().b((m)localObject);
    if (paramInt2 == 5)
    {
      localObject = g.DP().cachePath;
      com.tencent.mm.vfs.e.deleteFile((String)localObject + "brand_i18n.apk");
      return;
    }
    localObject = r.PK();
    com.tencent.mm.vfs.e.deleteFile(n.PH() + ((n)localObject).br(paramInt1, paramInt2));
  }
  
  private static boolean ax(String paramString1, String paramString2)
  {
    boolean bool = true;
    if ((bk.bl(paramString1)) || (bk.bl(paramString2))) {
      return false;
    }
    try
    {
      paramString1 = paramString1 + paramString2;
      paramString2 = com.tencent.mm.vfs.e.bP(paramString1);
      if (!bk.bl(paramString2))
      {
        g.DP().Dz().c(ac.a.utp, paramString2);
        try
        {
          com.tencent.mm.vfs.e.deleteFile(paramString1);
          y.i("MicroMsg.NetSceneDownloadPackage", "update sense where result[%b] filepath[%s] xml[%s] ", new Object[] { Boolean.valueOf(bool), paramString1, bk.aac(paramString2) });
          return bool;
        }
        catch (IOException paramString1) {}
        y.printErrStackTrace("MicroMsg.NetSceneDownloadPackage", paramString1, "", new Object[0]);
        return bool;
      }
    }
    catch (IOException paramString1)
    {
      for (;;)
      {
        bool = false;
        continue;
        bool = false;
      }
    }
  }
  
  public final int KF()
  {
    return this.bIv;
  }
  
  protected final int Ka()
  {
    return 50;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    y.d("MicroMsg.NetSceneDownloadPackage", "dkregcode doScene pkgId:%d packageType:%d", new Object[] { Integer.valueOf(this.ewN), Integer.valueOf(this.bIv) });
    paramf = r.PK().bp(this.ewN, this.bIv);
    if (paramf == null)
    {
      y.e("MicroMsg.NetSceneDownloadPackage", "doScene get Theme failed id:" + this.ewN + " type:" + this.bIv);
      return -1;
    }
    if (paramf.status != 3)
    {
      y.e("MicroMsg.NetSceneDownloadPackage", "doScene get Theme stat failed id:" + this.ewN + " stat:" + paramf.status);
      return -1;
    }
    if (paramf.size <= 0)
    {
      y.e("MicroMsg.NetSceneDownloadPackage", "doScene Theme size err id:" + this.ewN + " size:" + paramf.size);
      return -1;
    }
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new ud();
    ((b.a)localObject).ecI = new ue();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/downloadpackage";
    ((b.a)localObject).ecG = 160;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (ud)this.dmK.ecE.ecN;
    bcr localbcr = new bcr();
    localbcr.kWl = paramf.id;
    localbcr.hQQ = paramf.version;
    ((ud)localObject).sQU = localbcr;
    ((ud)localObject).sDT = this.offset;
    ((ud)localObject).sQV = 65536;
    ((ud)localObject).hQR = this.bIv;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd id:" + this.ewN + " + id:" + paramInt1 + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      y.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd, errType = " + paramInt2 + ", errCode = " + paramInt3);
      r.PK().bt(this.ewN, this.bIv);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    label768:
    label847:
    label1239:
    do
    {
      return;
      paramq = (ue)((com.tencent.mm.ah.b)paramq).ecF.ecN;
      if (paramq.hQR != this.bIv)
      {
        y.e("MicroMsg.NetSceneDownloadPackage", "packageType is not consistent");
        r.PK().bt(this.ewN, this.bIv);
        this.dmL.onSceneEnd(3, -1, "", this);
        return;
      }
      byte[] arrayOfByte = aa.a(paramq.sQW);
      if ((arrayOfByte == null) || (arrayOfByte.length == 0))
      {
        y.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd get pkgBuf failed id:" + this.ewN);
        r.PK().bt(this.ewN, this.bIv);
        this.dmL.onSceneEnd(3, -1, paramString, this);
        return;
      }
      m localm = r.PK().bp(this.ewN, this.bIv);
      if (localm == null)
      {
        y.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd info is null, pkgId = " + this.ewN);
        r.PK().bt(this.ewN, this.bIv);
        this.dmL.onSceneEnd(3, -1, paramString, this);
        return;
      }
      if (localm.size != paramq.sQX)
      {
        y.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd totalSize is incorrect");
        r.PK().bt(this.ewN, this.bIv);
        paramq = new k(this.bIv);
        g.DO().dJT.a(paramq, 0);
        this.dmL.onSceneEnd(3, -1, paramString, this);
        return;
      }
      if (this.bIv == 5) {
        paramArrayOfByte = g.DP().cachePath;
      }
      for (paramq = "brand_i18n.apk";; paramq = r.PK().br(this.ewN, this.bIv))
      {
        y.d("MicroMsg.NetSceneDownloadPackage", "packagePath " + paramArrayOfByte);
        y.d("MicroMsg.NetSceneDownloadPackage", "packageName " + paramq);
        com.tencent.mm.vfs.e.nb(paramArrayOfByte);
        paramInt1 = com.tencent.mm.vfs.e.a(paramArrayOfByte + '/' + paramq, arrayOfByte, arrayOfByte.length);
        if (paramInt1 == 0) {
          break;
        }
        r.PK().bt(this.ewN, this.bIv);
        y.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd write file fail, ret = " + paramInt1);
        this.dmL.onSceneEnd(3, -1, paramString, this);
        return;
        r.PK();
        paramArrayOfByte = n.PH();
      }
      paramInt1 = this.offset;
      this.offset = (arrayOfByte.length + paramInt1);
      if (this.offset >= localm.size)
      {
        boolean bool = false;
        if (this.bIv == 1)
        {
          paramString = r.PK().bs(this.ewN, this.bIv);
          paramInt1 = bk.gh(paramArrayOfByte + paramq, paramString);
          if (paramInt1 < 0)
          {
            y.e("MicroMsg.NetSceneDownloadPackage", "unzip fail, ret = " + paramInt1 + ", zipFilePath = " + paramArrayOfByte + paramq + ", unzipPath = " + paramString);
            r.PK().bt(this.ewN, this.bIv);
            this.dmL.onSceneEnd(3, 0, "unzip fail", this);
            bool = false;
          }
        }
        else
        {
          if (this.bIv == 23)
          {
            if ((!bk.bl(paramArrayOfByte)) && (!bk.bl(paramq))) {
              break label1239;
            }
            y.e("MicroMsg.NetSceneDownloadPackage", "update permission pkg failed, packagePath: %s, packageName: %s", new Object[] { paramArrayOfByte, paramq });
            r.PK().bt(this.ewN, this.bIv);
            this.dmL.onSceneEnd(3, 0, "open permission pkg failed", this);
            bool = false;
          }
          if (this.bIv == 7) {
            bool = true;
          }
          if (this.bIv == 9) {
            bool = true;
          }
          if (this.bIv == 5)
          {
            bool = true;
            y.i("MicroMsg.NetSceneDownloadPackage", "resetResContextImp");
          }
          if (this.bIv == 12)
          {
            paramString = new mo();
            paramString.bVW.bVY = (paramArrayOfByte + paramq);
            a.udP.m(paramString);
            bool = true;
          }
          if (this.bIv == 18)
          {
            paramString = r.PK().bs(this.ewN, this.bIv);
            paramInt1 = bk.gh(paramArrayOfByte + paramq, paramString);
            if (paramInt1 >= 0) {
              break label1434;
            }
            y.e("MicroMsg.NetSceneDownloadPackage", "unzip fail, ret = " + paramInt1 + ", zipFilePath = " + paramArrayOfByte + paramq + ", unzipPath = " + paramString);
            r.PK().bt(this.ewN, this.bIv);
            this.dmL.onSceneEnd(3, 0, "unzip fail", this);
            bool = false;
          }
          if (this.bIv == 20) {
            bool = true;
          }
          if (this.bIv == 21) {
            bool = true;
          }
          if (this.bIv == 26)
          {
            if ((!bk.bl(paramArrayOfByte)) && (!bk.bl(paramq))) {
              break label1457;
            }
            y.e("MicroMsg.NetSceneDownloadPackage", "updateIPCallContryCodeConfigPkg failed, packagePath: %s, packageName: %s", new Object[] { paramArrayOfByte, paramq });
            this.dmL.onSceneEnd(3, 0, "open IPCallContryCodeConfigs pkg failed", this);
            bool = false;
          }
        }
        for (;;)
        {
          if (this.bIv == 36) {
            bool = ax(paramArrayOfByte, paramq);
          }
          if (!bool) {
            break;
          }
          localm.status = 2;
          localm.bcw = 64;
          r.PK().b(localm);
          this.dmL.onSceneEnd(0, 0, "", this);
          return;
          bool = true;
          break label768;
          if (!new com.tencent.mm.vfs.b(paramArrayOfByte + paramq).exists())
          {
            y.e("MicroMsg.NetSceneDownloadPackage", "update permission pkg failed, file no exist, path: %s, name: %s", new Object[] { paramArrayOfByte, paramq });
            r.PK().bt(this.ewN, this.bIv);
            this.dmL.onSceneEnd(3, 0, "file not exist", this);
            bool = false;
            break label847;
          }
          paramString = com.tencent.mm.compatible.util.e.dOP + "permissioncfg.cfg";
          if (-1L == com.tencent.mm.vfs.e.r(paramArrayOfByte + paramq, paramString))
          {
            y.e("MicroMsg.NetSceneDownloadPackage", "copy file failed");
            r.PK().bt(this.ewN, this.bIv);
            this.dmL.onSceneEnd(3, 0, "copy file failed", this);
            bool = false;
            break label847;
          }
          bool = true;
          break label847;
          y.i("MicroMsg.NetSceneDownloadPackage", "Unzip Path %s", new Object[] { paramString });
          bool = true;
          break label1084;
          if (!new com.tencent.mm.vfs.b(paramArrayOfByte + paramq).exists())
          {
            y.e("MicroMsg.NetSceneDownloadPackage", "updateIPCallContryCodeConfigPkg failed, file not exist, packagePath: %s, packageName: %s", new Object[] { paramArrayOfByte, paramq });
            r.PK().bt(this.ewN, this.bIv);
            this.dmL.onSceneEnd(3, 0, "file not exist", this);
            bool = false;
          }
          else
          {
            paramString = com.tencent.mm.compatible.util.e.dOP + "ipcallCountryCodeConfig.cfg";
            if (-1L == com.tencent.mm.vfs.e.r(paramArrayOfByte + paramq, paramString))
            {
              y.e("MicroMsg.NetSceneDownloadPackage", "copy file failed");
              r.PK().bt(this.ewN, this.bIv);
              this.dmL.onSceneEnd(3, 0, "copy file failed", this);
              bool = false;
            }
            else
            {
              y.d("MicroMsg.NetSceneDownloadPackage", "updateIPCallContryCodeConfigPkg success");
              bool = true;
            }
          }
        }
      }
    } while (a(this.edc, this.dmL) >= 0);
    label1084:
    r.PK().bt(this.ewN, this.bIv);
    label1434:
    label1457:
    this.dmL.onSceneEnd(3, -1, paramString, this);
  }
  
  protected final void a(m.a parama)
  {
    r.PK().bt(this.ewN, this.bIv);
  }
  
  protected final m.b b(q paramq)
  {
    paramq = (ud)((com.tencent.mm.ah.b)paramq).ecE.ecN;
    m localm = r.PK().bp(this.ewN, this.bIv);
    if (localm == null)
    {
      y.e("MicroMsg.NetSceneDownloadPackage", "securityVerificationChecked get Theme failed id:" + this.ewN);
      return m.b.eds;
    }
    if ((paramq.sQU.kWl != this.ewN) || (paramq.sDT != this.offset) || (paramq.sDT >= localm.size) || (paramq.sQV != 65536) || (localm.size <= 0) || (localm.status != 3))
    {
      y.e("MicroMsg.NetSceneDownloadPackage", "securityVerificationChecked Theme failed id:" + this.ewN);
      return m.b.eds;
    }
    return m.b.edr;
  }
  
  public final int getType()
  {
    return 160;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.az.j
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m.a;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.ai.o;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.nj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.bka;
import com.tencent.mm.protocal.protobuf.yq;
import com.tencent.mm.protocal.protobuf.yr;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.io.IOException;

public final class j
  extends com.tencent.mm.ai.m
  implements o, com.tencent.mm.network.k
{
  private f callback;
  private int cpQ;
  public int fMD;
  private int offset;
  private com.tencent.mm.ai.b rr;
  
  public j(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(78452);
    this.fMD = paramInt1;
    this.cpQ = paramInt2;
    this.offset = 0;
    Object localObject = r.aiP().cz(paramInt1, paramInt2);
    if (localObject == null)
    {
      ab.e("MicroMsg.NetSceneDownloadPackage", "doScene get info null, id:".concat(String.valueOf(paramInt1)));
      AppMethodBeat.o(78452);
      return;
    }
    ((m)localObject).status = 3;
    ((m)localObject).bsY = 64;
    r.aiP().b((m)localObject);
    if (paramInt2 == 5)
    {
      localObject = g.RL().cachePath;
      com.tencent.mm.vfs.e.deleteFile((String)localObject + "brand_i18n.apk");
      AppMethodBeat.o(78452);
      return;
    }
    localObject = r.aiP();
    com.tencent.mm.vfs.e.deleteFile(n.aiM() + ((n)localObject).cB(paramInt1, paramInt2));
    AppMethodBeat.o(78452);
  }
  
  private static boolean aQ(String paramString1, String paramString2)
  {
    boolean bool = true;
    AppMethodBeat.i(78457);
    if ((bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(78457);
      return false;
    }
    try
    {
      paramString1 = paramString1 + paramString2;
      paramString2 = com.tencent.mm.vfs.e.cS(paramString1);
      if (!bo.isNullOrNil(paramString2)) {
        g.RL().Ru().set(ac.a.yDr, paramString2);
      }
    }
    catch (IOException paramString1)
    {
      for (;;)
      {
        try
        {
          com.tencent.mm.vfs.e.deleteFile(paramString1);
          ab.i("MicroMsg.NetSceneDownloadPackage", "update sense where result[%b] filepath[%s] xml[%s] ", new Object[] { Boolean.valueOf(bool), paramString1, bo.aqg(paramString2) });
          AppMethodBeat.o(78457);
          return bool;
        }
        catch (IOException paramString1)
        {
          continue;
        }
        paramString1 = paramString1;
        bool = false;
        ab.printErrStackTrace("MicroMsg.NetSceneDownloadPackage", paramString1, "", new Object[0]);
        continue;
        bool = false;
      }
    }
  }
  
  public final int ads()
  {
    return this.cpQ;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(78453);
    this.callback = paramf;
    ab.d("MicroMsg.NetSceneDownloadPackage", "dkregcode doScene pkgId:%d packageType:%d", new Object[] { Integer.valueOf(this.fMD), Integer.valueOf(this.cpQ) });
    paramf = r.aiP().cz(this.fMD, this.cpQ);
    if (paramf == null)
    {
      ab.e("MicroMsg.NetSceneDownloadPackage", "doScene get Theme failed id:" + this.fMD + " type:" + this.cpQ);
      AppMethodBeat.o(78453);
      return -1;
    }
    if (paramf.status != 3)
    {
      ab.e("MicroMsg.NetSceneDownloadPackage", "doScene get Theme stat failed id:" + this.fMD + " stat:" + paramf.status);
      AppMethodBeat.o(78453);
      return -1;
    }
    if (paramf.size <= 0)
    {
      ab.e("MicroMsg.NetSceneDownloadPackage", "doScene Theme size err id:" + this.fMD + " size:" + paramf.size);
      AppMethodBeat.o(78453);
      return -1;
    }
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new yq();
    ((b.a)localObject).fsY = new yr();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/downloadpackage";
    ((b.a)localObject).funcId = 160;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (yq)this.rr.fsV.fta;
    bka localbka = new bka();
    localbka.nuk = paramf.id;
    localbka.Version = paramf.version;
    ((yq)localObject).wPK = localbka;
    ((yq)localObject).wzS = this.offset;
    ((yq)localObject).wPL = 65536;
    ((yq)localObject).jKs = this.cpQ;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78453);
    return i;
  }
  
  public final int getType()
  {
    return 160;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78456);
    ab.d("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd id:" + this.fMD + " + id:" + paramInt1 + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      ab.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd, errType = " + paramInt2 + ", errCode = " + paramInt3);
      r.aiP().cD(this.fMD, this.cpQ);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(78456);
      return;
    }
    paramq = (yr)((com.tencent.mm.ai.b)paramq).fsW.fta;
    if (paramq.jKs != this.cpQ)
    {
      ab.e("MicroMsg.NetSceneDownloadPackage", "packageType is not consistent");
      r.aiP().cD(this.fMD, this.cpQ);
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(78456);
      return;
    }
    byte[] arrayOfByte = aa.a(paramq.wPM);
    if ((arrayOfByte == null) || (arrayOfByte.length == 0))
    {
      ab.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd get pkgBuf failed id:" + this.fMD);
      r.aiP().cD(this.fMD, this.cpQ);
      this.callback.onSceneEnd(3, -1, paramString, this);
      AppMethodBeat.o(78456);
      return;
    }
    m localm = r.aiP().cz(this.fMD, this.cpQ);
    if (localm == null)
    {
      ab.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd info is null, pkgId = " + this.fMD);
      r.aiP().cD(this.fMD, this.cpQ);
      this.callback.onSceneEnd(3, -1, paramString, this);
      AppMethodBeat.o(78456);
      return;
    }
    if (localm.size != paramq.wPN)
    {
      ab.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd totalSize is incorrect");
      r.aiP().cD(this.fMD, this.cpQ);
      paramq = new k(this.cpQ);
      g.RK().eHt.a(paramq, 0);
      this.callback.onSceneEnd(3, -1, paramString, this);
      AppMethodBeat.o(78456);
      return;
    }
    if (this.cpQ == 5) {
      paramArrayOfByte = g.RL().cachePath;
    }
    for (paramq = "brand_i18n.apk";; paramq = r.aiP().cB(this.fMD, this.cpQ))
    {
      ab.d("MicroMsg.NetSceneDownloadPackage", "packagePath ".concat(String.valueOf(paramArrayOfByte)));
      ab.d("MicroMsg.NetSceneDownloadPackage", "packageName ".concat(String.valueOf(paramq)));
      com.tencent.mm.vfs.e.um(paramArrayOfByte);
      paramInt1 = com.tencent.mm.vfs.e.a(paramArrayOfByte + '/' + paramq, arrayOfByte, arrayOfByte.length);
      if (paramInt1 == 0) {
        break;
      }
      r.aiP().cD(this.fMD, this.cpQ);
      ab.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd write file fail, ret = ".concat(String.valueOf(paramInt1)));
      this.callback.onSceneEnd(3, -1, paramString, this);
      AppMethodBeat.o(78456);
      return;
      r.aiP();
      paramArrayOfByte = n.aiM();
    }
    paramInt1 = this.offset;
    this.offset = (arrayOfByte.length + paramInt1);
    if (this.offset >= localm.size)
    {
      boolean bool = false;
      if (this.cpQ == 1)
      {
        paramString = r.aiP().cC(this.fMD, this.cpQ);
        paramInt1 = bo.ii(paramArrayOfByte + paramq, paramString);
        if (paramInt1 < 0)
        {
          ab.e("MicroMsg.NetSceneDownloadPackage", "unzip fail, ret = " + paramInt1 + ", zipFilePath = " + paramArrayOfByte + paramq + ", unzipPath = " + paramString);
          r.aiP().cD(this.fMD, this.cpQ);
          this.callback.onSceneEnd(3, 0, "unzip fail", this);
          bool = false;
        }
      }
      else
      {
        if (this.cpQ == 23)
        {
          if ((!bo.isNullOrNil(paramArrayOfByte)) && (!bo.isNullOrNil(paramq))) {
            break label1266;
          }
          ab.e("MicroMsg.NetSceneDownloadPackage", "update permission pkg failed, packagePath: %s, packageName: %s", new Object[] { paramArrayOfByte, paramq });
          r.aiP().cD(this.fMD, this.cpQ);
          this.callback.onSceneEnd(3, 0, "open permission pkg failed", this);
          bool = false;
        }
        label868:
        if (this.cpQ == 7) {
          bool = true;
        }
        if (this.cpQ == 9) {
          bool = true;
        }
        if (this.cpQ == 5)
        {
          bool = true;
          ab.i("MicroMsg.NetSceneDownloadPackage", "resetResContextImp");
        }
        if (this.cpQ == 12)
        {
          paramString = new nj();
          paramString.cDJ.cDL = (paramArrayOfByte + paramq);
          a.ymk.l(paramString);
          bool = true;
        }
        if (this.cpQ == 18)
        {
          paramString = r.aiP().cC(this.fMD, this.cpQ);
          paramInt1 = bo.ii(paramArrayOfByte + paramq, paramString);
          if (paramInt1 >= 0) {
            break label1461;
          }
          ab.e("MicroMsg.NetSceneDownloadPackage", "unzip fail, ret = " + paramInt1 + ", zipFilePath = " + paramArrayOfByte + paramq + ", unzipPath = " + paramString);
          r.aiP().cD(this.fMD, this.cpQ);
          this.callback.onSceneEnd(3, 0, "unzip fail", this);
          bool = false;
        }
        label1105:
        if (this.cpQ == 20) {
          bool = true;
        }
        if (this.cpQ == 21) {
          bool = true;
        }
        if (this.cpQ == 26)
        {
          if ((!bo.isNullOrNil(paramArrayOfByte)) && (!bo.isNullOrNil(paramq))) {
            break label1484;
          }
          ab.e("MicroMsg.NetSceneDownloadPackage", "updateIPCallContryCodeConfigPkg failed, packagePath: %s, packageName: %s", new Object[] { paramArrayOfByte, paramq });
          this.callback.onSceneEnd(3, 0, "open IPCallContryCodeConfigs pkg failed", this);
          bool = false;
        }
      }
      for (;;)
      {
        if (this.cpQ == 36) {
          bool = aQ(paramArrayOfByte, paramq);
        }
        if (bool)
        {
          localm.status = 2;
          localm.bsY = 64;
          r.aiP().b(localm);
          this.callback.onSceneEnd(0, 0, "", this);
        }
        AppMethodBeat.o(78456);
        return;
        bool = true;
        break;
        label1266:
        if (!new com.tencent.mm.vfs.b(paramArrayOfByte + paramq).exists())
        {
          ab.e("MicroMsg.NetSceneDownloadPackage", "update permission pkg failed, file no exist, path: %s, name: %s", new Object[] { paramArrayOfByte, paramq });
          r.aiP().cD(this.fMD, this.cpQ);
          this.callback.onSceneEnd(3, 0, "file not exist", this);
          bool = false;
          break label868;
        }
        paramString = com.tencent.mm.compatible.util.e.eQv + "permissioncfg.cfg";
        if (-1L == com.tencent.mm.vfs.e.C(paramArrayOfByte + paramq, paramString))
        {
          ab.e("MicroMsg.NetSceneDownloadPackage", "copy file failed");
          r.aiP().cD(this.fMD, this.cpQ);
          this.callback.onSceneEnd(3, 0, "copy file failed", this);
          bool = false;
          break label868;
        }
        bool = true;
        break label868;
        label1461:
        ab.i("MicroMsg.NetSceneDownloadPackage", "Unzip Path %s", new Object[] { paramString });
        bool = true;
        break label1105;
        label1484:
        if (!new com.tencent.mm.vfs.b(paramArrayOfByte + paramq).exists())
        {
          ab.e("MicroMsg.NetSceneDownloadPackage", "updateIPCallContryCodeConfigPkg failed, file not exist, packagePath: %s, packageName: %s", new Object[] { paramArrayOfByte, paramq });
          r.aiP().cD(this.fMD, this.cpQ);
          this.callback.onSceneEnd(3, 0, "file not exist", this);
          bool = false;
        }
        else
        {
          paramString = com.tencent.mm.compatible.util.e.eQv + "ipcallCountryCodeConfig.cfg";
          if (-1L == com.tencent.mm.vfs.e.C(paramArrayOfByte + paramq, paramString))
          {
            ab.e("MicroMsg.NetSceneDownloadPackage", "copy file failed");
            r.aiP().cD(this.fMD, this.cpQ);
            this.callback.onSceneEnd(3, 0, "copy file failed", this);
            bool = false;
          }
          else
          {
            ab.d("MicroMsg.NetSceneDownloadPackage", "updateIPCallContryCodeConfigPkg success");
            bool = true;
          }
        }
      }
    }
    if (doScene(dispatcher(), this.callback) < 0)
    {
      r.aiP().cD(this.fMD, this.cpQ);
      this.callback.onSceneEnd(3, -1, paramString, this);
    }
    AppMethodBeat.o(78456);
  }
  
  public final int securityLimitCount()
  {
    return 50;
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    AppMethodBeat.i(78454);
    paramq = (yq)((com.tencent.mm.ai.b)paramq).fsV.fta;
    m localm = r.aiP().cz(this.fMD, this.cpQ);
    if (localm == null)
    {
      ab.e("MicroMsg.NetSceneDownloadPackage", "securityVerificationChecked get Theme failed id:" + this.fMD);
      paramq = m.b.ftv;
      AppMethodBeat.o(78454);
      return paramq;
    }
    if ((paramq.wPK.nuk != this.fMD) || (paramq.wzS != this.offset) || (paramq.wzS >= localm.size) || (paramq.wPL != 65536) || (localm.size <= 0) || (localm.status != 3))
    {
      ab.e("MicroMsg.NetSceneDownloadPackage", "securityVerificationChecked Theme failed id:" + this.fMD);
      paramq = m.b.ftv;
      AppMethodBeat.o(78454);
      return paramq;
    }
    paramq = m.b.ftu;
    AppMethodBeat.o(78454);
    return paramq;
  }
  
  public final void setSecurityCheckError(m.a parama)
  {
    AppMethodBeat.i(78455);
    r.aiP().cD(this.fMD, this.cpQ);
    AppMethodBeat.o(78455);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ba.j
 * JD-Core Version:    0.7.0.1
 */
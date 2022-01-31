package com.tencent.mm.plugin.exdevice.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.compatible.a.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bw;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.plugin.exdevice.b.k;
import com.tencent.mm.plugin.exdevice.service.f.a;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bd;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public final class ad
  implements at
{
  private static HashMap<Integer, h.d> baseDBFactories;
  private ab lFZ;
  private b lGa;
  private com.tencent.mm.plugin.exdevice.h.c lGb;
  private com.tencent.mm.plugin.exdevice.f.b.b.d lGc;
  private com.tencent.mm.plugin.exdevice.f.b.b.a lGd;
  private com.tencent.mm.plugin.exdevice.f.b.b.b lGe;
  private com.tencent.mm.plugin.exdevice.f.b.b.e lGf;
  private e lGg;
  private d lGh;
  private com.tencent.mm.plugin.exdevice.f.b.c lGi;
  private com.tencent.mm.plugin.exdevice.f.b.a lGj;
  private com.tencent.mm.plugin.exdevice.f.a.c lGk;
  private com.tencent.mm.at.a.a lGl;
  private com.tencent.mm.at.a.a.c lGm;
  private af lGn;
  private h lGo;
  private bz.a lGp;
  n.b lGq;
  
  static
  {
    AppMethodBeat.i(19405);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("HARDDEVICEINFO_TABLE".hashCode()), new ad.1());
    baseDBFactories.put(Integer.valueOf("HARDDEVICERANKINFO_TABLE".hashCode()), new ad.3());
    baseDBFactories.put(Integer.valueOf("HARDDEVICERANKFOLLOWINFO_TABLE".hashCode()), new ad.4());
    baseDBFactories.put(Integer.valueOf("HARDDEVICELIKEINFO_TABLE".hashCode()), new ad.5());
    baseDBFactories.put(Integer.valueOf("HARDDEVICECHAMPIONINFO_TABLE".hashCode()), new ad.6());
    baseDBFactories.put(Integer.valueOf("HARDDEVICERANKDETAILINFO_TABLE".hashCode()), new ad.7());
    AppMethodBeat.o(19405);
  }
  
  public ad()
  {
    AppMethodBeat.i(19386);
    this.lFZ = new ab();
    this.lGl = null;
    this.lGm = null;
    this.lGp = new ad.8(this);
    this.lGq = new ad.9(this);
    if (this.lGh == null) {
      this.lGh = new d();
    }
    if (this.lGg == null) {
      this.lGg = new e();
    }
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.exdevice.SubCoreExDevice", "create SubCoreExDevice.");
    com.tencent.mm.sdk.b.a.ymk.c(this.lGg.lDR);
    AppMethodBeat.o(19386);
  }
  
  public static com.tencent.mm.at.a.a.c Lx(String paramString)
  {
    AppMethodBeat.i(19392);
    if (bo.isNullOrNil(paramString))
    {
      com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.exdevice.SubCoreExDevice", "newImageOptions failed, url is null or nil, return default.");
      paramString = bpX();
      if (paramString.lGm == null)
      {
        c.a locala = new c.a();
        o.ahH();
        locala.eOd = null;
        locala.eNT = 640;
        locala.eNS = 640;
        locala.eNK = false;
        locala.eNM = true;
        paramString.lGm = locala.ahY();
      }
      paramString = bpX().lGm;
      AppMethodBeat.o(19392);
      return paramString;
    }
    paramString = new c.a();
    paramString.eNT = 640;
    paramString.eNS = 640;
    paramString.eNK = false;
    paramString.eNL = true;
    aw.aaz();
    paramString.eNP = com.tencent.mm.model.c.YK();
    paramString = paramString.ahY();
    AppMethodBeat.o(19392);
    return paramString;
  }
  
  private static ad bpX()
  {
    AppMethodBeat.i(19387);
    aw.aat();
    ad localad2 = (ad)bw.pF("plugin.exdevice");
    ad localad1 = localad2;
    if (localad2 == null)
    {
      com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.exdevice.SubCoreExDevice", "not found in MMCore, new one");
      localad1 = new ad();
      aw.aat().a("plugin.exdevice", localad1);
    }
    AppMethodBeat.o(19387);
    return localad1;
  }
  
  public static com.tencent.mm.plugin.exdevice.h.c bpY()
  {
    AppMethodBeat.i(19388);
    g.RJ().QQ();
    if (bpX().lGb == null)
    {
      localObject = bpX();
      aw.aaz();
      ((ad)localObject).lGb = new com.tencent.mm.plugin.exdevice.h.c(com.tencent.mm.model.c.Rq());
    }
    Object localObject = bpX().lGb;
    AppMethodBeat.o(19388);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.exdevice.f.b.b.d bpZ()
  {
    AppMethodBeat.i(19389);
    g.RJ().QQ();
    if (bpX().lGc == null)
    {
      localObject = bpX();
      aw.aaz();
      ((ad)localObject).lGc = new com.tencent.mm.plugin.exdevice.f.b.b.d(com.tencent.mm.model.c.Rq());
    }
    Object localObject = bpX().lGc;
    AppMethodBeat.o(19389);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.exdevice.f.b.b.a bqa()
  {
    AppMethodBeat.i(19390);
    g.RJ().QQ();
    if (bpX().lGd == null)
    {
      localObject = bpX();
      aw.aaz();
      ((ad)localObject).lGd = new com.tencent.mm.plugin.exdevice.f.b.b.a(com.tencent.mm.model.c.Rq());
    }
    Object localObject = bpX().lGd;
    AppMethodBeat.o(19390);
    return localObject;
  }
  
  public static com.tencent.mm.at.a.a bqb()
  {
    AppMethodBeat.i(19391);
    if (bpX().lGl == null) {
      bpX().lGl = o.ahG();
    }
    com.tencent.mm.at.a.a locala = bpX().lGl;
    AppMethodBeat.o(19391);
    return locala;
  }
  
  public static com.tencent.mm.plugin.exdevice.f.b.b.b bqc()
  {
    AppMethodBeat.i(19393);
    g.RJ().QQ();
    if (bpX().lGe == null)
    {
      localObject = bpX();
      aw.aaz();
      ((ad)localObject).lGe = new com.tencent.mm.plugin.exdevice.f.b.b.b(com.tencent.mm.model.c.Rq());
    }
    Object localObject = bpX().lGe;
    AppMethodBeat.o(19393);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.exdevice.f.b.b.e bqd()
  {
    AppMethodBeat.i(19394);
    g.RJ().QQ();
    if (bpX().lGf == null)
    {
      localObject = bpX();
      aw.aaz();
      ((ad)localObject).lGf = new com.tencent.mm.plugin.exdevice.f.b.b.e(com.tencent.mm.model.c.Rq());
    }
    Object localObject = bpX().lGf;
    AppMethodBeat.o(19394);
    return localObject;
  }
  
  public static b bqe()
  {
    AppMethodBeat.i(19395);
    g.RJ().QQ();
    if (bpX().lGa == null) {
      bpX().lGa = new b();
    }
    b localb = bpX().lGa;
    AppMethodBeat.o(19395);
    return localb;
  }
  
  public static d bqf()
  {
    AppMethodBeat.i(19396);
    if (bpX().lGh == null) {
      bpX().lGh = new d();
    }
    d locald = bpX().lGh;
    AppMethodBeat.o(19396);
    return locald;
  }
  
  public static com.tencent.mm.plugin.exdevice.f.b.c bqg()
  {
    AppMethodBeat.i(19397);
    if (bpX().lGi == null) {
      bpX().lGi = new com.tencent.mm.plugin.exdevice.f.b.c();
    }
    com.tencent.mm.plugin.exdevice.f.b.c localc = bpX().lGi;
    AppMethodBeat.o(19397);
    return localc;
  }
  
  public static com.tencent.mm.plugin.exdevice.f.b.a bqh()
  {
    AppMethodBeat.i(19398);
    if (bpX().lGj == null) {
      bpX().lGj = new com.tencent.mm.plugin.exdevice.f.b.a();
    }
    com.tencent.mm.plugin.exdevice.f.b.a locala = bpX().lGj;
    AppMethodBeat.o(19398);
    return locala;
  }
  
  public static com.tencent.mm.plugin.exdevice.f.a.c bqi()
  {
    AppMethodBeat.i(19399);
    if (bpX().lGk == null) {
      bpX().lGk = new com.tencent.mm.plugin.exdevice.f.a.c();
    }
    com.tencent.mm.plugin.exdevice.f.a.c localc = bpX().lGk;
    AppMethodBeat.o(19399);
    return localc;
  }
  
  public static e bqj()
  {
    AppMethodBeat.i(19400);
    if (bpX().lGg == null) {
      bpX().lGg = new e();
    }
    e locale = bpX().lGg;
    AppMethodBeat.o(19400);
    return locale;
  }
  
  public static h bqk()
  {
    AppMethodBeat.i(19403);
    if (bpX().lGo == null) {
      bpX().lGo = new h();
    }
    h localh = bpX().lGo;
    AppMethodBeat.o(19403);
    return localh;
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.d> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(19401);
    aw.aaz();
    com.tencent.mm.model.c.YA().a(this.lGq);
    Object localObject = k.bpz();
    aw.Rc().a(538, (com.tencent.mm.ai.f)localObject);
    this.lGn = new af();
    com.tencent.mm.sdk.b.a.ymk.c(this.lFZ);
    aw.getSysCmdMsgExtension().a("wcdevicemsg", this.lGp, true);
    com.tencent.mm.sdk.b.a.ymk.c(bqj().lDs);
    com.tencent.mm.sdk.b.a.ymk.c(bqj().lDt);
    com.tencent.mm.sdk.b.a.ymk.c(bqj().lDu);
    com.tencent.mm.sdk.b.a.ymk.c(bqj().lDN);
    com.tencent.mm.sdk.b.a.ymk.c(bqj().lDr);
    com.tencent.mm.sdk.b.a.ymk.c(bqj().lDq);
    com.tencent.mm.sdk.b.a.ymk.c(bqj().lDv);
    com.tencent.mm.sdk.b.a.ymk.c(bqj().lDw);
    com.tencent.mm.sdk.b.a.ymk.c(bqj().lDx);
    com.tencent.mm.sdk.b.a.ymk.c(bqj().lDO);
    com.tencent.mm.sdk.b.a.ymk.c(bqj().lDy);
    com.tencent.mm.sdk.b.a.ymk.c(bqj().lDz);
    com.tencent.mm.sdk.b.a.ymk.c(bqj().lDA);
    com.tencent.mm.sdk.b.a.ymk.c(bqj().lDC);
    com.tencent.mm.sdk.b.a.ymk.c(bqj().lDB);
    com.tencent.mm.sdk.b.a.ymk.c(bqj().lDG);
    com.tencent.mm.sdk.b.a.ymk.c(bqj().lDE);
    com.tencent.mm.sdk.b.a.ymk.c(bqj().lDF);
    com.tencent.mm.sdk.b.a.ymk.c(bqj().lDH);
    com.tencent.mm.sdk.b.a.ymk.c(bqj().lDP);
    com.tencent.mm.sdk.b.a.ymk.c(bqj().jLe);
    com.tencent.mm.sdk.b.a.ymk.c(bqj().lDD);
    com.tencent.mm.sdk.b.a.ymk.c(bqj().lDI);
    com.tencent.mm.sdk.b.a.ymk.c(bqj().lDJ);
    com.tencent.mm.sdk.b.a.ymk.c(bqj().lDK);
    com.tencent.mm.sdk.b.a.ymk.c(bqj().lDL);
    com.tencent.mm.sdk.b.a.ymk.c(bqj().lDY);
    com.tencent.mm.sdk.b.a.ymk.c(bqj().lDZ);
    com.tencent.mm.sdk.b.a.ymk.c(bqj().lEa);
    com.tencent.mm.sdk.b.a.ymk.c(bqj().lEc);
    com.tencent.mm.sdk.b.a.ymk.c(bqj().lEb);
    com.tencent.mm.sdk.b.a.ymk.c(bqj().lDS);
    com.tencent.mm.sdk.b.a.ymk.c(bqj().lDT);
    com.tencent.mm.sdk.b.a.ymk.c(bqj().lDU);
    com.tencent.mm.sdk.b.a.ymk.c(bqj().lDV);
    com.tencent.mm.sdk.b.a.ymk.c(bqj().lDW);
    com.tencent.mm.sdk.b.a.ymk.c(bqj().lDX);
    com.tencent.mm.sdk.b.a.ymk.c(bqj().lDQ);
    com.tencent.mm.sdk.b.a.ymk.c(bqj().lDR);
    localObject = i.lFf;
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.exdevice.GetBoundDeviceLogic", "addSceneEndListener");
    aw.Rc().a(539, (com.tencent.mm.ai.f)localObject);
    com.tencent.mm.compatible.a.a.a(19, new a.a()
    {
      public final void run()
      {
        AppMethodBeat.i(19385);
        ad.a(ad.this);
        AppMethodBeat.o(19385);
      }
    });
    AppMethodBeat.o(19401);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(19402);
    aw.aaz();
    com.tencent.mm.model.c.YA().b(this.lGq);
    com.tencent.mm.sdk.b.a.ymk.d(bqj().lDs);
    com.tencent.mm.sdk.b.a.ymk.d(bqj().lDt);
    com.tencent.mm.sdk.b.a.ymk.d(bqj().lDu);
    com.tencent.mm.sdk.b.a.ymk.d(bqj().lDN);
    com.tencent.mm.sdk.b.a.ymk.d(bqj().lDP);
    com.tencent.mm.sdk.b.a.ymk.d(bqj().lDr);
    com.tencent.mm.sdk.b.a.ymk.d(bqj().lDq);
    com.tencent.mm.sdk.b.a.ymk.d(bqj().lDv);
    com.tencent.mm.sdk.b.a.ymk.d(bqj().lDw);
    com.tencent.mm.sdk.b.a.ymk.d(bqj().lDx);
    com.tencent.mm.sdk.b.a.ymk.d(bqj().lDO);
    com.tencent.mm.sdk.b.a.ymk.d(bqj().lDY);
    com.tencent.mm.sdk.b.a.ymk.d(bqj().lDZ);
    com.tencent.mm.sdk.b.a.ymk.d(bqj().lEa);
    com.tencent.mm.sdk.b.a.ymk.d(bqj().lEc);
    com.tencent.mm.sdk.b.a.ymk.d(bqj().lEb);
    com.tencent.mm.sdk.b.a.ymk.d(bqj().lDS);
    com.tencent.mm.sdk.b.a.ymk.d(bqj().lDT);
    com.tencent.mm.sdk.b.a.ymk.d(bqj().lDU);
    com.tencent.mm.sdk.b.a.ymk.d(bqj().lDV);
    com.tencent.mm.sdk.b.a.ymk.d(bqj().lDW);
    com.tencent.mm.sdk.b.a.ymk.d(bqj().lDX);
    com.tencent.mm.sdk.b.a.ymk.d(bqj().lDz);
    com.tencent.mm.sdk.b.a.ymk.d(bqj().lDQ);
    com.tencent.mm.sdk.b.a.ymk.d(bqj().lDR);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "releaseAllSharePreferences");
    Object localObject1 = ah.getContext().getSharedPreferences("exdevice_pref", 0);
    if (localObject1 == null)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == sp");
      localObject1 = u.bqz();
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.exdevice.ExdeviceInfoManager", "delAllDeviceAuthFlag");
      if (((com.tencent.mm.plugin.exdevice.service.f)localObject1).lIA != null) {
        break label601;
      }
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.exdevice.ExdeviceInfoManager", "null == exdeviceInfoList");
    }
    for (;;)
    {
      localObject1 = k.bpz();
      aw.Rc().b(538, (com.tencent.mm.ai.f)localObject1);
      k.lCB = null;
      com.tencent.mm.sdk.b.a.ymk.d(this.lFZ);
      aw.getSysCmdMsgExtension().b("wcdevicemsg", this.lGp, true);
      com.tencent.mm.sdk.b.a.ymk.d(bqj().lDy);
      if (bpX().lGa != null) {
        bpX();
      }
      localObject1 = i.lFf;
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.exdevice.GetBoundDeviceLogic", "removeSceneEndListener");
      aw.Rc().b(539, (com.tencent.mm.ai.f)localObject1);
      localObject1 = bpX().lGh;
      if ((((d)localObject1).lCX == null) || (((d)localObject1).lCX.isEmpty())) {
        break label666;
      }
      Object localObject2 = ((d)localObject1).lCX.entrySet().iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((ap)((Map.Entry)((Iterator)localObject2).next()).getValue()).stopTimer();
      }
      if (((SharedPreferences)localObject1).edit().clear().commit()) {
        break;
      }
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "sp.edit().clear().commit() Failed!!!");
      break;
      label601:
      localObject1 = ((com.tencent.mm.plugin.exdevice.service.f)localObject1).lIA.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        f.a locala = (f.a)((Map.Entry)localObject2).getValue();
        locala.lIE = false;
        ((Map.Entry)localObject2).setValue(locala);
      }
    }
    ((d)localObject1).lCX.clear();
    label666:
    if (bpX().lGi != null)
    {
      localObject1 = bpX().lGi;
      aw.Rc().b(1042, (com.tencent.mm.ai.f)localObject1);
      aw.Rc().b(1041, (com.tencent.mm.ai.f)localObject1);
      aw.Rc().b(1043, (com.tencent.mm.ai.f)localObject1);
      aw.Rc().b(1040, (com.tencent.mm.ai.f)localObject1);
    }
    if (bpX().lGl != null) {
      bpX().lGl.detach();
    }
    localObject1 = this.lGn;
    com.tencent.mm.sdk.b.a.ymk.d(((af)localObject1).dZC);
    AppMethodBeat.o(19402);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.ad
 * JD-Core Version:    0.7.0.1
 */
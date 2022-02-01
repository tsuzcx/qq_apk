package com.tencent.mm.plugin.ipcall.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.c;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.abk;
import com.tencent.mm.autogen.a.ms;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.ci;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.cl.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.ipcall.model.g.i;
import com.tencent.mm.plugin.ipcall.model.h.j;
import com.tencent.mm.plugin.ipcall.model.h.l;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Map;

public final class h
  implements be
{
  private static HashMap<Integer, h.b> JGI;
  private static h JGt;
  private com.tencent.mm.plugin.ipcall.model.h.d JGA;
  private l JGB;
  private j JGC;
  private com.tencent.mm.plugin.ipcall.model.h.h JGD;
  private com.tencent.mm.plugin.voip.video.c JGE;
  private IListener JGF;
  private IListener JGG;
  private IListener JGH;
  private cl.a JGJ;
  private cl.a JGK;
  private cl.a JGL;
  private g JGu;
  private com.tencent.mm.plugin.ipcall.model.d.a JGv;
  private com.tencent.mm.plugin.ipcall.model.d.b JGw;
  public com.tencent.mm.plugin.ipcall.model.c.b JGx;
  private f JGy;
  private com.tencent.mm.plugin.ipcall.c JGz;
  private com.tencent.mm.plugin.voip.video.e nky;
  
  static
  {
    AppMethodBeat.i(25405);
    JGt = null;
    HashMap localHashMap = new HashMap();
    JGI = localHashMap;
    localHashMap.put(Integer.valueOf("IPCallAddressItem".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.ipcall.model.h.d.SQL_CREATE;
      }
    });
    JGI.put(Integer.valueOf("IPCallRecord".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return l.SQL_CREATE;
      }
    });
    JGI.put(Integer.valueOf("IPCallPopularCountry".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return j.SQL_CREATE;
      }
    });
    JGI.put(Integer.valueOf("IPCallMsg".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.ipcall.model.h.h.SQL_CREATE;
      }
    });
    AppMethodBeat.o(25405);
  }
  
  public h()
  {
    AppMethodBeat.i(25389);
    this.JGu = new g();
    this.JGv = new com.tencent.mm.plugin.ipcall.model.d.a();
    this.JGw = new com.tencent.mm.plugin.ipcall.model.d.b();
    this.JGy = new f();
    this.JGz = new com.tencent.mm.plugin.ipcall.c();
    this.JGF = new SubCoreIPCall.1(this, com.tencent.mm.app.f.hfK);
    this.JGG = new SubCoreIPCall.2(this, com.tencent.mm.app.f.hfK);
    this.JGH = new SubCoreIPCall.3(this, com.tencent.mm.app.f.hfK);
    this.JGJ = new cl.a()
    {
      public final void a(g.a paramAnonymousa)
      {
        AppMethodBeat.i(303689);
        Log.i("MicroMsg.SubCoreIPCall", "WeChatOut onRecieveMsg");
        paramAnonymousa = w.a(paramAnonymousa.mpN.YFG);
        if ((paramAnonymousa == null) || (paramAnonymousa.length() == 0))
        {
          Log.e("MicroMsg.SubCoreIPCall", "WeChatOut onReceiveMsg, msgContent is null");
          AppMethodBeat.o(303689);
          return;
        }
        Object localObject = XmlParser.parseXml(paramAnonymousa, "sysmsg", null);
        if (localObject == null)
        {
          Log.e("MicroMsg.SubCoreIPCall", "WeChatOut onReceiveMsg, values is null");
          AppMethodBeat.o(303689);
          return;
        }
        int i;
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.AccountRedDotType"))
        {
          i = Util.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.AccountRedDotType"), -1);
          Log.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountRedDotType: %d", new Object[] { Integer.valueOf(i) });
          bh.bCz();
          com.tencent.mm.model.c.ban().set(at.a.acKC, Integer.valueOf(i));
        }
        for (;;)
        {
          int j;
          if (((Map)localObject).containsKey(".sysmsg.WeChatOut.AcctRD"))
          {
            j = Util.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.AcctRD"), 0);
            Log.i("MicroMsg.SubCoreIPCall", "WeChatOut AcctRD: %d", new Object[] { Integer.valueOf(j) });
            if (j != 0)
            {
              bh.bCz();
              com.tencent.mm.model.c.ban().set(at.a.acKB, Boolean.TRUE);
              com.tencent.mm.plugin.report.service.h.OAn.b(13254, new Object[] { Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(-1), Integer.valueOf(-1) });
            }
          }
          else
          {
            if (((Map)localObject).containsKey(".sysmsg.WeChatOut.TabRD"))
            {
              i = Util.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.TabRD"), 0);
              Log.i("MicroMsg.SubCoreIPCall", "WeChatOut TabRD: %d", new Object[] { Integer.valueOf(i) });
              if (i == 0) {
                break label1276;
              }
              bh.bCz();
              com.tencent.mm.model.c.ban().set(at.a.acKO, Boolean.TRUE);
              com.tencent.mm.plugin.report.service.h.OAn.b(13254, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1) });
            }
            label384:
            if (((Map)localObject).containsKey(".sysmsg.WeChatOut.RechargeRD"))
            {
              i = Util.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.RechargeRD"), 0);
              Log.i("MicroMsg.SubCoreIPCall", "WeChatOut RechargeRD: %d", new Object[] { Integer.valueOf(i) });
              if (i == 0) {
                break label1295;
              }
              bh.bCz();
              com.tencent.mm.model.c.ban().set(at.a.acKI, Boolean.TRUE);
              com.tencent.mm.plugin.report.service.h.OAn.b(13254, new Object[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1) });
            }
            label507:
            String str;
            if (((Map)localObject).containsKey(".sysmsg.WeChatOut.RechargeWording"))
            {
              str = (String)((Map)localObject).get(".sysmsg.WeChatOut.RechargeWording");
              Log.i("MicroMsg.SubCoreIPCall", "WeChatOut RechargeWording: %s", new Object[] { str });
              bh.bCz();
              com.tencent.mm.model.c.ban().set(at.a.acKH, str);
            }
            if (((Map)localObject).containsKey(".sysmsg.WeChatOut.PackagePurchaseWording"))
            {
              str = (String)((Map)localObject).get(".sysmsg.WeChatOut.PackagePurchaseWording");
              Log.i("MicroMsg.SubCoreIPCall", "WeChatOut PackagePurchaseWording: %s", new Object[] { str });
              bh.bCz();
              com.tencent.mm.model.c.ban().set(at.a.acKJ, str);
            }
            if (((Map)localObject).containsKey(".sysmsg.WeChatOut.AccountWording"))
            {
              str = (String)((Map)localObject).get(".sysmsg.WeChatOut.AccountWording");
              Log.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountWording: %s", new Object[] { str });
              bh.bCz();
              com.tencent.mm.model.c.ban().set(at.a.acKD, str);
            }
            if (((Map)localObject).containsKey(".sysmsg.WeChatOut.RechargeWordingVersion"))
            {
              i = Util.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.RechargeWordingVersion"), 0);
              Log.i("MicroMsg.SubCoreIPCall", "WeChatOut RechargeWordingVersion: %d", new Object[] { Integer.valueOf(i) });
              bh.bCz();
              com.tencent.mm.model.c.ban().set(at.a.acKS, Integer.valueOf(i));
            }
            if (((Map)localObject).containsKey(".sysmsg.WeChatOut.TabWording"))
            {
              str = (String)((Map)localObject).get(".sysmsg.WeChatOut.TabWording");
              Log.i("MicroMsg.SubCoreIPCall", "WeChatOut TabWording: %s", new Object[] { str });
              bh.bCz();
              com.tencent.mm.model.c.ban().set(at.a.acKN, str);
            }
            if (((Map)localObject).containsKey(".sysmsg.WeChatOut.AccountActivityWording"))
            {
              str = (String)((Map)localObject).get(".sysmsg.WeChatOut.AccountActivityWording");
              Log.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountActivityWording: %s", new Object[] { str });
              bh.bCz();
              com.tencent.mm.model.c.ban().set(at.a.acKE, str);
            }
            if (((Map)localObject).containsKey(".sysmsg.WeChatOut.AccountActivityWordingClearType"))
            {
              i = Util.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.AccountActivityWordingClearType"), 0);
              Log.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountActivityWordingClearType : %d", new Object[] { Integer.valueOf(i) });
              bh.bCz();
              com.tencent.mm.model.c.ban().set(at.a.acKF, Integer.valueOf(i));
            }
            if (((Map)localObject).containsKey(".sysmsg.WeChatOut.AccountActivityWordingVersion"))
            {
              i = Util.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.AccountActivityWordingVersion"), 0);
              Log.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountActivityWordingVersion: %d", new Object[] { Integer.valueOf(i) });
              bh.bCz();
              com.tencent.mm.model.c.ban().set(at.a.acKG, Integer.valueOf(i));
            }
            if (((Map)localObject).containsKey(".sysmsg.WeChatOut.TabRedDotType"))
            {
              i = Util.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.TabRedDotType"), 0);
              Log.i("MicroMsg.SubCoreIPCall", "WeChatOut TabRedDotType: %d", new Object[] { Integer.valueOf(i) });
              com.tencent.mm.plugin.report.service.h.OAn.b(13254, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(i) });
              bh.bCz();
              com.tencent.mm.model.c.ban().set(at.a.acKP, Integer.valueOf(i));
            }
            i = paramAnonymousa.indexOf("<ActivityInfo>");
            j = paramAnonymousa.indexOf("</ActivityInfo>");
            if ((i > 0) && (j > 0) && (j > i))
            {
              paramAnonymousa = paramAnonymousa.substring(i, j + 15);
              Log.i("MicroMsg.SubCoreIPCall", "WeChatOut ActivityInfo: %s", new Object[] { paramAnonymousa });
              localObject = com.tencent.mm.plugin.ipcall.model.h.a.aIU(paramAnonymousa);
              if ((localObject == null) || (!Util.isNullOrNil(((com.tencent.mm.plugin.ipcall.model.h.a)localObject).hAP)) || (!Util.isNullOrNil(((com.tencent.mm.plugin.ipcall.model.h.a)localObject).IGG))) {
                break label1314;
              }
              Log.i("MicroMsg.SubCoreIPCall", "clear activity");
              bh.bCz();
              com.tencent.mm.model.c.ban().set(at.a.acLb, Boolean.FALSE);
              bh.bCz();
              com.tencent.mm.model.c.ban().set(at.a.acLc, "");
            }
          }
          for (;;)
          {
            new ms().publish();
            new abk().publish();
            AppMethodBeat.o(303689);
            return;
            bh.bCz();
            com.tencent.mm.model.c.ban().set(at.a.acKB, Boolean.FALSE);
            break;
            label1276:
            bh.bCz();
            com.tencent.mm.model.c.ban().set(at.a.acKO, Boolean.FALSE);
            break label384;
            label1295:
            bh.bCz();
            com.tencent.mm.model.c.ban().set(at.a.acKI, Boolean.FALSE);
            break label507;
            label1314:
            if (localObject != null)
            {
              if (!Util.isNullOrNil(((com.tencent.mm.plugin.ipcall.model.h.a)localObject).JJP)) {
                r.bJZ().a(((com.tencent.mm.plugin.ipcall.model.h.a)localObject).JJP, true, null);
              }
              bh.bCz();
              com.tencent.mm.model.c.ban().set(at.a.acLb, Boolean.TRUE);
              bh.bCz();
              com.tencent.mm.model.c.ban().set(at.a.acLc, paramAnonymousa);
            }
          }
          i = -1;
        }
      }
      
      public final void a(g.c paramAnonymousc) {}
    };
    this.JGK = new h.7(this);
    this.JGL = new h.1(this);
    AppMethodBeat.o(25389);
  }
  
  public static com.tencent.mm.plugin.voip.video.e fRA()
  {
    AppMethodBeat.i(25401);
    if (fRo().nky == null) {
      fRo().nky = new com.tencent.mm.plugin.voip.video.e(MMApplicationContext.getContext());
    }
    com.tencent.mm.plugin.voip.video.e locale = fRo().nky;
    AppMethodBeat.o(25401);
    return locale;
  }
  
  public static com.tencent.mm.plugin.voip.video.c fRB()
  {
    AppMethodBeat.i(25402);
    if (fRo().JGE == null) {
      fRo().JGE = new com.tencent.mm.plugin.voip.video.c(MMApplicationContext.getContext());
    }
    com.tencent.mm.plugin.voip.video.c localc = fRo().JGE;
    AppMethodBeat.o(25402);
    return localc;
  }
  
  public static h fRo()
  {
    AppMethodBeat.i(25390);
    if (JGt == null)
    {
      JGt = new h();
      bh.bCt().a("plugin.ipcall", JGt);
    }
    h localh = JGt;
    AppMethodBeat.o(25390);
    return localh;
  }
  
  public static g fRq()
  {
    AppMethodBeat.i(25391);
    g localg = fRo().JGu;
    AppMethodBeat.o(25391);
    return localg;
  }
  
  public static com.tencent.mm.plugin.ipcall.model.d.a fRr()
  {
    AppMethodBeat.i(25392);
    com.tencent.mm.plugin.ipcall.model.d.a locala = fRo().JGv;
    AppMethodBeat.o(25392);
    return locala;
  }
  
  public static com.tencent.mm.plugin.ipcall.model.d.b fRs()
  {
    AppMethodBeat.i(25393);
    com.tencent.mm.plugin.ipcall.model.d.b localb = fRo().JGw;
    AppMethodBeat.o(25393);
    return localb;
  }
  
  public static com.tencent.mm.plugin.ipcall.model.c.b fRt()
  {
    AppMethodBeat.i(25394);
    com.tencent.mm.plugin.ipcall.model.c.b localb = fRo().JGx;
    AppMethodBeat.o(25394);
    return localb;
  }
  
  public static f fRu()
  {
    AppMethodBeat.i(25395);
    f localf = fRo().JGy;
    AppMethodBeat.o(25395);
    return localf;
  }
  
  public static com.tencent.mm.plugin.ipcall.c fRv()
  {
    AppMethodBeat.i(25396);
    com.tencent.mm.plugin.ipcall.c localc = fRo().JGz;
    AppMethodBeat.o(25396);
    return localc;
  }
  
  public static com.tencent.mm.plugin.ipcall.model.h.d fRw()
  {
    AppMethodBeat.i(25397);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (fRo().JGA == null)
    {
      localObject = fRo();
      bh.bCz();
      ((h)localObject).JGA = new com.tencent.mm.plugin.ipcall.model.h.d(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = fRo().JGA;
    AppMethodBeat.o(25397);
    return localObject;
  }
  
  public static l fRx()
  {
    AppMethodBeat.i(25398);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (fRo().JGB == null)
    {
      localObject = fRo();
      bh.bCz();
      ((h)localObject).JGB = new l(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = fRo().JGB;
    AppMethodBeat.o(25398);
    return localObject;
  }
  
  public static j fRy()
  {
    AppMethodBeat.i(25399);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (fRo().JGC == null)
    {
      localObject = fRo();
      bh.bCz();
      ((h)localObject).JGC = new j(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = fRo().JGC;
    AppMethodBeat.o(25399);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.ipcall.model.h.h fRz()
  {
    AppMethodBeat.i(25400);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (fRo().JGD == null)
    {
      localObject = fRo();
      bh.bCz();
      ((h)localObject).JGD = new com.tencent.mm.plugin.ipcall.model.h.h(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = fRo().JGD;
    AppMethodBeat.o(25400);
    return localObject;
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final void fRp()
  {
    AppMethodBeat.i(303699);
    this.JGx = new com.tencent.mm.plugin.ipcall.model.c.b();
    AppMethodBeat.o(303699);
  }
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return JGI;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(25403);
    g localg = this.JGu;
    localg.JGf.init();
    localg.JGg.init();
    localg.JGh.init();
    localg.JGi.init();
    localg.JGj.init();
    localg.JGk.init();
    localg.JGl.init();
    localg.JGm.init();
    localg.JGf.a(localg);
    localg.JGh.a(localg);
    localg.JGi.a(localg);
    localg.JGk.a(localg);
    localg.JGm.a(localg);
    localg.JGg.JGT = localg;
    localg.JGj.JGT = localg;
    bh.a(localg.JGq);
    b.init();
    d.fRf().JFS.alive();
    e.fRi().pWI.alive();
    bh.getSysCmdMsgExtension().a("WeChatOut", this.JGJ, true);
    bh.getSysCmdMsgExtension().a("WeChatOutMsg", this.JGK, true);
    bh.getSysCmdMsgExtension().a("WCONotify", this.JGL, true);
    this.JGF.alive();
    this.JGG.alive();
    this.JGH.alive();
    AppMethodBeat.o(25403);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(25404);
    if (this.JGy.fRj()) {
      this.JGz.jx(0, 0);
    }
    Object localObject = this.JGu;
    ((g)localObject).JGf.destroy();
    ((g)localObject).JGg.destroy();
    ((g)localObject).JGh.destroy();
    ((g)localObject).JGi.destroy();
    ((g)localObject).JGj.destroy();
    ((g)localObject).JGl.destroy();
    bh.b(((g)localObject).JGq);
    b.release();
    localObject = d.fRf();
    bh.aZW().b(159, (com.tencent.mm.am.h)localObject);
    bh.aZW().b(160, (com.tencent.mm.am.h)localObject);
    ((d)localObject).JFS.dead();
    e.fRi().pWI.dead();
    bh.getSysCmdMsgExtension().b("WeChatOut", this.JGJ, true);
    bh.getSysCmdMsgExtension().b("WeChatOutMsg", this.JGK, true);
    bh.getSysCmdMsgExtension().b("WCONotify", this.JGL, true);
    this.JGF.dead();
    this.JGG.dead();
    this.JGH.dead();
    AppMethodBeat.o(25404);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.h
 * JD-Core Version:    0.7.0.1
 */
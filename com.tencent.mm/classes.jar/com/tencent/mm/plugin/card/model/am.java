package com.tencent.mm.plugin.card.model;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jg;
import com.tencent.mm.g.a.jg.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.card.PluginCard;
import com.tencent.mm.plugin.card.b.n;
import com.tencent.mm.plugin.card.model.a.e.a;
import com.tencent.mm.plugin.card.ui.CardHomePageUI;
import com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI;
import com.tencent.mm.plugin.card.ui.v3.CardHomePageV3UI;
import com.tencent.mm.protocal.protobuf.rc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storagebase.h.b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class am
  implements aw
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private ap mHandler;
  private com.tencent.mm.plugin.card.b.b ntY;
  private c ntZ;
  private al nua;
  private h nub;
  private com.tencent.mm.plugin.card.b.m nuc;
  private com.tencent.mm.plugin.card.sharecard.a.a nud;
  private com.tencent.mm.plugin.card.sharecard.model.k nue;
  private com.tencent.mm.plugin.card.sharecard.model.o nuf;
  private com.tencent.mm.plugin.card.sharecard.a.c nug;
  private com.tencent.mm.plugin.card.b.k nuh;
  private com.tencent.mm.plugin.card.b.e nui;
  private com.tencent.mm.plugin.card.b.l nuj;
  private com.tencent.mm.plugin.card.b.d nuk;
  private com.tencent.mm.plugin.card.b.j nul;
  private com.tencent.mm.plugin.card.b.c num;
  private com.tencent.mm.plugin.card.b.g nun;
  private l nuo;
  private j nup;
  private com.tencent.mm.sdk.b.c nuq;
  private com.tencent.mm.sdk.b.c nur;
  private com.tencent.mm.sdk.b.c nus;
  private com.tencent.mm.plugin.card.ui.b nut;
  private com.tencent.mm.sdk.b.c nuu;
  private com.tencent.mm.sdk.b.c nuv;
  private cc.a nuw;
  private cc.a nux;
  private com.tencent.mm.sdk.b.c<jg> nuy;
  
  static
  {
    AppMethodBeat.i(112903);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("USERCARDINFO_TABLE".hashCode()), new am.8());
    baseDBFactories.put(Integer.valueOf("PENDINGCARDIDINFO_TABLE".hashCode()), new am.9());
    baseDBFactories.put(Integer.valueOf("CARDMSGINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return h.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("SHARECARDINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.card.sharecard.model.k.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("SHARECARDSYNCITEMINFO_TABLE".hashCode()), new am.12());
    baseDBFactories.put(Integer.valueOf("CARDQRCODECONFI_TABLE".hashCode()), new am.2());
    baseDBFactories.put(Integer.valueOf("CARDQRCODEDATAINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return l.SQL_CREATE;
      }
    });
    AppMethodBeat.o(112903);
  }
  
  public am()
  {
    AppMethodBeat.i(112881);
    this.nuh = null;
    this.nui = null;
    this.nuj = null;
    this.nuk = null;
    this.nul = null;
    this.mHandler = new ap(Looper.getMainLooper());
    this.nuq = new n();
    this.nur = new com.tencent.mm.plugin.card.b.o();
    this.nus = new com.tencent.mm.plugin.card.b.a();
    this.nut = new com.tencent.mm.plugin.card.ui.b();
    this.nuu = new am.1(this);
    this.nuv = new am.5(this);
    this.nuw = new am.6(this);
    this.nux = new am.7(this);
    this.nuy = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(jg paramAnonymousjg)
      {
        AppMethodBeat.i(112874);
        int i = ((Integer)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fux, Integer.valueOf(1))).intValue();
        int j = ((Integer)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FuA, Integer.valueOf(1))).intValue();
        boolean bool = ((Boolean)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FuC, Boolean.FALSE)).booleanValue();
        ad.i("MicroMsg.SubCoreCard", "goto card version: %s, trade area: %s, newVersion2: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool) });
        Object localObject;
        Context localContext;
        if (bool) {
          if (paramAnonymousjg.dnt.context != null)
          {
            localObject = new Intent(paramAnonymousjg.dnt.context, CardHomePageV3UI.class);
            localContext = paramAnonymousjg.dnt.context;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/card/model/SubCoreCard$12", "callback", "(Lcom/tencent/mm/autogen/events/GotoCardHomePageEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/card/model/SubCoreCard$12", "callback", "(Lcom/tencent/mm/autogen/events/GotoCardHomePageEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.plugin.card.b.k.bIK();
            if (paramAnonymousjg.dnt.enterScene == 1) {
              com.tencent.mm.plugin.report.service.h.vKh.f(16322, new Object[] { Integer.valueOf(3) });
            }
          }
        }
        for (;;)
        {
          paramAnonymousjg = com.tencent.mm.plugin.card.model.a.e.nuM;
          e.a.bJr();
          AppMethodBeat.o(112874);
          return true;
          if (j == 2)
          {
            paramAnonymousjg = (String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FuB, "");
            if (!bt.isNullOrNil(paramAnonymousjg)) {
              try
              {
                paramAnonymousjg = (rc)new rc().parseFrom(paramAnonymousjg.getBytes(d.n.d.ISO_8859_1));
                com.tencent.mm.plugin.card.d.b.G(paramAnonymousjg.zHs, paramAnonymousjg.zHt, paramAnonymousjg.Aoy);
              }
              catch (IOException paramAnonymousjg)
              {
                ad.printErrStackTrace("MicroMsg.SubCoreCard", paramAnonymousjg, "", new Object[0]);
              }
            }
          }
          else if (i == 1)
          {
            if (paramAnonymousjg.dnt.context != null)
            {
              localObject = new Intent(paramAnonymousjg.dnt.context, CardHomePageNewUI.class);
              localContext = paramAnonymousjg.dnt.context;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/card/model/SubCoreCard$12", "callback", "(Lcom/tencent/mm/autogen/events/GotoCardHomePageEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
              com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/card/model/SubCoreCard$12", "callback", "(Lcom/tencent/mm/autogen/events/GotoCardHomePageEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              com.tencent.mm.plugin.card.b.k.bIK();
              if (paramAnonymousjg.dnt.enterScene == 1) {
                com.tencent.mm.plugin.report.service.h.vKh.f(16322, new Object[] { Integer.valueOf(3) });
              }
            }
          }
          else
          {
            if (paramAnonymousjg.dnt.context != null)
            {
              localObject = new Intent(paramAnonymousjg.dnt.context, CardHomePageUI.class);
              ((Intent)localObject).putExtra("key_from_scene", 22);
              ((Intent)localObject).putExtra("key_home_page_from_scene", paramAnonymousjg.dnt.scene);
              localContext = paramAnonymousjg.dnt.context;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/card/model/SubCoreCard$12", "callback", "(Lcom/tencent/mm/autogen/events/GotoCardHomePageEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
              com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/card/model/SubCoreCard$12", "callback", "(Lcom/tencent/mm/autogen/events/GotoCardHomePageEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              com.tencent.mm.plugin.card.b.k.bIK();
              if (paramAnonymousjg.dnt.enterScene == 1) {
                com.tencent.mm.plugin.report.service.h.vKh.f(16322, new Object[] { Integer.valueOf(2) });
              }
            }
            paramAnonymousjg.dnu.targetActivity = "com.tencent.mm.plugin.card.ui.CardHomePageUI";
          }
        }
      }
    };
    com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(m.ntl);
    if (!locale.exists()) {
      locale.mkdirs();
    }
    locale = new com.tencent.mm.vfs.e(m.ntm);
    if (!locale.exists()) {
      locale.mkdirs();
    }
    AppMethodBeat.o(112881);
  }
  
  public static com.tencent.mm.plugin.card.b.b bIU()
  {
    AppMethodBeat.i(112885);
    com.tencent.mm.kernel.g.afz().aeD();
    if (getCore().ntY == null) {
      getCore().ntY = new com.tencent.mm.plugin.card.b.b();
    }
    com.tencent.mm.plugin.card.b.b localb = getCore().ntY;
    AppMethodBeat.o(112885);
    return localb;
  }
  
  public static c bIV()
  {
    AppMethodBeat.i(112886);
    com.tencent.mm.kernel.g.afz().aeD();
    if (getCore().ntZ == null) {
      getCore().ntZ = new c(com.tencent.mm.kernel.g.afB().gda);
    }
    c localc = getCore().ntZ;
    AppMethodBeat.o(112886);
    return localc;
  }
  
  public static al bIW()
  {
    AppMethodBeat.i(112887);
    com.tencent.mm.kernel.g.afz().aeD();
    if (getCore().nua == null) {
      getCore().nua = new al(com.tencent.mm.kernel.g.afB().gda);
    }
    al localal = getCore().nua;
    AppMethodBeat.o(112887);
    return localal;
  }
  
  public static h bIX()
  {
    AppMethodBeat.i(112888);
    com.tencent.mm.kernel.g.afz().aeD();
    if (getCore().nub == null) {
      getCore().nub = new h(com.tencent.mm.kernel.g.afB().gda);
    }
    h localh = getCore().nub;
    AppMethodBeat.o(112888);
    return localh;
  }
  
  public static com.tencent.mm.plugin.card.b.m bIY()
  {
    AppMethodBeat.i(112889);
    com.tencent.mm.kernel.g.afz().aeD();
    if (getCore().nuc == null) {
      getCore().nuc = new com.tencent.mm.plugin.card.b.m();
    }
    com.tencent.mm.plugin.card.b.m localm = getCore().nuc;
    AppMethodBeat.o(112889);
    return localm;
  }
  
  public static com.tencent.mm.plugin.card.b.k bIZ()
  {
    AppMethodBeat.i(112890);
    com.tencent.mm.kernel.g.afz().aeD();
    if (getCore().nuh == null) {
      getCore().nuh = new com.tencent.mm.plugin.card.b.k();
    }
    com.tencent.mm.plugin.card.b.k localk = getCore().nuh;
    AppMethodBeat.o(112890);
    return localk;
  }
  
  public static com.tencent.mm.plugin.card.b.e bJa()
  {
    AppMethodBeat.i(112891);
    com.tencent.mm.kernel.g.afz().aeD();
    if (getCore().nui == null) {
      getCore().nui = new com.tencent.mm.plugin.card.b.e();
    }
    com.tencent.mm.plugin.card.b.e locale = getCore().nui;
    AppMethodBeat.o(112891);
    return locale;
  }
  
  public static com.tencent.mm.plugin.card.b.l bJb()
  {
    AppMethodBeat.i(112892);
    com.tencent.mm.kernel.g.afz().aeD();
    if (getCore().nuj == null) {
      getCore().nuj = new com.tencent.mm.plugin.card.b.l();
    }
    com.tencent.mm.plugin.card.b.l locall = getCore().nuj;
    AppMethodBeat.o(112892);
    return locall;
  }
  
  public static com.tencent.mm.plugin.card.sharecard.a.a bJc()
  {
    AppMethodBeat.i(112893);
    com.tencent.mm.kernel.g.afz().aeD();
    if (getCore().nud == null) {
      getCore().nud = new com.tencent.mm.plugin.card.sharecard.a.a();
    }
    com.tencent.mm.plugin.card.sharecard.a.a locala = getCore().nud;
    AppMethodBeat.o(112893);
    return locala;
  }
  
  public static com.tencent.mm.plugin.card.sharecard.model.k bJd()
  {
    AppMethodBeat.i(112894);
    com.tencent.mm.kernel.g.afz().aeD();
    if (getCore().nue == null) {
      getCore().nue = new com.tencent.mm.plugin.card.sharecard.model.k(com.tencent.mm.kernel.g.afB().gda);
    }
    com.tencent.mm.plugin.card.sharecard.model.k localk = getCore().nue;
    AppMethodBeat.o(112894);
    return localk;
  }
  
  public static com.tencent.mm.plugin.card.sharecard.model.o bJe()
  {
    AppMethodBeat.i(112895);
    com.tencent.mm.kernel.g.afz().aeD();
    if (getCore().nuf == null) {
      getCore().nuf = new com.tencent.mm.plugin.card.sharecard.model.o(com.tencent.mm.kernel.g.afB().gda);
    }
    com.tencent.mm.plugin.card.sharecard.model.o localo = getCore().nuf;
    AppMethodBeat.o(112895);
    return localo;
  }
  
  public static com.tencent.mm.plugin.card.sharecard.a.c bJf()
  {
    AppMethodBeat.i(112896);
    com.tencent.mm.kernel.g.afz().aeD();
    if (getCore().nug == null) {
      getCore().nug = new com.tencent.mm.plugin.card.sharecard.a.c();
    }
    com.tencent.mm.plugin.card.sharecard.a.c localc = getCore().nug;
    AppMethodBeat.o(112896);
    return localc;
  }
  
  public static com.tencent.mm.plugin.card.b.d bJg()
  {
    AppMethodBeat.i(112897);
    com.tencent.mm.kernel.g.afz().aeD();
    if (getCore().nuk == null) {
      getCore().nuk = new com.tencent.mm.plugin.card.b.d();
    }
    com.tencent.mm.plugin.card.b.d locald = getCore().nuk;
    AppMethodBeat.o(112897);
    return locald;
  }
  
  public static com.tencent.mm.plugin.card.b.j bJh()
  {
    AppMethodBeat.i(112898);
    com.tencent.mm.kernel.g.afz().aeD();
    if (getCore().nul == null) {
      getCore().nul = new com.tencent.mm.plugin.card.b.j();
    }
    com.tencent.mm.plugin.card.b.j localj = getCore().nul;
    AppMethodBeat.o(112898);
    return localj;
  }
  
  public static com.tencent.mm.plugin.card.b.c bJi()
  {
    AppMethodBeat.i(112899);
    com.tencent.mm.kernel.g.afz().aeD();
    if (getCore().num == null) {
      getCore().num = new com.tencent.mm.plugin.card.b.c();
    }
    com.tencent.mm.plugin.card.b.c localc = getCore().num;
    AppMethodBeat.o(112899);
    return localc;
  }
  
  public static l bJj()
  {
    AppMethodBeat.i(112900);
    com.tencent.mm.kernel.g.afz().aeD();
    if (getCore().nuo == null) {
      getCore().nuo = new l(com.tencent.mm.kernel.g.afB().gda);
    }
    l locall = getCore().nuo;
    AppMethodBeat.o(112900);
    return locall;
  }
  
  public static j bJk()
  {
    AppMethodBeat.i(112901);
    com.tencent.mm.kernel.g.afz().aeD();
    if (getCore().nup == null) {
      getCore().nup = new j(com.tencent.mm.kernel.g.afB().gda);
    }
    j localj = getCore().nup;
    AppMethodBeat.o(112901);
    return localj;
  }
  
  public static com.tencent.mm.plugin.card.b.g bJl()
  {
    AppMethodBeat.i(112902);
    com.tencent.mm.kernel.g.afz().aeD();
    if (getCore().nun == null) {
      getCore().nun = new com.tencent.mm.plugin.card.b.g();
    }
    com.tencent.mm.plugin.card.b.g localg = getCore().nun;
    AppMethodBeat.o(112902);
    return localg;
  }
  
  private static am getCore()
  {
    AppMethodBeat.i(112882);
    Object localObject = (com.tencent.mm.plugin.card.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.card.a.a.class);
    if (localObject != null) {}
    for (localObject = ((PluginCard)localObject).getCore();; localObject = null)
    {
      AppMethodBeat.o(112882);
      return localObject;
    }
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(112883);
    ad.i("MicroMsg.SubCoreCard", "onAccountPostReset, updated = %b", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.mm.sdk.b.a.ESL.c(this.nuu);
    com.tencent.mm.sdk.b.a.ESL.c(this.nuv);
    com.tencent.mm.sdk.b.a.ESL.c(this.nuq);
    com.tencent.mm.sdk.b.a.ESL.c(this.nur);
    com.tencent.mm.sdk.b.a.ESL.c(this.nus);
    com.tencent.mm.sdk.b.a.ESL.c(this.nuy);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("carditemmsg", this.nuw, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("notifysharecard", this.nux, true);
    this.nuh = null;
    if (this.nui != null)
    {
      this.nui.nqs.clear();
      this.nui = null;
    }
    if (this.nuc != null) {
      ??? = this.nuc;
    }
    synchronized (((com.tencent.mm.plugin.card.b.m)???).nrl)
    {
      ((com.tencent.mm.plugin.card.b.m)???).nrl.clear();
      synchronized (((com.tencent.mm.plugin.card.b.m)???).nrm)
      {
        ((com.tencent.mm.plugin.card.b.m)???).nrm.clear();
        com.tencent.mm.kernel.g.afA().gcy.b(1058, (com.tencent.mm.al.g)???);
        ??? = com.tencent.mm.modelgeo.d.axT();
        if (??? != null) {
          ((com.tencent.mm.modelgeo.b)???).c((b.a)???);
        }
        if (((com.tencent.mm.plugin.card.b.m)???).nro != null) {
          com.tencent.mm.kernel.g.afA().gcy.a(((com.tencent.mm.plugin.card.b.m)???).nro);
        }
        this.nuc = null;
        if (this.ntY != null)
        {
          this.ntY.detach();
          this.ntY = null;
        }
        if (this.nud != null) {
          ??? = this.nud;
        }
      }
    }
    synchronized (((com.tencent.mm.plugin.card.sharecard.a.a)???).lock)
    {
      ((com.tencent.mm.plugin.card.sharecard.a.a)???).pendingList.clear();
      ((com.tencent.mm.plugin.card.sharecard.a.a)???).npY.clear();
      if (((com.tencent.mm.plugin.card.sharecard.a.a)???).nuX != null) {
        com.tencent.mm.kernel.g.afA().gcy.a(((com.tencent.mm.plugin.card.sharecard.a.a)???).nuX);
      }
      com.tencent.mm.kernel.g.afA().gcy.b(1132, (com.tencent.mm.al.g)???);
      this.nud = null;
      if (this.nuk != null)
      {
        this.nuk.release();
        ??? = this.nuk;
        ((com.tencent.mm.plugin.card.b.d)???).nqa.clear();
        ((com.tencent.mm.plugin.card.b.d)???).nqm.clear();
        ((com.tencent.mm.plugin.card.b.d)???).nqn.clear();
        ((com.tencent.mm.plugin.card.b.d)???).nqo.clear();
        ((com.tencent.mm.plugin.card.b.d)???).nqq = false;
        this.nuk = null;
      }
      if (this.nul == null) {
        break label573;
      }
      ??? = this.nul;
      com.tencent.mm.kernel.g.afA().gcy.b(1078, (com.tencent.mm.al.g)???);
      ??? = ((com.tencent.mm.plugin.card.b.j)???).nqX.iterator();
      while (((Iterator)???).hasNext())
      {
        String str = (String)((Iterator)???).next();
        Runnable localRunnable = (Runnable)((com.tencent.mm.plugin.card.b.j)???).nqZ.get(str);
        ((com.tencent.mm.plugin.card.b.j)???).nqZ.remove(str);
        ((com.tencent.mm.plugin.card.b.j)???).nqY.removeCallbacks(localRunnable);
        continue;
        localObject2 = finally;
        AppMethodBeat.o(112883);
        throw localObject2;
        localObject3 = finally;
        AppMethodBeat.o(112883);
        throw localObject3;
      }
    }
    localObject3.nqW.clear();
    localObject3.nqX.clear();
    localObject3.nqZ.clear();
    this.nul = null;
    label573:
    if (this.num != null)
    {
      this.num.release();
      this.num = null;
    }
    if (this.nun != null)
    {
      this.nun.release();
      this.nun = null;
    }
    this.nuj = null;
    com.tencent.mm.plugin.card.ui.b localb = this.nut;
    com.tencent.mm.plugin.card.ui.b.bod().registerActivityLifecycleCallbacks(localb);
    if (paramBoolean) {
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fux, Integer.valueOf(1));
    }
    AppMethodBeat.o(112883);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(112884);
    if (getCore().ntY != null) {
      getCore().ntY.detach();
    }
    com.tencent.mm.sdk.b.a.ESL.d(this.nuu);
    com.tencent.mm.sdk.b.a.ESL.d(this.nuv);
    com.tencent.mm.sdk.b.a.ESL.d(this.nuq);
    com.tencent.mm.sdk.b.a.ESL.d(this.nur);
    com.tencent.mm.sdk.b.a.ESL.d(this.nus);
    com.tencent.mm.sdk.b.a.ESL.d(this.nuy);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().b("carditemmsg", this.nuw, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().b("notifysharecard", this.nux, true);
    com.tencent.mm.plugin.card.ui.b localb = this.nut;
    com.tencent.mm.plugin.card.ui.b.bod().unregisterActivityLifecycleCallbacks(localb);
    AppMethodBeat.o(112884);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.am
 * JD-Core Version:    0.7.0.1
 */
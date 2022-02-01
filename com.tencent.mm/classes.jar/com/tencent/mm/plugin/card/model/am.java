package com.tencent.mm.plugin.card.model;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.lc;
import com.tencent.mm.f.a.lc.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.be;
import com.tencent.mm.model.ck;
import com.tencent.mm.model.ck.a;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.card.PluginCard;
import com.tencent.mm.plugin.card.b.g;
import com.tencent.mm.plugin.card.b.n;
import com.tencent.mm.plugin.card.model.a.e.a;
import com.tencent.mm.plugin.card.ui.CardHomePageUI;
import com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI;
import com.tencent.mm.plugin.card.ui.v3.CardHomePageV3UI;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.protocal.protobuf.up;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.q;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class am
  implements be
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private MMHandler mHandler;
  private com.tencent.mm.plugin.card.b.b tqB;
  private c tqC;
  private al tqD;
  private h tqE;
  private com.tencent.mm.plugin.card.b.m tqF;
  private com.tencent.mm.plugin.card.sharecard.a.a tqG;
  private com.tencent.mm.plugin.card.sharecard.model.k tqH;
  private com.tencent.mm.plugin.card.sharecard.model.o tqI;
  private com.tencent.mm.plugin.card.sharecard.a.c tqJ;
  private com.tencent.mm.plugin.card.b.k tqK;
  private com.tencent.mm.plugin.card.b.e tqL;
  private com.tencent.mm.plugin.card.b.l tqM;
  private com.tencent.mm.plugin.card.b.d tqN;
  private com.tencent.mm.plugin.card.b.j tqO;
  private com.tencent.mm.plugin.card.b.c tqP;
  private g tqQ;
  private l tqR;
  private j tqS;
  private IListener tqT;
  private IListener tqU;
  private IListener tqV;
  private com.tencent.mm.plugin.card.ui.b tqW;
  private IListener tqX;
  private IListener tqY;
  private ck.a tqZ;
  private ck.a tra;
  private IListener<lc> trb;
  
  static
  {
    AppMethodBeat.i(112903);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("USERCARDINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return c.SQL_CREATE;
      }
    });
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
    this.tqK = null;
    this.tqL = null;
    this.tqM = null;
    this.tqN = null;
    this.tqO = null;
    this.mHandler = new MMHandler(Looper.getMainLooper());
    this.tqT = new n();
    this.tqU = new com.tencent.mm.plugin.card.b.o();
    this.tqV = new com.tencent.mm.plugin.card.b.a();
    this.tqW = new com.tencent.mm.plugin.card.ui.b();
    this.tqX = new am.1(this);
    this.tqY = new am.5(this);
    this.tqZ = new am.6(this);
    this.tra = new am.7(this);
    this.trb = new IListener()
    {
      private static boolean a(lc paramAnonymouslc)
      {
        AppMethodBeat.i(112874);
        int i = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vwr, Integer.valueOf(1))).intValue();
        int j = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vwu, Integer.valueOf(1))).intValue();
        boolean bool = ((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vww, Boolean.FALSE)).booleanValue();
        Log.i("MicroMsg.SubCoreCard", "goto card version: %s, trade area: %s, newVersion2: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool) });
        Object localObject;
        Context localContext;
        if (bool) {
          if (paramAnonymouslc.fIO.context != null)
          {
            localObject = new Intent(paramAnonymouslc.fIO.context, CardHomePageV3UI.class);
            localContext = paramAnonymouslc.fIO.context;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/card/model/SubCoreCard$12", "callback", "(Lcom/tencent/mm/autogen/events/GotoCardHomePageEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/card/model/SubCoreCard$12", "callback", "(Lcom/tencent/mm/autogen/events/GotoCardHomePageEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.plugin.card.b.k.cHh();
            if (paramAnonymouslc.fIO.enterScene == 1) {
              com.tencent.mm.plugin.report.service.h.IzE.a(16322, new Object[] { Integer.valueOf(3) });
            }
          }
        }
        for (;;)
        {
          paramAnonymouslc = com.tencent.mm.plugin.card.model.a.e.trs;
          e.a.cHR();
          AppMethodBeat.o(112874);
          return true;
          if (j == 2)
          {
            paramAnonymouslc = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vwv, "");
            if (!Util.isNullOrNil(paramAnonymouslc)) {
              try
              {
                paramAnonymouslc = (up)new up().parseFrom(paramAnonymouslc.getBytes(kotlin.n.d.ISO_8859_1));
                com.tencent.mm.plugin.card.d.b.L(paramAnonymouslc.Ooe, paramAnonymouslc.Oof, paramAnonymouslc.Paq);
              }
              catch (IOException paramAnonymouslc)
              {
                Log.printErrStackTrace("MicroMsg.SubCoreCard", paramAnonymouslc, "", new Object[0]);
              }
            }
          }
          else if (i == 1)
          {
            if (paramAnonymouslc.fIO.context != null)
            {
              localObject = new Intent(paramAnonymouslc.fIO.context, CardHomePageNewUI.class);
              localContext = paramAnonymouslc.fIO.context;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
              com.tencent.mm.hellhoundlib.a.a.b(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/card/model/SubCoreCard$12", "callback", "(Lcom/tencent/mm/autogen/events/GotoCardHomePageEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
              com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/card/model/SubCoreCard$12", "callback", "(Lcom/tencent/mm/autogen/events/GotoCardHomePageEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              com.tencent.mm.plugin.card.b.k.cHh();
              if (paramAnonymouslc.fIO.enterScene == 1) {
                com.tencent.mm.plugin.report.service.h.IzE.a(16322, new Object[] { Integer.valueOf(3) });
              }
            }
          }
          else
          {
            if (paramAnonymouslc.fIO.context != null)
            {
              localObject = new Intent(paramAnonymouslc.fIO.context, CardHomePageUI.class);
              ((Intent)localObject).putExtra("key_from_scene", 22);
              ((Intent)localObject).putExtra("key_home_page_from_scene", paramAnonymouslc.fIO.scene);
              localContext = paramAnonymouslc.fIO.context;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
              com.tencent.mm.hellhoundlib.a.a.b(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/card/model/SubCoreCard$12", "callback", "(Lcom/tencent/mm/autogen/events/GotoCardHomePageEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
              com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/card/model/SubCoreCard$12", "callback", "(Lcom/tencent/mm/autogen/events/GotoCardHomePageEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              com.tencent.mm.plugin.card.b.k.cHh();
              if (paramAnonymouslc.fIO.enterScene == 1) {
                com.tencent.mm.plugin.report.service.h.IzE.a(16322, new Object[] { Integer.valueOf(2) });
              }
            }
            paramAnonymouslc.fIP.fIQ = "com.tencent.mm.plugin.card.ui.CardHomePageUI";
          }
        }
      }
    };
    q localq = new q(m.tpO);
    if (!localq.ifE()) {
      localq.ifK();
    }
    localq = new q(m.tpP);
    if (!localq.ifE()) {
      localq.ifK();
    }
    AppMethodBeat.o(112881);
  }
  
  public static com.tencent.mm.plugin.card.sharecard.model.k cHA()
  {
    AppMethodBeat.i(112894);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (getCore().tqH == null) {
      getCore().tqH = new com.tencent.mm.plugin.card.sharecard.model.k(com.tencent.mm.kernel.h.aHG().kcF);
    }
    com.tencent.mm.plugin.card.sharecard.model.k localk = getCore().tqH;
    AppMethodBeat.o(112894);
    return localk;
  }
  
  public static com.tencent.mm.plugin.card.sharecard.model.o cHB()
  {
    AppMethodBeat.i(112895);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (getCore().tqI == null) {
      getCore().tqI = new com.tencent.mm.plugin.card.sharecard.model.o(com.tencent.mm.kernel.h.aHG().kcF);
    }
    com.tencent.mm.plugin.card.sharecard.model.o localo = getCore().tqI;
    AppMethodBeat.o(112895);
    return localo;
  }
  
  public static com.tencent.mm.plugin.card.sharecard.a.c cHC()
  {
    AppMethodBeat.i(112896);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (getCore().tqJ == null) {
      getCore().tqJ = new com.tencent.mm.plugin.card.sharecard.a.c();
    }
    com.tencent.mm.plugin.card.sharecard.a.c localc = getCore().tqJ;
    AppMethodBeat.o(112896);
    return localc;
  }
  
  public static com.tencent.mm.plugin.card.b.d cHD()
  {
    AppMethodBeat.i(112897);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (getCore().tqN == null) {
      getCore().tqN = new com.tencent.mm.plugin.card.b.d();
    }
    com.tencent.mm.plugin.card.b.d locald = getCore().tqN;
    AppMethodBeat.o(112897);
    return locald;
  }
  
  public static com.tencent.mm.plugin.card.b.j cHE()
  {
    AppMethodBeat.i(112898);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (getCore().tqO == null) {
      getCore().tqO = new com.tencent.mm.plugin.card.b.j();
    }
    com.tencent.mm.plugin.card.b.j localj = getCore().tqO;
    AppMethodBeat.o(112898);
    return localj;
  }
  
  public static com.tencent.mm.plugin.card.b.c cHF()
  {
    AppMethodBeat.i(112899);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (getCore().tqP == null) {
      getCore().tqP = new com.tencent.mm.plugin.card.b.c();
    }
    com.tencent.mm.plugin.card.b.c localc = getCore().tqP;
    AppMethodBeat.o(112899);
    return localc;
  }
  
  public static l cHG()
  {
    AppMethodBeat.i(112900);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (getCore().tqR == null) {
      getCore().tqR = new l(com.tencent.mm.kernel.h.aHG().kcF);
    }
    l locall = getCore().tqR;
    AppMethodBeat.o(112900);
    return locall;
  }
  
  public static j cHH()
  {
    AppMethodBeat.i(112901);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (getCore().tqS == null) {
      getCore().tqS = new j(com.tencent.mm.kernel.h.aHG().kcF);
    }
    j localj = getCore().tqS;
    AppMethodBeat.o(112901);
    return localj;
  }
  
  public static g cHI()
  {
    AppMethodBeat.i(112902);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (getCore().tqQ == null) {
      getCore().tqQ = new g();
    }
    g localg = getCore().tqQ;
    AppMethodBeat.o(112902);
    return localg;
  }
  
  public static com.tencent.mm.plugin.card.b.b cHr()
  {
    AppMethodBeat.i(112885);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (getCore().tqB == null) {
      getCore().tqB = new com.tencent.mm.plugin.card.b.b();
    }
    com.tencent.mm.plugin.card.b.b localb = getCore().tqB;
    AppMethodBeat.o(112885);
    return localb;
  }
  
  public static c cHs()
  {
    AppMethodBeat.i(112886);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (getCore().tqC == null) {
      getCore().tqC = new c(com.tencent.mm.kernel.h.aHG().kcF);
    }
    c localc = getCore().tqC;
    AppMethodBeat.o(112886);
    return localc;
  }
  
  public static al cHt()
  {
    AppMethodBeat.i(112887);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (getCore().tqD == null) {
      getCore().tqD = new al(com.tencent.mm.kernel.h.aHG().kcF);
    }
    al localal = getCore().tqD;
    AppMethodBeat.o(112887);
    return localal;
  }
  
  public static h cHu()
  {
    AppMethodBeat.i(112888);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (getCore().tqE == null) {
      getCore().tqE = new h(com.tencent.mm.kernel.h.aHG().kcF);
    }
    h localh = getCore().tqE;
    AppMethodBeat.o(112888);
    return localh;
  }
  
  public static com.tencent.mm.plugin.card.b.m cHv()
  {
    AppMethodBeat.i(112889);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (getCore().tqF == null) {
      getCore().tqF = new com.tencent.mm.plugin.card.b.m();
    }
    com.tencent.mm.plugin.card.b.m localm = getCore().tqF;
    AppMethodBeat.o(112889);
    return localm;
  }
  
  public static com.tencent.mm.plugin.card.b.k cHw()
  {
    AppMethodBeat.i(112890);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (getCore().tqK == null) {
      getCore().tqK = new com.tencent.mm.plugin.card.b.k();
    }
    com.tencent.mm.plugin.card.b.k localk = getCore().tqK;
    AppMethodBeat.o(112890);
    return localk;
  }
  
  public static com.tencent.mm.plugin.card.b.e cHx()
  {
    AppMethodBeat.i(112891);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (getCore().tqL == null) {
      getCore().tqL = new com.tencent.mm.plugin.card.b.e();
    }
    com.tencent.mm.plugin.card.b.e locale = getCore().tqL;
    AppMethodBeat.o(112891);
    return locale;
  }
  
  public static com.tencent.mm.plugin.card.b.l cHy()
  {
    AppMethodBeat.i(112892);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (getCore().tqM == null) {
      getCore().tqM = new com.tencent.mm.plugin.card.b.l();
    }
    com.tencent.mm.plugin.card.b.l locall = getCore().tqM;
    AppMethodBeat.o(112892);
    return locall;
  }
  
  public static com.tencent.mm.plugin.card.sharecard.a.a cHz()
  {
    AppMethodBeat.i(112893);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (getCore().tqG == null) {
      getCore().tqG = new com.tencent.mm.plugin.card.sharecard.a.a();
    }
    com.tencent.mm.plugin.card.sharecard.a.a locala = getCore().tqG;
    AppMethodBeat.o(112893);
    return locala;
  }
  
  private static am getCore()
  {
    AppMethodBeat.i(112882);
    Object localObject = (com.tencent.mm.plugin.card.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.card.a.a.class);
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
    Log.i("MicroMsg.SubCoreCard", "onAccountPostReset, updated = %b", new Object[] { Boolean.valueOf(paramBoolean) });
    EventCenter.instance.addListener(this.tqX);
    EventCenter.instance.addListener(this.tqY);
    EventCenter.instance.addListener(this.tqT);
    EventCenter.instance.addListener(this.tqU);
    EventCenter.instance.addListener(this.tqV);
    EventCenter.instance.addListener(this.trb);
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().a("carditemmsg", this.tqZ, true);
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().a("notifysharecard", this.tra, true);
    this.tqK = null;
    if (this.tqL != null)
    {
      this.tqL.tmX.clear();
      this.tqL = null;
    }
    if (this.tqF != null) {
      ??? = this.tqF;
    }
    synchronized (((com.tencent.mm.plugin.card.b.m)???).tnR)
    {
      ((com.tencent.mm.plugin.card.b.m)???).tnR.clear();
      synchronized (((com.tencent.mm.plugin.card.b.m)???).tnS)
      {
        ((com.tencent.mm.plugin.card.b.m)???).tnS.clear();
        com.tencent.mm.kernel.h.aHF().kcd.b(1058, (i)???);
        ??? = com.tencent.mm.modelgeo.d.blq();
        if (??? != null) {
          ((com.tencent.mm.modelgeo.b)???).b((b.a)???);
        }
        if (((com.tencent.mm.plugin.card.b.m)???).tnU != null) {
          com.tencent.mm.kernel.h.aHF().kcd.a(((com.tencent.mm.plugin.card.b.m)???).tnU);
        }
        this.tqF = null;
        if (this.tqB != null)
        {
          this.tqB.detach();
          this.tqB = null;
        }
        if (this.tqG != null) {
          ??? = this.tqG;
        }
      }
    }
    synchronized (((com.tencent.mm.plugin.card.sharecard.a.a)???).lock)
    {
      ((com.tencent.mm.plugin.card.sharecard.a.a)???).pendingList.clear();
      ((com.tencent.mm.plugin.card.sharecard.a.a)???).tmE.clear();
      if (((com.tencent.mm.plugin.card.sharecard.a.a)???).trI != null) {
        com.tencent.mm.kernel.h.aHF().kcd.a(((com.tencent.mm.plugin.card.sharecard.a.a)???).trI);
      }
      com.tencent.mm.kernel.h.aHF().kcd.b(1132, (i)???);
      this.tqG = null;
      if (this.tqN != null)
      {
        this.tqN.release();
        ??? = this.tqN;
        ((com.tencent.mm.plugin.card.b.d)???).cSF.clear();
        ((com.tencent.mm.plugin.card.b.d)???).tmR.clear();
        ((com.tencent.mm.plugin.card.b.d)???).tmS.clear();
        ((com.tencent.mm.plugin.card.b.d)???).tmT.clear();
        ((com.tencent.mm.plugin.card.b.d)???).tmV = false;
        this.tqN = null;
      }
      if (this.tqO == null) {
        break label573;
      }
      ??? = this.tqO;
      com.tencent.mm.kernel.h.aHF().kcd.b(1078, (i)???);
      ??? = ((com.tencent.mm.plugin.card.b.j)???).tnD.iterator();
      while (((Iterator)???).hasNext())
      {
        String str = (String)((Iterator)???).next();
        Runnable localRunnable = (Runnable)((com.tencent.mm.plugin.card.b.j)???).tnF.get(str);
        ((com.tencent.mm.plugin.card.b.j)???).tnF.remove(str);
        ((com.tencent.mm.plugin.card.b.j)???).tnE.removeCallbacks(localRunnable);
        continue;
        localObject2 = finally;
        AppMethodBeat.o(112883);
        throw localObject2;
        localObject3 = finally;
        AppMethodBeat.o(112883);
        throw localObject3;
      }
    }
    localObject3.tnC.clear();
    localObject3.tnD.clear();
    localObject3.tnF.clear();
    this.tqO = null;
    label573:
    if (this.tqP != null)
    {
      this.tqP.release();
      this.tqP = null;
    }
    if (this.tqQ != null)
    {
      this.tqQ.release();
      this.tqQ = null;
    }
    this.tqM = null;
    com.tencent.mm.plugin.card.ui.b localb = this.tqW;
    com.tencent.mm.plugin.card.ui.b.cjC().registerActivityLifecycleCallbacks(localb);
    if (paramBoolean) {
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vwr, Integer.valueOf(1));
    }
    AppMethodBeat.o(112883);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(112884);
    if (getCore().tqB != null) {
      getCore().tqB.detach();
    }
    EventCenter.instance.removeListener(this.tqX);
    EventCenter.instance.removeListener(this.tqY);
    EventCenter.instance.removeListener(this.tqT);
    EventCenter.instance.removeListener(this.tqU);
    EventCenter.instance.removeListener(this.tqV);
    EventCenter.instance.removeListener(this.trb);
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().b("carditemmsg", this.tqZ, true);
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().b("notifysharecard", this.tra, true);
    com.tencent.mm.plugin.card.ui.b localb = this.tqW;
    com.tencent.mm.plugin.card.ui.b.cjC().unregisterActivityLifecycleCallbacks(localb);
    AppMethodBeat.o(112884);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.am
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.emoji.model;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.app.o.a;
import com.tencent.mm.av.a.a.b.a;
import com.tencent.mm.emoji.a.j;
import com.tencent.mm.emoji.sync.EmojiSyncManager;
import com.tencent.mm.emoji.sync.EmojiSyncManager.a;
import com.tencent.mm.model.az;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.emoji.e.i.1;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager.ConnectivityReceiver;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.e.a;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.be;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.o;
import com.tencent.mm.view.SmileyPanelImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class k
  implements az
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private com.tencent.mm.plugin.emoji.e.f pLA;
  private l pLB;
  private g pLC;
  private e pLD;
  private com.tencent.mm.plugin.emoji.sync.a<com.tencent.mm.plugin.emoji.sync.c> pLE;
  private volatile com.tencent.mm.plugin.emoji.e.g pLF;
  private volatile com.tencent.mm.plugin.emoji.e.b pLG;
  private volatile com.tencent.mm.plugin.emoji.e.i pLH;
  private com.tencent.mm.av.a.a pLI;
  private c pLy;
  private ba pLz;
  
  static
  {
    AppMethodBeat.i(108654);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("EMOJIINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.storage.emotion.f.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("EMOJIGROUPINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.storage.emotion.c.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("EMOJIINFODESC_TABLE".hashCode()), new k.10());
    baseDBFactories.put(Integer.valueOf("EMOTIONDETAIL_TABLE".hashCode()), new k.11());
    baseDBFactories.put(Integer.valueOf("GETEMOTIONLISTCACHE_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.storage.emotion.s.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("EmotionRewardINFO_TABLE".hashCode()), new k.13());
    baseDBFactories.put(Integer.valueOf("EmotionDesignerInfoStorage_TABLE".hashCode()), new k.14());
    baseDBFactories.put(Integer.valueOf("EmotionRewardTipStorage_TABLE".hashCode()), new k.15());
    baseDBFactories.put(Integer.valueOf("SmileyInfoStorage_TABLE".hashCode()), new k.16());
    baseDBFactories.put(Integer.valueOf("SmileyPanelConfigInfoStorage_TABLE".hashCode()), new k.2());
    baseDBFactories.put(Integer.valueOf("EmojiDescMapStorage".hashCode()), new k.3());
    baseDBFactories.put(Integer.valueOf("EmojiDesignerProductStorage_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.storage.emotion.b.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("EmojiSuggestCacheStorage".hashCode()), new k.5());
    baseDBFactories.put(Integer.valueOf("DELETE".hashCode()), new k.6());
    AppMethodBeat.o(108654);
  }
  
  private static k cid()
  {
    AppMethodBeat.i(108641);
    k localk = (k)u.ap(k.class);
    AppMethodBeat.o(108641);
    return localk;
  }
  
  public static com.tencent.mm.av.a.a cie()
  {
    AppMethodBeat.i(108642);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (cid().pLI == null)
    {
      localObject = new b.a(ak.getContext());
      ((b.a)localObject).ifZ = new com.tencent.mm.plugin.emoji.d.a();
      ((b.a)localObject).ifX = new com.tencent.mm.view.c.a();
      localObject = ((b.a)localObject).aJj();
      cid().pLI = new com.tencent.mm.av.a.a((com.tencent.mm.av.a.a.b)localObject);
    }
    Object localObject = cid().pLI;
    AppMethodBeat.o(108642);
    return localObject;
  }
  
  public static c cif()
  {
    AppMethodBeat.i(108643);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (cid().pLy == null) {
      cid().pLy = new c();
    }
    c localc = cid().pLy;
    AppMethodBeat.o(108643);
    return localc;
  }
  
  public static com.tencent.mm.plugin.emoji.e.f cig()
  {
    AppMethodBeat.i(108645);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (cid().pLA == null) {
      cid().pLA = new com.tencent.mm.plugin.emoji.e.f();
    }
    com.tencent.mm.plugin.emoji.e.f localf = cid().pLA;
    AppMethodBeat.o(108645);
    return localf;
  }
  
  public static com.tencent.mm.plugin.emoji.sync.a<com.tencent.mm.plugin.emoji.sync.c> cih()
  {
    AppMethodBeat.i(108646);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (cid().pLE == null) {
      cid().pLE = new com.tencent.mm.plugin.emoji.sync.a();
    }
    com.tencent.mm.plugin.emoji.sync.a locala = cid().pLE;
    AppMethodBeat.o(108646);
    return locala;
  }
  
  private static com.tencent.mm.plugin.emoji.e.g cii()
  {
    try
    {
      AppMethodBeat.i(108647);
      com.tencent.mm.kernel.g.ajP().aiU();
      if (cid().pLF == null) {
        cid().pLF = new com.tencent.mm.plugin.emoji.e.g();
      }
      com.tencent.mm.plugin.emoji.e.g localg = cid().pLF;
      AppMethodBeat.o(108647);
      return localg;
    }
    finally {}
  }
  
  private static com.tencent.mm.plugin.emoji.e.b cij()
  {
    AppMethodBeat.i(108648);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (cid().pLG == null) {
      cid().pLG = new com.tencent.mm.plugin.emoji.e.b();
    }
    com.tencent.mm.plugin.emoji.e.b localb = cid().pLG;
    AppMethodBeat.o(108648);
    return localb;
  }
  
  public static com.tencent.mm.plugin.emoji.e.i cik()
  {
    AppMethodBeat.i(108650);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (cid().pLH == null) {
      cid().pLH = new com.tencent.mm.plugin.emoji.e.i();
    }
    com.tencent.mm.plugin.emoji.e.i locali = cid().pLH;
    AppMethodBeat.o(108650);
    return locali;
  }
  
  public static e cil()
  {
    AppMethodBeat.i(108653);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (cid().pLD == null) {
      cid().pLD = new e();
    }
    e locale = cid().pLD;
    AppMethodBeat.o(108653);
    return locale;
  }
  
  public static ba getEmojiDescMgr()
  {
    AppMethodBeat.i(108644);
    if (cid().pLz == null) {
      cid().pLz = ba.fuY();
    }
    ba localba = cid().pLz;
    AppMethodBeat.o(108644);
    return localba;
  }
  
  public static be getEmojiStorageMgr()
  {
    AppMethodBeat.i(108649);
    be localbe = be.fvc();
    AppMethodBeat.o(108649);
    return localbe;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(108652);
    ae.i("MicroMsg.emoji.SubCoreEmoji", "[onAccountPostReset]");
    com.tencent.mm.pluginsdk.ui.chat.e.Fwh = new e.b()
    {
      public final ChatFooterPanel eE(Context paramAnonymousContext)
      {
        AppMethodBeat.i(194864);
        paramAnonymousContext = new SmileyPanelImpl(paramAnonymousContext, false);
        AppMethodBeat.o(194864);
        return paramAnonymousContext;
      }
    };
    com.tencent.mm.pluginsdk.ui.chat.e.Fwi = new e.a() {};
    be.fvc().fvd();
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).setEmojiMgr();
    Object localObject1 = cii();
    ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("emotionstore", ((com.tencent.mm.plugin.emoji.e.g)localObject1).pJj, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("NewRecommendEmotion", ((com.tencent.mm.plugin.emoji.e.g)localObject1).pJk, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("EmojiBackup", ((com.tencent.mm.plugin.emoji.e.g)localObject1).pJl, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("EmotionBackup", ((com.tencent.mm.plugin.emoji.e.g)localObject1).pJl, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("SelfieEmojiBackup", ((com.tencent.mm.plugin.emoji.e.g)localObject1).pJl, true);
    localObject1 = cij();
    com.tencent.mm.sdk.b.a.IvT.c(((com.tencent.mm.plugin.emoji.e.b)localObject1).pIK);
    com.tencent.mm.sdk.b.a.IvT.c(((com.tencent.mm.plugin.emoji.e.b)localObject1).pIO);
    com.tencent.mm.sdk.b.a.IvT.c(((com.tencent.mm.plugin.emoji.e.b)localObject1).pIP);
    com.tencent.mm.sdk.b.a.IvT.c(((com.tencent.mm.plugin.emoji.e.b)localObject1).pIQ);
    com.tencent.mm.plugin.emoji.e.b.appForegroundListener.alive();
    com.tencent.mm.sdk.b.a.IvT.c(((com.tencent.mm.plugin.emoji.e.b)localObject1).pIR);
    com.tencent.mm.sdk.b.a.IvT.c(((com.tencent.mm.plugin.emoji.e.b)localObject1).pIS);
    com.tencent.mm.sdk.b.a.IvT.c(((com.tencent.mm.plugin.emoji.e.b)localObject1).checkLanguageChangeIListener);
    com.tencent.mm.sdk.b.a.IvT.c(((com.tencent.mm.plugin.emoji.e.b)localObject1).pIT);
    com.tencent.mm.sdk.b.a.IvT.c(((com.tencent.mm.plugin.emoji.e.b)localObject1).pIU);
    com.tencent.mm.sdk.b.a.IvT.c(((com.tencent.mm.plugin.emoji.e.b)localObject1).pIL);
    com.tencent.mm.sdk.b.a.IvT.c(((com.tencent.mm.plugin.emoji.e.b)localObject1).pIM);
    com.tencent.mm.sdk.b.a.IvT.c(((com.tencent.mm.plugin.emoji.e.b)localObject1).pIV);
    com.tencent.mm.sdk.b.a.IvT.c(((com.tencent.mm.plugin.emoji.e.b)localObject1).pIW);
    com.tencent.mm.sdk.b.a.IvT.c(((com.tencent.mm.plugin.emoji.e.b)localObject1).pIN);
    localObject1 = be.fvc();
    ((be)localObject1).JfU.add(((be)localObject1).Jgo);
    ((be)localObject1).JfV.add(((be)localObject1).Jgm);
    ((be)localObject1).JfW.add(((be)localObject1).Jgn);
    com.tencent.mm.sdk.b.a.IvT.c(((be)localObject1).Jgp);
    getEmojiDescMgr();
    localObject1 = cik();
    Object localObject2 = com.tencent.mm.n.g.acL().getValue("EmotionRewardTipsLimit");
    long l;
    if (!bu.isNullOrNil((String)localObject2))
    {
      ae.i("MicroMsg.emoji.EmojiRewardTipMgr", "updateConfig dynamic config %s", new Object[] { localObject2 });
      localObject2 = ((String)localObject2).split(",");
      if ((localObject2 != null) && (localObject2.length == 3))
      {
        if (bu.getInt(localObject2[0], 0) != 0) {
          break label1340;
        }
        l = 863913600000L;
        ((com.tencent.mm.plugin.emoji.e.i)localObject1).pJW = l;
        ((com.tencent.mm.plugin.emoji.e.i)localObject1).pJX = (bu.getInt(localObject2[1], 20) - 1);
        ((com.tencent.mm.plugin.emoji.e.i)localObject1).fVN = (bu.getInt(localObject2[2], 80) - 1);
      }
    }
    boolean bool2 = com.tencent.mm.emoji.a.m.afi();
    boolean bool3 = ((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.ILa, Boolean.TRUE)).booleanValue();
    boolean bool1;
    if ((bool2) && (bool3))
    {
      bool1 = true;
      label588:
      ((com.tencent.mm.plugin.emoji.e.i)localObject1).pJV = bool1;
      ae.i("MicroMsg.emoji.EmojiRewardTipMgr", "init RewardTipMgr RewardTipEnable:%b isEnableRewardTip:%b isTipsEnable:%b", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.emoji.e.i)localObject1).pJV), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      com.tencent.mm.kernel.g.ajU().aw(new i.1((com.tencent.mm.plugin.emoji.e.i)localObject1));
      localObject1 = cih().pMY;
      ae.d("MicroMsg.BKGLoader.BKGLoaderManager", "bkg attach");
      com.tencent.mm.sdk.b.a.IvT.c(((BKGLoaderManager)localObject1).pNw);
      com.tencent.mm.sdk.b.a.IvT.c(((BKGLoaderManager)localObject1).pNx);
      localObject2 = new IntentFilter();
      ((IntentFilter)localObject2).addAction("android.net.conn.CONNECTIVITY_CHANGE");
      ((BKGLoaderManager)localObject1).pNs = new BKGLoaderManager.ConnectivityReceiver((BKGLoaderManager)localObject1);
      ak.getContext().registerReceiver(((BKGLoaderManager)localObject1).pNs, (IntentFilter)localObject2);
      ae.i("MicroMsg.emoji.SubCoreEmoji", "[oneliang]initCore");
      localObject1 = be.fvc();
      localObject2 = ak.getContext();
      if (localObject2 != null)
      {
        bool1 = ((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(274480, Boolean.TRUE)).booleanValue();
        ae.i("MicroMsg.emoji.EmojiStorageMgr", "[oneliang]initCore,need init emoji:%s", new Object[] { String.valueOf(bool1) });
        if (bool1)
        {
          ((be)localObject1).JfU.init((Context)localObject2);
          ((be)localObject1).JfV.init((Context)localObject2);
        }
        com.tencent.mm.kernel.g.ajR().ajA().set(274480, Boolean.FALSE);
      }
      if (((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.ILb, Integer.valueOf(0))).intValue() != com.tencent.mm.protocal.d.FFH)
      {
        l = System.currentTimeMillis();
        ((be)localObject1).JfV.fxg();
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.ILb, Integer.valueOf(com.tencent.mm.protocal.d.FFH));
        ae.i("MicroMsg.emoji.EmojiStorageMgr", "recoverCustomEmojiGroup use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      }
      if (((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.ILc, Boolean.TRUE)).booleanValue())
      {
        l = System.currentTimeMillis();
        bool1 = ((be)localObject1).JfV.fxh();
        localObject1 = com.tencent.mm.kernel.g.ajR().ajA();
        localObject2 = am.a.ILc;
        if (bool1) {
          break label1363;
        }
        bool1 = true;
        label983:
        ((aj)localObject1).set((am.a)localObject2, Boolean.valueOf(bool1));
        ae.i("MicroMsg.emoji.EmojiStorageMgr", "updateEmojiGroupCount use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      }
      this.pLB = new l();
      this.pLC = new g();
      com.tencent.mm.aq.a.eP(paramBoolean);
      paramBoolean = com.tencent.mm.ce.f.fqV().fqX();
      bool1 = com.tencent.mm.ce.e.fqT().fqS();
      if ((paramBoolean) && (((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.ILd, Integer.valueOf(0))).intValue() > 0))
      {
        com.tencent.mm.pluginsdk.j.a.a.b.fes().f(37, 1, -1, false);
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.ILd, Integer.valueOf(0));
        localObject1 = new com.tencent.mm.pluginsdk.j.a.a.m(37);
        com.tencent.mm.kernel.g.ajQ().gDv.a((n)localObject1, 0);
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(165L, 10L, 1L, false);
      }
      if ((bool1) && (((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.ILe, Integer.valueOf(0))).intValue() > 0))
      {
        com.tencent.mm.pluginsdk.j.a.a.b.fes().f(37, 2, -1, false);
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.ILe, Integer.valueOf(0));
        localObject1 = new com.tencent.mm.pluginsdk.j.a.a.m(37);
        com.tencent.mm.kernel.g.ajQ().gDv.a((n)localObject1, 0);
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(165L, 11L, 1L, false);
      }
      localObject1 = com.tencent.mm.aq.b.aHF();
      ae.i("MicroMsg.FontResLogic", "init");
      ((com.tencent.mm.aq.b)localObject1).hZz.alive();
      if (!((com.tencent.mm.aq.b)localObject1).aHI()) {
        break label1368;
      }
      com.tencent.mm.plugin.report.service.g.yxI.n(933L, 4L, 1L);
    }
    for (;;)
    {
      localObject1 = EmojiSyncManager.grP;
      EmojiSyncManager.a.agx().init();
      localObject1 = EmojiSyncManager.grP;
      EmojiSyncManager.a.agy().init();
      localObject1 = j.gmz;
      j.afe();
      com.tencent.mm.flutter.d.gtG.add(h.class);
      AppMethodBeat.o(108652);
      return;
      label1340:
      l = bu.getInt(localObject2[0], 0) * 86400000L;
      break;
      bool1 = false;
      break label588;
      label1363:
      bool1 = false;
      break label983;
      label1368:
      com.tencent.mm.plugin.report.service.g.yxI.n(933L, 5L, 1L);
      com.tencent.mm.pluginsdk.j.a.a.b.fes();
      localObject2 = com.tencent.mm.pluginsdk.j.a.a.b.jq(57, 1);
      if (o.fB((String)localObject2))
      {
        com.tencent.mm.plugin.report.service.g.yxI.n(933L, 6L, 1L);
        ae.i("MicroMsg.FontResLogic", "cache file exist %s", new Object[] { localObject2 });
        ((com.tencent.mm.aq.b)localObject1).f((String)localObject2, 57, 1, 1);
      }
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(108651);
    ae.i("MicroMsg.emoji.SubCoreEmoji", "onAccountRelease: ");
    Object localObject = cii();
    ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().b("emotionstore", ((com.tencent.mm.plugin.emoji.e.g)localObject).pJj, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().b("NewRecommendEmotion", ((com.tencent.mm.plugin.emoji.e.g)localObject).pJk, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().b("EmojiBackup", ((com.tencent.mm.plugin.emoji.e.g)localObject).pJl, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().b("EmotionBackup", ((com.tencent.mm.plugin.emoji.e.g)localObject).pJl, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().b("SelfieEmojiBackup", ((com.tencent.mm.plugin.emoji.e.g)localObject).pJl, true);
    localObject = cij();
    com.tencent.mm.plugin.emoji.e.b.appForegroundListener.dead();
    com.tencent.mm.sdk.b.a.IvT.d(((com.tencent.mm.plugin.emoji.e.b)localObject).pIK);
    com.tencent.mm.sdk.b.a.IvT.d(((com.tencent.mm.plugin.emoji.e.b)localObject).pIO);
    com.tencent.mm.sdk.b.a.IvT.d(((com.tencent.mm.plugin.emoji.e.b)localObject).pIP);
    com.tencent.mm.sdk.b.a.IvT.d(((com.tencent.mm.plugin.emoji.e.b)localObject).pIQ);
    com.tencent.mm.sdk.b.a.IvT.d(((com.tencent.mm.plugin.emoji.e.b)localObject).pIR);
    com.tencent.mm.sdk.b.a.IvT.d(((com.tencent.mm.plugin.emoji.e.b)localObject).pIS);
    com.tencent.mm.sdk.b.a.IvT.d(((com.tencent.mm.plugin.emoji.e.b)localObject).checkLanguageChangeIListener);
    com.tencent.mm.sdk.b.a.IvT.d(((com.tencent.mm.plugin.emoji.e.b)localObject).pIT);
    com.tencent.mm.sdk.b.a.IvT.d(((com.tencent.mm.plugin.emoji.e.b)localObject).pIU);
    com.tencent.mm.sdk.b.a.IvT.d(((com.tencent.mm.plugin.emoji.e.b)localObject).pIL);
    com.tencent.mm.sdk.b.a.IvT.d(((com.tencent.mm.plugin.emoji.e.b)localObject).pIM);
    com.tencent.mm.sdk.b.a.IvT.d(((com.tencent.mm.plugin.emoji.e.b)localObject).pIV);
    com.tencent.mm.sdk.b.a.IvT.d(((com.tencent.mm.plugin.emoji.e.b)localObject).pIW);
    com.tencent.mm.sdk.b.a.IvT.d(((com.tencent.mm.plugin.emoji.e.b)localObject).pIN);
    localObject = be.fvc();
    ((be)localObject).JfU.remove(((be)localObject).Jgo);
    ((be)localObject).JfV.remove(((be)localObject).Jgm);
    ((be)localObject).JfW.remove(((be)localObject).Jgn);
    com.tencent.mm.sdk.b.a.IvT.d(((be)localObject).Jgp);
    localObject = ((be)localObject).Jgi;
    if (((com.tencent.mm.emoji.a.i)localObject).gmt != null) {
      ((com.tencent.mm.emoji.a.i)localObject).gmt.clear();
    }
    ((com.tencent.mm.emoji.a.i)localObject).gmu.clear();
    getEmojiDescMgr().clear();
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).removeEmojiMgr();
    localObject = cif();
    com.tencent.mm.kernel.g.ajQ().gDv.b(175, (com.tencent.mm.ak.f)localObject);
    ((c)localObject).pKy.clear();
    ((c)localObject).pKw.clear();
    localObject = cik();
    ((com.tencent.mm.plugin.emoji.e.i)localObject).pJY = null;
    if (((com.tencent.mm.plugin.emoji.e.i)localObject).pJZ != null) {
      ((com.tencent.mm.plugin.emoji.e.i)localObject).pJZ.clear();
    }
    localObject = cih().pMY;
    ae.d("MicroMsg.BKGLoader.BKGLoaderManager", "bkg detach");
    ((BKGLoaderManager)localObject).ciD();
    com.tencent.mm.sdk.b.a.IvT.d(((BKGLoaderManager)localObject).pNw);
    com.tencent.mm.sdk.b.a.IvT.d(((BKGLoaderManager)localObject).pNx);
    if (((BKGLoaderManager)localObject).pNs != null)
    {
      ak.getContext().unregisterReceiver(((BKGLoaderManager)localObject).pNs);
      ((BKGLoaderManager)localObject).pNs = null;
    }
    if (this.pLB != null)
    {
      localObject = this.pLB;
      com.tencent.mm.sdk.b.a.IvT.d(((l)localObject).pLN);
      com.tencent.mm.sdk.b.a.IvT.d(((l)localObject).pLO);
    }
    if (this.pLC != null)
    {
      localObject = this.pLC;
      ((g)localObject).pKS.clear();
      cif().pKA = null;
      ((g)localObject).pKT.dead();
    }
    if (this.pLI != null) {
      this.pLI.detach();
    }
    com.tencent.mm.aq.b.aHF().hZz.dead();
    localObject = EmojiSyncManager.grP;
    EmojiSyncManager.a.agx().destroy();
    localObject = EmojiSyncManager.grP;
    EmojiSyncManager.a.agy().destroy();
    AppMethodBeat.o(108651);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.k
 * JD-Core Version:    0.7.0.1
 */
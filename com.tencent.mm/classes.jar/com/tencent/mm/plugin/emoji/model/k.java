package com.tencent.mm.plugin.emoji.model;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.app.n.a;
import com.tencent.mm.av.a.a.b.a;
import com.tencent.mm.emoji.a.j;
import com.tencent.mm.emoji.sync.EmojiSyncManager;
import com.tencent.mm.emoji.sync.EmojiSyncManager.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.emoji.e.i.1;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager.ConnectivityReceiver;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.e.a;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.av;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.emotion.s;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.view.SmileyPanelImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class k
  implements aw
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private c pbk;
  private av pbl;
  private com.tencent.mm.plugin.emoji.e.f pbm;
  private l pbn;
  private g pbo;
  private e pbp;
  private com.tencent.mm.plugin.emoji.sync.a<com.tencent.mm.plugin.emoji.sync.c> pbq;
  private volatile com.tencent.mm.plugin.emoji.e.g pbr;
  private volatile com.tencent.mm.plugin.emoji.e.b pbs;
  private volatile com.tencent.mm.plugin.emoji.e.i pbt;
  private com.tencent.mm.av.a.a pbu;
  
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
    baseDBFactories.put(Integer.valueOf("EMOJIINFODESC_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.storage.emotion.e.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("EMOTIONDETAIL_TABLE".hashCode()), new k.11());
    baseDBFactories.put(Integer.valueOf("GETEMOTIONLISTCACHE_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return s.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("EmotionRewardINFO_TABLE".hashCode()), new k.13());
    baseDBFactories.put(Integer.valueOf("EmotionDesignerInfoStorage_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.storage.emotion.k.SQL_CREATE;
      }
    });
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
    baseDBFactories.put(Integer.valueOf("EmojiSuggestCacheStorage".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        AppMethodBeat.i(207442);
        Object localObject = com.tencent.mm.storage.emotion.g.HaT;
        localObject = com.tencent.mm.storage.emotion.g.dYY();
        AppMethodBeat.o(207442);
        return localObject;
      }
    });
    baseDBFactories.put(Integer.valueOf("DELETE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return new String[] { "DROP TABLE IF EXISTS EmotionDetail ", "DROP TABLE IF EXISTS EmojiSummaryInfo", "DROP TABLE IF EXISTS RewardMagicInfo" };
      }
    });
    AppMethodBeat.o(108654);
  }
  
  private static k ccj()
  {
    AppMethodBeat.i(108641);
    k localk = (k)t.ap(k.class);
    AppMethodBeat.o(108641);
    return localk;
  }
  
  public static com.tencent.mm.av.a.a cck()
  {
    AppMethodBeat.i(108642);
    com.tencent.mm.kernel.g.agP().afT();
    if (ccj().pbu == null)
    {
      localObject = new b.a(ai.getContext());
      ((b.a)localObject).hKm = new com.tencent.mm.plugin.emoji.d.a();
      ((b.a)localObject).hKk = new com.tencent.mm.view.c.a();
      localObject = ((b.a)localObject).aFI();
      ccj().pbu = new com.tencent.mm.av.a.a((com.tencent.mm.av.a.a.b)localObject);
    }
    Object localObject = ccj().pbu;
    AppMethodBeat.o(108642);
    return localObject;
  }
  
  public static c ccl()
  {
    AppMethodBeat.i(108643);
    com.tencent.mm.kernel.g.agP().afT();
    if (ccj().pbk == null) {
      ccj().pbk = new c();
    }
    c localc = ccj().pbk;
    AppMethodBeat.o(108643);
    return localc;
  }
  
  public static com.tencent.mm.plugin.emoji.e.f ccm()
  {
    AppMethodBeat.i(108645);
    com.tencent.mm.kernel.g.agP().afT();
    if (ccj().pbm == null) {
      ccj().pbm = new com.tencent.mm.plugin.emoji.e.f();
    }
    com.tencent.mm.plugin.emoji.e.f localf = ccj().pbm;
    AppMethodBeat.o(108645);
    return localf;
  }
  
  public static com.tencent.mm.plugin.emoji.sync.a<com.tencent.mm.plugin.emoji.sync.c> ccn()
  {
    AppMethodBeat.i(108646);
    com.tencent.mm.kernel.g.agP().afT();
    if (ccj().pbq == null) {
      ccj().pbq = new com.tencent.mm.plugin.emoji.sync.a();
    }
    com.tencent.mm.plugin.emoji.sync.a locala = ccj().pbq;
    AppMethodBeat.o(108646);
    return locala;
  }
  
  private static com.tencent.mm.plugin.emoji.e.g cco()
  {
    try
    {
      AppMethodBeat.i(108647);
      com.tencent.mm.kernel.g.agP().afT();
      if (ccj().pbr == null) {
        ccj().pbr = new com.tencent.mm.plugin.emoji.e.g();
      }
      com.tencent.mm.plugin.emoji.e.g localg = ccj().pbr;
      AppMethodBeat.o(108647);
      return localg;
    }
    finally {}
  }
  
  private static com.tencent.mm.plugin.emoji.e.b ccp()
  {
    AppMethodBeat.i(108648);
    com.tencent.mm.kernel.g.agP().afT();
    if (ccj().pbs == null) {
      ccj().pbs = new com.tencent.mm.plugin.emoji.e.b();
    }
    com.tencent.mm.plugin.emoji.e.b localb = ccj().pbs;
    AppMethodBeat.o(108648);
    return localb;
  }
  
  public static com.tencent.mm.plugin.emoji.e.i ccq()
  {
    AppMethodBeat.i(108650);
    com.tencent.mm.kernel.g.agP().afT();
    if (ccj().pbt == null) {
      ccj().pbt = new com.tencent.mm.plugin.emoji.e.i();
    }
    com.tencent.mm.plugin.emoji.e.i locali = ccj().pbt;
    AppMethodBeat.o(108650);
    return locali;
  }
  
  public static e ccr()
  {
    AppMethodBeat.i(108653);
    com.tencent.mm.kernel.g.agP().afT();
    if (ccj().pbp == null) {
      ccj().pbp = new e();
    }
    e locale = ccj().pbp;
    AppMethodBeat.o(108653);
    return locale;
  }
  
  public static av getEmojiDescMgr()
  {
    AppMethodBeat.i(108644);
    if (ccj().pbl == null) {
      ccj().pbl = av.faV();
    }
    av localav = ccj().pbl;
    AppMethodBeat.o(108644);
    return localav;
  }
  
  public static az getEmojiStorageMgr()
  {
    AppMethodBeat.i(108649);
    az localaz = az.faZ();
    AppMethodBeat.o(108649);
    return localaz;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(108652);
    ac.i("MicroMsg.emoji.SubCoreEmoji", "[onAccountPostReset]");
    com.tencent.mm.pluginsdk.ui.chat.e.DyA = new e.b()
    {
      public final ChatFooterPanel eA(Context paramAnonymousContext)
      {
        AppMethodBeat.i(207443);
        paramAnonymousContext = new SmileyPanelImpl(paramAnonymousContext, false);
        AppMethodBeat.o(207443);
        return paramAnonymousContext;
      }
    };
    com.tencent.mm.pluginsdk.ui.chat.e.DyB = new e.a() {};
    az.faZ().fba();
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).setEmojiMgr();
    Object localObject1 = cco();
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("emotionstore", ((com.tencent.mm.plugin.emoji.e.g)localObject1).oYV, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("NewRecommendEmotion", ((com.tencent.mm.plugin.emoji.e.g)localObject1).oYW, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("EmojiBackup", ((com.tencent.mm.plugin.emoji.e.g)localObject1).oYX, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("EmotionBackup", ((com.tencent.mm.plugin.emoji.e.g)localObject1).oYX, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("SelfieEmojiBackup", ((com.tencent.mm.plugin.emoji.e.g)localObject1).oYX, true);
    localObject1 = ccp();
    com.tencent.mm.sdk.b.a.GpY.c(((com.tencent.mm.plugin.emoji.e.b)localObject1).oYw);
    com.tencent.mm.sdk.b.a.GpY.c(((com.tencent.mm.plugin.emoji.e.b)localObject1).oYA);
    com.tencent.mm.sdk.b.a.GpY.c(((com.tencent.mm.plugin.emoji.e.b)localObject1).oYB);
    com.tencent.mm.sdk.b.a.GpY.c(((com.tencent.mm.plugin.emoji.e.b)localObject1).oYC);
    com.tencent.mm.plugin.emoji.e.b.appForegroundListener.alive();
    com.tencent.mm.sdk.b.a.GpY.c(((com.tencent.mm.plugin.emoji.e.b)localObject1).oYD);
    com.tencent.mm.sdk.b.a.GpY.c(((com.tencent.mm.plugin.emoji.e.b)localObject1).oYE);
    com.tencent.mm.sdk.b.a.GpY.c(((com.tencent.mm.plugin.emoji.e.b)localObject1).checkLanguageChangeIListener);
    com.tencent.mm.sdk.b.a.GpY.c(((com.tencent.mm.plugin.emoji.e.b)localObject1).oYF);
    com.tencent.mm.sdk.b.a.GpY.c(((com.tencent.mm.plugin.emoji.e.b)localObject1).oYG);
    com.tencent.mm.sdk.b.a.GpY.c(((com.tencent.mm.plugin.emoji.e.b)localObject1).oYx);
    com.tencent.mm.sdk.b.a.GpY.c(((com.tencent.mm.plugin.emoji.e.b)localObject1).oYy);
    com.tencent.mm.sdk.b.a.GpY.c(((com.tencent.mm.plugin.emoji.e.b)localObject1).oYH);
    com.tencent.mm.sdk.b.a.GpY.c(((com.tencent.mm.plugin.emoji.e.b)localObject1).oYI);
    com.tencent.mm.sdk.b.a.GpY.c(((com.tencent.mm.plugin.emoji.e.b)localObject1).oYz);
    localObject1 = az.faZ();
    ((az)localObject1).GXZ.add(((az)localObject1).GYt);
    ((az)localObject1).GYa.add(((az)localObject1).GYr);
    ((az)localObject1).GYb.add(((az)localObject1).GYs);
    com.tencent.mm.sdk.b.a.GpY.c(((az)localObject1).GYu);
    getEmojiDescMgr();
    localObject1 = ccq();
    Object localObject2 = com.tencent.mm.m.g.ZY().getValue("EmotionRewardTipsLimit");
    long l;
    if (!bs.isNullOrNil((String)localObject2))
    {
      ac.i("MicroMsg.emoji.EmojiRewardTipMgr", "updateConfig dynamic config %s", new Object[] { localObject2 });
      localObject2 = ((String)localObject2).split(",");
      if ((localObject2 != null) && (localObject2.length == 3))
      {
        if (bs.getInt(localObject2[0], 0) != 0) {
          break label1340;
        }
        l = 863913600000L;
        ((com.tencent.mm.plugin.emoji.e.i)localObject1).oZI = l;
        ((com.tencent.mm.plugin.emoji.e.i)localObject1).oZJ = (bs.getInt(localObject2[1], 20) - 1);
        ((com.tencent.mm.plugin.emoji.e.i)localObject1).fAr = (bs.getInt(localObject2[2], 80) - 1);
      }
    }
    boolean bool2 = com.tencent.mm.emoji.a.m.acq();
    boolean bool3 = ((Boolean)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GEl, Boolean.TRUE)).booleanValue();
    boolean bool1;
    if ((bool2) && (bool3))
    {
      bool1 = true;
      label588:
      ((com.tencent.mm.plugin.emoji.e.i)localObject1).oZH = bool1;
      ac.i("MicroMsg.emoji.EmojiRewardTipMgr", "init RewardTipMgr RewardTipEnable:%b isEnableRewardTip:%b isTipsEnable:%b", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.emoji.e.i)localObject1).oZH), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      com.tencent.mm.kernel.g.agU().az(new i.1((com.tencent.mm.plugin.emoji.e.i)localObject1));
      localObject1 = ccn().pcK;
      ac.d("MicroMsg.BKGLoader.BKGLoaderManager", "bkg attach");
      com.tencent.mm.sdk.b.a.GpY.c(((BKGLoaderManager)localObject1).pdi);
      com.tencent.mm.sdk.b.a.GpY.c(((BKGLoaderManager)localObject1).pdj);
      localObject2 = new IntentFilter();
      ((IntentFilter)localObject2).addAction("android.net.conn.CONNECTIVITY_CHANGE");
      ((BKGLoaderManager)localObject1).pde = new BKGLoaderManager.ConnectivityReceiver((BKGLoaderManager)localObject1);
      ai.getContext().registerReceiver(((BKGLoaderManager)localObject1).pde, (IntentFilter)localObject2);
      ac.i("MicroMsg.emoji.SubCoreEmoji", "[oneliang]initCore");
      localObject1 = az.faZ();
      localObject2 = ai.getContext();
      if (localObject2 != null)
      {
        bool1 = ((Boolean)com.tencent.mm.kernel.g.agR().agA().get(274480, Boolean.TRUE)).booleanValue();
        ac.i("MicroMsg.emoji.EmojiStorageMgr", "[oneliang]initCore,need init emoji:%s", new Object[] { String.valueOf(bool1) });
        if (bool1)
        {
          ((az)localObject1).GXZ.init((Context)localObject2);
          ((az)localObject1).GYa.init((Context)localObject2);
        }
        com.tencent.mm.kernel.g.agR().agA().set(274480, Boolean.FALSE);
      }
      if (((Integer)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GEm, Integer.valueOf(0))).intValue() != com.tencent.mm.protocal.d.DIc)
      {
        l = System.currentTimeMillis();
        ((az)localObject1).GYa.fcY();
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GEm, Integer.valueOf(com.tencent.mm.protocal.d.DIc));
        ac.i("MicroMsg.emoji.EmojiStorageMgr", "recoverCustomEmojiGroup use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      }
      if (((Boolean)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GEn, Boolean.TRUE)).booleanValue())
      {
        l = System.currentTimeMillis();
        bool1 = ((az)localObject1).GYa.fcZ();
        localObject1 = com.tencent.mm.kernel.g.agR().agA();
        localObject2 = ah.a.GEn;
        if (bool1) {
          break label1363;
        }
        bool1 = true;
        label983:
        ((ae)localObject1).set((ah.a)localObject2, Boolean.valueOf(bool1));
        ac.i("MicroMsg.emoji.EmojiStorageMgr", "updateEmojiGroupCount use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      }
      this.pbn = new l();
      this.pbo = new g();
      com.tencent.mm.aq.a.eL(paramBoolean);
      paramBoolean = com.tencent.mm.cf.f.eXr().eXt();
      bool1 = com.tencent.mm.cf.e.eXp().eXo();
      if ((paramBoolean) && (((Integer)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GEo, Integer.valueOf(0))).intValue() > 0))
      {
        com.tencent.mm.pluginsdk.h.a.a.b.eLH().f(37, 1, -1, false);
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GEo, Integer.valueOf(0));
        localObject1 = new com.tencent.mm.pluginsdk.h.a.a.m(37);
        com.tencent.mm.kernel.g.agQ().ghe.a((n)localObject1, 0);
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(165L, 10L, 1L, false);
      }
      if ((bool1) && (((Integer)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GEp, Integer.valueOf(0))).intValue() > 0))
      {
        com.tencent.mm.pluginsdk.h.a.a.b.eLH().f(37, 2, -1, false);
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GEp, Integer.valueOf(0));
        localObject1 = new com.tencent.mm.pluginsdk.h.a.a.m(37);
        com.tencent.mm.kernel.g.agQ().ghe.a((n)localObject1, 0);
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(165L, 11L, 1L, false);
      }
      localObject1 = com.tencent.mm.aq.b.aEj();
      ac.i("MicroMsg.FontResLogic", "init");
      ((com.tencent.mm.aq.b)localObject1).hEc.alive();
      if (!((com.tencent.mm.aq.b)localObject1).aEm()) {
        break label1368;
      }
      com.tencent.mm.plugin.report.service.h.wUl.n(933L, 4L, 1L);
    }
    for (;;)
    {
      localObject1 = EmojiSyncManager.fVR;
      EmojiSyncManager.a.adD().init();
      localObject1 = EmojiSyncManager.fVR;
      EmojiSyncManager.a.adE().init();
      localObject1 = j.fQF;
      j.acm();
      com.tencent.mm.flutter.d.fXK.add(h.class);
      AppMethodBeat.o(108652);
      return;
      label1340:
      l = bs.getInt(localObject2[0], 0) * 86400000L;
      break;
      bool1 = false;
      break label588;
      label1363:
      bool1 = false;
      break label983;
      label1368:
      com.tencent.mm.plugin.report.service.h.wUl.n(933L, 5L, 1L);
      com.tencent.mm.pluginsdk.h.a.a.b.eLH();
      localObject2 = com.tencent.mm.pluginsdk.h.a.a.b.ja(57, 1);
      if (com.tencent.mm.vfs.i.eA((String)localObject2))
      {
        com.tencent.mm.plugin.report.service.h.wUl.n(933L, 6L, 1L);
        ac.i("MicroMsg.FontResLogic", "cache file exist %s", new Object[] { localObject2 });
        ((com.tencent.mm.aq.b)localObject1).f((String)localObject2, 57, 1, 1);
      }
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(108651);
    ac.i("MicroMsg.emoji.SubCoreEmoji", "onAccountRelease: ");
    Object localObject = cco();
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().b("emotionstore", ((com.tencent.mm.plugin.emoji.e.g)localObject).oYV, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().b("NewRecommendEmotion", ((com.tencent.mm.plugin.emoji.e.g)localObject).oYW, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().b("EmojiBackup", ((com.tencent.mm.plugin.emoji.e.g)localObject).oYX, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().b("EmotionBackup", ((com.tencent.mm.plugin.emoji.e.g)localObject).oYX, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().b("SelfieEmojiBackup", ((com.tencent.mm.plugin.emoji.e.g)localObject).oYX, true);
    localObject = ccp();
    com.tencent.mm.plugin.emoji.e.b.appForegroundListener.dead();
    com.tencent.mm.sdk.b.a.GpY.d(((com.tencent.mm.plugin.emoji.e.b)localObject).oYw);
    com.tencent.mm.sdk.b.a.GpY.d(((com.tencent.mm.plugin.emoji.e.b)localObject).oYA);
    com.tencent.mm.sdk.b.a.GpY.d(((com.tencent.mm.plugin.emoji.e.b)localObject).oYB);
    com.tencent.mm.sdk.b.a.GpY.d(((com.tencent.mm.plugin.emoji.e.b)localObject).oYC);
    com.tencent.mm.sdk.b.a.GpY.d(((com.tencent.mm.plugin.emoji.e.b)localObject).oYD);
    com.tencent.mm.sdk.b.a.GpY.d(((com.tencent.mm.plugin.emoji.e.b)localObject).oYE);
    com.tencent.mm.sdk.b.a.GpY.d(((com.tencent.mm.plugin.emoji.e.b)localObject).checkLanguageChangeIListener);
    com.tencent.mm.sdk.b.a.GpY.d(((com.tencent.mm.plugin.emoji.e.b)localObject).oYF);
    com.tencent.mm.sdk.b.a.GpY.d(((com.tencent.mm.plugin.emoji.e.b)localObject).oYG);
    com.tencent.mm.sdk.b.a.GpY.d(((com.tencent.mm.plugin.emoji.e.b)localObject).oYx);
    com.tencent.mm.sdk.b.a.GpY.d(((com.tencent.mm.plugin.emoji.e.b)localObject).oYy);
    com.tencent.mm.sdk.b.a.GpY.d(((com.tencent.mm.plugin.emoji.e.b)localObject).oYH);
    com.tencent.mm.sdk.b.a.GpY.d(((com.tencent.mm.plugin.emoji.e.b)localObject).oYI);
    com.tencent.mm.sdk.b.a.GpY.d(((com.tencent.mm.plugin.emoji.e.b)localObject).oYz);
    localObject = az.faZ();
    ((az)localObject).GXZ.remove(((az)localObject).GYt);
    ((az)localObject).GYa.remove(((az)localObject).GYr);
    ((az)localObject).GYb.remove(((az)localObject).GYs);
    com.tencent.mm.sdk.b.a.GpY.d(((az)localObject).GYu);
    localObject = ((az)localObject).GYn;
    if (((com.tencent.mm.emoji.a.i)localObject).fQA != null) {
      ((com.tencent.mm.emoji.a.i)localObject).fQA.clear();
    }
    ((com.tencent.mm.emoji.a.i)localObject).fQB.clear();
    getEmojiDescMgr().clear();
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).removeEmojiMgr();
    localObject = ccl();
    com.tencent.mm.kernel.g.agQ().ghe.b(175, (com.tencent.mm.ak.g)localObject);
    ((c)localObject).pak.clear();
    ((c)localObject).pai.clear();
    localObject = ccq();
    ((com.tencent.mm.plugin.emoji.e.i)localObject).oZK = null;
    if (((com.tencent.mm.plugin.emoji.e.i)localObject).oZL != null) {
      ((com.tencent.mm.plugin.emoji.e.i)localObject).oZL.clear();
    }
    localObject = ccn().pcK;
    ac.d("MicroMsg.BKGLoader.BKGLoaderManager", "bkg detach");
    ((BKGLoaderManager)localObject).ccJ();
    com.tencent.mm.sdk.b.a.GpY.d(((BKGLoaderManager)localObject).pdi);
    com.tencent.mm.sdk.b.a.GpY.d(((BKGLoaderManager)localObject).pdj);
    if (((BKGLoaderManager)localObject).pde != null)
    {
      ai.getContext().unregisterReceiver(((BKGLoaderManager)localObject).pde);
      ((BKGLoaderManager)localObject).pde = null;
    }
    if (this.pbn != null)
    {
      localObject = this.pbn;
      com.tencent.mm.sdk.b.a.GpY.d(((l)localObject).pbz);
      com.tencent.mm.sdk.b.a.GpY.d(((l)localObject).pbA);
    }
    if (this.pbo != null)
    {
      localObject = this.pbo;
      ((g)localObject).paE.clear();
      ccl().pam = null;
      ((g)localObject).paF.dead();
    }
    if (this.pbu != null) {
      this.pbu.detach();
    }
    com.tencent.mm.aq.b.aEj().hEc.dead();
    localObject = EmojiSyncManager.fVR;
    EmojiSyncManager.a.adD().destroy();
    localObject = EmojiSyncManager.fVR;
    EmojiSyncManager.a.adE().destroy();
    AppMethodBeat.o(108651);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.k
 * JD-Core Version:    0.7.0.1
 */
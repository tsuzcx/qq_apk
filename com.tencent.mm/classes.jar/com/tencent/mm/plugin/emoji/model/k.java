package com.tencent.mm.plugin.emoji.model;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.app.n.a;
import com.tencent.mm.aw.a.a.b.a;
import com.tencent.mm.emoji.sync.EmojiSyncManager;
import com.tencent.mm.emoji.sync.EmojiSyncManager.a;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.emoji.e.i.1;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager.ConnectivityReceiver;
import com.tencent.mm.pluginsdk.h.a.a.m;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.e.a;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.emotion.j;
import com.tencent.mm.storage.emotion.r;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.view.SmileyPanelImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class k
  implements com.tencent.mm.model.aw
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private c oxK;
  private as oxL;
  private com.tencent.mm.plugin.emoji.e.f oxM;
  private l oxN;
  private g oxO;
  private e oxP;
  private com.tencent.mm.plugin.emoji.sync.a<com.tencent.mm.plugin.emoji.sync.c> oxQ;
  private volatile com.tencent.mm.plugin.emoji.e.g oxR;
  private volatile com.tencent.mm.plugin.emoji.e.b oxS;
  private volatile com.tencent.mm.plugin.emoji.e.i oxT;
  private com.tencent.mm.aw.a.a oxU;
  
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
    baseDBFactories.put(Integer.valueOf("EMOTIONDETAIL_TABLE".hashCode()), new k.10());
    baseDBFactories.put(Integer.valueOf("GETEMOTIONLISTCACHE_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return r.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("EmotionRewardINFO_TABLE".hashCode()), new k.12());
    baseDBFactories.put(Integer.valueOf("EmotionDesignerInfoStorage_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return j.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("EmotionRewardTipStorage_TABLE".hashCode()), new k.14());
    baseDBFactories.put(Integer.valueOf("SmileyInfoStorage_TABLE".hashCode()), new k.15());
    baseDBFactories.put(Integer.valueOf("SmileyPanelConfigInfoStorage_TABLE".hashCode()), new k.2());
    baseDBFactories.put(Integer.valueOf("EmojiDescMapStorage".hashCode()), new k.3());
    baseDBFactories.put(Integer.valueOf("EmojiDesignerProductStorage_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.storage.emotion.b.SQL_CREATE;
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
  
  private static k bUW()
  {
    AppMethodBeat.i(108641);
    k localk = (k)t.ap(k.class);
    AppMethodBeat.o(108641);
    return localk;
  }
  
  public static com.tencent.mm.aw.a.a bUX()
  {
    AppMethodBeat.i(108642);
    com.tencent.mm.kernel.g.afz().aeD();
    if (bUW().oxU == null)
    {
      localObject = new b.a(aj.getContext());
      ((b.a)localObject).hjJ = new com.tencent.mm.plugin.emoji.d.a();
      ((b.a)localObject).hjH = new com.tencent.mm.view.c.a();
      localObject = ((b.a)localObject).ayR();
      bUW().oxU = new com.tencent.mm.aw.a.a((com.tencent.mm.aw.a.a.b)localObject);
    }
    Object localObject = bUW().oxU;
    AppMethodBeat.o(108642);
    return localObject;
  }
  
  public static c bUY()
  {
    AppMethodBeat.i(108643);
    com.tencent.mm.kernel.g.afz().aeD();
    if (bUW().oxK == null) {
      bUW().oxK = new c();
    }
    c localc = bUW().oxK;
    AppMethodBeat.o(108643);
    return localc;
  }
  
  public static com.tencent.mm.plugin.emoji.e.f bUZ()
  {
    AppMethodBeat.i(108645);
    com.tencent.mm.kernel.g.afz().aeD();
    if (bUW().oxM == null) {
      bUW().oxM = new com.tencent.mm.plugin.emoji.e.f();
    }
    com.tencent.mm.plugin.emoji.e.f localf = bUW().oxM;
    AppMethodBeat.o(108645);
    return localf;
  }
  
  public static com.tencent.mm.plugin.emoji.sync.a<com.tencent.mm.plugin.emoji.sync.c> bVa()
  {
    AppMethodBeat.i(108646);
    com.tencent.mm.kernel.g.afz().aeD();
    if (bUW().oxQ == null) {
      bUW().oxQ = new com.tencent.mm.plugin.emoji.sync.a();
    }
    com.tencent.mm.plugin.emoji.sync.a locala = bUW().oxQ;
    AppMethodBeat.o(108646);
    return locala;
  }
  
  private static com.tencent.mm.plugin.emoji.e.g bVb()
  {
    try
    {
      AppMethodBeat.i(108647);
      com.tencent.mm.kernel.g.afz().aeD();
      if (bUW().oxR == null) {
        bUW().oxR = new com.tencent.mm.plugin.emoji.e.g();
      }
      com.tencent.mm.plugin.emoji.e.g localg = bUW().oxR;
      AppMethodBeat.o(108647);
      return localg;
    }
    finally {}
  }
  
  private static com.tencent.mm.plugin.emoji.e.b bVc()
  {
    AppMethodBeat.i(108648);
    com.tencent.mm.kernel.g.afz().aeD();
    if (bUW().oxS == null) {
      bUW().oxS = new com.tencent.mm.plugin.emoji.e.b();
    }
    com.tencent.mm.plugin.emoji.e.b localb = bUW().oxS;
    AppMethodBeat.o(108648);
    return localb;
  }
  
  public static com.tencent.mm.plugin.emoji.e.i bVd()
  {
    AppMethodBeat.i(108650);
    com.tencent.mm.kernel.g.afz().aeD();
    if (bUW().oxT == null) {
      bUW().oxT = new com.tencent.mm.plugin.emoji.e.i();
    }
    com.tencent.mm.plugin.emoji.e.i locali = bUW().oxT;
    AppMethodBeat.o(108650);
    return locali;
  }
  
  public static e bVe()
  {
    AppMethodBeat.i(108653);
    com.tencent.mm.kernel.g.afz().aeD();
    if (bUW().oxP == null) {
      bUW().oxP = new e();
    }
    e locale = bUW().oxP;
    AppMethodBeat.o(108653);
    return locale;
  }
  
  public static as getEmojiDescMgr()
  {
    AppMethodBeat.i(108644);
    com.tencent.mm.kernel.g.afz().aeD();
    if (bUW().oxL == null) {
      bUW().oxL = new as();
    }
    as localas = bUW().oxL;
    AppMethodBeat.o(108644);
    return localas;
  }
  
  public static com.tencent.mm.storage.aw getEmojiStorageMgr()
  {
    AppMethodBeat.i(108649);
    com.tencent.mm.storage.aw localaw = com.tencent.mm.storage.aw.eLx();
    AppMethodBeat.o(108649);
    return localaw;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(108652);
    ad.i("MicroMsg.emoji.SubCoreEmoji", "[onAccountPostReset]");
    com.tencent.mm.pluginsdk.ui.chat.e.Cgj = new e.b()
    {
      public final ChatFooterPanel es(Context paramAnonymousContext)
      {
        AppMethodBeat.i(179056);
        paramAnonymousContext = new SmileyPanelImpl(paramAnonymousContext, false);
        AppMethodBeat.o(179056);
        return paramAnonymousContext;
      }
    };
    com.tencent.mm.pluginsdk.ui.chat.e.Cgk = new e.a() {};
    com.tencent.mm.storage.aw.eLx().eLy();
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).setEmojiMgr();
    Object localObject1 = bVb();
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("emotionstore", ((com.tencent.mm.plugin.emoji.e.g)localObject1).ovv, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("NewRecommendEmotion", ((com.tencent.mm.plugin.emoji.e.g)localObject1).ovw, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("EmojiBackup", ((com.tencent.mm.plugin.emoji.e.g)localObject1).ovx, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("EmotionBackup", ((com.tencent.mm.plugin.emoji.e.g)localObject1).ovx, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("SelfieEmojiBackup", ((com.tencent.mm.plugin.emoji.e.g)localObject1).ovx, true);
    localObject1 = bVc();
    com.tencent.mm.sdk.b.a.ESL.c(((com.tencent.mm.plugin.emoji.e.b)localObject1).ouW);
    com.tencent.mm.sdk.b.a.ESL.c(((com.tencent.mm.plugin.emoji.e.b)localObject1).ova);
    com.tencent.mm.sdk.b.a.ESL.c(((com.tencent.mm.plugin.emoji.e.b)localObject1).ovb);
    com.tencent.mm.sdk.b.a.ESL.c(((com.tencent.mm.plugin.emoji.e.b)localObject1).ovc);
    com.tencent.mm.plugin.emoji.e.b.appForegroundListener.alive();
    com.tencent.mm.sdk.b.a.ESL.c(((com.tencent.mm.plugin.emoji.e.b)localObject1).ovd);
    com.tencent.mm.sdk.b.a.ESL.c(((com.tencent.mm.plugin.emoji.e.b)localObject1).ove);
    com.tencent.mm.sdk.b.a.ESL.c(((com.tencent.mm.plugin.emoji.e.b)localObject1).checkLanguageChangeIListener);
    com.tencent.mm.sdk.b.a.ESL.c(((com.tencent.mm.plugin.emoji.e.b)localObject1).ovf);
    com.tencent.mm.sdk.b.a.ESL.c(((com.tencent.mm.plugin.emoji.e.b)localObject1).ovg);
    com.tencent.mm.sdk.b.a.ESL.c(((com.tencent.mm.plugin.emoji.e.b)localObject1).ouX);
    com.tencent.mm.sdk.b.a.ESL.c(((com.tencent.mm.plugin.emoji.e.b)localObject1).ouY);
    com.tencent.mm.sdk.b.a.ESL.c(((com.tencent.mm.plugin.emoji.e.b)localObject1).ovh);
    com.tencent.mm.sdk.b.a.ESL.c(((com.tencent.mm.plugin.emoji.e.b)localObject1).ovi);
    com.tencent.mm.sdk.b.a.ESL.c(((com.tencent.mm.plugin.emoji.e.b)localObject1).ouZ);
    localObject1 = com.tencent.mm.storage.aw.eLx();
    ((com.tencent.mm.storage.aw)localObject1).FyY.add(((com.tencent.mm.storage.aw)localObject1).Fzr);
    ((com.tencent.mm.storage.aw)localObject1).FyZ.add(((com.tencent.mm.storage.aw)localObject1).Fzp);
    ((com.tencent.mm.storage.aw)localObject1).Fza.add(((com.tencent.mm.storage.aw)localObject1).Fzq);
    com.tencent.mm.sdk.b.a.ESL.c(((com.tencent.mm.storage.aw)localObject1).Fzs);
    getEmojiDescMgr();
    localObject1 = bVd();
    Object localObject2 = com.tencent.mm.m.g.Zd().getValue("EmotionRewardTipsLimit");
    long l;
    if (!bt.isNullOrNil((String)localObject2))
    {
      ad.i("MicroMsg.emoji.EmojiRewardTipMgr", "updateConfig dynamic config %s", new Object[] { localObject2 });
      localObject2 = ((String)localObject2).split(",");
      if ((localObject2 != null) && (localObject2.length == 3))
      {
        if (bt.getInt(localObject2[0], 0) != 0) {
          break label1343;
        }
        l = 863913600000L;
        ((com.tencent.mm.plugin.emoji.e.i)localObject1).owi = l;
        ((com.tencent.mm.plugin.emoji.e.i)localObject1).owj = (bt.getInt(localObject2[1], 20) - 1);
        ((com.tencent.mm.plugin.emoji.e.i)localObject1).fwK = (bt.getInt(localObject2[2], 80) - 1);
      }
    }
    boolean bool2 = com.tencent.mm.emoji.a.l.abr();
    boolean bool3 = ((Boolean)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fgx, Boolean.TRUE)).booleanValue();
    boolean bool1;
    if ((bool2) && (bool3))
    {
      bool1 = true;
      label588:
      ((com.tencent.mm.plugin.emoji.e.i)localObject1).owh = bool1;
      ad.i("MicroMsg.emoji.EmojiRewardTipMgr", "init RewardTipMgr RewardTipEnable:%b isEnableRewardTip:%b isTipsEnable:%b", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.emoji.e.i)localObject1).owh), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      com.tencent.mm.kernel.g.afE().ax(new i.1((com.tencent.mm.plugin.emoji.e.i)localObject1));
      localObject1 = bVa().ozk;
      ad.d("MicroMsg.BKGLoader.BKGLoaderManager", "bkg attach");
      com.tencent.mm.sdk.b.a.ESL.c(((BKGLoaderManager)localObject1).ozI);
      com.tencent.mm.sdk.b.a.ESL.c(((BKGLoaderManager)localObject1).ozJ);
      localObject2 = new IntentFilter();
      ((IntentFilter)localObject2).addAction("android.net.conn.CONNECTIVITY_CHANGE");
      ((BKGLoaderManager)localObject1).ozE = new BKGLoaderManager.ConnectivityReceiver((BKGLoaderManager)localObject1);
      aj.getContext().registerReceiver(((BKGLoaderManager)localObject1).ozE, (IntentFilter)localObject2);
      ad.i("MicroMsg.emoji.SubCoreEmoji", "[oneliang]initCore");
      localObject1 = com.tencent.mm.storage.aw.eLx();
      localObject2 = aj.getContext();
      if (localObject2 != null)
      {
        bool1 = ((Boolean)com.tencent.mm.kernel.g.afB().afk().get(274480, Boolean.TRUE)).booleanValue();
        ad.i("MicroMsg.emoji.EmojiStorageMgr", "[oneliang]initCore,need init emoji:%s", new Object[] { String.valueOf(bool1) });
        if (bool1)
        {
          ((com.tencent.mm.storage.aw)localObject1).FyY.init((Context)localObject2);
          ((com.tencent.mm.storage.aw)localObject1).FyZ.init((Context)localObject2);
        }
        com.tencent.mm.kernel.g.afB().afk().set(274480, Boolean.FALSE);
      }
      if (((Integer)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fgy, Integer.valueOf(0))).intValue() != com.tencent.mm.protocal.d.CpK)
      {
        l = System.currentTimeMillis();
        ((com.tencent.mm.storage.aw)localObject1).FyZ.eNu();
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fgy, Integer.valueOf(com.tencent.mm.protocal.d.CpK));
        ad.i("MicroMsg.emoji.EmojiStorageMgr", "recoverCustomEmojiGroup use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      }
      if (((Boolean)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fgz, Boolean.TRUE)).booleanValue())
      {
        l = System.currentTimeMillis();
        bool1 = ((com.tencent.mm.storage.aw)localObject1).FyZ.eNv();
        localObject1 = com.tencent.mm.kernel.g.afB().afk();
        localObject2 = ae.a.Fgz;
        if (bool1) {
          break label1366;
        }
        bool1 = true;
        label983:
        ((ab)localObject1).set((ae.a)localObject2, Boolean.valueOf(bool1));
        ad.i("MicroMsg.emoji.EmojiStorageMgr", "updateEmojiGroupCount use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      }
      this.oxN = new l();
      this.oxO = new g();
      com.tencent.mm.ar.a.eq(paramBoolean);
      paramBoolean = com.tencent.mm.cg.f.eHV().eHX();
      bool1 = com.tencent.mm.cg.e.eHT().eHS();
      if ((paramBoolean) && (((Integer)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FgA, Integer.valueOf(0))).intValue() > 0))
      {
        com.tencent.mm.pluginsdk.h.a.a.b.ewn().e(37, 1, -1, false);
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.FgA, Integer.valueOf(0));
        localObject1 = new m(37);
        com.tencent.mm.kernel.g.afA().gcy.a((n)localObject1, 0);
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(165L, 10L, 1L, false);
      }
      if ((bool1) && (((Integer)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FgB, Integer.valueOf(0))).intValue() > 0))
      {
        com.tencent.mm.pluginsdk.h.a.a.b.ewn().e(37, 2, -1, false);
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.FgB, Integer.valueOf(0));
        localObject1 = new m(37);
        com.tencent.mm.kernel.g.afA().gcy.a((n)localObject1, 0);
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(165L, 11L, 1L, false);
      }
      localObject1 = com.tencent.mm.ar.b.axr();
      ad.i("MicroMsg.FontResLogic", "init");
      ((com.tencent.mm.ar.b)localObject1).hdz.alive();
      if (!((com.tencent.mm.ar.b)localObject1).axu()) {
        break label1371;
      }
      com.tencent.mm.plugin.report.service.h.vKh.m(933L, 4L, 1L);
    }
    for (;;)
    {
      localObject1 = EmojiSyncManager.fRW;
      EmojiSyncManager.a.acx().init();
      localObject1 = EmojiSyncManager.fRW;
      EmojiSyncManager.a.acy().init();
      localObject1 = com.tencent.mm.emoji.a.i.fMT;
      com.tencent.mm.emoji.a.i.abn();
      com.tencent.mm.emoji.a.i.report();
      com.tencent.mm.w.d.fTQ.add(h.class);
      AppMethodBeat.o(108652);
      return;
      label1343:
      l = bt.getInt(localObject2[0], 0) * 86400000L;
      break;
      bool1 = false;
      break label588;
      label1366:
      bool1 = false;
      break label983;
      label1371:
      com.tencent.mm.plugin.report.service.h.vKh.m(933L, 5L, 1L);
      com.tencent.mm.pluginsdk.h.a.a.b.ewn();
      localObject2 = com.tencent.mm.pluginsdk.h.a.a.b.iN(57, 1);
      if (com.tencent.mm.vfs.i.eK((String)localObject2))
      {
        com.tencent.mm.plugin.report.service.h.vKh.m(933L, 6L, 1L);
        ad.i("MicroMsg.FontResLogic", "cache file exist %s", new Object[] { localObject2 });
        ((com.tencent.mm.ar.b)localObject1).f((String)localObject2, 57, 1, 1);
      }
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(108651);
    ad.i("MicroMsg.emoji.SubCoreEmoji", "onAccountRelease: ");
    Object localObject = bVb();
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().b("emotionstore", ((com.tencent.mm.plugin.emoji.e.g)localObject).ovv, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().b("NewRecommendEmotion", ((com.tencent.mm.plugin.emoji.e.g)localObject).ovw, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().b("EmojiBackup", ((com.tencent.mm.plugin.emoji.e.g)localObject).ovx, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().b("EmotionBackup", ((com.tencent.mm.plugin.emoji.e.g)localObject).ovx, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().b("SelfieEmojiBackup", ((com.tencent.mm.plugin.emoji.e.g)localObject).ovx, true);
    localObject = bVc();
    com.tencent.mm.plugin.emoji.e.b.appForegroundListener.dead();
    com.tencent.mm.sdk.b.a.ESL.d(((com.tencent.mm.plugin.emoji.e.b)localObject).ouW);
    com.tencent.mm.sdk.b.a.ESL.d(((com.tencent.mm.plugin.emoji.e.b)localObject).ova);
    com.tencent.mm.sdk.b.a.ESL.d(((com.tencent.mm.plugin.emoji.e.b)localObject).ovb);
    com.tencent.mm.sdk.b.a.ESL.d(((com.tencent.mm.plugin.emoji.e.b)localObject).ovc);
    com.tencent.mm.sdk.b.a.ESL.d(((com.tencent.mm.plugin.emoji.e.b)localObject).ovd);
    com.tencent.mm.sdk.b.a.ESL.d(((com.tencent.mm.plugin.emoji.e.b)localObject).ove);
    com.tencent.mm.sdk.b.a.ESL.d(((com.tencent.mm.plugin.emoji.e.b)localObject).checkLanguageChangeIListener);
    com.tencent.mm.sdk.b.a.ESL.d(((com.tencent.mm.plugin.emoji.e.b)localObject).ovf);
    com.tencent.mm.sdk.b.a.ESL.d(((com.tencent.mm.plugin.emoji.e.b)localObject).ovg);
    com.tencent.mm.sdk.b.a.ESL.d(((com.tencent.mm.plugin.emoji.e.b)localObject).ouX);
    com.tencent.mm.sdk.b.a.ESL.d(((com.tencent.mm.plugin.emoji.e.b)localObject).ouY);
    com.tencent.mm.sdk.b.a.ESL.d(((com.tencent.mm.plugin.emoji.e.b)localObject).ovh);
    com.tencent.mm.sdk.b.a.ESL.d(((com.tencent.mm.plugin.emoji.e.b)localObject).ovi);
    com.tencent.mm.sdk.b.a.ESL.d(((com.tencent.mm.plugin.emoji.e.b)localObject).ouZ);
    localObject = com.tencent.mm.storage.aw.eLx();
    ((com.tencent.mm.storage.aw)localObject).FyY.remove(((com.tencent.mm.storage.aw)localObject).Fzr);
    ((com.tencent.mm.storage.aw)localObject).FyZ.remove(((com.tencent.mm.storage.aw)localObject).Fzp);
    ((com.tencent.mm.storage.aw)localObject).Fza.remove(((com.tencent.mm.storage.aw)localObject).Fzq);
    com.tencent.mm.sdk.b.a.ESL.d(((com.tencent.mm.storage.aw)localObject).Fzs);
    localObject = ((com.tencent.mm.storage.aw)localObject).Fzl;
    if (((com.tencent.mm.emoji.a.h)localObject).fMO != null) {
      ((com.tencent.mm.emoji.a.h)localObject).fMO.clear();
    }
    if (((com.tencent.mm.emoji.a.h)localObject).fMP != null) {
      ((com.tencent.mm.emoji.a.h)localObject).fMP.clear();
    }
    getEmojiDescMgr().clear();
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).removeEmojiMgr();
    localObject = bUY();
    com.tencent.mm.kernel.g.afA().gcy.b(175, (com.tencent.mm.al.g)localObject);
    ((c)localObject).owK.clear();
    ((c)localObject).owI.clear();
    localObject = bVd();
    ((com.tencent.mm.plugin.emoji.e.i)localObject).owk = null;
    if (((com.tencent.mm.plugin.emoji.e.i)localObject).owl != null) {
      ((com.tencent.mm.plugin.emoji.e.i)localObject).owl.clear();
    }
    localObject = bVa().ozk;
    ad.d("MicroMsg.BKGLoader.BKGLoaderManager", "bkg detach");
    ((BKGLoaderManager)localObject).bVw();
    com.tencent.mm.sdk.b.a.ESL.d(((BKGLoaderManager)localObject).ozI);
    com.tencent.mm.sdk.b.a.ESL.d(((BKGLoaderManager)localObject).ozJ);
    if (((BKGLoaderManager)localObject).ozE != null)
    {
      aj.getContext().unregisterReceiver(((BKGLoaderManager)localObject).ozE);
      ((BKGLoaderManager)localObject).ozE = null;
    }
    if (this.oxN != null)
    {
      localObject = this.oxN;
      com.tencent.mm.sdk.b.a.ESL.d(((l)localObject).oxZ);
      com.tencent.mm.sdk.b.a.ESL.d(((l)localObject).oya);
    }
    if (this.oxO != null)
    {
      localObject = this.oxO;
      ((g)localObject).oxe.clear();
      bUY().owM = null;
      ((g)localObject).oxf.dead();
    }
    if (this.oxU != null) {
      this.oxU.detach();
    }
    com.tencent.mm.ar.b.axr().hdz.dead();
    localObject = EmojiSyncManager.fRW;
    EmojiSyncManager.a.acx().destroy();
    localObject = EmojiSyncManager.fRW;
    EmojiSyncManager.a.acy().destroy();
    AppMethodBeat.o(108651);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.k
 * JD-Core Version:    0.7.0.1
 */
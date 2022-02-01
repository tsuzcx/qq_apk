package com.tencent.mm.plugin.emoji.model;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.av.a.a.b.a;
import com.tencent.mm.emoji.b.j;
import com.tencent.mm.emoji.b.n;
import com.tencent.mm.emoji.sync.EmojiSyncManager;
import com.tencent.mm.emoji.sync.EmojiSyncManager.a;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.emoji.e.i.1;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager.ConnectivityReceiver;
import com.tencent.mm.pluginsdk.j.a.a.m;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.e.a;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LruCache;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.SmileyPanelConfigInfo;
import com.tencent.mm.storage.emotion.o;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.view.SmileyPanelImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class k
  implements bd
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private d rbQ;
  private c rbR;
  private bf rbS;
  private com.tencent.mm.plugin.emoji.e.f rbT;
  private l rbU;
  private h rbV;
  private f rbW;
  private com.tencent.mm.plugin.emoji.sync.a<com.tencent.mm.plugin.emoji.sync.c> rbX;
  private volatile com.tencent.mm.plugin.emoji.e.g rbY;
  private volatile com.tencent.mm.plugin.emoji.e.b rbZ;
  private volatile com.tencent.mm.plugin.emoji.e.i rca;
  private com.tencent.mm.av.a.a rcb;
  
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
    baseDBFactories.put(Integer.valueOf("EMOTIONDETAIL_TABLE".hashCode()), new k.12());
    baseDBFactories.put(Integer.valueOf("GETEMOTIONLISTCACHE_TABLE".hashCode()), new k.13());
    baseDBFactories.put(Integer.valueOf("EmotionRewardINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return o.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("EmotionDesignerInfoStorage_TABLE".hashCode()), new k.15());
    baseDBFactories.put(Integer.valueOf("EmotionRewardTipStorage_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.storage.emotion.q.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("SmileyInfoStorage_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.storage.emotion.t.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("SmileyPanelConfigInfoStorage_TABLE".hashCode()), new k.2());
    baseDBFactories.put(Integer.valueOf("EmojiDescMapStorage".hashCode()), new k.3());
    baseDBFactories.put(Integer.valueOf("EmojiDesignerProductStorage_TABLE".hashCode()), new k.4());
    baseDBFactories.put(Integer.valueOf("EmojiSuggestCacheStorage".hashCode()), new k.5());
    baseDBFactories.put(Integer.valueOf("DELETE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return new String[] { "DROP TABLE IF EXISTS EmotionDetail ", "DROP TABLE IF EXISTS EmojiSummaryInfo", "DROP TABLE IF EXISTS RewardMagicInfo" };
      }
    });
    AppMethodBeat.o(108654);
  }
  
  private static k cGb()
  {
    AppMethodBeat.i(108641);
    k localk = (k)y.at(k.class);
    AppMethodBeat.o(108641);
    return localk;
  }
  
  public static com.tencent.mm.av.a.a cGc()
  {
    AppMethodBeat.i(108642);
    com.tencent.mm.kernel.g.aAf().azk();
    if (cGb().rcb == null)
    {
      localObject = new b.a(MMApplicationContext.getContext());
      ((b.a)localObject).jaU = new com.tencent.mm.plugin.emoji.d.a();
      ((b.a)localObject).jaS = new com.tencent.mm.view.c.a();
      localObject = ((b.a)localObject).bdd();
      cGb().rcb = new com.tencent.mm.av.a.a((com.tencent.mm.av.a.a.b)localObject);
    }
    Object localObject = cGb().rcb;
    AppMethodBeat.o(108642);
    return localObject;
  }
  
  public static d cGd()
  {
    AppMethodBeat.i(108643);
    com.tencent.mm.kernel.g.aAf().azk();
    if (cGb().rbQ == null) {
      cGb().rbQ = new d();
    }
    d locald = cGb().rbQ;
    AppMethodBeat.o(108643);
    return locald;
  }
  
  public static c cGe()
  {
    AppMethodBeat.i(240152);
    com.tencent.mm.kernel.g.aAf().azk();
    if (cGb().rbR == null) {
      cGb().rbR = new c();
    }
    c localc = cGb().rbR;
    AppMethodBeat.o(240152);
    return localc;
  }
  
  public static com.tencent.mm.plugin.emoji.e.f cGf()
  {
    AppMethodBeat.i(108645);
    com.tencent.mm.kernel.g.aAf().azk();
    if (cGb().rbT == null) {
      cGb().rbT = new com.tencent.mm.plugin.emoji.e.f();
    }
    com.tencent.mm.plugin.emoji.e.f localf = cGb().rbT;
    AppMethodBeat.o(108645);
    return localf;
  }
  
  public static com.tencent.mm.plugin.emoji.sync.a<com.tencent.mm.plugin.emoji.sync.c> cGg()
  {
    AppMethodBeat.i(108646);
    com.tencent.mm.kernel.g.aAf().azk();
    if (cGb().rbX == null) {
      cGb().rbX = new com.tencent.mm.plugin.emoji.sync.a();
    }
    com.tencent.mm.plugin.emoji.sync.a locala = cGb().rbX;
    AppMethodBeat.o(108646);
    return locala;
  }
  
  private static com.tencent.mm.plugin.emoji.e.g cGh()
  {
    try
    {
      AppMethodBeat.i(108647);
      com.tencent.mm.kernel.g.aAf().azk();
      if (cGb().rbY == null) {
        cGb().rbY = new com.tencent.mm.plugin.emoji.e.g();
      }
      com.tencent.mm.plugin.emoji.e.g localg = cGb().rbY;
      AppMethodBeat.o(108647);
      return localg;
    }
    finally {}
  }
  
  private static com.tencent.mm.plugin.emoji.e.b cGi()
  {
    AppMethodBeat.i(108648);
    com.tencent.mm.kernel.g.aAf().azk();
    if (cGb().rbZ == null) {
      cGb().rbZ = new com.tencent.mm.plugin.emoji.e.b();
    }
    com.tencent.mm.plugin.emoji.e.b localb = cGb().rbZ;
    AppMethodBeat.o(108648);
    return localb;
  }
  
  public static com.tencent.mm.plugin.emoji.e.i cGj()
  {
    AppMethodBeat.i(108650);
    com.tencent.mm.kernel.g.aAf().azk();
    if (cGb().rca == null) {
      cGb().rca = new com.tencent.mm.plugin.emoji.e.i();
    }
    com.tencent.mm.plugin.emoji.e.i locali = cGb().rca;
    AppMethodBeat.o(108650);
    return locali;
  }
  
  public static f cGk()
  {
    AppMethodBeat.i(108653);
    com.tencent.mm.kernel.g.aAf().azk();
    if (cGb().rbW == null) {
      cGb().rbW = new f();
    }
    f localf = cGb().rbW;
    AppMethodBeat.o(108653);
    return localf;
  }
  
  public static bf getEmojiDescMgr()
  {
    AppMethodBeat.i(108644);
    if (cGb().rbS == null) {
      cGb().rbS = bf.gCF();
    }
    bf localbf = cGb().rbS;
    AppMethodBeat.o(108644);
    return localbf;
  }
  
  public static bj getEmojiStorageMgr()
  {
    AppMethodBeat.i(108649);
    bj localbj = bj.gCJ();
    AppMethodBeat.o(108649);
    return localbj;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(108652);
    Log.i("MicroMsg.emoji.SubCoreEmoji", "[onAccountPostReset]");
    com.tencent.mm.pluginsdk.ui.chat.e.Knc = new e.b()
    {
      public final ChatFooterPanel eZ(Context paramAnonymousContext)
      {
        AppMethodBeat.i(240150);
        paramAnonymousContext = new SmileyPanelImpl(paramAnonymousContext, false);
        AppMethodBeat.o(240150);
        return paramAnonymousContext;
      }
    };
    com.tencent.mm.pluginsdk.ui.chat.e.Knd = new e.a() {};
    bj.gCJ().gCK();
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).setEmojiMgr();
    Object localObject1 = cGh();
    ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("emotionstore", ((com.tencent.mm.plugin.emoji.e.g)localObject1).qZE, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("NewRecommendEmotion", ((com.tencent.mm.plugin.emoji.e.g)localObject1).qZF, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("EmojiBackup", ((com.tencent.mm.plugin.emoji.e.g)localObject1).qZG, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("EmotionBackup", ((com.tencent.mm.plugin.emoji.e.g)localObject1).qZG, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("SelfieEmojiBackup", ((com.tencent.mm.plugin.emoji.e.g)localObject1).qZG, true);
    localObject1 = cGi();
    EventCenter.instance.addListener(((com.tencent.mm.plugin.emoji.e.b)localObject1).qZf);
    EventCenter.instance.addListener(((com.tencent.mm.plugin.emoji.e.b)localObject1).qZj);
    EventCenter.instance.addListener(((com.tencent.mm.plugin.emoji.e.b)localObject1).qZk);
    EventCenter.instance.addListener(((com.tencent.mm.plugin.emoji.e.b)localObject1).qZl);
    com.tencent.mm.plugin.emoji.e.b.appForegroundListener.alive();
    EventCenter.instance.addListener(((com.tencent.mm.plugin.emoji.e.b)localObject1).qZm);
    EventCenter.instance.addListener(((com.tencent.mm.plugin.emoji.e.b)localObject1).qZn);
    EventCenter.instance.addListener(((com.tencent.mm.plugin.emoji.e.b)localObject1).checkLanguageChangeIListener);
    EventCenter.instance.addListener(((com.tencent.mm.plugin.emoji.e.b)localObject1).qZo);
    EventCenter.instance.addListener(((com.tencent.mm.plugin.emoji.e.b)localObject1).qZp);
    EventCenter.instance.addListener(((com.tencent.mm.plugin.emoji.e.b)localObject1).qZg);
    EventCenter.instance.addListener(((com.tencent.mm.plugin.emoji.e.b)localObject1).qZh);
    EventCenter.instance.addListener(((com.tencent.mm.plugin.emoji.e.b)localObject1).qZq);
    EventCenter.instance.addListener(((com.tencent.mm.plugin.emoji.e.b)localObject1).qZr);
    EventCenter.instance.addListener(((com.tencent.mm.plugin.emoji.e.b)localObject1).qZi);
    localObject1 = bj.gCJ();
    ((bj)localObject1).OpN.add(((bj)localObject1).wKf);
    ((bj)localObject1).OpO.add(((bj)localObject1).Oqf);
    ((bj)localObject1).OpP.add(((bj)localObject1).Oqg);
    EventCenter.instance.addListener(((bj)localObject1).wKg);
    getEmojiDescMgr();
    localObject1 = cGj();
    Object localObject2 = com.tencent.mm.n.h.aqJ().getValue("EmotionRewardTipsLimit");
    long l;
    if (!Util.isNullOrNil((String)localObject2))
    {
      Log.i("MicroMsg.emoji.EmojiRewardTipMgr", "updateConfig dynamic config %s", new Object[] { localObject2 });
      localObject2 = ((String)localObject2).split(",");
      if ((localObject2 != null) && (localObject2.length == 3))
      {
        if (Util.getInt(localObject2[0], 0) != 0) {
          break label1398;
        }
        l = 863913600000L;
        ((com.tencent.mm.plugin.emoji.e.i)localObject1).raz = l;
        ((com.tencent.mm.plugin.emoji.e.i)localObject1).raA = (Util.getInt(localObject2[1], 20) - 1);
        ((com.tencent.mm.plugin.emoji.e.i)localObject1).cSs = (Util.getInt(localObject2[2], 80) - 1);
      }
    }
    boolean bool2 = n.auW();
    boolean bool3 = ((Boolean)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NSY, Boolean.TRUE)).booleanValue();
    boolean bool1;
    if ((bool2) && (bool3))
    {
      bool1 = true;
      label588:
      ((com.tencent.mm.plugin.emoji.e.i)localObject1).ray = bool1;
      Log.i("MicroMsg.emoji.EmojiRewardTipMgr", "init RewardTipMgr RewardTipEnable:%b isEnableRewardTip:%b isTipsEnable:%b", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.emoji.e.i)localObject1).ray), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      com.tencent.mm.kernel.g.aAk().postToWorker(new i.1((com.tencent.mm.plugin.emoji.e.i)localObject1));
      localObject1 = cGg().rds;
      Log.d("MicroMsg.BKGLoader.BKGLoaderManager", "bkg attach");
      EventCenter.instance.addListener(((BKGLoaderManager)localObject1).rdQ);
      EventCenter.instance.addListener(((BKGLoaderManager)localObject1).rdR);
      localObject2 = new IntentFilter();
      ((IntentFilter)localObject2).addAction("android.net.conn.CONNECTIVITY_CHANGE");
      ((BKGLoaderManager)localObject1).rdM = new BKGLoaderManager.ConnectivityReceiver((BKGLoaderManager)localObject1);
      MMApplicationContext.getContext().registerReceiver(((BKGLoaderManager)localObject1).rdM, (IntentFilter)localObject2);
      Log.i("MicroMsg.emoji.SubCoreEmoji", "[oneliang]initCore");
      localObject1 = bj.gCJ();
      localObject2 = MMApplicationContext.getContext();
      if (localObject2 != null)
      {
        bool1 = ((Boolean)com.tencent.mm.kernel.g.aAh().azQ().get(274480, Boolean.TRUE)).booleanValue();
        Log.i("MicroMsg.emoji.EmojiStorageMgr", "[oneliang]initCore,need init emoji:%s", new Object[] { String.valueOf(bool1) });
        if (bool1)
        {
          ((bj)localObject1).OpN.init((Context)localObject2);
          ((bj)localObject1).OpO.init((Context)localObject2);
        }
        com.tencent.mm.kernel.g.aAh().azQ().set(274480, Boolean.FALSE);
      }
      if (((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NSZ, Integer.valueOf(0))).intValue() != com.tencent.mm.protocal.d.KyO)
      {
        l = System.currentTimeMillis();
        ((bj)localObject1).OpO.gET();
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NSZ, Integer.valueOf(com.tencent.mm.protocal.d.KyO));
        Log.i("MicroMsg.emoji.EmojiStorageMgr", "recoverCustomEmojiGroup use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      }
      if (((Boolean)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NTa, Boolean.TRUE)).booleanValue())
      {
        l = System.currentTimeMillis();
        bool1 = ((bj)localObject1).OpO.gEU();
        localObject1 = com.tencent.mm.kernel.g.aAh().azQ();
        localObject2 = ar.a.NTa;
        if (bool1) {
          break label1421;
        }
        bool1 = true;
        label983:
        ((ao)localObject1).set((ar.a)localObject2, Boolean.valueOf(bool1));
        Log.i("MicroMsg.emoji.EmojiStorageMgr", "updateEmojiGroupCount use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      }
      this.rbU = new l();
      this.rbV = new h();
      com.tencent.mm.aq.a.fF(paramBoolean);
      paramBoolean = com.tencent.mm.ce.f.gxT().gxV();
      bool1 = com.tencent.mm.ce.e.gxR().gxQ();
      if ((paramBoolean) && (((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NTb, Integer.valueOf(0))).intValue() > 0))
      {
        com.tencent.mm.pluginsdk.j.a.a.b.gnC().g(37, 1, -1, false);
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NTb, Integer.valueOf(0));
        localObject1 = new m(37);
        com.tencent.mm.kernel.g.aAg().hqi.a((com.tencent.mm.ak.q)localObject1, 0);
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(165L, 10L, 1L, false);
      }
      if ((bool1) && (((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NTc, Integer.valueOf(0))).intValue() > 0))
      {
        com.tencent.mm.pluginsdk.j.a.a.b.gnC().g(37, 2, -1, false);
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NTc, Integer.valueOf(0));
        localObject1 = new m(37);
        com.tencent.mm.kernel.g.aAg().hqi.a((com.tencent.mm.ak.q)localObject1, 0);
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(165L, 11L, 1L, false);
      }
      localObject1 = com.tencent.mm.aq.b.bby();
      Log.i("MicroMsg.FontResLogic", "init");
      ((com.tencent.mm.aq.b)localObject1).iUx.alive();
      if (!((com.tencent.mm.aq.b)localObject1).bbB()) {
        break label1426;
      }
      com.tencent.mm.plugin.report.service.h.CyF.n(933L, 4L, 1L);
    }
    for (;;)
    {
      localObject1 = EmojiSyncManager.hda;
      EmojiSyncManager.a.awn().init();
      localObject1 = EmojiSyncManager.hda;
      EmojiSyncManager.a.awo().init();
      localObject1 = com.tencent.mm.emoji.b.k.gXr;
      com.tencent.mm.emoji.b.k.auS();
      localObject1 = com.tencent.mm.emoji.e.a.hdT;
      if (!com.tencent.mm.vfs.s.YS(com.tencent.mm.emoji.e.a.aww()))
      {
        com.tencent.mm.pluginsdk.j.a.a.b.gnC();
        localObject1 = com.tencent.mm.pluginsdk.j.a.a.b.kC(37, 7);
        if (com.tencent.mm.vfs.s.YS((String)localObject1))
        {
          Log.i("MicroMsg.emoji.SubCoreEmoji", "update emoji anim res from cache");
          com.tencent.mm.plugin.emoji.e.h.cFT().amD((String)localObject1);
        }
      }
      com.tencent.f.h.RTc.aX(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(240151);
          Iterator localIterator = com.tencent.mm.ce.e.gxR().gxS().iterator();
          while (localIterator.hasNext())
          {
            SmileyPanelConfigInfo localSmileyPanelConfigInfo = (SmileyPanelConfigInfo)localIterator.next();
            com.tencent.mm.ce.e.gxR();
            com.tencent.mm.ce.e.bid(localSmileyPanelConfigInfo.field_key);
          }
          AppMethodBeat.o(240151);
        }
      });
      AppMethodBeat.o(108652);
      return;
      label1398:
      l = Util.getInt(localObject2[0], 0) * 86400000L;
      break;
      bool1 = false;
      break label588;
      label1421:
      bool1 = false;
      break label983;
      label1426:
      com.tencent.mm.plugin.report.service.h.CyF.n(933L, 5L, 1L);
      com.tencent.mm.pluginsdk.j.a.a.b.gnC();
      localObject2 = com.tencent.mm.pluginsdk.j.a.a.b.kC(57, 1);
      if (com.tencent.mm.vfs.s.YS((String)localObject2))
      {
        com.tencent.mm.plugin.report.service.h.CyF.n(933L, 6L, 1L);
        Log.i("MicroMsg.FontResLogic", "cache file exist %s", new Object[] { localObject2 });
        ((com.tencent.mm.aq.b)localObject1).f((String)localObject2, 57, 1, 1);
      }
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(108651);
    Log.i("MicroMsg.emoji.SubCoreEmoji", "onAccountRelease: ");
    Object localObject = cGh();
    ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().b("emotionstore", ((com.tencent.mm.plugin.emoji.e.g)localObject).qZE, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().b("NewRecommendEmotion", ((com.tencent.mm.plugin.emoji.e.g)localObject).qZF, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().b("EmojiBackup", ((com.tencent.mm.plugin.emoji.e.g)localObject).qZG, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().b("EmotionBackup", ((com.tencent.mm.plugin.emoji.e.g)localObject).qZG, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().b("SelfieEmojiBackup", ((com.tencent.mm.plugin.emoji.e.g)localObject).qZG, true);
    localObject = cGi();
    com.tencent.mm.plugin.emoji.e.b.appForegroundListener.dead();
    EventCenter.instance.removeListener(((com.tencent.mm.plugin.emoji.e.b)localObject).qZf);
    EventCenter.instance.removeListener(((com.tencent.mm.plugin.emoji.e.b)localObject).qZj);
    EventCenter.instance.removeListener(((com.tencent.mm.plugin.emoji.e.b)localObject).qZk);
    EventCenter.instance.removeListener(((com.tencent.mm.plugin.emoji.e.b)localObject).qZl);
    EventCenter.instance.removeListener(((com.tencent.mm.plugin.emoji.e.b)localObject).qZm);
    EventCenter.instance.removeListener(((com.tencent.mm.plugin.emoji.e.b)localObject).qZn);
    EventCenter.instance.removeListener(((com.tencent.mm.plugin.emoji.e.b)localObject).checkLanguageChangeIListener);
    EventCenter.instance.removeListener(((com.tencent.mm.plugin.emoji.e.b)localObject).qZo);
    EventCenter.instance.removeListener(((com.tencent.mm.plugin.emoji.e.b)localObject).qZp);
    EventCenter.instance.removeListener(((com.tencent.mm.plugin.emoji.e.b)localObject).qZg);
    EventCenter.instance.removeListener(((com.tencent.mm.plugin.emoji.e.b)localObject).qZh);
    EventCenter.instance.removeListener(((com.tencent.mm.plugin.emoji.e.b)localObject).qZq);
    EventCenter.instance.removeListener(((com.tencent.mm.plugin.emoji.e.b)localObject).qZr);
    EventCenter.instance.removeListener(((com.tencent.mm.plugin.emoji.e.b)localObject).qZi);
    localObject = bj.gCJ();
    ((bj)localObject).OpN.remove(((bj)localObject).wKf);
    ((bj)localObject).OpO.remove(((bj)localObject).Oqf);
    ((bj)localObject).OpP.remove(((bj)localObject).Oqg);
    EventCenter.instance.removeListener(((bj)localObject).wKg);
    localObject = ((bj)localObject).Oqb;
    if (((j)localObject).gXk != null) {
      ((j)localObject).gXk.clear();
    }
    ((j)localObject).gXl.evictAll();
    getEmojiDescMgr().clear();
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).removeEmojiMgr();
    localObject = cGd();
    com.tencent.mm.kernel.g.aAg().hqi.b(175, (com.tencent.mm.ak.i)localObject);
    ((d)localObject).rba.clear();
    ((d)localObject).rbe.clear();
    localObject = cGe();
    com.tencent.mm.kernel.g.aAg().hqi.b(3862, (com.tencent.mm.ak.i)localObject);
    com.tencent.mm.kernel.g.aAg().hqi.b(697, (com.tencent.mm.ak.i)localObject);
    ((c)localObject).rba.clear();
    ((c)localObject).rbb.clear();
    localObject = cGj();
    ((com.tencent.mm.plugin.emoji.e.i)localObject).raB = null;
    if (((com.tencent.mm.plugin.emoji.e.i)localObject).raC != null) {
      ((com.tencent.mm.plugin.emoji.e.i)localObject).raC.clear();
    }
    localObject = cGg().rds;
    Log.d("MicroMsg.BKGLoader.BKGLoaderManager", "bkg detach");
    ((BKGLoaderManager)localObject).cGB();
    EventCenter.instance.removeListener(((BKGLoaderManager)localObject).rdQ);
    EventCenter.instance.removeListener(((BKGLoaderManager)localObject).rdR);
    if (((BKGLoaderManager)localObject).rdM != null)
    {
      MMApplicationContext.getContext().unregisterReceiver(((BKGLoaderManager)localObject).rdM);
      ((BKGLoaderManager)localObject).rdM = null;
    }
    if (this.rbU != null)
    {
      localObject = this.rbU;
      EventCenter.instance.removeListener(((l)localObject).rcg);
      EventCenter.instance.removeListener(((l)localObject).rch);
    }
    if (this.rbV != null)
    {
      localObject = this.rbV;
      ((h)localObject).rby.clear();
      cGd().rbg = null;
      ((h)localObject).rbz.dead();
    }
    if (this.rcb != null) {
      this.rcb.detach();
    }
    com.tencent.mm.aq.b.bby().iUx.dead();
    localObject = EmojiSyncManager.hda;
    EmojiSyncManager.a.awn().destroy();
    localObject = EmojiSyncManager.hda;
    EmojiSyncManager.a.awo().destroy();
    AppMethodBeat.o(108651);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.k
 * JD-Core Version:    0.7.0.1
 */
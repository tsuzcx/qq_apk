package com.tencent.mm.plugin.emoji.model;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.app.n.a;
import com.tencent.mm.aw.a.a.b.a;
import com.tencent.mm.emoji.a.j;
import com.tencent.mm.emoji.sync.EmojiSyncManager;
import com.tencent.mm.emoji.sync.EmojiSyncManager.a;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.cd;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.emoji.e.i.1;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager.ConnectivityReceiver;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.e.a;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.s;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.view.SmileyPanelImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class k
  implements ax
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private c pEU;
  private az pEV;
  private com.tencent.mm.plugin.emoji.e.f pEW;
  private l pEX;
  private g pEY;
  private e pEZ;
  private com.tencent.mm.plugin.emoji.sync.a<com.tencent.mm.plugin.emoji.sync.c> pFa;
  private volatile com.tencent.mm.plugin.emoji.e.g pFb;
  private volatile com.tencent.mm.plugin.emoji.e.b pFc;
  private volatile com.tencent.mm.plugin.emoji.e.i pFd;
  private com.tencent.mm.aw.a.a pFe;
  
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
    baseDBFactories.put(Integer.valueOf("EMOTIONDETAIL_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.storage.emotion.m.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("GETEMOTIONLISTCACHE_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return s.SQL_CREATE;
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
  
  private static k cgN()
  {
    AppMethodBeat.i(108641);
    k localk = (k)t.ap(k.class);
    AppMethodBeat.o(108641);
    return localk;
  }
  
  public static com.tencent.mm.aw.a.a cgO()
  {
    AppMethodBeat.i(108642);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (cgN().pFe == null)
    {
      localObject = new b.a(aj.getContext());
      ((b.a)localObject).idg = new com.tencent.mm.plugin.emoji.d.a();
      ((b.a)localObject).ide = new com.tencent.mm.view.c.a();
      localObject = ((b.a)localObject).aIR();
      cgN().pFe = new com.tencent.mm.aw.a.a((com.tencent.mm.aw.a.a.b)localObject);
    }
    Object localObject = cgN().pFe;
    AppMethodBeat.o(108642);
    return localObject;
  }
  
  public static c cgP()
  {
    AppMethodBeat.i(108643);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (cgN().pEU == null) {
      cgN().pEU = new c();
    }
    c localc = cgN().pEU;
    AppMethodBeat.o(108643);
    return localc;
  }
  
  public static com.tencent.mm.plugin.emoji.e.f cgQ()
  {
    AppMethodBeat.i(108645);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (cgN().pEW == null) {
      cgN().pEW = new com.tencent.mm.plugin.emoji.e.f();
    }
    com.tencent.mm.plugin.emoji.e.f localf = cgN().pEW;
    AppMethodBeat.o(108645);
    return localf;
  }
  
  public static com.tencent.mm.plugin.emoji.sync.a<com.tencent.mm.plugin.emoji.sync.c> cgR()
  {
    AppMethodBeat.i(108646);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (cgN().pFa == null) {
      cgN().pFa = new com.tencent.mm.plugin.emoji.sync.a();
    }
    com.tencent.mm.plugin.emoji.sync.a locala = cgN().pFa;
    AppMethodBeat.o(108646);
    return locala;
  }
  
  private static com.tencent.mm.plugin.emoji.e.g cgS()
  {
    try
    {
      AppMethodBeat.i(108647);
      com.tencent.mm.kernel.g.ajA().aiF();
      if (cgN().pFb == null) {
        cgN().pFb = new com.tencent.mm.plugin.emoji.e.g();
      }
      com.tencent.mm.plugin.emoji.e.g localg = cgN().pFb;
      AppMethodBeat.o(108647);
      return localg;
    }
    finally {}
  }
  
  private static com.tencent.mm.plugin.emoji.e.b cgT()
  {
    AppMethodBeat.i(108648);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (cgN().pFc == null) {
      cgN().pFc = new com.tencent.mm.plugin.emoji.e.b();
    }
    com.tencent.mm.plugin.emoji.e.b localb = cgN().pFc;
    AppMethodBeat.o(108648);
    return localb;
  }
  
  public static com.tencent.mm.plugin.emoji.e.i cgU()
  {
    AppMethodBeat.i(108650);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (cgN().pFd == null) {
      cgN().pFd = new com.tencent.mm.plugin.emoji.e.i();
    }
    com.tencent.mm.plugin.emoji.e.i locali = cgN().pFd;
    AppMethodBeat.o(108650);
    return locali;
  }
  
  public static e cgV()
  {
    AppMethodBeat.i(108653);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (cgN().pEZ == null) {
      cgN().pEZ = new e();
    }
    e locale = cgN().pEZ;
    AppMethodBeat.o(108653);
    return locale;
  }
  
  public static az getEmojiDescMgr()
  {
    AppMethodBeat.i(108644);
    if (cgN().pEV == null) {
      cgN().pEV = az.fqY();
    }
    az localaz = cgN().pEV;
    AppMethodBeat.o(108644);
    return localaz;
  }
  
  public static bd getEmojiStorageMgr()
  {
    AppMethodBeat.i(108649);
    bd localbd = bd.frc();
    AppMethodBeat.o(108649);
    return localbd;
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
    com.tencent.mm.pluginsdk.ui.chat.e.FdJ = new e.b()
    {
      public final ChatFooterPanel eA(Context paramAnonymousContext)
      {
        AppMethodBeat.i(198746);
        paramAnonymousContext = new SmileyPanelImpl(paramAnonymousContext, false);
        AppMethodBeat.o(198746);
        return paramAnonymousContext;
      }
    };
    com.tencent.mm.pluginsdk.ui.chat.e.FdK = new e.a() {};
    bd.frc().frd();
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).setEmojiMgr();
    Object localObject1 = cgS();
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().a("emotionstore", ((com.tencent.mm.plugin.emoji.e.g)localObject1).pCF, true);
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().a("NewRecommendEmotion", ((com.tencent.mm.plugin.emoji.e.g)localObject1).pCG, true);
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().a("EmojiBackup", ((com.tencent.mm.plugin.emoji.e.g)localObject1).pCH, true);
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().a("EmotionBackup", ((com.tencent.mm.plugin.emoji.e.g)localObject1).pCH, true);
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().a("SelfieEmojiBackup", ((com.tencent.mm.plugin.emoji.e.g)localObject1).pCH, true);
    localObject1 = cgT();
    com.tencent.mm.sdk.b.a.IbL.c(((com.tencent.mm.plugin.emoji.e.b)localObject1).pCg);
    com.tencent.mm.sdk.b.a.IbL.c(((com.tencent.mm.plugin.emoji.e.b)localObject1).pCk);
    com.tencent.mm.sdk.b.a.IbL.c(((com.tencent.mm.plugin.emoji.e.b)localObject1).pCl);
    com.tencent.mm.sdk.b.a.IbL.c(((com.tencent.mm.plugin.emoji.e.b)localObject1).pCm);
    com.tencent.mm.plugin.emoji.e.b.appForegroundListener.alive();
    com.tencent.mm.sdk.b.a.IbL.c(((com.tencent.mm.plugin.emoji.e.b)localObject1).pCn);
    com.tencent.mm.sdk.b.a.IbL.c(((com.tencent.mm.plugin.emoji.e.b)localObject1).pCo);
    com.tencent.mm.sdk.b.a.IbL.c(((com.tencent.mm.plugin.emoji.e.b)localObject1).checkLanguageChangeIListener);
    com.tencent.mm.sdk.b.a.IbL.c(((com.tencent.mm.plugin.emoji.e.b)localObject1).pCp);
    com.tencent.mm.sdk.b.a.IbL.c(((com.tencent.mm.plugin.emoji.e.b)localObject1).pCq);
    com.tencent.mm.sdk.b.a.IbL.c(((com.tencent.mm.plugin.emoji.e.b)localObject1).pCh);
    com.tencent.mm.sdk.b.a.IbL.c(((com.tencent.mm.plugin.emoji.e.b)localObject1).pCi);
    com.tencent.mm.sdk.b.a.IbL.c(((com.tencent.mm.plugin.emoji.e.b)localObject1).pCr);
    com.tencent.mm.sdk.b.a.IbL.c(((com.tencent.mm.plugin.emoji.e.b)localObject1).pCs);
    com.tencent.mm.sdk.b.a.IbL.c(((com.tencent.mm.plugin.emoji.e.b)localObject1).pCj);
    localObject1 = bd.frc();
    ((bd)localObject1).ILn.add(((bd)localObject1).ILH);
    ((bd)localObject1).ILo.add(((bd)localObject1).ILF);
    ((bd)localObject1).ILp.add(((bd)localObject1).ILG);
    com.tencent.mm.sdk.b.a.IbL.c(((bd)localObject1).ILI);
    getEmojiDescMgr();
    localObject1 = cgU();
    Object localObject2 = com.tencent.mm.n.g.acA().getValue("EmotionRewardTipsLimit");
    long l;
    if (!bt.isNullOrNil((String)localObject2))
    {
      ad.i("MicroMsg.emoji.EmojiRewardTipMgr", "updateConfig dynamic config %s", new Object[] { localObject2 });
      localObject2 = ((String)localObject2).split(",");
      if ((localObject2 != null) && (localObject2.length == 3))
      {
        if (bt.getInt(localObject2[0], 0) != 0) {
          break label1340;
        }
        l = 863913600000L;
        ((com.tencent.mm.plugin.emoji.e.i)localObject1).pDs = l;
        ((com.tencent.mm.plugin.emoji.e.i)localObject1).pDt = (bt.getInt(localObject2[1], 20) - 1);
        ((com.tencent.mm.plugin.emoji.e.i)localObject1).fTH = (bt.getInt(localObject2[2], 80) - 1);
      }
    }
    boolean bool2 = com.tencent.mm.emoji.a.m.aeU();
    boolean bool3 = ((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IqE, Boolean.TRUE)).booleanValue();
    boolean bool1;
    if ((bool2) && (bool3))
    {
      bool1 = true;
      label588:
      ((com.tencent.mm.plugin.emoji.e.i)localObject1).pDr = bool1;
      ad.i("MicroMsg.emoji.EmojiRewardTipMgr", "init RewardTipMgr RewardTipEnable:%b isEnableRewardTip:%b isTipsEnable:%b", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.emoji.e.i)localObject1).pDr), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      com.tencent.mm.kernel.g.ajF().ay(new i.1((com.tencent.mm.plugin.emoji.e.i)localObject1));
      localObject1 = cgR().pGu;
      ad.d("MicroMsg.BKGLoader.BKGLoaderManager", "bkg attach");
      com.tencent.mm.sdk.b.a.IbL.c(((BKGLoaderManager)localObject1).pGS);
      com.tencent.mm.sdk.b.a.IbL.c(((BKGLoaderManager)localObject1).pGT);
      localObject2 = new IntentFilter();
      ((IntentFilter)localObject2).addAction("android.net.conn.CONNECTIVITY_CHANGE");
      ((BKGLoaderManager)localObject1).pGO = new BKGLoaderManager.ConnectivityReceiver((BKGLoaderManager)localObject1);
      aj.getContext().registerReceiver(((BKGLoaderManager)localObject1).pGO, (IntentFilter)localObject2);
      ad.i("MicroMsg.emoji.SubCoreEmoji", "[oneliang]initCore");
      localObject1 = bd.frc();
      localObject2 = aj.getContext();
      if (localObject2 != null)
      {
        bool1 = ((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(274480, Boolean.TRUE)).booleanValue();
        ad.i("MicroMsg.emoji.EmojiStorageMgr", "[oneliang]initCore,need init emoji:%s", new Object[] { String.valueOf(bool1) });
        if (bool1)
        {
          ((bd)localObject1).ILn.init((Context)localObject2);
          ((bd)localObject1).ILo.init((Context)localObject2);
        }
        com.tencent.mm.kernel.g.ajC().ajl().set(274480, Boolean.FALSE);
      }
      if (((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IqF, Integer.valueOf(0))).intValue() != com.tencent.mm.protocal.d.Fnj)
      {
        l = System.currentTimeMillis();
        ((bd)localObject1).ILo.ftf();
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IqF, Integer.valueOf(com.tencent.mm.protocal.d.Fnj));
        ad.i("MicroMsg.emoji.EmojiStorageMgr", "recoverCustomEmojiGroup use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      }
      if (((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IqG, Boolean.TRUE)).booleanValue())
      {
        l = System.currentTimeMillis();
        bool1 = ((bd)localObject1).ILo.ftg();
        localObject1 = com.tencent.mm.kernel.g.ajC().ajl();
        localObject2 = al.a.IqG;
        if (bool1) {
          break label1363;
        }
        bool1 = true;
        label983:
        ((ai)localObject1).set((al.a)localObject2, Boolean.valueOf(bool1));
        ad.i("MicroMsg.emoji.EmojiStorageMgr", "updateEmojiGroupCount use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      }
      this.pEX = new l();
      this.pEY = new g();
      com.tencent.mm.ar.a.eN(paramBoolean);
      paramBoolean = com.tencent.mm.cf.f.fnb().fnd();
      bool1 = com.tencent.mm.cf.e.fmZ().fmY();
      if ((paramBoolean) && (((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IqH, Integer.valueOf(0))).intValue() > 0))
      {
        com.tencent.mm.pluginsdk.j.a.a.b.faE().f(37, 1, -1, false);
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IqH, Integer.valueOf(0));
        localObject1 = new com.tencent.mm.pluginsdk.j.a.a.m(37);
        com.tencent.mm.kernel.g.ajB().gAO.a((n)localObject1, 0);
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(165L, 10L, 1L, false);
      }
      if ((bool1) && (((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IqI, Integer.valueOf(0))).intValue() > 0))
      {
        com.tencent.mm.pluginsdk.j.a.a.b.faE().f(37, 2, -1, false);
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IqI, Integer.valueOf(0));
        localObject1 = new com.tencent.mm.pluginsdk.j.a.a.m(37);
        com.tencent.mm.kernel.g.ajB().gAO.a((n)localObject1, 0);
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(165L, 11L, 1L, false);
      }
      localObject1 = com.tencent.mm.ar.b.aHo();
      ad.i("MicroMsg.FontResLogic", "init");
      ((com.tencent.mm.ar.b)localObject1).hWH.alive();
      if (!((com.tencent.mm.ar.b)localObject1).aHr()) {
        break label1368;
      }
      com.tencent.mm.plugin.report.service.g.yhR.n(933L, 4L, 1L);
    }
    for (;;)
    {
      localObject1 = EmojiSyncManager.gpu;
      EmojiSyncManager.a.agj().init();
      localObject1 = EmojiSyncManager.gpu;
      EmojiSyncManager.a.agk().init();
      localObject1 = j.gkf;
      j.aeQ();
      com.tencent.mm.flutter.d.grg.add(h.class);
      AppMethodBeat.o(108652);
      return;
      label1340:
      l = bt.getInt(localObject2[0], 0) * 86400000L;
      break;
      bool1 = false;
      break label588;
      label1363:
      bool1 = false;
      break label983;
      label1368:
      com.tencent.mm.plugin.report.service.g.yhR.n(933L, 5L, 1L);
      com.tencent.mm.pluginsdk.j.a.a.b.faE();
      localObject2 = com.tencent.mm.pluginsdk.j.a.a.b.jm(57, 1);
      if (com.tencent.mm.vfs.i.fv((String)localObject2))
      {
        com.tencent.mm.plugin.report.service.g.yhR.n(933L, 6L, 1L);
        ad.i("MicroMsg.FontResLogic", "cache file exist %s", new Object[] { localObject2 });
        ((com.tencent.mm.ar.b)localObject1).f((String)localObject2, 57, 1, 1);
      }
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(108651);
    ad.i("MicroMsg.emoji.SubCoreEmoji", "onAccountRelease: ");
    Object localObject = cgS();
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().b("emotionstore", ((com.tencent.mm.plugin.emoji.e.g)localObject).pCF, true);
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().b("NewRecommendEmotion", ((com.tencent.mm.plugin.emoji.e.g)localObject).pCG, true);
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().b("EmojiBackup", ((com.tencent.mm.plugin.emoji.e.g)localObject).pCH, true);
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().b("EmotionBackup", ((com.tencent.mm.plugin.emoji.e.g)localObject).pCH, true);
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().b("SelfieEmojiBackup", ((com.tencent.mm.plugin.emoji.e.g)localObject).pCH, true);
    localObject = cgT();
    com.tencent.mm.plugin.emoji.e.b.appForegroundListener.dead();
    com.tencent.mm.sdk.b.a.IbL.d(((com.tencent.mm.plugin.emoji.e.b)localObject).pCg);
    com.tencent.mm.sdk.b.a.IbL.d(((com.tencent.mm.plugin.emoji.e.b)localObject).pCk);
    com.tencent.mm.sdk.b.a.IbL.d(((com.tencent.mm.plugin.emoji.e.b)localObject).pCl);
    com.tencent.mm.sdk.b.a.IbL.d(((com.tencent.mm.plugin.emoji.e.b)localObject).pCm);
    com.tencent.mm.sdk.b.a.IbL.d(((com.tencent.mm.plugin.emoji.e.b)localObject).pCn);
    com.tencent.mm.sdk.b.a.IbL.d(((com.tencent.mm.plugin.emoji.e.b)localObject).pCo);
    com.tencent.mm.sdk.b.a.IbL.d(((com.tencent.mm.plugin.emoji.e.b)localObject).checkLanguageChangeIListener);
    com.tencent.mm.sdk.b.a.IbL.d(((com.tencent.mm.plugin.emoji.e.b)localObject).pCp);
    com.tencent.mm.sdk.b.a.IbL.d(((com.tencent.mm.plugin.emoji.e.b)localObject).pCq);
    com.tencent.mm.sdk.b.a.IbL.d(((com.tencent.mm.plugin.emoji.e.b)localObject).pCh);
    com.tencent.mm.sdk.b.a.IbL.d(((com.tencent.mm.plugin.emoji.e.b)localObject).pCi);
    com.tencent.mm.sdk.b.a.IbL.d(((com.tencent.mm.plugin.emoji.e.b)localObject).pCr);
    com.tencent.mm.sdk.b.a.IbL.d(((com.tencent.mm.plugin.emoji.e.b)localObject).pCs);
    com.tencent.mm.sdk.b.a.IbL.d(((com.tencent.mm.plugin.emoji.e.b)localObject).pCj);
    localObject = bd.frc();
    ((bd)localObject).ILn.remove(((bd)localObject).ILH);
    ((bd)localObject).ILo.remove(((bd)localObject).ILF);
    ((bd)localObject).ILp.remove(((bd)localObject).ILG);
    com.tencent.mm.sdk.b.a.IbL.d(((bd)localObject).ILI);
    localObject = ((bd)localObject).ILB;
    if (((com.tencent.mm.emoji.a.i)localObject).gka != null) {
      ((com.tencent.mm.emoji.a.i)localObject).gka.clear();
    }
    ((com.tencent.mm.emoji.a.i)localObject).gkb.clear();
    getEmojiDescMgr().clear();
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).removeEmojiMgr();
    localObject = cgP();
    com.tencent.mm.kernel.g.ajB().gAO.b(175, (com.tencent.mm.al.f)localObject);
    ((c)localObject).pDU.clear();
    ((c)localObject).pDS.clear();
    localObject = cgU();
    ((com.tencent.mm.plugin.emoji.e.i)localObject).pDu = null;
    if (((com.tencent.mm.plugin.emoji.e.i)localObject).pDv != null) {
      ((com.tencent.mm.plugin.emoji.e.i)localObject).pDv.clear();
    }
    localObject = cgR().pGu;
    ad.d("MicroMsg.BKGLoader.BKGLoaderManager", "bkg detach");
    ((BKGLoaderManager)localObject).chn();
    com.tencent.mm.sdk.b.a.IbL.d(((BKGLoaderManager)localObject).pGS);
    com.tencent.mm.sdk.b.a.IbL.d(((BKGLoaderManager)localObject).pGT);
    if (((BKGLoaderManager)localObject).pGO != null)
    {
      aj.getContext().unregisterReceiver(((BKGLoaderManager)localObject).pGO);
      ((BKGLoaderManager)localObject).pGO = null;
    }
    if (this.pEX != null)
    {
      localObject = this.pEX;
      com.tencent.mm.sdk.b.a.IbL.d(((l)localObject).pFj);
      com.tencent.mm.sdk.b.a.IbL.d(((l)localObject).pFk);
    }
    if (this.pEY != null)
    {
      localObject = this.pEY;
      ((g)localObject).pEo.clear();
      cgP().pDW = null;
      ((g)localObject).pEp.dead();
    }
    if (this.pFe != null) {
      this.pFe.detach();
    }
    com.tencent.mm.ar.b.aHo().hWH.dead();
    localObject = EmojiSyncManager.gpu;
    EmojiSyncManager.a.agj().destroy();
    localObject = EmojiSyncManager.gpu;
    EmojiSyncManager.a.agk().destroy();
    AppMethodBeat.o(108651);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.k
 * JD-Core Version:    0.7.0.1
 */
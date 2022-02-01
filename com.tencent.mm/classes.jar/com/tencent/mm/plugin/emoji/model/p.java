package com.tencent.mm.plugin.emoji.model;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.app.o.a;
import com.tencent.mm.ay.a.a.b.a;
import com.tencent.mm.emoji.b.l;
import com.tencent.mm.emoji.b.o;
import com.tencent.mm.emoji.sync.j;
import com.tencent.mm.model.be;
import com.tencent.mm.model.ck;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.emoji.e.i.1;
import com.tencent.mm.plugin.emoji.h.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.v;
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
import com.tencent.mm.storage.emotion.e;
import com.tencent.mm.storage.emotion.s;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.u;
import com.tencent.mm.view.SmileyPanelImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class p
  implements be
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private i uEV;
  private d uEW;
  private bf uEX;
  private com.tencent.mm.plugin.emoji.e.f uEY;
  private q uEZ;
  private m uFa;
  private k uFb;
  private com.tencent.mm.plugin.emoji.h.a<com.tencent.mm.plugin.emoji.h.d> uFc;
  private volatile com.tencent.mm.plugin.emoji.e.g uFd;
  private volatile com.tencent.mm.plugin.emoji.e.b uFe;
  private volatile com.tencent.mm.plugin.emoji.e.i uFf;
  private com.tencent.mm.ay.a.a uFg;
  
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
    baseDBFactories.put(Integer.valueOf("EMOJIINFODESC_TABLE".hashCode()), new p.11());
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
    baseDBFactories.put(Integer.valueOf("EmotionRewardINFO_TABLE".hashCode()), new p.14());
    baseDBFactories.put(Integer.valueOf("EmotionDesignerInfoStorage_TABLE".hashCode()), new p.15());
    baseDBFactories.put(Integer.valueOf("EmotionRewardTipStorage_TABLE".hashCode()), new p.16());
    baseDBFactories.put(Integer.valueOf("SmileyInfoStorage_TABLE".hashCode()), new p.17());
    baseDBFactories.put(Integer.valueOf("SmileyPanelConfigInfoStorage_TABLE".hashCode()), new p.2());
    baseDBFactories.put(Integer.valueOf("EmojiDescMapStorage".hashCode()), new p.3());
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
        AppMethodBeat.i(256729);
        Object localObject = com.tencent.mm.storage.emotion.g.VIG;
        localObject = com.tencent.mm.storage.emotion.g.gfS();
        AppMethodBeat.o(256729);
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
  
  private static p cUK()
  {
    AppMethodBeat.i(108641);
    p localp = (p)y.as(p.class);
    AppMethodBeat.o(108641);
    return localp;
  }
  
  public static com.tencent.mm.ay.a.a cUL()
  {
    AppMethodBeat.i(108642);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (cUK().uFg == null)
    {
      localObject = new b.a(MMApplicationContext.getContext());
      ((b.a)localObject).lRs = new com.tencent.mm.plugin.emoji.d.a();
      ((b.a)localObject).lRq = new com.tencent.mm.view.c.a();
      localObject = ((b.a)localObject).bmu();
      cUK().uFg = new com.tencent.mm.ay.a.a((com.tencent.mm.ay.a.a.b)localObject);
    }
    Object localObject = cUK().uFg;
    AppMethodBeat.o(108642);
    return localObject;
  }
  
  public static i cUM()
  {
    AppMethodBeat.i(108643);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (cUK().uEV == null) {
      cUK().uEV = new i();
    }
    i locali = cUK().uEV;
    AppMethodBeat.o(108643);
    return locali;
  }
  
  public static d cUN()
  {
    AppMethodBeat.i(256906);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (cUK().uEW == null) {
      cUK().uEW = new d();
    }
    d locald = cUK().uEW;
    AppMethodBeat.o(256906);
    return locald;
  }
  
  public static com.tencent.mm.plugin.emoji.e.f cUO()
  {
    AppMethodBeat.i(108645);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (cUK().uEY == null) {
      cUK().uEY = new com.tencent.mm.plugin.emoji.e.f();
    }
    com.tencent.mm.plugin.emoji.e.f localf = cUK().uEY;
    AppMethodBeat.o(108645);
    return localf;
  }
  
  public static com.tencent.mm.plugin.emoji.h.a<com.tencent.mm.plugin.emoji.h.d> cUP()
  {
    AppMethodBeat.i(108646);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (cUK().uFc == null) {
      cUK().uFc = new com.tencent.mm.plugin.emoji.h.a();
    }
    com.tencent.mm.plugin.emoji.h.a locala = cUK().uFc;
    AppMethodBeat.o(108646);
    return locala;
  }
  
  private static com.tencent.mm.plugin.emoji.e.g cUQ()
  {
    try
    {
      AppMethodBeat.i(108647);
      com.tencent.mm.kernel.h.aHE().aGH();
      if (cUK().uFd == null) {
        cUK().uFd = new com.tencent.mm.plugin.emoji.e.g();
      }
      com.tencent.mm.plugin.emoji.e.g localg = cUK().uFd;
      AppMethodBeat.o(108647);
      return localg;
    }
    finally {}
  }
  
  private static com.tencent.mm.plugin.emoji.e.b cUR()
  {
    AppMethodBeat.i(108648);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (cUK().uFe == null) {
      cUK().uFe = new com.tencent.mm.plugin.emoji.e.b();
    }
    com.tencent.mm.plugin.emoji.e.b localb = cUK().uFe;
    AppMethodBeat.o(108648);
    return localb;
  }
  
  public static com.tencent.mm.plugin.emoji.e.i cUS()
  {
    AppMethodBeat.i(108650);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (cUK().uFf == null) {
      cUK().uFf = new com.tencent.mm.plugin.emoji.e.i();
    }
    com.tencent.mm.plugin.emoji.e.i locali = cUK().uFf;
    AppMethodBeat.o(108650);
    return locali;
  }
  
  public static k cUT()
  {
    AppMethodBeat.i(108653);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (cUK().uFb == null) {
      cUK().uFb = new k();
    }
    k localk = cUK().uFb;
    AppMethodBeat.o(108653);
    return localk;
  }
  
  public static bf getEmojiDescMgr()
  {
    AppMethodBeat.i(108644);
    if (cUK().uEX == null) {
      cUK().uEX = bf.hyR();
    }
    bf localbf = cUK().uEX;
    AppMethodBeat.o(108644);
    return localbf;
  }
  
  public static bj getEmojiStorageMgr()
  {
    AppMethodBeat.i(108649);
    bj localbj = bj.hyV();
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
    com.tencent.mm.pluginsdk.ui.chat.e.RnO = new e.b()
    {
      public final ChatFooterPanel fd(Context paramAnonymousContext)
      {
        AppMethodBeat.i(256169);
        paramAnonymousContext = new SmileyPanelImpl(paramAnonymousContext, false);
        AppMethodBeat.o(256169);
        return paramAnonymousContext;
      }
    };
    com.tencent.mm.pluginsdk.ui.chat.e.RnP = new e.a() {};
    bj.hyV().hyW();
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).setEmojiMgr();
    Object localObject1 = cUQ();
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().a("emotionstore", ((com.tencent.mm.plugin.emoji.e.g)localObject1).uCF, true);
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().a("NewRecommendEmotion", ((com.tencent.mm.plugin.emoji.e.g)localObject1).uCG, true);
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().a("EmojiBackup", ((com.tencent.mm.plugin.emoji.e.g)localObject1).uCH, true);
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().a("EmotionBackup", ((com.tencent.mm.plugin.emoji.e.g)localObject1).uCH, true);
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().a("SelfieEmojiBackup", ((com.tencent.mm.plugin.emoji.e.g)localObject1).uCH, true);
    localObject1 = cUR();
    EventCenter.instance.addListener(((com.tencent.mm.plugin.emoji.e.b)localObject1).uCg);
    EventCenter.instance.addListener(((com.tencent.mm.plugin.emoji.e.b)localObject1).uCk);
    EventCenter.instance.addListener(((com.tencent.mm.plugin.emoji.e.b)localObject1).uCl);
    EventCenter.instance.addListener(((com.tencent.mm.plugin.emoji.e.b)localObject1).uCm);
    com.tencent.mm.plugin.emoji.e.b.appForegroundListener.alive();
    EventCenter.instance.addListener(((com.tencent.mm.plugin.emoji.e.b)localObject1).uCn);
    EventCenter.instance.addListener(((com.tencent.mm.plugin.emoji.e.b)localObject1).uCo);
    EventCenter.instance.addListener(((com.tencent.mm.plugin.emoji.e.b)localObject1).checkLanguageChangeIListener);
    EventCenter.instance.addListener(((com.tencent.mm.plugin.emoji.e.b)localObject1).uCp);
    EventCenter.instance.addListener(((com.tencent.mm.plugin.emoji.e.b)localObject1).uCq);
    EventCenter.instance.addListener(((com.tencent.mm.plugin.emoji.e.b)localObject1).uCh);
    EventCenter.instance.addListener(((com.tencent.mm.plugin.emoji.e.b)localObject1).uCi);
    EventCenter.instance.addListener(((com.tencent.mm.plugin.emoji.e.b)localObject1).uCr);
    EventCenter.instance.addListener(((com.tencent.mm.plugin.emoji.e.b)localObject1).uCs);
    EventCenter.instance.addListener(((com.tencent.mm.plugin.emoji.e.b)localObject1).uCj);
    localObject1 = bj.hyV();
    ((bj)localObject1).VFH.add(((bj)localObject1).VGb);
    ((bj)localObject1).VFI.add(((bj)localObject1).VFZ);
    ((bj)localObject1).VFJ.add(((bj)localObject1).VGa);
    EventCenter.instance.addListener(((bj)localObject1).VGc);
    getEmojiDescMgr();
    localObject1 = cUS();
    Object localObject2 = com.tencent.mm.n.h.axc().getValue("EmotionRewardTipsLimit");
    long l;
    if (!Util.isNullOrNil((String)localObject2))
    {
      Log.i("MicroMsg.emoji.EmojiRewardTipMgr", "updateConfig dynamic config %s", new Object[] { localObject2 });
      localObject2 = ((String)localObject2).split(",");
      if ((localObject2 != null) && (localObject2.length == 3))
      {
        if (Util.getInt(localObject2[0], 0) != 0) {
          break label1392;
        }
        l = 863913600000L;
        ((com.tencent.mm.plugin.emoji.e.i)localObject1).uDz = l;
        ((com.tencent.mm.plugin.emoji.e.i)localObject1).uDA = (Util.getInt(localObject2[1], 20) - 1);
        ((com.tencent.mm.plugin.emoji.e.i)localObject1).cUX = (Util.getInt(localObject2[2], 80) - 1);
      }
    }
    boolean bool2 = o.aBR();
    boolean bool3 = ((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VgW, Boolean.TRUE)).booleanValue();
    boolean bool1;
    if ((bool2) && (bool3))
    {
      bool1 = true;
      label588:
      ((com.tencent.mm.plugin.emoji.e.i)localObject1).uDy = bool1;
      Log.i("MicroMsg.emoji.EmojiRewardTipMgr", "init RewardTipMgr RewardTipEnable:%b isEnableRewardTip:%b isTipsEnable:%b", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.emoji.e.i)localObject1).uDy), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      com.tencent.mm.kernel.h.aHJ().postToWorker(new i.1((com.tencent.mm.plugin.emoji.e.i)localObject1));
      localObject1 = cUP().uGy;
      Log.d("MicroMsg.BKGLoader.BKGLoaderManager", "bkg attach");
      EventCenter.instance.addListener(((com.tencent.mm.plugin.emoji.h.c)localObject1).uGV);
      EventCenter.instance.addListener(((com.tencent.mm.plugin.emoji.h.c)localObject1).uGW);
      localObject2 = new IntentFilter();
      ((IntentFilter)localObject2).addAction("android.net.conn.CONNECTIVITY_CHANGE");
      ((com.tencent.mm.plugin.emoji.h.c)localObject1).uGR = new c.a((com.tencent.mm.plugin.emoji.h.c)localObject1);
      MMApplicationContext.getContext().registerReceiver(((com.tencent.mm.plugin.emoji.h.c)localObject1).uGR, (IntentFilter)localObject2);
      Log.i("MicroMsg.emoji.SubCoreEmoji", "[oneliang]initCore");
      localObject1 = bj.hyV();
      localObject2 = MMApplicationContext.getContext();
      if (localObject2 != null)
      {
        bool1 = ((Boolean)com.tencent.mm.kernel.h.aHG().aHp().b(274480, Boolean.TRUE)).booleanValue();
        Log.i("MicroMsg.emoji.EmojiStorageMgr", "[oneliang]initCore,need init emoji:%s", new Object[] { String.valueOf(bool1) });
        if (bool1)
        {
          ((bj)localObject1).VFH.init((Context)localObject2);
          ((bj)localObject1).VFI.init((Context)localObject2);
        }
        com.tencent.mm.kernel.h.aHG().aHp().i(274480, Boolean.FALSE);
      }
      if (((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VgX, Integer.valueOf(0))).intValue() != com.tencent.mm.protocal.d.RAD)
      {
        l = System.currentTimeMillis();
        ((bj)localObject1).VFI.hBi();
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VgX, Integer.valueOf(com.tencent.mm.protocal.d.RAD));
        Log.i("MicroMsg.emoji.EmojiStorageMgr", "recoverCustomEmojiGroup use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      }
      if (((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VgY, Boolean.TRUE)).booleanValue())
      {
        l = System.currentTimeMillis();
        bool1 = ((bj)localObject1).VFI.hBj();
        localObject1 = com.tencent.mm.kernel.h.aHG().aHp();
        localObject2 = ar.a.VgY;
        if (bool1) {
          break label1415;
        }
        bool1 = true;
        label983:
        ((ao)localObject1).set((ar.a)localObject2, Boolean.valueOf(bool1));
        Log.i("MicroMsg.emoji.EmojiStorageMgr", "updateEmojiGroupCount use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      }
      this.uEZ = new q();
      this.uFa = new m();
      com.tencent.mm.at.a.gq(paramBoolean);
      paramBoolean = com.tencent.mm.cl.g.htS().htU();
      bool1 = com.tencent.mm.cl.f.htQ().htO();
      if ((paramBoolean) && (((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VgZ, Integer.valueOf(0))).intValue() > 0))
      {
        com.tencent.mm.pluginsdk.k.a.a.b.hii().g(37, 1, -1, false);
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VgZ, Integer.valueOf(0));
        localObject1 = new com.tencent.mm.pluginsdk.k.a.a.m(37);
        com.tencent.mm.kernel.h.aHF().kcd.a((com.tencent.mm.an.q)localObject1, 0);
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(165L, 10L, 1L, false);
      }
      if ((bool1) && (((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vha, Integer.valueOf(0))).intValue() > 0))
      {
        com.tencent.mm.pluginsdk.k.a.a.b.hii().g(37, 2, -1, false);
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vha, Integer.valueOf(0));
        localObject1 = new com.tencent.mm.pluginsdk.k.a.a.m(37);
        com.tencent.mm.kernel.h.aHF().kcd.a((com.tencent.mm.an.q)localObject1, 0);
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(165L, 11L, 1L, false);
      }
      localObject1 = com.tencent.mm.at.b.bkO();
      Log.i("MicroMsg.FontResLogic", "init");
      ((com.tencent.mm.at.b)localObject1).lKQ.alive();
      if (!((com.tencent.mm.at.b)localObject1).bkR()) {
        break label1420;
      }
      com.tencent.mm.plugin.report.service.h.IzE.p(933L, 4L, 1L);
    }
    for (;;)
    {
      com.tencent.mm.emoji.sync.g.aDr().init();
      com.tencent.mm.emoji.sync.g.aDs().init();
      localObject1 = l.jIq;
      l.init();
      localObject1 = com.tencent.mm.emoji.e.a.jPz;
      if (!u.agG(com.tencent.mm.emoji.e.a.aDE()))
      {
        com.tencent.mm.pluginsdk.k.a.a.b.hii();
        localObject1 = com.tencent.mm.pluginsdk.k.a.a.b.lV(37, 7);
        if (u.agG((String)localObject1))
        {
          Log.i("MicroMsg.emoji.SubCoreEmoji", "update emoji anim res from cache");
          com.tencent.mm.plugin.emoji.e.h.cUA().auw((String)localObject1);
        }
      }
      com.tencent.e.h.ZvG.be(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(256258);
          Iterator localIterator = com.tencent.mm.cl.f.htQ().htR().iterator();
          while (localIterator.hasNext())
          {
            SmileyPanelConfigInfo localSmileyPanelConfigInfo = (SmileyPanelConfigInfo)localIterator.next();
            com.tencent.mm.cl.f.htQ();
            com.tencent.mm.cl.f.buv(localSmileyPanelConfigInfo.field_key);
          }
          AppMethodBeat.o(256258);
        }
      });
      AppMethodBeat.o(108652);
      return;
      label1392:
      l = Util.getInt(localObject2[0], 0) * 86400000L;
      break;
      bool1 = false;
      break label588;
      label1415:
      bool1 = false;
      break label983;
      label1420:
      com.tencent.mm.plugin.report.service.h.IzE.p(933L, 5L, 1L);
      com.tencent.mm.pluginsdk.k.a.a.b.hii();
      localObject2 = com.tencent.mm.pluginsdk.k.a.a.b.lV(57, 1);
      if (u.agG((String)localObject2))
      {
        com.tencent.mm.plugin.report.service.h.IzE.p(933L, 6L, 1L);
        Log.i("MicroMsg.FontResLogic", "cache file exist %s", new Object[] { localObject2 });
        ((com.tencent.mm.at.b)localObject1).g((String)localObject2, 57, 1, 1);
      }
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(108651);
    Log.i("MicroMsg.emoji.SubCoreEmoji", "onAccountRelease: ");
    Object localObject = cUQ();
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().b("emotionstore", ((com.tencent.mm.plugin.emoji.e.g)localObject).uCF, true);
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().b("NewRecommendEmotion", ((com.tencent.mm.plugin.emoji.e.g)localObject).uCG, true);
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().b("EmojiBackup", ((com.tencent.mm.plugin.emoji.e.g)localObject).uCH, true);
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().b("EmotionBackup", ((com.tencent.mm.plugin.emoji.e.g)localObject).uCH, true);
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().b("SelfieEmojiBackup", ((com.tencent.mm.plugin.emoji.e.g)localObject).uCH, true);
    localObject = cUR();
    com.tencent.mm.plugin.emoji.e.b.appForegroundListener.dead();
    EventCenter.instance.removeListener(((com.tencent.mm.plugin.emoji.e.b)localObject).uCg);
    EventCenter.instance.removeListener(((com.tencent.mm.plugin.emoji.e.b)localObject).uCk);
    EventCenter.instance.removeListener(((com.tencent.mm.plugin.emoji.e.b)localObject).uCl);
    EventCenter.instance.removeListener(((com.tencent.mm.plugin.emoji.e.b)localObject).uCm);
    EventCenter.instance.removeListener(((com.tencent.mm.plugin.emoji.e.b)localObject).uCn);
    EventCenter.instance.removeListener(((com.tencent.mm.plugin.emoji.e.b)localObject).uCo);
    EventCenter.instance.removeListener(((com.tencent.mm.plugin.emoji.e.b)localObject).checkLanguageChangeIListener);
    EventCenter.instance.removeListener(((com.tencent.mm.plugin.emoji.e.b)localObject).uCp);
    EventCenter.instance.removeListener(((com.tencent.mm.plugin.emoji.e.b)localObject).uCq);
    EventCenter.instance.removeListener(((com.tencent.mm.plugin.emoji.e.b)localObject).uCh);
    EventCenter.instance.removeListener(((com.tencent.mm.plugin.emoji.e.b)localObject).uCi);
    EventCenter.instance.removeListener(((com.tencent.mm.plugin.emoji.e.b)localObject).uCr);
    EventCenter.instance.removeListener(((com.tencent.mm.plugin.emoji.e.b)localObject).uCs);
    EventCenter.instance.removeListener(((com.tencent.mm.plugin.emoji.e.b)localObject).uCj);
    localObject = bj.hyV();
    ((bj)localObject).VFH.remove(((bj)localObject).VGb);
    ((bj)localObject).VFI.remove(((bj)localObject).VFZ);
    ((bj)localObject).VFJ.remove(((bj)localObject).VGa);
    EventCenter.instance.removeListener(((bj)localObject).VGc);
    localObject = ((bj)localObject).VFV;
    if (((com.tencent.mm.emoji.b.k)localObject).jIj != null) {
      ((com.tencent.mm.emoji.b.k)localObject).jIj.clear();
    }
    ((com.tencent.mm.emoji.b.k)localObject).jIk.evictAll();
    getEmojiDescMgr().clear();
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).removeEmojiMgr();
    localObject = cUM();
    com.tencent.mm.kernel.h.aHF().kcd.b(175, (com.tencent.mm.an.i)localObject);
    ((i)localObject).uEb.clear();
    ((i)localObject).uEi.clear();
    localObject = cUN();
    com.tencent.mm.kernel.h.aHF().kcd.b(3862, (com.tencent.mm.an.i)localObject);
    com.tencent.mm.kernel.h.aHF().kcd.b(697, (com.tencent.mm.an.i)localObject);
    ((d)localObject).uEb.clear();
    ((d)localObject).uEc.clear();
    localObject = cUS();
    ((com.tencent.mm.plugin.emoji.e.i)localObject).uDB = null;
    if (((com.tencent.mm.plugin.emoji.e.i)localObject).uDC != null) {
      ((com.tencent.mm.plugin.emoji.e.i)localObject).uDC.clear();
    }
    localObject = cUP().uGy;
    Log.d("MicroMsg.BKGLoader.BKGLoaderManager", "bkg detach");
    ((com.tencent.mm.plugin.emoji.h.c)localObject).cVm();
    EventCenter.instance.removeListener(((com.tencent.mm.plugin.emoji.h.c)localObject).uGV);
    EventCenter.instance.removeListener(((com.tencent.mm.plugin.emoji.h.c)localObject).uGW);
    if (((com.tencent.mm.plugin.emoji.h.c)localObject).uGR != null)
    {
      MMApplicationContext.getContext().unregisterReceiver(((com.tencent.mm.plugin.emoji.h.c)localObject).uGR);
      ((com.tencent.mm.plugin.emoji.h.c)localObject).uGR = null;
    }
    if (this.uEZ != null)
    {
      localObject = this.uEZ;
      EventCenter.instance.removeListener(((q)localObject).uFl);
      EventCenter.instance.removeListener(((q)localObject).uFm);
    }
    if (this.uFa != null)
    {
      localObject = this.uFa;
      ((m)localObject).uEC.clear();
      cUM().uEk = null;
      ((m)localObject).uED.dead();
    }
    if (this.uFg != null) {
      this.uFg.detach();
    }
    com.tencent.mm.at.b.bkO().lKQ.dead();
    com.tencent.mm.emoji.sync.g.aDr().destroy();
    com.tencent.mm.emoji.sync.g.aDs().destroy();
    AppMethodBeat.o(108651);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.p
 * JD-Core Version:    0.7.0.1
 */
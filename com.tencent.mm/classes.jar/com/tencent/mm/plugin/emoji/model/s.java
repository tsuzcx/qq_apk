package com.tencent.mm.plugin.emoji.model;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.app.q.a;
import com.tencent.mm.emoji.sync.j;
import com.tencent.mm.model.be;
import com.tencent.mm.model.cl;
import com.tencent.mm.modelimage.loader.a.b.a;
import com.tencent.mm.plugin.emoji.event.EmojiPostTaskListener;
import com.tencent.mm.plugin.emoji.event.EmojiResUpdateListener;
import com.tencent.mm.plugin.emoji.event.EmojiResUpdateOperationListener;
import com.tencent.mm.plugin.emoji.event.EmojiRevokeMsgListener;
import com.tencent.mm.plugin.emoji.mgr.i.1;
import com.tencent.mm.plugin.emoji.sync.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.e.a;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LruCache;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.smiley.QQSmileyManager;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.SmileyPanelConfigInfo;
import com.tencent.mm.storage.emotion.e;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.view.SmileyPanelImpl;
import com.tencent.mm.view.loader.EmojiLoaderMemoryCache;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class s
  implements be
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private com.tencent.mm.plugin.emoji.mgr.f xNA;
  private t xNB;
  private n xNC;
  private l xND;
  private com.tencent.mm.plugin.emoji.sync.a<com.tencent.mm.plugin.emoji.sync.d> xNE;
  private volatile com.tencent.mm.plugin.emoji.mgr.g xNF;
  private volatile com.tencent.mm.plugin.emoji.mgr.b xNG;
  private volatile com.tencent.mm.plugin.emoji.mgr.i xNH;
  private com.tencent.mm.modelimage.loader.a xNI;
  private i xNx;
  private d xNy;
  private bh xNz;
  
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
    baseDBFactories.put(Integer.valueOf("EMOJIINFODESC_TABLE".hashCode()), new s.12());
    baseDBFactories.put(Integer.valueOf("EMOTIONDETAIL_TABLE".hashCode()), new s.13());
    baseDBFactories.put(Integer.valueOf("GETEMOTIONLISTCACHE_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.storage.emotion.s.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("GetSTORERECLISTCACHE_TABLE".hashCode()), new s.15());
    baseDBFactories.put(Integer.valueOf("EmotionRewardINFO_TABLE".hashCode()), new s.16());
    baseDBFactories.put(Integer.valueOf("EmotionDesignerInfoStorage_TABLE".hashCode()), new s.17());
    baseDBFactories.put(Integer.valueOf("EmotionRewardTipStorage_TABLE".hashCode()), new s.18());
    baseDBFactories.put(Integer.valueOf("SmileyInfoStorage_TABLE".hashCode()), new s.2());
    baseDBFactories.put(Integer.valueOf("SmileyPanelConfigInfoStorage_TABLE".hashCode()), new s.3());
    baseDBFactories.put(Integer.valueOf("EmojiDescMapStorage".hashCode()), new s.4());
    baseDBFactories.put(Integer.valueOf("EmojiDesignerProductStorage_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.storage.emotion.b.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("EmojiSuggestCacheStorage".hashCode()), new s.6());
    baseDBFactories.put(Integer.valueOf("DELETE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return new String[] { "DROP TABLE IF EXISTS EmotionDetail ", "DROP TABLE IF EXISTS EmojiSummaryInfo", "DROP TABLE IF EXISTS RewardMagicInfo" };
      }
    });
    AppMethodBeat.o(108654);
  }
  
  private static s dAh()
  {
    AppMethodBeat.i(108641);
    s locals = (s)com.tencent.mm.model.y.aL(s.class);
    AppMethodBeat.o(108641);
    return locals;
  }
  
  public static com.tencent.mm.modelimage.loader.a dAi()
  {
    AppMethodBeat.i(108642);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (dAh().xNI == null)
    {
      localObject = new b.a(MMApplicationContext.getContext());
      ((b.a)localObject).oKe = new com.tencent.mm.plugin.emoji.d.a();
      ((b.a)localObject).oKc = new EmojiLoaderMemoryCache();
      localObject = ((b.a)localObject).bKn();
      dAh().xNI = new com.tencent.mm.modelimage.loader.a((com.tencent.mm.modelimage.loader.a.b)localObject);
    }
    Object localObject = dAh().xNI;
    AppMethodBeat.o(108642);
    return localObject;
  }
  
  public static i dAj()
  {
    AppMethodBeat.i(108643);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (dAh().xNx == null) {
      dAh().xNx = new i();
    }
    i locali = dAh().xNx;
    AppMethodBeat.o(108643);
    return locali;
  }
  
  public static d dAk()
  {
    AppMethodBeat.i(269886);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (dAh().xNy == null) {
      dAh().xNy = new d();
    }
    d locald = dAh().xNy;
    AppMethodBeat.o(269886);
    return locald;
  }
  
  public static com.tencent.mm.plugin.emoji.mgr.f dAl()
  {
    AppMethodBeat.i(108645);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (dAh().xNA == null) {
      dAh().xNA = new com.tencent.mm.plugin.emoji.mgr.f();
    }
    com.tencent.mm.plugin.emoji.mgr.f localf = dAh().xNA;
    AppMethodBeat.o(108645);
    return localf;
  }
  
  public static com.tencent.mm.plugin.emoji.sync.a<com.tencent.mm.plugin.emoji.sync.d> dAm()
  {
    AppMethodBeat.i(108646);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (dAh().xNE == null) {
      dAh().xNE = new com.tencent.mm.plugin.emoji.sync.a();
    }
    com.tencent.mm.plugin.emoji.sync.a locala = dAh().xNE;
    AppMethodBeat.o(108646);
    return locala;
  }
  
  private static com.tencent.mm.plugin.emoji.mgr.g dAn()
  {
    try
    {
      AppMethodBeat.i(108647);
      com.tencent.mm.kernel.h.baC().aZJ();
      if (dAh().xNF == null) {
        dAh().xNF = new com.tencent.mm.plugin.emoji.mgr.g();
      }
      com.tencent.mm.plugin.emoji.mgr.g localg = dAh().xNF;
      AppMethodBeat.o(108647);
      return localg;
    }
    finally {}
  }
  
  private static com.tencent.mm.plugin.emoji.mgr.b dAo()
  {
    AppMethodBeat.i(108648);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (dAh().xNG == null) {
      dAh().xNG = new com.tencent.mm.plugin.emoji.mgr.b();
    }
    com.tencent.mm.plugin.emoji.mgr.b localb = dAh().xNG;
    AppMethodBeat.o(108648);
    return localb;
  }
  
  public static com.tencent.mm.plugin.emoji.mgr.i dAp()
  {
    AppMethodBeat.i(108650);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (dAh().xNH == null) {
      dAh().xNH = new com.tencent.mm.plugin.emoji.mgr.i();
    }
    com.tencent.mm.plugin.emoji.mgr.i locali = dAh().xNH;
    AppMethodBeat.o(108650);
    return locali;
  }
  
  public static l dAq()
  {
    AppMethodBeat.i(108653);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (dAh().xND == null) {
      dAh().xND = new l();
    }
    l locall = dAh().xND;
    AppMethodBeat.o(108653);
    return locall;
  }
  
  public static bh getEmojiDescMgr()
  {
    AppMethodBeat.i(108644);
    if (dAh().xNz == null) {
      dAh().xNz = bh.jaX();
    }
    bh localbh = dAh().xNz;
    AppMethodBeat.o(108644);
    return localbh;
  }
  
  public static bl getEmojiStorageMgr()
  {
    AppMethodBeat.i(108649);
    bl localbl = bl.jba();
    AppMethodBeat.o(108649);
    return localbl;
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
    com.tencent.mm.pluginsdk.ui.chat.e.Ykf = new e.b()
    {
      public final ChatFooterPanel fZ(Context paramAnonymousContext)
      {
        AppMethodBeat.i(269850);
        paramAnonymousContext = new SmileyPanelImpl(paramAnonymousContext, false);
        AppMethodBeat.o(269850);
        return paramAnonymousContext;
      }
    };
    com.tencent.mm.pluginsdk.ui.chat.e.Ykg = new e.a() {};
    bl.jba().jbb();
    ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).setEmojiMgr();
    Object localObject1 = dAn();
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("emotionstore", ((com.tencent.mm.plugin.emoji.mgr.g)localObject1).xLb, true);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("NewRecommendEmotion", ((com.tencent.mm.plugin.emoji.mgr.g)localObject1).xLc, true);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("EmojiBackup", ((com.tencent.mm.plugin.emoji.mgr.g)localObject1).xLd, true);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("EmotionBackup", ((com.tencent.mm.plugin.emoji.mgr.g)localObject1).xLd, true);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("SelfieEmojiBackup", ((com.tencent.mm.plugin.emoji.mgr.g)localObject1).xLd, true);
    localObject1 = dAo();
    ((com.tencent.mm.plugin.emoji.mgr.b)localObject1).xKC.alive();
    ((com.tencent.mm.plugin.emoji.mgr.b)localObject1).xKG.alive();
    ((com.tencent.mm.plugin.emoji.mgr.b)localObject1).xKH.alive();
    ((com.tencent.mm.plugin.emoji.mgr.b)localObject1).xKI.alive();
    com.tencent.mm.plugin.emoji.mgr.b.appForegroundListener.alive();
    ((com.tencent.mm.plugin.emoji.mgr.b)localObject1).xKJ.alive();
    ((com.tencent.mm.plugin.emoji.mgr.b)localObject1).xKK.alive();
    ((com.tencent.mm.plugin.emoji.mgr.b)localObject1).checkLanguageChangeIListener.alive();
    ((com.tencent.mm.plugin.emoji.mgr.b)localObject1).xKL.alive();
    ((com.tencent.mm.plugin.emoji.mgr.b)localObject1).xKM.alive();
    ((com.tencent.mm.plugin.emoji.mgr.b)localObject1).xKD.alive();
    ((com.tencent.mm.plugin.emoji.mgr.b)localObject1).xKE.alive();
    ((com.tencent.mm.plugin.emoji.mgr.b)localObject1).xKN.alive();
    ((com.tencent.mm.plugin.emoji.mgr.b)localObject1).xKO.alive();
    ((com.tencent.mm.plugin.emoji.mgr.b)localObject1).xKF.alive();
    localObject1 = bl.jba();
    ((bl)localObject1).adju.add(((bl)localObject1).adjP);
    ((bl)localObject1).adjv.add(((bl)localObject1).adjN);
    ((bl)localObject1).adjw.add(((bl)localObject1).adjO);
    ((bl)localObject1).adjQ.alive();
    getEmojiDescMgr();
    localObject1 = dAp();
    Object localObject2 = com.tencent.mm.k.i.aRC().getValue("EmotionRewardTipsLimit");
    long l;
    if (!Util.isNullOrNil((String)localObject2))
    {
      Log.i("MicroMsg.emoji.EmojiRewardTipMgr", "updateConfig dynamic config %s", new Object[] { localObject2 });
      localObject2 = ((String)localObject2).split(",");
      if ((localObject2 != null) && (localObject2.length == 3))
      {
        if (Util.getInt(localObject2[0], 0) != 0) {
          break label1324;
        }
        l = 863913600000L;
        ((com.tencent.mm.plugin.emoji.mgr.i)localObject1).xLR = l;
        ((com.tencent.mm.plugin.emoji.mgr.i)localObject1).xLS = (Util.getInt(localObject2[1], 20) - 1);
        ((com.tencent.mm.plugin.emoji.mgr.i)localObject1).eQx = (Util.getInt(localObject2[2], 80) - 1);
      }
    }
    boolean bool2 = com.tencent.mm.emoji.c.o.aUO();
    boolean bool3 = ((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acIn, Boolean.TRUE)).booleanValue();
    boolean bool1;
    if ((bool2) && (bool3))
    {
      bool1 = true;
      label528:
      ((com.tencent.mm.plugin.emoji.mgr.i)localObject1).xLQ = bool1;
      Log.i("MicroMsg.emoji.EmojiRewardTipMgr", "init RewardTipMgr RewardTipEnable:%b isEnableRewardTip:%b isTipsEnable:%b", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.emoji.mgr.i)localObject1).xLQ), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      com.tencent.mm.kernel.h.baH().postToWorker(new i.1((com.tencent.mm.plugin.emoji.mgr.i)localObject1));
      localObject1 = dAm().xPe;
      Log.d("MicroMsg.BKGLoader.BKGLoaderManager", "bkg attach");
      ((com.tencent.mm.plugin.emoji.sync.c)localObject1).xPB.alive();
      ((com.tencent.mm.plugin.emoji.sync.c)localObject1).xPC.alive();
      localObject2 = new IntentFilter();
      ((IntentFilter)localObject2).addAction("android.net.conn.CONNECTIVITY_CHANGE");
      ((com.tencent.mm.plugin.emoji.sync.c)localObject1).xPx = new c.a((com.tencent.mm.plugin.emoji.sync.c)localObject1);
      MMApplicationContext.getContext().registerReceiver(((com.tencent.mm.plugin.emoji.sync.c)localObject1).xPx, (IntentFilter)localObject2);
      Log.i("MicroMsg.emoji.SubCoreEmoji", "[oneliang]initCore");
      localObject1 = bl.jba();
      localObject2 = MMApplicationContext.getContext();
      if (localObject2 != null)
      {
        bool1 = ((Boolean)com.tencent.mm.kernel.h.baE().ban().d(274480, Boolean.TRUE)).booleanValue();
        Log.i("MicroMsg.emoji.EmojiStorageMgr", "[oneliang]initCore,need init emoji:%s", new Object[] { String.valueOf(bool1) });
        if (bool1)
        {
          ((bl)localObject1).adju.init((Context)localObject2);
          ((bl)localObject1).adjv.init((Context)localObject2);
        }
        com.tencent.mm.kernel.h.baE().ban().B(274480, Boolean.FALSE);
      }
      if (((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acIo, Integer.valueOf(0))).intValue() != com.tencent.mm.protocal.d.Yxh)
      {
        l = System.currentTimeMillis();
        ((bl)localObject1).adjv.jdj();
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acIo, Integer.valueOf(com.tencent.mm.protocal.d.Yxh));
        Log.i("MicroMsg.emoji.EmojiStorageMgr", "recoverCustomEmojiGroup use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      }
      if (((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acIp, Boolean.TRUE)).booleanValue())
      {
        l = System.currentTimeMillis();
        bool1 = ((bl)localObject1).adjv.jdk();
        localObject1 = com.tencent.mm.kernel.h.baE().ban();
        localObject2 = at.a.acIp;
        if (bool1) {
          break label1347;
        }
        bool1 = true;
        label915:
        ((aq)localObject1).set((at.a)localObject2, Boolean.valueOf(bool1));
        Log.i("MicroMsg.emoji.EmojiStorageMgr", "updateEmojiGroupCount use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      }
      this.xNB = new t();
      this.xNC = new n();
      com.tencent.mm.modelemoji.a.hh(paramBoolean);
      QQSmileyManager.iVq();
      paramBoolean = QQSmileyManager.iVo();
      bool1 = com.tencent.mm.smiley.o.iVl().iVj();
      if ((paramBoolean) && (((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acIq, Integer.valueOf(0))).intValue() > 0))
      {
        com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.iJf().f(37, 1, -1, false);
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acIq, Integer.valueOf(0));
        localObject1 = new com.tencent.mm.pluginsdk.res.downloader.checkresupdate.m(37);
        com.tencent.mm.kernel.h.baD().mCm.a((p)localObject1, 0);
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(165L, 10L, 1L, false);
      }
      if ((bool1) && (((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acIr, Integer.valueOf(0))).intValue() > 0))
      {
        com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.iJf().f(37, 2, -1, false);
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acIr, Integer.valueOf(0));
        localObject1 = new com.tencent.mm.pluginsdk.res.downloader.checkresupdate.m(37);
        com.tencent.mm.kernel.h.baD().mCm.a((p)localObject1, 0);
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(165L, 11L, 1L, false);
      }
      localObject1 = com.tencent.mm.modelemoji.b.bII();
      Log.i("MicroMsg.FontResLogic", "init");
      ((com.tencent.mm.modelemoji.b)localObject1).oDs.alive();
      if (!((com.tencent.mm.modelemoji.b)localObject1).bIK()) {
        break label1352;
      }
      com.tencent.mm.plugin.report.service.h.OAn.p(933L, 4L, 1L);
    }
    for (;;)
    {
      com.tencent.mm.emoji.sync.g.aWn().init();
      com.tencent.mm.emoji.sync.g.aWo().init();
      localObject1 = com.tencent.mm.emoji.c.m.mhY;
      com.tencent.mm.emoji.c.m.init();
      localObject1 = com.tencent.mm.emoji.f.c.moq;
      if (!com.tencent.mm.vfs.y.ZC(com.tencent.mm.emoji.f.c.aWD()))
      {
        com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.iJf();
        localObject1 = com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.nK(37, 7);
        if (com.tencent.mm.vfs.y.ZC((String)localObject1))
        {
          Log.i("MicroMsg.emoji.SubCoreEmoji", "update emoji anim res from cache");
          com.tencent.mm.plugin.emoji.mgr.h.dzH().aox((String)localObject1);
        }
      }
      com.tencent.threadpool.h.ahAA.bm(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(269901);
          Iterator localIterator = com.tencent.mm.smiley.o.iVl().iVm().iterator();
          while (localIterator.hasNext())
          {
            SmileyPanelConfigInfo localSmileyPanelConfigInfo = (SmileyPanelConfigInfo)localIterator.next();
            com.tencent.mm.smiley.o.iVl();
            com.tencent.mm.smiley.o.buC(localSmileyPanelConfigInfo.field_key);
          }
          AppMethodBeat.o(269901);
        }
      });
      AppMethodBeat.o(108652);
      return;
      label1324:
      l = Util.getInt(localObject2[0], 0) * 86400000L;
      break;
      bool1 = false;
      break label528;
      label1347:
      bool1 = false;
      break label915;
      label1352:
      com.tencent.mm.plugin.report.service.h.OAn.p(933L, 5L, 1L);
      com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.iJf();
      localObject2 = com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.nK(57, 1);
      if (com.tencent.mm.vfs.y.ZC((String)localObject2))
      {
        com.tencent.mm.plugin.report.service.h.OAn.p(933L, 6L, 1L);
        Log.i("MicroMsg.FontResLogic", "cache file exist %s", new Object[] { localObject2 });
        ((com.tencent.mm.modelemoji.b)localObject1).g((String)localObject2, 57, 1, 1);
      }
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(108651);
    Log.i("MicroMsg.emoji.SubCoreEmoji", "onAccountRelease: ");
    Object localObject = dAn();
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("emotionstore", ((com.tencent.mm.plugin.emoji.mgr.g)localObject).xLb, true);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("NewRecommendEmotion", ((com.tencent.mm.plugin.emoji.mgr.g)localObject).xLc, true);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("EmojiBackup", ((com.tencent.mm.plugin.emoji.mgr.g)localObject).xLd, true);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("EmotionBackup", ((com.tencent.mm.plugin.emoji.mgr.g)localObject).xLd, true);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("SelfieEmojiBackup", ((com.tencent.mm.plugin.emoji.mgr.g)localObject).xLd, true);
    localObject = dAo();
    com.tencent.mm.plugin.emoji.mgr.b.appForegroundListener.dead();
    ((com.tencent.mm.plugin.emoji.mgr.b)localObject).xKC.dead();
    ((com.tencent.mm.plugin.emoji.mgr.b)localObject).xKG.dead();
    ((com.tencent.mm.plugin.emoji.mgr.b)localObject).xKH.dead();
    ((com.tencent.mm.plugin.emoji.mgr.b)localObject).xKI.dead();
    ((com.tencent.mm.plugin.emoji.mgr.b)localObject).xKJ.dead();
    ((com.tencent.mm.plugin.emoji.mgr.b)localObject).xKK.dead();
    ((com.tencent.mm.plugin.emoji.mgr.b)localObject).checkLanguageChangeIListener.dead();
    ((com.tencent.mm.plugin.emoji.mgr.b)localObject).xKL.dead();
    ((com.tencent.mm.plugin.emoji.mgr.b)localObject).xKM.dead();
    ((com.tencent.mm.plugin.emoji.mgr.b)localObject).xKD.dead();
    ((com.tencent.mm.plugin.emoji.mgr.b)localObject).xKE.dead();
    ((com.tencent.mm.plugin.emoji.mgr.b)localObject).xKN.dead();
    ((com.tencent.mm.plugin.emoji.mgr.b)localObject).xKO.dead();
    ((com.tencent.mm.plugin.emoji.mgr.b)localObject).xKF.dead();
    localObject = bl.jba();
    ((bl)localObject).adju.remove(((bl)localObject).adjP);
    ((bl)localObject).adjv.remove(((bl)localObject).adjN);
    ((bl)localObject).adjw.remove(((bl)localObject).adjO);
    ((bl)localObject).adjQ.dead();
    localObject = ((bl)localObject).adjJ;
    if (((com.tencent.mm.emoji.c.l)localObject).mhS != null) {
      ((com.tencent.mm.emoji.c.l)localObject).mhS.clear();
    }
    ((com.tencent.mm.emoji.c.l)localObject).mhT.evictAll();
    getEmojiDescMgr().clear();
    ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).removeEmojiMgr();
    localObject = dAj();
    com.tencent.mm.kernel.h.baD().mCm.b(175, (com.tencent.mm.am.h)localObject);
    ((i)localObject).xMs.clear();
    ((i)localObject).xMz.clear();
    localObject = dAk();
    com.tencent.mm.kernel.h.baD().mCm.b(3862, (com.tencent.mm.am.h)localObject);
    com.tencent.mm.kernel.h.baD().mCm.b(697, (com.tencent.mm.am.h)localObject);
    ((d)localObject).xMs.clear();
    ((d)localObject).xMt.clear();
    localObject = dAp();
    ((com.tencent.mm.plugin.emoji.mgr.i)localObject).xLT = null;
    if (((com.tencent.mm.plugin.emoji.mgr.i)localObject).xLU != null) {
      ((com.tencent.mm.plugin.emoji.mgr.i)localObject).xLU.clear();
    }
    localObject = dAm().xPe;
    Log.d("MicroMsg.BKGLoader.BKGLoaderManager", "bkg detach");
    ((com.tencent.mm.plugin.emoji.sync.c)localObject).dAM();
    ((com.tencent.mm.plugin.emoji.sync.c)localObject).xPB.dead();
    ((com.tencent.mm.plugin.emoji.sync.c)localObject).xPC.dead();
    if (((com.tencent.mm.plugin.emoji.sync.c)localObject).xPx != null)
    {
      MMApplicationContext.getContext().unregisterReceiver(((com.tencent.mm.plugin.emoji.sync.c)localObject).xPx);
      ((com.tencent.mm.plugin.emoji.sync.c)localObject).xPx = null;
    }
    if (this.xNB != null)
    {
      localObject = this.xNB;
      ((t)localObject).xNN.dead();
      ((t)localObject).xNO.dead();
    }
    if (this.xNC != null)
    {
      localObject = this.xNC;
      ((n)localObject).xMZ.clear();
      dAj().xMB = null;
      ((n)localObject).xNa.dead();
    }
    if (this.xNI != null) {
      this.xNI.detach();
    }
    com.tencent.mm.modelemoji.b.bII().oDs.dead();
    com.tencent.mm.emoji.sync.g.aWn().destroy();
    com.tencent.mm.emoji.sync.g.aWo().destroy();
    AppMethodBeat.o(108651);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.s
 * JD-Core Version:    0.7.0.1
 */
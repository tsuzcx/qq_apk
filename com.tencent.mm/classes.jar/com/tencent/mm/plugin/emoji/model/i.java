package com.tencent.mm.plugin.emoji.model;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.j.a;
import com.tencent.mm.at.a.a.b.a;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.emoji.sync.EmojiSyncManager;
import com.tencent.mm.emoji.sync.EmojiSyncManager.a;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.emoji.e.k;
import com.tencent.mm.plugin.emoji.e.k.1;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager.ConnectivityReceiver;
import com.tencent.mm.pluginsdk.g.a.a.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class i
  implements com.tencent.mm.model.at
{
  private static HashMap<Integer, h.d> baseDBFactories;
  private c lhG;
  private aq lhH;
  private com.tencent.mm.plugin.emoji.e.h lhI;
  private j lhJ;
  private f lhK;
  private d lhL;
  private com.tencent.mm.plugin.emoji.sync.a<com.tencent.mm.plugin.emoji.sync.c> lhM;
  private volatile com.tencent.mm.plugin.emoji.e.i lhN;
  private volatile com.tencent.mm.plugin.emoji.e.c lhO;
  private volatile k lhP;
  private com.tencent.mm.at.a.a lhQ;
  
  static
  {
    AppMethodBeat.i(53077);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("EMOJIINFO_TABLE".hashCode()), new i.1());
    baseDBFactories.put(Integer.valueOf("EMOJIGROUPINFO_TABLE".hashCode()), new i.8());
    baseDBFactories.put(Integer.valueOf("EMOJIINFODESC_TABLE".hashCode()), new i.9());
    baseDBFactories.put(Integer.valueOf("EMOTIONDETAIL_TABLE".hashCode()), new i.10());
    baseDBFactories.put(Integer.valueOf("GETEMOTIONLISTCACHE_TABLE".hashCode()), new i.11());
    baseDBFactories.put(Integer.valueOf("EmotionRewardINFO_TABLE".hashCode()), new i.12());
    baseDBFactories.put(Integer.valueOf("EmotionDesignerInfoStorage_TABLE".hashCode()), new h.d()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.storage.emotion.h.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("EmotionRewardTipStorage_TABLE".hashCode()), new i.14());
    baseDBFactories.put(Integer.valueOf("SmileyInfoStorage_TABLE".hashCode()), new i.15());
    baseDBFactories.put(Integer.valueOf("SmileyPanelConfigInfoStorage_TABLE".hashCode()), new i.2());
    baseDBFactories.put(Integer.valueOf("EmojiDescMapStorage".hashCode()), new i.3());
    baseDBFactories.put(Integer.valueOf("DELETE".hashCode()), new i.4());
    AppMethodBeat.o(53077);
  }
  
  public static com.tencent.mm.at.a.a bld()
  {
    AppMethodBeat.i(53064);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (bln().lhQ == null)
    {
      localObject = new b.a(ah.getContext());
      ((b.a)localObject).fHk = new com.tencent.mm.plugin.emoji.d.a();
      ((b.a)localObject).fHi = new com.tencent.mm.view.d.a();
      localObject = ((b.a)localObject).ahO();
      bln().lhQ = new com.tencent.mm.at.a.a((com.tencent.mm.at.a.a.b)localObject);
    }
    Object localObject = bln().lhQ;
    AppMethodBeat.o(53064);
    return localObject;
  }
  
  private static i bln()
  {
    AppMethodBeat.i(53063);
    i locali = (i)q.S(i.class);
    AppMethodBeat.o(53063);
    return locali;
  }
  
  public static c blo()
  {
    AppMethodBeat.i(53065);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (bln().lhG == null) {
      bln().lhG = new c();
    }
    c localc = bln().lhG;
    AppMethodBeat.o(53065);
    return localc;
  }
  
  public static com.tencent.mm.plugin.emoji.e.h blp()
  {
    AppMethodBeat.i(53067);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (bln().lhI == null) {
      bln().lhI = new com.tencent.mm.plugin.emoji.e.h();
    }
    com.tencent.mm.plugin.emoji.e.h localh = bln().lhI;
    AppMethodBeat.o(53067);
    return localh;
  }
  
  public static com.tencent.mm.plugin.emoji.sync.a<com.tencent.mm.plugin.emoji.sync.c> blq()
  {
    AppMethodBeat.i(53068);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (bln().lhM == null) {
      bln().lhM = new com.tencent.mm.plugin.emoji.sync.a();
    }
    com.tencent.mm.plugin.emoji.sync.a locala = bln().lhM;
    AppMethodBeat.o(53068);
    return locala;
  }
  
  private static com.tencent.mm.plugin.emoji.e.i blr()
  {
    try
    {
      AppMethodBeat.i(53069);
      com.tencent.mm.kernel.g.RJ().QQ();
      if (bln().lhN == null) {
        bln().lhN = new com.tencent.mm.plugin.emoji.e.i();
      }
      com.tencent.mm.plugin.emoji.e.i locali = bln().lhN;
      AppMethodBeat.o(53069);
      return locali;
    }
    finally {}
  }
  
  private static com.tencent.mm.plugin.emoji.e.c bls()
  {
    AppMethodBeat.i(53070);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (bln().lhO == null) {
      bln().lhO = new com.tencent.mm.plugin.emoji.e.c();
    }
    com.tencent.mm.plugin.emoji.e.c localc = bln().lhO;
    AppMethodBeat.o(53070);
    return localc;
  }
  
  public static k blt()
  {
    AppMethodBeat.i(53072);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (bln().lhP == null) {
      bln().lhP = new k();
    }
    k localk = bln().lhP;
    AppMethodBeat.o(53072);
    return localk;
  }
  
  public static d blu()
  {
    AppMethodBeat.i(53075);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (bln().lhL == null) {
      bln().lhL = new d();
    }
    d locald = bln().lhL;
    AppMethodBeat.o(53075);
    return locald;
  }
  
  public static aq getEmojiDescMgr()
  {
    AppMethodBeat.i(53066);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (bln().lhH == null) {
      bln().lhH = new aq();
    }
    aq localaq = bln().lhH;
    AppMethodBeat.o(53066);
    return localaq;
  }
  
  public static com.tencent.mm.storage.at getEmojiStorageMgr()
  {
    AppMethodBeat.i(53071);
    com.tencent.mm.storage.at localat = com.tencent.mm.storage.at.dxt();
    AppMethodBeat.o(53071);
    return localat;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(53074);
    ab.i("MicroMsg.emoji.SubCoreEmoji", "[onAccountPostReset]");
    com.tencent.mm.pluginsdk.ui.chat.e.vYI = new i.5(this);
    com.tencent.mm.pluginsdk.ui.chat.e.vYJ = new i.6(this);
    com.tencent.mm.storage.at.dxt().dxu();
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).setEmojiMgr();
    Object localObject1 = blr();
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("emotionstore", ((com.tencent.mm.plugin.emoji.e.i)localObject1).lfT, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("NewRecommendEmotion", ((com.tencent.mm.plugin.emoji.e.i)localObject1).lfU, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("EmojiBackup", ((com.tencent.mm.plugin.emoji.e.i)localObject1).lfV, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("EmotionBackup", ((com.tencent.mm.plugin.emoji.e.i)localObject1).lfV, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("SelfieEmojiBackup", ((com.tencent.mm.plugin.emoji.e.i)localObject1).lfV, true);
    localObject1 = bls();
    com.tencent.mm.sdk.b.a.ymk.c(((com.tencent.mm.plugin.emoji.e.c)localObject1).lfo);
    com.tencent.mm.sdk.b.a.ymk.c(((com.tencent.mm.plugin.emoji.e.c)localObject1).lfs);
    com.tencent.mm.sdk.b.a.ymk.c(((com.tencent.mm.plugin.emoji.e.c)localObject1).lft);
    com.tencent.mm.sdk.b.a.ymk.c(((com.tencent.mm.plugin.emoji.e.c)localObject1).lfu);
    com.tencent.mm.plugin.emoji.e.c.appForegroundListener.alive();
    com.tencent.mm.sdk.b.a.ymk.c(((com.tencent.mm.plugin.emoji.e.c)localObject1).lfv);
    com.tencent.mm.sdk.b.a.ymk.c(((com.tencent.mm.plugin.emoji.e.c)localObject1).lfw);
    com.tencent.mm.sdk.b.a.ymk.c(((com.tencent.mm.plugin.emoji.e.c)localObject1).checkLanguageChangeIListener);
    com.tencent.mm.sdk.b.a.ymk.c(((com.tencent.mm.plugin.emoji.e.c)localObject1).lfx);
    com.tencent.mm.sdk.b.a.ymk.c(((com.tencent.mm.plugin.emoji.e.c)localObject1).lfy);
    com.tencent.mm.sdk.b.a.ymk.c(((com.tencent.mm.plugin.emoji.e.c)localObject1).lfp);
    com.tencent.mm.sdk.b.a.ymk.c(((com.tencent.mm.plugin.emoji.e.c)localObject1).lfq);
    com.tencent.mm.sdk.b.a.ymk.c(((com.tencent.mm.plugin.emoji.e.c)localObject1).lfz);
    com.tencent.mm.sdk.b.a.ymk.c(((com.tencent.mm.plugin.emoji.e.c)localObject1).lfA);
    com.tencent.mm.sdk.b.a.ymk.c(((com.tencent.mm.plugin.emoji.e.c)localObject1).lfr);
    localObject1 = com.tencent.mm.storage.at.dxt();
    ((com.tencent.mm.storage.at)localObject1).yNn.add(((com.tencent.mm.storage.at)localObject1).yNF);
    ((com.tencent.mm.storage.at)localObject1).yNo.add(((com.tencent.mm.storage.at)localObject1).yND);
    ((com.tencent.mm.storage.at)localObject1).yNp.add(((com.tencent.mm.storage.at)localObject1).yNE);
    com.tencent.mm.sdk.b.a.ymk.c(((com.tencent.mm.storage.at)localObject1).yNG);
    getEmojiDescMgr();
    localObject1 = blt();
    Object localObject2 = com.tencent.mm.m.g.Nq().getValue("EmotionRewardTipsLimit");
    long l;
    if (!bo.isNullOrNil((String)localObject2))
    {
      ab.i("MicroMsg.emoji.EmojiRewardTipMgr", "updateConfig dynamic config %s", new Object[] { localObject2 });
      localObject2 = ((String)localObject2).split(",");
      if ((localObject2 != null) && (localObject2.length == 3))
      {
        if (bo.getInt(localObject2[0], 0) != 0) {
          break label1344;
        }
        l = 863913600000L;
        ((k)localObject1).lgC = l;
        ((k)localObject1).lgD = (bo.getInt(localObject2[1], 20) - 1);
        ((k)localObject1).ejZ = (bo.getInt(localObject2[2], 80) - 1);
      }
    }
    boolean bool2 = com.tencent.mm.emoji.a.h.OI();
    boolean bool3 = ((Boolean)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yyd, Boolean.TRUE)).booleanValue();
    boolean bool1;
    if ((bool2) && (bool3))
    {
      bool1 = true;
      label588:
      ((k)localObject1).lgB = bool1;
      ab.i("MicroMsg.emoji.EmojiRewardTipMgr", "init RewardTipMgr RewardTipEnable:%b isEnableRewardTip:%b isTipsEnable:%b", new Object[] { Boolean.valueOf(((k)localObject1).lgB), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      com.tencent.mm.kernel.g.RO().ac(new k.1((k)localObject1));
      localObject1 = blq().lje;
      ab.d("MicroMsg.BKGLoader.BKGLoaderManager", "bkg attach");
      com.tencent.mm.sdk.b.a.ymk.c(((BKGLoaderManager)localObject1).ljA);
      com.tencent.mm.sdk.b.a.ymk.c(((BKGLoaderManager)localObject1).ljB);
      localObject2 = new IntentFilter();
      ((IntentFilter)localObject2).addAction("android.net.conn.CONNECTIVITY_CHANGE");
      ((BKGLoaderManager)localObject1).ljw = new BKGLoaderManager.ConnectivityReceiver((BKGLoaderManager)localObject1);
      ah.getContext().registerReceiver(((BKGLoaderManager)localObject1).ljw, (IntentFilter)localObject2);
      ab.i("MicroMsg.emoji.SubCoreEmoji", "[oneliang]initCore");
      localObject1 = com.tencent.mm.storage.at.dxt();
      localObject2 = ah.getContext();
      if (localObject2 != null)
      {
        bool1 = ((Boolean)com.tencent.mm.kernel.g.RL().Ru().get(274480, Boolean.TRUE)).booleanValue();
        ab.i("MicroMsg.emoji.EmojiStorageMgr", "[oneliang]initCore,need init emoji:%s", new Object[] { String.valueOf(bool1) });
        if (bool1)
        {
          ((com.tencent.mm.storage.at)localObject1).yNn.init((Context)localObject2);
          ((com.tencent.mm.storage.at)localObject1).yNo.init((Context)localObject2);
        }
        com.tencent.mm.kernel.g.RL().Ru().set(274480, Boolean.FALSE);
      }
      if (((Integer)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yye, Integer.valueOf(0))).intValue() != com.tencent.mm.protocal.d.whH)
      {
        l = System.currentTimeMillis();
        ((com.tencent.mm.storage.at)localObject1).yNo.dzi();
        com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yye, Integer.valueOf(com.tencent.mm.protocal.d.whH));
        ab.i("MicroMsg.emoji.EmojiStorageMgr", "recoverCustomEmojiGroup use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      }
      if (((Boolean)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yyf, Boolean.TRUE)).booleanValue())
      {
        l = System.currentTimeMillis();
        bool1 = ((com.tencent.mm.storage.at)localObject1).yNo.dzj();
        localObject1 = com.tencent.mm.kernel.g.RL().Ru();
        localObject2 = ac.a.yyf;
        if (bool1) {
          break label1367;
        }
        bool1 = true;
        label983:
        ((z)localObject1).set((ac.a)localObject2, Boolean.valueOf(bool1));
        ab.i("MicroMsg.emoji.EmojiStorageMgr", "updateEmojiGroupCount use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      }
      this.lhJ = new j();
      this.lhK = new f();
      com.tencent.mm.ao.a.cX(paramBoolean);
      paramBoolean = com.tencent.mm.cd.f.dvf().dvh();
      bool1 = com.tencent.mm.cd.e.dve().dvd();
      if ((paramBoolean) && (((Integer)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yyg, Integer.valueOf(0))).intValue() > 0))
      {
        b.c.dmg().e(37, 1, -1, false);
        com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yyg, Integer.valueOf(0));
        localObject1 = new com.tencent.mm.pluginsdk.g.a.a.m(37);
        com.tencent.mm.kernel.g.RK().eHt.a((com.tencent.mm.ai.m)localObject1, 0);
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(165L, 10L, 1L, false);
      }
      if ((bool1) && (((Integer)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yyh, Integer.valueOf(0))).intValue() > 0))
      {
        b.c.dmg().e(37, 2, -1, false);
        com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yyh, Integer.valueOf(0));
        localObject1 = new com.tencent.mm.pluginsdk.g.a.a.m(37);
        com.tencent.mm.kernel.g.RK().eHt.a((com.tencent.mm.ai.m)localObject1, 0);
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(165L, 11L, 1L, false);
      }
      localObject1 = com.tencent.mm.ao.b.agp();
      ab.i("MicroMsg.FontResLogic", "init");
      ((com.tencent.mm.ao.b)localObject1).fAZ.alive();
      if (!((com.tencent.mm.ao.b)localObject1).ags()) {
        break label1372;
      }
      com.tencent.mm.plugin.report.service.h.qsU.j(933L, 4L, 1L);
    }
    for (;;)
    {
      localObject1 = EmojiSyncManager.exH;
      EmojiSyncManager.a.Pg().init();
      localObject1 = EmojiSyncManager.exH;
      EmojiSyncManager.a.Ph().init();
      localObject1 = com.tencent.mm.emoji.a.e.ewz;
      com.tencent.mm.emoji.a.e.OE();
      com.tencent.mm.sdk.g.d.ysm.execute(new i.7(this));
      AppMethodBeat.o(53074);
      return;
      label1344:
      l = bo.getInt(localObject2[0], 0) * 86400000L;
      break;
      bool1 = false;
      break label588;
      label1367:
      bool1 = false;
      break label983;
      label1372:
      com.tencent.mm.plugin.report.service.h.qsU.j(933L, 5L, 1L);
      b.c.dmg();
      localObject2 = com.tencent.mm.pluginsdk.g.a.a.b.hc(57, 1);
      if (com.tencent.mm.vfs.e.cN((String)localObject2))
      {
        com.tencent.mm.plugin.report.service.h.qsU.j(933L, 6L, 1L);
        ab.i("MicroMsg.FontResLogic", "cache file exist %s", new Object[] { localObject2 });
        ((com.tencent.mm.ao.b)localObject1).e((String)localObject2, 57, 1, 1);
      }
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(53073);
    ab.i("MicroMsg.emoji.SubCoreEmoji", "onAccountRelease: ");
    Object localObject = blr();
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("emotionstore", ((com.tencent.mm.plugin.emoji.e.i)localObject).lfT, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("NewRecommendEmotion", ((com.tencent.mm.plugin.emoji.e.i)localObject).lfU, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("EmojiBackup", ((com.tencent.mm.plugin.emoji.e.i)localObject).lfV, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("EmotionBackup", ((com.tencent.mm.plugin.emoji.e.i)localObject).lfV, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("SelfieEmojiBackup", ((com.tencent.mm.plugin.emoji.e.i)localObject).lfV, true);
    localObject = bls();
    com.tencent.mm.plugin.emoji.e.c.appForegroundListener.dead();
    com.tencent.mm.sdk.b.a.ymk.d(((com.tencent.mm.plugin.emoji.e.c)localObject).lfo);
    com.tencent.mm.sdk.b.a.ymk.d(((com.tencent.mm.plugin.emoji.e.c)localObject).lfs);
    com.tencent.mm.sdk.b.a.ymk.d(((com.tencent.mm.plugin.emoji.e.c)localObject).lft);
    com.tencent.mm.sdk.b.a.ymk.d(((com.tencent.mm.plugin.emoji.e.c)localObject).lfu);
    com.tencent.mm.sdk.b.a.ymk.d(((com.tencent.mm.plugin.emoji.e.c)localObject).lfv);
    com.tencent.mm.sdk.b.a.ymk.d(((com.tencent.mm.plugin.emoji.e.c)localObject).lfw);
    com.tencent.mm.sdk.b.a.ymk.d(((com.tencent.mm.plugin.emoji.e.c)localObject).checkLanguageChangeIListener);
    com.tencent.mm.sdk.b.a.ymk.d(((com.tencent.mm.plugin.emoji.e.c)localObject).lfx);
    com.tencent.mm.sdk.b.a.ymk.d(((com.tencent.mm.plugin.emoji.e.c)localObject).lfy);
    com.tencent.mm.sdk.b.a.ymk.d(((com.tencent.mm.plugin.emoji.e.c)localObject).lfp);
    com.tencent.mm.sdk.b.a.ymk.d(((com.tencent.mm.plugin.emoji.e.c)localObject).lfq);
    com.tencent.mm.sdk.b.a.ymk.d(((com.tencent.mm.plugin.emoji.e.c)localObject).lfz);
    com.tencent.mm.sdk.b.a.ymk.d(((com.tencent.mm.plugin.emoji.e.c)localObject).lfA);
    com.tencent.mm.sdk.b.a.ymk.d(((com.tencent.mm.plugin.emoji.e.c)localObject).lfr);
    localObject = com.tencent.mm.storage.at.dxt();
    ((com.tencent.mm.storage.at)localObject).yNn.remove(((com.tencent.mm.storage.at)localObject).yNF);
    ((com.tencent.mm.storage.at)localObject).yNo.remove(((com.tencent.mm.storage.at)localObject).yND);
    ((com.tencent.mm.storage.at)localObject).yNp.remove(((com.tencent.mm.storage.at)localObject).yNE);
    com.tencent.mm.sdk.b.a.ymk.d(((com.tencent.mm.storage.at)localObject).yNG);
    localObject = ((com.tencent.mm.storage.at)localObject).yNz;
    if (((com.tencent.mm.emoji.a.d)localObject).eww != null) {
      ((com.tencent.mm.emoji.a.d)localObject).eww.clear();
    }
    if (((com.tencent.mm.emoji.a.d)localObject).ewx != null) {
      ((com.tencent.mm.emoji.a.d)localObject).ewx.clear();
    }
    getEmojiDescMgr().clear();
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).removeEmojiMgr();
    localObject = blo();
    com.tencent.mm.kernel.g.RK().eHt.b(175, (com.tencent.mm.ai.f)localObject);
    ((c)localObject).lhd.clear();
    ((c)localObject).lhb.clear();
    localObject = blt();
    ((k)localObject).lgE = null;
    if (((k)localObject).lgF != null) {
      ((k)localObject).lgF.clear();
    }
    localObject = blq().lje;
    ab.d("MicroMsg.BKGLoader.BKGLoaderManager", "bkg detach");
    ((BKGLoaderManager)localObject).blL();
    com.tencent.mm.sdk.b.a.ymk.d(((BKGLoaderManager)localObject).ljA);
    com.tencent.mm.sdk.b.a.ymk.d(((BKGLoaderManager)localObject).ljB);
    if (((BKGLoaderManager)localObject).ljw != null)
    {
      ah.getContext().unregisterReceiver(((BKGLoaderManager)localObject).ljw);
      ((BKGLoaderManager)localObject).ljw = null;
    }
    com.tencent.mm.plugin.emoji.e.f.bkQ().isRunning = false;
    if (this.lhJ != null)
    {
      localObject = this.lhJ;
      com.tencent.mm.sdk.b.a.ymk.d(((j)localObject).lhV);
      com.tencent.mm.sdk.b.a.ymk.d(((j)localObject).lhW);
    }
    if (this.lhK != null)
    {
      localObject = this.lhK;
      ((f)localObject).lhq.clear();
      blo().lhf = null;
      ((f)localObject).lhr.dead();
    }
    if (this.lhQ != null) {
      this.lhQ.detach();
    }
    com.tencent.mm.ao.b.agp().fAZ.dead();
    localObject = EmojiSyncManager.exH;
    EmojiSyncManager.a.Pg().destroy();
    localObject = EmojiSyncManager.exH;
    EmojiSyncManager.a.Ph().destroy();
    AppMethodBeat.o(53073);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.i
 * JD-Core Version:    0.7.0.1
 */
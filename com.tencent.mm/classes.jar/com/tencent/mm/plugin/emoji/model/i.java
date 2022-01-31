package com.tencent.mm.plugin.emoji.model;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.mm.as.a.a.b.a;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.bx;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.emoji.e.l;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager.ConnectivityReceiver;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.g.a.a.b.c;
import com.tencent.mm.protocal.c.bsl;
import com.tencent.mm.protocal.c.bsm;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.n;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class i
  implements ar
{
  private static HashMap<Integer, h.d> dgp;
  private d iYB;
  private aq iYC;
  private com.tencent.mm.plugin.emoji.e.f iYD;
  private j iYE;
  private g iYF;
  private e iYG;
  private com.tencent.mm.plugin.emoji.sync.a<com.tencent.mm.plugin.emoji.sync.d> iYH;
  private volatile com.tencent.mm.plugin.emoji.e.g iYI;
  private volatile com.tencent.mm.plugin.emoji.e.a iYJ;
  private volatile at iYK;
  private volatile com.tencent.mm.plugin.emoji.e.i iYL;
  private com.tencent.mm.as.a.a iYM;
  private c iYN;
  
  static
  {
    HashMap localHashMap = new HashMap();
    dgp = localHashMap;
    localHashMap.put(Integer.valueOf("EMOJIINFO_TABLE".hashCode()), new i.1());
    dgp.put(Integer.valueOf("EMOJIGROUPINFO_TABLE".hashCode()), new i.7());
    dgp.put(Integer.valueOf("EMOJIINFODESC_TABLE".hashCode()), new i.8());
    dgp.put(Integer.valueOf("EMOTIONDETAIL_TABLE".hashCode()), new i.9());
    dgp.put(Integer.valueOf("GETEMOTIONLISTCACHE_TABLE".hashCode()), new i.10());
    dgp.put(Integer.valueOf("EmotionRewardINFO_TABLE".hashCode()), new i.11());
    dgp.put(Integer.valueOf("EmotionDesignerInfoStorage_TABLE".hashCode()), new i.12());
    dgp.put(Integer.valueOf("EmotionRewardTipStorage_TABLE".hashCode()), new h.d()
    {
      public final String[] rK()
      {
        return n.dXp;
      }
    });
    dgp.put(Integer.valueOf("SmileyInfoStorage_TABLE".hashCode()), new i.14());
    dgp.put(Integer.valueOf("SmileyPanelConfigInfoStorage_TABLE".hashCode()), new i.2());
    dgp.put(Integer.valueOf("EmojiDescMapStorage".hashCode()), new i.3());
    dgp.put(Integer.valueOf("DELETE".hashCode()), new i.4());
  }
  
  private static i aHN()
  {
    return (i)com.tencent.mm.model.p.B(i.class);
  }
  
  public static d aHO()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (aHN().iYB == null) {
      aHN().iYB = new d();
    }
    return aHN().iYB;
  }
  
  public static com.tencent.mm.plugin.emoji.e.f aHP()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (aHN().iYD == null) {
      aHN().iYD = new com.tencent.mm.plugin.emoji.e.f();
    }
    return aHN().iYD;
  }
  
  public static com.tencent.mm.plugin.emoji.sync.a<com.tencent.mm.plugin.emoji.sync.d> aHQ()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (aHN().iYH == null) {
      aHN().iYH = new com.tencent.mm.plugin.emoji.sync.a();
    }
    return aHN().iYH;
  }
  
  private static com.tencent.mm.plugin.emoji.e.g aHR()
  {
    try
    {
      com.tencent.mm.kernel.g.DN().CX();
      if (aHN().iYI == null) {
        aHN().iYI = new com.tencent.mm.plugin.emoji.e.g();
      }
      com.tencent.mm.plugin.emoji.e.g localg = aHN().iYI;
      return localg;
    }
    finally {}
  }
  
  private static com.tencent.mm.plugin.emoji.e.a aHS()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (aHN().iYJ == null) {
      aHN().iYJ = new com.tencent.mm.plugin.emoji.e.a();
    }
    return aHN().iYJ;
  }
  
  public static com.tencent.mm.plugin.emoji.e.i aHT()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (aHN().iYL == null) {
      aHN().iYL = new com.tencent.mm.plugin.emoji.e.i();
    }
    return aHN().iYL;
  }
  
  public static e aHU()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (aHN().iYG == null) {
      aHN().iYG = new e();
    }
    return aHN().iYG;
  }
  
  public static c aHV()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (aHN().iYN == null) {
      aHN().iYN = new c();
    }
    return aHN().iYN;
  }
  
  public static com.tencent.mm.as.a.a aHr()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (aHN().iYM == null)
    {
      Object localObject = new b.a(ae.getContext());
      ((b.a)localObject).eqU = new com.tencent.mm.plugin.emoji.d.a();
      ((b.a)localObject).eqS = new com.tencent.mm.view.d.a();
      localObject = ((b.a)localObject).OU();
      aHN().iYM = new com.tencent.mm.as.a.a((com.tencent.mm.as.a.a.b)localObject);
    }
    return aHN().iYM;
  }
  
  public static aq getEmojiDescMgr()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (aHN().iYC == null) {
      aHN().iYC = new aq();
    }
    return aHN().iYC;
  }
  
  public static at getEmojiStorageMgr()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (aHN().iYK == null) {
      aHN().iYK = new at();
    }
    return aHN().iYK;
  }
  
  public final void bh(boolean paramBoolean)
  {
    y.i("MicroMsg.emoji.SubCoreEmoji", "[onAccountPostReset]");
    com.tencent.mm.pluginsdk.ui.chat.e.sgr = new i.5(this);
    com.tencent.mm.pluginsdk.ui.chat.e.sgs = new i.6(this);
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).setEmojiMgr();
    Object localObject1 = aHR();
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("emotionstore", ((com.tencent.mm.plugin.emoji.e.g)localObject1).iWH, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("NewRecommendEmotion", ((com.tencent.mm.plugin.emoji.e.g)localObject1).iWI, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("EmojiBackup", ((com.tencent.mm.plugin.emoji.e.g)localObject1).iWJ, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("EmotionBackup", ((com.tencent.mm.plugin.emoji.e.g)localObject1).iWJ, true);
    localObject1 = aHS();
    com.tencent.mm.sdk.b.a.udP.c(((com.tencent.mm.plugin.emoji.e.a)localObject1).iWf);
    com.tencent.mm.sdk.b.a.udP.c(((com.tencent.mm.plugin.emoji.e.a)localObject1).iWj);
    com.tencent.mm.sdk.b.a.udP.c(((com.tencent.mm.plugin.emoji.e.a)localObject1).iWk);
    com.tencent.mm.sdk.b.a.udP.c(((com.tencent.mm.plugin.emoji.e.a)localObject1).iWl);
    com.tencent.mm.sdk.b.a.udP.c(((com.tencent.mm.plugin.emoji.e.a)localObject1).iWm);
    com.tencent.mm.sdk.b.a.udP.c(((com.tencent.mm.plugin.emoji.e.a)localObject1).iWn);
    com.tencent.mm.sdk.b.a.udP.c(((com.tencent.mm.plugin.emoji.e.a)localObject1).iWo);
    com.tencent.mm.sdk.b.a.udP.c(((com.tencent.mm.plugin.emoji.e.a)localObject1).iWp);
    com.tencent.mm.sdk.b.a.udP.c(((com.tencent.mm.plugin.emoji.e.a)localObject1).iWq);
    com.tencent.mm.sdk.b.a.udP.c(((com.tencent.mm.plugin.emoji.e.a)localObject1).iWg);
    com.tencent.mm.sdk.b.a.udP.c(((com.tencent.mm.plugin.emoji.e.a)localObject1).iWh);
    com.tencent.mm.sdk.b.a.udP.c(((com.tencent.mm.plugin.emoji.e.a)localObject1).iWr);
    com.tencent.mm.sdk.b.a.udP.c(((com.tencent.mm.plugin.emoji.e.a)localObject1).iWs);
    com.tencent.mm.sdk.b.a.udP.c(((com.tencent.mm.plugin.emoji.e.a)localObject1).iWi);
    localObject1 = getEmojiStorageMgr();
    ((at)localObject1).uBb.c(((at)localObject1).uBw);
    ((at)localObject1).uBc.c(((at)localObject1).uBu);
    ((at)localObject1).uBd.c(((at)localObject1).uBv);
    com.tencent.mm.sdk.b.a.udP.c(((at)localObject1).uBx);
    getEmojiDescMgr();
    localObject1 = aHT();
    Object localObject2 = com.tencent.mm.m.g.AA().getValue("EmotionRewardTipsLimit");
    long l;
    if (!bk.bl((String)localObject2))
    {
      y.i("MicroMsg.emoji.EmojiRewardTipMgr", "updateConfig dynamic config %s", new Object[] { localObject2 });
      localObject2 = ((String)localObject2).split(",");
      if ((localObject2 != null) && (localObject2.length == 3))
      {
        if (bk.getInt(localObject2[0], 0) != 0) {
          break label1540;
        }
        l = 863913600000L;
        ((com.tencent.mm.plugin.emoji.e.i)localObject1).iXp = l;
        ((com.tencent.mm.plugin.emoji.e.i)localObject1).iXq = (bk.getInt(localObject2[1], 20) - 1);
        ((com.tencent.mm.plugin.emoji.e.i)localObject1).dsr = (bk.getInt(localObject2[2], 80) - 1);
      }
    }
    boolean bool2 = l.aHA();
    boolean bool3 = ((Boolean)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uok, Boolean.valueOf(true))).booleanValue();
    boolean bool1;
    label548:
    label954:
    int i;
    label1093:
    int j;
    if ((bool2) && (bool3))
    {
      bool1 = true;
      ((com.tencent.mm.plugin.emoji.e.i)localObject1).iXo = bool1;
      y.i("MicroMsg.emoji.EmojiRewardTipMgr", "init RewardTipMgr RewardTipEnable:%b isEnableRewardTip:%b isTipsEnable:%b", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.emoji.e.i)localObject1).iXo), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      com.tencent.mm.kernel.g.DS().O(new com.tencent.mm.plugin.emoji.e.i.1((com.tencent.mm.plugin.emoji.e.i)localObject1));
      localObject1 = aHQ().jan;
      y.d("MicroMsg.BKGLoader.BKGLoaderManager", "bkg attach");
      com.tencent.mm.sdk.b.a.udP.c(((BKGLoaderManager)localObject1).jaR);
      com.tencent.mm.sdk.b.a.udP.c(((BKGLoaderManager)localObject1).jaS);
      localObject2 = new IntentFilter();
      ((IntentFilter)localObject2).addAction("android.net.conn.CONNECTIVITY_CHANGE");
      ((BKGLoaderManager)localObject1).jaN = new BKGLoaderManager.ConnectivityReceiver((BKGLoaderManager)localObject1);
      ae.getContext().registerReceiver(((BKGLoaderManager)localObject1).jaN, (IntentFilter)localObject2);
      y.i("MicroMsg.emoji.SubCoreEmoji", "[oneliang]initCore");
      localObject1 = getEmojiStorageMgr();
      localObject2 = ae.getContext();
      if (localObject2 != null)
      {
        bool1 = ((Boolean)com.tencent.mm.kernel.g.DP().Dz().get(274480, Boolean.valueOf(true))).booleanValue();
        y.i("MicroMsg.emoji.EmojiStorageMgr", "[oneliang]initCore,need init emoji:%s", new Object[] { String.valueOf(bool1) });
        if (bool1)
        {
          ((at)localObject1).uBb.gj((Context)localObject2);
          ((at)localObject1).uBc.gj((Context)localObject2);
        }
        com.tencent.mm.kernel.g.DP().Dz().o(274480, Boolean.valueOf(false));
      }
      if (((Integer)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uol, Integer.valueOf(0))).intValue() != com.tencent.mm.protocal.d.spa)
      {
        l = System.currentTimeMillis();
        ((at)localObject1).uBc.cwx();
        com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uol, Integer.valueOf(com.tencent.mm.protocal.d.spa));
        y.i("MicroMsg.emoji.EmojiStorageMgr", "recoverCustomEmojiGroup use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      }
      if (((Boolean)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uom, Boolean.valueOf(true))).booleanValue())
      {
        l = System.currentTimeMillis();
        bool1 = ((at)localObject1).uBc.cwy();
        localObject1 = com.tencent.mm.kernel.g.DP().Dz();
        localObject2 = ac.a.uom;
        if (bool1) {
          break label1564;
        }
        bool1 = true;
        ((z)localObject1).c((ac.a)localObject2, Boolean.valueOf(bool1));
        y.i("MicroMsg.emoji.EmojiStorageMgr", "updateEmojiGroupCount use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      }
      this.iYE = new j();
      this.iYF = new g();
      com.tencent.mm.an.a.bV(paramBoolean);
      localObject1 = aHV();
      com.tencent.mm.kernel.g.DO().dJT.a(697, (com.tencent.mm.ah.f)localObject1);
      localObject1 = com.tencent.mm.cd.f.csI();
      y.i("MicroMsg.QQSmileyManager", "checkNewEmoji");
      localObject2 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aHh();
      if ((localObject2 != null) && (!((List)localObject2).isEmpty())) {
        break label1570;
      }
      ((com.tencent.mm.cd.f)localObject1).csK();
      i = 1;
      localObject1 = com.tencent.mm.cd.e.csH();
      y.i("MicroMsg.MergerSmileyManager", "checkNewSmiley ");
      localObject2 = ((PluginEmoji)com.tencent.mm.kernel.g.t(PluginEmoji.class)).getEmojiMgr().aHi();
      if ((localObject2 != null) && (!((ArrayList)localObject2).isEmpty())) {
        break label1585;
      }
      ((com.tencent.mm.cd.e)localObject1).asv();
      j = 1;
      label1147:
      if ((i != 0) && (((Integer)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uon, Integer.valueOf(0))).intValue() > 0))
      {
        b.c.clv().d(37, 1, -1, false);
        com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uon, Integer.valueOf(0));
        localObject1 = new com.tencent.mm.pluginsdk.g.a.a.m(37);
        com.tencent.mm.kernel.g.DO().dJT.a((com.tencent.mm.ah.m)localObject1, 0);
        h.nFQ.a(165L, 10L, 1L, false);
      }
      if ((j != 0) && (((Integer)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uoo, Integer.valueOf(0))).intValue() > 0))
      {
        b.c.clv().d(37, 2, -1, false);
        com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uoo, Integer.valueOf(0));
        localObject1 = new com.tencent.mm.pluginsdk.g.a.a.m(37);
        com.tencent.mm.kernel.g.DO().dJT.a((com.tencent.mm.ah.m)localObject1, 0);
        h.nFQ.a(165L, 11L, 1L, false);
      }
      localObject1 = com.tencent.mm.an.b.NC();
      y.i("MicroMsg.FontResLogic", "init");
      ((com.tencent.mm.an.b)localObject1).ekJ.cqo();
      if (!((com.tencent.mm.an.b)localObject1).NF()) {
        break label1596;
      }
      h.nFQ.h(933L, 4L, 1L);
    }
    for (;;)
    {
      if (((Long)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.wuQ, Long.valueOf(0L))).longValue() <= 0L) {
        com.tencent.mm.kernel.g.DP().Dz().c(ac.a.wuQ, Long.valueOf(System.currentTimeMillis()));
      }
      if (!com.tencent.mm.kernel.g.DP().Dz().getBoolean(ac.a.uzA, false))
      {
        localObject1 = getEmojiStorageMgr().uBe.aHm();
        if (localObject1 != null)
        {
          localObject2 = ((bsl)localObject1).tIZ.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            bsm localbsm = (bsm)((Iterator)localObject2).next();
            if (localbsm.syc.equals(String.valueOf(EmojiGroupInfo.uCR))) {
              localbsm.sAr = 0;
            }
          }
        }
        getEmojiStorageMgr().uBe.b((bsl)localObject1);
        com.tencent.mm.kernel.g.DP().Dz().c(ac.a.wuS, Boolean.valueOf(true));
      }
      return;
      label1540:
      l = bk.getInt(localObject2[0], 0) * 86400000L;
      break;
      bool1 = false;
      break label548;
      label1564:
      bool1 = false;
      break label954;
      label1570:
      com.tencent.mm.cd.f.dm((List)localObject2);
      ((com.tencent.mm.cd.f)localObject1).csK();
      i = 0;
      break label1093;
      label1585:
      ((com.tencent.mm.cd.e)localObject1).asv();
      j = 0;
      break label1147;
      label1596:
      h.nFQ.h(933L, 5L, 1L);
      b.c.clv();
      localObject2 = com.tencent.mm.pluginsdk.g.a.a.b.eV(57, 1);
      if (com.tencent.mm.vfs.e.bK((String)localObject2))
      {
        h.nFQ.h(933L, 6L, 1L);
        y.i("MicroMsg.FontResLogic", "cache file exist %s", new Object[] { localObject2 });
        ((com.tencent.mm.an.b)localObject1).d((String)localObject2, 57, 1, 1);
      }
    }
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    Object localObject = aHR();
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("emotionstore", ((com.tencent.mm.plugin.emoji.e.g)localObject).iWH, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("NewRecommendEmotion", ((com.tencent.mm.plugin.emoji.e.g)localObject).iWI, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("EmojiBackup", ((com.tencent.mm.plugin.emoji.e.g)localObject).iWJ, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("EmotionBackup", ((com.tencent.mm.plugin.emoji.e.g)localObject).iWJ, true);
    localObject = aHS();
    com.tencent.mm.sdk.b.a.udP.d(((com.tencent.mm.plugin.emoji.e.a)localObject).iWf);
    com.tencent.mm.sdk.b.a.udP.d(((com.tencent.mm.plugin.emoji.e.a)localObject).iWj);
    com.tencent.mm.sdk.b.a.udP.d(((com.tencent.mm.plugin.emoji.e.a)localObject).iWk);
    com.tencent.mm.sdk.b.a.udP.d(((com.tencent.mm.plugin.emoji.e.a)localObject).iWl);
    com.tencent.mm.sdk.b.a.udP.d(((com.tencent.mm.plugin.emoji.e.a)localObject).iWm);
    com.tencent.mm.sdk.b.a.udP.d(((com.tencent.mm.plugin.emoji.e.a)localObject).iWn);
    com.tencent.mm.sdk.b.a.udP.d(((com.tencent.mm.plugin.emoji.e.a)localObject).iWo);
    com.tencent.mm.sdk.b.a.udP.d(((com.tencent.mm.plugin.emoji.e.a)localObject).iWp);
    com.tencent.mm.sdk.b.a.udP.d(((com.tencent.mm.plugin.emoji.e.a)localObject).iWq);
    com.tencent.mm.sdk.b.a.udP.d(((com.tencent.mm.plugin.emoji.e.a)localObject).iWg);
    com.tencent.mm.sdk.b.a.udP.d(((com.tencent.mm.plugin.emoji.e.a)localObject).iWh);
    com.tencent.mm.sdk.b.a.udP.d(((com.tencent.mm.plugin.emoji.e.a)localObject).iWr);
    com.tencent.mm.sdk.b.a.udP.d(((com.tencent.mm.plugin.emoji.e.a)localObject).iWs);
    com.tencent.mm.sdk.b.a.udP.d(((com.tencent.mm.plugin.emoji.e.a)localObject).iWi);
    localObject = getEmojiStorageMgr();
    ((at)localObject).uBb.d(((at)localObject).uBw);
    ((at)localObject).uBc.d(((at)localObject).uBu);
    ((at)localObject).uBd.d(((at)localObject).uBv);
    com.tencent.mm.sdk.b.a.udP.d(((at)localObject).uBx);
    if (at.uBs != null)
    {
      at.uBs.clear();
      at.uBs = null;
    }
    if (at.uBt != null)
    {
      at.uBt.clear();
      at.uBt = null;
    }
    getEmojiDescMgr().clear();
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).removeEmojiMgr();
    localObject = aHO();
    com.tencent.mm.kernel.g.DO().dJT.b(175, (com.tencent.mm.ah.f)localObject);
    ((d)localObject).iXY.clear();
    ((d)localObject).iXW.clear();
    ((d)localObject).iYb.clear();
    localObject = aHT();
    ((com.tencent.mm.plugin.emoji.e.i)localObject).iXr = null;
    if (((com.tencent.mm.plugin.emoji.e.i)localObject).iXs != null) {
      ((com.tencent.mm.plugin.emoji.e.i)localObject).iXs.clear();
    }
    localObject = aHQ().jan;
    y.d("MicroMsg.BKGLoader.BKGLoaderManager", "bkg detach");
    ((BKGLoaderManager)localObject).bOE();
    com.tencent.mm.sdk.b.a.udP.d(((BKGLoaderManager)localObject).jaR);
    com.tencent.mm.sdk.b.a.udP.d(((BKGLoaderManager)localObject).jaS);
    if (((BKGLoaderManager)localObject).jaN != null)
    {
      ae.getContext().unregisterReceiver(((BKGLoaderManager)localObject).jaN);
      ((BKGLoaderManager)localObject).jaN = null;
    }
    if (this.iYE != null)
    {
      localObject = this.iYE;
      com.tencent.mm.sdk.b.a.udP.d(((j)localObject).iYS);
      com.tencent.mm.sdk.b.a.udP.d(((j)localObject).iYT);
    }
    if (this.iYF != null)
    {
      localObject = this.iYF;
      ((g)localObject).iYm.clear();
      aHO().iYa = null;
      ((g)localObject).iYn.dead();
    }
    if (this.iYM != null) {
      this.iYM.detach();
    }
    localObject = aHV();
    com.tencent.mm.kernel.g.DO().dJT.b(697, (com.tencent.mm.ah.f)localObject);
    com.tencent.mm.an.b.NC().ekJ.dead();
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return dgp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.i
 * JD-Core Version:    0.7.0.1
 */
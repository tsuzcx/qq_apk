package com.tencent.mm.plugin.luckymoney.app;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.c;
import com.tencent.mm.am.s;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.q;
import com.tencent.mm.autogen.a.adn;
import com.tencent.mm.autogen.a.bs;
import com.tencent.mm.autogen.a.gh;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.model.be;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.cl.a;
import com.tencent.mm.plugin.luckymoney.model.LuckyMoneyC2CNYPredownloadImgListener;
import com.tencent.mm.plugin.luckymoney.model.LuckyMoneyEnvelopeResUpdateListener;
import com.tencent.mm.plugin.luckymoney.model.ag;
import com.tencent.mm.plugin.luckymoney.model.ah;
import com.tencent.mm.plugin.luckymoney.model.bl;
import com.tencent.mm.plugin.luckymoney.model.p;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.wallet_core.model.ad;
import com.tencent.mm.pluginsdk.model.app.at;
import com.tencent.mm.pluginsdk.model.app.e;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storagebase.h.b;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class a
  implements q, be, i.a, com.tencent.mm.plugin.messenger.foundation.a.i
{
  public static int KlK;
  private static HashMap<Integer, h.b> baseDBFactories;
  private p KlF;
  private ag KlG;
  private com.tencent.mm.plugin.luckymoney.model.v KlH;
  private com.tencent.mm.plugin.luckymoney.model.w KlI;
  private LuckyMoneyC2CNYPredownloadImgListener KlJ;
  private bl KlL;
  private com.tencent.mm.cp.h<com.tencent.mm.plugin.luckymoney.model.u> KlM;
  private com.tencent.mm.cp.h<com.tencent.mm.plugin.luckymoney.story.b.b> KlN;
  private com.tencent.mm.cp.h<com.tencent.mm.plugin.luckymoney.story.b.d> KlO;
  private com.tencent.mm.cp.h<com.tencent.mm.plugin.luckymoney.story.b.f> KlP;
  private LuckyMoneyEnvelopeResUpdateListener KlQ;
  public IListener<gh> KlR;
  private IListener<bs> KlS;
  private IListener<adn> KlT;
  private cl.a wXR;
  
  static
  {
    AppMethodBeat.i(64867);
    KlK = -1;
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("LuckyMoneyEnvelopeResource".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.luckymoney.model.u.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("LocalRedPacketStoryInfo".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.luckymoney.story.b.b.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("LocalStoryDetail".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.luckymoney.story.b.d.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("LuckyMoneyDetailOpenRecord".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.luckymoney.story.b.f.SQL_CREATE;
      }
    });
    AppMethodBeat.o(64867);
  }
  
  public a()
  {
    AppMethodBeat.i(64861);
    this.KlJ = new LuckyMoneyC2CNYPredownloadImgListener();
    this.KlM = new com.tencent.mm.cp.h(new com.tencent.mm.cp.c() {});
    this.KlN = new com.tencent.mm.cp.h(new com.tencent.mm.cp.c() {});
    this.KlO = new com.tencent.mm.cp.h(new com.tencent.mm.cp.c() {});
    this.KlP = new com.tencent.mm.cp.h(new com.tencent.mm.cp.c() {});
    this.KlQ = new LuckyMoneyEnvelopeResUpdateListener();
    this.KlR = new SubCoreLuckyMoney.9(this, com.tencent.mm.app.f.hfK);
    this.KlS = new SubCoreLuckyMoney.10(this, com.tencent.mm.app.f.hfK);
    this.wXR = new cl.a()
    {
      public final void a(g.a paramAnonymousa)
      {
        AppMethodBeat.i(284073);
        paramAnonymousa = XmlParser.parseXml(com.tencent.mm.platformtools.w.a(paramAnonymousa.mpN.YFG), "sysmsg", null);
        Log.i("MicroMsg.SubCoreLuckyMoney", "helios::::mPayMsgListener");
        if (paramAnonymousa == null)
        {
          Log.e("MicroMsg.SubCoreLuckyMoney", "Resolve msg error");
          AppMethodBeat.o(284073);
          return;
        }
        Object localObject1 = (String)paramAnonymousa.get(".sysmsg.paymsg.PayMsgType");
        if ("14".equals(localObject1))
        {
          localObject1 = URLDecoder.decode((String)paramAnonymousa.get(".sysmsg.paymsg.appmsgcontent"));
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            Log.e("MicroMsg.SubCoreLuckyMoney", "msgxml illegal");
            AppMethodBeat.o(284073);
            return;
          }
          Object localObject2 = XmlParser.parseXml((String)localObject1, "msg", null);
          if (localObject2 == null)
          {
            Log.e("MicroMsg.SubCoreLuckyMoney", "Resolve appmsgxml error");
            AppMethodBeat.o(284073);
            return;
          }
          localObject2 = (String)((Map)localObject2).get(".msg.appmsg.wcpayinfo.paymsgid");
          if (Util.isNullOrNil((String)localObject2))
          {
            Log.e("MicroMsg.SubCoreLuckyMoney", "paymsgid is null");
            AppMethodBeat.o(284073);
            return;
          }
          paramAnonymousa = (String)paramAnonymousa.get(".sysmsg.paymsg.tousername");
          if ((Util.isNullOrNil((String)localObject1)) || (Util.isNullOrNil(paramAnonymousa)))
          {
            Log.e("MicroMsg.SubCoreLuckyMoney", "onRecieveMsg get a illegal msg,which content or toUserName is null");
            AppMethodBeat.o(284073);
            return;
          }
          if (a.this.fWp().aKz((String)localObject2))
          {
            Log.i("MicroMsg.SubCoreLuckyMoney", "insert a local msg for luckymoney");
            if (!ah.an((String)localObject1, paramAnonymousa, 1)) {
              a.this.fWp().aKA((String)localObject2);
            }
          }
          AppMethodBeat.o(284073);
          return;
        }
        if ("47".equals(localObject1))
        {
          paramAnonymousa = Util.nullAs((String)paramAnonymousa.get(".sysmsg.paymsg.OrderId"), "");
          localObject1 = com.tencent.mm.plugin.wallet_core.model.u.iiy().bgV(paramAnonymousa);
          if (localObject1 == null)
          {
            Log.w("MicroMsg.SubCoreLuckyMoney", "can't find sendid: %s", new Object[] { paramAnonymousa });
            AppMethodBeat.o(284073);
            return;
          }
          ((ad)localObject1).field_hbStatus = 5;
          com.tencent.mm.plugin.wallet_core.model.u.iiy().a((ad)localObject1);
          a.this.aKv(((ad)localObject1).field_sender);
        }
        AppMethodBeat.o(284073);
      }
      
      public final void a(g.c paramAnonymousc) {}
    };
    this.KlT = new SubCoreLuckyMoney.12(this, com.tencent.mm.app.f.hfK);
    com.tencent.mm.vfs.u localu = new com.tencent.mm.vfs.u(fWo());
    if (!localu.jKS()) {
      localu.jKY();
    }
    AppMethodBeat.o(64861);
  }
  
  public static a fWk()
  {
    AppMethodBeat.i(64860);
    a locala = (a)com.tencent.mm.model.y.aL(a.class);
    AppMethodBeat.o(64860);
    return locala;
  }
  
  public static p fWl()
  {
    AppMethodBeat.i(64864);
    Log.i("MicroMsg.SubCoreLuckyMoney", "getConfigMgr()");
    com.tencent.mm.kernel.h.baC().aZJ();
    if (fWk().KlF == null) {
      fWk().KlF = new p();
    }
    p localp = fWk().KlF;
    AppMethodBeat.o(64864);
    return localp;
  }
  
  public static ag fWm()
  {
    AppMethodBeat.i(284071);
    Log.i("MicroMsg.SubCoreLuckyMoney", "getConfigMgrUnion()");
    com.tencent.mm.kernel.h.baC().aZJ();
    if (fWk().KlG == null) {
      fWk().KlG = new ag();
    }
    ag localag = fWk().KlG;
    AppMethodBeat.o(284071);
    return localag;
  }
  
  public static com.tencent.mm.plugin.luckymoney.model.v fWn()
  {
    AppMethodBeat.i(284075);
    Log.i("MicroMsg.SubCoreLuckyMoney", "getConfigMgrLive()");
    com.tencent.mm.kernel.h.baC().aZJ();
    if (fWk().KlH == null) {
      fWk().KlH = new com.tencent.mm.plugin.luckymoney.model.v();
    }
    com.tencent.mm.plugin.luckymoney.model.v localv = fWk().KlH;
    AppMethodBeat.o(284075);
    return localv;
  }
  
  public static String fWo()
  {
    AppMethodBeat.i(64865);
    if (com.tencent.mm.kernel.h.baz())
    {
      String str = com.tencent.mm.plugin.image.d.bzL() + "luckymoney";
      AppMethodBeat.o(64865);
      return str;
    }
    AppMethodBeat.o(64865);
    return "";
  }
  
  public final void a(cc paramcc, i.c paramc, boolean[] paramArrayOfBoolean) {}
  
  public final void a(cc paramcc, bb parambb, boolean paramBoolean, i.c paramc)
  {
    AppMethodBeat.i(284130);
    if ((paramBoolean) && (au.bwE(parambb.field_username))) {
      aKv(parambb.field_username);
    }
    AppMethodBeat.o(284130);
  }
  
  public final void aKv(final String paramString)
  {
    AppMethodBeat.i(284124);
    com.tencent.threadpool.h.ahAA.g(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(284065);
        Log.i("MicroMsg.SubCoreLuckyMoney", "start update");
        long l = Util.currentTicks();
        boolean bool = a.aKw(paramString);
        bb localbb = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().bxM(paramString);
        if ((localbb != null) && (au.bwE(paramString)))
        {
          Log.i("MicroMsg.SubCoreLuckyMoney", "update red flag: %s, %s", new Object[] { paramString, Boolean.valueOf(bool) });
          if (!bool) {
            break label172;
          }
        }
        label172:
        for (int i = 1;; i = 0)
        {
          localbb.pQ(i);
          Log.i("MicroMsg.SubCoreLuckyMoney", "update ret: %s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().c(localbb, paramString)) });
          Log.i("MicroMsg.SubCoreLuckyMoney", "finish update red flag: %s", new Object[] { Long.valueOf(Util.currentTicks() - l) });
          AppMethodBeat.o(284065);
          return;
        }
      }
    }, "update_hb_red_flag");
    AppMethodBeat.o(284124);
  }
  
  public final void b(cc paramcc, bb parambb, boolean paramBoolean, i.c paramc) {}
  
  public void clearPluginData(int paramInt) {}
  
  public final void co(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(284120);
    com.tencent.threadpool.h.ahAA.g(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(284077);
        long l = Util.currentTicks();
        bb localbb = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().bxM(paramString);
        int j;
        if ((localbb != null) && (au.bwE(paramString)))
        {
          if (localbb.field_hbMarkRed != 1) {
            break label181;
          }
          j = 1;
          if (j != paramBoolean)
          {
            Log.i("MicroMsg.SubCoreLuckyMoney", "update red flag: %s, %s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
            if (!paramBoolean) {
              break label187;
            }
          }
        }
        label181:
        label187:
        for (int i = 1;; i = 0)
        {
          localbb.pQ(i);
          Log.i("MicroMsg.SubCoreLuckyMoney", "update ret: %s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().c(localbb, paramString)) });
          Log.i("MicroMsg.SubCoreLuckyMoney", "finish update red flag: %s", new Object[] { Long.valueOf(Util.currentTicks() - l) });
          AppMethodBeat.o(284077);
          return;
          j = 0;
          break;
        }
      }
    }, "update_hb_red_flag_2");
    AppMethodBeat.o(284120);
  }
  
  public final com.tencent.mm.plugin.luckymoney.model.u fWg()
  {
    AppMethodBeat.i(64859);
    com.tencent.mm.plugin.luckymoney.model.u localu = (com.tencent.mm.plugin.luckymoney.model.u)this.KlM.get();
    AppMethodBeat.o(64859);
    return localu;
  }
  
  public final com.tencent.mm.plugin.luckymoney.story.b.b fWh()
  {
    AppMethodBeat.i(163538);
    com.tencent.mm.plugin.luckymoney.story.b.b localb = (com.tencent.mm.plugin.luckymoney.story.b.b)this.KlN.get();
    AppMethodBeat.o(163538);
    return localb;
  }
  
  public final com.tencent.mm.plugin.luckymoney.story.b.d fWi()
  {
    AppMethodBeat.i(163539);
    com.tencent.mm.plugin.luckymoney.story.b.d locald = (com.tencent.mm.plugin.luckymoney.story.b.d)this.KlO.get();
    AppMethodBeat.o(163539);
    return locald;
  }
  
  public final com.tencent.mm.plugin.luckymoney.story.b.f fWj()
  {
    AppMethodBeat.i(284094);
    com.tencent.mm.plugin.luckymoney.story.b.f localf = (com.tencent.mm.plugin.luckymoney.story.b.f)this.KlP.get();
    AppMethodBeat.o(284094);
    return localf;
  }
  
  public final com.tencent.mm.plugin.luckymoney.model.w fWp()
  {
    try
    {
      AppMethodBeat.i(64866);
      if (this.KlI == null) {
        this.KlI = new com.tencent.mm.plugin.luckymoney.model.w();
      }
      com.tencent.mm.plugin.luckymoney.model.w localw = this.KlI;
      AppMethodBeat.o(64866);
      return localw;
    }
    finally {}
  }
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(64862);
    Object localObject = at.iIM();
    if (com.tencent.mm.kernel.h.baz())
    {
      com.tencent.mm.plugin.openapi.a.gxq().a(4, (com.tencent.mm.pluginsdk.model.app.y)localObject);
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(1060, (com.tencent.mm.am.h)localObject);
    }
    localObject = this.KlQ;
    com.tencent.mm.plugin.report.service.h.OAn.kJ(991, 18);
    com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.iJf();
    com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.avS(58);
    com.tencent.mm.plugin.report.service.h.OAn.kJ(991, 24);
    com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.iJf();
    com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.avS(104);
    com.tencent.mm.kernel.h.aZW().a(721, (com.tencent.mm.am.h)localObject);
    this.KlQ.alive();
    ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().a("paymsg", this.wXR, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().a(this);
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().a(this, null);
    AppForegroundDelegate.heY.a(this);
    boolean bool = false;
    com.tencent.mm.kernel.h.baF();
    long l = com.tencent.mm.kernel.h.baE().ban().amW(352276);
    if (System.currentTimeMillis() - l >= 43200000L) {
      bool = true;
    }
    Log.i("MicroMsg.SubCoreLuckyMoney", "isTime=" + bool + ", isUpdate=" + paramBoolean);
    if ((paramBoolean) || (bool))
    {
      Log.i("MicroMsg.SubCoreLuckyMoney", "get service applist");
      at.iIM().lv(MMApplicationContext.getContext());
    }
    this.KlJ.alive();
    this.KlT.alive();
    this.KlR.alive();
    this.KlS.alive();
    this.KlL = new bl();
    com.tencent.mm.plugin.luckymoney.model.n.fWU();
    AppMethodBeat.o(64862);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(64863);
    Object localObject1 = at.iIM();
    if (com.tencent.mm.kernel.h.baz())
    {
      com.tencent.mm.plugin.openapi.a.gxq().b(4, (com.tencent.mm.pluginsdk.model.app.y)localObject1);
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.b(1060, (com.tencent.mm.am.h)localObject1);
      ((at)localObject1).XTD = false;
      ((at)localObject1).XTE = false;
    }
    ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().b("paymsg", this.wXR, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().b(this);
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().a(this);
    AppForegroundDelegate.heY.b(this);
    try
    {
      this.KlI = null;
      this.KlJ.dead();
      this.KlT.dead();
      this.KlR.dead();
      this.KlS.dead();
      if (this.KlL != null)
      {
        localObject1 = this.KlL;
        ((bl)localObject1).Kvi.dead();
        if (((bl)localObject1).Kvf != null)
        {
          com.tencent.mm.kernel.h.baF();
          com.tencent.mm.kernel.h.baD().mCm.a(((bl)localObject1).Kvf);
          ((bl)localObject1).Kvf = null;
        }
        if (((bl)localObject1).Kvg != null)
        {
          com.tencent.mm.kernel.h.baF();
          com.tencent.mm.kernel.h.baD().mCm.a(((bl)localObject1).Kvg);
          ((bl)localObject1).Kvg = null;
        }
      }
      com.tencent.mm.plugin.luckymoney.model.n.unInit();
      localObject1 = this.KlQ;
      com.tencent.mm.kernel.h.aZW().b(721, (com.tencent.mm.am.h)localObject1);
      this.KlQ.dead();
      AppMethodBeat.o(64863);
      return;
    }
    finally
    {
      AppMethodBeat.o(64863);
    }
  }
  
  public void onAppBackground(String paramString)
  {
    AppMethodBeat.i(284137);
    com.tencent.threadpool.h.ahAA.g(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(284066);
        a.a(a.this);
        AppMethodBeat.o(284066);
      }
    }, "check_hb_red_flag_background");
    AppMethodBeat.o(284137);
  }
  
  public void onAppForeground(String paramString) {}
  
  public void onNotifyChange(com.tencent.mm.plugin.messenger.foundation.a.a.i parami, i.c paramc)
  {
    AppMethodBeat.i(284133);
    if (paramc.KRm.equals("delete"))
    {
      Log.i("MicroMsg.SubCoreLuckyMoney", "update red flag when delete msg: %s", new Object[] { paramc.talker });
      aKv(paramc.talker);
    }
    AppMethodBeat.o(284133);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.app.a
 * JD-Core Version:    0.7.0.1
 */
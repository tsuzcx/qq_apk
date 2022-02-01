package com.tencent.mm.plugin.luckymoney.b;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.c;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.o;
import com.tencent.mm.f.a.abq;
import com.tencent.mm.f.a.abq.a;
import com.tencent.mm.f.a.bj;
import com.tencent.mm.f.a.fw;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.be;
import com.tencent.mm.model.ck;
import com.tencent.mm.model.ck.a;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.luckymoney.model.ag;
import com.tencent.mm.plugin.luckymoney.model.bk;
import com.tencent.mm.plugin.luckymoney.model.m;
import com.tencent.mm.plugin.luckymoney.model.p;
import com.tencent.mm.plugin.luckymoney.model.w;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.q;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class a
  implements o, be, i.a, com.tencent.mm.plugin.messenger.foundation.a.i
{
  public static int Etd;
  private static HashMap<Integer, h.b> baseDBFactories;
  private p EsY;
  private com.tencent.mm.plugin.luckymoney.model.af EsZ;
  private w Eta;
  private x Etb;
  private com.tencent.mm.plugin.luckymoney.model.n Etc;
  private bk Ete;
  private com.tencent.mm.cw.h<com.tencent.mm.plugin.luckymoney.model.v> Etf;
  private com.tencent.mm.cw.h<com.tencent.mm.plugin.luckymoney.story.b.b> Etg;
  private com.tencent.mm.cw.h<com.tencent.mm.plugin.luckymoney.story.b.d> Eth;
  private com.tencent.mm.cw.h<com.tencent.mm.plugin.luckymoney.story.b.f> Eti;
  private com.tencent.mm.plugin.luckymoney.model.t Etj;
  public IListener<fw> Etk;
  private IListener<bj> Etl;
  private IListener<abq> Etm;
  private ck.a tUv;
  
  static
  {
    AppMethodBeat.i(64867);
    Etd = -1;
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("LuckyMoneyEnvelopeResource".hashCode()), new a.11());
    baseDBFactories.put(Integer.valueOf("LocalRedPacketStoryInfo".hashCode()), new a.12());
    baseDBFactories.put(Integer.valueOf("LocalStoryDetail".hashCode()), new a.13());
    baseDBFactories.put(Integer.valueOf("LuckyMoneyDetailOpenRecord".hashCode()), new a.14());
    AppMethodBeat.o(64867);
  }
  
  public a()
  {
    AppMethodBeat.i(64861);
    this.Etc = new com.tencent.mm.plugin.luckymoney.model.n();
    this.Etf = new com.tencent.mm.cw.h(new a.1(this));
    this.Etg = new com.tencent.mm.cw.h(new a.8(this));
    this.Eth = new com.tencent.mm.cw.h(new a.9(this));
    this.Eti = new com.tencent.mm.cw.h(new a.10(this));
    this.Etj = new com.tencent.mm.plugin.luckymoney.model.t();
    this.Etk = new a.15(this);
    this.Etl = new a.2(this);
    this.tUv = new ck.a()
    {
      public final void a(h.a paramAnonymousa)
      {
        AppMethodBeat.i(276302);
        paramAnonymousa = XmlParser.parseXml(com.tencent.mm.platformtools.z.a(paramAnonymousa.jQG.RIF), "sysmsg", null);
        Log.i("MicroMsg.SubCoreLuckyMoney", "helios::::mPayMsgListener");
        if (paramAnonymousa == null)
        {
          Log.e("MicroMsg.SubCoreLuckyMoney", "Resolve msg error");
          AppMethodBeat.o(276302);
          return;
        }
        Object localObject1 = (String)paramAnonymousa.get(".sysmsg.paymsg.PayMsgType");
        if ("14".equals(localObject1))
        {
          localObject1 = URLDecoder.decode((String)paramAnonymousa.get(".sysmsg.paymsg.appmsgcontent"));
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            Log.e("MicroMsg.SubCoreLuckyMoney", "msgxml illegal");
            AppMethodBeat.o(276302);
            return;
          }
          Object localObject2 = XmlParser.parseXml((String)localObject1, "msg", null);
          if (localObject2 == null)
          {
            Log.e("MicroMsg.SubCoreLuckyMoney", "Resolve appmsgxml error");
            AppMethodBeat.o(276302);
            return;
          }
          localObject2 = (String)((Map)localObject2).get(".msg.appmsg.wcpayinfo.paymsgid");
          if (Util.isNullOrNil((String)localObject2))
          {
            Log.e("MicroMsg.SubCoreLuckyMoney", "paymsgid is null");
            AppMethodBeat.o(276302);
            return;
          }
          paramAnonymousa = (String)paramAnonymousa.get(".sysmsg.paymsg.tousername");
          if ((Util.isNullOrNil((String)localObject1)) || (Util.isNullOrNil(paramAnonymousa)))
          {
            Log.e("MicroMsg.SubCoreLuckyMoney", "onRecieveMsg get a illegal msg,which content or toUserName is null");
            AppMethodBeat.o(276302);
            return;
          }
          if (a.this.eNW().aND((String)localObject2))
          {
            Log.i("MicroMsg.SubCoreLuckyMoney", "insert a local msg for luckymoney");
            if (!ag.ag((String)localObject1, paramAnonymousa, 1)) {
              a.this.eNW().aNE((String)localObject2);
            }
          }
          AppMethodBeat.o(276302);
          return;
        }
        if ("47".equals(localObject1))
        {
          paramAnonymousa = Util.nullAs((String)paramAnonymousa.get(".sysmsg.paymsg.OrderId"), "");
          localObject1 = com.tencent.mm.plugin.wallet_core.model.u.gJk().bhl(paramAnonymousa);
          if (localObject1 == null)
          {
            Log.w("MicroMsg.SubCoreLuckyMoney", "can't find sendid: %s", new Object[] { paramAnonymousa });
            AppMethodBeat.o(276302);
            return;
          }
          ((com.tencent.mm.plugin.wallet_core.model.af)localObject1).field_hbStatus = 5;
          com.tencent.mm.plugin.wallet_core.model.u.gJk().a((com.tencent.mm.plugin.wallet_core.model.af)localObject1);
          a.this.aNA(((com.tencent.mm.plugin.wallet_core.model.af)localObject1).field_sender);
        }
        AppMethodBeat.o(276302);
      }
      
      public final void a(h.c paramAnonymousc) {}
    };
    this.Etm = new IListener()
    {
      private boolean a(abq paramAnonymousabq)
      {
        AppMethodBeat.i(264428);
        k.b localb;
        Object localObject;
        if (!Util.isNullOrNil(paramAnonymousabq.gbx.fQs))
        {
          localb = k.b.OQ(paramAnonymousabq.gbx.fQs);
          if (!Util.isNullOrNil(localb.lnH))
          {
            Log.i("MicroMsg.SubCoreLuckyMoney", "receive lucky money: %s", new Object[] { localb.lnH });
            localObject = Uri.parse(Util.nullAsNil(localb.lnH));
          }
        }
        try
        {
          localObject = ((Uri)localObject).getQueryParameter("sendid");
          com.tencent.mm.aj.c localc = (com.tencent.mm.aj.c)localb.ar(com.tencent.mm.aj.c.class);
          com.tencent.mm.plugin.wallet_core.model.af localaf2 = com.tencent.mm.plugin.wallet_core.model.u.gJk().bhj(localb.lnH);
          com.tencent.mm.plugin.wallet_core.model.af localaf1 = localaf2;
          if (localaf2 == null) {
            localaf1 = new com.tencent.mm.plugin.wallet_core.model.af();
          }
          if (Util.isNullOrNil(localaf1.field_mNativeUrl))
          {
            localaf1.field_mNativeUrl = localb.lnH;
            localaf1.field_receiveStatus = 0;
            if (!Util.isNullOrNil(localc.lln))
            {
              localaf1.field_hbType = 3;
              localaf1.field_exclusiveUsername = localc.lln;
            }
            localaf1.field_invalidtime = localb.lnh;
            localaf1.field_sender = paramAnonymousabq.gbx.gby;
            localaf1.field_sendId = ((String)localObject);
            localaf1.field_msgSvrId = paramAnonymousabq.gbx.fNu;
          }
          com.tencent.mm.plugin.wallet_core.model.u.gJk().a(localaf1);
          if ((localaf1.field_hbType == 3) && (com.tencent.mm.model.z.bcZ().equals(localaf1.field_exclusiveUsername))) {
            a.this.bT(paramAnonymousabq.gbx.gby, true);
          }
          paramAnonymousabq = new com.tencent.mm.plugin.luckymoney.story.b.e();
          paramAnonymousabq.field_send_id = ((String)localObject);
          if (!a.this.eNQ().get(paramAnonymousabq, new String[0]))
          {
            paramAnonymousabq.field_open_count = 0;
            Log.d("MicroMsg.SubCoreLuckyMoney", "insert record: %s, %s", new Object[] { localObject, Boolean.valueOf(a.this.eNQ().insert(paramAnonymousabq)) });
          }
          AppMethodBeat.o(264428);
          return false;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            String str = "";
          }
        }
      }
    };
    q localq = new q(eNV());
    if (!localq.ifE()) {
      localq.ifK();
    }
    AppMethodBeat.o(64861);
  }
  
  public static a eNR()
  {
    AppMethodBeat.i(64860);
    a locala = (a)y.as(a.class);
    AppMethodBeat.o(64860);
    return locala;
  }
  
  public static p eNS()
  {
    AppMethodBeat.i(64864);
    Log.i("MicroMsg.SubCoreLuckyMoney", "getConfigMgr()");
    com.tencent.mm.kernel.h.aHE().aGH();
    if (eNR().EsY == null) {
      eNR().EsY = new p();
    }
    p localp = eNR().EsY;
    AppMethodBeat.o(64864);
    return localp;
  }
  
  public static com.tencent.mm.plugin.luckymoney.model.af eNT()
  {
    AppMethodBeat.i(272332);
    Log.i("MicroMsg.SubCoreLuckyMoney", "getConfigMgrUnion()");
    com.tencent.mm.kernel.h.aHE().aGH();
    if (eNR().EsZ == null) {
      eNR().EsZ = new com.tencent.mm.plugin.luckymoney.model.af();
    }
    com.tencent.mm.plugin.luckymoney.model.af localaf = eNR().EsZ;
    AppMethodBeat.o(272332);
    return localaf;
  }
  
  public static w eNU()
  {
    AppMethodBeat.i(272335);
    Log.i("MicroMsg.SubCoreLuckyMoney", "getConfigMgrLive()");
    com.tencent.mm.kernel.h.aHE().aGH();
    if (eNR().Eta == null) {
      eNR().Eta = new w();
    }
    w localw = eNR().Eta;
    AppMethodBeat.o(272335);
    return localw;
  }
  
  public static String eNV()
  {
    AppMethodBeat.i(64865);
    if (com.tencent.mm.kernel.h.aHB())
    {
      String str = com.tencent.mm.plugin.image.d.bbW() + "luckymoney";
      AppMethodBeat.o(64865);
      return str;
    }
    AppMethodBeat.o(64865);
    return "";
  }
  
  public final void a(ca paramca, i.c paramc, boolean[] paramArrayOfBoolean) {}
  
  public final void a(ca paramca, az paramaz, boolean paramBoolean, i.c paramc)
  {
    AppMethodBeat.i(272346);
    if ((paramBoolean) && (ab.Lj(paramaz.field_username))) {
      aNA(paramaz.field_username);
    }
    AppMethodBeat.o(272346);
  }
  
  public final void aNA(String paramString)
  {
    AppMethodBeat.i(272342);
    com.tencent.e.h.ZvG.d(new a.6(this, paramString), "update_hb_red_flag");
    AppMethodBeat.o(272342);
  }
  
  public final void b(ca paramca, az paramaz, boolean paramBoolean, i.c paramc) {}
  
  public final void bT(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(272339);
    com.tencent.e.h.ZvG.d(new a.5(this, paramString, paramBoolean), "update_hb_red_flag_2");
    AppMethodBeat.o(272339);
  }
  
  public void clearPluginData(int paramInt) {}
  
  public final com.tencent.mm.plugin.luckymoney.model.v eNN()
  {
    AppMethodBeat.i(64859);
    com.tencent.mm.plugin.luckymoney.model.v localv = (com.tencent.mm.plugin.luckymoney.model.v)this.Etf.get();
    AppMethodBeat.o(64859);
    return localv;
  }
  
  public final com.tencent.mm.plugin.luckymoney.story.b.b eNO()
  {
    AppMethodBeat.i(163538);
    com.tencent.mm.plugin.luckymoney.story.b.b localb = (com.tencent.mm.plugin.luckymoney.story.b.b)this.Etg.get();
    AppMethodBeat.o(163538);
    return localb;
  }
  
  public final com.tencent.mm.plugin.luckymoney.story.b.d eNP()
  {
    AppMethodBeat.i(163539);
    com.tencent.mm.plugin.luckymoney.story.b.d locald = (com.tencent.mm.plugin.luckymoney.story.b.d)this.Eth.get();
    AppMethodBeat.o(163539);
    return locald;
  }
  
  public final com.tencent.mm.plugin.luckymoney.story.b.f eNQ()
  {
    AppMethodBeat.i(272329);
    com.tencent.mm.plugin.luckymoney.story.b.f localf = (com.tencent.mm.plugin.luckymoney.story.b.f)this.Eti.get();
    AppMethodBeat.o(272329);
    return localf;
  }
  
  public final x eNW()
  {
    try
    {
      AppMethodBeat.i(64866);
      if (this.Etb == null) {
        this.Etb = new x();
      }
      x localx = this.Etb;
      AppMethodBeat.o(64866);
      return localx;
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
    Object localObject = ap.hhK();
    if (com.tencent.mm.kernel.h.aHB())
    {
      com.tencent.mm.plugin.ab.a.fmC().a(4, (com.tencent.mm.pluginsdk.model.app.u)localObject);
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.a(1060, (com.tencent.mm.an.i)localObject);
    }
    localObject = this.Etj;
    com.tencent.mm.plugin.report.service.h.IzE.el(991, 18);
    com.tencent.mm.pluginsdk.k.a.a.b.hii();
    com.tencent.mm.pluginsdk.k.a.a.b.apP(58);
    com.tencent.mm.kernel.h.aGY().a(721, (com.tencent.mm.an.i)localObject);
    this.Etj.alive();
    ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().a("paymsg", this.tUv, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbR().a(this);
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().a(this, null);
    AppForegroundDelegate.fby.a(this);
    boolean bool = false;
    com.tencent.mm.kernel.h.aHH();
    long l = com.tencent.mm.kernel.h.aHG().aHp().ahV(352276);
    if (System.currentTimeMillis() - l >= 43200000L) {
      bool = true;
    }
    Log.i("MicroMsg.SubCoreLuckyMoney", "isTime=" + bool + ", isUpdate=" + paramBoolean);
    if ((paramBoolean) || (bool))
    {
      Log.i("MicroMsg.SubCoreLuckyMoney", "get service applist");
      ap.hhK().jy(MMApplicationContext.getContext());
    }
    EventCenter.instance.addListener(this.Etc);
    EventCenter.instance.addListener(this.Etm);
    this.Etk.alive();
    this.Etl.alive();
    this.Ete = new bk();
    m.eOx();
    AppMethodBeat.o(64862);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(64863);
    Object localObject1 = ap.hhK();
    if (com.tencent.mm.kernel.h.aHB())
    {
      com.tencent.mm.plugin.ab.a.fmC().b(4, (com.tencent.mm.pluginsdk.model.app.u)localObject1);
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.b(1060, (com.tencent.mm.an.i)localObject1);
      ((ap)localObject1).QXF = false;
      ((ap)localObject1).QXG = false;
    }
    ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().b("paymsg", this.tUv, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbR().b(this);
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().a(this);
    AppForegroundDelegate.fby.b(this);
    try
    {
      this.Etb = null;
      EventCenter.instance.removeListener(this.Etc);
      EventCenter.instance.removeListener(this.Etm);
      this.Etk.dead();
      this.Etl.dead();
      if (this.Ete != null)
      {
        localObject1 = this.Ete;
        EventCenter.instance.removeListener(((bk)localObject1).ECh);
        if (((bk)localObject1).ECe != null)
        {
          com.tencent.mm.kernel.h.aHH();
          com.tencent.mm.kernel.h.aHF().kcd.a(((bk)localObject1).ECe);
          ((bk)localObject1).ECe = null;
        }
        if (((bk)localObject1).ECf != null)
        {
          com.tencent.mm.kernel.h.aHH();
          com.tencent.mm.kernel.h.aHF().kcd.a(((bk)localObject1).ECf);
          ((bk)localObject1).ECf = null;
        }
      }
      m.unInit();
      localObject1 = this.Etj;
      com.tencent.mm.kernel.h.aGY().b(721, (com.tencent.mm.an.i)localObject1);
      this.Etj.dead();
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
    AppMethodBeat.i(272350);
    com.tencent.e.h.ZvG.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(276801);
        a.a(a.this);
        AppMethodBeat.o(276801);
      }
    }, "check_hb_red_flag_background");
    AppMethodBeat.o(272350);
  }
  
  public void onAppForeground(String paramString) {}
  
  public void onNotifyChange(com.tencent.mm.plugin.messenger.foundation.a.a.i parami, i.c paramc)
  {
    AppMethodBeat.i(272349);
    if (paramc.EVM.equals("delete"))
    {
      Log.i("MicroMsg.SubCoreLuckyMoney", "update red flag when delete msg: %s", new Object[] { paramc.talker });
      aNA(paramc.talker);
    }
    AppMethodBeat.o(272349);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.b.a
 * JD-Core Version:    0.7.0.1
 */
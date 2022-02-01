package com.tencent.mm.plugin.luckymoney.b;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.c;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.g.a.aaj;
import com.tencent.mm.g.a.aaj.a;
import com.tencent.mm.g.a.fp;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.cj.a;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.model.bj;
import com.tencent.mm.plugin.luckymoney.model.m;
import com.tencent.mm.plugin.luckymoney.model.n;
import com.tencent.mm.plugin.luckymoney.model.p;
import com.tencent.mm.plugin.luckymoney.model.v;
import com.tencent.mm.plugin.luckymoney.model.w;
import com.tencent.mm.plugin.luckymoney.story.b.f;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.protocal.protobuf.de;
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
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class a
  implements com.tencent.mm.app.o, bd, i.a, com.tencent.mm.plugin.messenger.foundation.a.g
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private cj.a qvw;
  private p yPb;
  private com.tencent.mm.plugin.luckymoney.model.ae yPc;
  private w yPd;
  private n yPe;
  private bj yPf;
  private com.tencent.mm.co.h<v> yPg;
  private com.tencent.mm.co.h<com.tencent.mm.plugin.luckymoney.story.b.b> yPh;
  private com.tencent.mm.co.h<com.tencent.mm.plugin.luckymoney.story.b.d> yPi;
  private com.tencent.mm.co.h<f> yPj;
  private com.tencent.mm.plugin.luckymoney.model.t yPk;
  public IListener<fp> yPl;
  private IListener<aaj> yPm;
  
  static
  {
    AppMethodBeat.i(64867);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("LuckyMoneyEnvelopeResource".hashCode()), new a.9());
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
    baseDBFactories.put(Integer.valueOf("LuckyMoneyDetailOpenRecord".hashCode()), new a.12());
    AppMethodBeat.o(64867);
  }
  
  public a()
  {
    AppMethodBeat.i(64861);
    this.yPe = new n();
    this.yPg = new com.tencent.mm.co.h(new a.1(this));
    this.yPh = new com.tencent.mm.co.h(new com.tencent.mm.co.c() {});
    this.yPi = new com.tencent.mm.co.h(new com.tencent.mm.co.c() {});
    this.yPj = new com.tencent.mm.co.h(new a.8(this));
    this.yPk = new com.tencent.mm.plugin.luckymoney.model.t();
    this.yPl = new a.13(this);
    this.qvw = new cj.a()
    {
      public final void a(h.a paramAnonymousa)
      {
        AppMethodBeat.i(213244);
        paramAnonymousa = XmlParser.parseXml(com.tencent.mm.platformtools.z.a(paramAnonymousa.heO.KHn), "sysmsg", null);
        Log.i("MicroMsg.SubCoreLuckyMoney", "helios::::mPayMsgListener");
        if (paramAnonymousa == null)
        {
          Log.e("MicroMsg.SubCoreLuckyMoney", "Resolve msg error");
          AppMethodBeat.o(213244);
          return;
        }
        Object localObject1 = (String)paramAnonymousa.get(".sysmsg.paymsg.PayMsgType");
        if ("14".equals(localObject1))
        {
          localObject1 = URLDecoder.decode((String)paramAnonymousa.get(".sysmsg.paymsg.appmsgcontent"));
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            Log.e("MicroMsg.SubCoreLuckyMoney", "msgxml illegal");
            AppMethodBeat.o(213244);
            return;
          }
          Object localObject2 = XmlParser.parseXml((String)localObject1, "msg", null);
          if (localObject2 == null)
          {
            Log.e("MicroMsg.SubCoreLuckyMoney", "Resolve appmsgxml error");
            AppMethodBeat.o(213244);
            return;
          }
          localObject2 = (String)((Map)localObject2).get(".msg.appmsg.wcpayinfo.paymsgid");
          if (Util.isNullOrNil((String)localObject2))
          {
            Log.e("MicroMsg.SubCoreLuckyMoney", "paymsgid is null");
            AppMethodBeat.o(213244);
            return;
          }
          paramAnonymousa = (String)paramAnonymousa.get(".sysmsg.paymsg.tousername");
          if ((Util.isNullOrNil((String)localObject1)) || (Util.isNullOrNil(paramAnonymousa)))
          {
            Log.e("MicroMsg.SubCoreLuckyMoney", "onRecieveMsg get a illegal msg,which content or toUserName is null");
            AppMethodBeat.o(213244);
            return;
          }
          if (a.this.eeB().aDu((String)localObject2))
          {
            Log.i("MicroMsg.SubCoreLuckyMoney", "insert a local msg for luckymoney");
            if (!af.ac((String)localObject1, paramAnonymousa, 1)) {
              a.this.eeB().aDv((String)localObject2);
            }
          }
          AppMethodBeat.o(213244);
          return;
        }
        if ("47".equals(localObject1))
        {
          paramAnonymousa = Util.nullAs((String)paramAnonymousa.get(".sysmsg.paymsg.OrderId"), "");
          localObject1 = com.tencent.mm.plugin.wallet_core.model.t.fQE().aVC(paramAnonymousa);
          if (localObject1 == null)
          {
            Log.w("MicroMsg.SubCoreLuckyMoney", "can't find sendid: %s", new Object[] { paramAnonymousa });
            AppMethodBeat.o(213244);
            return;
          }
          ((com.tencent.mm.plugin.wallet_core.model.ae)localObject1).field_hbStatus = 5;
          com.tencent.mm.plugin.wallet_core.model.t.fQE().a((com.tencent.mm.plugin.wallet_core.model.ae)localObject1);
          a.this.aDq(((com.tencent.mm.plugin.wallet_core.model.ae)localObject1).field_sender);
        }
        AppMethodBeat.o(213244);
      }
      
      public final void a(h.c paramAnonymousc) {}
    };
    this.yPm = new IListener()
    {
      private boolean a(final aaj paramAnonymousaaj)
      {
        AppMethodBeat.i(213247);
        k.b localb;
        Object localObject;
        if (!Util.isNullOrNil(paramAnonymousaaj.ehg.dWG))
        {
          localb = k.b.HD(paramAnonymousaaj.ehg.dWG);
          if (!Util.isNullOrNil(localb.iyr))
          {
            Log.i("MicroMsg.SubCoreLuckyMoney", "receive lucky money: %s", new Object[] { localb.iyr });
            localObject = Uri.parse(Util.nullAsNil(localb.iyr));
          }
        }
        try
        {
          localObject = ((Uri)localObject).getQueryParameter("sendid");
          com.tencent.mm.ag.c localc = (com.tencent.mm.ag.c)localb.as(com.tencent.mm.ag.c.class);
          com.tencent.mm.plugin.wallet_core.model.ae localae2 = com.tencent.mm.plugin.wallet_core.model.t.fQE().aVA(localb.iyr);
          com.tencent.mm.plugin.wallet_core.model.ae localae1 = localae2;
          if (localae2 == null) {
            localae1 = new com.tencent.mm.plugin.wallet_core.model.ae();
          }
          if (Util.isNullOrNil(localae1.field_mNativeUrl))
          {
            localae1.field_mNativeUrl = localb.iyr;
            localae1.field_receiveStatus = 0;
            if (!Util.isNullOrNil(localc.iwa))
            {
              localae1.field_hbType = 3;
              localae1.field_exclusiveUsername = localc.iwa;
            }
            localae1.field_invalidtime = localb.ixR;
            localae1.field_sender = paramAnonymousaaj.ehg.ehh;
            localae1.field_sendId = ((String)localObject);
            localae1.field_msgSvrId = paramAnonymousaaj.ehg.dTS;
          }
          com.tencent.mm.plugin.wallet_core.model.t.fQE().a(localae1);
          com.tencent.f.h.RTc.o(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(213245);
              a.this.aDq(paramAnonymousaaj.ehg.ehh);
              AppMethodBeat.o(213245);
            }
          }, 50L);
          paramAnonymousaaj = new com.tencent.mm.plugin.luckymoney.story.b.e();
          paramAnonymousaaj.field_send_id = ((String)localObject);
          if (!a.this.eew().get(paramAnonymousaaj, new String[0]))
          {
            paramAnonymousaaj.field_open_count = 0;
            Log.d("MicroMsg.SubCoreLuckyMoney", "insert record: %s, %s", new Object[] { localObject, Boolean.valueOf(a.this.eew().insert(paramAnonymousaaj)) });
          }
          AppMethodBeat.o(213247);
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
    com.tencent.mm.vfs.o localo = new com.tencent.mm.vfs.o(eeA());
    if (!localo.exists()) {
      localo.mkdirs();
    }
    AppMethodBeat.o(64861);
  }
  
  private static boolean aDr(String paramString)
  {
    AppMethodBeat.i(213257);
    if (!ab.Eq(paramString))
    {
      AppMethodBeat.o(213257);
      return false;
    }
    Object localObject = com.tencent.mm.plugin.wallet_core.model.t.fQE().aVB(paramString);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.wallet_core.model.ae localae = (com.tencent.mm.plugin.wallet_core.model.ae)((Iterator)localObject).next();
        ca localca = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().aJ(paramString, localae.field_msgSvrId);
        if ((localae.field_hbType == 3) && (localca.field_msgId > 0L) && (com.tencent.mm.model.z.aTY().equals(localae.field_exclusiveUsername)) && (localae.field_hbStatus != 4) && (localae.field_hbStatus != 5) && (localae.field_invalidtime * 1000L - cl.aWA() > 0L)) {
          Log.i("MicroMsg.SubCoreLuckyMoney", "need mark red: %s, %s", new Object[] { Long.valueOf(localae.field_msgSvrId), localae.field_sendId });
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      AppMethodBeat.o(213257);
      return bool;
    }
  }
  
  public static String eeA()
  {
    AppMethodBeat.i(64865);
    if (com.tencent.mm.kernel.g.aAc())
    {
      String str = com.tencent.mm.plugin.image.d.aSY() + "luckymoney";
      AppMethodBeat.o(64865);
      return str;
    }
    AppMethodBeat.o(64865);
    return "";
  }
  
  public static a eex()
  {
    AppMethodBeat.i(64860);
    a locala = (a)y.at(a.class);
    AppMethodBeat.o(64860);
    return locala;
  }
  
  public static p eey()
  {
    AppMethodBeat.i(64864);
    Log.i("MicroMsg.SubCoreLuckyMoney", "getConfigMgr()");
    com.tencent.mm.kernel.g.aAf().azk();
    if (eex().yPb == null) {
      eex().yPb = new p();
    }
    p localp = eex().yPb;
    AppMethodBeat.o(64864);
    return localp;
  }
  
  public static com.tencent.mm.plugin.luckymoney.model.ae eez()
  {
    AppMethodBeat.i(213255);
    Log.i("MicroMsg.SubCoreLuckyMoney", "getConfigMgrUnion()");
    com.tencent.mm.kernel.g.aAf().azk();
    if (eex().yPc == null) {
      eex().yPc = new com.tencent.mm.plugin.luckymoney.model.ae();
    }
    com.tencent.mm.plugin.luckymoney.model.ae localae = eex().yPc;
    AppMethodBeat.o(213255);
    return localae;
  }
  
  public final void a(com.tencent.mm.plugin.messenger.foundation.a.a.i parami, i.c paramc)
  {
    AppMethodBeat.i(213259);
    if (paramc.zqn.equals("delete"))
    {
      Log.i("MicroMsg.SubCoreLuckyMoney", "update red flag when delete msg: %s", new Object[] { paramc.talker });
      aDq(paramc.talker);
    }
    AppMethodBeat.o(213259);
  }
  
  public final void a(ca paramca, i.c paramc, boolean[] paramArrayOfBoolean) {}
  
  public final void a(ca paramca, az paramaz, boolean paramBoolean, i.c paramc)
  {
    AppMethodBeat.i(213258);
    if ((paramBoolean) && (!ab.Eq(paramaz.field_username))) {
      if (!aDr(paramaz.field_username)) {
        break label46;
      }
    }
    label46:
    for (int i = 1;; i = 0)
    {
      paramaz.nD(i);
      AppMethodBeat.o(213258);
      return;
    }
  }
  
  public final void aDq(final String paramString)
  {
    AppMethodBeat.i(213256);
    com.tencent.f.h.RTc.aX(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213249);
        boolean bool = a.aDs(paramString);
        az localaz = ((l)com.tencent.mm.kernel.g.af(l.class)).aST().bjY(paramString);
        if ((localaz != null) && (ab.Eq(paramString)))
        {
          Log.i("MicroMsg.SubCoreLuckyMoney", "update red flag: %s, %s", new Object[] { paramString, Boolean.valueOf(bool) });
          if (!bool) {
            break label132;
          }
        }
        label132:
        for (int i = 1;; i = 0)
        {
          localaz.nD(i);
          Log.i("MicroMsg.SubCoreLuckyMoney", "update ret: %s", new Object[] { Integer.valueOf(((l)com.tencent.mm.kernel.g.af(l.class)).aST().a(localaz, paramString)) });
          AppMethodBeat.o(213249);
          return;
        }
      }
    });
    AppMethodBeat.o(213256);
  }
  
  public final void b(ca paramca, az paramaz, boolean paramBoolean, i.c paramc) {}
  
  public void clearPluginData(int paramInt) {}
  
  public final w eeB()
  {
    try
    {
      AppMethodBeat.i(64866);
      if (this.yPd == null) {
        this.yPd = new w();
      }
      w localw = this.yPd;
      AppMethodBeat.o(64866);
      return localw;
    }
    finally {}
  }
  
  public final v eet()
  {
    AppMethodBeat.i(64859);
    v localv = (v)this.yPg.get();
    AppMethodBeat.o(64859);
    return localv;
  }
  
  public final com.tencent.mm.plugin.luckymoney.story.b.b eeu()
  {
    AppMethodBeat.i(163538);
    com.tencent.mm.plugin.luckymoney.story.b.b localb = (com.tencent.mm.plugin.luckymoney.story.b.b)this.yPh.get();
    AppMethodBeat.o(163538);
    return localb;
  }
  
  public final com.tencent.mm.plugin.luckymoney.story.b.d eev()
  {
    AppMethodBeat.i(163539);
    com.tencent.mm.plugin.luckymoney.story.b.d locald = (com.tencent.mm.plugin.luckymoney.story.b.d)this.yPi.get();
    AppMethodBeat.o(163539);
    return locald;
  }
  
  public final f eew()
  {
    AppMethodBeat.i(213254);
    f localf = (f)this.yPj.get();
    AppMethodBeat.o(213254);
    return localf;
  }
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(64862);
    ap localap = ap.gni();
    if (com.tencent.mm.kernel.g.aAc())
    {
      com.tencent.mm.plugin.r.a.eAV().a(4, localap);
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAg().hqi.a(1060, localap);
    }
    this.yPk.alive();
    ((s)com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().a("paymsg", this.qvw, true);
    ((l)com.tencent.mm.kernel.g.af(l.class)).aST().a(this);
    ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().a(this, null);
    AppForegroundDelegate.djR.a(this);
    boolean bool = false;
    com.tencent.mm.kernel.g.aAi();
    long l = com.tencent.mm.kernel.g.aAh().azQ().akg(352276);
    if (System.currentTimeMillis() - l >= 43200000L) {
      bool = true;
    }
    Log.i("MicroMsg.SubCoreLuckyMoney", "isTime=" + bool + ", isUpdate=" + paramBoolean);
    if ((paramBoolean) || (bool))
    {
      Log.i("MicroMsg.SubCoreLuckyMoney", "get service applist");
      ap.gni().iv(MMApplicationContext.getContext());
    }
    EventCenter.instance.addListener(this.yPe);
    EventCenter.instance.addListener(this.yPm);
    this.yPl.alive();
    this.yPf = new bj();
    m.efc();
    AppMethodBeat.o(64862);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(64863);
    Object localObject1 = ap.gni();
    if (com.tencent.mm.kernel.g.aAc())
    {
      com.tencent.mm.plugin.r.a.eAV().b(4, (u)localObject1);
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAg().hqi.b(1060, (com.tencent.mm.ak.i)localObject1);
      ((ap)localObject1).JXl = false;
      ((ap)localObject1).JXm = false;
    }
    ((s)com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().b("paymsg", this.qvw, true);
    ((l)com.tencent.mm.kernel.g.af(l.class)).aST().b(this);
    ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().a(this);
    AppForegroundDelegate.djR.b(this);
    try
    {
      this.yPd = null;
      EventCenter.instance.removeListener(this.yPe);
      EventCenter.instance.removeListener(this.yPm);
      this.yPl.dead();
      if (this.yPf != null)
      {
        localObject1 = this.yPf;
        EventCenter.instance.removeListener(((bj)localObject1).yYb);
        if (((bj)localObject1).yXY != null)
        {
          com.tencent.mm.kernel.g.aAi();
          com.tencent.mm.kernel.g.aAg().hqi.a(((bj)localObject1).yXY);
          ((bj)localObject1).yXY = null;
        }
        if (((bj)localObject1).yXZ != null)
        {
          com.tencent.mm.kernel.g.aAi();
          com.tencent.mm.kernel.g.aAg().hqi.a(((bj)localObject1).yXZ);
          ((bj)localObject1).yXZ = null;
        }
      }
      m.unInit();
      this.yPk.dead();
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
    AppMethodBeat.i(213260);
    com.tencent.f.h.RTc.aX(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213250);
        a.a(a.this);
        AppMethodBeat.o(213250);
      }
    });
    AppMethodBeat.o(213260);
  }
  
  public void onAppForeground(String paramString) {}
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.b.a
 * JD-Core Version:    0.7.0.1
 */
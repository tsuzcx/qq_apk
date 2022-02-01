package com.tencent.mm.plugin.luckymoney.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.g.a.ye;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.luckymoney.model.ax;
import com.tencent.mm.plugin.luckymoney.model.i;
import com.tencent.mm.plugin.luckymoney.model.k;
import com.tencent.mm.plugin.luckymoney.model.o;
import com.tencent.mm.plugin.luckymoney.model.r;
import com.tencent.mm.plugin.luckymoney.story.b.f;
import com.tencent.mm.pluginsdk.model.app.aq;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storagebase.h.b;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class a
  implements aw
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private cc.a owm;
  private k ugc;
  private r ugd;
  private i uge;
  private ax ugf;
  private com.tencent.mm.cn.h<com.tencent.mm.plugin.luckymoney.model.q> ugg;
  private com.tencent.mm.cn.h<com.tencent.mm.plugin.luckymoney.story.b.b> ugh;
  private com.tencent.mm.cn.h<com.tencent.mm.plugin.luckymoney.story.b.d> ugi;
  private com.tencent.mm.cn.h<f> ugj;
  private o ugk;
  private com.tencent.mm.sdk.b.c<ye> ugl;
  
  static
  {
    AppMethodBeat.i(64867);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("LuckyMoneyEnvelopeResource".hashCode()), new a.6());
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
    baseDBFactories.put(Integer.valueOf("LuckyMoneyDetailOpenRecord".hashCode()), new a.9());
    AppMethodBeat.o(64867);
  }
  
  public a()
  {
    AppMethodBeat.i(64861);
    this.uge = new i();
    this.ugg = new com.tencent.mm.cn.h(new a.1(this));
    this.ugh = new com.tencent.mm.cn.h(new com.tencent.mm.cn.c() {});
    this.ugi = new com.tencent.mm.cn.h(new com.tencent.mm.cn.c() {});
    this.ugj = new com.tencent.mm.cn.h(new a.5(this));
    this.ugk = new o();
    this.owm = new cc.a()
    {
      public final void a(f.a paramAnonymousa)
      {
        AppMethodBeat.i(207096);
        Object localObject1 = bv.L(com.tencent.mm.platformtools.z.a(paramAnonymousa.fXi.DPV), "sysmsg");
        ac.i("MicroMsg.SubCoreLuckyMoney", "helios::::mPayMsgListener");
        if (localObject1 == null)
        {
          ac.e("MicroMsg.SubCoreLuckyMoney", "Resolve msg error");
          AppMethodBeat.o(207096);
          return;
        }
        if ("14".equals((String)((Map)localObject1).get(".sysmsg.paymsg.PayMsgType")))
        {
          paramAnonymousa = URLDecoder.decode((String)((Map)localObject1).get(".sysmsg.paymsg.appmsgcontent"));
          if (TextUtils.isEmpty(paramAnonymousa))
          {
            ac.e("MicroMsg.SubCoreLuckyMoney", "msgxml illegal");
            AppMethodBeat.o(207096);
            return;
          }
          Object localObject2 = bv.L(paramAnonymousa, "msg");
          if (localObject2 == null)
          {
            ac.e("MicroMsg.SubCoreLuckyMoney", "Resolve appmsgxml error");
            AppMethodBeat.o(207096);
            return;
          }
          localObject2 = (String)((Map)localObject2).get(".msg.appmsg.wcpayinfo.paymsgid");
          if (bs.isNullOrNil((String)localObject2))
          {
            ac.e("MicroMsg.SubCoreLuckyMoney", "paymsgid is null");
            AppMethodBeat.o(207096);
            return;
          }
          localObject1 = (String)((Map)localObject1).get(".sysmsg.paymsg.tousername");
          if ((bs.isNullOrNil(paramAnonymousa)) || (bs.isNullOrNil((String)localObject1)))
          {
            ac.e("MicroMsg.SubCoreLuckyMoney", "onRecieveMsg get a illegal msg,which content or toUserName is null");
            AppMethodBeat.o(207096);
            return;
          }
          if (a.this.cYy().akg((String)localObject2))
          {
            ac.i("MicroMsg.SubCoreLuckyMoney", "insert a local msg for luckymoney");
            if (!com.tencent.mm.plugin.luckymoney.model.z.W(paramAnonymousa, (String)localObject1, 1)) {
              a.this.cYy().akh((String)localObject2);
            }
          }
        }
        AppMethodBeat.o(207096);
      }
      
      public final void a(f.c paramAnonymousc) {}
    };
    this.ugl = new a.2(this);
    com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(cYx());
    if (!locale.exists()) {
      locale.mkdirs();
    }
    AppMethodBeat.o(64861);
  }
  
  public static a cYv()
  {
    AppMethodBeat.i(64860);
    a locala = (a)t.ap(a.class);
    AppMethodBeat.o(64860);
    return locala;
  }
  
  public static k cYw()
  {
    AppMethodBeat.i(64864);
    com.tencent.mm.kernel.g.agP().afT();
    if (cYv().ugc == null) {
      cYv().ugc = new k();
    }
    k localk = cYv().ugc;
    AppMethodBeat.o(64864);
    return localk;
  }
  
  public static String cYx()
  {
    AppMethodBeat.i(64865);
    if (com.tencent.mm.kernel.g.agM())
    {
      String str = com.tencent.mm.plugin.image.d.awL() + "luckymoney";
      AppMethodBeat.o(64865);
      return str;
    }
    AppMethodBeat.o(64865);
    return "";
  }
  
  public final com.tencent.mm.plugin.luckymoney.model.q cYr()
  {
    AppMethodBeat.i(64859);
    com.tencent.mm.plugin.luckymoney.model.q localq = (com.tencent.mm.plugin.luckymoney.model.q)this.ugg.get();
    AppMethodBeat.o(64859);
    return localq;
  }
  
  public final com.tencent.mm.plugin.luckymoney.story.b.b cYs()
  {
    AppMethodBeat.i(163538);
    com.tencent.mm.plugin.luckymoney.story.b.b localb = (com.tencent.mm.plugin.luckymoney.story.b.b)this.ugh.get();
    AppMethodBeat.o(163538);
    return localb;
  }
  
  public final com.tencent.mm.plugin.luckymoney.story.b.d cYt()
  {
    AppMethodBeat.i(163539);
    com.tencent.mm.plugin.luckymoney.story.b.d locald = (com.tencent.mm.plugin.luckymoney.story.b.d)this.ugi.get();
    AppMethodBeat.o(163539);
    return locald;
  }
  
  public final f cYu()
  {
    AppMethodBeat.i(207097);
    f localf = (f)this.ugj.get();
    AppMethodBeat.o(207097);
    return localf;
  }
  
  public final r cYy()
  {
    try
    {
      AppMethodBeat.i(64866);
      if (this.ugd == null) {
        this.ugd = new r();
      }
      r localr = this.ugd;
      AppMethodBeat.o(64866);
      return localr;
    }
    finally {}
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(64862);
    aq localaq = aq.eLo();
    if (com.tencent.mm.kernel.g.agM())
    {
      com.tencent.mm.plugin.s.a.dnB().a(4, localaq);
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.a(1060, localaq);
    }
    this.ugk.alive();
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("paymsg", this.owm, true);
    boolean bool = false;
    com.tencent.mm.kernel.g.agS();
    long l = com.tencent.mm.kernel.g.agR().agA().YH(352276);
    if (System.currentTimeMillis() - l >= 43200000L) {
      bool = true;
    }
    ac.i("MicroMsg.SubCoreLuckyMoney", "isTime=" + bool + ", isUpdate=" + paramBoolean);
    if ((paramBoolean) || (bool))
    {
      ac.i("MicroMsg.SubCoreLuckyMoney", "get service applist");
      aq.eLo().hq(ai.getContext());
    }
    com.tencent.mm.sdk.b.a.GpY.c(this.uge);
    com.tencent.mm.sdk.b.a.GpY.c(this.ugl);
    this.ugf = new ax();
    com.tencent.mm.plugin.luckymoney.model.h.cYX();
    AppMethodBeat.o(64862);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(64863);
    Object localObject1 = aq.eLo();
    if (com.tencent.mm.kernel.g.agM())
    {
      com.tencent.mm.plugin.s.a.dnB().b(4, (u)localObject1);
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.b(1060, (com.tencent.mm.ak.g)localObject1);
      ((aq)localObject1).Djh = false;
      ((aq)localObject1).Dji = false;
    }
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().b("paymsg", this.owm, true);
    try
    {
      this.ugd = null;
      com.tencent.mm.sdk.b.a.GpY.d(this.uge);
      com.tencent.mm.sdk.b.a.GpY.d(this.ugl);
      if (this.ugf != null)
      {
        localObject1 = this.ugf;
        com.tencent.mm.sdk.b.a.GpY.d(((ax)localObject1).uoq);
        if (((ax)localObject1).uon != null)
        {
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agQ().ghe.a(((ax)localObject1).uon);
          ((ax)localObject1).uon = null;
        }
        if (((ax)localObject1).uoo != null)
        {
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agQ().ghe.a(((ax)localObject1).uoo);
          ((ax)localObject1).uoo = null;
        }
      }
      com.tencent.mm.plugin.luckymoney.model.h.unInit();
      this.ugk.dead();
      AppMethodBeat.o(64863);
      return;
    }
    finally
    {
      AppMethodBeat.o(64863);
    }
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.b.a
 * JD-Core Version:    0.7.0.1
 */
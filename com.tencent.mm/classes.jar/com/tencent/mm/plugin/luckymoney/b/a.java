package com.tencent.mm.plugin.luckymoney.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.f.c;
import com.tencent.mm.g.a.xt;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.luckymoney.model.ax;
import com.tencent.mm.plugin.luckymoney.model.i;
import com.tencent.mm.plugin.luckymoney.model.k;
import com.tencent.mm.plugin.luckymoney.model.o;
import com.tencent.mm.plugin.luckymoney.model.r;
import com.tencent.mm.pluginsdk.model.app.aq;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storagebase.h.b;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class a
  implements aw
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private cc.a nSR;
  private k sXP;
  private r sXQ;
  private i sXR;
  private ax sXS;
  private com.tencent.mm.co.h<com.tencent.mm.plugin.luckymoney.model.q> sXT;
  private com.tencent.mm.co.h<com.tencent.mm.plugin.luckymoney.story.b.b> sXU;
  private com.tencent.mm.co.h<com.tencent.mm.plugin.luckymoney.story.b.d> sXV;
  private o sXW;
  private com.tencent.mm.sdk.b.c<xt> sXX;
  
  static
  {
    AppMethodBeat.i(64867);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("LuckyMoneyEnvelopeResource".hashCode()), new a.4());
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
    AppMethodBeat.o(64867);
  }
  
  public a()
  {
    AppMethodBeat.i(64861);
    this.sXR = new i();
    this.sXT = new com.tencent.mm.co.h(new a.1(this));
    this.sXU = new com.tencent.mm.co.h(new com.tencent.mm.co.c() {});
    this.sXV = new com.tencent.mm.co.h(new com.tencent.mm.co.c() {});
    this.sXW = new o();
    this.nSR = new cc.a()
    {
      public final void a(f.a paramAnonymousa)
      {
        AppMethodBeat.i(163535);
        Object localObject1 = bw.K(com.tencent.mm.platformtools.z.a(paramAnonymousa.fTo.Cxz), "sysmsg");
        ad.i("MicroMsg.SubCoreLuckyMoney", "helios::::mPayMsgListener");
        if (localObject1 == null)
        {
          ad.e("MicroMsg.SubCoreLuckyMoney", "Resolve msg error");
          AppMethodBeat.o(163535);
          return;
        }
        if ("14".equals((String)((Map)localObject1).get(".sysmsg.paymsg.PayMsgType")))
        {
          paramAnonymousa = URLDecoder.decode((String)((Map)localObject1).get(".sysmsg.paymsg.appmsgcontent"));
          if (TextUtils.isEmpty(paramAnonymousa))
          {
            ad.e("MicroMsg.SubCoreLuckyMoney", "msgxml illegal");
            AppMethodBeat.o(163535);
            return;
          }
          Object localObject2 = bw.K(paramAnonymousa, "msg");
          if (localObject2 == null)
          {
            ad.e("MicroMsg.SubCoreLuckyMoney", "Resolve appmsgxml error");
            AppMethodBeat.o(163535);
            return;
          }
          localObject2 = (String)((Map)localObject2).get(".msg.appmsg.wcpayinfo.paymsgid");
          if (bt.isNullOrNil((String)localObject2))
          {
            ad.e("MicroMsg.SubCoreLuckyMoney", "paymsgid is null");
            AppMethodBeat.o(163535);
            return;
          }
          localObject1 = (String)((Map)localObject1).get(".sysmsg.paymsg.tousername");
          if ((bt.isNullOrNil(paramAnonymousa)) || (bt.isNullOrNil((String)localObject1)))
          {
            ad.e("MicroMsg.SubCoreLuckyMoney", "onRecieveMsg get a illegal msg,which content or toUserName is null");
            AppMethodBeat.o(163535);
            return;
          }
          if (a.this.cKS().afm((String)localObject2))
          {
            ad.i("MicroMsg.SubCoreLuckyMoney", "insert a local msg for luckymoney");
            if (!com.tencent.mm.plugin.luckymoney.model.z.V(paramAnonymousa, (String)localObject1, 1)) {
              a.this.cKS().afn((String)localObject2);
            }
          }
        }
        AppMethodBeat.o(163535);
      }
      
      public final void a(f.c paramAnonymousc) {}
    };
    this.sXX = new com.tencent.mm.sdk.b.c() {};
    com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(cKR());
    if (!locale.exists()) {
      locale.mkdirs();
    }
    AppMethodBeat.o(64861);
  }
  
  public static a cKP()
  {
    AppMethodBeat.i(64860);
    a locala = (a)t.ap(a.class);
    AppMethodBeat.o(64860);
    return locala;
  }
  
  public static k cKQ()
  {
    AppMethodBeat.i(64864);
    com.tencent.mm.kernel.g.afz().aeD();
    if (cKP().sXP == null) {
      cKP().sXP = new k();
    }
    k localk = cKP().sXP;
    AppMethodBeat.o(64864);
    return localk;
  }
  
  public static String cKR()
  {
    AppMethodBeat.i(64865);
    if (com.tencent.mm.kernel.g.afw())
    {
      String str = com.tencent.mm.plugin.image.d.apW() + "luckymoney";
      AppMethodBeat.o(64865);
      return str;
    }
    AppMethodBeat.o(64865);
    return "";
  }
  
  public final com.tencent.mm.plugin.luckymoney.model.q cKM()
  {
    AppMethodBeat.i(64859);
    com.tencent.mm.plugin.luckymoney.model.q localq = (com.tencent.mm.plugin.luckymoney.model.q)this.sXT.get();
    AppMethodBeat.o(64859);
    return localq;
  }
  
  public final com.tencent.mm.plugin.luckymoney.story.b.b cKN()
  {
    AppMethodBeat.i(163538);
    com.tencent.mm.plugin.luckymoney.story.b.b localb = (com.tencent.mm.plugin.luckymoney.story.b.b)this.sXU.get();
    AppMethodBeat.o(163538);
    return localb;
  }
  
  public final com.tencent.mm.plugin.luckymoney.story.b.d cKO()
  {
    AppMethodBeat.i(163539);
    com.tencent.mm.plugin.luckymoney.story.b.d locald = (com.tencent.mm.plugin.luckymoney.story.b.d)this.sXV.get();
    AppMethodBeat.o(163539);
    return locald;
  }
  
  public final r cKS()
  {
    try
    {
      AppMethodBeat.i(64866);
      if (this.sXQ == null) {
        this.sXQ = new r();
      }
      r localr = this.sXQ;
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
    aq localaq = aq.evU();
    if (com.tencent.mm.kernel.g.afw())
    {
      com.tencent.mm.plugin.s.a.cZT().a(4, localaq);
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.a(1060, localaq);
    }
    this.sXW.alive();
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("paymsg", this.nSR, true);
    boolean bool = false;
    com.tencent.mm.kernel.g.afC();
    long l = com.tencent.mm.kernel.g.afB().afk().Wx(352276);
    if (System.currentTimeMillis() - l >= 43200000L) {
      bool = true;
    }
    ad.i("MicroMsg.SubCoreLuckyMoney", "isTime=" + bool + ", isUpdate=" + paramBoolean);
    if ((paramBoolean) || (bool))
    {
      ad.i("MicroMsg.SubCoreLuckyMoney", "get service applist");
      aq.evU().hf(aj.getContext());
    }
    com.tencent.mm.sdk.b.a.ESL.c(this.sXR);
    com.tencent.mm.sdk.b.a.ESL.c(this.sXX);
    this.sXS = new ax();
    com.tencent.mm.plugin.luckymoney.model.h.cLr();
    AppMethodBeat.o(64862);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(64863);
    Object localObject1 = aq.evU();
    if (com.tencent.mm.kernel.g.afw())
    {
      com.tencent.mm.plugin.s.a.cZT().b(4, (u)localObject1);
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.b(1060, (com.tencent.mm.al.g)localObject1);
      ((aq)localObject1).BQR = false;
      ((aq)localObject1).BQS = false;
    }
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().b("paymsg", this.nSR, true);
    try
    {
      this.sXQ = null;
      com.tencent.mm.sdk.b.a.ESL.d(this.sXR);
      com.tencent.mm.sdk.b.a.ESL.d(this.sXX);
      if (this.sXS != null)
      {
        localObject1 = this.sXS;
        com.tencent.mm.sdk.b.a.ESL.d(((ax)localObject1).tgb);
        if (((ax)localObject1).tfY != null)
        {
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afA().gcy.a(((ax)localObject1).tfY);
          ((ax)localObject1).tfY = null;
        }
        if (((ax)localObject1).tfZ != null)
        {
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afA().gcy.a(((ax)localObject1).tfZ);
          ((ax)localObject1).tfZ = null;
        }
      }
      com.tencent.mm.plugin.luckymoney.model.h.NX();
      this.sXW.dead();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.b.a
 * JD-Core Version:    0.7.0.1
 */
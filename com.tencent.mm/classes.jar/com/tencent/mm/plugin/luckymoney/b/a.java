package com.tencent.mm.plugin.luckymoney.b;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.c;
import com.tencent.mm.g.a.yy;
import com.tencent.mm.g.a.yy.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cd;
import com.tencent.mm.model.cd.a;
import com.tencent.mm.plugin.luckymoney.model.i;
import com.tencent.mm.plugin.luckymoney.model.k;
import com.tencent.mm.plugin.luckymoney.model.o;
import com.tencent.mm.plugin.wallet_core.model.ae;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storagebase.h.b;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class a
  implements com.tencent.mm.model.ax
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private cd.a oZH;
  private k viM;
  private com.tencent.mm.plugin.luckymoney.model.r viN;
  private i viO;
  private com.tencent.mm.plugin.luckymoney.model.ax viP;
  private com.tencent.mm.cn.h<com.tencent.mm.plugin.luckymoney.model.q> viQ;
  private com.tencent.mm.cn.h<com.tencent.mm.plugin.luckymoney.story.b.b> viR;
  private com.tencent.mm.cn.h<com.tencent.mm.plugin.luckymoney.story.b.d> viS;
  private com.tencent.mm.cn.h<com.tencent.mm.plugin.luckymoney.story.b.f> viT;
  private o viU;
  private com.tencent.mm.sdk.b.c<yy> viV;
  
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
    this.viO = new i();
    this.viQ = new com.tencent.mm.cn.h(new a.1(this));
    this.viR = new com.tencent.mm.cn.h(new com.tencent.mm.cn.c() {});
    this.viS = new com.tencent.mm.cn.h(new com.tencent.mm.cn.c() {});
    this.viT = new com.tencent.mm.cn.h(new a.5(this));
    this.viU = new o();
    this.oZH = new cd.a()
    {
      public final void a(e.a paramAnonymousa)
      {
        AppMethodBeat.i(199000);
        Object localObject1 = bw.M(com.tencent.mm.platformtools.z.a(paramAnonymousa.gqE.Fvk), "sysmsg");
        ad.i("MicroMsg.SubCoreLuckyMoney", "helios::::mPayMsgListener");
        if (localObject1 == null)
        {
          ad.e("MicroMsg.SubCoreLuckyMoney", "Resolve msg error");
          AppMethodBeat.o(199000);
          return;
        }
        if ("14".equals((String)((Map)localObject1).get(".sysmsg.paymsg.PayMsgType")))
        {
          paramAnonymousa = URLDecoder.decode((String)((Map)localObject1).get(".sysmsg.paymsg.appmsgcontent"));
          if (TextUtils.isEmpty(paramAnonymousa))
          {
            ad.e("MicroMsg.SubCoreLuckyMoney", "msgxml illegal");
            AppMethodBeat.o(199000);
            return;
          }
          Object localObject2 = bw.M(paramAnonymousa, "msg");
          if (localObject2 == null)
          {
            ad.e("MicroMsg.SubCoreLuckyMoney", "Resolve appmsgxml error");
            AppMethodBeat.o(199000);
            return;
          }
          localObject2 = (String)((Map)localObject2).get(".msg.appmsg.wcpayinfo.paymsgid");
          if (bt.isNullOrNil((String)localObject2))
          {
            ad.e("MicroMsg.SubCoreLuckyMoney", "paymsgid is null");
            AppMethodBeat.o(199000);
            return;
          }
          localObject1 = (String)((Map)localObject1).get(".sysmsg.paymsg.tousername");
          if ((bt.isNullOrNil(paramAnonymousa)) || (bt.isNullOrNil((String)localObject1)))
          {
            ad.e("MicroMsg.SubCoreLuckyMoney", "onRecieveMsg get a illegal msg,which content or toUserName is null");
            AppMethodBeat.o(199000);
            return;
          }
          if (a.this.dhK().aoT((String)localObject2))
          {
            ad.i("MicroMsg.SubCoreLuckyMoney", "insert a local msg for luckymoney");
            if (!com.tencent.mm.plugin.luckymoney.model.z.Z(paramAnonymousa, (String)localObject1, 1)) {
              a.this.dhK().aoU((String)localObject2);
            }
          }
        }
        AppMethodBeat.o(199000);
      }
      
      public final void a(e.c paramAnonymousc) {}
    };
    this.viV = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(yy paramAnonymousyy)
      {
        AppMethodBeat.i(198997);
        Object localObject;
        if (!bt.isNullOrNil(paramAnonymousyy.dNU.dDP))
        {
          k.b localb = k.b.yr(paramAnonymousyy.dNU.dDP);
          if (!bt.isNullOrNil(localb.hBx))
          {
            ad.i("MicroMsg.SubCoreLuckyMoney", "receive lucky money: %s", new Object[] { localb.hBx });
            localObject = com.tencent.mm.plugin.wallet_core.model.t.eFu().aEH(localb.hBx);
            paramAnonymousyy = (yy)localObject;
            if (localObject == null) {
              paramAnonymousyy = new ae();
            }
            if (bt.isNullOrNil(paramAnonymousyy.field_mNativeUrl))
            {
              paramAnonymousyy.field_mNativeUrl = localb.hBx;
              paramAnonymousyy.field_receiveStatus = 0;
            }
            com.tencent.mm.plugin.wallet_core.model.t.eFu().a(paramAnonymousyy);
          }
          if (!bt.isNullOrNil(localb.hBx)) {
            paramAnonymousyy = Uri.parse(bt.nullAsNil(localb.hBx));
          }
        }
        try
        {
          paramAnonymousyy = paramAnonymousyy.getQueryParameter("sendid");
          localObject = new com.tencent.mm.plugin.luckymoney.story.b.e();
          ((com.tencent.mm.plugin.luckymoney.story.b.e)localObject).field_send_id = paramAnonymousyy;
          if (!a.this.dhG().get((com.tencent.mm.sdk.e.c)localObject, new String[0]))
          {
            ((com.tencent.mm.plugin.luckymoney.story.b.e)localObject).field_open_count = 0;
            ad.d("MicroMsg.SubCoreLuckyMoney", "insert record: %s, %s", new Object[] { paramAnonymousyy, Boolean.valueOf(a.this.dhG().insert((com.tencent.mm.sdk.e.c)localObject)) });
          }
          label209:
          AppMethodBeat.o(198997);
          return false;
        }
        catch (Exception paramAnonymousyy)
        {
          break label209;
        }
      }
    };
    com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(dhJ());
    if (!locale.exists()) {
      locale.mkdirs();
    }
    AppMethodBeat.o(64861);
  }
  
  public static a dhH()
  {
    AppMethodBeat.i(64860);
    a locala = (a)com.tencent.mm.model.t.ap(a.class);
    AppMethodBeat.o(64860);
    return locala;
  }
  
  public static k dhI()
  {
    AppMethodBeat.i(64864);
    g.ajA().aiF();
    if (dhH().viM == null) {
      dhH().viM = new k();
    }
    k localk = dhH().viM;
    AppMethodBeat.o(64864);
    return localk;
  }
  
  public static String dhJ()
  {
    AppMethodBeat.i(64865);
    if (g.ajx())
    {
      String str = com.tencent.mm.plugin.image.d.azA() + "luckymoney";
      AppMethodBeat.o(64865);
      return str;
    }
    AppMethodBeat.o(64865);
    return "";
  }
  
  public void clearPluginData(int paramInt) {}
  
  public final com.tencent.mm.plugin.luckymoney.model.q dhD()
  {
    AppMethodBeat.i(64859);
    com.tencent.mm.plugin.luckymoney.model.q localq = (com.tencent.mm.plugin.luckymoney.model.q)this.viQ.get();
    AppMethodBeat.o(64859);
    return localq;
  }
  
  public final com.tencent.mm.plugin.luckymoney.story.b.b dhE()
  {
    AppMethodBeat.i(163538);
    com.tencent.mm.plugin.luckymoney.story.b.b localb = (com.tencent.mm.plugin.luckymoney.story.b.b)this.viR.get();
    AppMethodBeat.o(163538);
    return localb;
  }
  
  public final com.tencent.mm.plugin.luckymoney.story.b.d dhF()
  {
    AppMethodBeat.i(163539);
    com.tencent.mm.plugin.luckymoney.story.b.d locald = (com.tencent.mm.plugin.luckymoney.story.b.d)this.viS.get();
    AppMethodBeat.o(163539);
    return locald;
  }
  
  public final com.tencent.mm.plugin.luckymoney.story.b.f dhG()
  {
    AppMethodBeat.i(199001);
    com.tencent.mm.plugin.luckymoney.story.b.f localf = (com.tencent.mm.plugin.luckymoney.story.b.f)this.viT.get();
    AppMethodBeat.o(199001);
    return localf;
  }
  
  public final com.tencent.mm.plugin.luckymoney.model.r dhK()
  {
    try
    {
      AppMethodBeat.i(64866);
      if (this.viN == null) {
        this.viN = new com.tencent.mm.plugin.luckymoney.model.r();
      }
      com.tencent.mm.plugin.luckymoney.model.r localr = this.viN;
      AppMethodBeat.o(64866);
      return localr;
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
    ap localap = ap.faj();
    if (g.ajx())
    {
      com.tencent.mm.plugin.s.a.dxT().a(4, localap);
      g.ajD();
      g.ajB().gAO.a(1060, localap);
    }
    this.viU.alive();
    ((com.tencent.mm.plugin.messenger.foundation.a.r)g.ad(com.tencent.mm.plugin.messenger.foundation.a.r.class)).getSysCmdMsgExtension().a("paymsg", this.oZH, true);
    boolean bool = false;
    g.ajD();
    long l = g.ajC().ajl().aaQ(352276);
    if (System.currentTimeMillis() - l >= 43200000L) {
      bool = true;
    }
    ad.i("MicroMsg.SubCoreLuckyMoney", "isTime=" + bool + ", isUpdate=" + paramBoolean);
    if ((paramBoolean) || (bool))
    {
      ad.i("MicroMsg.SubCoreLuckyMoney", "get service applist");
      ap.faj().hv(aj.getContext());
    }
    com.tencent.mm.sdk.b.a.IbL.c(this.viO);
    com.tencent.mm.sdk.b.a.IbL.c(this.viV);
    this.viP = new com.tencent.mm.plugin.luckymoney.model.ax();
    com.tencent.mm.plugin.luckymoney.model.h.dij();
    AppMethodBeat.o(64862);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(64863);
    Object localObject1 = ap.faj();
    if (g.ajx())
    {
      com.tencent.mm.plugin.s.a.dxT().b(4, (u)localObject1);
      g.ajD();
      g.ajB().gAO.b(1060, (com.tencent.mm.al.f)localObject1);
      ((ap)localObject1).ENX = false;
      ((ap)localObject1).ENY = false;
    }
    ((com.tencent.mm.plugin.messenger.foundation.a.r)g.ad(com.tencent.mm.plugin.messenger.foundation.a.r.class)).getSysCmdMsgExtension().b("paymsg", this.oZH, true);
    try
    {
      this.viN = null;
      com.tencent.mm.sdk.b.a.IbL.d(this.viO);
      com.tencent.mm.sdk.b.a.IbL.d(this.viV);
      if (this.viP != null)
      {
        localObject1 = this.viP;
        com.tencent.mm.sdk.b.a.IbL.d(((com.tencent.mm.plugin.luckymoney.model.ax)localObject1).vqU);
        if (((com.tencent.mm.plugin.luckymoney.model.ax)localObject1).vqR != null)
        {
          g.ajD();
          g.ajB().gAO.a(((com.tencent.mm.plugin.luckymoney.model.ax)localObject1).vqR);
          ((com.tencent.mm.plugin.luckymoney.model.ax)localObject1).vqR = null;
        }
        if (((com.tencent.mm.plugin.luckymoney.model.ax)localObject1).vqS != null)
        {
          g.ajD();
          g.ajB().gAO.a(((com.tencent.mm.plugin.luckymoney.model.ax)localObject1).vqS);
          ((com.tencent.mm.plugin.luckymoney.model.ax)localObject1).vqS = null;
        }
      }
      com.tencent.mm.plugin.luckymoney.model.h.unInit();
      this.viU.dead();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.b.a
 * JD-Core Version:    0.7.0.1
 */
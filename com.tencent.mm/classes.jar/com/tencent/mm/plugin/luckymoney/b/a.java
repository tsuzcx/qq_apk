package com.tencent.mm.plugin.luckymoney.b;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.g.a.ze;
import com.tencent.mm.g.a.ze.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.cf.a;
import com.tencent.mm.plugin.luckymoney.model.ax;
import com.tencent.mm.plugin.luckymoney.model.i;
import com.tencent.mm.plugin.luckymoney.model.o;
import com.tencent.mm.plugin.luckymoney.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storagebase.h.b;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class a
  implements az
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private cf.a pgl;
  private com.tencent.mm.plugin.luckymoney.model.k vuR;
  private r vuS;
  private i vuT;
  private ax vuU;
  private com.tencent.mm.cm.h<com.tencent.mm.plugin.luckymoney.model.q> vuV;
  private com.tencent.mm.cm.h<com.tencent.mm.plugin.luckymoney.story.b.b> vuW;
  private com.tencent.mm.cm.h<com.tencent.mm.plugin.luckymoney.story.b.d> vuX;
  private com.tencent.mm.cm.h<com.tencent.mm.plugin.luckymoney.story.b.f> vuY;
  private o vuZ;
  private com.tencent.mm.sdk.b.c<ze> vva;
  
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
    this.vuT = new i();
    this.vuV = new com.tencent.mm.cm.h(new a.1(this));
    this.vuW = new com.tencent.mm.cm.h(new com.tencent.mm.cm.c() {});
    this.vuX = new com.tencent.mm.cm.h(new com.tencent.mm.cm.c() {});
    this.vuY = new com.tencent.mm.cm.h(new a.5(this));
    this.vuZ = new o();
    this.pgl = new cf.a()
    {
      public final void a(e.a paramAnonymousa)
      {
        AppMethodBeat.i(189834);
        Object localObject1 = bx.M(com.tencent.mm.platformtools.z.a(paramAnonymousa.gte.FNI), "sysmsg");
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SubCoreLuckyMoney", "helios::::mPayMsgListener");
        if (localObject1 == null)
        {
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SubCoreLuckyMoney", "Resolve msg error");
          AppMethodBeat.o(189834);
          return;
        }
        if ("14".equals((String)((Map)localObject1).get(".sysmsg.paymsg.PayMsgType")))
        {
          paramAnonymousa = URLDecoder.decode((String)((Map)localObject1).get(".sysmsg.paymsg.appmsgcontent"));
          if (TextUtils.isEmpty(paramAnonymousa))
          {
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SubCoreLuckyMoney", "msgxml illegal");
            AppMethodBeat.o(189834);
            return;
          }
          Object localObject2 = bx.M(paramAnonymousa, "msg");
          if (localObject2 == null)
          {
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SubCoreLuckyMoney", "Resolve appmsgxml error");
            AppMethodBeat.o(189834);
            return;
          }
          localObject2 = (String)((Map)localObject2).get(".msg.appmsg.wcpayinfo.paymsgid");
          if (bu.isNullOrNil((String)localObject2))
          {
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SubCoreLuckyMoney", "paymsgid is null");
            AppMethodBeat.o(189834);
            return;
          }
          localObject1 = (String)((Map)localObject1).get(".sysmsg.paymsg.tousername");
          if ((bu.isNullOrNil(paramAnonymousa)) || (bu.isNullOrNil((String)localObject1)))
          {
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SubCoreLuckyMoney", "onRecieveMsg get a illegal msg,which content or toUserName is null");
            AppMethodBeat.o(189834);
            return;
          }
          if (a.this.dkJ().apY((String)localObject2))
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SubCoreLuckyMoney", "insert a local msg for luckymoney");
            if (!com.tencent.mm.plugin.luckymoney.model.z.Z(paramAnonymousa, (String)localObject1, 1)) {
              a.this.dkJ().apZ((String)localObject2);
            }
          }
        }
        AppMethodBeat.o(189834);
      }
      
      public final void a(e.c paramAnonymousc) {}
    };
    this.vva = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(ze paramAnonymousze)
      {
        AppMethodBeat.i(189831);
        Object localObject;
        if (!bu.isNullOrNil(paramAnonymousze.dPk.dEU))
        {
          k.b localb = k.b.zb(paramAnonymousze.dPk.dEU);
          if (!bu.isNullOrNil(localb.hEl))
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SubCoreLuckyMoney", "receive lucky money: %s", new Object[] { localb.hEl });
            localObject = t.eJb().aGb(localb.hEl);
            paramAnonymousze = (ze)localObject;
            if (localObject == null) {
              paramAnonymousze = new com.tencent.mm.plugin.wallet_core.model.ae();
            }
            if (bu.isNullOrNil(paramAnonymousze.field_mNativeUrl))
            {
              paramAnonymousze.field_mNativeUrl = localb.hEl;
              paramAnonymousze.field_receiveStatus = 0;
            }
            t.eJb().a(paramAnonymousze);
          }
          if (!bu.isNullOrNil(localb.hEl)) {
            paramAnonymousze = Uri.parse(bu.nullAsNil(localb.hEl));
          }
        }
        try
        {
          paramAnonymousze = paramAnonymousze.getQueryParameter("sendid");
          localObject = new com.tencent.mm.plugin.luckymoney.story.b.e();
          ((com.tencent.mm.plugin.luckymoney.story.b.e)localObject).field_send_id = paramAnonymousze;
          if (!a.this.dkF().get((com.tencent.mm.sdk.e.c)localObject, new String[0]))
          {
            ((com.tencent.mm.plugin.luckymoney.story.b.e)localObject).field_open_count = 0;
            com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SubCoreLuckyMoney", "insert record: %s, %s", new Object[] { paramAnonymousze, Boolean.valueOf(a.this.dkF().insert((com.tencent.mm.sdk.e.c)localObject)) });
          }
          label209:
          AppMethodBeat.o(189831);
          return false;
        }
        catch (Exception paramAnonymousze)
        {
          break label209;
        }
      }
    };
    com.tencent.mm.vfs.k localk = new com.tencent.mm.vfs.k(dkI());
    if (!localk.exists()) {
      localk.mkdirs();
    }
    AppMethodBeat.o(64861);
  }
  
  public static a dkG()
  {
    AppMethodBeat.i(64860);
    a locala = (a)com.tencent.mm.model.u.ap(a.class);
    AppMethodBeat.o(64860);
    return locala;
  }
  
  public static com.tencent.mm.plugin.luckymoney.model.k dkH()
  {
    AppMethodBeat.i(64864);
    g.ajP().aiU();
    if (dkG().vuR == null) {
      dkG().vuR = new com.tencent.mm.plugin.luckymoney.model.k();
    }
    com.tencent.mm.plugin.luckymoney.model.k localk = dkG().vuR;
    AppMethodBeat.o(64864);
    return localk;
  }
  
  public static String dkI()
  {
    AppMethodBeat.i(64865);
    if (g.ajM())
    {
      String str = com.tencent.mm.plugin.image.d.azQ() + "luckymoney";
      AppMethodBeat.o(64865);
      return str;
    }
    AppMethodBeat.o(64865);
    return "";
  }
  
  public void clearPluginData(int paramInt) {}
  
  public final com.tencent.mm.plugin.luckymoney.model.q dkC()
  {
    AppMethodBeat.i(64859);
    com.tencent.mm.plugin.luckymoney.model.q localq = (com.tencent.mm.plugin.luckymoney.model.q)this.vuV.get();
    AppMethodBeat.o(64859);
    return localq;
  }
  
  public final com.tencent.mm.plugin.luckymoney.story.b.b dkD()
  {
    AppMethodBeat.i(163538);
    com.tencent.mm.plugin.luckymoney.story.b.b localb = (com.tencent.mm.plugin.luckymoney.story.b.b)this.vuW.get();
    AppMethodBeat.o(163538);
    return localb;
  }
  
  public final com.tencent.mm.plugin.luckymoney.story.b.d dkE()
  {
    AppMethodBeat.i(163539);
    com.tencent.mm.plugin.luckymoney.story.b.d locald = (com.tencent.mm.plugin.luckymoney.story.b.d)this.vuX.get();
    AppMethodBeat.o(163539);
    return locald;
  }
  
  public final com.tencent.mm.plugin.luckymoney.story.b.f dkF()
  {
    AppMethodBeat.i(189835);
    com.tencent.mm.plugin.luckymoney.story.b.f localf = (com.tencent.mm.plugin.luckymoney.story.b.f)this.vuY.get();
    AppMethodBeat.o(189835);
    return localf;
  }
  
  public final r dkJ()
  {
    try
    {
      AppMethodBeat.i(64866);
      if (this.vuS == null) {
        this.vuS = new r();
      }
      r localr = this.vuS;
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
    ap localap = ap.fdX();
    if (g.ajM())
    {
      com.tencent.mm.plugin.s.a.dBj().a(4, localap);
      g.ajS();
      g.ajQ().gDv.a(1060, localap);
    }
    this.vuZ.alive();
    ((s)g.ad(s.class)).getSysCmdMsgExtension().a("paymsg", this.pgl, true);
    boolean bool = false;
    g.ajS();
    long l = g.ajR().ajA().aby(352276);
    if (System.currentTimeMillis() - l >= 43200000L) {
      bool = true;
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SubCoreLuckyMoney", "isTime=" + bool + ", isUpdate=" + paramBoolean);
    if ((paramBoolean) || (bool))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SubCoreLuckyMoney", "get service applist");
      ap.fdX().hB(ak.getContext());
    }
    com.tencent.mm.sdk.b.a.IvT.c(this.vuT);
    com.tencent.mm.sdk.b.a.IvT.c(this.vva);
    this.vuU = new ax();
    com.tencent.mm.plugin.luckymoney.model.h.dli();
    AppMethodBeat.o(64862);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(64863);
    Object localObject1 = ap.fdX();
    if (g.ajM())
    {
      com.tencent.mm.plugin.s.a.dBj().b(4, (com.tencent.mm.pluginsdk.model.app.u)localObject1);
      g.ajS();
      g.ajQ().gDv.b(1060, (com.tencent.mm.ak.f)localObject1);
      ((ap)localObject1).Fgt = false;
      ((ap)localObject1).Fgu = false;
    }
    ((s)g.ad(s.class)).getSysCmdMsgExtension().b("paymsg", this.pgl, true);
    try
    {
      this.vuS = null;
      com.tencent.mm.sdk.b.a.IvT.d(this.vuT);
      com.tencent.mm.sdk.b.a.IvT.d(this.vva);
      if (this.vuU != null)
      {
        localObject1 = this.vuU;
        com.tencent.mm.sdk.b.a.IvT.d(((ax)localObject1).vCZ);
        if (((ax)localObject1).vCW != null)
        {
          g.ajS();
          g.ajQ().gDv.a(((ax)localObject1).vCW);
          ((ax)localObject1).vCW = null;
        }
        if (((ax)localObject1).vCX != null)
        {
          g.ajS();
          g.ajQ().gDv.a(((ax)localObject1).vCX);
          ((ax)localObject1).vCX = null;
        }
      }
      com.tencent.mm.plugin.luckymoney.model.h.unInit();
      this.vuZ.dead();
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
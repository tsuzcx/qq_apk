package com.tencent.mm.plugin.finder.live.plugin;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.live.model.e;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.util.j;
import com.tencent.mm.plugin.finder.live.util.j.a;
import com.tencent.mm.plugin.finder.live.util.j.b;
import com.tencent.mm.plugin.finder.live.util.n;
import com.tencent.mm.plugin.finder.live.util.p.b;
import com.tencent.mm.plugin.finder.live.util.p.c;
import com.tencent.mm.plugin.finder.live.view.FinderLiveGiftSendBtn;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.plugin.finder.report.live.m;
import com.tencent.mm.plugin.finder.report.live.s.aw;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.protocal.protobuf.auz;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.a.f.c;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "continuousClickCallback", "Lcom/tencent/mm/plugin/finder/live/util/ContinuousClickManager$IContinuousClickCallback;", "continuousClickManager", "Lcom/tencent/mm/plugin/finder/live/util/ContinuousClickManager;", "curComboCount", "", "curComboId", "curGiftId", "memberListAutoRefreshValue", "networkEnable", "", "notifyMemberListRefresh", "sendBtn", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveGiftSendBtn;", "sendGiftCallback", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin$ISendGiftCallback;", "sendLocalGiftToMsg", "vibrator", "", "kotlin.jvm.PlatformType", "wecoinDialog", "Lcom/tencent/mm/plugin/wallet/wecoin/api/IWeCoinRechargeDialog;", "addLocalGiftMsg", "", "rewardGiftId", "rewardGiftCnt", "comboId", "diffCnt", "addSelfGiftToComment", "giftId", "comboCount", "canClearScreen", "hideGiftSendAgainLayout", "networkChange", "status", "onBackPress", "resetSelfGiftParams", "resume", "sendGift", "canShowNotEnoughDialog", "showConsumeFailDialog", "showGiftSendAgainLayout", "showWecoinNotEnoughDialog", "statusChange", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "stopGiftSending", "unMount", "uodateWecoinBalance", "balance", "", "(Ljava/lang/Long;)V", "vibrateAndShowGiftAnimation", "clickCnt", "state", "Lcom/tencent/mm/plugin/finder/live/util/ContinuousClickManager$State;", "ISendGiftCallback", "plugin-finder_release"})
public final class af
  extends d
{
  final String TAG;
  final com.tencent.mm.live.c.b hOp;
  final Object hQn;
  com.tencent.mm.plugin.wallet.wecoin.a.d upj;
  String upm;
  boolean uqA;
  boolean uqB;
  int uqC;
  String uqt;
  int uqu;
  j.a uqv;
  FinderLiveGiftSendBtn uqw;
  j uqx;
  a uqy;
  volatile boolean uqz;
  
  public af(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(246750);
    this.hOp = paramb;
    this.TAG = "Finder.FinderLiveGiftSendPlugin";
    this.hQn = paramViewGroup.getContext().getSystemService("vibrator");
    this.uqw = ((FinderLiveGiftSendBtn)paramViewGroup);
    this.uqz = true;
    this.uqA = true;
    this.uqB = true;
    paramViewGroup.post((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(246725);
        Object localObject = this.hOA.getLayoutParams();
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
          AppMethodBeat.o(246725);
          throw ((Throwable)localObject);
        }
        localObject = (ViewGroup.MarginLayoutParams)localObject;
        ((ViewGroup.MarginLayoutParams)localObject).bottomMargin += au.aD(this.hOA.getContext());
        AppMethodBeat.o(246725);
      }
    });
    this.uqv = ((j.a)new j.a()
    {
      public final void V(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(246729);
        p.h(paramAnonymousMotionEvent, "event");
        paramAnonymousMotionEvent = this.uqD.uqw;
        com.tencent.mm.ac.d.a(paramAnonymousMotionEvent.uyA, paramAnonymousMotionEvent.uyF);
        AppMethodBeat.o(246729);
      }
      
      public final boolean a(int paramAnonymousInt1, int paramAnonymousInt2, j.b paramAnonymousb, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(246728);
        p.h(paramAnonymousb, "state");
        p.h(paramAnonymousString, "comboId");
        Log.i(this.uqD.TAG, "batchCallback on " + paramAnonymousb + ", clickCnt:" + paramAnonymousInt1 + ", diffCnt is " + paramAnonymousInt2 + ", comboId is " + paramAnonymousString + ", needCheckBalance:" + paramAnonymousBoolean + ", networkEnable:" + this.uqD.uqz);
        Object localObject1;
        Object localObject2;
        switch (ag.$EnumSwitchMapping$0[paramAnonymousb.ordinal()])
        {
        default: 
          paramAnonymousb = this.uqD.upm;
          localObject1 = e.uiD;
          boolean bool = e.bg(paramAnonymousb, false);
          if ((paramAnonymousb == null) || (!bool)) {
            break label580;
          }
          paramAnonymousInt1 = paramAnonymousInt2;
          if (!paramAnonymousBoolean) {
            break label354;
          }
          localObject1 = e.uiD;
          localObject1 = e.atA(paramAnonymousb);
          if (localObject1 == null)
          {
            AppMethodBeat.o(246728);
            return false;
          }
          break;
        case 1: 
          paramAnonymousb = this.uqD;
          if (paramAnonymousb.uqB)
          {
            paramAnonymousString = paramAnonymousb.hOp;
            localObject1 = b.c.hMV;
            localObject2 = new Bundle();
            ((Bundle)localObject2).putInt("PARAM_FINDER_LIVE_MEMBER_LIST_AUTOREFRESH_VALUE", paramAnonymousb.uqC);
            paramAnonymousString.statusChange((b.c)localObject1, (Bundle)localObject2);
          }
          this.uqD.dhq();
          AppMethodBeat.o(246728);
          return true;
        }
        int i = (int)((com.tencent.mm.plugin.finder.storage.s)localObject1).field_price;
        long l = this.uqD.getLiveData().uEM;
        paramAnonymousInt1 = paramAnonymousInt2;
        if (l < 0L)
        {
          paramAnonymousInt1 = paramAnonymousInt2;
          if (i > 0) {
            paramAnonymousInt1 = paramAnonymousInt2 - (int)Math.ceil(-l * 1.0D / i);
          }
        }
        Log.i(this.uqD.TAG, "batchCallback price = " + i + ", realTimeBalance = " + l + ", safeDiffCnt = " + paramAnonymousInt1);
        if (paramAnonymousInt1 > 0)
        {
          label354:
          localObject1 = this.uqD;
          if (((af)localObject1).uqy == null) {
            ((af)localObject1).uqy = ((af.a)new af.d((af)localObject1));
          }
          localObject2 = e.uiD;
          localObject2 = e.atA(paramAnonymousb);
          if (localObject2 == null) {
            break label533;
          }
          Log.i(((af)localObject1).TAG, "sendGift, giftId:" + paramAnonymousb + " diffCnt:" + paramAnonymousInt1 + " price:" + ((com.tencent.mm.plugin.finder.storage.s)localObject2).field_price + ",comboId:" + paramAnonymousString);
          Object localObject3 = o.ujN;
          localObject3 = o.getFinderLiveAssistant();
          if (localObject3 != null)
          {
            Context localContext = ((com.tencent.mm.live.c.a)localObject1).hwr.getContext();
            p.g(localContext, "root.context");
            ((af)localObject1).getLiveData();
            ((af)localObject1).getLiveData();
            ((com.tencent.mm.plugin.finder.live.model.s)localObject3).a(localContext, paramAnonymousb, paramAnonymousInt1, (int)((com.tencent.mm.plugin.finder.storage.s)localObject2).field_price, paramAnonymousString, ((af)localObject1).uqy);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(246728);
          return true;
          label533:
          Log.e(((af)localObject1).TAG, "sendGift giftInfo is empty, giftId:" + paramAnonymousb + " diffCnt:" + paramAnonymousInt1 + ",comboId:" + paramAnonymousString);
        }
        label580:
        af.c(this.uqD);
        af.a(this.uqD);
        AppMethodBeat.o(246728);
        return false;
      }
      
      public final boolean a(final int paramAnonymousInt1, final j.b paramAnonymousb, String paramAnonymousString, int paramAnonymousInt2)
      {
        AppMethodBeat.i(246727);
        p.h(paramAnonymousb, "state");
        p.h(paramAnonymousString, "comboId");
        Object localObject1 = e.uiD;
        localObject1 = e.atA(this.uqD.upm);
        if (localObject1 != null)
        {
          int j = (int)((com.tencent.mm.plugin.finder.storage.s)localObject1).field_price;
          int i;
          Object localObject2;
          boolean bool;
          if (this.uqD.getLiveData().uEM >= j)
          {
            i = 1;
            localObject1 = this.uqD.getLiveData();
            ((g)localObject1).EN(((g)localObject1).uEM - j);
            if (i == 0) {
              break label462;
            }
            localObject1 = this.uqD;
            localObject2 = this.uqD.upm;
            ((af)localObject1).uqt = paramAnonymousString;
            ((af)localObject1).uqu = paramAnonymousInt1;
            Object localObject3 = e.uiD;
            bool = e.atB((String)localObject2);
            localObject3 = e.uiD;
            localObject3 = e.atA((String)localObject2);
            if (localObject3 == null) {
              break label403;
            }
            localObject2 = new aut();
            Object localObject4 = new auz();
            ((auz)localObject4).LFM = ((com.tencent.mm.plugin.finder.storage.s)localObject3).field_rewardProductId;
            ((aut)localObject2).LFB = com.tencent.mm.bw.b.cD(((auz)localObject4).toByteArray());
            localObject3 = new avn();
            localObject4 = new FinderContact();
            ((FinderContact)localObject4).username = z.aTY();
            ((FinderContact)localObject4).nickname = z.aUa();
            ((avn)localObject3).contact = ((FinderContact)localObject4);
            ((aut)localObject2).LFE = ((avn)localObject3);
            ((aut)localObject2).ybm = 20009;
            localObject2 = new p.b((aut)localObject2);
            ((p.b)localObject2).upR = paramAnonymousString;
            ((p.b)localObject2).upS = paramAnonymousInt1;
            if (((p.b)localObject2).upS <= 1) {
              break label384;
            }
            if (!bool) {
              break label377;
            }
            paramAnonymousString = p.c.uwY;
            label290:
            ((p.b)localObject2).c(paramAnonymousString);
            Log.i(((af)localObject1).TAG, "addLocalGiftMsg local add GiftShowInfo:" + localObject2 + ",diffCnt:" + paramAnonymousInt2);
            ((af)localObject1).getLiveData().uDw.a((p.b)localObject2);
          }
          for (;;)
          {
            com.tencent.mm.ac.d.h((kotlin.g.a.a)new a(this, paramAnonymousInt1, paramAnonymousb));
            AppMethodBeat.o(246727);
            return true;
            i = 0;
            break;
            label377:
            paramAnonymousString = p.c.uxa;
            break label290;
            label384:
            if (bool)
            {
              paramAnonymousString = p.c.uwZ;
              break label290;
            }
            paramAnonymousString = p.c.uxb;
            break label290;
            label403:
            Log.i(((af)localObject1).TAG, "addLocalGiftMsg giftInfo is null,giftId:" + (String)localObject2 + ",cnt:" + paramAnonymousInt1 + ",comboId:" + paramAnonymousString + ",diffCnt:" + paramAnonymousInt2);
          }
          label462:
          Log.i(this.uqD.TAG, "instantCallback no haveEnoughBalanceToConsume cnt:" + paramAnonymousInt1 + ",curBalance:" + this.uqD.getLiveData().uEM + ", diffCnt:" + paramAnonymousInt2);
          af.a(this.uqD);
          af.b(this.uqD);
          AppMethodBeat.o(246727);
          return false;
        }
        Log.i(this.uqD.TAG, "instantCallback giftInfo empty,curBalance:" + this.uqD.getLiveData().uEM + ", cnt:" + paramAnonymousInt1 + ",comboId:" + paramAnonymousString + ", diffCnt:" + paramAnonymousInt2);
        AppMethodBeat.o(246727);
        return false;
      }
      
      @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
      static final class a
        extends q
        implements kotlin.g.a.a<x>
      {
        a(af.2 param2, int paramInt, j.b paramb)
        {
          super();
        }
      }
    });
    paramViewGroup = c.vCb;
    int i = ((Number)c.dwg().value()).intValue();
    paramViewGroup = c.vCb;
    this.uqC = (((Number)c.dwe().value()).intValue() * 1000);
    if (i == 0)
    {
      bool1 = true;
      this.uqA = bool1;
      if (this.uqC < 0) {
        break label222;
      }
    }
    label222:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.uqB = bool1;
      Log.i(this.TAG, "sendLocalGiftToMsgValue :" + i + ",memberListAutoRefreshValue:" + this.uqC);
      AppMethodBeat.o(246750);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final boolean dgK()
  {
    return true;
  }
  
  final void dhq()
  {
    AppMethodBeat.i(246744);
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(246744);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(246746);
    if (this.hwr.getVisibility() == 0)
    {
      dhq();
      AppMethodBeat.o(246746);
      return true;
    }
    boolean bool = super.onBackPress();
    AppMethodBeat.o(246746);
    return bool;
  }
  
  public final void resume()
  {
    AppMethodBeat.i(246745);
    super.resume();
    AppMethodBeat.o(246745);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(246749);
    p.h(paramc, "status");
    switch (ag.uqL[paramc.ordinal()])
    {
    }
    do
    {
      do
      {
        AppMethodBeat.o(246749);
        return;
        if ((paramBundle != null) && (paramBundle.containsKey("PARAM_FINDER_LIVE_GIFT_ID") == true)) {
          this.upm = paramBundle.getString("PARAM_FINDER_LIVE_GIFT_ID");
        }
        com.tencent.mm.ac.d.h((kotlin.g.a.a)new f(this));
        AppMethodBeat.o(246749);
        return;
        dhq();
        AppMethodBeat.o(246749);
        return;
      } while (getLiveData().dja());
      dhq();
      paramc = this.upj;
      if (paramc != null)
      {
        paramc.bMo();
        AppMethodBeat.o(246749);
        return;
      }
      AppMethodBeat.o(246749);
      return;
      paramc = this.upj;
    } while (paramc == null);
    paramc.bMo();
    AppMethodBeat.o(246749);
  }
  
  public final void uC(int paramInt)
  {
    AppMethodBeat.i(246748);
    this.uqz = NetStatusUtil.isConnected(MMApplicationContext.getContext());
    Log.i(this.TAG, "networkChange " + paramInt + ",networkEnable:" + this.uqz);
    if (!this.uqz) {
      com.tencent.mm.ac.d.h((kotlin.g.a.a)new c(this));
    }
    AppMethodBeat.o(246748);
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(246747);
    super.unMount();
    FinderLiveGiftSendBtn localFinderLiveGiftSendBtn = this.uqw;
    localFinderLiveGiftSendBtn.diu();
    com.tencent.mm.ac.d.C(localFinderLiveGiftSendBtn.uyF);
    AppMethodBeat.o(246747);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin$ISendGiftCallback;", "", "sendGiftCallback", "", "success", "", "errCode", "", "errType", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin$ISendGiftCallback$ErrorType;", "rewardGiftId", "", "balance", "", "cnt", "comboId", "(ZILcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin$ISendGiftCallback$ErrorType;Ljava/lang/String;Ljava/lang/Long;ILjava/lang/String;)V", "ErrorType", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, int paramInt1, a parama, String paramString1, Long paramLong, int paramInt2, String paramString2);
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin$ISendGiftCallback$ErrorType;", "", "(Ljava/lang/String;I)V", "OK", "NETWORK", "WECOIN", "plugin-finder_release"})
    public static enum a
    {
      static
      {
        AppMethodBeat.i(246730);
        a locala1 = new a("OK", 0);
        uqH = locala1;
        a locala2 = new a("NETWORK", 1);
        uqI = locala2;
        a locala3 = new a("WECOIN", 2);
        uqJ = locala3;
        uqK = new a[] { locala1, locala2, locala3 };
        AppMethodBeat.o(246730);
      }
      
      private a() {}
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(af paramaf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(af paramaf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin$sendGift$1", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin$ISendGiftCallback;", "sendGiftCallback", "", "success", "", "errCode", "", "errType", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin$ISendGiftCallback$ErrorType;", "rewardGiftId", "", "balance", "", "cnt", "comboId", "(ZILcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin$ISendGiftCallback$ErrorType;Ljava/lang/String;Ljava/lang/Long;ILjava/lang/String;)V", "plugin-finder_release"})
  public static final class d
    implements af.a
  {
    d(boolean paramBoolean) {}
    
    public final void a(boolean paramBoolean, int paramInt1, af.a.a parama, String paramString1, Long paramLong, int paramInt2, String paramString2)
    {
      AppMethodBeat.i(246737);
      p.h(parama, "errType");
      Log.i(this.uqD.TAG, "sendGiftCallback, success:" + paramBoolean + " errCode:" + paramInt1 + " errType:" + parama + ",rewardGiftId:" + paramString1 + ",balance:" + paramLong + ",cnt:" + paramInt2 + ",comboId:" + paramString2);
      if (paramBoolean)
      {
        parama = this.uqD;
        if (paramLong != null)
        {
          parama = parama.hOp;
          paramString2 = b.c.hMM;
          Bundle localBundle = new Bundle();
          localBundle.putLong("PARAM_FINDER_LIVE_GIFT_UPDATE_WECOIN", paramLong.longValue());
          parama.statusChange(paramString2, localBundle);
        }
        for (;;)
        {
          if (this.uqD.hOp.getLiveRole() == 0)
          {
            parama = m.vli;
            m.a(s.aw.vsk, paramString1, paramInt2);
          }
          AppMethodBeat.o(246737);
          return;
          b.b.a(parama.hOp, b.c.hMM);
        }
      }
      af.a(this.uqD);
      switch (ag.haE[parama.ordinal()])
      {
      }
      do
      {
        for (;;)
        {
          AppMethodBeat.o(246737);
          return;
          switch (paramInt1)
          {
          case 10001: 
          case 10002: 
          default: 
            af.c(this.uqD);
          }
        }
      } while (!this.uqN);
      af.b(this.uqD);
      AppMethodBeat.o(246737);
      return;
      AppMethodBeat.o(246737);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<x>
  {
    e(af paramaf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<x>
  {
    f(af paramaf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<x>
  {
    g(af paramaf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<x>
  {
    h(af paramaf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.af
 * JD-Core Version:    0.7.0.1
 */
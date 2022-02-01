package com.tencent.mm.plugin.finder.live.plugin;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.plugin.finder.live.model.an;
import com.tencent.mm.plugin.finder.live.report.s.bk;
import com.tencent.mm.plugin.finder.live.util.j;
import com.tencent.mm.plugin.finder.live.util.j.a;
import com.tencent.mm.plugin.finder.live.util.j.b;
import com.tencent.mm.plugin.finder.live.view.FinderLiveGiftSendBtn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.widget.a.f.c;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "continuousClickCallback", "Lcom/tencent/mm/plugin/finder/live/util/ContinuousClickManager$IContinuousClickCallback;", "continuousClickManager", "Lcom/tencent/mm/plugin/finder/live/util/ContinuousClickManager;", "curComboCount", "", "curComboId", "curGiftId", "entranceNotAvailabComboId", "memberListAutoRefreshValue", "networkEnable", "", "notEnoughWecoinComboId", "notifyMemberListRefresh", "sendBtn", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveGiftSendBtn;", "sendGiftCallback", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin$ISendGiftCallback;", "sendGiftTargetUserName", "sendLocalGiftToMsg", "vibrator", "", "kotlin.jvm.PlatformType", "wecoinDialog", "Lcom/tencent/mm/plugin/wallet/wecoin/api/IWeCoinRechargeDialog;", "wecoinEntranceNotAvailableDialog", "Lcom/tencent/mm/ui/widget/dialog/MMAlertDialog;", "wecoinNotEnoughDialog", "addLocalGiftMsg", "", "rewardGiftId", "rewardGiftCnt", "comboId", "diffCnt", "addSelfGiftToComment", "giftId", "comboCount", "canClearScreen", "hideGiftSendAgainLayout", "onBackPress", "onNetworkChange", "status", "resetSelfGiftParams", "resume", "sendGift", "canShowNotEnoughDialog", "showConsumeFailDialog", "errMsg", "showGiftSendAgainLayout", "showWecoinNotEnoughDialog", "statusChange", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "stopGiftSending", "unMount", "uodateWecoinBalance", "balance", "", "(Ljava/lang/Long;)V", "vibrateAndShowGiftAnimation", "clickCnt", "state", "Lcom/tencent/mm/plugin/finder/live/util/ContinuousClickManager$State;", "ISendGiftCallback", "plugin-finder_release"})
public final class be
  extends d
{
  private final String TAG;
  private final com.tencent.mm.live.c.b kCL;
  private final Object kEK;
  private com.tencent.mm.plugin.wallet.wecoin.a.d yqh;
  private String yqk;
  private String yse;
  private int ysf;
  private j.a ysg;
  private FinderLiveGiftSendBtn ysh;
  private j ysi;
  private a ysj;
  private String ysk;
  private String ysl;
  private com.tencent.mm.ui.widget.a.d ysm;
  private String ysn;
  private com.tencent.mm.ui.widget.a.d yso;
  private volatile boolean ysp;
  private boolean ysq;
  private boolean ysr;
  private int yss;
  
  public be(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(285826);
    this.kCL = paramb;
    this.TAG = "Finder.FinderLiveGiftSendPlugin";
    this.kEK = paramViewGroup.getContext().getSystemService("vibrator");
    this.ysh = ((FinderLiveGiftSendBtn)paramViewGroup);
    this.ysk = "";
    this.ysl = "";
    this.ysn = "";
    this.ysp = true;
    this.ysq = true;
    this.ysr = true;
    paramViewGroup.post((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(280310);
        Object localObject = this.kCW.getLayoutParams();
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
          AppMethodBeat.o(280310);
          throw ((Throwable)localObject);
        }
        localObject = (ViewGroup.MarginLayoutParams)localObject;
        ((ViewGroup.MarginLayoutParams)localObject).bottomMargin += ax.aB(this.kCW.getContext());
        AppMethodBeat.o(280310);
      }
    });
    this.ysg = ((j.a)new j.a()
    {
      public final boolean a(int paramAnonymousInt1, int paramAnonymousInt2, j.b paramAnonymousb, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(284721);
        p.k(paramAnonymousb, "state");
        p.k(paramAnonymousString, "comboId");
        Log.i(be.f(this.yst), "batchCallback on " + paramAnonymousb + ", clickCnt:" + paramAnonymousInt1 + ", diffCnt is " + paramAnonymousInt2 + ", comboId is " + paramAnonymousString + ", needCheckBalance:" + paramAnonymousBoolean + ", networkEnable:" + be.b(this.yst));
        Object localObject;
        switch (bf.$EnumSwitchMapping$0[paramAnonymousb.ordinal()])
        {
        default: 
          paramAnonymousb = be.g(this.yst);
          localObject = com.tencent.mm.plugin.finder.live.model.m.yfw;
          boolean bool = com.tencent.mm.plugin.finder.live.model.m.bj(paramAnonymousb, false);
          if ((paramAnonymousb == null) || (!bool)) {
            break label330;
          }
          paramAnonymousInt1 = paramAnonymousInt2;
          if (!paramAnonymousBoolean) {
            break label312;
          }
          localObject = com.tencent.mm.plugin.finder.live.model.m.yfw;
          localObject = com.tencent.mm.plugin.finder.live.model.m.aCc(paramAnonymousb);
          if (localObject == null)
          {
            AppMethodBeat.o(284721);
            return false;
          }
          break;
        case 1: 
          be.q(this.yst);
          be.r(this.yst);
          AppMethodBeat.o(284721);
          return true;
        }
        int i = (int)((com.tencent.c.a.a.a.d.a.b)localObject).field_price;
        long l = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.yst.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfK;
        paramAnonymousInt1 = paramAnonymousInt2;
        if (l < 0L)
        {
          paramAnonymousInt1 = paramAnonymousInt2;
          if (i > 0) {
            paramAnonymousInt1 = paramAnonymousInt2 - (int)Math.ceil(-l * 1.0D / i);
          }
        }
        Log.i(be.f(this.yst), "batchCallback price = " + i + ", realTimeBalance = " + l + ", safeDiffCnt = " + paramAnonymousInt1);
        if (paramAnonymousInt1 > 0) {
          label312:
          be.a(this.yst, paramAnonymousb, paramAnonymousInt1, paramAnonymousString);
        }
        AppMethodBeat.o(284721);
        return true;
        label330:
        be.a(this.yst);
        be.l(this.yst);
        AppMethodBeat.o(284721);
        return false;
      }
      
      public final boolean a(final int paramAnonymousInt1, final j.b paramAnonymousb, String paramAnonymousString, int paramAnonymousInt2)
      {
        AppMethodBeat.i(284720);
        p.k(paramAnonymousb, "state");
        p.k(paramAnonymousString, "comboId");
        Object localObject = com.tencent.mm.plugin.finder.live.model.m.yfw;
        localObject = com.tencent.mm.plugin.finder.live.model.m.aCc(be.g(this.yst));
        if (localObject != null)
        {
          int j = (int)((com.tencent.c.a.a.a.d.a.b)localObject).field_price;
          if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.yst.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfK >= j) {}
          for (int i = 1;; i = 0)
          {
            localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.yst.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
            ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).LP(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfK - j);
            if (i == 0) {
              break;
            }
            be.a(this.yst, be.g(this.yst), paramAnonymousInt1, paramAnonymousString, paramAnonymousInt2);
            com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this, paramAnonymousInt1, paramAnonymousb));
            AppMethodBeat.o(284720);
            return true;
          }
          Log.i(be.f(this.yst), "instantCallback no haveEnoughBalanceToConsume cnt:" + paramAnonymousInt1 + ",curBalance:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.yst.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfK + ", diffCnt:" + paramAnonymousInt2);
          be.l(this.yst);
          be.a(this.yst, paramAnonymousString);
          AppMethodBeat.o(284720);
          return false;
        }
        Log.i(be.f(this.yst), "instantCallback giftInfo empty,curBalance:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.yst.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfK + ", cnt:" + paramAnonymousInt1 + ",comboId:" + paramAnonymousString + ", diffCnt:" + paramAnonymousInt2);
        AppMethodBeat.o(284720);
        return false;
      }
      
      public final void ab(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(284722);
        p.k(paramAnonymousMotionEvent, "event");
        paramAnonymousMotionEvent = be.d(this.yst);
        com.tencent.mm.ae.d.a(paramAnonymousMotionEvent.yUr, paramAnonymousMotionEvent.yUw);
        AppMethodBeat.o(284722);
      }
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
      static final class a
        extends q
        implements kotlin.g.a.a<x>
      {
        a(be.2 param2, int paramInt, j.b paramb)
        {
          super();
        }
      }
    });
    paramViewGroup = com.tencent.c.a.a.a.a.a.Zlt;
    int i = ((Number)com.tencent.c.a.a.a.a.a.ilZ().aSr()).intValue();
    paramViewGroup = com.tencent.c.a.a.a.a.a.Zlt;
    this.yss = (((Number)com.tencent.c.a.a.a.a.a.ilW().aSr()).intValue() * 1000);
    if (i == 0)
    {
      bool1 = true;
      this.ysq = bool1;
      if (this.yss < 0) {
        break label241;
      }
    }
    label241:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.ysr = bool1;
      Log.i(this.TAG, "sendLocalGiftToMsgValue :" + i + ",memberListAutoRefreshValue:" + this.yss);
      AppMethodBeat.o(285826);
      return;
      bool1 = false;
      break;
    }
  }
  
  private final void aCr(final String paramString)
  {
    AppMethodBeat.i(285819);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new e(this, paramString));
    AppMethodBeat.o(285819);
  }
  
  private final void dBN()
  {
    AppMethodBeat.i(285817);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(285817);
  }
  
  public final boolean dAo()
  {
    return true;
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(285822);
    if (this.kiF.getVisibility() == 0)
    {
      dBN();
      AppMethodBeat.o(285822);
      return true;
    }
    boolean bool = super.onBackPress();
    AppMethodBeat.o(285822);
    return bool;
  }
  
  public final void onNetworkChange(int paramInt)
  {
    AppMethodBeat.i(285824);
    this.ysp = NetStatusUtil.isConnected(MMApplicationContext.getContext());
    Log.i(this.TAG, "networkChange " + paramInt + ",networkEnable:" + this.ysp);
    if (!this.ysp) {
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(this));
    }
    AppMethodBeat.o(285824);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(285821);
    super.resume();
    AppMethodBeat.o(285821);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(285825);
    p.k(paramc, "status");
    switch (bf.tKM[paramc.ordinal()])
    {
    }
    do
    {
      do
      {
        AppMethodBeat.o(285825);
        return;
        if ((paramBundle != null) && (paramBundle.containsKey("PARAM_FINDER_LIVE_GIFT_ID") == true)) {
          this.yqk = paramBundle.getString("PARAM_FINDER_LIVE_GIFT_ID");
        }
        if ((paramBundle != null) && (paramBundle.containsKey("PARAM_FINDER_LIVE_SEND_GIFT_TARGET_USER_NAME") == true))
        {
          paramBundle = paramBundle.getString("PARAM_FINDER_LIVE_SEND_GIFT_TARGET_USER_NAME");
          paramc = paramBundle;
          if (paramBundle == null) {
            paramc = "";
          }
          this.ysk = paramc;
        }
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new f(this));
        AppMethodBeat.o(285825);
        return;
        dBN();
        AppMethodBeat.o(285825);
        return;
      } while (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGF());
      dBN();
      paramc = this.yqh;
      if (paramc != null)
      {
        paramc.bYF();
        AppMethodBeat.o(285825);
        return;
      }
      AppMethodBeat.o(285825);
      return;
      paramc = this.yqh;
    } while (paramc == null);
    paramc.bYF();
    AppMethodBeat.o(285825);
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(285823);
    super.unMount();
    FinderLiveGiftSendBtn localFinderLiveGiftSendBtn = this.ysh;
    localFinderLiveGiftSendBtn.dFb();
    com.tencent.mm.ae.d.C(localFinderLiveGiftSendBtn.yUw);
    AppMethodBeat.o(285823);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin$ISendGiftCallback;", "", "sendGiftCallback", "", "success", "", "errCode", "", "errType", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin$ISendGiftCallback$ErrorType;", "rewardGiftId", "", "balance", "", "cnt", "comboId", "errMsg", "(ZILcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin$ISendGiftCallback$ErrorType;Ljava/lang/String;Ljava/lang/Long;ILjava/lang/String;Ljava/lang/String;)V", "ErrorType", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, int paramInt1, b paramb, String paramString1, Long paramLong, int paramInt2, String paramString2, String paramString3);
    
    @l(iBK={1, 1, 16})
    public static final class a {}
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin$ISendGiftCallback$ErrorType;", "", "(Ljava/lang/String;I)V", "OK", "NETWORK", "WECOIN", "plugin-finder_release"})
    public static enum b
    {
      static
      {
        AppMethodBeat.i(271688);
        b localb1 = new b("OK", 0);
        ysx = localb1;
        b localb2 = new b("NETWORK", 1);
        ysy = localb2;
        b localb3 = new b("WECOIN", 2);
        ysz = localb3;
        ysA = new b[] { localb1, localb2, localb3 };
        AppMethodBeat.o(271688);
      }
      
      private b() {}
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(be parambe)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(be parambe)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin$sendGift$1", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin$ISendGiftCallback;", "sendGiftCallback", "", "success", "", "errCode", "", "errType", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin$ISendGiftCallback$ErrorType;", "rewardGiftId", "", "balance", "", "cnt", "comboId", "errMsg", "(ZILcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin$ISendGiftCallback$ErrorType;Ljava/lang/String;Ljava/lang/Long;ILjava/lang/String;Ljava/lang/String;)V", "plugin-finder_release"})
  public static final class d
    implements be.a
  {
    public final void a(boolean paramBoolean, int paramInt1, be.a.b paramb, String paramString1, Long paramLong, int paramInt2, String paramString2, String paramString3)
    {
      AppMethodBeat.i(280473);
      p.k(paramb, "errType");
      Log.i(be.f(this.yst), "sendGiftCallback, success:" + paramBoolean + " errCode:" + paramInt1 + " errType:" + paramb + ",rewardGiftId:" + paramString1 + ",balance:" + paramLong + ",cnt:" + paramInt2 + ",comboId:" + paramString2);
      if (paramBoolean)
      {
        be.a(this.yst, paramLong);
        if (be.k(this.yst).getLiveRole() == 0)
        {
          paramb = com.tencent.mm.plugin.finder.live.report.m.yCt;
          com.tencent.mm.plugin.finder.live.report.m.a(s.bk.yMi, paramString1, paramInt2);
        }
        b.b.a(be.k(this.yst), b.c.kzv);
        AppMethodBeat.o(280473);
        return;
      }
      be.l(this.yst);
      switch (bf.jLJ[paramb.ordinal()])
      {
      }
      for (;;)
      {
        AppMethodBeat.o(280473);
        return;
        switch (paramInt1)
        {
        case 10001: 
        case 10002: 
        default: 
          be.a(this.yst);
          AppMethodBeat.o(280473);
          return;
        case 10003: 
          if (this.ysC)
          {
            be.a(this.yst, paramString2);
            AppMethodBeat.o(280473);
            return;
          }
          break;
        case 10000: 
          AppMethodBeat.o(280473);
          return;
          be.b(this.yst, paramString3);
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<x>
  {
    e(be parambe, String paramString)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<x>
  {
    f(be parambe)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<x>
  {
    g(be parambe, String paramString)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<x>
  {
    h(be parambe)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.be
 * JD-Core Version:    0.7.0.1
 */
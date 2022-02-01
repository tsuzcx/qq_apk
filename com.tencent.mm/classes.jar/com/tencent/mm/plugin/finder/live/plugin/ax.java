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
import com.tencent.mm.live.b.b.b;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.model.ak;
import com.tencent.mm.plugin.finder.live.model.ak.b;
import com.tencent.mm.plugin.finder.live.model.ap;
import com.tencent.mm.plugin.finder.live.model.q;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.q.cc;
import com.tencent.mm.plugin.finder.live.util.j;
import com.tencent.mm.plugin.finder.live.util.j.a;
import com.tencent.mm.plugin.finder.live.util.j.b;
import com.tencent.mm.plugin.finder.live.view.FinderLiveGiftSendBtn;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.ui.bf;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "comboIdStatusMap", "", "", "continuousClickCallback", "Lcom/tencent/mm/plugin/finder/live/util/ContinuousClickManager$IContinuousClickCallback;", "continuousClickManager", "Lcom/tencent/mm/plugin/finder/live/util/ContinuousClickManager;", "curComboCount", "", "curComboId", "curGiftId", "entranceNotAvailabComboId", "memberListAutoRefreshValue", "networkEnable", "notEnoughWecoinComboId", "notifyMemberListRefresh", "sendBtn", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveGiftSendBtn;", "sendGiftCallback", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin$ISendGiftCallback;", "sendGiftTargetUserName", "sendLocalGiftToMsg", "validRewardMap", "vibrator", "", "kotlin.jvm.PlatformType", "wecoinDialog", "Lcom/tencent/mm/plugin/wallet/wecoin/api/IWeCoinRechargeDialog;", "wecoinEntranceNotAvailableDialog", "Lcom/tencent/mm/ui/widget/dialog/MMAlertDialog;", "wecoinNotEnoughDialog", "addLocalGiftMsg", "", "rewardGiftId", "rewardGiftCnt", "comboId", "diffCnt", "addSelfGiftToComment", "giftId", "comboCount", "canClearScreen", "hideGiftSendAgainLayout", "onBackPress", "onNetworkChange", "status", "resetSelfGiftParams", "resume", "sendGift", "canShowNotEnoughDialog", "showConsumeFailDialog", "errMsg", "showGiftSendAgainLayout", "showWecoinNotEnoughDialog", "statusChange", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "stopGiftSending", "unMount", "uodateWecoinBalance", "balance", "", "(Ljava/lang/Long;)V", "updateValidRewardMap", "cnt", "vibrateAndShowGiftAnimation", "clickCnt", "state", "Lcom/tencent/mm/plugin/finder/live/util/ContinuousClickManager$State;", "ISendGiftCallback", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ax
  extends b
{
  private com.tencent.mm.plugin.wallet.wecoin.a.e Dak;
  private String Dap;
  private String Dcj;
  private int Dck;
  private final Map<String, Integer> Dcl;
  private final Map<String, Boolean> Dcm;
  private j.a Dcn;
  private FinderLiveGiftSendBtn Dco;
  private j Dcp;
  private a Dcq;
  private String Dcr;
  private String Dcs;
  private com.tencent.mm.ui.widget.a.e Dct;
  private String Dcu;
  private volatile boolean Dcv;
  private boolean Dcw;
  private boolean Dcx;
  private int Dcy;
  private final String TAG;
  private final com.tencent.mm.live.b.b nfT;
  private final Object nhS;
  
  public ax(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(354866);
    this.nfT = paramb;
    this.TAG = "Finder.FinderLiveGiftSendPlugin";
    this.nhS = paramViewGroup.getContext().getSystemService("vibrator");
    this.Dco = ((FinderLiveGiftSendBtn)paramViewGroup);
    this.Dcr = "";
    this.Dcs = "";
    this.Dcu = "";
    this.Dcv = true;
    this.Dcw = true;
    this.Dcx = true;
    paramViewGroup.post(new ax..ExternalSyntheticLambda0(paramViewGroup));
    this.Dcn = ((j.a)new j.a()
    {
      public final boolean a(int paramAnonymousInt1, int paramAnonymousInt2, j.b paramAnonymousb, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(353448);
        s.u(paramAnonymousb, "state");
        s.u(paramAnonymousString, "comboId");
        Log.i(ax.f(this.Dcz), "batchCallback on " + paramAnonymousb + ", clickCnt:" + paramAnonymousInt1 + ", diffCnt is " + paramAnonymousInt2 + ", comboId is " + paramAnonymousString + ", needCheckBalance:" + paramAnonymousBoolean + ", networkEnable:" + ax.b(this.Dcz));
        if (a.$EnumSwitchMapping$0[paramAnonymousb.ordinal()] == 1)
        {
          ax.p(this.Dcz);
          ax.q(this.Dcz);
          AppMethodBeat.o(353448);
          return true;
        }
        paramAnonymousb = ax.g(this.Dcz);
        Object localObject = q.CFU;
        boolean bool = q.bv(paramAnonymousb, false);
        if ((paramAnonymousb != null) && (bool))
        {
          paramAnonymousInt1 = paramAnonymousInt2;
          if (paramAnonymousBoolean)
          {
            localObject = q.CFU;
            localObject = q.awx(paramAnonymousb);
            if (localObject == null)
            {
              AppMethodBeat.o(353448);
              return false;
            }
            int i = (int)((com.tencent.d.a.a.a.d.a.d)localObject).field_price;
            long l = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.Dcz.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edy;
            paramAnonymousInt1 = paramAnonymousInt2;
            if (l < 0L)
            {
              paramAnonymousInt1 = paramAnonymousInt2;
              if (i > 0) {
                paramAnonymousInt1 = paramAnonymousInt2 - (int)Math.ceil(-l * 1.0D / i);
              }
            }
            Log.i(ax.f(this.Dcz), "batchCallback price = " + i + ", realTimeBalance = " + l + ", safeDiffCnt = " + paramAnonymousInt1);
            if (paramAnonymousInt1 <= 0) {}
          }
          else
          {
            ax.a(this.Dcz, paramAnonymousb, paramAnonymousInt1, paramAnonymousString);
          }
          AppMethodBeat.o(353448);
          return true;
        }
        ax.a(this.Dcz);
        ax.l(this.Dcz);
        AppMethodBeat.o(353448);
        return false;
      }
      
      public final boolean a(final int paramAnonymousInt1, final j.b paramAnonymousb, String paramAnonymousString, int paramAnonymousInt2)
      {
        AppMethodBeat.i(353439);
        s.u(paramAnonymousb, "state");
        s.u(paramAnonymousString, "comboId");
        Object localObject = q.CFU;
        localObject = q.awx(ax.g(this.Dcz));
        if (localObject != null)
        {
          int j = (int)((com.tencent.d.a.a.a.d.a.d)localObject).field_price;
          if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.Dcz.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edy >= j) {}
          for (int i = 1;; i = 0)
          {
            localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.Dcz.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
            ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject).oX(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject).Edy - j);
            if (i == 0) {
              break;
            }
            ax.a(this.Dcz, ax.g(this.Dcz), paramAnonymousInt1, paramAnonymousString, paramAnonymousInt2);
            com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(this.Dcz, paramAnonymousInt1, paramAnonymousb));
            AppMethodBeat.o(353439);
            return true;
          }
          Log.i(ax.f(this.Dcz), "instantCallback no haveEnoughBalanceToConsume cnt:" + paramAnonymousInt1 + ",curBalance:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.Dcz.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edy + ", diffCnt:" + paramAnonymousInt2 + ", price:" + j);
          ax.l(this.Dcz);
          ax.a(this.Dcz, paramAnonymousString);
          AppMethodBeat.o(353439);
          return false;
        }
        Log.i(ax.f(this.Dcz), "instantCallback giftInfo empty,curBalance:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.Dcz.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edy + ", cnt:" + paramAnonymousInt1 + ",comboId:" + paramAnonymousString + ", diffCnt:" + paramAnonymousInt2);
        AppMethodBeat.o(353439);
        return false;
      }
      
      public final void ac(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(353453);
        s.u(paramAnonymousMotionEvent, "event");
        paramAnonymousMotionEvent = ax.d(this.Dcz);
        com.tencent.mm.ae.d.a(paramAnonymousMotionEvent.DNJ, paramAnonymousMotionEvent.DNO);
        AppMethodBeat.o(353453);
      }
      
      @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
      static final class b
        extends u
        implements kotlin.g.a.a<ah>
      {
        b(ax paramax, int paramInt, j.b paramb)
        {
          super();
        }
      }
    });
    paramViewGroup = com.tencent.d.a.a.a.a.a.ahiX;
    int i = ((Number)com.tencent.d.a.a.a.a.a.jSC().bmg()).intValue();
    paramViewGroup = com.tencent.d.a.a.a.a.a.ahiX;
    this.Dcy = (((Number)com.tencent.d.a.a.a.a.a.jSz().bmg()).intValue() * 1000);
    if (i == 0)
    {
      bool1 = true;
      this.Dcw = bool1;
      if (this.Dcy < 0) {
        break label267;
      }
    }
    label267:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.Dcx = bool1;
      Log.i(this.TAG, "sendLocalGiftToMsgValue :" + i + ",memberListAutoRefreshValue:" + this.Dcy);
      this.Dcl = ((Map)new HashMap());
      this.Dcm = ((Map)new HashMap());
      AppMethodBeat.o(354866);
      return;
      bool1 = false;
      break;
    }
  }
  
  private final void awZ(final String paramString)
  {
    AppMethodBeat.i(354883);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new f(this, paramString));
    AppMethodBeat.o(354883);
  }
  
  private final void eqC()
  {
    AppMethodBeat.i(354870);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(354870);
  }
  
  private static final void x(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(354894);
    s.u(paramViewGroup, "$root");
    Object localObject = paramViewGroup.getLayoutParams();
    if (localObject == null)
    {
      paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(354894);
      throw paramViewGroup;
    }
    localObject = (ViewGroup.MarginLayoutParams)localObject;
    ((ViewGroup.MarginLayoutParams)localObject).bottomMargin += bf.bk(paramViewGroup.getContext());
    AppMethodBeat.o(354894);
  }
  
  public final boolean eoI()
  {
    return true;
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(355112);
    if (this.mJe.getVisibility() == 0)
    {
      eqC();
      AppMethodBeat.o(355112);
      return true;
    }
    boolean bool = super.onBackPress();
    AppMethodBeat.o(355112);
    return bool;
  }
  
  public final void onNetworkChange(int paramInt)
  {
    AppMethodBeat.i(355129);
    this.Dcv = NetStatusUtil.isConnected(MMApplicationContext.getContext());
    Log.i(this.TAG, "networkChange " + paramInt + ",networkEnable:" + this.Dcv);
    if (!this.Dcv) {
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d(this));
    }
    AppMethodBeat.o(355129);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(355105);
    super.resume();
    AppMethodBeat.o(355105);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(355147);
    s.u(paramc, "status");
    switch (b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(355147);
      return;
      if ((paramBundle != null) && (paramBundle.containsKey("PARAM_FINDER_LIVE_GIFT_ID") == true))
      {
        i = 1;
        if (i != 0)
        {
          if (paramBundle != null) {
            break label160;
          }
          paramc = null;
          label86:
          this.Dap = paramc;
        }
        if ((paramBundle == null) || (paramBundle.containsKey("PARAM_FINDER_LIVE_SEND_GIFT_TARGET_USER_NAME") != true)) {
          break label171;
        }
      }
      label160:
      label171:
      for (int i = 1;; i = 0)
      {
        if (i != 0)
        {
          paramBundle = paramBundle.getString("PARAM_FINDER_LIVE_SEND_GIFT_TARGET_USER_NAME");
          paramc = paramBundle;
          if (paramBundle == null) {
            paramc = "";
          }
          this.Dcr = paramc;
        }
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new g(this));
        AppMethodBeat.o(355147);
        return;
        i = 0;
        break;
        paramc = paramBundle.getString("PARAM_FINDER_LIVE_GIFT_ID");
        break label86;
      }
      eqC();
      AppMethodBeat.o(355147);
      return;
      if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyr())
      {
        eqC();
        paramc = this.Dak;
        if (paramc != null)
        {
          paramc.cyW();
          AppMethodBeat.o(355147);
          return;
          paramc = this.Dak;
          if (paramc != null) {
            paramc.cyW();
          }
        }
      }
    }
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(355122);
    super.unMount();
    FinderLiveGiftSendBtn localFinderLiveGiftSendBtn = this.Dco;
    localFinderLiveGiftSendBtn.evq();
    com.tencent.mm.ae.d.H(localFinderLiveGiftSendBtn.DNO);
    AppMethodBeat.o(355122);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin$ISendGiftCallback;", "", "sendGiftCallback", "", "success", "", "errCode", "", "errType", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin$ISendGiftCallback$ErrorType;", "rewardGiftId", "", "balance", "", "cnt", "comboId", "errMsg", "(ZILcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin$ISendGiftCallback$ErrorType;Ljava/lang/String;Ljava/lang/Long;ILjava/lang/String;Ljava/lang/String;)V", "ErrorType", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, int paramInt1, b paramb, String paramString1, Long paramLong, int paramInt2, String paramString2, String paramString3);
    
    @Metadata(k=3, mv={1, 5, 1}, xi=48)
    public static final class a {}
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin$ISendGiftCallback$ErrorType;", "", "(Ljava/lang/String;I)V", "OK", "NETWORK", "WECOIN", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static enum b
    {
      static
      {
        AppMethodBeat.i(355218);
        DcC = new b("OK", 0);
        DcD = new b("NETWORK", 1);
        DcE = new b("WECOIN", 2);
        DcF = new b[] { DcC, DcD, DcE };
        AppMethodBeat.o(355218);
      }
      
      private b() {}
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(ax paramax)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(ax paramax)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin$sendGift$1", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin$ISendGiftCallback;", "sendGiftCallback", "", "success", "", "errCode", "", "errType", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin$ISendGiftCallback$ErrorType;", "rewardGiftId", "", "balance", "", "cnt", "comboId", "errMsg", "(ZILcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin$ISendGiftCallback$ErrorType;Ljava/lang/String;Ljava/lang/Long;ILjava/lang/String;Ljava/lang/String;)V", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements ax.a
  {
    e(ax paramax, String paramString) {}
    
    public final void a(boolean paramBoolean, int paramInt1, ax.a.b paramb, String paramString1, Long paramLong, int paramInt2, String paramString2, String paramString3)
    {
      AppMethodBeat.i(355585);
      s.u(paramb, "errType");
      Log.i(ax.f(this.Dcz), "sendGiftCallback, success:" + paramBoolean + " errCode:" + paramInt1 + " errType:" + paramb + ",rewardGiftId:" + paramString1 + ",balance:" + paramLong + ",cnt:" + paramInt2 + ",comboId:" + paramString2);
      if (paramBoolean)
      {
        ax.a(this.Dcz, paramLong);
        if (ax.k(this.Dcz).getLiveRole() == 0)
        {
          paramb = ak.CHI;
          paramLong = ax.k(this.Dcz);
          paramb = (f)this.Dcz.business(f.class);
          if (paramb != null) {
            break label228;
          }
        }
        label228:
        for (paramb = null;; paramb = paramb.liveInfo)
        {
          ak.a(paramLong, paramb.liveId, ak.b.CHO);
          k.Doi.a(q.cc.DEt, paramString1, paramInt2);
          b.b.a(ax.k(this.Dcz), b.c.ncL);
          paramLong = this.Dcz;
          paramb = paramString1;
          if (paramString1 == null) {
            paramb = this.DcG;
          }
          ax.a(paramLong, paramb, paramString2, paramInt2);
          AppMethodBeat.o(355585);
          return;
        }
      }
      ax.l(this.Dcz);
      switch (a.$EnumSwitchMapping$0[paramb.ordinal()])
      {
      }
      for (;;)
      {
        AppMethodBeat.o(355585);
        return;
        switch (paramInt1)
        {
        case 10001: 
        case 10002: 
        default: 
          ax.a(this.Dcz);
          AppMethodBeat.o(355585);
          return;
        case 10003: 
          if (this.DcH)
          {
            ax.a(this.Dcz, paramString2);
            AppMethodBeat.o(355585);
            return;
          }
          break;
        case 10000: 
          AppMethodBeat.o(355585);
          return;
          ax.b(this.Dcz, paramString3);
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(ax paramax, String paramString)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ah>
  {
    g(ax paramax)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<ah>
  {
    h(ax paramax, String paramString)
    {
      super();
    }
    
    private static final void a(ax paramax, Context paramContext, boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(355682);
      s.u(paramax, "this$0");
      if (ax.k(paramax).getLiveRole() == 0) {
        k.Doi.a(q.cc.DEw, "", 0);
      }
      if ((paramContext instanceof FragmentActivity))
      {
        paramString = ax.getFinderLiveAssistant();
        if (paramString != null) {
          break label63;
        }
      }
      label63:
      for (paramContext = null;; paramContext = paramString.a((FragmentActivity)paramContext, 2, (kotlin.g.a.a)new a(paramax)))
      {
        ax.a(paramax, paramContext);
        AppMethodBeat.o(355682);
        return;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(ax paramax)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<ah>
  {
    i(ax paramax)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<ah>
  {
    j(ax paramax, String paramString1, String paramString2, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.ax
 * JD-Core Version:    0.7.0.1
 */
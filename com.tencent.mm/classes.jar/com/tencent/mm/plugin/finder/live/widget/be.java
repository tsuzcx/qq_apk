package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.am.b.a;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.model.ap;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.plugin.ax.a;
import com.tencent.mm.plugin.finder.live.plugin.ax.a.b;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.protocal.protobuf.bha;
import com.tencent.mm.protocal.protobuf.bhf;
import com.tencent.mm.protocal.protobuf.bht;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.ble;
import com.tencent.mm.protocal.protobuf.cbo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.widget.a.h;
import com.tencent.mm.ui.widget.a.h.b;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamPaymentBottomPage;", "Lcom/tencent/mm/ui/widget/dialog/MMCustomHalfBottomDialog$CustomBottomSheetPage;", "()V", "assistant", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "callback", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamPaymentBottomPage$Callback;", "checkAgain", "", "lastDoPaymentTime", "", "payValue", "", "rootView", "Landroid/view/View;", "weCoinArrow", "weCoinBg", "Landroid/view/ViewGroup;", "weCoinIcon", "weCoinProgressBar", "Landroid/widget/ProgressBar;", "weCoinValue", "Landroid/widget/TextView;", "wecoinBalanceRequestId", "doPayment", "", "getView", "root", "onPagePushed", "showConsumeFailDialog", "errMsg", "", "showRechargeDialog", "isNotEnough", "showWeCoinBalance", "balance", "showWeCoinNotEnoughDialog", "update", "value", "updateWeCoinBalance", "Callback", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class be
  extends h.b
{
  public static final be.b EuS;
  com.tencent.mm.plugin.finder.live.plugin.b CwG;
  private long Dam;
  private View EuT;
  private TextView EuU;
  private View EuV;
  private ViewGroup EuW;
  private ProgressBar EuX;
  a EuY;
  boolean EuZ;
  int Eva;
  ap Evb;
  private long Evc;
  private View rootView;
  
  static
  {
    AppMethodBeat.i(361470);
    EuS = new be.b((byte)0);
    AppMethodBeat.o(361470);
  }
  
  private static final ah a(ViewGroup paramViewGroup, be parambe, b.a parama)
  {
    Object localObject = null;
    AppMethodBeat.i(361383);
    s.u(paramViewGroup, "$root");
    s.u(parambe, "this$0");
    bhf localbhf;
    label84:
    label105:
    int i;
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      localbhf = ((bht)parama.ott).ZQZ;
      StringBuilder localStringBuilder = new StringBuilder("click gameTeamInfo status:");
      if (localbhf == null)
      {
        parama = null;
        localStringBuilder = localStringBuilder.append(parama).append(", in_teaming_up:");
        if (localbhf != null) {
          break label180;
        }
        parama = null;
        localStringBuilder = localStringBuilder.append(parama).append(' ');
        if (localbhf != null) {
          break label192;
        }
        parama = localObject;
        Log.i("MicroMsg.FinderLiveVisitorGameTeamPaymentBottomPage", parama);
        if (localbhf == null) {
          break label234;
        }
        parama = localbhf.ZQG;
        if (parama != null) {
          break label219;
        }
        i = 0;
        label136:
        if (i <= 0) {
          break label227;
        }
        aa.dc(paramViewGroup.getContext(), paramViewGroup.getContext().getString(p.h.Cha));
      }
    }
    for (;;)
    {
      paramViewGroup = ah.aiuX;
      AppMethodBeat.o(361383);
      return paramViewGroup;
      parama = Integer.valueOf(localbhf.status);
      break;
      label180:
      parama = Integer.valueOf(localbhf.ZOK);
      break label84;
      label192:
      cbo localcbo = localbhf.ZQG;
      parama = localObject;
      if (localcbo == null) {
        break label105;
      }
      parama = Integer.valueOf(localcbo.aakR);
      break label105;
      label219:
      i = parama.aakR;
      break label136;
      label227:
      parambe.eBG();
      continue;
      label234:
      paramViewGroup = bf.Evf;
      Log.i(bf.access$getTAG$cp(), "resp.game_team_info null");
      continue;
      aa.makeText(paramViewGroup.getContext(), (CharSequence)paramViewGroup.getContext().getString(p.h.finder_live_game_prepare_error), 0).show();
    }
  }
  
  private static final void a(be parambe, View paramView)
  {
    AppMethodBeat.i(361369);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parambe);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamPaymentBottomPage", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parambe, "this$0");
    parambe.jHR();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamPaymentBottomPage", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(361369);
  }
  
  private static final void a(be parambe, ViewGroup paramViewGroup, View paramView)
  {
    AppMethodBeat.i(361393);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parambe);
    localb.cH(paramViewGroup);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamPaymentBottomPage", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parambe, "this$0");
    s.u(paramViewGroup, "$root");
    if (parambe.EuZ)
    {
      paramView = parambe.CwG;
      if (paramView != null)
      {
        localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        localObject = paramViewGroup.getContext();
        s.s(localObject, "root.context");
        com.tencent.mm.plugin.finder.live.utils.a.J((Context)localObject, true);
        long l1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)paramView.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN;
        long l2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)paramView.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId;
        localObject = com.tencent.mm.bx.b.cX(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)paramView.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZp);
        s.s(localObject, "copyFrom(basePlugin.busi…:class.java).liveCookies)");
        new com.tencent.mm.plugin.finder.live.cgi.m(l1, l2, (com.tencent.mm.bx.b)localObject, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)paramView.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).nonceId).bFJ().g(new be..ExternalSyntheticLambda4(paramViewGroup, parambe));
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamPaymentBottomPage", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(361393);
      return;
      parambe.eBG();
    }
  }
  
  private static final void a(be parambe, com.tencent.mm.plugin.wallet.wecoin.a.e parame)
  {
    AppMethodBeat.i(361408);
    s.u(parambe, "this$0");
    parame = parambe.JfN;
    if (parame != null) {
      parame.a((h.b)parambe);
    }
    parambe = parambe.JfN;
    if (parambe != null) {
      parambe.dDn();
    }
    AppMethodBeat.o(361408);
  }
  
  private final void awZ(String paramString)
  {
    AppMethodBeat.i(361324);
    d.uiThread((kotlin.g.a.a)new d(paramString, this));
    AppMethodBeat.o(361324);
  }
  
  private static final void b(be parambe, View paramView)
  {
    AppMethodBeat.i(361400);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parambe);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamPaymentBottomPage", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parambe, "this$0");
    parambe.sJ(false);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamPaymentBottomPage", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(361400);
  }
  
  private final void eBG()
  {
    AppMethodBeat.i(361319);
    if (this.Evc != 0L)
    {
      AppMethodBeat.o(361319);
      return;
    }
    this.Evc = System.currentTimeMillis();
    ap localap = this.Evb;
    if (localap != null)
    {
      Object localObject1 = this.rootView;
      Object localObject2;
      if (localObject1 == null)
      {
        localObject1 = null;
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = MMApplicationContext.getContext();
        }
        localObject1 = this.CwG;
        if (localObject1 != null) {
          break label91;
        }
      }
      label91:
      for (localObject1 = null;; localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.plugin.b)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class))
      {
        if (localObject1 != null) {
          break label105;
        }
        AppMethodBeat.o(361319);
        return;
        localObject1 = ((View)localObject1).getContext();
        break;
      }
      label105:
      localObject1 = this.CwG;
      if (localObject1 == null) {}
      for (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e locale = null; locale == null; locale = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.plugin.b)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class))
      {
        AppMethodBeat.o(361319);
        return;
      }
      final ble localble = new ble();
      localObject1 = locale.Edg;
      if (localObject1 == null)
      {
        localObject1 = null;
        localble.ZUh = ((String)localObject1);
        localble.BZj = this.Eva;
        localObject1 = locale.CFy;
        if (localObject1 != null) {
          break label336;
        }
        localObject1 = null;
        label192:
        localble.ZUi = ((String)localObject1);
        Log.i("MicroMsg.FinderLiveVisitorGameTeamPaymentBottomPage", "doPayment " + locale.Edy + ' ' + this.Eva + ' ' + localble.ZUh + ' ' + localble.ZUi);
        localObject1 = this.EuX;
        if ((localObject1 == null) || (((ProgressBar)localObject1).getVisibility() != 0)) {
          break label344;
        }
      }
      label336:
      label344:
      for (int i = 1;; i = 0)
      {
        if ((i != 0) || (locale.Edy >= this.Eva)) {
          break label349;
        }
        this.Evc = 0L;
        eBH();
        AppMethodBeat.o(361319);
        return;
        localObject1 = ((bhf)localObject1).ZQG;
        if (localObject1 == null)
        {
          localObject1 = null;
          break;
        }
        localObject1 = ((cbo)localObject1).ZUh;
        break;
        localObject1 = ((bha)localObject1).Idh;
        break label192;
      }
      label349:
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      s.s(localObject2, "context");
      com.tencent.mm.plugin.finder.live.utils.a.J((Context)localObject2, true);
      localap.a((Context)localObject2, null, 0, 0, null, "", 2, com.tencent.mm.bx.b.cX(localble.toByteArray()), (ax.a)new c((Context)localObject2, localble, this));
    }
    AppMethodBeat.o(361319);
  }
  
  private final void eBH()
  {
    AppMethodBeat.i(361340);
    d.uiThread((kotlin.g.a.a)new f(this));
    AppMethodBeat.o(361340);
  }
  
  private final void eBI()
  {
    AppMethodBeat.i(361362);
    this.Dam = System.currentTimeMillis();
    ap localap = this.Evb;
    if (localap != null) {
      localap.a(this.Dam, (kotlin.g.a.m)new g(this));
    }
    AppMethodBeat.o(361362);
  }
  
  private final void sJ(boolean paramBoolean)
  {
    AppMethodBeat.i(361355);
    Object localObject1 = this.rootView;
    Object localObject2;
    if (localObject1 == null)
    {
      localObject1 = null;
      if ((localObject1 instanceof FragmentActivity))
      {
        localObject2 = this.JfN;
        if (localObject2 != null)
        {
          ((h)localObject2).GwS = true;
          ((h)localObject2).cyW();
        }
        localObject2 = this.Evb;
        if (localObject2 != null)
        {
          localObject1 = (FragmentActivity)localObject1;
          if (!paramBoolean) {
            break label123;
          }
        }
      }
    }
    label123:
    for (int i = 12;; i = 11)
    {
      localObject1 = ((ap)localObject2).a((FragmentActivity)localObject1, i, (kotlin.g.a.a)new e(this));
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.wallet.wecoin.a.e)localObject1).a(new be..ExternalSyntheticLambda3(this));
      }
      AppMethodBeat.o(361355);
      return;
      localObject1 = ((View)localObject1).getContext();
      break;
    }
  }
  
  public final View E(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(361518);
    s.u(paramViewGroup, "root");
    View localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(p.f.CcI, paramViewGroup, false);
    localView.findViewById(p.e.finder_live_back_btn).setOnClickListener(new be..ExternalSyntheticLambda1(this));
    Object localObject;
    if (localView != null)
    {
      localObject = (TextView)localView.findViewById(p.e.BZj);
      if (localObject != null)
      {
        aw localaw = aw.Gjk;
        aw.f((TextView)localObject, true);
      }
    }
    if (localView != null)
    {
      localObject = localView.findViewById(p.e.BKV);
      if (localObject != null) {
        ((View)localObject).setOnClickListener(new be..ExternalSyntheticLambda2(this, paramViewGroup));
      }
    }
    this.EuT = localView.findViewById(p.e.BLN);
    this.EuV = localView.findViewById(p.e.BLL);
    this.EuU = ((TextView)localView.findViewById(p.e.BLP));
    this.EuW = ((ViewGroup)localView.findViewById(p.e.BLM));
    this.EuX = ((ProgressBar)localView.findViewById(p.e.BLO));
    localView.findViewById(p.e.BLM).setOnClickListener(new be..ExternalSyntheticLambda0(this));
    this.rootView = localView;
    s.s(localView, "rootView");
    AppMethodBeat.o(361518);
    return localView;
  }
  
  public final void eAM()
  {
    AppMethodBeat.i(361526);
    this.Evc = 0L;
    Object localObject = this.rootView;
    if (localObject == null) {}
    for (localObject = null;; localObject = (TextView)((View)localObject).findViewById(p.e.BZj))
    {
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)String.valueOf(this.Eva));
      }
      eBI();
      AppMethodBeat.o(361526);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamPaymentBottomPage$Callback;", "", "onPaid", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void eBJ();
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamPaymentBottomPage$doPayment$1$1", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin$ISendGiftCallback;", "sendGiftCallback", "", "success", "", "errCode", "", "errType", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin$ISendGiftCallback$ErrorType;", "rewardGiftId", "", "balance", "", "cnt", "comboId", "errMsg", "(ZILcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin$ISendGiftCallback$ErrorType;Ljava/lang/String;Ljava/lang/Long;ILjava/lang/String;Ljava/lang/String;)V", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements ax.a
  {
    c(Context paramContext, ble paramble, be parambe) {}
    
    public final void a(boolean paramBoolean, int paramInt1, ax.a.b paramb, String paramString1, Long paramLong, int paramInt2, String paramString2, String paramString3)
    {
      AppMethodBeat.i(361451);
      s.u(paramb, "errType");
      paramString1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      paramString1 = this.$context;
      s.s(paramString1, "context");
      com.tencent.mm.plugin.finder.live.utils.a.J(paramString1, false);
      Log.i("MicroMsg.FinderLiveVisitorGameTeamPaymentBottomPage", "sendGiftCallback, success:" + paramBoolean + " errCode:" + paramInt1 + " errType:" + paramb + " balance:" + paramLong);
      if (paramBoolean)
      {
        k.a(k.Doi, 25, localble.BZj, null, 8);
        if (paramLong != null)
        {
          paramb = be.f(jdField_this);
          if (paramb != null)
          {
            paramString1 = b.c.ndu;
            paramString2 = new Bundle();
            paramString2.putLong("PARAM_FINDER_LIVE_GIFT_UPDATE_WECOIN", paramLong.longValue());
            paramLong = ah.aiuX;
            paramb.statusChange(paramString1, paramString2);
          }
        }
        for (;;)
        {
          paramb = be.g(jdField_this);
          if (paramb == null) {
            break;
          }
          paramb.eBJ();
          AppMethodBeat.o(361451);
          return;
          paramb = be.f(jdField_this);
          if (paramb != null) {
            paramb.statusChange(b.c.ndu, null);
          }
        }
      }
      k.Doi.c(26, localble.BZj, "errCode:" + paramInt1 + " errType:" + paramb + " errMsg:" + paramString3, null);
      be.h(jdField_this);
      switch (a.$EnumSwitchMapping$0[paramb.ordinal()])
      {
      default: 
        be.a(jdField_this, paramString3);
        AppMethodBeat.o(361451);
        return;
      case 1: 
        switch (paramInt1)
        {
        case 10001: 
        case 10002: 
        default: 
          be.a(jdField_this);
          AppMethodBeat.o(361451);
          return;
        case 10003: 
          be.i(jdField_this);
          AppMethodBeat.o(361451);
          return;
        }
        AppMethodBeat.o(361451);
        return;
      }
      AppMethodBeat.o(361451);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(String paramString, be parambe)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(be parambe)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(be parambe)
    {
      super();
    }
    
    private static final void a(be parambe, boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(361048);
      s.u(parambe, "this$0");
      be.c(parambe);
      AppMethodBeat.o(361048);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "wecoinBalance", "", "requestId"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.m<Long, Long, ah>
  {
    g(be parambe)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.be
 * JD-Core Version:    0.7.0.1
 */
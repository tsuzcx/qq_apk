package com.tencent.mm.plugin.finder.live.plugin;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.b.b.b;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.live.model.r.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.g;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.report.q.bu;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.blf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveChargePayPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "costContainer", "Landroid/view/View;", "getCostContainer", "()Landroid/view/View;", "setCostContainer", "(Landroid/view/View;)V", "costInnerContainer", "getCostInnerContainer", "setCostInnerContainer", "costTips", "Landroid/widget/TextView;", "getCostTips", "()Landroid/widget/TextView;", "setCostTips", "(Landroid/widget/TextView;)V", "countDownManager", "Lcom/tencent/mm/plugin/finder/replay/FinderLiveFreeTimeManager;", "getCountDownManager", "()Lcom/tencent/mm/plugin/finder/replay/FinderLiveFreeTimeManager;", "setCountDownManager", "(Lcom/tencent/mm/plugin/finder/replay/FinderLiveFreeTimeManager;)V", "value", "", "enableCountDown", "getEnableCountDown", "()Z", "setEnableCountDown", "(Z)V", "freeTimeTips", "getFreeTimeTips", "setFreeTimeTips", "freeTimeToWatch", "", "getFreeTimeToWatch", "()I", "setFreeTimeToWatch", "(I)V", "purchasePrice", "getPurchasePrice", "setPurchasePrice", "resetStatusTask", "Ljava/lang/Runnable;", "totalFreeTimeToWatch", "getTotalFreeTimeToWatch", "setTotalFreeTimeToWatch", "wecoinCost", "getWecoinCost", "setWecoinCost", "wecoinIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getWecoinIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setWecoinIcon", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "canClearScreen", "finishCountDown", "", "getEnterTime", "", "initView", "notifyFeedPaySuccess", "pay", "liveId", "objectId", "comboId", "", "giftId", "price", "cnt", "(JJLjava/lang/String;Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "payForLive", "reportClick", "reportPaySuc", "setWeCoinGroupVisible", "visible", "show", "freeTomeToWatch", "aboveNavigationBar", "showConsumeFailDialog", "errMsg", "showWecoinInfo", "scene", "showWecoinNotEnoughDialog", "unMount", "updateCostGroup", "userClick", "resetStatus", "updateFreeTimeGroup", "updatePlayProgress", "offset", "total", "updateTimer", "updateWecoinBalance", "Lkotlin/Pair;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "visibleInCurrentLiveMode", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ag
  extends b
{
  private static final float CXG;
  public static final ag.a CXt;
  public int CXA;
  private int CXB;
  int CXC;
  public com.tencent.mm.plugin.finder.replay.a CXD;
  private boolean CXE;
  private final Runnable CXF;
  private TextView CXu;
  private WeImageView CXv;
  private TextView CXw;
  private View CXx;
  private View CXy;
  private TextView CXz;
  private kotlinx.coroutines.aq coroutineScope;
  private final com.tencent.mm.live.b.b nfT;
  
  static
  {
    AppMethodBeat.i(355886);
    CXt = new ag.a((byte)0);
    CXG = bf.bf(MMApplicationContext.getContext()).x / 6.0F;
    AppMethodBeat.o(355886);
  }
  
  private ag(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb, null);
    AppMethodBeat.i(355699);
    this.nfT = paramb;
    this.coroutineScope = ar.kBZ();
    this.CXF = new ag..ExternalSyntheticLambda3(this);
    AppMethodBeat.o(355699);
  }
  
  private static final void a(ag paramag)
  {
    AppMethodBeat.i(355780);
    s.u(paramag, "this$0");
    paramag.ab(false, true);
    AppMethodBeat.o(355780);
  }
  
  private static final void a(ag paramag, View paramView)
  {
    AppMethodBeat.i(355767);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramag);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveChargePayPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramag, "this$0");
    paramView = aw.Gjk;
    if (aw.isFastClick())
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveChargePayPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(355767);
      return;
    }
    paramView = paramag.CXz;
    if (paramView == null) {
      paramView = null;
    }
    for (;;)
    {
      if (s.p(paramView, paramag.mJe.getContext().getResources().getString(p.h.Cji)))
      {
        paramView = h.baE().ban().get(at.a.adbb, Boolean.FALSE);
        if (paramView == null)
        {
          paramag = new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
          AppMethodBeat.o(355767);
          throw paramag;
          paramView = paramView.getText();
        }
        else if (((Boolean)paramView).booleanValue())
        {
          paramag.epN();
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveChargePayPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(355767);
      return;
      paramView = paramag.mJe.getContext();
      s.s(paramView, "root.context");
      paramView = new com.tencent.mm.plugin.finder.replay.widget.a(paramView, false);
      localObject1 = paramView.getContext().getResources().getString(p.h.Cjd);
      s.s(localObject1, "context.resources.getStr…ive_charge_license_desc1)");
      localObject2 = paramView.getContext().getResources().getString(p.h.Cjb);
      s.s(localObject2, "context.resources.getStr…_charge_license_content1)");
      paramView.b((String)localObject1, (String)localObject2, (kotlin.g.a.a)new ag.b(paramag));
      continue;
      a(paramag, true, 2);
    }
  }
  
  private static final void a(com.tencent.mm.plugin.wallet.wecoin.a.e parame) {}
  
  private final void ab(boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 0;
    Object localObject1 = null;
    AppMethodBeat.i(355740);
    Object localObject2 = this.CXw;
    if (localObject2 != null) {
      ((TextView)localObject2).setText((CharSequence)String.valueOf(this.CXC));
    }
    int i;
    label93:
    label101:
    int k;
    if (paramBoolean1)
    {
      localObject2 = this.CXy;
      if (localObject2 != null)
      {
        localObject1 = this.CXz;
        if (localObject1 == null)
        {
          localObject1 = null;
          if (s.p(localObject1, this.mJe.getContext().getResources().getString(p.h.Cji))) {
            break label295;
          }
          i = 1;
          if (i == 0) {
            break label300;
          }
          localObject1 = localObject2;
          if (localObject1 == null) {
            break label897;
          }
          localObject2 = this.CXz;
          if (localObject2 != null) {
            ((TextView)localObject2).setText((CharSequence)this.mJe.getContext().getResources().getString(p.h.Cji));
          }
          rl(false);
          if ((!isLandscape()) && (this.CXB <= 0)) {
            break label325;
          }
          k = ((View)localObject1).getWidth();
          localObject2 = this.CXv;
          if (localObject2 != null) {
            break label306;
          }
          i = 0;
          label180:
          localObject2 = this.CXw;
          if (localObject2 != null) {
            break label315;
          }
          label191:
          localObject2 = aw.Gjk;
          aw.a((View)localObject1, k, k - i - j, 150L, null, 16);
        }
        for (;;)
        {
          ((View)localObject1).postDelayed(this.CXF, 10000L);
          if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcR != 2)
          {
            localObject1 = com.tencent.mm.plugin.finder.live.report.k.Doi;
            localObject1 = q.bu.DDg;
            long l = System.currentTimeMillis();
            localObject2 = com.tencent.mm.plugin.finder.live.report.k.Doi;
            com.tencent.mm.plugin.finder.live.report.k.a((q.bu)localObject1, 1, l - com.tencent.mm.plugin.finder.live.report.k.etq());
          }
          AppMethodBeat.o(355740);
          return;
          localObject1 = ((TextView)localObject1).getText();
          break;
          label295:
          i = 0;
          break label93;
          label300:
          localObject1 = null;
          break label101;
          label306:
          i = ((WeImageView)localObject2).getWidth();
          break label180;
          label315:
          j = ((TextView)localObject2).getWidth();
          break label191;
          label325:
          ObjectAnimator.ofFloat(localObject1, "translationX", new float[] { -1.0F * CXG, 0.0F }).start();
        }
      }
    }
    else
    {
      if (this.CXB <= 0)
      {
        if (paramBoolean2)
        {
          localObject1 = this.CXz;
          if (localObject1 != null) {
            ((TextView)localObject1).setText((CharSequence)this.mJe.getContext().getResources().getString(p.h.Cjh));
          }
          c(this);
          AppMethodBeat.o(355740);
          return;
        }
        localObject1 = this.CXz;
        if (localObject1 == null)
        {
          localObject1 = null;
          if (!s.p(localObject1, this.mJe.getContext().getResources().getString(p.h.Cji)))
          {
            localObject1 = this.CXz;
            if (localObject1 != null) {
              ((TextView)localObject1).setText((CharSequence)this.mJe.getContext().getResources().getString(p.h.Cjh));
            }
          }
          if (!isLandscape()) {
            break label611;
          }
          localObject1 = this.CXx;
          if (localObject1 != null) {
            break label595;
          }
          localObject1 = null;
          label507:
          if (!(localObject1 instanceof ConstraintLayout.LayoutParams)) {
            break label605;
          }
          localObject1 = (ConstraintLayout.LayoutParams)localObject1;
          label522:
          if (localObject1 != null) {
            ((ConstraintLayout.LayoutParams)localObject1).width = -2;
          }
          localObject1 = this.CXx;
          if (localObject1 != null) {
            ((View)localObject1).requestLayout();
          }
        }
        for (;;)
        {
          localObject1 = this.CXu;
          if (localObject1 == null) {
            break label897;
          }
          ((TextView)localObject1).postDelayed(new ag..ExternalSyntheticLambda2(this), 100L);
          AppMethodBeat.o(355740);
          return;
          localObject1 = ((TextView)localObject1).getText();
          break;
          label595:
          localObject1 = ((View)localObject1).getLayoutParams();
          break label507;
          label605:
          localObject1 = null;
          break label522;
          label611:
          localObject1 = this.CXx;
          if (localObject1 == null)
          {
            localObject1 = null;
            label625:
            if (!(localObject1 instanceof ConstraintLayout.LayoutParams)) {
              break label713;
            }
          }
          label713:
          for (localObject1 = (ConstraintLayout.LayoutParams)localObject1;; localObject1 = null)
          {
            if (localObject1 != null) {
              ((ConstraintLayout.LayoutParams)localObject1).width = -1;
            }
            localObject1 = this.CXx;
            if (localObject1 == null) {
              break;
            }
            i = ((View)localObject1).getWidth();
            localObject2 = this.mJe.getLayoutParams();
            if (localObject2 != null) {
              break label719;
            }
            localObject1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(355740);
            throw ((Throwable)localObject1);
            localObject1 = ((View)localObject1).getLayoutParams();
            break label625;
          }
          label719:
          localObject2 = (ViewGroup.MarginLayoutParams)localObject2;
          j = bf.bf(MMApplicationContext.getContext()).x;
          k = ((ViewGroup.MarginLayoutParams)localObject2).leftMargin;
          int m = ((ViewGroup.MarginLayoutParams)localObject2).rightMargin;
          localObject2 = aw.Gjk;
          aw.a((View)localObject1, i, j - k - m, 0L, null, 24);
        }
      }
      if (paramBoolean2)
      {
        localObject1 = this.CXz;
        if (localObject1 != null) {
          ((TextView)localObject1).setText((CharSequence)this.mJe.getContext().getResources().getString(p.h.Cjg));
        }
        c(this);
        AppMethodBeat.o(355740);
        return;
      }
      localObject2 = this.CXz;
      if (localObject2 != null) {
        break label904;
      }
    }
    for (;;)
    {
      if (!s.p(localObject1, this.mJe.getContext().getResources().getString(p.h.Cji)))
      {
        localObject1 = this.CXz;
        if (localObject1 != null) {
          ((TextView)localObject1).setText((CharSequence)this.mJe.getContext().getResources().getString(p.h.Cjg));
        }
      }
      label897:
      AppMethodBeat.o(355740);
      return;
      label904:
      localObject1 = ((TextView)localObject2).getText();
    }
  }
  
  private static final void b(ag paramag)
  {
    int k = 0;
    AppMethodBeat.i(355785);
    s.u(paramag, "this$0");
    View localView = paramag.CXy;
    int m;
    Object localObject;
    int i;
    if (localView != null)
    {
      m = localView.getWidth();
      localObject = paramag.CXv;
      if (localObject != null) {
        break label163;
      }
      i = 0;
      localObject = paramag.CXw;
      if (localObject != null) {
        break label172;
      }
      j = 0;
      label59:
      i = m + i + j;
      paramag = paramag.CXw;
      if (paramag != null) {
        break label181;
      }
      paramag = null;
      label77:
      if (!(paramag instanceof ViewGroup.MarginLayoutParams)) {
        break label189;
      }
      paramag = (ViewGroup.MarginLayoutParams)paramag;
      label89:
      if (paramag == null) {
        break label194;
      }
      paramag = Integer.valueOf(paramag.leftMargin);
      j = k;
      if (((Number)paramag).intValue() > 0) {
        j = 1;
      }
      if (j == 0) {
        break label194;
      }
      label119:
      if (paramag != null) {
        break label199;
      }
    }
    label163:
    label172:
    label181:
    label189:
    label194:
    label199:
    for (int j = MMApplicationContext.getContext().getResources().getDimensionPixelOffset(p.c.Edge_0_25A);; j = paramag.intValue())
    {
      paramag = aw.Gjk;
      aw.a(localView, m, i + j, 150L, null, 16);
      AppMethodBeat.o(355785);
      return;
      i = ((WeImageView)localObject).getWidth();
      break;
      j = ((TextView)localObject).getWidth();
      break label59;
      paramag = paramag.getLayoutParams();
      break label77;
      paramag = null;
      break label89;
      paramag = null;
      break label119;
    }
  }
  
  private static final void c(ag paramag)
  {
    AppMethodBeat.i(355792);
    paramag.rl(true);
    paramag.mJe.post(new ag..ExternalSyntheticLambda4(paramag));
    AppMethodBeat.o(355792);
  }
  
  private static final void d(ag paramag)
  {
    AppMethodBeat.i(355797);
    s.u(paramag, "this$0");
    paramag = paramag.CXu;
    if (paramag != null) {
      paramag.setVisibility(8);
    }
    AppMethodBeat.o(355797);
  }
  
  private final void epN()
  {
    AppMethodBeat.i(355717);
    Log.printInfoStack("FinderLiveChargePayPlugin", "payForLive", new Object[0]);
    j.a(this.coroutineScope, null, null, (m)new d(this, null), 3);
    AppMethodBeat.o(355717);
  }
  
  private final void epO()
  {
    AppMethodBeat.i(355758);
    Object localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    com.tencent.mm.plugin.finder.live.utils.a.hQ("FinderLiveChargePayPlugin", s.X("updateFreeTimeGroup freeTomeToWatch:", Integer.valueOf(this.CXB)));
    if (this.CXB <= 0)
    {
      localObject = this.CXu;
      if (localObject != null)
      {
        ((TextView)localObject).setText((CharSequence)this.mJe.getContext().getResources().getString(p.h.CiX));
        AppMethodBeat.o(355758);
      }
    }
    else
    {
      localObject = this.CXu;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
      localObject = this.CXu;
      if (localObject != null)
      {
        Resources localResources = this.mJe.getContext().getResources();
        int i = p.h.Ckv;
        r.a locala = com.tencent.mm.live.model.r.mZi;
        ((TextView)localObject).setText((CharSequence)localResources.getString(i, new Object[] { r.a.I(this.CXB, ":") }));
      }
    }
    AppMethodBeat.o(355758);
  }
  
  private final void rl(boolean paramBoolean)
  {
    AppMethodBeat.i(355724);
    Object localObject;
    if (paramBoolean)
    {
      localObject = this.CXv;
      if (localObject != null) {
        ((WeImageView)localObject).setVisibility(0);
      }
      localObject = this.CXw;
      if (localObject != null)
      {
        ((TextView)localObject).setVisibility(0);
        AppMethodBeat.o(355724);
      }
    }
    else
    {
      localObject = this.CXv;
      if (localObject != null) {
        ((WeImageView)localObject).setVisibility(8);
      }
      localObject = this.CXw;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
    }
    AppMethodBeat.o(355724);
  }
  
  public final void aC(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(355952);
    this.CXB = paramInt;
    Object localObject = com.tencent.mm.plugin.finder.live.viewmodel.data.business.d.Eci;
    this.CXA = com.tencent.mm.plugin.finder.live.viewmodel.data.business.d.eyn();
    localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.d)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.d.class)).eyi();
    int i;
    if (localObject == null)
    {
      i = 0;
      this.CXC = i;
      if (paramBoolean)
      {
        localObject = this.mJe.getLayoutParams();
        if (!(localObject instanceof ViewGroup.MarginLayoutParams)) {
          break label296;
        }
      }
    }
    label296:
    for (localObject = (ViewGroup.MarginLayoutParams)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = (this.mJe.getContext().getResources().getDimensionPixelOffset(p.c.Edge_2A) + bf.bk(MMApplicationContext.getContext()));
      }
      this.CXu = ((TextView)this.mJe.findViewById(p.e.BUO));
      this.CXv = ((WeImageView)this.mJe.findViewById(p.e.BCb));
      this.CXw = ((TextView)this.mJe.findViewById(p.e.BCc));
      this.CXx = this.mJe.findViewById(p.e.BCa);
      localObject = this.CXx;
      if (localObject != null) {
        ((View)localObject).setOnClickListener(new ag..ExternalSyntheticLambda0(this));
      }
      this.CXz = ((TextView)this.mJe.findViewById(p.e.BCe));
      this.CXy = this.mJe.findViewById(p.e.BCd);
      tO(0);
      rk(true);
      a(this, false, 3);
      epO();
      localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.a((b)this, false);
      Log.i("FinderLiveChargePayPlugin", s.X("show freeTomeToWatch:", Integer.valueOf(paramInt)));
      AppMethodBeat.o(355952);
      return;
      i = ((blf)localObject).ZUm;
      break;
    }
  }
  
  public final boolean eoI()
  {
    return true;
  }
  
  public final boolean eoJ()
  {
    AppMethodBeat.i(355985);
    if ((((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcR == 1) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcR == 2))
    {
      AppMethodBeat.o(355985);
      return true;
    }
    AppMethodBeat.o(355985);
    return false;
  }
  
  public final void hG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(355961);
    if (!this.CXE)
    {
      AppMethodBeat.o(355961);
      return;
    }
    this.CXB = paramInt1;
    this.CXA = paramInt2;
    if ((paramInt1 <= 0) && (!isFinished()))
    {
      rk(false);
      b.b.a(this.nfT, b.c.nfC);
    }
    a(this, false, 3);
    epO();
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    com.tencent.mm.plugin.finder.live.utils.a.hQ("FinderLiveChargePayPlugin", "updateTimer freeTomeToWatch:" + paramInt1 + " finish:" + isFinished());
    AppMethodBeat.o(355961);
  }
  
  public final void rk(boolean paramBoolean)
  {
    AppMethodBeat.i(355937);
    Log.i("FinderLiveChargePayPlugin", s.X("enableCountDown:", Boolean.valueOf(paramBoolean)));
    this.CXE = paramBoolean;
    AppMethodBeat.o(355937);
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(355972);
    View localView = this.CXy;
    if (localView != null) {
      localView.removeCallbacks(this.CXF);
    }
    AppMethodBeat.o(355972);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveChargePayPlugin$pay$2$1", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin$ISendGiftCallback;", "sendGiftCallback", "", "success", "", "errCode", "", "errType", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin$ISendGiftCallback$ErrorType;", "rewardGiftId", "", "balance", "", "cnt", "comboId", "errMsg", "(ZILcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin$ISendGiftCallback$ErrorType;Ljava/lang/String;Ljava/lang/Long;ILjava/lang/String;Ljava/lang/String;)V", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements ax.a
  {
    c(ag paramag, kotlin.d.d<? super Boolean> paramd) {}
    
    public final void a(boolean paramBoolean, int paramInt1, ax.a.b paramb, String paramString1, Long paramLong, int paramInt2, String paramString2, String paramString3)
    {
      AppMethodBeat.i(355892);
      s.u(paramb, "errType");
      if (paramBoolean) {
        Log.i("FinderLiveChargePayPlugin", s.X("after pay left balance:", paramLong));
      }
      for (;;)
      {
        paramb = this.nXT;
        paramString1 = Result.Companion;
        paramb.resumeWith(Result.constructor-impl(Boolean.valueOf(paramBoolean)));
        AppMethodBeat.o(355892);
        return;
        switch (a.$EnumSwitchMapping$0[paramb.ordinal()])
        {
        default: 
          break;
        case 1: 
          if (paramInt1 == 10003) {
            ag.i(this.CXH);
          } else {
            ag.a(this.CXH, paramString3);
          }
          break;
        case 2: 
          ag.a(this.CXH, paramString3);
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.d.b.a.k
    implements m<kotlinx.coroutines.aq, kotlin.d.d<? super ah>, Object>
  {
    Object L$0;
    long Yx;
    int label;
    
    d(ag paramag, kotlin.d.d<? super d> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(356029);
      paramObject = (kotlin.d.d)new d(this.CXH, paramd);
      AppMethodBeat.o(356029);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(356023);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      Object localObject1;
      Object localObject2;
      kotlin.d.d locald;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(356023);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = w.a(this.CXH.mJe.getContext(), (CharSequence)this.CXH.mJe.getContext().getString(p.h.app_waiting), false, 3, null);
        localObject1 = (kotlin.d.f)bg.kCi();
        localObject2 = (m)new b(this.CXH, null);
        locald = (kotlin.d.d)this;
        this.L$0 = paramObject;
        this.label = 1;
        localObject1 = l.a((kotlin.d.f)localObject1, (m)localObject2, locald);
        if (localObject1 == locala)
        {
          AppMethodBeat.o(356023);
          return locala;
        }
        break;
      case 1: 
        localObject2 = (w)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        localObject1 = paramObject;
        paramObject = localObject2;
      }
      for (;;)
      {
        localObject1 = (kotlin.r)localObject1;
        if (((Boolean)((kotlin.r)localObject1).bsC).booleanValue()) {
          if (((Number)((kotlin.r)localObject1).bsD).longValue() > this.CXH.CXC)
          {
            final long l1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.CXH.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId;
            long l2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.CXH.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN;
            localObject2 = new StringBuilder();
            localObject1 = z.bAM();
            if (localObject1 == null) {
              localObject1 = null;
            }
            for (;;)
            {
              localObject2 = g.getMessageDigest((byte[])localObject1) + '_' + UUID.randomUUID();
              localObject1 = (kotlin.d.f)bg.kCi();
              localObject2 = (m)new a(this.CXH, l1, l2, (String)localObject2, null);
              locald = (kotlin.d.d)this;
              this.L$0 = paramObject;
              this.Yx = l1;
              this.label = 2;
              localObject2 = l.a((kotlin.d.f)localObject1, (m)localObject2, locald);
              localObject1 = localObject2;
              if (localObject2 != locala) {
                break;
              }
              AppMethodBeat.o(356023);
              return locala;
              localObject1 = ((String)localObject1).getBytes(kotlin.n.d.UTF_8);
              s.s(localObject1, "(this as java.lang.String).getBytes(charset)");
            }
            l1 = this.Yx;
            localObject2 = (w)this.L$0;
            ResultKt.throwOnFailure(paramObject);
            localObject1 = paramObject;
            paramObject = localObject2;
            if (((Boolean)localObject1).booleanValue())
            {
              this.CXH.rk(false);
              aa.y(this.CXH.mJe.getContext(), this.CXH.mJe.getContext().getString(p.h.Cjo), p.g.icons_outlined_done);
              localObject1 = this.CXH.CXD;
              if (localObject1 != null) {
                ((com.tencent.mm.plugin.finder.replay.a)localObject1).d(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.CXH.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId, true, true);
              }
              ((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).getFinderLiveChargeInfoStorage().ow(l1);
              b.b.a(ag.e(this.CXH), b.c.nfB);
              ag.f(this.CXH);
              this.CXH.tO(8);
              ag.b(this.CXH, this.CXH.CXC);
            }
            paramObject.hide();
          }
        }
        for (;;)
        {
          paramObject = ah.aiuX;
          AppMethodBeat.o(356023);
          return paramObject;
          paramObject.hide();
          ag.g(this.CXH);
          continue;
          paramObject.hide();
          aa.makeText(this.CXH.mJe.getContext(), (CharSequence)this.CXH.mJe.getContext().getResources().getString(p.h.CiW), 0).show();
        }
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.d.b.a.k
      implements m<kotlinx.coroutines.aq, kotlin.d.d<? super Boolean>, Object>
    {
      int label;
      
      a(ag paramag, long paramLong1, long paramLong2, String paramString, kotlin.d.d<? super a> paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(355294);
        paramObject = (kotlin.d.d)new a(this.CXH, l1, this.AsN, this.Cwa, paramd);
        AppMethodBeat.o(355294);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(355285);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(355285);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = this.CXH;
          long l1 = l1;
          long l2 = this.AsN;
          Object localObject = this.Cwa;
          int i = this.CXH.CXC;
          kotlin.d.d locald = (kotlin.d.d)this;
          this.label = 1;
          localObject = ag.a(paramObject, l1, l2, (String)localObject, i, locald);
          paramObject = localObject;
          if (localObject == locala)
          {
            AppMethodBeat.o(355285);
            return locala;
          }
          break;
        case 1: 
          ResultKt.throwOnFailure(paramObject);
        }
        AppMethodBeat.o(355285);
        return paramObject;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Lkotlin/Pair;", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends kotlin.d.b.a.k
      implements m<kotlinx.coroutines.aq, kotlin.d.d<? super kotlin.r<? extends Boolean, ? extends Long>>, Object>
    {
      int label;
      
      b(ag paramag, kotlin.d.d<? super b> paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(355334);
        paramObject = (kotlin.d.d)new b(this.CXH, paramd);
        AppMethodBeat.o(355334);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(355324);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(355324);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = (kotlin.d.d)this;
          this.label = 1;
          Object localObject = ag.ae(paramObject);
          paramObject = localObject;
          if (localObject == locala)
          {
            AppMethodBeat.o(355324);
            return locala;
          }
          break;
        case 1: 
          ResultKt.throwOnFailure(paramObject);
        }
        AppMethodBeat.o(355324);
        return paramObject;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(String paramString, ag paramag)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ah>
  {
    g(ag paramag)
    {
      super();
    }
    
    private static final void a(ag paramag, boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(356010);
      s.u(paramag, "this$0");
      ag.g(paramag);
      AppMethodBeat.o(356010);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.ag
 * JD-Core Version:    0.7.0.1
 */
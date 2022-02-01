package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.model.r;
import com.tencent.mm.live.model.r.a;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.d;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.p;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.protocal.protobuf.bkd;
import com.tencent.mm.protocal.protobuf.buh;
import com.tencent.mm.protocal.protobuf.bzc;
import com.tencent.mm.protocal.protobuf.ehg;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.a.g.a;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.ah.d;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bb;
import kotlinx.coroutines.bu;
import kotlinx.coroutines.cb;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveProductRecordView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "DURATION_MAX", "", "getDURATION_MAX", "()J", "DURATION_MAX$delegate", "Lkotlin/Lazy;", "TAG", "", "countdownJob", "Lkotlinx/coroutines/Job;", "getCountdownJob", "()Lkotlinx/coroutines/Job;", "setCountdownJob", "(Lkotlinx/coroutines/Job;)V", "mContext", "notifyRecordBtnCallBack", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/FinderWindowProductInfo;", "", "getNotifyRecordBtnCallBack", "()Lkotlin/jvm/functions/Function1;", "setNotifyRecordBtnCallBack", "(Lkotlin/jvm/functions/Function1;)V", "productInfo", "recordFinishView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getRecordFinishView", "()Landroid/view/View;", "recordFinishView$delegate", "recordGeneratingView", "getRecordGeneratingView", "recordGeneratingView$delegate", "recordLaunchView", "Landroid/view/ViewGroup;", "getRecordLaunchView", "()Landroid/view/ViewGroup;", "recordLaunchView$delegate", "recordingView", "getRecordingView", "recordingView$delegate", "root", "changeUI2Normal", "genCmdItem", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "cmdId", "productId", "initView", "modRecordCgi", "callBack", "Lkotlin/Function2;", "", "notifyRecordChange", "status", "onViewRecyled", "showCenterToast", "id", "str", "updateStatus", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveProductRecordView
  extends FrameLayout
{
  public static final a DOQ;
  private static final long DOZ;
  private static final long DPa;
  private static final long DPb;
  private final kotlin.j DOR;
  private bzc DOS;
  private kotlin.g.a.b<? super bzc, ah> DOT;
  public cb DOU;
  private final kotlin.j DOV;
  private final kotlin.j DOW;
  private final kotlin.j DOX;
  private final kotlin.j DOY;
  private final String TAG;
  private Context mContext;
  private ViewGroup mJe;
  
  static
  {
    AppMethodBeat.i(358159);
    DOQ = new a((byte)0);
    DOZ = 5L;
    DPa = 60L;
    DPb = 30L;
    AppMethodBeat.o(358159);
  }
  
  public FinderLiveProductRecordView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(357944);
    this.TAG = "FinderLiveProductRecordView";
    this.DOR = kotlin.k.cm((kotlin.g.a.a)b.DPc);
    this.DOV = kotlin.k.cm((kotlin.g.a.a)new g(this));
    this.DOW = kotlin.k.cm((kotlin.g.a.a)new h(this));
    this.DOX = kotlin.k.cm((kotlin.g.a.a)new e(this));
    this.DOY = kotlin.k.cm((kotlin.g.a.a)new f(this));
    ci(paramContext);
    AppMethodBeat.o(357944);
  }
  
  public FinderLiveProductRecordView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(357951);
    this.TAG = "FinderLiveProductRecordView";
    this.DOR = kotlin.k.cm((kotlin.g.a.a)b.DPc);
    this.DOV = kotlin.k.cm((kotlin.g.a.a)new g(this));
    this.DOW = kotlin.k.cm((kotlin.g.a.a)new h(this));
    this.DOX = kotlin.k.cm((kotlin.g.a.a)new e(this));
    this.DOY = kotlin.k.cm((kotlin.g.a.a)new f(this));
    ci(paramContext);
    AppMethodBeat.o(357951);
  }
  
  private final void ci(Context paramContext)
  {
    AppMethodBeat.i(358011);
    this.mContext = paramContext;
    paramContext = af.mU(paramContext).inflate(p.f.Cfm, (ViewGroup)this);
    if (paramContext == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(358011);
      throw paramContext;
    }
    paramContext = ((ViewGroup)paramContext).findViewById(p.e.BRg);
    s.s(paramContext, "thisView.findViewById(R.…e_product_recording_root)");
    this.mJe = ((ViewGroup)paramContext);
    AppMethodBeat.o(358011);
  }
  
  private final void evG()
  {
    int i = 0;
    AppMethodBeat.i(358032);
    Object localObject = aj.CGT;
    localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class);
    ViewGroup localViewGroup;
    if (localObject == null)
    {
      localObject = null;
      localViewGroup = getRecordLaunchView();
      if (!s.p(localObject, Boolean.TRUE)) {
        break label102;
      }
    }
    for (;;)
    {
      localViewGroup.setVisibility(i);
      AppMethodBeat.o(358032);
      return;
      localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)localObject).Ein;
      if (localObject == null)
      {
        localObject = null;
        break;
      }
      if ((((buh)localObject).ZTm == 1) && (((buh)localObject).ZTl == 1)) {}
      for (boolean bool = true;; bool = false)
      {
        localObject = Boolean.valueOf(bool);
        break;
      }
      label102:
      i = 8;
    }
  }
  
  private final long getDURATION_MAX()
  {
    AppMethodBeat.i(357960);
    long l = ((Number)this.DOR.getValue()).longValue();
    AppMethodBeat.o(357960);
    return l;
  }
  
  private final View getRecordFinishView()
  {
    AppMethodBeat.i(357985);
    View localView = (View)this.DOX.getValue();
    AppMethodBeat.o(357985);
    return localView;
  }
  
  private final View getRecordGeneratingView()
  {
    AppMethodBeat.i(357995);
    View localView = (View)this.DOY.getValue();
    AppMethodBeat.o(357995);
    return localView;
  }
  
  private final ViewGroup getRecordLaunchView()
  {
    AppMethodBeat.i(357966);
    ViewGroup localViewGroup = (ViewGroup)this.DOV.getValue();
    AppMethodBeat.o(357966);
    return localViewGroup;
  }
  
  private final View getRecordingView()
  {
    AppMethodBeat.i(357979);
    View localView = (View)this.DOW.getValue();
    AppMethodBeat.o(357979);
    return localView;
  }
  
  public final void a(bzc parambzc)
  {
    Object localObject2 = null;
    int j = 0;
    AppMethodBeat.i(358207);
    s.u(parambzc, "productInfo");
    Object localObject3 = new StringBuilder("[updateStatus] productId:").append(parambzc.DVk).append(", replayStatus:");
    Object localObject1 = parambzc.aaij;
    int m;
    if (localObject1 == null)
    {
      localObject1 = "null";
      ((StringBuilder)localObject3).append(localObject1);
      h.jXD();
      localObject3 = this.mJe;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("root");
        localObject1 = null;
      }
      m = ((ViewGroup)localObject1).getChildCount();
      if (m <= 0) {}
    }
    int k;
    for (int i = 0;; i = k)
    {
      k = i + 1;
      localObject3 = this.mJe;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("root");
        localObject1 = null;
      }
      ((ViewGroup)localObject1).getChildAt(i).setVisibility(8);
      if (k >= m)
      {
        localObject1 = this.DOU;
        if (localObject1 != null) {
          ((cb)localObject1).a(null);
        }
        this.DOS = parambzc;
        parambzc = parambzc.aaij;
        if (parambzc == null)
        {
          parambzc = (bzc)localObject2;
          if (parambzc == null) {
            ((FinderLiveProductRecordView)this).evG();
          }
          AppMethodBeat.o(358207);
          return;
          localObject1 = Integer.valueOf(((ehg)localObject1).replay_status);
          break;
        }
        switch (parambzc.replay_status)
        {
        }
        for (;;)
        {
          parambzc = ah.aiuX;
          break;
          getRecordingView().setVisibility(0);
          localObject1 = (TextView)getRecordingView().findViewById(p.e.BRf);
          localObject2 = aj.CGT;
          localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class);
          i = j;
          if (localObject2 != null)
          {
            localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)localObject2).Ein;
            i = j;
            if (localObject2 != null)
            {
              i = j;
              if (((buh)localObject2).ZTm == 0) {
                i = 1;
              }
            }
          }
          if (i != 0)
          {
            ((TextView)localObject1).setText((CharSequence)getContext().getString(p.h.CqV));
            getRecordingView().setBackgroundDrawable(null);
          }
          else
          {
            getRecordingView().setBackgroundDrawable(getContext().getDrawable(p.d.BAp));
            setCountdownJob(kotlinx.coroutines.j.a((aq)bu.ajwo, null, null, (m)new i(parambzc, this, (TextView)localObject1, null), 3));
            continue;
            getRecordGeneratingView().setVisibility(0);
            continue;
            getRecordFinishView().setVisibility(0);
            i = parambzc.duration;
            parambzc = (TextView)getRecordFinishView().findViewById(p.e.BRc);
            localObject1 = r.mZi;
            parambzc.setText((CharSequence)r.a.a(i, ":", false, false, false, 24));
            continue;
            evG();
          }
        }
      }
    }
  }
  
  public final cb getCountdownJob()
  {
    return this.DOU;
  }
  
  public final kotlin.g.a.b<bzc, ah> getNotifyRecordBtnCallBack()
  {
    return this.DOT;
  }
  
  public final void setCountdownJob(cb paramcb)
  {
    this.DOU = paramcb;
  }
  
  public final void setNotifyRecordBtnCallBack(kotlin.g.a.b<? super bzc, ah> paramb)
  {
    this.DOT = paramb;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveProductRecordView$Companion;", "", "()V", "DURATION_MIN", "", "getDURATION_MIN", "()J", "DURATION_TIS_ONE_MIN", "getDURATION_TIS_ONE_MIN", "DURATION_TIS_THIRTY_SECOND", "getDURATION_TIS_THIRTY_SECOND", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<Long>
  {
    public static final b DPc;
    
    static
    {
      AppMethodBeat.i(357636);
      DPc = new b();
      AppMethodBeat.o(357636);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "success", "", "errMsg", "", "<anonymous parameter 2>", "Lcom/tencent/mm/protocal/protobuf/FinderLiveModShopShelfResponse;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.q<Boolean, String, bkd, ah>
  {
    c(cb paramcb, ah.f<w> paramf, m<? super Boolean, ? super Long, ah> paramm, long paramLong, FinderLiveProductRecordView paramFinderLiveProductRecordView, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    d(ah.f<w> paramf, FinderLiveProductRecordView paramFinderLiveProductRecordView, kotlin.d.d<? super d> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(357662);
      paramObject = (kotlin.d.d)new d(this.AWR, this.DPf, paramd);
      AppMethodBeat.o(357662);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(357654);
      Object localObject = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(357654);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (kotlin.d.d)this;
        this.label = 1;
        if (bb.e(1000L, paramObject) == localObject)
        {
          AppMethodBeat.o(357654);
          return localObject;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      ah.f localf = this.AWR;
      localObject = FinderLiveProductRecordView.b(this.DPf);
      paramObject = localObject;
      if (localObject == null)
      {
        s.bIx("root");
        paramObject = null;
      }
      Context localContext = paramObject.getContext();
      localObject = FinderLiveProductRecordView.b(this.DPf);
      paramObject = localObject;
      if (localObject == null)
      {
        s.bIx("root");
        paramObject = null;
      }
      localf.aqH = w.a(localContext, (CharSequence)paramObject.getContext().getString(p.h.loading_tips), false, 0, null);
      paramObject = ah.aiuX;
      AppMethodBeat.o(357654);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<View>
  {
    e(FinderLiveProductRecordView paramFinderLiveProductRecordView)
    {
      super();
    }
    
    private static final void a(FinderLiveProductRecordView paramFinderLiveProductRecordView, View paramView)
    {
      Object localObject1 = null;
      AppMethodBeat.i(357664);
      Object localObject2 = new Object();
      Object localObject3 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject3).cH(paramFinderLiveProductRecordView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject3).cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/FinderLiveProductRecordView$recordFinishView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject2, ((com.tencent.mm.hellhoundlib.b.b)localObject3).aYj());
      s.u(paramFinderLiveProductRecordView, "this$0");
      paramView = com.tencent.mm.plugin.finder.live.report.j.Dob;
      localObject2 = aj.CGT;
      localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class);
      int i;
      if (localObject2 == null)
      {
        i = 0;
        com.tencent.mm.plugin.finder.live.report.j.a(paramView, 6, i);
        localObject2 = FinderLiveProductRecordView.e(paramFinderLiveProductRecordView);
        paramView = (View)localObject2;
        if (localObject2 == null)
        {
          s.bIx("mContext");
          paramView = null;
        }
        localObject3 = new g.a(paramView);
        localObject2 = FinderLiveProductRecordView.b(paramFinderLiveProductRecordView);
        paramView = (View)localObject2;
        if (localObject2 == null)
        {
          s.bIx("root");
          paramView = null;
        }
        ((g.a)localObject3).bDE(paramView.getContext().getString(p.h.CqO)).NF(true);
        ((g.a)localObject3).aEX(p.h.CqN);
        ((g.a)localObject3).aEY(paramFinderLiveProductRecordView.getContext().getResources().getColor(p.b.link_color));
        paramView = FinderLiveProductRecordView.b(paramFinderLiveProductRecordView);
        if (paramView != null) {
          break label292;
        }
        s.bIx("root");
        paramView = localObject1;
      }
      label292:
      for (;;)
      {
        ((g.a)localObject3).bDJ(paramView.getContext().getString(p.h.CqM));
        ((g.a)localObject3).c(new FinderLiveProductRecordView.e..ExternalSyntheticLambda1(paramFinderLiveProductRecordView)).show();
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/FinderLiveProductRecordView$recordFinishView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(357664);
        return;
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)localObject2).Ein;
        if (localObject2 == null)
        {
          i = 0;
          break;
        }
        i = ((buh)localObject2).ZTm;
        break;
      }
    }
    
    private static final void a(FinderLiveProductRecordView paramFinderLiveProductRecordView, boolean paramBoolean, final String paramString)
    {
      AppMethodBeat.i(357648);
      s.u(paramFinderLiveProductRecordView, "this$0");
      if (paramBoolean)
      {
        paramString = FinderLiveProductRecordView.c(paramFinderLiveProductRecordView);
        if (paramString != null) {
          FinderLiveProductRecordView.a(paramFinderLiveProductRecordView, 107, paramString.DVk, (m)new a(paramFinderLiveProductRecordView, paramString));
        }
      }
      AppMethodBeat.o(357648);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "succuss", "", "productId", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements m<Boolean, Long, ah>
    {
      a(FinderLiveProductRecordView paramFinderLiveProductRecordView, bzc parambzc)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<View>
  {
    f(FinderLiveProductRecordView paramFinderLiveProductRecordView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ViewGroup>
  {
    g(FinderLiveProductRecordView paramFinderLiveProductRecordView)
    {
      super();
    }
    
    private static final void a(final bzc parambzc, FinderLiveProductRecordView paramFinderLiveProductRecordView, boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(357645);
      s.u(parambzc, "$it");
      s.u(paramFinderLiveProductRecordView, "this$0");
      if (paramBoolean)
      {
        paramString = parambzc.aaij;
        if (paramString == null) {}
        for (int i = 0; i > 0; i = paramString.ftu)
        {
          long l = cn.getSyncServerTimeSecond() - i;
          paramString = FinderLiveProductRecordView.DOQ;
          if (l >= FinderLiveProductRecordView.evH()) {
            break;
          }
          com.tencent.mm.plugin.finder.live.report.j.a(com.tencent.mm.plugin.finder.live.report.j.Dob, 7, 1);
          FinderLiveProductRecordView.a(paramFinderLiveProductRecordView, p.h.CqS);
          AppMethodBeat.o(357645);
          return;
        }
        FinderLiveProductRecordView.a(paramFinderLiveProductRecordView, 106, parambzc.DVk, (m)new a(paramFinderLiveProductRecordView, parambzc));
      }
      AppMethodBeat.o(357645);
    }
    
    private static final void b(final FinderLiveProductRecordView paramFinderLiveProductRecordView, View paramView)
    {
      AppMethodBeat.i(357656);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramFinderLiveProductRecordView);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/FinderLiveProductRecordView$recordLaunchView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramFinderLiveProductRecordView, "this$0");
      paramView = com.tencent.mm.plugin.finder.live.report.j.Dob;
      localObject = aj.CGT;
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class);
      int i;
      if (localObject == null)
      {
        i = 0;
        com.tencent.mm.plugin.finder.live.report.j.a(paramView, 4, i);
        paramView = aj.CGT;
        paramView = (p)aj.business(p.class);
        if (paramView != null) {
          break label186;
        }
        paramView = null;
      }
      for (;;)
      {
        if (paramView == null)
        {
          paramView = FinderLiveProductRecordView.c(paramFinderLiveProductRecordView);
          if (paramView != null) {
            FinderLiveProductRecordView.a(paramFinderLiveProductRecordView, 105, paramView.DVk, (m)new b(paramView, paramFinderLiveProductRecordView));
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/FinderLiveProductRecordView$recordLaunchView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(357656);
        return;
        localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)localObject).Ein;
        if (localObject == null)
        {
          i = 0;
          break;
        }
        i = ((buh)localObject).ZTm;
        break;
        label186:
        paramView = paramView.EhV;
        if (paramView == null)
        {
          paramView = null;
        }
        else
        {
          localObject = new g.a(paramFinderLiveProductRecordView.getContext());
          ((g.a)localObject).bDE(paramFinderLiveProductRecordView.getContext().getString(p.h.CqU)).NF(true);
          ((g.a)localObject).c(new FinderLiveProductRecordView.g..ExternalSyntheticLambda1(paramView, paramFinderLiveProductRecordView)).show();
          paramView = ah.aiuX;
        }
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "succuss", "", "productId", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements m<Boolean, Long, ah>
    {
      a(FinderLiveProductRecordView paramFinderLiveProductRecordView, bzc parambzc)
      {
        super();
      }
      
      @Metadata(d1={""}, d2={"<anonymous>", "", "succuss", "", "productId", ""}, k=3, mv={1, 5, 1}, xi=48)
      static final class a
        extends u
        implements m<Boolean, Long, ah>
      {
        a(bzc parambzc, FinderLiveProductRecordView paramFinderLiveProductRecordView)
        {
          super();
        }
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "succuss", "", "productId", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements m<Boolean, Long, ah>
    {
      b(bzc parambzc, FinderLiveProductRecordView paramFinderLiveProductRecordView)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<View>
  {
    h(FinderLiveProductRecordView paramFinderLiveProductRecordView)
    {
      super();
    }
    
    private static final void c(FinderLiveProductRecordView paramFinderLiveProductRecordView, View paramView)
    {
      AppMethodBeat.i(357665);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramFinderLiveProductRecordView);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/FinderLiveProductRecordView$recordingView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramFinderLiveProductRecordView, "this$0");
      paramView = aj.CGT;
      paramView = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class);
      if (paramView != null)
      {
        paramView = paramView.Ein;
        if ((paramView == null) || (paramView.ZTm != 0)) {}
      }
      for (int i = 1; i != 0; i = 0)
      {
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/FinderLiveProductRecordView$recordingView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(357665);
        return;
      }
      paramView = aw.Gjk;
      localObject = FinderLiveProductRecordView.c(paramFinderLiveProductRecordView);
      paramView = FinderLiveProductRecordView.c(paramFinderLiveProductRecordView);
      if (paramView == null)
      {
        paramView = null;
        if ((localObject != null) && (paramView != null))
        {
          if (paramView.replay_status != 1000) {
            break label271;
          }
          if (paramView.ftu <= 0) {
            break label244;
          }
          long l = cn.getSyncServerTimeSecond() - paramView.ftu;
          paramView = FinderLiveProductRecordView.DOQ;
          if (l >= FinderLiveProductRecordView.evH()) {
            break label244;
          }
          com.tencent.mm.plugin.finder.live.report.j.a(com.tencent.mm.plugin.finder.live.report.j.Dob, 7, 1);
          FinderLiveProductRecordView.a(paramFinderLiveProductRecordView, p.h.CqS);
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/FinderLiveProductRecordView$recordingView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(357665);
        return;
        paramView = paramView.aaij;
        break;
        label244:
        FinderLiveProductRecordView.a(paramFinderLiveProductRecordView, 106, ((bzc)localObject).DVk, (m)new a(paramFinderLiveProductRecordView, (bzc)localObject));
        continue;
        label271:
        FinderLiveProductRecordView.d(paramFinderLiveProductRecordView);
        h.jXD();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "succuss", "", "productId", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements m<Boolean, Long, ah>
    {
      a(FinderLiveProductRecordView paramFinderLiveProductRecordView, bzc parambzc)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    Object L$0;
    int label;
    
    i(ehg paramehg, FinderLiveProductRecordView paramFinderLiveProductRecordView, TextView paramTextView, kotlin.d.d<? super i> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(357669);
      paramObject = (kotlin.d.d)new i(this.DPj, jdField_this, this.DPk, paramd);
      AppMethodBeat.o(357669);
      return paramObject;
    }
    
    public final Object invokeSuspend(final Object paramObject)
    {
      AppMethodBeat.i(357660);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      Object localObject;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(357660);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = new ah.d();
        paramObject.aixb = (cn.getSyncServerTimeSecond() - this.DPj.ftu);
        if (paramObject.aixb < FinderLiveProductRecordView.a(jdField_this))
        {
          paramObject.aixb = (cn.getSyncServerTimeSecond() - this.DPj.ftu);
          com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new u(this.DPk) {});
          localObject = (kotlin.d.d)this;
          this.L$0 = paramObject;
          this.label = 1;
          if (bb.e(1000L, (kotlin.d.d)localObject) != locala) {
            break label190;
          }
          AppMethodBeat.o(357660);
          return locala;
        }
        break;
      case 1: 
        localObject = (ah.d)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        paramObject = localObject;
      }
      label190:
      for (;;)
      {
        break;
        paramObject = ah.aiuX;
        AppMethodBeat.o(357660);
        return paramObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveProductRecordView
 * JD-Core Version:    0.7.0.1
 */
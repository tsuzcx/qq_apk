package com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.viewconvert;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.loader.p;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.nearby.f.e;
import com.tencent.mm.plugin.finder.nearby.f.h;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.protocal.protobuf.bad;
import com.tencent.mm.protocal.protobuf.bnn;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.recyclerview.j;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.bb;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/LivingTitleConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/convertdata/LivingTitleConvertData;", "outsideOperator", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/InnerAdapterLinkOutsideOperator;", "(Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/InnerAdapterLinkOutsideOperator;)V", "getOutsideOperator", "()Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/InnerAdapterLinkOutsideOperator;", "clear", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "getLayoutId", "", "handleClickReport", "activity", "Landroid/app/Activity;", "onBindViewHolder", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onViewRecycled", "renderTagView", "tabs", "", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "tagObj", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/LivingTitleConvert$TagObject;", "Companion", "TagObject", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends com.tencent.mm.view.recyclerview.f<com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.h>
{
  public static final a EOk;
  private final com.tencent.mm.plugin.finder.nearby.newlivesquare.b ENg;
  
  static
  {
    AppMethodBeat.i(340609);
    EOk = new a((byte)0);
    AppMethodBeat.o(340609);
  }
  
  public h(com.tencent.mm.plugin.finder.nearby.newlivesquare.b paramb)
  {
    AppMethodBeat.i(340520);
    this.ENg = paramb;
    AppMethodBeat.o(340520);
  }
  
  private static void F(j paramj)
  {
    AppMethodBeat.i(340529);
    Object localObject = paramj.tag;
    Application.ActivityLifecycleCallbacks localActivityLifecycleCallbacks;
    if ((localObject != null) && ((localObject instanceof b)))
    {
      ar.a(((b)localObject).scope, null);
      localActivityLifecycleCallbacks = ((b)localObject).ENK;
      if (localActivityLifecycleCallbacks != null)
      {
        localObject = MMApplicationContext.getContext().getApplicationContext();
        if (!(localObject instanceof Application)) {
          break label83;
        }
      }
    }
    label83:
    for (localObject = (Application)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((Application)localObject).unregisterActivityLifecycleCallbacks(localActivityLifecycleCallbacks);
      }
      paramj.tag = null;
      AppMethodBeat.o(340529);
      return;
    }
  }
  
  private static final void a(h paramh, j paramj, Context paramContext, bnn parambnn)
  {
    int j = 18;
    Object localObject3 = null;
    AppMethodBeat.i(340541);
    Object localObject1 = com.tencent.mm.ui.component.k.aeZF;
    localObject1 = ((as)com.tencent.mm.ui.component.k.nq(paramContext).q(as.class)).fou().zIO;
    Object localObject2;
    label119:
    int i;
    if (localObject1 == null)
    {
      localObject1 = "";
      localObject2 = com.tencent.mm.plugin.finder.nearby.live.report.a.ELu;
      com.tencent.mm.plugin.finder.nearby.live.report.a.QK(2);
      com.tencent.d.a.b.a.d locald = (com.tencent.d.a.b.a.d)com.tencent.mm.kernel.h.az(com.tencent.d.a.b.a.d.class);
      Intent localIntent = new Intent();
      localIntent.putExtra("key_request_scene", 9);
      if (parambnn != null)
      {
        localIntent.putExtra("nearby_live_target_square_page_params_key", parambnn.toByteArray());
        localObject2 = paramh.ENg.eFL();
        if (localObject2 != null) {
          break label349;
        }
        localObject2 = null;
        localObject2 = (Collection)localObject2;
        if ((localObject2 != null) && (!((Collection)localObject2).isEmpty())) {
          break label359;
        }
        i = 1;
        label144:
        if (i == 0) {
          break label365;
        }
        i = j;
        label153:
        localObject2 = com.tencent.mm.plugin.finder.nearby.preload.a.EPD;
        paramh = paramj.caK.getContext();
        if (!(paramh instanceof Activity)) {
          break label392;
        }
        paramh = (Activity)paramh;
        label178:
        if (paramh != null) {
          break label397;
        }
        paramh = null;
        label184:
        paramj = paramh;
        if (paramh == null) {
          paramj = new Intent();
        }
        j = parambnn.ZVZ;
        parambnn = parambnn.ZWa;
        paramh = parambnn;
        if (parambnn == null) {
          paramh = "";
        }
        ((com.tencent.mm.plugin.finder.nearby.preload.a)localObject2).a(paramj, j, i, paramh);
      }
      localIntent.putExtra("key_context_id", (String)localObject1);
      paramh = ah.aiuX;
      locald.enterFinderLiveSquare(paramContext, localIntent);
      if (!(paramContext instanceof Activity)) {
        break label405;
      }
      paramh = (Activity)paramContext;
      label266:
      if (paramh != null)
      {
        paramj = com.tencent.mm.ui.component.k.aeZF;
        paramj = ((as)com.tencent.mm.ui.component.k.nq((Context)paramh).q(as.class)).fou();
        paramContext = com.tencent.mm.ui.component.k.aeZF;
        paramh = com.tencent.mm.ui.component.k.nq((Context)paramh).q(com.tencent.mm.plugin.finder.nearby.report.f.class);
        s.s(paramh, "UICProvider.of(it).get(N…eReporterUIC::class.java)");
        paramContext = (com.tencent.mm.plugin.finder.nearby.report.f)paramh;
        if (paramj != null) {
          break label410;
        }
      }
    }
    label392:
    label397:
    label405:
    label410:
    for (paramh = localObject3;; paramh = paramj.zIO)
    {
      paramContext.aj(paramh, "main_page_recmd_more", "");
      AppMethodBeat.o(340541);
      return;
      break;
      label349:
      localObject2 = ((bad)localObject2).ZKV;
      break label119;
      label359:
      i = 0;
      break label144;
      label365:
      paramh = paramh.ENg.eFL();
      i = j;
      if (paramh == null) {
        break label153;
      }
      i = paramh.ZKY;
      break label153;
      paramh = null;
      break label178;
      paramh = paramh.getIntent();
      break label184;
      paramh = null;
      break label266;
    }
  }
  
  private static final void a(j paramj, h paramh, View paramView)
  {
    AppMethodBeat.i(340564);
    s.u(paramj, "$holder");
    s.u(paramh, "this$0");
    paramView = paramj.context;
    s.s(paramView, "holder.context");
    a(paramh, paramj, paramView, null);
    AppMethodBeat.o(340564);
  }
  
  private static final void a(j paramj, h paramh, bnn parambnn, ViewGroup paramViewGroup, TextView paramTextView, ImageView paramImageView)
  {
    AppMethodBeat.i(340557);
    paramViewGroup.setOnClickListener(new h..ExternalSyntheticLambda2(paramj, parambnn, paramh));
    paramj = p.ExI;
    paramj = p.eCl();
    paramh = new com.tencent.mm.plugin.finder.loader.b(parambnn.icon_url);
    parambnn = p.ExI;
    paramj.a(paramh, paramImageView, p.a(p.a.ExS));
    paramTextView.setText(f.h.logout_menu_more);
    AppMethodBeat.o(340557);
  }
  
  private static final void a(j paramj, bnn parambnn, h paramh, View paramView)
  {
    AppMethodBeat.i(340547);
    s.u(paramj, "$holder");
    s.u(parambnn, "$tab");
    s.u(paramh, "this$0");
    paramView = paramj.context;
    s.s(paramView, "holder.context");
    a(paramh, paramj, paramView, parambnn);
    AppMethodBeat.o(340547);
  }
  
  private static final void b(View paramView1, View paramView2, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(340572);
    s.u(paramView1, "$toShow");
    s.u(paramView2, "$toHide");
    Object localObject = paramValueAnimator.getAnimatedValue();
    if (localObject == null)
    {
      paramView1 = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(340572);
      throw paramView1;
    }
    paramView1.setAlpha(((Float)localObject).floatValue());
    paramView1 = paramValueAnimator.getAnimatedValue();
    if (paramView1 == null)
    {
      paramView1 = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(340572);
      throw paramView1;
    }
    paramView2.setAlpha(1.0F - ((Float)paramView1).floatValue());
    AppMethodBeat.o(340572);
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(340645);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    AppMethodBeat.o(340645);
  }
  
  public final int getLayoutId()
  {
    return f.e.EGW;
  }
  
  public final void m(j paramj)
  {
    AppMethodBeat.i(340637);
    s.u(paramj, "holder");
    super.m(paramj);
    Log.i("LivingTitleConvert", s.X("#onViewRecycled holder=", paramj));
    F(paramj);
    AppMethodBeat.o(340637);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/LivingTitleConvert$Companion;", "", "()V", "TAG", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/LivingTitleConvert$TagObject;", "", "(Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/LivingTitleConvert;)V", "lifeCallback", "Landroid/app/Application$ActivityLifecycleCallbacks;", "getLifeCallback", "()Landroid/app/Application$ActivityLifecycleCallbacks;", "setLifeCallback", "(Landroid/app/Application$ActivityLifecycleCallbacks;)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  final class b
  {
    Application.ActivityLifecycleCallbacks ENK;
    final aq scope;
    
    public b()
    {
      AppMethodBeat.i(340460);
      this.scope = ar.kBZ();
      AppMethodBeat.o(340460);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/LivingTitleConvert$onBindViewHolder$3", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/tools/SampleLifecycleCallbacks;", "onActivityDestroyed", "", "activity", "Landroid/app/Activity;", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.viewconvert.tools.a
  {
    c(h paramh, j paramj) {}
    
    public final void onActivityDestroyed(Activity paramActivity)
    {
      AppMethodBeat.i(340462);
      s.u(paramActivity, "activity");
      if (aH(paramActivity))
      {
        Log.i("LivingTitleConvert", "#lifeCallback-onActivityDestroyed");
        h.H(this.wHm);
      }
      AppMethodBeat.o(340462);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int aai;
    int label;
    
    d(List<? extends bnn> paramList, ah.f<ViewGroup> paramf1, ah.f<TextView> paramf2, ah.f<ImageView> paramf3, ah.f<ViewGroup> paramf4, ah.f<ImageView> paramf5, ah.f<TextView> paramf6, j paramj, h paramh, kotlin.d.d<? super d> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(340465);
      paramObject = (kotlin.d.d)new d(this.EOm, this.EOn, this.EOo, this.EOp, this.EOq, this.EOr, this.EOs, this.wHm, this.EOl, paramd);
      AppMethodBeat.o(340465);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(340461);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      int i;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(340461);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        i = -1;
        h.a(this.EOn, this.EOp, this.EOo, this.EOq, this.EOr, this.EOs);
        i += 1;
        if (i >= this.EOm.size()) {
          i = 0;
        }
        break;
      }
      for (;;)
      {
        paramObject = (bnn)this.EOm.get(i);
        h.b(this.wHm, this.EOl, paramObject, (ViewGroup)this.EOn.aqH, (TextView)this.EOo.aqH, (ImageView)this.EOp.aqH);
        h.n((View)this.EOn.aqH, (View)this.EOq.aqH);
        paramObject = (kotlin.d.d)this;
        this.aai = i;
        this.label = 1;
        if (bb.e(3000L, paramObject) == locala)
        {
          AppMethodBeat.o(340461);
          return locala;
          i = this.aai;
          ResultKt.throwOnFailure(paramObject);
        }
        for (;;)
        {
          break;
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/LivingTitleConvert$renderTagView$startShow$animator$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements Animator.AnimatorListener
  {
    e(View paramView1, View paramView2) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(340454);
      this.EOt.setAlpha(1.0F);
      this.EOu.setVisibility(8);
      AppMethodBeat.o(340454);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(340448);
      this.EOt.setAlpha(0.0F);
      this.EOt.setVisibility(0);
      AppMethodBeat.o(340448);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.viewconvert.h
 * JD-Core Version:    0.7.0.1
 */
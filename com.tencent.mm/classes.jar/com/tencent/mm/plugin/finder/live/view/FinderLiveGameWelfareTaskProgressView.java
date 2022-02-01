package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.report.q.ad;
import com.tencent.mm.protocal.protobuf.ccg;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.p;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.ah.d;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.bb;
import kotlinx.coroutines.cb;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveGameWelfareTaskProgressView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "childViewCarouseJob", "Lkotlinx/coroutines/Job;", "currentShowChildView", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveGameWelfareTaskProgressItemView;", "currentShowTask", "Lcom/tencent/mm/protocal/protobuf/GameWelfareTaskInfo;", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "progressBucket", "taskList", "", "getShowingTask", "render", "", "taskInfo", "", "reset", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveGameWelfareTaskProgressView
  extends RelativeLayout
{
  public static final FinderLiveGameWelfareTaskProgressView.a DNs;
  public cb DNt;
  public final RelativeLayout DNu;
  public final List<ccg> DNv;
  public ccg DNw;
  public FinderLiveGameWelfareTaskProgressItemView DNx;
  public final aq mainScope;
  
  static
  {
    AppMethodBeat.i(357536);
    DNs = new FinderLiveGameWelfareTaskProgressView.a((byte)0);
    AppMethodBeat.o(357536);
  }
  
  public FinderLiveGameWelfareTaskProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(357501);
    this.mainScope = ar.kBZ();
    paramContext = RelativeLayout.inflate(paramContext, p.f.CdS, (ViewGroup)this).findViewById(p.e.CbA);
    s.s(paramContext, "parent.findViewById(R.id.task_progress_bucket)");
    this.DNu = ((RelativeLayout)paramContext);
    this.DNv = ((List)new ArrayList());
    AppMethodBeat.o(357501);
  }
  
  public final ccg getShowingTask()
  {
    return this.DNw;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class b
    extends kotlin.d.b.a.k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    public b(FinderLiveGameWelfareTaskProgressView paramFinderLiveGameWelfareTaskProgressView, d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(357731);
      paramObject = (d)new b(this.DNy, paramd);
      AppMethodBeat.o(357731);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(357726);
      a locala = a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(357726);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        Log.i("FinderLiveGameWelfareTaskProgressView", "#render mainScope.launch");
      }
      for (;;)
      {
        int i;
        label84:
        label118:
        Object localObject1;
        label132:
        Object localObject2;
        if (!((Collection)FinderLiveGameWelfareTaskProgressView.a(this.DNy)).isEmpty())
        {
          i = 1;
          if (i == 0) {
            break;
          }
          if (FinderLiveGameWelfareTaskProgressView.b(this.DNy) != null) {
            break label273;
          }
          FinderLiveGameWelfareTaskProgressView.a(this.DNy, (ccg)p.oL(FinderLiveGameWelfareTaskProgressView.a(this.DNy)));
          paramObject = FinderLiveGameWelfareTaskProgressView.b(this.DNy);
          if (paramObject != null) {
            break label431;
          }
          paramObject = null;
          Log.i("FinderLiveGameWelfareTaskProgressView", s.X("#render currentShowTask task id: ", paramObject));
          paramObject = FinderLiveGameWelfareTaskProgressView.b(this.DNy);
          if (paramObject != null)
          {
            localObject1 = this.DNy;
            com.tencent.mm.plugin.finder.live.report.k.Doi.a(q.ad.DxP, paramObject.aalG);
            if (FinderLiveGameWelfareTaskProgressView.d((FinderLiveGameWelfareTaskProgressView)localObject1) != null) {
              break label439;
            }
            Log.i("FinderLiveGameWelfareTaskProgressView", "#render first time to show child view");
            localObject2 = ((FinderLiveGameWelfareTaskProgressView)localObject1).getContext();
            s.s(localObject2, "context");
            localObject2 = new FinderLiveGameWelfareTaskProgressItemView((Context)localObject2);
            ((FinderLiveGameWelfareTaskProgressItemView)localObject2).a(paramObject);
            FinderLiveGameWelfareTaskProgressView.c((FinderLiveGameWelfareTaskProgressView)localObject1).addView((View)localObject2);
            FinderLiveGameWelfareTaskProgressView.a((FinderLiveGameWelfareTaskProgressView)localObject1, (FinderLiveGameWelfareTaskProgressItemView)localObject2);
          }
        }
        for (;;)
        {
          paramObject = (d)this;
          this.label = 1;
          if (bb.e(5000L, paramObject) != locala) {
            break;
          }
          AppMethodBeat.o(357726);
          return locala;
          i = 0;
          break label84;
          label273:
          localObject1 = new ah.d();
          paramObject = (Iterable)FinderLiveGameWelfareTaskProgressView.a(this.DNy);
          localObject2 = this.DNy;
          i = 0;
          Object localObject3 = paramObject.iterator();
          if (((Iterator)localObject3).hasNext())
          {
            paramObject = ((Iterator)localObject3).next();
            if (i < 0) {
              p.kkW();
            }
            ccg localccg = (ccg)paramObject;
            paramObject = FinderLiveGameWelfareTaskProgressView.b((FinderLiveGameWelfareTaskProgressView)localObject2);
            if (paramObject == null) {}
            for (paramObject = null;; paramObject = paramObject.hzq)
            {
              if ((s.p(paramObject, localccg.hzq)) && (i + 1 < FinderLiveGameWelfareTaskProgressView.a((FinderLiveGameWelfareTaskProgressView)localObject2).size())) {
                ((ah.d)localObject1).aixb = (i + 1);
              }
              i += 1;
              break;
            }
          }
          FinderLiveGameWelfareTaskProgressView.a(this.DNy, (ccg)p.ae(FinderLiveGameWelfareTaskProgressView.a(this.DNy), ((ah.d)localObject1).aixb));
          break label118;
          label431:
          paramObject = paramObject.hzq;
          break label132;
          label439:
          if (FinderLiveGameWelfareTaskProgressView.a((FinderLiveGameWelfareTaskProgressView)localObject1).size() == 1)
          {
            Log.i("FinderLiveGameWelfareTaskProgressView", "#render taskList.size == 1");
            localObject1 = FinderLiveGameWelfareTaskProgressView.d((FinderLiveGameWelfareTaskProgressView)localObject1);
            if (localObject1 != null) {
              ((FinderLiveGameWelfareTaskProgressItemView)localObject1).a(paramObject);
            }
          }
          else
          {
            Log.i("FinderLiveGameWelfareTaskProgressView", "#render not first time to show child view");
            localObject2 = FinderLiveGameWelfareTaskProgressView.d((FinderLiveGameWelfareTaskProgressView)localObject1);
            localObject3 = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, -1.0F);
            ((TranslateAnimation)localObject3).setAnimationListener((Animation.AnimationListener)new a((FinderLiveGameWelfareTaskProgressView)localObject1, (FinderLiveGameWelfareTaskProgressItemView)localObject2));
            ((TranslateAnimation)localObject3).setDuration(400L);
            if (localObject2 != null) {
              ((FinderLiveGameWelfareTaskProgressItemView)localObject2).startAnimation((Animation)localObject3);
            }
            localObject2 = ((FinderLiveGameWelfareTaskProgressView)localObject1).getContext();
            s.s(localObject2, "context");
            localObject2 = new FinderLiveGameWelfareTaskProgressItemView((Context)localObject2);
            ((FinderLiveGameWelfareTaskProgressItemView)localObject2).a(paramObject);
            FinderLiveGameWelfareTaskProgressView.c((FinderLiveGameWelfareTaskProgressView)localObject1).addView((View)localObject2);
            FinderLiveGameWelfareTaskProgressView.a((FinderLiveGameWelfareTaskProgressView)localObject1, (FinderLiveGameWelfareTaskProgressItemView)localObject2);
            paramObject = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
            paramObject.setDuration(400L);
            ((FinderLiveGameWelfareTaskProgressItemView)localObject2).startAnimation((Animation)paramObject);
          }
        }
        ResultKt.throwOnFailure(paramObject);
      }
      Log.i("FinderLiveGameWelfareTaskProgressView", "#render taskList is empty");
      FinderLiveGameWelfareTaskProgressView.a(this.DNy, null);
      FinderLiveGameWelfareTaskProgressView.c(this.DNy).removeAllViews();
      FinderLiveGameWelfareTaskProgressView.a(this.DNy, null);
      paramObject = ah.aiuX;
      AppMethodBeat.o(357726);
      return paramObject;
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/view/FinderLiveGameWelfareTaskProgressView$render$1$2$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements Animation.AnimationListener
    {
      a(FinderLiveGameWelfareTaskProgressView paramFinderLiveGameWelfareTaskProgressView, FinderLiveGameWelfareTaskProgressItemView paramFinderLiveGameWelfareTaskProgressItemView) {}
      
      public final void onAnimationEnd(Animation paramAnimation)
      {
        AppMethodBeat.i(357623);
        Log.i("FinderLiveGameWelfareTaskProgressView", "#render animatorOut onAnimationEnd");
        FinderLiveGameWelfareTaskProgressView.c(this.DNy).removeView((View)this.DNz);
        AppMethodBeat.o(357623);
      }
      
      public final void onAnimationRepeat(Animation paramAnimation) {}
      
      public final void onAnimationStart(Animation paramAnimation) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveGameWelfareTaskProgressView
 * JD-Core Version:    0.7.0.1
 */
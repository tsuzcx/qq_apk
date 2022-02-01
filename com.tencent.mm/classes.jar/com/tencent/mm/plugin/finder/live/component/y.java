package com.tencent.mm.plugin.finder.live.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.view.c;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.q.ad;
import com.tencent.mm.plugin.finder.live.view.FinderLiveGameWelfareTaskProgressView;
import com.tencent.mm.plugin.finder.live.view.FinderLiveGameWelfareTaskProgressView.b;
import com.tencent.mm.plugin.finder.loader.p;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.protocal.protobuf.ccc;
import com.tencent.mm.protocal.protobuf.ccf;
import com.tencent.mm.protocal.protobuf.ccg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.j;
import org.libpag.PAGFile;
import org.libpag.PAGView;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveGameWelfareTaskBubbleViewCallback;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveGameWelfareTaskBubbleContract$ViewCallback;", "root", "Landroid/view/View;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveGameWelfareTaskBubbleContract$Presenter;", "setRootVisibleFunction", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "visible", "", "(Landroid/view/View;Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/live/component/FinderLiveGameWelfareTaskBubbleContract$Presenter;Lkotlin/jvm/functions/Function1;)V", "gainAnimContainer", "Landroid/widget/FrameLayout;", "getGainAnimContainer", "()Landroid/widget/FrameLayout;", "setGainAnimContainer", "(Landroid/widget/FrameLayout;)V", "gainImageView", "Landroid/widget/ImageView;", "gainLayout", "Landroid/view/ViewGroup;", "gainPagAnim", "Lorg/libpag/PAGView;", "getGainPagAnim", "()Lorg/libpag/PAGView;", "setGainPagAnim", "(Lorg/libpag/PAGView;)V", "gainTextView", "Landroid/widget/TextView;", "onBubbleClick", "Lkotlin/Function0;", "getOnBubbleClick", "()Lkotlin/jvm/functions/Function0;", "setOnBubbleClick", "(Lkotlin/jvm/functions/Function0;)V", "<set-?>", "showingStatus", "getShowingStatus", "()I", "taskView", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveGameWelfareTaskProgressView;", "getActivity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "getPresenter", "getShowingTask", "Lcom/tencent/mm/protocal/protobuf/GameWelfareTaskInfo;", "hideAndStopPagView", "hideGainView", "hideTaskView", "initSmallAnim", "showAndStartPagView", "forceLoadPag", "", "showGainView", "info", "Lcom/tencent/mm/protocal/protobuf/GameWelfareMediaInfo;", "showTaskView", "taskInfo", "", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class y
  implements w.b
{
  public static final y.a Cyu;
  private final kotlin.g.a.b<Integer, ah> Cwh;
  private kotlin.g.a.a<ah> Cwk;
  private FrameLayout CyA;
  private PAGView CyB;
  private final FinderLiveGameWelfareTaskProgressView CyC;
  private final w.a Cyv;
  private int Cyw;
  private final ViewGroup Cyx;
  private final TextView Cyy;
  private final ImageView Cyz;
  private final MMActivity activity;
  private final View lBX;
  
  static
  {
    AppMethodBeat.i(352916);
    Cyu = new y.a((byte)0);
    AppMethodBeat.o(352916);
  }
  
  public y(View paramView, MMActivity paramMMActivity, w.a parama, kotlin.g.a.b<? super Integer, ah> paramb)
  {
    AppMethodBeat.i(352883);
    this.lBX = paramView;
    this.activity = paramMMActivity;
    this.Cyv = parama;
    this.Cwh = paramb;
    this.lBX.setOnClickListener(new y..ExternalSyntheticLambda0(this));
    paramView = this.lBX.findViewById(p.e.BLl);
    s.s(paramView, "root.findViewById(R.id.f…lfare_gain_layout_parent)");
    this.Cyx = ((ViewGroup)paramView);
    paramView = this.lBX.findViewById(p.e.BLm);
    s.s(paramView, "root.findViewById(R.id.f…e_welfare_gain_layout_tv)");
    this.Cyy = ((TextView)paramView);
    paramView = this.lBX.findViewById(p.e.BLk);
    s.s(paramView, "root.findViewById(R.id.f…e_welfare_gain_layout_iv)");
    this.Cyz = ((ImageView)paramView);
    paramView = com.tencent.mm.plugin.finder.accessibility.a.Ate;
    paramView = this.lBX.getContext();
    s.s(paramView, "root.context");
    float f = com.tencent.mm.plugin.finder.accessibility.a.g(paramView, 12.0F);
    this.Cyy.setTextSize(1, f);
    this.CyA = ((FrameLayout)this.lBX.findViewById(p.e.BVv));
    if (this.CyB == null)
    {
      Log.i("FinderLiveGameWelfareTaskBubbleViewCallback", "#initSmallAnim create smallAnim!");
      paramView = this.CyA;
      if (paramView != null) {
        paramView.removeAllViews();
      }
      this.CyB = new PAGView(this.lBX.getContext());
      paramView = new FrameLayout.LayoutParams(c.dip2px((Context)this.activity, 104.0F), c.dip2px((Context)this.activity, 104.0F));
      paramMMActivity = this.CyB;
      if (paramMMActivity != null) {
        paramMMActivity.setLayoutParams((ViewGroup.LayoutParams)paramView);
      }
      paramView = this.CyB;
      if (paramView != null) {
        paramView.setScaleMode(1);
      }
      paramView = this.CyA;
      if (paramView != null) {
        paramView.addView((View)this.CyB);
      }
    }
    paramView = this.lBX.findViewById(p.e.BLo);
    s.s(paramView, "root.findViewById(R.id.f…me_welfare_task_progress)");
    this.CyC = ((FinderLiveGameWelfareTaskProgressView)paramView);
    AppMethodBeat.o(352883);
  }
  
  private static final void a(y paramy, View paramView)
  {
    AppMethodBeat.i(352905);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramy);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/component/FinderLiveGameWelfareTaskBubbleViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramy, "this$0");
    paramy = paramy.Cwk;
    if (paramy != null) {
      paramy.invoke();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/component/FinderLiveGameWelfareTaskBubbleViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(352905);
  }
  
  private final void eii()
  {
    AppMethodBeat.i(352893);
    Object localObject = this.CyB;
    if (localObject != null) {
      ((PAGView)localObject).stop();
    }
    localObject = this.CyA;
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(8);
    }
    AppMethodBeat.o(352893);
  }
  
  public final void a(ccf paramccf, boolean paramBoolean)
  {
    ImageView localImageView = null;
    AppMethodBeat.i(352958);
    s.u(paramccf, "info");
    Object localObject2 = new StringBuilder("#showGainView url=");
    Object localObject1 = paramccf.aalF;
    if (localObject1 == null)
    {
      localObject1 = null;
      Log.i("FinderLiveGameWelfareTaskBubbleViewCallback", localObject1 + " text=" + paramccf.aalE);
      this.Cyy.setText((CharSequence)paramccf.aalE);
      localObject1 = paramccf.aalF;
      if (localObject1 != null) {
        break label324;
      }
      localObject2 = localImageView;
      label99:
      if (localObject2 == null) {
        if (!paramBoolean)
        {
          localObject1 = this.CyA;
          if ((localObject1 == null) || (((FrameLayout)localObject1).getVisibility() != 0)) {
            break label446;
          }
        }
      }
    }
    label440:
    label446:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject1 = this.CyB;
        if (localObject1 != null) {
          ((PAGView)localObject1).stop();
        }
        localObject1 = this.CyB;
        if (localObject1 != null) {
          ((PAGView)localObject1).setFile(PAGFile.Load(this.activity.getAssets(), "small_lottery_amin.pag"));
        }
        localObject1 = this.CyB;
        if (localObject1 != null) {
          ((PAGView)localObject1).setRepeatCount(1);
        }
        localObject1 = this.CyB;
        if (localObject1 != null) {
          ((PAGView)localObject1).setProgress(0.0D);
        }
        localObject1 = this.CyB;
        if (localObject1 != null) {
          ((PAGView)localObject1).play();
        }
        localObject1 = this.CyB;
        if (localObject1 != null) {
          ((PAGView)localObject1).flush();
        }
        localObject1 = this.CyA;
        if (localObject1 != null) {
          ((FrameLayout)localObject1).setVisibility(0);
        }
      }
      this.Cyz.setVisibility(8);
      if (!this.Cyx.isShown()) {
        k.Doi.a(q.ad.DxQ, paramccf.aalG);
      }
      this.Cyx.setVisibility(0);
      this.Cyw = 2;
      AppMethodBeat.o(352958);
      return;
      localObject1 = ((ccc)localObject1).DUR;
      break;
      label324:
      localObject1 = ((ccc)localObject1).DUR;
      localObject2 = localImageView;
      if (localObject1 == null) {
        break label99;
      }
      if (((CharSequence)localObject1).length() > 0)
      {
        i = 1;
        label355:
        if (i == 0) {
          break label440;
        }
      }
      for (;;)
      {
        localObject2 = localImageView;
        if (localObject1 == null) {
          break;
        }
        localObject2 = p.ExI;
        localObject2 = p.eCl();
        localObject1 = new com.tencent.mm.plugin.finder.loader.b((String)localObject1);
        localImageView = this.Cyz;
        p localp = p.ExI;
        ((d)localObject2).a(localObject1, localImageView, p.a(p.a.ExS));
        eii();
        this.Cyz.setVisibility(0);
        localObject2 = ah.aiuX;
        break;
        i = 0;
        break label355;
        localObject1 = null;
      }
    }
  }
  
  public final void aU(kotlin.g.a.a<ah> parama)
  {
    this.Cwk = parama;
  }
  
  public final MMFragmentActivity dUP()
  {
    return (MMFragmentActivity)this.activity;
  }
  
  public final int eid()
  {
    return this.Cyw;
  }
  
  public final void eie()
  {
    AppMethodBeat.i(352968);
    Log.i("FinderLiveGameWelfareTaskBubbleViewCallback", "#hideGainView");
    this.Cyx.setVisibility(8);
    eii();
    this.Cyw = 0;
    AppMethodBeat.o(352968);
  }
  
  public final void eif()
  {
    AppMethodBeat.i(352994);
    this.CyC.setVisibility(8);
    FinderLiveGameWelfareTaskProgressView localFinderLiveGameWelfareTaskProgressView = this.CyC;
    Log.i("FinderLiveGameWelfareTaskProgressView", "#reset");
    cb localcb = localFinderLiveGameWelfareTaskProgressView.DNt;
    if (localcb != null) {
      localcb.a(null);
    }
    localFinderLiveGameWelfareTaskProgressView.DNv.clear();
    localFinderLiveGameWelfareTaskProgressView.DNw = null;
    localFinderLiveGameWelfareTaskProgressView.DNu.removeAllViews();
    localFinderLiveGameWelfareTaskProgressView.DNx = null;
    this.Cyw = 0;
    AppMethodBeat.o(352994);
  }
  
  public final ccg getShowingTask()
  {
    AppMethodBeat.i(353002);
    ccg localccg = this.CyC.getShowingTask();
    AppMethodBeat.o(353002);
    return localccg;
  }
  
  public final void gn(List<? extends ccg> paramList)
  {
    AppMethodBeat.i(352983);
    s.u(paramList, "taskInfo");
    FinderLiveGameWelfareTaskProgressView localFinderLiveGameWelfareTaskProgressView;
    if (!((Collection)paramList).isEmpty())
    {
      i = 1;
      if (i != 0)
      {
        localFinderLiveGameWelfareTaskProgressView = this.CyC;
        s.u(paramList, "taskInfo");
        Log.i("FinderLiveGameWelfareTaskProgressView", s.X("#render taskInfo size: ", Integer.valueOf(paramList.size())));
        localFinderLiveGameWelfareTaskProgressView.DNv.clear();
        localFinderLiveGameWelfareTaskProgressView.DNv.addAll((Collection)paramList);
        if (localFinderLiveGameWelfareTaskProgressView.DNt != null)
        {
          paramList = localFinderLiveGameWelfareTaskProgressView.DNt;
          if (paramList == null) {
            break label197;
          }
          if (paramList.isActive()) {
            break label192;
          }
          i = 1;
          label114:
          if (i != 1) {
            break label197;
          }
        }
      }
    }
    label192:
    label197:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramList = localFinderLiveGameWelfareTaskProgressView.DNt;
        if (paramList != null) {
          paramList.a(null);
        }
        localFinderLiveGameWelfareTaskProgressView.DNt = j.a(localFinderLiveGameWelfareTaskProgressView.mainScope, null, null, (m)new FinderLiveGameWelfareTaskProgressView.b(localFinderLiveGameWelfareTaskProgressView, null), 3);
      }
      this.CyC.setVisibility(0);
      this.Cyw = 1;
      AppMethodBeat.o(352983);
      return;
      i = 0;
      break;
      i = 0;
      break label114;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.y
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.live.component;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import org.libpag.PAGFile;
import org.libpag.PAGView;
import org.libpag.PAGView.PAGViewListener;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleViewCallback;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleContract$ViewCallback;", "root", "Landroid/view/View;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleContract$Presenter;", "(Landroid/view/View;Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleContract$Presenter;)V", "SMALL_ANIMATION_FILE", "", "getSMALL_ANIMATION_FILE", "()Ljava/lang/String;", "countDownTxt", "Landroid/widget/TextView;", "getCountDownTxt", "()Landroid/widget/TextView;", "setCountDownTxt", "(Landroid/widget/TextView;)V", "isPagEnable", "", "()Z", "smallAnim", "Lorg/libpag/PAGView;", "getSmallAnim", "()Lorg/libpag/PAGView;", "setSmallAnim", "(Lorg/libpag/PAGView;)V", "smallAnimContainer", "Landroid/widget/FrameLayout;", "getSmallAnimContainer", "()Landroid/widget/FrameLayout;", "setSmallAnimContainer", "(Landroid/widget/FrameLayout;)V", "smallAnimListener", "Lcom/tencent/mm/plugin/finder/live/component/SmallAnimListener;", "getSmallAnimListener", "()Lcom/tencent/mm/plugin/finder/live/component/SmallAnimListener;", "setSmallAnimListener", "(Lcom/tencent/mm/plugin/finder/live/component/SmallAnimListener;)V", "getActivity", "getPresenter", "initSmallAnim", "", "initView", "reset", "resumeLotteryBubble", "callback", "Lkotlin/Function0;", "showLotteryComputing", "showLotteryFinish", "showPrepareLottery", "updateCountDown", "remainTime", "Companion", "plugin-finder_release"})
public final class o
  implements m.b
{
  private static final String TAG = "FinderLiveLotteryBubbleViewCallback";
  public static final a yaD;
  private final MMActivity activity;
  private final View jac;
  private ah yaA;
  private final boolean yaB;
  final m.a yaC;
  private final String yav;
  TextView yax;
  private FrameLayout yay;
  private PAGView yaz;
  
  static
  {
    AppMethodBeat.i(281638);
    yaD = new a((byte)0);
    TAG = "FinderLiveLotteryBubbleViewCallback";
    AppMethodBeat.o(281638);
  }
  
  public o(View paramView, MMActivity paramMMActivity, m.a parama)
  {
    AppMethodBeat.i(281637);
    this.jac = paramView;
    this.activity = paramMMActivity;
    this.yaC = parama;
    this.yav = "small_lottery_amin.pag";
    paramView = h.ag(PluginFinder.class);
    p.j(paramView, "MMKernel.plugin(PluginFinder::class.java)");
    this.yaB = ((PluginFinder)paramView).isPagEnable();
    paramView = aj.AGc;
    aj.aFQ("FinderLiveLotteryBubbleViewCallback");
    AppMethodBeat.o(281637);
  }
  
  private final void dxx()
  {
    AppMethodBeat.i(281630);
    if (!this.yaB)
    {
      AppMethodBeat.o(281630);
      return;
    }
    if (this.yaz == null)
    {
      Log.i(TAG, "initSmallAnim create smallAnim!");
      this.yaz = new PAGView(this.jac.getContext());
      this.yaA = new ah(this);
      localObject = this.yaz;
      if (localObject != null) {
        ((PAGView)localObject).addListener((PAGView.PAGViewListener)this.yaA);
      }
    }
    Object localObject = this.yay;
    if (localObject != null)
    {
      if (((FrameLayout)localObject).indexOfChild((View)this.yaz) == -1)
      {
        Log.i(TAG, "initSmallAnim add smallAnim!");
        localObject = new FrameLayout.LayoutParams(-1, -1);
        PAGView localPAGView = this.yaz;
        if (localPAGView != null) {
          localPAGView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        localObject = this.yaz;
        if (localObject != null) {
          ((PAGView)localObject).setFile(PAGFile.Load(this.activity.getAssets(), this.yav));
        }
        localObject = this.yay;
        if (localObject != null)
        {
          ((FrameLayout)localObject).addView((View)this.yaz);
          AppMethodBeat.o(281630);
        }
      }
    }
    else
    {
      AppMethodBeat.o(281630);
      return;
    }
    AppMethodBeat.o(281630);
  }
  
  public final void G(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(281632);
    p.k(parama, "callback");
    Object localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder("showPrepareLottery smallAnim is null:");
    if (this.yaz == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i((String)localObject, bool + ",isPagEnable:" + this.yaB);
      if (this.yaB) {
        break;
      }
      parama.invoke();
      AppMethodBeat.o(281632);
      return;
    }
    localObject = this.yaz;
    if ((localObject != null) && (((PAGView)localObject).isPlaying() == true))
    {
      localObject = this.yaz;
      if (localObject != null) {
        ((PAGView)localObject).stop();
      }
    }
    dxx();
    localObject = this.yay;
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(0);
    }
    localObject = this.yax;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
    localObject = this.yaA;
    if (localObject != null)
    {
      p.k(parama, "callback");
      ((ah)localObject).ycT = parama;
    }
    parama = this.yaz;
    if (parama != null) {
      parama.setProgress(0.0D);
    }
    parama = this.yaz;
    if (parama != null)
    {
      parama.play();
      AppMethodBeat.o(281632);
      return;
    }
    AppMethodBeat.o(281632);
  }
  
  public final void H(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(281633);
    p.k(parama, "callback");
    Object localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder("resumeLotteryBubble smallAnim is null:");
    if (this.yaz == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i((String)localObject, bool);
      localObject = this.yay;
      if (localObject != null) {
        ((FrameLayout)localObject).setVisibility(0);
      }
      localObject = this.yaz;
      if (localObject != null) {
        ((PAGView)localObject).setProgress(1.0D);
      }
      localObject = this.yax;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
      parama.invoke();
      AppMethodBeat.o(281633);
      return;
    }
  }
  
  public final void aBQ(String paramString)
  {
    AppMethodBeat.i(281636);
    p.k(paramString, "remainTime");
    Log.i(TAG, "updateCountDown remainTime:".concat(String.valueOf(paramString)));
    Object localObject = this.yay;
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(0);
    }
    localObject = this.yaz;
    if (localObject != null) {
      ((PAGView)localObject).setProgress(1.0D);
    }
    localObject = this.yax;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(0);
    }
    localObject = this.yax;
    if (localObject != null) {
      ((TextView)localObject).setText((CharSequence)paramString);
    }
    paramString = this.yax;
    if (paramString != null)
    {
      paramString.setTextSize(1, 17.0F);
      AppMethodBeat.o(281636);
      return;
    }
    AppMethodBeat.o(281636);
  }
  
  public final void dxt()
  {
    AppMethodBeat.i(281634);
    Log.i(TAG, "showLotteryComputing");
    Object localObject = this.yay;
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(0);
    }
    localObject = this.yaz;
    if (localObject != null) {
      ((PAGView)localObject).setProgress(1.0D);
    }
    localObject = this.yax;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(0);
    }
    localObject = this.yax;
    if (localObject != null)
    {
      Context localContext = this.jac.getContext();
      p.j(localContext, "root.context");
      ((TextView)localObject).setText((CharSequence)localContext.getResources().getString(b.j.finder_live_lottery_bubble_computing));
    }
    localObject = this.yax;
    if (localObject != null)
    {
      ((TextView)localObject).setTextSize(1, 14.0F);
      AppMethodBeat.o(281634);
      return;
    }
    AppMethodBeat.o(281634);
  }
  
  public final void dxu()
  {
    AppMethodBeat.i(281635);
    Log.i(TAG, "showLotteryFinish");
    Object localObject = this.yay;
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(0);
    }
    localObject = this.yaz;
    if (localObject != null) {
      ((PAGView)localObject).setProgress(1.0D);
    }
    localObject = this.yax;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(0);
    }
    localObject = this.yax;
    if (localObject != null)
    {
      Context localContext = this.jac.getContext();
      p.j(localContext, "root.context");
      ((TextView)localObject).setText((CharSequence)localContext.getResources().getString(b.j.finder_live_lottery_bubble_done));
    }
    localObject = this.yax;
    if (localObject != null)
    {
      ((TextView)localObject).setTextSize(1, 14.0F);
      AppMethodBeat.o(281635);
      return;
    }
    AppMethodBeat.o(281635);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(281628);
    this.yax = ((TextView)this.jac.findViewById(b.f.countdown));
    this.yay = ((FrameLayout)this.jac.findViewById(b.f.anim_container));
    Object localObject = this.yay;
    if (localObject != null) {
      ((FrameLayout)localObject).setOnClickListener((View.OnClickListener)new b(this));
    }
    localObject = this.yax;
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener((View.OnClickListener)new c(this));
    }
    dxx();
    AppMethodBeat.o(281628);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleViewCallback$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(o paramo) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(243285);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleViewCallback$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = this.yaE.yaC;
      if (paramView != null) {
        paramView.dxs();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleViewCallback$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(243285);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(o paramo) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(272209);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleViewCallback$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = this.yaE.yaC;
      if (paramView != null) {
        paramView.dxs();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleViewCallback$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(272209);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.o
 * JD-Core Version:    0.7.0.1
 */
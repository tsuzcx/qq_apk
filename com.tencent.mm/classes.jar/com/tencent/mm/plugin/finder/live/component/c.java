package com.tencent.mm.plugin.finder.live.component;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import org.libpag.PAGFile;
import org.libpag.PAGView;
import org.libpag.PAGView.PAGViewListener;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleViewCallback;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleContract$ViewCallback;", "root", "Landroid/view/View;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleContract$Presenter;", "(Landroid/view/View;Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleContract$Presenter;)V", "SMALL_ANIMATION_FILE", "", "getSMALL_ANIMATION_FILE", "()Ljava/lang/String;", "countDownTxt", "Landroid/widget/TextView;", "getCountDownTxt", "()Landroid/widget/TextView;", "setCountDownTxt", "(Landroid/widget/TextView;)V", "isPagEnable", "", "()Z", "smallAnim", "Lorg/libpag/PAGView;", "getSmallAnim", "()Lorg/libpag/PAGView;", "setSmallAnim", "(Lorg/libpag/PAGView;)V", "smallAnimContainer", "Landroid/widget/FrameLayout;", "getSmallAnimContainer", "()Landroid/widget/FrameLayout;", "setSmallAnimContainer", "(Landroid/widget/FrameLayout;)V", "smallAnimListener", "Lcom/tencent/mm/plugin/finder/live/component/SmallAnimListener;", "getSmallAnimListener", "()Lcom/tencent/mm/plugin/finder/live/component/SmallAnimListener;", "setSmallAnimListener", "(Lcom/tencent/mm/plugin/finder/live/component/SmallAnimListener;)V", "getActivity", "getPresenter", "initSmallAnim", "", "initView", "reset", "resumeLotteryBubble", "callback", "Lkotlin/Function0;", "showLotteryComputing", "showLotteryFinish", "showPrepareLottery", "updateCountDown", "remainTime", "Companion", "plugin-finder_release"})
public final class c
  implements a.b
{
  private static final String TAG = "FinderLiveLotteryBubbleViewCallback";
  public static final a ugB;
  private final MMActivity activity;
  private final View gvQ;
  final a.a ugA;
  private final String ugu;
  TextView ugv;
  private FrameLayout ugw;
  private PAGView ugx;
  private h ugy;
  private final boolean ugz;
  
  static
  {
    AppMethodBeat.i(245919);
    ugB = new a((byte)0);
    TAG = "FinderLiveLotteryBubbleViewCallback";
    AppMethodBeat.o(245919);
  }
  
  public c(View paramView, MMActivity paramMMActivity, a.a parama)
  {
    AppMethodBeat.i(245918);
    this.gvQ = paramView;
    this.activity = paramMMActivity;
    this.ugA = parama;
    this.ugu = "small_lottery_amin.pag";
    paramView = g.ah(PluginFinder.class);
    p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
    this.ugz = ((PluginFinder)paramView).isPagEnable();
    paramView = y.vXH;
    y.awu("FinderLiveLotteryBubbleViewCallback");
    AppMethodBeat.o(245918);
  }
  
  private final void dfe()
  {
    AppMethodBeat.i(245912);
    if (!this.ugz)
    {
      AppMethodBeat.o(245912);
      return;
    }
    if (this.ugx == null)
    {
      Log.i(TAG, "initSmallAnim create smallAnim!");
      this.ugx = new PAGView(this.gvQ.getContext());
      this.ugy = new h(this);
      localObject = this.ugx;
      if (localObject != null) {
        ((PAGView)localObject).addListener((PAGView.PAGViewListener)this.ugy);
      }
    }
    Object localObject = this.ugw;
    if (localObject != null)
    {
      if (((FrameLayout)localObject).indexOfChild((View)this.ugx) == -1)
      {
        Log.i(TAG, "initSmallAnim add smallAnim!");
        localObject = new FrameLayout.LayoutParams(-1, -1);
        PAGView localPAGView = this.ugx;
        if (localPAGView != null) {
          localPAGView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        localObject = this.ugx;
        if (localObject != null) {
          ((PAGView)localObject).setFile(PAGFile.Load(this.activity.getAssets(), this.ugu));
        }
        localObject = this.ugw;
        if (localObject != null)
        {
          ((FrameLayout)localObject).addView((View)this.ugx);
          AppMethodBeat.o(245912);
        }
      }
    }
    else
    {
      AppMethodBeat.o(245912);
      return;
    }
    AppMethodBeat.o(245912);
  }
  
  public final void H(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(245913);
    p.h(parama, "callback");
    Object localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder("showPrepareLottery smallAnim is null:");
    if (this.ugx == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i((String)localObject, bool + ",isPagEnable:" + this.ugz);
      if (this.ugz) {
        break;
      }
      parama.invoke();
      AppMethodBeat.o(245913);
      return;
    }
    localObject = this.ugx;
    if ((localObject != null) && (((PAGView)localObject).isPlaying() == true))
    {
      localObject = this.ugx;
      if (localObject != null) {
        ((PAGView)localObject).stop();
      }
    }
    dfe();
    localObject = this.ugw;
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(0);
    }
    localObject = this.ugv;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
    localObject = this.ugy;
    if (localObject != null)
    {
      p.h(parama, "callback");
      ((h)localObject).uhH = parama;
    }
    parama = this.ugx;
    if (parama != null) {
      parama.setProgress(0.0D);
    }
    parama = this.ugx;
    if (parama != null)
    {
      parama.play();
      AppMethodBeat.o(245913);
      return;
    }
    AppMethodBeat.o(245913);
  }
  
  public final void I(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(245914);
    p.h(parama, "callback");
    Object localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder("resumeLotteryBubble smallAnim is null:");
    if (this.ugx == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i((String)localObject, bool);
      localObject = this.ugw;
      if (localObject != null) {
        ((FrameLayout)localObject).setVisibility(0);
      }
      localObject = this.ugx;
      if (localObject != null) {
        ((PAGView)localObject).setProgress(1.0D);
      }
      localObject = this.ugv;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
      parama.invoke();
      AppMethodBeat.o(245914);
      return;
    }
  }
  
  public final void ats(String paramString)
  {
    AppMethodBeat.i(245917);
    p.h(paramString, "remainTime");
    Log.i(TAG, "updateCountDown remainTime:".concat(String.valueOf(paramString)));
    Object localObject = this.ugw;
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(0);
    }
    localObject = this.ugx;
    if (localObject != null) {
      ((PAGView)localObject).setProgress(1.0D);
    }
    localObject = this.ugv;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(0);
    }
    localObject = this.ugv;
    if (localObject != null) {
      ((TextView)localObject).setText((CharSequence)paramString);
    }
    paramString = this.ugv;
    if (paramString != null)
    {
      paramString.setTextSize(1, 14.0F);
      AppMethodBeat.o(245917);
      return;
    }
    AppMethodBeat.o(245917);
  }
  
  public final void dfa()
  {
    AppMethodBeat.i(245915);
    Log.i(TAG, "showLotteryComputing");
    Object localObject = this.ugw;
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(0);
    }
    localObject = this.ugx;
    if (localObject != null) {
      ((PAGView)localObject).setProgress(1.0D);
    }
    localObject = this.ugv;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(0);
    }
    localObject = this.ugv;
    if (localObject != null)
    {
      Context localContext = this.gvQ.getContext();
      p.g(localContext, "root.context");
      ((TextView)localObject).setText((CharSequence)localContext.getResources().getString(2131760018));
    }
    localObject = this.ugv;
    if (localObject != null)
    {
      ((TextView)localObject).setTextSize(1, 12.0F);
      AppMethodBeat.o(245915);
      return;
    }
    AppMethodBeat.o(245915);
  }
  
  public final void dfb()
  {
    AppMethodBeat.i(245916);
    Log.i(TAG, "showLotteryFinish");
    Object localObject = this.ugw;
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(0);
    }
    localObject = this.ugx;
    if (localObject != null) {
      ((PAGView)localObject).setProgress(1.0D);
    }
    localObject = this.ugv;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(0);
    }
    localObject = this.ugv;
    if (localObject != null)
    {
      Context localContext = this.gvQ.getContext();
      p.g(localContext, "root.context");
      ((TextView)localObject).setText((CharSequence)localContext.getResources().getString(2131760019));
    }
    localObject = this.ugv;
    if (localObject != null)
    {
      ((TextView)localObject).setTextSize(1, 12.0F);
      AppMethodBeat.o(245916);
      return;
    }
    AppMethodBeat.o(245916);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(245911);
    this.ugv = ((TextView)this.gvQ.findViewById(2131299259));
    Object localObject = this.ugv;
    if (localObject != null) {}
    for (localObject = ((TextView)localObject).getPaint();; localObject = null)
    {
      ao.a((Paint)localObject, 0.8F);
      this.ugw = ((FrameLayout)this.gvQ.findViewById(2131296760));
      localObject = this.ugw;
      if (localObject != null) {
        ((FrameLayout)localObject).setOnClickListener((View.OnClickListener)new b(this));
      }
      localObject = this.ugv;
      if (localObject != null) {
        ((TextView)localObject).setOnClickListener((View.OnClickListener)new c(this));
      }
      dfe();
      AppMethodBeat.o(245911);
      return;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleViewCallback$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(c paramc) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(245909);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleViewCallback$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = this.ugC.ugA;
      if (paramView != null) {
        paramView.deZ();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleViewCallback$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(245909);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(c paramc) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(245910);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleViewCallback$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = this.ugC.ugA;
      if (paramView != null) {
        paramView.deZ();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleViewCallback$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(245910);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.c
 * JD-Core Version:    0.7.0.1
 */
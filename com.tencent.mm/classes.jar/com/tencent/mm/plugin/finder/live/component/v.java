package com.tencent.mm.plugin.finder.live.component;

import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.graphics.PointF;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.live.plugin.bk.b;
import com.tencent.mm.plugin.finder.live.plugin.bo.b;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;
import org.libpag.PAGFile;
import org.libpag.PAGView;
import org.libpag.PAGView.PAGViewListener;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleViewCallback;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleContract$ViewCallback;", "container", "Landroid/view/ViewGroup;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleContract$Presenter;", "refPoint", "Landroid/graphics/PointF;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleContract$Presenter;Landroid/graphics/PointF;)V", "animListener", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleViewCallback$AnimListener;", "cntTv", "Landroid/widget/TextView;", "currentCnt", "", "isPagEnable", "", "pagView", "Lorg/libpag/PAGView;", "rootView", "selfShowingLocation", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLuckyMoneyBubblePlugin$ShowingLocation;", "getSelfShowingLocation", "()Landroidx/lifecycle/MutableLiveData;", "setSelfShowingLocation", "(Landroidx/lifecycle/MutableLiveData;)V", "getActivity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "getBottomLocation", "", "getPresenter", "initView", "", "release", "reset", "updateLotteryStatus", "showingLocation", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryBubblePlugin$ShowingLocation;", "updateLuckyMoneyCount", "count", "updateRefPoint", "AnimListener", "Companion", "plugin-finder_release"})
public final class v
  implements t.c
{
  private static final float ycb;
  private static final float ycc;
  private static final float ycd;
  public static final b yce;
  private final MMActivity activity;
  private final ViewGroup mCC;
  private final boolean yaB;
  private TextView ybT;
  private PAGView ybU;
  private a ybV;
  private int ybW;
  public r<bo.b> ybX;
  private final ViewGroup ybY;
  final t.b ybZ;
  private final PointF yca;
  
  static
  {
    AppMethodBeat.i(273101);
    yce = new b((byte)0);
    ycb = -MMApplicationContext.getResources().getDimension(b.d.Edge_0_5_A);
    ycc = -MMApplicationContext.getResources().getDimension(b.d.Edge_0_5_A);
    ycd = -MMApplicationContext.getResources().getDimension(b.d.Edge_0_5_A);
    AppMethodBeat.o(273101);
  }
  
  public v(ViewGroup paramViewGroup, MMActivity paramMMActivity, t.b paramb, PointF paramPointF)
  {
    AppMethodBeat.i(273100);
    this.ybY = paramViewGroup;
    this.activity = paramMMActivity;
    this.ybZ = paramb;
    this.yca = paramPointF;
    paramViewGroup = h.ag(PluginFinder.class);
    p.j(paramViewGroup, "MMKernel.plugin(PluginFinder::class.java)");
    this.yaB = ((PluginFinder)paramViewGroup).isPagEnable();
    Log.i("Finder.FinderLiveLuckyMoneyBubbleViewCallback", "init: refPoint:" + this.yca);
    paramViewGroup = aj.AGc;
    aj.aFQ("FinderLiveLuckyMoneyBubbleViewCallback");
    paramViewGroup = LayoutInflater.from(this.ybY.getContext()).inflate(b.g.finder_live_lucky_money_bubble_ui, this.ybY, false);
    if (paramViewGroup == null)
    {
      paramViewGroup = new t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(273100);
      throw paramViewGroup;
    }
    this.mCC = ((ViewGroup)paramViewGroup);
    this.ybY.addView((View)this.mCC);
    this.mCC.setTranslationX(this.yca.x + ycc);
    this.mCC.setTranslationY(this.yca.y + ycb);
    AppMethodBeat.o(273100);
  }
  
  public final void Nk(int paramInt)
  {
    AppMethodBeat.i(273094);
    Log.i("Finder.FinderLiveLuckyMoneyBubbleViewCallback", "updateLuckyMoneyCount: count:" + paramInt + ", currentCnt=" + this.ybW + ", pagView:" + this.ybU + ", isPagEnable:" + this.yaB + ", refPoint:" + this.yca);
    Object localObject = this.ybU;
    if ((localObject != null) && (((PAGView)localObject).isPlaying() == true))
    {
      localObject = this.ybU;
      if (localObject != null) {
        ((PAGView)localObject).stop();
      }
    }
    localObject = this.ybU;
    if (localObject != null) {
      ((PAGView)localObject).removeListener((PAGView.PAGViewListener)this.ybV);
    }
    if (paramInt <= 0)
    {
      this.mCC.setVisibility(8);
      localObject = this.ybX;
      if (localObject != null)
      {
        ((r)localObject).setValue(bo.b.yuk);
        AppMethodBeat.o(273094);
        return;
      }
      AppMethodBeat.o(273094);
      return;
    }
    label282:
    float f;
    if (paramInt == 1)
    {
      localObject = this.ybU;
      if (localObject != null) {
        ((PAGView)localObject).setFile(PAGFile.Load(this.activity.getAssets(), "finder_live_lucky_money_section_1.pag"));
      }
      this.ybW = paramInt;
      localObject = this.ybU;
      if (localObject != null) {
        ((PAGView)localObject).setRepeatCount(1);
      }
      localObject = this.ybU;
      if (localObject != null) {
        ((PAGView)localObject).play();
      }
      localObject = this.ybU;
      if (localObject != null) {
        ((PAGView)localObject).addListener((PAGView.PAGViewListener)this.ybV);
      }
      if (this.mCC.getVisibility() != 0)
      {
        localObject = this.ybZ;
        if (localObject == null) {
          break label467;
        }
        localObject = ((t.b)localObject).dxE();
        if (localObject != bk.b.ytT) {
          break label477;
        }
        localObject = this.ybZ.dxF();
        if (localObject == null) {
          break label472;
        }
        f = ((Float)localObject).floatValue();
        label308:
        this.mCC.setTranslationY(f + ycd);
        localObject = this.ybX;
        if (localObject != null) {
          ((r)localObject).setValue(bo.b.yum);
        }
      }
      label336:
      this.mCC.setVisibility(0);
      localObject = this.ybT;
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)("x" + String.valueOf(paramInt)));
      }
      localObject = this.ybT;
      if (localObject == null) {
        break label519;
      }
      if (paramInt != 1) {
        break label514;
      }
    }
    label514:
    for (paramInt = 8;; paramInt = 0)
    {
      ((TextView)localObject).setVisibility(paramInt);
      AppMethodBeat.o(273094);
      return;
      PAGView localPAGView = this.ybU;
      if (localPAGView == null) {
        break;
      }
      if (this.ybW <= 0) {}
      for (localObject = PAGFile.Load(this.activity.getAssets(), "finder_live_lucky_money_complete.pag");; localObject = PAGFile.Load(this.activity.getAssets(), "finder_live_lucky_money_section_2.pag"))
      {
        localPAGView.setFile((PAGFile)localObject);
        break;
      }
      label467:
      localObject = null;
      break label282;
      label472:
      f = 0.0F;
      break label308;
      label477:
      this.mCC.setTranslationY(this.yca.y + ycb);
      localObject = this.ybX;
      if (localObject == null) {
        break label336;
      }
      ((r)localObject).setValue(bo.b.yul);
      break label336;
    }
    label519:
    AppMethodBeat.o(273094);
  }
  
  public final void a(bk.b paramb)
  {
    r localr2 = null;
    r localr1 = null;
    AppMethodBeat.i(273095);
    p.k(paramb, "showingLocation");
    switch (w.$EnumSwitchMapping$0[paramb.ordinal()])
    {
    }
    do
    {
      do
      {
        AppMethodBeat.o(273095);
        return;
        localr2 = this.ybX;
        paramb = localr1;
        if (localr2 != null) {
          paramb = (bo.b)localr2.getValue();
        }
      } while (paramb != bo.b.yum);
      ObjectAnimator.ofFloat(this.mCC, "translationY", new float[] { this.mCC.getTranslationY(), this.yca.y + ycb }).setDuration(500L).start();
      paramb = this.ybX;
      if (paramb != null)
      {
        paramb.setValue(bo.b.yul);
        AppMethodBeat.o(273095);
        return;
      }
      AppMethodBeat.o(273095);
      return;
      localr1 = this.ybX;
      paramb = localr2;
      if (localr1 != null) {
        paramb = (bo.b)localr1.getValue();
      }
    } while (paramb != bo.b.yum);
    paramb = this.ybZ;
    if (paramb != null)
    {
      paramb = paramb.dxF();
      if (paramb == null) {}
    }
    for (float f = paramb.floatValue();; f = 0.0F)
    {
      this.mCC.setTranslationY(f + ycd);
      break;
    }
  }
  
  public final void c(PointF paramPointF)
  {
    AppMethodBeat.i(273090);
    p.k(paramPointF, "refPoint");
    Log.i("Finder.FinderLiveLuckyMoneyBubbleViewCallback", "updateRefPoint refPoint:".concat(String.valueOf(paramPointF)));
    this.yca.set(paramPointF);
    this.mCC.setTranslationX(this.yca.x + ycc);
    this.mCC.setTranslationY(this.yca.y + ycb);
    AppMethodBeat.o(273090);
  }
  
  public final MMFragmentActivity dsB()
  {
    return (MMFragmentActivity)this.activity;
  }
  
  public final float dxG()
  {
    AppMethodBeat.i(273097);
    float f1 = this.mCC.getY();
    float f2 = this.mCC.getHeight();
    AppMethodBeat.o(273097);
    return f1 + f2;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(273092);
    this.ybT = ((TextView)this.mCC.findViewById(b.f.cnt_tv));
    Object localObject = this.ybT;
    if (localObject != null) {
      ((TextView)localObject).setTextSize(1, 22.0F);
    }
    localObject = this.ybT;
    if (localObject != null)
    {
      com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      com.tencent.mm.plugin.finder.live.utils.a.q((TextView)localObject);
    }
    this.ybU = ((PAGView)this.mCC.findViewById(b.f.lucky_money_bubble_view));
    this.ybV = new a(this);
    localObject = this.ybU;
    if (localObject != null) {
      ((PAGView)localObject).addListener((PAGView.PAGViewListener)this.ybV);
    }
    localObject = this.ybU;
    if (localObject != null)
    {
      ((PAGView)localObject).setOnClickListener((View.OnClickListener)new c(this));
      AppMethodBeat.o(273092);
      return;
    }
    AppMethodBeat.o(273092);
  }
  
  public final void release()
  {
    AppMethodBeat.i(273093);
    d.uiThread((kotlin.g.a.a)new d(this));
    AppMethodBeat.o(273093);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleViewCallback$AnimListener;", "Lorg/libpag/PAGView$PAGViewListener;", "viewCallback", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleViewCallback;", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleViewCallback;)V", "rViewCallback", "Ljava/lang/ref/WeakReference;", "getRViewCallback", "()Ljava/lang/ref/WeakReference;", "setRViewCallback", "(Ljava/lang/ref/WeakReference;)V", "onAnimationCancel", "", "view", "Lorg/libpag/PAGView;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class a
    implements PAGView.PAGViewListener
  {
    private WeakReference<v> ycf;
    
    public a(v paramv)
    {
      AppMethodBeat.i(279030);
      this.ycf = new WeakReference(paramv);
      AppMethodBeat.o(279030);
    }
    
    public final void onAnimationCancel(PAGView paramPAGView) {}
    
    public final void onAnimationEnd(PAGView paramPAGView)
    {
      AppMethodBeat.i(279028);
      v localv = (v)this.ycf.get();
      boolean bool;
      PAGView localPAGView;
      if (localv == null)
      {
        bool = true;
        Log.i("Finder.FinderLiveLuckyMoneyBubbleViewCallback", "onAnimationEnd emptyViewCallback:".concat(String.valueOf(bool)));
        if (localv == null) {
          break label155;
        }
        localPAGView = v.a(localv);
        if (localPAGView != null) {
          if (v.b(localv) != 1) {
            break label133;
          }
        }
      }
      label133:
      for (paramPAGView = PAGFile.Load(v.c(localv).getAssets(), "finder_live_lucky_money_repeated_1.pag");; paramPAGView = PAGFile.Load(v.c(localv).getAssets(), "finder_live_lucky_money_repeated_2.pag"))
      {
        localPAGView.setFile(paramPAGView);
        paramPAGView = v.a(localv);
        if (paramPAGView != null) {
          paramPAGView.removeListener((PAGView.PAGViewListener)this);
        }
        paramPAGView = v.a(localv);
        if (paramPAGView != null) {
          paramPAGView.setRepeatCount(0);
        }
        paramPAGView = v.a(localv);
        if (paramPAGView == null) {
          break label149;
        }
        paramPAGView.play();
        AppMethodBeat.o(279028);
        return;
        bool = false;
        break;
      }
      label149:
      AppMethodBeat.o(279028);
      return;
      label155:
      AppMethodBeat.o(279028);
    }
    
    public final void onAnimationRepeat(PAGView paramPAGView) {}
    
    public final void onAnimationStart(PAGView paramPAGView) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleViewCallback$Companion;", "", "()V", "ANIMATION_FILE_REPEATED_1", "", "ANIMATION_FILE_REPEATED_2", "ANIMATION_FILE_SECTION_1", "ANIMATION_FILE_SECTION_2", "ANIMATION_FILE_SECTION_COMPLETE", "ON_LOTTERY_BUBBLE_SHOWN_TRANSLATION_Y", "", "RELATIVE_TRANSLATION_X", "RELATIVE_TRANSLATION_Y", "TAG", "TRANSLATION_DURATION", "", "plugin-finder_release"})
  public static final class b {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(v paramv) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(284562);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleViewCallback$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = this.ycg.ybZ;
      if (paramView != null) {
        paramView.dxs();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleViewCallback$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(284562);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(v paramv)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.v
 * JD-Core Version:    0.7.0.1
 */
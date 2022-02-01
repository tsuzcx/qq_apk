package com.tencent.mm.plugin.finder.live.component;

import android.animation.ObjectAnimator;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.loader.b;
import com.tencent.mm.plugin.finder.loader.p;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.bf;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.bb;
import kotlinx.coroutines.cb;
import org.libpag.PAGFile;
import org.libpag.PAGView;
import org.libpag.PAGView.PAGViewListener;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAllowanceGiftPagViewCallback;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAllowanceGiftPagContract$ViewCallback;", "root", "Landroid/view/View;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAllowanceGiftPagContract$Presenter;", "(Landroid/view/View;Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAllowanceGiftPagContract$Presenter;)V", "animatorJpb", "Lkotlinx/coroutines/Job;", "iconView", "Landroid/widget/ImageView;", "pagViewContainer", "Landroid/widget/FrameLayout;", "realPagView", "Lorg/libpag/PAGView;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getActivity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "getPresenter", "initSmallAnim", "", "isLandscape", "", "onPagAnimationStart", "giftIcon", "", "showPagView", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  implements g.b
{
  public static final i.a Cwx;
  private FrameLayout CwA;
  private PAGView CwB;
  private final g.a Cwy;
  private cb Cwz;
  private final MMActivity activity;
  private ImageView dyS;
  private final View lBX;
  private final aq scope;
  
  static
  {
    AppMethodBeat.i(352952);
    Cwx = new i.a((byte)0);
    AppMethodBeat.o(352952);
  }
  
  public i(View paramView, MMActivity paramMMActivity, g.a parama)
  {
    AppMethodBeat.i(352900);
    this.lBX = paramView;
    this.activity = paramMMActivity;
    this.Cwy = parama;
    this.scope = ar.kBZ();
    this.CwA = ((FrameLayout)this.lBX.findViewById(p.e.BEP));
    this.dyS = ((ImageView)this.lBX.findViewById(p.e.BVG));
    if (this.CwB == null)
    {
      Log.i("FinderLiveAllowanceGiftPagViewCallback", "#initSmallAnim create smallAnim!");
      paramView = this.CwA;
      if (paramView != null) {
        paramView.removeAllViews();
      }
      this.CwB = new PAGView(this.lBX.getContext());
      paramView = this.CwB;
      if (paramView != null) {
        paramView.setScaleMode(1);
      }
      paramView = this.CwA;
      if (paramView != null) {
        paramView.addView((View)this.CwB);
      }
    }
    AppMethodBeat.o(352900);
  }
  
  public final void awl(final String paramString)
  {
    AppMethodBeat.i(352969);
    Log.i("FinderLiveAllowanceGiftPagViewCallback", s.X("#showPagView giftIcon=", paramString));
    PAGView localPAGView = this.CwB;
    Object localObject1;
    if (localPAGView != null)
    {
      localPAGView.addListener((PAGView.PAGViewListener)new d(this, paramString));
      localObject1 = this.dyS;
      if (localObject1 != null)
      {
        ((ImageView)localObject1).setVisibility(8);
        if (paramString == null) {
          break label229;
        }
        if (((CharSequence)paramString).length() <= 0) {
          break label224;
        }
        i = 1;
        if (i != 1) {
          break label229;
        }
      }
    }
    label224:
    label229:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Object localObject2 = p.ExI;
        localObject2 = p.eCl();
        paramString = new b(paramString);
        p localp = p.ExI;
        ((com.tencent.mm.loader.d)localObject2).a(paramString, (ImageView)localObject1, p.a(p.a.ExM));
      }
      paramString = bf.bf(MMApplicationContext.getContext());
      i = Math.min(paramString.x, paramString.y);
      paramString = new FrameLayout.LayoutParams(i, i);
      localObject1 = this.CwB;
      if (localObject1 != null) {
        ((PAGView)localObject1).setLayoutParams((ViewGroup.LayoutParams)paramString);
      }
      localPAGView.stop();
      localPAGView.setFile(PAGFile.Load(this.activity.getAssets(), "finder_live_allowance_gift_bubble_trans.pag"));
      localPAGView.setRepeatCount(1);
      localPAGView.setProgress(0.0D);
      localPAGView.play();
      localPAGView.flush();
      AppMethodBeat.o(352969);
      return;
      i = 0;
      break;
    }
  }
  
  public final MMFragmentActivity dUP()
  {
    return (MMFragmentActivity)this.activity;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    b(i parami, FrameLayout paramFrameLayout, String paramString, kotlin.d.d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(352887);
      paramObject = (kotlin.d.d)new b(this.CwC, this.CwD, this.CwE, paramd);
      AppMethodBeat.o(352887);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(352877);
      a locala = a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(352877);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        Log.i("FinderLiveAllowanceGiftPagViewCallback", "#onPagAnimationStart scope launch");
        float f1 = bf.bf(MMApplicationContext.getContext()).x / 2.0F;
        float f2 = com.tencent.mm.view.d.e(i.a(this.CwC).getContext(), 36.0F);
        paramObject = ObjectAnimator.ofFloat(this.CwD, "translationX", new float[] { f1 - f2, 0.0F });
        paramObject.setDuration(250L);
        paramObject.start();
        i.a(this.CwC).setVisibility(0);
        paramObject = (kotlin.d.d)this;
        this.label = 1;
        if (bb.e(1250L, paramObject) == locala)
        {
          AppMethodBeat.o(352877);
          return locala;
        }
      case 1: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.CwE;
        i locali = this.CwC;
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 2;
        if (i.a(paramObject, locali, locald) != locala) {
          break label225;
        }
        AppMethodBeat.o(352877);
        return locala;
      }
      ResultKt.throwOnFailure(paramObject);
      label225:
      paramObject = ah.aiuX;
      AppMethodBeat.o(352877);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    int label;
    
    c(kotlin.d.d<? super c> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(352914);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = i.a(null, null, (kotlin.d.d)this);
      AppMethodBeat.o(352914);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/component/FinderLiveAllowanceGiftPagViewCallback$showPagView$1$1", "Lorg/libpag/PAGView$PAGViewListener;", "onAnimationCancel", "", "view", "Lorg/libpag/PAGView;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements PAGView.PAGViewListener
  {
    d(i parami, String paramString) {}
    
    public final void onAnimationCancel(PAGView paramPAGView)
    {
      AppMethodBeat.i(352912);
      Log.i("FinderLiveAllowanceGiftPagViewCallback", s.X("#onAnimationCancel view=", paramPAGView));
      i.a(this.CwC).setVisibility(8);
      AppMethodBeat.o(352912);
    }
    
    public final void onAnimationEnd(PAGView paramPAGView)
    {
      AppMethodBeat.i(352902);
      Log.i("FinderLiveAllowanceGiftPagViewCallback", s.X("#onAnimationEnd view=", paramPAGView));
      i.a(this.CwC).setVisibility(8);
      AppMethodBeat.o(352902);
    }
    
    public final void onAnimationRepeat(PAGView paramPAGView)
    {
      AppMethodBeat.i(352921);
      Log.i("FinderLiveAllowanceGiftPagViewCallback", s.X("#onAnimationRepeat view=", paramPAGView));
      AppMethodBeat.o(352921);
    }
    
    public final void onAnimationStart(PAGView paramPAGView)
    {
      AppMethodBeat.i(352894);
      Log.i("FinderLiveAllowanceGiftPagViewCallback", s.X("#onAnimationStart view=", paramPAGView));
      i.a(this.CwC, paramString);
      AppMethodBeat.o(352894);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.i
 * JD-Core Version:    0.7.0.1
 */
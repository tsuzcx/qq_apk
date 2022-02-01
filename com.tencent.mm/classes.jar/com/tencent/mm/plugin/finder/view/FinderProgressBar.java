package com.tencent.mm.plugin.finder.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderProgressBar;", "Landroid/widget/FrameLayout;", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isEnableSeek", "", "lastX", "", "listener", "getListener", "()Landroid/widget/SeekBar$OnSeekBarChangeListener;", "setListener", "(Landroid/widget/SeekBar$OnSeekBarChangeListener;)V", "seekBar", "Landroid/widget/SeekBar;", "kotlin.jvm.PlatformType", "getSeekBar", "()Landroid/widget/SeekBar;", "seekBar$delegate", "Lkotlin/Lazy;", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "onProgressChanged", "", "progress", "fromUser", "onStartTrackingTouch", "onStopTrackingTouch", "showSeekBar", "isShow", "delay", "", "Companion", "plugin-finder_release"})
public final class FinderProgressBar
  extends FrameLayout
  implements SeekBar.OnSeekBarChangeListener
{
  public static final b woC;
  private float aTD;
  private final f vMb;
  private boolean woA;
  private SeekBar.OnSeekBarChangeListener woB;
  
  static
  {
    AppMethodBeat.i(168407);
    woC = new b((byte)0);
    AppMethodBeat.o(168407);
  }
  
  public FinderProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168414);
    LayoutInflater.from(getContext()).inflate(2131494673, (ViewGroup)this, true);
    paramContext = (SeekBar)findViewById(2131307482);
    if (paramContext != null)
    {
      setAlpha(0.0F);
      paramContext.setOnTouchListener((View.OnTouchListener)a.woD);
    }
    setOnLongClickListener((View.OnLongClickListener)new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(168402);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderProgressBar$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
        Log.i("Finder.ProgressBar", "onLongClick...");
        FinderProgressBar.b(this.woE);
        paramAnonymousView.performHapticFeedback(0, 2);
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/finder/view/FinderProgressBar$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(168402);
        return false;
      }
    });
    this.vMb = g.ah((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(168414);
  }
  
  public FinderProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168415);
    LayoutInflater.from(getContext()).inflate(2131494673, (ViewGroup)this, true);
    paramContext = (SeekBar)findViewById(2131307482);
    if (paramContext != null)
    {
      setAlpha(0.0F);
      paramContext.setOnTouchListener((View.OnTouchListener)a.woD);
    }
    setOnLongClickListener((View.OnLongClickListener)new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(168402);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderProgressBar$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
        Log.i("Finder.ProgressBar", "onLongClick...");
        FinderProgressBar.b(this.woE);
        paramAnonymousView.performHapticFeedback(0, 2);
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/finder/view/FinderProgressBar$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(168402);
        return false;
      }
    });
    this.vMb = g.ah((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(168415);
  }
  
  private final SeekBar getSeekBar()
  {
    AppMethodBeat.i(168409);
    SeekBar localSeekBar = (SeekBar)this.vMb.getValue();
    AppMethodBeat.o(168409);
    return localSeekBar;
  }
  
  private final void oZ(boolean paramBoolean)
  {
    AppMethodBeat.i(168410);
    if (paramBoolean)
    {
      localOnSeekBarChangeListener = this.woB;
      if (localOnSeekBarChangeListener != null) {
        localOnSeekBarChangeListener.onStartTrackingTouch(getSeekBar());
      }
      animate().cancel();
      animate().alpha(1.0F).withStartAction((Runnable)new d(this)).setListener((Animator.AnimatorListener)new e(this)).setDuration(300L).alpha(1.0F).setStartDelay(0L).start();
      AppMethodBeat.o(168410);
      return;
    }
    SeekBar.OnSeekBarChangeListener localOnSeekBarChangeListener = this.woB;
    if (localOnSeekBarChangeListener != null) {
      localOnSeekBarChangeListener.onStopTrackingTouch(getSeekBar());
    }
    animate().cancel();
    animate().alpha(0.0F).setListener((Animator.AnimatorListener)new f(this)).setDuration(300L).setStartDelay(0L).start();
    AppMethodBeat.o(168410);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(168408);
    p.h(paramMotionEvent, "event");
    if ((this.woA) && (paramMotionEvent.getAction() == 0))
    {
      animate().cancel();
      setAlpha(1.0F);
    }
    do
    {
      for (;;)
      {
        this.aTD = paramMotionEvent.getX();
        boolean bool = super.dispatchTouchEvent(paramMotionEvent);
        AppMethodBeat.o(168408);
        return bool;
        if ((paramMotionEvent.getAction() != 1) && (paramMotionEvent.getAction() != 3)) {
          break;
        }
        if (this.woA) {
          oZ(false);
        }
      }
    } while ((paramMotionEvent.getAction() != 2) || (!this.woA));
    float f3 = this.aTD - paramMotionEvent.getX();
    float f1 = Math.abs(f3);
    SeekBar localSeekBar = getSeekBar();
    p.g(localSeekBar, "seekBar");
    float f2 = localSeekBar.getProgress();
    if (f3 < 0.0F) {}
    for (;;)
    {
      localSeekBar = getSeekBar();
      p.g(localSeekBar, "seekBar");
      localSeekBar.setProgress((int)(f1 + f2));
      break;
      f1 = -f1;
    }
  }
  
  public final SeekBar.OnSeekBarChangeListener getListener()
  {
    return this.woB;
  }
  
  public final void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(168411);
    p.h(paramSeekBar, "seekBar");
    SeekBar.OnSeekBarChangeListener localOnSeekBarChangeListener = this.woB;
    if (localOnSeekBarChangeListener != null)
    {
      localOnSeekBarChangeListener.onProgressChanged(paramSeekBar, paramInt, paramBoolean);
      AppMethodBeat.o(168411);
      return;
    }
    AppMethodBeat.o(168411);
  }
  
  public final void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    AppMethodBeat.i(168412);
    p.h(paramSeekBar, "seekBar");
    AppMethodBeat.o(168412);
  }
  
  public final void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    AppMethodBeat.i(168413);
    p.h(paramSeekBar, "seekBar");
    AppMethodBeat.o(168413);
  }
  
  public final void setListener(SeekBar.OnSeekBarChangeListener paramOnSeekBarChangeListener)
  {
    this.woB = paramOnSeekBarChangeListener;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
  static final class a
    implements View.OnTouchListener
  {
    public static final a woD;
    
    static
    {
      AppMethodBeat.i(168401);
      woD = new a();
      AppMethodBeat.o(168401);
    }
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderProgressBar$Companion;", "", "()V", "ANIMATION_DURATION", "", "DISMISS_DELAY", "TAG", "", "plugin-finder_release"})
  public static final class b {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/SeekBar;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<SeekBar>
  {
    c(FinderProgressBar paramFinderProgressBar)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(FinderProgressBar paramFinderProgressBar) {}
    
    public final void run()
    {
      AppMethodBeat.i(168404);
      this.woE.setAlpha(0.0F);
      this.woE.setVisibility(0);
      FinderProgressBar.a(this.woE, true);
      AppMethodBeat.o(168404);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/view/FinderProgressBar$showSeekBar$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class e
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(254905);
      paramAnimator = FinderProgressBar.a(this.woE);
      p.g(paramAnimator, "seekBar");
      paramAnimator.setAlpha(1.0F);
      AppMethodBeat.o(254905);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/view/FinderProgressBar$showSeekBar$3", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class f
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(254906);
      this.woE.setAlpha(0.0F);
      FinderProgressBar.a(this.woE, false);
      AppMethodBeat.o(254906);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderProgressBar
 * JD-Core Version:    0.7.0.1
 */
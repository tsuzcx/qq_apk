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
import com.tencent.mm.sdk.platformtools.ad;
import d.f;
import d.g;
import d.g.b.p;
import d.g.b.q;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/FinderProgressBar;", "Landroid/widget/FrameLayout;", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isEnableSeek", "", "lastX", "", "listener", "getListener", "()Landroid/widget/SeekBar$OnSeekBarChangeListener;", "setListener", "(Landroid/widget/SeekBar$OnSeekBarChangeListener;)V", "seekBar", "Landroid/widget/SeekBar;", "kotlin.jvm.PlatformType", "getSeekBar", "()Landroid/widget/SeekBar;", "seekBar$delegate", "Lkotlin/Lazy;", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "onProgressChanged", "", "progress", "fromUser", "onStartTrackingTouch", "onStopTrackingTouch", "showSeekBar", "isShow", "delay", "", "Companion", "plugin-finder_release"})
public final class FinderProgressBar
  extends FrameLayout
  implements SeekBar.OnSeekBarChangeListener
{
  public static final FinderProgressBar.b sVt;
  private float aTL;
  private boolean sVq;
  private final f sVr;
  private SeekBar.OnSeekBarChangeListener sVs;
  
  static
  {
    AppMethodBeat.i(168407);
    sVt = new FinderProgressBar.b((byte)0);
    AppMethodBeat.o(168407);
  }
  
  public FinderProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168414);
    LayoutInflater.from(getContext()).inflate(2131494125, (ViewGroup)this, true);
    paramContext = (SeekBar)findViewById(2131304485);
    if (paramContext != null)
    {
      setAlpha(0.0F);
      paramContext.setOnTouchListener((View.OnTouchListener)FinderProgressBar.a.sVu);
    }
    setOnLongClickListener((View.OnLongClickListener)new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(168402);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderProgressBar$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahq());
        ad.i("Finder.ProgressBar", "onLongClick...");
        FinderProgressBar.b(this.sVv);
        paramAnonymousView.performHapticFeedback(0, 2);
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/finder/view/FinderProgressBar$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(168402);
        return false;
      }
    });
    this.sVr = g.O((d.g.a.a)new c(this));
    AppMethodBeat.o(168414);
  }
  
  public FinderProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168415);
    LayoutInflater.from(getContext()).inflate(2131494125, (ViewGroup)this, true);
    paramContext = (SeekBar)findViewById(2131304485);
    if (paramContext != null)
    {
      setAlpha(0.0F);
      paramContext.setOnTouchListener((View.OnTouchListener)FinderProgressBar.a.sVu);
    }
    setOnLongClickListener((View.OnLongClickListener)new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(168402);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderProgressBar$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahq());
        ad.i("Finder.ProgressBar", "onLongClick...");
        FinderProgressBar.b(this.sVv);
        paramAnonymousView.performHapticFeedback(0, 2);
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/finder/view/FinderProgressBar$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(168402);
        return false;
      }
    });
    this.sVr = g.O((d.g.a.a)new c(this));
    AppMethodBeat.o(168415);
  }
  
  private final SeekBar getSeekBar()
  {
    AppMethodBeat.i(168409);
    SeekBar localSeekBar = (SeekBar)this.sVr.getValue();
    AppMethodBeat.o(168409);
    return localSeekBar;
  }
  
  private final void mr(boolean paramBoolean)
  {
    AppMethodBeat.i(168410);
    if (paramBoolean)
    {
      localOnSeekBarChangeListener = this.sVs;
      if (localOnSeekBarChangeListener != null) {
        localOnSeekBarChangeListener.onStartTrackingTouch(getSeekBar());
      }
      animate().cancel();
      animate().alpha(1.0F).withStartAction((Runnable)new d(this)).setListener((Animator.AnimatorListener)new e(this)).setDuration(300L).alpha(1.0F).setStartDelay(0L).start();
      AppMethodBeat.o(168410);
      return;
    }
    SeekBar.OnSeekBarChangeListener localOnSeekBarChangeListener = this.sVs;
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
    if ((this.sVq) && (paramMotionEvent.getAction() == 0))
    {
      animate().cancel();
      setAlpha(1.0F);
    }
    do
    {
      for (;;)
      {
        this.aTL = paramMotionEvent.getX();
        boolean bool = super.dispatchTouchEvent(paramMotionEvent);
        AppMethodBeat.o(168408);
        return bool;
        if ((paramMotionEvent.getAction() != 1) && (paramMotionEvent.getAction() != 3)) {
          break;
        }
        if (this.sVq) {
          mr(false);
        }
      }
    } while ((paramMotionEvent.getAction() != 2) || (!this.sVq));
    float f3 = this.aTL - paramMotionEvent.getX();
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
    return this.sVs;
  }
  
  public final void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(168411);
    p.h(paramSeekBar, "seekBar");
    SeekBar.OnSeekBarChangeListener localOnSeekBarChangeListener = this.sVs;
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
    this.sVs = paramOnSeekBarChangeListener;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/widget/SeekBar;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<SeekBar>
  {
    c(FinderProgressBar paramFinderProgressBar)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(FinderProgressBar paramFinderProgressBar) {}
    
    public final void run()
    {
      AppMethodBeat.i(168404);
      this.sVv.setAlpha(0.0F);
      this.sVv.setVisibility(0);
      FinderProgressBar.a(this.sVv, true);
      AppMethodBeat.o(168404);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/view/FinderProgressBar$showSeekBar$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class e
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(221571);
      paramAnimator = FinderProgressBar.a(this.sVv);
      p.g(paramAnimator, "seekBar");
      paramAnimator.setAlpha(1.0F);
      AppMethodBeat.o(221571);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/view/FinderProgressBar$showSeekBar$3", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class f
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(221572);
      this.sVv.setAlpha(0.0F);
      FinderProgressBar.a(this.sVv, false);
      AppMethodBeat.o(221572);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderProgressBar
 * JD-Core Version:    0.7.0.1
 */
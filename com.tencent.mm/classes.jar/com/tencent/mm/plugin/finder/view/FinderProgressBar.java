package com.tencent.mm.plugin.finder.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderProgressBar;", "Landroid/widget/FrameLayout;", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isEnableSeek", "", "lastX", "", "listener", "getListener", "()Landroid/widget/SeekBar$OnSeekBarChangeListener;", "setListener", "(Landroid/widget/SeekBar$OnSeekBarChangeListener;)V", "seekBar", "Landroid/widget/SeekBar;", "kotlin.jvm.PlatformType", "getSeekBar", "()Landroid/widget/SeekBar;", "seekBar$delegate", "Lkotlin/Lazy;", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "onProgressChanged", "", "progress", "fromUser", "onStartTrackingTouch", "onStopTrackingTouch", "showSeekBar", "isShow", "delay", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderProgressBar
  extends FrameLayout
  implements SeekBar.OnSeekBarChangeListener
{
  public static final FinderProgressBar.a GBL;
  private final j FSi;
  private boolean GBM;
  private SeekBar.OnSeekBarChangeListener GBN;
  private float cxM;
  
  static
  {
    AppMethodBeat.i(168407);
    GBL = new FinderProgressBar.a((byte)0);
    AppMethodBeat.o(168407);
  }
  
  public FinderProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168414);
    LayoutInflater.from(getContext()).inflate(e.f.finder_video_seek_bar, (ViewGroup)this, true);
    paramContext = (SeekBar)findViewById(e.e.seek_bar);
    if (paramContext != null)
    {
      setAlpha(0.0F);
      paramContext.setOnTouchListener(FinderProgressBar..ExternalSyntheticLambda1.INSTANCE);
    }
    setOnLongClickListener(new FinderProgressBar..ExternalSyntheticLambda0(this));
    this.FSi = k.cm((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(168414);
  }
  
  public FinderProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168415);
    LayoutInflater.from(getContext()).inflate(e.f.finder_video_seek_bar, (ViewGroup)this, true);
    paramContext = (SeekBar)findViewById(e.e.seek_bar);
    if (paramContext != null)
    {
      setAlpha(0.0F);
      paramContext.setOnTouchListener(FinderProgressBar..ExternalSyntheticLambda1.INSTANCE);
    }
    setOnLongClickListener(new FinderProgressBar..ExternalSyntheticLambda0(this));
    this.FSi = k.cm((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(168415);
  }
  
  private static final void a(FinderProgressBar paramFinderProgressBar)
  {
    AppMethodBeat.i(344333);
    s.u(paramFinderProgressBar, "this$0");
    paramFinderProgressBar.setAlpha(0.0F);
    paramFinderProgressBar.setVisibility(0);
    paramFinderProgressBar.GBM = true;
    AppMethodBeat.o(344333);
  }
  
  private static final boolean a(FinderProgressBar paramFinderProgressBar, View paramView)
  {
    AppMethodBeat.i(344326);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramFinderProgressBar);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderProgressBar", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", localObject, localb.aYj());
    s.u(paramFinderProgressBar, "this$0");
    Log.i("Finder.ProgressBar", "onLongClick...");
    paramFinderProgressBar.uX(true);
    paramView.performHapticFeedback(0, 2);
    com.tencent.mm.hellhoundlib.a.a.a(false, new Object(), "com/tencent/mm/plugin/finder/view/FinderProgressBar", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(344326);
    return false;
  }
  
  private static final boolean g(View paramView, MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  private final SeekBar getSeekBar()
  {
    AppMethodBeat.i(168409);
    SeekBar localSeekBar = (SeekBar)this.FSi.getValue();
    AppMethodBeat.o(168409);
    return localSeekBar;
  }
  
  private final void uX(boolean paramBoolean)
  {
    AppMethodBeat.i(168410);
    if (paramBoolean)
    {
      localOnSeekBarChangeListener = this.GBN;
      if (localOnSeekBarChangeListener != null) {
        localOnSeekBarChangeListener.onStartTrackingTouch(getSeekBar());
      }
      animate().cancel();
      animate().alpha(1.0F).withStartAction(new FinderProgressBar..ExternalSyntheticLambda2(this)).setListener((Animator.AnimatorListener)new c(this)).setDuration(300L).alpha(1.0F).setStartDelay(0L).start();
      AppMethodBeat.o(168410);
      return;
    }
    SeekBar.OnSeekBarChangeListener localOnSeekBarChangeListener = this.GBN;
    if (localOnSeekBarChangeListener != null) {
      localOnSeekBarChangeListener.onStopTrackingTouch(getSeekBar());
    }
    animate().cancel();
    animate().alpha(0.0F).setListener((Animator.AnimatorListener)new d(this)).setDuration(300L).setStartDelay(0L).start();
    AppMethodBeat.o(168410);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(168408);
    s.u(paramMotionEvent, "event");
    if ((this.GBM) && (paramMotionEvent.getAction() == 0))
    {
      animate().cancel();
      setAlpha(1.0F);
    }
    do
    {
      for (;;)
      {
        this.cxM = paramMotionEvent.getX();
        boolean bool = super.dispatchTouchEvent(paramMotionEvent);
        AppMethodBeat.o(168408);
        return bool;
        if ((paramMotionEvent.getAction() != 1) && (paramMotionEvent.getAction() != 3)) {
          break;
        }
        if (this.GBM) {
          uX(false);
        }
      }
    } while ((paramMotionEvent.getAction() != 2) || (!this.GBM));
    float f3 = this.cxM - paramMotionEvent.getX();
    float f1 = Math.abs(f3);
    float f2 = getSeekBar().getProgress();
    if (f3 < 0.0F) {}
    for (;;)
    {
      getSeekBar().setProgress((int)(f1 + f2));
      break;
      f1 = -f1;
    }
  }
  
  public final SeekBar.OnSeekBarChangeListener getListener()
  {
    return this.GBN;
  }
  
  public final void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(168411);
    s.u(paramSeekBar, "seekBar");
    SeekBar.OnSeekBarChangeListener localOnSeekBarChangeListener = this.GBN;
    if (localOnSeekBarChangeListener != null) {
      localOnSeekBarChangeListener.onProgressChanged(paramSeekBar, paramInt, paramBoolean);
    }
    AppMethodBeat.o(168411);
  }
  
  public final void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    AppMethodBeat.i(168412);
    s.u(paramSeekBar, "seekBar");
    AppMethodBeat.o(168412);
  }
  
  public final void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    AppMethodBeat.i(168413);
    s.u(paramSeekBar, "seekBar");
    AppMethodBeat.o(168413);
  }
  
  public final void setListener(SeekBar.OnSeekBarChangeListener paramOnSeekBarChangeListener)
  {
    this.GBN = paramOnSeekBarChangeListener;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/SeekBar;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<SeekBar>
  {
    b(FinderProgressBar paramFinderProgressBar)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/FinderProgressBar$showSeekBar$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements Animator.AnimatorListener
  {
    c(FinderProgressBar paramFinderProgressBar) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(345045);
      FinderProgressBar.b(this.GBO).setAlpha(1.0F);
      AppMethodBeat.o(345045);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/FinderProgressBar$showSeekBar$3", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements Animator.AnimatorListener
  {
    d(FinderProgressBar paramFinderProgressBar) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(345040);
      this.GBO.setAlpha(0.0F);
      FinderProgressBar.c(this.GBO);
      AppMethodBeat.o(345040);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderProgressBar
 * JD-Core Version:    0.7.0.1
 */
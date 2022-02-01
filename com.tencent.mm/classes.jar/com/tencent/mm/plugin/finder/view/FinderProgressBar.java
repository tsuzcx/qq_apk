package com.tencent.mm.plugin.finder.view;

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
import com.tencent.mm.sdk.platformtools.ad;
import d.f;
import d.g;
import d.g.a.a;
import d.g.b.u;
import d.g.b.w;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/FinderProgressBar;", "Landroid/widget/FrameLayout;", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isEnableSeek", "", "lastX", "", "listener", "getListener", "()Landroid/widget/SeekBar$OnSeekBarChangeListener;", "setListener", "(Landroid/widget/SeekBar$OnSeekBarChangeListener;)V", "seekBar", "Landroid/widget/SeekBar;", "kotlin.jvm.PlatformType", "getSeekBar", "()Landroid/widget/SeekBar;", "seekBar$delegate", "Lkotlin/Lazy;", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "onProgressChanged", "", "progress", "fromUser", "onStartTrackingTouch", "onStopTrackingTouch", "showSeekBar", "isShow", "delay", "", "Companion", "plugin-finder_release"})
public final class FinderProgressBar
  extends FrameLayout
  implements SeekBar.OnSeekBarChangeListener
{
  public static final b qXN;
  private boolean qXJ;
  private float qXK;
  private final f qXL;
  private SeekBar.OnSeekBarChangeListener qXM;
  
  static
  {
    AppMethodBeat.i(168407);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(FinderProgressBar.class), "seekBar", "getSeekBar()Landroid/widget/SeekBar;")) };
    qXN = new b((byte)0);
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
      paramContext.setOnTouchListener((View.OnTouchListener)FinderProgressBar.a.qXO);
    }
    setOnLongClickListener((View.OnLongClickListener)new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(168402);
        ad.i("Finder.ProgressBar", "onLongClick...");
        FinderProgressBar.b(this.qXP);
        paramAnonymousView.performHapticFeedback(0, 2);
        AppMethodBeat.o(168402);
        return false;
      }
    });
    this.qXL = g.E((a)new c(this));
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
      paramContext.setOnTouchListener((View.OnTouchListener)FinderProgressBar.a.qXO);
    }
    setOnLongClickListener((View.OnLongClickListener)new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(168402);
        ad.i("Finder.ProgressBar", "onLongClick...");
        FinderProgressBar.b(this.qXP);
        paramAnonymousView.performHapticFeedback(0, 2);
        AppMethodBeat.o(168402);
        return false;
      }
    });
    this.qXL = g.E((a)new c(this));
    AppMethodBeat.o(168415);
  }
  
  private final SeekBar getSeekBar()
  {
    AppMethodBeat.i(168409);
    SeekBar localSeekBar = (SeekBar)this.qXL.getValue();
    AppMethodBeat.o(168409);
    return localSeekBar;
  }
  
  private final void lm(boolean paramBoolean)
  {
    AppMethodBeat.i(168410);
    if (paramBoolean)
    {
      localOnSeekBarChangeListener = this.qXM;
      if (localOnSeekBarChangeListener != null) {
        localOnSeekBarChangeListener.onStartTrackingTouch(getSeekBar());
      }
      animate().cancel();
      animate().alpha(1.0F).withStartAction((Runnable)new d(this)).withEndAction((Runnable)new e(this)).setDuration(300L).alpha(1.0F).setStartDelay(0L).start();
      AppMethodBeat.o(168410);
      return;
    }
    SeekBar.OnSeekBarChangeListener localOnSeekBarChangeListener = this.qXM;
    if (localOnSeekBarChangeListener != null) {
      localOnSeekBarChangeListener.onStopTrackingTouch(getSeekBar());
    }
    animate().cancel();
    animate().alpha(0.0F).withEndAction((Runnable)new f(this)).setDuration(300L).setStartDelay(0L).start();
    AppMethodBeat.o(168410);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(168408);
    d.g.b.k.h(paramMotionEvent, "event");
    if ((this.qXJ) && (paramMotionEvent.getAction() == 0))
    {
      animate().cancel();
      setAlpha(1.0F);
    }
    do
    {
      for (;;)
      {
        this.qXK = paramMotionEvent.getX();
        boolean bool = super.dispatchTouchEvent(paramMotionEvent);
        AppMethodBeat.o(168408);
        return bool;
        if ((paramMotionEvent.getAction() != 1) && (paramMotionEvent.getAction() != 3)) {
          break;
        }
        if (this.qXJ) {
          lm(false);
        }
      }
    } while ((paramMotionEvent.getAction() != 2) || (!this.qXJ));
    float f3 = this.qXK - paramMotionEvent.getX();
    float f1 = Math.abs(f3);
    SeekBar localSeekBar = getSeekBar();
    d.g.b.k.g(localSeekBar, "seekBar");
    float f2 = localSeekBar.getProgress();
    if (f3 < 0.0F) {}
    for (;;)
    {
      localSeekBar = getSeekBar();
      d.g.b.k.g(localSeekBar, "seekBar");
      localSeekBar.setProgress((int)(f1 + f2));
      break;
      f1 = -f1;
    }
  }
  
  public final SeekBar.OnSeekBarChangeListener getListener()
  {
    return this.qXM;
  }
  
  public final void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(168411);
    d.g.b.k.h(paramSeekBar, "seekBar");
    SeekBar.OnSeekBarChangeListener localOnSeekBarChangeListener = this.qXM;
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
    d.g.b.k.h(paramSeekBar, "seekBar");
    AppMethodBeat.o(168412);
  }
  
  public final void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    AppMethodBeat.i(168413);
    d.g.b.k.h(paramSeekBar, "seekBar");
    AppMethodBeat.o(168413);
  }
  
  public final void setListener(SeekBar.OnSeekBarChangeListener paramOnSeekBarChangeListener)
  {
    this.qXM = paramOnSeekBarChangeListener;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/FinderProgressBar$Companion;", "", "()V", "ANIMATION_DURATION", "", "DISMISS_DELAY", "TAG", "", "plugin-finder_release"})
  public static final class b {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/widget/SeekBar;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends d.g.b.l
    implements a<SeekBar>
  {
    c(FinderProgressBar paramFinderProgressBar)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(FinderProgressBar paramFinderProgressBar) {}
    
    public final void run()
    {
      AppMethodBeat.i(168404);
      this.qXP.setAlpha(0.0F);
      this.qXP.setVisibility(0);
      FinderProgressBar.a(this.qXP, true);
      AppMethodBeat.o(168404);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(FinderProgressBar paramFinderProgressBar) {}
    
    public final void run()
    {
      AppMethodBeat.i(168405);
      SeekBar localSeekBar = FinderProgressBar.a(this.qXP);
      d.g.b.k.g(localSeekBar, "seekBar");
      localSeekBar.setAlpha(1.0F);
      AppMethodBeat.o(168405);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(FinderProgressBar paramFinderProgressBar) {}
    
    public final void run()
    {
      AppMethodBeat.i(168406);
      this.qXP.setAlpha(0.0F);
      FinderProgressBar.a(this.qXP, false);
      AppMethodBeat.o(168406);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderProgressBar
 * JD-Core Version:    0.7.0.1
 */
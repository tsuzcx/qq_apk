package com.tencent.mm.plugin.finder.utils;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/LongClickUtils;", "", "()V", "TAG", "", "setLongClick", "", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "longClickView", "Landroid/view/View;", "delayMillis", "", "longClickListener", "Landroid/view/View$OnLongClickListener;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class be
{
  public static final be GlC;
  
  static
  {
    AppMethodBeat.i(333071);
    GlC = new be();
    AppMethodBeat.o(333071);
  }
  
  private static final void a(View.OnLongClickListener paramOnLongClickListener, View paramView)
  {
    AppMethodBeat.i(333063);
    s.u(paramView, "$longClickView");
    Log.i("LongClickUtils", "Runnable handle.");
    if (paramOnLongClickListener != null) {
      paramOnLongClickListener.onLongClick(paramView);
    }
    paramView.setOnTouchListener(null);
    AppMethodBeat.o(333063);
  }
  
  public static void a(MMHandler paramMMHandler, final View paramView, final View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(333056);
    s.u(paramMMHandler, "handler");
    s.u(paramView, "longClickView");
    paramOnLongClickListener = new be..ExternalSyntheticLambda0(paramOnLongClickListener, paramView);
    paramMMHandler.postDelayed(paramOnLongClickListener, 5000L);
    paramView.setOnTouchListener((View.OnTouchListener)new a(paramMMHandler, paramOnLongClickListener, paramView));
    AppMethodBeat.o(333056);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/utils/LongClickUtils$setLongClick$1", "Landroid/view/View$OnTouchListener;", "TOUCH_MAX", "", "mLastMotionX", "mLastMotionY", "onTouch", "", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements View.OnTouchListener
  {
    private final int GlD = 50;
    private int GlE;
    private int bwC;
    
    a(MMHandler paramMMHandler, Runnable paramRunnable, View paramView) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(332975);
      s.u(paramView, "v");
      s.u(paramMotionEvent, "event");
      int i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      switch (paramMotionEvent.getAction())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(332975);
        return true;
        this.GlF.removeCallbacks(paramOnLongClickListener);
        paramView.setOnTouchListener(null);
        Log.i("LongClickUtils", "ACTION_UP");
        continue;
        this.GlF.removeCallbacks(paramOnLongClickListener);
        this.GlE = i;
        this.bwC = j;
        this.GlF.postDelayed(paramOnLongClickListener, this.GlI);
        Log.i("LongClickUtils", s.X("ACTION_DOWN type:", Integer.valueOf(paramMotionEvent.getAction())));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.be
 * JD-Core Version:    0.7.0.1
 */
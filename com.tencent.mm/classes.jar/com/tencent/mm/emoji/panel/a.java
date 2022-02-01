package com.tencent.mm.emoji.panel;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/panel/TouchToClick;", "Landroid/view/View$OnTouchListener;", "()V", "clickHandler", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "clicked", "", "cancel", "", "onTouch", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements View.OnTouchListener
{
  MTimerHandler mkF;
  private boolean mkG;
  
  private static final boolean a(a parama, View paramView)
  {
    AppMethodBeat.i(242345);
    s.u(parama, "this$0");
    s.u(paramView, "$v");
    parama.mkG = true;
    boolean bool = paramView.performClick();
    AppMethodBeat.o(242345);
    return bool;
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(105625);
    s.u(paramView, "v");
    s.u(paramMotionEvent, "event");
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(105625);
      return true;
      this.mkG = false;
      this.mkF = new MTimerHandler(new a..ExternalSyntheticLambda0(this, paramView), true);
      paramView = this.mkF;
      if (paramView != null)
      {
        paramView.startTimer(ViewConfiguration.getKeyRepeatTimeout(), ViewConfiguration.getKeyRepeatDelay());
        continue;
        MTimerHandler localMTimerHandler = this.mkF;
        if (localMTimerHandler != null) {
          localMTimerHandler.stopTimer();
        }
        this.mkF = null;
        if ((!this.mkG) && (paramMotionEvent.getActionMasked() == 1)) {
          paramView.performClick();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a
 * JD-Core Version:    0.7.0.1
 */
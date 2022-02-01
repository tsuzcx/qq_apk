package com.tencent.mm.emoji.panel;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/panel/TouchToClick;", "Landroid/view/View$OnTouchListener;", "()V", "clickHandler", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "clicked", "", "cancel", "", "onTouch", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "plugin-emojisdk_release"})
public final class a
  implements View.OnTouchListener
{
  MTimerHandler hat;
  private boolean hau;
  
  public final boolean onTouch(final View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(105625);
    p.h(paramView, "v");
    p.h(paramMotionEvent, "event");
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(105625);
      return true;
      this.hau = false;
      this.hat = new MTimerHandler((MTimerHandler.CallBack)new a(this, paramView), true);
      paramView = this.hat;
      if (paramView != null)
      {
        paramView.startTimer(ViewConfiguration.getKeyRepeatTimeout(), ViewConfiguration.getKeyRepeatDelay());
        continue;
        MTimerHandler localMTimerHandler = this.hat;
        if (localMTimerHandler != null) {
          localMTimerHandler.stopTimer();
        }
        this.hat = null;
        if ((!this.hau) && (paramMotionEvent.getActionMasked() == 1)) {
          paramView.performClick();
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onTimerExpired"})
  static final class a
    implements MTimerHandler.CallBack
  {
    a(a parama, View paramView) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(105624);
      a.a(this.hav);
      boolean bool = paramView.performClick();
      AppMethodBeat.o(105624);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a
 * JD-Core Version:    0.7.0.1
 */
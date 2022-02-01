package com.tencent.mm.emoji.panel;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/panel/TouchToClick;", "Landroid/view/View$OnTouchListener;", "()V", "clickHandler", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "clicked", "", "cancel", "", "onTouch", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "plugin-emojisdk_release"})
public final class a
  implements View.OnTouchListener
{
  av fPF;
  private boolean fPG;
  
  public final boolean onTouch(final View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(105625);
    k.h(paramView, "v");
    k.h(paramMotionEvent, "event");
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(105625);
      return true;
      this.fPG = false;
      this.fPF = new av((av.a)new a(this, paramView), true);
      paramView = this.fPF;
      if (paramView != null)
      {
        paramView.av(ViewConfiguration.getKeyRepeatTimeout(), ViewConfiguration.getKeyRepeatDelay());
        continue;
        av localav = this.fPF;
        if (localav != null) {
          localav.stopTimer();
        }
        this.fPF = null;
        if ((!this.fPG) && (paramMotionEvent.getActionMasked() == 1)) {
          paramView.performClick();
        }
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "onTimerExpired"})
  static final class a
    implements av.a
  {
    a(a parama, View paramView) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(105624);
      a.a(this.fPH);
      boolean bool = paramView.performClick();
      AppMethodBeat.o(105624);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a
 * JD-Core Version:    0.7.0.1
 */
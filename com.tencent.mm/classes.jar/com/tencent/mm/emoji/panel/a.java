package com.tencent.mm.emoji.panel;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/panel/TouchToClick;", "Landroid/view/View$OnTouchListener;", "()V", "clickHandler", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "clicked", "", "cancel", "", "onTouch", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "plugin-emojisdk_release"})
public final class a
  implements View.OnTouchListener
{
  au fTA;
  private boolean fTB;
  
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
      this.fTB = false;
      this.fTA = new au((au.a)new a(this, paramView), true);
      paramView = this.fTA;
      if (paramView != null)
      {
        paramView.au(ViewConfiguration.getKeyRepeatTimeout(), ViewConfiguration.getKeyRepeatDelay());
        continue;
        au localau = this.fTA;
        if (localau != null) {
          localau.stopTimer();
        }
        this.fTA = null;
        if ((!this.fTB) && (paramMotionEvent.getActionMasked() == 1)) {
          paramView.performClick();
        }
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "onTimerExpired"})
  static final class a
    implements au.a
  {
    a(a parama, View paramView) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(105624);
      a.a(this.fTC);
      boolean bool = paramView.performClick();
      AppMethodBeat.o(105624);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a
 * JD-Core Version:    0.7.0.1
 */
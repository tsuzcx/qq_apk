package com.tencent.mm.emoji.panel;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/panel/TouchToClick;", "Landroid/view/View$OnTouchListener;", "()V", "clickHandler", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "clicked", "", "cancel", "", "onTouch", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "plugin-emojisdk_release"})
public final class a
  implements View.OnTouchListener
{
  aw gpA;
  private boolean gpB;
  
  public final boolean onTouch(final View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(105625);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    ((b)localObject).bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/emoji/panel/TouchToClick", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, ((b)localObject).ahF());
    p.h(paramView, "v");
    p.h(paramMotionEvent, "event");
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/emoji/panel/TouchToClick", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(105625);
      return true;
      this.gpB = false;
      this.gpA = new aw((aw.a)new a(this, paramView), true);
      paramView = this.gpA;
      if (paramView != null)
      {
        paramView.ay(ViewConfiguration.getKeyRepeatTimeout(), ViewConfiguration.getKeyRepeatDelay());
        continue;
        localObject = this.gpA;
        if (localObject != null) {
          ((aw)localObject).stopTimer();
        }
        this.gpA = null;
        if ((!this.gpB) && (paramMotionEvent.getActionMasked() == 1)) {
          paramView.performClick();
        }
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "onTimerExpired"})
  static final class a
    implements aw.a
  {
    a(a parama, View paramView) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(105624);
      a.a(this.gpC);
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
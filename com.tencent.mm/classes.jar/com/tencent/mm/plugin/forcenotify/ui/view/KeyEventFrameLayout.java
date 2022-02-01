package com.tencent.mm.plugin.forcenotify.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/forcenotify/ui/view/KeyEventFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "keyListener", "Landroid/view/View$OnKeyListener;", "scrollUpListener", "Lkotlin/Function0;", "", "startY", "", "touchSlop", "dispatchKeyEvent", "", "event", "Landroid/view/KeyEvent;", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "setOnKeyListener", "listener", "setOnScrollUpListener", "plugin-force-notify_release"})
public final class KeyEventFrameLayout
  extends FrameLayout
{
  private a<x> BFe;
  private float aBP;
  private final int bvH;
  private View.OnKeyListener rGh;
  
  public KeyEventFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(253087);
    AppMethodBeat.o(253087);
  }
  
  public KeyEventFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(253086);
    this.bvH = ViewConfiguration.getTouchSlop();
    this.aBP = -1.0F;
    AppMethodBeat.o(253086);
  }
  
  public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(253079);
    if (paramKeyEvent != null)
    {
      View.OnKeyListener localOnKeyListener = this.rGh;
      if (localOnKeyListener != null) {
        localOnKeyListener.onKey((View)this, paramKeyEvent.getKeyCode(), paramKeyEvent);
      }
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(253079);
    return bool;
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(253081);
    if (paramMotionEvent != null) {
      switch (paramMotionEvent.getAction())
      {
      }
    }
    for (;;)
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(253081);
      return bool;
      this.aBP = paramMotionEvent.getY();
      continue;
      if (this.aBP > 0.0F)
      {
        float f = paramMotionEvent.getY() - this.aBP;
        if ((f < 0.0F) && (Math.abs(f) > this.bvH))
        {
          a locala = this.BFe;
          if (locala != null) {
            locala.invoke();
          }
        }
        this.aBP = -1.0F;
      }
    }
  }
  
  public final void setOnKeyListener(View.OnKeyListener paramOnKeyListener)
  {
    AppMethodBeat.i(253084);
    this.rGh = paramOnKeyListener;
    super.setOnKeyListener(paramOnKeyListener);
    AppMethodBeat.o(253084);
  }
  
  public final void setOnScrollUpListener(a<x> parama)
  {
    AppMethodBeat.i(253085);
    p.k(parama, "listener");
    this.BFe = parama;
    AppMethodBeat.o(253085);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.ui.view.KeyEventFrameLayout
 * JD-Core Version:    0.7.0.1
 */
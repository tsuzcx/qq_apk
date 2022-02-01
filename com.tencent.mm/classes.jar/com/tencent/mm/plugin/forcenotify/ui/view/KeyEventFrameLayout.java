package com.tencent.mm.plugin.forcenotify.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/forcenotify/ui/view/KeyEventFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "keyListener", "Landroid/view/View$OnKeyListener;", "dispatchKeyEvent", "", "event", "Landroid/view/KeyEvent;", "setOnKeyListener", "", "listener", "plugin-force-notify_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class KeyEventFrameLayout
  extends FrameLayout
{
  private View.OnKeyListener uRt;
  
  public KeyEventFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(275004);
    AppMethodBeat.o(275004);
  }
  
  public KeyEventFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(275000);
    AppMethodBeat.o(275000);
  }
  
  public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(275010);
    if (paramKeyEvent != null)
    {
      View.OnKeyListener localOnKeyListener = this.uRt;
      if (localOnKeyListener != null) {
        localOnKeyListener.onKey((View)this, paramKeyEvent.getKeyCode(), paramKeyEvent);
      }
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(275010);
    return bool;
  }
  
  public final void setOnKeyListener(View.OnKeyListener paramOnKeyListener)
  {
    AppMethodBeat.i(275019);
    this.uRt = paramOnKeyListener;
    super.setOnKeyListener(paramOnKeyListener);
    AppMethodBeat.o(275019);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.ui.view.KeyEventFrameLayout
 * JD-Core Version:    0.7.0.1
 */
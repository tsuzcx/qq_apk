package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isInterceptDown", "", "()Z", "setInterceptDown", "(Z)V", "lastX", "", "getLastX", "()F", "setLastX", "(F)V", "touchListener", "Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout$TouchListener;", "getTouchListener", "()Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout$TouchListener;", "setTouchListener", "(Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout$TouchListener;)V", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "TouchListener", "plugin-finder_release"})
public final class FinderTouchLayout
  extends FrameLayout
{
  private boolean LfM;
  public a LfN;
  private float qXK;
  
  public FinderTouchLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(200167);
    AppMethodBeat.o(200167);
  }
  
  public FinderTouchLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(200168);
    AppMethodBeat.o(200168);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(200166);
    k.h(paramMotionEvent, "event");
    a locala;
    if (paramMotionEvent.getAction() == 0)
    {
      this.qXK = paramMotionEvent.getRawX();
      locala = this.LfN;
      if (locala == null) {
        k.aPZ("touchListener");
      }
      this.LfM = locala.i(paramMotionEvent);
      if (this.LfM)
      {
        AppMethodBeat.o(200166);
        return true;
      }
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(200166);
      return bool;
    }
    if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1))
    {
      if (this.LfM)
      {
        locala = this.LfN;
        if (locala == null) {
          k.aPZ("touchListener");
        }
        locala.j(paramMotionEvent);
        this.LfM = false;
        AppMethodBeat.o(200166);
        return true;
      }
    }
    else if (this.LfM)
    {
      locala = this.LfN;
      if (locala == null) {
        k.aPZ("touchListener");
      }
      locala.bZ(paramMotionEvent.getRawX() - this.qXK);
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(200166);
    return bool;
  }
  
  public final float getLastX()
  {
    return this.qXK;
  }
  
  public final a getTouchListener()
  {
    AppMethodBeat.i(200164);
    a locala = this.LfN;
    if (locala == null) {
      k.aPZ("touchListener");
    }
    AppMethodBeat.o(200164);
    return locala;
  }
  
  public final void setInterceptDown(boolean paramBoolean)
  {
    this.LfM = paramBoolean;
  }
  
  public final void setLastX(float paramFloat)
  {
    this.qXK = paramFloat;
  }
  
  public final void setTouchListener(a parama)
  {
    AppMethodBeat.i(200165);
    k.h(parama, "<set-?>");
    this.LfN = parama;
    AppMethodBeat.o(200165);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout$TouchListener;", "", "interceptDown", "", "event", "Landroid/view/MotionEvent;", "onScrollX", "", "x", "", "onTouchUp", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void bZ(float paramFloat);
    
    public abstract boolean i(MotionEvent paramMotionEvent);
    
    public abstract void j(MotionEvent paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderTouchLayout
 * JD-Core Version:    0.7.0.1
 */
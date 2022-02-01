package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isInterceptDown", "", "()Z", "setInterceptDown", "(Z)V", "lastX", "", "getLastX", "()F", "setLastX", "(F)V", "touchListener", "Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout$TouchListener;", "getTouchListener", "()Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout$TouchListener;", "setTouchListener", "(Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout$TouchListener;)V", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "TouchListener", "plugin-finder_release"})
public final class FinderTouchLayout
  extends FrameLayout
{
  private float rYu;
  private boolean rZp;
  public a rZq;
  
  public FinderTouchLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(204237);
    AppMethodBeat.o(204237);
  }
  
  public FinderTouchLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(204238);
    AppMethodBeat.o(204238);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(204236);
    k.h(paramMotionEvent, "event");
    a locala;
    if (paramMotionEvent.getAction() == 0)
    {
      this.rYu = paramMotionEvent.getRawX();
      locala = this.rZq;
      if (locala == null) {
        k.aVY("touchListener");
      }
      this.rZp = locala.T(paramMotionEvent);
      if (this.rZp)
      {
        AppMethodBeat.o(204236);
        return true;
      }
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(204236);
      return bool;
    }
    if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1))
    {
      if (this.rZp)
      {
        locala = this.rZq;
        if (locala == null) {
          k.aVY("touchListener");
        }
        locala.U(paramMotionEvent);
        this.rZp = false;
        AppMethodBeat.o(204236);
        return true;
      }
    }
    else if (this.rZp)
    {
      locala = this.rZq;
      if (locala == null) {
        k.aVY("touchListener");
      }
      locala.aY(paramMotionEvent.getRawX() - this.rYu);
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(204236);
    return bool;
  }
  
  public final float getLastX()
  {
    return this.rYu;
  }
  
  public final a getTouchListener()
  {
    AppMethodBeat.i(204234);
    a locala = this.rZq;
    if (locala == null) {
      k.aVY("touchListener");
    }
    AppMethodBeat.o(204234);
    return locala;
  }
  
  public final void setInterceptDown(boolean paramBoolean)
  {
    this.rZp = paramBoolean;
  }
  
  public final void setLastX(float paramFloat)
  {
    this.rYu = paramFloat;
  }
  
  public final void setTouchListener(a parama)
  {
    AppMethodBeat.i(204235);
    k.h(parama, "<set-?>");
    this.rZq = parama;
    AppMethodBeat.o(204235);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout$TouchListener;", "", "interceptDown", "", "event", "Landroid/view/MotionEvent;", "onScrollX", "", "x", "", "onTouchUp", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract boolean T(MotionEvent paramMotionEvent);
    
    public abstract void U(MotionEvent paramMotionEvent);
    
    public abstract void aY(float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderTouchLayout
 * JD-Core Version:    0.7.0.1
 */
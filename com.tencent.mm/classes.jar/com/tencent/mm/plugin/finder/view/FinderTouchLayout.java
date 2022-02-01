package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isInterceptDown", "", "()Z", "setInterceptDown", "(Z)V", "lastX", "", "getLastX", "()F", "setLastX", "(F)V", "touchListener", "Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout$TouchListener;", "getTouchListener", "()Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout$TouchListener;", "setTouchListener", "(Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout$TouchListener;)V", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "TouchListener", "plugin-finder_release"})
public final class FinderTouchLayout
  extends FrameLayout
{
  private float aTL;
  private boolean thy;
  public a thz;
  
  public FinderTouchLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(205859);
    AppMethodBeat.o(205859);
  }
  
  public FinderTouchLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(205860);
    AppMethodBeat.o(205860);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(205858);
    p.h(paramMotionEvent, "event");
    a locala;
    if (paramMotionEvent.getAction() == 0)
    {
      this.aTL = paramMotionEvent.getRawX();
      locala = this.thz;
      if (locala == null) {
        p.bdF("touchListener");
      }
      this.thy = locala.P(paramMotionEvent);
      if (this.thy)
      {
        AppMethodBeat.o(205858);
        return true;
      }
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(205858);
      return bool;
    }
    if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1))
    {
      if (this.thy)
      {
        locala = this.thz;
        if (locala == null) {
          p.bdF("touchListener");
        }
        locala.Q(paramMotionEvent);
        this.thy = false;
        AppMethodBeat.o(205858);
        return true;
      }
    }
    else if (this.thy)
    {
      locala = this.thz;
      if (locala == null) {
        p.bdF("touchListener");
      }
      locala.bb(paramMotionEvent.getRawX() - this.aTL);
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(205858);
    return bool;
  }
  
  public final float getLastX()
  {
    return this.aTL;
  }
  
  public final a getTouchListener()
  {
    AppMethodBeat.i(205856);
    a locala = this.thz;
    if (locala == null) {
      p.bdF("touchListener");
    }
    AppMethodBeat.o(205856);
    return locala;
  }
  
  public final void setInterceptDown(boolean paramBoolean)
  {
    this.thy = paramBoolean;
  }
  
  public final void setLastX(float paramFloat)
  {
    this.aTL = paramFloat;
  }
  
  public final void setTouchListener(a parama)
  {
    AppMethodBeat.i(205857);
    p.h(parama, "<set-?>");
    this.thz = parama;
    AppMethodBeat.o(205857);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout$TouchListener;", "", "interceptDown", "", "event", "Landroid/view/MotionEvent;", "onScrollX", "", "x", "", "onTouchUp", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract boolean P(MotionEvent paramMotionEvent);
    
    public abstract void Q(MotionEvent paramMotionEvent);
    
    public abstract void bb(float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderTouchLayout
 * JD-Core Version:    0.7.0.1
 */
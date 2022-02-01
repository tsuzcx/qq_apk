package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isInterceptDown", "", "()Z", "setInterceptDown", "(Z)V", "lastX", "", "getLastX", "()F", "setLastX", "(F)V", "touchListener", "Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout$TouchListener;", "getTouchListener", "()Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout$TouchListener;", "setTouchListener", "(Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout$TouchListener;)V", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "TouchListener", "plugin-finder_release"})
public final class FinderTouchLayout
  extends FrameLayout
{
  private float aTL;
  private boolean sWl;
  public a sWm;
  
  public FinderTouchLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(205217);
    AppMethodBeat.o(205217);
  }
  
  public FinderTouchLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(205218);
    AppMethodBeat.o(205218);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(205216);
    p.h(paramMotionEvent, "event");
    a locala;
    if (paramMotionEvent.getAction() == 0)
    {
      this.aTL = paramMotionEvent.getRawX();
      locala = this.sWm;
      if (locala == null) {
        p.bcb("touchListener");
      }
      this.sWl = locala.R(paramMotionEvent);
      if (this.sWl)
      {
        AppMethodBeat.o(205216);
        return true;
      }
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(205216);
      return bool;
    }
    if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1))
    {
      if (this.sWl)
      {
        locala = this.sWm;
        if (locala == null) {
          p.bcb("touchListener");
        }
        locala.S(paramMotionEvent);
        this.sWl = false;
        AppMethodBeat.o(205216);
        return true;
      }
    }
    else if (this.sWl)
    {
      locala = this.sWm;
      if (locala == null) {
        p.bcb("touchListener");
      }
      locala.bb(paramMotionEvent.getRawX() - this.aTL);
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(205216);
    return bool;
  }
  
  public final float getLastX()
  {
    return this.aTL;
  }
  
  public final a getTouchListener()
  {
    AppMethodBeat.i(205214);
    a locala = this.sWm;
    if (locala == null) {
      p.bcb("touchListener");
    }
    AppMethodBeat.o(205214);
    return locala;
  }
  
  public final void setInterceptDown(boolean paramBoolean)
  {
    this.sWl = paramBoolean;
  }
  
  public final void setLastX(float paramFloat)
  {
    this.aTL = paramFloat;
  }
  
  public final void setTouchListener(a parama)
  {
    AppMethodBeat.i(205215);
    p.h(parama, "<set-?>");
    this.sWm = parama;
    AppMethodBeat.o(205215);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout$TouchListener;", "", "interceptDown", "", "event", "Landroid/view/MotionEvent;", "onScrollX", "", "x", "", "onTouchUp", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract boolean R(MotionEvent paramMotionEvent);
    
    public abstract void S(MotionEvent paramMotionEvent);
    
    public abstract void bb(float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderTouchLayout
 * JD-Core Version:    0.7.0.1
 */
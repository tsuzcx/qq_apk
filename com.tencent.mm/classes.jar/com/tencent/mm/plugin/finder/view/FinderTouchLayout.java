package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isInterceptDown", "", "()Z", "setInterceptDown", "(Z)V", "lastX", "", "getLastX", "()F", "setLastX", "(F)V", "touchListener", "Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout$TouchListener;", "getTouchListener", "()Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout$TouchListener;", "setTouchListener", "(Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout$TouchListener;)V", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "TouchListener", "plugin-finder_release"})
public final class FinderTouchLayout
  extends FrameLayout
{
  private float aTD;
  private boolean wpJ;
  public a wpK;
  
  public FinderTouchLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(254999);
    AppMethodBeat.o(254999);
  }
  
  public FinderTouchLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(255000);
    AppMethodBeat.o(255000);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(254998);
    p.h(paramMotionEvent, "event");
    a locala;
    if (paramMotionEvent.getAction() == 0)
    {
      this.aTD = paramMotionEvent.getRawX();
      locala = this.wpK;
      if (locala == null) {
        p.btv("touchListener");
      }
      this.wpJ = locala.T(paramMotionEvent);
      if (this.wpJ)
      {
        AppMethodBeat.o(254998);
        return true;
      }
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(254998);
      return bool;
    }
    if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1))
    {
      if (this.wpJ)
      {
        locala = this.wpK;
        if (locala == null) {
          p.btv("touchListener");
        }
        locala.U(paramMotionEvent);
        this.wpJ = false;
        AppMethodBeat.o(254998);
        return true;
      }
    }
    else if (this.wpJ)
    {
      locala = this.wpK;
      if (locala == null) {
        p.btv("touchListener");
      }
      locala.bh(paramMotionEvent.getRawX() - this.aTD);
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(254998);
    return bool;
  }
  
  public final float getLastX()
  {
    return this.aTD;
  }
  
  public final a getTouchListener()
  {
    AppMethodBeat.i(254996);
    a locala = this.wpK;
    if (locala == null) {
      p.btv("touchListener");
    }
    AppMethodBeat.o(254996);
    return locala;
  }
  
  public final void setInterceptDown(boolean paramBoolean)
  {
    this.wpJ = paramBoolean;
  }
  
  public final void setLastX(float paramFloat)
  {
    this.aTD = paramFloat;
  }
  
  public final void setTouchListener(a parama)
  {
    AppMethodBeat.i(254997);
    p.h(parama, "<set-?>");
    this.wpK = parama;
    AppMethodBeat.o(254997);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout$TouchListener;", "", "interceptDown", "", "event", "Landroid/view/MotionEvent;", "onScrollX", "", "x", "", "onTouchUp", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract boolean T(MotionEvent paramMotionEvent);
    
    public abstract void U(MotionEvent paramMotionEvent);
    
    public abstract void bh(float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderTouchLayout
 * JD-Core Version:    0.7.0.1
 */
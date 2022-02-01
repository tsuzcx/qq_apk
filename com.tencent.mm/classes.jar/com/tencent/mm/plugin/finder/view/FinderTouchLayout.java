package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isInterceptDown", "", "()Z", "setInterceptDown", "(Z)V", "lastX", "", "getLastX", "()F", "setLastX", "(F)V", "touchListener", "Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout$TouchListener;", "getTouchListener", "()Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout$TouchListener;", "setTouchListener", "(Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout$TouchListener;)V", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "TouchListener", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderTouchLayout
  extends FrameLayout
{
  private boolean GDC;
  public a GDD;
  private float cxM;
  
  public FinderTouchLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(344411);
    AppMethodBeat.o(344411);
  }
  
  public FinderTouchLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(344417);
    AppMethodBeat.o(344417);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(344457);
    s.u(paramMotionEvent, "event");
    if (paramMotionEvent.getAction() == 0)
    {
      this.cxM = paramMotionEvent.getRawX();
      this.GDC = getTouchListener().aa(paramMotionEvent);
      if (this.GDC)
      {
        AppMethodBeat.o(344457);
        return true;
      }
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(344457);
      return bool;
    }
    if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1))
    {
      if (this.GDC)
      {
        getTouchListener().ab(paramMotionEvent);
        this.GDC = false;
        AppMethodBeat.o(344457);
        return true;
      }
    }
    else if (this.GDC) {
      getTouchListener().cj(paramMotionEvent.getRawX() - this.cxM);
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(344457);
    return bool;
  }
  
  public final float getLastX()
  {
    return this.cxM;
  }
  
  public final a getTouchListener()
  {
    AppMethodBeat.i(344441);
    a locala = this.GDD;
    if (locala != null)
    {
      AppMethodBeat.o(344441);
      return locala;
    }
    s.bIx("touchListener");
    AppMethodBeat.o(344441);
    return null;
  }
  
  public final void setInterceptDown(boolean paramBoolean)
  {
    this.GDC = paramBoolean;
  }
  
  public final void setLastX(float paramFloat)
  {
    this.cxM = paramFloat;
  }
  
  public final void setTouchListener(a parama)
  {
    AppMethodBeat.i(344449);
    s.u(parama, "<set-?>");
    this.GDD = parama;
    AppMethodBeat.o(344449);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout$TouchListener;", "", "interceptDown", "", "event", "Landroid/view/MotionEvent;", "onScrollX", "", "x", "", "onTouchUp", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract boolean aa(MotionEvent paramMotionEvent);
    
    public abstract void ab(MotionEvent paramMotionEvent);
    
    public abstract void cj(float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderTouchLayout
 * JD-Core Version:    0.7.0.1
 */
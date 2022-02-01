package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isInterceptDown", "", "()Z", "setInterceptDown", "(Z)V", "lastX", "", "getLastX", "()F", "setLastX", "(F)V", "touchListener", "Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout$TouchListener;", "getTouchListener", "()Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout$TouchListener;", "setTouchListener", "(Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout$TouchListener;)V", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "TouchListener", "plugin-finder_release"})
public final class FinderTouchLayout
  extends FrameLayout
{
  private boolean Bbr;
  public a Bbs;
  private float aCa;
  
  public FinderTouchLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(285202);
    AppMethodBeat.o(285202);
  }
  
  public FinderTouchLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(285203);
    AppMethodBeat.o(285203);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(285200);
    p.k(paramMotionEvent, "event");
    a locala;
    if (paramMotionEvent.getAction() == 0)
    {
      this.aCa = paramMotionEvent.getRawX();
      locala = this.Bbs;
      if (locala == null) {
        p.bGy("touchListener");
      }
      this.Bbr = locala.Z(paramMotionEvent);
      if (this.Bbr)
      {
        AppMethodBeat.o(285200);
        return true;
      }
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(285200);
      return bool;
    }
    if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1))
    {
      if (this.Bbr)
      {
        locala = this.Bbs;
        if (locala == null) {
          p.bGy("touchListener");
        }
        locala.aa(paramMotionEvent);
        this.Bbr = false;
        AppMethodBeat.o(285200);
        return true;
      }
    }
    else if (this.Bbr)
    {
      locala = this.Bbs;
      if (locala == null) {
        p.bGy("touchListener");
      }
      locala.bg(paramMotionEvent.getRawX() - this.aCa);
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(285200);
    return bool;
  }
  
  public final float getLastX()
  {
    return this.aCa;
  }
  
  public final a getTouchListener()
  {
    AppMethodBeat.i(285197);
    a locala = this.Bbs;
    if (locala == null) {
      p.bGy("touchListener");
    }
    AppMethodBeat.o(285197);
    return locala;
  }
  
  public final void setInterceptDown(boolean paramBoolean)
  {
    this.Bbr = paramBoolean;
  }
  
  public final void setLastX(float paramFloat)
  {
    this.aCa = paramFloat;
  }
  
  public final void setTouchListener(a parama)
  {
    AppMethodBeat.i(285198);
    p.k(parama, "<set-?>");
    this.Bbs = parama;
    AppMethodBeat.o(285198);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout$TouchListener;", "", "interceptDown", "", "event", "Landroid/view/MotionEvent;", "onScrollX", "", "x", "", "onTouchUp", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract boolean Z(MotionEvent paramMotionEvent);
    
    public abstract void aa(MotionEvent paramMotionEvent);
    
    public abstract void bg(float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderTouchLayout
 * JD-Core Version:    0.7.0.1
 */
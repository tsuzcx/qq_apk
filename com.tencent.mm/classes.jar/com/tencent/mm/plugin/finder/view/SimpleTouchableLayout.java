package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/SimpleTouchableLayout;", "Landroid/widget/FrameLayout;", "Landroid/view/GestureDetector$OnGestureListener;", "Landroid/view/GestureDetector$OnDoubleTapListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isEnableFling", "", "()Z", "setEnableFling", "(Z)V", "isEnableOverScroll", "setEnableOverScroll", "isEnableScale", "setEnableScale", "isEnableScroll", "setEnableScroll", "isEnableTouch", "setEnableTouch", "onDoubleClickListener", "Lcom/tencent/mm/plugin/finder/view/SimpleTouchableLayout$OnDoubleClickListener;", "getOnDoubleClickListener", "()Lcom/tencent/mm/plugin/finder/view/SimpleTouchableLayout$OnDoubleClickListener;", "setOnDoubleClickListener", "(Lcom/tencent/mm/plugin/finder/view/SimpleTouchableLayout$OnDoubleClickListener;)V", "onInterceptTouchEventCallback", "Lcom/tencent/mm/plugin/finder/view/SimpleTouchableLayout$OnInterceptTouchEventCallback;", "getOnInterceptTouchEventCallback", "()Lcom/tencent/mm/plugin/finder/view/SimpleTouchableLayout$OnInterceptTouchEventCallback;", "setOnInterceptTouchEventCallback", "(Lcom/tencent/mm/plugin/finder/view/SimpleTouchableLayout$OnInterceptTouchEventCallback;)V", "onLongClickListener", "Lcom/tencent/mm/plugin/finder/view/SimpleTouchableLayout$OnLongClickListener;", "getOnLongClickListener", "()Lcom/tencent/mm/plugin/finder/view/SimpleTouchableLayout$OnLongClickListener;", "setOnLongClickListener", "(Lcom/tencent/mm/plugin/finder/view/SimpleTouchableLayout$OnLongClickListener;)V", "onScaleListener", "Lcom/tencent/mm/plugin/finder/view/SimpleTouchableLayout$OnScaleListener;", "getOnScaleListener", "()Lcom/tencent/mm/plugin/finder/view/SimpleTouchableLayout$OnScaleListener;", "setOnScaleListener", "(Lcom/tencent/mm/plugin/finder/view/SimpleTouchableLayout$OnScaleListener;)V", "onSingleClickListener", "Lcom/tencent/mm/plugin/finder/view/SimpleTouchableLayout$OnSingleClickListener;", "getOnSingleClickListener", "()Lcom/tencent/mm/plugin/finder/view/SimpleTouchableLayout$OnSingleClickListener;", "setOnSingleClickListener", "(Lcom/tencent/mm/plugin/finder/view/SimpleTouchableLayout$OnSingleClickListener;)V", "touchDetector", "Landroid/view/GestureDetector;", "getTouchDetector", "()Landroid/view/GestureDetector;", "touchDetector$delegate", "Lkotlin/Lazy;", "canScrollHorizontally", "direction", "canScrollVertically", "onDoubleTap", "e", "Landroid/view/MotionEvent;", "onDoubleTapEvent", "onDown", "onFling", "e1", "e2", "velocityX", "", "velocityY", "onInterceptTouchEvent", "ev", "onLongPress", "", "onScroll", "distanceX", "distanceY", "onShowPress", "onSingleTapConfirmed", "onSingleTapUp", "onTouchEvent", "event", "setOnClickListener", "l", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnLongClickListener;", "Companion", "OnDoubleClickListener", "OnInterceptTouchEventCallback", "OnLongClickListener", "OnScaleListener", "OnSingleClickListener", "plugin-finder_release"})
public class SimpleTouchableLayout
  extends FrameLayout
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener
{
  public static final a BcI;
  private final f AOG;
  private boolean BcA;
  private boolean BcB;
  private boolean BcC;
  private d BcD;
  private f BcE;
  private SimpleTouchableLayout.b BcF;
  private e BcG;
  private c BcH;
  private boolean Bcy;
  private boolean Bcz;
  
  static
  {
    AppMethodBeat.i(290999);
    BcI = new a((byte)0);
    AppMethodBeat.o(290999);
  }
  
  public SimpleTouchableLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(290997);
    this.Bcy = true;
    this.Bcz = true;
    this.BcA = true;
    this.BcB = true;
    this.BcC = true;
    this.AOG = g.ar((kotlin.g.a.a)new i(this));
    setEnableFling(false);
    setEnableOverScroll(false);
    setEnableScale(false);
    AppMethodBeat.o(290997);
  }
  
  public SimpleTouchableLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(290998);
    this.Bcy = true;
    this.Bcz = true;
    this.BcA = true;
    this.BcB = true;
    this.BcC = true;
    this.AOG = g.ar((kotlin.g.a.a)new i(this));
    setEnableFling(false);
    setEnableOverScroll(false);
    setEnableScale(false);
    AppMethodBeat.o(290998);
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    return this.Bcy;
  }
  
  public boolean canScrollVertically(int paramInt)
  {
    return this.Bcy;
  }
  
  public final SimpleTouchableLayout.b getOnDoubleClickListener()
  {
    return this.BcF;
  }
  
  public final c getOnInterceptTouchEventCallback()
  {
    return this.BcH;
  }
  
  public final d getOnLongClickListener()
  {
    return this.BcD;
  }
  
  public final e getOnScaleListener()
  {
    return this.BcG;
  }
  
  public final f getOnSingleClickListener()
  {
    return this.BcE;
  }
  
  protected final GestureDetector getTouchDetector()
  {
    AppMethodBeat.i(290983);
    GestureDetector localGestureDetector = (GestureDetector)this.AOG.getValue();
    AppMethodBeat.o(290983);
    return localGestureDetector;
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(290990);
    Object localObject = new b();
    ((b)localObject).bn(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/SimpleTouchableLayout", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, ((b)localObject).aFi());
    if (paramMotionEvent != null)
    {
      localObject = this.BcF;
      if (localObject != null) {}
      for (boolean bool = ((SimpleTouchableLayout.b)localObject).b((View)this, paramMotionEvent);; bool = false)
      {
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/finder/view/SimpleTouchableLayout", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(290990);
        return bool;
      }
    }
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/finder/view/SimpleTouchableLayout", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(290990);
    return false;
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return this.BcF != null;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return (this.BcE != null) && (this.BcF != null) && (this.BcD != null);
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return this.BcA;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(290987);
    p.k(paramMotionEvent, "ev");
    c localc = this.BcH;
    if (localc != null)
    {
      bool = localc.ejt();
      AppMethodBeat.o(290987);
      return bool;
    }
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(290987);
    return bool;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(290989);
    b localb = new b();
    localb.bn(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/SimpleTouchableLayout", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aFi());
    paramMotionEvent = this.BcD;
    if (paramMotionEvent != null) {
      paramMotionEvent.eD((View)this);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/SimpleTouchableLayout", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(290989);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(290992);
    f localf = this.BcE;
    if (localf != null)
    {
      boolean bool = localf.c((View)this, paramMotionEvent);
      AppMethodBeat.o(290992);
      return bool;
    }
    AppMethodBeat.o(290992);
    return false;
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(290991);
    b localb = new b();
    localb.bn(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/SimpleTouchableLayout", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/finder/view/SimpleTouchableLayout", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(290991);
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(290984);
    p.k(paramMotionEvent, "event");
    if (!this.Bcy)
    {
      AppMethodBeat.o(290984);
      return false;
    }
    if (!super.onTouchEvent(paramMotionEvent))
    {
      GestureDetector localGestureDetector = getTouchDetector();
      paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bm(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b(localGestureDetector, paramMotionEvent.aFh(), "com/tencent/mm/plugin/finder/view/SimpleTouchableLayout", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      if (!com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)paramMotionEvent.sf(0)), "com/tencent/mm/plugin/finder/view/SimpleTouchableLayout", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z")) {}
    }
    else
    {
      AppMethodBeat.o(290984);
      return true;
    }
    AppMethodBeat.o(290984);
    return false;
  }
  
  public void setEnableFling(boolean paramBoolean)
  {
    this.BcA = paramBoolean;
  }
  
  public void setEnableOverScroll(boolean paramBoolean)
  {
    this.BcB = paramBoolean;
  }
  
  public void setEnableScale(boolean paramBoolean)
  {
    this.Bcz = paramBoolean;
  }
  
  public void setEnableScroll(boolean paramBoolean)
  {
    this.BcC = paramBoolean;
  }
  
  public void setEnableTouch(boolean paramBoolean)
  {
    this.Bcy = paramBoolean;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(290995);
    this.BcE = ((f)new g(paramOnClickListener));
    AppMethodBeat.o(290995);
  }
  
  public final void setOnDoubleClickListener(SimpleTouchableLayout.b paramb)
  {
    this.BcF = paramb;
  }
  
  public final void setOnInterceptTouchEventCallback(c paramc)
  {
    this.BcH = paramc;
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(290994);
    this.BcD = ((d)new h(paramOnLongClickListener));
    AppMethodBeat.o(290994);
  }
  
  public final void setOnLongClickListener(d paramd)
  {
    this.BcD = paramd;
  }
  
  public final void setOnScaleListener(e parame)
  {
    this.BcG = parame;
  }
  
  public final void setOnSingleClickListener(f paramf)
  {
    this.BcE = paramf;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/SimpleTouchableLayout$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/SimpleTouchableLayout$OnInterceptTouchEventCallback;", "", "isIntercept", "", "event", "Landroid/view/MotionEvent;", "plugin-finder_release"})
  public static abstract interface c
  {
    public abstract boolean ejt();
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/SimpleTouchableLayout$OnLongClickListener;", "", "onLongClick", "", "view", "Landroid/view/View;", "plugin-finder_release"})
  public static abstract interface d
  {
    public abstract void eD(View paramView);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/SimpleTouchableLayout$OnScaleListener;", "", "onScaleBegin", "", "detector", "Landroid/view/ScaleGestureDetector;", "onScaleEnd", "onScaling", "plugin-finder_release"})
  public static abstract interface e {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/SimpleTouchableLayout$OnSingleClickListener;", "", "onSingleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "plugin-finder_release"})
  public static abstract interface f
  {
    public abstract boolean c(View paramView, MotionEvent paramMotionEvent);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/view/SimpleTouchableLayout$setOnClickListener$1", "Lcom/tencent/mm/plugin/finder/view/SimpleTouchableLayout$OnSingleClickListener;", "onSingleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "plugin-finder_release"})
  public static final class g
    implements SimpleTouchableLayout.f
  {
    g(View.OnClickListener paramOnClickListener) {}
    
    public final boolean c(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(267997);
      p.k(paramView, "view");
      paramMotionEvent = this.BcJ;
      if (paramMotionEvent != null) {
        paramMotionEvent.onClick(paramView);
      }
      AppMethodBeat.o(267997);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/view/SimpleTouchableLayout$setOnLongClickListener$1", "Lcom/tencent/mm/plugin/finder/view/SimpleTouchableLayout$OnLongClickListener;", "onLongClick", "", "view", "Landroid/view/View;", "plugin-finder_release"})
  public static final class h
    implements SimpleTouchableLayout.d
  {
    h(View.OnLongClickListener paramOnLongClickListener) {}
    
    public final void eD(View paramView)
    {
      AppMethodBeat.i(264433);
      p.k(paramView, "view");
      View.OnLongClickListener localOnLongClickListener = this.BcK;
      if (localOnLongClickListener != null)
      {
        localOnLongClickListener.onLongClick(paramView);
        AppMethodBeat.o(264433);
        return;
      }
      AppMethodBeat.o(264433);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/GestureDetector;", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<GestureDetector>
  {
    i(SimpleTouchableLayout paramSimpleTouchableLayout)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.SimpleTouchableLayout
 * JD-Core Version:    0.7.0.1
 */
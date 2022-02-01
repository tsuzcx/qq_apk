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
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/SimpleTouchableLayout;", "Landroid/widget/FrameLayout;", "Landroid/view/GestureDetector$OnGestureListener;", "Landroid/view/GestureDetector$OnDoubleTapListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isEnableFling", "", "()Z", "setEnableFling", "(Z)V", "isEnableOverScroll", "setEnableOverScroll", "isEnableScale", "setEnableScale", "isEnableScroll", "setEnableScroll", "isEnableTouch", "setEnableTouch", "onDoubleClickListener", "Lcom/tencent/mm/plugin/finder/view/SimpleTouchableLayout$OnDoubleClickListener;", "getOnDoubleClickListener", "()Lcom/tencent/mm/plugin/finder/view/SimpleTouchableLayout$OnDoubleClickListener;", "setOnDoubleClickListener", "(Lcom/tencent/mm/plugin/finder/view/SimpleTouchableLayout$OnDoubleClickListener;)V", "onInterceptTouchEventCallback", "Lcom/tencent/mm/plugin/finder/view/SimpleTouchableLayout$OnInterceptTouchEventCallback;", "getOnInterceptTouchEventCallback", "()Lcom/tencent/mm/plugin/finder/view/SimpleTouchableLayout$OnInterceptTouchEventCallback;", "setOnInterceptTouchEventCallback", "(Lcom/tencent/mm/plugin/finder/view/SimpleTouchableLayout$OnInterceptTouchEventCallback;)V", "onLongClickListener", "Lcom/tencent/mm/plugin/finder/view/SimpleTouchableLayout$OnLongClickListener;", "getOnLongClickListener", "()Lcom/tencent/mm/plugin/finder/view/SimpleTouchableLayout$OnLongClickListener;", "setOnLongClickListener", "(Lcom/tencent/mm/plugin/finder/view/SimpleTouchableLayout$OnLongClickListener;)V", "onScaleListener", "Lcom/tencent/mm/plugin/finder/view/SimpleTouchableLayout$OnScaleListener;", "getOnScaleListener", "()Lcom/tencent/mm/plugin/finder/view/SimpleTouchableLayout$OnScaleListener;", "setOnScaleListener", "(Lcom/tencent/mm/plugin/finder/view/SimpleTouchableLayout$OnScaleListener;)V", "onSingleClickListener", "Lcom/tencent/mm/plugin/finder/view/SimpleTouchableLayout$OnSingleClickListener;", "getOnSingleClickListener", "()Lcom/tencent/mm/plugin/finder/view/SimpleTouchableLayout$OnSingleClickListener;", "setOnSingleClickListener", "(Lcom/tencent/mm/plugin/finder/view/SimpleTouchableLayout$OnSingleClickListener;)V", "touchDetector", "Landroid/view/GestureDetector;", "getTouchDetector", "()Landroid/view/GestureDetector;", "touchDetector$delegate", "Lkotlin/Lazy;", "canScrollHorizontally", "direction", "canScrollVertically", "onDoubleTap", "e", "Landroid/view/MotionEvent;", "onDoubleTapEvent", "onDown", "onFling", "e1", "e2", "velocityX", "", "velocityY", "onInterceptTouchEvent", "ev", "onLongPress", "", "onScroll", "distanceX", "distanceY", "onShowPress", "onSingleTapConfirmed", "onSingleTapUp", "onTouchEvent", "event", "setOnClickListener", "l", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnLongClickListener;", "Companion", "OnDoubleClickListener", "OnInterceptTouchEventCallback", "OnLongClickListener", "OnScaleListener", "OnSingleClickListener", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public class SimpleTouchableLayout
  extends FrameLayout
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener
{
  public static final a GFl;
  private boolean GFm;
  private boolean GFn;
  private boolean GFo;
  private boolean GFp;
  private boolean GFq;
  private d GFr;
  private f GFs;
  private b GFt;
  private e GFu;
  private c GFv;
  private final j Gra;
  
  static
  {
    AppMethodBeat.i(344188);
    GFl = new a((byte)0);
    AppMethodBeat.o(344188);
  }
  
  public SimpleTouchableLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(344178);
    this.GFm = true;
    this.GFn = true;
    this.GFo = true;
    this.GFp = true;
    this.GFq = true;
    this.Gra = k.cm((kotlin.g.a.a)new i(this));
    setEnableFling(false);
    setEnableOverScroll(false);
    setEnableScale(false);
    AppMethodBeat.o(344178);
  }
  
  public SimpleTouchableLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(344184);
    this.GFm = true;
    this.GFn = true;
    this.GFo = true;
    this.GFp = true;
    this.GFq = true;
    this.Gra = k.cm((kotlin.g.a.a)new i(this));
    setEnableFling(false);
    setEnableOverScroll(false);
    setEnableScale(false);
    AppMethodBeat.o(344184);
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    return this.GFm;
  }
  
  public boolean canScrollVertically(int paramInt)
  {
    return this.GFm;
  }
  
  public final b getOnDoubleClickListener()
  {
    return this.GFt;
  }
  
  public final c getOnInterceptTouchEventCallback()
  {
    return this.GFv;
  }
  
  public final d getOnLongClickListener()
  {
    return this.GFr;
  }
  
  public final e getOnScaleListener()
  {
    return this.GFu;
  }
  
  public final f getOnSingleClickListener()
  {
    return this.GFs;
  }
  
  protected final GestureDetector getTouchDetector()
  {
    AppMethodBeat.i(344217);
    GestureDetector localGestureDetector = (GestureDetector)this.Gra.getValue();
    AppMethodBeat.o(344217);
    return localGestureDetector;
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(344323);
    Object localObject = new b();
    ((b)localObject).cH(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/SimpleTouchableLayout", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, ((b)localObject).aYj());
    if (paramMotionEvent != null)
    {
      localObject = getOnDoubleClickListener();
      if (localObject == null) {}
      for (boolean bool = false;; bool = ((b)localObject).a((View)this, paramMotionEvent))
      {
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/finder/view/SimpleTouchableLayout", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(344323);
        return bool;
      }
    }
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/finder/view/SimpleTouchableLayout", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(344323);
    return false;
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return this.GFt != null;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return (this.GFs != null) && (this.GFt != null) && (this.GFr != null);
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return this.GFo;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(344281);
    s.u(paramMotionEvent, "ev");
    c localc = this.GFv;
    if (localc == null)
    {
      bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(344281);
      return bool;
    }
    boolean bool = localc.flG();
    AppMethodBeat.o(344281);
    return bool;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(344315);
    b localb = new b();
    localb.cH(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/SimpleTouchableLayout", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aYj());
    paramMotionEvent = this.GFr;
    if (paramMotionEvent != null) {
      paramMotionEvent.ft((View)this);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/SimpleTouchableLayout", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(344315);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(344346);
    f localf = this.GFs;
    if (localf == null)
    {
      AppMethodBeat.o(344346);
      return false;
    }
    boolean bool = localf.b((View)this, paramMotionEvent);
    AppMethodBeat.o(344346);
    return bool;
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(344335);
    b localb = new b();
    localb.cH(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/SimpleTouchableLayout", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/finder/view/SimpleTouchableLayout", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(344335);
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(344222);
    s.u(paramMotionEvent, "event");
    if (!this.GFm)
    {
      AppMethodBeat.o(344222);
      return false;
    }
    if (!super.onTouchEvent(paramMotionEvent))
    {
      GestureDetector localGestureDetector = getTouchDetector();
      paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b(localGestureDetector, paramMotionEvent.aYi(), "com/tencent/mm/plugin/finder/view/SimpleTouchableLayout", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      if (!com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)paramMotionEvent.sb(0)), "com/tencent/mm/plugin/finder/view/SimpleTouchableLayout", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z")) {}
    }
    else
    {
      AppMethodBeat.o(344222);
      return true;
    }
    AppMethodBeat.o(344222);
    return false;
  }
  
  public void setEnableFling(boolean paramBoolean)
  {
    this.GFo = paramBoolean;
  }
  
  public void setEnableOverScroll(boolean paramBoolean)
  {
    this.GFp = paramBoolean;
  }
  
  public void setEnableScale(boolean paramBoolean)
  {
    this.GFn = paramBoolean;
  }
  
  public void setEnableScroll(boolean paramBoolean)
  {
    this.GFq = paramBoolean;
  }
  
  public void setEnableTouch(boolean paramBoolean)
  {
    this.GFm = paramBoolean;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(344355);
    this.GFs = ((f)new g(paramOnClickListener));
    AppMethodBeat.o(344355);
  }
  
  public final void setOnDoubleClickListener(b paramb)
  {
    this.GFt = paramb;
  }
  
  public final void setOnInterceptTouchEventCallback(c paramc)
  {
    this.GFv = paramc;
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(344350);
    this.GFr = ((d)new h(paramOnLongClickListener));
    AppMethodBeat.o(344350);
  }
  
  public final void setOnLongClickListener(d paramd)
  {
    this.GFr = paramd;
  }
  
  public final void setOnScaleListener(e parame)
  {
    this.GFu = parame;
  }
  
  public final void setOnSingleClickListener(f paramf)
  {
    this.GFs = paramf;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/SimpleTouchableLayout$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/SimpleTouchableLayout$OnDoubleClickListener;", "", "onDoubleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract boolean a(View paramView, MotionEvent paramMotionEvent);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/SimpleTouchableLayout$OnInterceptTouchEventCallback;", "", "isIntercept", "", "event", "Landroid/view/MotionEvent;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface c
  {
    public abstract boolean flG();
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/SimpleTouchableLayout$OnLongClickListener;", "", "onLongClick", "", "view", "Landroid/view/View;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface d
  {
    public abstract void ft(View paramView);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/SimpleTouchableLayout$OnScaleListener;", "", "onScaleBegin", "", "detector", "Landroid/view/ScaleGestureDetector;", "onScaleEnd", "onScaling", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface e {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/SimpleTouchableLayout$OnSingleClickListener;", "", "onSingleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface f
  {
    public abstract boolean b(View paramView, MotionEvent paramMotionEvent);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/SimpleTouchableLayout$setOnClickListener$1", "Lcom/tencent/mm/plugin/finder/view/SimpleTouchableLayout$OnSingleClickListener;", "onSingleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements SimpleTouchableLayout.f
  {
    g(View.OnClickListener paramOnClickListener) {}
    
    public final boolean b(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(344168);
      s.u(paramView, "view");
      paramMotionEvent = this.GFw;
      if (paramMotionEvent != null) {
        paramMotionEvent.onClick(paramView);
      }
      AppMethodBeat.o(344168);
      return false;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/SimpleTouchableLayout$setOnLongClickListener$1", "Lcom/tencent/mm/plugin/finder/view/SimpleTouchableLayout$OnLongClickListener;", "onLongClick", "", "view", "Landroid/view/View;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    implements SimpleTouchableLayout.d
  {
    h(View.OnLongClickListener paramOnLongClickListener) {}
    
    public final void ft(View paramView)
    {
      AppMethodBeat.i(344180);
      s.u(paramView, "view");
      View.OnLongClickListener localOnLongClickListener = this.GFx;
      if (localOnLongClickListener != null) {
        localOnLongClickListener.onLongClick(paramView);
      }
      AppMethodBeat.o(344180);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/GestureDetector;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<GestureDetector>
  {
    i(SimpleTouchableLayout paramSimpleTouchableLayout)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.SimpleTouchableLayout
 * JD-Core Version:    0.7.0.1
 */
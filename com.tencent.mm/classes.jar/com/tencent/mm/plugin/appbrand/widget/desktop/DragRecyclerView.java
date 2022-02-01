package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ad;

public abstract class DragRecyclerView
  extends RecyclerView
  implements GestureDetector.OnGestureListener
{
  private GestureDetector lsn;
  DragFeatureView mYG;
  boolean mYz = false;
  
  public DragRecyclerView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public DragRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public DragRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.lsn = new GestureDetector(paramContext, this);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    GestureDetector localGestureDetector = this.lsn;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, locala.ahp(), "com/tencent/mm/plugin/appbrand/widget/desktop/DragRecyclerView", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala.mq(0)), "com/tencent/mm/plugin/appbrand/widget/desktop/DragRecyclerView", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    if (this.mYz)
    {
      if (this.mYG != null) {
        this.mYG.onTouch(this, paramMotionEvent);
      }
      int j = paramMotionEvent.getAction();
      paramMotionEvent.setAction(3);
      int i = 0;
      while (i < getChildCount())
      {
        getChildAt(i).dispatchTouchEvent(paramMotionEvent);
        i += 1;
      }
      paramMotionEvent.setAction(j);
    }
    if (paramMotionEvent.getAction() != 3) {
      paramMotionEvent.getAction();
    }
    if ((this.mYz) || (super.dispatchTouchEvent(paramMotionEvent))) {
      bool = true;
    }
    return bool;
  }
  
  public DragFeatureView getDragRubbishView()
  {
    return this.mYG;
  }
  
  public final void l(DragFeatureView paramDragFeatureView)
  {
    this.mYG = paramDragFeatureView;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    b localb = new b();
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/DragRecyclerView", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahq());
    if (this.mYz)
    {
      ad.i("DragRecyclerView", "alvinluo onLongPress ignore");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/DragRecyclerView", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
      return;
    }
    if (this.mYG != null)
    {
      this.mYG.onLongPress(paramMotionEvent);
      if (this.mYG.getVisibility() != 0) {
        break label101;
      }
    }
    label101:
    for (boolean bool = true;; bool = false)
    {
      this.mYz = bool;
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/DragRecyclerView", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
      return;
    }
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    b localb = new b();
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/DragRecyclerView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/appbrand/widget/desktop/DragRecyclerView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    return false;
  }
  
  public void setLongPress(boolean paramBoolean)
  {
    this.mYz = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.DragRecyclerView
 * JD-Core Version:    0.7.0.1
 */
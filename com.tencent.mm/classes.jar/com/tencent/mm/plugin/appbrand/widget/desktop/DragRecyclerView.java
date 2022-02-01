package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class DragRecyclerView
  extends RecyclerView
  implements GestureDetector.OnGestureListener
{
  private GestureDetector mDJ;
  boolean ooU = false;
  DragFeatureView opb;
  
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
    this.mDJ = new GestureDetector(paramContext, this);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    GestureDetector localGestureDetector = this.mDJ;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bl(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, locala.axQ(), "com/tencent/mm/plugin/appbrand/widget/desktop/DragRecyclerView", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala.pG(0)), "com/tencent/mm/plugin/appbrand/widget/desktop/DragRecyclerView", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    if (this.ooU)
    {
      if (this.opb != null) {
        this.opb.onTouch(this, paramMotionEvent);
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
    if ((this.ooU) || (super.dispatchTouchEvent(paramMotionEvent))) {
      bool = true;
    }
    return bool;
  }
  
  public DragFeatureView getDragRubbishView()
  {
    return this.opb;
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
    localb.bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/DragRecyclerView", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.axR());
    if (this.ooU)
    {
      Log.i("DragRecyclerView", "alvinluo onLongPress ignore");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/DragRecyclerView", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
      return;
    }
    if (this.opb != null)
    {
      this.opb.onLongPress(paramMotionEvent);
      if (this.opb.getVisibility() != 0) {
        break label101;
      }
    }
    label101:
    for (boolean bool = true;; bool = false)
    {
      this.ooU = bool;
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
    localb.bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/DragRecyclerView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/appbrand/widget/desktop/DragRecyclerView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    return false;
  }
  
  public void setLongPress(boolean paramBoolean)
  {
    this.ooU = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.DragRecyclerView
 * JD-Core Version:    0.7.0.1
 */
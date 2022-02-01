package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class DragRecyclerView
  extends RecyclerView
  implements GestureDetector.OnGestureListener
{
  private GestureDetector mQj;
  public boolean uAR = false;
  protected DragFeatureView uBe;
  
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
    this.mQj = new GestureDetector(paramContext, this);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    Object localObject = getContext();
    if ((Build.VERSION.SDK_INT >= 24) && ((localObject instanceof Activity)) && (((Activity)localObject).isInMultiWindowMode())) {
      bool = super.dispatchTouchEvent(paramMotionEvent);
    }
    for (;;)
    {
      return bool;
      localObject = this.mQj;
      com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/plugin/appbrand/widget/desktop/DragRecyclerView", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)locala.sb(0)), "com/tencent/mm/plugin/appbrand/widget/desktop/DragRecyclerView", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      if ((this.uAR) || (((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) && (this.uBe != null) && (this.uBe.uAR)))
      {
        if (this.uBe != null) {
          this.uBe.onTouch(this, paramMotionEvent);
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
      while ((this.uAR) || (super.dispatchTouchEvent(paramMotionEvent)))
      {
        return true;
        if (paramMotionEvent.getAction() == 3)
        {
          localObject = this.uBe;
          Log.i("MicroMsg.DragFeatureView", "cancelGestureDetector");
          localObject = ((DragFeatureView)localObject).mQj;
          locala = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "cancelGestureDetector", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
          com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)locala.sb(0)), "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "cancelGestureDetector", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        }
      }
    }
  }
  
  public DragFeatureView getDragRubbishView()
  {
    return this.uBe;
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
    localb.cH(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/widget/desktop/DragRecyclerView", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aYj());
    if (this.uAR)
    {
      Log.i("DragRecyclerView", "alvinluo onLongPress ignore");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/DragRecyclerView", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
      return;
    }
    if (this.uBe != null)
    {
      this.uBe.onLongPress(paramMotionEvent);
      if (this.uBe.getVisibility() != 0) {
        break label101;
      }
    }
    label101:
    for (boolean bool = true;; bool = false)
    {
      this.uAR = bool;
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
    localb.cH(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/widget/desktop/DragRecyclerView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/appbrand/widget/desktop/DragRecyclerView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    return false;
  }
  
  public void setLongPress(boolean paramBoolean)
  {
    this.uAR = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.DragRecyclerView
 * JD-Core Version:    0.7.0.1
 */
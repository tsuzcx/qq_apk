package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

final class q$1
  extends RelativeLayout
{
  q$1(q paramq, Context paramContext)
  {
    super(paramContext);
  }
  
  protected final void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Object localObject = q.c(this.gTY);
    long l = SystemClock.uptimeMillis();
    MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
    localMotionEvent.setSource(4098);
    localObject = ((y)localObject).gVk.iterator();
    while (((Iterator)localObject).hasNext())
    {
      View localView = (View)((y.b)((Iterator)localObject).next()).gVz.get();
      if (localView != null) {
        localView.dispatchTouchEvent(localMotionEvent);
      }
    }
    localMotionEvent.recycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.q.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.page;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

final class a$1
  implements View.OnAttachStateChangeListener
{
  a$1(a parama) {}
  
  public final void onViewAttachedToWindow(View paramView) {}
  
  public final void onViewDetachedFromWindow(View paramView)
  {
    AppMethodBeat.i(140857);
    Object localObject = this.iuH.iuE;
    long l = SystemClock.uptimeMillis();
    paramView = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
    paramView.setSource(4098);
    localObject = ((af)localObject).iyx.iterator();
    while (((Iterator)localObject).hasNext())
    {
      View localView = (View)((af.b)((Iterator)localObject).next()).iyQ.get();
      if (localView != null) {
        localView.dispatchTouchEvent(paramView);
      }
    }
    paramView.recycle();
    AppMethodBeat.o(140857);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.a.1
 * JD-Core Version:    0.7.0.1
 */
package androidx.appcompat.widget;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SearchView$e
  extends TouchDelegate
{
  private boolean mDelegateTargeted;
  private final View we;
  private final Rect wf;
  private final Rect wg;
  private final Rect wh;
  private final int wi;
  
  public SearchView$e(Rect paramRect1, Rect paramRect2, View paramView)
  {
    super(paramRect1, paramView);
    AppMethodBeat.i(199608);
    this.wi = ViewConfiguration.get(paramView.getContext()).getScaledTouchSlop();
    this.wf = new Rect();
    this.wh = new Rect();
    this.wg = new Rect();
    e(paramRect1, paramRect2);
    this.we = paramView;
    AppMethodBeat.o(199608);
  }
  
  public final void e(Rect paramRect1, Rect paramRect2)
  {
    AppMethodBeat.i(199621);
    this.wf.set(paramRect1);
    this.wh.set(paramRect1);
    this.wh.inset(-this.wi, -this.wi);
    this.wg.set(paramRect2);
    AppMethodBeat.o(199621);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool3 = false;
    AppMethodBeat.i(199635);
    int j = (int)paramMotionEvent.getX();
    int k = (int)paramMotionEvent.getY();
    int i;
    boolean bool1;
    label61:
    boolean bool2;
    switch (paramMotionEvent.getAction())
    {
    default: 
      i = 1;
      bool1 = false;
      bool2 = bool3;
      if (bool1)
      {
        if ((i == 0) || (this.wg.contains(j, k))) {
          break label212;
        }
        paramMotionEvent.setLocation(this.we.getWidth() / 2, this.we.getHeight() / 2);
      }
      break;
    }
    for (;;)
    {
      bool2 = this.we.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(199635);
      return bool2;
      if (!this.wf.contains(j, k)) {
        break;
      }
      this.mDelegateTargeted = true;
      i = 1;
      bool1 = true;
      break label61;
      bool2 = this.mDelegateTargeted;
      bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (!this.wh.contains(j, k))
        {
          i = 0;
          bool1 = bool2;
          break label61;
          bool1 = this.mDelegateTargeted;
          this.mDelegateTargeted = false;
        }
      }
      i = 1;
      break label61;
      label212:
      paramMotionEvent.setLocation(j - this.wg.left, k - this.wg.top);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.appcompat.widget.SearchView.e
 * JD-Core Version:    0.7.0.1
 */
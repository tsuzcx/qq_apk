package android.support.v7.widget;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;

final class SearchView$e
  extends TouchDelegate
{
  private final View awE;
  private final Rect awF;
  private final Rect awG;
  private final Rect awH;
  private final int awI;
  private boolean awJ;
  
  public SearchView$e(Rect paramRect1, Rect paramRect2, View paramView)
  {
    super(paramRect1, paramView);
    this.awI = ViewConfiguration.get(paramView.getContext()).getScaledTouchSlop();
    this.awF = new Rect();
    this.awH = new Rect();
    this.awG = new Rect();
    a(paramRect1, paramRect2);
    this.awE = paramView;
  }
  
  public final void a(Rect paramRect1, Rect paramRect2)
  {
    this.awF.set(paramRect1);
    this.awH.set(paramRect1);
    this.awH.inset(-this.awI, -this.awI);
    this.awG.set(paramRect2);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool3 = false;
    int j = (int)paramMotionEvent.getX();
    int k = (int)paramMotionEvent.getY();
    int i;
    boolean bool1;
    label57:
    boolean bool2;
    switch (paramMotionEvent.getAction())
    {
    default: 
      i = 1;
      bool1 = false;
      bool2 = bool3;
      if (bool1)
      {
        if ((i == 0) || (this.awG.contains(j, k))) {
          break label203;
        }
        paramMotionEvent.setLocation(this.awE.getWidth() / 2, this.awE.getHeight() / 2);
      }
      break;
    }
    for (;;)
    {
      bool2 = this.awE.dispatchTouchEvent(paramMotionEvent);
      return bool2;
      if (!this.awF.contains(j, k)) {
        break;
      }
      this.awJ = true;
      i = 1;
      bool1 = true;
      break label57;
      bool2 = this.awJ;
      bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (!this.awH.contains(j, k))
        {
          i = 0;
          bool1 = bool2;
          break label57;
          bool1 = this.awJ;
          this.awJ = false;
        }
      }
      i = 1;
      break label57;
      label203:
      paramMotionEvent.setLocation(j - this.awG.left, k - this.awG.top);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v7.widget.SearchView.e
 * JD-Core Version:    0.7.0.1
 */
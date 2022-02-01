package android.support.v7.widget;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;

final class SearchView$e
  extends TouchDelegate
{
  private final View awC;
  private final Rect awD;
  private final Rect awE;
  private final Rect awF;
  private final int awG;
  private boolean awH;
  
  public SearchView$e(Rect paramRect1, Rect paramRect2, View paramView)
  {
    super(paramRect1, paramView);
    this.awG = ViewConfiguration.get(paramView.getContext()).getScaledTouchSlop();
    this.awD = new Rect();
    this.awF = new Rect();
    this.awE = new Rect();
    a(paramRect1, paramRect2);
    this.awC = paramView;
  }
  
  public final void a(Rect paramRect1, Rect paramRect2)
  {
    this.awD.set(paramRect1);
    this.awF.set(paramRect1);
    this.awF.inset(-this.awG, -this.awG);
    this.awE.set(paramRect2);
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
        if ((i == 0) || (this.awE.contains(j, k))) {
          break label203;
        }
        paramMotionEvent.setLocation(this.awC.getWidth() / 2, this.awC.getHeight() / 2);
      }
      break;
    }
    for (;;)
    {
      bool2 = this.awC.dispatchTouchEvent(paramMotionEvent);
      return bool2;
      if (!this.awD.contains(j, k)) {
        break;
      }
      this.awH = true;
      i = 1;
      bool1 = true;
      break label57;
      bool2 = this.awH;
      bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (!this.awF.contains(j, k))
        {
          i = 0;
          bool1 = bool2;
          break label57;
          bool1 = this.awH;
          this.awH = false;
        }
      }
      i = 1;
      break label57;
      label203:
      paramMotionEvent.setLocation(j - this.awE.left, k - this.awE.top);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.v7.widget.SearchView.e
 * JD-Core Version:    0.7.0.1
 */
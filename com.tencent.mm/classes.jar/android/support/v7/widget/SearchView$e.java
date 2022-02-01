package android.support.v7.widget;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;

final class SearchView$e
  extends TouchDelegate
{
  private final View auM;
  private final Rect auN;
  private final Rect auO;
  private final Rect auP;
  private final int auQ;
  private boolean auR;
  
  public SearchView$e(Rect paramRect1, Rect paramRect2, View paramView)
  {
    super(paramRect1, paramView);
    this.auQ = ViewConfiguration.get(paramView.getContext()).getScaledTouchSlop();
    this.auN = new Rect();
    this.auP = new Rect();
    this.auO = new Rect();
    a(paramRect1, paramRect2);
    this.auM = paramView;
  }
  
  public final void a(Rect paramRect1, Rect paramRect2)
  {
    this.auN.set(paramRect1);
    this.auP.set(paramRect1);
    this.auP.inset(-this.auQ, -this.auQ);
    this.auO.set(paramRect2);
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
        if ((i == 0) || (this.auO.contains(j, k))) {
          break label203;
        }
        paramMotionEvent.setLocation(this.auM.getWidth() / 2, this.auM.getHeight() / 2);
      }
      break;
    }
    for (;;)
    {
      bool2 = this.auM.dispatchTouchEvent(paramMotionEvent);
      return bool2;
      if (!this.auN.contains(j, k)) {
        break;
      }
      this.auR = true;
      i = 1;
      bool1 = true;
      break label57;
      bool2 = this.auR;
      bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (!this.auP.contains(j, k))
        {
          i = 0;
          bool1 = bool2;
          break label57;
          bool1 = this.auR;
          this.auR = false;
        }
      }
      i = 1;
      break label57;
      label203:
      paramMotionEvent.setLocation(j - this.auO.left, k - this.auO.top);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v7.widget.SearchView.e
 * JD-Core Version:    0.7.0.1
 */
package android.support.v7.widget;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;

final class SearchView$e
  extends TouchDelegate
{
  private final View atR;
  private final Rect atS;
  private final Rect atT;
  private final Rect atU;
  private final int atV;
  private boolean atW;
  
  public SearchView$e(Rect paramRect1, Rect paramRect2, View paramView)
  {
    super(paramRect1, paramView);
    this.atV = ViewConfiguration.get(paramView.getContext()).getScaledTouchSlop();
    this.atS = new Rect();
    this.atU = new Rect();
    this.atT = new Rect();
    a(paramRect1, paramRect2);
    this.atR = paramView;
  }
  
  public final void a(Rect paramRect1, Rect paramRect2)
  {
    this.atS.set(paramRect1);
    this.atU.set(paramRect1);
    this.atU.inset(-this.atV, -this.atV);
    this.atT.set(paramRect2);
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
        if ((i == 0) || (this.atT.contains(j, k))) {
          break label203;
        }
        paramMotionEvent.setLocation(this.atR.getWidth() / 2, this.atR.getHeight() / 2);
      }
      break;
    }
    for (;;)
    {
      bool2 = this.atR.dispatchTouchEvent(paramMotionEvent);
      return bool2;
      if (!this.atS.contains(j, k)) {
        break;
      }
      this.atW = true;
      i = 1;
      bool1 = true;
      break label57;
      bool2 = this.atW;
      bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (!this.atU.contains(j, k))
        {
          i = 0;
          bool1 = bool2;
          break label57;
          bool1 = this.atW;
          this.atW = false;
        }
      }
      i = 1;
      break label57;
      label203:
      paramMotionEvent.setLocation(j - this.atT.left, k - this.atT.top);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v7.widget.SearchView.e
 * JD-Core Version:    0.7.0.1
 */
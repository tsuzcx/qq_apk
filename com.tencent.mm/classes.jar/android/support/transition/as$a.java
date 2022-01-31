package android.support.transition;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.q;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.reflect.Method;
import java.util.ArrayList;

final class as$a
  extends ViewGroup
{
  static Method tl;
  ViewGroup tm;
  View tn;
  ArrayList<Drawable> to = null;
  as tp;
  
  static
  {
    try
    {
      tl = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", new Class[] { Integer.TYPE, Integer.TYPE, Rect.class });
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException) {}
  }
  
  as$a(Context paramContext, ViewGroup paramViewGroup, View paramView, as paramas)
  {
    super(paramContext);
    this.tm = paramViewGroup;
    this.tn = paramView;
    setRight(paramViewGroup.getWidth());
    setBottom(paramViewGroup.getHeight());
    paramViewGroup.addView(this);
    this.tp = paramas;
  }
  
  public final void add(View paramView)
  {
    if ((paramView.getParent() instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
      if ((localViewGroup != this.tm) && (localViewGroup.getParent() != null) && (q.ao(localViewGroup)))
      {
        int[] arrayOfInt1 = new int[2];
        int[] arrayOfInt2 = new int[2];
        localViewGroup.getLocationOnScreen(arrayOfInt1);
        this.tm.getLocationOnScreen(arrayOfInt2);
        q.q(paramView, arrayOfInt1[0] - arrayOfInt2[0]);
        q.p(paramView, arrayOfInt1[1] - arrayOfInt2[1]);
      }
      localViewGroup.removeView(paramView);
      if (paramView.getParent() != null) {
        localViewGroup.removeView(paramView);
      }
    }
    super.addView(paramView, getChildCount() - 1);
  }
  
  protected final void dispatchDraw(Canvas paramCanvas)
  {
    int[] arrayOfInt1 = new int[2];
    int[] arrayOfInt2 = new int[2];
    this.tm.getLocationOnScreen(arrayOfInt1);
    this.tn.getLocationOnScreen(arrayOfInt2);
    paramCanvas.translate(arrayOfInt2[0] - arrayOfInt1[0], arrayOfInt2[1] - arrayOfInt1[1]);
    paramCanvas.clipRect(new Rect(0, 0, this.tn.getWidth(), this.tn.getHeight()));
    super.dispatchDraw(paramCanvas);
    if (this.to == null) {}
    for (int i = 0;; i = this.to.size())
    {
      int j = 0;
      while (j < i)
      {
        ((Drawable)this.to.get(j)).draw(paramCanvas);
        j += 1;
      }
    }
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public final ViewParent invalidateChildInParent(int[] paramArrayOfInt, Rect paramRect)
  {
    if (this.tm != null)
    {
      paramRect.offset(paramArrayOfInt[0], paramArrayOfInt[1]);
      if ((this.tm instanceof ViewGroup))
      {
        paramArrayOfInt[0] = 0;
        paramArrayOfInt[1] = 0;
        int[] arrayOfInt1 = new int[2];
        int[] arrayOfInt2 = new int[2];
        int[] arrayOfInt3 = new int[2];
        this.tm.getLocationOnScreen(arrayOfInt2);
        this.tn.getLocationOnScreen(arrayOfInt3);
        arrayOfInt3[0] -= arrayOfInt2[0];
        arrayOfInt3[1] -= arrayOfInt2[1];
        paramRect.offset(arrayOfInt1[0], arrayOfInt1[1]);
        return super.invalidateChildInParent(paramArrayOfInt, paramRect);
      }
      invalidate(paramRect);
    }
    return null;
  }
  
  public final void invalidateDrawable(Drawable paramDrawable)
  {
    invalidate(paramDrawable.getBounds());
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public final void remove(View paramView)
  {
    super.removeView(paramView);
    if ((getChildCount() == 0) && ((this.to == null) || (this.to.size() == 0))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.tm.removeView(this);
      }
      return;
    }
  }
  
  protected final boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || ((this.to != null) && (this.to.contains(paramDrawable)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     android.support.transition.as.a
 * JD-Core Version:    0.7.0.1
 */
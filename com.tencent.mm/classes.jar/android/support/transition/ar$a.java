package android.support.transition;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.t;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.reflect.Method;
import java.util.ArrayList;

final class ar$a
  extends ViewGroup
{
  static Method uo;
  ViewGroup up;
  View uq;
  ArrayList<Drawable> ur = null;
  ar ut;
  
  static
  {
    try
    {
      uo = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", new Class[] { Integer.TYPE, Integer.TYPE, Rect.class });
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException) {}
  }
  
  ar$a(Context paramContext, ViewGroup paramViewGroup, View paramView, ar paramar)
  {
    super(paramContext);
    this.up = paramViewGroup;
    this.uq = paramView;
    setRight(paramViewGroup.getWidth());
    setBottom(paramViewGroup.getHeight());
    paramViewGroup.addView(this);
    this.ut = paramar;
  }
  
  public final void add(View paramView)
  {
    if ((paramView.getParent() instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
      if ((localViewGroup != this.up) && (localViewGroup.getParent() != null) && (t.aw(localViewGroup)))
      {
        int[] arrayOfInt1 = new int[2];
        int[] arrayOfInt2 = new int[2];
        localViewGroup.getLocationOnScreen(arrayOfInt1);
        this.up.getLocationOnScreen(arrayOfInt2);
        t.s(paramView, arrayOfInt1[0] - arrayOfInt2[0]);
        t.q(paramView, arrayOfInt1[1] - arrayOfInt2[1]);
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
    this.up.getLocationOnScreen(arrayOfInt1);
    this.uq.getLocationOnScreen(arrayOfInt2);
    paramCanvas.translate(arrayOfInt2[0] - arrayOfInt1[0], arrayOfInt2[1] - arrayOfInt1[1]);
    paramCanvas.clipRect(new Rect(0, 0, this.uq.getWidth(), this.uq.getHeight()));
    super.dispatchDraw(paramCanvas);
    if (this.ur == null) {}
    for (int i = 0;; i = this.ur.size())
    {
      int j = 0;
      while (j < i)
      {
        ((Drawable)this.ur.get(j)).draw(paramCanvas);
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
    if (this.up != null)
    {
      paramRect.offset(paramArrayOfInt[0], paramArrayOfInt[1]);
      if ((this.up instanceof ViewGroup))
      {
        paramArrayOfInt[0] = 0;
        paramArrayOfInt[1] = 0;
        int[] arrayOfInt1 = new int[2];
        int[] arrayOfInt2 = new int[2];
        int[] arrayOfInt3 = new int[2];
        this.up.getLocationOnScreen(arrayOfInt2);
        this.uq.getLocationOnScreen(arrayOfInt3);
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
    if ((getChildCount() == 0) && ((this.ur == null) || (this.ur.size() == 0))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.up.removeView(this);
      }
      return;
    }
  }
  
  protected final boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || ((this.ur != null) && (this.ur.contains(paramDrawable)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.transition.ar.a
 * JD-Core Version:    0.7.0.1
 */
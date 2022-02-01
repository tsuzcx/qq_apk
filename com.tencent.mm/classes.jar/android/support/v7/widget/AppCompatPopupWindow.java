package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.widget.n;
import android.support.v7.a.a.a;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;

class AppCompatPopupWindow
  extends PopupWindow
{
  private static final boolean akw;
  private boolean akx;
  
  static
  {
    if (Build.VERSION.SDK_INT < 21) {}
    for (boolean bool = true;; bool = false)
    {
      akw = bool;
      return;
    }
  }
  
  public AppCompatPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  public AppCompatPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    b(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  private void ah(boolean paramBoolean)
  {
    if (akw)
    {
      this.akx = paramBoolean;
      return;
    }
    n.a(this, paramBoolean);
  }
  
  private void b(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    paramContext = az.a(paramContext, paramAttributeSet, a.a.PopupWindow, paramInt1, paramInt2);
    if (paramContext.hasValue(2)) {
      ah(paramContext.getBoolean(2, false));
    }
    setBackgroundDrawable(paramContext.getDrawable(0));
    paramContext.ayA.recycle();
  }
  
  public void showAsDropDown(View paramView, int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (akw)
    {
      i = paramInt2;
      if (this.akx) {
        i = paramInt2 - paramView.getHeight();
      }
    }
    super.showAsDropDown(paramView, paramInt1, i);
  }
  
  public void showAsDropDown(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt2;
    if (akw)
    {
      i = paramInt2;
      if (this.akx) {
        i = paramInt2 - paramView.getHeight();
      }
    }
    super.showAsDropDown(paramView, paramInt1, i, paramInt3);
  }
  
  public void update(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((akw) && (this.akx)) {
      paramInt2 -= paramView.getHeight();
    }
    for (;;)
    {
      super.update(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.AppCompatPopupWindow
 * JD-Core Version:    0.7.0.1
 */
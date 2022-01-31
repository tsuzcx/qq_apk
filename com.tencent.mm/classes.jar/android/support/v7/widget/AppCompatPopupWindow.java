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
  private static final boolean aaF;
  private boolean aaG;
  
  static
  {
    if (Build.VERSION.SDK_INT < 21) {}
    for (boolean bool = true;; bool = false)
    {
      aaF = bool;
      return;
    }
  }
  
  public AppCompatPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  public AppCompatPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    paramContext = az.a(paramContext, paramAttributeSet, a.a.PopupWindow, paramInt1, paramInt2);
    if (paramContext.hasValue(2)) {
      ab(paramContext.getBoolean(2, false));
    }
    setBackgroundDrawable(paramContext.getDrawable(0));
    paramContext.aoo.recycle();
  }
  
  private void ab(boolean paramBoolean)
  {
    if (aaF)
    {
      this.aaG = paramBoolean;
      return;
    }
    n.a(this, paramBoolean);
  }
  
  public void showAsDropDown(View paramView, int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (aaF)
    {
      i = paramInt2;
      if (this.aaG) {
        i = paramInt2 - paramView.getHeight();
      }
    }
    super.showAsDropDown(paramView, paramInt1, i);
  }
  
  public void showAsDropDown(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt2;
    if (aaF)
    {
      i = paramInt2;
      if (this.aaG) {
        i = paramInt2 - paramView.getHeight();
      }
    }
    super.showAsDropDown(paramView, paramInt1, i, paramInt3);
  }
  
  public void update(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((aaF) && (this.aaG)) {
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
package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.a.a.a;
import android.support.v4.widget.e;
import android.support.v7.a.a.j;
import android.support.v7.c.a.b;
import android.util.AttributeSet;
import android.widget.CompoundButton;

final class g
{
  private boolean ZA = false;
  private boolean ZB;
  private final CompoundButton Zw;
  ColorStateList Zx = null;
  PorterDuff.Mode Zy = null;
  private boolean Zz = false;
  
  g(CompoundButton paramCompoundButton)
  {
    this.Zw = paramCompoundButton;
  }
  
  private void gh()
  {
    Drawable localDrawable = e.a(this.Zw);
    if ((localDrawable != null) && ((this.Zz) || (this.ZA)))
    {
      localDrawable = a.f(localDrawable).mutate();
      if (this.Zz) {
        a.a(localDrawable, this.Zx);
      }
      if (this.ZA) {
        a.a(localDrawable, this.Zy);
      }
      if (localDrawable.isStateful()) {
        localDrawable.setState(this.Zw.getDrawableState());
      }
      this.Zw.setButtonDrawable(localDrawable);
    }
  }
  
  final void b(AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = this.Zw.getContext().obtainStyledAttributes(paramAttributeSet, a.j.CompoundButton, paramInt, 0);
    try
    {
      if (paramAttributeSet.hasValue(a.j.CompoundButton_android_button))
      {
        paramInt = paramAttributeSet.getResourceId(a.j.CompoundButton_android_button, 0);
        if (paramInt != 0) {
          this.Zw.setButtonDrawable(b.g(this.Zw.getContext(), paramInt));
        }
      }
      if (paramAttributeSet.hasValue(a.j.CompoundButton_buttonTint)) {
        e.a(this.Zw, paramAttributeSet.getColorStateList(a.j.CompoundButton_buttonTint));
      }
      if (paramAttributeSet.hasValue(a.j.CompoundButton_buttonTintMode)) {
        e.a(this.Zw, y.c(paramAttributeSet.getInt(a.j.CompoundButton_buttonTintMode, -1), null));
      }
      return;
    }
    finally
    {
      paramAttributeSet.recycle();
    }
  }
  
  final int bq(int paramInt)
  {
    int i = paramInt;
    if (Build.VERSION.SDK_INT < 17)
    {
      Drawable localDrawable = e.a(this.Zw);
      i = paramInt;
      if (localDrawable != null) {
        i = paramInt + localDrawable.getIntrinsicWidth();
      }
    }
    return i;
  }
  
  final void gg()
  {
    if (this.ZB)
    {
      this.ZB = false;
      return;
    }
    this.ZB = true;
    gh();
  }
  
  final void setSupportButtonTintList(ColorStateList paramColorStateList)
  {
    this.Zx = paramColorStateList;
    this.Zz = true;
    gh();
  }
  
  final void setSupportButtonTintMode(PorterDuff.Mode paramMode)
  {
    this.Zy = paramMode;
    this.ZA = true;
    gh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.g
 * JD-Core Version:    0.7.0.1
 */
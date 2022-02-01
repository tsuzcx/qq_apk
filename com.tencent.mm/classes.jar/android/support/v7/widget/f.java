package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.widget.e;
import android.support.v7.a.a.a;
import android.util.AttributeSet;
import android.widget.CompoundButton;

final class f
{
  private final CompoundButton ajX;
  ColorStateList ajY = null;
  PorterDuff.Mode ajZ = null;
  private boolean aka = false;
  private boolean akb = false;
  private boolean akc;
  
  f(CompoundButton paramCompoundButton)
  {
    this.ajX = paramCompoundButton;
  }
  
  private void ja()
  {
    Drawable localDrawable = e.a(this.ajX);
    if ((localDrawable != null) && ((this.aka) || (this.akb)))
    {
      localDrawable = android.support.v4.graphics.drawable.a.i(localDrawable).mutate();
      if (this.aka) {
        android.support.v4.graphics.drawable.a.a(localDrawable, this.ajY);
      }
      if (this.akb) {
        android.support.v4.graphics.drawable.a.a(localDrawable, this.ajZ);
      }
      if (localDrawable.isStateful()) {
        localDrawable.setState(this.ajX.getDrawableState());
      }
      this.ajX.setButtonDrawable(localDrawable);
    }
  }
  
  final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = this.ajX.getContext().obtainStyledAttributes(paramAttributeSet, a.a.CompoundButton, paramInt, 0);
    try
    {
      if (paramAttributeSet.hasValue(0))
      {
        paramInt = paramAttributeSet.getResourceId(0, 0);
        if (paramInt != 0) {
          this.ajX.setButtonDrawable(android.support.v7.c.a.a.l(this.ajX.getContext(), paramInt));
        }
      }
      if (paramAttributeSet.hasValue(1)) {
        e.a(this.ajX, paramAttributeSet.getColorStateList(1));
      }
      if (paramAttributeSet.hasValue(2)) {
        e.a(this.ajX, x.a(paramAttributeSet.getInt(2, -1), null));
      }
      return;
    }
    finally
    {
      paramAttributeSet.recycle();
    }
  }
  
  final int bH(int paramInt)
  {
    int i = paramInt;
    if (Build.VERSION.SDK_INT < 17)
    {
      Drawable localDrawable = e.a(this.ajX);
      i = paramInt;
      if (localDrawable != null) {
        i = paramInt + localDrawable.getIntrinsicWidth();
      }
    }
    return i;
  }
  
  final void iZ()
  {
    if (this.akc)
    {
      this.akc = false;
      return;
    }
    this.akc = true;
    ja();
  }
  
  final void setSupportButtonTintList(ColorStateList paramColorStateList)
  {
    this.ajY = paramColorStateList;
    this.aka = true;
    ja();
  }
  
  final void setSupportButtonTintMode(PorterDuff.Mode paramMode)
  {
    this.ajZ = paramMode;
    this.akb = true;
    ja();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.f
 * JD-Core Version:    0.7.0.1
 */
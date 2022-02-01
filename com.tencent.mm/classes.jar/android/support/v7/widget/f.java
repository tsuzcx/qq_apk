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
  private final CompoundButton akk;
  ColorStateList akl = null;
  PorterDuff.Mode akm = null;
  private boolean akn = false;
  private boolean ako = false;
  private boolean akp;
  
  f(CompoundButton paramCompoundButton)
  {
    this.akk = paramCompoundButton;
  }
  
  private void jj()
  {
    Drawable localDrawable = e.a(this.akk);
    if ((localDrawable != null) && ((this.akn) || (this.ako)))
    {
      localDrawable = android.support.v4.graphics.drawable.a.i(localDrawable).mutate();
      if (this.akn) {
        android.support.v4.graphics.drawable.a.a(localDrawable, this.akl);
      }
      if (this.ako) {
        android.support.v4.graphics.drawable.a.a(localDrawable, this.akm);
      }
      if (localDrawable.isStateful()) {
        localDrawable.setState(this.akk.getDrawableState());
      }
      this.akk.setButtonDrawable(localDrawable);
    }
  }
  
  final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = this.akk.getContext().obtainStyledAttributes(paramAttributeSet, a.a.CompoundButton, paramInt, 0);
    try
    {
      if (paramAttributeSet.hasValue(0))
      {
        paramInt = paramAttributeSet.getResourceId(0, 0);
        if (paramInt != 0) {
          this.akk.setButtonDrawable(android.support.v7.c.a.a.l(this.akk.getContext(), paramInt));
        }
      }
      if (paramAttributeSet.hasValue(1)) {
        e.a(this.akk, paramAttributeSet.getColorStateList(1));
      }
      if (paramAttributeSet.hasValue(2)) {
        e.a(this.akk, x.a(paramAttributeSet.getInt(2, -1), null));
      }
      return;
    }
    finally
    {
      paramAttributeSet.recycle();
    }
  }
  
  final int bI(int paramInt)
  {
    int i = paramInt;
    if (Build.VERSION.SDK_INT < 17)
    {
      Drawable localDrawable = e.a(this.akk);
      i = paramInt;
      if (localDrawable != null) {
        i = paramInt + localDrawable.getIntrinsicWidth();
      }
    }
    return i;
  }
  
  final void ji()
  {
    if (this.akp)
    {
      this.akp = false;
      return;
    }
    this.akp = true;
    jj();
  }
  
  final void setSupportButtonTintList(ColorStateList paramColorStateList)
  {
    this.akl = paramColorStateList;
    this.akn = true;
    jj();
  }
  
  final void setSupportButtonTintMode(PorterDuff.Mode paramMode)
  {
    this.akm = paramMode;
    this.ako = true;
    jj();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.f
 * JD-Core Version:    0.7.0.1
 */
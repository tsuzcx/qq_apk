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
  private final CompoundButton aig;
  ColorStateList aih = null;
  PorterDuff.Mode aii = null;
  private boolean aij = false;
  private boolean aik = false;
  private boolean ail;
  
  f(CompoundButton paramCompoundButton)
  {
    this.aig = paramCompoundButton;
  }
  
  private void iK()
  {
    Drawable localDrawable = e.a(this.aig);
    if ((localDrawable != null) && ((this.aij) || (this.aik)))
    {
      localDrawable = android.support.v4.graphics.drawable.a.i(localDrawable).mutate();
      if (this.aij) {
        android.support.v4.graphics.drawable.a.a(localDrawable, this.aih);
      }
      if (this.aik) {
        android.support.v4.graphics.drawable.a.a(localDrawable, this.aii);
      }
      if (localDrawable.isStateful()) {
        localDrawable.setState(this.aig.getDrawableState());
      }
      this.aig.setButtonDrawable(localDrawable);
    }
  }
  
  final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = this.aig.getContext().obtainStyledAttributes(paramAttributeSet, a.a.CompoundButton, paramInt, 0);
    try
    {
      if (paramAttributeSet.hasValue(0))
      {
        paramInt = paramAttributeSet.getResourceId(0, 0);
        if (paramInt != 0) {
          this.aig.setButtonDrawable(android.support.v7.c.a.a.l(this.aig.getContext(), paramInt));
        }
      }
      if (paramAttributeSet.hasValue(1)) {
        e.a(this.aig, paramAttributeSet.getColorStateList(1));
      }
      if (paramAttributeSet.hasValue(2)) {
        e.a(this.aig, x.a(paramAttributeSet.getInt(2, -1), null));
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
      Drawable localDrawable = e.a(this.aig);
      i = paramInt;
      if (localDrawable != null) {
        i = paramInt + localDrawable.getIntrinsicWidth();
      }
    }
    return i;
  }
  
  final void iJ()
  {
    if (this.ail)
    {
      this.ail = false;
      return;
    }
    this.ail = true;
    iK();
  }
  
  final void setSupportButtonTintList(ColorStateList paramColorStateList)
  {
    this.aih = paramColorStateList;
    this.aij = true;
    iK();
  }
  
  final void setSupportButtonTintMode(PorterDuff.Mode paramMode)
  {
    this.aii = paramMode;
    this.aik = true;
    iK();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.f
 * JD-Core Version:    0.7.0.1
 */
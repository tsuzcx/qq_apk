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
  private final CompoundButton ahm;
  ColorStateList ahn = null;
  PorterDuff.Mode aho = null;
  private boolean ahp = false;
  private boolean ahq = false;
  private boolean ahr;
  
  f(CompoundButton paramCompoundButton)
  {
    this.ahm = paramCompoundButton;
  }
  
  private void iC()
  {
    Drawable localDrawable = e.a(this.ahm);
    if ((localDrawable != null) && ((this.ahp) || (this.ahq)))
    {
      localDrawable = android.support.v4.graphics.drawable.a.i(localDrawable).mutate();
      if (this.ahp) {
        android.support.v4.graphics.drawable.a.a(localDrawable, this.ahn);
      }
      if (this.ahq) {
        android.support.v4.graphics.drawable.a.a(localDrawable, this.aho);
      }
      if (localDrawable.isStateful()) {
        localDrawable.setState(this.ahm.getDrawableState());
      }
      this.ahm.setButtonDrawable(localDrawable);
    }
  }
  
  final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = this.ahm.getContext().obtainStyledAttributes(paramAttributeSet, a.a.CompoundButton, paramInt, 0);
    try
    {
      if (paramAttributeSet.hasValue(0))
      {
        paramInt = paramAttributeSet.getResourceId(0, 0);
        if (paramInt != 0) {
          this.ahm.setButtonDrawable(android.support.v7.c.a.a.l(this.ahm.getContext(), paramInt));
        }
      }
      if (paramAttributeSet.hasValue(1)) {
        e.a(this.ahm, paramAttributeSet.getColorStateList(1));
      }
      if (paramAttributeSet.hasValue(2)) {
        e.a(this.ahm, x.a(paramAttributeSet.getInt(2, -1), null));
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
      Drawable localDrawable = e.a(this.ahm);
      i = paramInt;
      if (localDrawable != null) {
        i = paramInt + localDrawable.getIntrinsicWidth();
      }
    }
    return i;
  }
  
  final void iB()
  {
    if (this.ahr)
    {
      this.ahr = false;
      return;
    }
    this.ahr = true;
    iC();
  }
  
  final void setSupportButtonTintList(ColorStateList paramColorStateList)
  {
    this.ahn = paramColorStateList;
    this.ahp = true;
    iC();
  }
  
  final void setSupportButtonTintMode(PorterDuff.Mode paramMode)
  {
    this.aho = paramMode;
    this.ahq = true;
    iC();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.f
 * JD-Core Version:    0.7.0.1
 */
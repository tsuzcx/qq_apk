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
  private final CompoundButton aah;
  ColorStateList aai = null;
  PorterDuff.Mode aaj = null;
  private boolean aak = false;
  private boolean aal = false;
  private boolean aam;
  
  f(CompoundButton paramCompoundButton)
  {
    this.aah = paramCompoundButton;
  }
  
  private void hf()
  {
    Drawable localDrawable = e.a(this.aah);
    if ((localDrawable != null) && ((this.aak) || (this.aal)))
    {
      localDrawable = android.support.v4.graphics.drawable.a.e(localDrawable).mutate();
      if (this.aak) {
        android.support.v4.graphics.drawable.a.a(localDrawable, this.aai);
      }
      if (this.aal) {
        android.support.v4.graphics.drawable.a.a(localDrawable, this.aaj);
      }
      if (localDrawable.isStateful()) {
        localDrawable.setState(this.aah.getDrawableState());
      }
      this.aah.setButtonDrawable(localDrawable);
    }
  }
  
  final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = this.aah.getContext().obtainStyledAttributes(paramAttributeSet, a.a.CompoundButton, paramInt, 0);
    try
    {
      if (paramAttributeSet.hasValue(0))
      {
        paramInt = paramAttributeSet.getResourceId(0, 0);
        if (paramInt != 0) {
          this.aah.setButtonDrawable(android.support.v7.c.a.a.k(this.aah.getContext(), paramInt));
        }
      }
      if (paramAttributeSet.hasValue(1)) {
        e.a(this.aah, paramAttributeSet.getColorStateList(1));
      }
      if (paramAttributeSet.hasValue(2)) {
        e.a(this.aah, x.c(paramAttributeSet.getInt(2, -1), null));
      }
      return;
    }
    finally
    {
      paramAttributeSet.recycle();
    }
  }
  
  final int bp(int paramInt)
  {
    int i = paramInt;
    if (Build.VERSION.SDK_INT < 17)
    {
      Drawable localDrawable = e.a(this.aah);
      i = paramInt;
      if (localDrawable != null) {
        i = paramInt + localDrawable.getIntrinsicWidth();
      }
    }
    return i;
  }
  
  final void he()
  {
    if (this.aam)
    {
      this.aam = false;
      return;
    }
    this.aam = true;
    hf();
  }
  
  final void setSupportButtonTintList(ColorStateList paramColorStateList)
  {
    this.aai = paramColorStateList;
    this.aak = true;
    hf();
  }
  
  final void setSupportButtonTintMode(PorterDuff.Mode paramMode)
  {
    this.aaj = paramMode;
    this.aal = true;
    hf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.f
 * JD-Core Version:    0.7.0.1
 */
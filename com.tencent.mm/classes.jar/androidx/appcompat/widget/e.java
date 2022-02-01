package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.appcompat.a.j;
import androidx.core.widget.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e
{
  private final CompoundButton qu;
  ColorStateList qv = null;
  PorterDuff.Mode qw = null;
  private boolean qx = false;
  private boolean qy = false;
  private boolean qz;
  
  e(CompoundButton paramCompoundButton)
  {
    this.qu = paramCompoundButton;
  }
  
  private void dp()
  {
    AppMethodBeat.i(240732);
    Drawable localDrawable = c.a(this.qu);
    if ((localDrawable != null) && ((this.qx) || (this.qy)))
    {
      localDrawable = androidx.core.graphics.drawable.a.p(localDrawable).mutate();
      if (this.qx) {
        androidx.core.graphics.drawable.a.a(localDrawable, this.qv);
      }
      if (this.qy) {
        androidx.core.graphics.drawable.a.a(localDrawable, this.qw);
      }
      if (localDrawable.isStateful()) {
        localDrawable.setState(this.qu.getDrawableState());
      }
      this.qu.setButtonDrawable(localDrawable);
    }
    AppMethodBeat.o(240732);
  }
  
  final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(240728);
    paramAttributeSet = this.qu.getContext().obtainStyledAttributes(paramAttributeSet, a.j.CompoundButton, paramInt, 0);
    try
    {
      if (paramAttributeSet.hasValue(a.j.CompoundButton_android_button))
      {
        paramInt = paramAttributeSet.getResourceId(a.j.CompoundButton_android_button, 0);
        if (paramInt != 0) {
          this.qu.setButtonDrawable(androidx.appcompat.a.a.a.m(this.qu.getContext(), paramInt));
        }
      }
      if (paramAttributeSet.hasValue(a.j.CompoundButton_buttonTint)) {
        c.a(this.qu, paramAttributeSet.getColorStateList(a.j.CompoundButton_buttonTint));
      }
      if (paramAttributeSet.hasValue(a.j.CompoundButton_buttonTintMode)) {
        c.a(this.qu, o.c(paramAttributeSet.getInt(a.j.CompoundButton_buttonTintMode, -1), null));
      }
      return;
    }
    finally
    {
      paramAttributeSet.recycle();
      AppMethodBeat.o(240728);
    }
  }
  
  final int as(int paramInt)
  {
    AppMethodBeat.i(240733);
    int i = paramInt;
    if (Build.VERSION.SDK_INT < 17)
    {
      Drawable localDrawable = c.a(this.qu);
      i = paramInt;
      if (localDrawable != null) {
        i = paramInt + localDrawable.getIntrinsicWidth();
      }
    }
    AppMethodBeat.o(240733);
    return i;
  }
  
  final void jdMethod_do()
  {
    AppMethodBeat.i(240731);
    if (this.qz)
    {
      this.qz = false;
      AppMethodBeat.o(240731);
      return;
    }
    this.qz = true;
    dp();
    AppMethodBeat.o(240731);
  }
  
  final void setSupportButtonTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(240729);
    this.qv = paramColorStateList;
    this.qx = true;
    dp();
    AppMethodBeat.o(240729);
  }
  
  final void setSupportButtonTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(240730);
    this.qw = paramMode;
    this.qy = true;
    dp();
    AppMethodBeat.o(240730);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.widget.e
 * JD-Core Version:    0.7.0.1
 */
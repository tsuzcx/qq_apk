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
  private final CompoundButton rq;
  ColorStateList rs = null;
  PorterDuff.Mode rt = null;
  private boolean ru = false;
  private boolean rv = false;
  private boolean rw;
  
  e(CompoundButton paramCompoundButton)
  {
    this.rq = paramCompoundButton;
  }
  
  private void eo()
  {
    AppMethodBeat.i(200021);
    Drawable localDrawable = c.a(this.rq);
    if ((localDrawable != null) && ((this.ru) || (this.rv)))
    {
      localDrawable = androidx.core.graphics.drawable.a.s(localDrawable).mutate();
      if (this.ru) {
        androidx.core.graphics.drawable.a.a(localDrawable, this.rs);
      }
      if (this.rv) {
        androidx.core.graphics.drawable.a.a(localDrawable, this.rt);
      }
      if (localDrawable.isStateful()) {
        localDrawable.setState(this.rq.getDrawableState());
      }
      this.rq.setButtonDrawable(localDrawable);
    }
    AppMethodBeat.o(200021);
  }
  
  final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(200030);
    paramAttributeSet = this.rq.getContext().obtainStyledAttributes(paramAttributeSet, a.j.CompoundButton, paramInt, 0);
    try
    {
      if (paramAttributeSet.hasValue(a.j.CompoundButton_android_button))
      {
        paramInt = paramAttributeSet.getResourceId(a.j.CompoundButton_android_button, 0);
        if (paramInt != 0) {
          this.rq.setButtonDrawable(androidx.appcompat.a.a.a.m(this.rq.getContext(), paramInt));
        }
      }
      if (paramAttributeSet.hasValue(a.j.CompoundButton_buttonTint)) {
        c.a(this.rq, paramAttributeSet.getColorStateList(a.j.CompoundButton_buttonTint));
      }
      if (paramAttributeSet.hasValue(a.j.CompoundButton_buttonTintMode)) {
        c.a(this.rq, o.c(paramAttributeSet.getInt(a.j.CompoundButton_buttonTintMode, -1), null));
      }
      return;
    }
    finally
    {
      paramAttributeSet.recycle();
      AppMethodBeat.o(200030);
    }
  }
  
  final int aq(int paramInt)
  {
    AppMethodBeat.i(200077);
    int i = paramInt;
    if (Build.VERSION.SDK_INT < 17)
    {
      Drawable localDrawable = c.a(this.rq);
      i = paramInt;
      if (localDrawable != null) {
        i = paramInt + localDrawable.getIntrinsicWidth();
      }
    }
    AppMethodBeat.o(200077);
    return i;
  }
  
  final void en()
  {
    AppMethodBeat.i(200068);
    if (this.rw)
    {
      this.rw = false;
      AppMethodBeat.o(200068);
      return;
    }
    this.rw = true;
    eo();
    AppMethodBeat.o(200068);
  }
  
  final void setSupportButtonTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(200048);
    this.rs = paramColorStateList;
    this.ru = true;
    eo();
    AppMethodBeat.o(200048);
  }
  
  final void setSupportButtonTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(200058);
    this.rt = paramMode;
    this.rv = true;
    eo();
    AppMethodBeat.o(200058);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.widget.e
 * JD-Core Version:    0.7.0.1
 */
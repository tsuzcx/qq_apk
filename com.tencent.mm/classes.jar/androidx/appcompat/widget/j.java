package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.a.j;
import androidx.core.g.z;
import androidx.core.graphics.drawable.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class j
  extends i
{
  final SeekBar rW;
  Drawable rX;
  private ColorStateList rY = null;
  private PorterDuff.Mode rZ = null;
  private boolean sa = false;
  private boolean sc = false;
  
  j(SeekBar paramSeekBar)
  {
    super(paramSeekBar);
    this.rW = paramSeekBar;
  }
  
  private void er()
  {
    AppMethodBeat.i(199917);
    if ((this.rX != null) && ((this.sa) || (this.sc)))
    {
      this.rX = a.s(this.rX.mutate());
      if (this.sa) {
        a.a(this.rX, this.rY);
      }
      if (this.sc) {
        a.a(this.rX, this.rZ);
      }
      if (this.rX.isStateful()) {
        this.rX.setState(this.rW.getDrawableState());
      }
    }
    AppMethodBeat.o(199917);
  }
  
  final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(199927);
    super.a(paramAttributeSet, paramInt);
    paramAttributeSet = ac.a(this.rW.getContext(), paramAttributeSet, a.j.AppCompatSeekBar, paramInt, 0);
    Drawable localDrawable = paramAttributeSet.ax(a.j.AppCompatSeekBar_android_thumb);
    if (localDrawable != null) {
      this.rW.setThumb(localDrawable);
    }
    localDrawable = paramAttributeSet.getDrawable(a.j.AppCompatSeekBar_tickMark);
    if (this.rX != null) {
      this.rX.setCallback(null);
    }
    this.rX = localDrawable;
    if (localDrawable != null)
    {
      localDrawable.setCallback(this.rW);
      a.b(localDrawable, z.U(this.rW));
      if (localDrawable.isStateful()) {
        localDrawable.setState(this.rW.getDrawableState());
      }
      er();
    }
    this.rW.invalidate();
    if (paramAttributeSet.az(a.j.AppCompatSeekBar_tickMarkTintMode))
    {
      this.rZ = o.c(paramAttributeSet.getInt(a.j.AppCompatSeekBar_tickMarkTintMode, -1), this.rZ);
      this.sc = true;
    }
    if (paramAttributeSet.az(a.j.AppCompatSeekBar_tickMarkTint))
    {
      this.rY = paramAttributeSet.getColorStateList(a.j.AppCompatSeekBar_tickMarkTint);
      this.sa = true;
    }
    paramAttributeSet.xv.recycle();
    er();
    AppMethodBeat.o(199927);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.widget.j
 * JD-Core Version:    0.7.0.1
 */
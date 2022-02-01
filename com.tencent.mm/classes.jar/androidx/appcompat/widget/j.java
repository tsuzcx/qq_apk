package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.a.j;
import androidx.core.g.w;
import androidx.core.graphics.drawable.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class j
  extends i
{
  final SeekBar qZ;
  Drawable ra;
  private ColorStateList rb = null;
  private PorterDuff.Mode rc = null;
  private boolean rd = false;
  private boolean re = false;
  
  j(SeekBar paramSeekBar)
  {
    super(paramSeekBar);
    this.qZ = paramSeekBar;
  }
  
  private void ds()
  {
    AppMethodBeat.i(240956);
    if ((this.ra != null) && ((this.rd) || (this.re)))
    {
      this.ra = a.p(this.ra.mutate());
      if (this.rd) {
        a.a(this.ra, this.rb);
      }
      if (this.re) {
        a.a(this.ra, this.rc);
      }
      if (this.ra.isStateful()) {
        this.ra.setState(this.qZ.getDrawableState());
      }
    }
    AppMethodBeat.o(240956);
  }
  
  final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(240955);
    super.a(paramAttributeSet, paramInt);
    paramAttributeSet = ac.a(this.qZ.getContext(), paramAttributeSet, a.j.AppCompatSeekBar, paramInt, 0);
    Drawable localDrawable = paramAttributeSet.aA(a.j.AppCompatSeekBar_android_thumb);
    if (localDrawable != null) {
      this.qZ.setThumb(localDrawable);
    }
    localDrawable = paramAttributeSet.getDrawable(a.j.AppCompatSeekBar_tickMark);
    if (this.ra != null) {
      this.ra.setCallback(null);
    }
    this.ra = localDrawable;
    if (localDrawable != null)
    {
      localDrawable.setCallback(this.qZ);
      a.b(localDrawable, w.I(this.qZ));
      if (localDrawable.isStateful()) {
        localDrawable.setState(this.qZ.getDrawableState());
      }
      ds();
    }
    this.qZ.invalidate();
    if (paramAttributeSet.aC(a.j.AppCompatSeekBar_tickMarkTintMode))
    {
      this.rc = o.c(paramAttributeSet.getInt(a.j.AppCompatSeekBar_tickMarkTintMode, -1), this.rc);
      this.re = true;
    }
    if (paramAttributeSet.aC(a.j.AppCompatSeekBar_tickMarkTint))
    {
      this.rb = paramAttributeSet.getColorStateList(a.j.AppCompatSeekBar_tickMarkTint);
      this.rd = true;
    }
    paramAttributeSet.wA.recycle();
    ds();
    AppMethodBeat.o(240955);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.widget.j
 * JD-Core Version:    0.7.0.1
 */
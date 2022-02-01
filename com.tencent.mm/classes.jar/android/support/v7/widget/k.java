package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.a;
import android.support.v4.view.t;
import android.support.v7.a.a.a;
import android.util.AttributeSet;
import android.widget.SeekBar;

final class k
  extends j
{
  final SeekBar akC;
  Drawable akD;
  private ColorStateList akE = null;
  private PorterDuff.Mode akF = null;
  private boolean akG = false;
  private boolean akH = false;
  
  k(SeekBar paramSeekBar)
  {
    super(paramSeekBar);
    this.akC = paramSeekBar;
  }
  
  private void jd()
  {
    if ((this.akD != null) && ((this.akG) || (this.akH)))
    {
      this.akD = a.i(this.akD.mutate());
      if (this.akG) {
        a.a(this.akD, this.akE);
      }
      if (this.akH) {
        a.a(this.akD, this.akF);
      }
      if (this.akD.isStateful()) {
        this.akD.setState(this.akC.getDrawableState());
      }
    }
  }
  
  final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    super.a(paramAttributeSet, paramInt);
    paramAttributeSet = az.a(this.akC.getContext(), paramAttributeSet, a.a.AppCompatSeekBar, paramInt, 0);
    Drawable localDrawable = paramAttributeSet.da(0);
    if (localDrawable != null) {
      this.akC.setThumb(localDrawable);
    }
    localDrawable = paramAttributeSet.getDrawable(1);
    if (this.akD != null) {
      this.akD.setCallback(null);
    }
    this.akD = localDrawable;
    if (localDrawable != null)
    {
      localDrawable.setCallback(this.akC);
      a.b(localDrawable, t.Y(this.akC));
      if (localDrawable.isStateful()) {
        localDrawable.setState(this.akC.getDrawableState());
      }
      jd();
    }
    this.akC.invalidate();
    if (paramAttributeSet.hasValue(3))
    {
      this.akF = x.a(paramAttributeSet.getInt(3, -1), this.akF);
      this.akH = true;
    }
    if (paramAttributeSet.hasValue(2))
    {
      this.akE = paramAttributeSet.getColorStateList(2);
      this.akG = true;
    }
    paramAttributeSet.ayA.recycle();
    jd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.k
 * JD-Core Version:    0.7.0.1
 */
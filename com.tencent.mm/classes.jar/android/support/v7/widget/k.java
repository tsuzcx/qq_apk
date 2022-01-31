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
  final SeekBar aaL;
  Drawable aaM;
  private ColorStateList aaN = null;
  private PorterDuff.Mode aaO = null;
  private boolean aaP = false;
  private boolean aaQ = false;
  
  k(SeekBar paramSeekBar)
  {
    super(paramSeekBar);
    this.aaL = paramSeekBar;
  }
  
  private void hi()
  {
    if ((this.aaM != null) && ((this.aaP) || (this.aaQ)))
    {
      this.aaM = a.e(this.aaM.mutate());
      if (this.aaP) {
        a.a(this.aaM, this.aaN);
      }
      if (this.aaQ) {
        a.a(this.aaM, this.aaO);
      }
      if (this.aaM.isStateful()) {
        this.aaM.setState(this.aaL.getDrawableState());
      }
    }
  }
  
  final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    super.a(paramAttributeSet, paramInt);
    paramAttributeSet = az.a(this.aaL.getContext(), paramAttributeSet, a.a.AppCompatSeekBar, paramInt, 0);
    Drawable localDrawable = paramAttributeSet.cH(0);
    if (localDrawable != null) {
      this.aaL.setThumb(localDrawable);
    }
    localDrawable = paramAttributeSet.getDrawable(1);
    if (this.aaM != null) {
      this.aaM.setCallback(null);
    }
    this.aaM = localDrawable;
    if (localDrawable != null)
    {
      localDrawable.setCallback(this.aaL);
      a.b(localDrawable, t.T(this.aaL));
      if (localDrawable.isStateful()) {
        localDrawable.setState(this.aaL.getDrawableState());
      }
      hi();
    }
    this.aaL.invalidate();
    if (paramAttributeSet.hasValue(3))
    {
      this.aaO = x.c(paramAttributeSet.getInt(3, -1), this.aaO);
      this.aaQ = true;
    }
    if (paramAttributeSet.hasValue(2))
    {
      this.aaN = paramAttributeSet.getColorStateList(2);
      this.aaP = true;
    }
    paramAttributeSet.aoo.recycle();
    hi();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.k
 * JD-Core Version:    0.7.0.1
 */
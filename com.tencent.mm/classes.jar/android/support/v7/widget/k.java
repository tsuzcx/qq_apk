package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.a;
import android.support.v4.view.u;
import android.support.v7.a.a.a;
import android.util.AttributeSet;
import android.widget.SeekBar;

final class k
  extends j
{
  final SeekBar akP;
  Drawable akQ;
  private ColorStateList akR = null;
  private PorterDuff.Mode akS = null;
  private boolean akT = false;
  private boolean akU = false;
  
  k(SeekBar paramSeekBar)
  {
    super(paramSeekBar);
    this.akP = paramSeekBar;
  }
  
  private void jm()
  {
    if ((this.akQ != null) && ((this.akT) || (this.akU)))
    {
      this.akQ = a.i(this.akQ.mutate());
      if (this.akT) {
        a.a(this.akQ, this.akR);
      }
      if (this.akU) {
        a.a(this.akQ, this.akS);
      }
      if (this.akQ.isStateful()) {
        this.akQ.setState(this.akP.getDrawableState());
      }
    }
  }
  
  final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    super.a(paramAttributeSet, paramInt);
    paramAttributeSet = az.a(this.akP.getContext(), paramAttributeSet, a.a.AppCompatSeekBar, paramInt, 0);
    Drawable localDrawable = paramAttributeSet.cU(0);
    if (localDrawable != null) {
      this.akP.setThumb(localDrawable);
    }
    localDrawable = paramAttributeSet.getDrawable(1);
    if (this.akQ != null) {
      this.akQ.setCallback(null);
    }
    this.akQ = localDrawable;
    if (localDrawable != null)
    {
      localDrawable.setCallback(this.akP);
      a.b(localDrawable, u.Z(this.akP));
      if (localDrawable.isStateful()) {
        localDrawable.setState(this.akP.getDrawableState());
      }
      jm();
    }
    this.akP.invalidate();
    if (paramAttributeSet.hasValue(3))
    {
      this.akS = x.a(paramAttributeSet.getInt(3, -1), this.akS);
      this.akU = true;
    }
    if (paramAttributeSet.hasValue(2))
    {
      this.akR = paramAttributeSet.getColorStateList(2);
      this.akT = true;
    }
    paramAttributeSet.ayy.recycle();
    jm();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.k
 * JD-Core Version:    0.7.0.1
 */
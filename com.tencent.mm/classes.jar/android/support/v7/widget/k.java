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
  final SeekBar ahR;
  Drawable ahS;
  private ColorStateList ahT = null;
  private PorterDuff.Mode ahU = null;
  private boolean ahV = false;
  private boolean ahW = false;
  
  k(SeekBar paramSeekBar)
  {
    super(paramSeekBar);
    this.ahR = paramSeekBar;
  }
  
  private void iF()
  {
    if ((this.ahS != null) && ((this.ahV) || (this.ahW)))
    {
      this.ahS = a.i(this.ahS.mutate());
      if (this.ahV) {
        a.a(this.ahS, this.ahT);
      }
      if (this.ahW) {
        a.a(this.ahS, this.ahU);
      }
      if (this.ahS.isStateful()) {
        this.ahS.setState(this.ahR.getDrawableState());
      }
    }
  }
  
  final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    super.a(paramAttributeSet, paramInt);
    paramAttributeSet = az.a(this.ahR.getContext(), paramAttributeSet, a.a.AppCompatSeekBar, paramInt, 0);
    Drawable localDrawable = paramAttributeSet.db(0);
    if (localDrawable != null) {
      this.ahR.setThumb(localDrawable);
    }
    localDrawable = paramAttributeSet.getDrawable(1);
    if (this.ahS != null) {
      this.ahS.setCallback(null);
    }
    this.ahS = localDrawable;
    if (localDrawable != null)
    {
      localDrawable.setCallback(this.ahR);
      a.b(localDrawable, t.Y(this.ahR));
      if (localDrawable.isStateful()) {
        localDrawable.setState(this.ahR.getDrawableState());
      }
      iF();
    }
    this.ahR.invalidate();
    if (paramAttributeSet.hasValue(3))
    {
      this.ahU = x.a(paramAttributeSet.getInt(3, -1), this.ahU);
      this.ahW = true;
    }
    if (paramAttributeSet.hasValue(2))
    {
      this.ahT = paramAttributeSet.getColorStateList(2);
      this.ahV = true;
    }
    paramAttributeSet.avP.recycle();
    iF();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.k
 * JD-Core Version:    0.7.0.1
 */
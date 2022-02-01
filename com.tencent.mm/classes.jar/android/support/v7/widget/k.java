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
  final SeekBar aiL;
  Drawable aiM;
  private ColorStateList aiN = null;
  private PorterDuff.Mode aiO = null;
  private boolean aiP = false;
  private boolean aiQ = false;
  
  k(SeekBar paramSeekBar)
  {
    super(paramSeekBar);
    this.aiL = paramSeekBar;
  }
  
  private void iN()
  {
    if ((this.aiM != null) && ((this.aiP) || (this.aiQ)))
    {
      this.aiM = a.i(this.aiM.mutate());
      if (this.aiP) {
        a.a(this.aiM, this.aiN);
      }
      if (this.aiQ) {
        a.a(this.aiM, this.aiO);
      }
      if (this.aiM.isStateful()) {
        this.aiM.setState(this.aiL.getDrawableState());
      }
    }
  }
  
  final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    super.a(paramAttributeSet, paramInt);
    paramAttributeSet = az.a(this.aiL.getContext(), paramAttributeSet, a.a.AppCompatSeekBar, paramInt, 0);
    Drawable localDrawable = paramAttributeSet.da(0);
    if (localDrawable != null) {
      this.aiL.setThumb(localDrawable);
    }
    localDrawable = paramAttributeSet.getDrawable(1);
    if (this.aiM != null) {
      this.aiM.setCallback(null);
    }
    this.aiM = localDrawable;
    if (localDrawable != null)
    {
      localDrawable.setCallback(this.aiL);
      a.b(localDrawable, t.Y(this.aiL));
      if (localDrawable.isStateful()) {
        localDrawable.setState(this.aiL.getDrawableState());
      }
      iN();
    }
    this.aiL.invalidate();
    if (paramAttributeSet.hasValue(3))
    {
      this.aiO = x.a(paramAttributeSet.getInt(3, -1), this.aiO);
      this.aiQ = true;
    }
    if (paramAttributeSet.hasValue(2))
    {
      this.aiN = paramAttributeSet.getColorStateList(2);
      this.aiP = true;
    }
    paramAttributeSet.awJ.recycle();
    iN();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.k
 * JD-Core Version:    0.7.0.1
 */
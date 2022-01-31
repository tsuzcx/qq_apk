package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.a.a.a;
import android.support.v4.view.q;
import android.support.v7.a.a.j;
import android.util.AttributeSet;
import android.widget.SeekBar;

final class l
  extends k
{
  final SeekBar aab;
  Drawable aac;
  private ColorStateList aad = null;
  private PorterDuff.Mode aae = null;
  private boolean aaf = false;
  private boolean aag = false;
  
  l(SeekBar paramSeekBar)
  {
    super(paramSeekBar);
    this.aab = paramSeekBar;
  }
  
  private void gk()
  {
    if ((this.aac != null) && ((this.aaf) || (this.aag)))
    {
      this.aac = a.f(this.aac.mutate());
      if (this.aaf) {
        a.a(this.aac, this.aad);
      }
      if (this.aag) {
        a.a(this.aac, this.aae);
      }
      if (this.aac.isStateful()) {
        this.aac.setState(this.aab.getDrawableState());
      }
    }
  }
  
  final void b(AttributeSet paramAttributeSet, int paramInt)
  {
    super.b(paramAttributeSet, paramInt);
    paramAttributeSet = ax.a(this.aab.getContext(), paramAttributeSet, a.j.AppCompatSeekBar, paramInt, 0);
    Drawable localDrawable = paramAttributeSet.cr(a.j.AppCompatSeekBar_android_thumb);
    if (localDrawable != null) {
      this.aab.setThumb(localDrawable);
    }
    localDrawable = paramAttributeSet.getDrawable(a.j.AppCompatSeekBar_tickMark);
    if (this.aac != null) {
      this.aac.setCallback(null);
    }
    this.aac = localDrawable;
    if (localDrawable != null)
    {
      localDrawable.setCallback(this.aab);
      a.b(localDrawable, q.Q(this.aab));
      if (localDrawable.isStateful()) {
        localDrawable.setState(this.aab.getDrawableState());
      }
      gk();
    }
    this.aab.invalidate();
    if (paramAttributeSet.hasValue(a.j.AppCompatSeekBar_tickMarkTintMode))
    {
      this.aae = y.c(paramAttributeSet.getInt(a.j.AppCompatSeekBar_tickMarkTintMode, -1), this.aae);
      this.aag = true;
    }
    if (paramAttributeSet.hasValue(a.j.AppCompatSeekBar_tickMarkTint))
    {
      this.aad = paramAttributeSet.getColorStateList(a.j.AppCompatSeekBar_tickMarkTint);
      this.aaf = true;
    }
    paramAttributeSet.alZ.recycle();
    gk();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.l
 * JD-Core Version:    0.7.0.1
 */
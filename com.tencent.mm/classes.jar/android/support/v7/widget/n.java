package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.a.a.j;
import android.util.AttributeSet;
import android.widget.TextView;

final class n
  extends m
{
  private av aaF;
  private av aaG;
  
  n(TextView paramTextView)
  {
    super(paramTextView);
  }
  
  final void b(AttributeSet paramAttributeSet, int paramInt)
  {
    super.b(paramAttributeSet, paramInt);
    Context localContext = this.aav.getContext();
    h localh = h.gi();
    paramAttributeSet = localContext.obtainStyledAttributes(paramAttributeSet, a.j.AppCompatTextHelper, paramInt, 0);
    if (paramAttributeSet.hasValue(a.j.AppCompatTextHelper_android_drawableStart)) {
      this.aaF = a(localContext, localh, paramAttributeSet.getResourceId(a.j.AppCompatTextHelper_android_drawableStart, 0));
    }
    if (paramAttributeSet.hasValue(a.j.AppCompatTextHelper_android_drawableEnd)) {
      this.aaG = a(localContext, localh, paramAttributeSet.getResourceId(a.j.AppCompatTextHelper_android_drawableEnd, 0));
    }
    paramAttributeSet.recycle();
  }
  
  final void gm()
  {
    super.gm();
    if ((this.aaF != null) || (this.aaG != null))
    {
      Drawable[] arrayOfDrawable = this.aav.getCompoundDrawablesRelative();
      a(arrayOfDrawable[0], this.aaF);
      a(arrayOfDrawable[2], this.aaG);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.n
 * JD-Core Version:    0.7.0.1
 */
package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.t;
import android.support.v7.a.a.a;
import android.util.AttributeSet;
import android.view.View;

final class e
{
  private final g ajR;
  private int ajS = -1;
  private ax ajT;
  private ax ajU;
  private ax ajV;
  private final View mView;
  
  e(View paramView)
  {
    this.mView = paramView;
    this.ajR = g.jb();
  }
  
  private void f(ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null)
    {
      if (this.ajT == null) {
        this.ajT = new ax();
      }
      this.ajT.Kh = paramColorStateList;
      this.ajT.acG = true;
    }
    for (;;)
    {
      iX();
      return;
      this.ajT = null;
    }
  }
  
  private boolean iY()
  {
    int i = Build.VERSION.SDK_INT;
    if (i > 21) {
      if (this.ajT == null) {}
    }
    while (i == 21)
    {
      return true;
      return false;
    }
    return false;
  }
  
  private boolean p(Drawable paramDrawable)
  {
    if (this.ajV == null) {
      this.ajV = new ax();
    }
    ax localax = this.ajV;
    localax.clear();
    Object localObject = t.at(this.mView);
    if (localObject != null)
    {
      localax.acG = true;
      localax.Kh = ((ColorStateList)localObject);
    }
    localObject = t.au(this.mView);
    if (localObject != null)
    {
      localax.acH = true;
      localax.yf = ((PorterDuff.Mode)localObject);
    }
    if ((localax.acG) || (localax.acH))
    {
      g.a(paramDrawable, localax, this.mView.getDrawableState());
      return true;
    }
    return false;
  }
  
  final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = az.a(this.mView.getContext(), paramAttributeSet, a.a.ViewBackgroundHelper, paramInt, 0);
    try
    {
      if (paramAttributeSet.hasValue(0))
      {
        this.ajS = paramAttributeSet.getResourceId(0, -1);
        ColorStateList localColorStateList = this.ajR.s(this.mView.getContext(), this.ajS);
        if (localColorStateList != null) {
          f(localColorStateList);
        }
      }
      if (paramAttributeSet.hasValue(1)) {
        t.a(this.mView, paramAttributeSet.getColorStateList(1));
      }
      if (paramAttributeSet.hasValue(2)) {
        t.a(this.mView, x.a(paramAttributeSet.getInt(2, -1), null));
      }
      return;
    }
    finally
    {
      paramAttributeSet.ayA.recycle();
    }
  }
  
  final void bG(int paramInt)
  {
    this.ajS = paramInt;
    if (this.ajR != null) {}
    for (ColorStateList localColorStateList = this.ajR.s(this.mView.getContext(), paramInt);; localColorStateList = null)
    {
      f(localColorStateList);
      iX();
      return;
    }
  }
  
  final ColorStateList getSupportBackgroundTintList()
  {
    if (this.ajU != null) {
      return this.ajU.Kh;
    }
    return null;
  }
  
  final PorterDuff.Mode getSupportBackgroundTintMode()
  {
    if (this.ajU != null) {
      return this.ajU.yf;
    }
    return null;
  }
  
  final void iW()
  {
    this.ajS = -1;
    f(null);
    iX();
  }
  
  final void iX()
  {
    Drawable localDrawable = this.mView.getBackground();
    if ((localDrawable == null) || ((iY()) && (p(localDrawable)))) {}
    do
    {
      return;
      if (this.ajU != null)
      {
        g.a(localDrawable, this.ajU, this.mView.getDrawableState());
        return;
      }
    } while (this.ajT == null);
    g.a(localDrawable, this.ajT, this.mView.getDrawableState());
  }
  
  final void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    if (this.ajU == null) {
      this.ajU = new ax();
    }
    this.ajU.Kh = paramColorStateList;
    this.ajU.acG = true;
    iX();
  }
  
  final void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (this.ajU == null) {
      this.ajU = new ax();
    }
    this.ajU.yf = paramMode;
    this.ajU.acH = true;
    iX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.e
 * JD-Core Version:    0.7.0.1
 */
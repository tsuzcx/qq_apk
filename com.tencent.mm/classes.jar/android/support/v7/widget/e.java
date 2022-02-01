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
  private final g aia;
  private int aib = -1;
  private ax aic;
  private ax aid;
  private ax aie;
  private final View mView;
  
  e(View paramView)
  {
    this.mView = paramView;
    this.aia = g.iL();
  }
  
  private void f(ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null)
    {
      if (this.aic == null) {
        this.aic = new ax();
      }
      this.aic.Ip = paramColorStateList;
      this.aic.aaQ = true;
    }
    for (;;)
    {
      iH();
      return;
      this.aic = null;
    }
  }
  
  private boolean iI()
  {
    int i = Build.VERSION.SDK_INT;
    if (i > 21) {
      if (this.aic == null) {}
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
    if (this.aie == null) {
      this.aie = new ax();
    }
    ax localax = this.aie;
    localax.clear();
    Object localObject = t.at(this.mView);
    if (localObject != null)
    {
      localax.aaQ = true;
      localax.Ip = ((ColorStateList)localObject);
    }
    localObject = t.au(this.mView);
    if (localObject != null)
    {
      localax.aaR = true;
      localax.wn = ((PorterDuff.Mode)localObject);
    }
    if ((localax.aaQ) || (localax.aaR))
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
        this.aib = paramAttributeSet.getResourceId(0, -1);
        ColorStateList localColorStateList = this.aia.s(this.mView.getContext(), this.aib);
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
      paramAttributeSet.awJ.recycle();
    }
  }
  
  final void bG(int paramInt)
  {
    this.aib = paramInt;
    if (this.aia != null) {}
    for (ColorStateList localColorStateList = this.aia.s(this.mView.getContext(), paramInt);; localColorStateList = null)
    {
      f(localColorStateList);
      iH();
      return;
    }
  }
  
  final ColorStateList getSupportBackgroundTintList()
  {
    if (this.aid != null) {
      return this.aid.Ip;
    }
    return null;
  }
  
  final PorterDuff.Mode getSupportBackgroundTintMode()
  {
    if (this.aid != null) {
      return this.aid.wn;
    }
    return null;
  }
  
  final void iG()
  {
    this.aib = -1;
    f(null);
    iH();
  }
  
  final void iH()
  {
    Drawable localDrawable = this.mView.getBackground();
    if ((localDrawable == null) || ((iI()) && (p(localDrawable)))) {}
    do
    {
      return;
      if (this.aid != null)
      {
        g.a(localDrawable, this.aid, this.mView.getDrawableState());
        return;
      }
    } while (this.aic == null);
    g.a(localDrawable, this.aic, this.mView.getDrawableState());
  }
  
  final void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    if (this.aid == null) {
      this.aid = new ax();
    }
    this.aid.Ip = paramColorStateList;
    this.aid.aaQ = true;
    iH();
  }
  
  final void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (this.aid == null) {
      this.aid = new ax();
    }
    this.aid.wn = paramMode;
    this.aid.aaR = true;
    iH();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.e
 * JD-Core Version:    0.7.0.1
 */
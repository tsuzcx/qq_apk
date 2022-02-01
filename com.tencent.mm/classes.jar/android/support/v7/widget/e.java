package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.u;
import android.support.v7.a.a.a;
import android.util.AttributeSet;
import android.view.View;

final class e
{
  private final g ake;
  private int akf = -1;
  private ax akg;
  private ax akh;
  private ax aki;
  private final View mView;
  
  e(View paramView)
  {
    this.mView = paramView;
    this.ake = g.jk();
  }
  
  private void f(ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null)
    {
      if (this.akg == null) {
        this.akg = new ax();
      }
      this.akg.Kr = paramColorStateList;
      this.akg.acT = true;
    }
    for (;;)
    {
      jg();
      return;
      this.akg = null;
    }
  }
  
  private boolean jh()
  {
    int i = Build.VERSION.SDK_INT;
    if (i > 21) {
      if (this.akg == null) {}
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
    if (this.aki == null) {
      this.aki = new ax();
    }
    ax localax = this.aki;
    localax.clear();
    Object localObject = u.at(this.mView);
    if (localObject != null)
    {
      localax.acT = true;
      localax.Kr = ((ColorStateList)localObject);
    }
    localObject = u.au(this.mView);
    if (localObject != null)
    {
      localax.acU = true;
      localax.yl = ((PorterDuff.Mode)localObject);
    }
    if ((localax.acT) || (localax.acU))
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
        this.akf = paramAttributeSet.getResourceId(0, -1);
        ColorStateList localColorStateList = this.ake.s(this.mView.getContext(), this.akf);
        if (localColorStateList != null) {
          f(localColorStateList);
        }
      }
      if (paramAttributeSet.hasValue(1)) {
        u.a(this.mView, paramAttributeSet.getColorStateList(1));
      }
      if (paramAttributeSet.hasValue(2)) {
        u.a(this.mView, x.a(paramAttributeSet.getInt(2, -1), null));
      }
      return;
    }
    finally
    {
      paramAttributeSet.ayy.recycle();
    }
  }
  
  final void bH(int paramInt)
  {
    this.akf = paramInt;
    if (this.ake != null) {}
    for (ColorStateList localColorStateList = this.ake.s(this.mView.getContext(), paramInt);; localColorStateList = null)
    {
      f(localColorStateList);
      jg();
      return;
    }
  }
  
  final ColorStateList getSupportBackgroundTintList()
  {
    if (this.akh != null) {
      return this.akh.Kr;
    }
    return null;
  }
  
  final PorterDuff.Mode getSupportBackgroundTintMode()
  {
    if (this.akh != null) {
      return this.akh.yl;
    }
    return null;
  }
  
  final void jf()
  {
    this.akf = -1;
    f(null);
    jg();
  }
  
  final void jg()
  {
    Drawable localDrawable = this.mView.getBackground();
    if ((localDrawable == null) || ((jh()) && (p(localDrawable)))) {}
    do
    {
      return;
      if (this.akh != null)
      {
        g.a(localDrawable, this.akh, this.mView.getDrawableState());
        return;
      }
    } while (this.akg == null);
    g.a(localDrawable, this.akg, this.mView.getDrawableState());
  }
  
  final void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    if (this.akh == null) {
      this.akh = new ax();
    }
    this.akh.Kr = paramColorStateList;
    this.akh.acT = true;
    jg();
  }
  
  final void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (this.akh == null) {
      this.akh = new ax();
    }
    this.akh.yl = paramMode;
    this.akh.acU = true;
    jg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.e
 * JD-Core Version:    0.7.0.1
 */
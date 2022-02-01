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
  private final g ahg;
  private int ahh = -1;
  private ax ahi;
  private ax ahj;
  private ax ahk;
  private final View mView;
  
  e(View paramView)
  {
    this.mView = paramView;
    this.ahg = g.iD();
  }
  
  private void f(ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null)
    {
      if (this.ahi == null) {
        this.ahi = new ax();
      }
      this.ahi.Hr = paramColorStateList;
      this.ahi.ZV = true;
    }
    for (;;)
    {
      iz();
      return;
      this.ahi = null;
    }
  }
  
  private boolean iA()
  {
    int i = Build.VERSION.SDK_INT;
    if (i > 21) {
      if (this.ahi == null) {}
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
    if (this.ahk == null) {
      this.ahk = new ax();
    }
    ax localax = this.ahk;
    localax.clear();
    Object localObject = t.at(this.mView);
    if (localObject != null)
    {
      localax.ZV = true;
      localax.Hr = ((ColorStateList)localObject);
    }
    localObject = t.au(this.mView);
    if (localObject != null)
    {
      localax.ZW = true;
      localax.vo = ((PorterDuff.Mode)localObject);
    }
    if ((localax.ZV) || (localax.ZW))
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
        this.ahh = paramAttributeSet.getResourceId(0, -1);
        ColorStateList localColorStateList = this.ahg.s(this.mView.getContext(), this.ahh);
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
      paramAttributeSet.avP.recycle();
    }
  }
  
  final void bG(int paramInt)
  {
    this.ahh = paramInt;
    if (this.ahg != null) {}
    for (ColorStateList localColorStateList = this.ahg.s(this.mView.getContext(), paramInt);; localColorStateList = null)
    {
      f(localColorStateList);
      iz();
      return;
    }
  }
  
  final ColorStateList getSupportBackgroundTintList()
  {
    if (this.ahj != null) {
      return this.ahj.Hr;
    }
    return null;
  }
  
  final PorterDuff.Mode getSupportBackgroundTintMode()
  {
    if (this.ahj != null) {
      return this.ahj.vo;
    }
    return null;
  }
  
  final void iy()
  {
    this.ahh = -1;
    f(null);
    iz();
  }
  
  final void iz()
  {
    Drawable localDrawable = this.mView.getBackground();
    if ((localDrawable == null) || ((iA()) && (p(localDrawable)))) {}
    do
    {
      return;
      if (this.ahj != null)
      {
        g.a(localDrawable, this.ahj, this.mView.getDrawableState());
        return;
      }
    } while (this.ahi == null);
    g.a(localDrawable, this.ahi, this.mView.getDrawableState());
  }
  
  final void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    if (this.ahj == null) {
      this.ahj = new ax();
    }
    this.ahj.Hr = paramColorStateList;
    this.ahj.ZV = true;
    iz();
  }
  
  final void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (this.ahj == null) {
      this.ahj = new ax();
    }
    this.ahj.vo = paramMode;
    this.ahj.ZW = true;
    iz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.e
 * JD-Core Version:    0.7.0.1
 */
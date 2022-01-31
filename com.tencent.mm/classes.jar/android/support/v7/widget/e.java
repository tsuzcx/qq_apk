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
  private final g aab;
  private int aac = -1;
  private ax aad;
  private ax aae;
  private ax aaf;
  private final View mView;
  
  e(View paramView)
  {
    this.mView = paramView;
    this.aab = g.hg();
  }
  
  private void d(ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null)
    {
      if (this.aad == null) {
        this.aad = new ax();
      }
      this.aad.AW = paramColorStateList;
      this.aad.SS = true;
    }
    for (;;)
    {
      hc();
      return;
      this.aad = null;
    }
  }
  
  private boolean hd()
  {
    int i = Build.VERSION.SDK_INT;
    if (i > 21) {
      if (this.aad == null) {}
    }
    while (i == 21)
    {
      return true;
      return false;
    }
    return false;
  }
  
  private boolean k(Drawable paramDrawable)
  {
    if (this.aaf == null) {
      this.aaf = new ax();
    }
    ax localax = this.aaf;
    localax.clear();
    Object localObject = t.ao(this.mView);
    if (localObject != null)
    {
      localax.SS = true;
      localax.AW = ((ColorStateList)localObject);
    }
    localObject = t.ap(this.mView);
    if (localObject != null)
    {
      localax.ST = true;
      localax.oM = ((PorterDuff.Mode)localObject);
    }
    if ((localax.SS) || (localax.ST))
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
        this.aac = paramAttributeSet.getResourceId(0, -1);
        ColorStateList localColorStateList = this.aab.r(this.mView.getContext(), this.aac);
        if (localColorStateList != null) {
          d(localColorStateList);
        }
      }
      if (paramAttributeSet.hasValue(1)) {
        t.a(this.mView, paramAttributeSet.getColorStateList(1));
      }
      if (paramAttributeSet.hasValue(2)) {
        t.a(this.mView, x.c(paramAttributeSet.getInt(2, -1), null));
      }
      return;
    }
    finally
    {
      paramAttributeSet.aoo.recycle();
    }
  }
  
  final void bo(int paramInt)
  {
    this.aac = paramInt;
    if (this.aab != null) {}
    for (ColorStateList localColorStateList = this.aab.r(this.mView.getContext(), paramInt);; localColorStateList = null)
    {
      d(localColorStateList);
      hc();
      return;
    }
  }
  
  final ColorStateList getSupportBackgroundTintList()
  {
    if (this.aae != null) {
      return this.aae.AW;
    }
    return null;
  }
  
  final PorterDuff.Mode getSupportBackgroundTintMode()
  {
    if (this.aae != null) {
      return this.aae.oM;
    }
    return null;
  }
  
  final void hb()
  {
    this.aac = -1;
    d(null);
    hc();
  }
  
  final void hc()
  {
    Drawable localDrawable = this.mView.getBackground();
    if ((localDrawable == null) || ((hd()) && (k(localDrawable)))) {}
    do
    {
      return;
      if (this.aae != null)
      {
        g.a(localDrawable, this.aae, this.mView.getDrawableState());
        return;
      }
    } while (this.aad == null);
    g.a(localDrawable, this.aad, this.mView.getDrawableState());
  }
  
  final void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    if (this.aae == null) {
      this.aae = new ax();
    }
    this.aae.AW = paramColorStateList;
    this.aae.SS = true;
    hc();
  }
  
  final void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (this.aae == null) {
      this.aae = new ax();
    }
    this.aae.oM = paramMode;
    this.aae.ST = true;
    hc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.e
 * JD-Core Version:    0.7.0.1
 */
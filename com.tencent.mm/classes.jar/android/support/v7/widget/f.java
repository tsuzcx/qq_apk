package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.q;
import android.support.v7.a.a.j;
import android.util.AttributeSet;
import android.view.View;

final class f
{
  private final h Zq;
  private int Zr = -1;
  private av Zs;
  private av Zt;
  private av Zu;
  private final View mView;
  
  f(View paramView)
  {
    this.mView = paramView;
    this.Zq = h.gi();
  }
  
  private void d(ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null)
    {
      if (this.Zs == null) {
        this.Zs = new av();
      }
      this.Zs.alV = paramColorStateList;
      this.Zs.alX = true;
    }
    for (;;)
    {
      gf();
      return;
      this.Zs = null;
    }
  }
  
  final void b(AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = ax.a(this.mView.getContext(), paramAttributeSet, a.j.ViewBackgroundHelper, paramInt, 0);
    try
    {
      if (paramAttributeSet.hasValue(a.j.ViewBackgroundHelper_android_background))
      {
        this.Zr = paramAttributeSet.getResourceId(a.j.ViewBackgroundHelper_android_background, -1);
        ColorStateList localColorStateList = this.Zq.n(this.mView.getContext(), this.Zr);
        if (localColorStateList != null) {
          d(localColorStateList);
        }
      }
      if (paramAttributeSet.hasValue(a.j.ViewBackgroundHelper_backgroundTint)) {
        q.a(this.mView, paramAttributeSet.getColorStateList(a.j.ViewBackgroundHelper_backgroundTint));
      }
      if (paramAttributeSet.hasValue(a.j.ViewBackgroundHelper_backgroundTintMode)) {
        q.a(this.mView, y.c(paramAttributeSet.getInt(a.j.ViewBackgroundHelper_backgroundTintMode, -1), null));
      }
      return;
    }
    finally
    {
      paramAttributeSet.alZ.recycle();
    }
  }
  
  final void bp(int paramInt)
  {
    this.Zr = paramInt;
    if (this.Zq != null) {}
    for (ColorStateList localColorStateList = this.Zq.n(this.mView.getContext(), paramInt);; localColorStateList = null)
    {
      d(localColorStateList);
      gf();
      return;
    }
  }
  
  final void ge()
  {
    this.Zr = -1;
    d(null);
    gf();
  }
  
  final ColorStateList getSupportBackgroundTintList()
  {
    if (this.Zt != null) {
      return this.Zt.alV;
    }
    return null;
  }
  
  final PorterDuff.Mode getSupportBackgroundTintMode()
  {
    if (this.Zt != null) {
      return this.Zt.nN;
    }
    return null;
  }
  
  final void gf()
  {
    int j = 0;
    Drawable localDrawable = this.mView.getBackground();
    int i;
    if (localDrawable != null)
    {
      i = Build.VERSION.SDK_INT;
      if (i <= 21) {
        break label163;
      }
      if (this.Zs == null) {
        break label158;
      }
      i = 1;
      if (i == 0) {
        break label179;
      }
      if (this.Zu == null) {
        this.Zu = new av();
      }
      av localav = this.Zu;
      localav.clear();
      Object localObject = q.ah(this.mView);
      if (localObject != null)
      {
        localav.alX = true;
        localav.alV = ((ColorStateList)localObject);
      }
      localObject = q.ai(this.mView);
      if (localObject != null)
      {
        localav.alW = true;
        localav.nN = ((PorterDuff.Mode)localObject);
      }
      if (!localav.alX)
      {
        i = j;
        if (!localav.alW) {}
      }
      else
      {
        h.a(localDrawable, localav, this.mView.getDrawableState());
        i = 1;
      }
      if (i == 0) {
        break label179;
      }
    }
    label158:
    label163:
    label179:
    do
    {
      return;
      i = 0;
      break;
      if (i == 21)
      {
        i = 1;
        break;
      }
      i = 0;
      break;
      if (this.Zt != null)
      {
        h.a(localDrawable, this.Zt, this.mView.getDrawableState());
        return;
      }
    } while (this.Zs == null);
    h.a(localDrawable, this.Zs, this.mView.getDrawableState());
  }
  
  final void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    if (this.Zt == null) {
      this.Zt = new av();
    }
    this.Zt.alV = paramColorStateList;
    this.Zt.alX = true;
    gf();
  }
  
  final void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (this.Zt == null) {
      this.Zt = new av();
    }
    this.Zt.nN = paramMode;
    this.Zt.alW = true;
    gf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.f
 * JD-Core Version:    0.7.0.1
 */
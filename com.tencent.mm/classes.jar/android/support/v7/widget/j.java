package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.support.v7.a.a.j;
import android.support.v7.c.a.b;
import android.util.AttributeSet;
import android.widget.ImageView;

public final class j
{
  private final ImageView ZS;
  private av ZT;
  private av ZU;
  private av Zu;
  
  public j(ImageView paramImageView)
  {
    this.ZS = paramImageView;
  }
  
  public final void b(AttributeSet paramAttributeSet, int paramInt)
  {
    ax localax = ax.a(this.ZS.getContext(), paramAttributeSet, a.j.AppCompatImageView, paramInt, 0);
    try
    {
      Drawable localDrawable = this.ZS.getDrawable();
      paramAttributeSet = localDrawable;
      if (localDrawable == null)
      {
        paramInt = localax.getResourceId(a.j.AppCompatImageView_srcCompat, -1);
        paramAttributeSet = localDrawable;
        if (paramInt != -1)
        {
          localDrawable = b.g(this.ZS.getContext(), paramInt);
          paramAttributeSet = localDrawable;
          if (localDrawable != null)
          {
            this.ZS.setImageDrawable(localDrawable);
            paramAttributeSet = localDrawable;
          }
        }
      }
      if (paramAttributeSet != null) {
        y.l(paramAttributeSet);
      }
      if (localax.hasValue(a.j.AppCompatImageView_tint)) {
        android.support.v4.widget.j.a(this.ZS, localax.getColorStateList(a.j.AppCompatImageView_tint));
      }
      if (localax.hasValue(a.j.AppCompatImageView_tintMode)) {
        android.support.v4.widget.j.a(this.ZS, y.c(localax.getInt(a.j.AppCompatImageView_tintMode, -1), null));
      }
      return;
    }
    finally
    {
      localax.alZ.recycle();
    }
  }
  
  final ColorStateList getSupportImageTintList()
  {
    if (this.ZU != null) {
      return this.ZU.alV;
    }
    return null;
  }
  
  final PorterDuff.Mode getSupportImageTintMode()
  {
    if (this.ZU != null) {
      return this.ZU.nN;
    }
    return null;
  }
  
  final void gj()
  {
    int j = 0;
    Drawable localDrawable = this.ZS.getDrawable();
    if (localDrawable != null) {
      y.l(localDrawable);
    }
    int i;
    if (localDrawable != null)
    {
      i = Build.VERSION.SDK_INT;
      if (i <= 21) {
        break label171;
      }
      if (this.ZT == null) {
        break label166;
      }
      i = 1;
      if (i == 0) {
        break label187;
      }
      if (this.Zu == null) {
        this.Zu = new av();
      }
      av localav = this.Zu;
      localav.clear();
      Object localObject = android.support.v4.widget.j.b(this.ZS);
      if (localObject != null)
      {
        localav.alX = true;
        localav.alV = ((ColorStateList)localObject);
      }
      localObject = android.support.v4.widget.j.c(this.ZS);
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
        h.a(localDrawable, localav, this.ZS.getDrawableState());
        i = 1;
      }
      if (i == 0) {
        break label187;
      }
    }
    label166:
    label171:
    label187:
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
      if (this.ZU != null)
      {
        h.a(localDrawable, this.ZU, this.ZS.getDrawableState());
        return;
      }
    } while (this.ZT == null);
    h.a(localDrawable, this.ZT, this.ZS.getDrawableState());
  }
  
  final boolean hasOverlappingRendering()
  {
    Drawable localDrawable = this.ZS.getBackground();
    return (Build.VERSION.SDK_INT < 21) || (!(localDrawable instanceof RippleDrawable));
  }
  
  public final void setImageResource(int paramInt)
  {
    if (paramInt != 0)
    {
      Drawable localDrawable = b.g(this.ZS.getContext(), paramInt);
      if (localDrawable != null) {
        y.l(localDrawable);
      }
      this.ZS.setImageDrawable(localDrawable);
    }
    for (;;)
    {
      gj();
      return;
      this.ZS.setImageDrawable(null);
    }
  }
  
  final void setSupportImageTintList(ColorStateList paramColorStateList)
  {
    if (this.ZU == null) {
      this.ZU = new av();
    }
    this.ZU.alV = paramColorStateList;
    this.ZU.alX = true;
    gj();
  }
  
  final void setSupportImageTintMode(PorterDuff.Mode paramMode)
  {
    if (this.ZU == null) {
      this.ZU = new av();
    }
    this.ZU.nN = paramMode;
    this.ZU.alW = true;
    gj();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.j
 * JD-Core Version:    0.7.0.1
 */
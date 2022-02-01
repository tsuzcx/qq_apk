package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.support.v4.widget.l;
import android.support.v7.a.a.a;
import android.support.v7.c.a.a;
import android.util.AttributeSet;
import android.widget.ImageView;

public final class i
{
  private final ImageView ahI;
  private ax ahJ;
  private ax ahK;
  private ax ahk;
  
  public i(ImageView paramImageView)
  {
    this.ahI = paramImageView;
  }
  
  private boolean iA()
  {
    int i = Build.VERSION.SDK_INT;
    if (i > 21) {
      if (this.ahJ == null) {}
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
    Object localObject = l.a(this.ahI);
    if (localObject != null)
    {
      localax.ZV = true;
      localax.Hr = ((ColorStateList)localObject);
    }
    localObject = l.b(this.ahI);
    if (localObject != null)
    {
      localax.ZW = true;
      localax.vo = ((PorterDuff.Mode)localObject);
    }
    if ((localax.ZV) || (localax.ZW))
    {
      g.a(paramDrawable, localax, this.ahI.getDrawableState());
      return true;
    }
    return false;
  }
  
  public final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    az localaz = az.a(this.ahI.getContext(), paramAttributeSet, a.a.AppCompatImageView, paramInt, 0);
    try
    {
      Drawable localDrawable = this.ahI.getDrawable();
      paramAttributeSet = localDrawable;
      if (localDrawable == null)
      {
        paramInt = localaz.getResourceId(1, -1);
        paramAttributeSet = localDrawable;
        if (paramInt != -1)
        {
          localDrawable = a.l(this.ahI.getContext(), paramInt);
          paramAttributeSet = localDrawable;
          if (localDrawable != null)
          {
            this.ahI.setImageDrawable(localDrawable);
            paramAttributeSet = localDrawable;
          }
        }
      }
      if (paramAttributeSet != null) {
        x.s(paramAttributeSet);
      }
      if (localaz.hasValue(2)) {
        l.a(this.ahI, localaz.getColorStateList(2));
      }
      if (localaz.hasValue(3)) {
        l.a(this.ahI, x.a(localaz.getInt(3, -1), null));
      }
      return;
    }
    finally
    {
      localaz.avP.recycle();
    }
  }
  
  final ColorStateList getSupportImageTintList()
  {
    if (this.ahK != null) {
      return this.ahK.Hr;
    }
    return null;
  }
  
  final PorterDuff.Mode getSupportImageTintMode()
  {
    if (this.ahK != null) {
      return this.ahK.vo;
    }
    return null;
  }
  
  final boolean hasOverlappingRendering()
  {
    Drawable localDrawable = this.ahI.getBackground();
    return (Build.VERSION.SDK_INT < 21) || (!(localDrawable instanceof RippleDrawable));
  }
  
  final void iE()
  {
    Drawable localDrawable = this.ahI.getDrawable();
    if (localDrawable != null) {
      x.s(localDrawable);
    }
    if ((localDrawable == null) || ((iA()) && (p(localDrawable)))) {}
    do
    {
      return;
      if (this.ahK != null)
      {
        g.a(localDrawable, this.ahK, this.ahI.getDrawableState());
        return;
      }
    } while (this.ahJ == null);
    g.a(localDrawable, this.ahJ, this.ahI.getDrawableState());
  }
  
  public final void setImageResource(int paramInt)
  {
    if (paramInt != 0)
    {
      Drawable localDrawable = a.l(this.ahI.getContext(), paramInt);
      if (localDrawable != null) {
        x.s(localDrawable);
      }
      this.ahI.setImageDrawable(localDrawable);
    }
    for (;;)
    {
      iE();
      return;
      this.ahI.setImageDrawable(null);
    }
  }
  
  final void setSupportImageTintList(ColorStateList paramColorStateList)
  {
    if (this.ahK == null) {
      this.ahK = new ax();
    }
    this.ahK.Hr = paramColorStateList;
    this.ahK.ZV = true;
    iE();
  }
  
  final void setSupportImageTintMode(PorterDuff.Mode paramMode)
  {
    if (this.ahK == null) {
      this.ahK = new ax();
    }
    this.ahK.vo = paramMode;
    this.ahK.ZW = true;
    iE();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.i
 * JD-Core Version:    0.7.0.1
 */
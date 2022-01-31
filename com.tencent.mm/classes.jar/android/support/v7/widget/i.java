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
  private final ImageView aaC;
  private ax aaD;
  private ax aaE;
  private ax aaf;
  
  public i(ImageView paramImageView)
  {
    this.aaC = paramImageView;
  }
  
  private boolean hd()
  {
    int i = Build.VERSION.SDK_INT;
    if (i > 21) {
      if (this.aaD == null) {}
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
    Object localObject = l.b(this.aaC);
    if (localObject != null)
    {
      localax.SS = true;
      localax.AW = ((ColorStateList)localObject);
    }
    localObject = l.c(this.aaC);
    if (localObject != null)
    {
      localax.ST = true;
      localax.oM = ((PorterDuff.Mode)localObject);
    }
    if ((localax.SS) || (localax.ST))
    {
      g.a(paramDrawable, localax, this.aaC.getDrawableState());
      return true;
    }
    return false;
  }
  
  public final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    az localaz = az.a(this.aaC.getContext(), paramAttributeSet, a.a.AppCompatImageView, paramInt, 0);
    try
    {
      Drawable localDrawable = this.aaC.getDrawable();
      paramAttributeSet = localDrawable;
      if (localDrawable == null)
      {
        paramInt = localaz.getResourceId(1, -1);
        paramAttributeSet = localDrawable;
        if (paramInt != -1)
        {
          localDrawable = a.k(this.aaC.getContext(), paramInt);
          paramAttributeSet = localDrawable;
          if (localDrawable != null)
          {
            this.aaC.setImageDrawable(localDrawable);
            paramAttributeSet = localDrawable;
          }
        }
      }
      if (paramAttributeSet != null) {
        x.n(paramAttributeSet);
      }
      if (localaz.hasValue(2)) {
        l.a(this.aaC, localaz.getColorStateList(2));
      }
      if (localaz.hasValue(3)) {
        l.a(this.aaC, x.c(localaz.getInt(3, -1), null));
      }
      return;
    }
    finally
    {
      localaz.aoo.recycle();
    }
  }
  
  final ColorStateList getSupportImageTintList()
  {
    if (this.aaE != null) {
      return this.aaE.AW;
    }
    return null;
  }
  
  final PorterDuff.Mode getSupportImageTintMode()
  {
    if (this.aaE != null) {
      return this.aaE.oM;
    }
    return null;
  }
  
  final boolean hasOverlappingRendering()
  {
    Drawable localDrawable = this.aaC.getBackground();
    return (Build.VERSION.SDK_INT < 21) || (!(localDrawable instanceof RippleDrawable));
  }
  
  final void hh()
  {
    Drawable localDrawable = this.aaC.getDrawable();
    if (localDrawable != null) {
      x.n(localDrawable);
    }
    if ((localDrawable == null) || ((hd()) && (k(localDrawable)))) {}
    do
    {
      return;
      if (this.aaE != null)
      {
        g.a(localDrawable, this.aaE, this.aaC.getDrawableState());
        return;
      }
    } while (this.aaD == null);
    g.a(localDrawable, this.aaD, this.aaC.getDrawableState());
  }
  
  public final void setImageResource(int paramInt)
  {
    if (paramInt != 0)
    {
      Drawable localDrawable = a.k(this.aaC.getContext(), paramInt);
      if (localDrawable != null) {
        x.n(localDrawable);
      }
      this.aaC.setImageDrawable(localDrawable);
    }
    for (;;)
    {
      hh();
      return;
      this.aaC.setImageDrawable(null);
    }
  }
  
  final void setSupportImageTintList(ColorStateList paramColorStateList)
  {
    if (this.aaE == null) {
      this.aaE = new ax();
    }
    this.aaE.AW = paramColorStateList;
    this.aaE.SS = true;
    hh();
  }
  
  final void setSupportImageTintMode(PorterDuff.Mode paramMode)
  {
    if (this.aaE == null) {
      this.aaE = new ax();
    }
    this.aaE.oM = paramMode;
    this.aaE.ST = true;
    hh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.i
 * JD-Core Version:    0.7.0.1
 */
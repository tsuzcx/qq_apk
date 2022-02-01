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
  private final ImageView akG;
  private ax akH;
  private ax akI;
  private ax aki;
  
  public i(ImageView paramImageView)
  {
    this.akG = paramImageView;
  }
  
  private boolean jh()
  {
    int i = Build.VERSION.SDK_INT;
    if (i > 21) {
      if (this.akH == null) {}
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
    Object localObject = l.a(this.akG);
    if (localObject != null)
    {
      localax.acT = true;
      localax.Kr = ((ColorStateList)localObject);
    }
    localObject = l.b(this.akG);
    if (localObject != null)
    {
      localax.acU = true;
      localax.yl = ((PorterDuff.Mode)localObject);
    }
    if ((localax.acT) || (localax.acU))
    {
      g.a(paramDrawable, localax, this.akG.getDrawableState());
      return true;
    }
    return false;
  }
  
  public final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    az localaz = az.a(this.akG.getContext(), paramAttributeSet, a.a.AppCompatImageView, paramInt, 0);
    try
    {
      Drawable localDrawable = this.akG.getDrawable();
      paramAttributeSet = localDrawable;
      if (localDrawable == null)
      {
        paramInt = localaz.getResourceId(1, -1);
        paramAttributeSet = localDrawable;
        if (paramInt != -1)
        {
          localDrawable = a.l(this.akG.getContext(), paramInt);
          paramAttributeSet = localDrawable;
          if (localDrawable != null)
          {
            this.akG.setImageDrawable(localDrawable);
            paramAttributeSet = localDrawable;
          }
        }
      }
      if (paramAttributeSet != null) {
        x.s(paramAttributeSet);
      }
      if (localaz.hasValue(2)) {
        l.a(this.akG, localaz.getColorStateList(2));
      }
      if (localaz.hasValue(3)) {
        l.a(this.akG, x.a(localaz.getInt(3, -1), null));
      }
      return;
    }
    finally
    {
      localaz.ayy.recycle();
    }
  }
  
  final ColorStateList getSupportImageTintList()
  {
    if (this.akI != null) {
      return this.akI.Kr;
    }
    return null;
  }
  
  final PorterDuff.Mode getSupportImageTintMode()
  {
    if (this.akI != null) {
      return this.akI.yl;
    }
    return null;
  }
  
  final boolean hasOverlappingRendering()
  {
    Drawable localDrawable = this.akG.getBackground();
    return (Build.VERSION.SDK_INT < 21) || (!(localDrawable instanceof RippleDrawable));
  }
  
  final void jl()
  {
    Drawable localDrawable = this.akG.getDrawable();
    if (localDrawable != null) {
      x.s(localDrawable);
    }
    if ((localDrawable == null) || ((jh()) && (p(localDrawable)))) {}
    do
    {
      return;
      if (this.akI != null)
      {
        g.a(localDrawable, this.akI, this.akG.getDrawableState());
        return;
      }
    } while (this.akH == null);
    g.a(localDrawable, this.akH, this.akG.getDrawableState());
  }
  
  public final void setImageResource(int paramInt)
  {
    if (paramInt != 0)
    {
      Drawable localDrawable = a.l(this.akG.getContext(), paramInt);
      if (localDrawable != null) {
        x.s(localDrawable);
      }
      this.akG.setImageDrawable(localDrawable);
    }
    for (;;)
    {
      jl();
      return;
      this.akG.setImageDrawable(null);
    }
  }
  
  final void setSupportImageTintList(ColorStateList paramColorStateList)
  {
    if (this.akI == null) {
      this.akI = new ax();
    }
    this.akI.Kr = paramColorStateList;
    this.akI.acT = true;
    jl();
  }
  
  final void setSupportImageTintMode(PorterDuff.Mode paramMode)
  {
    if (this.akI == null) {
      this.akI = new ax();
    }
    this.akI.yl = paramMode;
    this.akI.acU = true;
    jl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.i
 * JD-Core Version:    0.7.0.1
 */
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
  private ax ajV;
  private final ImageView akt;
  private ax aku;
  private ax akv;
  
  public i(ImageView paramImageView)
  {
    this.akt = paramImageView;
  }
  
  private boolean iY()
  {
    int i = Build.VERSION.SDK_INT;
    if (i > 21) {
      if (this.aku == null) {}
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
    Object localObject = l.a(this.akt);
    if (localObject != null)
    {
      localax.acG = true;
      localax.Kh = ((ColorStateList)localObject);
    }
    localObject = l.b(this.akt);
    if (localObject != null)
    {
      localax.acH = true;
      localax.yf = ((PorterDuff.Mode)localObject);
    }
    if ((localax.acG) || (localax.acH))
    {
      g.a(paramDrawable, localax, this.akt.getDrawableState());
      return true;
    }
    return false;
  }
  
  public final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    az localaz = az.a(this.akt.getContext(), paramAttributeSet, a.a.AppCompatImageView, paramInt, 0);
    try
    {
      Drawable localDrawable = this.akt.getDrawable();
      paramAttributeSet = localDrawable;
      if (localDrawable == null)
      {
        paramInt = localaz.getResourceId(1, -1);
        paramAttributeSet = localDrawable;
        if (paramInt != -1)
        {
          localDrawable = a.l(this.akt.getContext(), paramInt);
          paramAttributeSet = localDrawable;
          if (localDrawable != null)
          {
            this.akt.setImageDrawable(localDrawable);
            paramAttributeSet = localDrawable;
          }
        }
      }
      if (paramAttributeSet != null) {
        x.s(paramAttributeSet);
      }
      if (localaz.hasValue(2)) {
        l.a(this.akt, localaz.getColorStateList(2));
      }
      if (localaz.hasValue(3)) {
        l.a(this.akt, x.a(localaz.getInt(3, -1), null));
      }
      return;
    }
    finally
    {
      localaz.ayA.recycle();
    }
  }
  
  final ColorStateList getSupportImageTintList()
  {
    if (this.akv != null) {
      return this.akv.Kh;
    }
    return null;
  }
  
  final PorterDuff.Mode getSupportImageTintMode()
  {
    if (this.akv != null) {
      return this.akv.yf;
    }
    return null;
  }
  
  final boolean hasOverlappingRendering()
  {
    Drawable localDrawable = this.akt.getBackground();
    return (Build.VERSION.SDK_INT < 21) || (!(localDrawable instanceof RippleDrawable));
  }
  
  final void jc()
  {
    Drawable localDrawable = this.akt.getDrawable();
    if (localDrawable != null) {
      x.s(localDrawable);
    }
    if ((localDrawable == null) || ((iY()) && (p(localDrawable)))) {}
    do
    {
      return;
      if (this.akv != null)
      {
        g.a(localDrawable, this.akv, this.akt.getDrawableState());
        return;
      }
    } while (this.aku == null);
    g.a(localDrawable, this.aku, this.akt.getDrawableState());
  }
  
  public final void setImageResource(int paramInt)
  {
    if (paramInt != 0)
    {
      Drawable localDrawable = a.l(this.akt.getContext(), paramInt);
      if (localDrawable != null) {
        x.s(localDrawable);
      }
      this.akt.setImageDrawable(localDrawable);
    }
    for (;;)
    {
      jc();
      return;
      this.akt.setImageDrawable(null);
    }
  }
  
  final void setSupportImageTintList(ColorStateList paramColorStateList)
  {
    if (this.akv == null) {
      this.akv = new ax();
    }
    this.akv.Kh = paramColorStateList;
    this.akv.acG = true;
    jc();
  }
  
  final void setSupportImageTintMode(PorterDuff.Mode paramMode)
  {
    if (this.akv == null) {
      this.akv = new ax();
    }
    this.akv.yf = paramMode;
    this.akv.acH = true;
    jc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.i
 * JD-Core Version:    0.7.0.1
 */
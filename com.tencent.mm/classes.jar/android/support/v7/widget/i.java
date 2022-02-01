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
  private final ImageView aiC;
  private ax aiD;
  private ax aiE;
  private ax aie;
  
  public i(ImageView paramImageView)
  {
    this.aiC = paramImageView;
  }
  
  private boolean iI()
  {
    int i = Build.VERSION.SDK_INT;
    if (i > 21) {
      if (this.aiD == null) {}
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
    Object localObject = l.a(this.aiC);
    if (localObject != null)
    {
      localax.aaQ = true;
      localax.Ip = ((ColorStateList)localObject);
    }
    localObject = l.b(this.aiC);
    if (localObject != null)
    {
      localax.aaR = true;
      localax.wn = ((PorterDuff.Mode)localObject);
    }
    if ((localax.aaQ) || (localax.aaR))
    {
      g.a(paramDrawable, localax, this.aiC.getDrawableState());
      return true;
    }
    return false;
  }
  
  public final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    az localaz = az.a(this.aiC.getContext(), paramAttributeSet, a.a.AppCompatImageView, paramInt, 0);
    try
    {
      Drawable localDrawable = this.aiC.getDrawable();
      paramAttributeSet = localDrawable;
      if (localDrawable == null)
      {
        paramInt = localaz.getResourceId(1, -1);
        paramAttributeSet = localDrawable;
        if (paramInt != -1)
        {
          localDrawable = a.l(this.aiC.getContext(), paramInt);
          paramAttributeSet = localDrawable;
          if (localDrawable != null)
          {
            this.aiC.setImageDrawable(localDrawable);
            paramAttributeSet = localDrawable;
          }
        }
      }
      if (paramAttributeSet != null) {
        x.s(paramAttributeSet);
      }
      if (localaz.hasValue(2)) {
        l.a(this.aiC, localaz.getColorStateList(2));
      }
      if (localaz.hasValue(3)) {
        l.a(this.aiC, x.a(localaz.getInt(3, -1), null));
      }
      return;
    }
    finally
    {
      localaz.awJ.recycle();
    }
  }
  
  final ColorStateList getSupportImageTintList()
  {
    if (this.aiE != null) {
      return this.aiE.Ip;
    }
    return null;
  }
  
  final PorterDuff.Mode getSupportImageTintMode()
  {
    if (this.aiE != null) {
      return this.aiE.wn;
    }
    return null;
  }
  
  final boolean hasOverlappingRendering()
  {
    Drawable localDrawable = this.aiC.getBackground();
    return (Build.VERSION.SDK_INT < 21) || (!(localDrawable instanceof RippleDrawable));
  }
  
  final void iM()
  {
    Drawable localDrawable = this.aiC.getDrawable();
    if (localDrawable != null) {
      x.s(localDrawable);
    }
    if ((localDrawable == null) || ((iI()) && (p(localDrawable)))) {}
    do
    {
      return;
      if (this.aiE != null)
      {
        g.a(localDrawable, this.aiE, this.aiC.getDrawableState());
        return;
      }
    } while (this.aiD == null);
    g.a(localDrawable, this.aiD, this.aiC.getDrawableState());
  }
  
  public final void setImageResource(int paramInt)
  {
    if (paramInt != 0)
    {
      Drawable localDrawable = a.l(this.aiC.getContext(), paramInt);
      if (localDrawable != null) {
        x.s(localDrawable);
      }
      this.aiC.setImageDrawable(localDrawable);
    }
    for (;;)
    {
      iM();
      return;
      this.aiC.setImageDrawable(null);
    }
  }
  
  final void setSupportImageTintList(ColorStateList paramColorStateList)
  {
    if (this.aiE == null) {
      this.aiE = new ax();
    }
    this.aiE.Ip = paramColorStateList;
    this.aiE.aaQ = true;
    iM();
  }
  
  final void setSupportImageTintMode(PorterDuff.Mode paramMode)
  {
    if (this.aiE == null) {
      this.aiE = new ax();
    }
    this.aiE.wn = paramMode;
    this.aiE.aaR = true;
    iM();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.i
 * JD-Core Version:    0.7.0.1
 */
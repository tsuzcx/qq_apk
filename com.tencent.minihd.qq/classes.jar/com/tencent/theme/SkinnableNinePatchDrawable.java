package com.tencent.theme;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.util.DisplayMetrics;

public class SkinnableNinePatchDrawable
  extends Drawable
{
  private a a;
  private NinePatch b;
  private Rect c;
  private Paint d;
  private int e = 160;
  private int f;
  private int g;
  
  SkinnableNinePatchDrawable() {}
  
  public SkinnableNinePatchDrawable(Resources paramResources, Bitmap paramBitmap, byte[] paramArrayOfByte, Rect paramRect, String paramString)
  {
    this(new a(new NinePatch(paramBitmap, paramArrayOfByte, paramString), paramBitmap, paramRect), paramResources);
    this.a.l = this.e;
  }
  
  @Deprecated
  public SkinnableNinePatchDrawable(Bitmap paramBitmap, byte[] paramArrayOfByte, Rect paramRect, String paramString)
  {
    this(new a(new NinePatch(paramBitmap, paramArrayOfByte, paramString), paramBitmap, paramRect), null);
  }
  
  SkinnableNinePatchDrawable(a parama, Resources paramResources)
  {
    a(parama, paramResources);
  }
  
  private void a()
  {
    b();
    if (this.a.f != null)
    {
      localObject = this.a.f;
      this.f = b.a(localObject[0], localObject[2], this.e);
      this.f = b.a(localObject[1], localObject[2], this.e);
      this.c.set(0, 0, 0, 0);
      return;
    }
    int i = this.b.getDensity();
    int j = this.e;
    if (i == j)
    {
      this.f = this.b.getWidth();
      this.g = this.b.getHeight();
      return;
    }
    this.f = b.a(this.b.getWidth(), i, j);
    this.g = b.a(this.b.getHeight(), i, j);
    Rect localRect1 = this.c;
    Rect localRect2 = this.a.h;
    Object localObject = localRect1;
    if (localRect1 == localRect2)
    {
      localObject = new Rect(localRect2);
      this.c = ((Rect)localObject);
    }
    ((Rect)localObject).left = b.a(localRect2.left, i, j);
    ((Rect)localObject).top = b.a(localRect2.top, i, j);
    ((Rect)localObject).right = b.a(localRect2.right, i, j);
    ((Rect)localObject).bottom = b.a(localRect2.bottom, i, j);
  }
  
  private void a(a parama, Resources paramResources)
  {
    this.a = parama;
    this.b = parama.g;
    this.c = parama.h;
    if (paramResources != null) {}
    for (int i = paramResources.getDisplayMetrics().densityDpi;; i = parama.l)
    {
      this.e = i;
      if (true != parama.j) {
        setDither(parama.j);
      }
      if (this.b != null) {
        a();
      }
      return;
    }
  }
  
  private void b()
  {
    if (this.b != this.a.g)
    {
      this.b = this.a.g;
      this.c = this.a.h;
      if (this.a.f != null)
      {
        localObject = this.a.f;
        this.f = b.a(localObject[0], localObject[2], this.e);
        this.f = b.a(localObject[1], localObject[2], this.e);
        this.c.set(0, 0, 0, 0);
      }
    }
    else
    {
      return;
    }
    int i = this.b.getDensity();
    int j = this.e;
    if (i == j)
    {
      this.f = this.b.getWidth();
      this.g = this.b.getHeight();
      return;
    }
    this.f = b.a(this.b.getWidth(), i, j);
    this.g = b.a(this.b.getHeight(), i, j);
    Rect localRect1 = this.c;
    Rect localRect2 = this.a.h;
    Object localObject = localRect1;
    if (localRect1 == localRect2)
    {
      localObject = new Rect(localRect2);
      this.c = ((Rect)localObject);
    }
    ((Rect)localObject).left = b.a(localRect2.left, i, j);
    ((Rect)localObject).top = b.a(localRect2.top, i, j);
    ((Rect)localObject).right = b.a(localRect2.right, i, j);
    ((Rect)localObject).bottom = b.a(localRect2.bottom, i, j);
  }
  
  boolean a(Rect paramRect)
  {
    if (this.a.i == null) {
      return false;
    }
    paramRect.set(this.a.i);
    return true;
  }
  
  public void draw(Canvas paramCanvas)
  {
    b();
    if (this.a.f != null) {}
    for (;;)
    {
      return;
      Rect localRect = getBounds();
      try
      {
        this.b.draw(paramCanvas, localRect, this.d);
        if (!this.a.e) {
          continue;
        }
        paramCanvas.drawRect(localRect, b.b);
        paramCanvas.drawLine(localRect.left, localRect.top, localRect.right, localRect.bottom, b.a);
        paramCanvas.drawLine(localRect.right, localRect.top, localRect.left, localRect.bottom, b.a);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public Bitmap getBitmap()
  {
    return this.a.m;
  }
  
  public int getChangingConfigurations()
  {
    return super.getChangingConfigurations() | this.a.k;
  }
  
  public Drawable.ConstantState getConstantState()
  {
    this.a.k = super.getChangingConfigurations();
    return this.a;
  }
  
  public int getIntrinsicHeight()
  {
    b();
    return this.g;
  }
  
  public int getIntrinsicWidth()
  {
    b();
    return this.f;
  }
  
  public int getMinimumHeight()
  {
    b();
    return this.g;
  }
  
  public int getMinimumWidth()
  {
    b();
    return this.f;
  }
  
  public int getOpacity()
  {
    b();
    if ((this.b == null) || (this.b.hasAlpha()) || ((this.d != null) && (this.d.getAlpha() < 255))) {
      return -3;
    }
    return -1;
  }
  
  public boolean getPadding(Rect paramRect)
  {
    b();
    paramRect.set(this.c);
    return true;
  }
  
  public Paint getPaint()
  {
    if (this.d == null)
    {
      this.d = new Paint();
      this.d.setDither(true);
    }
    return this.d;
  }
  
  public Region getTransparentRegion()
  {
    b();
    if (this.b == null) {
      return null;
    }
    return this.b.getTransparentRegion(getBounds());
  }
  
  public Drawable mutate()
  {
    return this;
  }
  
  public void setAlpha(int paramInt)
  {
    getPaint().setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    getPaint().setColorFilter(paramColorFilter);
  }
  
  public void setDither(boolean paramBoolean)
  {
    getPaint().setDither(paramBoolean);
  }
  
  public void setTargetDensity(int paramInt)
  {
    b();
    int i = paramInt;
    if (paramInt == 0) {
      i = 160;
    }
    this.e = i;
    if (this.b != null) {
      a();
    }
  }
  
  public void setTargetDensity(Canvas paramCanvas)
  {
    setTargetDensity(paramCanvas.getDensity());
  }
  
  public void setTargetDensity(DisplayMetrics paramDisplayMetrics)
  {
    b();
    this.e = paramDisplayMetrics.densityDpi;
    if (this.b != null) {
      a();
    }
  }
  
  static final class a
    extends b
  {
    NinePatch g;
    Rect h;
    Rect i;
    final boolean j;
    int k;
    int l = 160;
    Bitmap m;
    
    a(NinePatch paramNinePatch, Bitmap paramBitmap, Rect paramRect)
    {
      this(paramNinePatch, paramBitmap, paramRect, true);
    }
    
    a(NinePatch paramNinePatch, Bitmap paramBitmap, Rect paramRect, boolean paramBoolean)
    {
      this.m = paramBitmap;
      this.g = paramNinePatch;
      this.h = paramRect;
      this.j = paramBoolean;
    }
    
    public int getChangingConfigurations()
    {
      return this.k;
    }
    
    public Drawable newDrawable()
    {
      return new SkinnableNinePatchDrawable(this, null);
    }
    
    public Drawable newDrawable(Resources paramResources)
    {
      return new SkinnableNinePatchDrawable(this, paramResources);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.theme.SkinnableNinePatchDrawable
 * JD-Core Version:    0.7.0.1
 */
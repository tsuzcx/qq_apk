package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.SystemClock;

public final class zzacb
  extends Drawable
  implements Drawable.Callback
{
  private int mFrom;
  private int zzaED = 0;
  private int zzaEE;
  private int zzaEF = 255;
  private int zzaEG;
  private int zzaEH = 0;
  private boolean zzaEI;
  private zzacb.zzb zzaEJ;
  private Drawable zzaEK;
  private Drawable zzaEL;
  private boolean zzaEM;
  private boolean zzaEN;
  private boolean zzaEO;
  private int zzaEP;
  private boolean zzaEy = true;
  private long zzafe;
  
  public zzacb(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    this(null);
    Object localObject = paramDrawable1;
    if (paramDrawable1 == null) {
      localObject = zzacb.zza.zzxt();
    }
    this.zzaEK = ((Drawable)localObject);
    ((Drawable)localObject).setCallback(this);
    paramDrawable1 = this.zzaEJ;
    paramDrawable1.zzaES |= ((Drawable)localObject).getChangingConfigurations();
    paramDrawable1 = paramDrawable2;
    if (paramDrawable2 == null) {
      paramDrawable1 = zzacb.zza.zzxt();
    }
    this.zzaEL = paramDrawable1;
    paramDrawable1.setCallback(this);
    paramDrawable2 = this.zzaEJ;
    paramDrawable2.zzaES |= paramDrawable1.getChangingConfigurations();
  }
  
  zzacb(zzacb.zzb paramzzb)
  {
    this.zzaEJ = new zzacb.zzb(paramzzb);
  }
  
  public final boolean canConstantState()
  {
    if (!this.zzaEM) {
      if ((this.zzaEK.getConstantState() == null) || (this.zzaEL.getConstantState() == null)) {
        break label44;
      }
    }
    label44:
    for (boolean bool = true;; bool = false)
    {
      this.zzaEN = bool;
      this.zzaEM = true;
      return this.zzaEN;
    }
  }
  
  public final void draw(Canvas paramCanvas)
  {
    int j = 1;
    int i = 1;
    int k = 0;
    switch (this.zzaED)
    {
    }
    boolean bool;
    Drawable localDrawable1;
    Drawable localDrawable2;
    do
    {
      for (;;)
      {
        j = this.zzaEH;
        bool = this.zzaEy;
        localDrawable1 = this.zzaEK;
        localDrawable2 = this.zzaEL;
        if (i == 0) {
          break;
        }
        if ((!bool) || (j == 0)) {
          localDrawable1.draw(paramCanvas);
        }
        if (j == this.zzaEF)
        {
          localDrawable2.setAlpha(this.zzaEF);
          localDrawable2.draw(paramCanvas);
        }
        return;
        this.zzafe = SystemClock.uptimeMillis();
        this.zzaED = 2;
        i = k;
      }
    } while (this.zzafe < 0L);
    float f = (float)(SystemClock.uptimeMillis() - this.zzafe) / this.zzaEG;
    if (f >= 1.0F) {}
    for (i = j;; i = 0)
    {
      if (i != 0) {
        this.zzaED = 0;
      }
      this.zzaEH = ((int)(Math.min(f, 1.0F) * (this.zzaEE + 0) + 0.0F));
      break;
    }
    if (bool) {
      localDrawable1.setAlpha(this.zzaEF - j);
    }
    localDrawable1.draw(paramCanvas);
    if (bool) {
      localDrawable1.setAlpha(this.zzaEF);
    }
    if (j > 0)
    {
      localDrawable2.setAlpha(j);
      localDrawable2.draw(paramCanvas);
      localDrawable2.setAlpha(this.zzaEF);
    }
    invalidateSelf();
  }
  
  public final int getChangingConfigurations()
  {
    return super.getChangingConfigurations() | this.zzaEJ.mChangingConfigurations | this.zzaEJ.zzaES;
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    if (canConstantState())
    {
      this.zzaEJ.mChangingConfigurations = getChangingConfigurations();
      return this.zzaEJ;
    }
    return null;
  }
  
  public final int getIntrinsicHeight()
  {
    return Math.max(this.zzaEK.getIntrinsicHeight(), this.zzaEL.getIntrinsicHeight());
  }
  
  public final int getIntrinsicWidth()
  {
    return Math.max(this.zzaEK.getIntrinsicWidth(), this.zzaEL.getIntrinsicWidth());
  }
  
  public final int getOpacity()
  {
    if (!this.zzaEO)
    {
      this.zzaEP = Drawable.resolveOpacity(this.zzaEK.getOpacity(), this.zzaEL.getOpacity());
      this.zzaEO = true;
    }
    return this.zzaEP;
  }
  
  public final void invalidateDrawable(Drawable paramDrawable)
  {
    paramDrawable = getCallback();
    if (paramDrawable != null) {
      paramDrawable.invalidateDrawable(this);
    }
  }
  
  public final Drawable mutate()
  {
    if ((!this.zzaEI) && (super.mutate() == this))
    {
      if (!canConstantState()) {
        throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
      }
      this.zzaEK.mutate();
      this.zzaEL.mutate();
      this.zzaEI = true;
    }
    return this;
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    this.zzaEK.setBounds(paramRect);
    this.zzaEL.setBounds(paramRect);
  }
  
  public final void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    paramDrawable = getCallback();
    if (paramDrawable != null) {
      paramDrawable.scheduleDrawable(this, paramRunnable, paramLong);
    }
  }
  
  public final void setAlpha(int paramInt)
  {
    if (this.zzaEH == this.zzaEF) {
      this.zzaEH = paramInt;
    }
    this.zzaEF = paramInt;
    invalidateSelf();
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    this.zzaEK.setColorFilter(paramColorFilter);
    this.zzaEL.setColorFilter(paramColorFilter);
  }
  
  public final void startTransition(int paramInt)
  {
    this.mFrom = 0;
    this.zzaEE = this.zzaEF;
    this.zzaEH = 0;
    this.zzaEG = paramInt;
    this.zzaED = 1;
    invalidateSelf();
  }
  
  public final void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    paramDrawable = getCallback();
    if (paramDrawable != null) {
      paramDrawable.unscheduleDrawable(this, paramRunnable);
    }
  }
  
  public final Drawable zzxs()
  {
    return this.zzaEL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.zzacb
 * JD-Core Version:    0.7.0.1
 */
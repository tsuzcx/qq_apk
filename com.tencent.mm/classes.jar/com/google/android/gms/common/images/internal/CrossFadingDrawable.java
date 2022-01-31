package com.google.android.gms.common.images.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class CrossFadingDrawable
  extends Drawable
  implements Drawable.Callback
{
  private int mAlpha;
  private int mFrom;
  private boolean zzpl;
  private int zzpw;
  private long zzpx;
  private int zzpy;
  private int zzpz;
  private int zzqa;
  private boolean zzqb;
  private CrossFadingDrawable.zzb zzqc;
  private Drawable zzqd;
  private Drawable zzqe;
  private boolean zzqf;
  private boolean zzqg;
  private boolean zzqh;
  private int zzqi;
  
  public CrossFadingDrawable(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    this(null);
    AppMethodBeat.i(61262);
    Object localObject = paramDrawable1;
    if (paramDrawable1 == null) {
      localObject = CrossFadingDrawable.zza.zzcp();
    }
    this.zzqd = ((Drawable)localObject);
    ((Drawable)localObject).setCallback(this);
    paramDrawable1 = this.zzqc;
    paramDrawable1.zzql |= ((Drawable)localObject).getChangingConfigurations();
    paramDrawable1 = paramDrawable2;
    if (paramDrawable2 == null) {
      paramDrawable1 = CrossFadingDrawable.zza.zzcp();
    }
    this.zzqe = paramDrawable1;
    paramDrawable1.setCallback(this);
    paramDrawable2 = this.zzqc;
    paramDrawable2.zzql |= paramDrawable1.getChangingConfigurations();
    AppMethodBeat.o(61262);
  }
  
  CrossFadingDrawable(CrossFadingDrawable.zzb paramzzb)
  {
    AppMethodBeat.i(61263);
    this.zzpw = 0;
    this.zzpz = 255;
    this.mAlpha = 0;
    this.zzpl = true;
    this.zzqc = new CrossFadingDrawable.zzb(paramzzb);
    AppMethodBeat.o(61263);
  }
  
  public final boolean canConstantState()
  {
    AppMethodBeat.i(61275);
    if (!this.zzqf) {
      if ((this.zzqd.getConstantState() == null) || (this.zzqe.getConstantState() == null)) {
        break label56;
      }
    }
    label56:
    for (boolean bool = true;; bool = false)
    {
      this.zzqg = bool;
      this.zzqf = true;
      bool = this.zzqg;
      AppMethodBeat.o(61275);
      return bool;
    }
  }
  
  public final void draw(Canvas paramCanvas)
  {
    int j = 1;
    int i = 1;
    int k = 0;
    AppMethodBeat.i(61279);
    switch (this.zzpw)
    {
    }
    boolean bool;
    Drawable localDrawable1;
    Drawable localDrawable2;
    do
    {
      for (;;)
      {
        j = this.mAlpha;
        bool = this.zzpl;
        localDrawable1 = this.zzqd;
        localDrawable2 = this.zzqe;
        if (i == 0) {
          break;
        }
        if ((!bool) || (j == 0)) {
          localDrawable1.draw(paramCanvas);
        }
        if (j == this.zzpz)
        {
          localDrawable2.setAlpha(this.zzpz);
          localDrawable2.draw(paramCanvas);
        }
        AppMethodBeat.o(61279);
        return;
        this.zzpx = SystemClock.uptimeMillis();
        this.zzpw = 2;
        i = k;
      }
    } while (this.zzpx < 0L);
    float f = (float)(SystemClock.uptimeMillis() - this.zzpx) / this.zzqa;
    if (f >= 1.0F) {}
    for (i = j;; i = 0)
    {
      if (i != 0) {
        this.zzpw = 0;
      }
      this.mAlpha = ((int)(Math.min(f, 1.0F) * this.zzpy + 0.0F));
      break;
    }
    if (bool) {
      localDrawable1.setAlpha(this.zzpz - j);
    }
    localDrawable1.draw(paramCanvas);
    if (bool) {
      localDrawable1.setAlpha(this.zzpz);
    }
    if (j > 0)
    {
      localDrawable2.setAlpha(j);
      localDrawable2.draw(paramCanvas);
      localDrawable2.setAlpha(this.zzpz);
    }
    invalidateSelf();
    AppMethodBeat.o(61279);
  }
  
  public final int getChangingConfigurations()
  {
    AppMethodBeat.i(61267);
    int i = super.getChangingConfigurations();
    int j = this.zzqc.mChangingConfigurations;
    int k = this.zzqc.zzql;
    AppMethodBeat.o(61267);
    return i | j | k;
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    AppMethodBeat.i(61273);
    if (canConstantState())
    {
      this.zzqc.mChangingConfigurations = getChangingConfigurations();
      CrossFadingDrawable.zzb localzzb = this.zzqc;
      AppMethodBeat.o(61273);
      return localzzb;
    }
    AppMethodBeat.o(61273);
    return null;
  }
  
  public final Drawable getEndDrawable()
  {
    return this.zzqe;
  }
  
  public final int getIntrinsicHeight()
  {
    AppMethodBeat.i(61271);
    int i = Math.max(this.zzqd.getIntrinsicHeight(), this.zzqe.getIntrinsicHeight());
    AppMethodBeat.o(61271);
    return i;
  }
  
  public final int getIntrinsicWidth()
  {
    AppMethodBeat.i(61270);
    int i = Math.max(this.zzqd.getIntrinsicWidth(), this.zzqe.getIntrinsicWidth());
    AppMethodBeat.o(61270);
    return i;
  }
  
  public final int getOpacity()
  {
    AppMethodBeat.i(61274);
    if (!this.zzqh)
    {
      this.zzqi = Drawable.resolveOpacity(this.zzqd.getOpacity(), this.zzqe.getOpacity());
      this.zzqh = true;
    }
    int i = this.zzqi;
    AppMethodBeat.o(61274);
    return i;
  }
  
  public final Drawable getStartDrawable()
  {
    return this.zzqd;
  }
  
  public final void invalidateDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(61264);
    paramDrawable = getCallback();
    if (paramDrawable != null) {
      paramDrawable.invalidateDrawable(this);
    }
    AppMethodBeat.o(61264);
  }
  
  public final Drawable mutate()
  {
    AppMethodBeat.i(61276);
    if ((!this.zzqb) && (super.mutate() == this))
    {
      if (!canConstantState())
      {
        IllegalStateException localIllegalStateException = new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
        AppMethodBeat.o(61276);
        throw localIllegalStateException;
      }
      this.zzqd.mutate();
      this.zzqe.mutate();
      this.zzqb = true;
    }
    AppMethodBeat.o(61276);
    return this;
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    AppMethodBeat.i(61272);
    this.zzqd.setBounds(paramRect);
    this.zzqe.setBounds(paramRect);
    AppMethodBeat.o(61272);
  }
  
  public final void resetTransition()
  {
    AppMethodBeat.i(61278);
    this.mAlpha = 0;
    this.zzpw = 0;
    invalidateSelf();
    AppMethodBeat.o(61278);
  }
  
  public final void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(61265);
    paramDrawable = getCallback();
    if (paramDrawable != null) {
      paramDrawable.scheduleDrawable(this, paramRunnable, paramLong);
    }
    AppMethodBeat.o(61265);
  }
  
  public final void setAlpha(int paramInt)
  {
    AppMethodBeat.i(61268);
    if (this.mAlpha == this.zzpz) {
      this.mAlpha = paramInt;
    }
    this.zzpz = paramInt;
    invalidateSelf();
    AppMethodBeat.o(61268);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(61269);
    this.zzqd.setColorFilter(paramColorFilter);
    this.zzqe.setColorFilter(paramColorFilter);
    AppMethodBeat.o(61269);
  }
  
  public final void setCrossFadeEnabled(boolean paramBoolean)
  {
    this.zzpl = paramBoolean;
  }
  
  public final void startTransition(int paramInt)
  {
    AppMethodBeat.i(61277);
    this.mFrom = 0;
    this.zzpy = this.zzpz;
    this.mAlpha = 0;
    this.zzqa = paramInt;
    this.zzpw = 1;
    invalidateSelf();
    AppMethodBeat.o(61277);
  }
  
  public final void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    AppMethodBeat.i(61266);
    paramDrawable = getCallback();
    if (paramDrawable != null) {
      paramDrawable.unscheduleDrawable(this, paramRunnable);
    }
    AppMethodBeat.o(61266);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.common.images.internal.CrossFadingDrawable
 * JD-Core Version:    0.7.0.1
 */
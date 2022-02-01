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
  private zzb zzqc;
  private Drawable zzqd;
  private Drawable zzqe;
  private boolean zzqf;
  private boolean zzqg;
  private boolean zzqh;
  private int zzqi;
  
  public CrossFadingDrawable(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    this(null);
    AppMethodBeat.i(11754);
    Object localObject = paramDrawable1;
    if (paramDrawable1 == null) {
      localObject = zza.zzcp();
    }
    this.zzqd = ((Drawable)localObject);
    ((Drawable)localObject).setCallback(this);
    paramDrawable1 = this.zzqc;
    paramDrawable1.zzql |= ((Drawable)localObject).getChangingConfigurations();
    paramDrawable1 = paramDrawable2;
    if (paramDrawable2 == null) {
      paramDrawable1 = zza.zzcp();
    }
    this.zzqe = paramDrawable1;
    paramDrawable1.setCallback(this);
    paramDrawable2 = this.zzqc;
    paramDrawable2.zzql |= paramDrawable1.getChangingConfigurations();
    AppMethodBeat.o(11754);
  }
  
  CrossFadingDrawable(zzb paramzzb)
  {
    AppMethodBeat.i(11755);
    this.zzpw = 0;
    this.zzpz = 255;
    this.mAlpha = 0;
    this.zzpl = true;
    this.zzqc = new zzb(paramzzb);
    AppMethodBeat.o(11755);
  }
  
  public final boolean canConstantState()
  {
    AppMethodBeat.i(11767);
    if (!this.zzqf) {
      if ((this.zzqd.getConstantState() == null) || (this.zzqe.getConstantState() == null)) {
        break label58;
      }
    }
    label58:
    for (boolean bool = true;; bool = false)
    {
      this.zzqg = bool;
      this.zzqf = true;
      bool = this.zzqg;
      AppMethodBeat.o(11767);
      return bool;
    }
  }
  
  public final void draw(Canvas paramCanvas)
  {
    int j = 1;
    int i = 1;
    int k = 0;
    AppMethodBeat.i(11771);
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
        AppMethodBeat.o(11771);
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
    AppMethodBeat.o(11771);
  }
  
  public final int getChangingConfigurations()
  {
    AppMethodBeat.i(11759);
    int i = super.getChangingConfigurations();
    int j = this.zzqc.mChangingConfigurations;
    int k = this.zzqc.zzql;
    AppMethodBeat.o(11759);
    return i | j | k;
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    AppMethodBeat.i(11765);
    if (canConstantState())
    {
      this.zzqc.mChangingConfigurations = getChangingConfigurations();
      zzb localzzb = this.zzqc;
      AppMethodBeat.o(11765);
      return localzzb;
    }
    AppMethodBeat.o(11765);
    return null;
  }
  
  public final Drawable getEndDrawable()
  {
    return this.zzqe;
  }
  
  public final int getIntrinsicHeight()
  {
    AppMethodBeat.i(11763);
    int i = Math.max(this.zzqd.getIntrinsicHeight(), this.zzqe.getIntrinsicHeight());
    AppMethodBeat.o(11763);
    return i;
  }
  
  public final int getIntrinsicWidth()
  {
    AppMethodBeat.i(11762);
    int i = Math.max(this.zzqd.getIntrinsicWidth(), this.zzqe.getIntrinsicWidth());
    AppMethodBeat.o(11762);
    return i;
  }
  
  public final int getOpacity()
  {
    AppMethodBeat.i(11766);
    if (!this.zzqh)
    {
      this.zzqi = Drawable.resolveOpacity(this.zzqd.getOpacity(), this.zzqe.getOpacity());
      this.zzqh = true;
    }
    int i = this.zzqi;
    AppMethodBeat.o(11766);
    return i;
  }
  
  public final Drawable getStartDrawable()
  {
    return this.zzqd;
  }
  
  public final void invalidateDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(11756);
    paramDrawable = getCallback();
    if (paramDrawable != null) {
      paramDrawable.invalidateDrawable(this);
    }
    AppMethodBeat.o(11756);
  }
  
  public final Drawable mutate()
  {
    AppMethodBeat.i(11768);
    if ((!this.zzqb) && (super.mutate() == this))
    {
      if (!canConstantState())
      {
        IllegalStateException localIllegalStateException = new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
        AppMethodBeat.o(11768);
        throw localIllegalStateException;
      }
      this.zzqd.mutate();
      this.zzqe.mutate();
      this.zzqb = true;
    }
    AppMethodBeat.o(11768);
    return this;
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    AppMethodBeat.i(11764);
    this.zzqd.setBounds(paramRect);
    this.zzqe.setBounds(paramRect);
    AppMethodBeat.o(11764);
  }
  
  public final void resetTransition()
  {
    AppMethodBeat.i(11770);
    this.mAlpha = 0;
    this.zzpw = 0;
    invalidateSelf();
    AppMethodBeat.o(11770);
  }
  
  public final void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(11757);
    paramDrawable = getCallback();
    if (paramDrawable != null) {
      paramDrawable.scheduleDrawable(this, paramRunnable, paramLong);
    }
    AppMethodBeat.o(11757);
  }
  
  public final void setAlpha(int paramInt)
  {
    AppMethodBeat.i(11760);
    if (this.mAlpha == this.zzpz) {
      this.mAlpha = paramInt;
    }
    this.zzpz = paramInt;
    invalidateSelf();
    AppMethodBeat.o(11760);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(11761);
    this.zzqd.setColorFilter(paramColorFilter);
    this.zzqe.setColorFilter(paramColorFilter);
    AppMethodBeat.o(11761);
  }
  
  public final void setCrossFadeEnabled(boolean paramBoolean)
  {
    this.zzpl = paramBoolean;
  }
  
  public final void startTransition(int paramInt)
  {
    AppMethodBeat.i(11769);
    this.mFrom = 0;
    this.zzpy = this.zzpz;
    this.mAlpha = 0;
    this.zzqa = paramInt;
    this.zzpw = 1;
    invalidateSelf();
    AppMethodBeat.o(11769);
  }
  
  public final void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    AppMethodBeat.i(11758);
    paramDrawable = getCallback();
    if (paramDrawable != null) {
      paramDrawable.unscheduleDrawable(this, paramRunnable);
    }
    AppMethodBeat.o(11758);
  }
  
  static final class zza
    extends Drawable
  {
    private static final zza zzqj;
    private static final zzb zzqk;
    
    static
    {
      AppMethodBeat.i(11751);
      zzqj = new zza();
      zzqk = new zzb(null);
      AppMethodBeat.o(11751);
    }
    
    public final void draw(Canvas paramCanvas) {}
    
    public final Drawable.ConstantState getConstantState()
    {
      return zzqk;
    }
    
    public final int getOpacity()
    {
      return -2;
    }
    
    public final void setAlpha(int paramInt) {}
    
    public final void setColorFilter(ColorFilter paramColorFilter) {}
  }
  
  static final class zzb
    extends Drawable.ConstantState
  {
    int mChangingConfigurations;
    int zzql;
    
    zzb(zzb paramzzb)
    {
      AppMethodBeat.i(11752);
      if (paramzzb != null)
      {
        this.mChangingConfigurations = paramzzb.mChangingConfigurations;
        this.zzql = paramzzb.zzql;
      }
      AppMethodBeat.o(11752);
    }
    
    public final int getChangingConfigurations()
    {
      return this.mChangingConfigurations;
    }
    
    public final Drawable newDrawable()
    {
      AppMethodBeat.i(11753);
      CrossFadingDrawable localCrossFadingDrawable = new CrossFadingDrawable(this);
      AppMethodBeat.o(11753);
      return localCrossFadingDrawable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.gms.common.images.internal.CrossFadingDrawable
 * JD-Core Version:    0.7.0.1
 */
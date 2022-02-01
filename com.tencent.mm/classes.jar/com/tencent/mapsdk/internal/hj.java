package com.tencent.mapsdk.internal;

import android.os.SystemClock;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class hj
{
  protected long a;
  public boolean b;
  protected long c;
  public boolean d;
  protected a e;
  protected hj.b f;
  private boolean g;
  private boolean h;
  private Interpolator i;
  
  public hj()
  {
    AppMethodBeat.i(226039);
    this.a = 1500L;
    this.c = 0L;
    this.i = new LinearInterpolator();
    this.e = null;
    this.f = null;
    AppMethodBeat.o(226039);
  }
  
  private void a(Interpolator paramInterpolator)
  {
    this.i = paramInterpolator;
  }
  
  private void a(hj.b paramb)
  {
    this.f = paramb;
  }
  
  private float b(float paramFloat)
  {
    AppMethodBeat.i(226090);
    if (this.i != null)
    {
      paramFloat = this.i.getInterpolation(paramFloat);
      AppMethodBeat.o(226090);
      return paramFloat;
    }
    AppMethodBeat.o(226090);
    return paramFloat;
  }
  
  private Interpolator c()
  {
    return this.i;
  }
  
  private static long d()
  {
    AppMethodBeat.i(226066);
    long l = SystemClock.uptimeMillis();
    AppMethodBeat.o(226066);
    return l;
  }
  
  private void e()
  {
    this.b = false;
  }
  
  private boolean f()
  {
    return this.b;
  }
  
  private boolean g()
  {
    return this.g;
  }
  
  private boolean h()
  {
    return this.h;
  }
  
  private boolean i()
  {
    return this.d;
  }
  
  protected void a(float paramFloat)
  {
    AppMethodBeat.i(226139);
    if (this.e != null) {
      this.e.a(paramFloat);
    }
    AppMethodBeat.o(226139);
  }
  
  public final void a(long paramLong)
  {
    this.a = paramLong;
  }
  
  public final void a(a parama)
  {
    this.e = parama;
  }
  
  public final boolean a()
  {
    AppMethodBeat.i(226114);
    boolean bool = a(false);
    AppMethodBeat.o(226114);
    return bool;
  }
  
  public final boolean a(boolean paramBoolean)
  {
    if ((this.a <= 0L) || (this.h)) {
      return false;
    }
    this.h = true;
    this.g = paramBoolean;
    return true;
  }
  
  public final void b()
  {
    float f1 = 1.0F;
    AppMethodBeat.i(226134);
    if ((!this.b) && (this.h) && (this.c == 0L))
    {
      this.c = SystemClock.uptimeMillis();
      this.b = true;
    }
    long l = SystemClock.uptimeMillis();
    float f2 = (float)(l - this.c) / (float)this.a;
    if (f2 > 1.0F) {
      if (this.g) {
        this.c = l;
      }
    }
    for (;;)
    {
      f2 = f1;
      if (this.i != null) {
        f2 = this.i.getInterpolation(f1);
      }
      a(f2);
      if (!this.b) {
        this.d = true;
      }
      AppMethodBeat.o(226134);
      return;
      this.b = false;
      continue;
      f1 = f2;
    }
  }
  
  public static abstract class a
  {
    private static void a() {}
    
    private static void b() {}
    
    protected void a(float paramFloat) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.hj
 * JD-Core Version:    0.7.0.1
 */
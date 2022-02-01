package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class im
  implements Cloneable
{
  float a;
  Class<?> b;
  Interpolator c = null;
  boolean d = false;
  
  public static im a()
  {
    return new b();
  }
  
  public static im a(float paramFloat, double paramDouble)
  {
    return new a(paramFloat, paramDouble);
  }
  
  public static im a(float paramFloat, int paramInt)
  {
    return new b(paramFloat, paramInt);
  }
  
  public static im a(float paramFloat, Object paramObject)
  {
    return new c(paramFloat, paramObject);
  }
  
  private void a(float paramFloat)
  {
    this.a = paramFloat;
  }
  
  private void a(Interpolator paramInterpolator)
  {
    this.c = paramInterpolator;
  }
  
  public static im b()
  {
    return new a();
  }
  
  public static im c()
  {
    return new c(0.0F, null);
  }
  
  private boolean f()
  {
    return this.d;
  }
  
  private float g()
  {
    return this.a;
  }
  
  private Interpolator h()
  {
    return this.c;
  }
  
  private Class i()
  {
    return this.b;
  }
  
  public abstract void a(Object paramObject);
  
  public abstract Object d();
  
  public abstract im e();
  
  static final class a
    extends im
  {
    double e;
    
    a()
    {
      this.a = 0.0F;
      this.b = Double.TYPE;
    }
    
    a(float paramFloat, double paramDouble)
    {
      this.a = paramFloat;
      this.e = paramDouble;
      this.b = Double.TYPE;
      this.d = true;
    }
    
    private double f()
    {
      return this.e;
    }
    
    private a g()
    {
      AppMethodBeat.i(221373);
      a locala = new a(this.a, this.e);
      locala.c = this.c;
      AppMethodBeat.o(221373);
      return locala;
    }
    
    public final void a(Object paramObject)
    {
      AppMethodBeat.i(221383);
      if ((paramObject != null) && (paramObject.getClass() == Double.class))
      {
        this.e = ((Double)paramObject).doubleValue();
        this.d = true;
      }
      AppMethodBeat.o(221383);
    }
    
    public final Object d()
    {
      AppMethodBeat.i(221379);
      double d = this.e;
      AppMethodBeat.o(221379);
      return Double.valueOf(d);
    }
  }
  
  static final class b
    extends im
  {
    int e;
    
    b()
    {
      this.a = 0.0F;
      this.b = Integer.TYPE;
    }
    
    b(float paramFloat, int paramInt)
    {
      this.a = paramFloat;
      this.e = paramInt;
      this.b = Integer.TYPE;
      this.d = true;
    }
    
    private int f()
    {
      return this.e;
    }
    
    private b g()
    {
      AppMethodBeat.i(221395);
      b localb = new b(this.a, this.e);
      localb.c = this.c;
      AppMethodBeat.o(221395);
      return localb;
    }
    
    public final void a(Object paramObject)
    {
      AppMethodBeat.i(221409);
      if ((paramObject != null) && (paramObject.getClass() == Integer.class))
      {
        this.e = ((Integer)paramObject).intValue();
        this.d = true;
      }
      AppMethodBeat.o(221409);
    }
    
    public final Object d()
    {
      AppMethodBeat.i(221402);
      int i = this.e;
      AppMethodBeat.o(221402);
      return Integer.valueOf(i);
    }
  }
  
  static final class c
    extends im
  {
    Object e;
    
    c(float paramFloat, Object paramObject)
    {
      AppMethodBeat.i(226217);
      this.a = paramFloat;
      this.e = paramObject;
      boolean bool;
      if (paramObject != null)
      {
        bool = true;
        this.d = bool;
        if (!this.d) {
          break label58;
        }
      }
      label58:
      for (paramObject = paramObject.getClass();; paramObject = Object.class)
      {
        this.b = paramObject;
        AppMethodBeat.o(226217);
        return;
        bool = false;
        break;
      }
    }
    
    private c f()
    {
      AppMethodBeat.i(226229);
      c localc = new c(this.a, this.e);
      localc.c = this.c;
      AppMethodBeat.o(226229);
      return localc;
    }
    
    public final void a(Object paramObject)
    {
      this.e = paramObject;
      if (paramObject != null) {}
      for (boolean bool = true;; bool = false)
      {
        this.d = bool;
        return;
      }
    }
    
    public final Object d()
    {
      return this.e;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.im
 * JD-Core Version:    0.7.0.1
 */
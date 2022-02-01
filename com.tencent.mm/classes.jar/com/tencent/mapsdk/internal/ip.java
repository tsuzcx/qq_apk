package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class ip
  implements Cloneable
{
  private static final is<Integer> d;
  private static final is<Number> e;
  int a;
  Class<?> b;
  in c = null;
  private is f;
  private Object g;
  
  static
  {
    AppMethodBeat.i(223227);
    d = new ik();
    e = new ii();
    AppMethodBeat.o(223227);
  }
  
  private ip(int paramInt)
  {
    this.a = paramInt;
  }
  
  public static ip a(int paramInt, double... paramVarArgs)
  {
    AppMethodBeat.i(223147);
    paramVarArgs = new a(paramInt, paramVarArgs);
    AppMethodBeat.o(223147);
    return paramVarArgs;
  }
  
  public static ip a(int paramInt, int... paramVarArgs)
  {
    AppMethodBeat.i(223140);
    paramVarArgs = new b(paramInt, paramVarArgs);
    AppMethodBeat.o(223140);
    return paramVarArgs;
  }
  
  private static ip a(int paramInt, im... paramVarArgs)
  {
    int n = 0;
    AppMethodBeat.i(223172);
    int i1 = paramVarArgs.length;
    int i = 0;
    int m = 0;
    int k = 0;
    int j = 0;
    if (i < i1)
    {
      if ((paramVarArgs[i] instanceof im.a)) {
        j = 1;
      }
      for (;;)
      {
        i += 1;
        break;
        if ((paramVarArgs[i] instanceof im.b)) {
          k = 1;
        } else {
          m = 1;
        }
      }
    }
    Object localObject;
    if ((j != 0) && (k == 0) && (m == 0))
    {
      localObject = new im.a[i1];
      i = n;
      while (i < i1)
      {
        localObject[i] = ((im.a)paramVarArgs[i]);
        i += 1;
      }
      paramVarArgs = new ij((im.a[])localObject);
    }
    for (;;)
    {
      localObject = new ip(paramInt);
      ((ip)localObject).c = paramVarArgs;
      AppMethodBeat.o(223172);
      return localObject;
      if ((k != 0) && (j == 0) && (m == 0))
      {
        localObject = new im.b[i1];
        i = 0;
        while (i < i1)
        {
          localObject[i] = ((im.b)paramVarArgs[i]);
          i += 1;
        }
        paramVarArgs = new il((im.b[])localObject);
      }
      else
      {
        paramVarArgs = new in(paramVarArgs);
      }
    }
  }
  
  public static ip a(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(223156);
    ip localip = new ip(paramInt);
    localip.a(paramVarArgs);
    localip.a(null);
    AppMethodBeat.o(223156);
    return localip;
  }
  
  private void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  private void a(im... paramVarArgs)
  {
    AppMethodBeat.i(223183);
    int j = paramVarArgs.length;
    im[] arrayOfim = new im[Math.max(j, 2)];
    int i = 0;
    while (i < j)
    {
      arrayOfim[i] = paramVarArgs[i];
      i += 1;
    }
    this.c = new in(arrayOfim);
    AppMethodBeat.o(223183);
  }
  
  private void c()
  {
    is localis;
    if (this.f == null)
    {
      if (this.b != Integer.class) {
        break label44;
      }
      localis = d;
    }
    for (;;)
    {
      this.f = localis;
      if (this.f != null) {
        this.c.f = this.f;
      }
      return;
      label44:
      if (this.b == Double.class) {
        localis = e;
      } else {
        localis = null;
      }
    }
  }
  
  private int d()
  {
    return this.a;
  }
  
  public ip a()
  {
    AppMethodBeat.i(223273);
    try
    {
      ip localip = (ip)super.clone();
      localip.a = this.a;
      localip.c = this.c.a();
      localip.f = this.f;
      AppMethodBeat.o(223273);
      return localip;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      AppMethodBeat.o(223273);
    }
    return null;
  }
  
  void a(float paramFloat)
  {
    AppMethodBeat.i(223295);
    this.g = this.c.a(paramFloat);
    AppMethodBeat.o(223295);
  }
  
  void a(ib paramib)
  {
    AppMethodBeat.i(223281);
    if (paramib != null) {
      paramib.a(this.a, b());
    }
    AppMethodBeat.o(223281);
  }
  
  public final void a(is paramis)
  {
    this.f = paramis;
    this.c.f = paramis;
  }
  
  public void a(double... paramVarArgs)
  {
    int i = 1;
    AppMethodBeat.i(223254);
    this.b = Double.TYPE;
    int j = paramVarArgs.length;
    im.a[] arrayOfa = new im.a[Math.max(j, 2)];
    if (j == 1)
    {
      arrayOfa[0] = ((im.a)new im.a());
      arrayOfa[1] = ((im.a)im.a(1.0F, paramVarArgs[0]));
    }
    for (;;)
    {
      this.c = new ij(arrayOfa);
      AppMethodBeat.o(223254);
      return;
      arrayOfa[0] = ((im.a)im.a(0.0F, paramVarArgs[0]));
      while (i < j)
      {
        arrayOfa[i] = ((im.a)im.a(i / (j - 1), paramVarArgs[i]));
        i += 1;
      }
    }
  }
  
  public void a(int... paramVarArgs)
  {
    int i = 1;
    AppMethodBeat.i(223239);
    this.b = Integer.TYPE;
    int j = paramVarArgs.length;
    im.b[] arrayOfb = new im.b[Math.max(j, 2)];
    if (j == 1)
    {
      arrayOfb[0] = ((im.b)new im.b());
      arrayOfb[1] = ((im.b)im.a(1.0F, paramVarArgs[0]));
    }
    for (;;)
    {
      this.c = new il(arrayOfb);
      AppMethodBeat.o(223239);
      return;
      arrayOfb[0] = ((im.b)im.a(0.0F, paramVarArgs[0]));
      while (i < j)
      {
        arrayOfb[i] = ((im.b)im.a(i / (j - 1), paramVarArgs[i]));
        i += 1;
      }
    }
  }
  
  public final void a(Object... paramVarArgs)
  {
    AppMethodBeat.i(223264);
    this.b = paramVarArgs[0].getClass();
    this.c = in.a(paramVarArgs);
    AppMethodBeat.o(223264);
  }
  
  Object b()
  {
    return this.g;
  }
  
  public String toString()
  {
    AppMethodBeat.i(223308);
    String str = this.a + ": " + this.c.toString();
    AppMethodBeat.o(223308);
    return str;
  }
  
  static final class a
    extends ip
  {
    ij d;
    double e;
    
    private a(int paramInt, ij paramij)
    {
      super((byte)0);
      AppMethodBeat.i(222842);
      this.b = Float.TYPE;
      this.c = paramij;
      this.d = ((ij)this.c);
      AppMethodBeat.o(222842);
    }
    
    public a(int paramInt, double... paramVarArgs)
    {
      super((byte)0);
      AppMethodBeat.i(222853);
      a(paramVarArgs);
      AppMethodBeat.o(222853);
    }
    
    private a c()
    {
      AppMethodBeat.i(222860);
      a locala = (a)super.a();
      locala.d = ((ij)locala.c);
      AppMethodBeat.o(222860);
      return locala;
    }
    
    final void a(float paramFloat)
    {
      AppMethodBeat.i(222874);
      this.e = this.d.b(paramFloat);
      AppMethodBeat.o(222874);
    }
    
    final void a(ib paramib)
    {
      AppMethodBeat.i(222889);
      if (paramib != null) {
        paramib.a(this.a, Double.valueOf(this.e));
      }
      AppMethodBeat.o(222889);
    }
    
    public final void a(double... paramVarArgs)
    {
      AppMethodBeat.i(222868);
      super.a(paramVarArgs);
      this.d = ((ij)this.c);
      AppMethodBeat.o(222868);
    }
    
    final Object b()
    {
      AppMethodBeat.i(222880);
      double d1 = this.e;
      AppMethodBeat.o(222880);
      return Double.valueOf(d1);
    }
  }
  
  static final class b
    extends ip
  {
    il d;
    int e;
    
    private b(int paramInt, il paramil)
    {
      super((byte)0);
      AppMethodBeat.i(222871);
      this.b = Integer.TYPE;
      this.c = paramil;
      this.d = ((il)this.c);
      AppMethodBeat.o(222871);
    }
    
    public b(int paramInt, int... paramVarArgs)
    {
      super((byte)0);
      AppMethodBeat.i(222876);
      a(paramVarArgs);
      AppMethodBeat.o(222876);
    }
    
    private b c()
    {
      AppMethodBeat.i(222885);
      b localb = (b)super.a();
      localb.d = ((il)localb.c);
      AppMethodBeat.o(222885);
      return localb;
    }
    
    final void a(float paramFloat)
    {
      AppMethodBeat.i(222900);
      this.e = this.d.b(paramFloat);
      AppMethodBeat.o(222900);
    }
    
    final void a(ib paramib)
    {
      AppMethodBeat.i(222918);
      if (paramib != null) {
        paramib.a(this.a, Integer.valueOf(this.e));
      }
      AppMethodBeat.o(222918);
    }
    
    public final void a(int... paramVarArgs)
    {
      AppMethodBeat.i(222892);
      super.a(paramVarArgs);
      this.d = ((il)this.c);
      AppMethodBeat.o(222892);
    }
    
    final Object b()
    {
      AppMethodBeat.i(222912);
      int i = this.e;
      AppMethodBeat.o(222912);
      return Integer.valueOf(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ip
 * JD-Core Version:    0.7.0.1
 */
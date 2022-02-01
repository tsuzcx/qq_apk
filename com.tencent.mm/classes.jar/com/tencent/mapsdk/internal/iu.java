package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class iu
{
  public static final iu F;
  public static final iu G;
  public static final iu H;
  public static final int i = 1;
  public static final int j = 2;
  public static final int k = 3;
  public static final int l = 4;
  public static final int m = 5;
  public static final int n = 6;
  public static final int o = 100;
  public static final int p = 101;
  public static final int q = 102;
  public static final int r = 103;
  public static final int s = 104;
  public static final int t = 105;
  public static final int u = 10000;
  public static final int v = 108;
  public static final int w = 109;
  public static final int x = 110;
  public static final int y = 120;
  public double[] A;
  public long B = -1L;
  public boolean C = false;
  public boolean D;
  public Runnable E;
  private id a;
  public int z;
  
  static
  {
    AppMethodBeat.i(223104);
    F = new iu(1, null);
    G = new iu(2, null, true);
    H = new iu(104, null);
    AppMethodBeat.o(223104);
  }
  
  public iu() {}
  
  public iu(int paramInt, double[] paramArrayOfDouble)
  {
    this(paramInt, paramArrayOfDouble, false);
  }
  
  public iu(int paramInt, double[] paramArrayOfDouble, boolean paramBoolean)
  {
    this.z = paramInt;
    this.A = paramArrayOfDouble;
    this.D = paramBoolean;
  }
  
  public iu(Runnable paramRunnable)
  {
    this.z = 6;
    this.E = paramRunnable;
  }
  
  private void a(id paramid)
  {
    this.a = paramid;
  }
  
  private long c()
  {
    long l1 = 0L;
    if (this.B >= 0L) {
      l1 = this.B;
    }
    while (this.z < 100) {
      return l1;
    }
    return 20L;
  }
  
  private static void d() {}
  
  protected boolean a()
  {
    return true;
  }
  
  public boolean a(ix paramix)
  {
    AppMethodBeat.i(223114);
    boolean bool = a();
    paramix.c(this);
    AppMethodBeat.o(223114);
    return bool;
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.iu
 * JD-Core Version:    0.7.0.1
 */
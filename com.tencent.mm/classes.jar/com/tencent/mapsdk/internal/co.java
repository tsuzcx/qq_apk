package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public final class co
  implements Serializable
{
  public static final int a = 0;
  public static final co b;
  public static final int c = 1;
  public static final co d;
  public static final int e = 2;
  public static final co f;
  public static final int g = 3;
  public static final co h;
  public static final int i = 4;
  public static final co j;
  public static final int k = 5;
  public static final co l;
  public static final int m = 6;
  public static final co n;
  public static final int o = 7;
  public static final co p;
  private static co[] r;
  private int s;
  private String t;
  
  static
  {
    AppMethodBeat.i(222628);
    if (!co.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      q = bool;
      r = new co[8];
      b = new co(0, 0, "RST_SUCC");
      d = new co(1, 1, "RST_DECODE_FAIL");
      f = new co(2, 2, "RST_SYS_ERR");
      h = new co(3, 3, "RST_INVALID_USER");
      j = new co(4, 4, "RST_USE_INVALID_KEY");
      l = new co(5, 5, "RST_INVALID_UIN");
      n = new co(6, 6, "RST_INVALID_CMD");
      p = new co(7, 7, "RST_PACKAGE_ERR");
      AppMethodBeat.o(222628);
      return;
    }
  }
  
  private co(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(222618);
    this.t = new String();
    this.t = paramString;
    this.s = paramInt2;
    r[paramInt1] = this;
    AppMethodBeat.o(222618);
  }
  
  private int a()
  {
    return this.s;
  }
  
  private static co a(int paramInt)
  {
    AppMethodBeat.i(222592);
    int i1 = 0;
    Object localObject;
    while (i1 < r.length)
    {
      if (r[i1].s == paramInt)
      {
        localObject = r[i1];
        AppMethodBeat.o(222592);
        return localObject;
      }
      i1 += 1;
    }
    if (!q)
    {
      localObject = new AssertionError();
      AppMethodBeat.o(222592);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(222592);
    return null;
  }
  
  private static co a(String paramString)
  {
    AppMethodBeat.i(222606);
    int i1 = 0;
    while (i1 < r.length)
    {
      if (r[i1].toString().equals(paramString))
      {
        paramString = r[i1];
        AppMethodBeat.o(222606);
        return paramString;
      }
      i1 += 1;
    }
    if (!q)
    {
      paramString = new AssertionError();
      AppMethodBeat.o(222606);
      throw paramString;
    }
    AppMethodBeat.o(222606);
    return null;
  }
  
  public final String toString()
  {
    return this.t;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mapsdk.internal.co
 * JD-Core Version:    0.7.0.1
 */
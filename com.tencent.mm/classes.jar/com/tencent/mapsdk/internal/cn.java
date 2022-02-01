package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public final class cn
  implements Serializable
{
  public static final int a = 29;
  public static final int b = 1;
  public static final int c = 8;
  public static final cn d;
  private static cn[] f;
  private int g;
  private String h;
  
  static
  {
    AppMethodBeat.i(222655);
    if (!cn.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      e = bool;
      f = new cn[28];
      d = new cn("REQ_CONFIG");
      AppMethodBeat.o(222655);
      return;
    }
  }
  
  private cn(String paramString)
  {
    AppMethodBeat.i(222649);
    this.h = new String();
    this.h = paramString;
    this.g = 29;
    f[26] = this;
    AppMethodBeat.o(222649);
  }
  
  private int a()
  {
    return this.g;
  }
  
  private static cn a(int paramInt)
  {
    AppMethodBeat.i(222627);
    int i = 0;
    Object localObject;
    while (i < f.length)
    {
      if (f[i].g == paramInt)
      {
        localObject = f[i];
        AppMethodBeat.o(222627);
        return localObject;
      }
      i += 1;
    }
    if (!e)
    {
      localObject = new AssertionError();
      AppMethodBeat.o(222627);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(222627);
    return null;
  }
  
  private static cn a(String paramString)
  {
    AppMethodBeat.i(222634);
    int i = 0;
    while (i < f.length)
    {
      if (f[i].toString().equals(paramString))
      {
        paramString = f[i];
        AppMethodBeat.o(222634);
        return paramString;
      }
      i += 1;
    }
    if (!e)
    {
      paramString = new AssertionError();
      AppMethodBeat.o(222634);
      throw paramString;
    }
    AppMethodBeat.o(222634);
    return null;
  }
  
  public final String toString()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mapsdk.internal.cn
 * JD-Core Version:    0.7.0.1
 */
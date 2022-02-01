package com.tencent.mm.plugin.appbrand.u.a;

import com.tencent.mm.ab.g;
import com.tencent.mm.ab.i;

public abstract class b
  implements a
{
  public final String a(String paramString, c paramc)
  {
    try
    {
      paramString = new i(paramString);
      a(paramString, paramc);
      return null;
    }
    catch (g paramString) {}
    return paramc.bPU();
  }
  
  protected abstract void a(i parami, c paramc);
  
  public static abstract interface a
  {
    public abstract void ap(int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.a.b
 * JD-Core Version:    0.7.0.1
 */
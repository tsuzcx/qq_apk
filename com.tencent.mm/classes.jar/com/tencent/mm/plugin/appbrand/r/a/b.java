package com.tencent.mm.plugin.appbrand.r.a;

import com.tencent.mm.ac.g;
import com.tencent.mm.ac.i;

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
    return paramc.biI();
  }
  
  protected abstract void a(i parami, c paramc);
  
  public static abstract interface a
  {
    public abstract void ak(int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r.a.b
 * JD-Core Version:    0.7.0.1
 */
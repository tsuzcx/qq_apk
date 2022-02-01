package com.tencent.mm.plugin.appbrand.v.a;

import com.tencent.mm.ad.g;
import com.tencent.mm.ad.i;

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
    return paramc.Cz(2);
  }
  
  protected abstract void a(i parami, c paramc);
  
  public static abstract interface a
  {
    public abstract void aC(int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.v.a.b
 * JD-Core Version:    0.7.0.1
 */
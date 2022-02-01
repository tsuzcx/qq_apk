package com.tencent.mm.plugin.appbrand.u.a;

import com.tencent.mm.ad.g;
import com.tencent.mm.ad.i;

public abstract class d
  implements a
{
  public final String a(String paramString, c paramc)
  {
    try
    {
      paramString = new i(paramString);
      return b(paramString, paramc);
    }
    catch (g paramString) {}
    return paramc.Ck(2);
  }
  
  protected abstract String b(i parami, c paramc);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.a.d
 * JD-Core Version:    0.7.0.1
 */
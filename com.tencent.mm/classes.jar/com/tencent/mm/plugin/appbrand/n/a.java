package com.tencent.mm.plugin.appbrand.n;

import com.tencent.mm.ah.a.a;
import com.tencent.mm.protocal.c.bly;
import java.util.Locale;

public final class a
{
  public static boolean a(int paramInt1, int paramInt2, bly parambly)
  {
    return (paramInt1 == 0) && (paramInt2 == 0) && (parambly != null);
  }
  
  public static boolean b(a.a<?> parama)
  {
    return (parama != null) && (a(parama.errType, parama.errCode, parama.ecw));
  }
  
  public static String c(a.a parama)
  {
    if (parama == null) {
      return "null";
    }
    return String.format(Locale.US, "%d %d %s", new Object[] { Integer.valueOf(parama.errType), Integer.valueOf(parama.errCode), parama.aox });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.a
 * JD-Core Version:    0.7.0.1
 */
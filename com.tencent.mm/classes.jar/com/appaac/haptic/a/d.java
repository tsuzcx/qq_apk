package com.appaac.haptic.a;

import android.content.Context;

public abstract class d
{
  private static d cqP = null;
  
  public static d aF(Context paramContext)
  {
    if (cqP == null) {}
    try
    {
      if (cqP == null) {
        cqP = new e(paramContext);
      }
      return cqP;
    }
    finally {}
  }
  
  public abstract void Nq();
  
  public abstract int aW(String paramString);
  
  public abstract void f(String paramString, int paramInt1, int paramInt2);
  
  public abstract void g(String paramString, int paramInt1, int paramInt2);
  
  public abstract void h(String paramString, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.appaac.haptic.a.d
 * JD-Core Version:    0.7.0.1
 */
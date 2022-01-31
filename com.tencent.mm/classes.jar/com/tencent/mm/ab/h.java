package com.tencent.mm.ab;

import org.json.JSONObject;

public final class h
{
  private static volatile int dJi = 0;
  private static volatile boolean dJj = false;
  private static e dJk;
  
  public static c CH()
  {
    if (dJi == 1) {
      return new l();
    }
    return new d();
  }
  
  public static a CI()
  {
    if (dJi == 1) {
      return new k();
    }
    return new b();
  }
  
  public static int CJ()
  {
    return dJi;
  }
  
  public static void a(e parame)
  {
    dJk = parame;
  }
  
  public static JSONObject fU(String paramString)
  {
    boolean bool = dJj;
    if (dJi == 1) {
      return new i(paramString);
    }
    return new JSONObject(paramString);
  }
  
  public static c fV(String paramString)
  {
    if (dJi == 1) {
      return new l(paramString);
    }
    return new d(paramString);
  }
  
  public static a fW(String paramString)
  {
    if (dJi == 1) {
      return new k(paramString);
    }
    return new b(paramString);
  }
  
  public static void ht(int paramInt)
  {
    dJi = paramInt;
    dJj = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ab.h
 * JD-Core Version:    0.7.0.1
 */
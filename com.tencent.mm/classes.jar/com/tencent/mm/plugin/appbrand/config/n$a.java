package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.sdk.platformtools.bk;

public final class n$a
{
  public static void A(String paramString, int paramInt1, int paramInt2)
  {
    if (e.aaY() == null) {
      return;
    }
    e.aaY().bi(aC(paramString, paramInt1), String.valueOf(paramInt2));
  }
  
  public static void B(String paramString, int paramInt1, int paramInt2)
  {
    if (e.aaY() == null) {
      return;
    }
    e.aaY().bi(aD(paramString, paramInt1), String.valueOf(paramInt2));
  }
  
  private static String aC(String paramString, int paramInt)
  {
    return String.format("%s_%s_local_version", new Object[] { paramString, Integer.valueOf(paramInt) });
  }
  
  public static String aD(String paramString, int paramInt)
  {
    return String.format("%s_%s_server_version", new Object[] { paramString, Integer.valueOf(paramInt) });
  }
  
  private static String aE(String paramString, int paramInt)
  {
    return String.format("%s_%s_config", new Object[] { paramString, Integer.valueOf(paramInt) });
  }
  
  public static int aF(String paramString, int paramInt)
  {
    if (e.aaY() == null) {
      return 0;
    }
    return bk.getInt(e.aaY().get(aC(paramString, paramInt), "0"), 0);
  }
  
  public static String aG(String paramString, int paramInt)
  {
    if (e.aaY() == null) {
      return "";
    }
    return e.aaY().get(aE(paramString, paramInt), "");
  }
  
  public static void h(String paramString1, int paramInt, String paramString2)
  {
    if (e.aaY() == null) {
      return;
    }
    e.aaY().bi(aE(paramString1, paramInt), paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.n.a
 * JD-Core Version:    0.7.0.1
 */
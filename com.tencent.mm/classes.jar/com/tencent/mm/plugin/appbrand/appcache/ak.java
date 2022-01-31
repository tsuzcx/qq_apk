package com.tencent.mm.plugin.appbrand.appcache;

import android.annotation.SuppressLint;
import com.tencent.mm.plugin.appbrand.appcache.a.a;

@SuppressLint({"DefaultLocale"})
public class ak
  extends a
{
  ak(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    this(String.format("WxaPkg_%s_%d", new Object[] { paramString1, Integer.valueOf(paramInt2) }), ah(paramString1, paramInt2), paramString2, paramString1, paramInt2, paramInt1);
  }
  
  private ak(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2)
  {
    super(paramString1, paramString2, paramString3, paramString4, paramInt1, paramInt2);
  }
  
  public static String ah(String paramString, int paramInt)
  {
    String str = aj.abZ();
    return str + String.format("_%d_%d.wxapkg", new Object[] { Integer.valueOf(paramString.hashCode()), Integer.valueOf(paramInt) });
  }
  
  static String rc(String paramString)
  {
    String str = aj.abZ();
    return str + String.format("_%s.wxapkg", new Object[] { paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ak
 * JD-Core Version:    0.7.0.1
 */
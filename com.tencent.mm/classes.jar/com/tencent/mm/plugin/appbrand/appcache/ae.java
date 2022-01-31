package com.tencent.mm.plugin.appbrand.appcache;

import android.annotation.SuppressLint;
import com.tencent.mm.plugin.appbrand.appcache.a.a;

@SuppressLint({"DefaultLocale"})
class ae
  extends a
{
  ae(String paramString1, String paramString2, int paramInt)
  {
    super(str1, str2 + String.format("debug_%d_%d_%d.wxapkg", new Object[] { Integer.valueOf(paramString1.hashCode()), Integer.valueOf(paramInt), Integer.valueOf(paramString2.hashCode()) }), paramString2, paramString1, String.format("%d-%s", new Object[] { Integer.valueOf(paramInt), paramString2 }).hashCode(), paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ae
 * JD-Core Version:    0.7.0.1
 */
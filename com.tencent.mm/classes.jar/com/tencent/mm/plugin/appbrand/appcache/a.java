package com.tencent.mm.plugin.appbrand.appcache;

import android.content.res.Resources;
import android.util.SparseIntArray;
import com.tencent.mm.plugin.appbrand.appstorage.i;
import com.tencent.mm.plugin.appbrand.f.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;

public final class a
{
  private static final SparseIntArray fBP;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray(3);
    fBP = localSparseIntArray;
    localSparseIntArray.put(0, a.a.app_empty_string);
    fBP.put(1, a.a.app_brand_app_debug_type_testing);
    fBP.put(2, a.a.app_brand_app_debug_type_previewing);
  }
  
  public static String kp(int paramInt)
  {
    paramInt = fBP.get(paramInt, a.a.app_empty_string);
    return ae.getResources().getString(paramInt);
  }
  
  public static String qQ(String paramString)
  {
    if (bk.bl(paramString)) {
      return paramString;
    }
    int i = 0;
    while ((i < paramString.length()) && ('/' == paramString.charAt(i))) {
      i += 1;
    }
    return paramString.substring(i);
  }
  
  public static String qR(String paramString)
  {
    return i.rA(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.a
 * JD-Core Version:    0.7.0.1
 */
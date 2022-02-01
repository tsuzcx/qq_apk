package com.tencent.mm.plugin.appbrand.appcache;

import android.content.res.Resources;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class e
{
  private static final SparseIntArray nDY;
  
  static
  {
    AppMethodBeat.i(44236);
    SparseIntArray localSparseIntArray = new SparseIntArray(3);
    nDY = localSparseIntArray;
    localSparseIntArray.put(0, au.i.app_empty_string);
    nDY.put(1, au.i.app_brand_app_debug_type_testing);
    nDY.put(2, au.i.app_brand_app_debug_type_previewing);
    AppMethodBeat.o(44236);
  }
  
  public static String acA(String paramString)
  {
    AppMethodBeat.i(265287);
    String str = LaunchParcel.adT(paramString);
    paramString = str;
    if (str.endsWith("/")) {
      paramString = str.substring(0, str.length() - 1);
    }
    AppMethodBeat.o(265287);
    return paramString;
  }
  
  public static String acz(String paramString)
  {
    AppMethodBeat.i(44235);
    paramString = LaunchParcel.adT(paramString);
    AppMethodBeat.o(44235);
    return paramString;
  }
  
  public static String yZ(int paramInt)
  {
    AppMethodBeat.i(44234);
    paramInt = nDY.get(paramInt, au.i.app_empty_string);
    String str = MMApplicationContext.getResources().getString(paramInt);
    AppMethodBeat.o(44234);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.e
 * JD-Core Version:    0.7.0.1
 */
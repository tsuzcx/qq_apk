package com.tencent.mm.plugin.appbrand.appcache;

import android.content.res.Resources;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class e
{
  private static final SparseIntArray qDT;
  
  static
  {
    AppMethodBeat.i(44236);
    SparseIntArray localSparseIntArray = new SparseIntArray(3);
    qDT = localSparseIntArray;
    localSparseIntArray.put(0, ba.i.app_empty_string);
    qDT.put(1, ba.i.app_brand_app_debug_type_testing);
    qDT.put(2, ba.i.app_brand_app_debug_type_previewing);
    AppMethodBeat.o(44236);
  }
  
  public static String UZ(String paramString)
  {
    AppMethodBeat.i(320288);
    String str = LaunchParcel.Wu(paramString);
    paramString = str;
    if (str.endsWith("/")) {
      paramString = str.substring(0, str.length() - 1);
    }
    AppMethodBeat.o(320288);
    return paramString;
  }
  
  public static String zm(int paramInt)
  {
    AppMethodBeat.i(44234);
    paramInt = qDT.get(paramInt, ba.i.app_empty_string);
    String str = MMApplicationContext.getResources().getString(paramInt);
    AppMethodBeat.o(44234);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.e
 * JD-Core Version:    0.7.0.1
 */
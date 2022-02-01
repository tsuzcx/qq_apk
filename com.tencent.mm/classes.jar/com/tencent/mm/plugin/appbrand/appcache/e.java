package com.tencent.mm.plugin.appbrand.appcache;

import android.content.res.Resources;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.sdk.platformtools.aj;

public final class e
{
  private static final SparseIntArray iLp;
  
  static
  {
    AppMethodBeat.i(44236);
    SparseIntArray localSparseIntArray = new SparseIntArray(3);
    iLp = localSparseIntArray;
    localSparseIntArray.put(0, 2131755726);
    iLp.put(1, 2131755316);
    iLp.put(2, 2131755315);
    AppMethodBeat.o(44236);
  }
  
  public static String DK(String paramString)
  {
    AppMethodBeat.i(44235);
    paramString = LaunchParcel.EW(paramString);
    AppMethodBeat.o(44235);
    return paramString;
  }
  
  public static String DL(String paramString)
  {
    AppMethodBeat.i(195616);
    String str = LaunchParcel.EW(paramString);
    paramString = str;
    if (str.endsWith("/")) {
      paramString = str.substring(0, str.length() - 1);
    }
    AppMethodBeat.o(195616);
    return paramString;
  }
  
  public static String qC(int paramInt)
  {
    AppMethodBeat.i(44234);
    paramInt = iLp.get(paramInt, 2131755726);
    String str = aj.getResources().getString(paramInt);
    AppMethodBeat.o(44234);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.e
 * JD-Core Version:    0.7.0.1
 */
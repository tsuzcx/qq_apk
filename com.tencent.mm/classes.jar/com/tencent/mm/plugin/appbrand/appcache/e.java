package com.tencent.mm.plugin.appbrand.appcache;

import android.content.res.Resources;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.sdk.platformtools.ak;

public final class e
{
  private static final SparseIntArray jIl;
  
  static
  {
    AppMethodBeat.i(44236);
    SparseIntArray localSparseIntArray = new SparseIntArray(3);
    jIl = localSparseIntArray;
    localSparseIntArray.put(0, 2131755726);
    jIl.put(1, 2131755316);
    jIl.put(2, 2131755315);
    AppMethodBeat.o(44236);
  }
  
  public static String LG(String paramString)
  {
    AppMethodBeat.i(44235);
    paramString = LaunchParcel.MW(paramString);
    AppMethodBeat.o(44235);
    return paramString;
  }
  
  public static String LH(String paramString)
  {
    AppMethodBeat.i(222125);
    String str = LaunchParcel.MW(paramString);
    paramString = str;
    if (str.endsWith("/")) {
      paramString = str.substring(0, str.length() - 1);
    }
    AppMethodBeat.o(222125);
    return paramString;
  }
  
  public static String rS(int paramInt)
  {
    AppMethodBeat.i(44234);
    paramInt = jIl.get(paramInt, 2131755726);
    String str = ak.getResources().getString(paramInt);
    AppMethodBeat.o(44234);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.e
 * JD-Core Version:    0.7.0.1
 */
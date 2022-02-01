package com.tencent.mm.plugin.appbrand.appcache;

import android.content.res.Resources;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class e
{
  private static final SparseIntArray kKh;
  
  static
  {
    AppMethodBeat.i(44236);
    SparseIntArray localSparseIntArray = new SparseIntArray(3);
    kKh = localSparseIntArray;
    localSparseIntArray.put(0, 2131755797);
    kKh.put(1, 2131755352);
    kKh.put(2, 2131755351);
    AppMethodBeat.o(44236);
  }
  
  public static String UP(String paramString)
  {
    AppMethodBeat.i(44235);
    paramString = LaunchParcel.Wf(paramString);
    AppMethodBeat.o(44235);
    return paramString;
  }
  
  public static String UQ(String paramString)
  {
    AppMethodBeat.i(226349);
    String str = LaunchParcel.Wf(paramString);
    paramString = str;
    if (str.endsWith("/")) {
      paramString = str.substring(0, str.length() - 1);
    }
    AppMethodBeat.o(226349);
    return paramString;
  }
  
  public static String vO(int paramInt)
  {
    AppMethodBeat.i(44234);
    paramInt = kKh.get(paramInt, 2131755797);
    String str = MMApplicationContext.getResources().getString(paramInt);
    AppMethodBeat.o(44234);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.e
 * JD-Core Version:    0.7.0.1
 */
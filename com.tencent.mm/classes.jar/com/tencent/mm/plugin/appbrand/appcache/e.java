package com.tencent.mm.plugin.appbrand.appcache;

import android.content.res.Resources;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.sdk.platformtools.ai;

public final class e
{
  private static final SparseIntArray jlw;
  
  static
  {
    AppMethodBeat.i(44236);
    SparseIntArray localSparseIntArray = new SparseIntArray(3);
    jlw = localSparseIntArray;
    localSparseIntArray.put(0, 2131755726);
    jlw.put(1, 2131755316);
    jlw.put(2, 2131755315);
    AppMethodBeat.o(44236);
  }
  
  public static String HO(String paramString)
  {
    AppMethodBeat.i(44235);
    paramString = LaunchParcel.IZ(paramString);
    AppMethodBeat.o(44235);
    return paramString;
  }
  
  public static String rp(int paramInt)
  {
    AppMethodBeat.i(44234);
    paramInt = jlw.get(paramInt, 2131755726);
    String str = ai.getResources().getString(paramInt);
    AppMethodBeat.o(44234);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.e
 * JD-Core Version:    0.7.0.1
 */
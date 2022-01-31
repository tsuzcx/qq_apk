package com.tencent.mm.plugin.appbrand.appcache;

import android.content.res.Resources;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.sdk.platformtools.ah;

public final class b
{
  private static final SparseIntArray gTN;
  
  static
  {
    AppMethodBeat.i(129321);
    SparseIntArray localSparseIntArray = new SparseIntArray(3);
    gTN = localSparseIntArray;
    localSparseIntArray.put(0, 2131296919);
    gTN.put(1, 2131296570);
    gTN.put(2, 2131296569);
    AppMethodBeat.o(129321);
  }
  
  public static String nj(int paramInt)
  {
    AppMethodBeat.i(129319);
    paramInt = gTN.get(paramInt, 2131296919);
    String str = ah.getResources().getString(paramInt);
    AppMethodBeat.o(129319);
    return str;
  }
  
  public static String ym(String paramString)
  {
    AppMethodBeat.i(129320);
    paramString = LaunchParcel.Dq(paramString);
    AppMethodBeat.o(129320);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b
 * JD-Core Version:    0.7.0.1
 */
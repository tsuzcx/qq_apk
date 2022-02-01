package com.tencent.luggage.sdk.launching;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public enum b
{
  static
  {
    AppMethodBeat.i(240531);
    cBe = new b("LEGACY", 0);
    cBf = new b("PRE_RENDER", 1);
    cBg = new b[] { cBe, cBf };
    AppMethodBeat.o(240531);
  }
  
  private b() {}
  
  public static void a(b paramb, Parcel paramParcel)
  {
    AppMethodBeat.i(240524);
    paramParcel.writeInt(paramb.ordinal());
    AppMethodBeat.o(240524);
  }
  
  public static b b(Parcel paramParcel)
  {
    AppMethodBeat.i(240528);
    int j = paramParcel.readInt();
    paramParcel = values();
    int k = paramParcel.length;
    int i = 0;
    while (i < k)
    {
      b localb = paramParcel[i];
      if (j == localb.ordinal())
      {
        AppMethodBeat.o(240528);
        return localb;
      }
      i += 1;
    }
    Log.e("Luggage.WxaColdStartMode", "readFromParcel get unrecognized ordinal %d", new Object[] { Integer.valueOf(j) });
    paramParcel = cBe;
    AppMethodBeat.o(240528);
    return paramParcel;
  }
  
  public final long RJ()
  {
    AppMethodBeat.i(240521);
    long l = ordinal();
    AppMethodBeat.o(240521);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.sdk.launching.b
 * JD-Core Version:    0.7.0.1
 */
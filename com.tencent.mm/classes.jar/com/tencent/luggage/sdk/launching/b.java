package com.tencent.luggage.sdk.launching;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public enum b
{
  static
  {
    AppMethodBeat.i(229869);
    cBB = new b("LEGACY", 0);
    cBC = new b("PRE_RENDER", 1);
    cBD = new b[] { cBB, cBC };
    AppMethodBeat.o(229869);
  }
  
  private b() {}
  
  public static void a(b paramb, Parcel paramParcel)
  {
    AppMethodBeat.i(229867);
    paramParcel.writeInt(paramb.ordinal());
    AppMethodBeat.o(229867);
  }
  
  public static b b(Parcel paramParcel)
  {
    AppMethodBeat.i(229868);
    int j = paramParcel.readInt();
    paramParcel = values();
    int k = paramParcel.length;
    int i = 0;
    while (i < k)
    {
      b localb = paramParcel[i];
      if (j == localb.ordinal())
      {
        AppMethodBeat.o(229868);
        return localb;
      }
      i += 1;
    }
    Log.e("Luggage.WxaColdStartMode", "readFromParcel get unrecognized ordinal %d", new Object[] { Integer.valueOf(j) });
    paramParcel = cBB;
    AppMethodBeat.o(229868);
    return paramParcel;
  }
  
  public final long OC()
  {
    AppMethodBeat.i(229866);
    long l = ordinal();
    AppMethodBeat.o(229866);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.sdk.launching.b
 * JD-Core Version:    0.7.0.1
 */
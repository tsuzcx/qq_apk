package com.tencent.luggage.sdk.launching;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aeo;
import com.tencent.mm.sdk.platformtools.Log;

public enum e
{
  public final int etL;
  
  static
  {
    AppMethodBeat.i(220548);
    etI = new e("LEGACY", 0, 0);
    etJ = new e("PRE_RENDER", 1, 1);
    etK = new e("HEADLESS", 2, 2);
    etM = new e[] { etI, etJ, etK };
    AppMethodBeat.o(220548);
  }
  
  private e(int paramInt)
  {
    this.etL = paramInt;
  }
  
  public static void a(e parame, Parcel paramParcel)
  {
    AppMethodBeat.i(220534);
    paramParcel.writeInt(parame.ordinal());
    AppMethodBeat.o(220534);
  }
  
  public static e d(Parcel paramParcel)
  {
    AppMethodBeat.i(220542);
    int j = paramParcel.readInt();
    paramParcel = values();
    int k = paramParcel.length;
    int i = 0;
    while (i < k)
    {
      e locale = paramParcel[i];
      if (j == locale.ordinal())
      {
        AppMethodBeat.o(220542);
        return locale;
      }
      i += 1;
    }
    Log.e("Luggage.WxaColdStartMode", "readFromParcel get unrecognized ordinal %d", new Object[] { Integer.valueOf(j) });
    paramParcel = etI;
    AppMethodBeat.o(220542);
    return paramParcel;
  }
  
  public final void a(aeo paramaeo)
  {
    paramaeo.ZmA = false;
    paramaeo.ZmC = 0;
    if (etJ == this) {
      paramaeo.ZmA = true;
    }
    while (etK != this) {
      return;
    }
    paramaeo.ZmC = 1;
  }
  
  public final boolean arX()
  {
    return (this == etJ) || (this == etK);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.sdk.launching.e
 * JD-Core Version:    0.7.0.1
 */
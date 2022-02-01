package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum z
{
  static
  {
    AppMethodBeat.i(323357);
    raV = new z("UNKNOWN", 0);
    raW = new z("TRANSPARENT", 1);
    raX = new z("OPAQUE", 2);
    raY = new z[] { raV, raW, raX };
    AppMethodBeat.o(323357);
  }
  
  private z() {}
  
  public static void b(z paramz, Parcel paramParcel)
  {
    AppMethodBeat.i(323350);
    z localz = paramz;
    if (paramz == null) {
      localz = raV;
    }
    paramParcel.writeInt(localz.ordinal());
    AppMethodBeat.o(323350);
  }
  
  public static z m(Parcel paramParcel)
  {
    AppMethodBeat.i(323354);
    z localz = raV;
    int j = paramParcel.readInt();
    z[] arrayOfz = values();
    int k = arrayOfz.length;
    int i = 0;
    if (i < k)
    {
      paramParcel = arrayOfz[i];
      if (paramParcel.ordinal() != j) {}
    }
    for (;;)
    {
      AppMethodBeat.o(323354);
      return paramParcel;
      i += 1;
      break;
      paramParcel = localz;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.z
 * JD-Core Version:    0.7.0.1
 */
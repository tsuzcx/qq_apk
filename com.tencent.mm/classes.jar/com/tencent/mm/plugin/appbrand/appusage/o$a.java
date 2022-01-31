package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.kernel.g;

final class o$a
  implements i<IPCInteger, Parcel>
{
  private static Parcel a(IPCInteger paramIPCInteger)
  {
    AppMethodBeat.i(129584);
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeTypedList(((ag)g.E(ag.class)).nu(paramIPCInteger.value));
      AppMethodBeat.o(129584);
      return localParcel;
    }
    catch (Exception paramIPCInteger)
    {
      localParcel.setDataPosition(0);
      localParcel.writeTypedList(null);
      AppMethodBeat.o(129584);
    }
    return localParcel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.o.a
 * JD-Core Version:    0.7.0.1
 */
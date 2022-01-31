package com.tencent.mm.modelgeo;

import com.tencent.map.geolocation.internal.LocationLogCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class h$1
  implements LocationLogCallback
{
  h$1(h paramh) {}
  
  public final void onLog(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(151556);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(151556);
      return;
    case 2: 
      ab.v("MicroMsg.SLocationManager", "tag:%s msg:%s", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(151556);
      return;
    case 3: 
      ab.d("MicroMsg.SLocationManager", "tag:%s msg:%s", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(151556);
      return;
    case 4: 
      ab.i("MicroMsg.SLocationManager", "tag:%s msg:%s", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(151556);
      return;
    case 5: 
      ab.w("MicroMsg.SLocationManager", "tag:%s msg:%s", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(151556);
      return;
    }
    if (paramThrowable != null) {}
    for (paramThrowable = paramThrowable.getMessage();; paramThrowable = "")
    {
      ab.e("MicroMsg.SLocationManager", "tag:%s msg:%s th:%s", new Object[] { paramString1, paramString2, paramThrowable });
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelgeo.h.1
 * JD-Core Version:    0.7.0.1
 */
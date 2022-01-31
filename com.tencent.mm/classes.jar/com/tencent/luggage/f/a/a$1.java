package com.tencent.luggage.f.a;

import com.tencent.map.geolocation.internal.LocationLogCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class a$1
  implements LocationLogCallback
{
  a$1(a parama) {}
  
  public final void onLog(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(51134);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(51134);
      return;
    case 2: 
      ab.v("MicroMsg.DefaultTencentLocationManager", "tag:%s msg:%s", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(51134);
      return;
    case 3: 
      ab.d("MicroMsg.DefaultTencentLocationManager", "tag:%s msg:%s", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(51134);
      return;
    case 4: 
      ab.i("MicroMsg.DefaultTencentLocationManager", "tag:%s msg:%s", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(51134);
      return;
    case 5: 
      ab.w("MicroMsg.DefaultTencentLocationManager", "tag:%s msg:%s", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(51134);
      return;
    }
    if (paramThrowable != null) {}
    for (paramThrowable = paramThrowable.getMessage();; paramThrowable = "")
    {
      ab.e("MicroMsg.DefaultTencentLocationManager", "tag:%s msg:%s th:%s", new Object[] { paramString1, paramString2, paramThrowable });
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.f.a.a.1
 * JD-Core Version:    0.7.0.1
 */
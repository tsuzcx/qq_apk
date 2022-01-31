package com.tencent.luggage.f.a;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

final class a$2
  implements TencentLocationListener
{
  a$2(a parama) {}
  
  public final void onLocationChanged(TencentLocation paramTencentLocation, int paramInt, String paramString)
  {
    AppMethodBeat.i(51135);
    ab.v("MicroMsg.DefaultTencentLocationManager", "[mlocationListener]error:%d, reason:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (paramInt != 0) {
      ab.e("MicroMsg.DefaultTencentLocationManager", "[mlocationListener]error:%d, reason:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    }
    if ((a.a(this.bFt) != null) && (a.a(this.bFt).size() > 0))
    {
      a.a(a.a(this.bFt), paramInt, paramString, a.a(paramTencentLocation, false));
      a.a(this.bFt).clear();
    }
    if ((a.b(this.bFt) != null) && (a.b(this.bFt).size() > 0))
    {
      a.a(a.b(this.bFt), paramInt, paramString, a.a(paramTencentLocation, true));
      a.b(this.bFt).clear();
    }
    if ((a.c(this.bFt) != null) && (a.c(this.bFt).size() > 0)) {
      a.a(a.c(this.bFt), paramInt, paramString, a.a(paramTencentLocation, false));
    }
    if ((a.d(this.bFt) != null) && (a.d(this.bFt).size() > 0)) {
      a.a(a.d(this.bFt), paramInt, paramString, a.a(paramTencentLocation, true));
    }
    a.e(this.bFt);
    AppMethodBeat.o(51135);
  }
  
  public final void onStatusUpdate(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(51136);
    ab.i("MicroMsg.DefaultTencentLocationManager", "[mlocationListener]name:%s, status:%d, desc:%s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
    AppMethodBeat.o(51136);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.f.a.a.2
 * JD-Core Version:    0.7.0.1
 */
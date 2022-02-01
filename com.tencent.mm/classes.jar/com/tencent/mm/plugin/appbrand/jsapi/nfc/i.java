package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.e;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.r;
import kotlin.v;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/NFCErrnoMigrationLogic;", "", "()V", "errCode2ErrInfoMap", "", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/errno/AppBrandErrors$ErrorInfo;", "resolveErrInfo", "errCode", "luggage-commons-jsapi-nfc-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  public static final i skJ;
  private static final Map<Integer, a.d> skK;
  
  static
  {
    AppMethodBeat.i(328029);
    skJ = new i();
    skK = ak.e(new r[] { v.Y(Integer.valueOf(0), a.e.rVt), v.Y(Integer.valueOf(13000), a.c.rUO), v.Y(Integer.valueOf(13001), a.c.rUQ), v.Y(Integer.valueOf(13002), a.c.rUP), v.Y(Integer.valueOf(13003), a.e.rVz), v.Y(Integer.valueOf(13004), a.c.rUR), v.Y(Integer.valueOf(13005), a.e.rVz), v.Y(Integer.valueOf(13006), a.c.rUS), v.Y(Integer.valueOf(13007), a.c.rVd), v.Y(Integer.valueOf(13010), a.c.rUN), v.Y(Integer.valueOf(13019), a.c.rUT), v.Y(Integer.valueOf(13011), a.e.rVz), v.Y(Integer.valueOf(13012), a.c.rUU), v.Y(Integer.valueOf(13021), a.c.rUV), v.Y(Integer.valueOf(13018), a.c.rUW), v.Y(Integer.valueOf(13022), a.c.rUX), v.Y(Integer.valueOf(13023), a.c.rUY), v.Y(Integer.valueOf(13013), a.c.rUZ), v.Y(Integer.valueOf(13014), a.c.rVa), v.Y(Integer.valueOf(13015), a.c.rVb), v.Y(Integer.valueOf(13024), a.c.rVc), v.Y(Integer.valueOf(13017), a.c.rVd) });
    AppMethodBeat.o(328029);
  }
  
  public static a.d AT(int paramInt)
  {
    AppMethodBeat.i(328028);
    a.d locald = (a.d)skK.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(328028);
    return locald;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.i
 * JD-Core Version:    0.7.0.1
 */
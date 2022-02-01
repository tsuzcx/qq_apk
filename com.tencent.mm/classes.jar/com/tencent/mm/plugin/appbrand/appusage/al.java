package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appusage/QueryCall;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Lcom/tencent/mm/plugin/appbrand/appusage/QueryParams;", "Landroid/os/Parcel;", "()V", "invoke", "data", "plugin-appbrand-integration_release"})
final class al
  implements k<QueryParams, Parcel>
{
  private static Parcel a(QueryParams paramQueryParams)
  {
    AppMethodBeat.i(50298);
    Parcel localParcel = Parcel.obtain();
    if ((g.aAc()) && (paramQueryParams != null)) {}
    try
    {
      localParcel.writeTypedList(((ag)g.af(ag.class)).a(paramQueryParams.count, paramQueryParams.kWk, paramQueryParams.iOo));
      p.g(localParcel, "Parcel.obtain().apply {\n…}\n            }\n        }");
      AppMethodBeat.o(50298);
      return localParcel;
    }
    catch (Exception paramQueryParams)
    {
      for (;;)
      {
        Log.e("MicroMsg.AppBrandCollectionStorageIPC", "QueryCall, writeTypedList e = ".concat(String.valueOf(paramQueryParams)));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.al
 * JD-Core Version:    0.7.0.1
 */
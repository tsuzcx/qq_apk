package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.m;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appusage/QueryCall;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Lcom/tencent/mm/plugin/appbrand/appusage/QueryParams;", "Landroid/os/Parcel;", "()V", "invoke", "data", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class ak
  implements m<QueryParams, Parcel>
{
  private static Parcel a(QueryParams paramQueryParams)
  {
    AppMethodBeat.i(50298);
    Parcel localParcel = Parcel.obtain();
    s.s(localParcel, "obtain()");
    if ((h.baz()) && (paramQueryParams != null)) {}
    try
    {
      localParcel.writeTypedList(((af)h.ax(af.class)).a(paramQueryParams.count, paramQueryParams.qQm, paramQueryParams.euz));
      AppMethodBeat.o(50298);
      return localParcel;
    }
    catch (Exception paramQueryParams)
    {
      for (;;)
      {
        Log.e("MicroMsg.AppBrandCollectionStorageIPC", s.X("QueryCall, writeTypedList e = ", paramQueryParams));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.ak
 * JD-Core Version:    0.7.0.1
 */
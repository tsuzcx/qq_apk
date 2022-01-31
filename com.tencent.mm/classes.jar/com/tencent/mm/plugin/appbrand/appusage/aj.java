package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Parcel;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.sdk.platformtools.y;

final class aj
  implements i<QueryParams, Parcel>
{
  private static Parcel a(QueryParams paramQueryParams)
  {
    Parcel localParcel = Parcel.obtain();
    if ((com.tencent.mm.kernel.g.DK()) && (paramQueryParams != null)) {}
    try
    {
      localParcel.writeTypedList(((af)com.tencent.mm.kernel.g.r(af.class)).a(paramQueryParams.count, paramQueryParams.fKb));
      a.d.b.g.j(localParcel, "Parcel.obtain().apply {\n…}\n            }\n        }");
      return localParcel;
    }
    catch (Exception paramQueryParams)
    {
      for (;;)
      {
        y.e("MicroMsg.AppBrandCollectionStorageIPC", "QueryCall, writeTypedList e = " + paramQueryParams);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.aj
 * JD-Core Version:    0.7.0.1
 */
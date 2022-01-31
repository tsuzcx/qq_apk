package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.game.preload.d;
import com.tencent.mm.plugin.appbrand.game.preload.d.2;
import com.tencent.mm.plugin.appbrand.game.preload.e;
import com.tencent.mm.plugin.appbrand.m.b.a;
import com.tencent.mm.plugin.appbrand.m.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class o$5
  implements Runnable
{
  o$5(o paramo) {}
  
  public final void run()
  {
    AppMethodBeat.i(128982);
    d locald = d.aAQ();
    JSONArray localJSONArray;
    int i;
    if (locald.hud)
    {
      if (!locald.hasInit)
      {
        ab.e("MicroMsg.WAGamePreloadManager", "hasn't init!");
        AppMethodBeat.o(128982);
        return;
      }
      if (locald.htX != null)
      {
        if (locald.htX.getAppConfig() == null)
        {
          ab.e("MicroMsg.WAGamePreloadManager", "downloadPreloadFiles getAppConfig null!");
          AppMethodBeat.o(128982);
          return;
        }
        localJSONArray = locald.htX.getAppConfig().hgV;
        if (localJSONArray != null)
        {
          e.aAT().de(3000, localJSONArray.length());
          i = 0;
        }
      }
    }
    for (;;)
    {
      JSONObject localJSONObject;
      Object localObject1;
      Object localObject2;
      try
      {
        if (i < localJSONArray.length())
        {
          localJSONObject = localJSONArray.getJSONObject(i);
          if (localJSONObject == null) {
            break label361;
          }
          localObject1 = localJSONObject.optString("url");
          localObject2 = localJSONObject.optString("path");
          if ((bo.isNullOrNil((String)localObject1)) || (bo.isNullOrNil((String)localObject2))) {
            break label361;
          }
          if (locald.hua.zd((String)localObject2) == j.gZA)
          {
            ab.i("MicroMsg.WAGamePreloadManager", "predownload path %s has exists!", new Object[] { localObject2 });
          }
          else
          {
            locald.huc.add(localObject1);
            localObject2 = new d.2(locald, (String)localObject1, (String)localObject2);
            if (locald.htZ.bDs <= 0) {
              ab.i("MicroMsg.WAGamePreloadManager", "maxDownloadConcurrent <= 0 ");
            }
          }
        }
      }
      catch (JSONException localJSONException)
      {
        ab.printErrStackTrace("MicroMsg.WAGamePreloadManager", localJSONException, "", new Object[0]);
      }
      ArrayList localArrayList = locald.htX.getAppConfig().hgW;
      if (localArrayList != null) {
        e.aAT().de(4000, localArrayList.size());
      }
      locald.aAS();
      AppMethodBeat.o(128982);
      return;
      if (!d.a(locald.htZ, (String)localObject1))
      {
        ab.e("MicroMsg.WAGamePreloadManager", "checkDomains error,url:%s", new Object[] { localObject1 });
      }
      else
      {
        localObject1 = new HashMap();
        int j = locald.htZ.hhD;
        locald.htY.a(localJSONObject, 60000, (Map)localObject1, null, j, (b.a)localObject2, d.aAR(), "test");
      }
      label361:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.5
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/BeautySuitDataManager$ReportTools;", "", "()V", "makeBeautyInfoJson", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$a
{
  public static final a CDx;
  
  static
  {
    AppMethodBeat.i(359275);
    CDx = new a();
    AppMethodBeat.o(359275);
  }
  
  public static String ekb()
  {
    AppMethodBeat.i(359270);
    try
    {
      Object localObject1 = aj.CGT;
      localObject1 = (e)aj.business(e.class);
      if (localObject1 != null)
      {
        localObject1 = ((e)localObject1).Eej;
        if ((localObject1 == null) || (((m)localObject1).dUv() != 1)) {}
      }
      for (boolean bool = true;; bool = false)
      {
        localObject1 = new JSONObject();
        Object localObject2 = a.CDv;
        int i = a.eka();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(a.b(i, 0, bool, -1000)).append(";");
        ((StringBuilder)localObject2).append(a.b(i, 2, bool, -1000)).append(";");
        ((StringBuilder)localObject2).append(a.b(i, 8, bool, -1000)).append(";");
        ((StringBuilder)localObject2).append(a.b(i, 14, bool, -1000)).append(";");
        ((StringBuilder)localObject2).append(a.b(i, 5, bool, -1000)).append(";");
        ((StringBuilder)localObject2).append(a.b(i, 19, bool, -1000)).append(";");
        ((StringBuilder)localObject2).append(a.b(i, 18, bool, -1000)).append(";");
        ((StringBuilder)localObject2).append(a.b(i, 15, bool, -1000)).append(";");
        ((StringBuilder)localObject2).append(a.b(i, 11, bool, -1000)).append(";");
        ((StringBuilder)localObject2).append(a.b(i, 12, bool, -1000)).append(";");
        ((StringBuilder)localObject2).append(a.b(i, 13, bool, -1000)).append(";");
        ((StringBuilder)localObject2).append(a.b(i, 16, bool, -1000)).append(";");
        ((StringBuilder)localObject2).append(a.b(i, 17, bool, -1000)).append(";");
        ((StringBuilder)localObject2).append(a.b(i, 10, bool, -1000)).append(";");
        ((StringBuilder)localObject2).append(a.b(i, 6, bool, -1000)).append(";");
        ((StringBuilder)localObject2).append(a.b(i, 7, bool, -1000)).append(";");
        ((StringBuilder)localObject2).append(a.b(i, 9, bool, -1000)).append(";");
        ((StringBuilder)localObject2).append(a.b(i, 3, bool, -1000)).append(";");
        ((StringBuilder)localObject2).append(a.b(i, 21, bool, -1000)).append(";");
        ((StringBuilder)localObject2).append(a.b(i, 20, bool, -1000));
        ((JSONObject)localObject1).put("type", i + 1);
        ((JSONObject)localObject1).put("result", ((StringBuilder)localObject2).toString());
        localObject1 = ((JSONObject)localObject1).toString();
        s.s(localObject1, "beautyJson.toString()");
        localObject1 = n.bV((String)localObject1, ",", ";");
        AppMethodBeat.o(359270);
        return localObject1;
      }
      return "";
    }
    catch (Exception localException)
    {
      Log.e("Finder.BeautySuitDataManager", localException.toString());
      AppMethodBeat.o(359270);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.a.a
 * JD-Core Version:    0.7.0.1
 */
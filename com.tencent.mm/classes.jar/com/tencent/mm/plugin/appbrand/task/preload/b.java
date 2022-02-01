package com.tencent.mm.plugin.appbrand.task.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b
{
  private static volatile b tWZ;
  private static Map<Integer, LinkedList<Map<Integer, Map<Integer, Float>>>> tXa;
  
  static
  {
    AppMethodBeat.i(48502);
    tXa = new HashMap();
    cKk();
    AppMethodBeat.o(48502);
  }
  
  public static b cKj()
  {
    AppMethodBeat.i(48499);
    if (tWZ == null) {}
    try
    {
      if (tWZ == null) {
        tWZ = new b();
      }
      b localb = tWZ;
      AppMethodBeat.o(48499);
      return localb;
    }
    finally
    {
      AppMethodBeat.o(48499);
    }
  }
  
  private static void cKk()
  {
    AppMethodBeat.i(48500);
    Object localObject1 = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.znG, "");
    if (Util.isNullOrNil((String)localObject1))
    {
      Log.e("MicroMsg.Predownload.AppBrandPreloadPredictLevel", "clicfg_preload_miniprogram jsonStr error!");
      AppMethodBeat.o(48500);
      return;
    }
    Log.d("MicroMsg.Predownload.AppBrandPreloadPredictLevel", "generateScenePredictMap jsonStr:%s", new Object[] { localObject1 });
    try
    {
      localObject1 = new JSONArray((String)localObject1);
      int i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        Object localObject2 = new JSONObject(((JSONArray)localObject1).optString(i));
        int k = ((JSONObject)localObject2).optInt("id");
        LinkedList localLinkedList = new LinkedList();
        localObject2 = ((JSONObject)localObject2).optJSONArray("preloadRate");
        int j = 0;
        while (j < ((JSONArray)localObject2).length())
        {
          Object localObject3 = new JSONObject(((JSONArray)localObject2).optString(j));
          int m = ((JSONObject)localObject3).optInt("innerScene");
          float f1 = (float)((JSONObject)localObject3).optDouble("low");
          float f2 = (float)((JSONObject)localObject3).optDouble("middle");
          float f3 = (float)((JSONObject)localObject3).optDouble("high");
          localObject3 = new HashMap();
          HashMap localHashMap = new HashMap();
          localHashMap.put(Integer.valueOf(c.tXb.ordinal()), Float.valueOf(f1));
          localHashMap.put(Integer.valueOf(c.tXc.ordinal()), Float.valueOf(f2));
          localHashMap.put(Integer.valueOf(c.tXd.ordinal()), Float.valueOf(f3));
          ((Map)localObject3).put(Integer.valueOf(m), localHashMap);
          localLinkedList.add(localObject3);
          j += 1;
        }
        tXa.put(Integer.valueOf(k), localLinkedList);
        i += 1;
      }
      Log.d("MicroMsg.Predownload.AppBrandPreloadPredictLevel", "scenePredictMap :%s", new Object[] { tXa.toString() });
      AppMethodBeat.o(48500);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.e("MicroMsg.Predownload.AppBrandPreloadPredictLevel", "generateScenePredictMap json exception:%s", new Object[] { localJSONException });
      tXa.clear();
      tXa = null;
      AppMethodBeat.o(48500);
    }
  }
  
  public static Map<Integer, Float> fO(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(48501);
    if ((tXa == null) || (tXa.size() <= 0))
    {
      Log.e("MicroMsg.Predownload.AppBrandPreloadPredictLevel", "getScenePredictRate map null!");
      AppMethodBeat.o(48501);
      return null;
    }
    Object localObject = (LinkedList)tXa.get(Integer.valueOf(paramInt1));
    if (((LinkedList)localObject).size() > 0)
    {
      paramInt1 = 0;
      while (paramInt1 < ((LinkedList)localObject).size())
      {
        Map localMap = (Map)((LinkedList)localObject).get(paramInt1);
        if (localMap.containsKey(Integer.valueOf(paramInt2)))
        {
          localObject = (Map)localMap.get(Integer.valueOf(paramInt2));
          AppMethodBeat.o(48501);
          return localObject;
        }
        paramInt1 += 1;
      }
    }
    AppMethodBeat.o(48501);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.preload.b
 * JD-Core Version:    0.7.0.1
 */
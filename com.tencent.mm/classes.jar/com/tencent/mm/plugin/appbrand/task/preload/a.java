package com.tencent.mm.plugin.appbrand.task.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  private static volatile a lZb;
  private static Map<Integer, LinkedList<Map<Integer, Map<Integer, Float>>>> lZc;
  
  static
  {
    AppMethodBeat.i(48502);
    lZc = new HashMap();
    buM();
    AppMethodBeat.o(48502);
  }
  
  public static a buL()
  {
    AppMethodBeat.i(48499);
    if (lZb == null) {}
    try
    {
      if (lZb == null) {
        lZb = new a();
      }
      a locala = lZb;
      AppMethodBeat.o(48499);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(48499);
    }
  }
  
  private static void buM()
  {
    AppMethodBeat.i(48500);
    Object localObject1 = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.qaB, "");
    if (bs.isNullOrNil((String)localObject1))
    {
      ac.e("MicroMsg.Predownload.AppBrandPreloadPredictLevel", "clicfg_preload_miniprogram jsonStr error!");
      AppMethodBeat.o(48500);
      return;
    }
    ac.d("MicroMsg.Predownload.AppBrandPreloadPredictLevel", "generateScenePredictMap jsonStr:%s", new Object[] { localObject1 });
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
          localHashMap.put(Integer.valueOf(b.lZd.ordinal()), Float.valueOf(f1));
          localHashMap.put(Integer.valueOf(b.lZe.ordinal()), Float.valueOf(f2));
          localHashMap.put(Integer.valueOf(b.lZf.ordinal()), Float.valueOf(f3));
          ((Map)localObject3).put(Integer.valueOf(m), localHashMap);
          localLinkedList.add(localObject3);
          j += 1;
        }
        lZc.put(Integer.valueOf(k), localLinkedList);
        i += 1;
      }
      ac.d("MicroMsg.Predownload.AppBrandPreloadPredictLevel", "scenePredictMap :%s", new Object[] { lZc.toString() });
      AppMethodBeat.o(48500);
      return;
    }
    catch (JSONException localJSONException)
    {
      ac.e("MicroMsg.Predownload.AppBrandPreloadPredictLevel", "generateScenePredictMap json exception:%s", new Object[] { localJSONException });
      lZc.clear();
      lZc = null;
      AppMethodBeat.o(48500);
    }
  }
  
  public static Map<Integer, Float> eg(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(48501);
    if ((lZc == null) || (lZc.size() <= 0))
    {
      ac.e("MicroMsg.Predownload.AppBrandPreloadPredictLevel", "getScenePredictRate map null!");
      AppMethodBeat.o(48501);
      return null;
    }
    Object localObject = (LinkedList)lZc.get(Integer.valueOf(paramInt1));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.preload.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.task.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  private static volatile a myR;
  private static Map<Integer, LinkedList<Map<Integer, Map<Integer, Float>>>> myS;
  
  static
  {
    AppMethodBeat.i(48502);
    myS = new HashMap();
    byQ();
    AppMethodBeat.o(48502);
  }
  
  public static a byP()
  {
    AppMethodBeat.i(48499);
    if (myR == null) {}
    try
    {
      if (myR == null) {
        myR = new a();
      }
      a locala = myR;
      AppMethodBeat.o(48499);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(48499);
    }
  }
  
  private static void byQ()
  {
    AppMethodBeat.i(48500);
    Object localObject1 = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qFX, "");
    if (bt.isNullOrNil((String)localObject1))
    {
      ad.e("MicroMsg.Predownload.AppBrandPreloadPredictLevel", "clicfg_preload_miniprogram jsonStr error!");
      AppMethodBeat.o(48500);
      return;
    }
    ad.d("MicroMsg.Predownload.AppBrandPreloadPredictLevel", "generateScenePredictMap jsonStr:%s", new Object[] { localObject1 });
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
          localHashMap.put(Integer.valueOf(b.myT.ordinal()), Float.valueOf(f1));
          localHashMap.put(Integer.valueOf(b.myU.ordinal()), Float.valueOf(f2));
          localHashMap.put(Integer.valueOf(b.myV.ordinal()), Float.valueOf(f3));
          ((Map)localObject3).put(Integer.valueOf(m), localHashMap);
          localLinkedList.add(localObject3);
          j += 1;
        }
        myS.put(Integer.valueOf(k), localLinkedList);
        i += 1;
      }
      ad.d("MicroMsg.Predownload.AppBrandPreloadPredictLevel", "scenePredictMap :%s", new Object[] { myS.toString() });
      AppMethodBeat.o(48500);
      return;
    }
    catch (JSONException localJSONException)
    {
      ad.e("MicroMsg.Predownload.AppBrandPreloadPredictLevel", "generateScenePredictMap json exception:%s", new Object[] { localJSONException });
      myS.clear();
      myS = null;
      AppMethodBeat.o(48500);
    }
  }
  
  public static Map<Integer, Float> ei(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(48501);
    if ((myS == null) || (myS.size() <= 0))
    {
      ad.e("MicroMsg.Predownload.AppBrandPreloadPredictLevel", "getScenePredictRate map null!");
      AppMethodBeat.o(48501);
      return null;
    }
    Object localObject = (LinkedList)myS.get(Integer.valueOf(paramInt1));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.preload.a
 * JD-Core Version:    0.7.0.1
 */
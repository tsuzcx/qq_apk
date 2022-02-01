package com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"myNfcAdapter", "Landroid/nfc/NfcAdapter;", "getMyNfcAdapter", "()Landroid/nfc/NfcAdapter;", "map", "", "R", "Lorg/json/JSONArray;", "transform", "Lkotlin/Function1;", "", "mapRecursive", "mapTo", "C", "", "destination", "(Lorg/json/JSONArray;Ljava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "mapToRecursive", "", "toMap", "", "", "Lorg/json/JSONObject;", "toMapRecursive", "luggage-commons-jsapi-nfc-ext_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class a
{
  private static List<Object> a(JSONArray paramJSONArray, List<Object> paramList, b<Object, ? extends Object> paramb)
  {
    AppMethodBeat.i(183707);
    s.u(paramJSONArray, "<this>");
    s.u(paramList, "destination");
    s.u(paramb, "transform");
    int i = 0;
    int k = paramJSONArray.length();
    if (k > 0) {}
    for (;;)
    {
      int j = i + 1;
      Object localObject1 = paramJSONArray.get(i);
      s.s(localObject1, "get(index)");
      Object localObject2 = paramb.invoke(localObject1);
      if ((localObject2 instanceof JSONObject)) {
        localObject1 = a((JSONObject)localObject2, paramb);
      }
      for (;;)
      {
        paramList.add(localObject1);
        if (j < k) {
          break;
        }
        AppMethodBeat.o(183707);
        return paramList;
        localObject1 = localObject2;
        if ((localObject2 instanceof JSONArray)) {
          localObject1 = b((JSONArray)localObject2, paramb);
        }
      }
      i = j;
    }
  }
  
  public static final Map<String, Object> a(JSONObject paramJSONObject, b<Object, ? extends Object> paramb)
  {
    AppMethodBeat.i(183708);
    s.u(paramJSONObject, "<this>");
    s.u(paramb, "transform");
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramJSONObject.keys();
    s.s(localIterator, "keys()");
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject1 = paramJSONObject.get(str);
      s.s(localObject1, "get(it)");
      Object localObject2 = paramb.invoke(localObject1);
      Map localMap = (Map)localHashMap;
      s.s(str, "it");
      if ((localObject2 instanceof JSONObject)) {
        localObject1 = a((JSONObject)localObject2, paramb);
      }
      for (;;)
      {
        localMap.put(str, localObject1);
        break;
        localObject1 = localObject2;
        if ((localObject2 instanceof JSONArray)) {
          localObject1 = b((JSONArray)localObject2, paramb);
        }
      }
    }
    paramJSONObject = (Map)localHashMap;
    AppMethodBeat.o(183708);
    return paramJSONObject;
  }
  
  private static List<Object> b(JSONArray paramJSONArray, b<Object, ? extends Object> paramb)
  {
    AppMethodBeat.i(183706);
    s.u(paramJSONArray, "<this>");
    s.u(paramb, "transform");
    paramJSONArray = a(paramJSONArray, (List)new ArrayList(paramJSONArray.length()), paramb);
    AppMethodBeat.o(183706);
    return paramJSONArray;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.b.a
 * JD-Core Version:    0.7.0.1
 */
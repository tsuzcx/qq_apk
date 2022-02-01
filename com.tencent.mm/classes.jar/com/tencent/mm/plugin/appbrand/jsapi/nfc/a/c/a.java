package com.tencent.mm.plugin.appbrand.jsapi.nfc.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"myNfcAdapter", "Landroid/nfc/NfcAdapter;", "getMyNfcAdapter", "()Landroid/nfc/NfcAdapter;", "map", "", "R", "Lorg/json/JSONArray;", "transform", "Lkotlin/Function1;", "", "mapRecursive", "mapTo", "C", "", "destination", "(Lorg/json/JSONArray;Ljava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "mapToRecursive", "", "toMap", "", "", "Lorg/json/JSONObject;", "toMapRecursive", "luggage-commons-jsapi-nfc-ext_release"})
public final class a
{
  private static List<Object> a(JSONArray paramJSONArray, b<Object, ? extends Object> paramb)
  {
    AppMethodBeat.i(183706);
    k.h(paramJSONArray, "$this$mapRecursive");
    k.h(paramb, "transform");
    paramJSONArray = a(paramJSONArray, (List)new ArrayList(paramJSONArray.length()), paramb);
    AppMethodBeat.o(183706);
    return paramJSONArray;
  }
  
  private static List<Object> a(JSONArray paramJSONArray, List<Object> paramList, b<Object, ? extends Object> paramb)
  {
    AppMethodBeat.i(183707);
    k.h(paramJSONArray, "$this$mapToRecursive");
    k.h(paramList, "destination");
    k.h(paramb, "transform");
    int j = paramJSONArray.length();
    int i = 0;
    if (i < j)
    {
      Object localObject1 = paramJSONArray.get(i);
      k.g(localObject1, "get(index)");
      Object localObject2 = paramb.ay(localObject1);
      if ((localObject2 instanceof JSONObject)) {
        localObject1 = a((JSONObject)localObject2, paramb);
      }
      for (;;)
      {
        paramList.add(localObject1);
        i += 1;
        break;
        localObject1 = localObject2;
        if ((localObject2 instanceof JSONArray)) {
          localObject1 = a((JSONArray)localObject2, paramb);
        }
      }
    }
    AppMethodBeat.o(183707);
    return paramList;
  }
  
  public static final Map<String, Object> a(JSONObject paramJSONObject, b<Object, ? extends Object> paramb)
  {
    AppMethodBeat.i(183708);
    k.h(paramJSONObject, "$this$toMapRecursive");
    k.h(paramb, "transform");
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramJSONObject.keys();
    k.g(localIterator, "keys()");
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject1 = paramJSONObject.get(str);
      k.g(localObject1, "get(it)");
      Object localObject2 = paramb.ay(localObject1);
      Map localMap = (Map)localHashMap;
      k.g(str, "it");
      if ((localObject2 instanceof JSONObject)) {
        localObject1 = a((JSONObject)localObject2, paramb);
      }
      for (;;)
      {
        localMap.put(str, localObject1);
        break;
        localObject1 = localObject2;
        if ((localObject2 instanceof JSONArray)) {
          localObject1 = a((JSONArray)localObject2, paramb);
        }
      }
    }
    paramJSONObject = (Map)localHashMap;
    AppMethodBeat.o(183708);
    return paramJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.a.c.a
 * JD-Core Version:    0.7.0.1
 */
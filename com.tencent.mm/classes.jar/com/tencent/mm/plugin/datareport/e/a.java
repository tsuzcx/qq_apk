package com.tencent.mm.plugin.datareport.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.c.i;

public final class a
  implements b
{
  public final Map<String, Object> a(com.tencent.mm.plugin.datareport.f.a parama, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(262901);
    HashMap localHashMap = new HashMap();
    if ((parama != null) && (!i.hm(parama.cui))) {
      localHashMap.put("page_id", parama.cui);
    }
    if ((parama != null) && (parama.params != null) && (parama.params.size() > 0)) {
      localHashMap.putAll(parama.params);
    }
    if ((paramMap != null) && (paramMap.size() > 0)) {
      localHashMap.putAll(paramMap);
    }
    AppMethodBeat.o(262901);
    return localHashMap;
  }
  
  public final Map<String, Object> a(String paramString, Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    AppMethodBeat.i(262913);
    if (i.hm(paramString))
    {
      AppMethodBeat.o(262913);
      return null;
    }
    paramString = new HashMap();
    if (paramMap1.size() > 0) {
      paramString.putAll(paramMap1);
    }
    if ((paramMap2 != null) && (paramMap2.size() > 0)) {
      paramString.put("udf_kv", paramMap2);
    }
    AppMethodBeat.o(262913);
    return paramString;
  }
  
  public final Map<String, Object> a(List<com.tencent.mm.plugin.datareport.f.a> paramList, com.tencent.mm.plugin.datareport.f.a parama, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(262889);
    HashMap localHashMap = new HashMap();
    Object localObject1 = new ArrayList();
    if ((paramList != null) && (paramList.size() > 0))
    {
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        Object localObject2 = (com.tencent.mm.plugin.datareport.f.a)paramList.get(i);
        if (localObject2 != null)
        {
          String str = ((com.tencent.mm.plugin.datareport.f.a)localObject2).cui;
          if (!i.hm(str))
          {
            localHashMap.put("view_id", str);
            ((List)localObject1).add(0, str);
            localObject2 = ((com.tencent.mm.plugin.datareport.f.a)localObject2).params;
            if ((localObject2 != null) && (((Map)localObject2).size() > 0)) {
              localHashMap.putAll((Map)localObject2);
            }
          }
        }
        i -= 1;
      }
    }
    if (((List)localObject1).size() > 0) {
      localHashMap.put("view_path", localObject1);
    }
    paramList = new HashMap();
    if (parama != null)
    {
      localObject1 = parama.cui;
      if (!i.hm((String)localObject1)) {
        paramList.put("page_id", localObject1);
      }
      parama = parama.params;
      if ((parama != null) && (parama.size() > 0)) {
        paramList.putAll(parama);
      }
    }
    localHashMap.put("cur_page", paramList);
    if ((paramMap != null) && (paramMap.size() > 0)) {
      localHashMap.putAll(paramMap);
    }
    AppMethodBeat.o(262889);
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.datareport.e.a
 * JD-Core Version:    0.7.0.1
 */
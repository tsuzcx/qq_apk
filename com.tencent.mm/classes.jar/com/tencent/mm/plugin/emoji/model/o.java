package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.jz;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.emoji.e.m;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.gog;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class o
  implements com.tencent.mm.am.h
{
  private static LinkedList<Object> Z(LinkedList paramLinkedList)
  {
    AppMethodBeat.i(269881);
    if (paramLinkedList.size() > 0) {}
    for (Object localObject1 = paramLinkedList.get(0);; localObject1 = null)
    {
      if ((localObject1.getClass().isPrimitive()) || ((localObject1 instanceof String)))
      {
        AppMethodBeat.o(269881);
        return paramLinkedList;
      }
      if ((localObject1 instanceof etl))
      {
        localObject1 = new LinkedList();
        paramLinkedList = paramLinkedList.iterator();
        while (paramLinkedList.hasNext()) {
          ((LinkedList)localObject1).add(paramLinkedList.next().toString());
        }
        AppMethodBeat.o(269881);
        return localObject1;
      }
      if ((localObject1 instanceof a))
      {
        localObject1 = new LinkedList();
        paramLinkedList = paramLinkedList.iterator();
        while (paramLinkedList.hasNext())
        {
          Object localObject2 = paramLinkedList.next();
          ((LinkedList)localObject1).add(b(localObject2, localObject2.getClass()));
        }
        AppMethodBeat.o(269881);
        return localObject1;
      }
      AppMethodBeat.o(269881);
      return null;
    }
  }
  
  private static JSONObject a(gog paramgog)
  {
    AppMethodBeat.i(269869);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      a(paramgog, localJSONObject);
      label18:
      AppMethodBeat.o(269869);
      return localJSONObject;
    }
    catch (Exception paramgog)
    {
      break label18;
    }
  }
  
  public static final void a(Object paramObject, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(269885);
    a(b(paramObject, paramObject.getClass()), paramJSONObject);
    AppMethodBeat.o(269885);
  }
  
  private static void a(LinkedList<? extends Object> paramLinkedList, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(269893);
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      Object localObject1 = paramLinkedList.next();
      Object localObject2;
      if ((localObject1 instanceof LinkedList))
      {
        localObject2 = new JSONArray();
        a((LinkedList)localObject1, (JSONArray)localObject2);
        paramJSONArray.put(localObject2);
      }
      else if ((localObject1 instanceof Map))
      {
        localObject2 = new JSONObject();
        a((Map)localObject1, (JSONObject)localObject2);
        paramJSONArray.put(localObject2);
      }
      else
      {
        paramJSONArray.put(localObject1);
      }
    }
    AppMethodBeat.o(269893);
  }
  
  public static final void a(Map<String, ? extends Object> paramMap, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(269889);
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      Object localObject;
      if ((localEntry.getValue() instanceof Map))
      {
        localObject = new JSONObject();
        a((Map)localEntry.getValue(), (JSONObject)localObject);
        paramJSONObject.put((String)localEntry.getKey(), localObject);
      }
      else if ((localEntry.getValue() instanceof LinkedList))
      {
        localObject = new JSONArray();
        a((LinkedList)localEntry.getValue(), (JSONArray)localObject);
        paramJSONObject.put((String)localEntry.getKey(), localObject);
      }
      else
      {
        paramJSONObject.put((String)localEntry.getKey(), localEntry.getValue());
      }
    }
    AppMethodBeat.o(269889);
  }
  
  private static HashMap<String, Object> b(Object paramObject, Class paramClass)
  {
    AppMethodBeat.i(269875);
    HashMap localHashMap = new HashMap();
    paramClass = paramClass.getFields();
    int j = paramClass.length;
    int i = 0;
    for (;;)
    {
      Object localObject1;
      if (i < j) {
        localObject1 = paramClass[i];
      }
      try
      {
        Object localObject2 = localObject1.get(paramObject);
        if (localObject2 == null) {
          break label168;
        }
        if ((localObject1.getType().isPrimitive()) || ((localObject2 instanceof String)))
        {
          localHashMap.put(localObject1.getName(), localObject2);
        }
        else if ((localObject2 instanceof a))
        {
          localObject2 = b(localObject2, localObject1.getType());
          localHashMap.put(localObject1.getName(), localObject2);
        }
        else if ((localObject2 instanceof LinkedList))
        {
          localObject2 = Z((LinkedList)localObject2);
          if (localObject2 != null) {
            localHashMap.put(localObject1.getName(), localObject2);
          }
        }
      }
      catch (Exception localException)
      {
        label168:
        break label168;
      }
      AppMethodBeat.o(269875);
      return localHashMap;
      i += 1;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(269929);
    if ((paramp instanceof com.tencent.mm.plugin.emoji.e.o)) {
      com.tencent.mm.kernel.h.aZW().b(411, this);
    }
    for (;;)
    {
      AppMethodBeat.o(269929);
      throw null;
      if ((paramp instanceof m)) {
        com.tencent.mm.kernel.h.aZW().b(412, this);
      } else if ((paramp instanceof com.tencent.mm.plugin.emoji.e.p)) {
        com.tencent.mm.kernel.h.aZW().b(822, this);
      }
    }
  }
  
  final class a
    extends m
  {
    jz xNh;
    
    public a(String paramString, int paramInt)
    {
      super(5, paramInt);
    }
  }
  
  final class b
    extends com.tencent.mm.plugin.emoji.e.o
  {
    jz xNh;
    
    public b(int paramInt, byte[] paramArrayOfByte)
    {
      super(paramArrayOfByte, 2);
    }
  }
  
  final class c
    extends com.tencent.mm.plugin.emoji.e.p
  {
    jz xNh;
    
    public c(String paramString, int paramInt)
    {
      super(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.o
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.bk;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/pbtojson/PbToJsonUtil;", "", "()V", "Companion", "libcompatible_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a pxt;
  
  static
  {
    AppMethodBeat.i(230960);
    pxt = new a((byte)0);
    AppMethodBeat.o(230960);
  }
  
  public static final void a(JSONObject paramJSONObject, String paramString, Object paramObject, boolean paramBoolean)
  {
    AppMethodBeat.i(230957);
    pxt.a(paramJSONObject, paramString, paramObject, paramBoolean);
    AppMethodBeat.o(230957);
  }
  
  public static final void b(JSONObject paramJSONObject, String paramString, Object paramObject)
  {
    AppMethodBeat.i(230956);
    a locala = pxt;
    s.u(paramJSONObject, "obj");
    s.u(paramString, "key");
    locala.a(paramJSONObject, paramString, paramObject, false);
    AppMethodBeat.o(230956);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/pbtojson/PbToJsonUtil$Companion;", "", "()V", "isJsonSupportType", "", "value", "putObjectValue", "", "obj", "Lorg/json/JSONObject;", "key", "", "putObjectValueAll", "isPrintByteString", "toJSONArray", "Lorg/json/JSONArray;", "list", "Ljava/util/LinkedList;", "libcompatible_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private static boolean dC(Object paramObject)
    {
      AppMethodBeat.i(230961);
      s.u(paramObject, "value");
      if ((paramObject instanceof String))
      {
        AppMethodBeat.o(230961);
        return true;
      }
      if ((paramObject instanceof Integer))
      {
        AppMethodBeat.o(230961);
        return true;
      }
      if ((paramObject instanceof Long))
      {
        AppMethodBeat.o(230961);
        return true;
      }
      if ((paramObject instanceof Boolean))
      {
        AppMethodBeat.o(230961);
        return true;
      }
      if ((paramObject instanceof Float))
      {
        AppMethodBeat.o(230961);
        return true;
      }
      if ((paramObject instanceof Double))
      {
        AppMethodBeat.o(230961);
        return true;
      }
      if ((paramObject instanceof Short))
      {
        AppMethodBeat.o(230961);
        return true;
      }
      boolean bool = paramObject instanceof Character;
      AppMethodBeat.o(230961);
      return bool;
    }
    
    private JSONArray r(LinkedList<?> paramLinkedList)
    {
      AppMethodBeat.i(230959);
      JSONArray localJSONArray = new JSONArray();
      if (paramLinkedList != null)
      {
        paramLinkedList = paramLinkedList.iterator();
        while (paramLinkedList.hasNext())
        {
          Object localObject = paramLinkedList.next();
          if ((localObject instanceof LinkedList))
          {
            localJSONArray.put(r((LinkedList)localObject));
          }
          else if ((localObject instanceof com.tencent.mm.bx.a))
          {
            localJSONArray.put(((com.tencent.mm.bx.a)localObject).toJSON());
          }
          else if ((localObject instanceof b))
          {
            try
            {
              localJSONArray.put(((b)localObject).ZV());
            }
            catch (Exception localException) {}
          }
          else
          {
            s.s(localException, "item");
            if (dC(localException)) {
              localJSONArray.put(localException);
            }
          }
        }
      }
      AppMethodBeat.o(230959);
      return localJSONArray;
    }
    
    public final void a(JSONObject paramJSONObject, String paramString, Object paramObject, boolean paramBoolean)
    {
      AppMethodBeat.i(230965);
      s.u(paramJSONObject, "obj");
      s.u(paramString, "key");
      if (paramObject == null)
      {
        paramJSONObject.put(paramString, null);
        AppMethodBeat.o(230965);
        return;
      }
      if ((paramObject instanceof LinkedList))
      {
        paramJSONObject.put(paramString, r((LinkedList)paramObject));
        AppMethodBeat.o(230965);
        return;
      }
      if ((paramObject instanceof com.tencent.mm.bx.a))
      {
        paramJSONObject.put(paramString, ((com.tencent.mm.bx.a)paramObject).toJSON());
        AppMethodBeat.o(230965);
        return;
      }
      if ((paramObject instanceof b))
      {
        if (paramBoolean) {
          try
          {
            paramJSONObject.put(paramString, Base64.encodeToString(((b)paramObject).Op, 0));
            AppMethodBeat.o(230965);
            return;
          }
          catch (Exception paramJSONObject)
          {
            AppMethodBeat.o(230965);
            return;
          }
        }
        paramJSONObject.put(paramString, ((b)paramObject).ZV());
        AppMethodBeat.o(230965);
        return;
      }
      if ((paramObject instanceof byte[])) {
        try
        {
          paramJSONObject.put(paramString, "ByteArray[" + ((byte[])paramObject).length + ']');
          AppMethodBeat.o(230965);
          return;
        }
        catch (Exception paramJSONObject)
        {
          AppMethodBeat.o(230965);
          return;
        }
      }
      if (dC(paramObject)) {
        paramJSONObject.put(paramString, paramObject);
      }
      AppMethodBeat.o(230965);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.bk.a
 * JD-Core Version:    0.7.0.1
 */
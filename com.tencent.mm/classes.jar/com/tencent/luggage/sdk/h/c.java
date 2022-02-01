package com.tencent.luggage.sdk.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.a.ae;
import kotlin.a.ag;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.a.a;
import kotlin.g.b.s;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/sdk/wxa_ktx/JSONUtils;", "", "()V", "copy", "Lorg/json/JSONObject;", "forEach", "", "T", "Lorg/json/JSONArray;", "block", "Lkotlin/Function1;", "iterator", "", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c evK;
  
  static
  {
    AppMethodBeat.i(135552);
    evK = new c();
    AppMethodBeat.o(135552);
  }
  
  public static final <T> void a(JSONArray paramJSONArray, b<? super T, ah> paramb)
  {
    AppMethodBeat.i(220578);
    s.u(paramJSONArray, "<this>");
    s.u(paramb, "block");
    int i = 0;
    int k = paramJSONArray.length();
    if (k > 0) {}
    for (;;)
    {
      int j = i + 1;
      paramb.invoke(paramJSONArray.get(i));
      if (j >= k)
      {
        AppMethodBeat.o(220578);
        return;
      }
      i = j;
    }
  }
  
  public static Iterator<Object> f(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(220574);
    s.u(paramJSONArray, "<this>");
    paramJSONArray = (Iterator)new a(paramJSONArray);
    AppMethodBeat.o(220574);
    return paramJSONArray;
  }
  
  public static final JSONObject h(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(135551);
    s.u(paramJSONObject, "<this>");
    String[] arrayOfString = new String[paramJSONObject.length()];
    Iterator localIterator = paramJSONObject.keys();
    s.s(localIterator, "this.keys()");
    s.u(localIterator, "$this$withIndex");
    localIterator = (Iterator)new ag(localIterator);
    while (localIterator.hasNext())
    {
      ae localae = (ae)localIterator.next();
      arrayOfString[localae.index] = ((String)localae.value);
    }
    paramJSONObject = new JSONObject(paramJSONObject, arrayOfString);
    AppMethodBeat.o(135551);
    return paramJSONObject;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/luggage/sdk/wxa_ktx/JSONUtils$iterator$1", "", "", "index", "", "getIndex", "()I", "setIndex", "(I)V", "hasNext", "", "next", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Iterator<Object>, a
  {
    private int index;
    
    a(JSONArray paramJSONArray) {}
    
    public final boolean hasNext()
    {
      AppMethodBeat.i(220567);
      if (this.index < this.evL.length())
      {
        AppMethodBeat.o(220567);
        return true;
      }
      AppMethodBeat.o(220567);
      return false;
    }
    
    public final Object next()
    {
      AppMethodBeat.i(220570);
      Object localObject = this.evL.get(this.index);
      this.index += 1;
      AppMethodBeat.o(220570);
      return localObject;
    }
    
    public final void remove()
    {
      AppMethodBeat.i(220573);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
      AppMethodBeat.o(220573);
      throw localUnsupportedOperationException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.sdk.h.c
 * JD-Core Version:    0.7.0.1
 */
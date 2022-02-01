package com.tencent.luggage.sdk.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import kotlin.a.aa;
import kotlin.a.y;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/sdk/wxa_ktx/JSONUtils;", "", "()V", "copy", "Lorg/json/JSONObject;", "forEach", "", "T", "Lorg/json/JSONArray;", "block", "Lkotlin/Function1;", "iterator", "", "luggage-wxa-app_release"})
public final class c
{
  public static final c cDl;
  
  static
  {
    AppMethodBeat.i(135552);
    cDl = new c();
    AppMethodBeat.o(135552);
  }
  
  public static final <T> void a(JSONArray paramJSONArray, b<? super T, x> paramb)
  {
    AppMethodBeat.i(244199);
    p.k(paramJSONArray, "$this$forEach");
    p.k(paramb, "block");
    int i = 0;
    int j = paramJSONArray.length();
    while (i < j)
    {
      paramb.invoke(paramJSONArray.get(i));
      i += 1;
    }
    AppMethodBeat.o(244199);
  }
  
  public static final JSONObject i(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(135551);
    p.k(paramJSONObject, "$this$copy");
    String[] arrayOfString = new String[paramJSONObject.length()];
    Iterator localIterator = paramJSONObject.keys();
    p.j(localIterator, "this.keys()");
    p.k(localIterator, "$this$withIndex");
    localIterator = (Iterator)new aa(localIterator);
    while (localIterator.hasNext())
    {
      y localy = (y)localIterator.next();
      arrayOfString[localy.index] = ((String)localy.value);
    }
    paramJSONObject = new JSONObject(paramJSONObject, arrayOfString);
    AppMethodBeat.o(135551);
    return paramJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.sdk.h.c
 * JD-Core Version:    0.7.0.1
 */
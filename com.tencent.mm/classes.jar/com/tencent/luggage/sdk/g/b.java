package com.tencent.luggage.sdk.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import kotlin.a.aa;
import kotlin.a.y;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/luggage/sdk/wxa_ktx/JSONUtils;", "", "()V", "copy", "Lorg/json/JSONObject;", "luggage-wxa-app_release"})
public final class b
{
  public static final b cCH;
  
  static
  {
    AppMethodBeat.i(135552);
    cCH = new b();
    AppMethodBeat.o(135552);
  }
  
  public static final JSONObject f(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(135551);
    p.h(paramJSONObject, "$this$copy");
    String[] arrayOfString = new String[paramJSONObject.length()];
    Iterator localIterator = paramJSONObject.keys();
    p.g(localIterator, "this.keys()");
    p.h(localIterator, "$this$withIndex");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.sdk.g.b
 * JD-Core Version:    0.7.0.1
 */
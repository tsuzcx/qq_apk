package com.tencent.luggage.sdk.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.aa;
import d.a.y;
import d.g.b.k;
import d.l;
import java.util.Iterator;
import org.json.JSONObject;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/luggage/sdk/wxa_ktx/JSONUtils;", "", "()V", "copy", "Lorg/json/JSONObject;", "luggage-wxa-app_release"})
public final class b
{
  public static final b cfv;
  
  static
  {
    AppMethodBeat.i(135552);
    cfv = new b();
    AppMethodBeat.o(135552);
  }
  
  public static final JSONObject f(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(135551);
    k.h(paramJSONObject, "$this$copy");
    String[] arrayOfString = new String[paramJSONObject.length()];
    Iterator localIterator = paramJSONObject.keys();
    k.g(localIterator, "this.keys()");
    k.h(localIterator, "$this$withIndex");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.g.b
 * JD-Core Version:    0.7.0.1
 */
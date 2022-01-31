package com.facebook.share.internal;

import com.facebook.share.model.CameraEffectArguments.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONArray;
import org.json.JSONObject;

final class CameraEffectJSONUtility$3
  implements CameraEffectJSONUtility.Setter
{
  public final void setOnArgumentsBuilder(CameraEffectArguments.Builder paramBuilder, String paramString, Object paramObject)
  {
    AppMethodBeat.i(96948);
    paramObject = (JSONArray)paramObject;
    String[] arrayOfString = new String[paramObject.length()];
    int i = 0;
    while (i < paramObject.length())
    {
      Object localObject = paramObject.get(i);
      if ((localObject instanceof String))
      {
        arrayOfString[i] = ((String)localObject);
        i += 1;
      }
      else
      {
        paramBuilder = new IllegalArgumentException("Unexpected type in an array: " + localObject.getClass());
        AppMethodBeat.o(96948);
        throw paramBuilder;
      }
    }
    paramBuilder.putArgument(paramString, arrayOfString);
    AppMethodBeat.o(96948);
  }
  
  public final void setOnJSON(JSONObject paramJSONObject, String paramString, Object paramObject)
  {
    AppMethodBeat.i(96949);
    paramJSONObject = new IllegalArgumentException("JSONArray's are not supported in bundles.");
    AppMethodBeat.o(96949);
    throw paramJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.facebook.share.internal.CameraEffectJSONUtility.3
 * JD-Core Version:    0.7.0.1
 */
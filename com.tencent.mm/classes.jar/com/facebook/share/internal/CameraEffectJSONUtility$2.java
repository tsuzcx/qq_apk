package com.facebook.share.internal;

import com.facebook.share.model.CameraEffectArguments.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONArray;
import org.json.JSONObject;

final class CameraEffectJSONUtility$2
  implements CameraEffectJSONUtility.Setter
{
  public final void setOnArgumentsBuilder(CameraEffectArguments.Builder paramBuilder, String paramString, Object paramObject)
  {
    AppMethodBeat.i(96946);
    paramBuilder = new IllegalArgumentException("Unexpected type from JSON");
    AppMethodBeat.o(96946);
    throw paramBuilder;
  }
  
  public final void setOnJSON(JSONObject paramJSONObject, String paramString, Object paramObject)
  {
    AppMethodBeat.i(96947);
    JSONArray localJSONArray = new JSONArray();
    paramObject = (String[])paramObject;
    int j = paramObject.length;
    int i = 0;
    while (i < j)
    {
      localJSONArray.put(paramObject[i]);
      i += 1;
    }
    paramJSONObject.put(paramString, localJSONArray);
    AppMethodBeat.o(96947);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.facebook.share.internal.CameraEffectJSONUtility.2
 * JD-Core Version:    0.7.0.1
 */
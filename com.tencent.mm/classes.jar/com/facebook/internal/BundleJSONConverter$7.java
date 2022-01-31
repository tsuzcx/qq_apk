package com.facebook.internal;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

final class BundleJSONConverter$7
  implements BundleJSONConverter.Setter
{
  public final void setOnBundle(Bundle paramBundle, String paramString, Object paramObject)
  {
    AppMethodBeat.i(72262);
    paramObject = (JSONArray)paramObject;
    ArrayList localArrayList = new ArrayList();
    if (paramObject.length() == 0)
    {
      paramBundle.putStringArrayList(paramString, localArrayList);
      AppMethodBeat.o(72262);
      return;
    }
    int i = 0;
    while (i < paramObject.length())
    {
      Object localObject = paramObject.get(i);
      if ((localObject instanceof String))
      {
        localArrayList.add((String)localObject);
        i += 1;
      }
      else
      {
        paramBundle = new IllegalArgumentException("Unexpected type in an array: " + localObject.getClass());
        AppMethodBeat.o(72262);
        throw paramBundle;
      }
    }
    paramBundle.putStringArrayList(paramString, localArrayList);
    AppMethodBeat.o(72262);
  }
  
  public final void setOnJSON(JSONObject paramJSONObject, String paramString, Object paramObject)
  {
    AppMethodBeat.i(72263);
    paramJSONObject = new IllegalArgumentException("JSONArray's are not supported in bundles.");
    AppMethodBeat.o(72263);
    throw paramJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.facebook.internal.BundleJSONConverter.7
 * JD-Core Version:    0.7.0.1
 */
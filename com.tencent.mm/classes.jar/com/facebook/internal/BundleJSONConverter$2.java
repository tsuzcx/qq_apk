package com.facebook.internal;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

final class BundleJSONConverter$2
  implements BundleJSONConverter.Setter
{
  public final void setOnBundle(Bundle paramBundle, String paramString, Object paramObject)
  {
    AppMethodBeat.i(72252);
    paramBundle.putInt(paramString, ((Integer)paramObject).intValue());
    AppMethodBeat.o(72252);
  }
  
  public final void setOnJSON(JSONObject paramJSONObject, String paramString, Object paramObject)
  {
    AppMethodBeat.i(72253);
    paramJSONObject.put(paramString, paramObject);
    AppMethodBeat.o(72253);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.internal.BundleJSONConverter.2
 * JD-Core Version:    0.7.0.1
 */
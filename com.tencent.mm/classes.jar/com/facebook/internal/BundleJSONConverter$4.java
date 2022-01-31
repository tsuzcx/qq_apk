package com.facebook.internal;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

final class BundleJSONConverter$4
  implements BundleJSONConverter.Setter
{
  public final void setOnBundle(Bundle paramBundle, String paramString, Object paramObject)
  {
    AppMethodBeat.i(72256);
    paramBundle.putDouble(paramString, ((Double)paramObject).doubleValue());
    AppMethodBeat.o(72256);
  }
  
  public final void setOnJSON(JSONObject paramJSONObject, String paramString, Object paramObject)
  {
    AppMethodBeat.i(72257);
    paramJSONObject.put(paramString, paramObject);
    AppMethodBeat.o(72257);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.facebook.internal.BundleJSONConverter.4
 * JD-Core Version:    0.7.0.1
 */
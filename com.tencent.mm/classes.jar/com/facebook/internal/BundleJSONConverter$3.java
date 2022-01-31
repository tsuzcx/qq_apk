package com.facebook.internal;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

final class BundleJSONConverter$3
  implements BundleJSONConverter.Setter
{
  public final void setOnBundle(Bundle paramBundle, String paramString, Object paramObject)
  {
    AppMethodBeat.i(72254);
    paramBundle.putLong(paramString, ((Long)paramObject).longValue());
    AppMethodBeat.o(72254);
  }
  
  public final void setOnJSON(JSONObject paramJSONObject, String paramString, Object paramObject)
  {
    AppMethodBeat.i(72255);
    paramJSONObject.put(paramString, paramObject);
    AppMethodBeat.o(72255);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.facebook.internal.BundleJSONConverter.3
 * JD-Core Version:    0.7.0.1
 */
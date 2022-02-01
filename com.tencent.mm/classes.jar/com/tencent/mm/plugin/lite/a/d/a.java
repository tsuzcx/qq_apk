package com.tencent.mm.plugin.lite.a.d;

import com.tencent.d.a.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.lite.api.e;
import com.tencent.mm.plugin.lite.api.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import org.json.JSONObject;

public class a
  extends e
{
  public final void a(String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(271527);
    Log.d("LiteAppJsApiGetFinderLivePreviewMicCover", "Invoke getFinderLivePreviewMicCover");
    if (paramJSONObject == null)
    {
      this.JZj.aJV("data is null");
      AppMethodBeat.o(271527);
      return;
    }
    paramString = new HashMap();
    try
    {
      String str1 = paramJSONObject.optString("encryptedId");
      String str2 = paramJSONObject.optString("nonceId");
      paramJSONObject = paramJSONObject.optString("requestId");
      ((b)h.az(b.class)).loadMicInfos(str1, str2, new a.1(this, paramString, paramJSONObject));
      AppMethodBeat.o(271527);
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("LiteAppJsApiGetFinderLivePreviewMicCover", paramString, "getFinderLivePreviewMicCover fail", new Object[0]);
      this.JZj.aJV("Invalid input parameters");
      AppMethodBeat.o(271527);
    }
  }
  
  public final int fEx()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.a.d.a
 * JD-Core Version:    0.7.0.1
 */
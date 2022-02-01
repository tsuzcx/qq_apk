package com.tencent.mm.plugin.lite.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.lite.api.e;
import com.tencent.mm.plugin.lite.api.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.q;
import kotlin.g.b.u;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/lite/jsapi/finder/LiteAppJsApiGetFinderLivePreviewUrl;", "Lcom/tencent/mm/plugin/lite/api/LiteAppJsApi;", "()V", "invoke", "", "appId", "", "data", "Lorg/json/JSONObject;", "isFromView", "", "runModel", "", "Companion", "luggage-lite-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends e
{
  public static final a Kay;
  private static final String NAME;
  
  static
  {
    AppMethodBeat.i(271511);
    Kay = new a((byte)0);
    NAME = "getFinderLivePreviewUrl";
    AppMethodBeat.o(271511);
  }
  
  public final void a(String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(271528);
    Log.d("LiteAppJsApiGetFinderLivePreviewUrl", "invoke getFinderLivePreviewUrl");
    if (paramJSONObject == null)
    {
      this.JZj.aJV("data is null");
      AppMethodBeat.o(271528);
      return;
    }
    paramString = paramJSONObject.optString("encryptedId");
    String str1 = paramJSONObject.optString("nonceId");
    String str2 = paramJSONObject.optString("requestId");
    int i = paramJSONObject.optInt("scene");
    if (i == 0) {
      i = 114;
    }
    for (;;)
    {
      try
      {
        ((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).getFinderLivePreviewUrl(paramString, str1, i, (q)new b(str2, this));
        AppMethodBeat.o(271528);
        return;
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("LiteAppJsApiGetFinderLivePreviewUrl", (Throwable)paramString, "", new Object[0]);
        this.JZj.aJV("fail");
        AppMethodBeat.o(271528);
        return;
      }
    }
  }
  
  public final int fEx()
  {
    return 1;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/lite/jsapi/finder/LiteAppJsApiGetFinderLivePreviewUrl$Companion;", "", "()V", "NAME", "", "getNAME", "()Ljava/lang/String;", "TAG", "luggage-lite-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "url", "", "errMsg", "errCode", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements q<String, String, Integer, ah>
  {
    b(String paramString, b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.a.d.b
 * JD-Core Version:    0.7.0.1
 */
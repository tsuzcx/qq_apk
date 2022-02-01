package com.tencent.mm.plugin.appbrand.jsapi.z;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.page.ad;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/rendering_cache/EventOnInitialRenderingCacheReady;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApiEvent;", "()V", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends s
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "onInitialRenderingCacheReady";
  public static final a srR;
  
  static
  {
    AppMethodBeat.i(147955);
    srR = new a((byte)0);
    AppMethodBeat.o(147955);
  }
  
  public static final void a(String paramString1, String paramString2, ad paramad)
  {
    s locals = null;
    AppMethodBeat.i(147956);
    Object localObject;
    int i;
    if ((paramString1 != null) && (paramad != null))
    {
      localObject = (CharSequence)paramString2;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label124;
      }
      i = 1;
      if (i == 0) {
        break label129;
      }
      paramString2 = locals;
    }
    for (;;)
    {
      locals = new a().h((f)paramad);
      localObject = new HashMap();
      ((HashMap)localObject).put("content", paramString1);
      ((HashMap)localObject).put("webviewData", paramString2);
      ((HashMap)localObject).put("path", paramad.cgR());
      paramString1 = ah.aiuX;
      locals.K((Map)localObject).cpV();
      AppMethodBeat.o(147956);
      return;
      label124:
      i = 0;
      break;
      try
      {
        label129:
        paramString2 = new JSONObject(paramString2);
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          paramString2 = null;
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/rendering_cache/EventOnInitialRenderingCacheReady$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "dispatchReady", "", "content", "webviewData", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.z.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.jsapi.v;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.page.ac;
import java.util.HashMap;
import java.util.Map;
import kotlin.l;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/rendering_cache/EventOnInitialRenderingCacheReady;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApiEvent;", "()V", "Companion", "luggage-wechat-full-sdk_release"})
public final class a
  extends s
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "onInitialRenderingCacheReady";
  public static final a moV;
  
  static
  {
    AppMethodBeat.i(147955);
    moV = new a((byte)0);
    AppMethodBeat.o(147955);
  }
  
  public static final void a(String paramString1, String paramString2, ac paramac)
  {
    s locals = null;
    AppMethodBeat.i(147956);
    if (paramString1 == null)
    {
      AppMethodBeat.o(147956);
      return;
    }
    if (paramac == null)
    {
      AppMethodBeat.o(147956);
      return;
    }
    Object localObject = (CharSequence)paramString2;
    int i;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label137;
      }
      paramString2 = locals;
    }
    for (;;)
    {
      locals = new a().g((f)paramac);
      localObject = new HashMap();
      ((HashMap)localObject).put("content", paramString1);
      ((HashMap)localObject).put("webviewData", paramString2);
      ((HashMap)localObject).put("path", paramac.getURL());
      locals.K((Map)localObject).bEo();
      AppMethodBeat.o(147956);
      return;
      i = 0;
      break;
      try
      {
        label137:
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/rendering_cache/EventOnInitialRenderingCacheReady$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "dispatchReady", "", "content", "webviewData", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "luggage-wechat-full-sdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.v.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.jsapi.r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.aa;
import d.l;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/rendering_cache/EventOnInitialRenderingCacheReady;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApiEvent;", "()V", "Companion", "luggage-wechat-full-sdk_release"})
public final class a
  extends p
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "onInitialRenderingCacheReady";
  public static final a khT;
  
  static
  {
    AppMethodBeat.i(147955);
    khT = new a((byte)0);
    AppMethodBeat.o(147955);
  }
  
  public static final void a(String paramString1, String paramString2, aa paramaa)
  {
    p localp = null;
    AppMethodBeat.i(147956);
    if (paramString1 == null)
    {
      AppMethodBeat.o(147956);
      return;
    }
    if (paramaa == null)
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
      paramString2 = localp;
    }
    for (;;)
    {
      localp = new a().g((c)paramaa);
      localObject = new HashMap();
      ((HashMap)localObject).put("content", paramString1);
      ((HashMap)localObject).put("webviewData", paramString2);
      ((HashMap)localObject).put("path", paramaa.getURL());
      localp.B((Map)localObject).aXQ();
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
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/rendering_cache/EventOnInitialRenderingCacheReady$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "dispatchReady", "", "content", "webviewData", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "luggage-wechat-full-sdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.r.a
 * JD-Core Version:    0.7.0.1
 */
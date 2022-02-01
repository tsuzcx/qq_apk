package com.tencent.mm.plugin.appbrand.jsapi.t;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.z;
import d.l;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/rendering_cache/EventOnInitialRenderingCacheReady;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApiEvent;", "()V", "Companion", "luggage-wechat-full-sdk_release"})
public final class a
  extends p
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "onInitialRenderingCacheReady";
  public static final a ljq;
  
  static
  {
    AppMethodBeat.i(147955);
    ljq = new a((byte)0);
    AppMethodBeat.o(147955);
  }
  
  public static final void a(String paramString1, String paramString2, z paramz)
  {
    p localp = null;
    AppMethodBeat.i(147956);
    if (paramString1 == null)
    {
      AppMethodBeat.o(147956);
      return;
    }
    if (paramz == null)
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
      localp = new a().g((c)paramz);
      localObject = new HashMap();
      ((HashMap)localObject).put("content", paramString1);
      ((HashMap)localObject).put("webviewData", paramString2);
      ((HashMap)localObject).put("path", paramz.getURL());
      localp.H((Map)localObject).bja();
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/rendering_cache/EventOnInitialRenderingCacheReady$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "dispatchReady", "", "content", "webviewData", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "luggage-wechat-full-sdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.a
 * JD-Core Version:    0.7.0.1
 */
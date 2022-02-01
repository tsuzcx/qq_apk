package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.c.b;
import d.l;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiAppBindGroup;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class aj
  extends a<c>
{
  public static final int CTRL_INDEX = 875;
  public static final String NAME = "bindGroup";
  public static final a kuI;
  
  static
  {
    AppMethodBeat.i(223315);
    kuI = new a((byte)0);
    AppMethodBeat.o(223315);
  }
  
  public final void a(final c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    String str3 = null;
    AppMethodBeat.i(223314);
    String str1;
    Object localObject;
    int i;
    if (paramc != null)
    {
      str1 = paramc.getAppId();
      localObject = (CharSequence)str1;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label79;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        if (paramc != null)
        {
          paramc.h(paramInt, PO("fail:appId is null"));
          AppMethodBeat.o(223314);
          return;
          str1 = null;
          break;
          label79:
          i = 0;
          continue;
        }
        AppMethodBeat.o(223314);
        return;
      }
    }
    if (paramJSONObject != null)
    {
      localObject = paramJSONObject.optString("signature");
      if (paramJSONObject == null) {
        break label204;
      }
    }
    label204:
    for (String str2 = paramJSONObject.optString("groupId");; str2 = null)
    {
      if (paramJSONObject != null) {
        str3 = paramJSONObject.optString("nonceStr");
      }
      paramJSONObject = new c.b();
      paramJSONObject.appId = str1;
      paramJSONObject.signature = ((String)localObject);
      paramJSONObject.vVS = str2;
      paramJSONObject.vVT = str3;
      ((com.tencent.mm.plugin.messenger.foundation.a.c)g.ab(com.tencent.mm.plugin.messenger.foundation.a.c.class)).a(paramc.getContext(), paramJSONObject, (c.a)new b(this, paramc, paramInt));
      AppMethodBeat.o(223314);
      return;
      localObject = null;
      break;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiAppBindGroup$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "success", "", "errorMsg", "", "groupOpenId", "onDealEnd"})
  static final class b
    implements c.a
  {
    b(aj paramaj, c paramc, int paramInt) {}
    
    public final void a(boolean paramBoolean, String paramString1, String paramString2)
    {
      AppMethodBeat.i(223313);
      if (paramBoolean)
      {
        paramString1 = (CharSequence)paramString2;
        int i;
        if ((paramString1 == null) || (paramString1.length() == 0)) {
          i = 1;
        }
        while (i != 0)
        {
          paramString1 = new HashMap();
          ((Map)paramString1).put("openId", paramString2);
          paramString2 = paramc;
          if (paramString2 != null)
          {
            paramString2.h(paramInt, this.kuJ.n("ok", (Map)paramString1));
            AppMethodBeat.o(223313);
            return;
            i = 0;
          }
          else
          {
            AppMethodBeat.o(223313);
            return;
          }
        }
      }
      paramString1 = paramc;
      if (paramString1 != null)
      {
        paramString1.h(paramInt, this.kuJ.PO("fail"));
        AppMethodBeat.o(223313);
        return;
      }
      AppMethodBeat.o(223313);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aj
 * JD-Core Version:    0.7.0.1
 */
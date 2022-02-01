package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.e.a;
import com.tencent.mm.plugin.messenger.foundation.a.e.b;
import java.util.HashMap;
import java.util.Map;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiAppBindGroup;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class ao
  extends c<e>
{
  public static final int CTRL_INDEX = 875;
  public static final String NAME = "bindGroup";
  public static final a otP;
  
  static
  {
    AppMethodBeat.i(284002);
    otP = new a((byte)0);
    AppMethodBeat.o(284002);
  }
  
  public final void a(final e parame, JSONObject paramJSONObject, final int paramInt)
  {
    String str3 = null;
    AppMethodBeat.i(284001);
    String str1;
    Object localObject;
    int i;
    if (parame != null)
    {
      str1 = parame.getAppId();
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
        if (parame != null)
        {
          parame.j(paramInt, agS("fail:appId is null"));
          AppMethodBeat.o(284001);
          return;
          str1 = null;
          break;
          label79:
          i = 0;
          continue;
        }
        AppMethodBeat.o(284001);
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
      paramJSONObject = new e.b();
      paramJSONObject.appId = str1;
      paramJSONObject.signature = ((String)localObject);
      paramJSONObject.EVw = str2;
      paramJSONObject.EVx = str3;
      ((com.tencent.mm.plugin.messenger.foundation.a.e)h.ae(com.tencent.mm.plugin.messenger.foundation.a.e.class)).a(parame.getContext(), paramJSONObject, (e.a)new b(this, parame, paramInt));
      AppMethodBeat.o(284001);
      return;
      localObject = null;
      break;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiAppBindGroup$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "success", "", "errorMsg", "", "groupOpenId", "onDealEnd"})
  static final class b
    implements e.a
  {
    b(ao paramao, e parame, int paramInt) {}
    
    public final void a(boolean paramBoolean, String paramString1, String paramString2)
    {
      AppMethodBeat.i(278192);
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
          paramString2 = parame;
          if (paramString2 != null)
          {
            paramString2.j(paramInt, this.otQ.m("ok", (Map)paramString1));
            AppMethodBeat.o(278192);
            return;
            i = 0;
          }
          else
          {
            AppMethodBeat.o(278192);
            return;
          }
        }
      }
      paramString1 = parame;
      if (paramString1 != null)
      {
        paramString1.j(paramInt, this.otQ.agS("fail"));
        AppMethodBeat.o(278192);
        return;
      }
      AppMethodBeat.o(278192);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ao
 * JD-Core Version:    0.7.0.1
 */
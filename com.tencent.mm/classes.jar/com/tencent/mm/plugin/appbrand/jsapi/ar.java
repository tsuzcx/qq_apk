package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.c.b;
import java.util.HashMap;
import java.util.Map;
import kotlin.l;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiAppBindGroup;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class ar
  extends d<f>
{
  public static final int CTRL_INDEX = 875;
  public static final String NAME = "bindGroup";
  public static final a lyK;
  
  static
  {
    AppMethodBeat.i(228273);
    lyK = new a((byte)0);
    AppMethodBeat.o(228273);
  }
  
  public final void a(final f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    String str3 = null;
    AppMethodBeat.i(228272);
    String str1;
    Object localObject;
    int i;
    if (paramf != null)
    {
      str1 = paramf.getAppId();
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
        if (paramf != null)
        {
          paramf.i(paramInt, Zf("fail:appId is null"));
          AppMethodBeat.o(228272);
          return;
          str1 = null;
          break;
          label79:
          i = 0;
          continue;
        }
        AppMethodBeat.o(228272);
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
      paramJSONObject.zpX = str2;
      paramJSONObject.zpY = str3;
      ((c)g.af(c.class)).a(paramf.getContext(), paramJSONObject, (c.a)new b(this, paramf, paramInt));
      AppMethodBeat.o(228272);
      return;
      localObject = null;
      break;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiAppBindGroup$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "success", "", "errorMsg", "", "groupOpenId", "onDealEnd"})
  static final class b
    implements c.a
  {
    b(ar paramar, f paramf, int paramInt) {}
    
    public final void a(boolean paramBoolean, String paramString1, String paramString2)
    {
      AppMethodBeat.i(228271);
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
          paramString2 = paramf;
          if (paramString2 != null)
          {
            paramString2.i(paramInt, this.lyL.n("ok", (Map)paramString1));
            AppMethodBeat.o(228271);
            return;
            i = 0;
          }
          else
          {
            AppMethodBeat.o(228271);
            return;
          }
        }
      }
      paramString1 = paramf;
      if (paramString1 != null)
      {
        paramString1.i(paramInt, this.lyL.Zf("fail"));
        AppMethodBeat.o(228271);
        return;
      }
      AppMethodBeat.o(228271);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ar
 * JD-Core Version:    0.7.0.1
 */
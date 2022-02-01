package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.e.b;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiAppBindGroup;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ar
  extends c<f>
{
  public static final int CTRL_INDEX = 875;
  public static final String NAME = "bindGroup";
  public static final a rxx;
  
  static
  {
    AppMethodBeat.i(325555);
    rxx = new a((byte)0);
    AppMethodBeat.o(325555);
  }
  
  private static final void a(f paramf, int paramInt, ar paramar, boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(325554);
    s.u(paramar, "this$0");
    if (paramBoolean)
    {
      paramString1 = (CharSequence)paramString2;
      if ((paramString1 == null) || (paramString1.length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        paramString1 = new HashMap();
        ((Map)paramString1).put("openId", paramString2);
        if (paramf == null) {
          break label120;
        }
        paramf.callback(paramInt, paramar.m("ok", (Map)paramString1));
        AppMethodBeat.o(325554);
        return;
      }
    }
    if (paramf != null) {
      paramf.callback(paramInt, paramar.ZP("fail"));
    }
    label120:
    AppMethodBeat.o(325554);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    e.b localb = null;
    AppMethodBeat.i(325561);
    String str1;
    Object localObject;
    if (paramf == null)
    {
      str1 = null;
      localObject = (CharSequence)str1;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label79;
      }
    }
    label79:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label85;
      }
      if (paramf != null) {
        paramf.callback(paramInt, ZP("fail:appId is null"));
      }
      AppMethodBeat.o(325561);
      return;
      str1 = paramf.getAppId();
      break;
    }
    label85:
    String str2;
    if (paramJSONObject == null)
    {
      localObject = null;
      if (paramJSONObject != null) {
        break label190;
      }
      str2 = null;
      label99:
      if (paramJSONObject != null) {
        break label201;
      }
    }
    label190:
    label201:
    for (paramJSONObject = localb;; paramJSONObject = paramJSONObject.optString("nonceStr"))
    {
      localb = new e.b();
      localb.appId = str1;
      localb.signature = ((String)localObject);
      localb.KQX = str2;
      localb.KQY = paramJSONObject;
      ((e)h.ax(e.class)).a(paramf.getContext(), localb, new ar..ExternalSyntheticLambda0(paramf, paramInt, this));
      AppMethodBeat.o(325561);
      return;
      localObject = paramJSONObject.optString("signature");
      break;
      str2 = paramJSONObject.optString("groupId");
      break label99;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiAppBindGroup$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ar
 * JD-Core Version:    0.7.0.1
 */
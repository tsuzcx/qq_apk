package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.snackbar.b;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/share/JsApiShareVideoMessage;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends c<f>
{
  private static final int CTRL_INDEX = 957;
  private static final String NAME = "shareVideoMessage";
  public static final l.a suX;
  
  static
  {
    AppMethodBeat.i(326444);
    suX = new l.a((byte)0);
    AppMethodBeat.o(326444);
  }
  
  private static final void a(Activity paramActivity, f paramf, int paramInt, l paraml, ShareToConversationResult paramShareToConversationResult)
  {
    AppMethodBeat.i(326439);
    s.u(paraml, "this$0");
    if (paramShareToConversationResult == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiShareVideoMessage", "invoke, result is null");
      AppMethodBeat.o(326439);
      return;
    }
    Object localObject = aa.svM;
    localObject = aa.a.AY(paramShareToConversationResult.result);
    paramShareToConversationResult = (ShareToConversationResult)localObject;
    if (localObject == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiShareVideoMessage", "invoke, shareResult is null");
      paramShareToConversationResult = aa.svP;
    }
    Log.i("MicroMsg.AppBrand.JsApiShareVideoMessage", s.X("invoke, shareResult: ", paramShareToConversationResult));
    switch (b.$EnumSwitchMapping$0[paramShareToConversationResult.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(326439);
      return;
      b.u(paramActivity, paramActivity.getString(ba.i.finish_sent));
      paramf.callback(paramInt, paraml.ZP("ok"));
      AppMethodBeat.o(326439);
      return;
      paramf.callback(paramInt, paraml.ZP("cancel"));
      AppMethodBeat.o(326439);
      return;
      paramf.callback(paramInt, paraml.ZP("fail"));
    }
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(326450);
    if (paramf == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiShareVideoMessage", "invoke, env is null");
      AppMethodBeat.o(326450);
      return;
    }
    Object localObject1 = paramf.getContext();
    if ((localObject1 instanceof Activity)) {}
    for (Activity localActivity = (Activity)localObject1; localActivity == null; localActivity = null)
    {
      Log.w("MicroMsg.AppBrand.JsApiShareVideoMessage", "invoke, activity is null");
      paramf.callback(paramInt, ZP("fail:activity is null"));
      AppMethodBeat.o(326450);
      return;
    }
    if (paramJSONObject == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiShareVideoMessage", "invoke, data is null");
      paramf.callback(paramInt, ZP("fail:data is null"));
      AppMethodBeat.o(326450);
      return;
    }
    localObject1 = paramJSONObject.optString("videoPath");
    Object localObject2 = (CharSequence)localObject1;
    if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.w("MicroMsg.AppBrand.JsApiShareVideoMessage", "invoke, videoPath is empty");
      paramf.callback(paramInt, ZP("fail:videoPath is empty"));
      AppMethodBeat.o(326450);
      return;
    }
    Log.i("MicroMsg.AppBrand.JsApiShareVideoMessage", s.X("invoke, videoPath: ", localObject1));
    localObject2 = paramf.getFileSystem();
    if (localObject2 == null)
    {
      localObject1 = null;
      localObject2 = (CharSequence)localObject1;
      if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
        break label301;
      }
    }
    label301:
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label307;
      }
      Log.w("MicroMsg.AppBrand.JsApiShareVideoMessage", "invoke, videoPath is illegal");
      paramf.callback(paramInt, ZP("fail:videoPath is illegal"));
      AppMethodBeat.o(326450);
      return;
      localObject1 = ((w)localObject2).Wm((String)localObject1);
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ah.v(((u)localObject1).jKT());
      break;
    }
    label307:
    Log.i("MicroMsg.AppBrand.JsApiShareVideoMessage", s.X("invoke, realVideoPath: ", localObject1));
    localObject2 = paramJSONObject.optString("thumbPath");
    paramJSONObject = paramf.getFileSystem();
    if (paramJSONObject == null) {
      paramJSONObject = null;
    }
    for (;;)
    {
      Log.i("MicroMsg.AppBrand.JsApiShareVideoMessage", "invoke, thumbPath: " + localObject2 + ", realThumbPath: " + paramJSONObject);
      a.a((Context)localActivity, (AppBrandProxyUIProcessTask.ProcessRequest)new ShareVideoToConversationRequest((String)localObject1, paramJSONObject), new l..ExternalSyntheticLambda0(localActivity, paramf, paramInt, this));
      AppMethodBeat.o(326450);
      return;
      paramJSONObject = paramJSONObject.Wm((String)localObject2);
      if (paramJSONObject == null) {
        paramJSONObject = null;
      } else {
        paramJSONObject = ah.v(paramJSONObject.jKT());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.l
 * JD-Core Version:    0.7.0.1
 */
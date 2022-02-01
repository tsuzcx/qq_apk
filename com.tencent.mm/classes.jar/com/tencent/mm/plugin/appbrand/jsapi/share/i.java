package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.snackbar.b;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/share/JsApiShareFileMessage;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends com.tencent.mm.plugin.appbrand.jsapi.c<f>
{
  private static final int CTRL_INDEX = 956;
  private static final String NAME = "shareFileMessage";
  public static final i.a suG;
  
  static
  {
    AppMethodBeat.i(326445);
    suG = new i.a((byte)0);
    AppMethodBeat.o(326445);
  }
  
  private static final void a(Activity paramActivity, f paramf, int paramInt, i parami, ShareToConversationResult paramShareToConversationResult)
  {
    AppMethodBeat.i(326442);
    s.u(parami, "this$0");
    if (paramShareToConversationResult == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiShareFileMessage", "invoke, result is null");
      AppMethodBeat.o(326442);
      return;
    }
    Object localObject = aa.svM;
    localObject = aa.a.AY(paramShareToConversationResult.result);
    paramShareToConversationResult = (ShareToConversationResult)localObject;
    if (localObject == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiShareFileMessage", "invoke, shareResult is null");
      paramShareToConversationResult = aa.svP;
    }
    Log.i("MicroMsg.AppBrand.JsApiShareFileMessage", s.X("invoke, shareResult: ", paramShareToConversationResult));
    switch (b.$EnumSwitchMapping$0[paramShareToConversationResult.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(326442);
      return;
      b.u(paramActivity, paramActivity.getString(ba.i.finish_sent));
      paramf.callback(paramInt, parami.ZP("ok"));
      AppMethodBeat.o(326442);
      return;
      paramf.callback(paramInt, parami.ZP("cancel"));
      AppMethodBeat.o(326442);
      return;
      paramf.callback(paramInt, parami.ZP("fail"));
    }
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(326451);
    if (paramf == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiShareFileMessage", "invoke, env is null");
      AppMethodBeat.o(326451);
      return;
    }
    Object localObject1 = paramf.getContext();
    if ((localObject1 instanceof Activity)) {}
    for (Activity localActivity = (Activity)localObject1; localActivity == null; localActivity = null)
    {
      Log.w("MicroMsg.AppBrand.JsApiShareFileMessage", "invoke, activity is null");
      paramf.callback(paramInt, ZP("fail:activity is null"));
      AppMethodBeat.o(326451);
      return;
    }
    if (paramJSONObject == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiShareFileMessage", "invoke, data is null");
      paramf.callback(paramInt, ZP("fail:data is null"));
      AppMethodBeat.o(326451);
      return;
    }
    localObject1 = paramJSONObject.optString("filePath");
    Object localObject2 = (CharSequence)localObject1;
    if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.w("MicroMsg.AppBrand.JsApiShareFileMessage", "invoke, filePath is empty");
      paramf.callback(paramInt, ZP("fail:filePath is empty"));
      AppMethodBeat.o(326451);
      return;
    }
    s.s(localObject1, "filePath");
    Object localObject3;
    if (n.U((String)localObject1, "wxfile://", false))
    {
      localObject2 = org.apache.commons.b.c.bKZ((String)localObject1);
      Log.i("MicroMsg.AppBrand.JsApiShareFileMessage", "invoke, filePath: " + localObject1 + ", fileExt: " + localObject2);
      localObject3 = paramf.getFileSystem();
      if (localObject3 != null) {
        break label318;
      }
      localObject1 = null;
      label255:
      localObject3 = (CharSequence)localObject1;
      if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
        break label449;
      }
    }
    label318:
    label449:
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label455;
      }
      Log.w("MicroMsg.AppBrand.JsApiShareFileMessage", "invoke, filePath is illegal");
      paramf.callback(paramInt, ZP("fail:filePath is illegal"));
      AppMethodBeat.o(326451);
      return;
      localObject2 = "";
      break;
      localObject3 = ((w)localObject3).Wm((String)localObject1);
      if (localObject3 == null)
      {
        localObject1 = null;
        break label255;
      }
      if (!n.U((String)localObject1, "wxfile://", false))
      {
        localObject1 = paramf.getFileSystem();
        if (localObject1 == null)
        {
          localObject1 = null;
          break label255;
        }
        localObject1 = ((w)localObject1).Wo(((u)localObject3).getName());
        if (localObject1 == null)
        {
          localObject1 = null;
          break label255;
        }
        if (y.qn(ah.v(((u)localObject3).jKT()), ah.v(((u)localObject1).jKT())))
        {
          localObject1 = ah.v(((u)localObject1).jKT());
          break label255;
        }
        localObject1 = null;
        break label255;
      }
      localObject1 = ah.v(((u)localObject3).jKT());
      break label255;
    }
    label455:
    Log.i("MicroMsg.AppBrand.JsApiShareFileMessage", s.X("invoke, realFilePath: ", localObject1));
    paramJSONObject = paramJSONObject.optString("fileName");
    Log.i("MicroMsg.AppBrand.JsApiShareFileMessage", s.X("invoke, fileName: ", paramJSONObject));
    a.a((Context)localActivity, (AppBrandProxyUIProcessTask.ProcessRequest)new ShareFileToConversationRequest((String)localObject1, (String)localObject2, paramJSONObject), new i..ExternalSyntheticLambda0(localActivity, paramf, paramInt, this));
    AppMethodBeat.o(326451);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.i
 * JD-Core Version:    0.7.0.1
 */
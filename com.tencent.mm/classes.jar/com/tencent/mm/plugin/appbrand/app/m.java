package com.tencent.mm.plugin.appbrand.app;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cp.f;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.jsapi.h5_interact.SendDataToMiniProgramFromH5Event;
import com.tencent.mm.plugin.appbrand.jsapi.webview.c;
import com.tencent.mm.plugin.appbrand.jsapi.webview.g.c;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.e;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/app/ServiceForWebViewAnyProcess;", "Lcom/tencent/mm/plugin/appbrand/app/ServiceForWebView;", "()V", "batchSyncWxaAttr", "", "usernameList", "", "", "html_bridge_invokeMiniProgramAPI", "binderID", "", "name", "args", "", "preloadEnv", "appId", "privateOpenWeappFunctionalPage", "uuid", "transferJson", "reportMiniProgramPageData", "Lcom/tencent/mm/vending/pipeline/Pipeline;", "sendDataToMiniProgram", "data", "webviewId", "BatchSyncWxaAttr", "PreloadCdnEnv", "PrivateOpenFunctionalPage", "SendDataToMiniProgram", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  extends l
{
  private static final void a(Parcel paramParcel, IPCVoid paramIPCVoid)
  {
    AppMethodBeat.i(317745);
    s.u(paramParcel, "$parcel");
    paramParcel.recycle();
    AppMethodBeat.o(317745);
  }
  
  private static final Integer c(Void paramVoid)
  {
    AppMethodBeat.i(317742);
    com.tencent.mm.vending.g.g.jJL().gM(new IllegalAccessError("Not Support XPC invoke for now"));
    AppMethodBeat.o(317742);
    return null;
  }
  
  public final e<Integer> UU(String paramString)
  {
    AppMethodBeat.i(50172);
    paramString = com.tencent.mm.cp.g.jPX().b(m..ExternalSyntheticLambda1.INSTANCE);
    s.s(paramString, "pipelineExt().`$ui` {\n  …turn@`$ui` null\n        }");
    paramString = (e)paramString;
    AppMethodBeat.o(50172);
    return paramString;
  }
  
  public final void UV(String paramString)
  {
    AppMethodBeat.i(50173);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new IPCString(paramString), m.b.class, null);
    AppMethodBeat.o(50173);
  }
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    AppMethodBeat.i(175113);
    Object localObject = c.sLo;
    localObject = c.Bw(paramInt);
    if (localObject != null)
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("name", paramString);
      localJSONObject.put("arg", paramObject);
      paramString = ah.aiuX;
      ((g.c)localObject).av(localJSONObject);
    }
    AppMethodBeat.o(175113);
  }
  
  public final void cG(List<String> paramList)
  {
    AppMethodBeat.i(50175);
    if (paramList == null)
    {
      AppMethodBeat.o(50175);
      return;
    }
    Parcel localParcel = Parcel.obtain();
    localParcel.setDataPosition(0);
    localParcel.writeStringList(paramList);
    localParcel.setDataPosition(0);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, localParcel, m.a.class, new m..ExternalSyntheticLambda0(localParcel));
    AppMethodBeat.o(50175);
  }
  
  public final void cN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(50176);
    if (paramString2 == null)
    {
      AppMethodBeat.o(50176);
      return;
    }
    if (paramString1 == null)
    {
      AppMethodBeat.o(50176);
      return;
    }
    Parcel localParcel = Parcel.obtain();
    localParcel.setDataPosition(0);
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    localParcel.setDataPosition(0);
    try
    {
      XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, localParcel, m.c.class);
      return;
    }
    finally
    {
      localParcel.recycle();
      AppMethodBeat.o(50176);
    }
  }
  
  public final void w(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(50174);
    String str = MainProcessIPCService.PROCESS_NAME;
    SendDataToMiniProgramFromH5Event localSendDataToMiniProgramFromH5Event = new SendDataToMiniProgramFromH5Event();
    localSendDataToMiniProgramFromH5Event.rZd = paramString1;
    localSendDataToMiniProgramFromH5Event.data = paramString2;
    localSendDataToMiniProgramFromH5Event.rZe = paramInt;
    paramString1 = ah.aiuX;
    XIPCInvoker.a(str, localSendDataToMiniProgramFromH5Event, m.d.class, null);
    AppMethodBeat.o(50174);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.m
 * JD-Core Version:    0.7.0.1
 */
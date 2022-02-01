package com.tencent.mm.plugin.appbrand.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cw.g;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.m;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.jsapi.h5_interact.SendDataToMiniProgramFromH5Event;
import com.tencent.mm.plugin.appbrand.jsapi.webview.c;
import com.tencent.mm.plugin.appbrand.jsapi.webview.g.c;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.e;
import java.util.List;
import kotlin.g.b.p;
import org.json.JSONObject;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/app/ServiceForWebViewAnyProcess;", "Lcom/tencent/mm/plugin/appbrand/app/ServiceForWebView;", "()V", "batchSyncWxaAttr", "", "usernameList", "", "", "html_bridge_invokeMiniProgramAPI", "binderID", "", "name", "args", "", "preloadEnv", "appId", "privateOpenWeappFunctionalPage", "uuid", "transferJson", "reportMiniProgramPageData", "Lcom/tencent/mm/vending/pipeline/Pipeline;", "sendDataToMiniProgram", "data", "webviewId", "BatchSyncWxaAttr", "PreloadCdnEnv", "PrivateOpenFunctionalPage", "SendDataToMiniProgram", "plugin-appbrand-integration_release"})
public final class l
  extends k
{
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    AppMethodBeat.i(175113);
    Object localObject = c.pGg;
    localObject = c.Bj(paramInt);
    if (localObject != null)
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("name", paramString);
      localJSONObject.put("arg", paramObject);
      ((g.c)localObject).al(localJSONObject);
      AppMethodBeat.o(175113);
      return;
    }
    AppMethodBeat.o(175113);
  }
  
  public final e<Integer> acu(String paramString)
  {
    AppMethodBeat.i(50172);
    paramString = g.ijP().b((a)f.nCM);
    p.j(paramString, "pipelineExt().`$ui` {\n  …turn@`$ui` null\n        }");
    paramString = (e)paramString;
    AppMethodBeat.o(50172);
    return paramString;
  }
  
  public final void acv(String paramString)
  {
    AppMethodBeat.i(50173);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new IPCString(paramString), b.class, null);
    AppMethodBeat.o(50173);
  }
  
  @SuppressLint({"Recycle"})
  public final void ba(List<String> paramList)
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
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, localParcel, a.class, (com.tencent.mm.ipcinvoker.f)new e(localParcel));
    AppMethodBeat.o(50175);
  }
  
  public final void cw(String paramString1, String paramString2)
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
      XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, localParcel, c.class);
      return;
    }
    finally
    {
      localParcel.recycle();
      AppMethodBeat.o(50176);
    }
  }
  
  public final void r(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(50174);
    String str = MainProcessIPCService.PROCESS_NAME;
    SendDataToMiniProgramFromH5Event localSendDataToMiniProgramFromH5Event = new SendDataToMiniProgramFromH5Event();
    localSendDataToMiniProgramFromH5Event.oTP = paramString1;
    localSendDataToMiniProgramFromH5Event.data = paramString2;
    localSendDataToMiniProgramFromH5Event.oTQ = paramInt;
    XIPCInvoker.a(str, localSendDataToMiniProgramFromH5Event, d.class, null);
    AppMethodBeat.o(50174);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/app/ServiceForWebViewAnyProcess$BatchSyncWxaAttr;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Parcel;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"})
  static final class a
    implements d<Parcel, IPCVoid>
  {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/app/ServiceForWebViewAnyProcess$PreloadCdnEnv;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"})
  static final class b
    implements d<IPCString, IPCVoid>
  {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/app/ServiceForWebViewAnyProcess$PrivateOpenFunctionalPage;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Landroid/os/Parcel;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "data", "plugin-appbrand-integration_release"})
  static final class c
    implements m<Parcel, IPCVoid>
  {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/app/ServiceForWebViewAnyProcess$SendDataToMiniProgram;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/appbrand/jsapi/h5_interact/SendDataToMiniProgramFromH5Event;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"})
  static final class d
    implements d<SendDataToMiniProgramFromH5Event, IPCVoid>
  {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class e<T>
    implements com.tencent.mm.ipcinvoker.f<ResultType>
  {
    e(Parcel paramParcel) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
  static final class f<_Ret, _Var>
    implements a<_Ret, _Var>
  {
    public static final f nCM;
    
    static
    {
      AppMethodBeat.i(50171);
      nCM = new f();
      AppMethodBeat.o(50171);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.l
 * JD-Core Version:    0.7.0.1
 */
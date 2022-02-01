package com.tencent.mm.plugin.appbrand.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.f;
import com.tencent.mm.co.g;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.jsapi.h5_interact.SendDataToMiniProgramFromH5Event;
import com.tencent.mm.vending.g.e;
import java.util.List;
import kotlin.g.b.p;
import org.json.JSONObject;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/app/ServiceForWebViewAnyProcess;", "Lcom/tencent/mm/plugin/appbrand/app/ServiceForWebView;", "()V", "batchSyncWxaAttr", "", "usernameList", "", "", "html_bridge_invokeMiniProgramAPI", "binderID", "", "name", "args", "", "preloadEnv", "appId", "privateOpenWeappFunctionalPage", "uuid", "transferJson", "reportMiniProgramPageData", "Lcom/tencent/mm/vending/pipeline/Pipeline;", "sendDataToMiniProgram", "data", "webviewId", "BatchSyncWxaAttr", "PreloadCdnEnv", "PrivateOpenFunctionalPage", "SendDataToMiniProgram", "plugin-appbrand-integration_release"})
public final class m
  extends l
{
  public final e<Integer> UK(String paramString)
  {
    AppMethodBeat.i(50172);
    paramString = g.hio().b((com.tencent.mm.vending.c.a)f.kIW);
    p.g(paramString, "pipelineExt().`$ui` {\n  …turn@`$ui` null\n        }");
    paramString = (e)paramString;
    AppMethodBeat.o(50172);
    return paramString;
  }
  
  public final void UL(String paramString)
  {
    AppMethodBeat.i(50173);
    XIPCInvoker.a(MainProcessIPCService.dkO, new IPCString(paramString), m.b.class, null);
    AppMethodBeat.o(50173);
  }
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    AppMethodBeat.i(175113);
    Object localObject = com.tencent.mm.plugin.appbrand.jsapi.af.b.mHb;
    localObject = com.tencent.mm.plugin.appbrand.jsapi.af.b.xL(paramInt);
    if (localObject != null)
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("name", paramString);
      localJSONObject.put("arg", paramObject);
      ((com.tencent.mm.plugin.appbrand.jsapi.af.a)localObject).ah(localJSONObject);
      AppMethodBeat.o(175113);
      return;
    }
    AppMethodBeat.o(175113);
  }
  
  @SuppressLint({"Recycle"})
  public final void bc(List<String> paramList)
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
    XIPCInvoker.a(MainProcessIPCService.dkO, localParcel, m.a.class, (d)new e(localParcel));
    AppMethodBeat.o(50175);
  }
  
  public final void cr(String paramString1, String paramString2)
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
      XIPCInvoker.a(MainProcessIPCService.dkO, localParcel, m.c.class);
      return;
    }
    finally
    {
      localParcel.recycle();
      AppMethodBeat.o(50176);
    }
  }
  
  public final void p(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(50174);
    String str = MainProcessIPCService.dkO;
    SendDataToMiniProgramFromH5Event localSendDataToMiniProgramFromH5Event = new SendDataToMiniProgramFromH5Event();
    localSendDataToMiniProgramFromH5Event.lWe = paramString1;
    localSendDataToMiniProgramFromH5Event.data = paramString2;
    localSendDataToMiniProgramFromH5Event.lWf = paramInt;
    XIPCInvoker.a(str, localSendDataToMiniProgramFromH5Event, d.class, null);
    AppMethodBeat.o(50174);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/app/ServiceForWebViewAnyProcess$SendDataToMiniProgram;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/appbrand/jsapi/h5_interact/SendDataToMiniProgramFromH5Event;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"})
  static final class d
    implements com.tencent.mm.ipcinvoker.b<SendDataToMiniProgramFromH5Event, IPCVoid>
  {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class e<T>
    implements d<ResultType>
  {
    e(Parcel paramParcel) {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
  static final class f<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    public static final f kIW;
    
    static
    {
      AppMethodBeat.i(50171);
      kIW = new f();
      AppMethodBeat.o(50171);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.m
 * JD-Core Version:    0.7.0.1
 */
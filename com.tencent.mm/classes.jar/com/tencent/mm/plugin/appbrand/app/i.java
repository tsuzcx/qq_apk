package com.tencent.mm.plugin.appbrand.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.f;
import com.tencent.mm.cn.g;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.jsapi.h5_interact.SendDataToMiniProgramFromH5Event;
import com.tencent.mm.vending.g.e;
import d.g.b.k;
import d.l;
import java.util.List;
import org.json.JSONObject;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/app/ServiceForWebViewAnyProcess;", "Lcom/tencent/mm/plugin/appbrand/app/ServiceForWebView;", "()V", "batchSyncWxaAttr", "", "usernameList", "", "", "html_bridge_invokeMiniProgramAPI", "binderID", "", "name", "args", "", "preloadEnv", "appId", "privateOpenWeappFunctionalPage", "uuid", "transferJson", "reportMiniProgramPageData", "Lcom/tencent/mm/vending/pipeline/Pipeline;", "sendDataToMiniProgram", "data", "webviewId", "BatchSyncWxaAttr", "PreloadCdnEnv", "PrivateOpenFunctionalPage", "SendDataToMiniProgram", "plugin-appbrand-integration_release"})
public final class i
  extends h
{
  public final e<Integer> HJ(String paramString)
  {
    AppMethodBeat.i(50172);
    paramString = g.fBc().b((com.tencent.mm.vending.c.a)f.jkk);
    k.g(paramString, "pipelineExt().`$ui` {\n  …turn@`$ui` null\n        }");
    paramString = (e)paramString;
    AppMethodBeat.o(50172);
    return paramString;
  }
  
  public final void HK(String paramString)
  {
    AppMethodBeat.i(50173);
    XIPCInvoker.a("com.tencent.mm", new IPCString(paramString), i.b.class, null);
    AppMethodBeat.o(50173);
  }
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    AppMethodBeat.i(175113);
    Object localObject = com.tencent.mm.plugin.appbrand.jsapi.y.b.kYn;
    localObject = com.tencent.mm.plugin.appbrand.jsapi.y.b.te(paramInt);
    if (localObject != null)
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("name", paramString);
      localJSONObject.put("arg", paramObject);
      ((com.tencent.mm.plugin.appbrand.jsapi.y.a)localObject).V(localJSONObject);
      AppMethodBeat.o(175113);
      return;
    }
    AppMethodBeat.o(175113);
  }
  
  @SuppressLint({"Recycle"})
  public final void aR(List<String> paramList)
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
    XIPCInvoker.a("com.tencent.mm", localParcel, i.a.class, (d)new e(localParcel));
    AppMethodBeat.o(50175);
  }
  
  public final void cb(String paramString1, String paramString2)
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
    XIPCInvoker.a("com.tencent.mm", localParcel, i.c.class);
    localParcel.recycle();
    AppMethodBeat.o(50176);
  }
  
  public final void p(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(50174);
    SendDataToMiniProgramFromH5Event localSendDataToMiniProgramFromH5Event = new SendDataToMiniProgramFromH5Event();
    localSendDataToMiniProgramFromH5Event.ksh = paramString1;
    localSendDataToMiniProgramFromH5Event.data = paramString2;
    localSendDataToMiniProgramFromH5Event.ksi = paramInt;
    XIPCInvoker.a("com.tencent.mm", localSendDataToMiniProgramFromH5Event, d.class, null);
    AppMethodBeat.o(50174);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/app/ServiceForWebViewAnyProcess$SendDataToMiniProgram;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/appbrand/jsapi/h5_interact/SendDataToMiniProgramFromH5Event;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"})
  static final class d
    implements com.tencent.mm.ipcinvoker.b<SendDataToMiniProgramFromH5Event, IPCVoid>
  {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class e<T>
    implements d<ResultType>
  {
    e(Parcel paramParcel) {}
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
  static final class f<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    public static final f jkk;
    
    static
    {
      AppMethodBeat.i(50171);
      jkk = new f();
      AppMethodBeat.o(50171);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.i
 * JD-Core Version:    0.7.0.1
 */
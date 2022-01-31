package com.tencent.mm.plugin.appbrand.app;

import a.f.b.j;
import a.l;
import android.annotation.SuppressLint;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.g;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.jsapi.h5_interact.SendDataToMiniProgramFromH5Event;
import com.tencent.mm.vending.c.a;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/app/ServiceForWebViewAnyProcess;", "Lcom/tencent/mm/plugin/appbrand/app/ServiceForWebView;", "()V", "batchSyncWxaAttr", "", "usernameList", "", "", "preloadEnv", "appId", "privateOpenWeappFunctionalPage", "uuid", "transferJson", "reportMiniProgramPageData", "Lcom/tencent/mm/vending/pipeline/Pipeline;", "", "sendDataToMiniProgram", "data", "webviewId", "BatchSyncWxaAttr", "PreloadCdnEnv", "PrivateOpenFunctionalPage", "SendDataToMiniProgram", "plugin-appbrand-integration_release"})
public final class f
  extends e
{
  @SuppressLint({"Recycle"})
  public final void av(List<String> paramList)
  {
    AppMethodBeat.i(134465);
    if (paramList == null)
    {
      AppMethodBeat.o(134465);
      return;
    }
    Parcel localParcel = Parcel.obtain();
    localParcel.setDataPosition(0);
    localParcel.writeStringList(paramList);
    localParcel.setDataPosition(0);
    XIPCInvoker.a("com.tencent.mm", localParcel, f.a.class);
    localParcel.recycle();
    AppMethodBeat.o(134465);
  }
  
  public final void bt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(134466);
    if (paramString2 == null)
    {
      AppMethodBeat.o(134466);
      return;
    }
    if (paramString1 == null)
    {
      AppMethodBeat.o(134466);
      return;
    }
    Parcel localParcel = Parcel.obtain();
    localParcel.setDataPosition(0);
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    localParcel.setDataPosition(0);
    XIPCInvoker.a("com.tencent.mm", localParcel, c.class);
    localParcel.recycle();
    AppMethodBeat.o(134466);
  }
  
  public final void k(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(134464);
    SendDataToMiniProgramFromH5Event localSendDataToMiniProgramFromH5Event = new SendDataToMiniProgramFromH5Event();
    localSendDataToMiniProgramFromH5Event.hMk = paramString1;
    localSendDataToMiniProgramFromH5Event.data = paramString2;
    localSendDataToMiniProgramFromH5Event.hMl = paramInt;
    XIPCInvoker.a("com.tencent.mm", localSendDataToMiniProgramFromH5Event, f.d.class, null);
    AppMethodBeat.o(134464);
  }
  
  public final com.tencent.mm.vending.g.e<Integer> yj(String paramString)
  {
    AppMethodBeat.i(134462);
    paramString = g.dTg().b((a)f.e.gSR);
    j.p(paramString, "pipelineExt().`$ui` {\n  …turn@`$ui` null\n        }");
    paramString = (com.tencent.mm.vending.g.e)paramString;
    AppMethodBeat.o(134462);
    return paramString;
  }
  
  public final void yk(String paramString)
  {
    AppMethodBeat.i(134463);
    XIPCInvoker.a("com.tencent.mm", new IPCString(paramString), f.b.class, null);
    AppMethodBeat.o(134463);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/app/ServiceForWebViewAnyProcess$PrivateOpenFunctionalPage;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Landroid/os/Parcel;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "data", "plugin-appbrand-integration_release"})
  static final class c
    implements i<Parcel, IPCVoid>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.f
 * JD-Core Version:    0.7.0.1
 */
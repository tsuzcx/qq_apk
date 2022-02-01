package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.a;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsMpProcessIPCService;
import com.tencent.mm.network.aa;
import com.tencent.mm.plugin.webview.core.i;
import com.tencent.mm.plugin.webview.core.i.a;
import com.tencent.mm.plugin.webview.core.j;
import com.tencent.mm.protocal.protobuf.czo;
import com.tencent.mm.protocal.protobuf.dev;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.xweb.ao;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherDebugUtils;", "", "()V", "DOCKER_URL", "", "TAG", "enableDebugCookie", "", "enableDebugPatch", "getA8KeyUrlForDebug", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDebugCookie", "getDebugJsApiControlBytes", "Lcom/tencent/mm/protobuf/ByteString;", "getDebugPatchUrl", "httpGetForDebug", "savedFile", "Lcom/tencent/mm/vfs/VFSFile;", "receiveHeaders", "Lkotlin/Function1;", "", "", "Lkotlin/ParameterName;", "name", "headers", "", "setDebugCookie", "connection", "Lcom/tencent/mm/network/MMHttpUrlCronetConnection;", "jsapiRequest", "Lcom/tencent/mm/protocal/protobuf/JsApiRequest;", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class t
{
  public static final t vUU;
  
  static
  {
    AppMethodBeat.i(303303);
    vUU = new t();
    AppMethodBeat.o(303303);
  }
  
  public static final void a(aa paramaa)
  {
    AppMethodBeat.i(303260);
    s.u(paramaa, "connection");
    i.a locala = i.Wya;
    if (i.a.isp()) {
      paramaa.setRequestProperty("Cookie", dgv());
    }
    AppMethodBeat.o(303260);
  }
  
  public static final void a(dev paramdev)
  {
    AppMethodBeat.i(303265);
    s.u(paramdev, "jsapiRequest");
    Object localObject = i.Wya;
    if (i.a.isp())
    {
      paramdev = paramdev.aaKS;
      localObject = new czo();
      ((czo)localObject).key = "Cookie";
      ((czo)localObject).value = dgv();
      ah localah = ah.aiuX;
      paramdev.push(localObject);
    }
    AppMethodBeat.o(303265);
  }
  
  public static final boolean dgt()
  {
    AppMethodBeat.i(303271);
    i.a locala = i.Wya;
    if ((i.a.gTR()) && (j.cTb().getInt("debugPatchEnable", -1) == 1))
    {
      AppMethodBeat.o(303271);
      return true;
    }
    AppMethodBeat.o(303271);
    return false;
  }
  
  public static final String dgu()
  {
    AppMethodBeat.i(303278);
    Object localObject = i.Wya;
    if (i.a.gTR())
    {
      localObject = j.cTb().getString("debugPatchInfo", "");
      if (localObject != null)
      {
        AppMethodBeat.o(303278);
        return localObject;
      }
    }
    AppMethodBeat.o(303278);
    return "";
  }
  
  private static final String dgv()
  {
    AppMethodBeat.i(303291);
    String str = ToolsMpProcessIPCService.PROCESS_NAME;
    s.s(str, "PROCESS_NAME");
    IPCString localIPCString = (IPCString)a.a(str, (Parcelable)new IPCString("https://mp.weixin.qq.com/index/SetContainer"), t..ExternalSyntheticLambda0.INSTANCE);
    if (localIPCString == null) {}
    for (str = null;; str = localIPCString.value)
    {
      Log.d("MicroMsg.WebPrefetcherDebugUtils", "getCookieForDebug: %s", new Object[] { str });
      if (localIPCString != null) {
        break;
      }
      AppMethodBeat.o(303291);
      return "";
    }
    str = localIPCString.value;
    if (str == null)
    {
      AppMethodBeat.o(303291);
      return "";
    }
    AppMethodBeat.o(303291);
    return str;
  }
  
  private static final IPCString f(IPCString paramIPCString)
  {
    AppMethodBeat.i(303299);
    String str = ao.getCookie(paramIPCString.value);
    paramIPCString = str;
    if (str == null) {
      paramIPCString = "";
    }
    paramIPCString = new IPCString(paramIPCString);
    AppMethodBeat.o(303299);
    return paramIPCString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.t
 * JD-Core Version:    0.7.0.1
 */
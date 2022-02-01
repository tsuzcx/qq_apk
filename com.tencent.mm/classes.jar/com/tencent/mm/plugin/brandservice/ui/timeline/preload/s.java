package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.af.r;
import com.tencent.mm.plugin.appbrand.af.r.a;
import com.tencent.mm.plugin.brandservice.api.TransferRequestInfo;
import com.tencent.mm.plugin.brandservice.api.f;
import com.tencent.mm.plugin.brandservice.api.g.a;
import com.tencent.mm.plugin.webview.core.i;
import com.tencent.mm.plugin.webview.core.i.a;
import com.tencent.mm.plugin.webview.k.j.a;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.czo;
import com.tencent.mm.protocal.protobuf.dev;
import com.tencent.mm.protocal.protobuf.dew;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.vfs.u;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherContentManager;", "", "()V", "TAG", "", "enableFetchContentByWebTransfer", "", "Ljava/lang/Boolean;", "addJsApiRequestHeader", "", "jsApiRequest", "Lcom/tencent/mm/protocal/protobuf/JsApiRequest;", "key", "value", "canWebTransfer", "target", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchTarget;", "doFetchContentByWebTransfer", "", "reqUrl", "data", "prefetchHeaders", "", "callback", "Lcom/tencent/mm/plugin/brandservice/api/ITransferRequester$TransferRequestResultCallback;", "fetchContentByWebTransfer", "requestInfo", "Lcom/tencent/mm/plugin/brandservice/api/TransferRequestInfo;", "init", "onFetchContentResult", "response", "Lcom/tencent/mm/protocal/protobuf/JsApiResponse;", "errMsg", "FetchContentResult", "Reporter", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class s
{
  public static final s vUQ;
  private static Boolean vUR;
  
  static
  {
    AppMethodBeat.i(303301);
    vUQ = new s();
    AppMethodBeat.o(303301);
  }
  
  static int a(String paramString1, r.d paramd, String paramString2, Map<String, String> paramMap, final g.a parama)
  {
    Object localObject3 = null;
    int j = 1;
    AppMethodBeat.i(303257);
    Object localObject1 = (CharSequence)paramString2;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(303257);
      return 1;
    }
    localObject1 = i.Wya;
    Object localObject2;
    if (i.a.gTR())
    {
      localObject1 = com.tencent.mm.plugin.webview.f.c.WPT;
      localObject1 = com.tencent.mm.plugin.webview.f.c.a.iwy();
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject1 = paramd.dfX();
        if (localObject1 != null) {
          break label147;
        }
        localObject1 = null;
        label97:
        localObject2 = new JsapiPermissionWrapper((byte[])localObject1);
      }
      if (((JsapiPermissionWrapper)localObject2).sk(435)) {
        break label157;
      }
      Log.w("MicroMsg.WebPrefetcherContentManager", "fetchContentByWebTransfer has no permission of webTransfer and ignore");
    }
    label147:
    label157:
    for (i = 0;; i = 1)
    {
      if (i != 0) {
        break label163;
      }
      AppMethodBeat.o(303257);
      return 2;
      localObject1 = null;
      break;
      localObject1 = ((com.tencent.mm.bx.b)localObject1).Op;
      break label97;
    }
    label163:
    Log.i("MicroMsg.WebPrefetcherContentManager", "fetchContentByWebTransfer data: " + paramString2 + ", url: %s", new Object[] { paramString1 });
    Object localObject4;
    try
    {
      paramString2 = new JSONObject(paramString2);
      localObject1 = new TransferRequestInfo();
      ((TransferRequestInfo)localObject1).type = 2;
      ((TransferRequestInfo)localObject1).scope = paramString2.optString("scope");
      ((TransferRequestInfo)localObject1).url = paramString1;
      localObject2 = new dev();
      ((dev)localObject2).url = paramString1;
      ((dev)localObject2).method = 0;
      paramString1 = ah.aiuX;
      ((TransferRequestInfo)localObject1).vBl = ((dev)localObject2);
      paramString1 = ((TransferRequestInfo)localObject1).vBl;
      kotlin.g.b.s.s(paramString1, "jsApiRequest");
      t.a(paramString1);
      paramString1 = MMApplicationContext.getContext();
      localObject2 = com.tencent.mm.plugin.webview.k.j.Xta;
      localObject2 = j.a.iCS();
      localObject4 = MMApplicationContext.getContext();
      kotlin.g.b.s.s(localObject4, "getContext()");
      paramString1 = r.a(paramString1, (String)localObject2, (r.a)new com.tencent.mm.plugin.webview.k.j((Context)localObject4));
      localObject2 = ((TransferRequestInfo)localObject1).vBl;
      kotlin.g.b.s.s(localObject2, "jsApiRequest");
      a((dev)localObject2, "User-Agent", paramString1);
      if (paramMap != null)
      {
        paramString1 = paramMap.entrySet().iterator();
        while (paramString1.hasNext())
        {
          paramMap = (Map.Entry)paramString1.next();
          localObject2 = ((TransferRequestInfo)localObject1).vBl;
          kotlin.g.b.s.s(localObject2, "jsApiRequest");
          a((dev)localObject2, (String)paramMap.getKey(), (String)paramMap.getValue());
        }
      }
      localObject2 = paramString2.optJSONObject("header");
    }
    catch (Exception paramString1)
    {
      Log.printErrStackTrace("MicroMsg.WebPrefetcherContentManager", (Throwable)paramString1, "fetchContentByTransfer exception", new Object[0]);
      AppMethodBeat.o(303257);
      return 3;
    }
    if (localObject2 == null) {
      paramString1 = null;
    }
    for (;;)
    {
      label567:
      label709:
      label715:
      if (paramString1.hasNext())
      {
        localObject4 = (String)paramString1.next();
        paramMap = ((JSONObject)localObject2).optString((String)localObject4);
        paramString2 = paramMap;
        if (paramMap == null) {
          paramString2 = "";
        }
        paramMap = ((TransferRequestInfo)localObject1).vBl;
        kotlin.g.b.s.s(paramMap, "jsApiRequest");
        a(paramMap, (String)localObject4, paramString2);
        continue;
        paramString1 = ((JSONObject)localObject2).keys();
      }
      else
      {
        label588:
        label721:
        while (paramString1 == null)
        {
          paramString1 = paramd.vTz;
          if (paramString1 == null)
          {
            paramString1 = localObject3;
            if ((paramString1 == null) || (paramString1.jKS() != true)) {
              break label709;
            }
            i = 1;
            if (i != 0)
            {
              if (n.bp((CharSequence)paramd.dgg())) {
                break label715;
              }
              i = 1;
              if (i != 0)
              {
                paramString1 = ((TransferRequestInfo)localObject1).vBl;
                kotlin.g.b.s.s(paramString1, "jsApiRequest");
                a(paramString1, "x-wx-if-none-match", paramd.dgg());
              }
              if (n.bp((CharSequence)paramd.dgh())) {
                break label721;
              }
            }
          }
          for (i = j;; i = 0)
          {
            if (i != 0)
            {
              paramString1 = ((TransferRequestInfo)localObject1).vBl;
              kotlin.g.b.s.s(paramString1, "jsApiRequest");
              a(paramString1, "if-none-match", paramd.dgh());
            }
            ((f)h.ax(f.class)).a((TransferRequestInfo)localObject1, (g.a)new b(paramd, parama));
            AppMethodBeat.o(303257);
            return -1;
            paramString1 = paramString1.bii(paramd.dfT());
            break;
            i = 0;
            break label567;
            i = 0;
            break label588;
          }
        }
      }
    }
  }
  
  private static void a(dev paramdev, String paramString1, String paramString2)
  {
    AppMethodBeat.i(303266);
    Object localObject = (CharSequence)paramString1;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(303266);
      return;
    }
    Log.v("MicroMsg.WebPrefetcherContentManager", "fetchContentByTransfer request header key: " + paramString1 + ", value: " + paramString2);
    paramdev = paramdev.aaKS;
    localObject = new czo();
    ((czo)localObject).key = paramString1;
    ((czo)localObject).value = paramString2;
    paramString1 = ah.aiuX;
    paramdev.push(localObject);
    AppMethodBeat.o(303266);
  }
  
  public static final boolean dgr()
  {
    boolean bool2 = true;
    AppMethodBeat.i(303231);
    int i;
    if (vUR == null)
    {
      i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zgG, 1);
      if ((i == 1) || (BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED))
      {
        bool1 = true;
        vUR = Boolean.valueOf(bool1);
        Log.i("MicroMsg.WebPrefetcherContentManager", "initConfig enableFetchContentByWebTransfer config: " + i + ", enable: " + vUR);
      }
    }
    else
    {
      localObject = i.Wya;
      if (!i.a.gTR()) {
        break label166;
      }
      i = com.tencent.mm.plugin.webview.core.j.cTb().getInt("debugTransfer", -1);
      if (i == -1) {
        break label166;
      }
      if (i != 1) {
        break label161;
      }
      bool1 = bool2;
    }
    label126:
    for (Object localObject = Boolean.valueOf(bool1);; localObject = null)
    {
      if (localObject != null) {
        break label171;
      }
      localObject = vUR;
      kotlin.g.b.s.checkNotNull(localObject);
      bool1 = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(303231);
      return bool1;
      bool1 = false;
      break;
      bool1 = false;
      break label126;
    }
    label161:
    label166:
    label171:
    boolean bool1 = ((Boolean)localObject).booleanValue();
    AppMethodBeat.o(303231);
    return bool1;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherContentManager$Reporter;", "", "()V", "reportFetchContentResult", "", "result", "", "reportStartFetchContentByWebTransfer", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a
  {
    public static final a vUS;
    
    static
    {
      AppMethodBeat.i(303011);
      vUS = new a();
      AppMethodBeat.o(303011);
    }
    
    public static void HI(int paramInt)
    {
      AppMethodBeat.i(303005);
      switch (paramInt)
      {
      default: 
        paramInt = -1;
      }
      for (;;)
      {
        if (paramInt != -1)
        {
          com.tencent.mm.plugin.webcanvas.j localj = com.tencent.mm.plugin.webcanvas.j.WkY;
          com.tencent.mm.plugin.webcanvas.j.xC(paramInt);
        }
        AppMethodBeat.o(303005);
        return;
        paramInt = 220;
        continue;
        paramInt = 221;
        continue;
        paramInt = 222;
        continue;
        paramInt = 223;
        continue;
        paramInt = 224;
        continue;
        paramInt = 225;
        continue;
        paramInt = 226;
        continue;
        paramInt = 227;
      }
    }
    
    public static void dgs()
    {
      AppMethodBeat.i(302998);
      com.tencent.mm.plugin.webcanvas.j localj = com.tencent.mm.plugin.webcanvas.j.WkY;
      com.tencent.mm.plugin.webcanvas.j.xC(219L);
      AppMethodBeat.o(302998);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherContentManager$fetchContentByWebTransfer$1", "Lcom/tencent/mm/plugin/brandservice/api/ITransferRequester$TransferRequestResultCallback;", "interceptRequest", "", "requestInfo", "Lcom/tencent/mm/plugin/brandservice/api/TransferRequestInfo;", "onResult", "", "errMsg", "", "response", "Lcom/tencent/mm/protocal/protobuf/JsApiResponse;", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements g.a
  {
    b(r.d paramd, g.a parama) {}
    
    public final void a(String paramString, dew paramdew)
    {
      AppMethodBeat.i(303006);
      s locals = s.vUQ;
      s.a(this.vUf, paramdew);
      parama.a(paramString, paramdew);
      AppMethodBeat.o(303006);
    }
    
    public final boolean a(TransferRequestInfo paramTransferRequestInfo)
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.s
 * JD-Core Version:    0.7.0.1
 */
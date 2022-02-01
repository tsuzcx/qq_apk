package com.tencent.mm.plugin.appbrand.jsapi.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.a.a.b;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.FileSystem.b;
import com.tencent.mm.vfs.k.f;
import com.tencent.mm.vfs.u;
import com.tencent.mm.wexnet.Options;
import com.tencent.mm.wexnet.SessionCreateResult;
import com.tencent.mm.wexnet.WeXNet;
import com.tencent.mm.wexnet.WeXNet.a;
import com.tencent.mm.wexnet.WeXNet.a.a;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.am;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/ai/JsApiCreateInferenceSession;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "activateCacheFiles", "", "cachePath", "", "invoke", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends c<f>
{
  public static final int CTRL_INDEX = 1091;
  public static final String NAME = "createInferenceSession";
  public static final a.a rCi;
  
  static
  {
    AppMethodBeat.i(325967);
    rCi = new a.a((byte)0);
    AppMethodBeat.o(325967);
  }
  
  private final void ZV(String paramString)
  {
    AppMethodBeat.i(325960);
    paramString = new u(paramString);
    if (paramString.isDirectory())
    {
      paramString = paramString.jKX();
      if (paramString != null)
      {
        int j = paramString.length;
        int i = 0;
        if (i < j)
        {
          Object localObject = paramString[i];
          if (((u)localObject).isDirectory())
          {
            localObject = com.tencent.mm.vfs.ah.v(((u)localObject).jKT());
            s.s(localObject, "it.absolutePath");
            ZV((String)localObject);
          }
          for (;;)
          {
            i += 1;
            break;
            long l = System.currentTimeMillis();
            localObject = ((u)localObject).jKM();
            if (((k.f)localObject).boj()) {
              ((k.f)localObject).agxM.cF(((k.f)localObject).path, l);
            }
          }
        }
      }
    }
    AppMethodBeat.o(325960);
  }
  
  private static final void a(f paramf, int paramInt, a parama, String paramString, u paramu)
  {
    AppMethodBeat.i(325964);
    s.u(parama, "this$0");
    s.u(paramString, "$cachePath");
    long l1;
    try
    {
      l1 = System.currentTimeMillis();
      localObject = WeXNet.Companion;
      paramu = com.tencent.mm.vfs.ah.v(paramu.mUri);
      s.s(paramu, "modelFile.path");
      paramu = WeXNet.a.tryCreateSession(paramu, new Options(1, paramString));
      long l2 = System.currentTimeMillis();
      Log.i("MicroMsg.JsApiCreateInferenceSession", "tryCreateSession cost[" + (l2 - l1) + ']');
      parama.ZV(paramString);
      paramString = paramf.T(com.tencent.mm.plugin.appbrand.a.a.class);
      s.checkNotNull(paramString);
      i = ((com.tencent.mm.plugin.appbrand.a.a)paramString).a(paramu.getSessionKeeper());
      if (paramu.getSuccess())
      {
        paramString = a.e.rVt;
        paramu = new HashMap();
        paramu.put("sessionId", s.X("", Integer.valueOf(i)));
        localObject = kotlin.ah.aiuX;
        paramf.callback(paramInt, parama.a(paramString, (Map)paramu));
        AppMethodBeat.o(325964);
        return;
      }
    }
    catch (WeXNet.a.a paramString)
    {
      paramf.callback(paramInt, parama.a(null, com.tencent.mm.plugin.appbrand.jsapi.g.a.a.rUB, null));
      AppMethodBeat.o(325964);
      return;
    }
    Object localObject = paramu.getCodes();
    int i = 0;
    int k = localObject.length;
    int j = 0;
    paramString = "";
    if (j < k)
    {
      l1 = localObject[j];
      StringBuilder localStringBuilder = new StringBuilder().append(paramString).append(l1).append(':');
      if (paramu.getDesc().length > i) {}
      for (paramString = paramu.getDesc()[i];; paramString = "")
      {
        paramString = paramString + '\n';
        j += 1;
        i += 1;
        break;
      }
    }
    i = com.tencent.mm.plugin.appbrand.jsapi.g.a.a.rUs.rVs;
    paramu = am.aixg;
    localObject = com.tencent.mm.plugin.appbrand.jsapi.g.a.a.rUs.errMsg;
    paramu = (u)localObject;
    if (localObject == null) {
      paramu = "";
    }
    paramString = String.format(paramu, Arrays.copyOf(new Object[] { paramString }, 1));
    s.s(paramString, "java.lang.String.format(format, *args)");
    paramf.callback(paramInt, parama.a(null, new a.d(i, paramString), null));
    AppMethodBeat.o(325964);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(325973);
    if (paramf == null)
    {
      AppMethodBeat.o(325973);
      return;
    }
    Object localObject = paramf.getFileSystem();
    if (localObject == null)
    {
      localObject = null;
      if ((localObject == null) || (!((u)localObject).jKV()))
      {
        paramf.callback(paramInt, a(null, com.tencent.mm.plugin.appbrand.jsapi.g.a.a.rUr, null));
        AppMethodBeat.o(325973);
      }
    }
    else
    {
      if (paramJSONObject == null) {}
      for (paramJSONObject = null;; paramJSONObject = paramJSONObject.optString("model"))
      {
        localObject = ((w)localObject).Wm(paramJSONObject);
        break;
      }
    }
    paramJSONObject = (b)paramf.T(b.class);
    if (paramJSONObject == null) {
      paramJSONObject = "";
    }
    for (;;)
    {
      Log.i("MicroMsg.JsApiCreateInferenceSession", "modelFile=" + localObject + "  cachePath=" + paramJSONObject);
      h.ahAA.bo(new a..ExternalSyntheticLambda0(paramf, paramInt, this, paramJSONObject, (u)localObject));
      AppMethodBeat.o(325973);
      return;
      String str = paramJSONObject.baj();
      paramJSONObject = str;
      if (str == null) {
        paramJSONObject = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.a.a
 * JD-Core Version:    0.7.0.1
 */
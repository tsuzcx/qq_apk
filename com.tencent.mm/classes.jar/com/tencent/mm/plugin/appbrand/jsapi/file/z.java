package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.luggage.l.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.d;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.p.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.Closeable;
import java.io.InputStream;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.f.b;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/file/JsApiLoadWAFileSync;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandSyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class z
  extends ab<g>
{
  private static final int CTRL_INDEX = 909;
  private static final String NAME = "loadWAFileSync";
  public static final a rXG;
  
  static
  {
    AppMethodBeat.i(329069);
    rXG = new a((byte)0);
    AppMethodBeat.o(329069);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/file/JsApiLoadWAFileSync$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "invokeSync", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi$CallResult;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "TAG", "data", "Lorg/json/JSONObject;", "invokeSync$luggage_wechat_full_sdk_release", "toDirectByteBuffer", "Ljava/nio/ByteBuffer;", "Ljava/io/InputStream;", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static p.a a(g paramg, String paramString, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(329166);
      s.u(paramg, "<this>");
      s.u(paramString, "TAG");
      if (paramJSONObject == null)
      {
        paramJSONObject = null;
        Log.i(paramString, "invokeSync with filename:" + paramJSONObject + ", appId:" + paramg.getAppId());
        localObject = (CharSequence)paramJSONObject;
        if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
          break label113;
        }
      }
      label113:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label118;
        }
        paramg = new p.a("fail:invalid data", new Object[0]);
        AppMethodBeat.o(329166);
        return paramg;
        paramJSONObject = paramJSONObject.optString("filename");
        break;
      }
      label118:
      Object localObject = paramg.cbl();
      if (localObject == null)
      {
        s.u(paramString, "$TAG");
        s.u(paramg, "$this_invokeSync");
        Log.e(paramString, s.X("invokeSync get NULL reader, appId:", paramg.getAppId()));
        paramg = new p.a("fail:internal error", new Object[0]);
        AppMethodBeat.o(329166);
        return paramg;
      }
      localObject = ((ICommLibReader)localObject).Lh(paramJSONObject);
      if (localObject != null)
      {
        paramg = (Closeable)localObject;
        try
        {
          paramString = (InputStream)paramg;
          paramJSONObject = z.rXG;
          paramJSONObject = ByteBuffer.allocateDirect(paramString.available());
          if ((paramString instanceof a)) {
            paramJSONObject.put(((a)paramString).ewT);
          }
          for (;;)
          {
            s.s(paramJSONObject, "buffer");
            paramString = new p.a("ok", new Object[0]).u("arrayBuffer", paramJSONObject);
            s.s(paramString, "CallResult(\"ok\").put(\"arrayBuffer\", buffer)");
            b.a(paramg, null);
            AppMethodBeat.o(329166);
            return paramString;
            paramJSONObject.put(ByteBuffer.wrap(d.T(paramString)));
          }
          s.u(paramString, "$TAG");
        }
        finally
        {
          try
          {
            AppMethodBeat.o(329166);
            throw paramString;
          }
          finally
          {
            b.a(paramg, paramString);
            AppMethodBeat.o(329166);
          }
        }
      }
      s.u(paramg, "$this_invokeSync");
      Log.e(paramString, "invokeSync filename(" + paramJSONObject + ") not found, appId:" + paramg.getAppId());
      paramg = new p.a("fail:file doesn't exist", new Object[0]);
      AppMethodBeat.o(329166);
      return paramg;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.z
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.lite.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.brandservice.api.TransferRequestInfo;
import com.tencent.mm.plugin.brandservice.api.f;
import com.tencent.mm.plugin.brandservice.api.g.a;
import com.tencent.mm.plugin.lite.api.e;
import com.tencent.mm.plugin.lite.api.e.a;
import com.tencent.mm.protocal.protobuf.czo;
import com.tencent.mm.protocal.protobuf.dev;
import com.tencent.mm.protocal.protobuf.dew;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/lite/jsapi/comms/LiteAppJsApiWebTransfer;", "Lcom/tencent/mm/plugin/lite/api/LiteAppJsApi;", "()V", "invoke", "", "appId", "", "data", "Lorg/json/JSONObject;", "isFromView", "", "runModel", "", "Companion", "luggage-lite-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
  extends e
{
  public static final a Kat;
  private static final String NAME;
  
  static
  {
    AppMethodBeat.i(271604);
    Kat = new a((byte)0);
    NAME = "webTransfer";
    AppMethodBeat.o(271604);
  }
  
  public final void a(String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(271614);
    Log.d("LiteAppJsApiWebTransfer", "Invoke webTransfer");
    if (paramJSONObject == null)
    {
      this.JZj.aJV("data is null");
      AppMethodBeat.o(271614);
      return;
    }
    paramString = new TransferRequestInfo();
    paramString.type = 2;
    paramString.scope = paramJSONObject.optString("scope");
    paramString.url = "";
    Object localObject1 = new dev();
    ((dev)localObject1).url = paramJSONObject.optString("reqUrl");
    ((dev)localObject1).aaKR = paramJSONObject.optInt("cgiCmdId");
    ((dev)localObject1).YSb = paramJSONObject.optString("reqBody");
    ((dev)localObject1).method = paramJSONObject.optInt("method");
    Object localObject2 = ah.aiuX;
    paramString.vBl = ((dev)localObject1);
    for (;;)
    {
      try
      {
        paramJSONObject = paramJSONObject.optString("header");
        s.s(paramJSONObject, "headerStr");
        if (((CharSequence)paramJSONObject).length() > 0)
        {
          i = 1;
          if (i != 0)
          {
            paramJSONObject = new JSONObject(paramJSONObject);
            localObject1 = paramJSONObject.keys();
            s.s(localObject1, "keyList");
            if (((Iterator)localObject1).hasNext())
            {
              Object localObject3 = (String)((Iterator)localObject1).next();
              String str = paramJSONObject.optString((String)localObject3);
              localObject2 = paramString.vBl.aaKS;
              czo localczo = new czo();
              localczo.key = ((String)localObject3);
              localczo.value = str;
              localObject3 = ah.aiuX;
              ((LinkedList)localObject2).push(localczo);
              continue;
            }
          }
        }
        int i = 0;
      }
      catch (Exception paramJSONObject)
      {
        Log.printErrStackTrace("LiteAppJsApiWebTransfer", (Throwable)paramJSONObject, "parseTransferRequestInfo exception", new Object[0]);
        ((f)h.ax(f.class)).a(paramString, (g.a)new b(this));
        AppMethodBeat.o(271614);
        return;
      }
    }
  }
  
  public final int fEx()
  {
    return 1;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/lite/jsapi/comms/LiteAppJsApiWebTransfer$Companion;", "", "()V", "NAME", "", "getNAME", "()Ljava/lang/String;", "TAG", "luggage-lite-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/lite/jsapi/comms/LiteAppJsApiWebTransfer$invoke$1", "Lcom/tencent/mm/plugin/brandservice/api/ITransferRequester$TransferRequestResultCallback;", "interceptRequest", "", "p0", "Lcom/tencent/mm/plugin/brandservice/api/TransferRequestInfo;", "onResult", "", "errMsg", "", "response", "Lcom/tencent/mm/protocal/protobuf/JsApiResponse;", "luggage-lite-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements g.a
  {
    b(p paramp) {}
    
    public final void a(String paramString, dew paramdew)
    {
      AppMethodBeat.i(271607);
      HashMap localHashMap = new HashMap();
      Object localObject;
      int i;
      if (paramdew == null)
      {
        localObject = null;
        Log.i("LiteAppJsApiWebTransfer", "webTransfer errMsg: %s, response: %s", new Object[] { paramString, localObject });
        if (paramdew == null) {
          break label308;
        }
        localHashMap.put("errCode", Integer.valueOf(paramdew.ret));
        localObject = paramdew.Kuf;
        paramString = (String)localObject;
        if (localObject == null) {
          paramString = "";
        }
        localHashMap.put("result", paramString);
        paramString = paramdew.aaKS;
        s.s(paramString, "response.header");
        if (((Collection)paramString).isEmpty()) {
          break label231;
        }
        i = 1;
        label111:
        if (i == 0) {
          break label250;
        }
        paramString = new JSONObject();
        localObject = paramdew.aaKS;
        s.s(localObject, "response.header");
        localObject = ((Iterable)localObject).iterator();
      }
      label148:
      label231:
      label239:
      for (;;)
      {
        if (!((Iterator)localObject).hasNext()) {
          break label241;
        }
        czo localczo = (czo)((Iterator)localObject).next();
        CharSequence localCharSequence = (CharSequence)localczo.key;
        if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label239;
          }
          paramString.put(localczo.key, localczo.value);
          break label148;
          localObject = Integer.valueOf(paramdew.ret);
          break;
          i = 0;
          break label111;
        }
      }
      label241:
      localHashMap.put("header", paramString);
      label250:
      if (paramdew.ret == 0)
      {
        p.a(this.Kau).az((Map)localHashMap);
        AppMethodBeat.o(271607);
        return;
      }
      paramString = p.a(this.Kau);
      paramdew = p.Kat;
      paramString.aJV(s.X(p.fUd(), ": fail"));
      AppMethodBeat.o(271607);
      return;
      label308:
      paramString = p.a(this.Kau);
      paramdew = p.Kat;
      paramString.aJV(s.X(p.fUd(), ": fail"));
      AppMethodBeat.o(271607);
    }
    
    public final boolean a(TransferRequestInfo paramTransferRequestInfo)
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.a.c.p
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.luggage.jsapi.br.a;
import com.tencent.mm.plugin.wepkg.event.DownloadBigPkgCompleteNotify;
import com.tencent.mm.plugin.wepkg.event.c;
import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.wepkg.model.g;
import com.tencent.mm.plugin.wepkg.model.j;
import com.tencent.mm.protocal.protobuf.aod;
import com.tencent.mm.protocal.protobuf.eya;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class q
  extends br<com.tencent.luggage.d.a>
{
  private com.tencent.mm.plugin.wepkg.event.a xwU;
  
  private static JSONObject azE(String paramString)
  {
    AppMethodBeat.i(186866);
    JSONObject localJSONObject = azF(paramString);
    if (localJSONObject == null)
    {
      AppMethodBeat.o(186866);
      return null;
    }
    paramString = new JSONObject();
    try
    {
      paramString.put("data", localJSONObject);
      label37:
      AppMethodBeat.o(186866);
      return paramString;
    }
    catch (JSONException localJSONException)
    {
      break label37;
    }
  }
  
  private static JSONObject azF(String paramString)
  {
    AppMethodBeat.i(186867);
    Object localObject1 = j.bcI(paramString);
    if (localObject1 == null)
    {
      Log.i("MicroMsg.JsApiGetWepkgFileList", "not exist wepkg[%s]", new Object[] { paramString });
      AppMethodBeat.o(186867);
      return null;
    }
    paramString = new JSONObject();
    try
    {
      paramString.put("version", ((WepkgVersion)localObject1).version);
      paramString.put("size", ((WepkgVersion)localObject1).JNT);
      localObject1 = new o(((WepkgVersion)localObject1).pkgPath);
      boolean bool = ((o)localObject1).exists();
      if (!bool)
      {
        AppMethodBeat.o(186867);
        return null;
      }
      Object localObject2 = new g((o)localObject1).JNe;
      if (localObject2 == null)
      {
        AppMethodBeat.o(186867);
        return null;
      }
      if (((eya)localObject2).Nvh != null)
      {
        localObject1 = new JSONArray();
        localObject2 = ((eya)localObject2).Nvh.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          aod localaod = (aod)((Iterator)localObject2).next();
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("rid", localaod.LzG);
          localJSONObject.put("size", localaod.oUq);
          localJSONObject.put("mimeType", localaod.LzI);
          ((JSONArray)localObject1).put(localJSONObject);
        }
      }
      AppMethodBeat.o(186867);
    }
    catch (JSONException localJSONException)
    {
      Log.e("MicroMsg.JsApiGetWepkgFileList", "errMsg:%s", new Object[] { localJSONException.getMessage() });
    }
    for (;;)
    {
      return paramString;
      paramString.put("fileList", localJSONException);
    }
  }
  
  public final void a(Context paramContext, final String paramString, final br.a parama)
  {
    AppMethodBeat.i(186865);
    Log.i("MicroMsg.JsApiGetWepkgFileList", "invokeInMM");
    paramContext = com.tencent.mm.plugin.webview.luggage.c.b.Zc(paramString);
    if (paramContext == null)
    {
      parama.i("invalid_params", null);
      AppMethodBeat.o(186865);
      return;
    }
    paramString = paramContext.optString("wepkgId");
    final int i = paramContext.optInt("loadType", 0);
    Log.i("MicroMsg.JsApiGetWepkgFileList", "wepkgId:[%s] loadType:[%d]", new Object[] { paramString, Integer.valueOf(i) });
    if (Util.isNullOrNil(paramString))
    {
      parama.i("null_data", null);
      AppMethodBeat.o(186865);
      return;
    }
    h.RTc.aX(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(186862);
        q.a(q.this, paramString, i, parama);
        AppMethodBeat.o(186862);
      }
    });
    AppMethodBeat.o(186865);
  }
  
  public final void b(com.tencent.luggage.d.b<com.tencent.luggage.d.a>.a paramb) {}
  
  public final int dTs()
  {
    return 1;
  }
  
  public final String name()
  {
    return "getWepkgFileList";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.q
 * JD-Core Version:    0.7.0.1
 */
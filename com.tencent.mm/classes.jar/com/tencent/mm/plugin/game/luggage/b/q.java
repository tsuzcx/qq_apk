package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.luggage.jsapi.br.a;
import com.tencent.mm.plugin.wepkg.event.DownloadBigPkgCompleteNotify;
import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.wepkg.model.g;
import com.tencent.mm.plugin.wepkg.model.j;
import com.tencent.mm.protocal.protobuf.ape;
import com.tencent.mm.protocal.protobuf.fiq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class q
  extends br<com.tencent.luggage.d.a>
{
  private com.tencent.mm.plugin.wepkg.event.a CBc;
  
  private static JSONObject aJq(String paramString)
  {
    AppMethodBeat.i(232054);
    JSONObject localJSONObject = aJr(paramString);
    if (localJSONObject == null)
    {
      AppMethodBeat.o(232054);
      return null;
    }
    paramString = new JSONObject();
    try
    {
      paramString.put("data", localJSONObject);
      label37:
      AppMethodBeat.o(232054);
      return paramString;
    }
    catch (JSONException localJSONException)
    {
      break label37;
    }
  }
  
  private static JSONObject aJr(String paramString)
  {
    AppMethodBeat.i(232055);
    Object localObject1 = j.boH(paramString);
    if (localObject1 == null)
    {
      Log.i("MicroMsg.JsApiGetWepkgFileList", "not exist wepkg[%s]", new Object[] { paramString });
      AppMethodBeat.o(232055);
      return null;
    }
    paramString = new JSONObject();
    try
    {
      paramString.put("version", ((WepkgVersion)localObject1).version);
      paramString.put("size", ((WepkgVersion)localObject1).QNm);
      localObject1 = new com.tencent.mm.vfs.q(((WepkgVersion)localObject1).pkgPath);
      boolean bool = ((com.tencent.mm.vfs.q)localObject1).ifE();
      if (!bool)
      {
        AppMethodBeat.o(232055);
        return null;
      }
      Object localObject2 = new g((com.tencent.mm.vfs.q)localObject1).QMx;
      if (localObject2 == null)
      {
        AppMethodBeat.o(232055);
        return null;
      }
      if (((fiq)localObject2).UIq != null)
      {
        localObject1 = new JSONArray();
        localObject2 = ((fiq)localObject2).UIq.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          ape localape = (ape)((Iterator)localObject2).next();
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("rid", localape.SCg);
          localJSONObject.put("size", localape.rWo);
          localJSONObject.put("mimeType", localape.SCi);
          ((JSONArray)localObject1).put(localJSONObject);
        }
        paramString.put("fileList", localObject1);
      }
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.JsApiGetWepkgFileList", "errMsg:%s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(232055);
      return null;
    }
    AppMethodBeat.o(232055);
    return paramString;
  }
  
  public final void a(Context paramContext, final String paramString, final br.a parama)
  {
    AppMethodBeat.i(232053);
    Log.i("MicroMsg.JsApiGetWepkgFileList", "invokeInMM");
    paramContext = com.tencent.mm.plugin.webview.luggage.c.c.agO(paramString);
    if (paramContext == null)
    {
      parama.i("invalid_params", null);
      AppMethodBeat.o(232053);
      return;
    }
    paramString = paramContext.optString("wepkgId");
    final int i = paramContext.optInt("loadType", 0);
    Log.i("MicroMsg.JsApiGetWepkgFileList", "wepkgId:[%s] loadType:[%d]", new Object[] { paramString, Integer.valueOf(i) });
    if (Util.isNullOrNil(paramString))
    {
      parama.i("null_data", null);
      AppMethodBeat.o(232053);
      return;
    }
    h.ZvG.be(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(231607);
        q.a(q.this, paramString, i, parama);
        AppMethodBeat.o(231607);
      }
    });
    AppMethodBeat.o(232053);
  }
  
  public final void b(b<com.tencent.luggage.d.a>.a paramb) {}
  
  public final int cDj()
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
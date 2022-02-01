package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.jsapi.bv;
import com.tencent.mm.plugin.webview.luggage.jsapi.bv.a;
import com.tencent.mm.plugin.wepkg.event.DownloadBigPkgCompleteNotify;
import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.wepkg.model.g;
import com.tencent.mm.plugin.wepkg.model.j;
import com.tencent.mm.protocal.protobuf.asx;
import com.tencent.mm.protocal.protobuf.gfd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class t
  extends bv<com.tencent.luggage.d.a>
{
  private com.tencent.mm.plugin.wepkg.event.a IuP;
  
  private static JSONObject aGc(String paramString)
  {
    AppMethodBeat.i(277141);
    JSONObject localJSONObject = aGd(paramString);
    if (localJSONObject == null)
    {
      AppMethodBeat.o(277141);
      return null;
    }
    paramString = new JSONObject();
    try
    {
      paramString.put("data", localJSONObject);
      label37:
      AppMethodBeat.o(277141);
      return paramString;
    }
    catch (JSONException localJSONException)
    {
      break label37;
    }
  }
  
  private static JSONObject aGd(String paramString)
  {
    AppMethodBeat.i(277146);
    Object localObject1 = j.bov(paramString);
    if (localObject1 == null)
    {
      Log.i("MicroMsg.JsApiGetWepkgFileList", "not exist wepkg[%s]", new Object[] { paramString });
      AppMethodBeat.o(277146);
      return null;
    }
    paramString = new JSONObject();
    try
    {
      paramString.put("version", ((WepkgVersion)localObject1).version);
      paramString.put("size", ((WepkgVersion)localObject1).XGK);
      localObject1 = new u(((WepkgVersion)localObject1).pkgPath);
      boolean bool = ((u)localObject1).jKS();
      if (!bool)
      {
        AppMethodBeat.o(277146);
        return null;
      }
      Object localObject2 = new g((u)localObject1).XFV;
      if (localObject2 == null)
      {
        AppMethodBeat.o(277146);
        return null;
      }
      if (((gfd)localObject2).accz != null)
      {
        localObject1 = new JSONArray();
        localObject2 = ((gfd)localObject2).accz.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          asx localasx = (asx)((Iterator)localObject2).next();
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("rid", localasx.ZCY);
          localJSONObject.put("size", localasx.vhE);
          localJSONObject.put("mimeType", localasx.ZDa);
          ((JSONArray)localObject1).put(localJSONObject);
        }
        paramString.put("fileList", localObject1);
      }
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.JsApiGetWepkgFileList", "errMsg:%s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(277146);
      return null;
    }
    AppMethodBeat.o(277146);
    return paramString;
  }
  
  public final void a(Context paramContext, final String paramString, final bv.a parama)
  {
    AppMethodBeat.i(277162);
    Log.i("MicroMsg.JsApiGetWepkgFileList", "invokeInMM");
    paramContext = com.tencent.mm.plugin.webview.luggage.c.c.ZL(paramString);
    if (paramContext == null)
    {
      parama.j("invalid_params", null);
      AppMethodBeat.o(277162);
      return;
    }
    paramString = paramContext.optString("wepkgId");
    final int i = paramContext.optInt("loadType", 0);
    Log.i("MicroMsg.JsApiGetWepkgFileList", "wepkgId:[%s] loadType:[%d]", new Object[] { paramString, Integer.valueOf(i) });
    if (Util.isNullOrNil(paramString))
    {
      parama.j("null_data", null);
      AppMethodBeat.o(277162);
      return;
    }
    h.ahAA.bm(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(277160);
        t.a(t.this, paramString, i, parama);
        AppMethodBeat.o(277160);
      }
    });
    AppMethodBeat.o(277162);
  }
  
  public final void b(b<com.tencent.luggage.d.a>.a paramb) {}
  
  public final int dgI()
  {
    return 1;
  }
  
  public final String name()
  {
    return "getWepkgFileList";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.t
 * JD-Core Version:    0.7.0.1
 */
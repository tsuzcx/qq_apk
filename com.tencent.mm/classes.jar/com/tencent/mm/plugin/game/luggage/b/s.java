package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.jsapi.bv;
import com.tencent.mm.plugin.webview.luggage.jsapi.bv.a;
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class s
  extends bv<a>
{
  private static JSONObject K(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(277142);
    Object localObject1 = j.bov(paramString);
    if (localObject1 == null)
    {
      Log.i("MicroMsg.JsApiGetWepkgFileInfo", "not exist wepkg[%s]", new Object[] { paramString });
      AppMethodBeat.o(277142);
      return null;
    }
    paramString = new JSONObject();
    JSONArray localJSONArray;
    try
    {
      paramString.put("version", ((WepkgVersion)localObject1).version);
      localObject1 = new u(((WepkgVersion)localObject1).pkgPath);
      boolean bool = ((u)localObject1).jKS();
      if (!bool)
      {
        AppMethodBeat.o(277142);
        return null;
      }
      localObject1 = new g((u)localObject1);
      Object localObject2 = ((g)localObject1).XFV;
      if (localObject2 == null)
      {
        AppMethodBeat.o(277142);
        return null;
      }
      if (((gfd)localObject2).accz != null)
      {
        localJSONArray = new JSONArray();
        localObject2 = ((gfd)localObject2).accz.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          asx localasx = (asx)((Iterator)localObject2).next();
          if (paramMap.keySet().contains(localasx.ZCY))
          {
            String str = (String)paramMap.get(localasx.ZCY);
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("rid", localasx.ZCY);
            localJSONObject.put("size", localasx.vhE);
            localJSONObject.put("mimeType", localasx.ZDa);
            localJSONObject.put("data", ((g)localObject1).oM(localasx.ZCY, str));
            localJSONArray.put(localJSONObject);
          }
        }
      }
      AppMethodBeat.o(277142);
    }
    catch (JSONException paramMap)
    {
      Log.e("MicroMsg.JsApiGetWepkgFileInfo", "errMsg:%s", new Object[] { paramMap.getMessage() });
    }
    for (;;)
    {
      return paramString;
      paramString.put("fileList", localJSONArray);
    }
  }
  
  public final void a(Context paramContext, String paramString, bv.a parama) {}
  
  public final void b(final b<a>.a paramb)
  {
    int i = 0;
    AppMethodBeat.i(277154);
    Log.i("MicroMsg.JsApiGetWepkgFileInfo", "invokeInOwn");
    Object localObject = paramb.eiZ.eif;
    if (localObject == null)
    {
      paramb.a("invalid_params", null);
      AppMethodBeat.o(277154);
      return;
    }
    final String str = ((JSONObject)localObject).optString("wepkgId");
    localObject = ((JSONObject)localObject).optJSONArray("files");
    if ((Util.isNullOrNil(str)) || (localObject == null) || (((JSONArray)localObject).length() == 0))
    {
      paramb.a("null_data", null);
      AppMethodBeat.o(277154);
      return;
    }
    Log.i("MicroMsg.JsApiGetWepkgFileInfo", "wepkgId:[%s] files:[%s]", new Object[] { str, ((JSONArray)localObject).toString() });
    final HashMap localHashMap = new HashMap();
    for (;;)
    {
      if (i < ((JSONArray)localObject).length()) {}
      try
      {
        JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
        localHashMap.put(localJSONObject.optString("rid"), localJSONObject.optString("format"));
        label162:
        i += 1;
        continue;
        h.ahAA.bm(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(277152);
            JSONObject localJSONObject2 = s.L(str, localHashMap);
            if (localJSONObject2 == null)
            {
              paramb.a("fail", null);
              AppMethodBeat.o(277152);
              return;
            }
            JSONObject localJSONObject1 = new JSONObject();
            try
            {
              localJSONObject1.put("data", localJSONObject2);
              label53:
              paramb.a("", localJSONObject1);
              AppMethodBeat.o(277152);
              return;
            }
            catch (JSONException localJSONException)
            {
              break label53;
            }
          }
        });
        AppMethodBeat.o(277154);
        return;
      }
      catch (JSONException localJSONException)
      {
        break label162;
      }
    }
  }
  
  public final int dgI()
  {
    return 0;
  }
  
  public final String name()
  {
    return "getWepkgFileInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.s
 * JD-Core Version:    0.7.0.1
 */
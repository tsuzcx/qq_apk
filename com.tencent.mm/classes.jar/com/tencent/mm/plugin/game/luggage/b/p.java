package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.luggage.jsapi.br.a;
import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.wepkg.model.g;
import com.tencent.mm.plugin.wepkg.model.j;
import com.tencent.mm.protocal.protobuf.ape;
import com.tencent.mm.protocal.protobuf.fiq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class p
  extends br<a>
{
  private static JSONObject D(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(230986);
    Object localObject1 = j.boH(paramString);
    if (localObject1 == null)
    {
      Log.i("MicroMsg.JsApiGetWepkgFileInfo", "not exist wepkg[%s]", new Object[] { paramString });
      AppMethodBeat.o(230986);
      return null;
    }
    paramString = new JSONObject();
    JSONArray localJSONArray;
    try
    {
      paramString.put("version", ((WepkgVersion)localObject1).version);
      localObject1 = new q(((WepkgVersion)localObject1).pkgPath);
      boolean bool = ((q)localObject1).ifE();
      if (!bool)
      {
        AppMethodBeat.o(230986);
        return null;
      }
      localObject1 = new g((q)localObject1);
      Object localObject2 = ((g)localObject1).QMx;
      if (localObject2 == null)
      {
        AppMethodBeat.o(230986);
        return null;
      }
      if (((fiq)localObject2).UIq != null)
      {
        localJSONArray = new JSONArray();
        localObject2 = ((fiq)localObject2).UIq.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          ape localape = (ape)((Iterator)localObject2).next();
          if (paramMap.keySet().contains(localape.SCg))
          {
            String str = (String)paramMap.get(localape.SCg);
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("rid", localape.SCg);
            localJSONObject.put("size", localape.rWo);
            localJSONObject.put("mimeType", localape.SCi);
            localJSONObject.put("data", ((g)localObject1).mW(localape.SCg, str));
            localJSONArray.put(localJSONObject);
          }
        }
      }
      AppMethodBeat.o(230986);
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
  
  public final void a(Context paramContext, String paramString, br.a parama) {}
  
  public final void b(final b<a>.a paramb)
  {
    int i = 0;
    AppMethodBeat.i(230982);
    Log.i("MicroMsg.JsApiGetWepkgFileInfo", "invokeInOwn");
    Object localObject = paramb.crh.cqn;
    if (localObject == null)
    {
      paramb.a("invalid_params", null);
      AppMethodBeat.o(230982);
      return;
    }
    final String str = ((JSONObject)localObject).optString("wepkgId");
    localObject = ((JSONObject)localObject).optJSONArray("files");
    if ((Util.isNullOrNil(str)) || (localObject == null) || (((JSONArray)localObject).length() == 0))
    {
      paramb.a("null_data", null);
      AppMethodBeat.o(230982);
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
        h.ZvG.be(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(231120);
            JSONObject localJSONObject2 = p.E(str, localHashMap);
            if (localJSONObject2 == null)
            {
              paramb.a("fail", null);
              AppMethodBeat.o(231120);
              return;
            }
            JSONObject localJSONObject1 = new JSONObject();
            try
            {
              localJSONObject1.put("data", localJSONObject2);
              label53:
              paramb.a("", localJSONObject1);
              AppMethodBeat.o(231120);
              return;
            }
            catch (JSONException localJSONException)
            {
              break label53;
            }
          }
        });
        AppMethodBeat.o(230982);
        return;
      }
      catch (JSONException localJSONException)
      {
        break label162;
      }
    }
  }
  
  public final int cDj()
  {
    return 0;
  }
  
  public final String name()
  {
    return "getWepkgFileInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.p
 * JD-Core Version:    0.7.0.1
 */
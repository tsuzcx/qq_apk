package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.f.h;
import com.tencent.f.i;
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
import com.tencent.mm.protocal.protobuf.aod;
import com.tencent.mm.protocal.protobuf.eya;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class p
  extends br<a>
{
  private static JSONObject x(String paramString, List paramList)
  {
    AppMethodBeat.i(186860);
    Object localObject1 = j.bcI(paramString);
    if (localObject1 == null)
    {
      Log.i("MicroMsg.JsApiGetWepkgFileInfo", "not exist wepkg[%s]", new Object[] { paramString });
      AppMethodBeat.o(186860);
      return null;
    }
    paramString = new JSONObject();
    JSONArray localJSONArray;
    try
    {
      paramString.put("version", ((WepkgVersion)localObject1).version);
      localObject1 = new o(((WepkgVersion)localObject1).pkgPath);
      boolean bool = ((o)localObject1).exists();
      if (!bool)
      {
        AppMethodBeat.o(186860);
        return null;
      }
      localObject1 = new g((o)localObject1);
      Object localObject2 = ((g)localObject1).JNe;
      if (localObject2 == null)
      {
        AppMethodBeat.o(186860);
        return null;
      }
      if (((eya)localObject2).Nvh != null)
      {
        localJSONArray = new JSONArray();
        localObject2 = ((eya)localObject2).Nvh.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          aod localaod = (aod)((Iterator)localObject2).next();
          if (paramList.contains(localaod.LzG))
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("rid", localaod.LzG);
            localJSONObject.put("size", localaod.oUq);
            localJSONObject.put("mimeType", localaod.LzI);
            localJSONObject.put("data", ((g)localObject1).bcD(localaod.LzG));
            localJSONArray.put(localJSONObject);
          }
        }
      }
      AppMethodBeat.o(186860);
    }
    catch (JSONException paramList)
    {
      Log.e("MicroMsg.JsApiGetWepkgFileInfo", "errMsg:%s", new Object[] { paramList.getMessage() });
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
    AppMethodBeat.i(186859);
    Log.i("MicroMsg.JsApiGetWepkgFileInfo", "invokeInOwn");
    Object localObject = paramb.ctb.csi;
    if (localObject == null)
    {
      paramb.c("invalid_params", null);
      AppMethodBeat.o(186859);
      return;
    }
    final String str = ((JSONObject)localObject).optString("wepkgId");
    localObject = ((JSONObject)localObject).optJSONArray("files");
    if ((Util.isNullOrNil(str)) || (localObject == null) || (((JSONArray)localObject).length() == 0))
    {
      paramb.c("null_data", null);
      AppMethodBeat.o(186859);
      return;
    }
    Log.i("MicroMsg.JsApiGetWepkgFileInfo", "wepkgId:[%s] files:[%s]", new Object[] { str, ((JSONArray)localObject).toString() });
    final ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      if (i < ((JSONArray)localObject).length()) {}
      try
      {
        localArrayList.add(((JSONArray)localObject).getString(i));
        label146:
        i += 1;
        continue;
        h.RTc.aX(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(186858);
            JSONObject localJSONObject2 = p.y(str, localArrayList);
            if (localJSONObject2 == null)
            {
              paramb.c("fail", null);
              AppMethodBeat.o(186858);
              return;
            }
            JSONObject localJSONObject1 = new JSONObject();
            try
            {
              localJSONObject1.put("data", localJSONObject2);
              label53:
              paramb.c("", localJSONObject1);
              AppMethodBeat.o(186858);
              return;
            }
            catch (JSONException localJSONException)
            {
              break label53;
            }
          }
        });
        AppMethodBeat.o(186859);
        return;
      }
      catch (JSONException localJSONException)
      {
        break label146;
      }
    }
  }
  
  public final int dTs()
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
package com.tencent.mm.plugin.lite.c;

import android.os.Bundle;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.LiteAppCenter;
import com.tencent.mm.plugin.lite.jsapi.a;
import com.tencent.mm.plugin.lite.jsapi.a.a;
import com.tencent.mm.plugin.lite.logic.b.a;
import com.tencent.mm.plugin.lite.logic.b.b;
import com.tencent.mm.plugin.lite.logic.c;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import org.xwalk.core.Log;

public class b
  extends a
{
  public final void j(final String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(217173);
    c.dfF();
    com.tencent.mm.plugin.lite.d.b localb = c.aoy(paramString);
    if (localb == null)
    {
      Log.w("LiteAppJsApiLogin", "get LiteAppInfo fail");
      this.uYz.YL("can not find liteApp from local storage");
      AppMethodBeat.o(217173);
      return;
    }
    final boolean[] arrayOfBoolean = new boolean[1];
    arrayOfBoolean[0] = false;
    Object localObject2 = null;
    String str = null;
    Object localObject1 = localObject2;
    try
    {
      if (paramJSONObject.has("url"))
      {
        localObject1 = localObject2;
        str = paramJSONObject.getString("url");
      }
      localObject2 = str;
      if (str == null)
      {
        localObject1 = str;
        localObject2 = LiteAppCenter.getAuthUrl(localb.field_pkgPath, localb.field_appId, localb.field_signatureKey);
      }
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (!((String)localObject2).isEmpty()) {}
      }
      else
      {
        localObject1 = localObject2;
        Log.w("LiteAppJsApiLogin", "get authurl fail");
        localObject1 = localObject2;
        this.uYz.YL("get authUrl fail, please make sure config authUrl in config file");
        AppMethodBeat.o(217173);
        return;
      }
      long l = 60000L;
      localObject1 = localObject2;
      if (paramJSONObject.has("timeout"))
      {
        localObject1 = localObject2;
        l = paramJSONObject.getLong("timeout");
      }
      localObject1 = localObject2;
      h.LTJ.r(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(217170);
          synchronized (arrayOfBoolean)
          {
            if (arrayOfBoolean[0] == 0)
            {
              Log.w("LiteAppJsApiLogin", "geta8key timeout");
              arrayOfBoolean[0] = true;
              b.a(b.this).YL("getA8Key timeout");
            }
            AppMethodBeat.o(217170);
            return;
          }
        }
      }, l);
      localObject1 = localObject2;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        this.uYz.YL("json exception");
      }
    }
    com.tencent.mm.plugin.lite.logic.b.uYI.a((String)localObject1, new b.b()
    {
      public final void a(b.a paramAnonymousa)
      {
        AppMethodBeat.i(217172);
        synchronized (arrayOfBoolean)
        {
          if (arrayOfBoolean[0] == 0)
          {
            Log.i("LiteAppJsApiLogin", "geta8key:" + paramString);
            arrayOfBoolean[0] = true;
            LiteAppCenter.setAuthInfo(paramString, paramAnonymousa.uYN, paramAnonymousa.mHeaders, paramAnonymousa.uYO);
            new Bundle();
            JSONObject localJSONObject = new JSONObject();
            if (paramAnonymousa.uYO != null)
            {
              paramAnonymousa = paramAnonymousa.uYO.entrySet().iterator();
              while (paramAnonymousa.hasNext())
              {
                Map.Entry localEntry = (Map.Entry)paramAnonymousa.next();
                try
                {
                  localJSONObject.put((String)localEntry.getKey(), localEntry.getValue());
                }
                catch (JSONException localJSONException) {}
              }
            }
            b.c(b.this).aA(localJSONObject);
          }
          AppMethodBeat.o(217172);
          return;
        }
      }
      
      public final void onError()
      {
        AppMethodBeat.i(217171);
        synchronized (arrayOfBoolean)
        {
          if (arrayOfBoolean[0] == 0)
          {
            Log.w("LiteAppJsApiLogin", "geta8key fail");
            arrayOfBoolean[0] = true;
            b.b(b.this).YL("getA8Key fail");
          }
          AppMethodBeat.o(217171);
          return;
        }
      }
    });
    AppMethodBeat.o(217173);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.c.b
 * JD-Core Version:    0.7.0.1
 */
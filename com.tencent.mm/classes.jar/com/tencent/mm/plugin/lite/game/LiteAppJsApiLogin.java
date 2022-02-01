package com.tencent.mm.plugin.lite.game;

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

public class LiteAppJsApiLogin
  extends a
{
  public static final String NAME = "login";
  private static final String TAG = "LiteAppJsApiLogin";
  
  public void invoke(final String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(205696);
    c.cWu();
    com.tencent.mm.plugin.lite.d.b localb = c.ajL(paramString);
    if (localb == null)
    {
      Log.w("LiteAppJsApiLogin", "get LiteAppInfo fail");
      this.mInvokeCallback.Vc("can not find liteApp from local storage");
      AppMethodBeat.o(205696);
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
        this.mInvokeCallback.Vc("get authUrl fail, please make sure config authUrl in config file");
        AppMethodBeat.o(205696);
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
      h.JZN.q(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(205693);
          synchronized (arrayOfBoolean)
          {
            if (arrayOfBoolean[0] == 0)
            {
              Log.w("LiteAppJsApiLogin", "geta8key timeout");
              arrayOfBoolean[0] = true;
              LiteAppJsApiLogin.this.mInvokeCallback.Vc("getA8Key timeout");
            }
            AppMethodBeat.o(205693);
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
        this.mInvokeCallback.Vc("json exception");
      }
    }
    com.tencent.mm.plugin.lite.logic.b.tVZ.a((String)localObject1, new b.b()
    {
      public void onError()
      {
        AppMethodBeat.i(205694);
        synchronized (arrayOfBoolean)
        {
          if (arrayOfBoolean[0] == 0)
          {
            Log.w("LiteAppJsApiLogin", "geta8key fail");
            arrayOfBoolean[0] = true;
            LiteAppJsApiLogin.this.mInvokeCallback.Vc("getA8Key fail");
          }
          AppMethodBeat.o(205694);
          return;
        }
      }
      
      public void onSuccess(b.a paramAnonymousa)
      {
        AppMethodBeat.i(205695);
        Bundle localBundle;
        synchronized (arrayOfBoolean)
        {
          if (arrayOfBoolean[0] != 0) {
            break label169;
          }
          Log.i("LiteAppJsApiLogin", "geta8key:" + paramString);
          arrayOfBoolean[0] = true;
          LiteAppCenter.setAuthInfo(paramString, paramAnonymousa.tWe, paramAnonymousa.mHeaders, paramAnonymousa.tWf);
          localBundle = new Bundle();
          if (paramAnonymousa.tWf != null)
          {
            paramAnonymousa = paramAnonymousa.tWf.entrySet().iterator();
            if (paramAnonymousa.hasNext())
            {
              Map.Entry localEntry = (Map.Entry)paramAnonymousa.next();
              localBundle.putString((String)localEntry.getKey(), (String)localEntry.getValue());
            }
          }
        }
        LiteAppJsApiLogin.this.mInvokeCallback.af(localBundle);
        label169:
        AppMethodBeat.o(205695);
      }
    });
    AppMethodBeat.o(205696);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.game.LiteAppJsApiLogin
 * JD-Core Version:    0.7.0.1
 */
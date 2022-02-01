package com.tencent.mm.plugin.lite.a.c;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Bundle;
import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.LiteAppCenter;
import com.tencent.mm.plugin.lite.a.a;
import com.tencent.mm.plugin.lite.a.a.a;
import com.tencent.mm.plugin.lite.a.a.b;
import com.tencent.mm.plugin.lite.api.e;
import com.tencent.mm.plugin.lite.api.e.a;
import com.tencent.mm.plugin.lite.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.threadpool.i;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class g
  extends e
{
  public final void a(final String paramString, JSONObject paramJSONObject, final boolean paramBoolean)
  {
    AppMethodBeat.i(271598);
    com.tencent.mm.plugin.lite.logic.d.fUi();
    WxaLiteAppInfo localWxaLiteAppInfo = com.tencent.mm.plugin.lite.logic.d.et(paramString);
    if (localWxaLiteAppInfo == null)
    {
      Log.w("LiteAppJsApiLogin", "get LiteAppInfo fail");
      com.tencent.mm.plugin.report.service.h.OAn.p(1293L, 124L, 1L);
      this.JZj.aJV("can not find liteApp from local storage");
      AppMethodBeat.o(271598);
      return;
    }
    final boolean[] arrayOfBoolean = new boolean[1];
    arrayOfBoolean[0] = false;
    final String[] arrayOfString = new String[1];
    arrayOfString[0] = null;
    try
    {
      if (paramJSONObject.has("url")) {
        arrayOfString[0] = paramJSONObject.getString("url");
      }
      if (arrayOfString[0] == null) {
        arrayOfString[0] = LiteAppCenter.getAuthUrl(localWxaLiteAppInfo.path, localWxaLiteAppInfo.appId, localWxaLiteAppInfo.egI);
      }
      if ((arrayOfString[0] == null) || (arrayOfString[0].isEmpty()))
      {
        Log.w("LiteAppJsApiLogin", "get authurl fail");
        this.JZj.aJV("get authUrl fail, please make sure config authUrl in config file");
        AppMethodBeat.o(271598);
        return;
      }
      long l = 60000L;
      if (paramJSONObject.has("timeout")) {
        l = paramJSONObject.getLong("timeout");
      }
      com.tencent.threadpool.h.ahAA.p(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(271609);
          synchronized (arrayOfBoolean)
          {
            if (arrayOfBoolean[0] == 0)
            {
              Log.w("LiteAppJsApiLogin", "geta8key timeout");
              arrayOfBoolean[0] = true;
              g.a(g.this).aJV("getA8Key timeout");
            }
            AppMethodBeat.o(271609);
            return;
          }
        }
      }, l);
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        this.JZj.aJV("json exception");
      }
    }
    a.JZm.a(arrayOfString[0], new a.b()
    {
      public final void a(a.a paramAnonymousa)
      {
        AppMethodBeat.i(271622);
        synchronized (arrayOfBoolean)
        {
          com.tencent.mm.plugin.lite.storage.d locald;
          JSONObject localJSONObject;
          if (arrayOfBoolean[0] == 0)
          {
            Log.i("LiteAppJsApiLogin", "geta8key:" + paramString);
            arrayOfBoolean[0] = true;
            if ((paramString != null) && (c.JZa.contains(paramString))) {
              paramAnonymousa.mHeaders.put("referer", "https://game.weixin.qq.com/");
            }
            LiteAppCenter.setAuthInfo(paramString, paramAnonymousa.JZr, paramAnonymousa.mHeaders, paramAnonymousa.JZs, paramBoolean);
            locald = new com.tencent.mm.plugin.lite.storage.d();
            locald.field_host = arrayOfString[0];
            localJSONObject = new JSONObject();
            if (paramAnonymousa.JZs != null)
            {
              Iterator localIterator = paramAnonymousa.JZs.entrySet().iterator();
              while (localIterator.hasNext())
              {
                Map.Entry localEntry = (Map.Entry)localIterator.next();
                try
                {
                  localJSONObject.put((String)localEntry.getKey(), localEntry.getValue());
                }
                catch (JSONException localJSONException) {}
              }
            }
            locald.field_param = paramAnonymousa.JZr;
            locald.field_paramMap = localJSONObject.toString();
            locald.field_updateTime = (System.currentTimeMillis() / 1000L);
            locald.field_headerMap = new JSONObject(paramAnonymousa.mHeaders).toString();
            com.tencent.mm.plugin.lite.logic.d.fUi();
            paramAnonymousa = new Bundle();
            paramAnonymousa.putString("host", locald.field_host);
            paramAnonymousa.putString("param", locald.field_param);
            paramAnonymousa.putString("paramMap", locald.field_paramMap);
            paramAnonymousa.putString("headerMap", locald.field_headerMap);
            paramAnonymousa.putLong("updateTime", locald.field_updateTime);
          }
          try
          {
            MMApplicationContext.getContext().getContentResolver().call(com.tencent.mm.plugin.lite.logic.d.getUri(), "insertLiteAppAuthInfo", locald.field_host, paramAnonymousa);
            g.c(g.this).bq(localJSONObject);
            AppMethodBeat.o(271622);
            return;
          }
          catch (Exception paramAnonymousa)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.LiteApp.LiteAppLogic", paramAnonymousa, "", new Object[0]);
            }
          }
        }
      }
      
      public final void atR()
      {
        AppMethodBeat.i(271610);
        synchronized (arrayOfBoolean)
        {
          if (arrayOfBoolean[0] == 0)
          {
            Log.w("LiteAppJsApiLogin", "geta8key fail");
            arrayOfBoolean[0] = true;
            g.b(g.this).aJV("getA8Key fail");
          }
          AppMethodBeat.o(271610);
          return;
        }
      }
    });
    AppMethodBeat.o(271598);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.a.c.g
 * JD-Core Version:    0.7.0.1
 */
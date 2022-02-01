package com.tencent.mm.plugin.lite.jsapi.a;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Bundle;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.LiteAppCenter;
import com.tencent.mm.plugin.lite.b.f;
import com.tencent.mm.plugin.lite.jsapi.a;
import com.tencent.mm.plugin.lite.jsapi.a.a;
import com.tencent.mm.plugin.lite.jsapi.a.b;
import com.tencent.mm.plugin.lite.jsapi.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class b
  extends com.tencent.mm.plugin.lite.jsapi.b
{
  public final void a(final String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(198840);
    f.ecC();
    WxaLiteAppInfo localWxaLiteAppInfo = f.aCT(paramString);
    if (localWxaLiteAppInfo == null)
    {
      Log.w("LiteAppJsApiLogin", "get LiteAppInfo fail");
      this.yEn.aCS("can not find liteApp from local storage");
      AppMethodBeat.o(198840);
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
        arrayOfString[0] = LiteAppCenter.getAuthUrl(localWxaLiteAppInfo.path, localWxaLiteAppInfo.appId, localWxaLiteAppInfo.crh);
      }
      if ((arrayOfString[0] == null) || (arrayOfString[0].isEmpty()))
      {
        Log.w("LiteAppJsApiLogin", "get authurl fail");
        this.yEn.aCS("get authUrl fail, please make sure config authUrl in config file");
        AppMethodBeat.o(198840);
        return;
      }
      long l = 60000L;
      if (paramJSONObject.has("timeout")) {
        l = paramJSONObject.getLong("timeout");
      }
      h.RTc.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(198837);
          synchronized (arrayOfBoolean)
          {
            if (arrayOfBoolean[0] == 0)
            {
              Log.w("LiteAppJsApiLogin", "geta8key timeout");
              arrayOfBoolean[0] = true;
              b.a(b.this).aCS("getA8Key timeout");
            }
            AppMethodBeat.o(198837);
            return;
          }
        }
      }, l);
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        this.yEn.aCS("json exception");
      }
    }
    a.yEf.a(arrayOfString[0], new a.b()
    {
      public final void a(a.a paramAnonymousa)
      {
        AppMethodBeat.i(198839);
        synchronized (arrayOfBoolean)
        {
          com.tencent.mm.plugin.lite.storage.c localc;
          JSONObject localJSONObject;
          if (arrayOfBoolean[0] == 0)
          {
            Log.i("LiteAppJsApiLogin", "geta8key:" + paramString);
            arrayOfBoolean[0] = true;
            if ((paramString != null) && (com.tencent.mm.plugin.lite.c.yDV.contains(paramString))) {
              paramAnonymousa.mHeaders.put("referer", "https://game.weixin.qq.com/");
            }
            LiteAppCenter.setAuthInfo(paramString, paramAnonymousa.yEk, paramAnonymousa.mHeaders, paramAnonymousa.yEl);
            localc = new com.tencent.mm.plugin.lite.storage.c();
            localc.field_host = arrayOfString[0];
            localJSONObject = new JSONObject();
            if (paramAnonymousa.yEl != null)
            {
              Iterator localIterator = paramAnonymousa.yEl.entrySet().iterator();
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
            localc.field_param = paramAnonymousa.yEk;
            localc.field_paramMap = localJSONObject.toString();
            localc.field_updateTime = (System.currentTimeMillis() / 1000L);
            localc.field_headerMap = new JSONObject(paramAnonymousa.mHeaders).toString();
            f.ecC();
            paramAnonymousa = new Bundle();
            paramAnonymousa.putString("host", localc.field_host);
            paramAnonymousa.putString("param", localc.field_param);
            paramAnonymousa.putString("paramMap", localc.field_paramMap);
            paramAnonymousa.putString("headerMap", localc.field_headerMap);
            paramAnonymousa.putLong("updateTime", localc.field_updateTime);
          }
          try
          {
            MMApplicationContext.getContext().getContentResolver().call(f.getUri(), "insertLiteAppAuthInfo", localc.field_host, paramAnonymousa);
            b.c(b.this).aW(localJSONObject);
            AppMethodBeat.o(198839);
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
      
      public final void onError()
      {
        AppMethodBeat.i(198838);
        synchronized (arrayOfBoolean)
        {
          if (arrayOfBoolean[0] == 0)
          {
            Log.w("LiteAppJsApiLogin", "geta8key fail");
            arrayOfBoolean[0] = true;
            b.b(b.this).aCS("getA8Key fail");
          }
          AppMethodBeat.o(198838);
          return;
        }
      }
    });
    AppMethodBeat.o(198840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.jsapi.a.b
 * JD-Core Version:    0.7.0.1
 */
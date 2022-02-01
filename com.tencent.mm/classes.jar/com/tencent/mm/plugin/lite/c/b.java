package com.tencent.mm.plugin.lite.c;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Bundle;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.LiteAppCenter;
import com.tencent.mm.plugin.lite.d.e;
import com.tencent.mm.plugin.lite.jsapi.a;
import com.tencent.mm.plugin.lite.jsapi.a.a;
import com.tencent.mm.plugin.lite.logic.b.a;
import com.tencent.mm.plugin.lite.logic.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class b
  extends a
{
  public final void j(final String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(217783);
    com.tencent.mm.plugin.lite.logic.c.diz();
    e locale = com.tencent.mm.plugin.lite.logic.c.apC(paramString);
    if (locale == null)
    {
      ae.w("LiteAppJsApiLogin", "get LiteAppInfo fail");
      this.vko.ZC("can not find liteApp from local storage");
      AppMethodBeat.o(217783);
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
        arrayOfString[0] = LiteAppCenter.getAuthUrl(locale.field_pkgPath, locale.field_appId, locale.field_signatureKey);
      }
      if ((arrayOfString[0] == null) || (arrayOfString[0].isEmpty()))
      {
        ae.w("LiteAppJsApiLogin", "get authurl fail");
        this.vko.ZC("get authUrl fail, please make sure config authUrl in config file");
        AppMethodBeat.o(217783);
        return;
      }
      long l = 60000L;
      if (paramJSONObject.has("timeout")) {
        l = paramJSONObject.getLong("timeout");
      }
      h.MqF.r(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(217780);
          synchronized (arrayOfBoolean)
          {
            if (arrayOfBoolean[0] == 0)
            {
              ae.w("LiteAppJsApiLogin", "geta8key timeout");
              arrayOfBoolean[0] = true;
              b.a(b.this).ZC("getA8Key timeout");
            }
            AppMethodBeat.o(217780);
            return;
          }
        }
      }, l);
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        this.vko.ZC("json exception");
      }
    }
    com.tencent.mm.plugin.lite.logic.b.vky.a(arrayOfString[0], new b.b()
    {
      public final void a(b.a paramAnonymousa)
      {
        AppMethodBeat.i(217782);
        synchronized (arrayOfBoolean)
        {
          com.tencent.mm.plugin.lite.d.c localc;
          JSONObject localJSONObject;
          if (arrayOfBoolean[0] == 0)
          {
            ae.i("LiteAppJsApiLogin", "geta8key:" + paramString);
            arrayOfBoolean[0] = true;
            LiteAppCenter.setAuthInfo(paramString, paramAnonymousa.vkD, paramAnonymousa.mHeaders, paramAnonymousa.vkE);
            localc = new com.tencent.mm.plugin.lite.d.c();
            localc.field_host = arrayOfString[0];
            localJSONObject = new JSONObject();
            if (paramAnonymousa.vkE != null)
            {
              Iterator localIterator = paramAnonymousa.vkE.entrySet().iterator();
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
            localc.field_param = paramAnonymousa.vkD;
            localc.field_paramMap = localJSONObject.toString();
            localc.field_updateTime = (System.currentTimeMillis() / 1000L);
            localc.field_headerMap = new JSONObject(paramAnonymousa.mHeaders).toString();
            com.tencent.mm.plugin.lite.logic.c.diz();
            paramAnonymousa = new Bundle();
            paramAnonymousa.putString("host", localc.field_host);
            paramAnonymousa.putString("param", localc.field_param);
            paramAnonymousa.putString("paramMap", localc.field_paramMap);
            paramAnonymousa.putString("headerMap", localc.field_headerMap);
            paramAnonymousa.putLong("updateTime", localc.field_updateTime);
          }
          try
          {
            ak.getContext().getContentResolver().call(com.tencent.mm.plugin.lite.logic.c.getUri(), "insertLiteAppAuthInfo", localc.field_host, paramAnonymousa);
            b.c(b.this).aA(localJSONObject);
            AppMethodBeat.o(217782);
            return;
          }
          catch (Exception paramAnonymousa)
          {
            for (;;)
            {
              ae.printErrStackTrace("MicroMsg.LiteApp.LiteAppService", paramAnonymousa, "", new Object[0]);
            }
          }
        }
      }
      
      public final void onError()
      {
        AppMethodBeat.i(217781);
        synchronized (arrayOfBoolean)
        {
          if (arrayOfBoolean[0] == 0)
          {
            ae.w("LiteAppJsApiLogin", "geta8key fail");
            arrayOfBoolean[0] = true;
            b.b(b.this).ZC("getA8Key fail");
          }
          AppMethodBeat.o(217781);
          return;
        }
      }
    });
    AppMethodBeat.o(217783);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.c.b
 * JD-Core Version:    0.7.0.1
 */
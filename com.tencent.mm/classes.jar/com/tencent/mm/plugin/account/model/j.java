package com.tencent.mm.plugin.account.model;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.ui.r.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.i.a.a;
import com.tencent.mm.ui.i.a.a.1;
import com.tencent.mm.ui.i.a.a.a;
import com.tencent.mm.ui.i.a.c;
import com.tencent.mm.ui.i.a.e;
import com.tencent.mm.ui.i.a.f;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public final class j
{
  MMHandler handler;
  private c mZT;
  a mZU;
  
  public j(c paramc, a parama)
  {
    this.mZT = paramc;
    this.mZU = parama;
  }
  
  public final void bxF()
  {
    AppMethodBeat.i(127846);
    this.handler = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(127841);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(127841);
          return;
          if (j.this.mZU != null)
          {
            j.this.mZU.onError(paramAnonymousMessage.arg1, (String)paramAnonymousMessage.obj);
            AppMethodBeat.o(127841);
            return;
            if (j.this.mZU != null) {
              j.this.mZU.K(paramAnonymousMessage.getData());
            }
          }
        }
      }
    };
    Bundle localBundle = new Bundle();
    localBundle.putString("client_id", MMApplicationContext.getContext().getString(r.j.facebook_app_id));
    localBundle.putString("client_secret", MMApplicationContext.getContext().getString(r.j.facebook_client_secrect));
    localBundle.putString("grant_type", "fb_exchange_token");
    localBundle.putString("fb_exchange_token", this.mZT.mRq);
    a.a local2 = new a.a()
    {
      public final void a(FileNotFoundException paramAnonymousFileNotFoundException)
      {
        AppMethodBeat.i(127844);
        Log.e("MicroMsg.RefreshTokenRunner", "onFileNotFoundException");
        j.a(j.this, 2, paramAnonymousFileNotFoundException.getMessage());
        AppMethodBeat.o(127844);
      }
      
      public final void a(MalformedURLException paramAnonymousMalformedURLException)
      {
        AppMethodBeat.i(127845);
        Log.e("MicroMsg.RefreshTokenRunner", "onMalformedURLException");
        j.a(j.this, 2, paramAnonymousMalformedURLException.getMessage());
        AppMethodBeat.o(127845);
      }
      
      public final void aaT(String paramAnonymousString)
      {
        AppMethodBeat.i(127842);
        if ((paramAnonymousString == null) || (paramAnonymousString.length() == 0))
        {
          Log.e("MicroMsg.RefreshTokenRunner", "response is null or nil");
          j.a(j.this, 1, "response is null or nil");
          AppMethodBeat.o(127842);
          return;
        }
        Object localObject1;
        if ((paramAnonymousString.contains("access_token")) && (paramAnonymousString.length() > 12))
        {
          for (;;)
          {
            String str1;
            JSONArray localJSONArray;
            Object localObject3;
            String str2;
            try
            {
              localObject1 = f.bAs(paramAnonymousString);
              if (((JSONObject)localObject1).has("access_token"))
              {
                paramAnonymousString = new Bundle();
                localObject2 = ((JSONObject)localObject1).keys();
                if (!((Iterator)localObject2).hasNext()) {
                  break;
                }
                str1 = (String)((Iterator)localObject2).next();
                localJSONArray = ((JSONObject)localObject1).optJSONArray(str1);
                localObject3 = Double.valueOf(((JSONObject)localObject1).optDouble(str1));
                str2 = ((JSONObject)localObject1).optString(str1);
                if ((localJSONArray == null) || (localJSONArray.length() > 0)) {
                  break label189;
                }
                paramAnonymousString.putStringArray(str1, new String[0]);
                continue;
              }
              if (localJSONArray == null) {
                break label254;
              }
            }
            catch (Throwable paramAnonymousString)
            {
              Log.printErrStackTrace("MicroMsg.RefreshTokenRunner", paramAnonymousString, "", new Object[0]);
              j.a(j.this, 2, "decodeUrl fail");
              AppMethodBeat.o(127842);
              return;
            }
            label189:
            int i;
            if (!Double.isNaN(localJSONArray.optDouble(0)))
            {
              localObject3 = new double[localJSONArray.length()];
              i = 0;
              while (i < localJSONArray.length())
              {
                localObject3[i] = localJSONArray.optDouble(i);
                i += 1;
              }
              paramAnonymousString.putDoubleArray(str1, (double[])localObject3);
            }
            else
            {
              label254:
              if ((localJSONArray != null) && (localJSONArray.optString(0) != null))
              {
                localObject3 = new String[localJSONArray.length()];
                i = 0;
                while (i < localJSONArray.length())
                {
                  localObject3[i] = localJSONArray.optString(i);
                  i += 1;
                }
                paramAnonymousString.putStringArray(str1, (String[])localObject3);
              }
              else if (!((Double)localObject3).isNaN())
              {
                paramAnonymousString.putDouble(str1, ((Double)localObject3).doubleValue());
              }
              else if (str2 != null)
              {
                paramAnonymousString.putString(str1, str2);
              }
              else
              {
                System.err.println("unable to transform json to bundle ".concat(String.valueOf(str1)));
              }
            }
          }
          localObject1 = j.this;
          Object localObject2 = Message.obtain();
          ((Message)localObject2).what = 2;
          ((Message)localObject2).setData(paramAnonymousString);
          ((j)localObject1).handler.sendMessage((Message)localObject2);
          AppMethodBeat.o(127842);
          return;
        }
        try
        {
          f.bAs(paramAnonymousString);
          j.a(j.this, 2, "parseJson error");
          AppMethodBeat.o(127842);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          for (;;)
          {
            Log.e("MicroMsg.RefreshTokenRunner", "parseJson exception : " + paramAnonymousString.getMessage());
            Log.printErrStackTrace("MicroMsg.RefreshTokenRunner", paramAnonymousString, "", new Object[0]);
          }
        }
        catch (e paramAnonymousString)
        {
          localObject1 = "errCode = " + paramAnonymousString.mErrorCode + ", errType = " + paramAnonymousString.XHd + ", errMsg = " + paramAnonymousString.getMessage();
          Log.e("MicroMsg.RefreshTokenRunner", "parseJson facebookerror, ".concat(String.valueOf(localObject1)));
          Log.printErrStackTrace("MicroMsg.RefreshTokenRunner", paramAnonymousString, "", new Object[0]);
          j.a(j.this, 3, (String)localObject1);
          AppMethodBeat.o(127842);
        }
      }
      
      public final void c(IOException paramAnonymousIOException)
      {
        AppMethodBeat.i(127843);
        Log.e("MicroMsg.RefreshTokenRunner", "onIOException");
        j.a(j.this, 2, paramAnonymousIOException.getMessage());
        AppMethodBeat.o(127843);
      }
    };
    ThreadPool.post(new a.1(new a(this.mZT), "oauth/access_token", localBundle, "GET", local2), "AsyncFacebookRunner_request");
    AppMethodBeat.o(127846);
  }
  
  public static abstract interface a
  {
    public abstract void K(Bundle paramBundle);
    
    public abstract void onError(int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.j
 * JD-Core Version:    0.7.0.1
 */
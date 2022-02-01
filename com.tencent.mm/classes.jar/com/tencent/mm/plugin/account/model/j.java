package com.tencent.mm.plugin.account.model;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.g.a.a;
import com.tencent.mm.ui.g.a.a.1;
import com.tencent.mm.ui.g.a.a.a;
import com.tencent.mm.ui.g.a.c;
import com.tencent.mm.ui.g.a.e;
import com.tencent.mm.ui.g.a.f;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public final class j
{
  aq handler;
  private c jkr;
  a jks;
  
  public j(c paramc, a parama)
  {
    this.jkr = paramc;
    this.jks = parama;
  }
  
  public final void aSJ()
  {
    AppMethodBeat.i(127846);
    this.handler = new aq()
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
          if (j.this.jks != null)
          {
            j.this.jks.onError(paramAnonymousMessage.arg1, (String)paramAnonymousMessage.obj);
            AppMethodBeat.o(127841);
            return;
            if (j.this.jks != null) {
              j.this.jks.y(paramAnonymousMessage.getData());
            }
          }
        }
      }
    };
    Bundle localBundle = new Bundle();
    localBundle.putString("client_id", ak.getContext().getString(2131758773));
    localBundle.putString("client_secret", ak.getContext().getString(2131758788));
    localBundle.putString("grant_type", "fb_exchange_token");
    localBundle.putString("fb_exchange_token", this.jkr.jbU);
    a.a local2 = new a.a()
    {
      public final void Kp(String paramAnonymousString)
      {
        AppMethodBeat.i(127842);
        if ((paramAnonymousString == null) || (paramAnonymousString.length() == 0))
        {
          ae.e("MicroMsg.RefreshTokenRunner", "response is null or nil");
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
              localObject1 = f.aYF(paramAnonymousString);
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
              ae.printErrStackTrace("MicroMsg.RefreshTokenRunner", paramAnonymousString, "", new Object[0]);
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
          f.aYF(paramAnonymousString);
          j.a(j.this, 2, "parseJson error");
          AppMethodBeat.o(127842);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          for (;;)
          {
            ae.e("MicroMsg.RefreshTokenRunner", "parseJson exception : " + paramAnonymousString.getMessage());
            ae.printErrStackTrace("MicroMsg.RefreshTokenRunner", paramAnonymousString, "", new Object[0]);
          }
        }
        catch (e paramAnonymousString)
        {
          localObject1 = "errCode = " + paramAnonymousString.mErrorCode + ", errType = " + paramAnonymousString.KWC + ", errMsg = " + paramAnonymousString.getMessage();
          ae.e("MicroMsg.RefreshTokenRunner", "parseJson facebookerror, ".concat(String.valueOf(localObject1)));
          ae.printErrStackTrace("MicroMsg.RefreshTokenRunner", paramAnonymousString, "", new Object[0]);
          j.a(j.this, 3, (String)localObject1);
          AppMethodBeat.o(127842);
        }
      }
      
      public final void a(FileNotFoundException paramAnonymousFileNotFoundException)
      {
        AppMethodBeat.i(127844);
        ae.e("MicroMsg.RefreshTokenRunner", "onFileNotFoundException");
        j.a(j.this, 2, paramAnonymousFileNotFoundException.getMessage());
        AppMethodBeat.o(127844);
      }
      
      public final void a(MalformedURLException paramAnonymousMalformedURLException)
      {
        AppMethodBeat.i(127845);
        ae.e("MicroMsg.RefreshTokenRunner", "onMalformedURLException");
        j.a(j.this, 2, paramAnonymousMalformedURLException.getMessage());
        AppMethodBeat.o(127845);
      }
      
      public final void c(IOException paramAnonymousIOException)
      {
        AppMethodBeat.i(127843);
        ae.e("MicroMsg.RefreshTokenRunner", "onIOException");
        j.a(j.this, 2, paramAnonymousIOException.getMessage());
        AppMethodBeat.o(127843);
      }
    };
    b.c(new a.1(new a(this.jkr), "oauth/access_token", localBundle, "GET", local2), "AsyncFacebookRunner_request");
    AppMethodBeat.o(127846);
  }
  
  public static abstract interface a
  {
    public abstract void onError(int paramInt, String paramString);
    
    public abstract void y(Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.j
 * JD-Core Version:    0.7.0.1
 */
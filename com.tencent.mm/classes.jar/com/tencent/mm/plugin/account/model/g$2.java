package com.tencent.mm.plugin.account.model;

import android.os.Bundle;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.f.a.a.a;
import com.tencent.mm.ui.f.a.d;
import com.tencent.mm.ui.f.a.e;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

final class g$2
  implements a.a
{
  g$2(g paramg) {}
  
  public final void a(FileNotFoundException paramFileNotFoundException)
  {
    y.e("MicroMsg.RefreshTokenRunner", "onFileNotFoundException");
    g.a(this.fjz, 2, paramFileNotFoundException.getMessage());
  }
  
  public final void a(MalformedURLException paramMalformedURLException)
  {
    y.e("MicroMsg.RefreshTokenRunner", "onMalformedURLException");
    g.a(this.fjz, 2, paramMalformedURLException.getMessage());
  }
  
  public final void b(IOException paramIOException)
  {
    y.e("MicroMsg.RefreshTokenRunner", "onIOException");
    g.a(this.fjz, 2, paramIOException.getMessage());
  }
  
  public final void pW(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      y.e("MicroMsg.RefreshTokenRunner", "response is null or nil");
      g.a(this.fjz, 1, "response is null or nil");
      return;
    }
    Object localObject1;
    if ((paramString.contains("access_token")) && (paramString.length() > 12))
    {
      for (;;)
      {
        String str1;
        JSONArray localJSONArray;
        Object localObject3;
        String str2;
        try
        {
          localObject1 = e.aee(paramString);
          if (((JSONObject)localObject1).has("access_token"))
          {
            paramString = new Bundle();
            localObject2 = ((JSONObject)localObject1).keys();
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            str1 = (String)((Iterator)localObject2).next();
            localJSONArray = ((JSONObject)localObject1).optJSONArray(str1);
            localObject3 = Double.valueOf(((JSONObject)localObject1).optDouble(str1));
            str2 = ((JSONObject)localObject1).optString(str1);
            if ((localJSONArray == null) || (localJSONArray.length() > 0)) {
              break label174;
            }
            paramString.putStringArray(str1, new String[0]);
            continue;
          }
          if (localJSONArray == null) {
            break label239;
          }
        }
        catch (Throwable paramString)
        {
          y.printErrStackTrace("MicroMsg.RefreshTokenRunner", paramString, "", new Object[0]);
          g.a(this.fjz, 2, "decodeUrl fail");
          return;
        }
        label174:
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
          paramString.putDoubleArray(str1, (double[])localObject3);
        }
        else
        {
          label239:
          if ((localJSONArray != null) && (localJSONArray.optString(0) != null))
          {
            localObject3 = new String[localJSONArray.length()];
            i = 0;
            while (i < localJSONArray.length())
            {
              localObject3[i] = localJSONArray.optString(i);
              i += 1;
            }
            paramString.putStringArray(str1, (String[])localObject3);
          }
          else if (!((Double)localObject3).isNaN())
          {
            paramString.putDouble(str1, ((Double)localObject3).doubleValue());
          }
          else if (str2 != null)
          {
            paramString.putString(str1, str2);
          }
          else
          {
            System.err.println("unable to transform json to bundle " + str1);
          }
        }
      }
      localObject1 = this.fjz;
      Object localObject2 = Message.obtain();
      ((Message)localObject2).what = 2;
      ((Message)localObject2).setData(paramString);
      ((g)localObject1).handler.sendMessage((Message)localObject2);
      return;
    }
    try
    {
      e.aee(paramString);
      g.a(this.fjz, 2, "parseJson error");
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        y.e("MicroMsg.RefreshTokenRunner", "parseJson exception : " + paramString.getMessage());
        y.printErrStackTrace("MicroMsg.RefreshTokenRunner", paramString, "", new Object[0]);
      }
    }
    catch (d paramString)
    {
      localObject1 = "errCode = " + paramString.mErrorCode + ", errType = " + paramString.vVV + ", errMsg = " + paramString.getMessage();
      y.e("MicroMsg.RefreshTokenRunner", "parseJson facebookerror, " + (String)localObject1);
      y.printErrStackTrace("MicroMsg.RefreshTokenRunner", paramString, "", new Object[0]);
      g.a(this.fjz, 3, (String)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.g.2
 * JD-Core Version:    0.7.0.1
 */
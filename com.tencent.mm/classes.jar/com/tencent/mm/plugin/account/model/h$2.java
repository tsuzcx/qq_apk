package com.tencent.mm.plugin.account.model;

import android.os.Bundle;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.g.a.a.a;
import com.tencent.mm.ui.g.a.e;
import com.tencent.mm.ui.g.a.f;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

final class h$2
  implements a.a
{
  h$2(h paramh) {}
  
  public final void a(FileNotFoundException paramFileNotFoundException)
  {
    AppMethodBeat.i(124691);
    ab.e("MicroMsg.RefreshTokenRunner", "onFileNotFoundException");
    h.a(this.gAR, 2, paramFileNotFoundException.getMessage());
    AppMethodBeat.o(124691);
  }
  
  public final void a(MalformedURLException paramMalformedURLException)
  {
    AppMethodBeat.i(124692);
    ab.e("MicroMsg.RefreshTokenRunner", "onMalformedURLException");
    h.a(this.gAR, 2, paramMalformedURLException.getMessage());
    AppMethodBeat.o(124692);
  }
  
  public final void c(IOException paramIOException)
  {
    AppMethodBeat.i(124690);
    ab.e("MicroMsg.RefreshTokenRunner", "onIOException");
    h.a(this.gAR, 2, paramIOException.getMessage());
    AppMethodBeat.o(124690);
  }
  
  public final void xs(String paramString)
  {
    AppMethodBeat.i(124689);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ab.e("MicroMsg.RefreshTokenRunner", "response is null or nil");
      h.a(this.gAR, 1, "response is null or nil");
      AppMethodBeat.o(124689);
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
          localObject1 = f.auM(paramString);
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
              break label189;
            }
            paramString.putStringArray(str1, new String[0]);
            continue;
          }
          if (localJSONArray == null) {
            break label254;
          }
        }
        catch (Throwable paramString)
        {
          ab.printErrStackTrace("MicroMsg.RefreshTokenRunner", paramString, "", new Object[0]);
          h.a(this.gAR, 2, "decodeUrl fail");
          AppMethodBeat.o(124689);
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
          paramString.putDoubleArray(str1, (double[])localObject3);
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
            System.err.println("unable to transform json to bundle ".concat(String.valueOf(str1)));
          }
        }
      }
      localObject1 = this.gAR;
      Object localObject2 = Message.obtain();
      ((Message)localObject2).what = 2;
      ((Message)localObject2).setData(paramString);
      ((h)localObject1).handler.sendMessage((Message)localObject2);
      AppMethodBeat.o(124689);
      return;
    }
    try
    {
      f.auM(paramString);
      h.a(this.gAR, 2, "parseJson error");
      AppMethodBeat.o(124689);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ab.e("MicroMsg.RefreshTokenRunner", "parseJson exception : " + paramString.getMessage());
        ab.printErrStackTrace("MicroMsg.RefreshTokenRunner", paramString, "", new Object[0]);
      }
    }
    catch (e paramString)
    {
      localObject1 = "errCode = " + paramString.mErrorCode + ", errType = " + paramString.Aoe + ", errMsg = " + paramString.getMessage();
      ab.e("MicroMsg.RefreshTokenRunner", "parseJson facebookerror, ".concat(String.valueOf(localObject1)));
      ab.printErrStackTrace("MicroMsg.RefreshTokenRunner", paramString, "", new Object[0]);
      h.a(this.gAR, 3, (String)localObject1);
      AppMethodBeat.o(124689);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.h.2
 * JD-Core Version:    0.7.0.1
 */
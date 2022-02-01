package com.tencent.mm.plugin.account.bind.ui;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.friend.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class GoogleFriendUI$b
  extends AsyncTask<Void, Void, Void>
{
  private Context mContext;
  private String mToken;
  private GoogleFriendUI.a mUj = GoogleFriendUI.a.mUh;
  
  private GoogleFriendUI$b(GoogleFriendUI paramGoogleFriendUI, Context paramContext, String paramString)
  {
    this.mContext = paramContext;
    this.mToken = paramString;
  }
  
  private void aav(String paramString)
  {
    AppMethodBeat.i(110086);
    JSONArray localJSONArray1 = new JSONObject(paramString).getJSONObject("feed").getJSONArray("entry");
    int i;
    Object localObject2;
    JSONArray localJSONArray2;
    Object localObject3;
    int j;
    if (localJSONArray1 != null)
    {
      i = 0;
      if (i < localJSONArray1.length())
      {
        paramString = "";
        localObject1 = localJSONArray1.getJSONObject(i).optJSONObject("id");
        localObject2 = localJSONArray1.getJSONObject(i).optJSONObject("title");
        localJSONArray2 = localJSONArray1.getJSONObject(i).optJSONArray("gd$email");
        localObject3 = localJSONArray1.getJSONObject(i).optJSONArray("link");
        if (localObject1 == null) {
          break label440;
        }
        localObject1 = ((JSONObject)localObject1).getString("$t");
        j = ((String)localObject1).lastIndexOf("/");
        if (j <= 0) {
          break label440;
        }
      }
    }
    label440:
    for (Object localObject1 = ((String)localObject1).substring(j + 1);; localObject1 = "")
    {
      if (localObject2 != null) {}
      for (localObject2 = ((JSONObject)localObject2).getString("$t");; localObject2 = "")
      {
        String str1 = paramString;
        if (localObject3 != null)
        {
          j = 0;
          for (;;)
          {
            str1 = paramString;
            if (j >= ((JSONArray)localObject3).length()) {
              break;
            }
            String str2 = ((JSONArray)localObject3).getJSONObject(j).getString("rel");
            int k = str2.lastIndexOf("#");
            str1 = paramString;
            if (k > 0)
            {
              str2 = str2.substring(k + 1);
              str1 = paramString;
              if (!TextUtils.isEmpty(str2))
              {
                str1 = paramString;
                if ("photo".equals(str2)) {
                  str1 = ((JSONArray)localObject3).getJSONObject(j).getString("href");
                }
              }
            }
            j += 1;
            paramString = str1;
          }
        }
        if (localJSONArray2 != null)
        {
          j = 0;
          while (j < localJSONArray2.length())
          {
            paramString = localJSONArray2.getJSONObject(j).getString("address");
            if ((!TextUtils.isEmpty(paramString)) && (Util.isValidEmail(paramString)) && (!paramString.equals(GoogleFriendUI.h(this.mUb))))
            {
              localObject3 = new n();
              ((n)localObject3).field_googleid = ((String)localObject1);
              ((n)localObject3).field_googleitemid = ((String)localObject1 + paramString);
              ((n)localObject3).field_googlename = ((String)localObject2);
              ((n)localObject3).field_googlephotourl = str1;
              ((n)localObject3).field_googlegmail = paramString;
              if (!GoogleFriendUI.f(this.mUb).containsKey(paramString))
              {
                GoogleFriendUI.e(this.mUb).add(localObject3);
                GoogleFriendUI.f(this.mUb).put(paramString, localObject3);
              }
            }
            j += 1;
          }
        }
        i += 1;
        break;
        AppMethodBeat.o(110086);
        return;
      }
    }
  }
  
  private Void bxu()
  {
    AppMethodBeat.i(110083);
    Log.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "doInBackground");
    int j = 0;
    int i = 1;
    for (;;)
    {
      int k;
      try
      {
        Log.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "startInde:%d, totalCount:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        String str = l("json", i, this.mToken);
        k = new JSONObject(str).getJSONObject("feed").getJSONObject("openSearch$totalResults").getInt("$t");
        if (k <= 0) {
          break label203;
        }
        aav(str);
      }
      catch (IOException localIOException)
      {
        this.mUj = GoogleFriendUI.a.mUg;
        Log.e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "IOException" + localIOException.getMessage());
        continue;
      }
      catch (JSONException localJSONException)
      {
        this.mUj = GoogleFriendUI.a.mUh;
        Log.e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "JSONException" + localJSONException.getMessage());
        continue;
        j = k;
      }
      if ((j == 0) || (GoogleFriendUI.g(this.mUb)))
      {
        this.mUj = GoogleFriendUI.a.mUe;
        AppMethodBeat.o(110083);
        return null;
        j = 0;
      }
      else
      {
        continue;
        label203:
        if (k - i > 100)
        {
          i += 100;
          j = 1;
        }
      }
    }
  }
  
  private static String l(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(110084);
    paramString1 = new URL("https://www.google.com/m8/feeds/contacts/default/property-email?alt=" + paramString1 + "&max-results=100&start-index=" + paramInt + "&access_token=" + paramString2);
    Log.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "requestURL:%s", new Object[] { paramString1.toString() });
    paramString1 = (HttpURLConnection)paramString1.openConnection();
    paramString1.setRequestMethod("GET");
    paramString1.setConnectTimeout(20000);
    paramInt = paramString1.getResponseCode();
    Log.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "responseCode:%d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 200)
    {
      paramString1 = paramString1.getInputStream();
      paramString2 = y(paramString1);
      paramString1.close();
      AppMethodBeat.o(110084);
      return paramString2;
    }
    if (paramInt == 401) {
      Log.e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "Server OAuth Error,Please Try Again.");
    }
    try
    {
      for (;;)
      {
        paramString1.getInputStream().close();
        paramString1.disconnect();
        AppMethodBeat.o(110084);
        return null;
        Log.e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "Unknow Error.");
      }
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        Log.e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", paramString2.getMessage());
      }
    }
  }
  
  private static String y(InputStream paramInputStream)
  {
    AppMethodBeat.i(110085);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[20480];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte, 0, 20480);
      if (i == -1) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    paramInputStream = new String(localByteArrayOutputStream.toByteArray(), "UTF-8");
    AppMethodBeat.o(110085);
    return paramInputStream;
  }
  
  protected final void onPreExecute()
  {
    AppMethodBeat.i(110082);
    super.onPreExecute();
    Log.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "onPreExecute");
    GoogleFriendUI.e(this.mUb).clear();
    GoogleFriendUI.f(this.mUb).clear();
    AppMethodBeat.o(110082);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.GoogleFriendUI.b
 * JD-Core Version:    0.7.0.1
 */
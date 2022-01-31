package com.tencent.mm.plugin.account.bind.ui;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.friend.a.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
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
  private GoogleFriendUI.a gvz = GoogleFriendUI.a.gvx;
  private Context mContext;
  private String mToken;
  
  private GoogleFriendUI$b(GoogleFriendUI paramGoogleFriendUI, Context paramContext, String paramString)
  {
    this.mContext = paramContext;
    this.mToken = paramString;
  }
  
  private Void apA()
  {
    AppMethodBeat.i(13659);
    ab.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "doInBackground");
    int j = 0;
    int i = 1;
    for (;;)
    {
      int k;
      try
      {
        ab.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "startInde:%d, totalCount:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        String str = f("json", i, this.mToken);
        k = new JSONObject(str).getJSONObject("feed").getJSONObject("openSearch$totalResults").getInt("$t");
        if (k <= 0) {
          break label205;
        }
        wT(str);
      }
      catch (IOException localIOException)
      {
        this.gvz = GoogleFriendUI.a.gvw;
        ab.e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "IOException" + localIOException.getMessage());
        continue;
      }
      catch (JSONException localJSONException)
      {
        this.gvz = GoogleFriendUI.a.gvx;
        ab.e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "JSONException" + localJSONException.getMessage());
        continue;
        j = k;
      }
      if ((j == 0) || (GoogleFriendUI.g(this.gvr)))
      {
        this.gvz = GoogleFriendUI.a.gvu;
        AppMethodBeat.o(13659);
        return null;
        j = 0;
      }
      else
      {
        continue;
        label205:
        if (k - i > 100)
        {
          i += 100;
          j = 1;
        }
      }
    }
  }
  
  private static String f(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(155795);
    paramString1 = new URL("https://www.google.com/m8/feeds/contacts/default/property-email?alt=" + paramString1 + "&max-results=100&start-index=" + paramInt + "&access_token=" + paramString2);
    ab.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "requestURL:%s", new Object[] { paramString1.toString() });
    paramString1 = (HttpURLConnection)paramString1.openConnection();
    paramString1.setRequestMethod("GET");
    paramString1.setConnectTimeout(20000);
    paramInt = paramString1.getResponseCode();
    ab.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "responseCode:%d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 200)
    {
      paramString1 = paramString1.getInputStream();
      paramString2 = w(paramString1);
      paramString1.close();
      AppMethodBeat.o(155795);
      return paramString2;
    }
    if (paramInt == 401) {
      ab.e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "Server OAuth Error,Please Try Again.");
    }
    try
    {
      for (;;)
      {
        paramString1.getInputStream().close();
        paramString1.disconnect();
        AppMethodBeat.o(155795);
        return null;
        ab.e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "Unknow Error.");
      }
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        ab.e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", paramString2.getMessage());
      }
    }
  }
  
  private static String w(InputStream paramInputStream)
  {
    AppMethodBeat.i(13660);
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
    AppMethodBeat.o(13660);
    return paramInputStream;
  }
  
  private void wT(String paramString)
  {
    AppMethodBeat.i(13661);
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
          break label447;
        }
        localObject1 = ((JSONObject)localObject1).getString("$t");
        j = ((String)localObject1).lastIndexOf("/");
        if (j <= 0) {
          break label447;
        }
      }
    }
    label447:
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
            if ((!TextUtils.isEmpty(paramString)) && (bo.apH(paramString)) && (!paramString.equals(GoogleFriendUI.h(this.gvr))))
            {
              localObject3 = new n();
              ((n)localObject3).field_googleid = ((String)localObject1);
              ((n)localObject3).field_googleitemid = ((String)localObject1 + paramString);
              ((n)localObject3).field_googlename = ((String)localObject2);
              ((n)localObject3).field_googlephotourl = str1;
              ((n)localObject3).field_googlegmail = paramString;
              if (!GoogleFriendUI.f(this.gvr).containsKey(paramString))
              {
                GoogleFriendUI.e(this.gvr).add(localObject3);
                GoogleFriendUI.f(this.gvr).put(paramString, localObject3);
              }
            }
            j += 1;
          }
        }
        i += 1;
        break;
        AppMethodBeat.o(13661);
        return;
      }
    }
  }
  
  protected final void onPreExecute()
  {
    AppMethodBeat.i(13658);
    super.onPreExecute();
    ab.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "onPreExecute");
    GoogleFriendUI.e(this.gvr).clear();
    GoogleFriendUI.f(this.gvr).clear();
    AppMethodBeat.o(13658);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.GoogleFriendUI.b
 * JD-Core Version:    0.7.0.1
 */
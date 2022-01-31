package com.tencent.mm.plugin.account.bind.ui;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.mm.plugin.account.friend.a.n;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
  private String fdD;
  private GoogleFriendUI.a fdP = GoogleFriendUI.a.fdN;
  private Context mContext;
  
  private GoogleFriendUI$b(GoogleFriendUI paramGoogleFriendUI, Context paramContext, String paramString)
  {
    this.mContext = paramContext;
    this.fdD = paramString;
  }
  
  private Void Wb()
  {
    y.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "doInBackground");
    int j = 0;
    int i = 1;
    for (;;)
    {
      int k;
      try
      {
        y.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "startInde:%d, totalCount:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        localObject = this.fdD;
        localObject = new URL("https://www.google.com/m8/feeds/contacts/default/property-email?alt=" + "json" + "&max-results=100&start-index=" + i + "&access_token=" + (String)localObject);
        y.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "requestURL:%s", new Object[] { ((URL)localObject).toString() });
        localObject = (HttpURLConnection)((URL)localObject).openConnection();
        ((HttpURLConnection)localObject).setRequestMethod("GET");
        ((HttpURLConnection)localObject).setConnectTimeout(20000);
        j = ((HttpURLConnection)localObject).getResponseCode();
        y.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "responseCode:%d", new Object[] { Integer.valueOf(j) });
        if (j != 200) {
          continue;
        }
        InputStream localInputStream = ((HttpURLConnection)localObject).getInputStream();
        localObject = t(localInputStream);
        localInputStream.close();
        k = new JSONObject((String)localObject).getJSONObject("feed").getJSONObject("openSearch$totalResults").getInt("$t");
        if (k <= 0) {
          break label359;
        }
        pD((String)localObject);
      }
      catch (IOException localIOException)
      {
        Object localObject;
        this.fdP = GoogleFriendUI.a.fdM;
        y.e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "IOException" + localIOException.getMessage());
        return null;
        j = 0;
        continue;
      }
      catch (JSONException localJSONException)
      {
        this.fdP = GoogleFriendUI.a.fdN;
        y.e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "JSONException" + localJSONException.getMessage());
        return null;
      }
      if ((j == 0) || (GoogleFriendUI.g(this.fdH)))
      {
        this.fdP = GoogleFriendUI.a.fdK;
        return null;
        if (j == 401)
        {
          y.e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "Server OAuth Error,Please Try Again.");
          ((HttpURLConnection)localObject).disconnect();
          localObject = null;
        }
        else
        {
          y.e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "Unknow Error.");
        }
      }
      else
      {
        j = k;
        continue;
        label359:
        if (k - i > 100)
        {
          i += 100;
          j = 1;
        }
      }
    }
  }
  
  private void pD(String paramString)
  {
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
          break label430;
        }
        localObject1 = ((JSONObject)localObject1).getString("$t");
        j = ((String)localObject1).lastIndexOf("/");
        if (j <= 0) {
          break label430;
        }
      }
    }
    label430:
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
            if ((!TextUtils.isEmpty(paramString)) && (bk.ZC(paramString)) && (!paramString.equals(GoogleFriendUI.h(this.fdH))))
            {
              localObject3 = new n();
              ((n)localObject3).field_googleid = ((String)localObject1);
              ((n)localObject3).field_googleitemid = ((String)localObject1 + paramString);
              ((n)localObject3).field_googlename = ((String)localObject2);
              ((n)localObject3).field_googlephotourl = str1;
              ((n)localObject3).field_googlegmail = paramString;
              if (!GoogleFriendUI.f(this.fdH).containsKey(paramString))
              {
                GoogleFriendUI.e(this.fdH).add(localObject3);
                GoogleFriendUI.f(this.fdH).put(paramString, localObject3);
              }
            }
            j += 1;
          }
        }
        i += 1;
        break;
        return;
      }
    }
  }
  
  private static String t(InputStream paramInputStream)
  {
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
    return new String(localByteArrayOutputStream.toByteArray(), "UTF-8");
  }
  
  protected final void onPreExecute()
  {
    super.onPreExecute();
    y.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "onPreExecute");
    GoogleFriendUI.e(this.fdH).clear();
    GoogleFriendUI.f(this.fdH).clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.GoogleFriendUI.b
 * JD-Core Version:    0.7.0.1
 */
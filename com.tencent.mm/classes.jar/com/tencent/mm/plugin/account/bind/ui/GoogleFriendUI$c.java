package com.tencent.mm.plugin.account.bind.ui;

import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.friend.a.m;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

final class GoogleFriendUI$c
  extends AsyncTask<Void, Void, Void>
{
  private String gsH;
  private boolean gsJ;
  private String gsL;
  
  public GoogleFriendUI$c(GoogleFriendUI paramGoogleFriendUI, String paramString)
  {
    this.gsL = paramString;
  }
  
  private Void apA()
  {
    AppMethodBeat.i(13665);
    ab.i("MicroMsg.GoogleContact.GoogleFriendUI", "doInBackground");
    try
    {
      String str = apR();
      ab.i("MicroMsg.GoogleContact.GoogleFriendUI", "refresh response:%s", new Object[] { str });
      this.gsH = new JSONObject(str).optString("access_token");
      this.gsJ = true;
      AppMethodBeat.o(13665);
      return null;
    }
    catch (ProtocolException localProtocolException)
    {
      for (;;)
      {
        ab.e("MicroMsg.GoogleContact.GoogleFriendUI", "ProtocolException:%s", new Object[] { localProtocolException.getMessage() });
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        ab.e("MicroMsg.GoogleContact.GoogleFriendUI", "MalformedURLException:%s", new Object[] { localMalformedURLException.getMessage() });
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ab.e("MicroMsg.GoogleContact.GoogleFriendUI", "IOException:%s", new Object[] { localIOException.getMessage() });
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ab.e("MicroMsg.GoogleContact.GoogleFriendUI", "JSONException:%s", new Object[] { localJSONException.getMessage() });
      }
    }
  }
  
  private String apR()
  {
    AppMethodBeat.i(155796);
    Object localObject1 = "";
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL("https://accounts.google.com/o/oauth2/token").openConnection();
    localHttpURLConnection.setRequestProperty("Charset", "UTF-8");
    localHttpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
    localHttpURLConnection.setRequestMethod("POST");
    localHttpURLConnection.setConnectTimeout(20000);
    localHttpURLConnection.setReadTimeout(20000);
    localHttpURLConnection.setDoInput(true);
    localHttpURLConnection.setDoOutput(true);
    Object localObject2 = new ArrayList();
    ((List)localObject2).add(new BasicNameValuePair("refresh_token", this.gsL));
    ((List)localObject2).add(new BasicNameValuePair("client_id", "369820936870.apps.googleusercontent.com"));
    ((List)localObject2).add(new BasicNameValuePair("client_secret", "wcFhvo-s7wNcmQ9Zjr00H06u"));
    ((List)localObject2).add(new BasicNameValuePair("grant_type", "refresh_token"));
    localObject2 = m.as((List)localObject2);
    ab.i("MicroMsg.GoogleContact.GoogleFriendUI", "QueryString:%s".concat(String.valueOf(localObject2)));
    Object localObject3 = new BufferedWriter(new OutputStreamWriter(localHttpURLConnection.getOutputStream(), "UTF-8"));
    ((BufferedWriter)localObject3).write((String)localObject2);
    ((BufferedWriter)localObject3).flush();
    ((BufferedWriter)localObject3).close();
    int i = localHttpURLConnection.getResponseCode();
    ab.e("MicroMsg.GoogleContact.GoogleFriendUI", "responseCode:".concat(String.valueOf(i)));
    if (200 == i)
    {
      localObject1 = new StringBuffer();
      localObject2 = new BufferedReader(new InputStreamReader(localHttpURLConnection.getInputStream(), "UTF-8"));
      for (;;)
      {
        localObject3 = ((BufferedReader)localObject2).readLine();
        if (localObject3 == null) {
          break;
        }
        ((StringBuffer)localObject1).append((String)localObject3);
      }
      ((BufferedReader)localObject2).close();
      localObject1 = ((StringBuffer)localObject1).toString();
      ab.i("MicroMsg.GoogleContact.GoogleFriendUI", "exchange token respone:%s".concat(String.valueOf(localObject1)));
    }
    try
    {
      localHttpURLConnection.getInputStream().close();
      localHttpURLConnection.disconnect();
      AppMethodBeat.o(155796);
      return localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.GoogleContact.GoogleFriendUI", localException.getMessage());
      }
    }
  }
  
  protected final void onPreExecute()
  {
    AppMethodBeat.i(13664);
    super.onPreExecute();
    ab.i("MicroMsg.GoogleContact.GoogleFriendUI", "onPreExecute");
    this.gsJ = false;
    AppMethodBeat.o(13664);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.GoogleFriendUI.c
 * JD-Core Version:    0.7.0.1
 */
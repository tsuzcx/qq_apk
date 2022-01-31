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

final class BindGoogleContactUI$b
  extends AsyncTask<Void, Void, Void>
{
  private boolean csk;
  private String gsH;
  private String gsK;
  private String gsL;
  
  public BindGoogleContactUI$b(BindGoogleContactUI paramBindGoogleContactUI, String paramString)
  {
    this.gsK = paramString;
  }
  
  private Void apA()
  {
    AppMethodBeat.i(13361);
    try
    {
      String str = wN(this.gsK);
      this.gsH = new JSONObject(str).optString("access_token");
      this.gsL = new JSONObject(str).optString("refresh_token");
      ab.i("MicroMsg.GoogleContact.BindGoogleContactUI", "response:%s", new Object[] { str });
      ab.i("MicroMsg.GoogleContact.BindGoogleContactUI", "mAccessToken:%s", new Object[] { this.gsH });
      ab.i("MicroMsg.GoogleContact.BindGoogleContactUI", "mRefreshToken:%s", new Object[] { this.gsL });
      this.csk = true;
      AppMethodBeat.o(13361);
      return null;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        ab.e("MicroMsg.GoogleContact.BindGoogleContactUI", "MalformedURLException:%s" + localMalformedURLException.getMessage());
      }
    }
    catch (ProtocolException localProtocolException)
    {
      for (;;)
      {
        ab.e("MicroMsg.GoogleContact.BindGoogleContactUI", "ProtocolException:%s" + localProtocolException.getMessage());
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ab.e("MicroMsg.GoogleContact.BindGoogleContactUI", "IOException:%s" + localIOException.getMessage());
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ab.e("MicroMsg.GoogleContact.BindGoogleContactUI", "JSONException:%s" + localJSONException.getMessage());
      }
    }
  }
  
  private static String wN(String paramString)
  {
    AppMethodBeat.i(155794);
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
    ((List)localObject2).add(new BasicNameValuePair("code", paramString));
    ((List)localObject2).add(new BasicNameValuePair("client_id", "369820936870.apps.googleusercontent.com"));
    ((List)localObject2).add(new BasicNameValuePair("client_secret", "wcFhvo-s7wNcmQ9Zjr00H06u"));
    ((List)localObject2).add(new BasicNameValuePair("redirect_uri", "urn:ietf:wg:oauth:2.0:oob"));
    ((List)localObject2).add(new BasicNameValuePair("grant_type", "authorization_code"));
    paramString = m.as((List)localObject2);
    ab.i("MicroMsg.GoogleContact.BindGoogleContactUI", "QueryString:%s", new Object[] { paramString });
    localHttpURLConnection.setRequestProperty("Content-length", String.valueOf(paramString.getBytes().length));
    localObject2 = new BufferedWriter(new OutputStreamWriter(localHttpURLConnection.getOutputStream(), "UTF-8"));
    ((BufferedWriter)localObject2).write(paramString);
    ((BufferedWriter)localObject2).flush();
    ((BufferedWriter)localObject2).close();
    int i = localHttpURLConnection.getResponseCode();
    ab.e("MicroMsg.GoogleContact.BindGoogleContactUI", "responseCode:".concat(String.valueOf(i)));
    paramString = (String)localObject1;
    if (200 == i)
    {
      paramString = new StringBuffer();
      localObject1 = new BufferedReader(new InputStreamReader(localHttpURLConnection.getInputStream(), "UTF-8"));
      for (;;)
      {
        localObject2 = ((BufferedReader)localObject1).readLine();
        if (localObject2 == null) {
          break;
        }
        paramString.append((String)localObject2);
      }
      ((BufferedReader)localObject1).close();
      paramString = paramString.toString();
      ab.i("MicroMsg.GoogleContact.BindGoogleContactUI", "exchange token respone:%s", new Object[] { paramString });
    }
    try
    {
      localHttpURLConnection.getInputStream().close();
      localHttpURLConnection.disconnect();
      AppMethodBeat.o(155794);
      return paramString;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.GoogleContact.BindGoogleContactUI", localException.getMessage());
      }
    }
  }
  
  protected final void onPreExecute()
  {
    AppMethodBeat.i(13360);
    super.onPreExecute();
    ab.i("MicroMsg.GoogleContact.BindGoogleContactUI", "onPreExecute");
    this.gsH = "";
    this.gsL = "";
    this.csk = false;
    AppMethodBeat.o(13360);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindGoogleContactUI.b
 * JD-Core Version:    0.7.0.1
 */
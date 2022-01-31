package com.tencent.mm.plugin.account.bind.ui;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

final class BindGoogleContactUI$a
  extends AsyncTask<Void, Void, Void>
{
  private String gsH;
  private String gsI;
  private boolean gsJ;
  
  public BindGoogleContactUI$a(BindGoogleContactUI paramBindGoogleContactUI, String paramString)
  {
    this.gsH = paramString;
  }
  
  private Void apA()
  {
    AppMethodBeat.i(13357);
    ab.i("MicroMsg.GoogleContact.BindGoogleContactUI", "doInBackground");
    try
    {
      this.gsI = new JSONObject(wM(this.gsH)).optString("email");
      if (!TextUtils.isEmpty(this.gsI)) {
        this.gsJ = true;
      }
      AppMethodBeat.o(13357);
      return null;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        ab.e("MicroMsg.GoogleContact.BindGoogleContactUI", "MalformedURLException:%s", new Object[] { localMalformedURLException.getMessage() });
      }
    }
    catch (ProtocolException localProtocolException)
    {
      for (;;)
      {
        ab.e("MicroMsg.GoogleContact.BindGoogleContactUI", "ProtocolException:%s", new Object[] { localProtocolException.getMessage() });
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        ab.e("MicroMsg.GoogleContact.BindGoogleContactUI", "UnsupportedEncodingException:%s", new Object[] { localUnsupportedEncodingException.getMessage() });
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ab.e("MicroMsg.GoogleContact.BindGoogleContactUI", "IOException:%s", new Object[] { localIOException.getMessage() });
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.GoogleContact.BindGoogleContactUI", localJSONException, "", new Object[0]);
      }
    }
  }
  
  private static String wM(String paramString)
  {
    AppMethodBeat.i(155793);
    Object localObject = "";
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL("https://www.googleapis.com/oauth2/v1/userinfo?access_token=".concat(String.valueOf(paramString))).openConnection();
    localHttpURLConnection.setRequestProperty("Charset", "UTF-8");
    localHttpURLConnection.setRequestMethod("GET");
    localHttpURLConnection.setConnectTimeout(20000);
    localHttpURLConnection.setReadTimeout(20000);
    int i = localHttpURLConnection.getResponseCode();
    ab.e("MicroMsg.GoogleContact.BindGoogleContactUI", "responseCode:".concat(String.valueOf(i)));
    paramString = (String)localObject;
    if (200 == i)
    {
      paramString = new StringBuffer();
      localObject = new BufferedReader(new InputStreamReader(localHttpURLConnection.getInputStream(), "UTF-8"));
      for (;;)
      {
        String str = ((BufferedReader)localObject).readLine();
        if (str == null) {
          break;
        }
        paramString.append(str);
      }
      ((BufferedReader)localObject).close();
      paramString = paramString.toString();
      ab.i("MicroMsg.GoogleContact.BindGoogleContactUI", "get EmailAccount respone:%s", new Object[] { paramString });
    }
    try
    {
      localHttpURLConnection.getInputStream().close();
      localHttpURLConnection.disconnect();
      AppMethodBeat.o(155793);
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
    AppMethodBeat.i(13356);
    super.onPreExecute();
    ab.i("MicroMsg.GoogleContact.BindGoogleContactUI", "onPreExecute");
    this.gsJ = false;
    AppMethodBeat.o(13356);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindGoogleContactUI.a
 * JD-Core Version:    0.7.0.1
 */
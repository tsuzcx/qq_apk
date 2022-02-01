package com.tencent.mm.plugin.account.bind.ui;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
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
  private String jZX;
  private String jZY;
  private boolean jZZ;
  
  public BindGoogleContactUI$a(BindGoogleContactUI paramBindGoogleContactUI, String paramString)
  {
    this.jZX = paramString;
  }
  
  private static String SI(String paramString)
  {
    AppMethodBeat.i(109784);
    Object localObject = "";
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL("https://www.googleapis.com/oauth2/v1/userinfo?access_token=".concat(String.valueOf(paramString))).openConnection();
    localHttpURLConnection.setRequestProperty("Charset", "UTF-8");
    localHttpURLConnection.setRequestMethod("GET");
    localHttpURLConnection.setConnectTimeout(20000);
    localHttpURLConnection.setReadTimeout(20000);
    int i = localHttpURLConnection.getResponseCode();
    Log.e("MicroMsg.GoogleContact.BindGoogleContactUI", "responseCode:".concat(String.valueOf(i)));
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
      Log.i("MicroMsg.GoogleContact.BindGoogleContactUI", "get EmailAccount respone:%s", new Object[] { paramString });
    }
    try
    {
      localHttpURLConnection.getInputStream().close();
      localHttpURLConnection.disconnect();
      AppMethodBeat.o(109784);
      return paramString;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.GoogleContact.BindGoogleContactUI", localException.getMessage());
      }
    }
  }
  
  private Void bnl()
  {
    AppMethodBeat.i(109783);
    Log.i("MicroMsg.GoogleContact.BindGoogleContactUI", "doInBackground");
    try
    {
      this.jZY = new JSONObject(SI(this.jZX)).optString("email");
      if (!TextUtils.isEmpty(this.jZY)) {
        this.jZZ = true;
      }
      AppMethodBeat.o(109783);
      return null;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        Log.e("MicroMsg.GoogleContact.BindGoogleContactUI", "MalformedURLException:%s", new Object[] { localMalformedURLException.getMessage() });
      }
    }
    catch (ProtocolException localProtocolException)
    {
      for (;;)
      {
        Log.e("MicroMsg.GoogleContact.BindGoogleContactUI", "ProtocolException:%s", new Object[] { localProtocolException.getMessage() });
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        Log.e("MicroMsg.GoogleContact.BindGoogleContactUI", "UnsupportedEncodingException:%s", new Object[] { localUnsupportedEncodingException.getMessage() });
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.e("MicroMsg.GoogleContact.BindGoogleContactUI", "IOException:%s", new Object[] { localIOException.getMessage() });
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.GoogleContact.BindGoogleContactUI", localJSONException, "", new Object[0]);
      }
    }
  }
  
  protected final void onPreExecute()
  {
    AppMethodBeat.i(109782);
    super.onPreExecute();
    Log.i("MicroMsg.GoogleContact.BindGoogleContactUI", "onPreExecute");
    this.jZZ = false;
    AppMethodBeat.o(109782);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindGoogleContactUI.a
 * JD-Core Version:    0.7.0.1
 */
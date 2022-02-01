package com.tencent.mm.plugin.account.bind.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.webkit.ConsoleMessage;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.account.bind.a.e;
import com.tencent.mm.plugin.account.bind.a.f;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.plugin.account.friend.model.j;
import com.tencent.mm.plugin.account.friend.model.u;
import com.tencent.mm.plugin.account.friend.model.u.a;
import com.tencent.mm.pluginsdk.ui.tools.aa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ad;
import com.tencent.xweb.ag;
import com.tencent.xweb.ao;
import com.tencent.xweb.z;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

public class BindGoogleContactUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private boolean nzW = false;
  private MMWebView ooz;
  private boolean pNE = false;
  String pNG;
  private ProgressDialog pNH;
  private int pNJ;
  private TextView pNO;
  private boolean pNP = false;
  private String pNQ;
  String pNR;
  String pNS;
  private u pNT;
  private boolean pNU = false;
  
  private void bWb()
  {
    AppMethodBeat.i(109799);
    this.ooz.setVisibility(8);
    AppMethodBeat.o(109799);
  }
  
  private void bWc()
  {
    AppMethodBeat.i(109800);
    this.pNO.setVisibility(4);
    this.ooz.setVisibility(0);
    AppMethodBeat.o(109800);
  }
  
  private void bWd()
  {
    AppMethodBeat.i(109801);
    startActivityForResult(new Intent("com.tencent.mm.gms.ACTION_CHOOSE_ACCOUNT"), 1003);
    AppMethodBeat.o(109801);
  }
  
  private void bWe()
  {
    AppMethodBeat.i(109802);
    showLoadingDialog();
    this.ooz.getSettings().setJavaScriptEnabled(true);
    this.ooz.setWebViewClient(new ag()
    {
      public final boolean a(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(109775);
        Log.d("MicroMsg.GoogleContact.BindGoogleContactUI", "shouldOverrideUrlLoading, url = %s", new Object[] { paramAnonymousString });
        if (paramAnonymousString.toLowerCase().startsWith("weixin://private/googlegetcode"))
        {
          BindGoogleContactUI.a(BindGoogleContactUI.this, paramAnonymousString);
          AppMethodBeat.o(109775);
          return true;
        }
        boolean bool = super.a(paramAnonymousWebView, paramAnonymousString);
        AppMethodBeat.o(109775);
        return bool;
      }
      
      public final void b(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(109774);
        Log.d("MicroMsg.GoogleContact.BindGoogleContactUI", "onPageFinished URL:".concat(String.valueOf(paramAnonymousString)));
        if ((BindGoogleContactUI.a(BindGoogleContactUI.this) != null) && (BindGoogleContactUI.a(BindGoogleContactUI.this).getVisibility() != 0))
        {
          BindGoogleContactUI.a(BindGoogleContactUI.this).setVisibility(0);
          if (BindGoogleContactUI.b(BindGoogleContactUI.this) != null) {
            BindGoogleContactUI.b(BindGoogleContactUI.this).setVisibility(4);
          }
        }
        BindGoogleContactUI.c(BindGoogleContactUI.this);
        if (paramAnonymousWebView != null)
        {
          paramAnonymousWebView = paramAnonymousWebView.getTitle();
          Log.d("MicroMsg.GoogleContact.BindGoogleContactUI", "title:%s", new Object[] { paramAnonymousWebView });
          if (!TextUtils.isEmpty(paramAnonymousWebView))
          {
            if (paramAnonymousWebView.toLowerCase().contains("success"))
            {
              if (BindGoogleContactUI.a(BindGoogleContactUI.this) != null) {
                BindGoogleContactUI.a(BindGoogleContactUI.this).setVisibility(4);
              }
              aa.b(BindGoogleContactUI.a(BindGoogleContactUI.this), "weixin://private/googlegetcode", "document.getElementById('code').value");
              AppMethodBeat.o(109774);
              return;
            }
            if (paramAnonymousWebView.toLowerCase().contains("error")) {
              Log.w("MicroMsg.GoogleContact.BindGoogleContactUI", "failed." + paramAnonymousWebView.substring(paramAnonymousWebView.indexOf("=")));
            }
          }
        }
        AppMethodBeat.o(109774);
      }
    });
    this.ooz.setWebChromeClient(new z()
    {
      public final boolean onConsoleMessage(ConsoleMessage paramAnonymousConsoleMessage)
      {
        AppMethodBeat.i(109776);
        if (paramAnonymousConsoleMessage != null) {}
        for (String str = paramAnonymousConsoleMessage.message();; str = null)
        {
          str = aa.brU(str);
          if (!str.toLowerCase().startsWith("weixin://private/googlegetcode")) {
            break;
          }
          BindGoogleContactUI.a(BindGoogleContactUI.this, str);
          AppMethodBeat.o(109776);
          return true;
        }
        boolean bool = super.onConsoleMessage(paramAnonymousConsoleMessage);
        AppMethodBeat.o(109776);
        return bool;
      }
    });
    this.ooz.loadUrl(j.bXf());
    AppMethodBeat.o(109802);
  }
  
  private void bWg()
  {
    AppMethodBeat.i(109806);
    try
    {
      ao.oQ(this);
      ao.removeAllCookie();
      AppMethodBeat.o(109806);
      return;
    }
    catch (Exception localException)
    {
      Log.d("Google Login", "Clear cookie failed");
      AppMethodBeat.o(109806);
    }
  }
  
  private void showLoadingDialog()
  {
    AppMethodBeat.i(109807);
    if ((this.pNH == null) || (!this.pNH.isShowing()))
    {
      getString(a.i.app_tip);
      this.pNH = k.a(this, getString(a.i.app_waiting), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(109781);
          BindGoogleContactUI.f(BindGoogleContactUI.this);
          if (BindGoogleContactUI.g(BindGoogleContactUI.this) != null) {
            com.tencent.mm.kernel.h.aZW().a(BindGoogleContactUI.g(BindGoogleContactUI.this));
          }
          AppMethodBeat.o(109781);
        }
      });
    }
    AppMethodBeat.o(109807);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(109793);
    if (this.pNE)
    {
      bWb();
      showLoadingDialog();
      bWd();
      AppMethodBeat.o(109793);
      return;
    }
    bWc();
    bWe();
    AppMethodBeat.o(109793);
  }
  
  private void ym(int paramInt)
  {
    AppMethodBeat.i(109803);
    this.pNT = new u(u.a.pTj, this.pNG, paramInt);
    com.tencent.mm.kernel.h.aZW().a(this.pNT, 0);
    Log.i("MicroMsg.GoogleContact.BindGoogleContactUI", "doScene mAppToken:%s, mWebToke:%s", new Object[] { this.pNQ, this.pNR });
    AppMethodBeat.o(109803);
  }
  
  final void bWf()
  {
    AppMethodBeat.i(109805);
    if (this.ooz != null) {
      this.ooz.setVisibility(4);
    }
    if (this.pNO != null) {
      this.pNO.setVisibility(0);
    }
    if (!NetStatusUtil.isConnected(this)) {}
    for (String str = getString(a.i.gcontact_network_error_msg);; str = getString(a.i.gcontact_default_error_msg))
    {
      this.pNO.setText(str);
      AppMethodBeat.o(109805);
      return;
    }
  }
  
  final void bWh()
  {
    AppMethodBeat.i(109808);
    if ((this.pNH != null) && (this.pNH.isShowing())) {
      this.pNH.dismiss();
    }
    AppMethodBeat.o(109808);
  }
  
  final void bn(String paramString, int paramInt)
  {
    AppMethodBeat.i(109804);
    this.pNG = paramString;
    ym(paramInt);
    AppMethodBeat.o(109804);
  }
  
  public int getLayoutId()
  {
    return a.f.bindgooglecontact;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109796);
    setMMTitle(a.i.gcontact_authorize_title);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(109773);
        BindGoogleContactUI.this.finish();
        AppMethodBeat.o(109773);
        return true;
      }
    });
    this.ooz = MMWebView.a.u(this, a.e.gcontact_webview);
    this.pNO = ((TextView)findViewById(a.e.empty));
    AppMethodBeat.o(109796);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(109797);
    Log.i("MicroMsg.GoogleContact.BindGoogleContactUI", "requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 == -1)
    {
      switch (paramInt1)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(109797);
        return;
        this.pNE = paramIntent.getBooleanExtra("gpservices", false);
        updateView();
        AppMethodBeat.o(109797);
        return;
        paramInt1 = paramIntent.getIntExtra("error_code", -1);
        Log.i("MicroMsg.GoogleContact.BindGoogleContactUI", "errorCode:%d ", new Object[] { Integer.valueOf(paramInt1) });
        if (paramInt1 == 0)
        {
          this.pNG = paramIntent.getStringExtra("account");
          if (this.nzW)
          {
            bWh();
            AppMethodBeat.o(109797);
            return;
          }
          Log.d("MicroMsg.GoogleContact.BindGoogleContactUI", "startAcitivtyForGetToken");
          paramIntent = new Intent("com.tencent.mm.gms.ACTION_GET_TOKEN");
          paramIntent.putExtra("gmail", this.pNG);
          paramIntent.putExtra("scope", "oauth2:https://www.googleapis.com/auth/userinfo.email https://www.google.com/m8/feeds");
          startActivityForResult(paramIntent, 1004);
          AppMethodBeat.o(109797);
          return;
        }
        bWh();
        bWf();
        AppMethodBeat.o(109797);
        return;
        paramInt1 = paramIntent.getIntExtra("error_code", -1);
        Log.i("MicroMsg.GoogleContact.BindGoogleContactUI", "errorCode:%d errorMsg:%s", new Object[] { Integer.valueOf(paramInt1), paramIntent.getStringExtra("error_msg") });
        if (paramInt1 == 0)
        {
          this.pNQ = paramIntent.getStringExtra("token");
          ym(u.pTc);
          AppMethodBeat.o(109797);
          return;
        }
        bWh();
        bWf();
      }
    }
    if (paramInt1 == 1005)
    {
      this.pNE = paramIntent.getBooleanExtra("gpservices", false);
      updateView();
      AppMethodBeat.o(109797);
      return;
    }
    bWh();
    bWf();
    AppMethodBeat.o(109797);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109792);
    super.onCreate(paramBundle);
    this.pNJ = getIntent().getIntExtra("enter_scene", 0);
    this.pNU = getIntent().getBooleanExtra("KEnterFromBanner", false);
    this.pNE = j.eq(this);
    this.pNG = ((String)com.tencent.mm.kernel.h.baE().ban().d(208903, null));
    initView();
    if (this.pNE)
    {
      startActivityForResult(new Intent("com.tencent.mm.gms.CHECK_GP_SERVICES"), 1005);
      AppMethodBeat.o(109792);
      return;
    }
    updateView();
    AppMethodBeat.o(109792);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(109795);
    super.onPause();
    com.tencent.mm.kernel.h.aZW().b(487, this);
    AppMethodBeat.o(109795);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109794);
    super.onResume();
    com.tencent.mm.kernel.h.aZW().a(487, this);
    this.pNP = ((Boolean)com.tencent.mm.kernel.h.baE().ban().d(208905, Boolean.FALSE)).booleanValue();
    if (this.pNP)
    {
      bWg();
      this.pNP = false;
      com.tencent.mm.kernel.h.baE().ban().B(208905, Boolean.FALSE);
    }
    AppMethodBeat.o(109794);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(109798);
    paramp = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramp = "";
    }
    Log.i("MicroMsg.GoogleContact.BindGoogleContactUI", "[onSceneEnd] errType:%d,errCode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramp });
    bWh();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (this.pNE)
      {
        com.tencent.mm.kernel.h.baE().ban().B(208903, this.pNG);
        com.tencent.mm.kernel.h.baE().ban().B(208901, this.pNQ);
      }
      for (;;)
      {
        com.tencent.mm.kernel.h.baE().ban().iZy();
        paramString = new Intent(this, GoogleFriendUI.class);
        paramString.putExtra("enter_scene", this.pNJ);
        paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aYi(), "com/tencent/mm/plugin/account/bind/ui/BindGoogleContactUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/account/bind/ui/BindGoogleContactUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        if (this.pNU) {
          com.tencent.mm.plugin.report.service.h.OAn.b(11002, new Object[] { Integer.valueOf(6), Integer.valueOf(6) });
        }
        AppMethodBeat.o(109798);
        return;
        com.tencent.mm.kernel.h.baE().ban().B(208903, this.pNG);
        com.tencent.mm.kernel.h.baE().ban().B(208902, this.pNR);
        com.tencent.mm.kernel.h.baE().ban().B(208904, this.pNS);
      }
    }
    if (paramInt2 == u.pTe)
    {
      k.a(this, getString(a.i.gcontact_msg_account_has_binded), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(109779);
          BindGoogleContactUI.a(BindGoogleContactUI.this, u.pTd);
          AppMethodBeat.o(109779);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(109780);
          BindGoogleContactUI.d(BindGoogleContactUI.this);
          BindGoogleContactUI.e(BindGoogleContactUI.this);
          AppMethodBeat.o(109780);
        }
      });
      AppMethodBeat.o(109798);
      return;
    }
    bWf();
    AppMethodBeat.o(109798);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends AsyncTask<Void, Void, Void>
  {
    private String pNX;
    private String pNY;
    private boolean pNZ;
    
    public a(String paramString)
    {
      this.pNX = paramString;
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
    
    private Void bWi()
    {
      AppMethodBeat.i(109783);
      Log.i("MicroMsg.GoogleContact.BindGoogleContactUI", "doInBackground");
      try
      {
        this.pNY = new JSONObject(SI(this.pNX)).optString("email");
        if (!TextUtils.isEmpty(this.pNY)) {
          this.pNZ = true;
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
      this.pNZ = false;
      AppMethodBeat.o(109782);
    }
  }
  
  final class b
    extends AsyncTask<Void, Void, Void>
  {
    private boolean isSuccess;
    private String pNX;
    private String pOa;
    private String pOb;
    
    public b(String paramString)
    {
      this.pOa = paramString;
    }
    
    private static String SJ(String paramString)
    {
      AppMethodBeat.i(109789);
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
      paramString = j.cB((List)localObject2);
      Log.i("MicroMsg.GoogleContact.BindGoogleContactUI", "QueryString:%s", new Object[] { paramString });
      localHttpURLConnection.setRequestProperty("Content-length", String.valueOf(paramString.getBytes().length));
      localObject2 = new BufferedWriter(new OutputStreamWriter(localHttpURLConnection.getOutputStream(), "UTF-8"));
      ((BufferedWriter)localObject2).write(paramString);
      ((BufferedWriter)localObject2).flush();
      ((BufferedWriter)localObject2).close();
      int i = localHttpURLConnection.getResponseCode();
      Log.e("MicroMsg.GoogleContact.BindGoogleContactUI", "responseCode:".concat(String.valueOf(i)));
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
        Log.i("MicroMsg.GoogleContact.BindGoogleContactUI", "exchange token respone:%s", new Object[] { paramString });
      }
      try
      {
        localHttpURLConnection.getInputStream().close();
        localHttpURLConnection.disconnect();
        AppMethodBeat.o(109789);
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
    
    private Void bWi()
    {
      AppMethodBeat.i(109788);
      try
      {
        String str = SJ(this.pOa);
        this.pNX = new JSONObject(str).optString("access_token");
        this.pOb = new JSONObject(str).optString("refresh_token");
        Log.i("MicroMsg.GoogleContact.BindGoogleContactUI", "response:%s", new Object[] { str });
        Log.i("MicroMsg.GoogleContact.BindGoogleContactUI", "mAccessToken:%s", new Object[] { this.pNX });
        Log.i("MicroMsg.GoogleContact.BindGoogleContactUI", "mRefreshToken:%s", new Object[] { this.pOb });
        this.isSuccess = true;
        AppMethodBeat.o(109788);
        return null;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          Log.e("MicroMsg.GoogleContact.BindGoogleContactUI", "MalformedURLException:%s" + localMalformedURLException.getMessage());
        }
      }
      catch (ProtocolException localProtocolException)
      {
        for (;;)
        {
          Log.e("MicroMsg.GoogleContact.BindGoogleContactUI", "ProtocolException:%s" + localProtocolException.getMessage());
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Log.e("MicroMsg.GoogleContact.BindGoogleContactUI", "IOException:%s" + localIOException.getMessage());
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          Log.e("MicroMsg.GoogleContact.BindGoogleContactUI", "JSONException:%s" + localJSONException.getMessage());
        }
      }
    }
    
    protected final void onPreExecute()
    {
      AppMethodBeat.i(109787);
      super.onPreExecute();
      Log.i("MicroMsg.GoogleContact.BindGoogleContactUI", "onPreExecute");
      this.pNX = "";
      this.pOb = "";
      this.isSuccess = false;
      AppMethodBeat.o(109787);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindGoogleContactUI
 * JD-Core Version:    0.7.0.1
 */
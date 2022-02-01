package com.tencent.mm.plugin.account.bind.ui;

import android.app.Activity;
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
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.account.friend.a.m;
import com.tencent.mm.plugin.account.friend.a.x.a;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.xweb.WebView;
import com.tencent.xweb.c;
import com.tencent.xweb.d;
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

@JgClassChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.JSEXECUTECHECK})
public class BindGoogleContactUI
  extends MMActivity
  implements com.tencent.mm.ak.g
{
  private boolean gRx = false;
  private MMWebView hqK;
  String iFB;
  private ProgressDialog iFC;
  private int iFE;
  private TextView iFJ;
  private boolean iFK = false;
  private String iFL;
  String iFM;
  String iFN;
  private com.tencent.mm.plugin.account.friend.a.x iFO;
  private boolean iFP = false;
  private boolean iFz = false;
  
  private void aOF()
  {
    AppMethodBeat.i(109799);
    this.hqK.setVisibility(8);
    AppMethodBeat.o(109799);
  }
  
  private void aOG()
  {
    AppMethodBeat.i(109800);
    this.iFJ.setVisibility(4);
    this.hqK.setVisibility(0);
    AppMethodBeat.o(109800);
  }
  
  private void aOH()
  {
    AppMethodBeat.i(109801);
    startActivityForResult(new Intent("com.tencent.mm.gms.ACTION_CHOOSE_ACCOUNT"), 1003);
    AppMethodBeat.o(109801);
  }
  
  private void aOI()
  {
    AppMethodBeat.i(109802);
    aOL();
    this.hqK.getSettings().setJavaScriptEnabled(true);
    this.hqK.setWebViewClient(new com.tencent.xweb.ac()
    {
      public final boolean a(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(109775);
        com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.GoogleContact.BindGoogleContactUI", "shouldOverrideUrlLoading, url = %s", new Object[] { paramAnonymousString });
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
        com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.GoogleContact.BindGoogleContactUI", "onPageFinished URL:".concat(String.valueOf(paramAnonymousString)));
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
          com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.GoogleContact.BindGoogleContactUI", "title:%s", new Object[] { paramAnonymousWebView });
          if (!TextUtils.isEmpty(paramAnonymousWebView))
          {
            if (paramAnonymousWebView.toLowerCase().contains("success"))
            {
              if (BindGoogleContactUI.a(BindGoogleContactUI.this) != null) {
                BindGoogleContactUI.a(BindGoogleContactUI.this).setVisibility(4);
              }
              com.tencent.mm.pluginsdk.ui.tools.x.a(BindGoogleContactUI.a(BindGoogleContactUI.this), "weixin://private/googlegetcode", "document.getElementById('code').value");
              AppMethodBeat.o(109774);
              return;
            }
            if (paramAnonymousWebView.toLowerCase().contains("error")) {
              com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.GoogleContact.BindGoogleContactUI", "failed." + paramAnonymousWebView.substring(paramAnonymousWebView.indexOf("=")));
            }
          }
        }
        AppMethodBeat.o(109774);
      }
    });
    this.hqK.setWebChromeClient(new com.tencent.xweb.x()
    {
      public final boolean onConsoleMessage(ConsoleMessage paramAnonymousConsoleMessage)
      {
        AppMethodBeat.i(109776);
        if (paramAnonymousConsoleMessage != null) {}
        for (String str = paramAnonymousConsoleMessage.message();; str = null)
        {
          str = com.tencent.mm.pluginsdk.ui.tools.x.aIg(str);
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
    this.hqK.loadUrl(m.aPM());
    AppMethodBeat.o(109802);
  }
  
  private void aOK()
  {
    AppMethodBeat.i(109806);
    try
    {
      d.li(this);
      c.fJa().removeAllCookie();
      AppMethodBeat.o(109806);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ac.d("Google Login", "Clear cookie failed");
      AppMethodBeat.o(109806);
    }
  }
  
  private void aOL()
  {
    AppMethodBeat.i(109807);
    if ((this.iFC == null) || (!this.iFC.isShowing()))
    {
      getString(2131755906);
      this.iFC = com.tencent.mm.ui.base.h.b(this, getString(2131755936), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(109781);
          BindGoogleContactUI.f(BindGoogleContactUI.this);
          if (BindGoogleContactUI.g(BindGoogleContactUI.this) != null) {
            com.tencent.mm.kernel.g.agi().a(BindGoogleContactUI.g(BindGoogleContactUI.this));
          }
          AppMethodBeat.o(109781);
        }
      });
    }
    AppMethodBeat.o(109807);
  }
  
  private void cL()
  {
    AppMethodBeat.i(109793);
    if (this.iFz)
    {
      aOF();
      aOL();
      aOH();
      AppMethodBeat.o(109793);
      return;
    }
    aOG();
    aOI();
    AppMethodBeat.o(109793);
  }
  
  private void qJ(int paramInt)
  {
    AppMethodBeat.i(109803);
    this.iFO = new com.tencent.mm.plugin.account.friend.a.x(x.a.iKY, this.iFB, paramInt);
    com.tencent.mm.kernel.g.agi().a(this.iFO, 0);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.GoogleContact.BindGoogleContactUI", "doScene mAppToken:%s, mWebToke:%s", new Object[] { this.iFL, this.iFM });
    AppMethodBeat.o(109803);
  }
  
  final void aOJ()
  {
    AppMethodBeat.i(109805);
    if (this.hqK != null) {
      this.hqK.setVisibility(4);
    }
    if (this.iFJ != null) {
      this.iFJ.setVisibility(0);
    }
    if (!ax.isConnected(this)) {}
    for (String str = getString(2131760027);; str = getString(2131760019))
    {
      this.iFJ.setText(str);
      AppMethodBeat.o(109805);
      return;
    }
  }
  
  final void aOM()
  {
    AppMethodBeat.i(109808);
    if ((this.iFC != null) && (this.iFC.isShowing())) {
      this.iFC.dismiss();
    }
    AppMethodBeat.o(109808);
  }
  
  final void aw(String paramString, int paramInt)
  {
    AppMethodBeat.i(109804);
    this.iFB = paramString;
    qJ(paramInt);
    AppMethodBeat.o(109804);
  }
  
  public int getLayoutId()
  {
    return 2131493176;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109796);
    setMMTitle(2131760018);
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
    this.hqK = MMWebView.a.s(this, 2131300579);
    this.iFJ = ((TextView)findViewById(2131299457));
    AppMethodBeat.o(109796);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(109797);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.GoogleContact.BindGoogleContactUI", "requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 == -1)
    {
      switch (paramInt1)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(109797);
        return;
        this.iFz = paramIntent.getBooleanExtra("gpservices", false);
        cL();
        AppMethodBeat.o(109797);
        return;
        paramInt1 = paramIntent.getIntExtra("error_code", -1);
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.GoogleContact.BindGoogleContactUI", "errorCode:%d ", new Object[] { Integer.valueOf(paramInt1) });
        if (paramInt1 == 0)
        {
          this.iFB = paramIntent.getStringExtra("account");
          if (this.gRx)
          {
            aOM();
            AppMethodBeat.o(109797);
            return;
          }
          com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.GoogleContact.BindGoogleContactUI", "startAcitivtyForGetToken");
          paramIntent = new Intent("com.tencent.mm.gms.ACTION_GET_TOKEN");
          paramIntent.putExtra("gmail", this.iFB);
          paramIntent.putExtra("scope", "oauth2:https://www.googleapis.com/auth/userinfo.email https://www.google.com/m8/feeds");
          startActivityForResult(paramIntent, 1004);
          AppMethodBeat.o(109797);
          return;
        }
        aOM();
        aOJ();
        AppMethodBeat.o(109797);
        return;
        paramInt1 = paramIntent.getIntExtra("error_code", -1);
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.GoogleContact.BindGoogleContactUI", "errorCode:%d errorMsg:%s", new Object[] { Integer.valueOf(paramInt1), paramIntent.getStringExtra("error_msg") });
        if (paramInt1 == 0)
        {
          this.iFL = paramIntent.getStringExtra("token");
          qJ(com.tencent.mm.plugin.account.friend.a.x.iKR);
          AppMethodBeat.o(109797);
          return;
        }
        aOM();
        aOJ();
      }
    }
    if (paramInt1 == 1005)
    {
      this.iFz = paramIntent.getBooleanExtra("gpservices", false);
      cL();
      AppMethodBeat.o(109797);
      return;
    }
    aOM();
    aOJ();
    AppMethodBeat.o(109797);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109792);
    super.onCreate(paramBundle);
    this.iFE = getIntent().getIntExtra("enter_scene", 0);
    this.iFP = getIntent().getBooleanExtra("KEnterFromBanner", false);
    this.iFz = m.dg(this);
    this.iFB = ((String)com.tencent.mm.kernel.g.agR().agA().get(208903, null));
    initView();
    if (this.iFz)
    {
      startActivityForResult(new Intent("com.tencent.mm.gms.CHECK_GP_SERVICES"), 1005);
      AppMethodBeat.o(109792);
      return;
    }
    cL();
    AppMethodBeat.o(109792);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(109795);
    super.onPause();
    com.tencent.mm.kernel.g.agi().b(487, this);
    AppMethodBeat.o(109795);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109794);
    super.onResume();
    com.tencent.mm.kernel.g.agi().a(487, this);
    this.iFK = ((Boolean)com.tencent.mm.kernel.g.agR().agA().get(208905, Boolean.FALSE)).booleanValue();
    if (this.iFK)
    {
      aOK();
      this.iFK = false;
      com.tencent.mm.kernel.g.agR().agA().set(208905, Boolean.FALSE);
    }
    AppMethodBeat.o(109794);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(109798);
    paramn = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramn = "";
    }
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.GoogleContact.BindGoogleContactUI", "[onSceneEnd] errType:%d,errCode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramn });
    aOM();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (this.iFz)
      {
        com.tencent.mm.kernel.g.agR().agA().set(208903, this.iFB);
        com.tencent.mm.kernel.g.agR().agA().set(208901, this.iFL);
      }
      for (;;)
      {
        com.tencent.mm.kernel.g.agR().agA().faa();
        paramString = new Intent(this, GoogleFriendUI.class);
        paramString.putExtra("enter_scene", this.iFE);
        paramString = new com.tencent.mm.hellhoundlib.b.a().ba(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramString.aeD(), "com/tencent/mm/plugin/account/bind/ui/BindGoogleContactUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindGoogleContactUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        if (this.iFP) {
          com.tencent.mm.plugin.report.service.h.wUl.f(11002, new Object[] { Integer.valueOf(6), Integer.valueOf(6) });
        }
        AppMethodBeat.o(109798);
        return;
        com.tencent.mm.kernel.g.agR().agA().set(208903, this.iFB);
        com.tencent.mm.kernel.g.agR().agA().set(208902, this.iFM);
        com.tencent.mm.kernel.g.agR().agA().set(208904, this.iFN);
      }
    }
    if (paramInt2 == com.tencent.mm.plugin.account.friend.a.x.iKT)
    {
      com.tencent.mm.ui.base.h.a(this, getString(2131760025), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(109779);
          BindGoogleContactUI.a(BindGoogleContactUI.this, com.tencent.mm.plugin.account.friend.a.x.iKS);
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
    aOJ();
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
    private String iFS;
    private String iFT;
    private boolean iFU;
    
    public a(String paramString)
    {
      this.iFS = paramString;
    }
    
    private static String FV(String paramString)
    {
      AppMethodBeat.i(109784);
      Object localObject = "";
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL("https://www.googleapis.com/oauth2/v1/userinfo?access_token=".concat(String.valueOf(paramString))).openConnection();
      localHttpURLConnection.setRequestProperty("Charset", "UTF-8");
      localHttpURLConnection.setRequestMethod("GET");
      localHttpURLConnection.setConnectTimeout(20000);
      localHttpURLConnection.setReadTimeout(20000);
      int i = localHttpURLConnection.getResponseCode();
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.GoogleContact.BindGoogleContactUI", "responseCode:".concat(String.valueOf(i)));
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
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.GoogleContact.BindGoogleContactUI", "get EmailAccount respone:%s", new Object[] { paramString });
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
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.GoogleContact.BindGoogleContactUI", localException.getMessage());
        }
      }
    }
    
    private Void aON()
    {
      AppMethodBeat.i(109783);
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.GoogleContact.BindGoogleContactUI", "doInBackground");
      try
      {
        this.iFT = new JSONObject(FV(this.iFS)).optString("email");
        if (!TextUtils.isEmpty(this.iFT)) {
          this.iFU = true;
        }
        AppMethodBeat.o(109783);
        return null;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.GoogleContact.BindGoogleContactUI", "MalformedURLException:%s", new Object[] { localMalformedURLException.getMessage() });
        }
      }
      catch (ProtocolException localProtocolException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.GoogleContact.BindGoogleContactUI", "ProtocolException:%s", new Object[] { localProtocolException.getMessage() });
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.GoogleContact.BindGoogleContactUI", "UnsupportedEncodingException:%s", new Object[] { localUnsupportedEncodingException.getMessage() });
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.GoogleContact.BindGoogleContactUI", "IOException:%s", new Object[] { localIOException.getMessage() });
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.GoogleContact.BindGoogleContactUI", localJSONException, "", new Object[0]);
        }
      }
    }
    
    protected final void onPreExecute()
    {
      AppMethodBeat.i(109782);
      super.onPreExecute();
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.GoogleContact.BindGoogleContactUI", "onPreExecute");
      this.iFU = false;
      AppMethodBeat.o(109782);
    }
  }
  
  final class b
    extends AsyncTask<Void, Void, Void>
  {
    private boolean deB;
    private String iFS;
    private String iFV;
    private String iFW;
    
    public b(String paramString)
    {
      this.iFV = paramString;
    }
    
    private static String FW(String paramString)
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
      paramString = m.aO((List)localObject2);
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.GoogleContact.BindGoogleContactUI", "QueryString:%s", new Object[] { paramString });
      localHttpURLConnection.setRequestProperty("Content-length", String.valueOf(paramString.getBytes().length));
      localObject2 = new BufferedWriter(new OutputStreamWriter(localHttpURLConnection.getOutputStream(), "UTF-8"));
      ((BufferedWriter)localObject2).write(paramString);
      ((BufferedWriter)localObject2).flush();
      ((BufferedWriter)localObject2).close();
      int i = localHttpURLConnection.getResponseCode();
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.GoogleContact.BindGoogleContactUI", "responseCode:".concat(String.valueOf(i)));
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
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.GoogleContact.BindGoogleContactUI", "exchange token respone:%s", new Object[] { paramString });
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
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.GoogleContact.BindGoogleContactUI", localException.getMessage());
        }
      }
    }
    
    private Void aON()
    {
      AppMethodBeat.i(109788);
      try
      {
        String str = FW(this.iFV);
        this.iFS = new JSONObject(str).optString("access_token");
        this.iFW = new JSONObject(str).optString("refresh_token");
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.GoogleContact.BindGoogleContactUI", "response:%s", new Object[] { str });
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.GoogleContact.BindGoogleContactUI", "mAccessToken:%s", new Object[] { this.iFS });
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.GoogleContact.BindGoogleContactUI", "mRefreshToken:%s", new Object[] { this.iFW });
        this.deB = true;
        AppMethodBeat.o(109788);
        return null;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.GoogleContact.BindGoogleContactUI", "MalformedURLException:%s" + localMalformedURLException.getMessage());
        }
      }
      catch (ProtocolException localProtocolException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.GoogleContact.BindGoogleContactUI", "ProtocolException:%s" + localProtocolException.getMessage());
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.GoogleContact.BindGoogleContactUI", "IOException:%s" + localIOException.getMessage());
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.GoogleContact.BindGoogleContactUI", "JSONException:%s" + localJSONException.getMessage());
        }
      }
    }
    
    protected final void onPreExecute()
    {
      AppMethodBeat.i(109787);
      super.onPreExecute();
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.GoogleContact.BindGoogleContactUI", "onPreExecute");
      this.iFS = "";
      this.iFW = "";
      this.deB = false;
      AppMethodBeat.o(109787);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindGoogleContactUI
 * JD-Core Version:    0.7.0.1
 */
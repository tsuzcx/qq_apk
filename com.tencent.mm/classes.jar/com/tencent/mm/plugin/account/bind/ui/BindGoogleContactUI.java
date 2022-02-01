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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.account.friend.a.m;
import com.tencent.mm.plugin.account.friend.a.x.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.storage.aj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ac;
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
  implements f
{
  private MMWebView hLV;
  private boolean hmD = false;
  private boolean jbB = false;
  String jbD;
  private ProgressDialog jbE;
  private int jbG;
  private TextView jbL;
  private boolean jbM = false;
  private String jbN;
  String jbO;
  String jbP;
  private com.tencent.mm.plugin.account.friend.a.x jbQ;
  private boolean jbR = false;
  
  private void aSq()
  {
    AppMethodBeat.i(109799);
    this.hLV.setVisibility(8);
    AppMethodBeat.o(109799);
  }
  
  private void aSr()
  {
    AppMethodBeat.i(109800);
    this.jbL.setVisibility(4);
    this.hLV.setVisibility(0);
    AppMethodBeat.o(109800);
  }
  
  private void aSs()
  {
    AppMethodBeat.i(109801);
    startActivityForResult(new Intent("com.tencent.mm.gms.ACTION_CHOOSE_ACCOUNT"), 1003);
    AppMethodBeat.o(109801);
  }
  
  private void aSt()
  {
    AppMethodBeat.i(109802);
    aSw();
    this.hLV.getSettings().setJavaScriptEnabled(true);
    this.hLV.setWebViewClient(new ac()
    {
      public final boolean a(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(109775);
        ae.d("MicroMsg.GoogleContact.BindGoogleContactUI", "shouldOverrideUrlLoading, url = %s", new Object[] { paramAnonymousString });
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
        ae.d("MicroMsg.GoogleContact.BindGoogleContactUI", "onPageFinished URL:".concat(String.valueOf(paramAnonymousString)));
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
          ae.d("MicroMsg.GoogleContact.BindGoogleContactUI", "title:%s", new Object[] { paramAnonymousWebView });
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
              ae.w("MicroMsg.GoogleContact.BindGoogleContactUI", "failed." + paramAnonymousWebView.substring(paramAnonymousWebView.indexOf("=")));
            }
          }
        }
        AppMethodBeat.o(109774);
      }
    });
    this.hLV.setWebChromeClient(new com.tencent.xweb.x()
    {
      public final boolean onConsoleMessage(ConsoleMessage paramAnonymousConsoleMessage)
      {
        AppMethodBeat.i(109776);
        if (paramAnonymousConsoleMessage != null) {}
        for (String str = paramAnonymousConsoleMessage.message();; str = null)
        {
          str = com.tencent.mm.pluginsdk.ui.tools.x.aPf(str);
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
    this.hLV.loadUrl(m.aTx());
    AppMethodBeat.o(109802);
  }
  
  private void aSv()
  {
    AppMethodBeat.i(109806);
    try
    {
      d.lB(this);
      c.geY().removeAllCookie();
      AppMethodBeat.o(109806);
      return;
    }
    catch (Exception localException)
    {
      ae.d("Google Login", "Clear cookie failed");
      AppMethodBeat.o(109806);
    }
  }
  
  private void aSw()
  {
    AppMethodBeat.i(109807);
    if ((this.jbE == null) || (!this.jbE.isShowing()))
    {
      getString(2131755906);
      this.jbE = h.b(this, getString(2131755936), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(109781);
          BindGoogleContactUI.f(BindGoogleContactUI.this);
          if (BindGoogleContactUI.g(BindGoogleContactUI.this) != null) {
            com.tencent.mm.kernel.g.ajj().a(BindGoogleContactUI.g(BindGoogleContactUI.this));
          }
          AppMethodBeat.o(109781);
        }
      });
    }
    AppMethodBeat.o(109807);
  }
  
  private void rm(int paramInt)
  {
    AppMethodBeat.i(109803);
    this.jbQ = new com.tencent.mm.plugin.account.friend.a.x(x.a.jha, this.jbD, paramInt);
    com.tencent.mm.kernel.g.ajj().a(this.jbQ, 0);
    ae.i("MicroMsg.GoogleContact.BindGoogleContactUI", "doScene mAppToken:%s, mWebToke:%s", new Object[] { this.jbN, this.jbO });
    AppMethodBeat.o(109803);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(109793);
    if (this.jbB)
    {
      aSq();
      aSw();
      aSs();
      AppMethodBeat.o(109793);
      return;
    }
    aSr();
    aSt();
    AppMethodBeat.o(109793);
  }
  
  final void aSu()
  {
    AppMethodBeat.i(109805);
    if (this.hLV != null) {
      this.hLV.setVisibility(4);
    }
    if (this.jbL != null) {
      this.jbL.setVisibility(0);
    }
    if (!az.isConnected(this)) {}
    for (String str = getString(2131760027);; str = getString(2131760019))
    {
      this.jbL.setText(str);
      AppMethodBeat.o(109805);
      return;
    }
  }
  
  final void aSx()
  {
    AppMethodBeat.i(109808);
    if ((this.jbE != null) && (this.jbE.isShowing())) {
      this.jbE.dismiss();
    }
    AppMethodBeat.o(109808);
  }
  
  final void az(String paramString, int paramInt)
  {
    AppMethodBeat.i(109804);
    this.jbD = paramString;
    rm(paramInt);
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
    this.hLV = MMWebView.a.s(this, 2131300579);
    this.jbL = ((TextView)findViewById(2131299457));
    AppMethodBeat.o(109796);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(109797);
    ae.i("MicroMsg.GoogleContact.BindGoogleContactUI", "requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 == -1)
    {
      switch (paramInt1)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(109797);
        return;
        this.jbB = paramIntent.getBooleanExtra("gpservices", false);
        updateView();
        AppMethodBeat.o(109797);
        return;
        paramInt1 = paramIntent.getIntExtra("error_code", -1);
        ae.i("MicroMsg.GoogleContact.BindGoogleContactUI", "errorCode:%d ", new Object[] { Integer.valueOf(paramInt1) });
        if (paramInt1 == 0)
        {
          this.jbD = paramIntent.getStringExtra("account");
          if (this.hmD)
          {
            aSx();
            AppMethodBeat.o(109797);
            return;
          }
          ae.d("MicroMsg.GoogleContact.BindGoogleContactUI", "startAcitivtyForGetToken");
          paramIntent = new Intent("com.tencent.mm.gms.ACTION_GET_TOKEN");
          paramIntent.putExtra("gmail", this.jbD);
          paramIntent.putExtra("scope", "oauth2:https://www.googleapis.com/auth/userinfo.email https://www.google.com/m8/feeds");
          startActivityForResult(paramIntent, 1004);
          AppMethodBeat.o(109797);
          return;
        }
        aSx();
        aSu();
        AppMethodBeat.o(109797);
        return;
        paramInt1 = paramIntent.getIntExtra("error_code", -1);
        ae.i("MicroMsg.GoogleContact.BindGoogleContactUI", "errorCode:%d errorMsg:%s", new Object[] { Integer.valueOf(paramInt1), paramIntent.getStringExtra("error_msg") });
        if (paramInt1 == 0)
        {
          this.jbN = paramIntent.getStringExtra("token");
          rm(com.tencent.mm.plugin.account.friend.a.x.jgT);
          AppMethodBeat.o(109797);
          return;
        }
        aSx();
        aSu();
      }
    }
    if (paramInt1 == 1005)
    {
      this.jbB = paramIntent.getBooleanExtra("gpservices", false);
      updateView();
      AppMethodBeat.o(109797);
      return;
    }
    aSx();
    aSu();
    AppMethodBeat.o(109797);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109792);
    super.onCreate(paramBundle);
    this.jbG = getIntent().getIntExtra("enter_scene", 0);
    this.jbR = getIntent().getBooleanExtra("KEnterFromBanner", false);
    this.jbB = m.dg(this);
    this.jbD = ((String)com.tencent.mm.kernel.g.ajR().ajA().get(208903, null));
    initView();
    if (this.jbB)
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
    com.tencent.mm.kernel.g.ajj().b(487, this);
    AppMethodBeat.o(109795);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109794);
    super.onResume();
    com.tencent.mm.kernel.g.ajj().a(487, this);
    this.jbM = ((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(208905, Boolean.FALSE)).booleanValue();
    if (this.jbM)
    {
      aSv();
      this.jbM = false;
      com.tencent.mm.kernel.g.ajR().ajA().set(208905, Boolean.FALSE);
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
    ae.i("MicroMsg.GoogleContact.BindGoogleContactUI", "[onSceneEnd] errType:%d,errCode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramn });
    aSx();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (this.jbB)
      {
        com.tencent.mm.kernel.g.ajR().ajA().set(208903, this.jbD);
        com.tencent.mm.kernel.g.ajR().ajA().set(208901, this.jbN);
      }
      for (;;)
      {
        com.tencent.mm.kernel.g.ajR().ajA().fuc();
        paramString = new Intent(this, GoogleFriendUI.class);
        paramString.putExtra("enter_scene", this.jbG);
        paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahE(), "com/tencent/mm/plugin/account/bind/ui/BindGoogleContactUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindGoogleContactUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        if (this.jbR) {
          com.tencent.mm.plugin.report.service.g.yxI.f(11002, new Object[] { Integer.valueOf(6), Integer.valueOf(6) });
        }
        AppMethodBeat.o(109798);
        return;
        com.tencent.mm.kernel.g.ajR().ajA().set(208903, this.jbD);
        com.tencent.mm.kernel.g.ajR().ajA().set(208902, this.jbO);
        com.tencent.mm.kernel.g.ajR().ajA().set(208904, this.jbP);
      }
    }
    if (paramInt2 == com.tencent.mm.plugin.account.friend.a.x.jgV)
    {
      h.a(this, getString(2131760025), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(109779);
          BindGoogleContactUI.a(BindGoogleContactUI.this, com.tencent.mm.plugin.account.friend.a.x.jgU);
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
    aSu();
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
    private String jbU;
    private String jbV;
    private boolean jbW;
    
    public a(String paramString)
    {
      this.jbU = paramString;
    }
    
    private static String JJ(String paramString)
    {
      AppMethodBeat.i(109784);
      Object localObject = "";
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL("https://www.googleapis.com/oauth2/v1/userinfo?access_token=".concat(String.valueOf(paramString))).openConnection();
      localHttpURLConnection.setRequestProperty("Charset", "UTF-8");
      localHttpURLConnection.setRequestMethod("GET");
      localHttpURLConnection.setConnectTimeout(20000);
      localHttpURLConnection.setReadTimeout(20000);
      int i = localHttpURLConnection.getResponseCode();
      ae.e("MicroMsg.GoogleContact.BindGoogleContactUI", "responseCode:".concat(String.valueOf(i)));
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
        ae.i("MicroMsg.GoogleContact.BindGoogleContactUI", "get EmailAccount respone:%s", new Object[] { paramString });
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
          ae.e("MicroMsg.GoogleContact.BindGoogleContactUI", localException.getMessage());
        }
      }
    }
    
    private Void aSy()
    {
      AppMethodBeat.i(109783);
      ae.i("MicroMsg.GoogleContact.BindGoogleContactUI", "doInBackground");
      try
      {
        this.jbV = new JSONObject(JJ(this.jbU)).optString("email");
        if (!TextUtils.isEmpty(this.jbV)) {
          this.jbW = true;
        }
        AppMethodBeat.o(109783);
        return null;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          ae.e("MicroMsg.GoogleContact.BindGoogleContactUI", "MalformedURLException:%s", new Object[] { localMalformedURLException.getMessage() });
        }
      }
      catch (ProtocolException localProtocolException)
      {
        for (;;)
        {
          ae.e("MicroMsg.GoogleContact.BindGoogleContactUI", "ProtocolException:%s", new Object[] { localProtocolException.getMessage() });
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          ae.e("MicroMsg.GoogleContact.BindGoogleContactUI", "UnsupportedEncodingException:%s", new Object[] { localUnsupportedEncodingException.getMessage() });
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          ae.e("MicroMsg.GoogleContact.BindGoogleContactUI", "IOException:%s", new Object[] { localIOException.getMessage() });
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.GoogleContact.BindGoogleContactUI", localJSONException, "", new Object[0]);
        }
      }
    }
    
    protected final void onPreExecute()
    {
      AppMethodBeat.i(109782);
      super.onPreExecute();
      ae.i("MicroMsg.GoogleContact.BindGoogleContactUI", "onPreExecute");
      this.jbW = false;
      AppMethodBeat.o(109782);
    }
  }
  
  final class b
    extends AsyncTask<Void, Void, Void>
  {
    private boolean drc;
    private String jbU;
    private String jbX;
    private String jbY;
    
    public b(String paramString)
    {
      this.jbX = paramString;
    }
    
    private static String JK(String paramString)
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
      paramString = m.aP((List)localObject2);
      ae.i("MicroMsg.GoogleContact.BindGoogleContactUI", "QueryString:%s", new Object[] { paramString });
      localHttpURLConnection.setRequestProperty("Content-length", String.valueOf(paramString.getBytes().length));
      localObject2 = new BufferedWriter(new OutputStreamWriter(localHttpURLConnection.getOutputStream(), "UTF-8"));
      ((BufferedWriter)localObject2).write(paramString);
      ((BufferedWriter)localObject2).flush();
      ((BufferedWriter)localObject2).close();
      int i = localHttpURLConnection.getResponseCode();
      ae.e("MicroMsg.GoogleContact.BindGoogleContactUI", "responseCode:".concat(String.valueOf(i)));
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
        ae.i("MicroMsg.GoogleContact.BindGoogleContactUI", "exchange token respone:%s", new Object[] { paramString });
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
          ae.e("MicroMsg.GoogleContact.BindGoogleContactUI", localException.getMessage());
        }
      }
    }
    
    private Void aSy()
    {
      AppMethodBeat.i(109788);
      try
      {
        String str = JK(this.jbX);
        this.jbU = new JSONObject(str).optString("access_token");
        this.jbY = new JSONObject(str).optString("refresh_token");
        ae.i("MicroMsg.GoogleContact.BindGoogleContactUI", "response:%s", new Object[] { str });
        ae.i("MicroMsg.GoogleContact.BindGoogleContactUI", "mAccessToken:%s", new Object[] { this.jbU });
        ae.i("MicroMsg.GoogleContact.BindGoogleContactUI", "mRefreshToken:%s", new Object[] { this.jbY });
        this.drc = true;
        AppMethodBeat.o(109788);
        return null;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          ae.e("MicroMsg.GoogleContact.BindGoogleContactUI", "MalformedURLException:%s" + localMalformedURLException.getMessage());
        }
      }
      catch (ProtocolException localProtocolException)
      {
        for (;;)
        {
          ae.e("MicroMsg.GoogleContact.BindGoogleContactUI", "ProtocolException:%s" + localProtocolException.getMessage());
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          ae.e("MicroMsg.GoogleContact.BindGoogleContactUI", "IOException:%s" + localIOException.getMessage());
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          ae.e("MicroMsg.GoogleContact.BindGoogleContactUI", "JSONException:%s" + localJSONException.getMessage());
        }
      }
    }
    
    protected final void onPreExecute()
    {
      AppMethodBeat.i(109787);
      super.onPreExecute();
      ae.i("MicroMsg.GoogleContact.BindGoogleContactUI", "onPreExecute");
      this.jbU = "";
      this.jbY = "";
      this.drc = false;
      AppMethodBeat.o(109787);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindGoogleContactUI
 * JD-Core Version:    0.7.0.1
 */
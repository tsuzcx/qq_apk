package com.tencent.mm.plugin.account.bind.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.webkit.ConsoleMessage;
import android.widget.TextView;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.m;
import com.tencent.mm.plugin.account.friend.a.x.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ac;
import com.tencent.xweb.c;
import com.tencent.xweb.d;

@JgClassChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.JSEXECUTECHECK})
public class BindGoogleContactUI
  extends MMActivity
  implements i
{
  private MMWebView iGY;
  private boolean ifz = false;
  private boolean jZE = false;
  String jZG;
  private ProgressDialog jZH;
  private int jZJ;
  private TextView jZO;
  private boolean jZP = false;
  private String jZQ;
  String jZR;
  String jZS;
  private com.tencent.mm.plugin.account.friend.a.x jZT;
  private boolean jZU = false;
  
  private void bnd()
  {
    AppMethodBeat.i(109799);
    this.iGY.setVisibility(8);
    AppMethodBeat.o(109799);
  }
  
  private void bne()
  {
    AppMethodBeat.i(109800);
    this.jZO.setVisibility(4);
    this.iGY.setVisibility(0);
    AppMethodBeat.o(109800);
  }
  
  private void bnf()
  {
    AppMethodBeat.i(109801);
    startActivityForResult(new Intent("com.tencent.mm.gms.ACTION_CHOOSE_ACCOUNT"), 1003);
    AppMethodBeat.o(109801);
  }
  
  private void bng()
  {
    AppMethodBeat.i(109802);
    bnj();
    this.iGY.getSettings().setJavaScriptEnabled(true);
    this.iGY.setWebViewClient(new ac()
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
              com.tencent.mm.pluginsdk.ui.tools.z.a(BindGoogleContactUI.a(BindGoogleContactUI.this), "weixin://private/googlegetcode", "document.getElementById('code').value");
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
    this.iGY.setWebChromeClient(new com.tencent.xweb.x()
    {
      public final boolean onConsoleMessage(ConsoleMessage paramAnonymousConsoleMessage)
      {
        AppMethodBeat.i(109776);
        if (paramAnonymousConsoleMessage != null) {}
        for (String str = paramAnonymousConsoleMessage.message();; str = null)
        {
          str = com.tencent.mm.pluginsdk.ui.tools.z.bfJ(str);
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
    this.iGY.loadUrl(m.boj());
    AppMethodBeat.o(109802);
  }
  
  private void bni()
  {
    AppMethodBeat.i(109806);
    try
    {
      d.lA(this);
      c.hsp().removeAllCookie();
      AppMethodBeat.o(109806);
      return;
    }
    catch (Exception localException)
    {
      Log.d("Google Login", "Clear cookie failed");
      AppMethodBeat.o(109806);
    }
  }
  
  private void bnj()
  {
    AppMethodBeat.i(109807);
    if ((this.jZH == null) || (!this.jZH.isShowing()))
    {
      getString(2131755998);
      this.jZH = com.tencent.mm.ui.base.h.a(this, getString(2131756029), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(109781);
          BindGoogleContactUI.f(BindGoogleContactUI.this);
          if (BindGoogleContactUI.g(BindGoogleContactUI.this) != null) {
            g.azz().a(BindGoogleContactUI.g(BindGoogleContactUI.this));
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
    if (this.jZE)
    {
      bnd();
      bnj();
      bnf();
      AppMethodBeat.o(109793);
      return;
    }
    bne();
    bng();
    AppMethodBeat.o(109793);
  }
  
  private void vc(int paramInt)
  {
    AppMethodBeat.i(109803);
    this.jZT = new com.tencent.mm.plugin.account.friend.a.x(x.a.kfe, this.jZG, paramInt);
    g.azz().a(this.jZT, 0);
    Log.i("MicroMsg.GoogleContact.BindGoogleContactUI", "doScene mAppToken:%s, mWebToke:%s", new Object[] { this.jZQ, this.jZR });
    AppMethodBeat.o(109803);
  }
  
  final void aD(String paramString, int paramInt)
  {
    AppMethodBeat.i(109804);
    this.jZG = paramString;
    vc(paramInt);
    AppMethodBeat.o(109804);
  }
  
  final void bnh()
  {
    AppMethodBeat.i(109805);
    if (this.iGY != null) {
      this.iGY.setVisibility(4);
    }
    if (this.jZO != null) {
      this.jZO.setVisibility(0);
    }
    if (!NetStatusUtil.isConnected(this)) {}
    for (String str = getString(2131761405);; str = getString(2131761397))
    {
      this.jZO.setText(str);
      AppMethodBeat.o(109805);
      return;
    }
  }
  
  final void bnk()
  {
    AppMethodBeat.i(109808);
    if ((this.jZH != null) && (this.jZH.isShowing())) {
      this.jZH.dismiss();
    }
    AppMethodBeat.o(109808);
  }
  
  public int getLayoutId()
  {
    return 2131493222;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109796);
    setMMTitle(2131761396);
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
    this.iGY = MMWebView.a.r(this, 2131302114);
    this.jZO = ((TextView)findViewById(2131300076));
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
        this.jZE = paramIntent.getBooleanExtra("gpservices", false);
        updateView();
        AppMethodBeat.o(109797);
        return;
        paramInt1 = paramIntent.getIntExtra("error_code", -1);
        Log.i("MicroMsg.GoogleContact.BindGoogleContactUI", "errorCode:%d ", new Object[] { Integer.valueOf(paramInt1) });
        if (paramInt1 == 0)
        {
          this.jZG = paramIntent.getStringExtra("account");
          if (this.ifz)
          {
            bnk();
            AppMethodBeat.o(109797);
            return;
          }
          Log.d("MicroMsg.GoogleContact.BindGoogleContactUI", "startAcitivtyForGetToken");
          paramIntent = new Intent("com.tencent.mm.gms.ACTION_GET_TOKEN");
          paramIntent.putExtra("gmail", this.jZG);
          paramIntent.putExtra("scope", "oauth2:https://www.googleapis.com/auth/userinfo.email https://www.google.com/m8/feeds");
          startActivityForResult(paramIntent, 1004);
          AppMethodBeat.o(109797);
          return;
        }
        bnk();
        bnh();
        AppMethodBeat.o(109797);
        return;
        paramInt1 = paramIntent.getIntExtra("error_code", -1);
        Log.i("MicroMsg.GoogleContact.BindGoogleContactUI", "errorCode:%d errorMsg:%s", new Object[] { Integer.valueOf(paramInt1), paramIntent.getStringExtra("error_msg") });
        if (paramInt1 == 0)
        {
          this.jZQ = paramIntent.getStringExtra("token");
          vc(com.tencent.mm.plugin.account.friend.a.x.keX);
          AppMethodBeat.o(109797);
          return;
        }
        bnk();
        bnh();
      }
    }
    if (paramInt1 == 1005)
    {
      this.jZE = paramIntent.getBooleanExtra("gpservices", false);
      updateView();
      AppMethodBeat.o(109797);
      return;
    }
    bnk();
    bnh();
    AppMethodBeat.o(109797);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109792);
    super.onCreate(paramBundle);
    this.jZJ = getIntent().getIntExtra("enter_scene", 0);
    this.jZU = getIntent().getBooleanExtra("KEnterFromBanner", false);
    this.jZE = m.dB(this);
    this.jZG = ((String)g.aAh().azQ().get(208903, null));
    initView();
    if (this.jZE)
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
    g.azz().b(487, this);
    AppMethodBeat.o(109795);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109794);
    super.onResume();
    g.azz().a(487, this);
    this.jZP = ((Boolean)g.aAh().azQ().get(208905, Boolean.FALSE)).booleanValue();
    if (this.jZP)
    {
      bni();
      this.jZP = false;
      g.aAh().azQ().set(208905, Boolean.FALSE);
    }
    AppMethodBeat.o(109794);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(109798);
    paramq = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramq = "";
    }
    Log.i("MicroMsg.GoogleContact.BindGoogleContactUI", "[onSceneEnd] errType:%d,errCode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramq });
    bnk();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (this.jZE)
      {
        g.aAh().azQ().set(208903, this.jZG);
        g.aAh().azQ().set(208901, this.jZQ);
      }
      for (;;)
      {
        g.aAh().azQ().gBI();
        paramString = new Intent(this, GoogleFriendUI.class);
        paramString.putExtra("enter_scene", this.jZJ);
        paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramString.axQ(), "com/tencent/mm/plugin/account/bind/ui/BindGoogleContactUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindGoogleContactUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        if (this.jZU) {
          com.tencent.mm.plugin.report.service.h.CyF.a(11002, new Object[] { Integer.valueOf(6), Integer.valueOf(6) });
        }
        AppMethodBeat.o(109798);
        return;
        g.aAh().azQ().set(208903, this.jZG);
        g.aAh().azQ().set(208902, this.jZR);
        g.aAh().azQ().set(208904, this.jZS);
      }
    }
    if (paramInt2 == com.tencent.mm.plugin.account.friend.a.x.keZ)
    {
      com.tencent.mm.ui.base.h.a(this, getString(2131761403), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(109779);
          BindGoogleContactUI.a(BindGoogleContactUI.this, com.tencent.mm.plugin.account.friend.a.x.keY);
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
    bnh();
    AppMethodBeat.o(109798);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindGoogleContactUI
 * JD-Core Version:    0.7.0.1
 */
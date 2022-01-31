package com.tencent.mm.plugin.account.bind.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import com.jg.JgClassChecked;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.bind.a.e;
import com.tencent.mm.plugin.account.bind.a.f;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.plugin.account.friend.a.w;
import com.tencent.mm.plugin.account.friend.a.w.a;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.xweb.b;
import com.tencent.xweb.c;
import com.tencent.xweb.n;

@JgClassChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.JSEXECUTECHECK})
public class BindGoogleContactUI
  extends MMActivity
  implements f
{
  private MMWebView dYF;
  private boolean edT = false;
  private int faB;
  private TextView faG;
  private boolean faH = false;
  private String faI;
  String faJ;
  String faK;
  private w faL;
  private boolean faM = false;
  private boolean faw = false;
  String fay;
  private ProgressDialog faz;
  
  private void VW()
  {
    VZ();
    this.dYF.getSettings().setJavaScriptEnabled(true);
    this.dYF.setWebViewClient(new BindGoogleContactUI.2(this));
    this.dYF.setWebChromeClient(new BindGoogleContactUI.3(this));
    MMWebView localMMWebView = this.dYF;
    y.i("MicroMsg.GoogleContactLogic", "getRequestCodeUrl:%s", new Object[] { "https://accounts.google.com/o/oauth2/auth?scope=https://www.googleapis.com/auth/userinfo.email https://www.google.com/m8/feeds&redirect_uri=urn:ietf:wg:oauth:2.0:oob&response_type=code&client_id=369820936870.apps.googleusercontent.com" });
    localMMWebView.loadUrl("https://accounts.google.com/o/oauth2/auth?scope=https://www.googleapis.com/auth/userinfo.email https://www.google.com/m8/feeds&redirect_uri=urn:ietf:wg:oauth:2.0:oob&response_type=code&client_id=369820936870.apps.googleusercontent.com");
  }
  
  private void VY()
  {
    try
    {
      c.il(this);
      b.cSe().removeAllCookie();
      return;
    }
    catch (Exception localException)
    {
      y.d("Google Login", "Clear cookie failed");
    }
  }
  
  private void VZ()
  {
    if ((this.faz == null) || (!this.faz.isShowing()))
    {
      getString(a.i.app_tip);
      this.faz = com.tencent.mm.ui.base.h.b(this, getString(a.i.app_waiting), true, new BindGoogleContactUI.8(this));
    }
  }
  
  private void aZ()
  {
    if (this.faw)
    {
      this.dYF.setVisibility(8);
      VZ();
      startActivityForResult(new Intent("com.tencent.mm.gms.ACTION_CHOOSE_ACCOUNT"), 1003);
      return;
    }
    this.faG.setVisibility(4);
    this.dYF.setVisibility(0);
    VW();
  }
  
  private void jS(int paramInt)
  {
    this.faL = new w(w.a.fgm, this.fay, paramInt);
    g.Dk().a(this.faL, 0);
    y.i("MicroMsg.GoogleContact.BindGoogleContactUI", "doScene mAppToken:%s, mWebToke:%s", new Object[] { this.faI, this.faJ });
  }
  
  final void VX()
  {
    if (this.dYF != null) {
      this.dYF.setVisibility(4);
    }
    if (this.faG != null) {
      this.faG.setVisibility(0);
    }
    if (!aq.isConnected(this)) {}
    for (String str = getString(a.i.gcontact_network_error_msg);; str = getString(a.i.gcontact_default_error_msg))
    {
      this.faG.setText(str);
      return;
    }
  }
  
  final void Wa()
  {
    if ((this.faz != null) && (this.faz.isShowing())) {
      this.faz.dismiss();
    }
  }
  
  final void aa(String paramString, int paramInt)
  {
    this.fay = paramString;
    jS(paramInt);
  }
  
  protected final int getLayoutId()
  {
    return a.f.bindgooglecontact;
  }
  
  protected final void initView()
  {
    setMMTitle(a.i.gcontact_authorize_title);
    setBackBtn(new BindGoogleContactUI.1(this));
    this.dYF = MMWebView.a.m(this, a.e.gcontact_webview);
    this.faG = ((TextView)findViewById(a.e.empty));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    y.i("MicroMsg.GoogleContact.BindGoogleContactUI", "requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 == -1)
    {
      switch (paramInt1)
      {
      default: 
        return;
      case 1005: 
        this.faw = paramIntent.getBooleanExtra("gpservices", false);
        aZ();
        return;
      case 1003: 
        paramInt1 = paramIntent.getIntExtra("error_code", -1);
        y.i("MicroMsg.GoogleContact.BindGoogleContactUI", "errorCode:%d ", new Object[] { Integer.valueOf(paramInt1) });
        if (paramInt1 == 0)
        {
          this.fay = paramIntent.getStringExtra("account");
          if (this.edT)
          {
            Wa();
            return;
          }
          y.d("MicroMsg.GoogleContact.BindGoogleContactUI", "startAcitivtyForGetToken");
          paramIntent = new Intent("com.tencent.mm.gms.ACTION_GET_TOKEN");
          paramIntent.putExtra("gmail", this.fay);
          paramIntent.putExtra("scope", "oauth2:https://www.googleapis.com/auth/userinfo.email https://www.google.com/m8/feeds");
          startActivityForResult(paramIntent, 1004);
          return;
        }
        Wa();
        VX();
        return;
      }
      paramInt1 = paramIntent.getIntExtra("error_code", -1);
      y.i("MicroMsg.GoogleContact.BindGoogleContactUI", "errorCode:%d errorMsg:%s", new Object[] { Integer.valueOf(paramInt1), paramIntent.getStringExtra("error_msg") });
      if (paramInt1 == 0)
      {
        this.faI = paramIntent.getStringExtra("token");
        jS(w.fgf);
        return;
      }
      Wa();
      VX();
      return;
    }
    if (paramInt1 == 1005)
    {
      this.faw = paramIntent.getBooleanExtra("gpservices", false);
      aZ();
      return;
    }
    Wa();
    VX();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.faB = getIntent().getIntExtra("enter_scene", 0);
    this.faM = getIntent().getBooleanExtra("KEnterFromBanner", false);
    this.faw = com.tencent.mm.plugin.account.friend.a.m.bX(this);
    this.fay = ((String)g.DP().Dz().get(208903, null));
    initView();
    if (this.faw)
    {
      startActivityForResult(new Intent("com.tencent.mm.gms.CHECK_GP_SERVICES"), 1005);
      return;
    }
    aZ();
  }
  
  protected void onPause()
  {
    super.onPause();
    g.Dk().b(487, this);
  }
  
  protected void onResume()
  {
    super.onResume();
    g.Dk().a(487, this);
    this.faH = ((Boolean)g.DP().Dz().get(208905, Boolean.valueOf(false))).booleanValue();
    if (this.faH)
    {
      VY();
      this.faH = false;
      g.DP().Dz().o(208905, Boolean.valueOf(false));
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    paramm = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramm = "";
    }
    y.i("MicroMsg.GoogleContact.BindGoogleContactUI", "[onSceneEnd] errType:%d,errCode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramm });
    Wa();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (this.faw)
      {
        g.DP().Dz().o(208903, this.fay);
        g.DP().Dz().o(208901, this.faI);
      }
      for (;;)
      {
        g.DP().Dz().mC(true);
        paramString = new Intent(this, GoogleFriendUI.class);
        paramString.putExtra("enter_scene", this.faB);
        startActivity(paramString);
        finish();
        if (this.faM) {
          com.tencent.mm.plugin.report.service.h.nFQ.f(11002, new Object[] { Integer.valueOf(6), Integer.valueOf(6) });
        }
        return;
        g.DP().Dz().o(208903, this.fay);
        g.DP().Dz().o(208902, this.faJ);
        g.DP().Dz().o(208904, this.faK);
      }
    }
    if (paramInt2 == w.fgh)
    {
      com.tencent.mm.ui.base.h.a(this, getString(a.i.gcontact_msg_account_has_binded), "", new BindGoogleContactUI.6(this), new BindGoogleContactUI.7(this));
      return;
    }
    VX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindGoogleContactUI
 * JD-Core Version:    0.7.0.1
 */
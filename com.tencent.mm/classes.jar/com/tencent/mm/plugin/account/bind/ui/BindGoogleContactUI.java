package com.tencent.mm.plugin.account.bind.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.w;
import com.tencent.mm.plugin.account.friend.a.w.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.xweb.b;
import com.tencent.xweb.c;
import com.tencent.xweb.t;

@JgClassChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.JSEXECUTECHECK})
public class BindGoogleContactUI
  extends MMActivity
  implements f
{
  private boolean eUJ = false;
  private MMWebView foJ;
  private String gsA;
  String gsB;
  String gsC;
  private w gsD;
  private boolean gsE = false;
  private boolean gso = false;
  String gsq;
  private ProgressDialog gsr;
  private int gst;
  private TextView gsy;
  private boolean gsz = false;
  
  private void aps()
  {
    AppMethodBeat.i(13371);
    this.foJ.setVisibility(8);
    AppMethodBeat.o(13371);
  }
  
  private void apt()
  {
    AppMethodBeat.i(13372);
    this.gsy.setVisibility(4);
    this.foJ.setVisibility(0);
    AppMethodBeat.o(13372);
  }
  
  private void apu()
  {
    AppMethodBeat.i(13373);
    startActivityForResult(new Intent("com.tencent.mm.gms.ACTION_CHOOSE_ACCOUNT"), 1003);
    AppMethodBeat.o(13373);
  }
  
  private void apv()
  {
    AppMethodBeat.i(13374);
    apy();
    this.foJ.getSettings().setJavaScriptEnabled(true);
    this.foJ.setWebViewClient(new BindGoogleContactUI.2(this));
    this.foJ.setWebChromeClient(new BindGoogleContactUI.3(this));
    this.foJ.loadUrl(com.tencent.mm.plugin.account.friend.a.m.aqA());
    AppMethodBeat.o(13374);
  }
  
  private void apx()
  {
    AppMethodBeat.i(13378);
    try
    {
      c.jQ(this);
      b.dYg().removeAllCookie();
      AppMethodBeat.o(13378);
      return;
    }
    catch (Exception localException)
    {
      ab.d("Google Login", "Clear cookie failed");
      AppMethodBeat.o(13378);
    }
  }
  
  private void apy()
  {
    AppMethodBeat.i(13379);
    if ((this.gsr == null) || (!this.gsr.isShowing()))
    {
      getString(2131297087);
      this.gsr = com.tencent.mm.ui.base.h.b(this, getString(2131297112), true, new BindGoogleContactUI.8(this));
    }
    AppMethodBeat.o(13379);
  }
  
  private void bJ()
  {
    AppMethodBeat.i(13365);
    if (this.gso)
    {
      aps();
      apy();
      apu();
      AppMethodBeat.o(13365);
      return;
    }
    apt();
    apv();
    AppMethodBeat.o(13365);
  }
  
  private void mO(int paramInt)
  {
    AppMethodBeat.i(13375);
    this.gsD = new w(w.a.gxU, this.gsq, paramInt);
    g.Rc().a(this.gsD, 0);
    ab.i("MicroMsg.GoogleContact.BindGoogleContactUI", "doScene mAppToken:%s, mWebToke:%s", new Object[] { this.gsA, this.gsB });
    AppMethodBeat.o(13375);
  }
  
  final void ai(String paramString, int paramInt)
  {
    AppMethodBeat.i(13376);
    this.gsq = paramString;
    mO(paramInt);
    AppMethodBeat.o(13376);
  }
  
  final void apw()
  {
    AppMethodBeat.i(13377);
    if (this.foJ != null) {
      this.foJ.setVisibility(4);
    }
    if (this.gsy != null) {
      this.gsy.setVisibility(0);
    }
    if (!at.isConnected(this)) {}
    for (String str = getString(2131300491);; str = getString(2131300483))
    {
      this.gsy.setText(str);
      AppMethodBeat.o(13377);
      return;
    }
  }
  
  final void apz()
  {
    AppMethodBeat.i(13380);
    if ((this.gsr != null) && (this.gsr.isShowing())) {
      this.gsr.dismiss();
    }
    AppMethodBeat.o(13380);
  }
  
  public int getLayoutId()
  {
    return 2130968844;
  }
  
  public void initView()
  {
    AppMethodBeat.i(13368);
    setMMTitle(2131300482);
    setBackBtn(new BindGoogleContactUI.1(this));
    this.foJ = MMWebView.a.p(this, 2131821787);
    this.gsy = ((TextView)findViewById(2131821788));
    AppMethodBeat.o(13368);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(13369);
    ab.i("MicroMsg.GoogleContact.BindGoogleContactUI", "requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 == -1)
    {
      switch (paramInt1)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(13369);
        return;
        this.gso = paramIntent.getBooleanExtra("gpservices", false);
        bJ();
        AppMethodBeat.o(13369);
        return;
        paramInt1 = paramIntent.getIntExtra("error_code", -1);
        ab.i("MicroMsg.GoogleContact.BindGoogleContactUI", "errorCode:%d ", new Object[] { Integer.valueOf(paramInt1) });
        if (paramInt1 == 0)
        {
          this.gsq = paramIntent.getStringExtra("account");
          if (this.eUJ)
          {
            apz();
            AppMethodBeat.o(13369);
            return;
          }
          ab.d("MicroMsg.GoogleContact.BindGoogleContactUI", "startAcitivtyForGetToken");
          paramIntent = new Intent("com.tencent.mm.gms.ACTION_GET_TOKEN");
          paramIntent.putExtra("gmail", this.gsq);
          paramIntent.putExtra("scope", "oauth2:https://www.googleapis.com/auth/userinfo.email https://www.google.com/m8/feeds");
          startActivityForResult(paramIntent, 1004);
          AppMethodBeat.o(13369);
          return;
        }
        apz();
        apw();
        AppMethodBeat.o(13369);
        return;
        paramInt1 = paramIntent.getIntExtra("error_code", -1);
        ab.i("MicroMsg.GoogleContact.BindGoogleContactUI", "errorCode:%d errorMsg:%s", new Object[] { Integer.valueOf(paramInt1), paramIntent.getStringExtra("error_msg") });
        if (paramInt1 == 0)
        {
          this.gsA = paramIntent.getStringExtra("token");
          mO(w.gxN);
          AppMethodBeat.o(13369);
          return;
        }
        apz();
        apw();
      }
    }
    if (paramInt1 == 1005)
    {
      this.gso = paramIntent.getBooleanExtra("gpservices", false);
      bJ();
      AppMethodBeat.o(13369);
      return;
    }
    apz();
    apw();
    AppMethodBeat.o(13369);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(13364);
    super.onCreate(paramBundle);
    this.gst = getIntent().getIntExtra("enter_scene", 0);
    this.gsE = getIntent().getBooleanExtra("KEnterFromBanner", false);
    this.gso = com.tencent.mm.plugin.account.friend.a.m.cD(this);
    this.gsq = ((String)g.RL().Ru().get(208903, null));
    initView();
    if (this.gso)
    {
      startActivityForResult(new Intent("com.tencent.mm.gms.CHECK_GP_SERVICES"), 1005);
      AppMethodBeat.o(13364);
      return;
    }
    bJ();
    AppMethodBeat.o(13364);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(13367);
    super.onPause();
    g.Rc().b(487, this);
    AppMethodBeat.o(13367);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(13366);
    super.onResume();
    g.Rc().a(487, this);
    this.gsz = ((Boolean)g.RL().Ru().get(208905, Boolean.FALSE)).booleanValue();
    if (this.gsz)
    {
      apx();
      this.gsz = false;
      g.RL().Ru().set(208905, Boolean.FALSE);
    }
    AppMethodBeat.o(13366);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(13370);
    paramm = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramm = "";
    }
    ab.i("MicroMsg.GoogleContact.BindGoogleContactUI", "[onSceneEnd] errType:%d,errCode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramm });
    apz();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (this.gso)
      {
        g.RL().Ru().set(208903, this.gsq);
        g.RL().Ru().set(208901, this.gsA);
      }
      for (;;)
      {
        g.RL().Ru().dww();
        paramString = new Intent(this, GoogleFriendUI.class);
        paramString.putExtra("enter_scene", this.gst);
        startActivity(paramString);
        finish();
        if (this.gsE) {
          com.tencent.mm.plugin.report.service.h.qsU.e(11002, new Object[] { Integer.valueOf(6), Integer.valueOf(6) });
        }
        AppMethodBeat.o(13370);
        return;
        g.RL().Ru().set(208903, this.gsq);
        g.RL().Ru().set(208902, this.gsB);
        g.RL().Ru().set(208904, this.gsC);
      }
    }
    if (paramInt2 == w.gxP)
    {
      com.tencent.mm.ui.base.h.a(this, getString(2131300489), "", new BindGoogleContactUI.6(this), new BindGoogleContactUI.7(this));
      AppMethodBeat.o(13370);
      return;
    }
    apw();
    AppMethodBeat.o(13370);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindGoogleContactUI
 * JD-Core Version:    0.7.0.1
 */
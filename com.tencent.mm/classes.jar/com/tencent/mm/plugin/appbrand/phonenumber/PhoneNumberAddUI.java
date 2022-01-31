package com.tencent.mm.plugin.appbrand.phonenumber;

import a.f.b.j;
import a.l;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;
import com.tencent.mm.ui.widget.MMSwitchBtn;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberAddUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "appId", "", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "finishBtn", "Landroid/widget/Button;", "getFinishBtn", "()Landroid/widget/Button;", "setFinishBtn", "(Landroid/widget/Button;)V", "formInputView", "Lcom/tencent/mm/ui/base/MMFormVerifyCodeInputView;", "getFormInputView", "()Lcom/tencent/mm/ui/base/MMFormVerifyCodeInputView;", "setFormInputView", "(Lcom/tencent/mm/ui/base/MMFormVerifyCodeInputView;)V", "formVerifyCodeInputView", "Lcom/tencent/mm/ui/base/MMFormInputView;", "getFormVerifyCodeInputView", "()Lcom/tencent/mm/ui/base/MMFormInputView;", "setFormVerifyCodeInputView", "(Lcom/tencent/mm/ui/base/MMFormInputView;)V", "mobile", "getMobile", "setMobile", "switchBtn", "Lcom/tencent/mm/ui/widget/MMSwitchBtn;", "getSwitchBtn", "()Lcom/tencent/mm/ui/widget/MMSwitchBtn;", "setSwitchBtn", "(Lcom/tencent/mm/ui/widget/MMSwitchBtn;)V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "sendSms", "showErrorTips", "errMsg", "verifyCode", "Companion", "plugin-appbrand-integration_release"})
@com.tencent.mm.ui.base.a(3)
public final class PhoneNumberAddUI
  extends MMActivity
{
  public static final a iDA;
  String appId = "";
  String czF = "";
  MMFormVerifyCodeInputView iDw;
  MMFormInputView iDx;
  MMSwitchBtn iDy;
  Button iDz;
  
  static
  {
    AppMethodBeat.i(134840);
    iDA = new a((byte)0);
    AppMethodBeat.o(134840);
  }
  
  public final int getLayoutId()
  {
    return 2130968703;
  }
  
  public final void jC(String paramString)
  {
    AppMethodBeat.i(134836);
    j.q(paramString, "<set-?>");
    this.czF = paramString;
    AppMethodBeat.o(134836);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(134837);
    super.onCreate(paramBundle);
    setActionbarColor(-1);
    getContentView().setBackgroundColor(getActionbarColor());
    paramBundle = getIntent().getStringExtra("APPID");
    j.p(paramBundle, "intent.getStringExtra(APPID)");
    this.appId = paramBundle;
    ab.i("MicroMsg.PhoneNumberAddUI", "onCreate() appId:%s", new Object[] { this.appId });
    b.a.a.a.a.a.a.a.a.CKU.azx(this.appId);
    this.iDy = ((MMSwitchBtn)findViewById(2131821277));
    this.iDz = ((Button)findViewById(2131821278));
    this.iDw = ((MMFormVerifyCodeInputView)findViewById(2131821275));
    paramBundle = this.iDw;
    if (paramBundle != null) {
      paramBundle.setInputType(3);
    }
    paramBundle = this.iDw;
    if (paramBundle != null) {
      paramBundle.setSendSmsBtnClickListener((View.OnClickListener)new PhoneNumberAddUI.b(this));
    }
    paramBundle = this.iDw;
    if (paramBundle != null) {
      paramBundle.addTextChangedListener((TextWatcher)new PhoneNumberAddUI.c(this));
    }
    this.iDx = ((MMFormInputView)findViewById(2131821276));
    paramBundle = this.iDx;
    if (paramBundle != null) {
      paramBundle.setInputType(3);
    }
    paramBundle = this.iDx;
    if (paramBundle != null) {
      paramBundle.addTextChangedListener((TextWatcher)new PhoneNumberAddUI.d(this));
    }
    paramBundle = this.iDz;
    if (paramBundle != null)
    {
      paramBundle.setOnClickListener((View.OnClickListener)new PhoneNumberAddUI.e(this));
      AppMethodBeat.o(134837);
      return;
    }
    AppMethodBeat.o(134837);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(134839);
    super.onDestroy();
    MMFormVerifyCodeInputView localMMFormVerifyCodeInputView = this.iDw;
    if (localMMFormVerifyCodeInputView != null) {
      localMMFormVerifyCodeInputView.reset();
    }
    b.a.a.a.a.a.a.a.a.CKU.afj(this.appId);
    AppMethodBeat.o(134839);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(134838);
    super.onResume();
    setMMTitle(2131297160);
    hideActionbarLine();
    setBackBtn((MenuItem.OnMenuItemClickListener)new f(this));
    AppMethodBeat.o(134838);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberAddUI$Companion;", "", "()V", "APPID", "", "TAG", "addPhoneNumber", "", "context", "Landroid/content/Context;", "appId", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class f
    implements MenuItem.OnMenuItemClickListener
  {
    f(PhoneNumberAddUI paramPhoneNumberAddUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(134823);
      this.iDB.finish();
      AppMethodBeat.o(134823);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberAddUI
 * JD-Core Version:    0.7.0.1
 */
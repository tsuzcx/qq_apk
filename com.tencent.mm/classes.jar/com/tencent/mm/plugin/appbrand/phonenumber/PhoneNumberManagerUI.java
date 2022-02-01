package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.luggage.m.a.a;
import com.tencent.luggage.m.a.e;
import com.tencent.luggage.m.a.f;
import com.tencent.luggage.m.a.g;
import com.tencent.luggage.m.a.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.BaseActivity.c;
import com.tencent.mm.ui.base.BaseLuggageActivity;
import junit.framework.Assert;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManagerUI;", "Lcom/tencent/mm/ui/base/BaseLuggageActivity;", "()V", "mPhoneNumberManagerLogic", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberManageLogic;", "showDelete", "", "enableEditPhoneNumber", "", "enable", "getLayoutId", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "updateView", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PhoneNumberManagerUI
  extends BaseLuggageActivity
{
  public static final PhoneNumberManagerUI.a tHC;
  private boolean tGy;
  private o tHD;
  
  static
  {
    AppMethodBeat.i(148158);
    tHC = new PhoneNumberManagerUI.a((byte)0);
    AppMethodBeat.o(148158);
  }
  
  private static final boolean a(PhoneNumberManagerUI paramPhoneNumberManagerUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(318997);
    s.u(paramPhoneNumberManagerUI, "this$0");
    paramMenuItem = paramPhoneNumberManagerUI.tHD;
    if (paramMenuItem != null) {
      paramMenuItem.cHy();
    }
    paramPhoneNumberManagerUI.kF(false);
    paramPhoneNumberManagerUI.updateView();
    AppMethodBeat.o(318997);
    return true;
  }
  
  private static final boolean b(PhoneNumberManagerUI paramPhoneNumberManagerUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(319005);
    s.u(paramPhoneNumberManagerUI, "this$0");
    paramPhoneNumberManagerUI.kF(false);
    paramPhoneNumberManagerUI.updateView();
    AppMethodBeat.o(319005);
    return true;
  }
  
  private static final boolean c(PhoneNumberManagerUI paramPhoneNumberManagerUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(319010);
    s.u(paramPhoneNumberManagerUI, "this$0");
    paramPhoneNumberManagerUI.kF(true);
    paramPhoneNumberManagerUI.updateView();
    AppMethodBeat.o(319010);
    return true;
  }
  
  private static final boolean d(PhoneNumberManagerUI paramPhoneNumberManagerUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(319014);
    s.u(paramPhoneNumberManagerUI, "this$0");
    paramPhoneNumberManagerUI.finish();
    AppMethodBeat.o(319014);
    return true;
  }
  
  private final void kF(boolean paramBoolean)
  {
    AppMethodBeat.i(148156);
    this.tGy = paramBoolean;
    o localo = this.tHD;
    if (localo != null) {
      localo.kE(paramBoolean);
    }
    AppMethodBeat.o(148156);
  }
  
  private final void updateView()
  {
    AppMethodBeat.i(148154);
    removeAllOptionMenu();
    o localo = this.tHD;
    if (localo != null) {
      localo.kD(this.tGy);
    }
    if (this.tGy)
    {
      a(getString(a.g.appbrand_phone_number_finish_menu), BaseActivity.c.advw, new PhoneNumberManagerUI..ExternalSyntheticLambda3(this));
      a(a.f.actionbar_icon_dark_close, new PhoneNumberManagerUI..ExternalSyntheticLambda1(this));
      AppMethodBeat.o(148154);
      return;
    }
    a(getString(a.g.appbrand_phone_number_manager_menu), BaseActivity.c.advw, new PhoneNumberManagerUI..ExternalSyntheticLambda0(this));
    setBackBtn(new PhoneNumberManagerUI..ExternalSyntheticLambda2(this));
    AppMethodBeat.o(148154);
  }
  
  public final int getLayoutId()
  {
    return a.e.app_brand_empty;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(148155);
    if (this.tGy)
    {
      kF(false);
      updateView();
      AppMethodBeat.o(148155);
      return;
    }
    super.onBackPressed();
    AppMethodBeat.o(148155);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(148152);
    setTheme(a.h.WeUITheme);
    super.onCreate(paramBundle);
    setActionBarColor(getResources().getColor(a.a.BG_2));
    setNavigationbarColor(getResources().getColor(a.a.BG_1));
    hideActionbarLine();
    setTitle((CharSequence)getResources().getString(a.g.appbrand_phone_number_manager_phone_number));
    paramBundle = getIntent().getStringExtra("APPID");
    Util.isNullOrNil(paramBundle);
    Assert.assertFalse(false);
    Log.i("MicroMsg.PhoneNumberManagerUI", s.X("onCreate() appId:", paramBundle));
    String str = getIntent().getStringExtra("PAGEPATH");
    Object localObject = u.tHm;
    localObject = u.cHB();
    Context localContext = (Context)this;
    s.checkNotNull(paramBundle);
    s.checkNotNull(str);
    this.tHD = ((n)localObject).w(localContext, paramBundle, str);
    paramBundle = this.tHD;
    if (paramBundle != null) {
      paramBundle.init();
    }
    paramBundle = this.tHD;
    if (paramBundle == null) {}
    for (paramBundle = null;; paramBundle = paramBundle.getView())
    {
      setContentView(paramBundle);
      AppMethodBeat.o(148152);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(148157);
    super.onDestroy();
    o localo = this.tHD;
    if (localo != null) {
      localo.uninit();
    }
    AppMethodBeat.o(148157);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(148153);
    super.onResume();
    updateView();
    AppMethodBeat.o(148153);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberManagerUI
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.phonenumber;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.BaseActivity.c;
import com.tencent.mm.ui.base.BaseLuggageActivity;
import junit.framework.Assert;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManagerUI;", "Lcom/tencent/mm/ui/base/BaseLuggageActivity;", "()V", "mPhoneNumberManagerLogic", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberManageLogic;", "showDelete", "", "enableEditPhoneNumber", "", "enable", "getLayoutId", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "updateView", "Companion", "luggage-wechat-full-sdk_release"})
public final class PhoneNumberManagerUI
  extends BaseLuggageActivity
{
  public static final PhoneNumberManagerUI.a nAu;
  private o nAt;
  private boolean nze;
  
  static
  {
    AppMethodBeat.i(148158);
    nAu = new PhoneNumberManagerUI.a((byte)0);
    AppMethodBeat.o(148158);
  }
  
  private final void iu(boolean paramBoolean)
  {
    AppMethodBeat.i(148156);
    this.nze = paramBoolean;
    o localo = this.nAt;
    if (localo != null)
    {
      localo.it(paramBoolean);
      AppMethodBeat.o(148156);
      return;
    }
    AppMethodBeat.o(148156);
  }
  
  private final void updateView()
  {
    AppMethodBeat.i(148154);
    removeAllOptionMenu();
    o localo = this.nAt;
    if (localo != null) {
      localo.is(this.nze);
    }
    if (this.nze)
    {
      a(getString(2131756134), BaseActivity.c.Oyl, (MenuItem.OnMenuItemClickListener)new b(this));
      a((MenuItem.OnMenuItemClickListener)new c(this));
      AppMethodBeat.o(148154);
      return;
    }
    a(getString(2131756141), BaseActivity.c.Oyl, (MenuItem.OnMenuItemClickListener)new d(this));
    setBackBtn((MenuItem.OnMenuItemClickListener)new e(this));
    AppMethodBeat.o(148154);
  }
  
  public final int getLayoutId()
  {
    return 2131493027;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(148155);
    if (this.nze)
    {
      iu(false);
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
    setTheme(2131821591);
    super.onCreate(paramBundle);
    setActionBarColor(getResources().getColor(2131099650));
    setNavigationbarColor(getResources().getColor(2131099649));
    hideActionbarLine();
    setTitle(2131756142);
    paramBundle = getIntent().getStringExtra("APPID");
    Util.isNullOrNil(paramBundle);
    Assert.assertFalse(false);
    Log.i("MicroMsg.PhoneNumberManagerUI", "onCreate() appId:".concat(String.valueOf(paramBundle)));
    String str = getIntent().getStringExtra("PAGEPATH");
    Object localObject = u.nAe;
    localObject = u.bTz();
    Context localContext = (Context)this;
    p.g(paramBundle, "appId");
    p.g(str, "pagePath");
    this.nAt = ((n)localObject).s(localContext, paramBundle, str);
    paramBundle = this.nAt;
    if (paramBundle != null) {
      paramBundle.init();
    }
    paramBundle = this.nAt;
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.getView();; paramBundle = null)
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
    o localo = this.nAt;
    if (localo != null)
    {
      localo.uninit();
      AppMethodBeat.o(148157);
      return;
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(PhoneNumberManagerUI paramPhoneNumberManagerUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(148148);
      paramMenuItem = PhoneNumberManagerUI.a(this.nAv);
      if (paramMenuItem != null) {
        paramMenuItem.bTx();
      }
      PhoneNumberManagerUI.a(this.nAv, false);
      PhoneNumberManagerUI.b(this.nAv);
      AppMethodBeat.o(148148);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class c
    implements MenuItem.OnMenuItemClickListener
  {
    c(PhoneNumberManagerUI paramPhoneNumberManagerUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(148149);
      PhoneNumberManagerUI.a(this.nAv, false);
      PhoneNumberManagerUI.b(this.nAv);
      AppMethodBeat.o(148149);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class d
    implements MenuItem.OnMenuItemClickListener
  {
    d(PhoneNumberManagerUI paramPhoneNumberManagerUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(148150);
      PhoneNumberManagerUI.a(this.nAv, true);
      PhoneNumberManagerUI.b(this.nAv);
      AppMethodBeat.o(148150);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class e
    implements MenuItem.OnMenuItemClickListener
  {
    e(PhoneNumberManagerUI paramPhoneNumberManagerUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(148151);
      this.nAv.finish();
      AppMethodBeat.o(148151);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberManagerUI
 * JD-Core Version:    0.7.0.1
 */
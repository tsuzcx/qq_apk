package com.tencent.mm.plugin.appbrand.phonenumber;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.BaseActivity.c;
import com.tencent.mm.ui.base.BaseLuggageActivity;
import d.g.b.k;
import d.l;
import junit.framework.Assert;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManagerUI;", "Lcom/tencent/mm/ui/base/BaseLuggageActivity;", "()V", "mPhoneNumberManagerLogic", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberManageLogic;", "showDelete", "", "enableEditPhoneNumber", "", "enable", "getLayoutId", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "updateView", "Companion", "luggage-wechat-full-sdk_release"})
public final class PhoneNumberManagerUI
  extends BaseLuggageActivity
{
  public static final PhoneNumberManagerUI.a llf;
  private boolean ljQ;
  private o lle;
  
  static
  {
    AppMethodBeat.i(148158);
    llf = new PhoneNumberManagerUI.a((byte)0);
    AppMethodBeat.o(148158);
  }
  
  private final void cE()
  {
    AppMethodBeat.i(148154);
    removeAllOptionMenu();
    o localo = this.lle;
    if (localo != null) {
      localo.gP(this.ljQ);
    }
    if (this.ljQ)
    {
      a(getString(2131756019), BaseActivity.c.FHl, (MenuItem.OnMenuItemClickListener)new b(this));
      a((MenuItem.OnMenuItemClickListener)new c(this));
      AppMethodBeat.o(148154);
      return;
    }
    a(getString(2131756026), BaseActivity.c.FHl, (MenuItem.OnMenuItemClickListener)new d(this));
    setBackBtn((MenuItem.OnMenuItemClickListener)new e(this));
    AppMethodBeat.o(148154);
  }
  
  private final void gR(boolean paramBoolean)
  {
    AppMethodBeat.i(148156);
    this.ljQ = paramBoolean;
    o localo = this.lle;
    if (localo != null)
    {
      localo.gQ(paramBoolean);
      AppMethodBeat.o(148156);
      return;
    }
    AppMethodBeat.o(148156);
  }
  
  public final int getLayoutId()
  {
    return 2131492992;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(148155);
    if (this.ljQ)
    {
      gR(false);
      cE();
      AppMethodBeat.o(148155);
      return;
    }
    super.onBackPressed();
    AppMethodBeat.o(148155);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(148152);
    setTheme(2131821543);
    super.onCreate(paramBundle);
    setActionBarColor(getResources().getColor(2131099650));
    setNavigationbarColor(getResources().getColor(2131099649));
    hideActionbarLine();
    setTitle(2131756027);
    paramBundle = getIntent().getStringExtra("APPID");
    bt.isNullOrNil(paramBundle);
    Assert.assertFalse(false);
    ad.i("MicroMsg.PhoneNumberManagerUI", "onCreate() appId:".concat(String.valueOf(paramBundle)));
    String str = getIntent().getStringExtra("PAGEPATH");
    Object localObject = u.lkN;
    localObject = u.blE();
    Context localContext = (Context)this;
    k.g(paramBundle, "appId");
    k.g(str, "pagePath");
    this.lle = ((n)localObject).s(localContext, paramBundle, str);
    paramBundle = this.lle;
    if (paramBundle != null) {
      paramBundle.init();
    }
    paramBundle = this.lle;
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
    o localo = this.lle;
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
    cE();
    AppMethodBeat.o(148153);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(PhoneNumberManagerUI paramPhoneNumberManagerUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(148148);
      paramMenuItem = PhoneNumberManagerUI.a(this.llg);
      if (paramMenuItem != null) {
        paramMenuItem.blC();
      }
      PhoneNumberManagerUI.a(this.llg, false);
      PhoneNumberManagerUI.b(this.llg);
      AppMethodBeat.o(148148);
      return true;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class c
    implements MenuItem.OnMenuItemClickListener
  {
    c(PhoneNumberManagerUI paramPhoneNumberManagerUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(148149);
      PhoneNumberManagerUI.a(this.llg, false);
      PhoneNumberManagerUI.b(this.llg);
      AppMethodBeat.o(148149);
      return true;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class d
    implements MenuItem.OnMenuItemClickListener
  {
    d(PhoneNumberManagerUI paramPhoneNumberManagerUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(148150);
      PhoneNumberManagerUI.a(this.llg, true);
      PhoneNumberManagerUI.b(this.llg);
      AppMethodBeat.o(148150);
      return true;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class e
    implements MenuItem.OnMenuItemClickListener
  {
    e(PhoneNumberManagerUI paramPhoneNumberManagerUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(148151);
      this.llg.finish();
      AppMethodBeat.o(148151);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberManagerUI
 * JD-Core Version:    0.7.0.1
 */
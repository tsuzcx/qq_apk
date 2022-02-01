package com.tencent.mm.plugin.appbrand.phonenumber;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.luggage.h.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.BaseLuggageActivity;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberAddUI;", "Lcom/tencent/mm/ui/base/BaseLuggageActivity;", "()V", "mPhoneNumberAddLogic", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberAddLogic;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "luggage-wechat-full-sdk_release"})
public final class PhoneNumberAddUI
  extends BaseLuggageActivity
{
  public static final PhoneNumberAddUI.a nzW;
  private l nzV;
  
  static
  {
    AppMethodBeat.i(148111);
    nzW = new PhoneNumberAddUI.a((byte)0);
    AppMethodBeat.o(148111);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(148109);
    if (j.cDv.isDarkMode())
    {
      setTheme(2131821592);
      super.onCreate(paramBundle);
      setNavigationbarColor(getResources().getColor(2131099649));
      setActionBarColor(getResources().getColor(2131099650));
      hideActionbarLine();
      paramBundle = getIntent().getStringExtra("APPID");
      Log.i("MicroMsg.PhoneNumberAddUI", "onCreate() appId:".concat(String.valueOf(paramBundle)));
      setTitle(2131756125);
      setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
      Object localObject = u.nAe;
      localObject = u.bTz();
      Context localContext = (Context)this;
      p.g(paramBundle, "appId");
      this.nzV = ((n)localObject).a(localContext, paramBundle, (a)new c(this));
      paramBundle = this.nzV;
      if (paramBundle != null) {
        paramBundle.init();
      }
      paramBundle = this.nzV;
      if (paramBundle == null) {
        break label193;
      }
    }
    label193:
    for (paramBundle = paramBundle.getView();; paramBundle = null)
    {
      setContentView(paramBundle);
      AppMethodBeat.o(148109);
      return;
      setTheme(2131821593);
      break;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(148110);
    super.onDestroy();
    l locall = this.nzV;
    if (locall != null)
    {
      locall.uninit();
      AppMethodBeat.o(148110);
      return;
    }
    AppMethodBeat.o(148110);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(PhoneNumberAddUI paramPhoneNumberAddUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(148107);
      this.nzX.finish();
      AppMethodBeat.o(148107);
      return true;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<x>
  {
    c(PhoneNumberAddUI paramPhoneNumberAddUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberAddUI
 * JD-Core Version:    0.7.0.1
 */
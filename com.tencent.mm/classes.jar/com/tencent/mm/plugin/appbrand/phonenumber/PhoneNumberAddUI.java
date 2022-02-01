package com.tencent.mm.plugin.appbrand.phonenumber;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.luggage.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.BaseLuggageActivity;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.z;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberAddUI;", "Lcom/tencent/mm/ui/base/BaseLuggageActivity;", "()V", "mPhoneNumberAddLogic", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberAddLogic;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "luggage-wechat-full-sdk_release"})
public final class PhoneNumberAddUI
  extends BaseLuggageActivity
{
  public static final PhoneNumberAddUI.a mkn;
  private l mkm;
  
  static
  {
    AppMethodBeat.i(148111);
    mkn = new PhoneNumberAddUI.a((byte)0);
    AppMethodBeat.o(148111);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(148109);
    if (i.cqA.isDarkMode())
    {
      setTheme(2131821544);
      super.onCreate(paramBundle);
      setNavigationbarColor(getResources().getColor(2131099649));
      setActionBarColor(getResources().getColor(2131099650));
      hideActionbarLine();
      paramBundle = getIntent().getStringExtra("APPID");
      ad.i("MicroMsg.PhoneNumberAddUI", "onCreate() appId:".concat(String.valueOf(paramBundle)));
      setTitle(2131756010);
      setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
      Object localObject = u.mkv;
      localObject = u.bwy();
      Context localContext = (Context)this;
      p.g(paramBundle, "appId");
      this.mkm = ((n)localObject).a(localContext, paramBundle, (a)new c(this));
      paramBundle = this.mkm;
      if (paramBundle != null) {
        paramBundle.init();
      }
      paramBundle = this.mkm;
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
      setTheme(2131821545);
      break;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(148110);
    super.onDestroy();
    l locall = this.mkm;
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
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(PhoneNumberAddUI paramPhoneNumberAddUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(148107);
      this.mko.finish();
      AppMethodBeat.o(148107);
      return true;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<z>
  {
    c(PhoneNumberAddUI paramPhoneNumberAddUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberAddUI
 * JD-Core Version:    0.7.0.1
 */
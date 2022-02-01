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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.BaseLuggageActivity;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.z;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberAddUI;", "Lcom/tencent/mm/ui/base/BaseLuggageActivity;", "()V", "mPhoneNumberAddLogic", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberAddLogic;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "luggage-wechat-full-sdk_release"})
public final class PhoneNumberAddUI
  extends BaseLuggageActivity
{
  public static final PhoneNumberAddUI.a mpk;
  private l mpj;
  
  static
  {
    AppMethodBeat.i(148111);
    mpk = new PhoneNumberAddUI.a((byte)0);
    AppMethodBeat.o(148111);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(148109);
    if (i.cre.isDarkMode())
    {
      setTheme(2131821544);
      super.onCreate(paramBundle);
      setNavigationbarColor(getResources().getColor(2131099649));
      setActionBarColor(getResources().getColor(2131099650));
      hideActionbarLine();
      paramBundle = getIntent().getStringExtra("APPID");
      ae.i("MicroMsg.PhoneNumberAddUI", "onCreate() appId:".concat(String.valueOf(paramBundle)));
      setTitle(2131756010);
      setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
      Object localObject = u.mps;
      localObject = u.bxp();
      Context localContext = (Context)this;
      p.g(paramBundle, "appId");
      this.mpj = ((n)localObject).a(localContext, paramBundle, (a)new c(this));
      paramBundle = this.mpj;
      if (paramBundle != null) {
        paramBundle.init();
      }
      paramBundle = this.mpj;
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
    l locall = this.mpj;
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
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(PhoneNumberAddUI paramPhoneNumberAddUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(148107);
      this.mpl.finish();
      AppMethodBeat.o(148107);
      return true;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberAddUI
 * JD-Core Version:    0.7.0.1
 */
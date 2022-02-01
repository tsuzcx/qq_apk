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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.BaseLuggageActivity;
import d.g.a.a;
import d.g.b.k;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberAddUI;", "Lcom/tencent/mm/ui/base/BaseLuggageActivity;", "()V", "mPhoneNumberAddLogic", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberAddLogic;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "luggage-wechat-full-sdk_release"})
public final class PhoneNumberAddUI
  extends BaseLuggageActivity
{
  public static final a lKx;
  private l lKw;
  
  static
  {
    AppMethodBeat.i(148111);
    lKx = new a((byte)0);
    AppMethodBeat.o(148111);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(148109);
    if (i.cgk.DT())
    {
      setTheme(2131821544);
      super.onCreate(paramBundle);
      setNavigationbarColor(getResources().getColor(2131099649));
      setActionBarColor(getResources().getColor(2131099650));
      hideActionbarLine();
      paramBundle = getIntent().getStringExtra("APPID");
      ac.i("MicroMsg.PhoneNumberAddUI", "onCreate() appId:".concat(String.valueOf(paramBundle)));
      setTitle(2131756010);
      setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
      Object localObject = u.lKF;
      localObject = u.bst();
      Context localContext = (Context)this;
      k.g(paramBundle, "appId");
      this.lKw = ((n)localObject).a(localContext, paramBundle, (a)new c(this));
      paramBundle = this.lKw;
      if (paramBundle != null) {
        paramBundle.init();
      }
      paramBundle = this.lKw;
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
    l locall = this.lKw;
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
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberAddUI$Companion;", "", "()V", "APPID", "", "TAG", "luggage-wechat-full-sdk_release"})
  public static final class a {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(PhoneNumberAddUI paramPhoneNumberAddUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(148107);
      this.lKy.finish();
      AppMethodBeat.o(148107);
      return true;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements a<y>
  {
    c(PhoneNumberAddUI paramPhoneNumberAddUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberAddUI
 * JD-Core Version:    0.7.0.1
 */
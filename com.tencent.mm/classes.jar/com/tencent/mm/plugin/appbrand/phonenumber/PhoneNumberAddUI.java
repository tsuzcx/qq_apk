package com.tencent.mm.plugin.appbrand.phonenumber;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.luggage.k.j;
import com.tencent.luggage.l.a.a;
import com.tencent.luggage.l.a.g;
import com.tencent.luggage.l.a.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.BaseLuggageActivity;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberAddUI;", "Lcom/tencent/mm/ui/base/BaseLuggageActivity;", "()V", "mPhoneNumberAddLogic", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberAddLogic;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "luggage-wechat-full-sdk_release"})
public final class PhoneNumberAddUI
  extends BaseLuggageActivity
{
  public static final PhoneNumberAddUI.a qCh;
  private l qCg;
  
  static
  {
    AppMethodBeat.i(148111);
    qCh = new PhoneNumberAddUI.a((byte)0);
    AppMethodBeat.o(148111);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(148109);
    String str = getIntent().getStringExtra("APPID");
    if (j.cEc.em(str))
    {
      setTheme(a.h.WeUITheme_DarkMode);
      super.onCreate(paramBundle);
      setNavigationbarColor(getResources().getColor(a.a.BG_1));
      setActionBarColor(getResources().getColor(a.a.BG_2));
      hideActionbarLine();
      Log.i("MicroMsg.PhoneNumberAddUI", "onCreate() appId:".concat(String.valueOf(str)));
      setTitle(a.g.appbrand_phone_number_add_phone_number);
      setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
      paramBundle = u.qCp;
      paramBundle = u.cgE();
      Context localContext = (Context)this;
      p.j(str, "appId");
      this.qCg = paramBundle.a(localContext, str, (a)new c(this));
      paramBundle = this.qCg;
      if (paramBundle != null) {
        paramBundle.init();
      }
      paramBundle = this.qCg;
      if (paramBundle == null) {
        break label199;
      }
    }
    label199:
    for (paramBundle = paramBundle.getView();; paramBundle = null)
    {
      setContentView(paramBundle);
      AppMethodBeat.o(148109);
      return;
      setTheme(a.h.WeUITheme_LightMode);
      break;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(148110);
    super.onDestroy();
    l locall = this.qCg;
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
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(PhoneNumberAddUI paramPhoneNumberAddUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(148107);
      this.qCi.finish();
      AppMethodBeat.o(148107);
      return true;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberAddUI
 * JD-Core Version:    0.7.0.1
 */
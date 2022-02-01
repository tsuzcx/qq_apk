package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.luggage.l.k;
import com.tencent.luggage.m.a.a;
import com.tencent.luggage.m.a.g;
import com.tencent.luggage.m.a.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.BaseLuggageActivity;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberAddUI;", "Lcom/tencent/mm/ui/base/BaseLuggageActivity;", "()V", "mPhoneNumberAddLogic", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberAddLogic;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PhoneNumberAddUI
  extends BaseLuggageActivity
{
  public static final PhoneNumberAddUI.a tHe;
  private l tHf;
  
  static
  {
    AppMethodBeat.i(148111);
    tHe = new PhoneNumberAddUI.a((byte)0);
    AppMethodBeat.o(148111);
  }
  
  private static final boolean a(PhoneNumberAddUI paramPhoneNumberAddUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(318947);
    s.u(paramPhoneNumberAddUI, "this$0");
    paramPhoneNumberAddUI.finish();
    AppMethodBeat.o(318947);
    return true;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(148109);
    String str = getIntent().getStringExtra("APPID");
    if (k.exm.fJ(str))
    {
      setTheme(a.h.WeUITheme_DarkMode);
      super.onCreate(paramBundle);
      setNavigationbarColor(getResources().getColor(a.a.BG_1));
      setActionBarColor(getResources().getColor(a.a.BG_2));
      hideActionbarLine();
      Log.i("MicroMsg.PhoneNumberAddUI", s.X("onCreate() appId:", str));
      setTitle((CharSequence)getResources().getString(a.g.appbrand_phone_number_add_phone_number));
      setBackBtn(new PhoneNumberAddUI..ExternalSyntheticLambda0(this));
      paramBundle = u.tHm;
      paramBundle = u.cHB();
      Context localContext = (Context)this;
      s.checkNotNull(str);
      this.tHf = paramBundle.a(localContext, str, (a)new b(this));
      paramBundle = this.tHf;
      if (paramBundle != null) {
        paramBundle.init();
      }
      paramBundle = this.tHf;
      if (paramBundle != null) {
        break label196;
      }
    }
    label196:
    for (paramBundle = null;; paramBundle = paramBundle.getView())
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
    l locall = this.tHf;
    if (locall != null) {
      locall.uninit();
    }
    AppMethodBeat.o(148110);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements a<ah>
  {
    b(PhoneNumberAddUI paramPhoneNumberAddUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberAddUI
 * JD-Core Version:    0.7.0.1
 */
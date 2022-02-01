package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.au.f;
import com.tencent.mm.plugin.appbrand.au.g;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;

@com.tencent.mm.ui.base.a(19)
public final class AppBrand404PageUI
  extends MMActivity
{
  public static void CR(int paramInt)
  {
    AppMethodBeat.i(48514);
    a(MMApplicationContext.getContext().getString(paramInt), null);
    AppMethodBeat.o(48514);
  }
  
  public static void a(int paramInt, ActivityStarterIpcDelegate paramActivityStarterIpcDelegate)
  {
    AppMethodBeat.i(246391);
    a(MMApplicationContext.getContext().getString(paramInt), paramActivityStarterIpcDelegate);
    AppMethodBeat.o(246391);
  }
  
  private static void a(String paramString, ActivityStarterIpcDelegate paramActivityStarterIpcDelegate)
  {
    AppMethodBeat.i(48513);
    paramString = new Intent(MMApplicationContext.getContext(), AppBrand404PageUI.class).putExtra("key_wording", paramString).putExtra("key_icon_url", null);
    if (paramActivityStarterIpcDelegate != null)
    {
      paramString = new com.tencent.mm.hellhoundlib.b.a().bm(paramString);
      com.tencent.mm.hellhoundlib.a.a.b(paramActivityStarterIpcDelegate, paramString.aFh(), "com/tencent/mm/plugin/appbrand/ui/AppBrand404PageUI", "show", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/luggage/sdk/launching/ActivityStarterIpcDelegate;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramActivityStarterIpcDelegate.startActivity((Intent)paramString.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramActivityStarterIpcDelegate, "com/tencent/mm/plugin/appbrand/ui/AppBrand404PageUI", "show", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/luggage/sdk/launching/ActivityStarterIpcDelegate;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(48513);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48511);
        this.val$intent.addFlags(268435456);
        Context localContext = MMApplicationContext.getContext();
        Object localObject = this.val$intent;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/appbrand/ui/AppBrand404PageUI$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/appbrand/ui/AppBrand404PageUI$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(48511);
      }
    });
    AppMethodBeat.o(48513);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(48517);
    super.finish();
    AppMethodBeat.o(48517);
  }
  
  public final int getLayoutId()
  {
    return au.g.app_brand_404_page_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48516);
    super.onCreate(paramBundle);
    setMMTitle(au.i.app_brand_error);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(48512);
        AppBrand404PageUI.this.finish();
        AppMethodBeat.o(48512);
        return true;
      }
    });
    paramBundle = (TextView)findViewById(au.f.app_brand_error_page_reason);
    String str = getIntent().getStringExtra("key_wording");
    Util.isNullOrNil(str);
    if (paramBundle != null) {
      paramBundle.setText(str);
    }
    AppMethodBeat.o(48516);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(48518);
    super.onDestroy();
    AppMethodBeat.o(48518);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrand404PageUI
 * JD-Core Version:    0.7.0.1
 */
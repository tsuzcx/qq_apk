package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;

@com.tencent.mm.ui.base.a(19)
public final class AppBrand404PageUI
  extends MMActivity
{
  public static void a(ActivityStarterIpcDelegate paramActivityStarterIpcDelegate)
  {
    AppMethodBeat.i(48515);
    a(ai.getContext().getString(2131755509), paramActivityStarterIpcDelegate);
    AppMethodBeat.o(48515);
  }
  
  private static void a(String paramString, ActivityStarterIpcDelegate paramActivityStarterIpcDelegate)
  {
    AppMethodBeat.i(48513);
    paramString = new Intent(ai.getContext(), AppBrand404PageUI.class).putExtra("key_wording", paramString).putExtra("key_icon_url", null);
    if (paramActivityStarterIpcDelegate != null)
    {
      paramString = new com.tencent.mm.hellhoundlib.b.a().ba(paramString);
      com.tencent.mm.hellhoundlib.a.a.a(paramActivityStarterIpcDelegate, paramString.aeD(), "com/tencent/mm/plugin/appbrand/ui/AppBrand404PageUI", "show", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/luggage/sdk/launching/ActivityStarterIpcDelegate;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString = (Intent)paramString.lR(0);
      if (paramString != null)
      {
        Bundle localBundle = new Bundle(1);
        localBundle.putParcelable("intent", paramString);
        paramActivityStarterIpcDelegate.ceI.send(4660, localBundle);
      }
      com.tencent.mm.hellhoundlib.a.a.a(paramActivityStarterIpcDelegate, "com/tencent/mm/plugin/appbrand/ui/AppBrand404PageUI", "show", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/luggage/sdk/launching/ActivityStarterIpcDelegate;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(48513);
      return;
    }
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48511);
        this.val$intent.addFlags(268435456);
        Context localContext = ai.getContext();
        Object localObject = this.val$intent;
        localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/appbrand/ui/AppBrand404PageUI$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/appbrand/ui/AppBrand404PageUI$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(48511);
      }
    });
    AppMethodBeat.o(48513);
  }
  
  public static void show(int paramInt)
  {
    AppMethodBeat.i(48514);
    a(ai.getContext().getString(paramInt), null);
    AppMethodBeat.o(48514);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(48517);
    super.finish();
    AppMethodBeat.o(48517);
  }
  
  public final int getLayoutId()
  {
    return 2131492963;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48516);
    super.onCreate(paramBundle);
    setMMTitle(2131755402);
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
    paramBundle = (TextView)findViewById(2131296715);
    String str = getIntent().getStringExtra("key_wording");
    bs.isNullOrNil(str);
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
package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;

public class AppBrandWaitingDebugUI
  extends MMActivity
{
  public int getLayoutId()
  {
    return 2131493077;
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(48889);
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    final String str = paramBundle.getStringExtra("fromClass");
    ad.i("MicroMsg.AppBrandWaitingDebugUI", "hy: from class: %s", new Object[] { str });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(48887);
        AppBrandWaitingDebugUI.this.finish();
        AppMethodBeat.o(48887);
        return true;
      }
    });
    findViewById(2131296903).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(48888);
        try
        {
          paramAnonymousView = Class.forName(str);
          paramBundle.setClass(AppBrandWaitingDebugUI.this, paramAnonymousView);
          paramAnonymousView = AppBrandWaitingDebugUI.this;
          Object localObject = paramBundle;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/appbrand/ui/AppBrandWaitingDebugUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/appbrand/ui/AppBrandWaitingDebugUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppBrandWaitingDebugUI.this.finish();
          AppMethodBeat.o(48888);
          return;
        }
        catch (ClassNotFoundException paramAnonymousView)
        {
          ad.printErrStackTrace("MicroMsg.AppBrandWaitingDebugUI", paramAnonymousView, "hy: not found class! %s", new Object[] { str });
          AppMethodBeat.o(48888);
        }
      }
    });
    AppMethodBeat.o(48889);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandWaitingDebugUI
 * JD-Core Version:    0.7.0.1
 */
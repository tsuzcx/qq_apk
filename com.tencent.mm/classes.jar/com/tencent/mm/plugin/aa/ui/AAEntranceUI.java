package com.tencent.mm.plugin.aa.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.e.a;
import com.tencent.mm.wallet_core.ui.f;

@i
public class AAEntranceUI
  extends MMActivity
{
  private Button jUs;
  private TextView jUt;
  private TextView jUu;
  
  public int getLayoutId()
  {
    return 2131492896;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(63475);
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(63475);
      return;
    }
    if (paramInt1 == 1)
    {
      String str = paramIntent.getStringExtra("Select_Conv_User");
      Log.i("MicroMsg.AAEntranceUI", "select chatroom：%s", new Object[] { str });
      if (!Util.isNullOrNil(str))
      {
        Intent localIntent = new Intent(getContext(), LaunchAAUI.class);
        localIntent.putExtra("enter_scene", 2);
        localIntent.putExtra("chatroom_name", str);
        if (getIntent().getExtras() != null) {
          localIntent.putExtras(getIntent().getExtras());
        }
        startActivityForResult(localIntent, 2);
      }
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(63475);
      return;
      if (paramInt1 == 2) {
        finish();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(63474);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(2131101424));
    hideActionbarLine();
    setMMTitle("");
    this.jUs = ((Button)findViewById(2131303043));
    this.jUt = ((TextView)findViewById(2131298598));
    this.jUs.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(63471);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/aa/ui/AAEntranceUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        AAEntranceUI.a(AAEntranceUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/aa/ui/AAEntranceUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(63471);
      }
    });
    paramBundle = getString(2131757550);
    f.a(this.jUt, paramBundle, 0, paramBundle.length(), new e(new e.a()
    {
      public final void bmr()
      {
        AppMethodBeat.i(63472);
        Object localObject = new Intent(AAEntranceUI.this.getContext(), AAQueryListUI.class);
        AAEntranceUI localAAEntranceUI = AAEntranceUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(localAAEntranceUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/aa/ui/AAEntranceUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localAAEntranceUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(localAAEntranceUI, "com/tencent/mm/plugin/aa/ui/AAEntranceUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(63472);
      }
    }), getContext());
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(63473);
        AAEntranceUI.this.finish();
        AppMethodBeat.o(63473);
        return false;
      }
    });
    this.jUu = ((TextView)findViewById(2131296291));
    ao.a(this.jUu.getPaint(), 0.8F);
    AppMethodBeat.o(63474);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AAEntranceUI
 * JD-Core Version:    0.7.0.1
 */
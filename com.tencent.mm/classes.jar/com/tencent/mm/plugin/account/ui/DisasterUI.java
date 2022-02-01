package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;

public class DisasterUI
  extends MMActivity
{
  public int getLayoutId()
  {
    return 2131493716;
  }
  
  public boolean needShowIdcError()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(127908);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("key_disaster_content");
    final String str = getIntent().getStringExtra("key_disaster_url");
    ae.i("MicroMsg.DisasterUI", "summerdiz onCreate :%d, content[%s], url[%s]", new Object[] { Integer.valueOf(hashCode()), paramBundle, str });
    ((TextView)findViewById(2131302969)).setText(paramBundle);
    findViewById(2131302968).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(127906);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/DisasterUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
        ae.i("MicroMsg.DisasterUI", "summerdiz jump link");
        g.yxI.f(13939, new Object[] { Integer.valueOf(1) });
        localObject = new Intent("android.intent.action.VIEW");
        ((Intent)localObject).setData(Uri.parse(str));
        paramAnonymousView = DisasterUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/account/ui/DisasterUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/account/ui/DisasterUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/DisasterUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(127906);
      }
    });
    setMMTitle(getString(2131758087));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(127907);
        g.yxI.f(13939, new Object[] { Integer.valueOf(3) });
        ae.i("MicroMsg.DisasterUI", "summerdiz back");
        DisasterUI.this.finish();
        AppMethodBeat.o(127907);
        return true;
      }
    });
    AppMethodBeat.o(127908);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.DisasterUI
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.brandservice.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;

public final class e
{
  final Activity dgE;
  String nwL;
  com.tencent.mm.ui.tools.m nxw;
  
  public e(Activity paramActivity, String paramString)
  {
    this.dgE = paramActivity;
    this.nwL = paramString;
  }
  
  public final MenuItem.OnMenuItemClickListener bJG()
  {
    AppMethodBeat.i(198652);
    MenuItem.OnMenuItemClickListener local1 = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(198651);
        if (e.this.nxw != null)
        {
          e.this.nxw.dismiss();
          e.this.nxw = null;
        }
        e.this.nxw = new com.tencent.mm.ui.tools.m(e.this.dgE);
        e.this.nxw.ISu = new n.c()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
          {
            AppMethodBeat.i(198649);
            ((com.tencent.mm.api.m)g.ab(com.tencent.mm.api.m.class)).dW(e.this.nwL);
            String str;
            if (!((com.tencent.mm.api.m)g.ab(com.tencent.mm.api.m.class)).dT(e.this.nwL))
            {
              str = ((com.tencent.mm.api.m)g.ab(com.tencent.mm.api.m.class)).dU(e.this.nwL);
              if (!bs.isNullOrNil(str)) {
                break label121;
              }
              paramAnonymous2l.aJ(2, 2131760267, 2131690972);
            }
            for (;;)
            {
              paramAnonymous2l.aJ(3, 2131758438, 2131689485);
              paramAnonymous2l.aJ(4, 2131755135, 2131689512);
              AppMethodBeat.o(198649);
              return;
              label121:
              paramAnonymous2l.a(2, str, 2131690972);
            }
          }
        };
        e.this.nxw.ISv = new n.d()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(198650);
            switch (paramAnonymous2MenuItem.getItemId())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(198650);
              return;
              paramAnonymous2MenuItem = ((com.tencent.mm.api.m)g.ab(com.tencent.mm.api.m.class)).dV(e.this.nwL);
              if (!bs.isNullOrNil(paramAnonymous2MenuItem)) {}
              for (paramAnonymous2Int = 1; paramAnonymous2Int != 0; paramAnonymous2Int = 0)
              {
                localObject = new Intent();
                ((Intent)localObject).putExtra("rawUrl", paramAnonymous2MenuItem);
                ac.i("EnterpriseBizEntranceListHelper", "KRawUrl :%s", new Object[] { paramAnonymous2MenuItem });
                ((Intent)localObject).putExtra("useJs", true);
                ((Intent)localObject).addFlags(67108864);
                d.b(e.this.dgE, "webview", ".ui.tools.WebViewUI", (Intent)localObject, 0);
                AppMethodBeat.o(198650);
                return;
              }
              ((com.tencent.mm.api.m)g.ab(com.tencent.mm.api.m.class)).dW(e.this.nwL);
              ((com.tencent.mm.api.m)g.ab(com.tencent.mm.api.m.class)).b(e.this.dgE, e.this.nwL);
              AppMethodBeat.o(198650);
              return;
              Object localObject = new Intent(e.this.dgE, EnterpriseBizContactPlainListUI.class);
              ((Intent)localObject).putExtra("enterprise_biz_name", e.this.nwL);
              ((Intent)localObject).putExtra("enterprise_scene", 2);
              paramAnonymous2MenuItem = e.this.dgE;
              localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2MenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListHelper$1$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymous2MenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2MenuItem, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListHelper$1$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(198650);
              return;
              paramAnonymous2MenuItem = new Intent();
              paramAnonymous2MenuItem.putExtra("Contact_User", e.this.nwL);
              com.tencent.mm.plugin.brandservice.b.iyx.c(paramAnonymous2MenuItem, e.this.dgE);
            }
          }
        };
        e.this.nxw.hU();
        AppMethodBeat.o(198651);
        return false;
      }
    };
    AppMethodBeat.o(198652);
    return local1;
  }
  
  public final boolean d(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(198653);
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(198653);
      return false;
    }
    if ((paramInt2 == -1) && (paramIntent != null))
    {
      String str1 = paramIntent.getStringExtra("be_send_card_name");
      String str2 = paramIntent.getStringExtra("received_card_name");
      boolean bool = paramIntent.getBooleanExtra("Is_Chatroom", false);
      paramIntent = paramIntent.getStringExtra("custom_send_text");
      j.dck().q(str1, str2, bool);
      j.dck().hF(paramIntent, str2);
      com.tencent.mm.ui.widget.snackbar.b.n(this.dgE, this.dgE.getString(2131760233));
    }
    AppMethodBeat.o(198653);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.e
 * JD-Core Version:    0.7.0.1
 */
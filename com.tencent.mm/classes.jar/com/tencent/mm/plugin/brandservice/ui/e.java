package com.tencent.mm.plugin.brandservice.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;

public final class e
{
  final Activity dtg;
  String odS;
  com.tencent.mm.ui.tools.m oeD;
  
  public e(Activity paramActivity, String paramString)
  {
    this.dtg = paramActivity;
    this.odS = paramString;
  }
  
  public final MenuItem.OnMenuItemClickListener bOW()
  {
    AppMethodBeat.i(208412);
    MenuItem.OnMenuItemClickListener local1 = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(208411);
        if (e.this.oeD != null)
        {
          e.this.oeD.dismiss();
          e.this.oeD = null;
        }
        e.this.oeD = new com.tencent.mm.ui.tools.m(e.this.dtg);
        e.this.oeD.LfS = new n.d()
        {
          public final void onCreateMMMenu(l paramAnonymous2l)
          {
            AppMethodBeat.i(208409);
            ((com.tencent.mm.api.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.m.class)).eW(e.this.odS);
            String str;
            if (!((com.tencent.mm.api.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.m.class)).eT(e.this.odS))
            {
              str = ((com.tencent.mm.api.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.m.class)).eU(e.this.odS);
              if (!bu.isNullOrNil(str)) {
                break label121;
              }
              paramAnonymous2l.aM(2, 2131760267, 2131690972);
            }
            for (;;)
            {
              paramAnonymous2l.aM(3, 2131758438, 2131689485);
              paramAnonymous2l.aM(4, 2131755135, 2131689512);
              AppMethodBeat.o(208409);
              return;
              label121:
              paramAnonymous2l.a(2, str, 2131690972);
            }
          }
        };
        e.this.oeD.LfT = new n.e()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(208410);
            switch (paramAnonymous2MenuItem.getItemId())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(208410);
              return;
              paramAnonymous2MenuItem = ((com.tencent.mm.api.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.m.class)).eV(e.this.odS);
              if (!bu.isNullOrNil(paramAnonymous2MenuItem)) {}
              for (paramAnonymous2Int = 1; paramAnonymous2Int != 0; paramAnonymous2Int = 0)
              {
                localObject = new Intent();
                ((Intent)localObject).putExtra("rawUrl", paramAnonymous2MenuItem);
                ae.i("EnterpriseBizEntranceListHelper", "KRawUrl :%s", new Object[] { paramAnonymous2MenuItem });
                ((Intent)localObject).putExtra("useJs", true);
                ((Intent)localObject).addFlags(67108864);
                com.tencent.mm.br.d.b(e.this.dtg, "webview", ".ui.tools.WebViewUI", (Intent)localObject, 0);
                AppMethodBeat.o(208410);
                return;
              }
              ((com.tencent.mm.api.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.m.class)).eW(e.this.odS);
              ((com.tencent.mm.api.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.m.class)).b(e.this.dtg, e.this.odS);
              AppMethodBeat.o(208410);
              return;
              Object localObject = new Intent(e.this.dtg, EnterpriseBizContactPlainListUI.class);
              ((Intent)localObject).putExtra("enterprise_biz_name", e.this.odS);
              ((Intent)localObject).putExtra("enterprise_scene", 2);
              paramAnonymous2MenuItem = e.this.dtg;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2MenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListHelper$1$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymous2MenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2MenuItem, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListHelper$1$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(208410);
              return;
              paramAnonymous2MenuItem = new Intent();
              paramAnonymous2MenuItem.putExtra("Contact_User", e.this.odS);
              com.tencent.mm.plugin.brandservice.b.iUz.c(paramAnonymous2MenuItem, e.this.dtg);
            }
          }
        };
        e.this.oeD.il();
        AppMethodBeat.o(208411);
        return false;
      }
    };
    AppMethodBeat.o(208412);
    return local1;
  }
  
  public final boolean d(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(208413);
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(208413);
      return false;
    }
    if ((paramInt2 == -1) && (paramIntent != null))
    {
      String str1 = paramIntent.getStringExtra("be_send_card_name");
      String str2 = paramIntent.getStringExtra("received_card_name");
      boolean bool = paramIntent.getBooleanExtra("Is_Chatroom", false);
      paramIntent = paramIntent.getStringExtra("custom_send_text");
      com.tencent.mm.plugin.messenger.a.g.doC().q(str1, str2, bool);
      com.tencent.mm.plugin.messenger.a.g.doC().hW(paramIntent, str2);
      com.tencent.mm.ui.widget.snackbar.b.n(this.dtg, this.dtg.getString(2131760233));
    }
    AppMethodBeat.o(208413);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.e
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.brandservice.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.n;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.messenger.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;

public final class e
{
  final Activity dKq;
  String poQ;
  com.tencent.mm.ui.tools.m ppB;
  
  public e(Activity paramActivity, String paramString)
  {
    this.dKq = paramActivity;
    this.poQ = paramString;
  }
  
  public final MenuItem.OnMenuItemClickListener cmc()
  {
    AppMethodBeat.i(194877);
    MenuItem.OnMenuItemClickListener local1 = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(194876);
        if (e.this.ppB != null)
        {
          e.this.ppB.dismiss();
          e.this.ppB = null;
        }
        e.this.ppB = new com.tencent.mm.ui.tools.m(e.this.dKq);
        e.this.ppB.HLX = new o.f()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramAnonymous2m)
          {
            AppMethodBeat.i(194874);
            ((n)com.tencent.mm.kernel.g.af(n.class)).fI(e.this.poQ);
            String str;
            if (!((n)com.tencent.mm.kernel.g.af(n.class)).fF(e.this.poQ))
            {
              str = ((n)com.tencent.mm.kernel.g.af(n.class)).fG(e.this.poQ);
              if (!Util.isNullOrNil(str)) {
                break label121;
              }
              paramAnonymous2m.aS(2, 2131756829, 2131691270);
            }
            for (;;)
            {
              paramAnonymous2m.aS(3, 2131758735, 2131689487);
              paramAnonymous2m.aS(4, 2131755153, 2131689514);
              AppMethodBeat.o(194874);
              return;
              label121:
              paramAnonymous2m.b(2, str, 2131691270);
            }
          }
        };
        e.this.ppB.HLY = new o.g()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(194875);
            switch (paramAnonymous2MenuItem.getItemId())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(194875);
              return;
              paramAnonymous2MenuItem = ((n)com.tencent.mm.kernel.g.af(n.class)).fH(e.this.poQ);
              if (!Util.isNullOrNil(paramAnonymous2MenuItem)) {}
              for (paramAnonymous2Int = 1; paramAnonymous2Int != 0; paramAnonymous2Int = 0)
              {
                localObject = new Intent();
                ((Intent)localObject).putExtra("rawUrl", paramAnonymous2MenuItem);
                Log.i("EnterpriseBizEntranceListHelper", "KRawUrl :%s", new Object[] { paramAnonymous2MenuItem });
                ((Intent)localObject).putExtra("useJs", true);
                ((Intent)localObject).addFlags(67108864);
                c.b(e.this.dKq, "webview", ".ui.tools.WebViewUI", (Intent)localObject, 0);
                AppMethodBeat.o(194875);
                return;
              }
              ((n)com.tencent.mm.kernel.g.af(n.class)).fI(e.this.poQ);
              ((n)com.tencent.mm.kernel.g.af(n.class)).b(e.this.dKq, e.this.poQ);
              AppMethodBeat.o(194875);
              return;
              Object localObject = new Intent(e.this.dKq, EnterpriseBizContactPlainListUI.class);
              ((Intent)localObject).putExtra("enterprise_biz_name", e.this.poQ);
              ((Intent)localObject).putExtra("enterprise_scene", 2);
              paramAnonymous2MenuItem = e.this.dKq;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2MenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListHelper$1$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymous2MenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2MenuItem, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListHelper$1$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(194875);
              return;
              paramAnonymous2MenuItem = new Intent();
              paramAnonymous2MenuItem.putExtra("Contact_User", e.this.poQ);
              com.tencent.mm.plugin.brandservice.b.jRt.c(paramAnonymous2MenuItem, e.this.dKq);
            }
          }
        };
        e.this.ppB.iv();
        AppMethodBeat.o(194876);
        return false;
      }
    };
    AppMethodBeat.o(194877);
    return local1;
  }
  
  public final boolean e(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(194878);
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(194878);
      return false;
    }
    if ((paramInt2 == -1) && (paramIntent != null))
    {
      String str1 = paramIntent.getStringExtra("be_send_card_name");
      String str2 = paramIntent.getStringExtra("received_card_name");
      boolean bool = paramIntent.getBooleanExtra("Is_Chatroom", false);
      paramIntent = paramIntent.getStringExtra("custom_send_text");
      com.tencent.mm.plugin.messenger.a.g.eir().s(str1, str2, bool);
      com.tencent.mm.plugin.messenger.a.g.eir().iF(paramIntent, str2);
      com.tencent.mm.ui.widget.snackbar.b.r(this.dKq, this.dKq.getString(2131761619));
    }
    AppMethodBeat.o(194878);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.e
 * JD-Core Version:    0.7.0.1
 */
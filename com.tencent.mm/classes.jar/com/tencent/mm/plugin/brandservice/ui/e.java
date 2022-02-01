package com.tencent.mm.plugin.brandservice.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;

public final class e
{
  final Activity dsa;
  com.tencent.mm.ui.tools.m nYU;
  String nYj;
  
  public e(Activity paramActivity, String paramString)
  {
    this.dsa = paramActivity;
    this.nYj = paramString;
  }
  
  public final MenuItem.OnMenuItemClickListener bNZ()
  {
    AppMethodBeat.i(209458);
    MenuItem.OnMenuItemClickListener local1 = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(209457);
        if (e.this.nYU != null)
        {
          e.this.nYU.dismiss();
          e.this.nYU = null;
        }
        e.this.nYU = new com.tencent.mm.ui.tools.m(e.this.dsa);
        e.this.nYU.KJy = new n.d()
        {
          public final void onCreateMMMenu(l paramAnonymous2l)
          {
            AppMethodBeat.i(209455);
            ((com.tencent.mm.api.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.m.class)).eR(e.this.nYj);
            String str;
            if (!((com.tencent.mm.api.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.m.class)).eO(e.this.nYj))
            {
              str = ((com.tencent.mm.api.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.m.class)).eP(e.this.nYj);
              if (!bt.isNullOrNil(str)) {
                break label121;
              }
              paramAnonymous2l.aL(2, 2131760267, 2131690972);
            }
            for (;;)
            {
              paramAnonymous2l.aL(3, 2131758438, 2131689485);
              paramAnonymous2l.aL(4, 2131755135, 2131689512);
              AppMethodBeat.o(209455);
              return;
              label121:
              paramAnonymous2l.a(2, str, 2131690972);
            }
          }
        };
        e.this.nYU.KJz = new n.e()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(209456);
            switch (paramAnonymous2MenuItem.getItemId())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(209456);
              return;
              paramAnonymous2MenuItem = ((com.tencent.mm.api.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.m.class)).eQ(e.this.nYj);
              if (!bt.isNullOrNil(paramAnonymous2MenuItem)) {}
              for (paramAnonymous2Int = 1; paramAnonymous2Int != 0; paramAnonymous2Int = 0)
              {
                localObject = new Intent();
                ((Intent)localObject).putExtra("rawUrl", paramAnonymous2MenuItem);
                ad.i("EnterpriseBizEntranceListHelper", "KRawUrl :%s", new Object[] { paramAnonymous2MenuItem });
                ((Intent)localObject).putExtra("useJs", true);
                ((Intent)localObject).addFlags(67108864);
                com.tencent.mm.bs.d.b(e.this.dsa, "webview", ".ui.tools.WebViewUI", (Intent)localObject, 0);
                AppMethodBeat.o(209456);
                return;
              }
              ((com.tencent.mm.api.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.m.class)).eR(e.this.nYj);
              ((com.tencent.mm.api.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.m.class)).b(e.this.dsa, e.this.nYj);
              AppMethodBeat.o(209456);
              return;
              Object localObject = new Intent(e.this.dsa, EnterpriseBizContactPlainListUI.class);
              ((Intent)localObject).putExtra("enterprise_biz_name", e.this.nYj);
              ((Intent)localObject).putExtra("enterprise_scene", 2);
              paramAnonymous2MenuItem = e.this.dsa;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2MenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListHelper$1$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymous2MenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2MenuItem, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListHelper$1$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(209456);
              return;
              paramAnonymous2MenuItem = new Intent();
              paramAnonymous2MenuItem.putExtra("Contact_User", e.this.nYj);
              com.tencent.mm.plugin.brandservice.b.iRG.c(paramAnonymous2MenuItem, e.this.dsa);
            }
          }
        };
        e.this.nYU.il();
        AppMethodBeat.o(209457);
        return false;
      }
    };
    AppMethodBeat.o(209458);
    return local1;
  }
  
  public final boolean d(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(209459);
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(209459);
      return false;
    }
    if ((paramInt2 == -1) && (paramIntent != null))
    {
      String str1 = paramIntent.getStringExtra("be_send_card_name");
      String str2 = paramIntent.getStringExtra("received_card_name");
      boolean bool = paramIntent.getBooleanExtra("Is_Chatroom", false);
      paramIntent = paramIntent.getStringExtra("custom_send_text");
      com.tencent.mm.plugin.messenger.a.g.dlD().q(str1, str2, bool);
      com.tencent.mm.plugin.messenger.a.g.dlD().hP(paramIntent, str2);
      com.tencent.mm.ui.widget.snackbar.b.n(this.dsa, this.dsa.getString(2131760233));
    }
    AppMethodBeat.o(209459);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.e
 * JD-Core Version:    0.7.0.1
 */
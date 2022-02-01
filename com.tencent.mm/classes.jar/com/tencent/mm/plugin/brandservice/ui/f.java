package com.tencent.mm.plugin.brandservice.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.o;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.brandservice.d.h;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.plugin.messenger.a.d;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;

public final class f
{
  final Activity hHU;
  String vDy;
  com.tencent.mm.ui.tools.m vEh;
  
  public f(Activity paramActivity, String paramString)
  {
    this.hHU = paramActivity;
    this.vDy = paramString;
  }
  
  public final MenuItem.OnMenuItemClickListener dcy()
  {
    AppMethodBeat.i(301720);
    MenuItem.OnMenuItemClickListener local1 = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(301610);
        if (f.this.vEh != null)
        {
          f.this.vEh.dismiss();
          f.this.vEh = null;
        }
        f.this.vEh = new com.tencent.mm.ui.tools.m(f.this.hHU);
        f.this.vEh.Vtg = new u.g()
        {
          public final void onCreateMMMenu(s paramAnonymous2s)
          {
            AppMethodBeat.i(301558);
            ((o)h.ax(o.class)).hT(f.this.vDy);
            String str;
            if (!((o)h.ax(o.class)).hQ(f.this.vDy))
            {
              str = ((o)h.ax(o.class)).hR(f.this.vDy);
              if (!Util.isNullOrNil(str)) {
                break label127;
              }
              paramAnonymous2s.bx(2, d.i.bizchat_invite_chat, d.h.ofm_add_icon);
            }
            for (;;)
            {
              paramAnonymous2s.bx(3, d.i.enterprise_disable, d.h.actionbar_goto_disabled_biz_icon);
              paramAnonymous2s.bx(4, d.i.actionbar_title_setting, d.h.actionbar_setting_white_icon);
              AppMethodBeat.o(301558);
              return;
              label127:
              paramAnonymous2s.a(2, str, d.h.ofm_add_icon);
            }
          }
        };
        f.this.vEh.GAC = new u.i()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(301561);
            switch (paramAnonymous2MenuItem.getItemId())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(301561);
              return;
              paramAnonymous2MenuItem = ((o)h.ax(o.class)).hS(f.this.vDy);
              if (!Util.isNullOrNil(paramAnonymous2MenuItem)) {}
              for (paramAnonymous2Int = 1; paramAnonymous2Int != 0; paramAnonymous2Int = 0)
              {
                localObject = new Intent();
                ((Intent)localObject).putExtra("rawUrl", paramAnonymous2MenuItem);
                Log.i("EnterpriseBizEntranceListHelper", "KRawUrl :%s", new Object[] { paramAnonymous2MenuItem });
                ((Intent)localObject).putExtra("useJs", true);
                ((Intent)localObject).addFlags(67108864);
                c.b(f.this.hHU, "webview", ".ui.tools.WebViewUI", (Intent)localObject, 0);
                AppMethodBeat.o(301561);
                return;
              }
              ((o)h.ax(o.class)).hT(f.this.vDy);
              ((o)h.ax(o.class)).b(f.this.hHU, f.this.vDy);
              AppMethodBeat.o(301561);
              return;
              Object localObject = new Intent(f.this.hHU, EnterpriseBizContactPlainListUI.class);
              ((Intent)localObject).putExtra("enterprise_biz_name", f.this.vDy);
              ((Intent)localObject).putExtra("enterprise_scene", 2);
              paramAnonymous2MenuItem = f.this.hHU;
              localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
              com.tencent.mm.hellhoundlib.a.a.b(paramAnonymous2MenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListHelper$1$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymous2MenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
              com.tencent.mm.hellhoundlib.a.a.c(paramAnonymous2MenuItem, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListHelper$1$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(301561);
              return;
              paramAnonymous2MenuItem = new Intent();
              paramAnonymous2MenuItem.putExtra("Contact_User", f.this.vDy);
              com.tencent.mm.plugin.brandservice.b.pFn.c(paramAnonymous2MenuItem, f.this.hHU);
            }
          }
        };
        f.this.vEh.du();
        AppMethodBeat.o(301610);
        return false;
      }
    };
    AppMethodBeat.o(301720);
    return local1;
  }
  
  public final boolean h(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(301722);
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(301722);
      return false;
    }
    if ((paramInt2 == -1) && (paramIntent != null))
    {
      String str1 = paramIntent.getStringExtra("be_send_card_name");
      String str2 = paramIntent.getStringExtra("received_card_name");
      boolean bool = paramIntent.getBooleanExtra("Is_Chatroom", false);
      paramIntent = paramIntent.getStringExtra("custom_send_text");
      g.gaI().B(str1, str2, bool);
      g.gaI().ke(paramIntent, str2);
      com.tencent.mm.ui.widget.snackbar.b.u(this.hHU, this.hHU.getString(d.i.has_send));
    }
    AppMethodBeat.o(301722);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.f
 * JD-Core Version:    0.7.0.1
 */
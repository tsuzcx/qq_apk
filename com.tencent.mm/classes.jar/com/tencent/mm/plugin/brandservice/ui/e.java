package com.tencent.mm.plugin.brandservice.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.brandservice.d.h;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.plugin.messenger.a.d;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;

public final class e
{
  final Activity fDf;
  String sxP;
  com.tencent.mm.ui.tools.n syA;
  
  public e(Activity paramActivity, String paramString)
  {
    this.fDf = paramActivity;
    this.sxP = paramString;
  }
  
  public final MenuItem.OnMenuItemClickListener czG()
  {
    AppMethodBeat.i(265055);
    MenuItem.OnMenuItemClickListener local1 = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(266235);
        if (e.this.syA != null)
        {
          e.this.syA.dismiss();
          e.this.syA = null;
        }
        e.this.syA = new com.tencent.mm.ui.tools.n(e.this.fDf);
        e.this.syA.ODT = new q.f()
        {
          public final void onCreateMMMenu(o paramAnonymous2o)
          {
            AppMethodBeat.i(266233);
            ((com.tencent.mm.api.n)h.ae(com.tencent.mm.api.n.class)).gt(e.this.sxP);
            String str;
            if (!((com.tencent.mm.api.n)h.ae(com.tencent.mm.api.n.class)).gq(e.this.sxP))
            {
              str = ((com.tencent.mm.api.n)h.ae(com.tencent.mm.api.n.class)).gr(e.this.sxP);
              if (!Util.isNullOrNil(str)) {
                break label127;
              }
              paramAnonymous2o.aW(2, d.i.esY, d.h.ofm_add_icon);
            }
            for (;;)
            {
              paramAnonymous2o.aW(3, d.i.svj, d.h.actionbar_goto_disabled_biz_icon);
              paramAnonymous2o.aW(4, d.i.actionbar_title_setting, d.h.actionbar_setting_white_icon);
              AppMethodBeat.o(266233);
              return;
              label127:
              paramAnonymous2o.b(2, str, d.h.ofm_add_icon);
            }
          }
        };
        e.this.syA.ODU = new q.g()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(266355);
            switch (paramAnonymous2MenuItem.getItemId())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(266355);
              return;
              paramAnonymous2MenuItem = ((com.tencent.mm.api.n)h.ae(com.tencent.mm.api.n.class)).gs(e.this.sxP);
              if (!Util.isNullOrNil(paramAnonymous2MenuItem)) {}
              for (paramAnonymous2Int = 1; paramAnonymous2Int != 0; paramAnonymous2Int = 0)
              {
                localObject = new Intent();
                ((Intent)localObject).putExtra("rawUrl", paramAnonymous2MenuItem);
                Log.i("EnterpriseBizEntranceListHelper", "KRawUrl :%s", new Object[] { paramAnonymous2MenuItem });
                ((Intent)localObject).putExtra("useJs", true);
                ((Intent)localObject).addFlags(67108864);
                c.b(e.this.fDf, "webview", ".ui.tools.WebViewUI", (Intent)localObject, 0);
                AppMethodBeat.o(266355);
                return;
              }
              ((com.tencent.mm.api.n)h.ae(com.tencent.mm.api.n.class)).gt(e.this.sxP);
              ((com.tencent.mm.api.n)h.ae(com.tencent.mm.api.n.class)).b(e.this.fDf, e.this.sxP);
              AppMethodBeat.o(266355);
              return;
              Object localObject = new Intent(e.this.fDf, EnterpriseBizContactPlainListUI.class);
              ((Intent)localObject).putExtra("enterprise_biz_name", e.this.sxP);
              ((Intent)localObject).putExtra("enterprise_scene", 2);
              paramAnonymous2MenuItem = e.this.fDf;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
              com.tencent.mm.hellhoundlib.a.a.b(paramAnonymous2MenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListHelper$1$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymous2MenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
              com.tencent.mm.hellhoundlib.a.a.c(paramAnonymous2MenuItem, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListHelper$1$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(266355);
              return;
              paramAnonymous2MenuItem = new Intent();
              paramAnonymous2MenuItem.putExtra("Contact_User", e.this.sxP);
              com.tencent.mm.plugin.brandservice.b.mIG.c(paramAnonymous2MenuItem, e.this.fDf);
            }
          }
        };
        e.this.syA.cB();
        AppMethodBeat.o(266235);
        return false;
      }
    };
    AppMethodBeat.o(265055);
    return local1;
  }
  
  public final boolean e(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(265056);
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(265056);
      return false;
    }
    if ((paramInt2 == -1) && (paramIntent != null))
    {
      String str1 = paramIntent.getStringExtra("be_send_card_name");
      String str2 = paramIntent.getStringExtra("received_card_name");
      boolean bool = paramIntent.getBooleanExtra("Is_Chatroom", false);
      paramIntent = paramIntent.getStringExtra("custom_send_text");
      g.eRW().u(str1, str2, bool);
      g.eRW().iQ(paramIntent, str2);
      com.tencent.mm.ui.widget.snackbar.b.r(this.fDf, this.fDf.getString(d.i.has_send));
    }
    AppMethodBeat.o(265056);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.e
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.honey_pay.model;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.utils.g;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.cqw;
import com.tencent.mm.protocal.protobuf.dhy;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

final class c$2
  implements MenuItem.OnMenuItemClickListener
{
  c$2(MMActivity paramMMActivity, cqw paramcqw, String paramString, dhy paramdhy, int paramInt) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(64650);
    paramMenuItem = new com.tencent.mm.ui.widget.a.e(this.val$activity, 1, false);
    paramMenuItem.ISu = new n.c()
    {
      public final void onCreateMMMenu(l paramAnonymousl)
      {
        AppMethodBeat.i(64648);
        Iterator localIterator = c.2.this.tCN.FDQ.iterator();
        int i = 0;
        bui localbui;
        if (localIterator.hasNext())
        {
          localbui = (bui)localIterator.next();
          if (bs.isNullOrNil(localbui.nyq)) {
            break label110;
          }
          if (!bs.isNullOrNil(localbui.hiu))
          {
            paramAnonymousl.a(i, g.cd(localbui.hiu, true), localbui.nyq);
            label83:
            i += 1;
          }
        }
        label110:
        for (;;)
        {
          break;
          paramAnonymousl.c(i, localbui.nyq);
          break label83;
          AppMethodBeat.o(64648);
          return;
        }
      }
    };
    paramMenuItem.ISv = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(64649);
        paramAnonymousMenuItem = (bui)c.2.this.tCN.FDQ.get(paramAnonymousInt);
        if (!bs.isNullOrNil(paramAnonymousMenuItem.url))
        {
          if ((paramAnonymousMenuItem.url.equals("weixin://wcpay/honeypay/unbind")) && (!bs.isNullOrNil(c.2.this.tCO)) && (c.2.this.tCP != null))
          {
            ac.i("MicroMsg.HoneyPayUtil", "go to unbind");
            paramAnonymousMenuItem = new Intent(c.2.this.val$activity, HoneyPayCheckPwdUI.class);
            paramAnonymousMenuItem.putExtra("key_scene", 3);
            paramAnonymousMenuItem.putExtra("key_card_no", c.2.this.tCO);
            try
            {
              paramAnonymousMenuItem.putExtra("key_toke_mess", c.2.this.tCP.toByteArray());
              c.2.this.val$activity.startActivityForResult(paramAnonymousMenuItem, c.2.this.tCQ);
              AppMethodBeat.o(64649);
              return;
            }
            catch (IOException localIOException)
            {
              for (;;)
              {
                ac.printErrStackTrace("MicroMsg.HoneyPayUtil", localIOException, "", new Object[0]);
              }
            }
          }
          com.tencent.mm.wallet_core.ui.e.o(c.2.this.val$activity, paramAnonymousMenuItem.url, false);
        }
        AppMethodBeat.o(64649);
      }
    };
    paramMenuItem.cED();
    AppMethodBeat.o(64650);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.model.c.2
 * JD-Core Version:    0.7.0.1
 */
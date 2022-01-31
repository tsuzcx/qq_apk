package com.tencent.mm.plugin.honey_pay.model;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI;
import com.tencent.mm.protocal.c.awm;
import com.tencent.mm.protocal.c.bmi;
import com.tencent.mm.protocal.c.bya;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.wallet_core.ui.e;
import java.io.IOException;
import java.util.LinkedList;

final class c$2$2
  implements n.d
{
  c$2$2(c.2 param2) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    paramMenuItem = (awm)this.lka.ljW.tFJ.get(paramInt);
    if (!bk.bl(paramMenuItem.url))
    {
      if ((paramMenuItem.url.equals("weixin://wcpay/honeypay/unbind")) && (!bk.bl(this.lka.ljX)) && (this.lka.ljY != null))
      {
        y.i("MicroMsg.HoneyPayUtil", "go to unbind");
        paramMenuItem = new Intent(this.lka.gGJ, HoneyPayCheckPwdUI.class);
        paramMenuItem.putExtra("key_scene", 3);
        paramMenuItem.putExtra("key_card_no", this.lka.ljX);
      }
    }
    else {
      try
      {
        paramMenuItem.putExtra("key_toke_mess", this.lka.ljY.toByteArray());
        this.lka.gGJ.startActivityForResult(paramMenuItem, this.lka.ljZ);
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.HoneyPayUtil", localIOException, "", new Object[0]);
        }
      }
    }
    e.l(this.lka.gGJ, paramMenuItem.url, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.model.c.2.2
 * JD-Core Version:    0.7.0.1
 */
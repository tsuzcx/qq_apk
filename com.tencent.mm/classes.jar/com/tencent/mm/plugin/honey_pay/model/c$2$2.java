package com.tencent.mm.plugin.honey_pay.model;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI;
import com.tencent.mm.protocal.protobuf.bdb;
import com.tencent.mm.protocal.protobuf.bvv;
import com.tencent.mm.protocal.protobuf.ckm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
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
    AppMethodBeat.i(41754);
    paramMenuItem = (bdb)this.nHw.nHs.xJr.get(paramInt);
    if (!bo.isNullOrNil(paramMenuItem.url))
    {
      if ((paramMenuItem.url.equals("weixin://wcpay/honeypay/unbind")) && (!bo.isNullOrNil(this.nHw.nHt)) && (this.nHw.nHu != null))
      {
        ab.i("MicroMsg.HoneyPayUtil", "go to unbind");
        paramMenuItem = new Intent(this.nHw.val$activity, HoneyPayCheckPwdUI.class);
        paramMenuItem.putExtra("key_scene", 3);
        paramMenuItem.putExtra("key_card_no", this.nHw.nHt);
        try
        {
          paramMenuItem.putExtra("key_toke_mess", this.nHw.nHu.toByteArray());
          this.nHw.val$activity.startActivityForResult(paramMenuItem, this.nHw.nHv);
          AppMethodBeat.o(41754);
          return;
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            ab.printErrStackTrace("MicroMsg.HoneyPayUtil", localIOException, "", new Object[0]);
          }
        }
      }
      e.m(this.nHw.val$activity, paramMenuItem.url, false);
    }
    AppMethodBeat.o(41754);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.model.c.2.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.mall.ui;

import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.cic;
import com.tencent.mm.protocal.c.cid;
import com.tencent.mm.ui.base.h.c;
import java.util.LinkedList;

final class MallIndexOSUI$4$1
  implements h.c
{
  MallIndexOSUI$4$1(MallIndexOSUI.4 param4, cic paramcic, boolean paramBoolean) {}
  
  public final void gl(int paramInt)
  {
    if (paramInt < this.maa.taW.size())
    {
      localIntent = new Intent();
      localIntent.putExtra("rawUrl", aa.a(((cid)this.maa.taW.get(paramInt)).tWG));
      d.b(this.mad.lZX, "webview", ".ui.tools.WebViewUI", localIntent);
    }
    while (!this.mab)
    {
      Intent localIntent;
      return;
    }
    d.c(this.mad.lZX, "wallet_core", ".ui.WalletSwitchWalletCurrencyUI", 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexOSUI.4.1
 * JD-Core Version:    0.7.0.1
 */
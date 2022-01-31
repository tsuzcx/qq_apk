package com.tencent.mm.app.plugin;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.R.l;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.nl;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.ui.base.h;

@URISpanHandlerSet.a
class URISpanHandlerSet$TransferUriSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$TransferUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final boolean a(m paramm, g paramg)
  {
    if (paramm != null)
    {
      if (paramm.type == 42)
      {
        d.x(URISpanHandlerSet.a(this.byk), "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
        return true;
      }
      if (paramm.type == 41)
      {
        d.x(URISpanHandlerSet.a(this.byk), "wallet", ".balance.ui.WalletBalanceManagerUI");
        return true;
      }
      if (paramm.type == 39)
      {
        if ((paramm.data != null) && ((paramm.data instanceof Bundle)))
        {
          paramm = (Bundle)paramm.data;
          h.a(URISpanHandlerSet.a(this.byk), URISpanHandlerSet.a(this.byk).getString(R.l.span_remittance_confirm_resend_msg), URISpanHandlerSet.a(this.byk).getString(R.l.app_remind), URISpanHandlerSet.a(this.byk).getString(R.l.span_remittance_resend), URISpanHandlerSet.a(this.byk).getString(R.l.app_cancel), new URISpanHandlerSet.TransferUriSpanHandler.1(this, paramm), new URISpanHandlerSet.TransferUriSpanHandler.2(this));
        }
        return true;
      }
      if (paramm.type == 40)
      {
        if ((paramm.data != null) && ((paramm.data instanceof Bundle)))
        {
          paramm = (Bundle)paramm.data;
          paramg = new nl();
          paramg.bXc.bMY = paramm.getString("transaction_id");
          paramg.bXc.bQR = paramm.getString("transfer_id");
          paramg.bXc.bXd = paramm.getInt("total_fee");
          paramg.bXc.bXe = paramm.getString("sender_name");
          a.udP.m(paramg);
        }
        return true;
      }
    }
    return false;
  }
  
  final boolean a(String paramString, boolean paramBoolean, s params, Bundle paramBundle)
  {
    return false;
  }
  
  final m cA(String paramString)
  {
    if (paramString.trim().toLowerCase().startsWith("weixin://wcpay/transfer/retrysendmsg")) {
      return new m(paramString, 39, null);
    }
    if (paramString.trim().toLowerCase().startsWith("weixin://wcpay/transfer/rebacksendmsg")) {
      return new m(paramString, 40, null);
    }
    if (paramString.trim().toLowerCase().startsWith("weixin://wcpay/transfer/watchbalance")) {
      return new m(paramString, 41, null);
    }
    if (paramString.trim().toLowerCase().startsWith("weixin://wcpay/transfer/watchlqt")) {
      return new m(paramString, 42, null);
    }
    return null;
  }
  
  final int[] tA()
  {
    return new int[] { 39, 40, 41, 42 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.TransferUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */
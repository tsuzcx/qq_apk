package com.tencent.mm.app.plugin;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.ok;
import com.tencent.mm.plugin.wxpaysdk.api.ResendMsgInfo;
import com.tencent.mm.plugin.wxpaysdk.api.b;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.v;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

@URISpanHandlerSet.a
class URISpanHandlerSet$TransferUriSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$TransferUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final int[] Cf()
  {
    return new int[] { 39, 40, 41, 42, 49 };
  }
  
  final boolean a(m paramm, com.tencent.mm.pluginsdk.ui.d.g paramg)
  {
    AppMethodBeat.i(15716);
    if (paramm != null)
    {
      if (paramm.type == 42)
      {
        d.H(URISpanHandlerSet.a(this.cam), "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
        AppMethodBeat.o(15716);
        return true;
      }
      if (paramm.type == 41)
      {
        d.H(URISpanHandlerSet.a(this.cam), "wallet", ".balance.ui.WalletBalanceManagerUI");
        AppMethodBeat.o(15716);
        return true;
      }
      if (paramm.type == 39)
      {
        if ((paramm.data != null) && ((paramm.data instanceof Bundle)))
        {
          paramm = (Bundle)paramm.data;
          paramg = (ResendMsgInfo)paramm.getParcelable("resend_msg_info");
          ((b)com.tencent.mm.kernel.g.E(b.class)).a(URISpanHandlerSet.a(this.cam), paramg, new URISpanHandlerSet.TransferUriSpanHandler.1(this, paramm));
        }
        AppMethodBeat.o(15716);
        return true;
      }
      if (paramm.type == 40)
      {
        if ((paramm.data != null) && ((paramm.data instanceof Bundle)))
        {
          paramm = (Bundle)paramm.data;
          paramg = new ok();
          paramg.cEV.cnJ = paramm.getString("transaction_id");
          paramg.cEV.cyr = paramm.getString("transfer_id");
          paramg.cEV.cEW = paramm.getInt("total_fee");
          paramg.cEV.cEX = paramm.getString("sender_name");
          a.ymk.l(paramg);
        }
        AppMethodBeat.o(15716);
        return true;
      }
      if (paramm.type == 49)
      {
        paramg = Uri.parse(paramm.url);
        String str1 = paramg.getQueryParameter("transfer_id");
        String str2 = paramg.getQueryParameter("trans_id");
        paramg = "";
        if ((paramm.data != null) && ((paramm.data instanceof Bundle))) {}
        for (paramm = ((Bundle)paramm.data).getString("sender_name");; paramm = paramg)
        {
          paramg = new Intent();
          paramg.putExtra("transfer_id", str1);
          paramg.putExtra("transaction_id", str2);
          paramg.putExtra("sender_name", paramm);
          d.b(ah.getContext(), "remittance", ".ui.RemittanceDetailUI", paramg);
          AppMethodBeat.o(15716);
          return true;
          ab.i("MicroMsg.URISpanHandlerSet", "hrefInfo.getType() == TYPE_TRANSFER_QUERY_MSG senderName == null");
        }
      }
    }
    AppMethodBeat.o(15716);
    return false;
  }
  
  final boolean a(String paramString, boolean paramBoolean, v paramv, Bundle paramBundle)
  {
    return false;
  }
  
  final m dN(String paramString)
  {
    AppMethodBeat.i(15715);
    if (paramString.trim().toLowerCase().startsWith("weixin://wcpay/transfer/retrysendmsg"))
    {
      paramString = new m(paramString, 39, null);
      AppMethodBeat.o(15715);
      return paramString;
    }
    if (paramString.trim().toLowerCase().startsWith("weixin://wcpay/transfer/rebacksendmsg"))
    {
      paramString = new m(paramString, 40, null);
      AppMethodBeat.o(15715);
      return paramString;
    }
    if (paramString.trim().toLowerCase().startsWith("weixin://wcpay/transfer/watchbalance"))
    {
      paramString = new m(paramString, 41, null);
      AppMethodBeat.o(15715);
      return paramString;
    }
    if (paramString.trim().toLowerCase().startsWith("weixin://wcpay/transfer/watchlqt"))
    {
      paramString = new m(paramString, 42, null);
      AppMethodBeat.o(15715);
      return paramString;
    }
    if (paramString.trim().toLowerCase().startsWith("wechat://wcpay/transfer/transferquery"))
    {
      paramString = new m(paramString, 49, null);
      AppMethodBeat.o(15715);
      return paramString;
    }
    AppMethodBeat.o(15715);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.TransferUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */
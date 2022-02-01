package com.tencent.mm.app.plugin;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.l;
import com.tencent.mm.f.a.so;
import com.tencent.mm.f.a.uu;
import com.tencent.mm.f.c.et;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.remittance.b.d;
import com.tencent.mm.plugin.wxpaysdk.api.ResendMsgInfo;
import com.tencent.mm.plugin.wxpaysdk.api.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.f.a;

@URISpanHandlerSet.a
class URISpanHandlerSet$TransferUriSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$TransferUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.i parami)
  {
    AppMethodBeat.i(291222);
    if (paramu != null)
    {
      if (paramu.type == 42)
      {
        com.tencent.mm.by.c.ad(URISpanHandlerSet.a(this.fgB), "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
        AppMethodBeat.o(291222);
        return true;
      }
      if (paramu.type == 41)
      {
        com.tencent.mm.by.c.ad(URISpanHandlerSet.a(this.fgB), "wallet", ".balance.ui.WalletBalanceManagerUI");
        AppMethodBeat.o(291222);
        return true;
      }
      if (paramu.type == 39)
      {
        if ((paramu.bnW != null) && ((paramu.bnW instanceof Bundle)))
        {
          paramView = (Bundle)paramu.bnW;
          paramu = (ResendMsgInfo)paramView.getParcelable("resend_msg_info");
          ((b)com.tencent.mm.kernel.h.ae(b.class)).a(URISpanHandlerSet.a(this.fgB), paramu, new URISpanHandlerSet.TransferUriSpanHandler.1(this, paramView));
        }
        AppMethodBeat.o(291222);
        return true;
      }
      if (paramu.type == 40)
      {
        if ((paramu.bnW != null) && ((paramu.bnW instanceof Bundle)))
        {
          paramView = (Bundle)paramu.bnW;
          paramu = new so();
          paramu.fRW.fww = paramView.getString("transaction_id");
          paramu.fRW.fJG = paramView.getString("transfer_id");
          paramu.fRW.fRX = paramView.getInt("total_fee");
          paramu.fRW.fRY = paramView.getString("sender_name");
          EventCenter.instance.publish(paramu);
        }
        AppMethodBeat.o(291222);
        return true;
      }
      Object localObject;
      if (paramu.type == 49)
      {
        paramView = Uri.parse(paramu.url);
        parami = paramView.getQueryParameter("transfer_id");
        localObject = paramView.getQueryParameter("trans_id");
        paramView = "";
        if ((paramu.bnW != null) && ((paramu.bnW instanceof Bundle))) {
          paramView = ((Bundle)paramu.bnW).getString("sender_name");
        }
        for (;;)
        {
          paramu = new Intent();
          paramu.putExtra("transfer_id", parami);
          paramu.putExtra("transaction_id", (String)localObject);
          paramu.putExtra("sender_name", paramView);
          com.tencent.mm.by.c.b(MMApplicationContext.getContext(), "remittance", ".ui.RemittanceDetailUI", paramu);
          AppMethodBeat.o(291222);
          return true;
          Log.i("MicroMsg.URISpanHandlerSet", "hrefInfo.getType() == TYPE_TRANSFER_QUERY_MSG senderName == null");
        }
      }
      if ((paramu.type == 56) || (paramu.type == 63))
      {
        localObject = Uri.parse(paramu.url);
        parami = ((Uri)localObject).getQueryParameter("transferid");
        paramView = ((Uri)localObject).getQueryParameter("fromusername");
        localObject = ((Uri)localObject).getQueryParameter("transfer_msg_type");
        if (paramu.type == 56)
        {
          Log.i("MicroMsg.URISpanHandlerSet", "click MSpanConstants.Type.TYPE_TRANSFER_REMINDE_RECEIVE_MSG, transferId: %s，msgType:%s", new Object[] { parami, localObject });
          com.tencent.mm.plugin.report.service.h.IzE.a(20467, new Object[] { "transfer_to_change", "click message", "", "", "", "", Integer.valueOf(3), parami, localObject });
        }
        if ((!Util.isNullOrNil(parami)) && (!Util.isNullOrNil(paramView)))
        {
          Log.i("MicroMsg.URISpanHandlerSet", "handle MSpanConstants.Type.TYPE_TRANSFER_REMINDE_RECEIVE_MSG");
          com.tencent.mm.plugin.remittance.a.c.fzJ();
          paramu = com.tencent.mm.plugin.remittance.a.c.fzL().aWA(parami);
          if ((paramu == null) || (paramu.field_locaMsgId <= 0L)) {
            break label736;
          }
          Log.i("MicroMsg.URISpanHandlerSet", "handle MSpanConstants.Type.TYPE_TRANSFER_REMINDE_RECEIVE_MSG, localMsgId: %s", new Object[] { Long.valueOf(paramu.field_locaMsgId) });
          if (((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(paramu.field_locaMsgId).field_msgId > 0L) {
            break label698;
          }
          Log.i("MicroMsg.URISpanHandlerSet", "cannot find msg in msg storage!");
          new f.a(MMApplicationContext.getContext()).bBl(MMApplicationContext.getContext().getString(R.l.remittance_find_from_jsapi_failed_delete)).ayq(MMApplicationContext.getContext().getResources().getColor(R.e.link_color)).ayp(R.l.i_know_it).b(new URISpanHandlerSet.TransferUriSpanHandler.2(this)).show();
        }
        for (;;)
        {
          AppMethodBeat.o(291222);
          return true;
          label698:
          parami = new uu();
          parami.fUb.msgId = paramu.field_locaMsgId;
          parami.fUb.fcC = paramView;
          EventCenter.instance.publish(parami);
          continue;
          label736:
          Log.i("MicroMsg.URISpanHandlerSet", "handle MSpanConstants.Type.TYPE_TRANSFER_REMINDE_RECEIVE_MSG, cannot find local msg");
          new f.a(MMApplicationContext.getContext()).bBl(MMApplicationContext.getContext().getString(R.l.remittance_find_from_jsapi_failed_delete)).ayq(MMApplicationContext.getContext().getResources().getColor(R.e.link_color)).ayp(R.l.i_know_it).b(new URISpanHandlerSet.TransferUriSpanHandler.3(this)).show();
        }
      }
    }
    AppMethodBeat.o(291222);
    return false;
  }
  
  final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
  {
    return false;
  }
  
  final int[] abR()
  {
    return new int[] { 39, 40, 41, 42, 49, 56, 63 };
  }
  
  final com.tencent.mm.pluginsdk.ui.applet.u hi(String paramString)
  {
    AppMethodBeat.i(19761);
    if (paramString.trim().toLowerCase().startsWith("weixin://wcpay/transfer/retrysendmsg"))
    {
      paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 39, null);
      AppMethodBeat.o(19761);
      return paramString;
    }
    if (paramString.trim().toLowerCase().startsWith("weixin://wcpay/transfer/rebacksendmsg"))
    {
      paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 40, null);
      AppMethodBeat.o(19761);
      return paramString;
    }
    if (paramString.trim().toLowerCase().startsWith("weixin://wcpay/transfer/watchbalance"))
    {
      paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 41, null);
      AppMethodBeat.o(19761);
      return paramString;
    }
    if (paramString.trim().toLowerCase().startsWith("weixin://wcpay/transfer/watchlqt"))
    {
      paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 42, null);
      AppMethodBeat.o(19761);
      return paramString;
    }
    if (paramString.trim().toLowerCase().startsWith("wechat://wcpay/transfer/transferquery"))
    {
      paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 49, null);
      AppMethodBeat.o(19761);
      return paramString;
    }
    if (paramString.trim().toLowerCase().startsWith("weixin://wxpay/transfer/remindrcvmsg"))
    {
      paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 56, null);
      AppMethodBeat.o(19761);
      return paramString;
    }
    if (paramString.trim().toLowerCase().startsWith("weixin://wxpay/transfer/transfer_overtime"))
    {
      paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 63, null);
      AppMethodBeat.o(19761);
      return paramString;
    }
    AppMethodBeat.o(19761);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.TransferUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.app.plugin;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.rp;
import com.tencent.mm.g.a.tr;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.remittance.b.d;
import com.tencent.mm.plugin.report.service.h;
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
  
  final int[] Xp()
  {
    return new int[] { 39, 40, 41, 42, 49, 56 };
  }
  
  final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.i parami)
  {
    AppMethodBeat.i(231456);
    if (paramu != null)
    {
      if (paramu.type == 42)
      {
        com.tencent.mm.br.c.V(URISpanHandlerSet.a(this.dnW), "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
        AppMethodBeat.o(231456);
        return true;
      }
      if (paramu.type == 41)
      {
        com.tencent.mm.br.c.V(URISpanHandlerSet.a(this.dnW), "wallet", ".balance.ui.WalletBalanceManagerUI");
        AppMethodBeat.o(231456);
        return true;
      }
      if (paramu.type == 39)
      {
        if ((paramu.data != null) && ((paramu.data instanceof Bundle)))
        {
          paramView = (Bundle)paramu.data;
          paramu = (ResendMsgInfo)paramView.getParcelable("resend_msg_info");
          ((b)g.af(b.class)).a(URISpanHandlerSet.a(this.dnW), paramu, new URISpanHandlerSet.TransferUriSpanHandler.1(this, paramView));
        }
        AppMethodBeat.o(231456);
        return true;
      }
      if (paramu.type == 40)
      {
        if ((paramu.data != null) && ((paramu.data instanceof Bundle)))
        {
          paramView = (Bundle)paramu.data;
          paramu = new rp();
          paramu.dYf.dDM = paramView.getString("transaction_id");
          paramu.dYf.dQp = paramView.getString("transfer_id");
          paramu.dYf.dYg = paramView.getInt("total_fee");
          paramu.dYf.dYh = paramView.getString("sender_name");
          EventCenter.instance.publish(paramu);
        }
        AppMethodBeat.o(231456);
        return true;
      }
      if (paramu.type == 49)
      {
        paramView = Uri.parse(paramu.url);
        parami = paramView.getQueryParameter("transfer_id");
        String str = paramView.getQueryParameter("trans_id");
        paramView = "";
        if ((paramu.data != null) && ((paramu.data instanceof Bundle))) {
          paramView = ((Bundle)paramu.data).getString("sender_name");
        }
        for (;;)
        {
          paramu = new Intent();
          paramu.putExtra("transfer_id", parami);
          paramu.putExtra("transaction_id", str);
          paramu.putExtra("sender_name", paramView);
          com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "remittance", ".ui.RemittanceDetailUI", paramu);
          AppMethodBeat.o(231456);
          return true;
          Log.i("MicroMsg.URISpanHandlerSet", "hrefInfo.getType() == TYPE_TRANSFER_QUERY_MSG senderName == null");
        }
      }
      if (paramu.type == 56)
      {
        parami = Uri.parse(paramu.url);
        paramu = parami.getQueryParameter("transferid");
        paramView = parami.getQueryParameter("fromusername");
        parami = parami.getQueryParameter("transfer_msg_type");
        Log.i("MicroMsg.URISpanHandlerSet", "click MSpanConstants.Type.TYPE_TRANSFER_REMINDE_RECEIVE_MSG, transferId: %s，msgType:%s", new Object[] { paramu, parami });
        h.CyF.a(20467, new Object[] { "transfer_to_change", "click message", "", "", "", "", Integer.valueOf(3), paramu, parami });
        if ((!Util.isNullOrNil(paramu)) && (!Util.isNullOrNil(paramView)))
        {
          Log.i("MicroMsg.URISpanHandlerSet", "handle MSpanConstants.Type.TYPE_TRANSFER_REMINDE_RECEIVE_MSG");
          com.tencent.mm.plugin.remittance.a.c.eMU();
          paramu = com.tencent.mm.plugin.remittance.a.c.eMW().aLW(paramu);
          if ((paramu == null) || (paramu.field_locaMsgId <= 0L)) {
            break label711;
          }
          Log.i("MicroMsg.URISpanHandlerSet", "handle MSpanConstants.Type.TYPE_TRANSFER_REMINDE_RECEIVE_MSG, localMsgId: %s", new Object[] { Long.valueOf(paramu.field_locaMsgId) });
          if (((l)g.af(l.class)).eiy().Hb(paramu.field_locaMsgId).field_msgId > 0L) {
            break label673;
          }
          Log.i("MicroMsg.URISpanHandlerSet", "cannot find msg in msg storage!");
          new f.a(MMApplicationContext.getContext()).bow(MMApplicationContext.getContext().getString(2131764555)).apb(MMApplicationContext.getContext().getResources().getColor(2131100685)).apa(2131761757).b(new URISpanHandlerSet.TransferUriSpanHandler.2(this)).show();
        }
        for (;;)
        {
          AppMethodBeat.o(231456);
          return true;
          label673:
          parami = new tr();
          parami.eae.msgId = paramu.field_locaMsgId;
          parami.eae.dkU = paramView;
          EventCenter.instance.publish(parami);
          continue;
          label711:
          Log.i("MicroMsg.URISpanHandlerSet", "handle MSpanConstants.Type.TYPE_TRANSFER_REMINDE_RECEIVE_MSG, cannot find local msg");
          new f.a(MMApplicationContext.getContext()).bow(MMApplicationContext.getContext().getString(2131764555)).apb(MMApplicationContext.getContext().getResources().getColor(2131100685)).apa(2131761757).b(new URISpanHandlerSet.TransferUriSpanHandler.3(this)).show();
        }
      }
    }
    AppMethodBeat.o(231456);
    return false;
  }
  
  final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
  {
    return false;
  }
  
  final com.tencent.mm.pluginsdk.ui.applet.u gx(String paramString)
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
    AppMethodBeat.o(19761);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.TransferUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */
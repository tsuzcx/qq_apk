package com.tencent.mm.app.plugin;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.sdk.platformtools.y;

@URISpanHandlerSet.a
class URISpanHandlerSet$HoneyPayLinkSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$HoneyPayLinkSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final boolean a(m paramm, g paramg)
  {
    if (paramm.type == 46)
    {
      y.i("MicroMsg.URISpanHandlerSet", "go to honey pay proxy");
      if ((paramm.data != null) && ((paramm.data instanceof Bundle)))
      {
        paramg = Uri.parse(paramm.url);
        paramm = paramg.getQueryParameter("cardNo");
        bool = paramg.getQueryParameter("isPayer").equals("1");
        paramg = new Intent();
        paramg.putExtra("key_card_no", paramm);
        paramg.putExtra("key_is_payer", bool);
        d.b(URISpanHandlerSet.a(this.byk), "honey_pay", ".ui.HoneyPayProxyUI", paramg);
      }
    }
    while (paramm.type != 47)
    {
      boolean bool;
      return false;
    }
    y.i("MicroMsg.URISpanHandlerSet", "go to bank card list");
    paramm = new Intent();
    paramm.putExtra("intent_finish_self", true);
    d.b(URISpanHandlerSet.a(this.byk), "wallet", ".bind.ui.WalletBankcardManageUI", paramm);
    h.nFQ.f(15191, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
    return false;
  }
  
  final boolean a(String paramString, boolean paramBoolean, s params, Bundle paramBundle)
  {
    return false;
  }
  
  final m cA(String paramString)
  {
    if (paramString.trim().startsWith("native://wcpay/honeypay")) {
      return new m(paramString, 46, null);
    }
    if (paramString.trim().startsWith("weixin://wcpay/bankCardList")) {
      return new m(paramString, 47, null);
    }
    return null;
  }
  
  final int[] tA()
  {
    return new int[] { 46, 47 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.HoneyPayLinkSpanHandler
 * JD-Core Version:    0.7.0.1
 */
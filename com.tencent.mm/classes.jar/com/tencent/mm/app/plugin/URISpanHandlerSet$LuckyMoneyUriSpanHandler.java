package com.tencent.mm.app.plugin;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;

@URISpanHandlerSet.a
class URISpanHandlerSet$LuckyMoneyUriSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$LuckyMoneyUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final boolean a(m paramm, g paramg)
  {
    if (paramm.type == 33)
    {
      paramg = new Intent();
      paramg.putExtra("key_native_url", paramm.url);
      d.b(URISpanHandlerSet.a(this.byk), "luckymoney", ".ui.LuckyMoneyDetailUI", paramg);
      h.nFQ.f(12097, new Object[] { Integer.valueOf(11), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
      h.nFQ.f(11850, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
      return true;
    }
    return false;
  }
  
  final boolean a(String paramString, boolean paramBoolean, s params, Bundle paramBundle)
  {
    return false;
  }
  
  final m cA(String paramString)
  {
    if (paramString.trim().toLowerCase().startsWith("weixin://weixinhongbao/")) {
      return new m(paramString, 33, null);
    }
    return null;
  }
  
  final int[] tA()
  {
    return new int[] { 33 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.LuckyMoneyUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */
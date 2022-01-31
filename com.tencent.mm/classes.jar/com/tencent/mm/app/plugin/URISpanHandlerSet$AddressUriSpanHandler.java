package com.tencent.mm.app.plugin;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

@URISpanHandlerSet.a
class URISpanHandlerSet$AddressUriSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$AddressUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final boolean a(m paramm, g paramg)
  {
    if (paramm.type == 44)
    {
      paramm = Uri.parse("geo:0,0?q=" + Uri.encode(paramm.url));
      paramg = new Intent("android.intent.action.VIEW");
      paramg.setData(paramm);
      paramg.addFlags(268435456);
      if (paramg.resolveActivity(ae.getContext().getPackageManager()) != null)
      {
        ae.getContext().startActivity(paramg);
        h.nFQ.f(12809, new Object[] { Integer.valueOf(9), "" });
      }
      for (;;)
      {
        h.nFQ.f(12809, new Object[] { Integer.valueOf(8), "" });
        return true;
        y.w("MicroMsg.URISpanHandlerSet", "Cannot find map app");
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
    return null;
  }
  
  final int[] tA()
  {
    return new int[] { 44 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.AddressUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.app.plugin;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.wallet.a;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

@URISpanHandlerSet.a
class URISpanHandlerSet$PayTransferUriSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$PayTransferUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final boolean a(m paramm, g paramg)
  {
    return false;
  }
  
  final boolean a(String paramString, boolean paramBoolean, s params, Bundle paramBundle)
  {
    if (paramString.startsWith("wxpay://"))
    {
      if (params == null) {
        break label215;
      }
      paramBundle = params.cko().toString();
      params = params.ckp();
      if (!(params instanceof a)) {
        break label210;
      }
      params = (a)params;
    }
    for (;;)
    {
      if (bk.bl(paramBundle))
      {
        y.e("MicroMsg.URISpanHandlerSet", "SERVICE_JUMP_TO_PAY fail, null username");
        return false;
      }
      String str = paramString.substring(8);
      paramString = str;
      if (str.indexOf("&") > 0) {
        paramString = str.split("&")[0];
      }
      int i = paramString.indexOf("=");
      if (i >= 0) {}
      for (paramString = paramString.substring(i + 1);; paramString = "")
      {
        if (bk.getInt(paramString, 0) == 1)
        {
          if ((q.Gx()) || (q.Gy())) {
            h.a(URISpanHandlerSet.a(this.byk), 5, paramBundle, 11, params);
          }
          for (;;)
          {
            return true;
            h.a(URISpanHandlerSet.a(this.byk), 2, paramBundle, 11, params);
          }
        }
        Toast.makeText(URISpanHandlerSet.a(this.byk), URISpanHandlerSet.a(this.byk).getString(R.l.service_app_service_not_support), 0).show();
        return false;
        return false;
      }
      label210:
      params = null;
      continue;
      label215:
      params = null;
      paramBundle = null;
    }
  }
  
  final m cA(String paramString)
  {
    return null;
  }
  
  final int[] tA()
  {
    return new int[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.PayTransferUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.app.plugin;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.mm.h.a.hc;
import com.tencent.mm.h.a.hc.a;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.sdk.b.a;

@URISpanHandlerSet.a
class URISpanHandlerSet$PayUriSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$PayUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final boolean a(m paramm, g paramg)
  {
    if (paramm.type == 28)
    {
      if (paramg != null) {
        paramg.a(paramm);
      }
      hc localhc = new hc();
      localhc.bOW.actionCode = 11;
      localhc.bOW.result = paramm.url;
      localhc.bOW.context = URISpanHandlerSet.a(this.byk);
      localhc.bOW.bOY = new Bundle();
      localhc.bOW.bOY.putInt("pay_channel", 6);
      a.udP.a(localhc, Looper.myLooper());
      if (paramg != null) {
        paramg.b(paramm);
      }
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
    return null;
  }
  
  final int[] tA()
  {
    return new int[] { 28 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.PayUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */
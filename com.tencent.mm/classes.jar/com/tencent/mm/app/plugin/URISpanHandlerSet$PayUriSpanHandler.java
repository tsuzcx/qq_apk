package com.tencent.mm.app.plugin;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hf;
import com.tencent.mm.g.a.hf.a;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.pluginsdk.v;
import com.tencent.mm.sdk.b.a;

@URISpanHandlerSet.a
class URISpanHandlerSet$PayUriSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$PayUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final int[] Cf()
  {
    return new int[] { 28 };
  }
  
  final boolean a(m paramm, g paramg)
  {
    AppMethodBeat.i(15682);
    if (paramm.type == 28)
    {
      if (paramg != null) {
        paramg.a(paramm);
      }
      hf localhf = new hf();
      localhf.cwn.actionCode = 11;
      localhf.cwn.result = paramm.url;
      localhf.cwn.context = URISpanHandlerSet.a(this.cam);
      localhf.cwn.cwp = new Bundle();
      localhf.cwn.cwp.putInt("pay_channel", 6);
      a.ymk.a(localhf, Looper.myLooper());
      if (paramg != null) {
        paramg.b(paramm);
      }
      AppMethodBeat.o(15682);
      return true;
    }
    AppMethodBeat.o(15682);
    return false;
  }
  
  final boolean a(String paramString, boolean paramBoolean, v paramv, Bundle paramBundle)
  {
    return false;
  }
  
  final m dN(String paramString)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.PayUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */
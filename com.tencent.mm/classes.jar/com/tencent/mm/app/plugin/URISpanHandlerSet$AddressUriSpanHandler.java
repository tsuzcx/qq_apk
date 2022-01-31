package com.tencent.mm.app.plugin;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.pluginsdk.v;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

@URISpanHandlerSet.a
class URISpanHandlerSet$AddressUriSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$AddressUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final int[] Cf()
  {
    return new int[] { 44 };
  }
  
  final boolean a(m paramm, g paramg)
  {
    AppMethodBeat.i(15632);
    if (paramm.type == 44)
    {
      paramm = Uri.parse("geo:0,0?q=" + Uri.encode(paramm.url));
      paramg = new Intent("android.intent.action.VIEW");
      paramg.setData(paramm);
      paramg.addFlags(268435456);
      if (paramg.resolveActivity(ah.getContext().getPackageManager()) != null)
      {
        ah.getContext().startActivity(paramg);
        h.qsU.e(12809, new Object[] { Integer.valueOf(9), "" });
      }
      for (;;)
      {
        h.qsU.e(12809, new Object[] { Integer.valueOf(8), "" });
        AppMethodBeat.o(15632);
        return true;
        ab.w("MicroMsg.URISpanHandlerSet", "Cannot find map app");
      }
    }
    AppMethodBeat.o(15632);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.AddressUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */
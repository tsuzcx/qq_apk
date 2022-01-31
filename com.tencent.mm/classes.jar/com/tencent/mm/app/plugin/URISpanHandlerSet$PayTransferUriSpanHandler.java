package com.tencent.mm.app.plugin;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.wallet.a;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.pluginsdk.v;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

@URISpanHandlerSet.a
class URISpanHandlerSet$PayTransferUriSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$PayTransferUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final int[] Cf()
  {
    return new int[0];
  }
  
  final boolean a(m paramm, g paramg)
  {
    return false;
  }
  
  final boolean a(String paramString, boolean paramBoolean, v paramv, Bundle paramBundle)
  {
    AppMethodBeat.i(15681);
    if (paramString.startsWith("wxpay://"))
    {
      if (paramv == null) {
        break label244;
      }
      paramBundle = paramv.dkU().toString();
      paramv = paramv.dkV();
      if (!(paramv instanceof a)) {
        break label239;
      }
      paramv = (a)paramv;
    }
    for (;;)
    {
      if (bo.isNullOrNil(paramBundle))
      {
        ab.e("MicroMsg.URISpanHandlerSet", "SERVICE_JUMP_TO_PAY fail, null username");
        AppMethodBeat.o(15681);
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
        if (bo.getInt(paramString, 0) == 1)
        {
          if ((r.ZC()) || (r.ZD())) {
            h.a(URISpanHandlerSet.a(this.cam), 5, paramBundle, 11, paramv);
          }
          for (;;)
          {
            AppMethodBeat.o(15681);
            return true;
            h.a(URISpanHandlerSet.a(this.cam), 2, paramBundle, 11, paramv);
          }
        }
        Toast.makeText(URISpanHandlerSet.a(this.cam), URISpanHandlerSet.a(this.cam).getString(2131303134), 0).show();
        AppMethodBeat.o(15681);
        return false;
        AppMethodBeat.o(15681);
        return false;
      }
      label239:
      paramv = null;
      continue;
      label244:
      paramv = null;
      paramBundle = null;
    }
  }
  
  final m dN(String paramString)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.PayTransferUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.app.plugin;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.pluginsdk.v;
import com.tencent.mm.sdk.platformtools.ab;

@URISpanHandlerSet.a
class URISpanHandlerSet$ScanQrCodeUriSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$ScanQrCodeUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
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
    int j = 0;
    AppMethodBeat.i(15689);
    if (paramString.equals("weixin://scanqrcode/"))
    {
      if (!paramBoolean)
      {
        ab.e("MicroMsg.URISpanHandlerSet", "jumpToActivity, scan qrcode permission fail");
        AppMethodBeat.o(15689);
        return true;
      }
      paramString = new Intent();
      paramString.putExtra("BaseScanUI_select_scan_mode", 1);
      int i = j;
      if (paramBundle != null)
      {
        i = j;
        if (paramBundle.getInt("fromScene") == 100) {
          i = 1;
        }
      }
      if (i == 0) {
        paramString.addFlags(67108864);
      }
      if ((URISpanHandlerSet.a(this.cam) instanceof Service)) {
        paramString.addFlags(268435456);
      }
      if (i != 0)
      {
        d.b(URISpanHandlerSet.a(this.cam), "scanner", ".ui.SingleTopScanUI", paramString);
        AppMethodBeat.o(15689);
        return true;
      }
      d.b(URISpanHandlerSet.a(this.cam), "scanner", ".ui.BaseScanUI", paramString);
      AppMethodBeat.o(15689);
      return true;
    }
    AppMethodBeat.o(15689);
    return false;
  }
  
  final m dN(String paramString)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.ScanQrCodeUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */
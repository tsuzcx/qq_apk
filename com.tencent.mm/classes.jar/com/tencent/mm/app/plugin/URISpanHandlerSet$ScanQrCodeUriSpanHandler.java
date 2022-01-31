package com.tencent.mm.app.plugin;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.br.d;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.sdk.platformtools.y;

@URISpanHandlerSet.a
class URISpanHandlerSet$ScanQrCodeUriSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$ScanQrCodeUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final boolean a(m paramm, g paramg)
  {
    return false;
  }
  
  final boolean a(String paramString, boolean paramBoolean, s params, Bundle paramBundle)
  {
    int j = 0;
    if (paramString.equals("weixin://scanqrcode/"))
    {
      if (!paramBoolean)
      {
        y.e("MicroMsg.URISpanHandlerSet", "jumpToActivity, scan qrcode permission fail");
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
      if ((URISpanHandlerSet.a(this.byk) instanceof Service)) {
        paramString.addFlags(268435456);
      }
      if (i != 0)
      {
        d.b(URISpanHandlerSet.a(this.byk), "scanner", ".ui.SingleTopScanUI", paramString);
        return true;
      }
      d.b(URISpanHandlerSet.a(this.byk), "scanner", ".ui.BaseScanUI", paramString);
      return true;
    }
    return false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.ScanQrCodeUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.app.plugin;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.ui.LauncherUI;

@URISpanHandlerSet.a
class URISpanHandlerSet$JumpActivityUriSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$JumpActivityUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final boolean a(m paramm, g paramg)
  {
    return false;
  }
  
  final boolean a(String paramString, boolean paramBoolean, s params, Bundle paramBundle)
  {
    if (paramString.toLowerCase().startsWith("weixin://jump/"))
    {
      paramString = paramString.split("/");
      paramString = paramString[(paramString.length - 1)];
      if ("mainframe".equalsIgnoreCase(paramString))
      {
        paramString = new Intent(URISpanHandlerSet.a(this.byk), LauncherUI.class);
        if ((URISpanHandlerSet.a(this.byk) instanceof Service)) {
          paramString.addFlags(268435456);
        }
        paramString.addFlags(67108864);
        URISpanHandlerSet.a(this.byk).startActivity(paramString);
      }
      for (;;)
      {
        return true;
        if ("shake".equalsIgnoreCase(paramString))
        {
          h.nFQ.aC(10221, "1");
          paramString = new Intent();
          paramString.addFlags(67108864);
          if ((URISpanHandlerSet.a(this.byk) instanceof Service)) {
            paramString.addFlags(268435456);
          }
          d.b(URISpanHandlerSet.a(this.byk), "shake", ".ui.ShakeReportUI", paramString);
          if ((URISpanHandlerSet.a(this.byk) != null) && ((URISpanHandlerSet.a(this.byk) instanceof Activity))) {
            ((Activity)URISpanHandlerSet.a(this.byk)).finish();
          }
        }
        else if ("scanqrcode".equalsIgnoreCase(paramString))
        {
          paramString = new Intent();
          paramString.putExtra("BaseScanUI_select_scan_mode", 1);
          paramString.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 2);
          paramString.setFlags(65536);
          paramString.addFlags(67108864);
          if ((URISpanHandlerSet.a(this.byk) instanceof Service)) {
            paramString.addFlags(268435456);
          }
          d.b(URISpanHandlerSet.a(this.byk), "scanner", ".ui.BaseScanUI", paramString);
        }
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.JumpActivityUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */
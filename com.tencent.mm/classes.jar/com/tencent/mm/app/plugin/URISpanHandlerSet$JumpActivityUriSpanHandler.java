package com.tencent.mm.app.plugin;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.pluginsdk.v;
import com.tencent.mm.ui.LauncherUI;

@URISpanHandlerSet.a
class URISpanHandlerSet$JumpActivityUriSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$JumpActivityUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
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
    AppMethodBeat.i(15675);
    if (paramString.toLowerCase().startsWith("weixin://jump/"))
    {
      paramString = paramString.split("/");
      paramString = paramString[(paramString.length - 1)];
      if ("mainframe".equalsIgnoreCase(paramString))
      {
        paramString = new Intent(URISpanHandlerSet.a(this.cam), LauncherUI.class);
        if ((URISpanHandlerSet.a(this.cam) instanceof Service)) {
          paramString.addFlags(268435456);
        }
        paramString.addFlags(67108864);
        URISpanHandlerSet.a(this.cam).startActivity(paramString);
      }
      for (;;)
      {
        AppMethodBeat.o(15675);
        return true;
        if ("shake".equalsIgnoreCase(paramString))
        {
          h.qsU.kvStat(10221, "1");
          paramString = new Intent();
          paramString.addFlags(67108864);
          if ((URISpanHandlerSet.a(this.cam) instanceof Service)) {
            paramString.addFlags(268435456);
          }
          d.b(URISpanHandlerSet.a(this.cam), "shake", ".ui.ShakeReportUI", paramString);
          if ((URISpanHandlerSet.a(this.cam) != null) && ((URISpanHandlerSet.a(this.cam) instanceof Activity))) {
            ((Activity)URISpanHandlerSet.a(this.cam)).finish();
          }
        }
        else if ("scanqrcode".equalsIgnoreCase(paramString))
        {
          paramString = new Intent();
          paramString.putExtra("BaseScanUI_select_scan_mode", 1);
          paramString.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 2);
          paramString.setFlags(65536);
          paramString.addFlags(67108864);
          if ((URISpanHandlerSet.a(this.cam) instanceof Service)) {
            paramString.addFlags(268435456);
          }
          d.b(URISpanHandlerSet.a(this.cam), "scanner", ".ui.BaseScanUI", paramString);
        }
      }
    }
    AppMethodBeat.o(15675);
    return false;
  }
  
  final m dN(String paramString)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.JumpActivityUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */
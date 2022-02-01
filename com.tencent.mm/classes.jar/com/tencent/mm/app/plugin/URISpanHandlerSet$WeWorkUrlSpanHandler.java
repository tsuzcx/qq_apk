package com.tencent.mm.app.plugin;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.account.sdk.b.a;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.ui.span.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatHosts;

@URISpanHandlerSet.a
class URISpanHandlerSet$WeWorkUrlSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  private final String fgQ;
  
  URISpanHandlerSet$WeWorkUrlSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
    AppMethodBeat.i(269088);
    this.fgQ = ("https://" + WeChatHosts.domainString(R.l.host_work_weixin_qq_com) + "/wework_admin/commdownload");
    AppMethodBeat.o(269088);
  }
  
  private static String getAppName(Context paramContext, String paramString)
  {
    AppMethodBeat.i(179569);
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext = paramContext.getApplicationInfo(paramString, 0).loadLabel(paramContext).toString();
      AppMethodBeat.o(179569);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      AppMethodBeat.o(179569);
    }
    return null;
  }
  
  final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, i parami)
  {
    AppMethodBeat.i(269090);
    if (paramu.type == 52)
    {
      paramView = new Intent();
      paramView.setAction("android.intent.action.VIEW");
      paramView.setData(Uri.parse(paramu.url));
      paramView.setPackage("com.tencent.wework");
      paramView.setFlags(268435456);
      try
      {
        boolean bool = h.b(MMApplicationContext.getContext(), paramView, getAppName(MMApplicationContext.getContext(), "com.tencent.wework"));
        if (!bool) {
          a.b(MMApplicationContext.getContext(), this.fgQ, 0, true);
        }
        Log.i("MicroMsg.URISpanHandlerSet", "WeWorkUrlSpanHandler result:%s", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(269090);
        return true;
      }
      catch (Exception paramView)
      {
        AppMethodBeat.o(269090);
        return false;
      }
    }
    AppMethodBeat.o(269090);
    return false;
  }
  
  final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
  {
    return false;
  }
  
  final int[] abR()
  {
    return new int[] { 52 };
  }
  
  final com.tencent.mm.pluginsdk.ui.applet.u hi(String paramString)
  {
    AppMethodBeat.i(179567);
    if (paramString.trim().toLowerCase().startsWith("wxwork://jump?"))
    {
      paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 52, null);
      AppMethodBeat.o(179567);
      return paramString;
    }
    AppMethodBeat.o(179567);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.WeWorkUrlSpanHandler
 * JD-Core Version:    0.7.0.1
 */
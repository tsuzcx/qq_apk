package com.tencent.mm.app.plugin;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.pluginsdk.v;

@URISpanHandlerSet.a
class URISpanHandlerSet$SettingPluginLomoUriSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$SettingPluginLomoUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final int[] Cf()
  {
    return new int[] { 12 };
  }
  
  final boolean a(m paramm, g paramg)
  {
    AppMethodBeat.i(15703);
    if (paramm.type == 12)
    {
      if (paramg != null) {
        paramg.a(paramm);
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("Contact_User", "weibo");
      d.b(URISpanHandlerSet.a(this.cam), "profile", ".ui.ContactInfoUI", localIntent);
      if (paramg != null) {
        paramg.b(paramm);
      }
      AppMethodBeat.o(15703);
      return true;
    }
    AppMethodBeat.o(15703);
    return false;
  }
  
  final boolean a(String paramString, boolean paramBoolean, v paramv, Bundle paramBundle)
  {
    AppMethodBeat.i(15704);
    if (paramString.equals("weixin://setting/plugin/lomo"))
    {
      paramString = new Intent();
      paramString.putExtra("Contact_User", "weibo");
      if ((URISpanHandlerSet.a(this.cam) instanceof Service)) {
        paramString.addFlags(268435456);
      }
      d.b(URISpanHandlerSet.a(this.cam), "profile", ".ui.ContactInfoUI", paramString);
      AppMethodBeat.o(15704);
      return true;
    }
    AppMethodBeat.o(15704);
    return false;
  }
  
  final m dN(String paramString)
  {
    AppMethodBeat.i(15702);
    if (paramString.trim().startsWith("weixin://setting/plugin/lomo"))
    {
      paramString = new m(paramString, 12, null);
      AppMethodBeat.o(15702);
      return paramString;
    }
    AppMethodBeat.o(15702);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.SettingPluginLomoUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */
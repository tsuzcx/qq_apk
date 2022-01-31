package com.tencent.mm.app.plugin;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.br.d;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;

@URISpanHandlerSet.a
class URISpanHandlerSet$SettingPluginLomoUriSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$SettingPluginLomoUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final boolean a(m paramm, g paramg)
  {
    if (paramm.type == 12)
    {
      if (paramg != null) {
        paramg.a(paramm);
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("Contact_User", "weibo");
      d.b(URISpanHandlerSet.a(this.byk), "profile", ".ui.ContactInfoUI", localIntent);
      if (paramg != null) {
        paramg.b(paramm);
      }
      return true;
    }
    return false;
  }
  
  final boolean a(String paramString, boolean paramBoolean, s params, Bundle paramBundle)
  {
    if (paramString.equals("weixin://setting/plugin/lomo"))
    {
      paramString = new Intent();
      paramString.putExtra("Contact_User", "weibo");
      if ((URISpanHandlerSet.a(this.byk) instanceof Service)) {
        paramString.addFlags(268435456);
      }
      d.b(URISpanHandlerSet.a(this.byk), "profile", ".ui.ContactInfoUI", paramString);
      return true;
    }
    return false;
  }
  
  final m cA(String paramString)
  {
    if (paramString.trim().startsWith("weixin://setting/plugin/lomo")) {
      return new m(paramString, 12, null);
    }
    return null;
  }
  
  final int[] tA()
  {
    return new int[] { 12 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.SettingPluginLomoUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */
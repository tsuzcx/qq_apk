package com.tencent.mm.app.plugin;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.model.ah;
import com.tencent.mm.model.ai;
import com.tencent.mm.pluginsdk.ui.span.i;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MainTabUI;
import com.tencent.mm.ui.contact.AddressUI;
import com.tencent.mm.ui.contact.SelectContactUI;

@URISpanHandlerSet.a
class URISpanHandlerSet$SettingBlacklistUriSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$SettingBlacklistUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, i parami)
  {
    AppMethodBeat.i(274731);
    if (paramu.type == 14)
    {
      if (parami != null) {
        parami.a(paramu);
      }
      Object localObject = ai.Rt(URISpanHandlerSet.a(this.fgB).getString(R.l.group_blacklist));
      paramView = new Intent();
      paramView.setClass(URISpanHandlerSet.a(this.fgB), SelectContactUI.class);
      paramView.putExtra("Contact_GroupFilter_Type", ((ah)localObject).getType());
      paramView.putExtra("Contact_GroupFilter_DisplayName", ((ah)localObject).ayr());
      paramView.addFlags(67108864);
      localObject = LauncherUI.getInstance();
      if (localObject != null) {
        ((LauncherUI)localObject).VXk.getMainTabUI().byt("tab_settings");
      }
      localObject = URISpanHandlerSet.a(this.fgB);
      paramView = new com.tencent.mm.hellhoundlib.b.a().bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b(localObject, paramView.aFh(), "com/tencent/mm/app/plugin/URISpanHandlerSet$SettingBlacklistUriSpanHandler", "handleSpanClick", "(Landroid/view/View;Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((Context)localObject).startActivity((Intent)paramView.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/app/plugin/URISpanHandlerSet$SettingBlacklistUriSpanHandler", "handleSpanClick", "(Landroid/view/View;Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      if (parami != null) {
        parami.b(paramu);
      }
      AppMethodBeat.o(274731);
      return true;
    }
    AppMethodBeat.o(274731);
    return false;
  }
  
  final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
  {
    AppMethodBeat.i(19741);
    if (paramString.equals("weixin://setting/blacklist"))
    {
      paramu = ai.Rt(URISpanHandlerSet.a(this.fgB).getString(R.l.group_blacklist));
      paramString = new Intent();
      paramString.setClass(URISpanHandlerSet.a(this.fgB), AddressUI.class);
      paramString.putExtra("Contact_GroupFilter_Type", paramu.getType());
      paramString.putExtra("Contact_GroupFilter_DisplayName", paramu.ayr());
      paramString.addFlags(67108864);
      if ((URISpanHandlerSet.a(this.fgB) instanceof Service)) {
        paramString.addFlags(268435456);
      }
      paramu = LauncherUI.getInstance();
      if (paramu != null) {
        paramu.VXk.getMainTabUI().byt("tab_settings");
      }
      paramu = URISpanHandlerSet.a(this.fgB);
      paramString = new com.tencent.mm.hellhoundlib.b.a().bm(paramString);
      com.tencent.mm.hellhoundlib.a.a.b(paramu, paramString.aFh(), "com/tencent/mm/app/plugin/URISpanHandlerSet$SettingBlacklistUriSpanHandler", "handleUriJump", "(Ljava/lang/String;ZLcom/tencent/mm/pluginsdk/UriJumpCallback;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramu.startActivity((Intent)paramString.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramu, "com/tencent/mm/app/plugin/URISpanHandlerSet$SettingBlacklistUriSpanHandler", "handleUriJump", "(Ljava/lang/String;ZLcom/tencent/mm/pluginsdk/UriJumpCallback;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(19741);
      return true;
    }
    AppMethodBeat.o(19741);
    return false;
  }
  
  final int[] abR()
  {
    return new int[] { 14 };
  }
  
  final com.tencent.mm.pluginsdk.ui.applet.u hi(String paramString)
  {
    AppMethodBeat.i(19739);
    if (paramString.trim().startsWith("weixin://setting/blacklist"))
    {
      paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 14, null);
      AppMethodBeat.o(19739);
      return paramString;
    }
    AppMethodBeat.o(19739);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.SettingBlacklistUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */
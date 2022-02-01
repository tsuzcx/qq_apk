package com.tencent.mm.plugin.appbrand.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.msgsubscription.presenter.d;
import com.tencent.mm.msgsubscription.ui.BizSubscribeMsgManagerUI;
import com.tencent.mm.sdk.platformtools.Log;

final class PluginAppBrand$14
  extends com.tencent.mm.msgsubscription.b.a
{
  PluginAppBrand$14(PluginAppBrand paramPluginAppBrand, com.tencent.mm.msgsubscription.d.a parama)
  {
    super(parama);
  }
  
  public final void a(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(317658);
    Log.i("MicroMsg.PluginAppBrand[speedtest]", "goToSettingManagerUI bizUsername: %s, nickname: %s", new Object[] { paramString1, paramString2 });
    Intent localIntent = new Intent(paramContext, BizSubscribeMsgManagerUI.class);
    localIntent.putExtra("key_biz_username", paramString1);
    localIntent.putExtra("key_biz_nickname", paramString2);
    localIntent.putExtra("key_biz_presenter_class", d.class.getName());
    if ((paramContext instanceof Activity))
    {
      com.tencent.mm.hellhoundlib.a.a.a((Activity)paramContext, c.a(100, new com.tencent.mm.hellhoundlib.b.a()).cG(localIntent).aYi(), "com/tencent/mm/plugin/appbrand/app/PluginAppBrand$8", "goToSettingManagerUI", "(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
      AppMethodBeat.o(317658);
      return;
    }
    paramString1 = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString1.aYi(), "com/tencent/mm/plugin/appbrand/app/PluginAppBrand$8", "goToSettingManagerUI", "(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString1.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/appbrand/app/PluginAppBrand$8", "goToSettingManagerUI", "(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(317658);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.PluginAppBrand.14
 * JD-Core Version:    0.7.0.1
 */
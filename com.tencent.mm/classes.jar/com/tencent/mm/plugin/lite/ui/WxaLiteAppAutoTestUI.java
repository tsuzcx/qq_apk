package com.tencent.mm.plugin.lite.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.boots.a.g;
import com.tencent.mm.plugin.lite.b.e;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.w;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/lite/ui/WxaLiteAppAutoTestUI;", "Landroid/app/Activity;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "luggage-lite-app_release"})
public final class WxaLiteAppAutoTestUI
  extends HellActivity
{
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(233744);
    super.onCreate(paramBundle);
    paramBundle = new g();
    paramBundle.appId = "wxalitefebbc33b53466af81dcbca5fef1c6c4f";
    paramBundle.smT = "http://dldir1.qq.com/weixin/liteappconfig/wxalitefebbc33b53466af81dcbca5fef1c6c4f_1f3b93b7b7a029ac684f5f9c83e27b39_d3198365b4b049dd9a197bc611be001e.zip";
    e.Egt.a(paramBundle, "debug", (com.tencent.mm.plugin.lite.launch.a)new a(this));
    AppMethodBeat.o(233744);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/lite/ui/WxaLiteAppAutoTestUI$onCreate$1", "Lcom/tencent/mm/plugin/lite/launch/ILiteAppInfoCallback;", "fail", "", "success", "info", "Lcom/tencent/liteapp/storage/WxaLiteAppInfo;", "luggage-lite-app_release"})
  public static final class a
    implements com.tencent.mm.plugin.lite.launch.a
  {
    public final void a(WxaLiteAppInfo paramWxaLiteAppInfo)
    {
      AppMethodBeat.i(234284);
      p.k(paramWxaLiteAppInfo, "info");
      Bundle localBundle = new Bundle();
      localBundle.putString("appId", paramWxaLiteAppInfo.appId);
      ((com.tencent.mm.plugin.lite.a.a)h.ae(com.tencent.mm.plugin.lite.a.a.class)).a(MMApplicationContext.getContext(), localBundle, false, null);
      this.Eha.finish();
      AppMethodBeat.o(234284);
    }
    
    public final void ewD()
    {
      AppMethodBeat.i(234286);
      w.makeText(MMApplicationContext.getContext(), (CharSequence)"下载失败", 0).show();
      this.Eha.finish();
      AppMethodBeat.o(234286);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.ui.WxaLiteAppAutoTestUI
 * JD-Core Version:    0.7.0.1
 */
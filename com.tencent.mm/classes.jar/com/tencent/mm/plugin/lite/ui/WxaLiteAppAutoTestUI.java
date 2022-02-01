package com.tencent.mm.plugin.lite.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.boots.a.g;
import com.tencent.mm.plugin.lite.api.b;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.aa;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/lite/ui/WxaLiteAppAutoTestUI;", "Landroid/app/Activity;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "luggage-lite-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class WxaLiteAppAutoTestUI
  extends HellActivity
{
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(271439);
    super.onCreate(paramBundle);
    paramBundle = new g();
    paramBundle.appId = "wxalitefebbc33b53466af81dcbca5fef1c6c4f";
    paramBundle.mOI = "http://dldir1.qq.com/weixin/liteappconfig/wxalitefebbc33b53466af81dcbca5fef1c6c4f_1f3b93b7b7a029ac684f5f9c83e27b39_d3198365b4b049dd9a197bc611be001e.zip";
    com.tencent.mm.plugin.lite.logic.c.KaN.a(paramBundle, "debug", (b)new a(this));
    AppMethodBeat.o(271439);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/lite/ui/WxaLiteAppAutoTestUI$onCreate$1", "Lcom/tencent/mm/plugin/lite/api/ILiteAppInfoCallback;", "fail", "", "success", "info", "Lcom/tencent/liteapp/storage/WxaLiteAppInfo;", "luggage-lite-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements b
  {
    a(WxaLiteAppAutoTestUI paramWxaLiteAppAutoTestUI) {}
    
    public final void b(WxaLiteAppInfo paramWxaLiteAppInfo)
    {
      AppMethodBeat.i(271408);
      s.u(paramWxaLiteAppInfo, "info");
      Bundle localBundle = new Bundle();
      localBundle.putString("appId", paramWxaLiteAppInfo.appId);
      ((com.tencent.mm.plugin.lite.api.c)h.ax(com.tencent.mm.plugin.lite.api.c.class)).a(MMApplicationContext.getContext(), localBundle, false, true, null);
      this.KbC.finish();
      AppMethodBeat.o(271408);
    }
    
    public final void csy()
    {
      AppMethodBeat.i(271416);
      aa.makeText(MMApplicationContext.getContext(), (CharSequence)"下载失败", 0).show();
      this.KbC.finish();
      AppMethodBeat.o(271416);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.ui.WxaLiteAppAutoTestUI
 * JD-Core Version:    0.7.0.1
 */
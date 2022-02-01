package com.tencent.mm.plugin.lite.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.LiteAppCenter;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity.b;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.d.b;
import java.util.HashMap;

@a(7)
@d.b
public class WxaLiteAppApiProxyUI
  extends MMActivity
{
  private static String TAG = "MicroMsg.WxaLiteAppApiProxyUI";
  
  public int getLayoutId()
  {
    return -1;
  }
  
  @TargetApi(21)
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(217821);
    super.onCreate(paramBundle);
    if (com.tencent.mm.compatible.util.d.lA(21)) {
      getWindow().setStatusBarColor(0);
    }
    paramBundle = getIntent();
    if (paramBundle.getIntExtra("proxyui_action_code_key", 0) == 0)
    {
      final int i = paramBundle.getIntExtra("callback_id", 0);
      paramBundle = (HashMap)paramBundle.getSerializableExtra("webview_params");
      Intent localIntent = new Intent();
      localIntent.putExtra("Select_Conv_Type", 3);
      localIntent.putExtra("scene_from", 2);
      localIntent.putExtra("mutil_select_is_ret", true);
      localIntent.putExtra("webview_params", paramBundle);
      localIntent.putExtra("Retr_Msg_Type", 2);
      ae.i(TAG, "start SelectConversationUI");
      com.tencent.mm.br.d.a(this, ".ui.transmit.SelectConversationUI", localIntent, 1, new MMFragmentActivity.b()
      {
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(217820);
          ae.i(WxaLiteAppApiProxyUI.TAG, "startAppActivityForResult %d %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          LiteAppCenter.onSelectConversationUICallback(i, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousIntent);
          WxaLiteAppApiProxyUI.this.finish();
          AppMethodBeat.o(217820);
        }
      });
    }
    AppMethodBeat.o(217821);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.ui.WxaLiteAppApiProxyUI
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.lite.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity.b;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.e.b;
import java.util.HashMap;

@a(7)
@e.b
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
    AppMethodBeat.i(233761);
    super.onCreate(paramBundle);
    if (d.qV(21)) {
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
      Log.i(TAG, "start SelectConversationUI");
      com.tencent.mm.by.c.a(this, ".ui.transmit.SelectConversationUI", localIntent, 1, new MMFragmentActivity.b()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(234268);
          Log.i(WxaLiteAppApiProxyUI.TAG, "startAppActivityForResult %d %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          com.tencent.mm.plugin.lite.c.a(i, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousIntent);
          WxaLiteAppApiProxyUI.this.finish();
          AppMethodBeat.o(234268);
        }
      });
    }
    AppMethodBeat.o(233761);
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
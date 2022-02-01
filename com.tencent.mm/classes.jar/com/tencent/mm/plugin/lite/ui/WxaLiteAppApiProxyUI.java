package com.tencent.mm.plugin.lite.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.account.ui.VerifyPwdUI;
import com.tencent.mm.plugin.findersdk.a.cb;
import com.tencent.mm.plugin.lite.a.b;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.pluginsdk.ui.applet.v;
import com.tencent.mm.pluginsdk.ui.applet.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.MMFragmentActivity.c;
import com.tencent.mm.ui.e.b;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(7)
@e.b
public class WxaLiteAppApiProxyUI
  extends MMActivity
{
  private static String TAG = "MicroMsg.WxaLiteAppApiProxyUI";
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(271496);
    super.onCreate(paramBundle);
    if (d.rb(21)) {
      getWindow().setStatusBarColor(0);
    }
    paramBundle = getIntent();
    switch (paramBundle.getIntExtra("proxyui_action_code_key", 0))
    {
    }
    for (;;)
    {
      AppMethodBeat.o(271496);
      return;
      final int i = paramBundle.getIntExtra("callback_id", 0);
      paramBundle = (HashMap)paramBundle.getSerializableExtra("webview_params");
      Object localObject1 = new Intent();
      ((Intent)localObject1).putExtra("Select_Conv_Type", 3);
      ((Intent)localObject1).putExtra("scene_from", 2);
      ((Intent)localObject1).putExtra("mutil_select_is_ret", true);
      ((Intent)localObject1).putExtra("webview_params", paramBundle);
      ((Intent)localObject1).putExtra("Retr_Msg_Type", 2);
      Log.i(TAG, "start SelectConversationUI");
      c.a(this, ".ui.transmit.SelectConversationUI", (Intent)localObject1, 1, new MMFragmentActivity.c()
      {
        public final void mmOnActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(271456);
          Log.i(WxaLiteAppApiProxyUI.TAG, "startAppActivityForResult %d %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          b.b(i, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousIntent);
          WxaLiteAppApiProxyUI.this.finish();
          AppMethodBeat.o(271456);
        }
      });
      AppMethodBeat.o(271496);
      return;
      i = paramBundle.getIntExtra("callback_id", 0);
      Object localObject4 = (HashMap)paramBundle.getSerializableExtra("batch_add_card_params");
      paramBundle = (String)((HashMap)localObject4).get("card_list");
      localObject1 = (String)((HashMap)localObject4).get("srcUsername");
      Object localObject2 = (String)((HashMap)localObject4).get("url");
      Object localObject3 = (String)((HashMap)localObject4).get("consumedCardId");
      String str = (String)((HashMap)localObject4).get("template_id");
      int j = Integer.parseInt((String)((HashMap)localObject4).get("scene"));
      localObject4 = new Intent();
      ((Intent)localObject4).putExtra("key_in_card_list", paramBundle);
      ((Intent)localObject4).putExtra("key_from_scene", j);
      ((Intent)localObject4).putExtra("src_username", (String)localObject1);
      ((Intent)localObject4).putExtra("js_url", (String)localObject2);
      ((Intent)localObject4).putExtra("key_consumed_card_id", (String)localObject3);
      ((Intent)localObject4).putExtra("key_template_id", str);
      Log.i(TAG, "start batchAddCard");
      mmSetOnActivityResultCallback(new MMActivity.a()
      {
        public final void mmOnActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(271454);
          Log.i(WxaLiteAppApiProxyUI.TAG, "startActivityForResult %d %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          b.c(i, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousIntent);
          WxaLiteAppApiProxyUI.this.finish();
          AppMethodBeat.o(271454);
        }
      });
      c.a(this, "card", ".ui.CardAddEntranceUI", (Intent)localObject4, 1, false);
      AppMethodBeat.o(271496);
      return;
      i = paramBundle.getIntExtra("callback_id", 0);
      localObject3 = (HashMap)paramBundle.getSerializableExtra("add_contact_params");
      ((HashMap)localObject3).get("webtype");
      paramBundle = (String)((HashMap)localObject3).get("username");
      ((HashMap)localObject3).get("scene");
      localObject2 = (String)((HashMap)localObject3).get("addscene");
      localObject1 = (String)((HashMap)localObject3).get("scenenote");
      localObject3 = (String)((HashMap)localObject3).get("profileReportInfo");
      switch (Util.getInt((String)localObject2, -1))
      {
      default: 
        Log.e(TAG, "unknown addScene = ".concat(String.valueOf(localObject2)));
        b.jz(i, -1);
        finish();
        AppMethodBeat.o(271496);
        return;
      }
      Log.i(TAG, "start addContact");
      localObject2 = new com.tencent.mm.pluginsdk.a();
      ((com.tencent.mm.pluginsdk.a)localObject2).XNj = ((String)localObject3);
      ((com.tencent.mm.pluginsdk.a)localObject2).hzx = ((String)localObject1);
      ((i)h.ax(i.class)).a(this, paramBundle, 33, new v()
      {
        public final void onAddContact(int paramAnonymousInt)
        {
          AppMethodBeat.i(271445);
          b.jz(i, paramAnonymousInt);
          WxaLiteAppApiProxyUI.this.finish();
          AppMethodBeat.o(271445);
        }
      }, (com.tencent.mm.pluginsdk.a)localObject2).show();
      AppMethodBeat.o(271496);
      return;
      i = paramBundle.getIntExtra("callback_id", 0);
      localObject2 = (HashMap)paramBundle.getSerializableExtra("jump_to_biz_profile_params");
      paramBundle = (String)((HashMap)localObject2).get("tousername");
      localObject1 = (String)((HashMap)localObject2).get("extmsg");
      localObject3 = (String)((HashMap)localObject2).get("url");
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("toUserName", paramBundle);
      ((Intent)localObject2).putExtra("extInfo", (String)localObject1);
      ((Intent)localObject2).putExtra("fromURL", (String)localObject3);
      ((Intent)localObject2).putExtra("source", 2);
      paramBundle = new MMActivity.a()
      {
        public final void mmOnActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(271437);
          Log.i(WxaLiteAppApiProxyUI.TAG, "startActivityForResult: %d %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          b.aP(i, paramAnonymousInt1, paramAnonymousInt2);
          WxaLiteAppApiProxyUI.this.finish();
          AppMethodBeat.o(271437);
        }
      };
      ((Intent)localObject2).setClassName(this, "com.tencent.mm.ui.CheckCanSubscribeBizUI");
      mmStartActivityForResult(paramBundle, (Intent)localObject2, 3);
      AppMethodBeat.o(271496);
      return;
      i = paramBundle.getIntExtra("callback_id", 0);
      paramBundle = (String)paramBundle.getSerializableExtra("open_finder_search_view_param");
      try
      {
        paramBundle = new JSONObject(paramBundle);
        if (((cb)h.ax(cb.class)).g(this, paramBundle)) {
          b.bh(i, true);
        }
        for (;;)
        {
          finish();
          AppMethodBeat.o(271496);
          return;
          b.bh(i, false);
        }
        i = paramBundle.getIntExtra("callback_id", 0);
      }
      catch (JSONException paramBundle)
      {
        Log.printErrStackTrace(TAG, paramBundle, "", new Object[0]);
        b.bh(i, false);
        finish();
        AppMethodBeat.o(271496);
        return;
      }
      paramBundle = (String)paramBundle.getSerializableExtra("open_finder_timeline_view_param");
      try
      {
        paramBundle = new JSONObject(paramBundle);
        if (((cb)h.ax(cb.class)).f(this, paramBundle)) {
          b.bi(i, true);
        }
        for (;;)
        {
          finish();
          AppMethodBeat.o(271496);
          return;
          b.bi(i, false);
        }
        mmSetOnActivityResultCallback(new MMActivity.a()
        {
          public final void mmOnActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
          {
            AppMethodBeat.i(271461);
            Log.i(WxaLiteAppApiProxyUI.TAG, "startActivityForResult: %d %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
            b.d(this.elZ, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousIntent);
            WxaLiteAppApiProxyUI.this.finish();
            AppMethodBeat.o(271461);
          }
        });
      }
      catch (JSONException paramBundle)
      {
        Log.printErrStackTrace(TAG, paramBundle, "", new Object[0]);
        b.bi(i, false);
        finish();
        AppMethodBeat.o(271496);
        return;
      }
      paramBundle = new Intent(this, VerifyPwdUI.class);
      paramBundle.putExtra("key_scenen", 0);
      startActivityForResult(paramBundle, 1000);
      AppMethodBeat.o(271496);
      return;
      i = paramBundle.getIntExtra("callback_id", 0);
      localObject1 = (HashMap)paramBundle.getSerializableExtra("download_game_video_params");
      paramBundle = (String)((HashMap)localObject1).get("videoUrl");
      localObject1 = (String)((HashMap)localObject1).get("thumbUrl");
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("game_from", 11);
      ((Intent)localObject2).putExtra("video_url", paramBundle);
      ((Intent)localObject2).putExtra("thumb_url", (String)localObject1);
      mmSetOnActivityResultCallback(new MMActivity.a()
      {
        public final void mmOnActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(271458);
          Log.i(WxaLiteAppApiProxyUI.TAG, "startActivityForResult: %d %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          b.e(i, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousIntent);
          WxaLiteAppApiProxyUI.this.finish();
          AppMethodBeat.o(271458);
        }
      });
      c.b(this, "game", ".media.GameVideoDownloadUI", (Intent)localObject2, 1137);
    }
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
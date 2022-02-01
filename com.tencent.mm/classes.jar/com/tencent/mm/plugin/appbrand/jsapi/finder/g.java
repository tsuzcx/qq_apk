package com.tencent.mm.plugin.appbrand.jsapi.finder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.l.e.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.message.k.b;
import com.tencent.mm.message.k.c;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.w;
import org.json.JSONObject;

public final class g
  extends com.tencent.mm.plugin.appbrand.jsapi.c
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "shareFinderEndorsementToFriend";
  private static com.tencent.mm.cp.c rYv;
  private w rYw = null;
  
  static
  {
    AppMethodBeat.i(326613);
    com.tencent.mm.cp.c local1 = new com.tencent.mm.cp.c() {};
    rYv = local1;
    k.c.a(local1);
    AppMethodBeat.o(326613);
  }
  
  public final void a(final f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(163989);
    if ((!(paramf.getContext() instanceof Activity)) || (paramJSONObject == null))
    {
      paramf.callback(paramInt, "fail");
      AppMethodBeat.o(163989);
      return;
    }
    Object localObject = paramJSONObject.optString("title", "");
    String str1 = paramJSONObject.optString("desc", "");
    String str2 = paramJSONObject.optString("relativePath", "");
    int i = paramJSONObject.optInt("scene", 0);
    paramJSONObject.optString("sceneNote", "");
    paramJSONObject = paramJSONObject.optString("appid", "");
    k.b localb = new k.b();
    com.tencent.mm.plugin.finder.api.e locale = new com.tencent.mm.plugin.finder.api.e();
    locale.title = ((String)localObject);
    locale.desc = str1;
    locale.Axg = str2;
    locale.appid = paramJSONObject;
    locale.scene = i;
    localb.type = 81;
    localb.url = MMApplicationContext.getContext().getString(ba.i.low_version_upgrade_url);
    localb.title = ((String)localObject);
    localb.desc = str1;
    localb.a(locale);
    paramJSONObject = k.b.a(localb, null, null);
    Log.i("MicroMsg.Finder.JsApiShareFinderEndorsementToFriend", "msgContent %s", new Object[] { paramJSONObject });
    localObject = new Intent();
    ((Intent)localObject).setClassName(paramf.getContext(), MMApplicationContext.getSourcePackageName() + ".ui.transmit.MsgRetransmitUI");
    ((Intent)localObject).putExtra("Retr_Msg_Type", 19);
    ((Intent)localObject).putExtra("Retr_Msg_content", paramJSONObject);
    ((Intent)localObject).putExtra("Multi_Retr", false);
    ((Intent)localObject).putExtra("Retr_go_to_chattingUI", false);
    ((Intent)localObject).putExtra("Retr_show_success_tips", true);
    com.tencent.luggage.l.e.bt(paramf.getContext()).a((Intent)localObject, new e.b()
    {
      public final void onResult(int paramAnonymousInt, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(326612);
        for (;;)
        {
          try
          {
            paramAnonymousIntent = new JSONObject();
            if (paramAnonymousInt != -1) {
              continue;
            }
            paramAnonymousIntent.put("isSuccess", true);
            paramAnonymousIntent.put("isCancel", false);
            paramf.callback(paramInt, a.a("", 0, paramAnonymousIntent));
          }
          catch (Exception paramAnonymousIntent)
          {
            Log.i("MicroMsg.Finder.JsApiShareFinderEndorsementToFriend", paramAnonymousIntent.getMessage());
            return;
            paramAnonymousIntent.put("isSuccess", false);
            paramAnonymousIntent.put("isCancel", false);
            paramf.callback(paramInt, a.a("", paramAnonymousInt, paramAnonymousIntent));
            continue;
          }
          finally
          {
            if ((g.a(g.this) == null) || (!g.a(g.this).isShowing())) {
              continue;
            }
            g.a(g.this).dismiss();
            AppMethodBeat.o(326612);
          }
          if ((g.a(g.this) == null) || (!g.a(g.this).isShowing())) {
            break label265;
          }
          g.a(g.this).dismiss();
          AppMethodBeat.o(326612);
          return;
          if (paramAnonymousInt != 0) {
            continue;
          }
          paramAnonymousIntent.put("isSuccess", false);
          paramAnonymousIntent.put("isCancel", true);
          paramf.callback(paramInt, a.a("", 1, paramAnonymousIntent));
        }
        label265:
        AppMethodBeat.o(326612);
      }
    });
    AppMethodBeat.o(163989);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.finder.g
 * JD-Core Version:    0.7.0.1
 */
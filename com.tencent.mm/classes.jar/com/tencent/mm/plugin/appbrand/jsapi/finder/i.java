package com.tencent.mm.plugin.appbrand.jsapi.finder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.k.f;
import com.tencent.luggage.k.f.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.aj.k.c;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.s;
import org.json.JSONObject;

public final class i
  extends com.tencent.mm.plugin.appbrand.jsapi.c
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "shareFinderEndorsementToFriend";
  private static com.tencent.mm.cw.c oTj;
  private s oTk = null;
  
  static
  {
    AppMethodBeat.i(274741);
    com.tencent.mm.cw.c local1 = new com.tencent.mm.cw.c() {};
    oTj = local1;
    k.c.a(local1);
    AppMethodBeat.o(274741);
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(163989);
    if ((!(parame.getContext() instanceof Activity)) || (paramJSONObject == null))
    {
      parame.j(paramInt, "fail");
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
    locale.wZW = str2;
    locale.appid = paramJSONObject;
    locale.scene = i;
    localb.type = 81;
    localb.url = MMApplicationContext.getContext().getString(au.i.low_version_upgrade_url);
    localb.title = ((String)localObject);
    localb.desc = str1;
    localb.a(locale);
    paramJSONObject = k.b.a(localb, null, null);
    Log.i("MicroMsg.Finder.JsApiShareFinderEndorsementToFriend", "msgContent %s", new Object[] { paramJSONObject });
    localObject = new Intent();
    ((Intent)localObject).setClassName(parame.getContext(), MMApplicationContext.getSourcePackageName() + ".ui.transmit.MsgRetransmitUI");
    ((Intent)localObject).putExtra("Retr_Msg_Type", 19);
    ((Intent)localObject).putExtra("Retr_Msg_content", paramJSONObject);
    ((Intent)localObject).putExtra("Multi_Retr", false);
    ((Intent)localObject).putExtra("Retr_go_to_chattingUI", false);
    ((Intent)localObject).putExtra("Retr_show_success_tips", true);
    f.aI(parame.getContext()).a((Intent)localObject, new f.b()
    {
      public final void a(int paramAnonymousInt, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(279502);
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
            parame.j(paramInt, a.a("", 0, paramAnonymousIntent));
          }
          catch (Exception paramAnonymousIntent)
          {
            Log.i("MicroMsg.Finder.JsApiShareFinderEndorsementToFriend", paramAnonymousIntent.getMessage());
            return;
            paramAnonymousIntent.put("isSuccess", false);
            paramAnonymousIntent.put("isCancel", false);
            parame.j(paramInt, a.a("", paramAnonymousInt, paramAnonymousIntent));
            continue;
          }
          finally
          {
            if ((i.a(i.this) == null) || (!i.a(i.this).isShowing())) {
              continue;
            }
            i.a(i.this).dismiss();
            AppMethodBeat.o(279502);
          }
          if ((i.a(i.this) == null) || (!i.a(i.this).isShowing())) {
            break label265;
          }
          i.a(i.this).dismiss();
          AppMethodBeat.o(279502);
          return;
          if (paramAnonymousInt != 0) {
            continue;
          }
          paramAnonymousIntent.put("isSuccess", false);
          paramAnonymousIntent.put("isCancel", true);
          parame.j(paramInt, a.a("", 1, paramAnonymousIntent));
        }
        label265:
        AppMethodBeat.o(279502);
      }
    });
    AppMethodBeat.o(163989);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.finder.i
 * JD-Core Version:    0.7.0.1
 */
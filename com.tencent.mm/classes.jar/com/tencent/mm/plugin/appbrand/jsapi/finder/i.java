package com.tencent.mm.plugin.appbrand.jsapi.finder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.h.e;
import com.tencent.luggage.h.e.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.finder.api.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import org.json.JSONObject;

public final class i
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "shareFinderEndorsementToFriend";
  
  public final void a(final c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(163989);
    if ((!(paramc.getContext() instanceof Activity)) || (paramJSONObject == null))
    {
      paramc.h(paramInt, "fail");
      AppMethodBeat.o(163989);
      return;
    }
    Object localObject = paramJSONObject.optString("title", "");
    String str1 = paramJSONObject.optString("desc", "");
    String str2 = paramJSONObject.optString("relativePath", "");
    paramJSONObject.optInt("scene", 0);
    paramJSONObject = paramJSONObject.optString("sceneNote", "");
    k.b localb = new k.b();
    d locald = new d();
    locald.title = ((String)localObject);
    locald.desc = str1;
    locald.rHp = str2;
    locald.dkh = paramJSONObject;
    locald.desc = str1;
    localb.type = 52;
    localb.url = aj.getContext().getString(2131760810);
    localb.title = ((String)localObject);
    localb.desc = str1;
    localb.a(locald);
    paramJSONObject = k.b.a(localb, null, null);
    ad.i("MicroMsg.Finder.JsApiShareFinderEndorsementToFriend", "msgContent %s", new Object[] { paramJSONObject });
    localObject = new Intent();
    ((Intent)localObject).setClassName(paramc.getContext(), aj.fkB() + ".ui.transmit.MsgRetransmitUI");
    ((Intent)localObject).putExtra("Retr_Msg_Type", 19);
    ((Intent)localObject).putExtra("Retr_Msg_content", paramJSONObject);
    ((Intent)localObject).putExtra("Multi_Retr", true);
    ((Intent)localObject).putExtra("Retr_go_to_chattingUI", false);
    ((Intent)localObject).putExtra("Retr_show_success_tips", true);
    e.aA(paramc.getContext()).a((Intent)localObject, new e.b()
    {
      public final void a(int paramAnonymousInt, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(163988);
        if (paramAnonymousInt == -1)
        {
          paramc.h(paramInt, a.a("", 0, new JSONObject()));
          AppMethodBeat.o(163988);
          return;
        }
        paramc.h(paramInt, a.a("", 1, new JSONObject()));
        AppMethodBeat.o(163988);
      }
    });
    AppMethodBeat.o(163989);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.finder.i
 * JD-Core Version:    0.7.0.1
 */
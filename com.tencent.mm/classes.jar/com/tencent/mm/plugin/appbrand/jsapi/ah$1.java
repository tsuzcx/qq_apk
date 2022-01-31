package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.luggage.g.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class ah$1
  implements e.a
{
  ah$1(ah paramah, c paramc, int paramInt) {}
  
  public final void b(int paramInt, Intent paramIntent)
  {
    int i = -1;
    AppMethodBeat.i(130412);
    if (paramInt == -1)
    {
      String str1 = paramIntent.getStringExtra("k_select_group");
      HashMap localHashMap = new HashMap();
      if (!TextUtils.isEmpty(str1))
      {
        switch (str1.hashCode())
        {
        default: 
          paramInt = i;
          switch (paramInt)
          {
          }
          break;
        }
        for (;;)
        {
          this.hxC.h(this.bAX, this.hxD.j("cancel", null));
          AppMethodBeat.o(130412);
          return;
          paramInt = i;
          if (!str1.equals("private")) {
            break;
          }
          paramInt = 0;
          break;
          paramInt = i;
          if (!str1.equals("public")) {
            break;
          }
          paramInt = 1;
          break;
          paramInt = i;
          if (!str1.equals("visible")) {
            break;
          }
          paramInt = 2;
          break;
          paramInt = i;
          if (!str1.equals("invisible")) {
            break;
          }
          paramInt = 3;
          break;
          localHashMap.put("group", str1);
          this.hxC.h(this.bAX, this.hxD.j("ok", localHashMap));
          AppMethodBeat.o(130412);
          return;
          String str2 = paramIntent.getStringExtra("Klabel_name_list");
          paramIntent = paramIntent.getStringExtra("Kother_user_name_list");
          localHashMap.put("group", str1);
          try
          {
            if (!TextUtils.isEmpty(str2)) {
              localHashMap.put("labels", new JSONObject(str2));
            }
            if (!TextUtils.isEmpty(paramIntent)) {
              localHashMap.put("userList", new JSONArray(paramIntent));
            }
            this.hxC.h(this.bAX, this.hxD.j("ok", localHashMap));
            AppMethodBeat.o(130412);
            return;
          }
          catch (JSONException paramIntent)
          {
            ab.printErrStackTrace("MicroMsg.JsApiChooseShareGroup", paramIntent, "", new Object[0]);
          }
        }
      }
      this.hxC.h(this.bAX, this.hxD.j("cancel", null));
      AppMethodBeat.o(130412);
      return;
    }
    this.hxC.h(this.bAX, this.hxD.j("fail", null));
    AppMethodBeat.o(130412);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ah.1
 * JD-Core Version:    0.7.0.1
 */
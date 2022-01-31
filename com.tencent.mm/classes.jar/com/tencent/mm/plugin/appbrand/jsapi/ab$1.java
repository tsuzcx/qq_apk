package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

final class ab$1
  implements MMActivity.a
{
  ab$1(ab paramab, h paramh) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(130373);
    if (paramInt1 == 1)
    {
      if (paramInt2 == -1)
      {
        if (paramIntent == null)
        {
          this.hxk.h(this.hxl.bxX, this.hxl.j("fail:internal error", null));
          com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.JsApiAddCard", "location result is empty!");
          AppMethodBeat.o(130373);
          return;
        }
        HashMap localHashMap = new HashMap();
        paramIntent = paramIntent.getStringExtra("card_list");
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.JsApiAddCard", "mmSetOnActivityResultCallback cardList:%s", new Object[] { paramIntent });
        try
        {
          paramIntent = new JSONArray(paramIntent);
          if (paramIntent != null)
          {
            localHashMap.put("cardList", paramIntent);
            this.hxk.h(this.hxl.bxX, this.hxl.j("ok", localHashMap));
            AppMethodBeat.o(130373);
            return;
          }
        }
        catch (JSONException paramIntent)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.JsApiAddCard", "parse fail result:%s", new Object[] { bo.l(paramIntent) });
            paramIntent = null;
          }
          this.hxk.h(this.hxl.bxX, this.hxl.j("fail: cardList is empty", localHashMap));
          com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.JsApiAddCard", "add card result is fail! cardList is empty");
          AppMethodBeat.o(130373);
          return;
        }
      }
      if (paramInt2 == 0)
      {
        this.hxk.h(this.hxl.bxX, this.hxl.j("cancel", null));
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.JsApiAddCard", "add card result is cancel!");
        AppMethodBeat.o(130373);
        return;
      }
      if (paramIntent == null) {
        break label352;
      }
    }
    label352:
    for (paramInt1 = paramIntent.getIntExtra("result_code", 2);; paramInt1 = 2)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.JsApiAddCard", "mmSetOnActivityResultCallback ret_code:%d", new Object[] { Integer.valueOf(paramInt1) });
      if (paramInt1 == 2)
      {
        this.hxk.h(this.hxl.bxX, this.hxl.j("fail:internal error", null));
        AppMethodBeat.o(130373);
        return;
      }
      this.hxk.h(this.hxl.bxX, this.hxl.j("cancel", null));
      AppMethodBeat.o(130373);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ab.1
 * JD-Core Version:    0.7.0.1
 */
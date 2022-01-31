package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

final class w$1
  implements MMActivity.a
{
  w$1(w paramw, f paramf) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1)
    {
      if (paramInt2 != -1) {
        break label190;
      }
      if (paramIntent == null)
      {
        this.gfy.C(this.gfz.bhx, this.gfz.h("fail:internal error", null));
        y.e("MicroMsg.JsApiAddCard", "location result is empty!");
      }
    }
    else
    {
      return;
    }
    HashMap localHashMap = new HashMap();
    paramIntent = paramIntent.getStringExtra("card_list");
    y.d("MicroMsg.JsApiAddCard", "mmSetOnActivityResultCallback cardList:%s", new Object[] { paramIntent });
    try
    {
      paramIntent = new JSONArray(paramIntent);
      if (paramIntent != null)
      {
        localHashMap.put("cardList", paramIntent);
        this.gfy.C(this.gfz.bhx, this.gfz.h("ok", localHashMap));
        return;
      }
    }
    catch (JSONException paramIntent)
    {
      for (;;)
      {
        y.e("MicroMsg.JsApiAddCard", "parse fail result:%s", new Object[] { bk.j(paramIntent) });
        paramIntent = null;
      }
      this.gfy.C(this.gfz.bhx, this.gfz.h("fail: cardList is empty", localHashMap));
      y.e("MicroMsg.JsApiAddCard", "add card result is fail! cardList is empty");
      return;
    }
    label190:
    if (paramInt2 == 0)
    {
      this.gfy.C(this.gfz.bhx, this.gfz.h("cancel", null));
      y.e("MicroMsg.JsApiAddCard", "add card result is cancel!");
      return;
    }
    if (paramIntent != null) {}
    for (paramInt1 = paramIntent.getIntExtra("result_code", 2);; paramInt1 = 2)
    {
      y.i("MicroMsg.JsApiAddCard", "mmSetOnActivityResultCallback ret_code:%d", new Object[] { Integer.valueOf(paramInt1) });
      if (paramInt1 == 2)
      {
        this.gfy.C(this.gfz.bhx, this.gfz.h("fail:internal error", null));
        return;
      }
      this.gfy.C(this.gfz.bhx, this.gfz.h("cancel", null));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.w.1
 * JD-Core Version:    0.7.0.1
 */
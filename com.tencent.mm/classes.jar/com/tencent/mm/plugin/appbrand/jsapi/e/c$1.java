package com.tencent.mm.plugin.appbrand.jsapi.e;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Map;

final class c$1
  implements MMActivity.a
{
  c$1(c paramc, r paramr) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(131108);
    if (paramInt1 == 1)
    {
      if (paramInt2 == -1)
      {
        if (paramIntent == null)
        {
          this.bAW.h(this.hMY.bxX, this.hMY.j("fail", null));
          ab.e("MicroMsg.JsApiChooseLocation", "location result is empty!");
          AppMethodBeat.o(131108);
          return;
        }
        paramIntent = (Addr)paramIntent.getParcelableExtra("key_pick_addr");
        HashMap localHashMap = new HashMap();
        if (paramIntent != null)
        {
          ab.i("MicroMsg.JsApiChooseLocation", "addr: " + paramIntent.toString());
          StringBuilder localStringBuilder = new StringBuilder();
          if (!TextUtils.isEmpty(paramIntent.fBq))
          {
            localStringBuilder.append(paramIntent.fBq);
            localHashMap.put("address", localStringBuilder.toString());
            if (TextUtils.isEmpty(paramIntent.fBz)) {
              break label262;
            }
            localHashMap.put("name", paramIntent.fBz);
          }
          for (;;)
          {
            localHashMap.put("latitude", Float.valueOf(paramIntent.fBB));
            localHashMap.put("longitude", Float.valueOf(paramIntent.fBC));
            this.bAW.h(this.hMY.bxX, this.hMY.j("ok", localHashMap));
            AppMethodBeat.o(131108);
            return;
            localStringBuilder.append(paramIntent.agM());
            break;
            label262:
            localHashMap.put("name", localStringBuilder.toString());
          }
        }
        this.bAW.h(this.hMY.bxX, this.hMY.j("fail", null));
        ab.e("MicroMsg.JsApiChooseLocation", "location result is empty!");
        AppMethodBeat.o(131108);
        return;
      }
      if (paramInt2 == 0)
      {
        this.bAW.h(this.hMY.bxX, this.hMY.j("cancel", null));
        ab.e("MicroMsg.JsApiChooseLocation", "location result is cancel!");
        AppMethodBeat.o(131108);
        return;
      }
      this.bAW.h(this.hMY.bxX, this.hMY.j("fail", null));
      ab.e("MicroMsg.JsApiChooseLocation", "location result is fail!");
    }
    AppMethodBeat.o(131108);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.e.c.1
 * JD-Core Version:    0.7.0.1
 */
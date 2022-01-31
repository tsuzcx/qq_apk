package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Map;

final class av$1
  implements MMActivity.a
{
  av$1(av paramav, c paramc, int paramInt) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(130512);
    if (paramInt1 != (this.hzb.hashCode() & 0xFFFF))
    {
      AppMethodBeat.o(130512);
      return;
    }
    if ((paramInt2 == -1) && (paramIntent != null))
    {
      String str1 = bo.bf(paramIntent.getStringExtra("nationalCode"), "");
      String str2 = bo.bf(paramIntent.getStringExtra("userName"), "");
      String str3 = bo.bf(paramIntent.getStringExtra("telNumber"), "");
      String str4 = bo.bf(paramIntent.getStringExtra("addressPostalCode"), "");
      String str5 = bo.bf(paramIntent.getStringExtra("proviceFirstStageName"), "");
      String str6 = bo.bf(paramIntent.getStringExtra("addressCitySecondStageName"), "");
      String str7 = bo.bf(paramIntent.getStringExtra("addressCountiesThirdStageName"), "");
      paramIntent = bo.bf(paramIntent.getStringExtra("addressDetailInfo"), "");
      ab.i("MicroMsg.JsApiOpenAddress", "first =  " + str5 + " ; detail =" + paramIntent + "; second = " + str6 + " ; tel = " + str3 + "; third = " + str7);
      if (!bo.isNullOrNil(str2))
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("nationalCode", str1);
        localHashMap.put("userName", str2);
        localHashMap.put("telNumber", str3);
        localHashMap.put("addressPostalCode", str4);
        localHashMap.put("proviceFirstStageName", str5);
        localHashMap.put("addressCitySecondStageName", str6);
        localHashMap.put("addressCountiesThirdStageName", str7);
        localHashMap.put("addressDetailInfo", paramIntent);
        this.hza.h(this.bAX, this.hzb.j("ok", localHashMap));
        AppMethodBeat.o(130512);
        return;
      }
    }
    if (paramInt2 == 0)
    {
      this.hza.h(this.bAX, this.hzb.j("cancel", null));
      AppMethodBeat.o(130512);
      return;
    }
    this.hza.h(this.bAX, this.hzb.j("fail", null));
    AppMethodBeat.o(130512);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.av.1
 * JD-Core Version:    0.7.0.1
 */
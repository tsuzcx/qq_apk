package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Map;

final class al$1
  implements MMActivity.a
{
  al$1(al paramal, c paramc, int paramInt) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != (this.ggF.hashCode() & 0xFFFF)) {
      return;
    }
    if ((paramInt2 == -1) && (paramIntent != null))
    {
      String str1 = bk.aM(paramIntent.getStringExtra("nationalCode"), "");
      String str2 = bk.aM(paramIntent.getStringExtra("userName"), "");
      String str3 = bk.aM(paramIntent.getStringExtra("telNumber"), "");
      String str4 = bk.aM(paramIntent.getStringExtra("addressPostalCode"), "");
      String str5 = bk.aM(paramIntent.getStringExtra("proviceFirstStageName"), "");
      String str6 = bk.aM(paramIntent.getStringExtra("addressCitySecondStageName"), "");
      String str7 = bk.aM(paramIntent.getStringExtra("addressCountiesThirdStageName"), "");
      paramIntent = bk.aM(paramIntent.getStringExtra("addressDetailInfo"), "");
      y.i("MicroMsg.JsApiOpenAddress", "first =  " + str5 + " ; detail =" + paramIntent + "; second = " + str6 + " ; tel = " + str3 + "; third = " + str7);
      if (!bk.bl(str2))
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
        this.ggE.C(this.dIS, this.ggF.h("ok", localHashMap));
        return;
      }
    }
    if (paramInt2 == 0)
    {
      this.ggE.C(this.dIS, this.ggF.h("cancel", null));
      return;
    }
    this.ggE.C(this.dIS, this.ggF.h("fail", null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.al.1
 * JD-Core Version:    0.7.0.1
 */
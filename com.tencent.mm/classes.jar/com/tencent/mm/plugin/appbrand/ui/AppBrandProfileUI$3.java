package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.wp;
import com.tencent.mm.message.a;
import com.tencent.mm.message.f;
import com.tencent.mm.message.k.b;
import com.tencent.mm.message.w;
import com.tencent.mm.message.w.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.ac;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.config.al;
import com.tencent.mm.plugin.appbrand.jsapi.share.x;
import com.tencent.mm.plugin.appbrand.jsapi.share.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.k;
import java.util.Iterator;
import java.util.List;

final class AppBrandProfileUI$3
  implements MMActivity.a
{
  AppBrandProfileUI$3(AppBrandProfileUI paramAppBrandProfileUI, al paramal) {}
  
  public final void mmOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(322379);
    if (paramInt1 == 1)
    {
      if (paramInt2 == -1)
      {
        if (paramIntent == null) {}
        for (Object localObject1 = null; (localObject1 == null) || (((String)localObject1).length() == 0); localObject1 = paramIntent.getStringExtra("Select_Conv_User"))
        {
          Log.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "mmOnActivityResult fail, toUser is null");
          AppMethodBeat.o(322379);
          return;
        }
        Log.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "result success toUser : %s ", new Object[] { localObject1 });
        paramIntent = paramIntent.getStringExtra("custom_send_text");
        String str = this.udB.appId;
        Object localObject2 = ad.Jo("wxapp_".concat(String.valueOf(str)));
        ad.bCb().M((String)localObject2, true).q("prePublishId", "wxapp_".concat(String.valueOf(str)));
        paramInt1 = 0;
        localObject2 = new k.b();
        ((k.b)localObject2).title = this.udB.nickname;
        ((k.b)localObject2).type = 33;
        ((k.b)localObject2).nTD = AppBrandProfileUI.g(this.udA);
        ((k.b)localObject2).nTE = str;
        ((k.b)localObject2).nTF = 1;
        ((k.b)localObject2).iag = "wxapp_".concat(String.valueOf(str));
        ((k.b)localObject2).thumburl = this.udB.hJL;
        ((k.b)localObject2).url = ac.UC(str);
        ((k.b)localObject2).iaa = AppBrandProfileUI.g(this.udA);
        ((k.b)localObject2).iab = this.udB.nickname;
        Object localObject3 = new a();
        ((a)localObject3).nOW = this.udB.rbZ;
        ((a)localObject3).nOX = this.udB.nOX;
        ((k.b)localObject2).a((f)localObject3);
        localObject1 = Util.stringsToList(((String)localObject1).split(",")).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject3 = (String)((Iterator)localObject1).next();
          ((k.b)localObject2).nTI = x.cJ(str, paramInt1).toString();
          w.a.bwq().a((k.b)localObject2, str, this.udB.nickname, (String)localObject3, null, null);
          if (!Util.isNullOrNil(paramIntent))
          {
            wp localwp = new wp();
            localwp.iak.hgl = ((String)localObject3);
            localwp.iak.content = paramIntent;
            localwp.iak.type = ab.IX((String)localObject3);
            localwp.iak.flags = 0;
            localwp.publish();
          }
          if (((String)localObject3).endsWith("@chatroom")) {}
          for (paramInt2 = 31;; paramInt2 = 30)
          {
            localObject3 = new y();
            ((y)localObject3).hzD = ((k.b)localObject2).nTI;
            ((y)localObject3).svF = 0;
            ((y)localObject3).svG = ((k.b)localObject2).title;
            ((y)localObject3).svI = ((k.b)localObject2).thumburl;
            AppBrandProfileUI.a(this.udA, paramInt2, Util.nowSecond(), (y)localObject3);
            paramInt1 += 1;
            break;
          }
        }
        k.cZ(this.udA, this.udA.getResources().getString(ba.i.app_shared));
        AppMethodBeat.o(322379);
      }
    }
    else {
      AppBrandProfileUI.a(this.udA, 30, 2);
    }
    AppMethodBeat.o(322379);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.3
 * JD-Core Version:    0.7.0.1
 */
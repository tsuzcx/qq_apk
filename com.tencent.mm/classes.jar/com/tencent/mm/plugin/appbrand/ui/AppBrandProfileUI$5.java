package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.h.a.pe;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.h;
import java.util.Iterator;
import java.util.List;

final class AppBrandProfileUI$5
  implements MMActivity.a
{
  AppBrandProfileUI$5(AppBrandProfileUI paramAppBrandProfileUI, com.tencent.mm.plugin.appbrand.config.u paramu, View paramView) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1)
    {
      if (paramInt2 == -1) {
        if (paramIntent != null) {
          break label38;
        }
      }
      label38:
      for (Object localObject1 = null; (localObject1 == null) || (((String)localObject1).length() == 0); localObject1 = paramIntent.getStringExtra("Select_Conv_User"))
      {
        y.i("MicroMsg.AppBrandProfileUI", "mmOnActivityResult fail, toUser is null");
        return;
      }
      y.i("MicroMsg.AppBrandProfileUI", "result success toUser : %s ", new Object[] { localObject1 });
      paramIntent = paramIntent.getStringExtra("custom_send_text");
      String str1 = this.hdF.appId;
      Object localObject2 = com.tencent.mm.model.u.ij("wxapp_" + str1);
      com.tencent.mm.model.u.Hc().v((String)localObject2, true).h("prePublishId", "wxapp_" + str1);
      localObject2 = new g.a();
      ((g.a)localObject2).title = this.hdF.nickname;
      ((g.a)localObject2).type = 33;
      ((g.a)localObject2).dSY = AppBrandProfileUI.b(this.hdE);
      ((g.a)localObject2).dSZ = str1;
      ((g.a)localObject2).dTa = 1;
      ((g.a)localObject2).bYM = ("wxapp_" + str1);
      ((g.a)localObject2).thumburl = this.hdF.fRz;
      ((g.a)localObject2).url = r.qN(str1);
      ((g.a)localObject2).bYG = AppBrandProfileUI.b(this.hdE);
      ((g.a)localObject2).bYH = this.hdF.nickname;
      localObject1 = bk.G(((String)localObject1).split(",")).iterator();
      if (((Iterator)localObject1).hasNext())
      {
        String str2 = (String)((Iterator)localObject1).next();
        ((com.tencent.mm.plugin.appbrand.compat.a.a)g.r(com.tencent.mm.plugin.appbrand.compat.a.a.class)).a((g.a)localObject2, str1, this.hdF.nickname, str2, null);
        if (!bk.bl(paramIntent))
        {
          pe localpe = new pe();
          localpe.bYQ.bYR = str2;
          localpe.bYQ.content = paramIntent;
          localpe.bYQ.type = s.hW(str2);
          localpe.bYQ.flags = 0;
          com.tencent.mm.sdk.b.a.udP.m(localpe);
        }
        if (str2.endsWith("@chatroom")) {}
        for (paramInt1 = 9;; paramInt1 = 8)
        {
          AppBrandProfileUI.a(this.hdE, paramInt1, bk.UX());
          break;
        }
      }
      h.bC(this.hdG.getContext(), this.hdG.getContext().getResources().getString(y.j.app_shared));
      return;
    }
    AppBrandProfileUI.a(this.hdE, 8, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.5
 * JD-Core Version:    0.7.0.1
 */
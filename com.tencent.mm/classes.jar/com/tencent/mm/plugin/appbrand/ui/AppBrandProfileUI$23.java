package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.a.qj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.model.v.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.h;
import java.util.Iterator;
import java.util.List;

final class AppBrandProfileUI$23
  implements MMActivity.a
{
  AppBrandProfileUI$23(AppBrandProfileUI paramAppBrandProfileUI, com.tencent.mm.plugin.appbrand.config.v paramv, View paramView) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(133047);
    if (paramInt1 == 1)
    {
      if (paramInt2 == -1)
      {
        if (paramIntent == null) {}
        for (Object localObject1 = null; (localObject1 == null) || (((String)localObject1).length() == 0); localObject1 = paramIntent.getStringExtra("Select_Conv_User"))
        {
          ab.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "mmOnActivityResult fail, toUser is null");
          AppMethodBeat.o(133047);
          return;
        }
        ab.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "result success toUser : %s ", new Object[] { localObject1 });
        paramIntent = paramIntent.getStringExtra("custom_send_text");
        String str1 = this.iOl.appId;
        Object localObject2 = com.tencent.mm.model.v.oQ("wxapp_".concat(String.valueOf(str1)));
        com.tencent.mm.model.v.aae().z((String)localObject2, true).i("prePublishId", "wxapp_".concat(String.valueOf(str1)));
        localObject2 = new j.b();
        ((j.b)localObject2).title = this.iOl.nickname;
        ((j.b)localObject2).type = 33;
        ((j.b)localObject2).fiX = AppBrandProfileUI.d(this.iOj);
        ((j.b)localObject2).fiY = str1;
        ((j.b)localObject2).fiZ = 1;
        ((j.b)localObject2).cGT = "wxapp_".concat(String.valueOf(str1));
        ((j.b)localObject2).thumburl = this.iOl.hkq;
        ((j.b)localObject2).url = com.tencent.mm.plugin.appbrand.v.yg(str1);
        ((j.b)localObject2).cGN = AppBrandProfileUI.d(this.iOj);
        ((j.b)localObject2).cGO = this.iOl.nickname;
        localObject1 = bo.P(((String)localObject1).split(",")).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          String str2 = (String)((Iterator)localObject1).next();
          ((com.tencent.mm.plugin.appbrand.compat.a.a)g.E(com.tencent.mm.plugin.appbrand.compat.a.a.class)).a((j.b)localObject2, str1, this.iOl.nickname, str2, null);
          if (!bo.isNullOrNil(paramIntent))
          {
            qj localqj = new qj();
            localqj.cGX.cGY = str2;
            localqj.cGX.content = paramIntent;
            localqj.cGX.type = t.oF(str2);
            localqj.cGX.flags = 0;
            com.tencent.mm.sdk.b.a.ymk.l(localqj);
          }
          if (str2.endsWith("@chatroom")) {}
          for (paramInt1 = 9;; paramInt1 = 8)
          {
            AppBrandProfileUI.a(this.iOj, paramInt1, bo.aox());
            break;
          }
        }
        h.bO(this.val$view.getContext(), this.val$view.getContext().getResources().getString(2131297076));
        AppMethodBeat.o(133047);
      }
    }
    else {
      AppBrandProfileUI.a(this.iOj, 8, 2);
    }
    AppMethodBeat.o(133047);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.23
 * JD-Core Version:    0.7.0.1
 */
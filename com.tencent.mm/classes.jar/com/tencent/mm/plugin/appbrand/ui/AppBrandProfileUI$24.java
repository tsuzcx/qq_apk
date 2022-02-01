package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ah.w;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.g.a.sy;
import com.tencent.mm.model.x;
import com.tencent.mm.model.z;
import com.tencent.mm.model.z.b;
import com.tencent.mm.plugin.appbrand.config.ab;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.h;
import java.util.Iterator;
import java.util.List;

final class AppBrandProfileUI$24
  implements MMActivity.a
{
  AppBrandProfileUI$24(AppBrandProfileUI paramAppBrandProfileUI, ab paramab, View paramView) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(48730);
    if (paramInt1 == 1)
    {
      if (paramInt2 == -1)
      {
        if (paramIntent == null) {}
        for (Object localObject1 = null; (localObject1 == null) || (((String)localObject1).length() == 0); localObject1 = paramIntent.getStringExtra("Select_Conv_User"))
        {
          ae.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "mmOnActivityResult fail, toUser is null");
          AppMethodBeat.o(48730);
          return;
        }
        ae.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "result success toUser : %s ", new Object[] { localObject1 });
        paramIntent = paramIntent.getStringExtra("custom_send_text");
        String str = this.mJf.appId;
        Object localObject2 = z.Br("wxapp_".concat(String.valueOf(str)));
        z.aBG().F((String)localObject2, true).k("prePublishId", "wxapp_".concat(String.valueOf(str)));
        localObject2 = new k.b();
        ((k.b)localObject2).title = this.mJf.nickname;
        ((k.b)localObject2).type = 33;
        ((k.b)localObject2).hFc = AppBrandProfileUI.d(this.mJd);
        ((k.b)localObject2).hFd = str;
        ((k.b)localObject2).hFe = 1;
        ((k.b)localObject2).dIz = "wxapp_".concat(String.valueOf(str));
        ((k.b)localObject2).thumburl = this.mJf.duL;
        ((k.b)localObject2).url = v.Lj(str);
        ((k.b)localObject2).dIt = AppBrandProfileUI.d(this.mJd);
        ((k.b)localObject2).dIu = this.mJf.nickname;
        Object localObject3 = new com.tencent.mm.ah.a();
        ((com.tencent.mm.ah.a)localObject3).hAV = this.mJf.kaX;
        ((k.b)localObject2).a((f)localObject3);
        localObject1 = bu.U(((String)localObject1).split(",")).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject3 = (String)((Iterator)localObject1).next();
          w.a.azs().a((k.b)localObject2, str, this.mJf.nickname, (String)localObject3, null, null);
          if (!bu.isNullOrNil(paramIntent))
          {
            sy localsy = new sy();
            localsy.dID.cUB = ((String)localObject3);
            localsy.dID.content = paramIntent;
            localsy.dID.type = x.Bb((String)localObject3);
            localsy.dID.flags = 0;
            com.tencent.mm.sdk.b.a.IvT.l(localsy);
          }
          if (((String)localObject3).endsWith("@chatroom")) {}
          for (paramInt1 = 9;; paramInt1 = 8)
          {
            AppBrandProfileUI.a(this.mJd, paramInt1, bu.aRi());
            break;
          }
        }
        h.cm(this.val$view.getContext(), this.val$view.getContext().getResources().getString(2131755894));
        AppMethodBeat.o(48730);
      }
    }
    else {
      AppBrandProfileUI.a(this.mJd, 8, 2);
    }
    AppMethodBeat.o(48730);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.24
 * JD-Core Version:    0.7.0.1
 */
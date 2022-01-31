package com.tencent.mm.plugin.appbrand.ui;

import android.os.HandlerThread;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.plugin.appbrand.config.s;
import com.tencent.mm.plugin.appbrand.config.u;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.d;
import com.tencent.mm.ui.MMActivity;
import java.util.Map;

final class AppBrandProfileUI$6
  implements Runnable
{
  AppBrandProfileUI$6(AppBrandProfileUI paramAppBrandProfileUI, boolean paramBoolean) {}
  
  public final void run()
  {
    Object localObject = r.sq(AppBrandProfileUI.b(this.hdE));
    ai.d(new Runnable()
    {
      public final void run()
      {
        AppBrandProfileUI.a(AppBrandProfileUI.6.this.hdE, this.hdF, this.hdI);
        if ((AppBrandProfileUI.6.this.hdH) && (!AppBrandProfileUI.6.this.hdE.isFinishing()) && (!AppBrandProfileUI.6.this.hdE.uMr)) {
          r.aem().a(AppBrandProfileUI.6.this.hdE, com.tencent.mm.plugin.appbrand.v.c.DS().mnU.getLooper());
        }
      }
    });
    String str;
    label85:
    AppBrandProfileUI localAppBrandProfileUI;
    if (this.hdH)
    {
      s.sE(AppBrandProfileUI.b(this.hdE));
      AppBrandProfileUI.a(this.hdE, 1, 1);
      if (localObject != null)
      {
        if (((u)localObject).bFB != 4) {
          break label136;
        }
        str = "openWAGameContactDev";
        if (((u)localObject).bFB != 4) {
          break label142;
        }
        localObject = "100409";
        localObject = com.tencent.mm.model.c.c.IX().fJ((String)localObject);
        localAppBrandProfileUI = this.hdE;
        if ((!((com.tencent.mm.storage.c)localObject).isValid()) || (bk.getInt((String)((com.tencent.mm.storage.c)localObject).ctr().get(str), 0) <= 0)) {
          break label148;
        }
      }
    }
    label136:
    label142:
    label148:
    for (boolean bool = true;; bool = false)
    {
      AppBrandProfileUI.a(localAppBrandProfileUI, bool);
      return;
      str = "openContactDev";
      break;
      localObject = "100401";
      break label85;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.6
 * JD-Core Version:    0.7.0.1
 */
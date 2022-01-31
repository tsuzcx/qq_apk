package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.mm.protocal.c.ep;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;
import java.util.Iterator;
import java.util.List;

final class AppBrandAuthorizeUI$8
  implements Runnable
{
  AppBrandAuthorizeUI$8(AppBrandAuthorizeUI paramAppBrandAuthorizeUI, List paramList) {}
  
  public final void run()
  {
    y.d("MicroMsg.AppBrandAuthorizeUI", "initAuthItem authItems.size = %d", new Object[] { Integer.valueOf(this.hcz.size()) });
    Iterator localIterator = this.hcz.iterator();
    if (localIterator.hasNext())
    {
      ep localep = (ep)localIterator.next();
      CheckBoxPreference localCheckBoxPreference = new CheckBoxPreference(this.hcu);
      localCheckBoxPreference.vdK = false;
      localCheckBoxPreference.setKey(localep.scope);
      localCheckBoxPreference.setTitle(localep.syf);
      if (localep.state == 1) {}
      for (boolean bool = true;; bool = false)
      {
        localCheckBoxPreference.rHo = bool;
        this.hcu.hcp.a(localCheckBoxPreference);
        break;
      }
    }
    this.hcu.hcp.notifyDataSetChanged();
    y.d("MicroMsg.AppBrandAuthorizeUI", "initAuthItem finish");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.8
 * JD-Core Version:    0.7.0.1
 */
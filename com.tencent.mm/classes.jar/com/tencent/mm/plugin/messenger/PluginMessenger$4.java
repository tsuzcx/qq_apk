package com.tencent.mm.plugin.messenger;

import android.content.Context;
import com.tencent.mm.h.b.a.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.e.d;

final class PluginMessenger$4
  implements e.d
{
  PluginMessenger$4(PluginMessenger paramPluginMessenger, String paramString1, String paramString2, String paramString3, String paramString4, Context paramContext) {}
  
  public final void b(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (ad.aaU(this.egy)))
    {
      paramString = new o();
      paramString.cja = this.eGV;
      paramString.cjc = 1L;
      paramString.cjb = this.gPG;
      paramString.cjd = 1L;
      paramString.cjf = 2L;
      paramString.QX();
      PluginMessenger.access$202(this.mci, new com.tencent.mm.openim.b.p(this.egy, this.ksz));
      PluginMessenger.access$200(this.mci).eQa = this.gPG;
      g.Dk().a(PluginMessenger.access$200(this.mci), 0);
      paramString = this.mci;
      Context localContext = this.val$context;
      this.val$context.getString(b.c.app_tip);
      PluginMessenger.access$302(paramString, h.b(localContext, this.val$context.getString(b.c.openim_switch_user_verify), true, new PluginMessenger.4.1(this)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.PluginMessenger.4
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.messenger;

import android.os.Bundle;
import android.view.View;
import com.tencent.mm.h.b.a.o;
import com.tencent.mm.plugin.messenger.a.a;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.Map;

final class PluginMessenger$6$1
  extends a
{
  PluginMessenger$6$1(PluginMessenger.6 param6, Bundle paramBundle, Map paramMap, String paramString) {}
  
  public final void onClickImp(View paramView)
  {
    try
    {
      paramView = this.dmH.getString("send_msg_username", "");
      String str = bk.aM((String)this.mcl.get(this.mcm + ".chatname"), "");
      o localo = new o();
      localo.cjb = paramView;
      localo.cjc = 2L;
      localo.cjd = 2L;
      localo.cjg = 1L;
      localo.QX();
      PluginMessenger.access$100(this.mco.mci, str);
      return;
    }
    catch (Throwable paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.PluginMessenger.6.1
 * JD-Core Version:    0.7.0.1
 */
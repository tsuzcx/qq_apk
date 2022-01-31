package com.tencent.mm.plugin.messenger;

import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.x;
import com.tencent.mm.plugin.messenger.a.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

final class PluginMessenger$7$1
  extends a
{
  PluginMessenger$7$1(PluginMessenger.7 param7, Bundle paramBundle, Map paramMap, String paramString) {}
  
  public final void onClickImp(View paramView)
  {
    AppMethodBeat.i(136883);
    try
    {
      paramView = this.val$params.getString("send_msg_username", "");
      String str = bo.bf((String)this.oCN.get(this.oCO + ".chatname"), "");
      x localx = new x();
      localx.ft(paramView);
      localx.cTL = 2L;
      localx.cTM = 2L;
      localx.cTP = 1L;
      localx.ake();
      PluginMessenger.access$100(this.oCQ.oCK, str);
      AppMethodBeat.o(136883);
      return;
    }
    catch (Throwable paramView)
    {
      AppMethodBeat.o(136883);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.PluginMessenger.7.1
 * JD-Core Version:    0.7.0.1
 */
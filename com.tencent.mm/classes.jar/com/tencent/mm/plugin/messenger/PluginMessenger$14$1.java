package com.tencent.mm.plugin.messenger;

import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.do;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.a;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.ref.WeakReference;
import java.util.Map;

final class PluginMessenger$14$1
  extends a
{
  PluginMessenger$14$1(PluginMessenger.14 param14, Bundle paramBundle, Map paramMap, String paramString, WeakReference paramWeakReference1, WeakReference paramWeakReference2) {}
  
  public final void onClickImp(View paramView)
  {
    AppMethodBeat.i(90713);
    try
    {
      paramView = this.val$params.getString("send_msg_username", "");
      String str = bt.bI((String)this.fKy.get(this.vIV + ".chatname"), "");
      do localdo = new do();
      localdo.mV(paramView);
      localdo.egJ = 2L;
      localdo.egK = 2L;
      localdo.egN = 1L;
      localdo.aLk();
      PluginMessenger.access$100(this.vIY.vIO, str);
      ((e)g.ab(e.class)).a("link_jump_chat", this.fKy, this.val$params);
      AppMethodBeat.o(90713);
      return;
    }
    catch (Throwable paramView)
    {
      AppMethodBeat.o(90713);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.PluginMessenger.14.1
 * JD-Core Version:    0.7.0.1
 */
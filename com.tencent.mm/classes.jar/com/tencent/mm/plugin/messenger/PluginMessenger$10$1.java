package com.tencent.mm.plugin.messenger;

import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.cv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.a;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.sdk.platformtools.bs;
import java.lang.ref.WeakReference;
import java.util.Map;

final class PluginMessenger$10$1
  extends a
{
  PluginMessenger$10$1(PluginMessenger.10 param10, Bundle paramBundle, Map paramMap, String paramString, WeakReference paramWeakReference1, WeakReference paramWeakReference2) {}
  
  public final void onClickImp(View paramView)
  {
    AppMethodBeat.i(90713);
    try
    {
      paramView = this.val$params.getString("send_msg_username", "");
      String str = bs.bG((String)this.frY.get(this.uFT + ".chatname"), "");
      cv localcv = new cv();
      localcv.kS(paramView);
      localcv.dRm = 2L;
      localcv.dRn = 2L;
      localcv.dRq = 1L;
      localcv.aHZ();
      PluginMessenger.access$100(this.uFV.uFM, str);
      ((f)g.ab(f.class)).a("link_jump_chat", this.frY, this.val$params);
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
 * Qualified Name:     com.tencent.mm.plugin.messenger.PluginMessenger.10.1
 * JD-Core Version:    0.7.0.1
 */
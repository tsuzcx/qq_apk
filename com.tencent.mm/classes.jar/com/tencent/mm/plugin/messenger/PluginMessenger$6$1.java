package com.tencent.mm.plugin.messenger;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.api.LiveConfig.a;
import java.lang.ref.WeakReference;

final class PluginMessenger$6$1
  extends com.tencent.mm.plugin.messenger.a.a
{
  PluginMessenger$6$1(PluginMessenger.6 param6, WeakReference paramWeakReference, String paramString1, String paramString2, long paramLong) {}
  
  public final void onClickImp(View paramView)
  {
    AppMethodBeat.i(211825);
    try
    {
      if (this.fKx.get() != null)
      {
        paramView = new LiveConfig.a();
        paramView.gGx = LiveConfig.gGt;
        paramView.gGz = this.vIP;
        paramView.gGC = this.vIQ;
        paramView.gGy = this.vIR;
        paramView.scene = LiveConfig.gGp;
        paramView = paramView.alb();
        ((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).liveEntranceJumper().d((Context)this.fKx.get(), paramView);
      }
      AppMethodBeat.o(211825);
      return;
    }
    catch (Throwable paramView)
    {
      AppMethodBeat.o(211825);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.PluginMessenger.6.1
 * JD-Core Version:    0.7.0.1
 */
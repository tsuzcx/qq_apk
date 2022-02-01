package com.tencent.mm.plugin.messenger;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.api.LiveConfig.a;
import java.lang.ref.WeakReference;

final class PluginMessenger$4$1
  extends com.tencent.mm.plugin.messenger.a.a
{
  PluginMessenger$4$1(PluginMessenger.4 param4, WeakReference paramWeakReference, String paramString1, String paramString2, long paramLong) {}
  
  public final void onClickImp(View paramView)
  {
    AppMethodBeat.i(198559);
    try
    {
      if (this.frX.get() != null)
      {
        paramView = new LiveConfig.a();
        paramView.gmO = LiveConfig.gmK;
        paramView.gmQ = this.uFN;
        paramView.gmT = this.uFO;
        paramView.gmP = this.uFP;
        paramView.scene = LiveConfig.gmG;
        paramView = paramView.aip();
        ((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).liveEntranceJumper().d((Context)this.frX.get(), paramView);
      }
      AppMethodBeat.o(198559);
      return;
    }
    catch (Throwable paramView)
    {
      AppMethodBeat.o(198559);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.PluginMessenger.4.1
 * JD-Core Version:    0.7.0.1
 */
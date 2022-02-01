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
    AppMethodBeat.i(203899);
    try
    {
      if (this.foC.get() != null)
      {
        paramView = new LiveConfig.a();
        paramView.qsO = LiveConfig.qsK;
        paramView.qsP = this.Lmv;
        paramView.quk = this.Lmw;
        paramView.DlB = this.Lmx;
        paramView.scene = LiveConfig.qsE;
        paramView = paramView.cld();
        ((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).liveEntranceJumper().d((Context)this.foC.get(), paramView);
      }
      AppMethodBeat.o(203899);
      return;
    }
    catch (Throwable paramView)
    {
      AppMethodBeat.o(203899);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.PluginMessenger.4.1
 * JD-Core Version:    0.7.0.1
 */
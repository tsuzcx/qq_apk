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
    AppMethodBeat.i(194463);
    try
    {
      if (this.grM.get() != null)
      {
        paramView = new LiveConfig.a();
        paramView.hvZ = LiveConfig.hvV;
        paramView.hwa = this.zoZ;
        paramView.hwd = this.zpa;
        paramView.liveId = this.zpb;
        paramView.scene = LiveConfig.hvR;
        paramView = paramView.aBR();
        ((com.tencent.mm.live.a)g.ah(com.tencent.mm.live.a.class)).liveEntranceJumper().d((Context)this.grM.get(), paramView);
      }
      AppMethodBeat.o(194463);
      return;
    }
    catch (Throwable paramView)
    {
      AppMethodBeat.o(194463);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.PluginMessenger.6.1
 * JD-Core Version:    0.7.0.1
 */
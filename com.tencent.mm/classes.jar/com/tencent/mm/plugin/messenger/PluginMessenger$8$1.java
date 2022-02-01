package com.tencent.mm.plugin.messenger;

import android.view.View;
import com.tencent.c.a.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.findersdk.a.ag;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.messenger.a.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class PluginMessenger$8$1
  extends a
{
  PluginMessenger$8$1(PluginMessenger.8 param8, Long paramLong1, Long paramLong2, String paramString1, String paramString2)
  {
    super(5, null);
  }
  
  public final void onClickImp(View paramView)
  {
    AppMethodBeat.i(213538);
    ((ak)h.ag(ak.class)).report21053OnClick(this.EUv.longValue(), this.EUw.longValue(), "", -1, -1, -1L, "temp_17", -1, -1, "", "", System.currentTimeMillis(), -1);
    ((b)h.ag(b.class)).enterFinderLiveVisitorUI(null, MMApplicationContext.getContext(), this.EUv.longValue(), this.EUw, "", this.EUx, "", "", "", this.EUy, 0, "", 1, ((ak)h.ag(ak.class)).getFinderUtilApi().eeK());
    AppMethodBeat.o(213538);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.PluginMessenger.8.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.luggage.xweb_ext.extendplugin.component.a.a;

import android.os.Bundle;
import com.tencent.luggage.xweb_ext.extendplugin.component.a.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.ITXLivePlayListener;

final class a$1
  implements ITXLivePlayListener
{
  a$1(a parama) {}
  
  public final void onNetStatus(Bundle paramBundle)
  {
    AppMethodBeat.i(139754);
    if (this.bGg.xt()) {
      this.bGg.bFX.c(this.bGg.getId(), paramBundle);
    }
    AppMethodBeat.o(139754);
  }
  
  public final void onPlayEvent(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(139753);
    if (this.bGg.xt()) {
      this.bGg.bFX.a(this.bGg.getId(), paramInt, paramBundle);
    }
    AppMethodBeat.o(139753);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.a.a.a.1
 * JD-Core Version:    0.7.0.1
 */
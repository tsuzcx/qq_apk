package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import com.tencent.luggage.xweb_ext.extendplugin.component.video.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class a$6
  implements Runnable
{
  a$6(a parama, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(139849);
    if (((this.bHS == 2) && (!this.bHR.bGf)) || ((this.bHS == 1) && (!this.bHR.bGe)))
    {
      ab.i(this.bHR.xo(), "handleWebViewBackground runnable, video not auto pause");
      AppMethodBeat.o(139849);
      return;
    }
    if ((this.bHR.bHu != null) && (this.bHR.bHG))
    {
      this.bHR.bHD = this.bHR.bHu.isPlaying();
      ab.i(this.bHR.xo(), "handleWebViewBackground runnable, video playing state when enter background:%s", new Object[] { Boolean.valueOf(this.bHR.bHD) });
      this.bHR.pause();
    }
    AppMethodBeat.o(139849);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.a.6
 * JD-Core Version:    0.7.0.1
 */
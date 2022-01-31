package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import com.tencent.luggage.xweb_ext.extendplugin.component.video.a.c;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.b.b.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class a$2
  implements b.g
{
  a$2(a parama) {}
  
  public final void bI(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(154410);
    a locala = this.bHR;
    if (!locala.bHH)
    {
      ab.i(locala.xo(), "onMediaPlayerVideoSizeChanged, mp released");
      AppMethodBeat.o(154410);
      return;
    }
    ab.i(locala.xo(), "onVideoSizeChanged, width:%d, height:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    locala.xB();
    int i = locala.getDuration();
    if ((locala.bHG) && (locala.bHu != null) && ((paramInt1 != locala.mVideoWidth) || (paramInt2 != locala.mVideoHeight) || (i != locala.bHK)) && (locala.xt())) {
      locala.bHv.B(paramInt1, paramInt2, i);
    }
    locala.mVideoWidth = paramInt1;
    locala.mVideoHeight = paramInt2;
    locala.bHK = i;
    AppMethodBeat.o(154410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.a.2
 * JD-Core Version:    0.7.0.1
 */
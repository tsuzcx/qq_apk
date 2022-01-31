package com.tencent.luggage.xweb_ext.extendplugin.component.a.a;

import android.os.Bundle;
import com.tencent.luggage.xweb_ext.extendplugin.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayer;

final class a$2
  implements a.a
{
  a$2(a parama) {}
  
  public final void fx(int paramInt)
  {
    AppMethodBeat.i(154387);
    a locala = this.bGg;
    ab.i(locala.xo(), "*** handler(%s) handleWebViewBackground, type:%d", new Object[] { locala.tX(), Integer.valueOf(paramInt) });
    if (((paramInt == 2) && (!locala.bGf)) || ((paramInt == 1) && (!locala.bGe)))
    {
      ab.i(locala.xo(), "handleWebViewBackground, live player not auto pause");
      AppMethodBeat.o(154387);
      return;
    }
    if (locala.bFV != null)
    {
      localObject = locala.bFV;
      ((b)localObject).bGp = ((b)localObject).bGk.isPlaying();
      if (!((b)localObject).bGp) {
        break label175;
      }
      if (((b)localObject).bGl != null) {
        ((b)localObject).bGl.onPlayEvent(6000, new Bundle());
      }
    }
    label175:
    for (Object localObject = ((b)localObject).cl("pause");; localObject = new com.tencent.luggage.xweb_ext.extendplugin.component.a.a())
    {
      ab.i(locala.xo(), "handleWebViewBackground, code:%d info:%s", new Object[] { Integer.valueOf(((com.tencent.luggage.xweb_ext.extendplugin.component.a.a)localObject).errorCode), ((com.tencent.luggage.xweb_ext.extendplugin.component.a.a)localObject).bFT });
      AppMethodBeat.o(154387);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(154388);
    a locala = this.bGg;
    ab.i(locala.xo(), "*** handler(%s) handleWebViewDestroy", new Object[] { locala.tX() });
    locala.release();
    AppMethodBeat.o(154388);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(154386);
    a locala = this.bGg;
    ab.i(locala.xo(), "*** handler(%s) handleWebViewForeground", new Object[] { locala.tX() });
    if (locala.bFV != null)
    {
      localObject = locala.bFV;
      if (!((b)localObject).bGp) {
        break label92;
      }
    }
    label92:
    for (Object localObject = ((b)localObject).cl("resume");; localObject = new com.tencent.luggage.xweb_ext.extendplugin.component.a.a())
    {
      ab.i(locala.xo(), "handleWebViewForeground, code:%d info:%s", new Object[] { Integer.valueOf(((com.tencent.luggage.xweb_ext.extendplugin.component.a.a)localObject).errorCode), ((com.tencent.luggage.xweb_ext.extendplugin.component.a.a)localObject).bFT });
      AppMethodBeat.o(154386);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.a.a.a.2
 * JD-Core Version:    0.7.0.1
 */
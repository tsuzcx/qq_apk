package com.tencent.mm.plugin.game.luggage.d;

import android.os.Bundle;
import com.tencent.luggage.d.g;
import com.tencent.luggage.d.k;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.d.a;
import com.tencent.mm.plugin.webview.luggage.i;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
  extends f
{
  public b(g paramg, Bundle paramBundle)
  {
    super(paramg, null, paramBundle);
    AppMethodBeat.i(83122);
    cMm();
    ekT();
    Bn();
    AppMethodBeat.o(83122);
  }
  
  public final boolean bEZ()
  {
    return false;
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(83124);
    ad.i("MicroMsg.GameInsertWebPage", "onBackground");
    Sz("onPause");
    this.ASU.onPause();
    AppMethodBeat.o(83124);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(83125);
    if (!this.ATv)
    {
      this.ATv = true;
      ad.i("MicroMsg.GameInsertWebPage", "onDestroy");
      Sz("onDestroy");
      this.ATg.ASM = null;
      i.c(this);
      this.ATm.AKM = true;
      this.caI.destroy();
    }
    AppMethodBeat.o(83125);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(83123);
    ad.i("MicroMsg.GameInsertWebPage", "onForeground");
    Sz("onResume");
    this.ASU.onResume();
    AppMethodBeat.o(83123);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.b
 * JD-Core Version:    0.7.0.1
 */
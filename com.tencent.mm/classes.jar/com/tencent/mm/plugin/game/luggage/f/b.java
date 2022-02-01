package com.tencent.mm.plugin.game.luggage.f;

import android.os.Bundle;
import com.tencent.luggage.d.p;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.d.a;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
  extends g
{
  public b(com.tencent.luggage.d.j paramj, Bundle paramBundle)
  {
    super(paramj, null, paramBundle);
    AppMethodBeat.i(83122);
    djf();
    ePf();
    Cq();
    AppMethodBeat.o(83122);
  }
  
  public final boolean bQO()
  {
    return false;
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(83124);
    ad.i("MicroMsg.GameInsertWebPage", "onBackground");
    aas("onPause");
    this.DOt.onPause();
    AppMethodBeat.o(83124);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(83125);
    if (!this.tWp)
    {
      this.tWp = true;
      ad.i("MicroMsg.GameInsertWebPage", "onDestroy");
      aas("onDestroy");
      this.DOE.DOl = null;
      com.tencent.mm.plugin.webview.luggage.j.c(this);
      this.DOK.DGd = true;
      this.chX.destroy();
    }
    AppMethodBeat.o(83125);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(83123);
    ad.i("MicroMsg.GameInsertWebPage", "onForeground");
    aas("onResume");
    this.DOt.onResume();
    AppMethodBeat.o(83123);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.f.b
 * JD-Core Version:    0.7.0.1
 */
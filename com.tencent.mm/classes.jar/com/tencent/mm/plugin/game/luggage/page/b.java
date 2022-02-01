package com.tencent.mm.plugin.game.luggage.page;

import android.os.Bundle;
import com.tencent.luggage.d.j;
import com.tencent.luggage.d.p;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.d.a;
import com.tencent.mm.plugin.webview.luggage.k;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends GameWebPage
{
  public b(j paramj, Bundle paramBundle)
  {
    super(paramj, null, paramBundle);
    AppMethodBeat.i(83122);
    hideActionBar();
    iug();
    aoJ();
    AppMethodBeat.o(83122);
  }
  
  public final boolean dhz()
  {
    return false;
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(83124);
    Log.i("MicroMsg.GameInsertWebPage", "onBackground");
    bjV("onPause");
    this.WFO.onPause();
    AppMethodBeat.o(83124);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(83125);
    if (!this.IxR)
    {
      this.IxR = true;
      Log.i("MicroMsg.GameInsertWebPage", "onDestroy");
      bjV("onDestroy");
      this.WFZ.WFG = null;
      k.c(this);
      this.WGg.WwD = true;
      this.ejR.destroy();
    }
    AppMethodBeat.o(83125);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(83123);
    Log.i("MicroMsg.GameInsertWebPage", "onForeground");
    bjV("onResume");
    this.WFO.onResume();
    AppMethodBeat.o(83123);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.page.b
 * JD-Core Version:    0.7.0.1
 */
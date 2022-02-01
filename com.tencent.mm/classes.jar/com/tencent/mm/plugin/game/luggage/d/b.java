package com.tencent.mm.plugin.game.luggage.d;

import android.os.Bundle;
import com.tencent.luggage.d.g;
import com.tencent.luggage.d.k;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.d.a;
import com.tencent.mm.plugin.webview.luggage.i;
import com.tencent.mm.sdk.platformtools.ac;

public final class b
  extends f
{
  public b(g paramg, Bundle paramBundle)
  {
    super(paramg, null, paramBundle);
    AppMethodBeat.i(83122);
    cZS();
    eAp();
    AR();
    AppMethodBeat.o(83122);
  }
  
  public final boolean bMn()
  {
    return false;
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(83124);
    ac.i("MicroMsg.GameInsertWebPage", "onBackground");
    WL("onPause");
    this.Clh.onPause();
    AppMethodBeat.o(83124);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(83125);
    if (!this.ClI)
    {
      this.ClI = true;
      ac.i("MicroMsg.GameInsertWebPage", "onDestroy");
      WL("onDestroy");
      this.Clt.CkZ = null;
      i.c(this);
      this.Clz.Cdd = true;
      this.bXF.destroy();
    }
    AppMethodBeat.o(83125);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(83123);
    ac.i("MicroMsg.GameInsertWebPage", "onForeground");
    WL("onResume");
    this.Clh.onResume();
    AppMethodBeat.o(83123);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.b
 * JD-Core Version:    0.7.0.1
 */
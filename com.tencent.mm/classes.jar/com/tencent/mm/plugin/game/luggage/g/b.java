package com.tencent.mm.plugin.game.luggage.g;

import android.os.Bundle;
import com.tencent.luggage.d.p;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.webview_impl.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends i
{
  public b(com.tencent.luggage.d.j paramj, Bundle paramBundle)
  {
    super(paramj, null, paramBundle);
    AppMethodBeat.i(83122);
    ega();
    gbD();
    LK();
    AppMethodBeat.o(83122);
  }
  
  public final boolean cpz()
  {
    return false;
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(83124);
    Log.i("MicroMsg.GameInsertWebPage", "onBackground");
    aYq("onPause");
    this.ITd.onPause();
    AppMethodBeat.o(83124);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(83125);
    if (!this.xzH)
    {
      this.xzH = true;
      Log.i("MicroMsg.GameInsertWebPage", "onDestroy");
      aYq("onDestroy");
      this.ITo.ISU = null;
      com.tencent.mm.plugin.webview.luggage.j.c(this);
      this.ITv.IJS = true;
      this.ctS.destroy();
    }
    AppMethodBeat.o(83125);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(83123);
    Log.i("MicroMsg.GameInsertWebPage", "onForeground");
    aYq("onResume");
    this.ITd.onResume();
    AppMethodBeat.o(83123);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.g.b
 * JD-Core Version:    0.7.0.1
 */
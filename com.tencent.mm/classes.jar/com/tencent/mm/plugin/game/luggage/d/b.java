package com.tencent.mm.plugin.game.luggage.d;

import android.os.Bundle;
import com.tencent.luggage.d.g;
import com.tencent.luggage.d.k;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.d.a;
import com.tencent.mm.plugin.webview.luggage.i;
import com.tencent.mm.plugin.webview.luggage.permission.LuggageGetA8Key;
import com.tencent.mm.sdk.platformtools.ab;

public final class b
  extends f
{
  public b(g paramg, Bundle paramBundle)
  {
    super(paramg, null, paramBundle);
    AppMethodBeat.i(154155);
    bNQ();
    daX();
    uy();
    AppMethodBeat.o(154155);
  }
  
  public final boolean aYi()
  {
    return false;
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(154157);
    ab.i("MicroMsg.GameInsertWebPage", "onBackground");
    JR("onPause");
    this.uRk.onPause();
    AppMethodBeat.o(154157);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(154158);
    if (!this.uRL)
    {
      this.uRL = true;
      ab.i("MicroMsg.GameInsertWebPage", "onDestroy");
      JR("onDestroy");
      this.uRw.uSb = null;
      i.c(this);
      this.uRC.destroy();
      this.bzs.destroy();
    }
    AppMethodBeat.o(154158);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(154156);
    ab.i("MicroMsg.GameInsertWebPage", "onForeground");
    JR("onResume");
    this.uRk.onResume();
    AppMethodBeat.o(154156);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.b
 * JD-Core Version:    0.7.0.1
 */
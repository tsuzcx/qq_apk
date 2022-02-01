package com.tencent.mm.plugin.lite.logic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.q.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends q.a
{
  public final void onAppBackground(String paramString) {}
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(271374);
    Log.d("MicroMsg.AppLite.LiteAppAppForegroundListener", "onAppForeground");
    AppMethodBeat.o(271374);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.logic.a
 * JD-Core Version:    0.7.0.1
 */
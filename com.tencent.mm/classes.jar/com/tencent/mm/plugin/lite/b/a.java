package com.tencent.mm.plugin.lite.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends o.a
{
  public final void onAppBackground(String paramString) {}
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(233824);
    Log.d("MicroMsg.AppLite.LiteAppAppForegroundListener", "onAppForeground");
    AppMethodBeat.o(233824);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.b.a
 * JD-Core Version:    0.7.0.1
 */
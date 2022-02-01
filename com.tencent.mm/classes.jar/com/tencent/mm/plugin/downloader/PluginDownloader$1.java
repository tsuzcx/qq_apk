package com.tencent.mm.plugin.downloader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.a.d;

final class PluginDownloader$1
  extends o.a
{
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(88822);
    if ((g.aAc()) && (g.aAf().hpY))
    {
      g.aAf();
      if (!a.azj()) {
        ((d)g.af(d.class)).kR(false);
      }
    }
    AppMethodBeat.o(88822);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(88821);
    if ((g.aAc()) && (g.aAf().hpY))
    {
      g.aAf();
      if (!a.azj()) {
        ((d)g.af(d.class)).kR(true);
      }
    }
    AppMethodBeat.o(88821);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.PluginDownloader.1
 * JD-Core Version:    0.7.0.1
 */
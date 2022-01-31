package com.tencent.mm.plugin.downloader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.j.a;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.a.d;

final class PluginDownloader$1
  extends j.a
{
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(141049);
    if ((g.RG()) && (g.RJ().eHg))
    {
      g.RJ();
      if (!a.QP()) {
        ((d)g.E(d.class)).gq(false);
      }
    }
    AppMethodBeat.o(141049);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(141048);
    if ((g.RG()) && (g.RJ().eHg))
    {
      g.RJ();
      if (!a.QP()) {
        ((d)g.E(d.class)).gq(true);
      }
    }
    AppMethodBeat.o(141048);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.PluginDownloader.1
 * JD-Core Version:    0.7.0.1
 */
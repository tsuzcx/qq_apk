package com.tencent.mm.plugin.fav.offline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.offline.PluginFavOffline;

public final class c
  implements ae
{
  public final void add(String paramString)
  {
    AppMethodBeat.i(73563);
    ((PluginFavOffline)g.ah(PluginFavOffline.class)).getFavOfflineService().add(paramString);
    AppMethodBeat.o(73563);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.offline.a.c
 * JD-Core Version:    0.7.0.1
 */
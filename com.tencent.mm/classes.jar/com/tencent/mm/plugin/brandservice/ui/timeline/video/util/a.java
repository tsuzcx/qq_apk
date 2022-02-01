package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.j;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.MMFileSlotManager;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizPlaylistFileMgr;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "playlistManager", "Lcom/tencent/mm/sdk/platformtools/MMFileSlotManager;", "getPlaylistManager", "()Lcom/tencent/mm/sdk/platformtools/MMFileSlotManager;", "isProxyOpen", "", "save", "", "url", "content", "plugin-brandservice_release"})
public final class a
{
  public static final String TAG = "MicroMsg.BizPlaylistFileMgr";
  public static final MMFileSlotManager pKj;
  public static final a pKk;
  
  static
  {
    AppMethodBeat.i(175529);
    pKk = new a();
    TAG = "MicroMsg.BizPlaylistFileMgr";
    pKj = new MMFileSlotManager("bizplaylist", 86400L);
    AppMethodBeat.o(175529);
  }
  
  public static boolean cqV()
  {
    AppMethodBeat.i(175528);
    if ((j.bJE().bJG()) && (((b)g.af(b.class)).a(b.a.rTX, 0) == 1))
    {
      AppMethodBeat.o(175528);
      return true;
    }
    AppMethodBeat.o(175528);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.a
 * JD-Core Version:    0.7.0.1
 */
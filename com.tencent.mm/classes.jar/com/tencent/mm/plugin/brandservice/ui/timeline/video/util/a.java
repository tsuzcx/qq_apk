package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.n;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.an;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizPlaylistFileMgr;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "playlistManager", "Lcom/tencent/mm/sdk/platformtools/MMFileSlotManager;", "getPlaylistManager", "()Lcom/tencent/mm/sdk/platformtools/MMFileSlotManager;", "isProxyOpen", "", "save", "", "url", "content", "plugin-brandservice_release"})
public final class a
{
  public static final String TAG = "MicroMsg.BizPlaylistFileMgr";
  public static final an nND;
  public static final a nNE;
  
  static
  {
    AppMethodBeat.i(175529);
    nNE = new a();
    TAG = "MicroMsg.BizPlaylistFileMgr";
    nND = new an("bizplaylist", 86400L);
    AppMethodBeat.o(175529);
  }
  
  public static boolean bNy()
  {
    AppMethodBeat.i(175528);
    if ((n.bjG().bjI()) && (((b)g.ab(b.class)).a(b.a.pQk, 0) == 1))
    {
      AppMethodBeat.o(175528);
      return true;
    }
    AppMethodBeat.o(175528);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.a
 * JD-Core Version:    0.7.0.1
 */
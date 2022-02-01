package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.j;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ao;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizPlaylistFileMgr;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "playlistManager", "Lcom/tencent/mm/sdk/platformtools/MMFileSlotManager;", "getPlaylistManager", "()Lcom/tencent/mm/sdk/platformtools/MMFileSlotManager;", "isProxyOpen", "", "save", "", "url", "content", "plugin-brandservice_release"})
public final class a
{
  public static final String TAG = "MicroMsg.BizPlaylistFileMgr";
  public static final ao nkD;
  public static final a nkE;
  
  static
  {
    AppMethodBeat.i(175529);
    nkE = new a();
    TAG = "MicroMsg.BizPlaylistFileMgr";
    nkD = new ao("bizplaylist", 86400L);
    AppMethodBeat.o(175529);
  }
  
  public static boolean bGl()
  {
    AppMethodBeat.i(175528);
    if ((j.bcK().bcM()) && (((b)g.ab(b.class)).a(b.a.pmK, 0) == 1))
    {
      AppMethodBeat.o(175528);
      return true;
    }
    AppMethodBeat.o(175528);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.a
 * JD-Core Version:    0.7.0.1
 */
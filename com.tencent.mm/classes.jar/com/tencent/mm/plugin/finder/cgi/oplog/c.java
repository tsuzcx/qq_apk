package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.bx;
import com.tencent.mm.plugin.finder.cgi.bx.a;
import com.tencent.mm.plugin.i.a.u;
import com.tencent.mm.protocal.protobuf.ayx;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModFeedReproduce;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderModifyFeedReproduce;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedReproduction;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "cmdBufItem", "getCmdId", "", "handleUpdateResult", "", "retCode", "modifyFeedReproduce", "ifOpen", "", "plugin-finder_release"})
public final class c
  extends k<ayx>
  implements u
{
  private final String TAG = "Finder.FinderModFeedReproduce";
  
  public final int getCmdId()
  {
    AppMethodBeat.i(242645);
    bx.a locala = bx.tvW;
    int i = bx.cYU();
    AppMethodBeat.o(242645);
    return i;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void mP(boolean paramBoolean)
  {
    AppMethodBeat.i(242647);
    ayx localayx = new ayx();
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      localayx.LIU = i;
      a(localayx, null, false);
      AppMethodBeat.o(242647);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.c
 * JD-Core Version:    0.7.0.1
 */
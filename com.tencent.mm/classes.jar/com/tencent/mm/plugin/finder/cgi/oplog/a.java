package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.au;
import com.tencent.mm.plugin.finder.cgi.au.a;
import com.tencent.mm.plugin.i.a.k;
import com.tencent.mm.protocal.protobuf.apz;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModFeedReproduce;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderModifyFeedReproduce;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedReproduction;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "cmdBufItem", "getCmdId", "", "handleUpdateResult", "", "retCode", "modifyFeedReproduce", "ifOpen", "", "plugin-finder_release"})
public final class a
  extends h<apz>
  implements k
{
  private final String TAG = "Finder.FinderModFeedReproduce";
  
  public final int getCmdId()
  {
    AppMethodBeat.i(201660);
    au.a locala = au.rRY;
    int i = au.cAg();
    AppMethodBeat.o(201660);
    return i;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void lK(boolean paramBoolean)
  {
    AppMethodBeat.i(201662);
    apz localapz = new apz();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localapz.GGZ = i;
      a(localapz, null);
      AppMethodBeat.o(201662);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.a
 * JD-Core Version:    0.7.0.1
 */
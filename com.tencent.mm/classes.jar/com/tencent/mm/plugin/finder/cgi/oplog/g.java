package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.ca;
import com.tencent.mm.plugin.finder.cgi.ca.a;
import com.tencent.mm.plugin.finder.service.j;
import com.tencent.mm.plugin.findersdk.a.aj;
import com.tencent.mm.protocal.protobuf.bfa;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModProfileSticky;", "Lcom/tencent/mm/plugin/finder/service/IFinderModProfileSticky;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModProfileStickySetting;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "cmdBufItem", "getCmdId", "", "handleUpdateResult", "", "retCode", "modifyStickyFeed", "feedId", "", "opType", "nonceId", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Companion", "plugin-finder_release"})
public final class g
  extends m<bfa>
  implements j
{
  public static final a xfK;
  private final String TAG = "Finder.FinderModProfileStickySetting";
  
  static
  {
    AppMethodBeat.i(270974);
    xfK = new a((byte)0);
    AppMethodBeat.o(270974);
  }
  
  public final void a(long paramLong, int paramInt, String paramString, aj<bfa> paramaj)
  {
    AppMethodBeat.i(270970);
    p.k(paramString, "nonceId");
    bfa localbfa = new bfa();
    localbfa.SPH = paramLong;
    localbfa.fSo = paramInt;
    localbfa.objectNonceId = paramString;
    m.a(this, localbfa, paramaj);
    AppMethodBeat.o(270970);
  }
  
  public final int getCmdId()
  {
    AppMethodBeat.i(270968);
    ca.a locala = ca.xdJ;
    int i = ca.doL();
    AppMethodBeat.o(270968);
    return i;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModProfileSticky$Companion;", "", "()V", "PROFILE_STICK_EVENT_TYPE", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.g
 * JD-Core Version:    0.7.0.1
 */
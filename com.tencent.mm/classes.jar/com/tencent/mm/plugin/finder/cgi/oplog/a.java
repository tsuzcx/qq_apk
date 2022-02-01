package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.bx;
import com.tencent.mm.plugin.finder.cgi.bx.a;
import com.tencent.mm.plugin.i.a.ai;
import com.tencent.mm.plugin.i.a.o;
import com.tencent.mm.protocal.protobuf.bbm;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderDelFansService;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderDelFansService;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderRemoveFansSetting;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "cmdBufItem", "delFans", "", "fansId", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "getCmdId", "", "handleUpdateResult", "retCode", "plugin-finder_release"})
public final class a
  extends k<bbm>
  implements o
{
  private final String TAG = "Finder.FinderDelFansService";
  
  public final void a(String paramString, ai<bbm> paramai)
  {
    AppMethodBeat.i(242639);
    p.h(paramString, "fansId");
    bbm localbbm = new bbm();
    localbbm.LKT = paramString;
    a(localbbm, paramai, false);
    AppMethodBeat.o(242639);
  }
  
  public final int getCmdId()
  {
    AppMethodBeat.i(242637);
    bx.a locala = bx.tvW;
    int i = bx.cYY();
    AppMethodBeat.o(242637);
    return i;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.a
 * JD-Core Version:    0.7.0.1
 */
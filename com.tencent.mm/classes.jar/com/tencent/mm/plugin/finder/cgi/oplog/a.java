package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.ca;
import com.tencent.mm.plugin.finder.cgi.ca.a;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderAgreeSavePhone;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderAgreeSavePhoneService;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "", "()V", "TAG", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "cmdBufItem", "getCmdId", "", "handleUpdateResult", "", "retCode", "modOverSeaAgreeSavePhone", "isReset", "", "(Ljava/lang/Boolean;)V", "plugin-finder_release"})
public final class a
  extends m<String>
  implements com.tencent.mm.plugin.findersdk.a.l
{
  private final String TAG = "Finder.FinderAgreeSavePhone";
  
  public final int getCmdId()
  {
    AppMethodBeat.i(244711);
    ca.a locala = ca.xdJ;
    int i = ca.doQ();
    AppMethodBeat.o(244711);
    return i;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void o(Boolean paramBoolean)
  {
    AppMethodBeat.i(244719);
    if (p.h(paramBoolean, Boolean.TRUE)) {}
    for (paramBoolean = "remove_allow_accept_phone";; paramBoolean = "")
    {
      m.a(this, paramBoolean, null);
      AppMethodBeat.o(244719);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.a
 * JD-Core Version:    0.7.0.1
 */
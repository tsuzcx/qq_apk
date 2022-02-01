package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.a.x;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderAgreeSavePhone;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderAgreeSavePhoneService;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "", "()V", "TAG", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "cmdBufItem", "getCmdId", "", "handleUpdateResult", "", "retCode", "modOverSeaAgreeSavePhone", "isReset", "", "(Ljava/lang/Boolean;)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends n<String>
  implements x
{
  private final String TAG = "Finder.FinderAgreeSavePhone";
  
  public final int getCmdId()
  {
    return 17;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void r(Boolean paramBoolean)
  {
    AppMethodBeat.i(336526);
    n localn = (n)this;
    if (s.p(paramBoolean, Boolean.TRUE)) {}
    for (paramBoolean = "remove_allow_accept_phone";; paramBoolean = "")
    {
      n.a(localn, paramBoolean, null, false, false, 12);
      AppMethodBeat.o(336526);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.a
 * JD-Core Version:    0.7.0.1
 */
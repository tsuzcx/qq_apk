package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.bx;
import com.tencent.mm.plugin.finder.cgi.bx.a;
import com.tencent.mm.plugin.i.a.ai;
import com.tencent.mm.plugin.i.a.s;
import com.tencent.mm.protocal.protobuf.aze;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModProfileSticky;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderModProfileSticky;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModProfileStickySetting;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "cmdBufItem", "getCmdId", "", "handleUpdateResult", "", "retCode", "modifyStickyFeed", "feedId", "", "opType", "nonceId", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Companion", "plugin-finder_release"})
public final class e
  extends k<aze>
  implements s
{
  public static final a txI;
  private final String TAG = "Finder.FinderModProfileStickySetting";
  
  static
  {
    AppMethodBeat.i(242656);
    txI = new a((byte)0);
    AppMethodBeat.o(242656);
  }
  
  public final void a(long paramLong, int paramInt, String paramString, ai<aze> paramai)
  {
    AppMethodBeat.i(242654);
    p.h(paramString, "nonceId");
    aze localaze = new aze();
    localaze.LIV = paramLong;
    localaze.dYx = paramInt;
    localaze.objectNonceId = paramString;
    a(localaze, paramai, false);
    AppMethodBeat.o(242654);
  }
  
  public final int getCmdId()
  {
    AppMethodBeat.i(242652);
    bx.a locala = bx.tvW;
    int i = bx.cYW();
    AppMethodBeat.o(242652);
    return i;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModProfileSticky$Companion;", "", "()V", "PROFILE_STICK_EVENT_TYPE", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.e
 * JD-Core Version:    0.7.0.1
 */
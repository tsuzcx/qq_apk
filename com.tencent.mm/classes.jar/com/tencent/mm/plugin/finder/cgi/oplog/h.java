package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.service.o;
import com.tencent.mm.plugin.findersdk.a.ck;
import com.tencent.mm.protocal.protobuf.bqb;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModProfileSticky;", "Lcom/tencent/mm/plugin/finder/service/IFinderModProfileSticky;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModProfileStickySetting;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "cmdBufItem", "getCmdId", "", "handleUpdateResult", "", "retCode", "modifyStickyFeed", "feedId", "", "opType", "nonceId", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends n<bqb>
  implements o
{
  public static final h.a AFh;
  private final String TAG = "Finder.FinderModProfileStickySetting";
  
  static
  {
    AppMethodBeat.i(336521);
    AFh = new h.a((byte)0);
    AppMethodBeat.o(336521);
  }
  
  public final void a(long paramLong, int paramInt, String paramString, ck<bqb> paramck)
  {
    AppMethodBeat.i(336524);
    s.u(paramString, "nonceId");
    bqb localbqb = new bqb();
    localbqb.ZXZ = paramLong;
    localbqb.hYl = paramInt;
    localbqb.objectNonceId = paramString;
    n.a((n)this, localbqb, paramck, false, false, 12);
    AppMethodBeat.o(336524);
  }
  
  public final int getCmdId()
  {
    return 12;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.h
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.service.m;
import com.tencent.mm.plugin.findersdk.a.ck;
import com.tencent.mm.protocal.protobuf.buf;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderDelFansService;", "Lcom/tencent/mm/plugin/finder/service/IFinderDelFansService;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderRemoveFansSetting;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "cmdBufItem", "delFans", "", "fansId", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "getCmdId", "", "handleUpdateResult", "retCode", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends n<buf>
  implements m
{
  private final String TAG = "Finder.FinderDelFansService";
  
  public final void a(String paramString, ck<buf> paramck)
  {
    AppMethodBeat.i(336528);
    s.u(paramString, "fansId");
    buf localbuf = new buf();
    localbuf.aabY = paramString;
    n.a((n)this, localbuf, paramck, false, false, 12);
    AppMethodBeat.o(336528);
  }
  
  public final int getCmdId()
  {
    return 14;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.b
 * JD-Core Version:    0.7.0.1
 */
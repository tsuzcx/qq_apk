package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.ca;
import com.tencent.mm.plugin.finder.cgi.ca.a;
import com.tencent.mm.plugin.finder.service.k;
import com.tencent.mm.plugin.findersdk.a.aj;
import com.tencent.mm.protocal.protobuf.beo;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModifyBlackListService;", "Lcom/tencent/mm/plugin/finder/service/IFinderModifyBlackList;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "kotlin.jvm.PlatformType", "cmdBufItem", "getCmdId", "", "handleUpdateResult", "", "retCode", "modifyCommentBlackList", "commentId", "", "feedId", "feedNonceId", "isBlack", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "modifyFansBlackList", "fansId", "modifyLiveBlackList", "username", "Companion", "plugin-finder_release"})
public final class i
  extends m<beo>
  implements k
{
  private static final int xfL = 1;
  private static final int xfM = 2;
  public static final a xfN;
  private final String TAG = "Finder.FinderModifyBlackListService";
  
  static
  {
    AppMethodBeat.i(165301);
    xfN = new a((byte)0);
    xfL = 1;
    xfM = 2;
    AppMethodBeat.o(165301);
  }
  
  public final void a(long paramLong1, long paramLong2, String paramString, aj<beo> paramaj)
  {
    AppMethodBeat.i(165299);
    p.k(paramString, "feedNonceId");
    beo localbeo = new beo();
    localbeo.xbT = paramLong1;
    localbeo.refObjectId = paramLong2;
    localbeo.refObjectNonceId = paramString;
    localbeo.opType = xfL;
    m.a(this, localbeo, paramaj);
    AppMethodBeat.o(165299);
  }
  
  public final void b(String paramString, aj<beo> paramaj)
  {
    AppMethodBeat.i(286134);
    p.k(paramString, "username");
    beo localbeo = new beo();
    localbeo.username = paramString;
    localbeo.opType = xfL;
    m.a(this, localbeo, paramaj);
    AppMethodBeat.o(286134);
  }
  
  public final void b(String paramString, boolean paramBoolean, aj<beo> paramaj)
  {
    AppMethodBeat.i(165298);
    p.k(paramString, "fansId");
    beo localbeo = new beo();
    localbeo.fFa = paramString;
    if (paramBoolean) {}
    for (localbeo.opType = xfL;; localbeo.opType = xfM)
    {
      m.a(this, localbeo, paramaj);
      AppMethodBeat.o(165298);
      return;
    }
  }
  
  public final int getCmdId()
  {
    AppMethodBeat.i(165297);
    ca.a locala = ca.xdJ;
    int i = ca.doE();
    AppMethodBeat.o(165297);
    return i;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModifyBlackListService$Companion;", "", "()V", "ModBlackListOpAdd", "", "getModBlackListOpAdd", "()I", "ModBlackListOpDel", "getModBlackListOpDel", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.i
 * JD-Core Version:    0.7.0.1
 */
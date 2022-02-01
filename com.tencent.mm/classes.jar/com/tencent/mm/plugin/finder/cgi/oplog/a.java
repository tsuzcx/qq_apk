package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.plugin.finder.cgi.v;
import com.tencent.mm.plugin.finder.cgi.v.a;
import com.tencent.mm.plugin.i.a.e;
import com.tencent.mm.plugin.i.a.i;
import com.tencent.mm.protocal.protobuf.ajw;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModifyBlackListService;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderModifyBlackList;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "kotlin.jvm.PlatformType", "cmdBufItem", "getCmdId", "", "handleUpdateResult", "", "retCode", "modifyCommentBlackList", "commentId", "", "feedId", "feedNonceId", "isBlack", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "modifyFansBlackList", "fansId", "Companion", "plugin-finder_release"})
public final class a
  extends d<ajw>
  implements g, e
{
  private static final int qpQ = 1;
  private static final int qpR = 2;
  public static final a qpS;
  private final String TAG = "Finder.FinderModifyBlackListService";
  
  static
  {
    AppMethodBeat.i(165301);
    qpS = new a((byte)0);
    qpQ = 1;
    qpR = 2;
    AppMethodBeat.o(165301);
  }
  
  public final void a(long paramLong1, long paramLong2, String paramString, i<ajw> parami)
  {
    AppMethodBeat.i(165299);
    k.h(paramString, "feedNonceId");
    ajw localajw = new ajw();
    localajw.qoE = paramLong1;
    localajw.refObjectId = paramLong2;
    localajw.refObjectNonceId = paramString;
    localajw.opType = qpQ;
    a(localajw, parami);
    AppMethodBeat.o(165299);
  }
  
  public final void a(String paramString, boolean paramBoolean, i<ajw> parami)
  {
    AppMethodBeat.i(165298);
    k.h(paramString, "fansId");
    ajw localajw = new ajw();
    localajw.DkZ = paramString;
    if (paramBoolean) {}
    for (localajw.opType = qpQ;; localajw.opType = qpR)
    {
      a(localajw, parami);
      AppMethodBeat.o(165298);
      return;
    }
  }
  
  public final int getCmdId()
  {
    AppMethodBeat.i(165297);
    v.a locala = v.qpr;
    int i = v.ckS();
    AppMethodBeat.o(165297);
    return i;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModifyBlackListService$Companion;", "", "()V", "ModBlackListOpAdd", "", "getModBlackListOpAdd", "()I", "ModBlackListOpDel", "getModBlackListOpDel", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.plugin.finder.cgi.am.a;
import com.tencent.mm.plugin.i.a.f;
import com.tencent.mm.protocal.protobuf.amf;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModifyBlackListService;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderModifyBlackList;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "kotlin.jvm.PlatformType", "cmdBufItem", "getCmdId", "", "handleUpdateResult", "", "retCode", "modifyCommentBlackList", "commentId", "", "feedId", "feedNonceId", "isBlack", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "modifyFansBlackList", "fansId", "Companion", "plugin-finder_release"})
public final class b
  extends e<amf>
  implements g, f
{
  private static final int qZx = 1;
  private static final int qZy = 2;
  public static final b.a qZz;
  private final String TAG = "Finder.FinderModifyBlackListService";
  
  static
  {
    AppMethodBeat.i(165301);
    qZz = new b.a((byte)0);
    qZx = 1;
    qZy = 2;
    AppMethodBeat.o(165301);
  }
  
  public final void a(long paramLong1, long paramLong2, String paramString, com.tencent.mm.plugin.i.a.k<amf> paramk)
  {
    AppMethodBeat.i(165299);
    d.g.b.k.h(paramString, "feedNonceId");
    amf localamf = new amf();
    localamf.qXy = paramLong1;
    localamf.refObjectId = paramLong2;
    localamf.refObjectNonceId = paramString;
    localamf.opType = qZx;
    a(localamf, paramk);
    AppMethodBeat.o(165299);
  }
  
  public final void a(String paramString, boolean paramBoolean, com.tencent.mm.plugin.i.a.k<amf> paramk)
  {
    AppMethodBeat.i(165298);
    d.g.b.k.h(paramString, "fansId");
    amf localamf = new amf();
    localamf.EEs = paramString;
    if (paramBoolean) {}
    for (localamf.opType = qZx;; localamf.opType = qZy)
    {
      a(localamf, paramk);
      AppMethodBeat.o(165298);
      return;
    }
  }
  
  public final int getCmdId()
  {
    AppMethodBeat.i(165297);
    am.a locala = am.qYu;
    int i = am.csJ();
    AppMethodBeat.o(165297);
    return i;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.b
 * JD-Core Version:    0.7.0.1
 */
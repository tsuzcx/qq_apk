package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.plugin.finder.cgi.au;
import com.tencent.mm.plugin.finder.cgi.au.a;
import com.tencent.mm.plugin.i.a.j;
import com.tencent.mm.plugin.i.a.s;
import com.tencent.mm.protocal.protobuf.apy;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModifyBlackListService;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderModifyBlackList;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "kotlin.jvm.PlatformType", "cmdBufItem", "getCmdId", "", "handleUpdateResult", "", "retCode", "modifyCommentBlackList", "commentId", "", "feedId", "feedNonceId", "isBlack", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "modifyFansBlackList", "fansId", "Companion", "plugin-finder_release"})
public final class d
  extends h<apy>
  implements f, j
{
  private static final int rTq = 1;
  private static final int rTr = 2;
  public static final a rTs;
  private final String TAG = "Finder.FinderModifyBlackListService";
  
  static
  {
    AppMethodBeat.i(165301);
    rTs = new a((byte)0);
    rTq = 1;
    rTr = 2;
    AppMethodBeat.o(165301);
  }
  
  public final void a(long paramLong1, long paramLong2, String paramString, s<apy> params)
  {
    AppMethodBeat.i(165299);
    p.h(paramString, "feedNonceId");
    apy localapy = new apy();
    localapy.rQR = paramLong1;
    localapy.refObjectId = paramLong2;
    localapy.refObjectNonceId = paramString;
    localapy.opType = rTq;
    a(localapy, params);
    AppMethodBeat.o(165299);
  }
  
  public final void a(String paramString, boolean paramBoolean, s<apy> params)
  {
    AppMethodBeat.i(165298);
    p.h(paramString, "fansId");
    apy localapy = new apy();
    localapy.GEH = paramString;
    if (paramBoolean) {}
    for (localapy.opType = rTq;; localapy.opType = rTr)
    {
      a(localapy, params);
      AppMethodBeat.o(165298);
      return;
    }
  }
  
  public final int getCmdId()
  {
    AppMethodBeat.i(165297);
    au.a locala = au.rRY;
    int i = au.cAb();
    AppMethodBeat.o(165297);
    return i;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModifyBlackListService$Companion;", "", "()V", "ModBlackListOpAdd", "", "getModBlackListOpAdd", "()I", "ModBlackListOpDel", "getModBlackListOpDel", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.d
 * JD-Core Version:    0.7.0.1
 */
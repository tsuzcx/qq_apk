package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.plugin.finder.cgi.at;
import com.tencent.mm.plugin.finder.cgi.at.a;
import com.tencent.mm.plugin.i.a.j;
import com.tencent.mm.plugin.i.a.s;
import com.tencent.mm.protocal.protobuf.apl;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModifyBlackListService;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderModifyBlackList;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "kotlin.jvm.PlatformType", "cmdBufItem", "getCmdId", "", "handleUpdateResult", "", "retCode", "modifyCommentBlackList", "commentId", "", "feedId", "feedNonceId", "isBlack", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "modifyFansBlackList", "fansId", "Companion", "plugin-finder_release"})
public final class d
  extends h<apl>
  implements f, j
{
  private static final int rLc = 1;
  private static final int rLd = 2;
  public static final a rLe;
  private final String TAG = "Finder.FinderModifyBlackListService";
  
  static
  {
    AppMethodBeat.i(165301);
    rLe = new a((byte)0);
    rLc = 1;
    rLd = 2;
    AppMethodBeat.o(165301);
  }
  
  public final void a(long paramLong1, long paramLong2, String paramString, s<apl> params)
  {
    AppMethodBeat.i(165299);
    p.h(paramString, "feedNonceId");
    apl localapl = new apl();
    localapl.rIH = paramLong1;
    localapl.refObjectId = paramLong2;
    localapl.refObjectNonceId = paramString;
    localapl.opType = rLc;
    a(localapl, params);
    AppMethodBeat.o(165299);
  }
  
  public final void a(String paramString, boolean paramBoolean, s<apl> params)
  {
    AppMethodBeat.i(165298);
    p.h(paramString, "fansId");
    apl localapl = new apl();
    localapl.GlF = paramString;
    if (paramBoolean) {}
    for (localapl.opType = rLc;; localapl.opType = rLd)
    {
      a(localapl, params);
      AppMethodBeat.o(165298);
      return;
    }
  }
  
  public final int getCmdId()
  {
    AppMethodBeat.i(165297);
    at.a locala = at.rJK;
    int i = at.cyA();
    AppMethodBeat.o(165297);
    return i;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModifyBlackListService$Companion;", "", "()V", "ModBlackListOpAdd", "", "getModBlackListOpAdd", "()I", "ModBlackListOpDel", "getModBlackListOpDel", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.d
 * JD-Core Version:    0.7.0.1
 */
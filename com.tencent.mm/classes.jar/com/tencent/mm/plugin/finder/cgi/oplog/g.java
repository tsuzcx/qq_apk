package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.plugin.finder.cgi.bx;
import com.tencent.mm.plugin.finder.cgi.bx.a;
import com.tencent.mm.plugin.i.a.ai;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.protocal.protobuf.ayt;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModifyBlackListService;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderModifyBlackList;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "kotlin.jvm.PlatformType", "cmdBufItem", "getCmdId", "", "handleUpdateResult", "", "retCode", "modifyCommentBlackList", "commentId", "", "feedId", "feedNonceId", "isBlack", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "modifyFansBlackList", "fansId", "modifyLiveBlackList", "username", "Companion", "plugin-finder_release"})
public final class g
  extends k<ayt>
  implements i, t
{
  private static final int txJ = 1;
  private static final int txK = 2;
  public static final a txL;
  private final String TAG = "Finder.FinderModifyBlackListService";
  
  static
  {
    AppMethodBeat.i(165301);
    txL = new a((byte)0);
    txJ = 1;
    txK = 2;
    AppMethodBeat.o(165301);
  }
  
  public final void a(long paramLong1, long paramLong2, String paramString, ai<ayt> paramai)
  {
    AppMethodBeat.i(165299);
    p.h(paramString, "feedNonceId");
    ayt localayt = new ayt();
    localayt.tuj = paramLong1;
    localayt.refObjectId = paramLong2;
    localayt.refObjectNonceId = paramString;
    localayt.opType = txJ;
    a(localayt, paramai, false);
    AppMethodBeat.o(165299);
  }
  
  public final void b(String paramString, ai<ayt> paramai)
  {
    AppMethodBeat.i(242660);
    p.h(paramString, "username");
    ayt localayt = new ayt();
    localayt.username = paramString;
    localayt.opType = txJ;
    a(localayt, paramai, false);
    AppMethodBeat.o(242660);
  }
  
  public final void b(String paramString, boolean paramBoolean, ai<ayt> paramai)
  {
    AppMethodBeat.i(165298);
    p.h(paramString, "fansId");
    ayt localayt = new ayt();
    localayt.dMj = paramString;
    if (paramBoolean) {}
    for (localayt.opType = txJ;; localayt.opType = txK)
    {
      a(localayt, paramai, false);
      AppMethodBeat.o(165298);
      return;
    }
  }
  
  public final int getCmdId()
  {
    AppMethodBeat.i(165297);
    bx.a locala = bx.tvW;
    int i = bx.cYP();
    AppMethodBeat.o(165297);
    return i;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModifyBlackListService$Companion;", "", "()V", "ModBlackListOpAdd", "", "getModBlackListOpAdd", "()I", "ModBlackListOpDel", "getModBlackListOpDel", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.g
 * JD-Core Version:    0.7.0.1
 */
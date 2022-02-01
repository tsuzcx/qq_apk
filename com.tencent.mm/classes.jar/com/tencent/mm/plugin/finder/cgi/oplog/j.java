package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.service.p;
import com.tencent.mm.plugin.findersdk.a.ck;
import com.tencent.mm.protocal.protobuf.bpp;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModifyBlackListService;", "Lcom/tencent/mm/plugin/finder/service/IFinderModifyBlackList;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "kotlin.jvm.PlatformType", "cmdBufItem", "getCmdId", "", "handleUpdateResult", "", "retCode", "modifyCommentBlackList", "commentId", "", "feedId", "feedNonceId", "isBlack", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "modifyFansBlackList", "fansId", "modifyLiveBlackList", "username", "anchorUsername", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends n<bpp>
  implements p
{
  public static final a AFi;
  private static final int AFj;
  private static final int AFk;
  private final String TAG = "Finder.FinderModifyBlackListService";
  
  static
  {
    AppMethodBeat.i(165301);
    AFi = new a((byte)0);
    AFj = 1;
    AFk = 2;
    AppMethodBeat.o(165301);
  }
  
  public final void a(long paramLong1, long paramLong2, String paramString, ck<bpp> paramck)
  {
    AppMethodBeat.i(165299);
    s.u(paramString, "feedNonceId");
    bpp localbpp = new bpp();
    localbpp.AAW = paramLong1;
    localbpp.refObjectId = paramLong2;
    localbpp.refObjectNonceId = paramString;
    localbpp.opType = AFj;
    n.a((n)this, localbpp, paramck, false, false, 12);
    AppMethodBeat.o(165299);
  }
  
  public final void a(String paramString1, String paramString2, ck<bpp> paramck)
  {
    AppMethodBeat.i(336551);
    s.u(paramString1, "anchorUsername");
    s.u(paramString2, "username");
    Log.i(this.TAG, "modifyLiveBlackList anchorUsername:" + paramString1 + ", username:" + paramString2);
    bpp localbpp = new bpp();
    localbpp.username = paramString2;
    localbpp.opType = AFj;
    ((n)this).a(paramString1, localbpp, paramck);
    AppMethodBeat.o(336551);
  }
  
  public final void b(String paramString, ck<bpp> paramck)
  {
    AppMethodBeat.i(336544);
    s.u(paramString, "username");
    bpp localbpp = new bpp();
    localbpp.username = paramString;
    localbpp.opType = AFj;
    n.a((n)this, localbpp, paramck, false, false, 12);
    AppMethodBeat.o(336544);
  }
  
  public final void b(String paramString, boolean paramBoolean, ck<bpp> paramck)
  {
    AppMethodBeat.i(165298);
    s.u(paramString, "fansId");
    bpp localbpp = new bpp();
    localbpp.hJS = paramString;
    if (paramBoolean) {}
    for (localbpp.opType = AFj;; localbpp.opType = AFk)
    {
      n.a((n)this, localbpp, paramck, false, false, 12);
      d.uiThread((a)b.AFl);
      AppMethodBeat.o(165298);
      return;
    }
  }
  
  public final int getCmdId()
  {
    AppMethodBeat.i(165297);
    AppMethodBeat.o(165297);
    return 3;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModifyBlackListService$Companion;", "", "()V", "ModBlackListOpAdd", "", "getModBlackListOpAdd", "()I", "ModBlackListOpDel", "getModBlackListOpDel", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<ah>
  {
    public static final b AFl;
    
    static
    {
      AppMethodBeat.i(336516);
      AFl = new b();
      AppMethodBeat.o(336516);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.j
 * JD-Core Version:    0.7.0.1
 */
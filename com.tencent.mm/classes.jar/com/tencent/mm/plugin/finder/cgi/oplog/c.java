package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.plugin.finder.cgi.am.a;
import com.tencent.mm.plugin.finder.report.d;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.amg;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModifyFeedSettingService;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderModifyFeedSetting;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "kotlin.jvm.PlatformType", "modUserInfo", "getCmdId", "", "handleUpdateResult", "", "cmdBufItem", "retCode", "modifyFeedComment", "feedId", "", "feedObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "objectNonceId", "openComment", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Companion", "plugin-finder_release"})
public final class c
  extends e<amg>
  implements com.tencent.mm.ak.g, com.tencent.mm.plugin.i.a.g
{
  public static final a qZA;
  private final String TAG = "Finder.FinderModifyFeedSettingService";
  
  static
  {
    AppMethodBeat.i(165306);
    qZA = new a((byte)0);
    AppMethodBeat.o(165306);
  }
  
  public final void a(long paramLong, FinderObject paramFinderObject, String paramString, boolean paramBoolean, com.tencent.mm.plugin.i.a.k<amg> paramk)
  {
    int j = 1;
    AppMethodBeat.i(165302);
    d.g.b.k.h(paramFinderObject, "feedObj");
    d.g.b.k.h(paramString, "objectNonceId");
    Object localObject = d.rxr;
    if (paramBoolean) {}
    for (int i = 2;; i = 1)
    {
      d.g.b.k.h(paramFinderObject, "finderObject");
      localObject = ((com.tencent.mm.plugin.expt.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.c.class)).cit();
      paramFinderObject = (String)localObject + ',' + i + ',' + d.ut(paramFinderObject.id) + ',' + paramFinderObject.username + ',' + paramFinderObject.likeCount + ',' + paramFinderObject.commentCount + ',' + paramFinderObject.friendLikeCount;
      ac.i(d.TAG, "18952 ".concat(String.valueOf(paramFinderObject)));
      com.tencent.mm.plugin.report.e.wTc.kvStat(18952, paramFinderObject);
      paramFinderObject = new amg();
      paramFinderObject.EFE = paramLong;
      paramFinderObject.scene = 1;
      i = j;
      if (paramBoolean) {
        i = 0;
      }
      paramFinderObject.dtJ = i;
      paramFinderObject.objectNonceId = paramString;
      a(paramFinderObject, paramk);
      AppMethodBeat.o(165302);
      return;
    }
  }
  
  public final int getCmdId()
  {
    AppMethodBeat.i(165305);
    am.a locala = am.qYu;
    int i = am.csK();
    AppMethodBeat.o(165305);
    return i;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModifyFeedSettingService$Companion;", "", "()V", "CLOSE_COMMENT", "", "OPEN_COMMENT", "SCENE_CLOSE_COMMENT", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.c
 * JD-Core Version:    0.7.0.1
 */
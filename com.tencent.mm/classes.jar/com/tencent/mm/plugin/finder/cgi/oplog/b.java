package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.a.c;
import com.tencent.mm.plugin.finder.cgi.v;
import com.tencent.mm.plugin.finder.cgi.v.a;
import com.tencent.mm.plugin.i.a.f;
import com.tencent.mm.plugin.i.a.i;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModifyFeedSettingService;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderModifyFeedSetting;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "kotlin.jvm.PlatformType", "modUserInfo", "getCmdId", "", "handleUpdateResult", "", "cmdBufItem", "retCode", "modifyFeedComment", "feedId", "", "feedObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "objectNonceId", "openComment", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Companion", "plugin-finder_release"})
public final class b
  extends d<ajx>
  implements com.tencent.mm.al.g, f
{
  public static final a qpT;
  private final String TAG = "Finder.FinderModifyFeedSettingService";
  
  static
  {
    AppMethodBeat.i(165306);
    qpT = new a((byte)0);
    AppMethodBeat.o(165306);
  }
  
  public final void a(long paramLong, FinderObject paramFinderObject, String paramString, boolean paramBoolean, i<ajx> parami)
  {
    int j = 1;
    AppMethodBeat.i(165302);
    k.h(paramFinderObject, "feedObj");
    k.h(paramString, "objectNonceId");
    Object localObject = com.tencent.mm.plugin.finder.report.b.qFq;
    if (paramBoolean) {}
    for (int i = 2;; i = 1)
    {
      k.h(paramFinderObject, "finderObject");
      localObject = ((c)com.tencent.mm.kernel.g.ab(c.class)).cbk();
      paramFinderObject = (String)localObject + ',' + i + ',' + com.tencent.mm.plugin.finder.report.b.qi(paramFinderObject.id) + ',' + paramFinderObject.username + ',' + paramFinderObject.likeCount + ',' + paramFinderObject.commentCount + ',' + paramFinderObject.friendLikeCount;
      ad.i(com.tencent.mm.plugin.finder.report.b.TAG, "18952 ".concat(String.valueOf(paramFinderObject)));
      e.vIY.kvStat(18952, paramFinderObject);
      paramFinderObject = new ajx();
      paramFinderObject.DlN = paramLong;
      paramFinderObject.scene = 1;
      i = j;
      if (paramBoolean) {
        i = 0;
      }
      paramFinderObject.dvW = i;
      paramFinderObject.objectNonceId = paramString;
      a(paramFinderObject, parami);
      AppMethodBeat.o(165302);
      return;
    }
  }
  
  public final int getCmdId()
  {
    AppMethodBeat.i(165305);
    v.a locala = v.qpr;
    int i = v.ckT();
    AppMethodBeat.o(165305);
    return i;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModifyFeedSettingService$Companion;", "", "()V", "CLOSE_COMMENT", "", "OPEN_COMMENT", "SCENE_CLOSE_COMMENT", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.b
 * JD-Core Version:    0.7.0.1
 */
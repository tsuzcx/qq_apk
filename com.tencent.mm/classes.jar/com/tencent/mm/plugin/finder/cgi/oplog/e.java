package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.finder.cgi.at;
import com.tencent.mm.plugin.finder.cgi.at.a;
import com.tencent.mm.plugin.i.a.s;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.apn;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModifyFeedSettingService;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderModifyFeedSetting;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "kotlin.jvm.PlatformType", "modUserInfo", "getCmdId", "", "handleUpdateResult", "", "cmdBufItem", "retCode", "modifyFeedComment", "feedId", "", "feedObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "objectNonceId", "openComment", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "modifyFeedPrivacy", "ifPrivate", "Companion", "plugin-finder_release"})
public final class e
  extends h<apn>
  implements f, com.tencent.mm.plugin.i.a.l
{
  public static final a rLf;
  private final String TAG = "Finder.FinderModifyFeedSettingService";
  
  static
  {
    AppMethodBeat.i(165306);
    rLf = new a((byte)0);
    AppMethodBeat.o(165306);
  }
  
  public final void a(long paramLong, FinderObject paramFinderObject, String paramString, boolean paramBoolean, s<apn> params)
  {
    int j = 1;
    AppMethodBeat.i(165302);
    p.h(paramFinderObject, "feedObj");
    p.h(paramString, "objectNonceId");
    Object localObject = com.tencent.mm.plugin.finder.report.h.soM;
    if (paramBoolean) {}
    for (int i = 2;; i = 1)
    {
      p.h(paramFinderObject, "finderObject");
      localObject = ((c)g.ab(c.class)).cnc();
      paramFinderObject = (String)localObject + ',' + i + ',' + com.tencent.mm.plugin.finder.report.h.wu(paramFinderObject.id) + ',' + paramFinderObject.username + ',' + paramFinderObject.likeCount + ',' + paramFinderObject.commentCount + ',' + paramFinderObject.friendLikeCount;
      ad.i(com.tencent.mm.plugin.finder.report.h.TAG, "18952 ".concat(String.valueOf(paramFinderObject)));
      com.tencent.mm.plugin.report.e.ygI.kvStat(18952, paramFinderObject);
      paramFinderObject = new apn();
      paramFinderObject.GnU = paramLong;
      paramFinderObject.scene = 1;
      i = j;
      if (paramBoolean) {
        i = 0;
      }
      paramFinderObject.dFJ = i;
      paramFinderObject.objectNonceId = paramString;
      a(paramFinderObject, params);
      AppMethodBeat.o(165302);
      return;
    }
  }
  
  public final void b(long paramLong, FinderObject paramFinderObject, String paramString, boolean paramBoolean, s<apn> params)
  {
    AppMethodBeat.i(201243);
    p.h(paramFinderObject, "feedObj");
    p.h(paramString, "objectNonceId");
    paramFinderObject = new apn();
    paramFinderObject.GnU = paramLong;
    paramFinderObject.scene = 2;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramFinderObject.dFJ = i;
      paramFinderObject.objectNonceId = paramString;
      a(paramFinderObject, params);
      AppMethodBeat.o(201243);
      return;
    }
  }
  
  public final int getCmdId()
  {
    AppMethodBeat.i(165305);
    at.a locala = at.rJK;
    int i = at.cyB();
    AppMethodBeat.o(165305);
    return i;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModifyFeedSettingService$Companion;", "", "()V", "CLOSE_COMMENT", "", "OPEN_COMMENT", "SCENE_CLOSE_COMMENT", "SCENE_SET_PRIVATE", "SET_PRIVATE", "SET_PUBLIC", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.e
 * JD-Core Version:    0.7.0.1
 */
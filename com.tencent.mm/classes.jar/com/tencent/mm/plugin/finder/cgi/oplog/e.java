package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.finder.cgi.au;
import com.tencent.mm.plugin.finder.cgi.au.a;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.plugin.i.a.s;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aqa;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModifyFeedSettingService;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderModifyFeedSetting;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "kotlin.jvm.PlatformType", "modUserInfo", "getCmdId", "", "handleUpdateResult", "", "cmdBufItem", "retCode", "modifyFeedComment", "feedId", "", "feedObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "objectNonceId", "openComment", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "modifyFeedPrivacy", "ifPrivate", "Companion", "plugin-finder_release"})
public final class e
  extends h<aqa>
  implements f, com.tencent.mm.plugin.i.a.l
{
  public static final a rTt;
  private final String TAG = "Finder.FinderModifyFeedSettingService";
  
  static
  {
    AppMethodBeat.i(165306);
    rTt = new a((byte)0);
    AppMethodBeat.o(165306);
  }
  
  public final void a(long paramLong, FinderObject paramFinderObject, String paramString, boolean paramBoolean, s<aqa> params)
  {
    int j = 1;
    AppMethodBeat.i(165302);
    p.h(paramFinderObject, "feedObj");
    p.h(paramString, "objectNonceId");
    Object localObject = i.syT;
    if (paramBoolean) {}
    for (int i = 2;; i = 1)
    {
      p.h(paramFinderObject, "finderObject");
      localObject = ((c)g.ab(c.class)).cos();
      paramFinderObject = (String)localObject + ',' + i + ',' + i.wL(paramFinderObject.id) + ',' + paramFinderObject.username + ',' + paramFinderObject.likeCount + ',' + paramFinderObject.commentCount + ',' + paramFinderObject.friendLikeCount;
      ae.i(i.TAG, "18952 ".concat(String.valueOf(paramFinderObject)));
      com.tencent.mm.plugin.report.e.ywz.kvStat(18952, paramFinderObject);
      paramFinderObject = new aqa();
      paramFinderObject.GHa = paramLong;
      paramFinderObject.scene = 1;
      i = j;
      if (paramBoolean) {
        i = 0;
      }
      paramFinderObject.dGO = i;
      paramFinderObject.objectNonceId = paramString;
      a(paramFinderObject, params);
      AppMethodBeat.o(165302);
      return;
    }
  }
  
  public final void b(long paramLong, FinderObject paramFinderObject, String paramString, boolean paramBoolean, s<aqa> params)
  {
    AppMethodBeat.i(201670);
    p.h(paramFinderObject, "feedObj");
    p.h(paramString, "objectNonceId");
    paramFinderObject = new aqa();
    paramFinderObject.GHa = paramLong;
    paramFinderObject.scene = 2;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramFinderObject.dGO = i;
      paramFinderObject.objectNonceId = paramString;
      a(paramFinderObject, params);
      AppMethodBeat.o(201670);
      return;
    }
  }
  
  public final int getCmdId()
  {
    AppMethodBeat.i(165305);
    au.a locala = au.rRY;
    int i = au.cAc();
    AppMethodBeat.o(165305);
    return i;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModifyFeedSettingService$Companion;", "", "()V", "CLOSE_COMMENT", "", "OPEN_COMMENT", "SCENE_CLOSE_COMMENT", "SCENE_SET_PRIVATE", "SET_PRIVATE", "SET_PUBLIC", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.e
 * JD-Core Version:    0.7.0.1
 */
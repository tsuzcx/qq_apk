package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.finder.cgi.bx;
import com.tencent.mm.plugin.finder.cgi.bx.a;
import com.tencent.mm.plugin.i.a.ai;
import com.tencent.mm.plugin.i.a.v;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ayy;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModifyFeedSettingService;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderModifyFeedSetting;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "kotlin.jvm.PlatformType", "modUserInfo", "getCmdId", "", "handleUpdateResult", "", "cmdBufItem", "retCode", "modifyFeedComment", "feedId", "", "feedObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "objectNonceId", "openComment", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "modifyFeedPrivacy", "ifPrivate", "Companion", "plugin-finder_release"})
public final class h
  extends k<ayy>
  implements i, v
{
  public static final a txM;
  private final String TAG = "Finder.FinderModifyFeedSettingService";
  
  static
  {
    AppMethodBeat.i(165306);
    txM = new a((byte)0);
    AppMethodBeat.o(165306);
  }
  
  public final void a(long paramLong, FinderObject paramFinderObject, String paramString, boolean paramBoolean, ai<ayy> paramai)
  {
    int j = 1;
    AppMethodBeat.i(165302);
    p.h(paramFinderObject, "feedObj");
    p.h(paramString, "objectNonceId");
    Object localObject = com.tencent.mm.plugin.finder.report.k.vfA;
    if (paramBoolean) {}
    for (int i = 2;; i = 1)
    {
      p.h(paramFinderObject, "finderObject");
      localObject = ((c)g.af(c.class)).cMD();
      paramFinderObject = (String)localObject + ',' + i + ',' + com.tencent.mm.plugin.finder.report.k.Fg(paramFinderObject.id) + ',' + paramFinderObject.username + ',' + paramFinderObject.likeCount + ',' + paramFinderObject.commentCount + ',' + paramFinderObject.friendLikeCount;
      Log.i(com.tencent.mm.plugin.finder.report.k.TAG, "18952 ".concat(String.valueOf(paramFinderObject)));
      e.Cxv.kvStat(18952, paramFinderObject);
      paramFinderObject = new ayy();
      paramFinderObject.LIV = paramLong;
      paramFinderObject.scene = 1;
      i = j;
      if (paramBoolean) {
        i = 0;
      }
      paramFinderObject.dYx = i;
      paramFinderObject.objectNonceId = paramString;
      a(paramFinderObject, paramai, false);
      AppMethodBeat.o(165302);
      return;
    }
  }
  
  public final void b(long paramLong, FinderObject paramFinderObject, String paramString, boolean paramBoolean, ai<ayy> paramai)
  {
    boolean bool = true;
    AppMethodBeat.i(242661);
    p.h(paramString, "objectNonceId");
    ayy localayy = new ayy();
    localayy.LIV = paramLong;
    localayy.scene = 2;
    int i;
    if (paramBoolean)
    {
      i = 1;
      localayy.dYx = i;
      localayy.objectNonceId = paramString;
      if (paramFinderObject != null) {
        break label88;
      }
    }
    label88:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      a(localayy, paramai, paramBoolean);
      AppMethodBeat.o(242661);
      return;
      i = 0;
      break;
    }
  }
  
  public final int getCmdId()
  {
    AppMethodBeat.i(165305);
    bx.a locala = bx.tvW;
    int i = bx.cYQ();
    AppMethodBeat.o(165305);
    return i;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModifyFeedSettingService$Companion;", "", "()V", "CLOSE_COMMENT", "", "OPEN_COMMENT", "SCENE_CLOSE_COMMENT", "SCENE_SET_PRIVATE", "SET_PRIVATE", "SET_PUBLIC", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.h
 * JD-Core Version:    0.7.0.1
 */
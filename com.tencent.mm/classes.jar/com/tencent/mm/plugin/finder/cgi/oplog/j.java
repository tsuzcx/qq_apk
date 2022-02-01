package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.finder.cgi.ca;
import com.tencent.mm.plugin.finder.cgi.ca.a;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.findersdk.a.aj;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bet;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModifyFeedSettingService;", "Lcom/tencent/mm/plugin/finder/service/IFinderModifyFeedSetting;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "kotlin.jvm.PlatformType", "modUserInfo", "getCmdId", "", "handleUpdateResult", "", "cmdBufItem", "retCode", "modifyFeedComment", "feedId", "", "feedObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "objectNonceId", "openComment", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "modifyFeedPrivacy", "ifPrivate", "Companion", "plugin-finder_release"})
public final class j
  extends m<bet>
  implements com.tencent.mm.plugin.finder.service.l
{
  public static final a xfO;
  private final String TAG = "Finder.FinderModifyFeedSettingService";
  
  static
  {
    AppMethodBeat.i(165306);
    xfO = new a((byte)0);
    AppMethodBeat.o(165306);
  }
  
  public final void a(long paramLong, FinderObject paramFinderObject, String paramString, boolean paramBoolean, aj<bet> paramaj)
  {
    int j = 1;
    AppMethodBeat.i(165302);
    p.k(paramFinderObject, "feedObj");
    p.k(paramString, "objectNonceId");
    Object localObject = n.zWF;
    if (paramBoolean) {}
    for (int i = 2;; i = 1)
    {
      p.k(paramFinderObject, "finderObject");
      localObject = ((c)h.ae(c.class)).dbr();
      paramFinderObject = (String)localObject + ',' + i + ',' + n.Mp(paramFinderObject.id) + ',' + paramFinderObject.username + ',' + paramFinderObject.likeCount + ',' + paramFinderObject.commentCount + ',' + paramFinderObject.friendLikeCount;
      Log.i(n.TAG, "18952 ".concat(String.valueOf(paramFinderObject)));
      f.Iyx.kvStat(18952, paramFinderObject);
      paramFinderObject = new bet();
      paramFinderObject.SPH = paramLong;
      paramFinderObject.scene = 1;
      i = j;
      if (paramBoolean) {
        i = 0;
      }
      paramFinderObject.fSo = i;
      paramFinderObject.objectNonceId = paramString;
      m.a(this, paramFinderObject, paramaj);
      AppMethodBeat.o(165302);
      return;
    }
  }
  
  public final void b(long paramLong, FinderObject paramFinderObject, String paramString, boolean paramBoolean, aj<bet> paramaj)
  {
    boolean bool = true;
    AppMethodBeat.i(278874);
    p.k(paramString, "objectNonceId");
    bet localbet = new bet();
    localbet.SPH = paramLong;
    localbet.scene = 2;
    int i;
    if (paramBoolean)
    {
      i = 1;
      localbet.fSo = i;
      localbet.objectNonceId = paramString;
      if (paramFinderObject != null) {
        break label88;
      }
    }
    label88:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      a(localbet, paramaj, paramBoolean);
      AppMethodBeat.o(278874);
      return;
      i = 0;
      break;
    }
  }
  
  public final int getCmdId()
  {
    AppMethodBeat.i(165305);
    ca.a locala = ca.xdJ;
    int i = ca.doF();
    AppMethodBeat.o(165305);
    return i;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModifyFeedSettingService$Companion;", "", "()V", "CLOSE_COMMENT", "", "OPEN_COMMENT", "SCENE_CLOSE_COMMENT", "SCENE_SET_PRIVATE", "SET_PRIVATE", "SET_PUBLIC", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.j
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.d;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.service.q;
import com.tencent.mm.plugin.findersdk.a.ck;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bpu;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModifyFeedSettingService;", "Lcom/tencent/mm/plugin/finder/service/IFinderModifyFeedSetting;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "kotlin.jvm.PlatformType", "modUserInfo", "getCmdId", "", "handleUpdateResult", "", "cmdBufItem", "retCode", "modifyFeedComment", "feedId", "", "feedObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "objectNonceId", "openComment", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "modifyFeedPrivacy", "ifPrivate", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends n<bpu>
  implements q
{
  public static final a AFm;
  private final String TAG = "Finder.FinderModifyFeedSettingService";
  
  static
  {
    AppMethodBeat.i(165306);
    AFm = new a((byte)0);
    AppMethodBeat.o(165306);
  }
  
  public final void a(long paramLong, FinderObject paramFinderObject, String paramString, boolean paramBoolean, ck<bpu> paramck)
  {
    int j = 1;
    AppMethodBeat.i(165302);
    s.u(paramFinderObject, "feedObj");
    s.u(paramString, "objectNonceId");
    Object localObject = z.FrZ;
    if (paramBoolean) {}
    for (int i = 2;; i = 1)
    {
      s.u(paramFinderObject, "finderObject");
      localObject = ((d)h.ax(d.class)).dHN();
      paramFinderObject = localObject + ',' + i + ',' + z.pL(paramFinderObject.id) + ',' + paramFinderObject.username + ',' + paramFinderObject.likeCount + ',' + paramFinderObject.commentCount + ',' + paramFinderObject.friendLikeCount;
      Log.i(z.TAG, s.X("18952 ", paramFinderObject));
      f.Ozc.kvStat(18952, paramFinderObject);
      paramFinderObject = new bpu();
      paramFinderObject.ZXZ = paramLong;
      paramFinderObject.scene = 1;
      i = j;
      if (paramBoolean) {
        i = 0;
      }
      paramFinderObject.hYl = i;
      paramFinderObject.objectNonceId = paramString;
      n.a((n)this, paramFinderObject, paramck, false, false, 12);
      AppMethodBeat.o(165302);
      return;
    }
  }
  
  public final void b(long paramLong, FinderObject paramFinderObject, String paramString, boolean paramBoolean, ck<bpu> paramck)
  {
    AppMethodBeat.i(336536);
    s.u(paramString, "objectNonceId");
    bpu localbpu = new bpu();
    localbpu.ZXZ = paramLong;
    localbpu.scene = 2;
    int i;
    if (paramBoolean)
    {
      i = 1;
      localbpu.hYl = i;
      localbpu.objectNonceId = paramString;
      paramString = (n)this;
      if (paramFinderObject != null) {
        break label94;
      }
    }
    label94:
    for (paramBoolean = true;; paramBoolean = false)
    {
      n.a(paramString, localbpu, paramck, paramBoolean, false, 8);
      AppMethodBeat.o(336536);
      return;
      i = 0;
      break;
    }
  }
  
  public final int getCmdId()
  {
    AppMethodBeat.i(165305);
    AppMethodBeat.o(165305);
    return 4;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModifyFeedSettingService$Companion;", "", "()V", "CLOSE_COMMENT", "", "OPEN_COMMENT", "SCENE_CLOSE_COMMENT", "SCENE_SET_PRIVATE", "SET_PRIVATE", "SET_PUBLIC", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.k
 * JD-Core Version:    0.7.0.1
 */
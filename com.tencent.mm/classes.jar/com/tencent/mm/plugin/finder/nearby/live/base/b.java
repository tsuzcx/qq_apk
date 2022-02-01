package com.tencent.mm.plugin.finder.nearby.live.base;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.ag;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.s.l;
import com.tencent.mm.plugin.finder.live.report.s.t;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.model.w;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.awq;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bhx;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/base/NearbyEnterTargetLiveRoomChecker;", "Lcom/tencent/plugin/finder/nearby/api/INearbyEnterTargetLiveRoomChecker;", "()V", "TAG", "", "enableRedDotToTargetLiveRoom", "", "getEnableRedDotToTargetLiveRoom", "()Z", "finderObjectMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "Lkotlin/collections/HashMap;", "isFetching", "onGetFinderObjectCallback", "Lkotlin/Function1;", "", "startFetchTimeStamp", "", "checkEnterTargetLiveRoom", "targetObjectId", "targetObjectNonceId", "commentScene", "", "checkJumpToTargetLiveRoom", "activity", "Landroid/app/Activity;", "targetLiveUserName", "targetLiveNickName", "targetLiveCoverUrl", "fetchTargetLiveRoomObject", "objectId", "objectNonceId", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getKey", "getRedDotInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLbsTabTipsInfo;", "getTargetLiveId", "reset", "plugin-finder-nearby_release"})
public final class b
  implements com.tencent.c.a.b.a.a
{
  private static boolean xzk;
  private static boolean zEP;
  private static final HashMap<String, FinderObject> zEQ;
  private static kotlin.g.a.b<? super FinderObject, x> zER;
  private static long zES;
  public static final b zET;
  
  static
  {
    AppMethodBeat.i(200162);
    zET = new b();
    zEP = true;
    zEQ = new HashMap();
    zES = System.currentTimeMillis();
    AppMethodBeat.o(200162);
  }
  
  public static void a(Activity paramActivity, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(200144);
    p.k(paramActivity, "activity");
    p.k(paramString1, "targetObjectNonceId");
    p.k(paramString2, "targetLiveUserName");
    p.k(paramString3, "targetLiveNickName");
    p.k(paramString4, "targetLiveCoverUrl");
    if (!dLI())
    {
      Log.w("NearbyEnterTargetLiveRoomChecker", "checkJumpToTargetLiveRoom return for enableRedDotToTargetLiveRoom:" + dLI());
      AppMethodBeat.o(200144);
      return;
    }
    if ((paramLong == -1L) || (paramLong == 0L))
    {
      Log.w("NearbyEnterTargetLiveRoomChecker", "checkJumpToTargetLiveRoom return for targetObjectId:".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(200144);
      return;
    }
    if (com.tencent.mm.q.a.aAp())
    {
      Log.w("NearbyEnterTargetLiveRoomChecker", "checkJumpToTargetLiveRoom return for checkFinderLiveStatePlaying targetObjectId:".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(200144);
      return;
    }
    Object localObject1 = g.Xox;
    localObject1 = ((aj)g.lm((Context)paramActivity).i(aj.class)).wmL;
    if (localObject1 == null) {
      localObject1 = "";
    }
    for (;;)
    {
      int i = ((com.tencent.c.a.b.a.d)h.ag(com.tencent.c.a.b.a.d.class)).getTargetCommentScene(94);
      Log.i("NearbyEnterTargetLiveRoomChecker", "checkJumpToTargetLiveRoom targetObjectId:" + paramLong + " targetObjectNonceId:" + paramString1 + " contextId:" + (String)localObject1 + " commentScene:" + i + " clickTabContextId:" + "8001");
      Object localObject3 = k.yBj;
      Object localObject4 = s.t.yGS;
      Object localObject5 = s.l.yGf.scene;
      p.k(localObject4, "actionType");
      p.k(localObject5, "commentscene");
      if (localObject1 == null) {}
      for (Object localObject2 = "";; localObject2 = localObject1)
      {
        com.tencent.mm.plugin.expt.hellhound.core.b.awV((String)localObject2);
        com.tencent.mm.plugin.expt.hellhound.core.b.awU("8001");
        k.a((k)localObject3, paramLong, 1L, paramString2, -1L, -1L, (s.t)localObject4, (String)localObject5);
        localObject2 = new ArrayList();
        localObject3 = new FinderItem();
        localObject4 = new bac();
        ((bac)localObject4).liveId = 1L;
        ((bac)localObject4).liveStatus = 1;
        localObject5 = new FinderMedia();
        ((FinderMedia)localObject5).thumbUrl = paramString4;
        paramString4 = new FinderObjectDesc();
        paramString4.media = new LinkedList();
        paramString4.media.add(localObject5);
        ((FinderItem)localObject3).getFeedObject().objectDesc = paramString4;
        ((FinderItem)localObject3).getFeedObject().id = paramLong;
        ((FinderItem)localObject3).getFeedObject().objectNonceId = paramString1;
        ((FinderItem)localObject3).getFeedObject().username = paramString2;
        ((FinderItem)localObject3).getFeedObject().nickname = paramString3;
        ((FinderItem)localObject3).getFeedObject().liveInfo = ((bac)localObject4);
        ((FinderItem)localObject3).setMediaType(9);
        paramString2 = new w((FinderItem)localObject3);
        ((ArrayList)localObject2).add(paramString2);
        paramString3 = com.tencent.mm.plugin.finder.utils.a.ACH;
        paramActivity = (Context)paramActivity;
        paramString3 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
        paramString2 = (bu)paramString2;
        paramString3 = h.ag(PluginFinder.class);
        p.j(paramString3, "MMKernel.plugin(PluginFinder::class.java)");
        paramString4 = ((PluginFinder)paramString3).getRedDotManager().aBi("NearbyLiveTab");
        boolean bool;
        if (paramString4 != null)
        {
          bool = true;
          paramString3 = new awq();
          if (paramString4 != null)
          {
            paramString3.SJc = paramString4.object_id;
            paramString3.SJm = paramString4.object_nonce_id;
            paramString3.SJd = paramString4.tabTipsByPassInfo;
            paramString4 = com.tencent.mm.plugin.finder.nearby.abtest.a.zDp;
            if (!com.tencent.mm.plugin.finder.nearby.abtest.a.dLo()) {
              break label823;
            }
            paramString3.SJn = "FinderLiveEntrance";
          }
          label610:
          paramString4 = new StringBuilder("getRedDotInfo isEnterRequest=").append(bool).append(" tab_tips_path=").append(paramString3.SJn).append(' ').append(" tabTipsByPassInfo=");
          if (paramString3.SJd == null) {
            break label834;
          }
          bool = true;
          label663:
          Log.i("NearbyEnterTargetLiveRoomChecker", bool + ' ' + "objectId=" + com.tencent.mm.ae.d.Fw(paramString3.SJc) + ' ');
          i = com.tencent.mm.plugin.finder.utils.a.a(paramActivity, com.tencent.mm.plugin.finder.live.utils.a.a((ArrayList)localObject2, paramString2, i, true, paramString3), (String)localObject1, "8001", null, 16);
          paramActivity = com.tencent.mm.plugin.finder.nearby.live.report.a.zGc;
          com.tencent.mm.plugin.finder.nearby.live.report.a.dMc();
          paramActivity = com.tencent.mm.plugin.finder.nearby.live.square.report.a.zGH;
          paramActivity = (FinderObject)zEQ.get(x(paramLong, paramString1));
          if (paramActivity != null)
          {
            Log.i("NearbyEnterTargetLiveRoomChecker", "getTargetLiveId return for hit cache.");
            paramActivity = paramActivity.liveInfo;
            if (paramActivity == null) {
              break label840;
            }
          }
        }
        label823:
        label834:
        label840:
        for (paramActivity = Long.valueOf(paramActivity.liveId);; paramActivity = null)
        {
          paramString1 = String.valueOf(paramActivity);
          paramActivity = paramString1;
          if (paramString1 == null) {
            paramActivity = "";
          }
          com.tencent.mm.plugin.finder.nearby.live.square.report.a.j((String)localObject1, i, String.valueOf(paramLong), paramActivity);
          AppMethodBeat.o(200144);
          return;
          bool = false;
          break;
          paramString3.SJn = "NearbyEntrance";
          break label610;
          bool = false;
          break label663;
        }
      }
    }
  }
  
  private static boolean dLI()
  {
    AppMethodBeat.i(200119);
    com.tencent.c.a.a.a.a.a locala = com.tencent.c.a.a.a.a.a.Zlt;
    if (((Number)com.tencent.c.a.a.a.a.a.ilz().aSr()).intValue() == 1)
    {
      AppMethodBeat.o(200119);
      return true;
    }
    AppMethodBeat.o(200119);
    return false;
  }
  
  public static void reset()
  {
    AppMethodBeat.i(200160);
    xzk = false;
    zEQ.clear();
    zER = null;
    AppMethodBeat.o(200160);
  }
  
  private static String x(long paramLong, String paramString)
  {
    AppMethodBeat.i(200159);
    paramString = paramLong + '-' + paramString;
    AppMethodBeat.o(200159);
    return paramString;
  }
  
  public final void a(long paramLong, String paramString, int paramInt, kotlin.g.a.b<? super FinderObject, x> paramb)
  {
    AppMethodBeat.i(200156);
    if ((paramLong == -1L) || (paramLong == 0L))
    {
      Log.w("NearbyEnterTargetLiveRoomChecker", "checkEnterTargetLiveRoom return for targetObjectId:".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(200156);
      return;
    }
    Log.i("NearbyEnterTargetLiveRoomChecker", "checkEnterTargetLiveRoom targetObjectId:" + paramLong + " targetObjectNonceId:" + paramString);
    bid localbid = new bid();
    localbid.fGo = paramInt;
    localbid.xkX = paramInt;
    if (paramString == null) {
      paramString = "";
    }
    for (;;)
    {
      Log.i("NearbyEnterTargetLiveRoomChecker", "fetchTargetLiveRoomObject objectId:" + paramLong + " objectNonceId:" + paramString);
      zES = System.currentTimeMillis();
      zER = paramb;
      FinderObject localFinderObject = (FinderObject)zEQ.get(x(paramLong, paramString));
      if (localFinderObject != null)
      {
        Log.i("NearbyEnterTargetLiveRoomChecker", "fetchTargetLiveRoomObject fetch time:" + (System.currentTimeMillis() - zES));
        if (paramb != null) {
          paramb.invoke(localFinderObject);
        }
        Log.i("NearbyEnterTargetLiveRoomChecker", "fetchTargetLiveRoomObject return for hit cache.");
        AppMethodBeat.o(200156);
        return;
      }
      if (xzk)
      {
        Log.i("NearbyEnterTargetLiveRoomChecker", "fetchTargetLiveRoomObject return for isFetchTargetFeed:" + xzk + '.');
        AppMethodBeat.o(200156);
        return;
      }
      xzk = true;
      new ag(paramLong, paramString, 0, 2, "", true, null, null, 0L, null, false, false, null, localbid, 0, null, 24512).bhW().b((com.tencent.mm.vending.c.a)new a(paramLong, paramString));
      AppMethodBeat.o(200156);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "kotlin.jvm.PlatformType", "call", "(Lcom/tencent/mm/modelbase/Cgi$CgiBack;)Lkotlin/Unit;"})
  static final class a<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    a(long paramLong, String paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.base.b
 * JD-Core Version:    0.7.0.1
 */
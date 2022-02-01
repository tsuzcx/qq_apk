package com.tencent.mm.plugin.finder.nearby.live.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.f.a;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.az;
import com.tencent.mm.plugin.finder.extension.reddot.p;
import com.tencent.mm.plugin.finder.live.report.j;
import com.tencent.mm.plugin.finder.live.report.q.n;
import com.tencent.mm.plugin.finder.live.report.q.w;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.model.x;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.plugin.findersdk.a.ce.a;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.FinderTipsShowEntranceExtInfo;
import com.tencent.mm.protocal.protobuf.ayl;
import com.tencent.mm.protocal.protobuf.bcl;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.btw;
import com.tencent.mm.protocal.protobuf.btx;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/base/NearbyEnterTargetLiveRoomChecker;", "Lcom/tencent/plugin/finder/nearby/api/INearbyEnterTargetLiveRoomChecker;", "()V", "TAG", "", "enableRedDotToTargetLiveRoom", "", "getEnableRedDotToTargetLiveRoom", "()Z", "finderObjectMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "Lkotlin/collections/HashMap;", "isFetching", "onGetFinderObjectCallback", "Ljava/lang/ref/WeakReference;", "Lkotlin/Function1;", "", "startFetchTimeStamp", "", "checkEnterTargetLiveRoom", "targetObjectId", "targetObjectNonceId", "commentScene", "", "checkJumpToTargetLiveRoom", "activity", "Landroid/app/Activity;", "targetTabId", "targetLiveUserName", "targetLiveNickName", "targetLiveCoverUrl", "fetchTargetLiveRoomObject", "objectId", "objectNonceId", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "genChnlExtra", "getKey", "getRedDotInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLbsTabTipsInfo;", "getTargetLiveId", "reset", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements com.tencent.d.a.b.a.a
{
  private static boolean AWv;
  public static final b EJG;
  private static boolean EJH;
  private static final HashMap<String, FinderObject> EJI;
  private static WeakReference<kotlin.g.a.b<FinderObject, ah>> EJJ;
  private static long EJK;
  
  static
  {
    AppMethodBeat.i(340756);
    EJG = new b();
    EJH = true;
    EJI = new HashMap();
    EJK = System.currentTimeMillis();
    AppMethodBeat.o(340756);
  }
  
  private static String I(long paramLong, String paramString)
  {
    AppMethodBeat.i(340737);
    paramString = paramLong + '-' + paramString;
    AppMethodBeat.o(340737);
    return paramString;
  }
  
  private static final ah a(b paramb, long paramLong, String paramString, b.a parama)
  {
    AppMethodBeat.i(340750);
    s.u(paramb, "this$0");
    s.u(paramString, "$objectNonceId");
    AWv = false;
    paramb = EJJ;
    if (paramb == null)
    {
      paramb = null;
      if ((parama.errType != 0) || (parama.errCode != 0))
      {
        localObject = aw.Gjk;
        if (!aw.iv(parama.errType, parama.errCode)) {
          break label173;
        }
      }
      Object localObject = ((ayl)parama.ott).feedObject;
      if (localObject != null)
      {
        Log.i("NearbyEnterTargetLiveRoomChecker", s.X("fetchTargetLiveRoomObject fetch time:", Long.valueOf(System.currentTimeMillis() - EJK)));
        ((Map)EJI).put(I(paramLong, paramString), localObject);
      }
      if (paramb != null) {
        paramb.invoke(((ayl)parama.ott).feedObject);
      }
    }
    for (;;)
    {
      EJJ = null;
      paramb = ah.aiuX;
      AppMethodBeat.o(340750);
      return paramb;
      paramb = (kotlin.g.a.b)paramb.get();
      break;
      label173:
      if (paramb != null) {
        paramb.invoke(null);
      }
    }
  }
  
  private final void a(long paramLong, String paramString, bui parambui, kotlin.g.a.b<? super FinderObject, ah> paramb)
  {
    AppMethodBeat.i(340731);
    Log.i("NearbyEnterTargetLiveRoomChecker", "fetchTargetLiveRoomObject objectId:" + paramLong + " objectNonceId:" + paramString);
    EJK = System.currentTimeMillis();
    EJJ = new WeakReference(paramb);
    FinderObject localFinderObject = (FinderObject)EJI.get(I(paramLong, paramString));
    if (localFinderObject != null)
    {
      Log.i("NearbyEnterTargetLiveRoomChecker", s.X("fetchTargetLiveRoomObject fetch time:", Long.valueOf(System.currentTimeMillis() - EJK)));
      if (paramb != null) {
        paramb.invoke(localFinderObject);
      }
      Log.i("NearbyEnterTargetLiveRoomChecker", "fetchTargetLiveRoomObject return for hit cache.");
      AppMethodBeat.o(340731);
      return;
    }
    if (AWv)
    {
      Log.i("NearbyEnterTargetLiveRoomChecker", "fetchTargetLiveRoomObject return for isFetchTargetFeed:" + AWv + '.');
      AppMethodBeat.o(340731);
      return;
    }
    AWv = true;
    new az(paramLong, paramString, 0, 2, "", true, null, null, 0L, null, false, false, null, parambui, 0, null, 24512).bFJ().b(new b..ExternalSyntheticLambda0(this, paramLong, paramString));
    AppMethodBeat.o(340731);
  }
  
  public static void a(Activity paramActivity, int paramInt, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(340720);
    s.u(paramActivity, "activity");
    s.u(paramString1, "targetObjectNonceId");
    s.u(paramString2, "targetLiveUserName");
    s.u(paramString3, "targetLiveNickName");
    s.u(paramString4, "targetLiveCoverUrl");
    if (!eEQ())
    {
      Log.w("NearbyEnterTargetLiveRoomChecker", s.X("checkJumpToTargetLiveRoom return for enableRedDotToTargetLiveRoom:", Boolean.valueOf(eEQ())));
      AppMethodBeat.o(340720);
      return;
    }
    if ((paramLong == -1L) || (paramLong == 0L))
    {
      Log.w("NearbyEnterTargetLiveRoomChecker", s.X("checkJumpToTargetLiveRoom return for targetObjectId:", Long.valueOf(paramLong)));
      AppMethodBeat.o(340720);
      return;
    }
    if (com.tencent.mm.n.a.aTk())
    {
      Log.w("NearbyEnterTargetLiveRoomChecker", s.X("checkJumpToTargetLiveRoom return for checkFinderLiveStatePlaying targetObjectId:", Long.valueOf(paramLong)));
      AppMethodBeat.o(340720);
      return;
    }
    Object localObject1 = k.aeZF;
    localObject1 = ((as)k.nq((Context)paramActivity).q(as.class)).zIO;
    String str;
    Object localObject2;
    label190:
    label200:
    int j;
    Object localObject3;
    Object localObject4;
    label330:
    int i;
    if (localObject1 == null)
    {
      localObject1 = "";
      str = "8001";
      localObject2 = com.tencent.mm.plugin.finder.nearby.abtest.a.EHr;
      if (!com.tencent.mm.plugin.finder.nearby.abtest.a.eEi()) {
        break label988;
      }
      if (str != null) {
        break label994;
      }
      str = "1001";
      j = ((com.tencent.d.a.b.a.d)h.az(com.tencent.d.a.b.a.d.class)).getTargetCommentScene(94);
      Log.i("NearbyEnterTargetLiveRoomChecker", "checkJumpToTargetLiveRoom targetObjectId:$" + com.tencent.mm.ae.d.hF(paramLong) + " targetObjectNonceId:" + paramString1 + " contextId:" + (String)localObject1 + " commentScene:" + j + " clickTabContextId:" + str);
      localObject3 = j.Dob;
      localObject4 = q.w.DwU;
      Object localObject5 = q.n.DtJ.scene;
      s.u(localObject4, "actionType");
      s.u(localObject5, "commentscene");
      if (localObject1 != null) {
        break label997;
      }
      localObject2 = "";
      com.tencent.mm.plugin.expt.hellhound.core.b.aqZ((String)localObject2);
      com.tencent.mm.plugin.expt.hellhound.core.b.aqY(str);
      ce.a.a((ce)localObject3, paramLong, 1L, paramString2, -1L, -1L, (q.w)localObject4, (String)localObject5);
      localObject2 = new ArrayList();
      localObject3 = new FinderItem();
      localObject4 = new bip();
      ((bip)localObject4).liveId = 1L;
      ((bip)localObject4).liveStatus = 1;
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
      ((FinderItem)localObject3).getFeedObject().liveInfo = ((bip)localObject4);
      ((FinderItem)localObject3).setMediaType(9);
      paramString4 = new x((FinderItem)localObject3);
      ((ArrayList)localObject2).add(paramString4);
      paramString2 = new Intent();
      paramString3 = eER();
      localObject3 = (CharSequence)paramString3;
      if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
        break label1004;
      }
      i = 1;
      label573:
      if (i == 0) {
        paramString2.putExtra("key_chnl_extra", paramString3);
      }
      paramString2.putExtra("KEY_PARAMS_NOT_KEEP_CUR_LIVE", true);
      paramString3 = (com.tencent.mm.plugin.f)com.tencent.mm.plugin.finder.utils.a.GfO;
      paramActivity = (Context)paramActivity;
      localObject3 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      paramString4 = (cc)paramString4;
      localObject4 = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().avs("NearbyLiveTab");
      if (localObject4 == null) {
        break label1010;
      }
      bool = true;
      label652:
      localObject3 = new bcl();
      if (localObject4 != null)
      {
        ((bcl)localObject3).ZNj = ((btx)localObject4).object_id;
        ((bcl)localObject3).ZNw = ((btx)localObject4).object_nonce_id;
        ((bcl)localObject3).ZwY = ((btx)localObject4).tabTipsByPassInfo;
        localObject4 = com.tencent.mm.plugin.finder.nearby.abtest.a.EHr;
        if (!com.tencent.mm.plugin.finder.nearby.abtest.a.eEi()) {
          break label1016;
        }
        ((bcl)localObject3).ZNx = "FinderLiveEntrance";
      }
      label715:
      localObject4 = new StringBuilder("getRedDotInfo isEnterRequest=").append(bool).append(" tab_tips_path=").append(((bcl)localObject3).ZNx).append("  tabTipsByPassInfo=");
      if (((bcl)localObject3).ZwY == null) {
        break label1027;
      }
    }
    label1027:
    for (boolean bool = true;; bool = false)
    {
      Log.i("NearbyEnterTargetLiveRoomChecker", bool + " objectId=" + com.tencent.mm.ae.d.hF(((bcl)localObject3).ZNj) + ' ');
      i = f.a.a(paramString3, paramActivity, com.tencent.mm.plugin.finder.live.utils.a.a((ArrayList)localObject2, paramString4, j, true, (bcl)localObject3), (String)localObject1, str, paramString2, false, 32);
      paramActivity = com.tencent.mm.plugin.finder.nearby.live.report.a.ELu;
      com.tencent.mm.plugin.finder.nearby.live.report.a.eFw();
      paramActivity = com.tencent.mm.plugin.finder.nearby.live.square.report.a.EMb;
      paramActivity = (FinderObject)EJI.get(I(paramLong, paramString1));
      if (paramActivity != null) {
        break label1033;
      }
      paramActivity = "";
      com.tencent.mm.plugin.finder.nearby.live.square.report.a.g((String)localObject1, i, String.valueOf(paramLong), paramActivity);
      paramActivity = com.tencent.d.a.a.a.a.a.ahiX;
      if (((Number)com.tencent.d.a.a.a.a.a.jUc().bmg()).intValue() == 0)
      {
        paramActivity = com.tencent.mm.plugin.finder.nearby.preload.a.EPD;
        s.u(localObject1, "contextId");
        Log.i("NearbyPreloadManager", "onClickRedDotEnterLiveRoom contextId:" + (String)localObject1 + " targetTabId:" + paramInt);
        i = paramInt;
        if (paramInt == 0) {
          i = 88890;
        }
        paramActivity = new Intent();
        paramActivity.putExtra("key_context_id", (String)localObject1);
        com.tencent.mm.plugin.finder.nearby.preload.a.a(paramActivity, i, 11);
      }
      AppMethodBeat.o(340720);
      return;
      break;
      label988:
      str = null;
      break label190;
      label994:
      break label200;
      label997:
      localObject2 = localObject1;
      break label330;
      label1004:
      i = 0;
      break label573;
      label1010:
      bool = false;
      break label652;
      label1016:
      ((bcl)localObject3).ZNx = "NearbyEntrance";
      break label715;
    }
    label1033:
    Log.i("NearbyEnterTargetLiveRoomChecker", "getTargetLiveId return for hit cache.");
    paramActivity = paramActivity.liveInfo;
    if (paramActivity == null) {}
    for (paramActivity = null;; paramActivity = Long.valueOf(paramActivity.liveId))
    {
      paramString1 = String.valueOf(paramActivity);
      paramActivity = paramString1;
      if (paramString1 != null) {
        break;
      }
      paramActivity = "";
      break;
    }
  }
  
  private static boolean eEQ()
  {
    AppMethodBeat.i(340689);
    com.tencent.d.a.a.a.a.a locala = com.tencent.d.a.a.a.a.a.ahiX;
    if (((Number)com.tencent.d.a.a.a.a.a.jSb().bmg()).intValue() == 1)
    {
      AppMethodBeat.o(340689);
      return true;
    }
    AppMethodBeat.o(340689);
    return false;
  }
  
  private static String eER()
  {
    Object localObject2 = null;
    AppMethodBeat.i(340701);
    com.tencent.mm.ad.i locali = new com.tencent.mm.ad.i();
    label318:
    for (;;)
    {
      try
      {
        localObject1 = com.tencent.mm.plugin.finder.nearby.abtest.a.EHr;
        if (!com.tencent.mm.plugin.finder.nearby.abtest.a.eEi()) {
          continue;
        }
        localObject1 = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager();
        if (localObject1 != null) {
          continue;
        }
        localObject1 = null;
        localObject2 = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager();
        if (localObject2 != null) {
          continue;
        }
        localObject2 = null;
        if ((localObject2 != null) && (localObject1 != null))
        {
          localObject3 = ((p)localObject2).eav();
          JSONObject localJSONObject = com.tencent.mm.ae.f.dg(localObject3);
          locali.n("reddotctrltype", Long.valueOf(((p)localObject2).field_ctrInfo.type));
          locali.n("reddottipsid", ((p)localObject2).field_tipsId);
          locali.n("reddotshowinfopath", ((bxq)localObject1).path);
          locali.n("reddotshowinfoext", localJSONObject.get("report_ext_info"));
          locali.n("feedid", com.tencent.mm.ae.d.hF(((FinderTipsShowEntranceExtInfo)localObject3).object_id));
          locali.n("username", ((p)localObject2).ASz.YIZ);
        }
      }
      catch (Exception localException)
      {
        Object localObject1;
        Object localObject3;
        Log.e("NearbyEnterTargetLiveRoomChecker", s.X("genChnlExtra fail! ex:", localException.getMessage()));
        continue;
      }
      Log.i("NearbyEnterTargetLiveRoomChecker", s.X("genChnlExtra:", locali));
      localObject1 = locali.toString();
      s.s(localObject1, "chnlExtra.toString()");
      localObject1 = n.m((String)localObject1, ",", ";", false);
      AppMethodBeat.o(340701);
      return localObject1;
      localObject1 = ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject1).avp("FinderLiveEntrance");
      continue;
      localObject2 = ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject2).Su("FinderLiveEntrance");
      continue;
      localObject1 = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager();
      if (localObject1 == null)
      {
        localObject1 = null;
        localObject3 = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager();
        if (localObject3 == null) {
          break label318;
        }
      }
      else
      {
        localObject1 = ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject1).avp("NearbyEntrance");
        continue;
      }
      localObject2 = ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject3).Su("NearbyEntrance");
    }
  }
  
  public static void reset()
  {
    AppMethodBeat.i(340742);
    AWv = false;
    EJI.clear();
    EJJ = null;
    AppMethodBeat.o(340742);
  }
  
  public final void a(long paramLong, String paramString, int paramInt, kotlin.g.a.b<? super FinderObject, ah> paramb)
  {
    AppMethodBeat.i(340771);
    if ((paramLong == -1L) || (paramLong == 0L))
    {
      Log.w("NearbyEnterTargetLiveRoomChecker", s.X("checkEnterTargetLiveRoom return for targetObjectId:", Long.valueOf(paramLong)));
      AppMethodBeat.o(340771);
      return;
    }
    Log.i("NearbyEnterTargetLiveRoomChecker", "checkEnterTargetLiveRoom targetObjectId:" + paramLong + " targetObjectNonceId:" + paramString);
    bui localbui = new bui();
    localbui.hLK = paramInt;
    localbui.AJo = paramInt;
    if (paramString == null) {
      paramString = "";
    }
    for (;;)
    {
      a(paramLong, paramString, localbui, paramb);
      AppMethodBeat.o(340771);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.base.b
 * JD-Core Version:    0.7.0.1
 */
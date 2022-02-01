package com.tencent.mm.plugin.finder.utils;

import com.tencent.d.a.a.a.b.b.g;
import com.tencent.d.a.a.a.b.b.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.api.LiveConfig.a;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.live.model.context.a;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.protocal.protobuf.awr;
import com.tencent.mm.protocal.protobuf.bgr;
import com.tencent.mm.protocal.protobuf.bv;
import com.tencent.mm.protocal.protobuf.bw;
import com.tencent.mm.protocal.protobuf.cdp;
import com.tencent.mm.protocal.protobuf.ctt;
import com.tencent.mm.protocal.protobuf.dcg;
import com.tencent.mm.protocal.protobuf.dch;
import com.tencent.mm.protocal.protobuf.deq;
import com.tencent.mm.protocal.protobuf.der;
import com.tencent.mm.protocal.protobuf.dz;
import com.tencent.mm.protocal.protobuf.epb;
import com.tencent.mm.protocal.protobuf.fgz;
import com.tencent.mm.protocal.protobuf.fom;
import com.tencent.mm.protocal.protobuf.fsf;
import com.tencent.mm.protocal.protobuf.fvf;
import com.tencent.mm.protocal.protobuf.rv;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/OlympicsCommon;", "", "()V", "TAG", "", "joinLiveTime", "", "getJoinLiveTime", "()J", "setJoinLiveTime", "(J)V", "debugLog", "", "tag", "log", "getMockStreamStatus", "", "default", "clone", "Lcom/tencent/mm/protocal/protobuf/SportActivity;", "stageBoardInfo", "Lcom/tencent/mm/protocal/protobuf/ActivityStageBoardInfo;", "getEventInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveEventInfo;", "Lcom/tencent/mm/live/api/LiveConfig;", "hasVideoStream", "", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "isOlympicsLive", "logInfo", "Lcom/tencent/mm/protocal/protobuf/ActivityStage;", "Lcom/tencent/mm/protocal/protobuf/AddTorchCertRequest;", "Lcom/tencent/mm/protocal/protobuf/AddTorchCertResponse;", "Lcom/tencent/mm/protocal/protobuf/BoardIndexInfo;", "Lcom/tencent/mm/protocal/protobuf/GetActivityBoardRequest;", "Lcom/tencent/mm/protocal/protobuf/GetActivityBoardResponse;", "Lcom/tencent/mm/protocal/protobuf/GetActivityInfoRequest;", "Lcom/tencent/mm/protocal/protobuf/GetActivityInfoResponse;", "Lcom/tencent/mm/protocal/protobuf/GetTorchCertRequest;", "Lcom/tencent/mm/protocal/protobuf/GetTorchCertResponse;", "Lcom/tencent/mm/protocal/protobuf/InitTorchLiveRequest;", "Lcom/tencent/mm/protocal/protobuf/InitTorchLiveResponse;", "Lcom/tencent/mm/protocal/protobuf/JoinRunWithRequest;", "Lcom/tencent/mm/protocal/protobuf/JoinRunWithResponse;", "Lcom/tencent/mm/protocal/protobuf/RelatedEventInfo;", "Lcom/tencent/mm/protocal/protobuf/TorchCert;", "Lcom/tencent/mm/protocal/protobuf/UpdateTorchCertRequest;", "Lcom/tencent/mm/protocal/protobuf/UpdateTorchCertResponse;", "Lcom/tencent/mm/protocal/protobuf/UserLocation;", "setLiveEventInfo", "Lcom/tencent/mm/live/api/LiveConfig$LiveConfigBuilder;", "eventInfo", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bj
{
  public static final bj GlQ;
  private static long Glc;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(333389);
    GlQ = new bj();
    TAG = "Finder.OlympicsCommon";
    AppMethodBeat.o(333389);
  }
  
  public static int Uy(int paramInt)
  {
    AppMethodBeat.i(333383);
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED))
    {
      com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
      switch (((Number)com.tencent.mm.plugin.finder.storage.d.eSJ().bmg()).intValue())
      {
      default: 
        AppMethodBeat.o(333383);
        return paramInt;
      case 1: 
        AppMethodBeat.o(333383);
        return 0;
      case 2: 
        if ((Glc > 0L) && (cn.bDw() - Glc > 10000L))
        {
          AppMethodBeat.o(333383);
          return 0;
        }
        AppMethodBeat.o(333383);
        return 1;
      case 3: 
        if ((Glc > 0L) && (cn.bDw() - Glc > 10000L))
        {
          AppMethodBeat.o(333383);
          return 1;
        }
        AppMethodBeat.o(333383);
        return 0;
      }
      AppMethodBeat.o(333383);
      return 1;
    }
    AppMethodBeat.o(333383);
    return paramInt;
  }
  
  public static LiveConfig.a a(LiveConfig.a parama, String paramString, bgr parambgr)
  {
    AppMethodBeat.i(333203);
    s.u(parama, "<this>");
    s.u(paramString, "tag");
    if (parambgr != null)
    {
      parama.mIY = parambgr.mIY;
      parama.mIZ = parambgr.mIZ;
      parama.mJa = parambgr.mJa;
      parama.mJb = parambgr.mJb;
      String str = TAG;
      paramString = new StringBuilder("setLiveEventInfo ").append(paramString).append(", objectId:").append(com.tencent.mm.ae.d.hF(parama.mIH)).append(", liveId:").append(com.tencent.mm.ae.d.hF(parama.liveId)).append(", username:").append(parama.mIC).append(", ");
      s.u(parambgr, "<this>");
      Log.i(str, new StringBuilder("event_id:").append(parambgr.mIY).append(", participant_identity:").append(parambgr.mIZ).append(", event_status:").append(parambgr.mJa).append(", stream_status:").append(parambgr.mJb).toString());
    }
    for (;;)
    {
      AppMethodBeat.o(333203);
      return parama;
      parama.mIY = 0;
      Log.i(TAG, "setLiveEventInfo " + paramString + ", objectId:" + com.tencent.mm.ae.d.hF(parama.mIH) + ", liveId:" + com.tencent.mm.ae.d.hF(parama.liveId) + ", username:" + parama.mIC + ", null");
    }
  }
  
  public static fgz a(fgz paramfgz, bw parambw)
  {
    AppMethodBeat.i(333323);
    s.u(paramfgz, "<this>");
    s.u(parambw, "stageBoardInfo");
    fgz localfgz = new fgz();
    localfgz.Vyi = paramfgz.Vyi;
    localfgz.abHo = paramfgz.abHo;
    localfgz.abHp = new LinkedList();
    Object localObject = paramfgz.abHp;
    s.s(localObject, "this.stages");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      bv localbv1 = (bv)((Iterator)localObject).next();
      bv localbv2 = new bv();
      localbv2.YDA = localbv1.YDA;
      localbv2.YDB = localbv1.YDB;
      localbv2.ftu = localbv1.ftu;
      localbv2.end_time = localbv1.end_time;
      localbv2.YDC = new LinkedList((Collection)p.al(new bw[] { parambw }));
      localfgz.abHp.add(localbv2);
    }
    localfgz.abHq = paramfgz.abHq;
    localfgz.abHr = paramfgz.abHr;
    AppMethodBeat.o(333323);
    return localfgz;
  }
  
  public static String a(bv parambv)
  {
    AppMethodBeat.i(333303);
    s.u(parambv, "<this>");
    StringBuilder localStringBuilder = new StringBuilder("stage_id:").append(parambv.YDA).append(", stage_name:").append(parambv.YDB).append(", stage_board_info:");
    parambv = parambv.YDC;
    s.s(parambv, "stage_board_info");
    parambv = p.a((Iterable)parambv, null, null, null, 0, null, (kotlin.g.a.b)a.GlR, 31) + ", ";
    AppMethodBeat.o(333303);
    return parambv;
  }
  
  public static String a(bw parambw)
  {
    AppMethodBeat.i(333308);
    s.u(parambw, "<this>");
    parambw = "board_scene:" + parambw.YDD + ", board_name:" + parambw.YDE + ", top_count:" + parambw.YDF + ", board_max_count:" + parambw.YDG + ", board_index:" + parambw.YDH + ", ";
    AppMethodBeat.o(333308);
    return parambw;
  }
  
  public static String a(cdp paramcdp)
  {
    Object localObject2 = null;
    StringBuilder localStringBuilder = null;
    AppMethodBeat.i(333334);
    s.u(paramcdp, "<this>");
    Object localObject3 = new StringBuilder("scene:").append(paramcdp.scene).append(", activity_id:").append(paramcdp.Vyi).append(", wx_username:").append(paramcdp.aanS).append(", last_ctx:");
    Object localObject1 = paramcdp.aanT;
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = Integer.valueOf(((com.tencent.mm.bx.b)localObject1).hashCode()))
    {
      localObject1 = ((StringBuilder)localObject3).append(localObject1).append(", stage_id:").append(paramcdp.YDA).append(", board_index:").append(paramcdp.YDH).append(", live_id:").append(com.tencent.mm.ae.d.hF(paramcdp.mMJ)).append(", board_index_info:");
      localObject3 = paramcdp.aanU;
      if (localObject3 != null) {
        break;
      }
      paramcdp = localStringBuilder;
      paramcdp = paramcdp + ", ";
      AppMethodBeat.o(333334);
      return paramcdp;
    }
    s.u(localObject3, "<this>");
    localStringBuilder = new StringBuilder("board_index_scene:").append(((rv)localObject3).YWG).append(", board_index:").append(((rv)localObject3).YDH).append(", location:");
    paramcdp = ((rv)localObject3).YWH;
    if (paramcdp == null)
    {
      paramcdp = null;
      label237:
      localStringBuilder = localStringBuilder.append(paramcdp).append(',');
      paramcdp = ((rv)localObject3).YWH;
      if (paramcdp != null) {
        break label283;
      }
    }
    label283:
    for (paramcdp = localObject2;; paramcdp = Float.valueOf(paramcdp.latitude))
    {
      paramcdp = paramcdp;
      break;
      paramcdp = Float.valueOf(paramcdp.longitude);
      break label237;
    }
  }
  
  public static String a(ctt paramctt)
  {
    AppMethodBeat.i(333251);
    s.u(paramctt, "<this>");
    AppMethodBeat.o(333251);
    return "";
  }
  
  public static String a(dcg paramdcg)
  {
    AppMethodBeat.i(333220);
    s.u(paramdcg, "<this>");
    paramdcg = s.X("source:", Integer.valueOf(paramdcg.source));
    AppMethodBeat.o(333220);
    return paramdcg;
  }
  
  public static String a(dch paramdch)
  {
    AppMethodBeat.i(333232);
    s.u(paramdch, "<this>");
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("ret:");
    Object localObject = paramdch.YGg;
    if (localObject == null)
    {
      localObject = null;
      localStringBuilder2 = localStringBuilder2.append(localObject).append(", msg:");
      localObject = paramdch.YGg;
      if (localObject != null) {
        break label283;
      }
    }
    label283:
    for (localObject = null;; localObject = ((awr)localObject).msg)
    {
      localStringBuilder2.append(localObject).append(", start_remaining_time:").append(paramdch.aaHY).append(", is_torcher:").append(paramdch.aaHZ).append(", torcher_total:").append(paramdch.aaIa).append(", cert_id:").append(com.tencent.mm.ae.d.hF(paramdch.aaIb)).append(", is_light_torch:").append(paramdch.YGe).append(", is_start:").append(paramdch.aaIc).append(",is_auto_add:").append(paramdch.YGf).append(",name:").append(paramdch.name).append(",is_join_run_with:").append(paramdch.aaId).append(",join_run_with_total:");
      localObject = localStringBuilder1.append(paramdch.aaIe).append(",start_remaining_day:").append(paramdch.aaIf).append(",bgm_urls:");
      paramdch = paramdch.aaIg;
      s.s(paramdch, "bgm_urls");
      ((StringBuilder)localObject).append(p.a((Iterable)paramdch, (CharSequence)"  ", null, null, 0, null, null, 62));
      paramdch = localStringBuilder1.toString();
      AppMethodBeat.o(333232);
      return paramdch;
      localObject = Integer.valueOf(((awr)localObject).ret);
      break;
    }
  }
  
  public static String a(deq paramdeq)
  {
    AppMethodBeat.i(333284);
    s.u(paramdeq, "<this>");
    paramdeq = "longitude:" + paramdeq.longitude + ", latitude:" + paramdeq.latitude;
    AppMethodBeat.o(333284);
    return paramdeq;
  }
  
  public static String a(der paramder)
  {
    Object localObject2 = null;
    AppMethodBeat.i(333291);
    s.u(paramder, "<this>");
    StringBuilder localStringBuilder = new StringBuilder("ret:");
    Object localObject1 = paramder.YGg;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject1 = localStringBuilder.append(localObject1).append(", msg:");
      paramder = paramder.YGg;
      if (paramder != null) {
        break label87;
      }
    }
    label87:
    for (paramder = localObject2;; paramder = paramder.msg)
    {
      paramder = paramder;
      AppMethodBeat.o(333291);
      return paramder;
      localObject1 = Integer.valueOf(((awr)localObject1).ret);
      break;
    }
  }
  
  public static String a(dz paramdz)
  {
    AppMethodBeat.i(333241);
    s.u(paramdz, "<this>");
    paramdz = "from_wx_username:" + paramdz.YGc + ", from_finder_username:" + paramdz.YGd + ", name:" + paramdz.name + ", longitude:" + paramdz.longitude + ", latitude:" + paramdz.latitude + ", is_light_torch:" + paramdz.YGe;
    AppMethodBeat.o(333241);
    return paramdz;
  }
  
  public static String a(epb paramepb)
  {
    AppMethodBeat.i(333341);
    s.u(paramepb, "<this>");
    paramepb = "related_event_type:" + paramepb.abtl + ", related_event_id:" + paramepb.abtm;
    AppMethodBeat.o(333341);
    return paramepb;
  }
  
  public static String a(fsf paramfsf)
  {
    AppMethodBeat.i(333263);
    s.u(paramfsf, "<this>");
    paramfsf = "name:" + paramfsf.name + ", longitude:" + paramfsf.longitude + ", latitude:" + paramfsf.latitude + ", is_show_sport_step:" + paramfsf.abOW + ", is_access_location:" + paramfsf.abOV;
    AppMethodBeat.o(333263);
    return paramfsf;
  }
  
  public static String a(fvf paramfvf)
  {
    AppMethodBeat.i(333346);
    s.u(paramfvf, "<this>");
    paramfvf = "longitude:" + paramfvf.longitude + ", latitude:" + paramfvf.latitude;
    AppMethodBeat.o(333346);
    return paramfvf;
  }
  
  public static bgr b(LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(333212);
    s.u(paramLiveConfig, "<this>");
    bgr localbgr = null;
    if (paramLiveConfig.mIY != 0)
    {
      localbgr = new bgr();
      localbgr.mIY = paramLiveConfig.mIY;
      localbgr.mIZ = paramLiveConfig.mIZ;
      localbgr.mJa = paramLiveConfig.mJa;
      localbgr.mJb = paramLiveConfig.mJb;
    }
    AppMethodBeat.o(333212);
    return localbgr;
  }
  
  public static String b(fgz paramfgz)
  {
    AppMethodBeat.i(333313);
    s.u(paramfgz, "<this>");
    StringBuilder localStringBuilder = new StringBuilder("activity_id:").append(paramfgz.Vyi).append(", activity_name:").append(paramfgz.abHo).append(", stages:[");
    LinkedList localLinkedList = paramfgz.abHp;
    s.s(localLinkedList, "stages");
    paramfgz = p.a((Iterable)localLinkedList, null, null, null, 0, null, (kotlin.g.a.b)b.GlS, 31) + "], begin_time_s:" + paramfgz.abHq + ", end_time_s:" + paramfgz.abHr + '!';
    AppMethodBeat.o(333313);
    return paramfgz;
  }
  
  public static String b(fom paramfom)
  {
    AppMethodBeat.i(333274);
    s.u(paramfom, "<this>");
    paramfom = "cert_id:" + com.tencent.mm.ae.d.hF(paramfom.aaIb) + ", name:" + paramfom.name + ", locations:" + paramfom.CPm + ", from_nickname:" + paramfom.aaYz + ", from_icon:" + paramfom.abOT + ", sport_step:" + paramfom.abOU + ", is_join_run_with:" + paramfom.aaId + ", is_show_sport_step:" + paramfom.abOW + ", is_access_location:" + paramfom.abOV + ", is_light_torch:" + paramfom.YGe;
    AppMethodBeat.o(333274);
    return paramfom;
  }
  
  public static void hf(String paramString1, String paramString2)
  {
    AppMethodBeat.i(333371);
    s.u(paramString1, "tag");
    s.u(paramString2, "log");
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED)) {
      Log.i(paramString1, paramString2);
    }
    AppMethodBeat.o(333371);
  }
  
  public static void qR(long paramLong)
  {
    Glc = paramLong;
  }
  
  public static boolean y(a parama)
  {
    AppMethodBeat.i(333354);
    s.u(parama, "<this>");
    int i = ((e)parama.business(e.class)).mIY;
    parama = b.g.ahoC;
    if (i == b.g.a.jWh())
    {
      AppMethodBeat.o(333354);
      return true;
    }
    AppMethodBeat.o(333354);
    return false;
  }
  
  public static boolean z(a parama)
  {
    AppMethodBeat.i(333362);
    s.u(parama, "<this>");
    if (((e)parama.business(e.class)).mJb == 1)
    {
      AppMethodBeat.o(333362);
      return true;
    }
    AppMethodBeat.o(333362);
    return false;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/ActivityStageBoardInfo;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.b<bw, CharSequence>
  {
    public static final a GlR;
    
    static
    {
      AppMethodBeat.i(333449);
      GlR = new a();
      AppMethodBeat.o(333449);
    }
    
    a()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/ActivityStage;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<bv, CharSequence>
  {
    public static final b GlS;
    
    static
    {
      AppMethodBeat.i(333450);
      GlS = new b();
      AppMethodBeat.o(333450);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.bj
 * JD-Core Version:    0.7.0.1
 */
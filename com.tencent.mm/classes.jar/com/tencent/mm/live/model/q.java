package com.tencent.mm.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/LiveSysMsgReceiver;", "Lcom/tencent/mm/plugin/messenger/foundation/api/INewXmlReceived;", "()V", "onNewXmlReceived", "", "subType", "", "values", "", "addMsgInfo", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "Companion", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
  implements t
{
  public static final q.a mZh;
  
  static
  {
    AppMethodBeat.i(246523);
    mZh = new q.a((byte)0);
    AppMethodBeat.o(246523);
  }
  
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, g.a parama)
  {
    AppMethodBeat.i(246558);
    if (paramString != null) {}
    switch (paramString.hashCode())
    {
    default: 
      AppMethodBeat.o(246558);
      return;
    case 1533908605: 
      if (paramString.equals("LiveMicSucc")) {
        break label1509;
      }
      AppMethodBeat.o(246558);
      return;
    case 214701709: 
      if (!paramString.equals("ApplyLiveMic"))
      {
        AppMethodBeat.o(246558);
        return;
      }
      break;
    case -650051483: 
      if (paramString.equals("CloseApplyLiveMic")) {
        break label1192;
      }
      AppMethodBeat.o(246558);
      return;
    case 1521247972: 
      if (paramString.equals("CloseLive")) {
        break label913;
      }
      AppMethodBeat.o(246558);
      return;
    case -996496189: 
      if (paramString.equals("CloseLiveMic")) {
        break label1014;
      }
      AppMethodBeat.o(246558);
      return;
    case 1047354468: 
      if (paramString.equals("BanLiveComment")) {
        break label1337;
      }
      AppMethodBeat.o(246558);
      return;
    case -594567309: 
      if (paramString.equals("AcceptLiveMic")) {
        break label484;
      }
      AppMethodBeat.o(246558);
      return;
    case 1331847997: 
      if (paramString.equals("OnlineLiveList")) {
        break label1822;
      }
      AppMethodBeat.o(246558);
      return;
    }
    long l1;
    label234:
    label241:
    String str;
    if (paramMap == null)
    {
      paramString = null;
      l1 = Util.getLong(paramString, 0L);
      if (paramMap != null) {
        break label381;
      }
      paramString = "";
      if (paramMap != null) {
        break label406;
      }
      parama = "";
      if (paramMap != null) {
        break label431;
      }
      str = "";
      label249:
      if (paramMap != null) {
        break label459;
      }
      paramMap = "";
    }
    Object localObject1;
    for (;;)
    {
      localObject1 = p.mZf;
      localObject1 = p.bhS();
      if (localObject1 != null)
      {
        ((g)localObject1).onApplyLiveMic(new b(l1, paramString, parama, str, paramMap));
        localObject1 = ah.aiuX;
      }
      Log.i("MicroMsg.LiveSysMsgReceiver", "receive apply live mic newxml. liveId:" + l1 + " micId:" + paramString + " uid:" + parama + " roomId:" + str + " sdkUid:" + paramMap);
      paramString = ah.aiuX;
      AppMethodBeat.o(246558);
      return;
      paramString = (String)paramMap.get(".sysmsg.mmlive.live_id");
      break;
      label381:
      paramString = (String)paramMap.get(".sysmsg.mmlive.live_mic_id");
      if (paramString == null)
      {
        paramString = "";
        break label234;
      }
      break label234;
      label406:
      parama = (String)paramMap.get(".sysmsg.mmlive.identity_id");
      if (parama == null)
      {
        parama = "";
        break label241;
      }
      break label241;
      label431:
      str = (String)paramMap.get(".sysmsg.mmlive.roomid");
      if (str == null)
      {
        str = "";
        break label249;
      }
      break label249;
      label459:
      paramMap = (String)paramMap.get(".sysmsg.mmlive.mic_sdk_user_id");
      if (paramMap == null) {
        paramMap = "";
      }
    }
    label484:
    label504:
    label510:
    int i;
    label525:
    label531:
    int j;
    label544:
    int k;
    label559:
    Object localObject2;
    label567:
    label573:
    long l2;
    if (paramMap == null)
    {
      paramString = null;
      l1 = Util.getLong(paramString, 0L);
      if (paramMap != null) {
        break label698;
      }
      parama = "";
      if (paramMap != null) {
        break label723;
      }
      paramString = null;
      i = Util.getInt(paramString, 0);
      if (paramMap != null) {
        break label738;
      }
      str = "";
      if (paramMap != null) {
        break label766;
      }
      paramString = null;
      j = Util.getInt(paramString, 0);
      if (paramMap != null) {
        break label781;
      }
      paramString = null;
      k = Util.getInt(paramString, 0);
      if (paramMap != null) {
        break label796;
      }
      localObject1 = "";
      if (paramMap != null) {
        break label824;
      }
      localObject2 = "";
      if (paramMap != null) {
        break label852;
      }
      paramString = null;
      l2 = Util.getLong(paramString, 300L);
      if (paramMap != null) {
        break label867;
      }
      paramString = null;
    }
    for (;;)
    {
      paramMap = p.mZf;
      paramMap = p.bhS();
      if (paramMap != null)
      {
        paramMap.onAcceptLiveMic(new a(l1, parama, str, i, k, j, (String)localObject1, (String)localObject2, l2, paramString, null, 0L, null, false, 31744));
        paramString = ah.aiuX;
      }
      Log.i("MicroMsg.LiveSysMsgReceiver", "receive accept live mic newxml. liveId:" + l1 + " micId:" + parama);
      paramString = ah.aiuX;
      AppMethodBeat.o(246558);
      return;
      paramString = (String)paramMap.get(".sysmsg.mmlive.live_id");
      break;
      label698:
      parama = (String)paramMap.get(".sysmsg.mmlive.live_mic_id");
      if (parama == null)
      {
        parama = "";
        break label504;
      }
      break label504;
      label723:
      paramString = (String)paramMap.get(".sysmsg.mmlive.live_sdk_info.sdk_appid");
      break label510;
      label738:
      str = (String)paramMap.get(".sysmsg.mmlive.live_sdk_info.sdk_user_id");
      if (str == null)
      {
        str = "";
        break label525;
      }
      break label525;
      label766:
      paramString = (String)paramMap.get(".sysmsg.mmlive.live_sdk_info.sdk_live_id");
      break label531;
      label781:
      paramString = (String)paramMap.get(".sysmsg.mmlive.live_sdk_info.sdk_role_id");
      break label544;
      label796:
      localObject1 = (String)paramMap.get(".sysmsg.mmlive.live_sdk_info.sdk_user_sig");
      if (localObject1 == null)
      {
        localObject1 = "";
        break label559;
      }
      break label559;
      label824:
      localObject2 = (String)paramMap.get(".sysmsg.mmlive.live_sdk_info.sdk_private_map_key");
      if (localObject2 == null)
      {
        localObject2 = "";
        break label567;
      }
      break label567;
      label852:
      paramString = (String)paramMap.get(".sysmsg.mmlive.live_sdk_info.expire_for_pmk");
      break label573;
      label867:
      paramString = (String)paramMap.get(".sysmsg.mmlive.live_sdk_info.sdk_params");
      if (paramString == null)
      {
        paramString = null;
      }
      else
      {
        paramMap = paramString.getBytes(kotlin.n.d.UTF_8);
        kotlin.g.b.s.s(paramMap, "(this as java.lang.String).getBytes(charset)");
        paramString = paramMap;
        if (paramMap == null) {
          paramString = null;
        }
      }
    }
    label913:
    if (paramMap == null) {}
    for (paramString = null;; paramString = (String)paramMap.get(".sysmsg.mmlive.live_id"))
    {
      l1 = Util.getLong(paramString, 0L);
      com.tencent.mm.live.model.c.c.getLiveTipsBarStorage().hT(l1);
      paramString = com.tencent.mm.live.model.c.a.nbR;
      com.tencent.mm.live.model.c.a.hS(l1);
      paramString = p.mZf;
      paramString = p.bhS();
      if (paramString != null)
      {
        paramString.onCloseLive(new e(l1));
        paramString = ah.aiuX;
      }
      Log.i("MicroMsg.LiveSysMsgReceiver", kotlin.g.b.s.X("receive close live newxml liveId:", Long.valueOf(l1)));
      paramString = ah.aiuX;
      AppMethodBeat.o(246558);
      return;
    }
    label1014:
    if (paramMap == null)
    {
      paramString = null;
      l1 = Util.getLong(paramString, 0L);
      if (paramMap != null) {
        break label1142;
      }
      paramString = "";
      if (paramMap != null) {
        break label1168;
      }
      paramMap = "";
    }
    for (;;)
    {
      label1034:
      parama = p.mZf;
      parama = p.bhS();
      if (parama != null)
      {
        parama.onCloseLiveMic(new f(l1, paramString, paramMap));
        parama = ah.aiuX;
      }
      Log.i("MicroMsg.LiveSysMsgReceiver", "receive close mic newxml liveid:" + l1 + " audience:" + paramString + ", micId:" + paramMap);
      paramString = ah.aiuX;
      AppMethodBeat.o(246558);
      return;
      paramString = (String)paramMap.get(".sysmsg.mmlive.live_id");
      break;
      label1142:
      paramString = (String)paramMap.get(".sysmsg.mmlive.audience");
      if (paramString == null)
      {
        paramString = "";
        break label1034;
      }
      break label1034;
      label1168:
      parama = (String)paramMap.get(".sysmsg.mmlive.live_mic_id");
      paramMap = parama;
      if (parama == null) {
        paramMap = "";
      }
    }
    label1192:
    if (paramMap == null)
    {
      paramString = null;
      l1 = Util.getLong(paramString, 0L);
      if (paramMap != null) {
        break label1315;
      }
      paramString = null;
      label1211:
      if (Util.getInt(paramString, 0) != 1) {
        break label1331;
      }
    }
    label1315:
    label1331:
    for (boolean bool = true;; bool = false)
    {
      paramString = p.mZf;
      paramString = p.bhS();
      if (paramString != null)
      {
        paramString.onCloseApplyLiveMic(new d(l1, bool));
        paramString = ah.aiuX;
      }
      Log.i("MicroMsg.LiveSysMsgReceiver", "receive CloseApplyLiveMic newxml liveId:" + l1 + ", " + bool);
      paramString = ah.aiuX;
      AppMethodBeat.o(246558);
      return;
      paramString = (String)paramMap.get(".sysmsg.mmlive.live_id");
      break;
      paramString = (String)paramMap.get(".sysmsg.mmlive.enable_apply_live_mic");
      break label1211;
    }
    label1337:
    if (paramMap == null)
    {
      paramString = null;
      l1 = Util.getLong(paramString, 0L);
      if (paramMap != null) {
        break label1477;
      }
      paramString = null;
      label1356:
      i = Util.getInt(paramString, 0);
      if (paramMap != null) {
        break label1493;
      }
    }
    label1477:
    label1493:
    for (paramString = null;; paramString = (String)paramMap.get(".sysmsg.mmlive.wording"))
    {
      paramString = Util.nullAsNil(paramString);
      paramMap = p.mZf;
      paramMap = p.bhS();
      if (paramMap != null)
      {
        paramMap.onBanLiveComment(new c(l1, i, paramString));
        paramMap = ah.aiuX;
      }
      Log.i("MicroMsg.LiveSysMsgReceiver", "receive ban comment newxml liveId:" + l1 + " enableComment:" + i + " wording:" + paramString);
      paramString = ah.aiuX;
      AppMethodBeat.o(246558);
      return;
      paramString = (String)paramMap.get(".sysmsg.mmlive.live_id");
      break;
      paramString = (String)paramMap.get(".sysmsg.mmlive.enable_comment");
      break label1356;
    }
    label1509:
    if (paramMap == null)
    {
      paramString = null;
      l1 = Util.getLong(paramString, 0L);
      if (paramMap != null) {
        break label1689;
      }
      paramString = "";
      label1529:
      if (paramMap != null) {
        break label1714;
      }
      parama = "";
      if (paramMap != null) {
        break label1740;
      }
      str = "";
      if (paramMap != null) {
        break label1769;
      }
      localObject1 = "";
      if (paramMap != null) {
        break label1797;
      }
      paramMap = "";
    }
    for (;;)
    {
      label1536:
      label1544:
      label1552:
      localObject2 = p.mZf;
      localObject2 = p.bhS();
      if (localObject2 != null)
      {
        ((g)localObject2).onLiveMicSucc(new n(l1, paramString, parama, str, (String)localObject1, paramMap));
        parama = ah.aiuX;
      }
      Log.i("MicroMsg.LiveSysMsgReceiver", "receive live mic success. liveId:" + l1 + " audience:" + paramString + " nickName:" + str + " sdkUid:" + (String)localObject1 + " micId:" + paramMap);
      paramString = ah.aiuX;
      AppMethodBeat.o(246558);
      return;
      paramString = (String)paramMap.get(".sysmsg.mmlive.live_id");
      break;
      label1689:
      paramString = (String)paramMap.get(".sysmsg.mmlive.identity_id");
      if (paramString == null)
      {
        paramString = "";
        break label1529;
      }
      break label1529;
      label1714:
      parama = (String)paramMap.get(".sysmsg.mmlive.headimg");
      if (parama == null)
      {
        parama = "";
        break label1536;
      }
      break label1536;
      label1740:
      str = (String)paramMap.get(".sysmsg.mmlive.nickName");
      if (str == null)
      {
        str = "";
        break label1544;
      }
      break label1544;
      label1769:
      localObject1 = (String)paramMap.get(".sysmsg.mmlive.mic_sdk_user_id");
      if (localObject1 == null)
      {
        localObject1 = "";
        break label1552;
      }
      break label1552;
      label1797:
      paramMap = (String)paramMap.get(".sysmsg.mmlive.live_mic_id");
      if (paramMap == null) {
        paramMap = "";
      }
    }
    label1822:
    Log.i("MicroMsg.LiveSysMsgReceiver", "receive online livelist mmlive.");
    if (paramMap == null)
    {
      paramString = "";
      label1837:
      if (parama != null) {
        break label1940;
      }
      paramMap = null;
      label1843:
      str = w.a(paramMap);
      if (str != null) {
        break label1962;
      }
      str = "";
      label1858:
      if (parama != null) {
        break label1965;
      }
      paramMap = null;
    }
    for (;;)
    {
      parama = w.a(paramMap);
      paramMap = parama;
      if (parama == null) {
        paramMap = "";
      }
      parama = p.mZf;
      parama = p.bhS();
      if (parama == null) {
        break;
      }
      parama.onOnlineLiveList(new s(paramString, str, paramMap));
      paramString = ah.aiuX;
      break;
      paramString = (String)paramMap.get(".sysmsg.mmlive.live_info_list");
      if (paramString == null)
      {
        paramString = "";
        break label1837;
      }
      break label1837;
      label1940:
      paramMap = parama.mpN;
      if (paramMap == null)
      {
        paramMap = null;
        break label1843;
      }
      paramMap = paramMap.YFG;
      break label1843;
      label1962:
      break label1858;
      label1965:
      paramMap = parama.mpN;
      if (paramMap == null) {
        paramMap = null;
      } else {
        paramMap = paramMap.YFF;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.model.q
 * JD-Core Version:    0.7.0.1
 */
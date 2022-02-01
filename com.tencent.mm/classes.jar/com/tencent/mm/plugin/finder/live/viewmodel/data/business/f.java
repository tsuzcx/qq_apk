package com.tencent.mm.plugin.finder.live.viewmodel.data.business;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.live.core.core.e.t;
import com.tencent.mm.live.core.core.model.h;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.aui;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.dix;
import com.tencent.mm.protocal.protobuf.diz;
import com.tencent.mm.protocal.protobuf.fxp;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveCoreSlice;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/IBusiness;", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "liveContext", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "TAG", "", "closeLiveByUser", "", "getCloseLiveByUser", "()Z", "setCloseLiveByUser", "(Z)V", "closeLiveByUserFromFluent", "getCloseLiveByUserFromFluent", "setCloseLiveByUserFromFluent", "finderDescObject", "Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;", "getFinderDescObject", "()Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;", "setFinderDescObject", "(Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;)V", "hasInitWecoin", "getHasInitWecoin", "setHasInitWecoin", "liveCookies", "", "getLiveCookies", "()[B", "setLiveCookies", "([B)V", "value", "Lcom/tencent/mm/protocal/protobuf/FinderLiveInfo;", "liveInfo", "getLiveInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveInfo;", "setLiveInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveInfo;)V", "Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "liveRoomModel", "getLiveRoomModel", "()Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "setLiveRoomModel", "(Lcom/tencent/mm/live/core/core/model/LiveRoomModel;)V", "liveSdkInfo", "Lcom/tencent/mm/protocal/protobuf/LiveSdkInfo;", "getLiveSdkInfo", "()Lcom/tencent/mm/protocal/protobuf/LiveSdkInfo;", "setLiveSdkInfo", "(Lcom/tencent/mm/protocal/protobuf/LiveSdkInfo;)V", "nicknameOption", "getNicknameOption", "()Ljava/lang/String;", "setNicknameOption", "(Ljava/lang/String;)V", "nonceId", "getNonceId", "setNonceId", "objectId", "", "getObjectId", "()J", "setObjectId", "(J)V", "sessionBuffer", "getSessionBuffer", "setSessionBuffer", "uniqueId", "getUniqueId", "setUniqueId", "videoParamsMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/protocal/protobuf/VideoPKParams;", "Lkotlin/collections/HashMap;", "getVideoParamsMap", "()Ljava/util/HashMap;", "setVideoParamsMap", "(Ljava/util/HashMap;)V", "dumpVideoParams", "", "fillMiniInfo", "json", "Lorg/json/JSONObject;", "info", "onCleared", "updateVideoParams", "videoParam", "Lcom/tencent/mm/protocal/protobuf/LiveSdkVideoParams;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends c<com.tencent.mm.plugin.finder.live.model.context.a>
{
  public FinderObjectDesc EeY;
  public boolean EeZ;
  public HashMap<Integer, fxp> Efa;
  private final String TAG;
  public boolean akhc;
  public long hKN;
  public String hTs;
  public bip liveInfo;
  public String mIU;
  public byte[] mZp;
  public dix mZr;
  public h mZu;
  public String nonceId;
  public String sessionBuffer;
  
  public f(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
    AppMethodBeat.i(356707);
    this.TAG = s.X("LiveCoreSlice@", Integer.valueOf(hashCode()));
    this.mZr = new dix();
    this.liveInfo = new bip();
    this.nonceId = "";
    this.sessionBuffer = "";
    this.mIU = "";
    this.hTs = "";
    this.Efa = new HashMap();
    AppMethodBeat.o(356707);
  }
  
  private final void eyN()
  {
    AppMethodBeat.i(356716);
    StringBuilder localStringBuilder = new StringBuilder("------videoParams------\n");
    Iterator localIterator = ((Map)this.Efa).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localStringBuilder.append(((Number)localEntry.getKey()).intValue() + ":[encResEnum:" + ((fxp)localEntry.getValue()).aaOD + ", capFps:" + ((fxp)localEntry.getValue()).aaOF + ", encBR:" + ((fxp)localEntry.getValue()).aaOG + ", encBR_Min:" + ((fxp)localEntry.getValue()).aaON + "]\n");
    }
    localStringBuilder.append("------videoParams------");
    Log.i(this.TAG, localStringBuilder.toString());
    AppMethodBeat.o(356716);
  }
  
  public final void a(dix paramdix)
  {
    AppMethodBeat.i(356735);
    s.u(paramdix, "<set-?>");
    this.mZr = paramdix;
    AppMethodBeat.o(356735);
  }
  
  public final void awv(String paramString)
  {
    AppMethodBeat.i(356784);
    s.u(paramString, "<set-?>");
    this.mIU = paramString;
    AppMethodBeat.o(356784);
  }
  
  public final void ayp(String paramString)
  {
    AppMethodBeat.i(356787);
    s.u(paramString, "value");
    Log.i(this.TAG, s.X("write uniqueId to:", paramString));
    this.hTs = paramString;
    AppMethodBeat.o(356787);
  }
  
  public final void b(h paramh)
  {
    AppMethodBeat.i(356759);
    this.mZu = paramh;
    com.tencent.mm.plugin.findersdk.f.b localb = com.tencent.mm.plugin.findersdk.f.b.HeJ;
    com.tencent.mm.plugin.findersdk.f.b.iz(this.TAG, s.X("set liveRoomModel ", paramh));
    AppMethodBeat.o(356759);
  }
  
  public final void b(diz paramdiz)
  {
    AppMethodBeat.i(356811);
    if (paramdiz != null)
    {
      Object localObject1 = (Map)this.Efa;
      Object localObject2 = e.t.mMh;
      int i = e.t.bdZ();
      localObject2 = new fxp();
      ((fxp)localObject2).aaOD = paramdiz.aaOD;
      ((fxp)localObject2).aaOF = paramdiz.aaOF;
      ((fxp)localObject2).aaOG = paramdiz.aaOG;
      ((fxp)localObject2).aaON = paramdiz.aaON;
      ((Map)localObject1).put(Integer.valueOf(i), localObject2);
      Map localMap = (Map)this.Efa;
      localObject1 = e.t.mMh;
      i = e.t.bea();
      localObject2 = paramdiz.aaOT;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new fxp();
      }
      localMap.put(Integer.valueOf(i), localObject1);
      localMap = (Map)this.Efa;
      localObject1 = e.t.mMh;
      i = e.t.beb();
      localObject2 = paramdiz.aaOU;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new fxp();
      }
      localMap.put(Integer.valueOf(i), localObject1);
      localObject2 = (Map)this.Efa;
      localObject1 = e.t.mMh;
      i = e.t.bec();
      localObject1 = paramdiz.aaOV;
      paramdiz = (diz)localObject1;
      if (localObject1 == null) {
        paramdiz = new fxp();
      }
      ((Map)localObject2).put(Integer.valueOf(i), paramdiz);
      eyN();
    }
    AppMethodBeat.o(356811);
  }
  
  public final byte[] bid()
  {
    return this.mZp;
  }
  
  public final long ecI()
  {
    return this.hKN;
  }
  
  public final bip getLiveInfo()
  {
    return this.liveInfo;
  }
  
  public final String getNonceId()
  {
    return this.nonceId;
  }
  
  public final String info()
  {
    AppMethodBeat.i(356799);
    String str = "objectId:" + this.hKN + " nicknameOption:" + this.mIU + " liveInfo:" + this.liveInfo.liveId + ' ' + this.liveInfo.ZRW;
    AppMethodBeat.o(356799);
    return str;
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(356792);
    super.onCleared();
    this.hKN = 0L;
    setLiveInfo(new bip());
    this.mZr = new dix();
    this.mZp = null;
    b(null);
    this.EeY = null;
    this.nonceId = "";
    this.sessionBuffer = "";
    this.mIU = "";
    ayp("");
    this.EeZ = false;
    this.Efa.clear();
    this.akhc = false;
    AppMethodBeat.o(356792);
  }
  
  public final void setLiveInfo(bip parambip)
  {
    String str = null;
    AppMethodBeat.i(356752);
    s.u(parambip, "value");
    this.liveInfo = parambip;
    Object localObject2 = this.TAG;
    Object localObject3 = new StringBuilder("#liveInfo set liveId:").append(parambip.liveId).append(", liveStatus:").append(parambip.liveStatus).append(" live_flag=").append(parambip.live_flag).append(" biz_info.username=");
    Object localObject1 = parambip.ZSj;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject1 = ((StringBuilder)localObject3).append(localObject1).append(" liveCharge=");
      localObject3 = com.tencent.mm.plugin.finder.live.view.convert.a.DUC;
      Log.i((String)localObject2, com.tencent.mm.plugin.finder.live.view.convert.a.a(parambip.ZSc));
      if (d.ee(parambip.live_flag, 64))
      {
        localObject2 = (b)business(b.class);
        localObject1 = parambip.ZSj;
        if (localObject1 != null) {
          break label208;
        }
        localObject1 = null;
        label161:
        localObject3 = parambip.ZSj;
        if (localObject3 != null) {
          break label216;
        }
        label172:
        parambip = parambip.ZSj;
        if (parambip != null) {
          break label226;
        }
      }
    }
    label208:
    label216:
    label226:
    for (int i = 0;; i = parambip.ZEN)
    {
      ((b)localObject2).b(true, (String)localObject1, str, i);
      AppMethodBeat.o(356752);
      return;
      localObject1 = ((aui)localObject1).ADE;
      break;
      localObject1 = ((aui)localObject1).ADE;
      break label161;
      str = ((aui)localObject3).YTl;
      break label172;
    }
  }
  
  public final void setNonceId(String paramString)
  {
    AppMethodBeat.i(356772);
    s.u(paramString, "<set-?>");
    this.nonceId = paramString;
    AppMethodBeat.o(356772);
  }
  
  public final void setSessionBuffer(String paramString)
  {
    AppMethodBeat.i(356779);
    s.u(paramString, "<set-?>");
    this.sessionBuffer = paramString;
    AppMethodBeat.o(356779);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.business.f
 * JD-Core Version:    0.7.0.1
 */
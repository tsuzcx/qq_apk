package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.protocal.protobuf.avb;
import com.tencent.mm.protocal.protobuf.azw;
import com.tencent.mm.protocal.protobuf.azx;
import com.tencent.mm.protocal.protobuf.bcl;
import com.tencent.mm.protocal.protobuf.bft;
import com.tencent.mm.protocal.protobuf.bfu;
import com.tencent.mm.protocal.protobuf.bly;
import com.tencent.mm.protocal.protobuf.bmx;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bve;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetLiveRelatedList;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "relScene", "", "lng", "", "lat", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protobuf/ByteString;IFFLcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "objectId", "", "nonceId", "", "sessionBuffer", "scene", "baseRequest", "Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "lbsTabTipsInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLbsTabTipsInfo;", "byPassInfo", "Lcom/tencent/mm/protocal/protobuf/FinderCommByPass;", "readStat", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRelatedListReadStat;", "curIndex", "squareEntranceInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveSquareEntranceInfo;", "(JLjava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;IFFLcom/tencent/mm/protocal/protobuf/FinderBaseRequest;Lcom/tencent/mm/protocal/protobuf/FinderLbsTabTipsInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Lcom/tencent/mm/protocal/protobuf/FinderCommByPass;Ljava/util/LinkedList;ILcom/tencent/mm/protocal/protobuf/FinderLiveSquareEntranceInfo;)V", "TAG", "getBaseRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "setBaseRequest", "(Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;)V", "getByPassInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderCommByPass;", "setByPassInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderCommByPass;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "category", "getCategory", "()Ljava/lang/String;", "setCategory", "(Ljava/lang/String;)V", "getCurIndex", "()I", "setCurIndex", "(I)V", "enterScene", "getEnterScene", "setEnterScene", "feedId", "getFeedId", "()J", "setFeedId", "(J)V", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getLat", "()F", "setLat", "(F)V", "getLbsTabTipsInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLbsTabTipsInfo;", "setLbsTabTipsInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLbsTabTipsInfo;)V", "getLng", "setLng", "getNonceId", "setNonceId", "pullType", "getPullType", "setPullType", "getReadStat", "()Ljava/util/LinkedList;", "setReadStat", "(Ljava/util/LinkedList;)V", "getRelScene", "setRelScene", "request", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveRelatedListRequest;", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderGetLiveRelatedListRequest;", "setRequest", "(Lcom/tencent/mm/protocal/protobuf/FinderGetLiveRelatedListRequest;)V", "requestJson", "Lorg/json/JSONObject;", "responseJson", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "setSectionInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;)V", "getSessionBuffer", "setSessionBuffer", "getSquareEntranceInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveSquareEntranceInfo;", "setSquareEntranceInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveSquareEntranceInfo;)V", "stateWhenRequest", "getStateWhenRequest", "setStateWhenRequest", "actionExt", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFeedRelList", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getRefreshInterval", "getRequestBuffer", "getResponseBuffer", "getType", "hasContinue", "", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "isFetchFeedCgi", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "realInit", "resultExt", "setReqPullType", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class co
  extends com.tencent.mm.plugin.findersdk.b.h
{
  public azw ACo;
  public int ACp;
  private int ACq;
  private bve ACr;
  private atz ACs;
  private bcl ACt;
  private avb ACu;
  private LinkedList<bly> ACv;
  private bmx ACw;
  private final JSONObject ACx;
  private final JSONObject ACy;
  private final String TAG;
  private com.tencent.mm.am.h callback;
  public int enterScene;
  private long feedId;
  private String kDf;
  private final com.tencent.mm.bx.b lastBuffer;
  private String nonceId;
  private float oDT;
  private float oDU;
  public int pullType;
  public c rr;
  private String sessionBuffer;
  private int zVI;
  
  public co(long paramLong, String paramString1, String paramString2, com.tencent.mm.bx.b paramb, int paramInt1, float paramFloat1, float paramFloat2, atz paramatz, bcl parambcl, bui parambui, avb paramavb, LinkedList<bly> paramLinkedList, int paramInt2, bmx parambmx)
  {
    super(parambui);
    AppMethodBeat.i(336650);
    this.TAG = "NetSceneFinderGetLiveRelatedList";
    this.nonceId = "";
    this.sessionBuffer = "";
    this.kDf = "";
    this.ACq = -1;
    this.ACx = new JSONObject();
    this.ACy = new JSONObject();
    this.feedId = paramLong;
    this.nonceId = paramString1;
    this.sessionBuffer = paramString2;
    this.lastBuffer = paramb;
    this.ACq = paramInt1;
    this.oDU = paramFloat1;
    this.oDT = paramFloat2;
    this.ACr = null;
    this.ACs = paramatz;
    this.ACt = parambcl;
    this.ACu = paramavb;
    this.ACv = paramLinkedList;
    this.zVI = paramInt2;
    this.ACw = parambmx;
    paramb = new c.a();
    paramb.funcId = getType();
    paramString1 = new azw();
    kotlin.g.b.s.u(paramString1, "<set-?>");
    this.ACo = paramString1;
    dWa().object_id = this.feedId;
    dWa().object_nonce_id = this.nonceId;
    dWa().longitude = this.oDU;
    dWa().latitude = this.oDT;
    dWa().ZEQ = this.lastBuffer;
    dWa().ZJK = this.sessionBuffer;
    paramatz = dWa();
    paramString2 = this.ACs;
    paramString1 = paramString2;
    if (paramString2 == null)
    {
      paramString1 = bi.ABn;
      paramString1 = bi.a(getContextObj());
    }
    paramatz.YIY = paramString1;
    dWa().scene = this.ACq;
    dWa().ZKE = this.ACt;
    dWa().ZKG = this.ACu;
    dWa().ZER = this.pullType;
    paramString1 = dWa();
    paramString2 = aw.Gjk;
    paramString1.ZKH = aw.fgv();
    dWa().ZKI = this.ACv;
    dWa().ZKJ = this.zVI;
    paramString1 = this.ACw;
    label426:
    label448:
    label471:
    label494:
    boolean bool;
    if (paramString1 == null)
    {
      paramString1 = null;
      paramString1 = (Collection)paramString1;
      if ((paramString1 != null) && (!paramString1.isEmpty())) {
        break label915;
      }
      paramInt1 = 1;
      if (paramInt1 == 0)
      {
        paramString2 = dWa();
        paramString1 = this.ACw;
        if (paramString1 != null) {
          break label921;
        }
        paramString1 = null;
        paramString2.ZKK = paramString1;
        paramString2 = dWa();
        paramString1 = this.ACw;
        if (paramString1 != null) {
          break label929;
        }
        paramString1 = null;
        paramString2.ZKL = paramString1;
        paramString2 = dWa();
        paramString1 = this.ACw;
        if (paramString1 != null) {
          break label937;
        }
        paramString1 = null;
        paramString2.ZKM = paramString1;
      }
      paramb.otE = ((a)dWa());
      paramb.otF = ((a)new azx());
      paramb.uri = "/cgi-bin/micromsg-bin/findergetliverelatedlist";
      paramString1 = paramb.bEF();
      kotlin.g.b.s.s(paramString1, "builder.buildInstance()");
      this.rr = paramString1;
      if (this.enterScene == 3)
      {
        paramString2 = this.rr;
        paramString1 = paramString2;
        if (paramString2 == null)
        {
          kotlin.g.b.s.bIx("rr");
          paramString1 = null;
        }
        paramString1.setIsUserCmd(true);
      }
      this.ACx.put("object_id", this.feedId);
      this.ACx.put("scene", this.ACq);
      paramb = this.TAG;
      paramatz = new StringBuilder();
      paramString2 = paramatz.append("realInit feedId ").append(this.feedId).append("  category ").append(this.kDf).append(" lastBuffer relScene:").append(this.ACq).append(' ').append(this.lastBuffer).append(" tab_tips_path=");
      paramString1 = this.ACt;
      if (paramString1 != null) {
        break label945;
      }
      paramString1 = null;
      label705:
      paramString2 = paramString2.append(paramString1).append("  tabTipsByPassInfo=");
      paramString1 = this.ACt;
      if (paramString1 != null) {
        break label953;
      }
      paramString1 = null;
      label730:
      if (paramString1 == null) {
        break label961;
      }
      bool = true;
      label737:
      paramString2 = paramString2.append(bool).append(" objectId=");
      paramString1 = this.ACt;
      if (paramString1 != null) {
        break label967;
      }
      paramString1 = null;
      label763:
      parambcl = paramString2.append(paramString1).append(" isUserCmd=");
      paramString2 = this.rr;
      paramString1 = paramString2;
      if (paramString2 == null)
      {
        kotlin.g.b.s.bIx("rr");
        paramString1 = null;
      }
      paramString2 = parambcl.append(paramString1.getIsUserCmd()).append(" pullType:").append(dWa().ZER).append(" speed=");
      paramString1 = dWa();
      if (paramString1 != null) {
        break label978;
      }
      paramString1 = null;
      label843:
      paramString2 = paramString2.append(paramString1).append(" readStatSize:");
      paramString1 = this.ACv;
      if (paramString1 != null) {
        break label1017;
      }
    }
    label915:
    label921:
    label929:
    label937:
    label945:
    label953:
    label961:
    label967:
    label978:
    label1017:
    for (paramString1 = null;; paramString1 = Integer.valueOf(paramString1.size()))
    {
      paramString2.append(paramString1).append(" cur_object_index:");
      paramatz.append(this.zVI);
      Log.i(paramb, paramatz.toString());
      AppMethodBeat.o(336650);
      return;
      paramString1 = paramString1.ZVD;
      break;
      paramInt1 = 0;
      break label426;
      paramString1 = paramString1.ZVD;
      break label448;
      paramString1 = paramString1.ZKL;
      break label471;
      paramString1 = paramString1.ZKM;
      break label494;
      paramString1 = paramString1.ZNx;
      break label705;
      paramString1 = paramString1.ZwY;
      break label730;
      bool = false;
      break label737;
      paramString1 = Long.valueOf(paramString1.ZNj);
      break label763;
      paramString1 = paramString1.ZKH;
      if (paramString1 == null)
      {
        paramString1 = null;
        break label843;
      }
      paramString1 = paramString1.ZPF;
      if (paramString1 == null)
      {
        paramString1 = null;
        break label843;
      }
      paramString1 = Integer.valueOf(paramString1.ZPE);
      break label843;
    }
  }
  
  public final void MX(int paramInt)
  {
    AppMethodBeat.i(336659);
    dWa().ZER = paramInt;
    Log.i(this.TAG, kotlin.g.b.s.X("setReqPullType ", Integer.valueOf(paramInt)));
    AppMethodBeat.o(336659);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(336677);
    Log.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString + ", pullType:" + this.pullType);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = this.TAG;
      Object localObject = new StringBuilder("feedId ").append(this.feedId).append(", ");
      bg localbg = bg.ABl;
      Log.i(params, bg.fV((List)dVP()));
      this.ACy.put("count", dVP().size());
      params = ((Iterable)dVP()).iterator();
      while (params.hasNext())
      {
        localObject = (FinderObject)params.next();
        ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).a((FinderObject)localObject, getContextObj());
      }
    }
    if (this.callback != null)
    {
      params = this.callback;
      kotlin.g.b.s.checkNotNull(params);
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(336677);
  }
  
  public final com.tencent.mm.bx.b dVJ()
  {
    AppMethodBeat.i(336684);
    c localc = this.rr;
    Object localObject = localc;
    if (localc == null)
    {
      kotlin.g.b.s.bIx("rr");
      localObject = null;
    }
    localObject = c.c.b(((c)localObject).otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLiveRelatedListResponse");
      AppMethodBeat.o(336684);
      throw ((Throwable)localObject);
    }
    localObject = ((azx)localObject).ZEQ;
    AppMethodBeat.o(336684);
    return localObject;
  }
  
  public final boolean dVN()
  {
    AppMethodBeat.i(336698);
    c localc = this.rr;
    Object localObject = localc;
    if (localc == null)
    {
      kotlin.g.b.s.bIx("rr");
      localObject = null;
    }
    localObject = c.c.b(((c)localObject).otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLiveRelatedListResponse");
      AppMethodBeat.o(336698);
      throw ((Throwable)localObject);
    }
    if (((azx)localObject).BeA != 0)
    {
      AppMethodBeat.o(336698);
      return true;
    }
    AppMethodBeat.o(336698);
    return false;
  }
  
  public final LinkedList<FinderObject> dVP()
  {
    AppMethodBeat.i(336693);
    c localc = this.rr;
    Object localObject = localc;
    if (localc == null)
    {
      kotlin.g.b.s.bIx("rr");
      localObject = null;
    }
    localObject = c.c.b(((c)localObject).otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLiveRelatedListResponse");
      AppMethodBeat.o(336693);
      throw ((Throwable)localObject);
    }
    localObject = ((azx)localObject).object;
    if (localObject == null)
    {
      localObject = new LinkedList();
      AppMethodBeat.o(336693);
      return localObject;
    }
    AppMethodBeat.o(336693);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.findersdk.b.a.b dVi()
  {
    return com.tencent.mm.plugin.findersdk.b.a.b.Hde;
  }
  
  public final JSONObject dVk()
  {
    return this.ACx;
  }
  
  public final JSONObject dVl()
  {
    return this.ACy;
  }
  
  public final azw dWa()
  {
    AppMethodBeat.i(336656);
    azw localazw = this.ACo;
    if (localazw != null)
    {
      AppMethodBeat.o(336656);
      return localazw;
    }
    kotlin.g.b.s.bIx("request");
    AppMethodBeat.o(336656);
    return null;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(336670);
    this.callback = paramh;
    c localc = this.rr;
    paramh = localc;
    if (localc == null)
    {
      kotlin.g.b.s.bIx("rr");
      paramh = null;
    }
    int i = dispatch(paramg, (com.tencent.mm.network.s)paramh, (m)this);
    AppMethodBeat.o(336670);
    return i;
  }
  
  public final int getType()
  {
    return 6479;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.co
 * JD-Core Version:    0.7.0.1
 */
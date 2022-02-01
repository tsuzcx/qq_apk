package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.bx.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bbf;
import com.tencent.mm.protocal.protobuf.bbg;
import com.tencent.mm.protocal.protobuf.btc;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bve;
import com.tencent.mm.protocal.protobuf.bxt;
import com.tencent.mm.protocal.protobuf.bxv;
import com.tencent.mm.protocal.protobuf.epc;
import com.tencent.mm.protocal.protobuf.fok;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.n.d;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetTopicFeed;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "topic", "", "topicType", "", "refObjectId", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "byPassInfo", "(Ljava/lang/String;ILjava/lang/Long;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Ljava/lang/String;)V", "topicId", "(Ljava/lang/Long;JLcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Ljava/lang/String;)V", "eventTopicId", "encryptedTopicId", "innerTabType", "(JLjava/lang/Long;Ljava/lang/String;ILcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Ljava/lang/String;)V", "(Ljava/lang/String;Ljava/lang/Long;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Ljava/lang/String;)V", "topicBuffer", "(Ljava/lang/String;JLcom/tencent/mm/protobuf/ByteString;Ljava/lang/Long;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Ljava/lang/String;)V", "(Ljava/lang/String;Ljava/lang/Long;ILcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Ljava/lang/String;)V", "(Ljava/lang/String;JLcom/tencent/mm/protobuf/ByteString;Ljava/lang/Long;ILcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Ljava/lang/String;)V", "poiClassifyId", "longitude", "", "latitude", "tabType", "topicRecommend", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "(Ljava/lang/String;FFLjava/lang/Long;Lcom/tencent/mm/protobuf/ByteString;ILcom/tencent/mm/protocal/protobuf/RelatedTopic;Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Ljava/lang/String;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "objectList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectList", "()Ljava/util/List;", "setObjectList", "(Ljava/util/List;)V", "pullType", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "selectedTag", "getSelectedTag", "()Ljava/lang/String;", "setSelectedTag", "(Ljava/lang/String;)V", "getTopicType", "setTopicType", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "fillByPassInfo", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderGetTopicListRequest;", "getBgmInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicBgmInfo;", "getContinueFlag", "getDisableFlag", "getFeedList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getFlag", "getMusicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "getRequest", "getRequestTopicId", "getRequestTopicType", "getRespLastBuffer", "getSubTitle", "Lcom/tencent/mm/protocal/protobuf/PoiTopicSubTitle;", "getTabType", "getTopicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "getTopicRecommends", "getTotalCount", "getType", "onCgiEnd", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ct
  extends com.tencent.mm.plugin.findersdk.b.h
{
  public String ACG;
  public int Auy;
  private final String TAG;
  private com.tencent.mm.am.h callback;
  public int pullType;
  public c rr;
  
  public ct(long paramLong, Long paramLong1, String paramString1, int paramInt, b paramb, bui parambui, String paramString2)
  {
    super(parambui);
    AppMethodBeat.i(336638);
    this.TAG = "Finder.NetSceneFinderGetTopicFeed";
    c.a locala = new c.a();
    locala.funcId = getType();
    bbf localbbf = new bbf();
    String str;
    if (paramInt > 2)
    {
      i = 12;
      localbbf.Auy = i;
      localbbf.ADo = paramLong;
      if (paramLong1 != null)
      {
        ((Number)paramLong1).longValue();
        localbbf.Avd = paramLong1.longValue();
      }
      if (!Util.isNullOrNil(paramString1)) {
        localbbf.fromType = 4;
      }
      if (paramString1 != null) {
        break label340;
      }
      str = "";
      label111:
      localbbf.Bbz = str;
      localbbf.ZEQ = paramb;
      localbbf.Bbt = paramInt;
      paramb = bi.ABn;
      localbbf.ZHY = bi.a(parambui);
      a(localbbf, paramString2);
      paramb = bi.ABn;
      paramb = localbbf.ZHY;
      if (parambui != null) {
        break label347;
      }
    }
    label340:
    label347:
    for (int i = 0;; i = parambui.hLK)
    {
      bi.a(paramb, kotlin.a.p.listOf(new r(Integer.valueOf(i), Long.valueOf(localbbf.Avd))));
      locala.otE = ((com.tencent.mm.bx.a)localbbf);
      locala.funcId = getType();
      locala.otF = ((com.tencent.mm.bx.a)new bbg());
      locala.uri = "/cgi-bin/micromsg-bin/findergettopiclist";
      paramb = locala.bEF();
      kotlin.g.b.s.s(paramb, "builder.buildInstance()");
      this.rr = paramb;
      Log.i(this.TAG, "NetSceneFinderGetTopicFeed get eventTopic init eventTopicId:" + paramLong + ", " + paramLong1 + " encryptedTopicId:" + paramString1 + " innerTabType:" + paramInt);
      this.Auy = this.Auy;
      AppMethodBeat.o(336638);
      return;
      i = 7;
      break;
      str = paramString1;
      break label111;
    }
  }
  
  public ct(String paramString1, float paramFloat1, float paramFloat2, Long paramLong, b paramb, int paramInt, epc paramepc, bve parambve, bui parambui, String paramString2)
  {
    super(parambui);
    AppMethodBeat.i(336695);
    this.TAG = "Finder.NetSceneFinderGetTopicFeed";
    c.a locala = new c.a();
    locala.funcId = getType();
    bbf localbbf = new bbf();
    localbbf.Auy = 2;
    localbbf.topic = paramString1;
    localbbf.longitude = paramFloat1;
    localbbf.latitude = paramFloat2;
    localbbf.ZEQ = paramb;
    if (paramLong != null)
    {
      ((Number)paramLong).longValue();
      localbbf.Avd = paramLong.longValue();
    }
    localbbf.ACr = parambve;
    localbbf.fromType = 1;
    if (parambve != null) {
      localbbf.fromType = 2;
    }
    localbbf.hJx = paramInt;
    a(localbbf, paramString2);
    if (paramepc != null)
    {
      paramb = new fok();
      parambve = new LinkedList();
      paramString2 = paramepc.abtn;
      kotlin.g.b.s.s(paramString2, "topicRecommend.topic_list");
      paramString2 = ((Iterable)paramString2).iterator();
      while (paramString2.hasNext()) {
        parambve.add(Long.valueOf(((bxv)paramString2.next()).ADo));
      }
      paramb.abOS = parambve;
      parambve = ah.aiuX;
      localbbf.ZLV = paramb;
      this.ACG = ((bxv)paramepc.abtn.get(0)).topic;
    }
    paramb = bi.ABn;
    localbbf.ZHY = bi.a(parambui);
    paramb = bi.ABn;
    paramb = localbbf.ZHY;
    if (parambui == null) {}
    for (paramInt = 0;; paramInt = parambui.hLK)
    {
      bi.a(paramb, kotlin.a.p.listOf(new r(Integer.valueOf(paramInt), Long.valueOf(localbbf.Avd))));
      locala.otE = ((com.tencent.mm.bx.a)localbbf);
      locala.funcId = getType();
      locala.otF = ((com.tencent.mm.bx.a)new bbg());
      locala.uri = "/cgi-bin/micromsg-bin/findergettopiclist";
      paramb = locala.bEF();
      kotlin.g.b.s.s(paramb, "builder.buildInstance()");
      this.rr = paramb;
      Log.i(this.TAG, "NetSceneFinderGetTopicFeed get poi init: " + paramString1 + ' ' + paramLong);
      this.Auy = this.Auy;
      AppMethodBeat.o(336695);
      return;
    }
  }
  
  private ct(String paramString, long paramLong, b paramb, Long paramLong1, int paramInt, bui parambui)
  {
    super(parambui);
    AppMethodBeat.i(336678);
    this.TAG = "Finder.NetSceneFinderGetTopicFeed";
    c.a locala = new c.a();
    locala.funcId = getType();
    bbf localbbf = new bbf();
    localbbf.Auy = paramInt;
    localbbf.topic = paramString;
    localbbf.ADo = paramLong;
    localbbf.ZEQ = null;
    localbbf.ZLW = paramb;
    if (paramLong1 != null)
    {
      ((Number)paramLong1).longValue();
      localbbf.Avd = paramLong1.longValue();
    }
    paramb = bi.ABn;
    localbbf.ZHY = bi.a(parambui);
    a(localbbf, null);
    paramb = bi.ABn;
    paramb = localbbf.ZHY;
    if (parambui == null) {}
    for (int i = 0;; i = parambui.hLK)
    {
      bi.a(paramb, kotlin.a.p.listOf(new r(Integer.valueOf(i), Long.valueOf(localbbf.Avd))));
      locala.otE = ((com.tencent.mm.bx.a)localbbf);
      locala.funcId = getType();
      locala.otF = ((com.tencent.mm.bx.a)new bbg());
      locala.uri = "/cgi-bin/micromsg-bin/findergettopiclist";
      paramb = locala.bEF();
      kotlin.g.b.s.s(paramb, "builder.buildInstance()");
      this.rr = paramb;
      Log.i(this.TAG, "NetSceneFinderGetTopicFeed get word init: " + paramString + ", " + paramLong1);
      this.Auy = paramInt;
      AppMethodBeat.o(336678);
      return;
    }
  }
  
  private ct(String paramString, long paramLong, b paramb1, Long paramLong1, b paramb2, bve parambve, bui parambui)
  {
    super(parambui);
    AppMethodBeat.i(336665);
    this.TAG = "Finder.NetSceneFinderGetTopicFeed";
    c.a locala = new c.a();
    locala.funcId = getType();
    bbf localbbf = new bbf();
    localbbf.Auy = 5;
    localbbf.topic = paramString;
    localbbf.ADo = paramLong;
    localbbf.ZEQ = paramb2;
    localbbf.ZLW = paramb1;
    if (paramLong1 != null)
    {
      ((Number)paramLong1).longValue();
      localbbf.Avd = paramLong1.longValue();
    }
    localbbf.ACr = parambve;
    paramb1 = bi.ABn;
    localbbf.ZHY = bi.a(parambui);
    a(localbbf, null);
    paramb1 = bi.ABn;
    paramb1 = localbbf.ZHY;
    if (parambui == null) {}
    for (int i = 0;; i = parambui.hLK)
    {
      bi.a(paramb1, kotlin.a.p.listOf(new r(Integer.valueOf(i), Long.valueOf(localbbf.Avd))));
      locala.otE = ((com.tencent.mm.bx.a)localbbf);
      locala.funcId = getType();
      locala.otF = ((com.tencent.mm.bx.a)new bbg());
      locala.uri = "/cgi-bin/micromsg-bin/findergettopiclist";
      paramb1 = locala.bEF();
      kotlin.g.b.s.s(paramb1, "builder.buildInstance()");
      this.rr = paramb1;
      Log.i(this.TAG, "NetSceneFinderGetTopicFeed get word init: " + paramString + ", " + paramLong1);
      this.Auy = this.Auy;
      AppMethodBeat.o(336665);
      return;
    }
  }
  
  public ct(String paramString1, Long paramLong, b paramb, bve parambve, bui parambui, String paramString2)
  {
    super(parambui);
    AppMethodBeat.i(336629);
    this.TAG = "Finder.NetSceneFinderGetTopicFeed";
    c.a locala = new c.a();
    locala.funcId = getType();
    bbf localbbf = new bbf();
    localbbf.Auy = 4;
    localbbf.topic = paramString1;
    localbbf.ZEQ = paramb;
    if (paramLong != null)
    {
      ((Number)paramLong).longValue();
      localbbf.Avd = paramLong.longValue();
    }
    localbbf.ACr = parambve;
    paramb = bi.ABn;
    localbbf.ZHY = bi.a(parambui);
    a(localbbf, paramString2);
    paramb = bi.ABn;
    paramb = localbbf.ZHY;
    if (parambui == null) {}
    for (int i = 0;; i = parambui.hLK)
    {
      bi.a(paramb, kotlin.a.p.listOf(new r(Integer.valueOf(i), Long.valueOf(localbbf.Avd))));
      locala.otE = ((com.tencent.mm.bx.a)localbbf);
      locala.funcId = getType();
      locala.otF = ((com.tencent.mm.bx.a)new bbg());
      locala.uri = "/cgi-bin/micromsg-bin/findergettopiclist";
      paramb = locala.bEF();
      kotlin.g.b.s.s(paramb, "builder.buildInstance()");
      this.rr = paramb;
      Log.i(this.TAG, "NetSceneFinderGetTopicFeed get word init: " + paramString1 + ", " + paramLong);
      this.Auy = 4;
      AppMethodBeat.o(336629);
      return;
    }
  }
  
  public ct(String paramString1, Long paramLong, b paramb, bve parambve, bui parambui, String paramString2, byte paramByte)
  {
    super(parambui);
    AppMethodBeat.i(336654);
    this.TAG = "Finder.NetSceneFinderGetTopicFeed";
    c.a locala = new c.a();
    locala.funcId = getType();
    bbf localbbf = new bbf();
    localbbf.Auy = 1;
    localbbf.topic = paramString1;
    localbbf.ZEQ = paramb;
    if (paramLong != null)
    {
      ((Number)paramLong).longValue();
      localbbf.Avd = paramLong.longValue();
    }
    localbbf.ACr = parambve;
    paramb = bi.ABn;
    localbbf.ZHY = bi.a(parambui);
    a(localbbf, paramString2);
    paramb = bi.ABn;
    paramb = localbbf.ZHY;
    if (parambui == null) {}
    for (paramByte = 0;; paramByte = parambui.hLK)
    {
      bi.a(paramb, kotlin.a.p.listOf(new r(Integer.valueOf(paramByte), Long.valueOf(localbbf.Avd))));
      locala.otE = ((com.tencent.mm.bx.a)localbbf);
      locala.funcId = getType();
      locala.otF = ((com.tencent.mm.bx.a)new bbg());
      locala.uri = "/cgi-bin/micromsg-bin/findergettopiclist";
      paramb = locala.bEF();
      kotlin.g.b.s.s(paramb, "builder.buildInstance()");
      this.rr = paramb;
      Log.i(this.TAG, "NetSceneFinderGetTopicFeed get word init: " + paramString1 + ", " + paramLong);
      this.Auy = this.Auy;
      AppMethodBeat.o(336654);
      return;
    }
  }
  
  private static void a(bbf parambbf, String paramString)
  {
    AppMethodBeat.i(336703);
    if (paramString != null)
    {
      paramString = paramString.getBytes(d.UTF_8);
      kotlin.g.b.s.s(paramString, "(this as java.lang.String).getBytes(charset)");
      parambbf.ZFs = new b(paramString);
    }
    AppMethodBeat.o(336703);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(336720);
    Log.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    Object localObject1;
    Object localObject2;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = this.TAG;
      localObject1 = new StringBuilder("pullType ").append(this.pullType).append(" selectedTag").append(this.ACG).append(' ');
      localObject2 = bg.ABl;
      Log.i(params, bg.fV((List)dVW()));
      params = c.c.b(this.rr.otC);
      if (params == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
        AppMethodBeat.o(336720);
        throw paramString;
      }
      params = (bbg)params;
      localObject1 = com.tencent.mm.plugin.finder.preload.a.EUs;
      localObject1 = params.preloadInfo;
      params = params.object;
      kotlin.g.b.s.s(params, "resp.`object`");
      com.tencent.mm.plugin.finder.preload.a.a((btc)localObject1, (List)params, 817);
    }
    if (this.callback != null)
    {
      params = this.callback;
      kotlin.g.b.s.checkNotNull(params);
      params.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.am.p)this);
    }
    paramString = getContextObj();
    if (paramString != null)
    {
      params = ((Iterable)dVW()).iterator();
      while (params.hasNext())
      {
        localObject1 = (FinderObject)params.next();
        localObject2 = z.FrZ;
        z.a((FinderObject)localObject1, paramString.AJo);
      }
    }
    AppMethodBeat.o(336720);
  }
  
  public final LinkedList<FinderObject> dVW()
  {
    AppMethodBeat.i(336741);
    Object localObject = c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
      AppMethodBeat.o(336741);
      throw ((Throwable)localObject);
    }
    localObject = ((bbg)localObject).object;
    kotlin.g.b.s.s(localObject, "rr.responseProtoBuf as F…picListResponse).`object`");
    AppMethodBeat.o(336741);
    return localObject;
  }
  
  public final b dVY()
  {
    AppMethodBeat.i(165237);
    Object localObject = c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
      AppMethodBeat.o(165237);
      throw ((Throwable)localObject);
    }
    localObject = ((bbg)localObject).lastBuffer;
    AppMethodBeat.o(165237);
    return localObject;
  }
  
  public final int dVZ()
  {
    AppMethodBeat.i(165238);
    Object localObject = c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
      AppMethodBeat.o(165238);
      throw ((Throwable)localObject);
    }
    int i = ((bbg)localObject).continueFlag;
    AppMethodBeat.o(165238);
    return i;
  }
  
  public final int dWh()
  {
    AppMethodBeat.i(336733);
    Object localObject = c.b.b(this.rr.otB);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListRequest");
      AppMethodBeat.o(336733);
      throw ((Throwable)localObject);
    }
    int i = ((bbf)localObject).Auy;
    AppMethodBeat.o(336733);
    return i;
  }
  
  public final long dWi()
  {
    AppMethodBeat.i(165236);
    Object localObject = c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
      AppMethodBeat.o(165236);
      throw ((Throwable)localObject);
    }
    long l = ((bbg)localObject).Bbb;
    AppMethodBeat.o(165236);
    return l;
  }
  
  public final bxv dWj()
  {
    AppMethodBeat.i(336762);
    Object localObject = c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
      AppMethodBeat.o(336762);
      throw ((Throwable)localObject);
    }
    localObject = ((bbg)localObject).ZLU;
    AppMethodBeat.o(336762);
    return localObject;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(165233);
    Object localObject = z.FrZ;
    localObject = getContextObj();
    if (localObject == null) {}
    for (int i = 0;; i = ((bui)localObject).AJo)
    {
      z.SB(i);
      this.callback = paramh;
      i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
      AppMethodBeat.o(165233);
      return i;
    }
  }
  
  public final bxt getBgmInfo()
  {
    AppMethodBeat.i(336759);
    Object localObject = c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
      AppMethodBeat.o(336759);
      throw ((Throwable)localObject);
    }
    localObject = ((bbg)localObject).ZLU;
    if (localObject == null)
    {
      AppMethodBeat.o(336759);
      return null;
    }
    localObject = ((bxv)localObject).aagH;
    AppMethodBeat.o(336759);
    return localObject;
  }
  
  public final int getTabType()
  {
    AppMethodBeat.i(336724);
    Object localObject = c.b.b(this.rr.otB);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListRequest");
      AppMethodBeat.o(336724);
      throw ((Throwable)localObject);
    }
    int i = ((bbf)localObject).Bbt;
    AppMethodBeat.o(336724);
    return i;
  }
  
  public final int getType()
  {
    return 817;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ct
 * JD-Core Version:    0.7.0.1
 */
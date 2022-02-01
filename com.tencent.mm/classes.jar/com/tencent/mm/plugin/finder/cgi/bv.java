package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.b;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.avx;
import com.tencent.mm.protocal.protobuf.avy;
import com.tencent.mm.protocal.protobuf.bhh;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.biv;
import com.tencent.mm.protocal.protobuf.bkq;
import com.tencent.mm.protocal.protobuf.bkr;
import com.tencent.mm.protocal.protobuf.dwb;
import com.tencent.mm.protocal.protobuf.etb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetTopicFeed;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "topic", "", "topicType", "", "refObjectId", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;ILjava/lang/Long;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "topicId", "(Ljava/lang/Long;JLcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "eventTopicId", "encryptedTopicId", "innerTabType", "(JLjava/lang/Long;Ljava/lang/String;ILcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "(Ljava/lang/String;Ljava/lang/Long;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "topicBuffer", "(Ljava/lang/String;JLcom/tencent/mm/protobuf/ByteString;Ljava/lang/Long;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "(Ljava/lang/String;Ljava/lang/Long;ILcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "(Ljava/lang/String;JLcom/tencent/mm/protobuf/ByteString;Ljava/lang/Long;ILcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "poiClassifyId", "longitude", "", "latitude", "tabType", "topicRecommend", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "(Ljava/lang/String;FFLjava/lang/Long;Lcom/tencent/mm/protobuf/ByteString;ILcom/tencent/mm/protocal/protobuf/RelatedTopic;Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "objectList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectList", "()Ljava/util/List;", "setObjectList", "(Ljava/util/List;)V", "pullType", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "selectedTag", "getSelectedTag", "()Ljava/lang/String;", "setSelectedTag", "(Ljava/lang/String;)V", "getTopicType", "setTopicType", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getBgmInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicBgmInfo;", "getContinueFlag", "getDisableFlag", "getFeedList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getFlag", "getMusicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "getRequest", "Lcom/tencent/mm/protocal/protobuf/FinderGetTopicListRequest;", "getRequestTopicType", "getRespLastBuffer", "getSubTitle", "Lcom/tencent/mm/protocal/protobuf/PoiTopicSubTitle;", "getTabType", "getTopicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "getTopicRecommends", "getTotalCount", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class bv
  extends com.tencent.mm.plugin.findersdk.b.g
{
  private final String TAG;
  private i callback;
  public int pullType;
  public d rr;
  public int wXA;
  public String xdj;
  
  public bv(long paramLong, Long paramLong1, String paramString, int paramInt, b paramb, bid parambid)
  {
    super(parambid);
    AppMethodBeat.i(280424);
    this.TAG = "Finder.NetSceneFinderGetTopicFeed";
    d.a locala = new d.a();
    locala.vD(getType());
    avx localavx = new avx();
    localavx.wXA = 7;
    localavx.xee = paramLong;
    if (paramLong1 != null)
    {
      ((Number)paramLong1).longValue();
      localavx.wZw = paramLong1.longValue();
    }
    if (!Util.isNullOrNil(paramString)) {
      localavx.fromType = 4;
    }
    if (paramString == null) {}
    for (String str = "";; str = paramString)
    {
      localavx.xEG = str;
      localavx.SDI = paramb;
      localavx.xEw = paramInt;
      paramb = ao.xcj;
      localavx.SFL = ao.a(parambid);
      paramb = ao.xcj;
      paramb = localavx.SFL;
      if (parambid != null) {}
      for (int i = parambid.fGo;; i = 0)
      {
        ao.a(paramb, j.listOf(new o(Integer.valueOf(i), Long.valueOf(localavx.wZw))));
        locala.c((com.tencent.mm.cd.a)localavx);
        locala.vD(getType());
        locala.d((com.tencent.mm.cd.a)new avy());
        locala.TW("/cgi-bin/micromsg-bin/findergettopiclist");
        paramb = locala.bgN();
        p.j(paramb, "builder.buildInstance()");
        this.rr = paramb;
        Log.i(this.TAG, "NetSceneFinderGetTopicFeed get eventTopic init eventTopicId:" + paramLong + ", " + paramLong1 + " encryptedTopicId:" + paramString + " innerTabType:" + paramInt);
        this.wXA = this.wXA;
        AppMethodBeat.o(280424);
        return;
      }
    }
  }
  
  public bv(String paramString, float paramFloat1, float paramFloat2, Long paramLong, b paramb, int paramInt, dwb paramdwb, biv parambiv, bid parambid)
  {
    super(parambid);
    AppMethodBeat.i(280428);
    this.TAG = "Finder.NetSceneFinderGetTopicFeed";
    d.a locala = new d.a();
    locala.vD(getType());
    avx localavx = new avx();
    localavx.wXA = 2;
    localavx.topic = paramString;
    localavx.longitude = paramFloat1;
    localavx.latitude = paramFloat2;
    localavx.SDI = paramb;
    if (paramLong != null)
    {
      ((Number)paramLong).longValue();
      localavx.wZw = paramLong.longValue();
    }
    localavx.xcZ = parambiv;
    localavx.fromType = 1;
    if (parambiv != null) {
      localavx.fromType = 2;
    }
    localavx.fEH = paramInt;
    if (paramdwb != null)
    {
      paramb = new etb();
      parambiv = new LinkedList();
      Object localObject = paramdwb.Uca;
      p.j(localObject, "topicRecommend.topic_list");
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        parambiv.add(Long.valueOf(((bkr)((Iterator)localObject).next()).xee));
      }
      paramb.Uvr = parambiv;
      localavx.SIm = paramb;
      this.xdj = ((bkr)paramdwb.Uca.get(0)).topic;
    }
    paramb = ao.xcj;
    localavx.SFL = ao.a(parambid);
    paramb = ao.xcj;
    paramb = localavx.SFL;
    if (parambid != null) {}
    for (paramInt = parambid.fGo;; paramInt = 0)
    {
      ao.a(paramb, j.listOf(new o(Integer.valueOf(paramInt), Long.valueOf(localavx.wZw))));
      locala.c((com.tencent.mm.cd.a)localavx);
      locala.vD(getType());
      locala.d((com.tencent.mm.cd.a)new avy());
      locala.TW("/cgi-bin/micromsg-bin/findergettopiclist");
      paramb = locala.bgN();
      p.j(paramb, "builder.buildInstance()");
      this.rr = paramb;
      Log.i(this.TAG, "NetSceneFinderGetTopicFeed get poi init: " + paramString + ' ' + paramLong);
      this.wXA = this.wXA;
      AppMethodBeat.o(280428);
      return;
    }
  }
  
  public bv(String paramString, long paramLong, b paramb, Long paramLong1, int paramInt, bid parambid)
  {
    super(parambid);
    AppMethodBeat.i(280427);
    this.TAG = "Finder.NetSceneFinderGetTopicFeed";
    d.a locala = new d.a();
    locala.vD(getType());
    avx localavx = new avx();
    localavx.wXA = paramInt;
    localavx.topic = paramString;
    localavx.xee = paramLong;
    localavx.SDI = null;
    localavx.SIn = paramb;
    if (paramLong1 != null)
    {
      ((Number)paramLong1).longValue();
      localavx.wZw = paramLong1.longValue();
    }
    paramb = ao.xcj;
    localavx.SFL = ao.a(parambid);
    paramb = ao.xcj;
    paramb = localavx.SFL;
    if (parambid != null) {}
    for (int i = parambid.fGo;; i = 0)
    {
      ao.a(paramb, j.listOf(new o(Integer.valueOf(i), Long.valueOf(localavx.wZw))));
      locala.c((com.tencent.mm.cd.a)localavx);
      locala.vD(getType());
      locala.d((com.tencent.mm.cd.a)new avy());
      locala.TW("/cgi-bin/micromsg-bin/findergettopiclist");
      paramb = locala.bgN();
      p.j(paramb, "builder.buildInstance()");
      this.rr = paramb;
      Log.i(this.TAG, "NetSceneFinderGetTopicFeed get word init: " + paramString + ", " + paramLong1);
      this.wXA = paramInt;
      AppMethodBeat.o(280427);
      return;
    }
  }
  
  public bv(String paramString, long paramLong, b paramb1, Long paramLong1, b paramb2, biv parambiv, bid parambid)
  {
    super(parambid);
    AppMethodBeat.i(280426);
    this.TAG = "Finder.NetSceneFinderGetTopicFeed";
    d.a locala = new d.a();
    locala.vD(getType());
    avx localavx = new avx();
    localavx.wXA = 5;
    localavx.topic = paramString;
    localavx.xee = paramLong;
    localavx.SDI = paramb2;
    localavx.SIn = paramb1;
    if (paramLong1 != null)
    {
      ((Number)paramLong1).longValue();
      localavx.wZw = paramLong1.longValue();
    }
    localavx.xcZ = parambiv;
    paramb1 = ao.xcj;
    localavx.SFL = ao.a(parambid);
    paramb1 = ao.xcj;
    paramb1 = localavx.SFL;
    if (parambid != null) {}
    for (int i = parambid.fGo;; i = 0)
    {
      ao.a(paramb1, j.listOf(new o(Integer.valueOf(i), Long.valueOf(localavx.wZw))));
      locala.c((com.tencent.mm.cd.a)localavx);
      locala.vD(getType());
      locala.d((com.tencent.mm.cd.a)new avy());
      locala.TW("/cgi-bin/micromsg-bin/findergettopiclist");
      paramb1 = locala.bgN();
      p.j(paramb1, "builder.buildInstance()");
      this.rr = paramb1;
      Log.i(this.TAG, "NetSceneFinderGetTopicFeed get word init: " + paramString + ", " + paramLong1);
      this.wXA = this.wXA;
      AppMethodBeat.o(280426);
      return;
    }
  }
  
  public bv(String paramString, Long paramLong, b paramb, biv parambiv, bid parambid)
  {
    super(parambid);
    AppMethodBeat.i(280423);
    this.TAG = "Finder.NetSceneFinderGetTopicFeed";
    d.a locala = new d.a();
    locala.vD(getType());
    avx localavx = new avx();
    localavx.wXA = 4;
    localavx.topic = paramString;
    localavx.SDI = paramb;
    if (paramLong != null)
    {
      ((Number)paramLong).longValue();
      localavx.wZw = paramLong.longValue();
    }
    localavx.xcZ = parambiv;
    paramb = ao.xcj;
    localavx.SFL = ao.a(parambid);
    paramb = ao.xcj;
    paramb = localavx.SFL;
    if (parambid != null) {}
    for (int i = parambid.fGo;; i = 0)
    {
      ao.a(paramb, j.listOf(new o(Integer.valueOf(i), Long.valueOf(localavx.wZw))));
      locala.c((com.tencent.mm.cd.a)localavx);
      locala.vD(getType());
      locala.d((com.tencent.mm.cd.a)new avy());
      locala.TW("/cgi-bin/micromsg-bin/findergettopiclist");
      paramb = locala.bgN();
      p.j(paramb, "builder.buildInstance()");
      this.rr = paramb;
      Log.i(this.TAG, "NetSceneFinderGetTopicFeed get word init: " + paramString + ", " + paramLong);
      this.wXA = 4;
      AppMethodBeat.o(280423);
      return;
    }
  }
  
  public bv(String paramString, Long paramLong, b paramb, biv parambiv, bid parambid, byte paramByte)
  {
    super(parambid);
    AppMethodBeat.i(280425);
    this.TAG = "Finder.NetSceneFinderGetTopicFeed";
    d.a locala = new d.a();
    locala.vD(getType());
    avx localavx = new avx();
    localavx.wXA = 1;
    localavx.topic = paramString;
    localavx.SDI = paramb;
    if (paramLong != null)
    {
      ((Number)paramLong).longValue();
      localavx.wZw = paramLong.longValue();
    }
    localavx.xcZ = parambiv;
    paramb = ao.xcj;
    localavx.SFL = ao.a(parambid);
    paramb = ao.xcj;
    paramb = localavx.SFL;
    if (parambid != null) {}
    for (paramByte = parambid.fGo;; paramByte = 0)
    {
      ao.a(paramb, j.listOf(new o(Integer.valueOf(paramByte), Long.valueOf(localavx.wZw))));
      locala.c((com.tencent.mm.cd.a)localavx);
      locala.vD(getType());
      locala.d((com.tencent.mm.cd.a)new avy());
      locala.TW("/cgi-bin/micromsg-bin/findergettopiclist");
      paramb = locala.bgN();
      p.j(paramb, "builder.buildInstance()");
      this.rr = paramb;
      Log.i(this.TAG, "NetSceneFinderGetTopicFeed get word init: " + paramString + ", " + paramLong);
      this.wXA = this.wXA;
      AppMethodBeat.o(280425);
      return;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(280417);
    Log.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    Object localObject1;
    Object localObject2;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = this.TAG;
      localObject1 = new StringBuilder("pullType ").append(this.pullType).append(" selectedTag").append(this.xdj).append(' ');
      localObject2 = am.xch;
      Log.i(params, am.dY((List)dow()));
      params = this.rr.bhY();
      if (params == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
        AppMethodBeat.o(280417);
        throw paramString;
      }
      params = (avy)params;
      localObject1 = com.tencent.mm.plugin.finder.preload.a.zKe;
      localObject1 = params.preloadInfo;
      params = params.object;
      p.j(params, "resp.`object`");
      com.tencent.mm.plugin.finder.preload.a.a((bhh)localObject1, (List)params, 817);
    }
    if (this.callback != null)
    {
      params = this.callback;
      if (params == null) {
        p.iCn();
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
    }
    paramString = this.xbu;
    if (paramString != null)
    {
      params = ((Iterable)dow()).iterator();
      while (params.hasNext())
      {
        localObject1 = (FinderObject)params.next();
        localObject2 = n.zWF;
        n.a((FinderObject)localObject1, paramString.xkX);
      }
      AppMethodBeat.o(280417);
      return;
    }
    AppMethodBeat.o(280417);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(165233);
    Object localObject = n.zWF;
    localObject = this.xbu;
    if (localObject != null) {}
    for (int i = ((bid)localObject).xkX;; i = 0)
    {
      n.Px(i);
      this.callback = parami;
      i = dispatch(paramg, (s)this.rr, (m)this);
      AppMethodBeat.o(165233);
      return i;
    }
  }
  
  public final b don()
  {
    AppMethodBeat.i(165237);
    Object localObject = this.rr.bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
      AppMethodBeat.o(165237);
      throw ((Throwable)localObject);
    }
    localObject = ((avy)localObject).lastBuffer;
    AppMethodBeat.o(165237);
    return localObject;
  }
  
  public final int doo()
  {
    AppMethodBeat.i(165238);
    Object localObject = this.rr.bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
      AppMethodBeat.o(165238);
      throw ((Throwable)localObject);
    }
    int i = ((avy)localObject).continueFlag;
    AppMethodBeat.o(165238);
    return i;
  }
  
  public final int dov()
  {
    AppMethodBeat.i(280419);
    Object localObject = this.rr.bhX();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListRequest");
      AppMethodBeat.o(280419);
      throw ((Throwable)localObject);
    }
    int i = ((avx)localObject).wXA;
    AppMethodBeat.o(280419);
    return i;
  }
  
  public final LinkedList<FinderObject> dow()
  {
    AppMethodBeat.i(280420);
    Object localObject = this.rr.bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
      AppMethodBeat.o(280420);
      throw ((Throwable)localObject);
    }
    localObject = ((avy)localObject).object;
    p.j(localObject, "(rr.responseProtoBuf as …picListResponse).`object`");
    AppMethodBeat.o(280420);
    return localObject;
  }
  
  public final long dox()
  {
    AppMethodBeat.i(165236);
    Object localObject = this.rr.bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
      AppMethodBeat.o(165236);
      throw ((Throwable)localObject);
    }
    long l = ((avy)localObject).xEc;
    AppMethodBeat.o(165236);
    return l;
  }
  
  public final bkr doy()
  {
    AppMethodBeat.i(280422);
    Object localObject = this.rr.bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
      AppMethodBeat.o(280422);
      throw ((Throwable)localObject);
    }
    localObject = ((avy)localObject).SIo;
    AppMethodBeat.o(280422);
    return localObject;
  }
  
  public final bkq getBgmInfo()
  {
    AppMethodBeat.i(280421);
    Object localObject = this.rr.bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
      AppMethodBeat.o(280421);
      throw ((Throwable)localObject);
    }
    localObject = ((avy)localObject).SIo;
    if (localObject != null)
    {
      localObject = ((bkr)localObject).SVG;
      AppMethodBeat.o(280421);
      return localObject;
    }
    AppMethodBeat.o(280421);
    return null;
  }
  
  public final int getTabType()
  {
    AppMethodBeat.i(280418);
    Object localObject = this.rr.bhX();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListRequest");
      AppMethodBeat.o(280418);
      throw ((Throwable)localObject);
    }
    int i = ((avx)localObject).xEw;
    AppMethodBeat.o(280418);
    return i;
  }
  
  public final int getType()
  {
    return 817;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bv
 * JD-Core Version:    0.7.0.1
 */
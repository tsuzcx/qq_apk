package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.atu;
import com.tencent.mm.protocal.protobuf.atv;
import com.tencent.mm.protocal.protobuf.baw;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bcc;
import com.tencent.mm.protocal.protobuf.bdr;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.protocal.protobuf.dmk;
import com.tencent.mm.protocal.protobuf.eiz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetTopicFeed;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "topic", "", "topicType", "", "refObjectId", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;ILjava/lang/Long;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "topicId", "(Ljava/lang/Long;JLcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "eventTopicId", "encryptedTopicId", "innerTabType", "(JLjava/lang/Long;Ljava/lang/String;ILcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "(Ljava/lang/String;Ljava/lang/Long;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "topicBuffer", "(Ljava/lang/String;JLcom/tencent/mm/protobuf/ByteString;Ljava/lang/Long;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "(Ljava/lang/String;Ljava/lang/Long;ILcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "(Ljava/lang/String;JLcom/tencent/mm/protobuf/ByteString;Ljava/lang/Long;ILcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "poiClassifyId", "longitude", "", "latitude", "tabType", "topicRecommend", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "(Ljava/lang/String;FFLjava/lang/Long;Lcom/tencent/mm/protobuf/ByteString;ILcom/tencent/mm/protocal/protobuf/RelatedTopic;Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "objectList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectList", "()Ljava/util/List;", "setObjectList", "(Ljava/util/List;)V", "pullType", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "selectedTag", "getSelectedTag", "()Ljava/lang/String;", "setSelectedTag", "(Ljava/lang/String;)V", "getTopicType", "setTopicType", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getBgmInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicBgmInfo;", "getContinueFlag", "getDisableFlag", "getFeedList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getFlag", "getMusicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "getRespLastBuffer", "getSubTitle", "Lcom/tencent/mm/protocal/protobuf/PoiTopicSubTitle;", "getTopicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "getTopicRecommends", "getTotalCount", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class bs
  extends ax
{
  private final String TAG;
  private i callback;
  public int pullType;
  public d rr;
  public String tvB;
  public int tvC;
  
  public bs(long paramLong, Long paramLong1, String paramString, int paramInt, b paramb, bbn parambbn)
  {
    AppMethodBeat.i(242462);
    this.TAG = "Finder.NetSceneFinderGetTopicFeed";
    d.a locala = new d.a();
    locala.sG(getType());
    atu localatu = new atu();
    localatu.tvC = 7;
    localatu.twp = paramLong;
    if (paramLong1 != null)
    {
      ((Number)paramLong1).longValue();
      localatu.trn = paramLong1.longValue();
    }
    if (!Util.isNullOrNil(paramString)) {
      localatu.fromType = 4;
    }
    if (paramString == null) {}
    for (String str = "";; str = paramString)
    {
      localatu.tTQ = str;
      localatu.LDs = paramb;
      localatu.tTH = paramInt;
      paramb = am.tuw;
      localatu.LCA = am.a(parambbn);
      locala.c((com.tencent.mm.bw.a)localatu);
      locala.sG(getType());
      locala.d((com.tencent.mm.bw.a)new atv());
      locala.MB("/cgi-bin/micromsg-bin/findergettopiclist");
      paramb = locala.aXF();
      p.g(paramb, "builder.buildInstance()");
      this.rr = paramb;
      Log.i(this.TAG, "NetSceneFinderGetTopicFeed get eventTopic init eventTopicId:" + paramLong + ", " + paramLong1 + " encryptedTopicId:" + paramString + " innerTabType:" + paramInt);
      this.tvC = this.tvC;
      AppMethodBeat.o(242462);
      return;
    }
  }
  
  public bs(String paramString, float paramFloat1, float paramFloat2, Long paramLong, b paramb, int paramInt, dmk paramdmk, bcc parambcc, bbn parambbn)
  {
    super(parambbn);
    AppMethodBeat.i(242466);
    this.TAG = "Finder.NetSceneFinderGetTopicFeed";
    d.a locala = new d.a();
    locala.sG(getType());
    atu localatu = new atu();
    localatu.tvC = 2;
    localatu.dST = paramString;
    localatu.dTj = paramFloat1;
    localatu.latitude = paramFloat2;
    localatu.LDs = paramb;
    if (paramLong != null)
    {
      ((Number)paramLong).longValue();
      localatu.trn = paramLong.longValue();
    }
    localatu.tvs = parambcc;
    localatu.fromType = 1;
    if (parambcc != null) {
      localatu.fromType = 2;
    }
    localatu.dLS = paramInt;
    if (paramdmk != null)
    {
      paramb = new eiz();
      parambcc = new LinkedList();
      Object localObject = paramdmk.MPW;
      p.g(localObject, "topicRecommend.topic_list");
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        parambcc.add(Long.valueOf(((bds)((Iterator)localObject).next()).twp));
      }
      paramb.NiM = parambcc;
      localatu.LEE = paramb;
      this.tvB = ((bds)paramdmk.MPW.get(0)).dST;
    }
    paramb = am.tuw;
    localatu.LCA = am.a(parambbn);
    locala.c((com.tencent.mm.bw.a)localatu);
    locala.sG(getType());
    locala.d((com.tencent.mm.bw.a)new atv());
    locala.MB("/cgi-bin/micromsg-bin/findergettopiclist");
    paramb = locala.aXF();
    p.g(paramb, "builder.buildInstance()");
    this.rr = paramb;
    Log.i(this.TAG, "NetSceneFinderGetTopicFeed get poi init: " + paramString + ' ' + paramLong);
    this.tvC = this.tvC;
    AppMethodBeat.o(242466);
  }
  
  public bs(String paramString, long paramLong, b paramb, Long paramLong1, int paramInt, bbn parambbn)
  {
    super(parambbn);
    AppMethodBeat.i(242465);
    this.TAG = "Finder.NetSceneFinderGetTopicFeed";
    d.a locala = new d.a();
    locala.sG(getType());
    atu localatu = new atu();
    localatu.tvC = paramInt;
    localatu.dST = paramString;
    localatu.twp = paramLong;
    localatu.LDs = null;
    localatu.LEF = paramb;
    if (paramLong1 != null)
    {
      ((Number)paramLong1).longValue();
      localatu.trn = paramLong1.longValue();
    }
    paramb = am.tuw;
    localatu.LCA = am.a(parambbn);
    locala.c((com.tencent.mm.bw.a)localatu);
    locala.sG(getType());
    locala.d((com.tencent.mm.bw.a)new atv());
    locala.MB("/cgi-bin/micromsg-bin/findergettopiclist");
    paramb = locala.aXF();
    p.g(paramb, "builder.buildInstance()");
    this.rr = paramb;
    Log.i(this.TAG, "NetSceneFinderGetTopicFeed get word init: " + paramString + ", " + paramLong1);
    this.tvC = paramInt;
    AppMethodBeat.o(242465);
  }
  
  public bs(String paramString, long paramLong, b paramb1, Long paramLong1, b paramb2, bcc parambcc, bbn parambbn)
  {
    super(parambbn);
    AppMethodBeat.i(242464);
    this.TAG = "Finder.NetSceneFinderGetTopicFeed";
    d.a locala = new d.a();
    locala.sG(getType());
    atu localatu = new atu();
    localatu.tvC = 5;
    localatu.dST = paramString;
    localatu.twp = paramLong;
    localatu.LDs = paramb2;
    localatu.LEF = paramb1;
    if (paramLong1 != null)
    {
      ((Number)paramLong1).longValue();
      localatu.trn = paramLong1.longValue();
    }
    localatu.tvs = parambcc;
    paramb1 = am.tuw;
    localatu.LCA = am.a(parambbn);
    locala.c((com.tencent.mm.bw.a)localatu);
    locala.sG(getType());
    locala.d((com.tencent.mm.bw.a)new atv());
    locala.MB("/cgi-bin/micromsg-bin/findergettopiclist");
    paramb1 = locala.aXF();
    p.g(paramb1, "builder.buildInstance()");
    this.rr = paramb1;
    Log.i(this.TAG, "NetSceneFinderGetTopicFeed get word init: " + paramString + ", " + paramLong1);
    this.tvC = this.tvC;
    AppMethodBeat.o(242464);
  }
  
  public bs(String paramString, Long paramLong, b paramb, bcc parambcc, bbn parambbn)
  {
    super(parambbn);
    AppMethodBeat.i(242461);
    this.TAG = "Finder.NetSceneFinderGetTopicFeed";
    d.a locala = new d.a();
    locala.sG(getType());
    atu localatu = new atu();
    localatu.tvC = 4;
    localatu.dST = paramString;
    localatu.LDs = paramb;
    if (paramLong != null)
    {
      ((Number)paramLong).longValue();
      localatu.trn = paramLong.longValue();
    }
    localatu.tvs = parambcc;
    paramb = am.tuw;
    localatu.LCA = am.a(parambbn);
    locala.c((com.tencent.mm.bw.a)localatu);
    locala.sG(getType());
    locala.d((com.tencent.mm.bw.a)new atv());
    locala.MB("/cgi-bin/micromsg-bin/findergettopiclist");
    paramb = locala.aXF();
    p.g(paramb, "builder.buildInstance()");
    this.rr = paramb;
    Log.i(this.TAG, "NetSceneFinderGetTopicFeed get word init: " + paramString + ", " + paramLong);
    this.tvC = 4;
    AppMethodBeat.o(242461);
  }
  
  public bs(String paramString, Long paramLong, b paramb, bcc parambcc, bbn parambbn, byte paramByte)
  {
    super(parambbn);
    AppMethodBeat.i(242463);
    this.TAG = "Finder.NetSceneFinderGetTopicFeed";
    d.a locala = new d.a();
    locala.sG(getType());
    atu localatu = new atu();
    localatu.tvC = 1;
    localatu.dST = paramString;
    localatu.LDs = paramb;
    if (paramLong != null)
    {
      ((Number)paramLong).longValue();
      localatu.trn = paramLong.longValue();
    }
    localatu.tvs = parambcc;
    paramb = am.tuw;
    localatu.LCA = am.a(parambbn);
    locala.c((com.tencent.mm.bw.a)localatu);
    locala.sG(getType());
    locala.d((com.tencent.mm.bw.a)new atv());
    locala.MB("/cgi-bin/micromsg-bin/findergettopiclist");
    paramb = locala.aXF();
    p.g(paramb, "builder.buildInstance()");
    this.rr = paramb;
    Log.i(this.TAG, "NetSceneFinderGetTopicFeed get word init: " + paramString + ", " + paramLong);
    this.tvC = this.tvC;
    AppMethodBeat.o(242463);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(242457);
    Log.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    Object localObject1;
    Object localObject2;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = this.TAG;
      localObject1 = new StringBuilder("pullType ").append(this.pullType).append(" selectedTag").append(this.tvB).append(' ');
      localObject2 = al.tuv;
      Log.i(params, al.dQ((List)cYH()));
      params = this.rr.aYK();
      if (params == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
        AppMethodBeat.o(242457);
        throw paramString;
      }
      params = (atv)params;
      localObject1 = com.tencent.mm.plugin.finder.preload.a.uTO;
      localObject1 = params.preloadInfo;
      params = params.object;
      p.g(params, "resp.`object`");
      com.tencent.mm.plugin.finder.preload.a.a((baw)localObject1, (List)params, 817);
    }
    if (this.callback != null)
    {
      params = this.callback;
      if (params == null) {
        p.hyc();
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
    }
    paramString = this.ttO;
    if (paramString != null)
    {
      params = ((Iterable)cYH()).iterator();
      while (params.hasNext())
      {
        localObject1 = (FinderObject)params.next();
        localObject2 = k.vfA;
        k.e(((FinderObject)localObject1).id, paramString.tCE, ((FinderObject)localObject1).sessionBuffer);
      }
      AppMethodBeat.o(242457);
      return;
    }
    AppMethodBeat.o(242457);
  }
  
  public final int cYA()
  {
    AppMethodBeat.i(165238);
    Object localObject = this.rr.aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
      AppMethodBeat.o(165238);
      throw ((Throwable)localObject);
    }
    int i = ((atv)localObject).continueFlag;
    AppMethodBeat.o(165238);
    return i;
  }
  
  public final LinkedList<FinderObject> cYH()
  {
    AppMethodBeat.i(242458);
    Object localObject = this.rr.aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
      AppMethodBeat.o(242458);
      throw ((Throwable)localObject);
    }
    localObject = ((atv)localObject).object;
    p.g(localObject, "(rr.responseProtoBuf as …picListResponse).`object`");
    AppMethodBeat.o(242458);
    return localObject;
  }
  
  public final long cYI()
  {
    AppMethodBeat.i(165236);
    Object localObject = this.rr.aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
      AppMethodBeat.o(165236);
      throw ((Throwable)localObject);
    }
    long l = ((atv)localObject).tTn;
    AppMethodBeat.o(165236);
    return l;
  }
  
  public final bds cYJ()
  {
    AppMethodBeat.i(242460);
    Object localObject = this.rr.aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
      AppMethodBeat.o(242460);
      throw ((Throwable)localObject);
    }
    localObject = ((atv)localObject).LEG;
    AppMethodBeat.o(242460);
    return localObject;
  }
  
  public final b cYz()
  {
    AppMethodBeat.i(165237);
    Object localObject = this.rr.aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
      AppMethodBeat.o(165237);
      throw ((Throwable)localObject);
    }
    localObject = ((atv)localObject).lastBuffer;
    AppMethodBeat.o(165237);
    return localObject;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(165233);
    Object localObject = k.vfA;
    localObject = this.ttO;
    if (localObject != null) {}
    for (int i = ((bbn)localObject).tCE;; i = 0)
    {
      k.Ku(i);
      this.callback = parami;
      i = dispatch(paramg, (s)this.rr, (m)this);
      AppMethodBeat.o(165233);
      return i;
    }
  }
  
  public final bdr getBgmInfo()
  {
    AppMethodBeat.i(242459);
    Object localObject = this.rr.aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
      AppMethodBeat.o(242459);
      throw ((Throwable)localObject);
    }
    localObject = ((atv)localObject).LEG;
    if (localObject != null)
    {
      localObject = ((bds)localObject).LNw;
      AppMethodBeat.o(242459);
      return localObject;
    }
    AppMethodBeat.o(242459);
    return null;
  }
  
  public final int getType()
  {
    return 817;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bs
 * JD-Core Version:    0.7.0.1
 */
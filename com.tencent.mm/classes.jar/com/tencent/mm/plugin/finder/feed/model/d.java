package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.cgi.aq.d;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.auk;
import com.tencent.mm.protocal.protobuf.btc;
import com.tencent.mm.protocal.protobuf.bwe;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "", "list", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(Ljava/util/List;IILjava/lang/String;)V", "afterFeedIdHistory", "", "getAfterFeedIdHistory", "()J", "setAfterFeedIdHistory", "(J)V", "continue_flag", "getContinue_flag", "()I", "setContinue_flag", "(I)V", "dataBufferList", "Ljava/util/ArrayList;", "getDataBufferList", "()Ljava/util/ArrayList;", "setDataBufferList", "(Ljava/util/ArrayList;)V", "endWording", "getEndWording", "()Ljava/lang/String;", "setEndWording", "(Ljava/lang/String;)V", "getErrCode", "setErrCode", "getErrMsg", "setErrMsg", "getErrType", "setErrType", "finderItems", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getFinderItems", "()Ljava/util/List;", "setFinderItems", "(Ljava/util/List;)V", "headWording", "getHeadWording", "setHeadWording", "historySize", "getHistorySize", "setHistorySize", "incrementList", "Ljava/util/LinkedList;", "getIncrementList", "()Ljava/util/LinkedList;", "setIncrementList", "(Ljava/util/LinkedList;)V", "isFetchHistoryNow", "", "()Z", "setFetchHistoryNow", "(Z)V", "isForceChangePrefetchResult", "setForceChangePrefetchResult", "isGetHistory", "setGetHistory", "isNeedClear", "setNeedClear", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "layoutInfo", "Lcom/tencent/mm/protocal/protobuf/FinderStreamLayoutInfo;", "getLayoutInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamLayoutInfo;", "setLayoutInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderStreamLayoutInfo;)V", "preloadInfo", "Lcom/tencent/mm/protocal/protobuf/FinderPreloadInfo;", "getPreloadInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderPreloadInfo;", "setPreloadInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderPreloadInfo;)V", "pullType", "getPullType", "setPullType", "recommendTags", "Lcom/tencent/mm/protocal/protobuf/FinderCategoryRecommend;", "getRecommendTags", "()Lcom/tencent/mm/protocal/protobuf/FinderCategoryRecommend;", "setRecommendTags", "(Lcom/tencent/mm/protocal/protobuf/FinderCategoryRecommend;)V", "recommendTopic", "Lcom/tencent/mm/protocal/protobuf/FinderTopicRecommend;", "getRecommendTopic", "()Lcom/tencent/mm/protocal/protobuf/FinderTopicRecommend;", "setRecommendTopic", "(Lcom/tencent/mm/protocal/protobuf/FinderTopicRecommend;)V", "resp", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "getResp", "()Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "setResp", "(Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;)V", "ret_flag", "getRet_flag", "setRet_flag", "streamSize", "getStreamSize", "setStreamSize", "tabType", "getTabType", "setTabType", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public int AAs;
  public long AAt;
  public boolean AEi;
  public String AZa;
  public int BeA;
  public boolean BeB;
  public boolean BeC;
  public auk BeD;
  public ArrayList<cc> BeE;
  public bwe BeF;
  public aq.d BeG;
  public String BeH;
  public LinkedList<cc> Bex;
  public List<? extends FinderObject> Bey;
  public int Bez;
  public int errCode;
  public String errMsg;
  public int errType;
  public int hJx;
  public boolean isNeedClear;
  public b lastBuffer;
  public btc preloadInfo;
  public int pullType;
  public int qpb;
  
  public d(List<? extends cc> paramList, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(366051);
    this.errType = paramInt1;
    this.errCode = paramInt2;
    this.errMsg = paramString;
    this.hJx = -1;
    this.Bex = new LinkedList((Collection)paramList);
    this.pullType = -1;
    this.isNeedClear = true;
    this.AAt = -1L;
    AppMethodBeat.o(366051);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.d
 * JD-Core Version:    0.7.0.1
 */
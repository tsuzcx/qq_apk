package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aqk;
import com.tencent.mm.protocal.protobuf.bhh;
import com.tencent.mm.protocal.protobuf.bjt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "", "list", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(Ljava/util/List;IILjava/lang/String;)V", "afterFeedIdHistory", "", "getAfterFeedIdHistory", "()J", "setAfterFeedIdHistory", "(J)V", "continue_flag", "getContinue_flag", "()I", "setContinue_flag", "(I)V", "dataBufferList", "Ljava/util/ArrayList;", "getDataBufferList", "()Ljava/util/ArrayList;", "setDataBufferList", "(Ljava/util/ArrayList;)V", "endWording", "getEndWording", "()Ljava/lang/String;", "setEndWording", "(Ljava/lang/String;)V", "getErrCode", "setErrCode", "getErrMsg", "setErrMsg", "getErrType", "setErrType", "finderItems", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getFinderItems", "()Ljava/util/List;", "setFinderItems", "(Ljava/util/List;)V", "headWording", "getHeadWording", "setHeadWording", "historySize", "getHistorySize", "setHistorySize", "incrementList", "Ljava/util/LinkedList;", "getIncrementList", "()Ljava/util/LinkedList;", "setIncrementList", "(Ljava/util/LinkedList;)V", "isFetchHistoryNow", "", "()Z", "setFetchHistoryNow", "(Z)V", "isForceChangePrefetchResult", "setForceChangePrefetchResult", "isGetHistory", "setGetHistory", "isNeedClear", "setNeedClear", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "layoutInfo", "Lcom/tencent/mm/protocal/protobuf/FinderStreamLayoutInfo;", "getLayoutInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamLayoutInfo;", "setLayoutInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderStreamLayoutInfo;)V", "preloadInfo", "Lcom/tencent/mm/protocal/protobuf/FinderPreloadInfo;", "getPreloadInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderPreloadInfo;", "setPreloadInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderPreloadInfo;)V", "pullType", "getPullType", "setPullType", "recommendTags", "Lcom/tencent/mm/protocal/protobuf/FinderCategoryRecommend;", "getRecommendTags", "()Lcom/tencent/mm/protocal/protobuf/FinderCategoryRecommend;", "setRecommendTags", "(Lcom/tencent/mm/protocal/protobuf/FinderCategoryRecommend;)V", "recommendTopic", "Lcom/tencent/mm/protocal/protobuf/FinderTopicRecommend;", "getRecommendTopic", "()Lcom/tencent/mm/protocal/protobuf/FinderTopicRecommend;", "setRecommendTopic", "(Lcom/tencent/mm/protocal/protobuf/FinderTopicRecommend;)V", "ret_flag", "getRet_flag", "setRet_flag", "streamSize", "getStreamSize", "setStreamSize", "tabType", "getTabType", "setTabType", "plugin-finder_release"})
public final class d
{
  public int errCode;
  public String errMsg;
  public int errType;
  public int fEH;
  public boolean isNeedClear;
  public b lastBuffer;
  public int nqx;
  public bhh preloadInfo;
  public int pullType;
  public String xBL;
  public LinkedList<bu> xFF;
  public List<? extends FinderObject> xFG;
  public int xFH;
  public int xFI;
  public boolean xFJ;
  public boolean xFK;
  public aqk xFL;
  public ArrayList<bu> xFM;
  public bjt xFN;
  public String xFO;
  public int xbB;
  public long xbC;
  public boolean xeZ;
  
  public d(List<? extends bu> paramList, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(252490);
    this.errType = paramInt1;
    this.errCode = paramInt2;
    this.errMsg = paramString;
    this.fEH = -1;
    this.xFF = new LinkedList((Collection)paramList);
    this.pullType = -1;
    this.isNeedClear = true;
    this.xbC = -1L;
    AppMethodBeat.o(252490);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.d
 * JD-Core Version:    0.7.0.1
 */
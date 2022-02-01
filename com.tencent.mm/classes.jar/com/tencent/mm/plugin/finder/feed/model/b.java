package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aly;
import com.tencent.mm.protocal.protobuf.arc;
import com.tencent.mm.protocal.protobuf.asf;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "", "list", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(Ljava/util/List;IILjava/lang/String;)V", "afterFeedIdHistory", "", "getAfterFeedIdHistory", "()J", "setAfterFeedIdHistory", "(J)V", "continue_flag", "getContinue_flag", "()I", "setContinue_flag", "(I)V", "dataBufferList", "Ljava/util/ArrayList;", "getDataBufferList", "()Ljava/util/ArrayList;", "setDataBufferList", "(Ljava/util/ArrayList;)V", "endWording", "getEndWording", "()Ljava/lang/String;", "setEndWording", "(Ljava/lang/String;)V", "getErrCode", "setErrCode", "getErrMsg", "setErrMsg", "getErrType", "setErrType", "finderItems", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getFinderItems", "()Ljava/util/List;", "setFinderItems", "(Ljava/util/List;)V", "headWording", "getHeadWording", "setHeadWording", "historySize", "getHistorySize", "setHistorySize", "incrementList", "Ljava/util/LinkedList;", "getIncrementList", "()Ljava/util/LinkedList;", "setIncrementList", "(Ljava/util/LinkedList;)V", "isFetchHistoryNow", "", "()Z", "setFetchHistoryNow", "(Z)V", "isForceChangePrefetchResult", "setForceChangePrefetchResult", "isGetHistory", "setGetHistory", "isNeedClear", "setNeedClear", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "layoutInfo", "Lcom/tencent/mm/protocal/protobuf/FinderStreamLayoutInfo;", "getLayoutInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamLayoutInfo;", "setLayoutInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderStreamLayoutInfo;)V", "preloadInfo", "Lcom/tencent/mm/protocal/protobuf/FinderPreloadInfo;", "getPreloadInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderPreloadInfo;", "setPreloadInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderPreloadInfo;)V", "pullType", "getPullType", "setPullType", "recommendTags", "Lcom/tencent/mm/protocal/protobuf/FinderCategoryRecommend;", "getRecommendTags", "()Lcom/tencent/mm/protocal/protobuf/FinderCategoryRecommend;", "setRecommendTags", "(Lcom/tencent/mm/protocal/protobuf/FinderCategoryRecommend;)V", "recommendTopic", "Lcom/tencent/mm/protocal/protobuf/FinderTopicRecommend;", "getRecommendTopic", "()Lcom/tencent/mm/protocal/protobuf/FinderTopicRecommend;", "setRecommendTopic", "(Lcom/tencent/mm/protocal/protobuf/FinderTopicRecommend;)V", "ret_flag", "getRet_flag", "setRet_flag", "streamSize", "getStreamSize", "setStreamSize", "tabType", "getTabType", "setTabType", "plugin-finder_release"})
public final class b
{
  public int dvm;
  public int errCode;
  public String errMsg;
  public int errType;
  public boolean isNeedClear;
  public com.tencent.mm.bw.b lastBuffer;
  public arc preloadInfo;
  public int pullType;
  public int rQD;
  public long rQE;
  public int rQF;
  public boolean rSI;
  public LinkedList<am> sjH;
  public List<? extends FinderObject> sjI;
  public int sjJ;
  public int sjK;
  public boolean sjL;
  public boolean sjM;
  public aly sjN;
  public ArrayList<am> sjO;
  public asf sjP;
  public String sjQ;
  public String sjR;
  
  public b(List<? extends am> paramList, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(202783);
    this.errType = paramInt1;
    this.errCode = paramInt2;
    this.errMsg = paramString;
    this.dvm = -1;
    this.sjH = new LinkedList((Collection)paramList);
    this.pullType = -1;
    this.isNeedClear = true;
    this.rQE = -1L;
    AppMethodBeat.o(202783);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.b
 * JD-Core Version:    0.7.0.1
 */
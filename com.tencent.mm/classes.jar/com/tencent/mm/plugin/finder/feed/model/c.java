package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.akp;
import com.tencent.mm.protocal.protobuf.dyf;
import com.tencent.mm.protocal.protobuf.dzx;
import d.l;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FetchFinderTimelineInfo;", "", "incrementList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "history_head_wording", "", "history_end_wording", "errType", "", "errCode", "errMsg", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V", "continue_flag", "getContinue_flag", "()I", "setContinue_flag", "(I)V", "dataBufferList", "Ljava/util/ArrayList;", "getDataBufferList", "()Ljava/util/ArrayList;", "setDataBufferList", "(Ljava/util/ArrayList;)V", "getErrCode", "setErrCode", "getErrMsg", "()Ljava/lang/String;", "setErrMsg", "(Ljava/lang/String;)V", "getErrType", "setErrType", "finderItems", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getFinderItems", "()Ljava/util/List;", "setFinderItems", "(Ljava/util/List;)V", "getHistory_end_wording", "setHistory_end_wording", "getHistory_head_wording", "setHistory_head_wording", "getIncrementList", "setIncrementList", "isFetchHistoryNow", "", "()Z", "setFetchHistoryNow", "(Z)V", "isForceChangePrefetchResult", "setForceChangePrefetchResult", "isNeedClear", "setNeedClear", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "preloadInfo", "Lcom/tencent/mm/protocal/protobuf/FinderPreloadInfo;", "getPreloadInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderPreloadInfo;", "setPreloadInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderPreloadInfo;)V", "recommendTags", "Lcom/tencent/mm/protocal/protobuf/FinderCategoryRecommend;", "getRecommendTags", "()Lcom/tencent/mm/protocal/protobuf/FinderCategoryRecommend;", "setRecommendTags", "(Lcom/tencent/mm/protocal/protobuf/FinderCategoryRecommend;)V", "recommendTopic", "Lcom/tencent/mm/protocal/protobuf/FinderTopicRecommend;", "getRecommendTopic", "()Lcom/tencent/mm/protocal/protobuf/FinderTopicRecommend;", "setRecommendTopic", "(Lcom/tencent/mm/protocal/protobuf/FinderTopicRecommend;)V", "ret_flag", "getRet_flag", "setRet_flag", "plugin-finder_release"})
public final class c
{
  public akp DmE;
  public boolean KPG;
  public dzx KPH;
  public dyf KPI;
  public ArrayList<BaseFinderFeed> KPJ;
  public int errCode;
  public String errMsg;
  public int errType;
  public List<? extends BaseFinderFeed> incrementList;
  public boolean isNeedClear;
  public b lastBuffer;
  public List<? extends FinderObject> qyo;
  public String qyp;
  public String qyq;
  public int qyr;
  public int qys;
  public boolean qyu;
  
  public c(List<? extends BaseFinderFeed> paramList, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(166022);
    this.errMsg = "";
    this.isNeedClear = true;
    if (paramList == null) {
      paramList = (List)new LinkedList();
    }
    for (;;)
    {
      this.incrementList = paramList;
      this.errType = paramInt1;
      this.errCode = paramInt2;
      this.errMsg = paramString3;
      this.qyp = paramString1;
      this.qyq = paramString2;
      AppMethodBeat.o(166022);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.c
 * JD-Core Version:    0.7.0.1
 */
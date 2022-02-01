package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.mm.cd.b;
import com.tencent.mm.protocal.protobuf.bkq;
import java.util.List;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "bgmInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicBgmInfo;", "getBgmInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderTopicBgmInfo;", "setBgmInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderTopicBgmInfo;)V", "getErrCode", "()I", "getErrMsg", "()Ljava/lang/String;", "getErrType", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "incrementList", "", "getIncrementList", "()Ljava/util/List;", "setIncrementList", "(Ljava/util/List;)V", "isNeedClear", "setNeedClear", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "pullType", "getPullType", "setPullType", "(I)V", "request", "getRequest", "()Ljava/lang/Object;", "setRequest", "(Ljava/lang/Object;)V", "plugin-finder-base_release"})
public class IResponse<T extends k>
{
  private bkq bgmInfo;
  private final int errCode;
  private final String errMsg;
  private final int errType;
  private boolean hasMore;
  private List<? extends T> incrementList;
  private boolean isNeedClear;
  private b lastBuffer;
  private int pullType;
  private Object request;
  
  public IResponse()
  {
    this(0, 0, null, 7, null);
  }
  
  public IResponse(int paramInt1, int paramInt2, String paramString)
  {
    this.errType = paramInt1;
    this.errCode = paramInt2;
    this.errMsg = paramString;
    this.pullType = -1;
    this.hasMore = true;
    this.isNeedClear = true;
  }
  
  public final bkq getBgmInfo()
  {
    return this.bgmInfo;
  }
  
  public final int getErrCode()
  {
    return this.errCode;
  }
  
  public final String getErrMsg()
  {
    return this.errMsg;
  }
  
  public final int getErrType()
  {
    return this.errType;
  }
  
  public final boolean getHasMore()
  {
    return this.hasMore;
  }
  
  public final List<T> getIncrementList()
  {
    return this.incrementList;
  }
  
  public final b getLastBuffer()
  {
    return this.lastBuffer;
  }
  
  public final int getPullType()
  {
    return this.pullType;
  }
  
  public final Object getRequest()
  {
    return this.request;
  }
  
  public final boolean isNeedClear()
  {
    return this.isNeedClear;
  }
  
  public final void setBgmInfo(bkq parambkq)
  {
    this.bgmInfo = parambkq;
  }
  
  public final void setHasMore(boolean paramBoolean)
  {
    this.hasMore = paramBoolean;
  }
  
  public final void setIncrementList(List<? extends T> paramList)
  {
    this.incrementList = paramList;
  }
  
  public final void setLastBuffer(b paramb)
  {
    this.lastBuffer = paramb;
  }
  
  public final void setNeedClear(boolean paramBoolean)
  {
    this.isNeedClear = paramBoolean;
  }
  
  public final void setPullType(int paramInt)
  {
    this.pullType = paramInt;
  }
  
  public final void setRequest(Object paramObject)
  {
    this.request = paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.IResponse
 * JD-Core Version:    0.7.0.1
 */
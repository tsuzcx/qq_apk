package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.mm.bw.b;
import d.l;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "getErrCode", "()I", "getErrMsg", "()Ljava/lang/String;", "getErrType", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "incrementList", "", "getIncrementList", "()Ljava/util/List;", "setIncrementList", "(Ljava/util/List;)V", "isNeedClear", "setNeedClear", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "pullType", "getPullType", "setPullType", "(I)V", "request", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IRequest;", "getRequest", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/IRequest;", "setRequest", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IRequest;)V", "plugin-finder_release"})
public class IResponse<T extends h>
{
  private final int errCode;
  private final String errMsg;
  private final int errType;
  private boolean hasMore;
  private List<? extends T> incrementList;
  private boolean isNeedClear;
  private b lastBuffer;
  private int pullType;
  private i request;
  
  public IResponse(int paramInt1, int paramInt2, String paramString)
  {
    this.errType = paramInt1;
    this.errCode = paramInt2;
    this.errMsg = paramString;
    this.pullType = -1;
    this.hasMore = true;
    this.isNeedClear = true;
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
  
  public final i getRequest()
  {
    return this.request;
  }
  
  public final boolean isNeedClear()
  {
    return this.isNeedClear;
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
  
  public final void setRequest(i parami)
  {
    this.request = parami;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.IResponse
 * JD-Core Version:    0.7.0.1
 */
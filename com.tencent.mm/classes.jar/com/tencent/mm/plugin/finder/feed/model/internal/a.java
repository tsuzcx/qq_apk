package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.feed.model.q;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/internal/AdCache;", "Lcom/tencent/mm/plugin/finder/feed/model/IFinderCache;", "cacheId", "", "(J)V", "createTime", "getCreateTime", "()J", "expireLimit", "getExpireLimit", "setExpireLimit", "id", "isValid", "", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public class a
  implements q
{
  public static final a BjO;
  private final long BjP;
  private long BjQ;
  private final long createTime;
  
  static
  {
    AppMethodBeat.i(366563);
    BjO = new a((byte)0);
    AppMethodBeat.o(366563);
  }
  
  public a(long paramLong)
  {
    AppMethodBeat.i(366558);
    this.BjP = paramLong;
    this.createTime = cn.bDw();
    this.BjQ = 259200000L;
    AppMethodBeat.o(366558);
  }
  
  public final long id()
  {
    return this.BjP;
  }
  
  public final boolean isValid()
  {
    AppMethodBeat.i(366574);
    if (cn.bDw() - this.createTime < this.BjQ)
    {
      AppMethodBeat.o(366574);
      return true;
    }
    AppMethodBeat.o(366574);
    return false;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/internal/AdCache$Companion;", "", "()V", "EXPIRE_LIMIT", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.a
 * JD-Core Version:    0.7.0.1
 */
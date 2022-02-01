package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.feed.model.o;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/internal/AdCache;", "Lcom/tencent/mm/plugin/finder/feed/model/IFinderCache;", "cacheId", "", "(J)V", "createTime", "getCreateTime", "()J", "expireLimit", "getExpireLimit", "setExpireLimit", "id", "isValid", "", "Companion", "plugin-finder-base_release"})
public class a
  implements o
{
  public static final a xKd;
  private final long createTime;
  private long xKb;
  private final long xKc;
  
  static
  {
    AppMethodBeat.i(260385);
    xKd = new a((byte)0);
    AppMethodBeat.o(260385);
  }
  
  public a(long paramLong)
  {
    AppMethodBeat.i(260382);
    this.xKc = paramLong;
    this.createTime = cm.bfE();
    this.xKb = 259200000L;
    AppMethodBeat.o(260382);
  }
  
  public final long dux()
  {
    return this.xKc;
  }
  
  public final boolean isValid()
  {
    AppMethodBeat.i(260380);
    if (cm.bfE() - this.createTime < this.xKb)
    {
      AppMethodBeat.o(260380);
      return true;
    }
    AppMethodBeat.o(260380);
    return false;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/internal/AdCache$Companion;", "", "()V", "EXPIRE_LIMIT", "", "plugin-finder-base_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.a
 * JD-Core Version:    0.7.0.1
 */
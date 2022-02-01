package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer;", "T", "A", "", "policy", "Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer$Policy;", "name", "", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer$Policy;Ljava/lang/String;)V", "buffer", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer$PageData;", "empty", "Ljava/util/concurrent/locks/Condition;", "kotlin.jvm.PlatformType", "length", "", "getLength", "()I", "setLength", "(I)V", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "clear", "", "makeList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "offer", "page", "take", "count", "expiredTimeMs", "", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer$Callback;", "Callback", "Companion", "PageData", "Policy", "plugin-finder-base_release"})
public final class o<T, A>
{
  public static final a xKV;
  private final ReentrantLock eYl;
  private final String name;
  private final Condition xKS;
  private final LinkedList<Object<T, A>> xKT;
  private final b xKU;
  
  static
  {
    AppMethodBeat.i(259408);
    xKV = new a((byte)0);
    AppMethodBeat.o(259408);
  }
  
  public o()
  {
    this(null, null, 3);
  }
  
  private o(b paramb, String paramString)
  {
    AppMethodBeat.i(259405);
    this.xKU = paramb;
    this.name = paramString;
    this.eYl = new ReentrantLock();
    this.xKS = this.eYl.newCondition();
    this.xKT = new LinkedList();
    AppMethodBeat.o(259405);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer$Companion;", "", "()V", "TAG", "", "plugin-finder-base_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer$Policy;", "", "(Ljava/lang/String;I)V", "GREEDY", "NORMAL", "plugin-finder-base_release"})
  public static enum b
  {
    static
    {
      AppMethodBeat.i(262428);
      b localb1 = new b("GREEDY", 0);
      xKW = localb1;
      b localb2 = new b("NORMAL", 1);
      xKX = localb2;
      xKY = new b[] { localb1, localb2 };
      AppMethodBeat.o(262428);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.o
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer;", "T", "A", "", "policy", "Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer$Policy;", "name", "", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer$Policy;Ljava/lang/String;)V", "buffer", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer$PageData;", "empty", "Ljava/util/concurrent/locks/Condition;", "kotlin.jvm.PlatformType", "length", "", "getLength", "()I", "setLength", "(I)V", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "clear", "", "makeList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "offer", "page", "take", "count", "expiredTimeMs", "", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer$Callback;", "Callback", "Companion", "PageData", "Policy", "plugin-finder_release"})
public final class l<T, A>
{
  public static final a tYK;
  private final ReentrantLock dgE;
  private final String name;
  private final Condition tYH;
  private final LinkedList<Object<T, A>> tYI;
  private final l.b tYJ;
  
  static
  {
    AppMethodBeat.i(245035);
    tYK = new a((byte)0);
    AppMethodBeat.o(245035);
  }
  
  public l()
  {
    this(null, null, 3);
  }
  
  private l(l.b paramb, String paramString)
  {
    AppMethodBeat.i(245033);
    this.tYJ = paramb;
    this.name = paramString;
    this.dgE = new ReentrantLock();
    this.tYH = this.dgE.newCondition();
    this.tYI = new LinkedList();
    AppMethodBeat.o(245033);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.l
 * JD-Core Version:    0.7.0.1
 */
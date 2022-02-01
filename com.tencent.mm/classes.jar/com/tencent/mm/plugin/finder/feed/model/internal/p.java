package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer;", "T", "A", "", "policy", "Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer$Policy;", "name", "", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer$Policy;Ljava/lang/String;)V", "buffer", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer$PageData;", "empty", "Ljava/util/concurrent/locks/Condition;", "kotlin.jvm.PlatformType", "length", "", "getLength", "()I", "setLength", "(I)V", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "clear", "", "makeList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "offer", "page", "take", "count", "expiredTimeMs", "", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer$Callback;", "Callback", "Companion", "PageData", "Policy", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p<T, A>
{
  public static final a BkG;
  private final b BkH;
  private final Condition BkI;
  private final LinkedList<Object<T, A>> BkJ;
  private final ReentrantLock bKF;
  private final String name;
  
  static
  {
    AppMethodBeat.i(366527);
    BkG = new a((byte)0);
    AppMethodBeat.o(366527);
  }
  
  public p()
  {
    this(null, null, 3);
  }
  
  private p(b paramb, String paramString)
  {
    AppMethodBeat.i(366516);
    this.BkH = paramb;
    this.name = paramString;
    this.bKF = new ReentrantLock();
    this.BkI = this.bKF.newCondition();
    this.BkJ = new LinkedList();
    AppMethodBeat.o(366516);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer$Companion;", "", "()V", "TAG", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer$Policy;", "", "(Ljava/lang/String;I)V", "GREEDY", "NORMAL", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum b
  {
    static
    {
      AppMethodBeat.i(366512);
      BkK = new b("GREEDY", 0);
      BkL = new b("NORMAL", 1);
      BkM = new b[] { BkK, BkL };
      AppMethodBeat.o(366512);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.p
 * JD-Core Version:    0.7.0.1
 */
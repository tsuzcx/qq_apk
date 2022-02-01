package androidx.paging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlinx.coroutines.al;
import kotlinx.coroutines.aq;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/LegacyPageFetcher;", "K", "", "V", "pagedListScope", "Lkotlinx/coroutines/CoroutineScope;", "config", "Landroidx/paging/PagedList$Config;", "source", "Landroidx/paging/PagingSource;", "notifyDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "fetchDispatcher", "pageConsumer", "Landroidx/paging/LegacyPageFetcher$PageConsumer;", "keyProvider", "Landroidx/paging/LegacyPageFetcher$KeyProvider;", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/paging/PagedList$Config;Landroidx/paging/PagingSource;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Landroidx/paging/LegacyPageFetcher$PageConsumer;Landroidx/paging/LegacyPageFetcher$KeyProvider;)V", "getConfig", "()Landroidx/paging/PagedList$Config;", "detached", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isDetached", "", "()Z", "loadStateManager", "Landroidx/paging/PagedList$LoadStateManager;", "getLoadStateManager$annotations", "()V", "getLoadStateManager", "()Landroidx/paging/PagedList$LoadStateManager;", "setLoadStateManager", "(Landroidx/paging/PagedList$LoadStateManager;)V", "getPageConsumer", "()Landroidx/paging/LegacyPageFetcher$PageConsumer;", "getSource", "()Landroidx/paging/PagingSource;", "detach", "", "onLoadError", "type", "Landroidx/paging/LoadType;", "throwable", "", "onLoadSuccess", "value", "Landroidx/paging/PagingSource$LoadResult$Page;", "retry", "scheduleAppend", "scheduleLoad", "params", "Landroidx/paging/PagingSource$LoadParams;", "schedulePrepend", "tryScheduleAppend", "trySchedulePrepend", "KeyProvider", "PageConsumer", "paging-common"}, k=1, mv={1, 4, 2})
public final class v<K, V>
{
  final AtomicBoolean bMR;
  private ap.f bMS;
  private final aq bMT;
  private final ap.e bMU;
  private final ay<K, V> bMV;
  private final al bMW;
  private final al bMX;
  private final v.b<V> bMY;
  private final v.a<K> bMZ;
  
  public v(aq paramaq, ap.e parame, ay<K, V> paramay, al paramal1, al paramal2, v.b<V> paramb, v.a<K> parama)
  {
    AppMethodBeat.i(197007);
    this.bMT = paramaq;
    this.bMU = parame;
    this.bMV = paramay;
    this.bMW = paramal1;
    this.bMX = paramal2;
    this.bMY = paramb;
    this.bMZ = parama;
    this.bMR = new AtomicBoolean(false);
    this.bMS = ((ap.f)new c(this));
    AppMethodBeat.o(197007);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"androidx/paging/LegacyPageFetcher$loadStateManager$1", "Landroidx/paging/PagedList$LoadStateManager;", "onStateChanged", "", "type", "Landroidx/paging/LoadType;", "state", "Landroidx/paging/LoadState;", "paging-common"}, k=1, mv={1, 4, 2})
  public static final class c
    extends ap.f
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.paging.v
 * JD-Core Version:    0.7.0.1
 */
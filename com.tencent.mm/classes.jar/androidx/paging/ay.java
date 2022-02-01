package androidx.paging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.d.d;
import kotlin.g.a.a;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/PagingSource;", "Key", "", "Value", "()V", "_invalid", "Ljava/util/concurrent/atomic/AtomicBoolean;", "invalid", "", "getInvalid", "()Z", "jumpingSupported", "getJumpingSupported", "keyReuseSupported", "getKeyReuseSupported", "onInvalidatedCallbacks", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lkotlin/Function0;", "", "getOnInvalidatedCallbacks$paging_common$annotations", "getOnInvalidatedCallbacks$paging_common", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "getRefreshKey", "state", "Landroidx/paging/PagingState;", "(Landroidx/paging/PagingState;)Ljava/lang/Object;", "invalidate", "load", "Landroidx/paging/PagingSource$LoadResult;", "params", "Landroidx/paging/PagingSource$LoadParams;", "(Landroidx/paging/PagingSource$LoadParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerInvalidatedCallback", "onInvalidatedCallback", "unregisterInvalidatedCallback", "LoadParams", "LoadResult", "paging-common"}, k=1, mv={1, 4, 2})
public abstract class ay<Key, Value>
{
  final CopyOnWriteArrayList<a<ah>> bLZ = new CopyOnWriteArrayList();
  final AtomicBoolean bMa = new AtomicBoolean(false);
  
  public boolean HJ()
  {
    return false;
  }
  
  public abstract Object a(a<Key> parama, d<? super ay.b<Key, Value>> paramd);
  
  public abstract Key a(ba<Key, Value> paramba);
  
  public final void invalidate()
  {
    if (this.bMa.compareAndSet(false, true))
    {
      Iterator localIterator = ((Iterable)this.bLZ).iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).invoke();
      }
    }
  }
  
  public final void m(a<ah> parama)
  {
    s.u(parama, "onInvalidatedCallback");
    this.bLZ.add(parama);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/PagingSource$LoadParams;", "Key", "", "loadSize", "", "placeholdersEnabled", "", "(IZ)V", "key", "getKey", "()Ljava/lang/Object;", "getLoadSize", "()I", "getPlaceholdersEnabled", "()Z", "Append", "Companion", "Prepend", "Refresh", "Landroidx/paging/PagingSource$LoadParams$Refresh;", "Landroidx/paging/PagingSource$LoadParams$Append;", "Landroidx/paging/PagingSource$LoadParams$Prepend;", "paging-common"}, k=1, mv={1, 4, 2})
  public static abstract class a<Key>
  {
    public static final ay.a.b bQK = new ay.a.b((byte)0);
    final boolean bMr;
    final int bQJ;
    
    private a(int paramInt, boolean paramBoolean)
    {
      this.bQJ = paramInt;
      this.bMr = paramBoolean;
    }
    
    public abstract Key getKey();
    
    @Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/PagingSource$LoadParams$Append;", "Key", "", "Landroidx/paging/PagingSource$LoadParams;", "key", "loadSize", "", "placeholdersEnabled", "", "(Ljava/lang/Object;IZ)V", "getKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", "paging-common"}, k=1, mv={1, 4, 2})
    public static final class a<Key>
      extends ay.a<Key>
    {
      private final Key key;
      
      public a(Key paramKey, int paramInt, boolean paramBoolean)
      {
        super(paramBoolean, (byte)0);
        AppMethodBeat.i(197056);
        this.key = paramKey;
        AppMethodBeat.o(197056);
      }
      
      public final Key getKey()
      {
        return this.key;
      }
    }
    
    @Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/PagingSource$LoadParams$Prepend;", "Key", "", "Landroidx/paging/PagingSource$LoadParams;", "key", "loadSize", "", "placeholdersEnabled", "", "(Ljava/lang/Object;IZ)V", "getKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", "paging-common"}, k=1, mv={1, 4, 2})
    public static final class c<Key>
      extends ay.a<Key>
    {
      private final Key key;
      
      public c(Key paramKey, int paramInt, boolean paramBoolean)
      {
        super(paramBoolean, (byte)0);
        AppMethodBeat.i(197079);
        this.key = paramKey;
        AppMethodBeat.o(197079);
      }
      
      public final Key getKey()
      {
        return this.key;
      }
    }
    
    @Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/PagingSource$LoadParams$Refresh;", "Key", "", "Landroidx/paging/PagingSource$LoadParams;", "key", "loadSize", "", "placeholdersEnabled", "", "(Ljava/lang/Object;IZ)V", "getKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", "paging-common"}, k=1, mv={1, 4, 2})
    public static final class d<Key>
      extends ay.a<Key>
    {
      private final Key key;
      
      public d(Key paramKey, int paramInt, boolean paramBoolean)
      {
        super(paramBoolean, (byte)0);
        this.key = paramKey;
      }
      
      public final Key getKey()
      {
        return this.key;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.paging.ay
 * JD-Core Version:    0.7.0.1
 */
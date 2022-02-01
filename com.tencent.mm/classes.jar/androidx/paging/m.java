package androidx.paging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.d.d;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/DataSource;", "Key", "", "Value", "type", "Landroidx/paging/DataSource$KeyType;", "(Landroidx/paging/DataSource$KeyType;)V", "_invalid", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isContiguous", "", "isContiguous$paging_common", "()Z", "isInvalid", "onInvalidatedCallbacks", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroidx/paging/DataSource$InvalidatedCallback;", "getOnInvalidatedCallbacks$paging_common$annotations", "()V", "getOnInvalidatedCallbacks$paging_common", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "supportsPageDropping", "getSupportsPageDropping$paging_common", "getType$paging_common", "()Landroidx/paging/DataSource$KeyType;", "addInvalidatedCallback", "", "onInvalidatedCallback", "getKeyInternal", "item", "getKeyInternal$paging_common", "(Ljava/lang/Object;)Ljava/lang/Object;", "invalidate", "load", "Landroidx/paging/DataSource$BaseResult;", "params", "Landroidx/paging/DataSource$Params;", "load$paging_common", "(Landroidx/paging/DataSource$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "map", "ToValue", "function", "Lkotlin/Function1;", "Landroidx/arch/core/util/Function;", "mapByPage", "", "removeInvalidatedCallback", "BaseResult", "Companion", "Factory", "InvalidatedCallback", "KeyType", "Params", "paging-common"}, k=1, mv={1, 4, 2})
public abstract class m<Key, Value>
{
  public static final b bMe = new b((byte)0);
  final CopyOnWriteArrayList<m.d> bLZ;
  final AtomicBoolean bMa;
  private final boolean bMb;
  private final boolean bMc;
  final m.e bMd;
  
  public m(m.e parame)
  {
    this.bMd = parame;
    this.bLZ = new CopyOnWriteArrayList();
    this.bMa = new AtomicBoolean(false);
    this.bMb = true;
    this.bMc = true;
  }
  
  public abstract Object a(f<Key> paramf, d<? super a<Value>> paramd);
  
  public final void a(m.d paramd)
  {
    s.u(paramd, "onInvalidatedCallback");
    this.bLZ.add(paramd);
  }
  
  public abstract Key aP(Value paramValue);
  
  public final void b(m.d paramd)
  {
    s.u(paramd, "onInvalidatedCallback");
    this.bLZ.remove(paramd);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/DataSource$BaseResult;", "Value", "", "data", "", "prevKey", "nextKey", "itemsBefore", "", "itemsAfter", "(Ljava/util/List;Ljava/lang/Object;Ljava/lang/Object;II)V", "getItemsAfter", "()I", "getItemsBefore", "getNextKey", "()Ljava/lang/Object;", "getPrevKey", "equals", "", "other", "validateForInitialTiling", "", "pageSize", "validateForInitialTiling$paging_common", "Companion", "paging-common"}, k=1, mv={1, 4, 2})
  public static final class a<Value>
  {
    public static final a bMk;
    public final List<Value> bMf;
    final Object bMg;
    final Object bMh;
    final int bMi;
    final int bMj;
    
    static
    {
      AppMethodBeat.i(196921);
      bMk = new a((byte)0);
      AppMethodBeat.o(196921);
    }
    
    public a(List<? extends Value> paramList)
    {
      AppMethodBeat.i(196917);
      this.bMf = paramList;
      this.bMg = null;
      this.bMh = null;
      this.bMi = 0;
      this.bMj = 0;
      if ((this.bMi < 0) && (this.bMi != -2147483648))
      {
        paramList = (Throwable)new IllegalArgumentException("Position must be non-negative");
        AppMethodBeat.o(196917);
        throw paramList;
      }
      if ((this.bMf.isEmpty()) && ((this.bMi > 0) || (this.bMj > 0)))
      {
        paramList = (Throwable)new IllegalArgumentException("Initial result cannot be empty if items are present in data set.");
        AppMethodBeat.o(196917);
        throw paramList;
      }
      if ((this.bMj < 0) && (this.bMj != -2147483648))
      {
        paramList = (Throwable)new IllegalArgumentException("List size + position too large, last item in list beyond totalCount.");
        AppMethodBeat.o(196917);
        throw paramList;
      }
      AppMethodBeat.o(196917);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(196928);
      if ((paramObject instanceof a))
      {
        if ((s.p(this.bMf, ((a)paramObject).bMf)) && (s.p(this.bMg, ((a)paramObject).bMg)) && (s.p(this.bMh, ((a)paramObject).bMh)) && (this.bMi == ((a)paramObject).bMi) && (this.bMj == ((a)paramObject).bMj))
        {
          AppMethodBeat.o(196928);
          return true;
        }
        AppMethodBeat.o(196928);
        return false;
      }
      AppMethodBeat.o(196928);
      return false;
    }
    
    @Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/DataSource$BaseResult$Companion;", "", "()V", "convert", "Landroidx/paging/DataSource$BaseResult;", "Value", "ToValue", "result", "function", "Landroidx/arch/core/util/Function;", "", "convert$paging_common", "empty", "T", "empty$paging_common", "paging-common"}, k=1, mv={1, 4, 2})
    public static final class a {}
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/DataSource$Companion;", "", "()V", "convert", "", "B", "A", "function", "Landroidx/arch/core/util/Function;", "source", "convert$paging_common", "paging-common"}, k=1, mv={1, 4, 2})
  public static final class b {}
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/DataSource$Factory;", "Key", "", "Value", "()V", "asPagingSourceFactory", "Lkotlin/Function0;", "Landroidx/paging/PagingSource;", "fetchDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "create", "Landroidx/paging/DataSource;", "map", "ToValue", "function", "Lkotlin/Function1;", "Landroidx/arch/core/util/Function;", "mapByPage", "", "paging-common"}, k=1, mv={1, 4, 2})
  public static abstract class c<Key, Value>
  {
    public abstract m<Key, Value> HH();
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/DataSource$Params;", "K", "", "type", "Landroidx/paging/LoadType;", "key", "initialLoadSize", "", "placeholdersEnabled", "", "pageSize", "(Landroidx/paging/LoadType;Ljava/lang/Object;IZI)V", "getInitialLoadSize", "()I", "getKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getPageSize", "getPlaceholdersEnabled", "()Z", "getType$paging_common", "()Landroidx/paging/LoadType;", "paging-common"}, k=1, mv={1, 4, 2})
  public static final class f<K>
  {
    final ad bMp;
    final int bMq;
    final boolean bMr;
    final K key;
    final int pageSize;
    
    public f(ad paramad, K paramK, int paramInt1, boolean paramBoolean, int paramInt2)
    {
      AppMethodBeat.i(196905);
      this.bMp = paramad;
      this.key = paramK;
      this.bMq = paramInt1;
      this.bMr = paramBoolean;
      this.pageSize = paramInt2;
      if ((this.bMp != ad.bNC) && (this.key == null))
      {
        paramad = (Throwable)new IllegalArgumentException("Key must be non-null for prepend/append");
        AppMethodBeat.o(196905);
        throw paramad;
      }
      AppMethodBeat.o(196905);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     androidx.paging.m
 * JD-Core Version:    0.7.0.1
 */
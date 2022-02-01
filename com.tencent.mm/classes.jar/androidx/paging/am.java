package androidx.paging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.ab;
import kotlin.d.a.a;
import kotlin.d.a.b;
import kotlin.g.b.s;
import kotlinx.coroutines.p;
import kotlinx.coroutines.q;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/PageKeyedDataSource;", "Key", "", "Value", "Landroidx/paging/DataSource;", "()V", "supportsPageDropping", "", "getSupportsPageDropping$paging_common$annotations", "getSupportsPageDropping$paging_common", "()Z", "continuationAsCallback", "Landroidx/paging/PageKeyedDataSource$LoadCallback;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "Landroidx/paging/DataSource$BaseResult;", "isAppend", "getKeyInternal", "item", "getKeyInternal$paging_common", "(Ljava/lang/Object;)Ljava/lang/Object;", "load", "params", "Landroidx/paging/DataSource$Params;", "load$paging_common", "(Landroidx/paging/DataSource$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadAfter", "Landroidx/paging/PageKeyedDataSource$LoadParams;", "(Landroidx/paging/PageKeyedDataSource$LoadParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "callback", "loadBefore", "loadInitial", "Landroidx/paging/PageKeyedDataSource$LoadInitialParams;", "(Landroidx/paging/PageKeyedDataSource$LoadInitialParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/paging/PageKeyedDataSource$LoadInitialCallback;", "map", "ToValue", "function", "Lkotlin/Function1;", "Landroidx/arch/core/util/Function;", "mapByPage", "", "LoadCallback", "LoadInitialCallback", "LoadInitialParams", "LoadParams", "paging-common"}, k=1, mv={1, 4, 2})
public abstract class am<Key, Value>
  extends m<Key, Value>
{
  public am()
  {
    super(m.e.bMm);
  }
  
  private static a<Key, Value> a(p<? super m.a<Value>> paramp, final boolean paramBoolean)
  {
    return (a)new e(paramp, paramBoolean);
  }
  
  public final Object a(m.f<Key> paramf, kotlin.d.d<? super m.a<Value>> paramd)
  {
    f localf;
    if ((paramd instanceof f))
    {
      localf = (f)paramd;
      if ((localf.label & 0x80000000) != 0) {
        localf.label += -2147483648;
      }
    }
    a locala;
    for (;;)
    {
      paramd = localf.result;
      locala = a.aiwj;
      switch (localf.label)
      {
      default: 
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        localf = new f(this, paramd);
      }
    }
    ResultKt.throwOnFailure(paramd);
    if (paramf.bMp == ad.bNC)
    {
      paramf = new c(paramf.bMq, paramf.bMr);
      localf.label = 1;
      paramd = new q(b.au(localf), 1);
      paramd.kBA();
      a(paramf, (b)new g((p)paramd));
      paramf = paramd.getResult();
      if (paramf == a.aiwj) {
        s.u(localf, "frame");
      }
      paramd = paramf;
      if (paramf == locala)
      {
        return locala;
        ResultKt.throwOnFailure(paramd);
      }
      return (m.a)paramd;
    }
    if (paramf.key == null)
    {
      paramf = m.a.bMk;
      return new m.a((List)ab.aivy);
    }
    if (paramf.bMp == ad.bND)
    {
      paramf = new d(paramf.key, paramf.pageSize);
      localf.label = 2;
      paramd = new q(b.au(localf), 1);
      paramd.kBA();
      a(paramf, a((p)paramd, false));
      paramf = paramd.getResult();
      if (paramf == a.aiwj) {
        s.u(localf, "frame");
      }
      paramd = paramf;
      if (paramf == locala)
      {
        return locala;
        ResultKt.throwOnFailure(paramd);
      }
      return (m.a)paramd;
    }
    if (paramf.bMp == ad.bNE)
    {
      paramf = new d(paramf.key, paramf.pageSize);
      localf.label = 3;
      paramd = new q(b.au(localf), 1);
      paramd.kBA();
      b(paramf, a((p)paramd, true));
      paramf = paramd.getResult();
      if (paramf == a.aiwj) {
        s.u(localf, "frame");
      }
      paramd = paramf;
      if (paramf == locala)
      {
        return locala;
        ResultKt.throwOnFailure(paramd);
      }
      return (m.a)paramd;
    }
    throw ((Throwable)new IllegalArgumentException("Unsupported type " + paramf.bMp.toString()));
  }
  
  public abstract void a(c<Key> paramc, b<Key, Value> paramb);
  
  public abstract void a(d<Key> paramd, a<Key, Value> parama);
  
  public final Key aP(Value paramValue)
  {
    s.u(paramValue, "item");
    throw ((Throwable)new IllegalStateException("Cannot get key by item in pageKeyedDataSource"));
  }
  
  public abstract void b(d<Key> paramd, a<Key, Value> parama);
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/PageKeyedDataSource$LoadCallback;", "Key", "Value", "", "()V", "onResult", "", "data", "", "adjacentPageKey", "(Ljava/util/List;Ljava/lang/Object;)V", "paging-common"}, k=1, mv={1, 4, 2})
  public static abstract class a<Key, Value> {}
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/PageKeyedDataSource$LoadInitialCallback;", "Key", "Value", "", "()V", "onResult", "", "data", "", "previousPageKey", "nextPageKey", "(Ljava/util/List;Ljava/lang/Object;Ljava/lang/Object;)V", "position", "", "totalCount", "(Ljava/util/List;IILjava/lang/Object;Ljava/lang/Object;)V", "paging-common"}, k=1, mv={1, 4, 2})
  public static abstract class b<Key, Value> {}
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/PageKeyedDataSource$LoadInitialParams;", "Key", "", "requestedLoadSize", "", "placeholdersEnabled", "", "(IZ)V", "paging-common"}, k=1, mv={1, 4, 2})
  public static final class c<Key>
  {
    public final boolean bMr;
    public final int bPu;
    
    public c(int paramInt, boolean paramBoolean)
    {
      this.bPu = paramInt;
      this.bMr = paramBoolean;
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/PageKeyedDataSource$LoadParams;", "Key", "", "key", "requestedLoadSize", "", "(Ljava/lang/Object;I)V", "Ljava/lang/Object;", "paging-common"}, k=1, mv={1, 4, 2})
  public static final class d<Key>
  {
    public final int bPu;
    public final Key key;
    
    public d(Key paramKey, int paramInt)
    {
      AppMethodBeat.i(197093);
      this.key = paramKey;
      this.bPu = paramInt;
      AppMethodBeat.o(197093);
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"androidx/paging/PageKeyedDataSource$continuationAsCallback$1", "Landroidx/paging/PageKeyedDataSource$LoadCallback;", "onResult", "", "data", "", "adjacentPageKey", "(Ljava/util/List;Ljava/lang/Object;)V", "paging-common"}, k=1, mv={1, 4, 2})
  public static final class e
    extends am.a<Key, Value>
  {
    e(p paramp, boolean paramBoolean) {}
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"load", "", "Key", "Value", "params", "Landroidx/paging/DataSource$Params;", "continuation", "Lkotlin/coroutines/Continuation;", "Landroidx/paging/DataSource$BaseResult;"}, k=3, mv={1, 4, 2})
  static final class f
    extends kotlin.d.b.a.d
  {
    int label;
    
    f(am paramam, kotlin.d.d paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(197161);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.bPx.a(null, this);
      AppMethodBeat.o(197161);
      return paramObject;
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"androidx/paging/PageKeyedDataSource$loadInitial$2$1", "Landroidx/paging/PageKeyedDataSource$LoadInitialCallback;", "onResult", "", "data", "", "previousPageKey", "nextPageKey", "(Ljava/util/List;Ljava/lang/Object;Ljava/lang/Object;)V", "position", "", "totalCount", "(Ljava/util/List;IILjava/lang/Object;Ljava/lang/Object;)V", "paging-common"}, k=1, mv={1, 4, 2})
  public static final class g
    extends am.b<Key, Value>
  {
    g(p paramp) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     androidx.paging.am
 * JD-Core Version:    0.7.0.1
 */
package androidx.paging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.j;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/AccessorState;", "Key", "", "Value", "()V", "blockStates", "", "Landroidx/paging/AccessorState$BlockState;", "[Landroidx/paging/AccessorState$BlockState;", "errors", "Landroidx/paging/LoadState$Error;", "[Landroidx/paging/LoadState$Error;", "pendingRequests", "Lkotlin/collections/ArrayDeque;", "Landroidx/paging/AccessorState$PendingRequest;", "add", "", "loadType", "Landroidx/paging/LoadType;", "pagingState", "Landroidx/paging/PagingState;", "clearErrors", "", "clearPendingRequest", "clearPendingRequests", "computeLoadStates", "Landroidx/paging/LoadStates;", "computeLoadTypeState", "Landroidx/paging/LoadState;", "getPendingBoundary", "Lkotlin/Pair;", "getPendingRefresh", "setBlockState", "state", "setError", "errorState", "BlockState", "PendingRequest", "paging-common"}, k=1, mv={1, 4, 2})
final class a<Key, Value>
{
  final a[] bKv;
  final aa.a[] bKw;
  final j<b<Key, Value>> bKx;
  
  public a()
  {
    AppMethodBeat.i(197215);
    int k = ad.values().length;
    Object localObject = new a[k];
    int i = 0;
    while (i < k)
    {
      localObject[i] = a.bKy;
      i += 1;
    }
    this.bKv = ((a[])localObject);
    k = ad.values().length;
    localObject = new aa.a[k];
    i = j;
    while (i < k)
    {
      localObject[i] = null;
      i += 1;
    }
    this.bKw = ((aa.a[])localObject);
    this.bKx = new j();
    AppMethodBeat.o(197215);
  }
  
  private final aa a(ad paramad)
  {
    AppMethodBeat.i(197205);
    a locala = this.bKv[paramad.ordinal()];
    Object localObject = (Iterable)this.bKx;
    if ((!(localObject instanceof Collection)) || (!((Collection)localObject).isEmpty()))
    {
      localObject = ((Iterable)localObject).iterator();
      if (((Iterator)localObject).hasNext()) {
        if (((b)((Iterator)localObject).next()).bKC == paramad)
        {
          i = 1;
          label83:
          if (i == 0) {
            break label117;
          }
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      if ((i == 0) || (locala == a.bKA)) {
        break label124;
      }
      paramad = (aa)aa.b.bNw;
      AppMethodBeat.o(197205);
      return paramad;
      i = 0;
      break label83;
      label117:
      break;
    }
    label124:
    paramad = this.bKw[paramad.ordinal()];
    if (paramad != null)
    {
      paramad = (aa)paramad;
      AppMethodBeat.o(197205);
      return paramad;
    }
    switch (b.$EnumSwitchMapping$0[locala.ordinal()])
    {
    default: 
      paramad = new kotlin.p();
      AppMethodBeat.o(197205);
      throw paramad;
    case 1: 
      paramad = aa.c.bNz;
      paramad = (aa)aa.c.HL();
      AppMethodBeat.o(197205);
      return paramad;
    case 2: 
      paramad = aa.c.bNz;
      paramad = (aa)aa.c.HM();
      AppMethodBeat.o(197205);
      return paramad;
    }
    paramad = aa.c.bNz;
    paramad = (aa)aa.c.HM();
    AppMethodBeat.o(197205);
    return paramad;
  }
  
  public final ab HC()
  {
    AppMethodBeat.i(197219);
    Object localObject = a(ad.bNC);
    aa localaa = a(ad.bNE);
    localObject = new ab((aa)localObject, a(ad.bND), localaa);
    AppMethodBeat.o(197219);
    return localObject;
  }
  
  public final void a(ad paramad, a parama)
  {
    AppMethodBeat.i(197226);
    s.u(paramad, "loadType");
    s.u(parama, "state");
    this.bKv[paramad.ordinal()] = parama;
    AppMethodBeat.o(197226);
  }
  
  public final void b(ad paramad)
  {
    AppMethodBeat.i(197231);
    s.u(paramad, "loadType");
    kotlin.a.p.e((List)this.bKx, (b)new c(paramad));
    AppMethodBeat.o(197231);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/AccessorState$BlockState;", "", "(Ljava/lang/String;I)V", "UNBLOCKED", "COMPLETED", "REQUIRES_REFRESH", "paging-common"}, k=1, mv={1, 4, 2})
  public static enum a
  {
    static
    {
      AppMethodBeat.i(196937);
      a locala1 = new a("UNBLOCKED", 0);
      bKy = locala1;
      a locala2 = new a("COMPLETED", 1);
      bKz = locala2;
      a locala3 = new a("REQUIRES_REFRESH", 2);
      bKA = locala3;
      bKB = new a[] { locala1, locala2, locala3 };
      AppMethodBeat.o(196937);
    }
    
    private a() {}
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/AccessorState$PendingRequest;", "Key", "", "Value", "loadType", "Landroidx/paging/LoadType;", "pagingState", "Landroidx/paging/PagingState;", "(Landroidx/paging/LoadType;Landroidx/paging/PagingState;)V", "getLoadType", "()Landroidx/paging/LoadType;", "getPagingState", "()Landroidx/paging/PagingState;", "setPagingState", "(Landroidx/paging/PagingState;)V", "paging-common"}, k=1, mv={1, 4, 2})
  public static final class b<Key, Value>
  {
    final ad bKC;
    ba<Key, Value> bKD;
    
    public b(ad paramad, ba<Key, Value> paramba)
    {
      AppMethodBeat.i(196941);
      this.bKC = paramad;
      this.bKD = paramba;
      AppMethodBeat.o(196941);
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "Key", "", "Value", "it", "Landroidx/paging/AccessorState$PendingRequest;", "invoke"}, k=3, mv={1, 4, 2})
  static final class c
    extends u
    implements b<a.b<Key, Value>, Boolean>
  {
    c(ad paramad)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.paging.a
 * JD-Core Version:    0.7.0.1
 */
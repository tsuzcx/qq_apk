package androidx.paging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/PagingSource$LoadResult;", "Key", "", "Value", "()V", "Error", "Page", "Landroidx/paging/PagingSource$LoadResult$Error;", "Landroidx/paging/PagingSource$LoadResult$Page;", "paging-common"}, k=1, mv={1, 4, 2})
public abstract class ay$b<Key, Value>
{
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/PagingSource$LoadResult$Error;", "Key", "", "Value", "Landroidx/paging/PagingSource$LoadResult;", "throwable", "", "(Ljava/lang/Throwable;)V", "getThrowable", "()Ljava/lang/Throwable;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "paging-common"}, k=1, mv={1, 4, 2})
  public static final class a<Key, Value>
    extends ay.b<Key, Value>
  {
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a)) {
          throw null;
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      throw null;
    }
    
    public final String toString()
    {
      throw null;
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/PagingSource$LoadResult$Page;", "Key", "", "Value", "Landroidx/paging/PagingSource$LoadResult;", "data", "", "prevKey", "nextKey", "(Ljava/util/List;Ljava/lang/Object;Ljava/lang/Object;)V", "itemsBefore", "", "itemsAfter", "(Ljava/util/List;Ljava/lang/Object;Ljava/lang/Object;II)V", "getData", "()Ljava/util/List;", "getItemsAfter", "()I", "getItemsBefore", "getNextKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getPrevKey", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/util/List;Ljava/lang/Object;Ljava/lang/Object;II)Landroidx/paging/PagingSource$LoadResult$Page;", "equals", "", "other", "hashCode", "toString", "", "Companion", "paging-common"}, k=1, mv={1, 4, 2})
  public static final class b<Key, Value>
    extends ay.b<Key, Value>
  {
    private static final b bQL;
    public static final a bQM;
    final List<Value> bMf;
    final Key bMg;
    final Key bMh;
    final int bMi;
    final int bMj;
    
    static
    {
      AppMethodBeat.i(196874);
      bQM = new a((byte)0);
      bQL = new b((List)ab.aivy, null, null, 0, 0);
      AppMethodBeat.o(196874);
    }
    
    public b(List<? extends Value> paramList, Key paramKey)
    {
      this(paramList, null, paramKey, -2147483648, -2147483648);
      AppMethodBeat.i(196871);
      AppMethodBeat.o(196871);
    }
    
    public b(List<? extends Value> paramList, Key paramKey1, Key paramKey2, int paramInt1, int paramInt2)
    {
      super();
      AppMethodBeat.i(196863);
      this.bMf = paramList;
      this.bMg = paramKey1;
      this.bMh = paramKey2;
      this.bMi = paramInt1;
      this.bMj = paramInt2;
      if ((this.bMi == -2147483648) || (this.bMi >= 0)) {}
      for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
      {
        paramList = (Throwable)new IllegalArgumentException("itemsBefore cannot be negative".toString());
        AppMethodBeat.o(196863);
        throw paramList;
      }
      if (this.bMj != -2147483648)
      {
        paramInt1 = i;
        if (this.bMj < 0) {}
      }
      else
      {
        paramInt1 = 1;
      }
      if (paramInt1 == 0)
      {
        paramList = (Throwable)new IllegalArgumentException("itemsAfter cannot be negative".toString());
        AppMethodBeat.o(196863);
        throw paramList;
      }
      AppMethodBeat.o(196863);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(196887);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((!s.p(this.bMf, paramObject.bMf)) || (!s.p(this.bMg, paramObject.bMg)) || (!s.p(this.bMh, paramObject.bMh)) || (this.bMi != paramObject.bMi) || (this.bMj != paramObject.bMj)) {}
        }
      }
      else
      {
        AppMethodBeat.o(196887);
        return true;
      }
      AppMethodBeat.o(196887);
      return false;
    }
    
    public final int hashCode()
    {
      int k = 0;
      AppMethodBeat.i(196881);
      Object localObject = this.bMf;
      int i;
      if (localObject != null)
      {
        i = localObject.hashCode();
        localObject = this.bMg;
        if (localObject == null) {
          break label104;
        }
      }
      label104:
      for (int j = localObject.hashCode();; j = 0)
      {
        localObject = this.bMh;
        if (localObject != null) {
          k = localObject.hashCode();
        }
        int m = this.bMi;
        int n = this.bMj;
        AppMethodBeat.o(196881);
        return (((j + i * 31) * 31 + k) * 31 + m) * 31 + n;
        i = 0;
        break;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(196877);
      String str = "Page(data=" + this.bMf + ", prevKey=" + this.bMg + ", nextKey=" + this.bMh + ", itemsBefore=" + this.bMi + ", itemsAfter=" + this.bMj + ")";
      AppMethodBeat.o(196877);
      return str;
    }
    
    @Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/PagingSource$LoadResult$Page$Companion;", "", "()V", "COUNT_UNDEFINED", "", "EMPTY", "Landroidx/paging/PagingSource$LoadResult$Page;", "", "getEMPTY$paging_common$annotations", "getEMPTY$paging_common", "()Landroidx/paging/PagingSource$LoadResult$Page;", "empty", "Key", "Value", "empty$paging_common", "paging-common"}, k=1, mv={1, 4, 2})
    public static final class a {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     androidx.paging.ay.b
 * JD-Core Version:    0.7.0.1
 */
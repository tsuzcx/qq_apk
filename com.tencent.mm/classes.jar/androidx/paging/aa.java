package androidx.paging;

import androidx.compose.b.a.e..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/LoadState;", "", "endOfPaginationReached", "", "(Z)V", "getEndOfPaginationReached", "()Z", "Error", "Loading", "NotLoading", "Landroidx/paging/LoadState$NotLoading;", "Landroidx/paging/LoadState$Loading;", "Landroidx/paging/LoadState$Error;", "paging-common"}, k=1, mv={1, 4, 2})
public abstract class aa
{
  final boolean bNv;
  
  private aa(boolean paramBoolean)
  {
    this.bNv = paramBoolean;
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/LoadState$Error;", "Landroidx/paging/LoadState;", "error", "", "(Ljava/lang/Throwable;)V", "getError", "()Ljava/lang/Throwable;", "equals", "", "other", "", "hashCode", "", "toString", "", "paging-common"}, k=1, mv={1, 4, 2})
  public static final class a
    extends aa
  {
    public final boolean equals(Object paramObject)
    {
      if (((paramObject instanceof a)) && (this.bNv == ((a)paramObject).bNv)) {
        throw null;
      }
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(196586);
      e..ExternalSyntheticBackport0.m(this.bNv);
      AppMethodBeat.o(196586);
      throw null;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(196594);
      new StringBuilder("Error(endOfPaginationReached=").append(this.bNv).append(", error=");
      AppMethodBeat.o(196594);
      throw null;
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/LoadState$Loading;", "Landroidx/paging/LoadState;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "paging-common"}, k=1, mv={1, 4, 2})
  public static final class b
    extends aa
  {
    public static final b bNw;
    
    static
    {
      AppMethodBeat.i(196613);
      bNw = new b();
      AppMethodBeat.o(196613);
    }
    
    private b()
    {
      super((byte)0);
    }
    
    public final boolean equals(Object paramObject)
    {
      return ((paramObject instanceof b)) && (this.bNv == ((b)paramObject).bNv);
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(196636);
      int i = e..ExternalSyntheticBackport0.m(this.bNv);
      AppMethodBeat.o(196636);
      return i;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(196620);
      String str = "Loading(endOfPaginationReached=" + this.bNv + ')';
      AppMethodBeat.o(196620);
      return str;
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/LoadState$NotLoading;", "Landroidx/paging/LoadState;", "endOfPaginationReached", "", "(Z)V", "equals", "other", "", "hashCode", "", "toString", "", "Companion", "paging-common"}, k=1, mv={1, 4, 2})
  public static final class c
    extends aa
  {
    private static final c bNx;
    private static final c bNy;
    public static final aa.c.a bNz;
    
    static
    {
      AppMethodBeat.i(196593);
      bNz = new aa.c.a((byte)0);
      bNx = new c(true);
      bNy = new c(false);
      AppMethodBeat.o(196593);
    }
    
    public c(boolean paramBoolean)
    {
      super((byte)0);
    }
    
    public final boolean equals(Object paramObject)
    {
      return ((paramObject instanceof c)) && (this.bNv == ((c)paramObject).bNv);
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(196622);
      int i = e..ExternalSyntheticBackport0.m(this.bNv);
      AppMethodBeat.o(196622);
      return i;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(196612);
      String str = "NotLoading(endOfPaginationReached=" + this.bNv + ')';
      AppMethodBeat.o(196612);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.paging.aa
 * JD-Core Version:    0.7.0.1
 */
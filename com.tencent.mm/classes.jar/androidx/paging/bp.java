package androidx.paging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.n.n;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/ViewportHint;", "", "presentedItemsBefore", "", "presentedItemsAfter", "originalPageOffsetFirst", "originalPageOffsetLast", "(IIII)V", "getOriginalPageOffsetFirst", "()I", "getOriginalPageOffsetLast", "getPresentedItemsAfter", "getPresentedItemsBefore", "equals", "", "other", "hashCode", "Access", "Initial", "Landroidx/paging/ViewportHint$Initial;", "Landroidx/paging/ViewportHint$Access;", "paging-common"}, k=1, mv={1, 4, 2})
public abstract class bp
{
  final int bRH;
  final int bRI;
  final int bRJ;
  final int bRK;
  
  private bp(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.bRH = paramInt1;
    this.bRI = paramInt2;
    this.bRJ = paramInt3;
    this.bRK = paramInt4;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((bp)this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof bp)) {
      return false;
    }
    return (this.bRH == ((bp)paramObject).bRH) && (this.bRI == ((bp)paramObject).bRI) && (this.bRJ == ((bp)paramObject).bRJ) && (this.bRK == ((bp)paramObject).bRK);
  }
  
  public int hashCode()
  {
    return this.bRH + this.bRI + this.bRJ + this.bRK;
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/ViewportHint$Access;", "Landroidx/paging/ViewportHint;", "pageOffset", "", "indexInPage", "presentedItemsBefore", "presentedItemsAfter", "originalPageOffsetFirst", "originalPageOffsetLast", "(IIIIII)V", "getIndexInPage", "()I", "getPageOffset", "equals", "", "other", "", "hashCode", "toString", "", "paging-common"}, k=1, mv={1, 4, 2})
  public static final class a
    extends bp
  {
    final int bRL;
    final int bRM;
    
    public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
    {
      super(paramInt4, paramInt5, paramInt6, (byte)0);
      this.bRL = paramInt1;
      this.bRM = paramInt2;
    }
    
    public final boolean equals(Object paramObject)
    {
      if ((a)this == paramObject) {
        return true;
      }
      if (!(paramObject instanceof a)) {
        return false;
      }
      return (this.bRL == ((a)paramObject).bRL) && (this.bRM == ((a)paramObject).bRM) && (this.bRH == ((a)paramObject).bRH) && (this.bRI == ((a)paramObject).bRI) && (this.bRJ == ((a)paramObject).bRJ) && (this.bRK == ((a)paramObject).bRK);
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(196741);
      int i = super.hashCode();
      int j = this.bRL;
      int k = this.bRM;
      AppMethodBeat.o(196741);
      return i + j + k;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(196755);
      String str = n.bJA("ViewportHint.Access(\n            |    pageOffset=" + this.bRL + ",\n            |    indexInPage=" + this.bRM + ",\n            |    presentedItemsBefore=" + this.bRH + ",\n            |    presentedItemsAfter=" + this.bRI + ",\n            |    originalPageOffsetFirst=" + this.bRJ + ",\n            |    originalPageOffsetLast=" + this.bRK + ",\n            |)");
      AppMethodBeat.o(196755);
      return str;
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/ViewportHint$Initial;", "Landroidx/paging/ViewportHint;", "presentedItemsBefore", "", "presentedItemsAfter", "originalPageOffsetFirst", "originalPageOffsetLast", "(IIII)V", "toString", "", "paging-common"}, k=1, mv={1, 4, 2})
  public static final class b
    extends bp
  {
    public b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super(paramInt2, paramInt3, paramInt4, (byte)0);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(196735);
      String str = n.bJA("ViewportHint.Initial(\n            |    presentedItemsBefore=" + this.bRH + ",\n            |    presentedItemsAfter=" + this.bRI + ",\n            |    originalPageOffsetFirst=" + this.bRJ + ",\n            |    originalPageOffsetLast=" + this.bRK + ",\n            |)");
      AppMethodBeat.o(196735);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.paging.bp
 * JD-Core Version:    0.7.0.1
 */
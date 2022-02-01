package androidx.paging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/TransformablePage;", "T", "", "originalPageOffset", "", "data", "", "(ILjava/util/List;)V", "originalPageOffsets", "", "hintOriginalPageOffset", "hintOriginalIndices", "([ILjava/util/List;ILjava/util/List;)V", "getData", "()Ljava/util/List;", "getHintOriginalIndices", "getHintOriginalPageOffset", "()I", "getOriginalPageOffsets", "()[I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "viewportHintFor", "Landroidx/paging/ViewportHint$Access;", "index", "presentedItemsBefore", "presentedItemsAfter", "originalPageOffsetFirst", "originalPageOffsetLast", "Companion", "paging-common"}, k=1, mv={1, 4, 2})
public final class bn<T>
{
  private static final bn<Object> bRF;
  public static final a bRG;
  public final List<T> bMf;
  final int[] bRC;
  final int bRD;
  final List<Integer> bRE;
  
  static
  {
    AppMethodBeat.i(197018);
    bRG = new a((byte)0);
    bRF = new bn(0, (List)ab.aivy);
    AppMethodBeat.o(197018);
  }
  
  public bn(int paramInt, List<? extends T> paramList)
  {
    this(new int[] { paramInt }, paramList, paramInt, null);
    AppMethodBeat.i(197012);
    AppMethodBeat.o(197012);
  }
  
  public bn(int[] paramArrayOfInt, List<? extends T> paramList, int paramInt, List<Integer> paramList1)
  {
    AppMethodBeat.i(197003);
    this.bRC = paramArrayOfInt;
    this.bMf = paramList;
    this.bRD = paramInt;
    this.bRE = paramList1;
    if (this.bRC.length == 0)
    {
      paramInt = 1;
      if (paramInt != 0) {
        break label93;
      }
    }
    label93:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0) {
        break label98;
      }
      paramArrayOfInt = (Throwable)new IllegalArgumentException("originalPageOffsets cannot be empty when constructing TransformablePage".toString());
      AppMethodBeat.o(197003);
      throw paramArrayOfInt;
      paramInt = 0;
      break;
    }
    label98:
    if (this.bRE != null)
    {
      paramInt = i;
      if (this.bRE.size() != this.bMf.size()) {}
    }
    else
    {
      paramInt = 1;
    }
    if (paramInt == 0)
    {
      paramArrayOfInt = new StringBuilder("If originalIndices (size = ");
      paramList = this.bRE;
      s.checkNotNull(paramList);
      paramArrayOfInt = (Throwable)new IllegalArgumentException((paramList.size() + ") is provided, it must be same length as data (size = " + this.bMf.size() + ')').toString());
      AppMethodBeat.o(197003);
      throw paramArrayOfInt;
    }
    AppMethodBeat.o(197003);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(197040);
    if ((bn)this == paramObject)
    {
      AppMethodBeat.o(197040);
      return true;
    }
    Class localClass2 = getClass();
    if (paramObject != null) {}
    for (Class localClass1 = paramObject.getClass(); (s.p(localClass2, localClass1) ^ true); localClass1 = null)
    {
      AppMethodBeat.o(197040);
      return false;
    }
    if (paramObject == null)
    {
      paramObject = new NullPointerException("null cannot be cast to non-null type androidx.paging.TransformablePage<*>");
      AppMethodBeat.o(197040);
      throw paramObject;
    }
    if (!Arrays.equals(this.bRC, ((bn)paramObject).bRC))
    {
      AppMethodBeat.o(197040);
      return false;
    }
    if ((s.p(this.bMf, ((bn)paramObject).bMf) ^ true))
    {
      AppMethodBeat.o(197040);
      return false;
    }
    if (this.bRD != ((bn)paramObject).bRD)
    {
      AppMethodBeat.o(197040);
      return false;
    }
    if ((s.p(this.bRE, ((bn)paramObject).bRE) ^ true))
    {
      AppMethodBeat.o(197040);
      return false;
    }
    AppMethodBeat.o(197040);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(197046);
    int j = Arrays.hashCode(this.bRC);
    int k = this.bMf.hashCode();
    int m = this.bRD;
    List localList = this.bRE;
    if (localList != null) {}
    for (int i = localList.hashCode();; i = 0)
    {
      AppMethodBeat.o(197046);
      return i + ((j * 31 + k) * 31 + m) * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(197055);
    String str = "TransformablePage(originalPageOffsets=" + Arrays.toString(this.bRC) + ", data=" + this.bMf + ", hintOriginalPageOffset=" + this.bRD + ", hintOriginalIndices=" + this.bRE + ")";
    AppMethodBeat.o(197055);
    return str;
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/TransformablePage$Companion;", "", "()V", "EMPTY_INITIAL_PAGE", "Landroidx/paging/TransformablePage;", "getEMPTY_INITIAL_PAGE", "()Landroidx/paging/TransformablePage;", "empty", "T", "paging-common"}, k=1, mv={1, 4, 2})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     androidx.paging.bn
 * JD-Core Version:    0.7.0.1
 */
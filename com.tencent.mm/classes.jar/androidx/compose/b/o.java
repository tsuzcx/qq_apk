package androidx.compose.b;

import androidx.compose.foundation.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/material/Shapes;", "", "small", "Landroidx/compose/foundation/shape/CornerBasedShape;", "medium", "large", "(Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;)V", "getLarge", "()Landroidx/compose/foundation/shape/CornerBasedShape;", "getMedium", "getSmall", "copy", "equals", "", "other", "hashCode", "", "toString", "", "material_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
{
  private final a aiM;
  private final a aiN;
  private final a aiO;
  
  private o(a parama1, a parama2, a parama3)
  {
    AppMethodBeat.i(201715);
    this.aiM = parama1;
    this.aiN = parama2;
    this.aiO = parama3;
    AppMethodBeat.o(201715);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(201723);
    if (this == paramObject)
    {
      AppMethodBeat.o(201723);
      return true;
    }
    if (!(paramObject instanceof o))
    {
      AppMethodBeat.o(201723);
      return false;
    }
    if (!s.p(this.aiM, ((o)paramObject).aiM))
    {
      AppMethodBeat.o(201723);
      return false;
    }
    if (!s.p(this.aiN, ((o)paramObject).aiN))
    {
      AppMethodBeat.o(201723);
      return false;
    }
    if (!s.p(this.aiO, ((o)paramObject).aiO))
    {
      AppMethodBeat.o(201723);
      return false;
    }
    AppMethodBeat.o(201723);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(201728);
    int i = this.aiM.hashCode();
    int j = this.aiN.hashCode();
    int k = this.aiO.hashCode();
    AppMethodBeat.o(201728);
    return (i * 31 + j) * 31 + k;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(201733);
    String str = "Shapes(small=" + this.aiM + ", medium=" + this.aiN + ", large=" + this.aiO + ')';
    AppMethodBeat.o(201733);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.b.o
 * JD-Core Version:    0.7.0.1
 */
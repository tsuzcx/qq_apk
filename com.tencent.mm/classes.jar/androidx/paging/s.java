package androidx.paging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.p;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/GenerationalViewportHint;", "", "generationId", "", "hint", "Landroidx/paging/ViewportHint;", "(ILandroidx/paging/ViewportHint;)V", "getGenerationId", "()I", "getHint", "()Landroidx/paging/ViewportHint;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "presentedItemsBeyondAnchor", "loadType", "Landroidx/paging/LoadType;", "presentedItemsBeyondAnchor$paging_common", "toString", "", "paging-common"}, k=1, mv={1, 4, 2})
public final class s
{
  final int bMO;
  final bp bMP;
  
  public s(int paramInt, bp parambp)
  {
    AppMethodBeat.i(197089);
    this.bMO = paramInt;
    this.bMP = parambp;
    AppMethodBeat.o(197089);
  }
  
  public final int c(ad paramad)
  {
    AppMethodBeat.i(197099);
    kotlin.g.b.s.u(paramad, "loadType");
    switch (t.$EnumSwitchMapping$0[paramad.ordinal()])
    {
    default: 
      paramad = new p();
      AppMethodBeat.o(197099);
      throw paramad;
    case 1: 
      paramad = (Throwable)new IllegalArgumentException("Cannot get presentedItems for loadType: REFRESH");
      AppMethodBeat.o(197099);
      throw paramad;
    case 2: 
      i = this.bMP.bRH;
      AppMethodBeat.o(197099);
      return i;
    }
    int i = this.bMP.bRI;
    AppMethodBeat.o(197099);
    return i;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(197123);
    if (this != paramObject)
    {
      if ((paramObject instanceof s))
      {
        paramObject = (s)paramObject;
        if ((this.bMO != paramObject.bMO) || (!kotlin.g.b.s.p(this.bMP, paramObject.bMP))) {}
      }
    }
    else
    {
      AppMethodBeat.o(197123);
      return true;
    }
    AppMethodBeat.o(197123);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(197113);
    int j = this.bMO;
    bp localbp = this.bMP;
    if (localbp != null) {}
    for (int i = localbp.hashCode();; i = 0)
    {
      AppMethodBeat.o(197113);
      return i + j * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(197104);
    String str = "GenerationalViewportHint(generationId=" + this.bMO + ", hint=" + this.bMP + ")";
    AppMethodBeat.o(197104);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.paging.s
 * JD-Core Version:    0.7.0.1
 */
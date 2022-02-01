package androidx.paging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.p;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/LoadStates;", "", "refresh", "Landroidx/paging/LoadState;", "prepend", "append", "(Landroidx/paging/LoadState;Landroidx/paging/LoadState;Landroidx/paging/LoadState;)V", "getAppend", "()Landroidx/paging/LoadState;", "getPrepend", "getRefresh", "component1", "component2", "component3", "copy", "equals", "", "other", "forEach", "", "op", "Lkotlin/Function2;", "Landroidx/paging/LoadType;", "get", "loadType", "get$paging_common", "hashCode", "", "modifyState", "newState", "modifyState$paging_common", "toString", "", "Companion", "paging-common"}, k=1, mv={1, 4, 2})
public final class ab
{
  private static final ab bNA;
  public static final ab.a bNB;
  public final aa bLA;
  public final aa bLB;
  public final aa bLz;
  
  static
  {
    AppMethodBeat.i(196767);
    bNB = new ab.a((byte)0);
    Object localObject1 = aa.c.bNz;
    localObject1 = (aa)aa.c.HM();
    Object localObject2 = aa.c.bNz;
    localObject2 = (aa)aa.c.HM();
    aa.c.a locala = aa.c.bNz;
    bNA = new ab((aa)localObject1, (aa)localObject2, (aa)aa.c.HM());
    AppMethodBeat.o(196767);
  }
  
  public ab(aa paramaa1, aa paramaa2, aa paramaa3)
  {
    AppMethodBeat.i(196760);
    this.bLz = paramaa1;
    this.bLA = paramaa2;
    this.bLB = paramaa3;
    AppMethodBeat.o(196760);
  }
  
  private static ab a(aa paramaa1, aa paramaa2, aa paramaa3)
  {
    AppMethodBeat.i(196779);
    s.u(paramaa1, "refresh");
    s.u(paramaa2, "prepend");
    s.u(paramaa3, "append");
    paramaa1 = new ab(paramaa1, paramaa2, paramaa3);
    AppMethodBeat.o(196779);
    return paramaa1;
  }
  
  public final ab a(ad paramad, aa paramaa)
  {
    AppMethodBeat.i(196795);
    s.u(paramad, "loadType");
    s.u(paramaa, "newState");
    switch (ac.$EnumSwitchMapping$0[paramad.ordinal()])
    {
    default: 
      paramad = new p();
      AppMethodBeat.o(196795);
      throw paramad;
    case 1: 
      paramad = a(this, null, null, paramaa, 3);
      AppMethodBeat.o(196795);
      return paramad;
    case 2: 
      paramad = a(this, null, paramaa, null, 5);
      AppMethodBeat.o(196795);
      return paramad;
    }
    paramad = a(this, paramaa, null, null, 6);
    AppMethodBeat.o(196795);
    return paramad;
  }
  
  public final aa d(ad paramad)
  {
    AppMethodBeat.i(196801);
    s.u(paramad, "loadType");
    switch (ac.avl[paramad.ordinal()])
    {
    default: 
      paramad = new p();
      AppMethodBeat.o(196801);
      throw paramad;
    case 1: 
      paramad = this.bLz;
      AppMethodBeat.o(196801);
      return paramad;
    case 2: 
      paramad = this.bLB;
      AppMethodBeat.o(196801);
      return paramad;
    }
    paramad = this.bLA;
    AppMethodBeat.o(196801);
    return paramad;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(196818);
    if (this != paramObject)
    {
      if ((paramObject instanceof ab))
      {
        paramObject = (ab)paramObject;
        if ((!s.p(this.bLz, paramObject.bLz)) || (!s.p(this.bLA, paramObject.bLA)) || (!s.p(this.bLB, paramObject.bLB))) {}
      }
    }
    else
    {
      AppMethodBeat.o(196818);
      return true;
    }
    AppMethodBeat.o(196818);
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(196811);
    aa localaa = this.bLz;
    int i;
    if (localaa != null)
    {
      i = localaa.hashCode();
      localaa = this.bLA;
      if (localaa == null) {
        break label80;
      }
    }
    label80:
    for (int j = localaa.hashCode();; j = 0)
    {
      localaa = this.bLB;
      if (localaa != null) {
        k = localaa.hashCode();
      }
      AppMethodBeat.o(196811);
      return (j + i * 31) * 31 + k;
      i = 0;
      break;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(196805);
    String str = "LoadStates(refresh=" + this.bLz + ", prepend=" + this.bLA + ", append=" + this.bLB + ")";
    AppMethodBeat.o(196805);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.paging.ab
 * JD-Core Version:    0.7.0.1
 */
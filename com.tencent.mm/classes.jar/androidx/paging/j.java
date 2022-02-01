package androidx.paging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/CombinedLoadStates;", "", "refresh", "Landroidx/paging/LoadState;", "prepend", "append", "source", "Landroidx/paging/LoadStates;", "mediator", "(Landroidx/paging/LoadState;Landroidx/paging/LoadState;Landroidx/paging/LoadState;Landroidx/paging/LoadStates;Landroidx/paging/LoadStates;)V", "getAppend", "()Landroidx/paging/LoadState;", "getMediator", "()Landroidx/paging/LoadStates;", "getPrepend", "getRefresh", "getSource", "equals", "", "other", "forEach", "", "op", "Lkotlin/Function3;", "Landroidx/paging/LoadType;", "forEach$paging_common", "hashCode", "", "toString", "", "Companion", "paging-common"}, k=1, mv={1, 4, 2})
public final class j
{
  private static final j bLE;
  public static final j.a bLF;
  final aa bLA;
  public final aa bLB;
  final ab bLC;
  final ab bLD;
  public final aa bLz;
  
  static
  {
    AppMethodBeat.i(197071);
    bLF = new j.a((byte)0);
    Object localObject1 = aa.c.bNz;
    localObject1 = (aa)aa.c.HM();
    Object localObject2 = aa.c.bNz;
    localObject2 = (aa)aa.c.HM();
    Object localObject3 = aa.c.bNz;
    localObject3 = (aa)aa.c.HM();
    ab.a locala = ab.bNB;
    bLE = new j((aa)localObject1, (aa)localObject2, (aa)localObject3, ab.HN());
    AppMethodBeat.o(197071);
  }
  
  public j(aa paramaa1, aa paramaa2, aa paramaa3, ab paramab1, ab paramab2)
  {
    AppMethodBeat.i(197059);
    this.bLz = paramaa1;
    this.bLA = paramaa2;
    this.bLB = paramaa3;
    this.bLC = paramab1;
    this.bLD = paramab2;
    AppMethodBeat.o(197059);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(197077);
    if ((j)this == paramObject)
    {
      AppMethodBeat.o(197077);
      return true;
    }
    Class localClass2 = getClass();
    if (paramObject != null) {}
    for (Class localClass1 = paramObject.getClass(); (s.p(localClass2, localClass1) ^ true); localClass1 = null)
    {
      AppMethodBeat.o(197077);
      return false;
    }
    if (paramObject == null)
    {
      paramObject = new NullPointerException("null cannot be cast to non-null type androidx.paging.CombinedLoadStates");
      AppMethodBeat.o(197077);
      throw paramObject;
    }
    if ((s.p(this.bLz, ((j)paramObject).bLz) ^ true))
    {
      AppMethodBeat.o(197077);
      return false;
    }
    if ((s.p(this.bLA, ((j)paramObject).bLA) ^ true))
    {
      AppMethodBeat.o(197077);
      return false;
    }
    if ((s.p(this.bLB, ((j)paramObject).bLB) ^ true))
    {
      AppMethodBeat.o(197077);
      return false;
    }
    if ((s.p(this.bLC, ((j)paramObject).bLC) ^ true))
    {
      AppMethodBeat.o(197077);
      return false;
    }
    if ((s.p(this.bLD, ((j)paramObject).bLD) ^ true))
    {
      AppMethodBeat.o(197077);
      return false;
    }
    AppMethodBeat.o(197077);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(197082);
    int j = this.bLz.hashCode();
    int k = this.bLA.hashCode();
    int m = this.bLB.hashCode();
    int n = this.bLC.hashCode();
    ab localab = this.bLD;
    if (localab != null) {}
    for (int i = localab.hashCode();; i = 0)
    {
      AppMethodBeat.o(197082);
      return i + (((j * 31 + k) * 31 + m) * 31 + n) * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(197086);
    String str = "CombinedLoadStates(refresh=" + this.bLz + ", prepend=" + this.bLA + ", append=" + this.bLB + ", source=" + this.bLC + ", mediator=" + this.bLD + ')';
    AppMethodBeat.o(197086);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.paging.j
 * JD-Core Version:    0.7.0.1
 */
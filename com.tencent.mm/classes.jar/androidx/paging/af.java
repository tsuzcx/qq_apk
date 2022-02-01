package androidx.paging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/MutableLoadStateCollection;", "", "()V", "append", "Landroidx/paging/LoadState;", "mediator", "Landroidx/paging/LoadStates;", "prepend", "refresh", "source", "computeHelperState", "previousState", "sourceRefreshState", "sourceState", "remoteState", "forEach", "", "op", "Lkotlin/Function3;", "Landroidx/paging/LoadType;", "", "forEach$paging_common", "get", "type", "remote", "set", "combinedLoadStates", "Landroidx/paging/CombinedLoadStates;", "sourceLoadStates", "remoteLoadStates", "state", "snapshot", "terminates", "loadType", "terminates$paging_common", "updateHelperStates", "paging-common"}, k=1, mv={1, 4, 2})
public final class af
{
  private aa bLA;
  private aa bLB;
  ab bLC;
  ab bLD;
  private aa bLz;
  
  public af()
  {
    AppMethodBeat.i(196707);
    Object localObject = aa.c.bNz;
    this.bLz = ((aa)aa.c.HM());
    localObject = aa.c.bNz;
    this.bLA = ((aa)aa.c.HM());
    localObject = aa.c.bNz;
    this.bLB = ((aa)aa.c.HM());
    localObject = ab.bNB;
    this.bLC = ab.HN();
    AppMethodBeat.o(196707);
  }
  
  private static aa a(aa paramaa1, aa paramaa2, aa paramaa3, aa paramaa4)
  {
    if (paramaa4 == null) {
      return paramaa3;
    }
    if (((paramaa1 instanceof aa.b)) && ((!(paramaa2 instanceof aa.c)) || (!(paramaa4 instanceof aa.c))) && (!(paramaa4 instanceof aa.a))) {
      return paramaa1;
    }
    return paramaa4;
  }
  
  public final j HO()
  {
    AppMethodBeat.i(196712);
    j localj = new j(this.bLz, this.bLA, this.bLB, this.bLC, this.bLD);
    AppMethodBeat.o(196712);
    return localj;
  }
  
  final void HP()
  {
    Object localObject2 = null;
    AppMethodBeat.i(196730);
    aa localaa1 = this.bLz;
    aa localaa2 = this.bLC.bLz;
    aa localaa3 = this.bLC.bLz;
    Object localObject1 = this.bLD;
    if (localObject1 != null)
    {
      localObject1 = ((ab)localObject1).bLz;
      this.bLz = a(localaa1, localaa2, localaa3, (aa)localObject1);
      localaa1 = this.bLA;
      localaa2 = this.bLC.bLz;
      localaa3 = this.bLC.bLA;
      localObject1 = this.bLD;
      if (localObject1 == null) {
        break label173;
      }
    }
    label173:
    for (localObject1 = ((ab)localObject1).bLA;; localObject1 = null)
    {
      this.bLA = a(localaa1, localaa2, localaa3, (aa)localObject1);
      localaa1 = this.bLB;
      localaa2 = this.bLC.bLz;
      localaa3 = this.bLC.bLB;
      ab localab = this.bLD;
      localObject1 = localObject2;
      if (localab != null) {
        localObject1 = localab.bLB;
      }
      this.bLB = a(localaa1, localaa2, localaa3, (aa)localObject1);
      AppMethodBeat.o(196730);
      return;
      localObject1 = null;
      break;
    }
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(196718);
    s.u(paramj, "combinedLoadStates");
    this.bLz = paramj.bLz;
    this.bLA = paramj.bLA;
    this.bLB = paramj.bLB;
    this.bLC = paramj.bLC;
    this.bLD = paramj.bLD;
    AppMethodBeat.o(196718);
  }
  
  public final boolean a(ad paramad, boolean paramBoolean, aa paramaa)
  {
    AppMethodBeat.i(196725);
    s.u(paramad, "type");
    s.u(paramaa, "state");
    ab localab2;
    Object localObject;
    if (paramBoolean)
    {
      localab2 = this.bLD;
      ab localab1 = this.bLD;
      localObject = localab1;
      if (localab1 == null)
      {
        localObject = ab.bNB;
        localObject = ab.HN();
      }
      this.bLD = ((ab)localObject).a(paramad, paramaa);
    }
    for (paramBoolean = s.p(this.bLD, localab2) ^ true;; paramBoolean = s.p(this.bLC, localObject) ^ true)
    {
      HP();
      AppMethodBeat.o(196725);
      return paramBoolean;
      localObject = this.bLC;
      this.bLC = this.bLC.a(paramad, paramaa);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.paging.af
 * JD-Core Version:    0.7.0.1
 */
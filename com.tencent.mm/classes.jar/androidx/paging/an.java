package androidx.paging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.q;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k.g;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/PagePresenter;", "T", "", "Landroidx/paging/NullPaddedList;", "insertEvent", "Landroidx/paging/PageEvent$Insert;", "(Landroidx/paging/PageEvent$Insert;)V", "originalPageOffsetFirst", "", "getOriginalPageOffsetFirst", "()I", "originalPageOffsetLast", "getOriginalPageOffsetLast", "pages", "", "Landroidx/paging/TransformablePage;", "<set-?>", "placeholdersAfter", "getPlaceholdersAfter", "placeholdersBefore", "getPlaceholdersBefore", "size", "getSize", "storageCount", "getStorageCount", "accessHintForPresenterIndex", "Landroidx/paging/ViewportHint$Access;", "index", "checkIndex", "", "dropPages", "drop", "Landroidx/paging/PageEvent$Drop;", "callback", "Landroidx/paging/PagePresenter$ProcessPageEventCallback;", "dropPagesWithOffsets", "pageOffsetsToDrop", "Lkotlin/ranges/IntRange;", "get", "(I)Ljava/lang/Object;", "getFromStorage", "localIndex", "initializeHint", "Landroidx/paging/ViewportHint$Initial;", "insertPage", "insert", "processEvent", "pageEvent", "Landroidx/paging/PageEvent;", "snapshot", "Landroidx/paging/ItemSnapshotList;", "toString", "", "fullCount", "", "Companion", "ProcessPageEventCallback", "paging-common"}, k=1, mv={1, 4, 2})
public final class an<T>
{
  private static final an<Object> bPA;
  public static final an.a bPB;
  public int bMw;
  public int bMx;
  public final List<bn<T>> bNN;
  public int bPz;
  
  static
  {
    AppMethodBeat.i(196714);
    bPB = new an.a((byte)0);
    ag.b.a locala = ag.b.bNQ;
    bPA = new an(ag.b.HQ());
    AppMethodBeat.o(196714);
  }
  
  public an(ag.b<T> paramb)
  {
    AppMethodBeat.i(196706);
    this.bNN = p.J((Collection)paramb.bNN);
    this.bPz = ab(paramb.bNN);
    this.bMw = paramb.bMw;
    this.bMx = paramb.bMx;
    AppMethodBeat.o(196706);
  }
  
  private final int a(g paramg)
  {
    AppMethodBeat.i(196694);
    Iterator localIterator = this.bNN.iterator();
    int i = 0;
    int j;
    if (localIterator.hasNext())
    {
      bn localbn = (bn)localIterator.next();
      int[] arrayOfInt = localbn.bRC;
      int k = arrayOfInt.length;
      j = 0;
      label54:
      if (j < k) {
        if (paramg.aKs(arrayOfInt[j]))
        {
          j = 1;
          label73:
          if (j == 0) {
            break label119;
          }
          i = localbn.bMf.size() + i;
          localIterator.remove();
        }
      }
    }
    label119:
    for (;;)
    {
      break;
      j += 1;
      break label54;
      j = 0;
      break label73;
      AppMethodBeat.o(196694);
      return i;
    }
  }
  
  private static int ab(List<bn<T>> paramList)
  {
    AppMethodBeat.i(196685);
    paramList = ((Iterable)paramList).iterator();
    for (int i = 0; paramList.hasNext(); i = ((bn)paramList.next()).bMf.size() + i) {}
    AppMethodBeat.o(196685);
    return i;
  }
  
  final int HU()
  {
    AppMethodBeat.i(196733);
    Object localObject = ((bn)p.oK(this.bNN)).bRC;
    s.u(localObject, "$this$minOrNull");
    if (localObject.length == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      localObject = null;
      s.checkNotNull(localObject);
      i = ((Integer)localObject).intValue();
      AppMethodBeat.o(196733);
      return i;
    }
    i = localObject[0];
    int m = k.ad((int[])localObject);
    int j;
    label84:
    int k;
    if (m > 0)
    {
      j = 1;
      k = localObject[j];
      if (i <= k) {
        break label122;
      }
      i = k;
    }
    label122:
    for (;;)
    {
      k = i;
      if (j != m)
      {
        j += 1;
        break label84;
        k = i;
      }
      localObject = Integer.valueOf(k);
      break;
    }
  }
  
  final int HV()
  {
    AppMethodBeat.i(196745);
    Integer localInteger = k.ag(((bn)p.oM(this.bNN)).bRC);
    s.checkNotNull(localInteger);
    int i = localInteger.intValue();
    AppMethodBeat.o(196745);
    return i;
  }
  
  public final void a(ag<T> paramag, b paramb)
  {
    AppMethodBeat.i(196806);
    s.u(paramag, "pageEvent");
    s.u(paramb, "callback");
    int i;
    int j;
    Object localObject1;
    int k;
    if ((paramag instanceof ag.b))
    {
      paramag = (ag.b)paramag;
      i = ab(paramag.bNN);
      j = getSize();
      localObject1 = paramag.bKC;
      switch (ao.$EnumSwitchMapping$0[localObject1.ordinal()])
      {
      }
      for (;;)
      {
        localObject1 = paramag.bNO;
        paramag = (q)new c(paramb);
        s.u(paramag, "op");
        paramb = ((j)localObject1).bLC;
        Object localObject2 = ad.bNC;
        aa localaa = paramb.bLz;
        paramag.invoke(localObject2, Boolean.FALSE, localaa);
        localObject2 = ad.bND;
        localaa = paramb.bLA;
        paramag.invoke(localObject2, Boolean.FALSE, localaa);
        localObject2 = ad.bNE;
        paramb = paramb.bLB;
        paramag.invoke(localObject2, Boolean.FALSE, paramb);
        paramb = ((j)localObject1).bLD;
        if (paramb == null) {
          break;
        }
        localObject1 = ad.bNC;
        localObject2 = paramb.bLz;
        paramag.invoke(localObject1, Boolean.TRUE, localObject2);
        localObject1 = ad.bND;
        localObject2 = paramb.bLA;
        paramag.invoke(localObject1, Boolean.TRUE, localObject2);
        localObject1 = ad.bNE;
        paramb = paramb.bLB;
        paramag.invoke(localObject1, Boolean.TRUE, paramb);
        AppMethodBeat.o(196806);
        return;
        paramag = (Throwable)new IllegalArgumentException();
        AppMethodBeat.o(196806);
        throw paramag;
        k = Math.min(this.bMw, i);
        int m = i - k;
        this.bNN.addAll(0, (Collection)paramag.bNN);
        this.bPz += i;
        this.bMw = paramag.bMw;
        paramb.fc(k);
        paramb.fg(m);
        i = getSize() - j - m;
        if (i > 0)
        {
          paramb.fg(i);
        }
        else if (i < 0)
        {
          paramb.fh(-i);
          continue;
          k = Math.min(this.bMx, i);
          m = i - k;
          this.bNN.addAll(this.bNN.size(), (Collection)paramag.bNN);
          this.bPz += i;
          this.bMx = paramag.bMx;
          paramb.fc(k);
          paramb.fg(m);
          i = getSize() - j - m;
          if (i > 0)
          {
            getSize();
            paramb.fg(i);
          }
          else if (i < 0)
          {
            getSize();
            paramb.fh(-i);
          }
        }
      }
      AppMethodBeat.o(196806);
      return;
    }
    if ((paramag instanceof ag.a))
    {
      paramag = (ag.a)paramag;
      i = getSize();
      if (paramag.bKC == ad.bND)
      {
        j = this.bMw;
        k = a(new g(paramag.bNK, paramag.bNL));
        this.bPz -= k;
        this.bMw = paramag.bNM;
        i = getSize() - i;
        if (i > 0) {
          paramb.fg(i);
        }
        for (;;)
        {
          i = Math.max(0, i + j);
          i = paramag.bNM - i;
          if (i > 0) {
            paramb.fc(i);
          }
          paramag = ad.bND;
          localObject1 = aa.c.bNz;
          paramb.b(paramag, false, (aa)aa.c.HM());
          AppMethodBeat.o(196806);
          return;
          if (i < 0) {
            paramb.fh(-i);
          }
        }
      }
      j = this.bMx;
      k = a(new g(paramag.bNK, paramag.bNL));
      this.bPz -= k;
      this.bMx = paramag.bNM;
      i = getSize() - i;
      if (i > 0)
      {
        paramb.fg(i);
        if (i >= 0) {
          break label843;
        }
      }
      label843:
      for (i = Math.min(j, -i);; i = 0)
      {
        i = paramag.bNM - (j - i);
        if (i > 0)
        {
          getSize();
          paramb.fc(i);
        }
        paramag = ad.bNE;
        localObject1 = aa.c.bNz;
        paramb.b(paramag, false, (aa)aa.c.HM());
        AppMethodBeat.o(196806);
        return;
        if (i >= 0) {
          break;
        }
        paramb.fh(-i);
        break;
      }
    }
    if ((paramag instanceof ag.c)) {
      paramb.b(((ag.c)paramag).bKC, ((ag.c)paramag).bNX, ((ag.c)paramag).bNY);
    }
    AppMethodBeat.o(196806);
  }
  
  public final T fl(int paramInt)
  {
    AppMethodBeat.i(196768);
    int k = this.bNN.size();
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < k)
    {
      j = ((bn)this.bNN.get(paramInt)).bMf.size();
      if (j > i) {
        break;
      }
      i -= j;
      paramInt += 1;
    }
    Object localObject = ((bn)this.bNN.get(paramInt)).bMf.get(i);
    AppMethodBeat.o(196768);
    return localObject;
  }
  
  public final bp.a fm(int paramInt)
  {
    AppMethodBeat.i(196823);
    int j = 0;
    int i = paramInt - this.bMw;
    while ((i >= ((bn)this.bNN.get(j)).bMf.size()) && (j < p.oE(this.bNN)))
    {
      k = ((bn)this.bNN.get(j)).bMf.size();
      j += 1;
      i -= k;
    }
    Object localObject1 = (bn)this.bNN.get(j);
    j = this.bMw;
    int k = getSize();
    int m = this.bMx;
    int n = HU();
    int i1 = HV();
    int i2 = ((bn)localObject1).bRD;
    Object localObject2 = ((bn)localObject1).bRE;
    if (localObject2 != null)
    {
      localObject2 = p.F((Collection)localObject2);
      if ((localObject2 != null) && (((g)localObject2).aKs(i) == true)) {
        i = ((Number)((bn)localObject1).bRE.get(i)).intValue();
      }
    }
    for (;;)
    {
      localObject1 = new bp.a(i2, i, paramInt - j, k - paramInt - m - 1, n, i1);
      AppMethodBeat.o(196823);
      return localObject1;
    }
  }
  
  public final int getSize()
  {
    return this.bMw + this.bPz + this.bMx;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(196759);
    int j = this.bPz;
    Object localObject = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      ((ArrayList)localObject).add(fl(i));
      i += 1;
    }
    localObject = p.a((Iterable)localObject, null, null, null, 0, null, null, 63);
    localObject = "[(" + this.bMw + " placeholders), " + (String)localObject + ", (" + this.bMx + " placeholders)]";
    AppMethodBeat.o(196759);
    return localObject;
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/PagePresenter$ProcessPageEventCallback;", "", "onChanged", "", "position", "", "count", "onInserted", "onRemoved", "onStateUpdate", "loadType", "Landroidx/paging/LoadType;", "fromMediator", "", "loadState", "Landroidx/paging/LoadState;", "paging-common"}, k=1, mv={1, 4, 2})
  public static abstract interface b
  {
    public abstract void b(ad paramad, boolean paramBoolean, aa paramaa);
    
    public abstract void fc(int paramInt);
    
    public abstract void fg(int paramInt);
    
    public abstract void fh(int paramInt);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "", "type", "Landroidx/paging/LoadType;", "fromMediator", "", "state", "Landroidx/paging/LoadState;", "invoke"}, k=3, mv={1, 4, 2})
  static final class c
    extends u
    implements q<ad, Boolean, aa, ah>
  {
    c(an.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.paging.an
 * JD-Core Version:    0.7.0.1
 */
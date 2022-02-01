package androidx.compose.runtime.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.p;
import kotlin.ah;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.m.h;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "", "", "upperSet", "", "lowerSet", "lowerBound", "belowBound", "", "(JJI[I)V", "andNot", "bits", "clear", "bit", "get", "", "iterator", "", "lowest", "default", "or", "set", "toString", "", "Companion", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  implements Iterable<Integer>, kotlin.g.b.a.a
{
  public static final j.a asC;
  private static final j asH;
  final long asD;
  final long asE;
  final int asF;
  final int[] asG;
  
  static
  {
    AppMethodBeat.i(202535);
    asC = new j.a((byte)0);
    asH = new j(0L, 0L, 0, null);
    AppMethodBeat.o(202535);
  }
  
  private j(long paramLong1, long paramLong2, int paramInt, int[] paramArrayOfInt)
  {
    this.asD = paramLong1;
    this.asE = paramLong2;
    this.asF = paramInt;
    this.asG = paramArrayOfInt;
  }
  
  public final boolean cr(int paramInt)
  {
    AppMethodBeat.i(202545);
    int i = paramInt - this.asF;
    if ((i >= 0) && (i < 64))
    {
      if ((1L << i & this.asE) != 0L)
      {
        AppMethodBeat.o(202545);
        return true;
      }
      AppMethodBeat.o(202545);
      return false;
    }
    if ((i >= 64) && (i < 128))
    {
      if ((1L << i - 64 & this.asD) != 0L)
      {
        AppMethodBeat.o(202545);
        return true;
      }
      AppMethodBeat.o(202545);
      return false;
    }
    if (i > 0)
    {
      AppMethodBeat.o(202545);
      return false;
    }
    int[] arrayOfInt = this.asG;
    if (arrayOfInt == null)
    {
      AppMethodBeat.o(202545);
      return false;
    }
    if (k.p(arrayOfInt, paramInt) >= 0)
    {
      AppMethodBeat.o(202545);
      return true;
    }
    AppMethodBeat.o(202545);
    return false;
  }
  
  public final j cs(int paramInt)
  {
    AppMethodBeat.i(202566);
    j localj = this;
    int i = paramInt - localj.asF;
    long l1;
    Object localObject1;
    long l2;
    label208:
    Object localObject3;
    Object localObject2;
    int j;
    if ((i >= 0) && (i < 64))
    {
      l1 = 1L << i;
      if ((localj.asE & l1) == 0L)
      {
        localObject1 = new j(localj.asD, l1 | localj.asE, localj.asF, localj.asG);
        AppMethodBeat.o(202566);
        return localObject1;
      }
    }
    else if ((i >= 64) && (i < 128))
    {
      l1 = 1L << i - 64;
      if ((localj.asD & l1) == 0L)
      {
        localObject1 = new j(l1 | localj.asD, localj.asE, localj.asF, localj.asG);
        AppMethodBeat.o(202566);
        return localObject1;
      }
    }
    else if (i >= 128)
    {
      if (localj.cr(paramInt)) {
        break label577;
      }
      l1 = localj.asD;
      l2 = localj.asE;
      i = localj.asF;
      localObject1 = null;
      int k = (paramInt + 1) / 64 * 64;
      if (i >= k) {
        break label585;
      }
      localObject3 = localObject1;
      if (l2 != 0L)
      {
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject2 = (List)new ArrayList();
          localObject1 = localj.asG;
          if (localObject1 != null)
          {
            int m = localObject1.length;
            j = 0;
            while (j < m)
            {
              ((List)localObject2).add(Integer.valueOf(localObject1[j]));
              j += 1;
            }
          }
          localObject1 = ah.aiuX;
        }
        j = 0;
        for (;;)
        {
          localObject3 = localObject2;
          if (j >= 64) {
            break;
          }
          if ((1L << j & l2) != 0L) {
            ((List)localObject2).add(Integer.valueOf(j + i));
          }
          j += 1;
        }
      }
      if (l1 == 0L)
      {
        l2 = 0L;
        i = k;
        localObject1 = localObject3;
      }
    }
    label577:
    label585:
    for (;;)
    {
      if (localObject1 == null) {}
      for (localObject1 = null;; localObject1 = p.I((Collection)localObject1))
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = localj.asG;
        }
        localj = new j(l1, l2, i, (int[])localObject2);
        break;
        i += 64;
        l2 = l1;
        l1 = 0L;
        localObject1 = localObject3;
        break label208;
      }
      localObject1 = localj.asG;
      if (localObject1 == null)
      {
        localObject1 = new j(localj.asD, localj.asE, localj.asF, new int[] { paramInt });
        AppMethodBeat.o(202566);
        return localObject1;
      }
      i = k.p((int[])localObject1, paramInt);
      if (i < 0)
      {
        i = -(i + 1);
        j = localObject1.length + 1;
        localObject2 = new int[j];
        kotlin.a.k.a((int[])localObject1, (int[])localObject2, 0, 0, i);
        kotlin.a.k.a((int[])localObject1, (int[])localObject2, i + 1, i, j - 1);
        localObject2[i] = paramInt;
        localObject1 = new j(localj.asD, localj.asE, localj.asF, (int[])localObject2);
        AppMethodBeat.o(202566);
        return localObject1;
      }
      AppMethodBeat.o(202566);
      return localj;
    }
  }
  
  public final j ct(int paramInt)
  {
    AppMethodBeat.i(202580);
    int i = paramInt - this.asF;
    long l;
    Object localObject;
    if ((i >= 0) && (i < 64))
    {
      l = 1L << i;
      if ((this.asE & l) != 0L)
      {
        localObject = new j(this.asD, (l ^ 0xFFFFFFFF) & this.asE, this.asF, this.asG);
        AppMethodBeat.o(202580);
        return localObject;
      }
    }
    else if ((i >= 64) && (i < 128))
    {
      l = 1L << i - 64;
      if ((this.asD & l) != 0L)
      {
        localObject = new j((l ^ 0xFFFFFFFF) & this.asD, this.asE, this.asF, this.asG);
        AppMethodBeat.o(202580);
        return localObject;
      }
    }
    else if (i < 0)
    {
      localObject = this.asG;
      if (localObject != null)
      {
        paramInt = k.p((int[])localObject, paramInt);
        if (paramInt >= 0)
        {
          i = localObject.length - 1;
          if (i == 0)
          {
            localObject = new j(this.asD, this.asE, this.asF, null);
            AppMethodBeat.o(202580);
            return localObject;
          }
          int[] arrayOfInt = new int[i];
          if (paramInt > 0) {
            kotlin.a.k.a((int[])localObject, arrayOfInt, 0, 0, paramInt);
          }
          if (paramInt < i) {
            kotlin.a.k.a((int[])localObject, arrayOfInt, paramInt, paramInt + 1, i + 1);
          }
          localObject = new j(this.asD, this.asE, this.asF, arrayOfInt);
          AppMethodBeat.o(202580);
          return localObject;
        }
      }
    }
    AppMethodBeat.o(202580);
    return this;
  }
  
  public final j f(j paramj)
  {
    AppMethodBeat.i(202596);
    s.u(paramj, "bits");
    if (paramj == asH)
    {
      AppMethodBeat.o(202596);
      return this;
    }
    if (this == asH)
    {
      paramj = asH;
      AppMethodBeat.o(202596);
      return paramj;
    }
    if ((paramj.asF == this.asF) && (paramj.asG == this.asG))
    {
      paramj = new j(this.asD & (paramj.asD ^ 0xFFFFFFFF), this.asE & (paramj.asE ^ 0xFFFFFFFF), this.asF, this.asG);
      AppMethodBeat.o(202596);
      return paramj;
    }
    Iterator localIterator = ((Iterable)paramj).iterator();
    int i;
    for (paramj = this; localIterator.hasNext(); paramj = ((j)paramj).ct(i)) {
      i = ((Number)localIterator.next()).intValue();
    }
    paramj = (j)paramj;
    AppMethodBeat.o(202596);
    return paramj;
  }
  
  public final j g(j paramj)
  {
    AppMethodBeat.i(202606);
    s.u(paramj, "bits");
    if (paramj == asH)
    {
      AppMethodBeat.o(202606);
      return this;
    }
    if (this == asH)
    {
      AppMethodBeat.o(202606);
      return paramj;
    }
    if ((paramj.asF == this.asF) && (paramj.asG == this.asG))
    {
      paramj = new j(this.asD | paramj.asD, this.asE | paramj.asE, this.asF, this.asG);
      AppMethodBeat.o(202606);
      return paramj;
    }
    if (this.asG == null)
    {
      localIterator = ((Iterable)this).iterator();
      while (localIterator.hasNext()) {
        paramj = paramj.cs(((Number)localIterator.next()).intValue());
      }
      AppMethodBeat.o(202606);
      return paramj;
    }
    Iterator localIterator = ((Iterable)paramj).iterator();
    int i;
    for (paramj = this; localIterator.hasNext(); paramj = ((j)paramj).cs(i)) {
      i = ((Number)localIterator.next()).intValue();
    }
    paramj = (j)paramj;
    AppMethodBeat.o(202606);
    return paramj;
  }
  
  public final Iterator<Integer> iterator()
  {
    AppMethodBeat.i(202619);
    Iterator localIterator = kotlin.m.k.w((m)new b(this, null)).iterator();
    AppMethodBeat.o(202619);
    return localIterator;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(202633);
    Object localObject1 = new StringBuilder().append(super.toString()).append(" [");
    Object localObject3 = (Iterable)this;
    Object localObject2 = (Collection)new ArrayList(p.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((Collection)localObject2).add(String.valueOf(((Number)((Iterator)localObject3).next()).intValue()));
    }
    localObject2 = (List)localObject2;
    localObject3 = (CharSequence)", ";
    CharSequence localCharSequence1 = (CharSequence)"";
    CharSequence localCharSequence2 = (CharSequence)"";
    CharSequence localCharSequence3 = (CharSequence)"...";
    s.u(localObject2, "<this>");
    s.u(localObject3, "separator");
    s.u(localCharSequence1, "prefix");
    s.u(localCharSequence2, "postfix");
    s.u(localCharSequence3, "truncated");
    localObject2 = ((StringBuilder)b.a((List)localObject2, (Appendable)new StringBuilder(), (CharSequence)localObject3, localCharSequence1, localCharSequence2)).toString();
    s.s(localObject2, "fastJoinTo(StringBuilder…form)\n        .toString()");
    localObject1 = (String)localObject2 + ']';
    AppMethodBeat.o(202633);
    return localObject1;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.j
    implements m<kotlin.m.j<? super Integer>, d<? super ah>, Object>
  {
    Object Uf;
    int aai;
    int asI;
    int label;
    
    b(j paramj, d<? super b> paramd)
    {
      super();
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(202677);
      paramd = new b(this.asJ, paramd);
      paramd.L$0 = paramObject;
      paramObject = (d)paramd;
      AppMethodBeat.o(202677);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(202667);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      Object localObject1;
      Object localObject2;
      int j;
      int i;
      int k;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(202667);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        localObject1 = (kotlin.m.j)this.L$0;
        localObject2 = j.h(this.asJ);
        paramObject = localObject1;
        if (localObject2 != null)
        {
          j = 0;
          i = localObject2.length;
          paramObject = localObject1;
          localObject1 = localObject2;
          if (j < i)
          {
            k = localObject1[j];
            j += 1;
            localObject2 = (d)this;
            this.L$0 = paramObject;
            this.Uf = localObject1;
            this.aai = j;
            this.asI = i;
            this.label = 1;
            if (paramObject.d(Integer.valueOf(k), (d)localObject2) != locala) {
              break label496;
            }
            AppMethodBeat.o(202667);
            return locala;
          }
        }
        break;
      case 1: 
        i = this.asI;
        j = this.aai;
        localObject1 = (int[])this.Uf;
        localObject2 = (kotlin.m.j)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        paramObject = localObject2;
      }
      label483:
      label491:
      label496:
      for (;;)
      {
        break;
        localObject1 = paramObject;
        if (j.i(this.asJ) != 0L)
        {
          i = 0;
          j = i + 1;
          if ((j.i(this.asJ) & 1L << i) == 0L) {
            break label491;
          }
          k = j.j(this.asJ);
          localObject1 = (d)this;
          this.L$0 = paramObject;
          this.Uf = null;
          this.aai = j;
          this.label = 2;
          if (paramObject.d(Integer.valueOf(k + i), (d)localObject1) != locala) {
            break label491;
          }
          AppMethodBeat.o(202667);
          return locala;
          i = this.aai;
          localObject1 = (kotlin.m.j)this.L$0;
          ResultKt.throwOnFailure(paramObject);
          paramObject = localObject1;
        }
        for (;;)
        {
          if (i >= 64)
          {
            localObject1 = paramObject;
            if (j.k(this.asJ) != 0L)
            {
              i = 0;
              paramObject = localObject1;
              j = i + 1;
              if ((j.k(this.asJ) & 1L << i) == 0L) {
                break label483;
              }
              k = j.j(this.asJ);
              localObject1 = (d)this;
              this.L$0 = paramObject;
              this.Uf = null;
              this.aai = j;
              this.label = 3;
              if (paramObject.d(Integer.valueOf(i + 64 + k), (d)localObject1) != locala) {
                break label483;
              }
              AppMethodBeat.o(202667);
              return locala;
              i = this.aai;
              localObject1 = (kotlin.m.j)this.L$0;
              ResultKt.throwOnFailure(paramObject);
              paramObject = localObject1;
            }
            for (;;)
            {
              if (i >= 64)
              {
                paramObject = ah.aiuX;
                AppMethodBeat.o(202667);
                return paramObject;
              }
              break;
              i = j;
            }
          }
          break;
          i = j;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.f.j
 * JD-Core Version:    0.7.0.1
 */
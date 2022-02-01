package androidx.compose.runtime.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/collection/IdentityScopeMap;", "T", "", "()V", "scopeSets", "", "Landroidx/compose/runtime/collection/IdentityArraySet;", "getScopeSets$annotations", "getScopeSets", "()[Landroidx/compose/runtime/collection/IdentityArraySet;", "setScopeSets", "([Landroidx/compose/runtime/collection/IdentityArraySet;)V", "[Landroidx/compose/runtime/collection/IdentityArraySet;", "size", "", "getSize$annotations", "getSize", "()I", "setSize", "(I)V", "valueOrder", "", "getValueOrder$annotations", "getValueOrder", "()[I", "setValueOrder", "([I)V", "values", "getValues$annotations", "getValues", "()[Ljava/lang/Object;", "setValues", "([Ljava/lang/Object;)V", "[Ljava/lang/Object;", "add", "", "value", "scope", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "clear", "", "contains", "element", "find", "findExactIndex", "midIndex", "valueHash", "forEachScopeOf", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "getOrCreateIdentitySet", "remove", "removeValueIf", "predicate", "scopeSetAt", "index", "valueAt", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d<T>
{
  public Object[] aqm;
  public int[] aqo;
  public c<T>[] aqp;
  public int size;
  
  public d()
  {
    AppMethodBeat.i(202053);
    int i = 0;
    int[] arrayOfInt = new int[50];
    while (i < 50)
    {
      arrayOfInt[i] = i;
      i += 1;
    }
    this.aqo = arrayOfInt;
    this.aqm = new Object[50];
    this.aqp = new c[50];
    AppMethodBeat.o(202053);
  }
  
  private final c<T> W(Object paramObject)
  {
    AppMethodBeat.i(202066);
    int j;
    if (this.size > 0)
    {
      j = V(paramObject);
      i = j;
      if (j >= 0)
      {
        paramObject = cb(j);
        AppMethodBeat.o(202066);
        return paramObject;
      }
    }
    else
    {
      i = -1;
    }
    int k = -(i + 1);
    if (this.size < this.aqo.length)
    {
      i = this.aqo[this.size];
      this.aqm[i] = paramObject;
      localObject = this.aqp[i];
      paramObject = localObject;
      if (localObject == null)
      {
        paramObject = new c();
        this.aqp[i] = paramObject;
      }
      if (k < this.size) {
        k.a(this.aqo, this.aqo, k + 1, k, this.size);
      }
      this.aqo[k] = i;
      this.size += 1;
      AppMethodBeat.o(202066);
      return paramObject;
    }
    int m = this.aqo.length * 2;
    int n = this.size;
    Object localObject = Arrays.copyOf(this.aqp, m);
    s.s(localObject, "java.util.Arrays.copyOf(this, newSize)");
    this.aqp = ((c[])localObject);
    localObject = new c();
    this.aqp[n] = localObject;
    Object[] arrayOfObject = Arrays.copyOf(this.aqm, m);
    s.s(arrayOfObject, "java.util.Arrays.copyOf(this, newSize)");
    this.aqm = arrayOfObject;
    this.aqm[n] = paramObject;
    paramObject = new int[m];
    int i = this.size + 1;
    if (i < m) {}
    for (;;)
    {
      j = i + 1;
      paramObject[i] = i;
      if (j >= m)
      {
        if (k < this.size) {
          k.a(this.aqo, paramObject, k + 1, k, this.size);
        }
        paramObject[k] = n;
        if (k > 0) {
          k.a(this.aqo, paramObject, k);
        }
        this.aqo = paramObject;
        this.size += 1;
        AppMethodBeat.o(202066);
        return localObject;
      }
      i = j;
    }
  }
  
  private final int a(int paramInt1, Object paramObject, int paramInt2)
  {
    AppMethodBeat.i(202077);
    int i = paramInt1 - 1;
    if (i >= 0) {}
    for (;;)
    {
      int j = i - 1;
      Object localObject = this.aqm[this.aqo[i]];
      s.checkNotNull(localObject);
      if (localObject == paramObject)
      {
        AppMethodBeat.o(202077);
        return i;
      }
      if ((System.identityHashCode(localObject) != paramInt2) || (j < 0))
      {
        paramInt1 += 1;
        j = this.size;
        if (paramInt1 < j) {}
        for (;;)
        {
          i = paramInt1 + 1;
          localObject = this.aqm[this.aqo[paramInt1]];
          s.checkNotNull(localObject);
          if (localObject == paramObject)
          {
            AppMethodBeat.o(202077);
            return paramInt1;
          }
          if (System.identityHashCode(localObject) != paramInt2)
          {
            paramInt1 = -(paramInt1 + 1);
            AppMethodBeat.o(202077);
            return paramInt1;
          }
          if (i >= j)
          {
            paramInt1 = -(this.size + 1);
            AppMethodBeat.o(202077);
            return paramInt1;
          }
          paramInt1 = i;
        }
      }
      i = j;
    }
  }
  
  public final int V(Object paramObject)
  {
    AppMethodBeat.i(202124);
    int k = System.identityHashCode(paramObject);
    int i = 0;
    int j = this.size - 1;
    while (i <= j)
    {
      int m = i + j >>> 1;
      Object localObject = this.aqm[this.aqo[m]];
      s.checkNotNull(localObject);
      int n = System.identityHashCode(localObject) - k;
      if (n < 0)
      {
        i = m + 1;
      }
      else if (n > 0)
      {
        j = m - 1;
      }
      else
      {
        if (paramObject == localObject)
        {
          AppMethodBeat.o(202124);
          return m;
        }
        i = a(m, paramObject, k);
        AppMethodBeat.o(202124);
        return i;
      }
    }
    i = -(i + 1);
    AppMethodBeat.o(202124);
    return i;
  }
  
  public final c<T> cb(int paramInt)
  {
    AppMethodBeat.i(202085);
    c localc = this.aqp[this.aqo[paramInt]];
    s.checkNotNull(localc);
    AppMethodBeat.o(202085);
    return localc;
  }
  
  public final boolean contains(Object paramObject)
  {
    AppMethodBeat.i(202103);
    s.u(paramObject, "element");
    if (V(paramObject) >= 0)
    {
      AppMethodBeat.o(202103);
      return true;
    }
    AppMethodBeat.o(202103);
    return false;
  }
  
  public final boolean g(Object paramObject, T paramT)
  {
    AppMethodBeat.i(202094);
    s.u(paramObject, "value");
    s.u(paramT, "scope");
    boolean bool = W(paramObject).add(paramT);
    AppMethodBeat.o(202094);
    return bool;
  }
  
  public final boolean remove(Object paramObject, T paramT)
  {
    AppMethodBeat.i(202118);
    s.u(paramObject, "value");
    s.u(paramT, "scope");
    int i = V(paramObject);
    if (i >= 0)
    {
      int j = this.aqo[i];
      paramObject = this.aqp[j];
      if (paramObject == null)
      {
        AppMethodBeat.o(202118);
        return false;
      }
      boolean bool = paramObject.remove(paramT);
      if (paramObject.size() == 0)
      {
        int k = i + 1;
        int m = this.size;
        if (k < m) {
          k.a(this.aqo, this.aqo, i, k, m);
        }
        this.aqo[(this.size - 1)] = j;
        this.aqm[j] = null;
        this.size -= 1;
      }
      AppMethodBeat.o(202118);
      return bool;
    }
    AppMethodBeat.o(202118);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.a.d
 * JD-Core Version:    0.7.0.1
 */
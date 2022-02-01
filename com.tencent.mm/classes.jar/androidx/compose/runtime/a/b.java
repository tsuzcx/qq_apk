package androidx.compose.runtime.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/collection/IdentityArrayMap;", "Key", "", "Value", "capacity", "", "(I)V", "keys", "", "getKeys$runtime_release", "()[Ljava/lang/Object;", "setKeys$runtime_release", "([Ljava/lang/Object;)V", "[Ljava/lang/Object;", "size", "getSize$runtime_release", "()I", "setSize$runtime_release", "values", "getValues$runtime_release", "setValues$runtime_release", "contains", "", "key", "(Ljava/lang/Object;)Z", "find", "findExactIndex", "midIndex", "keyHash", "forEach", "", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "value", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "isEmpty", "isNotEmpty", "remove", "removeValueIf", "Lkotlin/Function1;", "set", "(Ljava/lang/Object;Ljava/lang/Object;)V", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b<Key, Value>
{
  public Object[] aqk;
  public Object[] aqm;
  public int size;
  
  private b()
  {
    AppMethodBeat.i(202050);
    this.aqk = new Object[16];
    this.aqm = new Object[16];
    AppMethodBeat.o(202050);
  }
  
  private final int a(int paramInt1, Object paramObject, int paramInt2)
  {
    AppMethodBeat.i(202062);
    int i = paramInt1 - 1;
    if (i >= 0) {}
    for (;;)
    {
      int j = i - 1;
      Object localObject = this.aqk[i];
      if (localObject == paramObject)
      {
        AppMethodBeat.o(202062);
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
          localObject = this.aqk[paramInt1];
          if (localObject == paramObject)
          {
            AppMethodBeat.o(202062);
            return paramInt1;
          }
          if (System.identityHashCode(localObject) != paramInt2)
          {
            paramInt1 = -(paramInt1 + 1);
            AppMethodBeat.o(202062);
            return paramInt1;
          }
          if (i >= j)
          {
            paramInt1 = -(this.size + 1);
            AppMethodBeat.o(202062);
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
    AppMethodBeat.i(202096);
    int k = System.identityHashCode(paramObject);
    int i = 0;
    int j = this.size - 1;
    while (i <= j)
    {
      int m = i + j >>> 1;
      Object localObject = this.aqk[m];
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
          AppMethodBeat.o(202096);
          return m;
        }
        i = a(m, paramObject, k);
        AppMethodBeat.o(202096);
        return i;
      }
    }
    i = -(i + 1);
    AppMethodBeat.o(202096);
    return i;
  }
  
  public final Value get(Key paramKey)
  {
    AppMethodBeat.i(202074);
    s.u(paramKey, "key");
    int i = V(paramKey);
    if (i >= 0)
    {
      paramKey = this.aqm[i];
      AppMethodBeat.o(202074);
      return paramKey;
    }
    AppMethodBeat.o(202074);
    return null;
  }
  
  public final void set(Key paramKey, Value paramValue)
  {
    AppMethodBeat.i(202087);
    s.u(paramKey, "key");
    int i = V(paramKey);
    if (i >= 0)
    {
      this.aqm[i] = paramValue;
      AppMethodBeat.o(202087);
      return;
    }
    int j = -(i + 1);
    Object[] arrayOfObject;
    if (this.size == this.aqk.length)
    {
      i = 1;
      if (i == 0) {
        break label204;
      }
      arrayOfObject = new Object[this.size * 2];
      label69:
      k.a(this.aqk, arrayOfObject, j + 1, j, this.size);
      if (i != 0) {
        k.a(this.aqk, arrayOfObject, 0, 0, j, 6);
      }
      arrayOfObject[j] = paramKey;
      this.aqk = arrayOfObject;
      if (i == 0) {
        break label213;
      }
    }
    label204:
    label213:
    for (paramKey = new Object[this.size * 2];; paramKey = this.aqm)
    {
      k.a(this.aqm, paramKey, j + 1, j, this.size);
      if (i != 0) {
        k.a(this.aqm, paramKey, 0, 0, j, 6);
      }
      paramKey[j] = paramValue;
      this.aqm = paramKey;
      this.size += 1;
      AppMethodBeat.o(202087);
      return;
      i = 0;
      break;
      arrayOfObject = this.aqk;
      break label69;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.a.b
 * JD-Core Version:    0.7.0.1
 */
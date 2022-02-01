package androidx.compose.runtime.b.a.a.a.a.a;

import androidx.compose.runtime.b.a.a.a.b.c;
import androidx.compose.runtime.b.a.a.a.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/PersistentVector;", "E", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/AbstractPersistentList;", "root", "", "", "tail", "size", "", "rootShift", "([Ljava/lang/Object;[Ljava/lang/Object;II)V", "[Ljava/lang/Object;", "getSize", "()I", "add", "element", "(Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "index", "(ILjava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "bufferFor", "(I)[Ljava/lang/Object;", "builder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/PersistentVectorBuilder;", "get", "(I)Ljava/lang/Object;", "insertIntoRoot", "shift", "elementCarry", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;", "([Ljava/lang/Object;IILjava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;)[Ljava/lang/Object;", "insertIntoTail", "tailIndex", "([Ljava/lang/Object;ILjava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/PersistentVector;", "listIterator", "", "pullLastBuffer", "tailCarry", "([Ljava/lang/Object;IILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;)[Ljava/lang/Object;", "pullLastBufferFromRoot", "rootSize", "([Ljava/lang/Object;II)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "pushFilledTail", "filledTail", "newTail", "([Ljava/lang/Object;[Ljava/lang/Object;[Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/PersistentVector;", "pushTail", "([Ljava/lang/Object;I[Ljava/lang/Object;)[Ljava/lang/Object;", "removeAll", "predicate", "Lkotlin/Function1;", "", "removeAt", "removeFromRootAt", "removeFromTailAt", "([Ljava/lang/Object;III)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "set", "setInRoot", "e", "([Ljava/lang/Object;IILjava/lang/Object;)[Ljava/lang/Object;", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e<E>
  extends b<E>
{
  private final Object[] aqw;
  private final Object[] aqx;
  private final int aqy;
  private final int size;
  
  public e(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(202911);
    this.aqw = paramArrayOfObject1;
    this.aqx = paramArrayOfObject2;
    this.size = paramInt1;
    this.aqy = paramInt2;
    if (size() > 32) {}
    for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
    {
      paramArrayOfObject1 = (Throwable)new IllegalArgumentException(s.X("Trie-based persistent vector should have at least 33 elements, got ", Integer.valueOf(size())).toString());
      AppMethodBeat.o(202911);
      throw paramArrayOfObject1;
    }
    size();
    size();
    AppMethodBeat.o(202911);
  }
  
  private final e<E> a(Object[] paramArrayOfObject, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(202955);
    int i = size() - qx();
    Object[] arrayOfObject = Arrays.copyOf(this.aqx, 32);
    s.s(arrayOfObject, "java.util.Arrays.copyOf(this, newSize)");
    if (i < 32)
    {
      k.a(this.aqx, arrayOfObject, paramInt + 1, paramInt, i);
      arrayOfObject[paramInt] = paramObject;
      paramArrayOfObject = new e(paramArrayOfObject, arrayOfObject, size() + 1, this.aqy);
      AppMethodBeat.o(202955);
      return paramArrayOfObject;
    }
    Object localObject = this.aqx[31];
    k.a(this.aqx, arrayOfObject, paramInt + 1, paramInt, i - 1);
    arrayOfObject[paramInt] = paramObject;
    paramArrayOfObject = a(paramArrayOfObject, arrayOfObject, l.ac(localObject));
    AppMethodBeat.o(202955);
    return paramArrayOfObject;
  }
  
  private final e<E> a(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2, Object[] paramArrayOfObject3)
  {
    AppMethodBeat.i(202929);
    if (size() >> 5 > 1 << this.aqy)
    {
      paramArrayOfObject1 = l.ac(paramArrayOfObject1);
      int i = this.aqy + 5;
      paramArrayOfObject1 = new e(a(paramArrayOfObject1, i, paramArrayOfObject2), paramArrayOfObject3, size() + 1, i);
      AppMethodBeat.o(202929);
      return paramArrayOfObject1;
    }
    paramArrayOfObject1 = new e(a(paramArrayOfObject1, this.aqy, paramArrayOfObject2), paramArrayOfObject3, size() + 1, this.aqy);
    AppMethodBeat.o(202929);
    return paramArrayOfObject1;
  }
  
  private final h<E> a(Object[] paramArrayOfObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(202996);
    if (paramInt2 == 0)
    {
      localObject = paramArrayOfObject;
      if (paramArrayOfObject.length == 33)
      {
        localObject = Arrays.copyOf(paramArrayOfObject, 32);
        s.s(localObject, "java.util.Arrays.copyOf(this, newSize)");
      }
      paramArrayOfObject = (h)new j((Object[])localObject);
      AppMethodBeat.o(202996);
      return paramArrayOfObject;
    }
    Object localObject = new d(null);
    paramArrayOfObject = a(paramArrayOfObject, paramInt2, paramInt1 - 1, (d)localObject);
    s.checkNotNull(paramArrayOfObject);
    localObject = ((d)localObject).value;
    if (localObject == null)
    {
      paramArrayOfObject = new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
      AppMethodBeat.o(202996);
      throw paramArrayOfObject;
    }
    localObject = (Object[])localObject;
    if (paramArrayOfObject[1] == null)
    {
      paramArrayOfObject = paramArrayOfObject[0];
      if (paramArrayOfObject == null)
      {
        paramArrayOfObject = new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        AppMethodBeat.o(202996);
        throw paramArrayOfObject;
      }
      paramArrayOfObject = (h)new e((Object[])paramArrayOfObject, (Object[])localObject, paramInt1, paramInt2 - 5);
      AppMethodBeat.o(202996);
      return paramArrayOfObject;
    }
    paramArrayOfObject = (h)new e(paramArrayOfObject, (Object[])localObject, paramInt1, paramInt2);
    AppMethodBeat.o(202996);
    return paramArrayOfObject;
  }
  
  private final h<E> a(Object[] paramArrayOfObject, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(202983);
    int i = size() - paramInt1;
    if (i == 1)
    {
      paramArrayOfObject = a(paramArrayOfObject, paramInt1, paramInt2);
      AppMethodBeat.o(202983);
      return paramArrayOfObject;
    }
    Object[] arrayOfObject = Arrays.copyOf(this.aqx, 32);
    s.s(arrayOfObject, "java.util.Arrays.copyOf(this, newSize)");
    if (paramInt3 < i - 1) {
      k.a(this.aqx, arrayOfObject, paramInt3, paramInt3 + 1, i);
    }
    arrayOfObject[(i - 1)] = null;
    paramArrayOfObject = (h)new e(paramArrayOfObject, arrayOfObject, i + paramInt1 - 1, paramInt2);
    AppMethodBeat.o(202983);
    return paramArrayOfObject;
  }
  
  private final Object[] a(Object[] paramArrayOfObject, int paramInt1, int paramInt2, d paramd)
  {
    AppMethodBeat.i(203006);
    int i = paramInt2 >> paramInt1 & 0x1F;
    if (paramInt1 == 5) {
      paramd.value = paramArrayOfObject[i];
    }
    Object localObject;
    for (paramd = null; (paramd == null) && (i == 0); paramd = a((Object[])localObject, paramInt1 - 5, paramInt2, paramd))
    {
      AppMethodBeat.o(203006);
      return null;
      localObject = paramArrayOfObject[i];
      if (localObject == null)
      {
        paramArrayOfObject = new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        AppMethodBeat.o(203006);
        throw paramArrayOfObject;
      }
    }
    paramArrayOfObject = Arrays.copyOf(paramArrayOfObject, 32);
    s.s(paramArrayOfObject, "java.util.Arrays.copyOf(this, newSize)");
    paramArrayOfObject[i] = paramd;
    AppMethodBeat.o(203006);
    return paramArrayOfObject;
  }
  
  private final Object[] a(Object[] paramArrayOfObject, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(203030);
    int i = paramInt2 >> paramInt1 & 0x1F;
    paramArrayOfObject = Arrays.copyOf(paramArrayOfObject, 32);
    s.s(paramArrayOfObject, "java.util.Arrays.copyOf(this, newSize)");
    if (paramInt1 == 0) {
      paramArrayOfObject[i] = paramObject;
    }
    for (;;)
    {
      AppMethodBeat.o(203030);
      return paramArrayOfObject;
      Object localObject = paramArrayOfObject[i];
      if (localObject == null)
      {
        paramArrayOfObject = new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        AppMethodBeat.o(203030);
        throw paramArrayOfObject;
      }
      paramArrayOfObject[i] = a((Object[])localObject, paramInt1 - 5, paramInt2, paramObject);
    }
  }
  
  private final Object[] a(Object[] paramArrayOfObject, int paramInt1, int paramInt2, Object paramObject, d paramd)
  {
    AppMethodBeat.i(202969);
    int j = paramInt2 >> paramInt1 & 0x1F;
    if (paramInt1 == 0)
    {
      if (j == 0) {
        arrayOfObject = new Object[32];
      }
      for (;;)
      {
        k.a(paramArrayOfObject, arrayOfObject, j + 1, j, 31);
        paramd.value = paramArrayOfObject[31];
        arrayOfObject[j] = paramObject;
        AppMethodBeat.o(202969);
        return arrayOfObject;
        arrayOfObject = Arrays.copyOf(paramArrayOfObject, 32);
        s.s(arrayOfObject, "java.util.Arrays.copyOf(this, newSize)");
      }
    }
    Object[] arrayOfObject = Arrays.copyOf(paramArrayOfObject, 32);
    s.s(arrayOfObject, "java.util.Arrays.copyOf(this, newSize)");
    int i = paramInt1 - 5;
    Object localObject = paramArrayOfObject[j];
    if (localObject == null)
    {
      paramArrayOfObject = new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
      AppMethodBeat.o(202969);
      throw paramArrayOfObject;
    }
    arrayOfObject[j] = a((Object[])localObject, i, paramInt2, paramObject, paramd);
    paramInt1 = j + 1;
    if (paramInt1 < 32) {}
    for (;;)
    {
      paramInt2 = paramInt1 + 1;
      if (arrayOfObject[paramInt1] != null)
      {
        paramObject = paramArrayOfObject[paramInt1];
        if (paramObject == null)
        {
          paramArrayOfObject = new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
          AppMethodBeat.o(202969);
          throw paramArrayOfObject;
        }
        arrayOfObject[paramInt1] = a((Object[])paramObject, i, 0, paramd.value, paramd);
        if (paramInt2 < 32) {}
      }
      else
      {
        AppMethodBeat.o(202969);
        return arrayOfObject;
      }
      paramInt1 = paramInt2;
    }
  }
  
  private final Object[] a(Object[] paramArrayOfObject1, int paramInt, Object[] paramArrayOfObject2)
  {
    AppMethodBeat.i(202939);
    int i = size() - 1 >> paramInt & 0x1F;
    if (paramArrayOfObject1 == null)
    {
      paramArrayOfObject1 = null;
      if (paramArrayOfObject1 != null) {
        break label67;
      }
      paramArrayOfObject1 = new Object[32];
      label34:
      if (paramInt != 5) {
        break label70;
      }
      paramArrayOfObject1[i] = paramArrayOfObject2;
    }
    for (;;)
    {
      AppMethodBeat.o(202939);
      return paramArrayOfObject1;
      paramArrayOfObject1 = Arrays.copyOf(paramArrayOfObject1, 32);
      s.s(paramArrayOfObject1, "java.util.Arrays.copyOf(this, newSize)");
      break;
      label67:
      break label34;
      label70:
      paramArrayOfObject1[i] = a((Object[])paramArrayOfObject1[i], paramInt - 5, paramArrayOfObject2);
    }
  }
  
  private final Object[] b(Object[] paramArrayOfObject, int paramInt1, int paramInt2, d paramd)
  {
    AppMethodBeat.i(203018);
    int j = paramInt2 >> paramInt1 & 0x1F;
    Object localObject;
    if (paramInt1 == 0)
    {
      if (j == 0) {
        localObject = new Object[32];
      }
      for (;;)
      {
        k.a(paramArrayOfObject, (Object[])localObject, j, j + 1, 32);
        localObject[31] = paramd.value;
        paramd.value = paramArrayOfObject[j];
        AppMethodBeat.o(203018);
        return localObject;
        localObject = Arrays.copyOf(paramArrayOfObject, 32);
        s.s(localObject, "java.util.Arrays.copyOf(this, newSize)");
      }
    }
    if (paramArrayOfObject[31] == null) {}
    for (int i = qx() - 1 >> paramInt1 & 0x1F;; i = 31)
    {
      paramArrayOfObject = Arrays.copyOf(paramArrayOfObject, 32);
      s.s(paramArrayOfObject, "java.util.Arrays.copyOf(this, newSize)");
      paramInt1 -= 5;
      int k = j + 1;
      if (k <= i) {}
      for (;;)
      {
        localObject = paramArrayOfObject[i];
        if (localObject == null)
        {
          paramArrayOfObject = new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
          AppMethodBeat.o(203018);
          throw paramArrayOfObject;
        }
        paramArrayOfObject[i] = b((Object[])localObject, paramInt1, 0, paramd);
        if (i == k)
        {
          localObject = paramArrayOfObject[j];
          if (localObject == null)
          {
            paramArrayOfObject = new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            AppMethodBeat.o(203018);
            throw paramArrayOfObject;
          }
          paramArrayOfObject[j] = b((Object[])localObject, paramInt1, paramInt2, paramd);
          AppMethodBeat.o(203018);
          return paramArrayOfObject;
        }
        i -= 1;
      }
    }
  }
  
  private final int qx()
  {
    AppMethodBeat.i(202920);
    int i = size();
    AppMethodBeat.o(202920);
    return i - 1 & 0xFFFFFFE0;
  }
  
  private f<E> qy()
  {
    AppMethodBeat.i(203024);
    f localf = new f((h)this, this.aqw, this.aqx, this.aqy);
    AppMethodBeat.o(203024);
    return localf;
  }
  
  public final h<E> X(E paramE)
  {
    AppMethodBeat.i(203049);
    int i = size() - qx();
    if (i < 32)
    {
      Object[] arrayOfObject = Arrays.copyOf(this.aqx, 32);
      s.s(arrayOfObject, "java.util.Arrays.copyOf(this, newSize)");
      arrayOfObject[i] = paramE;
      paramE = (h)new e(this.aqw, arrayOfObject, size() + 1, this.aqy);
      AppMethodBeat.o(203049);
      return paramE;
    }
    paramE = l.ac(paramE);
    paramE = (h)a(this.aqw, this.aqx, paramE);
    AppMethodBeat.o(203049);
    return paramE;
  }
  
  public final h<E> cc(int paramInt)
  {
    AppMethodBeat.i(203072);
    c.U(paramInt, size());
    int i = qx();
    if (paramInt >= i)
    {
      localh = a(this.aqw, i, this.aqy, paramInt - i);
      AppMethodBeat.o(203072);
      return localh;
    }
    h localh = a(b(this.aqw, this.aqy, paramInt, new d(this.aqx[0])), i, this.aqy, 0);
    AppMethodBeat.o(203072);
    return localh;
  }
  
  public final h<E> e(kotlin.g.a.b<? super E, Boolean> paramb)
  {
    AppMethodBeat.i(203085);
    s.u(paramb, "predicate");
    f localf = qy();
    localf.f(paramb);
    paramb = localf.qs();
    AppMethodBeat.o(203085);
    return paramb;
  }
  
  public final E get(int paramInt)
  {
    AppMethodBeat.i(203110);
    c.U(paramInt, size());
    Object localObject2;
    if (qx() <= paramInt)
    {
      localObject2 = this.aqx;
      localObject1 = localObject2[(paramInt & 0x1F)];
      AppMethodBeat.o(203110);
      return localObject1;
    }
    Object localObject1 = this.aqw;
    int i = this.aqy;
    for (;;)
    {
      localObject2 = localObject1;
      if (i <= 0) {
        break;
      }
      localObject1 = localObject1[(paramInt >> i & 0x1F)];
      if (localObject1 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        AppMethodBeat.o(203110);
        throw ((Throwable)localObject1);
      }
      localObject1 = (Object[])localObject1;
      i -= 5;
    }
  }
  
  public final int getSize()
  {
    return this.size;
  }
  
  public final ListIterator<E> listIterator(int paramInt)
  {
    AppMethodBeat.i(203095);
    c.V(paramInt, size());
    ListIterator localListIterator = (ListIterator)new g(this.aqw, this.aqx, paramInt, size(), this.aqy / 5 + 1);
    AppMethodBeat.o(203095);
    return localListIterator;
  }
  
  public final h<E> m(int paramInt, E paramE)
  {
    AppMethodBeat.i(203121);
    c.U(paramInt, size());
    if (qx() <= paramInt)
    {
      Object[] arrayOfObject = Arrays.copyOf(this.aqx, 32);
      s.s(arrayOfObject, "java.util.Arrays.copyOf(this, newSize)");
      arrayOfObject[(paramInt & 0x1F)] = paramE;
      paramE = (h)new e(this.aqw, arrayOfObject, size(), this.aqy);
      AppMethodBeat.o(203121);
      return paramE;
    }
    paramE = (h)new e(a(this.aqw, this.aqy, paramInt, paramE), this.aqx, size(), this.aqy);
    AppMethodBeat.o(203121);
    return paramE;
  }
  
  public final h<E> n(int paramInt, E paramE)
  {
    AppMethodBeat.i(203060);
    c.V(paramInt, size());
    if (paramInt == size())
    {
      paramE = X(paramE);
      AppMethodBeat.o(203060);
      return paramE;
    }
    int i = qx();
    if (paramInt >= i)
    {
      paramE = (h)a(this.aqw, paramInt - i, paramE);
      AppMethodBeat.o(203060);
      return paramE;
    }
    d locald = new d(null);
    paramE = (h)a(a(this.aqw, this.aqy, paramInt, paramE, locald), 0, locald.value);
    AppMethodBeat.o(203060);
    return paramE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.b.a.a.a.a.a.e
 * JD-Core Version:    0.7.0.1
 */
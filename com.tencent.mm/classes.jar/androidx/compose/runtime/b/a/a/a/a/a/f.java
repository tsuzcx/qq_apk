package androidx.compose.runtime.b.a.a.a.a.a;

import androidx.compose.runtime.b.a.a.a.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/PersistentVectorBuilder;", "E", "Lkotlin/collections/AbstractMutableList;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList$Builder;", "vector", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "vectorRoot", "", "", "vectorTail", "rootShift", "", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;[Ljava/lang/Object;[Ljava/lang/Object;I)V", "ownership", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;", "<set-?>", "root", "getRoot$runtime_release", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "getRootShift$runtime_release", "()I", "setRootShift$runtime_release", "(I)V", "size", "getSize", "tail", "getTail$runtime_release", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "bufferFor", "(I)[Ljava/lang/Object;", "build", "copyToBuffer", "buffer", "bufferIndex", "sourceIterator", "", "([Ljava/lang/Object;ILjava/util/Iterator;)[Ljava/lang/Object;", "get", "(I)Ljava/lang/Object;", "getModCount", "getModCount$runtime_release", "insertIntoRoot", "shift", "elementCarry", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;", "([Ljava/lang/Object;IILjava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;)[Ljava/lang/Object;", "rightShift", "buffers", "nullBuffers", "nextBuffer", "(Ljava/util/Collection;II[[Ljava/lang/Object;I[Ljava/lang/Object;)V", "insertIntoTail", "([Ljava/lang/Object;ILjava/lang/Object;)V", "isMutable", "([Ljava/lang/Object;)Z", "iterator", "", "leafBufferIterator", "", "listIterator", "", "makeMutable", "([Ljava/lang/Object;)[Ljava/lang/Object;", "makeMutableShiftingRight", "distance", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "mutableBuffer", "mutableBufferWith", "(Ljava/lang/Object;)[Ljava/lang/Object;", "nullifyAfter", "([Ljava/lang/Object;II)[Ljava/lang/Object;", "pullLastBuffer", "rootSize", "tailCarry", "([Ljava/lang/Object;IILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;)[Ljava/lang/Object;", "pullLastBufferFromRoot", "([Ljava/lang/Object;II)V", "pushBuffers", "buffersIterator", "([Ljava/lang/Object;IILjava/util/Iterator;)[Ljava/lang/Object;", "pushBuffersIncreasingHeightIfNeeded", "([Ljava/lang/Object;I[[Ljava/lang/Object;)[Ljava/lang/Object;", "pushFilledTail", "filledTail", "newTail", "([Ljava/lang/Object;[Ljava/lang/Object;[Ljava/lang/Object;)V", "pushTail", "([Ljava/lang/Object;[Ljava/lang/Object;I)[Ljava/lang/Object;", "recyclableRemoveAll", "predicate", "Lkotlin/Function1;", "bufferSize", "toBufferSize", "bufferRef", "recyclableBuffers", "", "(Lkotlin/jvm/functions/Function1;[Ljava/lang/Object;IILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;Ljava/util/List;Ljava/util/List;)I", "removeAll", "(Lkotlin/jvm/functions/Function1;[Ljava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;)I", "removeAllFromTail", "tailSize", "removeAllWithPredicate", "removeAt", "removeFromRootAt", "removeFromTailAt", "([Ljava/lang/Object;III)Ljava/lang/Object;", "retainFirst", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "setInRoot", "e", "oldElementCarry", "shiftLeafBuffers", "startLeafIndex", "(II[[Ljava/lang/Object;I[Ljava/lang/Object;)[Ljava/lang/Object;", "splitToBuffers", "startBuffer", "startBufferSize", "(Ljava/util/Collection;I[Ljava/lang/Object;I[[Ljava/lang/Object;I[Ljava/lang/Object;)V", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f<E>
  extends kotlin.a.e<E>
  implements h.a<E>
{
  private Object[] aqA;
  private Object[] aqB;
  private androidx.compose.runtime.b.a.a.a.b.d aqC;
  Object[] aqw;
  Object[] aqx;
  int aqy;
  private androidx.compose.runtime.b.a.a.a.h<? extends E> aqz;
  private int size;
  
  public f(androidx.compose.runtime.b.a.a.a.h<? extends E> paramh, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2, int paramInt)
  {
    AppMethodBeat.i(202917);
    this.aqz = paramh;
    this.aqA = paramArrayOfObject1;
    this.aqB = paramArrayOfObject2;
    this.aqy = paramInt;
    this.aqC = new androidx.compose.runtime.b.a.a.a.b.d();
    this.aqw = this.aqA;
    this.aqx = this.aqB;
    this.size = this.aqz.size();
    AppMethodBeat.o(202917);
  }
  
  private final int a(b<? super E, Boolean> paramb, int paramInt, d paramd)
  {
    AppMethodBeat.i(203115);
    int i = a(paramb, this.aqx, paramInt, paramd);
    if (i == paramInt)
    {
      AppMethodBeat.o(203115);
      return paramInt;
    }
    paramb = paramd.value;
    if (paramb == null)
    {
      paramb = new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
      AppMethodBeat.o(203115);
      throw paramb;
    }
    paramb = (Object[])paramb;
    kotlin.a.k.a(paramb, null, i, paramInt);
    this.aqx = paramb;
    this.size = (size() - (paramInt - i));
    AppMethodBeat.o(203115);
    return i;
  }
  
  private final int a(b<? super E, Boolean> paramb, Object[] paramArrayOfObject, int paramInt1, int paramInt2, d paramd, List<Object[]> paramList1, List<Object[]> paramList2)
  {
    AppMethodBeat.i(203136);
    if (d(paramArrayOfObject)) {
      paramList1.add(paramArrayOfObject);
    }
    Object localObject1 = paramd.value;
    if (localObject1 == null)
    {
      paramb = new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
      AppMethodBeat.o(203136);
      throw paramb;
    }
    Object[] arrayOfObject = (Object[])localObject1;
    int j;
    int k;
    Object localObject2;
    int i;
    if (paramInt1 > 0)
    {
      j = 0;
      localObject1 = arrayOfObject;
      k = j + 1;
      Object localObject3 = paramArrayOfObject[j];
      localObject2 = localObject1;
      i = paramInt2;
      if (!((Boolean)paramb.invoke(localObject3)).booleanValue())
      {
        if (paramInt2 != 32) {
          break label250;
        }
        if (!((Collection)paramList1).isEmpty())
        {
          paramInt2 = 1;
          label129:
          if (paramInt2 == 0) {
            break label226;
          }
          localObject1 = (Object[])paramList1.remove(paramList1.size() - 1);
          label155:
          paramInt2 = 0;
          label158:
          localObject1[paramInt2] = localObject3;
          i = paramInt2 + 1;
          localObject2 = localObject1;
        }
      }
      else
      {
        if (k < paramInt1) {
          break label235;
        }
        paramInt2 = i;
      }
    }
    for (;;)
    {
      paramd.value = localObject2;
      if (arrayOfObject != paramd.value) {
        paramList2.add(arrayOfObject);
      }
      AppMethodBeat.o(203136);
      return paramInt2;
      paramInt2 = 0;
      break label129;
      label226:
      localObject1 = qA();
      break label155;
      label235:
      j = k;
      localObject1 = localObject2;
      paramInt2 = i;
      break;
      label250:
      break label158;
      localObject2 = arrayOfObject;
    }
  }
  
  private final int a(b<? super E, Boolean> paramb, Object[] paramArrayOfObject, int paramInt, d paramd)
  {
    AppMethodBeat.i(203125);
    int k;
    int j;
    int i;
    Object[] arrayOfObject;
    int m;
    Object localObject;
    if (paramInt > 0)
    {
      k = 0;
      j = 0;
      i = paramInt;
      arrayOfObject = paramArrayOfObject;
      m = k + 1;
      localObject = paramArrayOfObject[k];
      if (((Boolean)paramb.invoke(localObject)).booleanValue())
      {
        if (j != 0) {
          break label120;
        }
        arrayOfObject = e(paramArrayOfObject);
        j = 1;
        i = k;
        label70:
        if (m < paramInt) {
          break label113;
        }
      }
    }
    for (;;)
    {
      paramd.value = arrayOfObject;
      AppMethodBeat.o(203125);
      return i;
      if (j != 0)
      {
        arrayOfObject[i] = localObject;
        i += 1;
        break label70;
        label113:
        k = m;
        break;
      }
      label120:
      break label70;
      i = paramInt;
      arrayOfObject = paramArrayOfObject;
    }
  }
  
  private final void a(Collection<? extends E> paramCollection, int paramInt1, int paramInt2, Object[][] paramArrayOfObject, int paramInt3, Object[] paramArrayOfObject1)
  {
    AppMethodBeat.i(203026);
    if (this.aqw == null)
    {
      paramCollection = (Throwable)new IllegalStateException("Required value was null.".toString());
      AppMethodBeat.o(203026);
      throw paramCollection;
    }
    int i = paramInt1 >> 5;
    Object[] arrayOfObject = a(i, paramInt2, paramArrayOfObject, paramInt3, paramArrayOfObject1);
    paramInt2 = paramInt3 - ((qx() >> 5) - 1 - i);
    if (paramInt2 < paramInt3)
    {
      paramArrayOfObject1 = paramArrayOfObject[paramInt2];
      s.checkNotNull(paramArrayOfObject1);
    }
    for (;;)
    {
      a(paramCollection, paramInt1, arrayOfObject, 32, paramArrayOfObject, paramInt2, paramArrayOfObject1);
      AppMethodBeat.o(203026);
      return;
    }
  }
  
  private final void a(Collection<? extends E> paramCollection, int paramInt1, Object[] paramArrayOfObject1, int paramInt2, Object[][] paramArrayOfObject, int paramInt3, Object[] paramArrayOfObject2)
  {
    AppMethodBeat.i(203045);
    if (paramInt3 > 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramCollection = (Throwable)new IllegalStateException("Check failed.".toString());
      AppMethodBeat.o(203045);
      throw paramCollection;
    }
    Object[] arrayOfObject = e(paramArrayOfObject1);
    paramArrayOfObject[0] = arrayOfObject;
    i = paramInt1 & 0x1F;
    paramInt1 = paramCollection.size() + paramInt1 - 1 & 0x1F;
    int j = paramInt2 - i;
    if (paramInt1 + j < 32)
    {
      kotlin.a.k.a(arrayOfObject, paramArrayOfObject2, paramInt1 + 1, i, paramInt2);
      paramCollection = paramCollection.iterator();
      a(arrayOfObject, i, paramCollection);
      paramInt1 = 1;
      if (1 >= paramInt3) {}
    }
    for (;;)
    {
      paramInt2 = paramInt1 + 1;
      paramArrayOfObject[paramInt1] = a(qA(), 0, paramCollection);
      if (paramInt2 >= paramInt3)
      {
        a(paramArrayOfObject2, 0, paramCollection);
        AppMethodBeat.o(203045);
        return;
        j = j + paramInt1 - 32 + 1;
        if (paramInt3 == 1) {
          paramArrayOfObject1 = arrayOfObject;
        }
        for (;;)
        {
          kotlin.a.k.a(arrayOfObject, paramArrayOfObject2, 0, paramInt2 - j, paramInt2);
          kotlin.a.k.a(arrayOfObject, paramArrayOfObject1, paramInt1 + 1, i, paramInt2 - j);
          paramArrayOfObject2 = paramArrayOfObject1;
          break;
          paramArrayOfObject1 = qA();
          paramInt3 -= 1;
          paramArrayOfObject[paramInt3] = paramArrayOfObject1;
        }
      }
      paramInt1 = paramInt2;
    }
  }
  
  private final Object[] a(int paramInt1, int paramInt2, Object[][] paramArrayOfObject, int paramInt3, Object[] paramArrayOfObject1)
  {
    AppMethodBeat.i(203033);
    if (this.aqw == null)
    {
      paramArrayOfObject = (Throwable)new IllegalStateException("Required value was null.".toString());
      AppMethodBeat.o(203033);
      throw paramArrayOfObject;
    }
    ListIterator localListIterator = ce(qx() >> 5);
    while (localListIterator.previousIndex() != paramInt1)
    {
      Object[] arrayOfObject = (Object[])localListIterator.previous();
      kotlin.a.k.a(arrayOfObject, paramArrayOfObject1, 0, 32 - paramInt2, 32);
      paramArrayOfObject1 = d(arrayOfObject, paramInt2);
      paramInt3 -= 1;
      paramArrayOfObject[paramInt3] = paramArrayOfObject1;
    }
    paramArrayOfObject = (Object[])localListIterator.previous();
    AppMethodBeat.o(203033);
    return paramArrayOfObject;
  }
  
  private final Object[] a(Object[] paramArrayOfObject, int paramInt1, int paramInt2, d paramd)
  {
    AppMethodBeat.i(203076);
    int i = paramInt2 - 1 >> paramInt1 & 0x1F;
    if (paramInt1 == 5) {
      paramd.value = paramArrayOfObject[i];
    }
    Object localObject;
    for (paramd = null; (paramd == null) && (i == 0); paramd = a((Object[])localObject, paramInt1 - 5, paramInt2, paramd))
    {
      AppMethodBeat.o(203076);
      return null;
      localObject = paramArrayOfObject[i];
      if (localObject == null)
      {
        paramArrayOfObject = new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        AppMethodBeat.o(203076);
        throw paramArrayOfObject;
      }
    }
    paramArrayOfObject = e(paramArrayOfObject);
    paramArrayOfObject[i] = paramd;
    AppMethodBeat.o(203076);
    return paramArrayOfObject;
  }
  
  private final Object[] a(Object[] paramArrayOfObject, int paramInt1, int paramInt2, Object paramObject, d paramd)
  {
    AppMethodBeat.i(203022);
    int j = paramInt2 >> paramInt1 & 0x1F;
    if (paramInt1 == 0)
    {
      paramd.value = paramArrayOfObject[31];
      paramArrayOfObject = kotlin.a.k.a(paramArrayOfObject, e(paramArrayOfObject), j + 1, j, 31);
      paramArrayOfObject[j] = paramObject;
      AppMethodBeat.o(203022);
      return paramArrayOfObject;
    }
    paramArrayOfObject = e(paramArrayOfObject);
    int i = paramInt1 - 5;
    Object localObject = paramArrayOfObject[j];
    if (localObject == null)
    {
      paramArrayOfObject = new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
      AppMethodBeat.o(203022);
      throw paramArrayOfObject;
    }
    paramArrayOfObject[j] = a((Object[])localObject, i, paramInt2, paramObject, paramd);
    paramInt1 = j + 1;
    if (paramInt1 < 32) {}
    for (;;)
    {
      paramInt2 = paramInt1 + 1;
      if (paramArrayOfObject[paramInt1] != null)
      {
        paramObject = paramArrayOfObject[paramInt1];
        if (paramObject == null)
        {
          paramArrayOfObject = new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
          AppMethodBeat.o(203022);
          throw paramArrayOfObject;
        }
        paramArrayOfObject[paramInt1] = a((Object[])paramObject, i, 0, paramd.value, paramd);
        if (paramInt2 < 32) {}
      }
      else
      {
        AppMethodBeat.o(203022);
        return paramArrayOfObject;
      }
      paramInt1 = paramInt2;
    }
  }
  
  private final Object[] a(Object[] paramArrayOfObject, int paramInt1, int paramInt2, Iterator<Object[]> paramIterator)
  {
    AppMethodBeat.i(203002);
    if (!paramIterator.hasNext())
    {
      paramArrayOfObject = (Throwable)new IllegalStateException("Check failed.".toString());
      AppMethodBeat.o(203002);
      throw paramArrayOfObject;
    }
    if (paramInt2 >= 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramArrayOfObject = (Throwable)new IllegalStateException("Check failed.".toString());
      AppMethodBeat.o(203002);
      throw paramArrayOfObject;
    }
    if (paramInt2 == 0)
    {
      paramArrayOfObject = (Object[])paramIterator.next();
      AppMethodBeat.o(203002);
      return paramArrayOfObject;
    }
    paramArrayOfObject = e(paramArrayOfObject);
    i = paramInt1 >> paramInt2 & 0x1F;
    paramArrayOfObject[i] = a((Object[])paramArrayOfObject[i], paramInt1, paramInt2 - 5, paramIterator);
    paramInt1 = i;
    for (;;)
    {
      paramInt1 += 1;
      if ((paramInt1 >= 32) || (!paramIterator.hasNext())) {
        break;
      }
      paramArrayOfObject[paramInt1] = a((Object[])paramArrayOfObject[paramInt1], 0, paramInt2 - 5, paramIterator);
    }
    AppMethodBeat.o(203002);
    return paramArrayOfObject;
  }
  
  private static Object[] a(Object[] paramArrayOfObject, int paramInt, Iterator<? extends Object> paramIterator)
  {
    AppMethodBeat.i(202988);
    while ((paramInt < 32) && (paramIterator.hasNext()))
    {
      paramArrayOfObject[paramInt] = paramIterator.next();
      paramInt += 1;
    }
    AppMethodBeat.o(202988);
    return paramArrayOfObject;
  }
  
  private final Object[] a(Object[] paramArrayOfObject, int paramInt, Object[][] paramArrayOfObject1)
  {
    AppMethodBeat.i(202997);
    paramArrayOfObject1 = kotlin.g.b.c.ao((Object[])paramArrayOfObject1);
    if (paramInt >> 5 < 1 << this.aqy) {
      paramArrayOfObject = a(paramArrayOfObject, paramInt, this.aqy, paramArrayOfObject1);
    }
    while (paramArrayOfObject1.hasNext())
    {
      this.aqy += 5;
      paramArrayOfObject = ab(paramArrayOfObject);
      a(paramArrayOfObject, 1 << this.aqy, this.aqy, paramArrayOfObject1);
      continue;
      paramArrayOfObject = e(paramArrayOfObject);
    }
    AppMethodBeat.o(202997);
    return paramArrayOfObject;
  }
  
  private final Object[] a(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2, int paramInt)
  {
    AppMethodBeat.i(202979);
    int i = size() - 1 >> paramInt & 0x1F;
    paramArrayOfObject1 = e(paramArrayOfObject1);
    if (paramInt == 5) {
      paramArrayOfObject1[i] = paramArrayOfObject2;
    }
    for (;;)
    {
      AppMethodBeat.o(202979);
      return paramArrayOfObject1;
      paramArrayOfObject1[i] = a((Object[])paramArrayOfObject1[i], paramArrayOfObject2, paramInt - 5);
    }
  }
  
  private final Object[] ab(Object paramObject)
  {
    Object[] arrayOfObject = new Object[33];
    arrayOfObject[0] = paramObject;
    arrayOfObject[32] = this.aqC;
    return arrayOfObject;
  }
  
  private final Object b(Object[] paramArrayOfObject, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(203051);
    int i = size() - paramInt1;
    Object localObject;
    if (i == 1)
    {
      localObject = this.aqx[0];
      b(paramArrayOfObject, paramInt1, paramInt2);
    }
    for (paramArrayOfObject = localObject;; paramArrayOfObject = localObject)
    {
      AppMethodBeat.o(203051);
      return paramArrayOfObject;
      localObject = this.aqx[paramInt3];
      Object[] arrayOfObject = kotlin.a.k.a(this.aqx, e(this.aqx), paramInt3, paramInt3 + 1, i);
      arrayOfObject[(i - 1)] = null;
      this.aqw = paramArrayOfObject;
      this.aqx = arrayOfObject;
      this.size = (i + paramInt1 - 1);
      this.aqy = paramInt2;
    }
  }
  
  private final void b(Object[] paramArrayOfObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(203066);
    if (paramInt2 == 0)
    {
      this.aqw = null;
      localObject = paramArrayOfObject;
      if (paramArrayOfObject == null) {
        localObject = new Object[0];
      }
      this.aqx = ((Object[])localObject);
      this.size = paramInt1;
      this.aqy = paramInt2;
      AppMethodBeat.o(203066);
      return;
    }
    Object localObject = new d(null);
    s.checkNotNull(paramArrayOfObject);
    paramArrayOfObject = a(paramArrayOfObject, paramInt2, paramInt1, (d)localObject);
    s.checkNotNull(paramArrayOfObject);
    localObject = ((d)localObject).value;
    if (localObject == null)
    {
      paramArrayOfObject = new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
      AppMethodBeat.o(203066);
      throw paramArrayOfObject;
    }
    this.aqx = ((Object[])localObject);
    this.size = paramInt1;
    if (paramArrayOfObject[1] == null)
    {
      this.aqw = ((Object[])paramArrayOfObject[0]);
      this.aqy = (paramInt2 - 5);
      AppMethodBeat.o(203066);
      return;
    }
    this.aqw = paramArrayOfObject;
    this.aqy = paramInt2;
    AppMethodBeat.o(203066);
  }
  
  private final void b(Object[] paramArrayOfObject, int paramInt, E paramE)
  {
    AppMethodBeat.i(203011);
    int i = cd(size());
    Object[] arrayOfObject = e(this.aqx);
    if (i < 32)
    {
      kotlin.a.k.a(this.aqx, arrayOfObject, paramInt + 1, paramInt, i);
      arrayOfObject[paramInt] = paramE;
      this.aqw = paramArrayOfObject;
      this.aqx = arrayOfObject;
      this.size = (size() + 1);
      AppMethodBeat.o(203011);
      return;
    }
    Object localObject = this.aqx[31];
    kotlin.a.k.a(this.aqx, arrayOfObject, paramInt + 1, paramInt, 31);
    arrayOfObject[paramInt] = paramE;
    b(paramArrayOfObject, arrayOfObject, ab(localObject));
    AppMethodBeat.o(203011);
  }
  
  private final void b(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2, Object[] paramArrayOfObject3)
  {
    AppMethodBeat.i(202970);
    if (size() >> 5 > 1 << this.aqy)
    {
      this.aqw = a(ab(paramArrayOfObject1), paramArrayOfObject2, this.aqy + 5);
      this.aqx = paramArrayOfObject3;
      this.aqy += 5;
      this.size = (size() + 1);
      AppMethodBeat.o(202970);
      return;
    }
    if (paramArrayOfObject1 == null)
    {
      this.aqw = paramArrayOfObject2;
      this.aqx = paramArrayOfObject3;
      this.size = (size() + 1);
      AppMethodBeat.o(202970);
      return;
    }
    this.aqw = a(paramArrayOfObject1, paramArrayOfObject2, this.aqy);
    this.aqx = paramArrayOfObject3;
    this.size = (size() + 1);
    AppMethodBeat.o(202970);
  }
  
  private final Object[] b(Object[] paramArrayOfObject, int paramInt1, int paramInt2, d paramd)
  {
    int i = 31;
    AppMethodBeat.i(203059);
    int j = paramInt2 >> paramInt1 & 0x1F;
    Object localObject;
    if (paramInt1 == 0)
    {
      localObject = paramArrayOfObject[j];
      paramArrayOfObject = kotlin.a.k.a(paramArrayOfObject, e(paramArrayOfObject), j, j + 1, 32);
      paramArrayOfObject[31] = paramd.value;
      paramd.value = localObject;
      AppMethodBeat.o(203059);
      return paramArrayOfObject;
    }
    if (paramArrayOfObject[31] == null) {
      i = qx() - 1 >> paramInt1 & 0x1F;
    }
    paramArrayOfObject = e(paramArrayOfObject);
    paramInt1 -= 5;
    int k = j + 1;
    if (k <= i) {}
    for (;;)
    {
      localObject = paramArrayOfObject[i];
      if (localObject == null)
      {
        paramArrayOfObject = new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        AppMethodBeat.o(203059);
        throw paramArrayOfObject;
      }
      paramArrayOfObject[i] = b((Object[])localObject, paramInt1, 0, paramd);
      if (i == k)
      {
        localObject = paramArrayOfObject[j];
        if (localObject == null)
        {
          paramArrayOfObject = new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
          AppMethodBeat.o(203059);
          throw paramArrayOfObject;
        }
        paramArrayOfObject[j] = b((Object[])localObject, paramInt1, paramInt2, paramd);
        AppMethodBeat.o(203059);
        return paramArrayOfObject;
      }
      i -= 1;
    }
  }
  
  private final Object[] b(Object[] paramArrayOfObject, int paramInt1, int paramInt2, E paramE, d paramd)
  {
    AppMethodBeat.i(203145);
    int i = paramInt2 >> paramInt1 & 0x1F;
    Object[] arrayOfObject = e(paramArrayOfObject);
    if (paramInt1 == 0)
    {
      if (arrayOfObject != paramArrayOfObject) {
        this.modCount += 1;
      }
      paramd.value = arrayOfObject[i];
      arrayOfObject[i] = paramE;
      AppMethodBeat.o(203145);
      return arrayOfObject;
    }
    paramArrayOfObject = arrayOfObject[i];
    if (paramArrayOfObject == null)
    {
      paramArrayOfObject = new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
      AppMethodBeat.o(203145);
      throw paramArrayOfObject;
    }
    arrayOfObject[i] = b((Object[])paramArrayOfObject, paramInt1 - 5, paramInt2, paramE, paramd);
    AppMethodBeat.o(203145);
    return arrayOfObject;
  }
  
  private final Object[] c(Object[] paramArrayOfObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(203109);
    if (paramInt2 >= 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramArrayOfObject = (Throwable)new IllegalStateException("Check failed.".toString());
      AppMethodBeat.o(203109);
      throw paramArrayOfObject;
    }
    if (paramInt2 == 0)
    {
      AppMethodBeat.o(203109);
      return paramArrayOfObject;
    }
    i = paramInt1 >> paramInt2 & 0x1F;
    Object localObject = paramArrayOfObject[i];
    if (localObject == null)
    {
      paramArrayOfObject = new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
      AppMethodBeat.o(203109);
      throw paramArrayOfObject;
    }
    Object[] arrayOfObject = c((Object[])localObject, paramInt1, paramInt2 - 5);
    localObject = paramArrayOfObject;
    if (i < 31)
    {
      localObject = paramArrayOfObject;
      if (paramArrayOfObject[(i + 1)] != null)
      {
        if (d(paramArrayOfObject)) {
          kotlin.a.k.a(paramArrayOfObject, null, i + 1, 32);
        }
        localObject = kotlin.a.k.a(paramArrayOfObject, qA(), 0, 0, i + 1);
      }
    }
    paramArrayOfObject = (Object[])localObject;
    if (arrayOfObject != localObject[i])
    {
      paramArrayOfObject = e((Object[])localObject);
      paramArrayOfObject[i] = arrayOfObject;
    }
    AppMethodBeat.o(203109);
    return paramArrayOfObject;
  }
  
  private static int cd(int paramInt)
  {
    if (paramInt <= 32) {
      return paramInt;
    }
    return paramInt - (paramInt - 1 & 0xFFFFFFE0);
  }
  
  private final ListIterator<Object[]> ce(int paramInt)
  {
    AppMethodBeat.i(203153);
    if (this.aqw == null)
    {
      localObject = (Throwable)new IllegalStateException("Required value was null.".toString());
      AppMethodBeat.o(203153);
      throw ((Throwable)localObject);
    }
    int i = qx() >> 5;
    androidx.compose.runtime.b.a.a.a.b.c.V(paramInt, i);
    if (this.aqy == 0)
    {
      localObject = this.aqw;
      s.checkNotNull(localObject);
      localObject = (ListIterator)new i(localObject, paramInt);
      AppMethodBeat.o(203153);
      return localObject;
    }
    int j = this.aqy / 5;
    Object localObject = this.aqw;
    s.checkNotNull(localObject);
    localObject = (ListIterator)new k((Object[])localObject, paramInt, i, j);
    AppMethodBeat.o(203153);
    return localObject;
  }
  
  private final boolean d(Object[] paramArrayOfObject)
  {
    return (paramArrayOfObject.length == 33) && (paramArrayOfObject[32] == this.aqC);
  }
  
  private final Object[] d(Object[] paramArrayOfObject, int paramInt)
  {
    AppMethodBeat.i(202949);
    if (d(paramArrayOfObject))
    {
      paramArrayOfObject = kotlin.a.k.a(paramArrayOfObject, paramArrayOfObject, paramInt, 0, 32 - paramInt);
      AppMethodBeat.o(202949);
      return paramArrayOfObject;
    }
    paramArrayOfObject = kotlin.a.k.a(paramArrayOfObject, qA(), paramInt, 0, 32 - paramInt);
    AppMethodBeat.o(202949);
    return paramArrayOfObject;
  }
  
  private final Object[] e(Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(202941);
    if (paramArrayOfObject == null)
    {
      paramArrayOfObject = qA();
      AppMethodBeat.o(202941);
      return paramArrayOfObject;
    }
    if (d(paramArrayOfObject))
    {
      AppMethodBeat.o(202941);
      return paramArrayOfObject;
    }
    paramArrayOfObject = kotlin.a.k.a(paramArrayOfObject, qA(), 0, 0, kotlin.k.k.qv(paramArrayOfObject.length, 32), 6);
    AppMethodBeat.o(202941);
    return paramArrayOfObject;
  }
  
  private final Object[] e(Object[] paramArrayOfObject, int paramInt)
  {
    AppMethodBeat.i(203099);
    if ((paramInt & 0x1F) == 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramArrayOfObject = (Throwable)new IllegalStateException("Check failed.".toString());
      AppMethodBeat.o(203099);
      throw paramArrayOfObject;
    }
    if (paramInt == 0)
    {
      this.aqy = 0;
      AppMethodBeat.o(203099);
      return null;
    }
    paramInt -= 1;
    while (paramInt >> this.aqy == 0)
    {
      this.aqy -= 5;
      paramArrayOfObject = paramArrayOfObject[0];
      if (paramArrayOfObject == null)
      {
        paramArrayOfObject = new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        AppMethodBeat.o(203099);
        throw paramArrayOfObject;
      }
      paramArrayOfObject = (Object[])paramArrayOfObject;
    }
    paramArrayOfObject = c(paramArrayOfObject, paramInt, this.aqy);
    AppMethodBeat.o(203099);
    return paramArrayOfObject;
  }
  
  private final boolean g(b<? super E, Boolean> paramb)
  {
    AppMethodBeat.i(203091);
    int j = cd(size());
    Object localObject = new d(null);
    if (this.aqw == null)
    {
      if (a(paramb, j, (d)localObject) != j)
      {
        AppMethodBeat.o(203091);
        return true;
      }
      AppMethodBeat.o(203091);
      return false;
    }
    ListIterator localListIterator = ce(0);
    for (int i = 32; (i == 32) && (localListIterator.hasNext()); i = a(paramb, (Object[])localListIterator.next(), 32, (d)localObject)) {}
    if (i == 32)
    {
      localListIterator.hasNext();
      i = a(paramb, j, (d)localObject);
      if (i == 0) {
        b(this.aqw, size(), this.aqy);
      }
      if (i != j)
      {
        AppMethodBeat.o(203091);
        return true;
      }
      AppMethodBeat.o(203091);
      return false;
    }
    int k = localListIterator.previousIndex() << 5;
    List localList1 = (List)new ArrayList();
    List localList2 = (List)new ArrayList();
    while (localListIterator.hasNext()) {
      i = a(paramb, (Object[])localListIterator.next(), 32, i, (d)localObject, localList2, localList1);
    }
    i = a(paramb, this.aqx, j, i, (d)localObject, localList2, localList1);
    paramb = ((d)localObject).value;
    if (paramb == null)
    {
      paramb = new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
      AppMethodBeat.o(203091);
      throw paramb;
    }
    localObject = (Object[])paramb;
    kotlin.a.k.a((Object[])localObject, null, i, 32);
    if (localList1.isEmpty())
    {
      paramb = this.aqw;
      s.checkNotNull(paramb);
    }
    for (;;)
    {
      j = (localList1.size() << 5) + k;
      this.aqw = e(paramb, j);
      this.aqx = ((Object[])localObject);
      this.size = (j + i);
      AppMethodBeat.o(203091);
      return true;
      paramb = a(this.aqw, k, this.aqy, localList1.iterator());
    }
  }
  
  private final Object[] qA()
  {
    Object[] arrayOfObject = new Object[33];
    arrayOfObject[32] = this.aqC;
    return arrayOfObject;
  }
  
  private final int qx()
  {
    AppMethodBeat.i(202923);
    if (size() <= 32)
    {
      AppMethodBeat.o(202923);
      return 0;
    }
    int i = size();
    AppMethodBeat.o(202923);
    return i - 1 & 0xFFFFFFE0;
  }
  
  public final void add(int paramInt, E paramE)
  {
    AppMethodBeat.i(203185);
    androidx.compose.runtime.b.a.a.a.b.c.V(paramInt, size());
    if (paramInt == size())
    {
      add(paramE);
      AppMethodBeat.o(203185);
      return;
    }
    this.modCount += 1;
    int i = qx();
    if (paramInt >= i)
    {
      b(this.aqw, paramInt - i, paramE);
      AppMethodBeat.o(203185);
      return;
    }
    d locald = new d(null);
    Object[] arrayOfObject = this.aqw;
    s.checkNotNull(arrayOfObject);
    b(a(arrayOfObject, this.aqy, paramInt, paramE, locald), 0, locald.value);
    AppMethodBeat.o(203185);
  }
  
  public final boolean add(E paramE)
  {
    AppMethodBeat.i(203172);
    this.modCount += 1;
    int i = cd(size());
    if (i < 32)
    {
      Object[] arrayOfObject = e(this.aqx);
      arrayOfObject[i] = paramE;
      this.aqx = arrayOfObject;
      this.size = (size() + 1);
    }
    for (;;)
    {
      AppMethodBeat.o(203172);
      return true;
      paramE = ab(paramE);
      b(this.aqw, this.aqx, paramE);
    }
  }
  
  public final boolean addAll(int paramInt, Collection<? extends E> paramCollection)
  {
    AppMethodBeat.i(203193);
    s.u(paramCollection, "elements");
    androidx.compose.runtime.b.a.a.a.b.c.V(paramInt, size());
    if (paramInt == size())
    {
      boolean bool = addAll(paramCollection);
      AppMethodBeat.o(203193);
      return bool;
    }
    if (paramCollection.isEmpty())
    {
      AppMethodBeat.o(203193);
      return false;
    }
    this.modCount += 1;
    int i = paramInt >> 5 << 5;
    int j = (size() - i + paramCollection.size() - 1) / 32;
    Object[] arrayOfObject1;
    if (j == 0)
    {
      qx();
      i = paramInt & 0x1F;
      j = paramCollection.size();
      arrayOfObject1 = kotlin.a.k.a(this.aqx, e(this.aqx), (j + paramInt - 1 & 0x1F) + 1, i, cd(size()));
      a(arrayOfObject1, i, paramCollection.iterator());
      this.aqx = arrayOfObject1;
      this.size = (size() + paramCollection.size());
      AppMethodBeat.o(203193);
      return true;
    }
    Object[][] arrayOfObject; = new Object[j][];
    int k = cd(size());
    int m = cd(size() + paramCollection.size());
    if (paramInt >= qx())
    {
      arrayOfObject1 = qA();
      a(paramCollection, paramInt, this.aqx, k, arrayOfObject;, j, arrayOfObject1);
    }
    for (;;)
    {
      this.aqw = a(this.aqw, i, arrayOfObject;);
      this.aqx = arrayOfObject1;
      this.size = (size() + paramCollection.size());
      AppMethodBeat.o(203193);
      return true;
      if (m > k)
      {
        k = m - k;
        arrayOfObject1 = d(this.aqx, k);
        a(paramCollection, paramInt, k, arrayOfObject;, j, arrayOfObject1);
      }
      else
      {
        arrayOfObject1 = kotlin.a.k.a(this.aqx, qA(), 0, k - m, k);
        k = 32 - (k - m);
        Object[] arrayOfObject2 = d(this.aqx, k);
        arrayOfObject;[(j - 1)] = arrayOfObject2;
        a(paramCollection, paramInt, k, arrayOfObject;, j - 1, arrayOfObject2);
      }
    }
  }
  
  public final boolean addAll(Collection<? extends E> paramCollection)
  {
    AppMethodBeat.i(203177);
    s.u(paramCollection, "elements");
    if (paramCollection.isEmpty())
    {
      AppMethodBeat.o(203177);
      return false;
    }
    this.modCount += 1;
    int i = cd(size());
    Iterator localIterator = paramCollection.iterator();
    if (32 - i >= paramCollection.size())
    {
      this.aqx = a(e(this.aqx), i, localIterator);
      this.size = (size() + paramCollection.size());
      AppMethodBeat.o(203177);
      return true;
    }
    int k = (paramCollection.size() + i - 1) / 32;
    Object[][] arrayOfObject; = new Object[k][];
    arrayOfObject;[0] = a(e(this.aqx), i, localIterator);
    if (1 < k) {}
    int j;
    for (i = 1;; i = j)
    {
      j = i + 1;
      arrayOfObject;[i] = a(qA(), 0, localIterator);
      if (j >= k)
      {
        this.aqw = a(this.aqw, qx(), arrayOfObject;);
        this.aqx = a(qA(), 0, localIterator);
        this.size = (size() + paramCollection.size());
        break;
      }
    }
  }
  
  public final boolean f(b<? super E, Boolean> paramb)
  {
    AppMethodBeat.i(203220);
    s.u(paramb, "predicate");
    boolean bool = g(paramb);
    if (bool) {
      this.modCount += 1;
    }
    AppMethodBeat.o(203220);
    return bool;
  }
  
  public final E get(int paramInt)
  {
    AppMethodBeat.i(203197);
    androidx.compose.runtime.b.a.a.a.b.c.U(paramInt, size());
    Object localObject2;
    if (qx() <= paramInt)
    {
      localObject2 = this.aqx;
      localObject1 = localObject2[(paramInt & 0x1F)];
      AppMethodBeat.o(203197);
      return localObject1;
    }
    Object localObject1 = this.aqw;
    s.checkNotNull(localObject1);
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
        AppMethodBeat.o(203197);
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
  
  public final Iterator<E> iterator()
  {
    AppMethodBeat.i(203232);
    Iterator localIterator = (Iterator)listIterator();
    AppMethodBeat.o(203232);
    return localIterator;
  }
  
  public final ListIterator<E> listIterator()
  {
    AppMethodBeat.i(203241);
    ListIterator localListIterator = listIterator(0);
    AppMethodBeat.o(203241);
    return localListIterator;
  }
  
  public final ListIterator<E> listIterator(int paramInt)
  {
    AppMethodBeat.i(203246);
    androidx.compose.runtime.b.a.a.a.b.c.V(paramInt, size());
    ListIterator localListIterator = (ListIterator)new h(this, paramInt);
    AppMethodBeat.o(203246);
    return localListIterator;
  }
  
  public final androidx.compose.runtime.b.a.a.a.h<E> qs()
  {
    AppMethodBeat.i(203166);
    Object localObject;
    if ((this.aqw == this.aqA) && (this.aqx == this.aqB)) {
      localObject = this.aqz;
    }
    for (;;)
    {
      this.aqz = ((androidx.compose.runtime.b.a.a.a.h)localObject);
      localObject = this.aqz;
      AppMethodBeat.o(203166);
      return localObject;
      this.aqC = new androidx.compose.runtime.b.a.a.a.b.d();
      this.aqA = this.aqw;
      this.aqB = this.aqx;
      if (this.aqw == null)
      {
        if (this.aqx.length == 0) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label111;
          }
          localObject = l.qG();
          break;
        }
        label111:
        localObject = Arrays.copyOf(this.aqx, size());
        s.s(localObject, "java.util.Arrays.copyOf(this, newSize)");
        localObject = (androidx.compose.runtime.b.a.a.a.h)new j((Object[])localObject);
      }
      else
      {
        localObject = this.aqw;
        s.checkNotNull(localObject);
        localObject = (androidx.compose.runtime.b.a.a.a.h)new e((Object[])localObject, this.aqx, size(), this.aqy);
      }
    }
  }
  
  public final int qz()
  {
    return this.modCount;
  }
  
  public final boolean removeAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(203215);
    s.u(paramCollection, "elements");
    boolean bool = f((b)new f.a(paramCollection));
    AppMethodBeat.o(203215);
    return bool;
  }
  
  public final E removeAt(int paramInt)
  {
    AppMethodBeat.i(203206);
    androidx.compose.runtime.b.a.a.a.b.c.U(paramInt, size());
    this.modCount += 1;
    int i = qx();
    if (paramInt >= i)
    {
      localObject = b(this.aqw, i, this.aqy, paramInt - i);
      AppMethodBeat.o(203206);
      return localObject;
    }
    Object localObject = new d(this.aqx[0]);
    Object[] arrayOfObject = this.aqw;
    s.checkNotNull(arrayOfObject);
    b(b(arrayOfObject, this.aqy, paramInt, (d)localObject), i, this.aqy, 0);
    localObject = ((d)localObject).value;
    AppMethodBeat.o(203206);
    return localObject;
  }
  
  public final E set(int paramInt, E paramE)
  {
    AppMethodBeat.i(203223);
    androidx.compose.runtime.b.a.a.a.b.c.U(paramInt, size());
    if (qx() <= paramInt)
    {
      localObject1 = e(this.aqx);
      if (localObject1 != this.aqx) {
        this.modCount += 1;
      }
      paramInt &= 0x1F;
      localObject2 = localObject1[paramInt];
      localObject1[paramInt] = paramE;
      this.aqx = ((Object[])localObject1);
      AppMethodBeat.o(203223);
      return localObject2;
    }
    Object localObject1 = new d(null);
    Object localObject2 = this.aqw;
    s.checkNotNull(localObject2);
    this.aqw = b((Object[])localObject2, this.aqy, paramInt, paramE, (d)localObject1);
    paramE = ((d)localObject1).value;
    AppMethodBeat.o(203223);
    return paramE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.b.a.a.a.a.a.f
 * JD-Core Version:    0.7.0.1
 */
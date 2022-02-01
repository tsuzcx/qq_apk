package androidx.compose.runtime.b.a.a.a.a.b;

import androidx.compose.runtime.b.a.a.a.b.a;
import androidx.compose.runtime.b.a.a.a.b.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.k.e;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "K", "V", "", "dataMap", "", "nodeMap", "buffer", "", "(II[Ljava/lang/Object;)V", "ownedBy", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;", "(II[Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)V", "<set-?>", "getBuffer$runtime_release", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "accept", "", "visitor", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "node", "shift", "hash", "accept$runtime_release", "asInsertResult", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode$ModificationResult;", "asUpdateResult", "bufferMoveEntryToNode", "keyIndex", "positionMask", "newKeyHash", "newKey", "newValue", "owner", "(IIILjava/lang/Object;Ljava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)[Ljava/lang/Object;", "calculateSize", "collisionContainsKey", "", "key", "(Ljava/lang/Object;)Z", "collisionGet", "(Ljava/lang/Object;)Ljava/lang/Object;", "collisionPut", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode$ModificationResult;", "collisionRemove", "(Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "(Ljava/lang/Object;Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "collisionRemoveEntryAtIndex", "i", "containsKey", "keyHash", "(ILjava/lang/Object;I)Z", "elementsIdentityEquals", "otherNode", "entryCount", "entryCount$runtime_release", "entryKeyIndex", "entryKeyIndex$runtime_release", "get", "(ILjava/lang/Object;I)Ljava/lang/Object;", "hasEntryAt", "hasEntryAt$runtime_release", "hasNodeAt", "insertEntryAt", "(ILjava/lang/Object;Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "keyAtIndex", "(I)Ljava/lang/Object;", "makeNode", "keyHash1", "key1", "value1", "keyHash2", "key2", "value2", "(ILjava/lang/Object;Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "moveEntryToNode", "(IIILjava/lang/Object;Ljava/lang/Object;I)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "mutableCollisionPut", "mutator", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;", "(Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "mutableCollisionPutAll", "intersectionCounter", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/DeltaCounter;", "mutableCollisionRemove", "(Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "mutableCollisionRemoveEntryAtIndex", "mutableInsertEntryAt", "(ILjava/lang/Object;Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "mutableMoveEntryToNode", "(IIILjava/lang/Object;Ljava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "mutablePut", "(ILjava/lang/Object;Ljava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "mutablePutAll", "mutablePutAllFromOtherNodeCell", "other", "mutableRemove", "(ILjava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "mutableRemoveEntryAtIndex", "mutableRemoveNodeAtIndex", "nodeIndex", "mutableReplaceNode", "targetNode", "newNode", "mutableUpdateNodeAtIndex", "mutableUpdateValueAtIndex", "(ILjava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "nodeAtIndex", "nodeAtIndex$runtime_release", "nodeIndex$runtime_release", "put", "(ILjava/lang/Object;Ljava/lang/Object;I)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode$ModificationResult;", "remove", "(ILjava/lang/Object;Ljava/lang/Object;I)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "(ILjava/lang/Object;I)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "removeEntryAtIndex", "removeNodeAtIndex", "replaceNode", "updateNodeAtIndex", "updateValueAtIndex", "(ILjava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "valueAtKeyIndex", "Companion", "ModificationResult", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class t<K, V>
{
  public static final t.a ara;
  private static final t are;
  int arb;
  private int arc;
  private final d ard;
  Object[] buffer;
  
  static
  {
    AppMethodBeat.i(203042);
    ara = new t.a((byte)0);
    are = new t(0, 0, new Object[0]);
    AppMethodBeat.o(203042);
  }
  
  private t(int paramInt1, int paramInt2, Object[] paramArrayOfObject)
  {
    this(paramInt1, paramInt2, paramArrayOfObject, null);
    AppMethodBeat.i(202832);
    AppMethodBeat.o(202832);
  }
  
  private t(int paramInt1, int paramInt2, Object[] paramArrayOfObject, d paramd)
  {
    AppMethodBeat.i(202824);
    this.arb = paramInt1;
    this.arc = paramInt2;
    this.ard = paramd;
    this.buffer = paramArrayOfObject;
    AppMethodBeat.o(202824);
  }
  
  private final t<K, V> a(int paramInt1, int paramInt2, int paramInt3, K paramK, V paramV, int paramInt4)
  {
    AppMethodBeat.i(202922);
    paramK = a(paramInt1, paramInt2, paramInt3, paramK, paramV, paramInt4, null);
    paramK = new t(this.arb ^ paramInt2, this.arc | paramInt2, paramK);
    AppMethodBeat.o(202922);
    return paramK;
  }
  
  private final t<K, V> a(int paramInt1, int paramInt2, f<K, V> paramf)
  {
    AppMethodBeat.i(202943);
    paramf.setSize(paramf.size() - 1);
    paramf.aqU = cm(paramInt1);
    if (this.buffer.length == 2)
    {
      AppMethodBeat.o(202943);
      return null;
    }
    if (this.ard == paramf.aqC)
    {
      this.buffer = x.g(this.buffer, paramInt1);
      this.arb ^= paramInt2;
      AppMethodBeat.o(202943);
      return this;
    }
    Object[] arrayOfObject = x.g(this.buffer, paramInt1);
    paramf = new t(this.arb ^ paramInt2, this.arc, arrayOfObject, paramf.aqC);
    AppMethodBeat.o(202943);
    return paramf;
  }
  
  private final t<K, V> a(int paramInt1, int paramInt2, t<K, V> paramt)
  {
    AppMethodBeat.i(202891);
    Object localObject = paramt.buffer;
    if ((localObject.length == 2) && (paramt.arc == 0))
    {
      if (this.buffer.length == 1)
      {
        paramt.arb = this.arc;
        AppMethodBeat.o(202891);
        return paramt;
      }
      int i = ck(paramInt2);
      paramt = this.buffer;
      arrayOfObject1 = localObject[0];
      localObject = localObject[1];
      Object[] arrayOfObject2 = Arrays.copyOf(paramt, paramt.length + 1);
      s.s(arrayOfObject2, "java.util.Arrays.copyOf(this, newSize)");
      kotlin.a.k.a(arrayOfObject2, arrayOfObject2, paramInt1 + 2, paramInt1 + 1, paramt.length);
      kotlin.a.k.a(arrayOfObject2, arrayOfObject2, i + 2, i, paramInt1);
      arrayOfObject2[i] = arrayOfObject1;
      arrayOfObject2[(i + 1)] = localObject;
      paramt = new t(this.arb ^ paramInt2, this.arc ^ paramInt2, arrayOfObject2);
      AppMethodBeat.o(202891);
      return paramt;
    }
    Object[] arrayOfObject1 = Arrays.copyOf(this.buffer, this.buffer.length);
    s.s(arrayOfObject1, "java.util.Arrays.copyOf(this, newSize)");
    arrayOfObject1[paramInt1] = paramt;
    paramt = new t(this.arb, this.arc, arrayOfObject1);
    AppMethodBeat.o(202891);
    return paramt;
  }
  
  private final t<K, V> a(int paramInt1, int paramInt2, d paramd)
  {
    AppMethodBeat.i(202908);
    if (this.buffer.length == 1)
    {
      AppMethodBeat.o(202908);
      return null;
    }
    if (this.ard == paramd)
    {
      this.buffer = x.h(this.buffer, paramInt1);
      this.arc ^= paramInt2;
      AppMethodBeat.o(202908);
      return this;
    }
    Object[] arrayOfObject = x.h(this.buffer, paramInt1);
    paramd = new t(this.arb, this.arc ^ paramInt2, arrayOfObject, paramd);
    AppMethodBeat.o(202908);
    return paramd;
  }
  
  private final t<K, V> a(int paramInt, f<K, V> paramf)
  {
    AppMethodBeat.i(202952);
    paramf.setSize(paramf.size() - 1);
    paramf.aqU = cm(paramInt);
    if (this.buffer.length == 2)
    {
      AppMethodBeat.o(202952);
      return null;
    }
    if (this.ard == paramf.aqC)
    {
      this.buffer = x.g(this.buffer, paramInt);
      AppMethodBeat.o(202952);
      return this;
    }
    paramf = new t(0, 0, x.g(this.buffer, paramInt), paramf.aqC);
    AppMethodBeat.o(202952);
    return paramf;
  }
  
  private final t<K, V> a(int paramInt, t<K, V> paramt, d paramd)
  {
    AppMethodBeat.i(202900);
    if ((this.buffer.length == 1) && (paramt.buffer.length == 2) && (paramt.arc == 0))
    {
      paramt.arb = this.arc;
      AppMethodBeat.o(202900);
      return paramt;
    }
    if (this.ard == paramd)
    {
      this.buffer[paramInt] = paramt;
      AppMethodBeat.o(202900);
      return this;
    }
    Object[] arrayOfObject = this.buffer;
    arrayOfObject = Arrays.copyOf(arrayOfObject, arrayOfObject.length);
    s.s(arrayOfObject, "java.util.Arrays.copyOf(this, size)");
    arrayOfObject[paramInt] = paramt;
    paramt = new t(this.arb, this.arc, arrayOfObject, paramd);
    AppMethodBeat.o(202900);
    return paramt;
  }
  
  private final t<K, V> a(int paramInt, V paramV, f<K, V> paramf)
  {
    AppMethodBeat.i(202885);
    if (this.ard == paramf.aqC)
    {
      this.buffer[(paramInt + 1)] = paramV;
      AppMethodBeat.o(202885);
      return this;
    }
    paramf.aqV += 1;
    Object[] arrayOfObject = this.buffer;
    arrayOfObject = Arrays.copyOf(arrayOfObject, arrayOfObject.length);
    s.s(arrayOfObject, "java.util.Arrays.copyOf(this, size)");
    arrayOfObject[(paramInt + 1)] = paramV;
    paramV = new t(this.arb, this.arc, arrayOfObject, paramf.aqC);
    AppMethodBeat.o(202885);
    return paramV;
  }
  
  private final t<K, V> a(int paramInt1, K paramK1, V paramV1, int paramInt2, K paramK2, V paramV2, int paramInt3, d paramd)
  {
    AppMethodBeat.i(202935);
    if (paramInt3 > 30)
    {
      paramK1 = new t(0, 0, new Object[] { paramK1, paramV1, paramK2, paramV2 }, paramd);
      AppMethodBeat.o(202935);
      return paramK1;
    }
    int i = paramInt1 >> paramInt3 & 0x1F;
    int j = paramInt2 >> paramInt3 & 0x1F;
    if (i != j)
    {
      Object[] arrayOfObject;
      if (i < j)
      {
        arrayOfObject = new Object[4];
        arrayOfObject[0] = paramK1;
        arrayOfObject[1] = paramV1;
        arrayOfObject[2] = paramK2;
        arrayOfObject[3] = paramV2;
      }
      for (paramK1 = arrayOfObject;; paramK1 = arrayOfObject)
      {
        paramK1 = new t(1 << j | 1 << i, 0, paramK1, paramd);
        AppMethodBeat.o(202935);
        return paramK1;
        arrayOfObject = new Object[4];
        arrayOfObject[0] = paramK2;
        arrayOfObject[1] = paramV2;
        arrayOfObject[2] = paramK1;
        arrayOfObject[3] = paramV1;
      }
    }
    paramK1 = new t(0, 1 << i, new Object[] { a(paramInt1, paramK1, paramV1, paramInt2, paramK2, paramV2, paramInt3 + 5, paramd) }, paramd);
    AppMethodBeat.o(202935);
    return paramK1;
  }
  
  private final t<K, V> a(int paramInt, K paramK, V paramV, d paramd)
  {
    AppMethodBeat.i(202873);
    int i = ck(paramInt);
    if (this.ard == paramd)
    {
      this.buffer = x.a(this.buffer, i, paramK, paramV);
      this.arb |= paramInt;
      AppMethodBeat.o(202873);
      return this;
    }
    paramK = x.a(this.buffer, i, paramK, paramV);
    paramK = new t(this.arb | paramInt, this.arc, paramK, paramd);
    AppMethodBeat.o(202873);
    return paramK;
  }
  
  private final t<K, V> a(t<K, V> paramt, int paramInt1, int paramInt2, a parama, f<K, V> paramf)
  {
    AppMethodBeat.i(203015);
    if (paramt.cj(paramInt1))
    {
      paramt = a(paramt.cn(paramt.cl(paramInt1)), paramInt2 + 5, parama, paramf);
      AppMethodBeat.o(203015);
      return paramt;
    }
    if (paramt.ci(paramInt1))
    {
      paramInt1 = paramt.ck(paramInt1);
      Object localObject = paramt.buffer[paramInt1];
      paramt = paramt.cm(paramInt1);
      int i = paramf.size();
      if (localObject != null) {}
      for (paramInt1 = localObject.hashCode();; paramInt1 = 0)
      {
        paramt = a(paramInt1, localObject, paramt, paramInt2 + 5, paramf);
        if (paramf.size() == i) {
          parama.count += 1;
        }
        AppMethodBeat.o(203015);
        return paramt;
      }
    }
    AppMethodBeat.o(203015);
    return this;
  }
  
  private final t<K, V> a(t<K, V> paramt1, t<K, V> paramt2, int paramInt1, int paramInt2, d paramd)
  {
    AppMethodBeat.i(203032);
    if (paramt2 == null)
    {
      paramt1 = a(paramInt1, paramInt2, paramd);
      AppMethodBeat.o(203032);
      return paramt1;
    }
    if ((this.ard == paramd) || (paramt1 != paramt2))
    {
      paramt1 = a(paramInt1, paramt2, paramd);
      AppMethodBeat.o(203032);
      return paramt1;
    }
    AppMethodBeat.o(203032);
    return this;
  }
  
  private final t<K, V> a(t<K, V> paramt, a parama, d paramd)
  {
    AppMethodBeat.i(203007);
    Object[] arrayOfObject = Arrays.copyOf(this.buffer, this.buffer.length + paramt.buffer.length);
    s.s(arrayOfObject, "java.util.Arrays.copyOf(this, newSize)");
    int i = this.buffer.length;
    e locale = kotlin.k.k.a((e)kotlin.k.k.qt(0, paramt.buffer.length), 2);
    int k = locale.fIj;
    int m = locale.aixs;
    int n = locale.rBp;
    int j;
    if ((n <= 0) || (k > m))
    {
      j = i;
      if (n < 0)
      {
        j = i;
        if (m > k) {}
      }
    }
    else
    {
      j = k;
    }
    for (;;)
    {
      if (!ad(paramt.buffer[j]))
      {
        arrayOfObject[i] = paramt.buffer[j];
        arrayOfObject[(i + 1)] = paramt.buffer[(j + 1)];
        i += 2;
      }
      while (j == m)
      {
        j = i;
        if (j == this.buffer.length)
        {
          AppMethodBeat.o(203007);
          return this;
          parama.count += 1;
        }
        else
        {
          if (j == paramt.buffer.length)
          {
            AppMethodBeat.o(203007);
            return paramt;
          }
          if (j == arrayOfObject.length)
          {
            paramt = new t(0, 0, arrayOfObject, paramd);
            AppMethodBeat.o(203007);
            return paramt;
          }
          paramt = Arrays.copyOf(arrayOfObject, j);
          s.s(paramt, "java.util.Arrays.copyOf(this, newSize)");
          paramt = new t(0, 0, paramt, paramd);
          AppMethodBeat.o(203007);
          return paramt;
        }
      }
      j += n;
    }
  }
  
  private final t<K, V> a(K paramK, f<K, V> paramf)
  {
    AppMethodBeat.i(202990);
    e locale = kotlin.k.k.a((e)kotlin.k.k.qt(0, this.buffer.length), 2);
    int j = locale.fIj;
    int k = locale.aixs;
    int m = locale.rBp;
    int i;
    if (m > 0)
    {
      i = j;
      if (j <= k) {}
    }
    else
    {
      if ((m >= 0) || (k > j)) {
        break label109;
      }
      i = j;
    }
    for (;;)
    {
      if (s.p(paramK, this.buffer[i]))
      {
        paramK = a(i, paramf);
        AppMethodBeat.o(202990);
        return paramK;
      }
      if (i == k)
      {
        label109:
        AppMethodBeat.o(202990);
        return this;
      }
      i += m;
    }
  }
  
  private final t<K, V> a(K paramK, V paramV, f<K, V> paramf)
  {
    AppMethodBeat.i(202984);
    e locale = kotlin.k.k.a((e)kotlin.k.k.qt(0, this.buffer.length), 2);
    int j = locale.fIj;
    int k = locale.aixs;
    int m = locale.rBp;
    int i;
    if (m > 0)
    {
      i = j;
      if (j <= k) {}
    }
    else
    {
      if ((m >= 0) || (k > j)) {
        break label196;
      }
      i = j;
    }
    for (;;)
    {
      if (s.p(paramK, this.buffer[i]))
      {
        paramf.aqU = cm(i);
        if (this.ard == paramf.aqC)
        {
          this.buffer[(i + 1)] = paramV;
          AppMethodBeat.o(202984);
          return this;
        }
        paramf.aqV += 1;
        paramK = this.buffer;
        paramK = Arrays.copyOf(paramK, paramK.length);
        s.s(paramK, "java.util.Arrays.copyOf(this, size)");
        paramK[(i + 1)] = paramV;
        paramK = new t(0, 0, paramK, paramf.aqC);
        AppMethodBeat.o(202984);
        return paramK;
      }
      if (i == k)
      {
        label196:
        paramf.setSize(paramf.size() + 1);
        paramK = new t(0, 0, x.a(this.buffer, 0, paramK, paramV), paramf.aqC);
        AppMethodBeat.o(202984);
        return paramK;
      }
      i += m;
    }
  }
  
  private final boolean a(t<K, V> paramt)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramt) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (this.arc != paramt.arc);
      bool1 = bool2;
    } while (this.arb != paramt.arb);
    int k = this.buffer.length;
    if (k > 0) {}
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      bool1 = bool2;
      if (this.buffer[i] != paramt.buffer[i]) {
        break;
      }
      if (j >= k) {
        return true;
      }
    }
  }
  
  private final Object[] a(int paramInt1, int paramInt2, int paramInt3, K paramK, V paramV, int paramInt4, d paramd)
  {
    AppMethodBeat.i(202916);
    Object localObject = this.buffer[paramInt1];
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      paramK = a(i, localObject, cm(paramInt1), paramInt3, paramK, paramV, paramInt4 + 5, paramd);
      paramInt2 = cl(paramInt2) + 1;
      paramV = this.buffer;
      paramInt3 = paramInt2 - 2;
      paramd = new Object[paramV.length - 2 + 1];
      kotlin.a.k.a(paramV, paramd, 0, 0, paramInt1, 6);
      kotlin.a.k.a(paramV, paramd, paramInt1, paramInt1 + 2, paramInt2);
      paramd[paramInt3] = paramK;
      kotlin.a.k.a(paramV, paramd, paramInt3 + 1, paramInt2, paramV.length);
      AppMethodBeat.o(202916);
      return paramd;
    }
  }
  
  private final boolean ad(K paramK)
  {
    AppMethodBeat.i(202961);
    e locale = kotlin.k.k.a((e)kotlin.k.k.qt(0, this.buffer.length), 2);
    int j = locale.fIj;
    int k = locale.aixs;
    int m = locale.rBp;
    int i;
    if (m > 0)
    {
      i = j;
      if (j <= k) {}
    }
    else
    {
      if ((m >= 0) || (k > j)) {
        break label97;
      }
      i = j;
    }
    for (;;)
    {
      if (s.p(paramK, this.buffer[i]))
      {
        AppMethodBeat.o(202961);
        return true;
      }
      if (i == k)
      {
        label97:
        AppMethodBeat.o(202961);
        return false;
      }
      i += m;
    }
  }
  
  private final V ae(K paramK)
  {
    AppMethodBeat.i(202967);
    e locale = kotlin.k.k.a((e)kotlin.k.k.qt(0, this.buffer.length), 2);
    int j = locale.fIj;
    int k = locale.aixs;
    int m = locale.rBp;
    int i;
    if (m > 0)
    {
      i = j;
      if (j <= k) {}
    }
    else
    {
      if ((m >= 0) || (k > j)) {
        break label103;
      }
      i = j;
    }
    for (;;)
    {
      if (s.p(paramK, this.buffer[i]))
      {
        paramK = cm(i);
        AppMethodBeat.o(202967);
        return paramK;
      }
      if (i == k)
      {
        label103:
        AppMethodBeat.o(202967);
        return null;
      }
      i += m;
    }
  }
  
  private final t<K, V> b(int paramInt1, int paramInt2, int paramInt3, K paramK, V paramV, int paramInt4, d paramd)
  {
    AppMethodBeat.i(202928);
    if (this.ard == paramd)
    {
      this.buffer = a(paramInt1, paramInt2, paramInt3, paramK, paramV, paramInt4, paramd);
      this.arb ^= paramInt2;
      this.arc |= paramInt2;
      AppMethodBeat.o(202928);
      return this;
    }
    paramK = a(paramInt1, paramInt2, paramInt3, paramK, paramV, paramInt4, paramd);
    paramK = new t(this.arb ^ paramInt2, this.arc | paramInt2, paramK, paramd);
    AppMethodBeat.o(202928);
    return paramK;
  }
  
  private final t<K, V> b(K paramK, V paramV, f<K, V> paramf)
  {
    AppMethodBeat.i(202999);
    e locale = kotlin.k.k.a((e)kotlin.k.k.qt(0, this.buffer.length), 2);
    int j = locale.fIj;
    int k = locale.aixs;
    int m = locale.rBp;
    int i;
    if (m > 0)
    {
      i = j;
      if (j <= k) {}
    }
    else
    {
      if ((m >= 0) || (k > j)) {
        break label127;
      }
      i = j;
    }
    for (;;)
    {
      if ((s.p(paramK, this.buffer[i])) && (s.p(paramV, cm(i))))
      {
        paramK = a(i, paramf);
        AppMethodBeat.o(202999);
        return paramK;
      }
      if (i == k)
      {
        label127:
        AppMethodBeat.o(202999);
        return this;
      }
      i += m;
    }
  }
  
  private final boolean cj(int paramInt)
  {
    return (this.arc & paramInt) != 0;
  }
  
  private final V cm(int paramInt)
  {
    return this.buffer[(paramInt + 1)];
  }
  
  private final t<K, V> e(int paramInt, K paramK, V paramV)
  {
    AppMethodBeat.i(202862);
    int i = ck(paramInt);
    paramK = x.a(this.buffer, i, paramK, paramV);
    paramK = new t(this.arb | paramInt, this.arc, paramK);
    AppMethodBeat.o(202862);
    return paramK;
  }
  
  private final b<K, V> j(K paramK, V paramV)
  {
    AppMethodBeat.i(202975);
    e locale = kotlin.k.k.a((e)kotlin.k.k.qt(0, this.buffer.length), 2);
    int j = locale.fIj;
    int k = locale.aixs;
    int m = locale.rBp;
    int i;
    if (m > 0)
    {
      i = j;
      if (j <= k) {}
    }
    else
    {
      if ((m >= 0) || (k > j)) {
        break label158;
      }
      i = j;
    }
    for (;;)
    {
      if (s.p(paramK, this.buffer[i]))
      {
        if (paramV == cm(i))
        {
          AppMethodBeat.o(202975);
          return null;
        }
        paramK = this.buffer;
        paramK = Arrays.copyOf(paramK, paramK.length);
        s.s(paramK, "java.util.Arrays.copyOf(this, size)");
        paramK[(i + 1)] = paramV;
        paramK = new t(0, 0, paramK).qR();
        AppMethodBeat.o(202975);
        return paramK;
      }
      if (i == k)
      {
        label158:
        paramK = new t(0, 0, x.a(this.buffer, 0, paramK, paramV)).qQ();
        AppMethodBeat.o(202975);
        return paramK;
      }
      i += m;
    }
  }
  
  private final t<K, V> o(int paramInt, V paramV)
  {
    AppMethodBeat.i(202880);
    Object[] arrayOfObject = this.buffer;
    arrayOfObject = Arrays.copyOf(arrayOfObject, arrayOfObject.length);
    s.s(arrayOfObject, "java.util.Arrays.copyOf(this, size)");
    arrayOfObject[(paramInt + 1)] = paramV;
    paramV = new t(this.arb, this.arc, arrayOfObject);
    AppMethodBeat.o(202880);
    return paramV;
  }
  
  private final b<K, V> qQ()
  {
    AppMethodBeat.i(202837);
    b localb = new b(this, 1);
    AppMethodBeat.o(202837);
    return localb;
  }
  
  private final b<K, V> qR()
  {
    AppMethodBeat.i(202843);
    b localb = new b(this, 0);
    AppMethodBeat.o(202843);
    return localb;
  }
  
  private final int qS()
  {
    AppMethodBeat.i(203021);
    if (this.arc == 0)
    {
      i = this.buffer.length / 2;
      AppMethodBeat.o(203021);
      return i;
    }
    int i = Integer.bitCount(this.arb);
    int k = i * 2;
    int m = this.buffer.length;
    int j = i;
    if (k < m) {}
    for (j = k;; j = k)
    {
      k = j + 1;
      i += cn(j).qS();
      if (k >= m)
      {
        j = i;
        AppMethodBeat.o(203021);
        return j;
      }
    }
  }
  
  public final b<K, V> a(int paramInt1, K paramK, V paramV, int paramInt2)
  {
    AppMethodBeat.i(203107);
    int i = 1 << (paramInt1 >> paramInt2 & 0x1F);
    int j;
    if (ci(i))
    {
      j = ck(i);
      if (s.p(paramK, this.buffer[j]))
      {
        if (cm(j) == paramV)
        {
          AppMethodBeat.o(203107);
          return null;
        }
        paramK = o(j, paramV).qR();
        AppMethodBeat.o(203107);
        return paramK;
      }
      paramK = a(j, i, paramInt1, paramK, paramV, paramInt2).qQ();
      AppMethodBeat.o(203107);
      return paramK;
    }
    if (cj(i))
    {
      j = cl(i);
      t localt = cn(j);
      if (paramInt2 == 30)
      {
        paramV = localt.j(paramK, paramV);
        paramK = paramV;
        if (paramV == null)
        {
          AppMethodBeat.o(203107);
          return null;
        }
      }
      else
      {
        paramV = localt.a(paramInt1, paramK, paramV, paramInt2 + 5);
        paramK = paramV;
        if (paramV == null)
        {
          AppMethodBeat.o(203107);
          return null;
        }
      }
      paramK.b(a(j, i, paramK.aqO));
      AppMethodBeat.o(203107);
      return paramK;
    }
    paramK = e(i, paramK, paramV).qQ();
    AppMethodBeat.o(203107);
    return paramK;
  }
  
  public final t<K, V> a(int paramInt1, K paramK, int paramInt2, f<K, V> paramf)
  {
    AppMethodBeat.i(203137);
    s.u(paramf, "mutator");
    int i = 1 << (paramInt1 >> paramInt2 & 0x1F);
    if (ci(i))
    {
      paramInt1 = ck(i);
      if (s.p(paramK, this.buffer[paramInt1]))
      {
        paramK = a(paramInt1, i, paramf);
        AppMethodBeat.o(203137);
        return paramK;
      }
      AppMethodBeat.o(203137);
      return this;
    }
    if (cj(i))
    {
      int j = cl(i);
      t localt = cn(j);
      if (paramInt2 == 30) {}
      for (paramK = localt.a(paramK, paramf);; paramK = localt.a(paramInt1, paramK, paramInt2 + 5, paramf))
      {
        paramK = a(localt, paramK, j, i, paramf.aqC);
        AppMethodBeat.o(203137);
        return paramK;
      }
    }
    AppMethodBeat.o(203137);
    return this;
  }
  
  public final t<K, V> a(int paramInt1, K paramK, V paramV, int paramInt2, f<K, V> paramf)
  {
    AppMethodBeat.i(203117);
    s.u(paramf, "mutator");
    int i = 1 << (paramInt1 >> paramInt2 & 0x1F);
    if (ci(i))
    {
      int j = ck(i);
      if (s.p(paramK, this.buffer[j]))
      {
        paramf.aqU = cm(j);
        if (cm(j) == paramV)
        {
          AppMethodBeat.o(203117);
          return this;
        }
        paramK = a(j, paramV, paramf);
        AppMethodBeat.o(203117);
        return paramK;
      }
      paramf.setSize(paramf.size() + 1);
      paramK = b(j, i, paramInt1, paramK, paramV, paramInt2, paramf.aqC);
      AppMethodBeat.o(203117);
      return paramK;
    }
    if (cj(i))
    {
      i = cl(i);
      t localt = cn(i);
      if (paramInt2 == 30) {}
      for (paramK = localt.a(paramK, paramV, paramf); localt == paramK; paramK = localt.a(paramInt1, paramK, paramV, paramInt2 + 5, paramf))
      {
        AppMethodBeat.o(203117);
        return this;
      }
      paramK = a(i, paramK, paramf.aqC);
      AppMethodBeat.o(203117);
      return paramK;
    }
    paramf.setSize(paramf.size() + 1);
    paramK = a(i, paramK, paramV, paramf.aqC);
    AppMethodBeat.o(203117);
    return paramK;
  }
  
  public final t<K, V> a(t<K, V> paramt, int paramInt, a parama, f<K, V> paramf)
  {
    AppMethodBeat.i(203098);
    s.u(paramt, "otherNode");
    s.u(parama, "intersectionCounter");
    s.u(paramf, "mutator");
    if (this == paramt)
    {
      parama.co(qS());
      AppMethodBeat.o(203098);
      return this;
    }
    if (paramInt > 30)
    {
      paramt = a(paramt, parama, paramf.aqC);
      AppMethodBeat.o(203098);
      return paramt;
    }
    int i = this.arc;
    int j = paramt.arc | i;
    i = (this.arb ^ paramt.arb) & (j ^ 0xFFFFFFFF);
    int k = this.arb & paramt.arb;
    if (k != 0)
    {
      m = Integer.lowestOneBit(k);
      n = ck(m);
      localObject1 = this.buffer[n];
      n = paramt.ck(m);
      if (s.p(localObject1, paramt.buffer[n])) {
        i |= m;
      }
      for (;;)
      {
        k ^= m;
        break;
        j |= m;
      }
    }
    t localt;
    label235:
    int i1;
    int i2;
    Object[] arrayOfObject;
    if ((s.p(this.ard, paramf.aqC)) && (this.arb == i) && (this.arc == j))
    {
      localt = this;
      k = 0;
      if (j == 0) {
        break label502;
      }
      i1 = Integer.lowestOneBit(j);
      i2 = localt.buffer.length;
      arrayOfObject = localt.buffer;
      if (!cj(i1)) {
        break label353;
      }
    }
    for (Object localObject1 = cn(cl(i1)).a(paramt, i1, paramInt, parama, paramf);; localObject1 = paramt.cn(paramt.cl(i1)).a(this, i1, paramInt, parama, paramf))
    {
      arrayOfObject[(i2 - 1 - k)] = localObject1;
      k += 1;
      j ^= i1;
      break label235;
      localt = new t(i, j, new Object[Integer.bitCount(i) * 2 + Integer.bitCount(j)]);
      break;
      label353:
      if (!paramt.cj(i1)) {
        break label387;
      }
    }
    label387:
    int m = ck(i1);
    localObject1 = this.buffer[m];
    Object localObject2 = cm(m);
    m = paramt.ck(i1);
    Object localObject3 = paramt.buffer[m];
    Object localObject4 = paramt.cm(m);
    if (localObject1 != null)
    {
      m = localObject1.hashCode();
      label449:
      if (localObject3 == null) {
        break label496;
      }
    }
    label496:
    for (int n = localObject3.hashCode();; n = 0)
    {
      localObject1 = a(m, localObject1, localObject2, n, localObject3, localObject4, paramInt + 5, paramf.aqC);
      break;
      m = 0;
      break label449;
    }
    label502:
    paramInt = 0;
    if (i != 0)
    {
      j = Integer.lowestOneBit(i);
      k = paramInt * 2;
      if (!paramt.ci(j))
      {
        m = ck(j);
        localt.buffer[k] = this.buffer[m];
        localt.buffer[(k + 1)] = cm(m);
      }
      for (;;)
      {
        paramInt += 1;
        i ^= j;
        break;
        m = paramt.ck(j);
        localt.buffer[k] = paramt.buffer[m];
        localt.buffer[(k + 1)] = paramt.cm(m);
        if (ci(j)) {
          parama.count += 1;
        }
      }
    }
    if (a(localt))
    {
      AppMethodBeat.o(203098);
      return this;
    }
    if (paramt.a(localt))
    {
      AppMethodBeat.o(203098);
      return paramt;
    }
    AppMethodBeat.o(203098);
    return localt;
  }
  
  public final t<K, V> b(int paramInt1, K paramK, V paramV, int paramInt2, f<K, V> paramf)
  {
    AppMethodBeat.i(203146);
    s.u(paramf, "mutator");
    int i = 1 << (paramInt1 >> paramInt2 & 0x1F);
    if (ci(i))
    {
      paramInt1 = ck(i);
      if ((s.p(paramK, this.buffer[paramInt1])) && (s.p(paramV, cm(paramInt1))))
      {
        paramK = a(paramInt1, i, paramf);
        AppMethodBeat.o(203146);
        return paramK;
      }
      AppMethodBeat.o(203146);
      return this;
    }
    if (cj(i))
    {
      int j = cl(i);
      t localt = cn(j);
      if (paramInt2 == 30) {}
      for (paramK = localt.b(paramK, paramV, paramf);; paramK = localt.b(paramInt1, paramK, paramV, paramInt2 + 5, paramf))
      {
        paramK = a(localt, paramK, j, i, paramf.aqC);
        AppMethodBeat.o(203146);
        return paramK;
      }
    }
    AppMethodBeat.o(203146);
    return this;
  }
  
  public final boolean b(int paramInt1, K paramK, int paramInt2)
  {
    AppMethodBeat.i(203071);
    t localt = this;
    for (;;)
    {
      int i = 1 << (paramInt1 >> paramInt2 & 0x1F);
      boolean bool;
      if (localt.ci(i))
      {
        paramInt1 = localt.ck(i);
        bool = s.p(paramK, localt.buffer[paramInt1]);
        AppMethodBeat.o(203071);
        return bool;
      }
      if (!localt.cj(i)) {
        break;
      }
      localt = localt.cn(localt.cl(i));
      if (paramInt2 == 30)
      {
        bool = localt.ad(paramK);
        AppMethodBeat.o(203071);
        return bool;
      }
      paramInt2 += 5;
    }
    AppMethodBeat.o(203071);
    return false;
  }
  
  public final V c(int paramInt1, K paramK, int paramInt2)
  {
    AppMethodBeat.i(203083);
    t localt = this;
    for (;;)
    {
      int i = 1 << (paramInt1 >> paramInt2 & 0x1F);
      if (localt.ci(i))
      {
        paramInt1 = localt.ck(i);
        if (s.p(paramK, localt.buffer[paramInt1]))
        {
          paramK = localt.cm(paramInt1);
          AppMethodBeat.o(203083);
          return paramK;
        }
        AppMethodBeat.o(203083);
        return null;
      }
      if (!localt.cj(i)) {
        break;
      }
      localt = localt.cn(localt.cl(i));
      if (paramInt2 == 30)
      {
        paramK = localt.ae(paramK);
        AppMethodBeat.o(203083);
        return paramK;
      }
      paramInt2 += 5;
    }
    AppMethodBeat.o(203083);
    return null;
  }
  
  public final boolean ci(int paramInt)
  {
    return (this.arb & paramInt) != 0;
  }
  
  public final int ck(int paramInt)
  {
    AppMethodBeat.i(203052);
    paramInt = Integer.bitCount(this.arb & paramInt - 1);
    AppMethodBeat.o(203052);
    return paramInt * 2;
  }
  
  public final int cl(int paramInt)
  {
    AppMethodBeat.i(203058);
    int i = this.buffer.length;
    paramInt = Integer.bitCount(this.arc & paramInt - 1);
    AppMethodBeat.o(203058);
    return i - 1 - paramInt;
  }
  
  public final t<K, V> cn(int paramInt)
  {
    AppMethodBeat.i(203065);
    Object localObject = this.buffer[paramInt];
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode>");
      AppMethodBeat.o(203065);
      throw ((Throwable)localObject);
    }
    localObject = (t)localObject;
    AppMethodBeat.o(203065);
    return localObject;
  }
  
  public final t<K, V> d(int paramInt1, K paramK, int paramInt2)
  {
    AppMethodBeat.i(203128);
    int i = 1 << (paramInt1 >> paramInt2 & 0x1F);
    if (ci(i))
    {
      paramInt1 = ck(i);
      if (s.p(paramK, this.buffer[paramInt1]))
      {
        if (this.buffer.length == 2)
        {
          AppMethodBeat.o(203128);
          return null;
        }
        paramK = x.g(this.buffer, paramInt1);
        paramK = new t(this.arb ^ i, this.arc, paramK);
        AppMethodBeat.o(203128);
        return paramK;
      }
      AppMethodBeat.o(203128);
      return this;
    }
    int j;
    t localt;
    int k;
    int m;
    if (cj(i))
    {
      j = cl(i);
      localt = cn(j);
      if (paramInt2 == 30)
      {
        e locale = kotlin.k.k.a((e)kotlin.k.k.qt(0, localt.buffer.length), 2);
        paramInt2 = locale.fIj;
        k = locale.aixs;
        m = locale.rBp;
        if (m > 0)
        {
          paramInt1 = paramInt2;
          if (paramInt2 <= k) {}
        }
        else
        {
          if ((m >= 0) || (k > paramInt2)) {
            break label278;
          }
          paramInt1 = paramInt2;
        }
      }
    }
    for (;;)
    {
      if (s.p(paramK, localt.buffer[paramInt1])) {
        if (localt.buffer.length == 2) {
          paramK = null;
        }
      }
      while (paramK == null) {
        if (this.buffer.length == 1)
        {
          AppMethodBeat.o(203128);
          return null;
          paramK = new t(0, 0, x.g(localt.buffer, paramInt1));
          continue;
          if (paramInt1 != k) {
            break label376;
          }
          label278:
          paramK = localt;
          continue;
          paramK = localt.d(paramInt1, paramK, paramInt2 + 5);
        }
        else
        {
          paramK = x.h(this.buffer, j);
          paramK = new t(this.arb, i ^ this.arc, paramK);
          AppMethodBeat.o(203128);
          return paramK;
        }
      }
      if (localt != paramK)
      {
        paramK = a(j, i, paramK);
        AppMethodBeat.o(203128);
        return paramK;
      }
      AppMethodBeat.o(203128);
      return this;
      AppMethodBeat.o(203128);
      return this;
      label376:
      paramInt1 += m;
    }
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode$ModificationResult;", "K", "V", "", "node", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "sizeDelta", "", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;I)V", "getNode", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "setNode", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;)V", "getSizeDelta", "()I", "replaceNode", "operation", "Lkotlin/Function1;", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b<K, V>
  {
    t<K, V> aqO;
    final int arf;
    
    public b(t<K, V> paramt, int paramInt)
    {
      AppMethodBeat.i(202745);
      this.aqO = paramt;
      this.arf = paramInt;
      AppMethodBeat.o(202745);
    }
    
    public final void b(t<K, V> paramt)
    {
      AppMethodBeat.i(202753);
      s.u(paramt, "<set-?>");
      this.aqO = paramt;
      AppMethodBeat.o(202753);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     androidx.compose.runtime.b.a.a.a.a.b.t
 * JD-Core Version:    0.7.0.1
 */
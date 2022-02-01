package androidx.compose.runtime.b.a.a.a.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.a.d;
import kotlin.g.b.an;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilderBaseIterator;", "K", "V", "T", "", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBaseIterator;", "builder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;", "path", "", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNodeBaseIterator;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;[Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNodeBaseIterator;)V", "expectedModCount", "", "lastIteratedKey", "Ljava/lang/Object;", "nextWasInvoked", "", "checkForComodification", "", "checkNextWasInvoked", "next", "()Ljava/lang/Object;", "remove", "resetPath", "keyHash", "node", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "key", "pathIndex", "(ILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;Ljava/lang/Object;I)V", "setValue", "newValue", "(Ljava/lang/Object;Ljava/lang/Object;)V", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public class g<K, V, T>
  extends e<K, V, T>
  implements Iterator<T>, d
{
  private int aqF;
  private final f<K, V> aqW;
  private K aqX;
  private boolean aqY;
  
  public g(f<K, V> paramf, u<K, V, T>[] paramArrayOfu)
  {
    super(paramf.aqO, paramArrayOfu);
    AppMethodBeat.i(202800);
    this.aqW = paramf;
    this.aqF = this.aqW.aqV;
    AppMethodBeat.o(202800);
  }
  
  private final void a(int paramInt1, t<?, ?> paramt, K paramK, int paramInt2)
  {
    AppMethodBeat.i(202810);
    for (;;)
    {
      int i = paramInt2 * 5;
      if (i > 30)
      {
        qL()[paramInt2].d(paramt.buffer, paramt.buffer.length, 0);
        while (!s.p(qL()[paramInt2].qN(), paramK)) {
          qL()[paramInt2].qV();
        }
        cg(paramInt2);
        AppMethodBeat.o(202810);
        return;
      }
      i = 1 << (paramInt1 >> i & 0x1F);
      if (paramt.ci(i))
      {
        paramInt1 = paramt.ck(i);
        qL()[paramInt2].d(paramt.buffer, Integer.bitCount(paramt.arb) * 2, paramInt1);
        cg(paramInt2);
        AppMethodBeat.o(202810);
        return;
      }
      i = paramt.cl(i);
      t localt = paramt.cn(i);
      qL()[paramInt2].d(paramt.buffer, Integer.bitCount(paramt.arb) * 2, i);
      paramInt2 += 1;
      paramt = localt;
    }
  }
  
  public final void i(K paramK, V paramV)
  {
    AppMethodBeat.i(202834);
    if (!this.aqW.containsKey(paramK))
    {
      AppMethodBeat.o(202834);
      return;
    }
    int i;
    if (hasNext())
    {
      Object localObject = qN();
      ((Map)this.aqW).put(paramK, paramV);
      if (localObject != null)
      {
        i = localObject.hashCode();
        a(i, this.aqW.aqO, localObject, 0);
      }
    }
    for (;;)
    {
      this.aqF = this.aqW.aqV;
      AppMethodBeat.o(202834);
      return;
      i = 0;
      break;
      ((Map)this.aqW).put(paramK, paramV);
    }
  }
  
  public T next()
  {
    AppMethodBeat.i(202816);
    if (this.aqW.aqV != this.aqF)
    {
      localObject = new ConcurrentModificationException();
      AppMethodBeat.o(202816);
      throw ((Throwable)localObject);
    }
    this.aqX = qN();
    this.aqY = true;
    Object localObject = super.next();
    AppMethodBeat.o(202816);
    return localObject;
  }
  
  public void remove()
  {
    AppMethodBeat.i(202826);
    Object localObject1;
    if (!this.aqY)
    {
      localObject1 = new IllegalStateException();
      AppMethodBeat.o(202826);
      throw ((Throwable)localObject1);
    }
    Object localObject2;
    int i;
    if (hasNext())
    {
      localObject1 = qN();
      localObject2 = (Map)this.aqW;
      Object localObject3 = this.aqX;
      if (localObject2 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
        AppMethodBeat.o(202826);
        throw ((Throwable)localObject1);
      }
      an.hJ(localObject2).remove(localObject3);
      if (localObject1 != null)
      {
        i = localObject1.hashCode();
        a(i, this.aqW.aqO, localObject1, 0);
      }
    }
    for (;;)
    {
      this.aqX = null;
      this.aqY = false;
      this.aqF = this.aqW.aqV;
      AppMethodBeat.o(202826);
      return;
      i = 0;
      break;
      localObject1 = (Map)this.aqW;
      localObject2 = this.aqX;
      if (localObject1 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
        AppMethodBeat.o(202826);
        throw ((Throwable)localObject1);
      }
      an.hJ(localObject1).remove(localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     androidx.compose.runtime.b.a.a.a.a.b.g
 * JD-Core Version:    0.7.0.1
 */
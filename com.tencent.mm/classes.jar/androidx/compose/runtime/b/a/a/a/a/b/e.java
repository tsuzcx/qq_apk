package androidx.compose.runtime.b.a.a.a.a.b;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.g.b.a.a;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBaseIterator;", "K", "V", "T", "", "node", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "path", "", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNodeBaseIterator;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;[Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNodeBaseIterator;)V", "hasNext", "", "getHasNext$annotations", "()V", "getPath", "()[Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNodeBaseIterator;", "[Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNodeBaseIterator;", "pathLastIndex", "", "getPathLastIndex", "()I", "setPathLastIndex", "(I)V", "checkHasNext", "", "currentKey", "()Ljava/lang/Object;", "ensureNextEntryIsReady", "moveToNextNodeWithData", "pathIndex", "next", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class e<K, V, T>
  implements Iterator<T>, a
{
  private final u<K, V, T>[] aqQ;
  private int aqR;
  private boolean aqS;
  
  public e(t<K, V> paramt, u<K, V, T>[] paramArrayOfu)
  {
    this.aqQ = paramArrayOfu;
    this.aqS = true;
    this.aqQ[0].f(paramt.buffer, Integer.bitCount(paramt.arb) * 2);
    this.aqR = 0;
    qM();
  }
  
  private final int ch(int paramInt)
  {
    if (this.aqQ[paramInt].qU()) {
      return paramInt;
    }
    if (this.aqQ[paramInt].qW())
    {
      Object localObject = this.aqQ[paramInt];
      ((u)localObject).qW();
      localObject = localObject.buffer[localObject.index];
      if (localObject == null) {
        throw new NullPointerException("null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNodeBaseIterator, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNodeBaseIterator>");
      }
      localObject = (t)localObject;
      if (paramInt == 6) {
        this.aqQ[(paramInt + 1)].f(((t)localObject).buffer, ((t)localObject).buffer.length);
      }
      for (;;)
      {
        paramInt += 1;
        break;
        this.aqQ[(paramInt + 1)].f(((t)localObject).buffer, Integer.bitCount(((t)localObject).arb) * 2);
      }
    }
    return -1;
  }
  
  private final void qM()
  {
    if (this.aqQ[this.aqR].qU()) {
      return;
    }
    int i = this.aqR;
    if (i >= 0) {}
    for (;;)
    {
      int k = i - 1;
      int m = ch(i);
      int j = m;
      if (m == -1)
      {
        j = m;
        if (this.aqQ[i].qW())
        {
          this.aqQ[i].qX();
          j = ch(i);
        }
      }
      if (j != -1)
      {
        this.aqR = j;
        return;
      }
      if (i > 0) {
        this.aqQ[(i - 1)].qX();
      }
      u localu = this.aqQ[i];
      t.a locala = t.ara;
      localu.f(t.qT().buffer, 0);
      if (k < 0)
      {
        this.aqS = false;
        return;
      }
      i = k;
    }
  }
  
  private final void qO()
  {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
  }
  
  protected final void cg(int paramInt)
  {
    this.aqR = paramInt;
  }
  
  public boolean hasNext()
  {
    return this.aqS;
  }
  
  public T next()
  {
    qO();
    Object localObject = this.aqQ[this.aqR].next();
    qM();
    return localObject;
  }
  
  protected final u<K, V, T>[] qL()
  {
    return this.aqQ;
  }
  
  protected final K qN()
  {
    qO();
    return this.aqQ[this.aqR].qN();
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     androidx.compose.runtime.b.a.a.a.a.b.e
 * JD-Core Version:    0.7.0.1
 */
package androidx.compose.runtime.b.a.a.a.a.b;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.a.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNodeBaseIterator;", "K", "V", "T", "", "()V", "<set-?>", "", "", "buffer", "getBuffer", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "dataSize", "", "index", "getIndex", "()I", "setIndex", "(I)V", "currentKey", "()Ljava/lang/Object;", "currentNode", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "hasNext", "", "hasNextKey", "hasNextNode", "moveToNextKey", "", "moveToNextNode", "reset", "([Ljava/lang/Object;I)V", "([Ljava/lang/Object;II)V", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class u<K, V, T>
  implements Iterator<T>, a
{
  Object[] buffer;
  private int dataSize;
  int index;
  
  public u()
  {
    t.a locala = t.ara;
    this.buffer = t.qT().buffer;
  }
  
  public final void d(Object[] paramArrayOfObject, int paramInt1, int paramInt2)
  {
    s.u(paramArrayOfObject, "buffer");
    this.buffer = paramArrayOfObject;
    this.dataSize = paramInt1;
    this.index = paramInt2;
  }
  
  public final void f(Object[] paramArrayOfObject, int paramInt)
  {
    s.u(paramArrayOfObject, "buffer");
    d(paramArrayOfObject, paramInt, 0);
  }
  
  public boolean hasNext()
  {
    return qU();
  }
  
  public final K qN()
  {
    qU();
    return this.buffer[this.index];
  }
  
  public final boolean qU()
  {
    return this.index < this.dataSize;
  }
  
  public final void qV()
  {
    qU();
    this.index += 2;
  }
  
  public final boolean qW()
  {
    return this.index < this.buffer.length;
  }
  
  public final void qX()
  {
    qW();
    this.index += 1;
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     androidx.compose.runtime.b.a.a.a.a.b.u
 * JD-Core Version:    0.7.0.1
 */
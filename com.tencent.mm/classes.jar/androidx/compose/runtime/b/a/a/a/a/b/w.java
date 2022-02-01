package androidx.compose.runtime.b.a.a.a.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNodeKeysIterator;", "K", "V", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNodeBaseIterator;", "()V", "next", "()Ljava/lang/Object;", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class w<K, V>
  extends u<K, V, K>
{
  public final K next()
  {
    AppMethodBeat.i(202819);
    qU();
    this.index += 2;
    Object localObject = this.buffer[(this.index - 2)];
    AppMethodBeat.o(202819);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     androidx.compose.runtime.b.a.a.a.a.b.w
 * JD-Core Version:    0.7.0.1
 */
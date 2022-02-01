package androidx.compose.runtime.b.a.a.a.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.a.k;

@Metadata(d1={""}, d2={"ENTRY_SIZE", "", "LOG_MAX_BRANCHING_FACTOR", "MAX_BRANCHING_FACTOR", "MAX_BRANCHING_FACTOR_MINUS_ONE", "MAX_SHIFT", "indexSegment", "index", "shift", "insertEntryAtIndex", "", "", "K", "V", "keyIndex", "key", "value", "([Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Object;)[Ljava/lang/Object;", "removeEntryAtIndex", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "removeNodeAtIndex", "nodeIndex", "replaceEntryWithNode", "newNode", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "([Ljava/lang/Object;IILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;)[Ljava/lang/Object;", "replaceNodeWithEntry", "([Ljava/lang/Object;IILjava/lang/Object;Ljava/lang/Object;)[Ljava/lang/Object;", "runtime_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class x
{
  static final <K, V> Object[] a(Object[] paramArrayOfObject, int paramInt, K paramK, V paramV)
  {
    AppMethodBeat.i(202833);
    Object[] arrayOfObject = new Object[paramArrayOfObject.length + 2];
    k.a(paramArrayOfObject, arrayOfObject, 0, 0, paramInt, 6);
    k.a(paramArrayOfObject, arrayOfObject, paramInt + 2, paramInt, paramArrayOfObject.length);
    arrayOfObject[paramInt] = paramK;
    arrayOfObject[(paramInt + 1)] = paramV;
    AppMethodBeat.o(202833);
    return arrayOfObject;
  }
  
  static final Object[] g(Object[] paramArrayOfObject, int paramInt)
  {
    AppMethodBeat.i(202839);
    Object[] arrayOfObject = new Object[paramArrayOfObject.length - 2];
    k.a(paramArrayOfObject, arrayOfObject, 0, 0, paramInt, 6);
    k.a(paramArrayOfObject, arrayOfObject, paramInt, paramInt + 2, paramArrayOfObject.length);
    AppMethodBeat.o(202839);
    return arrayOfObject;
  }
  
  static final Object[] h(Object[] paramArrayOfObject, int paramInt)
  {
    AppMethodBeat.i(202846);
    Object[] arrayOfObject = new Object[paramArrayOfObject.length - 1];
    k.a(paramArrayOfObject, arrayOfObject, 0, 0, paramInt, 6);
    k.a(paramArrayOfObject, arrayOfObject, paramInt, paramInt + 1, paramArrayOfObject.length);
    AppMethodBeat.o(202846);
    return arrayOfObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.b.a.a.a.a.b.x
 * JD-Core Version:    0.7.0.1
 */
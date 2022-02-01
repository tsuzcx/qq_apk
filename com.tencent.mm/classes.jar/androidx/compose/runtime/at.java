package androidx.compose.runtime;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/ProvidedValue;", "T", "", "compositionLocal", "Landroidx/compose/runtime/CompositionLocal;", "value", "canOverride", "", "(Landroidx/compose/runtime/CompositionLocal;Ljava/lang/Object;Z)V", "getCanOverride", "()Z", "getCompositionLocal", "()Landroidx/compose/runtime/CompositionLocal;", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class at<T>
{
  final p<T> aoG;
  final boolean aoH;
  final T value;
  
  public at(p<T> paramp, T paramT)
  {
    AppMethodBeat.i(201915);
    this.aoG = paramp;
    this.value = paramT;
    this.aoH = true;
    AppMethodBeat.o(201915);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.at
 * JD-Core Version:    0.7.0.1
 */
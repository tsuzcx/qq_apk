package androidx.compose.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.b;

@Metadata(d1={""}, d2={"Landroidx/compose/animation/core/TwoWayConverterImpl;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/TwoWayConverter;", "convertToVector", "Lkotlin/Function1;", "convertFromVector", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getConvertFromVector", "()Lkotlin/jvm/functions/Function1;", "getConvertToVector", "animation-core_release"}, k=1, mv={1, 5, 1}, xi=48)
final class ax<T, V extends k>
  implements aw<T, V>
{
  private final b<T, V> WO;
  private final b<V, T> WP;
  
  public ax(b<? super T, ? extends V> paramb, b<? super V, ? extends T> paramb1)
  {
    AppMethodBeat.i(203311);
    this.WO = paramb;
    this.WP = paramb1;
    AppMethodBeat.o(203311);
  }
  
  public final b<T, V> md()
  {
    return this.WO;
  }
  
  public final b<V, T> me()
  {
    return this.WP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.a.a.ax
 * JD-Core Version:    0.7.0.1
 */
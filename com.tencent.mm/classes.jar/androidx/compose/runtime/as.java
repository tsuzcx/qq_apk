package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.g.a.a;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/ProvidableCompositionLocal;", "T", "Landroidx/compose/runtime/CompositionLocal;", "defaultFactory", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "provides", "Landroidx/compose/runtime/ProvidedValue;", "value", "(Ljava/lang/Object;)Landroidx/compose/runtime/ProvidedValue;", "providesDefault", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class as<T>
  extends p<T>
{
  public as(a<? extends T> parama)
  {
    super(parama, (byte)0);
  }
  
  public final at<T> N(T paramT)
  {
    return new at((p)this, paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.as
 * JD-Core Version:    0.7.0.1
 */
package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.g.a.a;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/CompositionLocal;", "T", "", "defaultFactory", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "current", "getCurrent$annotations", "()V", "getCurrent", "(Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "defaultValueHolder", "Landroidx/compose/runtime/LazyValueHolder;", "getDefaultValueHolder$runtime_release$annotations", "getDefaultValueHolder$runtime_release", "()Landroidx/compose/runtime/LazyValueHolder;", "provided", "Landroidx/compose/runtime/State;", "value", "provided$runtime_release", "(Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class p<T>
{
  final ak<T> anJ;
  
  private p(a<? extends T> parama)
  {
    this.anJ = new ak(parama);
  }
  
  public abstract bm<T> a(T paramT, h paramh);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.p
 * JD-Core Version:    0.7.0.1
 */
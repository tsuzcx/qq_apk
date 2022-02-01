package androidx.compose.runtime;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.b;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/DisposableEffectImpl;", "Landroidx/compose/runtime/RememberObserver;", "effect", "Lkotlin/Function1;", "Landroidx/compose/runtime/DisposableEffectScope;", "Landroidx/compose/runtime/DisposableEffectResult;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)V", "onDispose", "onAbandoned", "", "onForgotten", "onRemembered", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
final class w
  implements az
{
  private final b<y, x> anT;
  private x anU;
  
  public w(b<? super y, ? extends x> paramb)
  {
    AppMethodBeat.i(202222);
    this.anT = paramb;
    AppMethodBeat.o(202222);
  }
  
  public final void mJ()
  {
    AppMethodBeat.i(202226);
    this.anU = ((x)this.anT.invoke(aa.pt()));
    AppMethodBeat.o(202226);
  }
  
  public final void mK()
  {
    AppMethodBeat.i(202234);
    x localx = this.anU;
    if (localx != null) {
      localx.dispose();
    }
    this.anU = null;
    AppMethodBeat.o(202234);
  }
  
  public final void mL() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.w
 * JD-Core Version:    0.7.0.1
 */
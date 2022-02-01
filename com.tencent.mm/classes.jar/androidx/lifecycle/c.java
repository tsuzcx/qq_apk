package androidx.lifecycle;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.d.f;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.cg;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/lifecycle/CloseableCoroutineScope;", "Ljava/io/Closeable;", "Lkotlinx/coroutines/CoroutineScope;", "context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)V", "coroutineContext", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "close", "", "lifecycle-viewmodel-ktx_release"}, k=1, mv={1, 4, 1})
public final class c
  implements Closeable, aq
{
  private final f bGV;
  
  public c(f paramf)
  {
    AppMethodBeat.i(194414);
    this.bGV = paramf;
    AppMethodBeat.o(194414);
  }
  
  public final void close()
  {
    AppMethodBeat.i(194428);
    cg.a(getCoroutineContext(), null);
    AppMethodBeat.o(194428);
  }
  
  public final f getCoroutineContext()
  {
    return this.bGV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.lifecycle.c
 * JD-Core Version:    0.7.0.1
 */
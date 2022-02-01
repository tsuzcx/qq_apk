package coil.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.d;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlinx.coroutines.p;
import okhttp3.e;
import okhttp3.f;
import okhttp3.z;

@Metadata(d1={""}, d2={"Lcoil/util/ContinuationCallback;", "Lokhttp3/Callback;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "call", "Lokhttp3/Call;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "Lokhttp3/Response;", "(Lokhttp3/Call;Lkotlinx/coroutines/CancellableContinuation;)V", "invoke", "onFailure", "e", "Ljava/io/IOException;", "onResponse", "response", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  implements b<Throwable, ah>, f
{
  private final p<z> bgf;
  private final e cqs;
  
  public i(e parame, p<? super z> paramp)
  {
    AppMethodBeat.i(188127);
    this.cqs = parame;
    this.bgf = paramp;
    AppMethodBeat.o(188127);
  }
  
  public final void a(e parame, IOException paramIOException)
  {
    AppMethodBeat.i(188147);
    s.u(parame, "call");
    s.u(paramIOException, "e");
    if (!parame.isCanceled())
    {
      parame = (d)this.bgf;
      Result.Companion localCompanion = Result.Companion;
      parame.resumeWith(Result.constructor-impl(ResultKt.createFailure((Throwable)paramIOException)));
    }
    AppMethodBeat.o(188147);
  }
  
  public final void a(e parame, z paramz)
  {
    AppMethodBeat.i(188139);
    s.u(parame, "call");
    s.u(paramz, "response");
    parame = (d)this.bgf;
    Result.Companion localCompanion = Result.Companion;
    parame.resumeWith(Result.constructor-impl(paramz));
    AppMethodBeat.o(188139);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     coil.util.i
 * JD-Core Version:    0.7.0.1
 */
package coil.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlinx.coroutines.cb;

@Metadata(d1={""}, d2={"Lcoil/request/BaseTargetDisposable;", "Lcoil/request/Disposable;", "job", "Lkotlinx/coroutines/Job;", "(Lkotlinx/coroutines/Job;)V", "isDisposed", "", "()Z", "await", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispose", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements e
{
  private final cb job;
  
  public a(cb paramcb)
  {
    AppMethodBeat.i(187910);
    this.job = paramcb;
    AppMethodBeat.o(187910);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     coil.j.a
 * JD-Core Version:    0.7.0.1
 */
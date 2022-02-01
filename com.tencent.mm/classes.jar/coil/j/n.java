package coil.j;

import coil.target.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.UUID;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcoil/request/ViewTargetDisposable;", "Lcoil/request/Disposable;", "requestId", "Ljava/util/UUID;", "target", "Lcoil/target/ViewTarget;", "(Ljava/util/UUID;Lcoil/target/ViewTarget;)V", "isDisposed", "", "()Z", "await", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispose", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
  implements e
{
  private final UUID cpQ;
  private final c<?> cpR;
  
  public n(UUID paramUUID, c<?> paramc)
  {
    AppMethodBeat.i(187880);
    this.cpQ = paramUUID;
    this.cpR = paramc;
    AppMethodBeat.o(187880);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     coil.j.n
 * JD-Core Version:    0.7.0.1
 */
package coil.memory;

import androidx.lifecycle.j;
import androidx.lifecycle.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlinx.coroutines.cb;

@Metadata(d1={""}, d2={"Lcoil/memory/BaseRequestDelegate;", "Lcoil/memory/RequestDelegate;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "job", "Lkotlinx/coroutines/Job;", "(Landroidx/lifecycle/Lifecycle;Lkotlinx/coroutines/Job;)V", "complete", "", "dispose", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class BaseRequestDelegate
  extends RequestDelegate
{
  private final cb job;
  private final j lifecycle;
  
  public BaseRequestDelegate(j paramj, cb paramcb)
  {
    super((byte)0);
    AppMethodBeat.i(188319);
    this.lifecycle = paramj;
    this.job = paramcb;
    AppMethodBeat.o(188319);
  }
  
  public final void GK()
  {
    AppMethodBeat.i(188328);
    this.lifecycle.removeObserver((p)this);
    AppMethodBeat.o(188328);
  }
  
  public final void dispose()
  {
    AppMethodBeat.i(188337);
    this.job.a(null);
    AppMethodBeat.o(188337);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     coil.memory.BaseRequestDelegate
 * JD-Core Version:    0.7.0.1
 */
package coil.memory;

import androidx.lifecycle.j;
import androidx.lifecycle.p;
import coil.j.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlinx.coroutines.cb;

@Metadata(d1={""}, d2={"Lcoil/memory/ViewTargetRequestDelegate;", "Lcoil/memory/RequestDelegate;", "imageLoader", "Lcoil/ImageLoader;", "request", "Lcoil/request/ImageRequest;", "targetDelegate", "Lcoil/memory/TargetDelegate;", "job", "Lkotlinx/coroutines/Job;", "(Lcoil/ImageLoader;Lcoil/request/ImageRequest;Lcoil/memory/TargetDelegate;Lkotlinx/coroutines/Job;)V", "dispose", "", "restart", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ViewTargetRequestDelegate
  extends RequestDelegate
{
  final coil.d ckS;
  final h cmE;
  private final s coI;
  private final cb job;
  
  public ViewTargetRequestDelegate(coil.d paramd, h paramh, s params, cb paramcb)
  {
    super((byte)0);
    AppMethodBeat.i(188300);
    this.ckS = paramd;
    this.cmE = paramh;
    this.coI = params;
    this.job = paramcb;
    AppMethodBeat.o(188300);
  }
  
  public final void dispose()
  {
    AppMethodBeat.i(188307);
    this.job.a(null);
    this.coI.clear();
    coil.util.d.a(this.coI, null);
    if ((this.cmE.com instanceof p)) {
      this.cmE.lifecycle.removeObserver((p)this.cmE.com);
    }
    this.cmE.lifecycle.removeObserver((p)this);
    AppMethodBeat.o(188307);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     coil.memory.ViewTargetRequestDelegate
 * JD-Core Version:    0.7.0.1
 */
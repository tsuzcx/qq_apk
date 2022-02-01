package coil.memory;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import androidx.b.g;
import coil.j.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlinx.coroutines.cb;

@Metadata(d1={""}, d2={"Lcoil/memory/ViewTargetRequestManager;", "Landroid/view/View$OnAttachStateChangeListener;", "()V", "bitmaps", "Landroidx/collection/SimpleArrayMap;", "", "Landroid/graphics/Bitmap;", "currentRequest", "Lcoil/memory/ViewTargetRequestDelegate;", "<set-?>", "Ljava/util/UUID;", "currentRequestId", "getCurrentRequestId", "()Ljava/util/UUID;", "Lkotlinx/coroutines/Job;", "currentRequestJob", "getCurrentRequestJob", "()Lkotlinx/coroutines/Job;", "isRestart", "", "metadata", "Lcoil/request/ImageResult$Metadata;", "getMetadata", "()Lcoil/request/ImageResult$Metadata;", "setMetadata", "(Lcoil/request/ImageResult$Metadata;)V", "pendingClear", "skipAttach", "clearCurrentRequest", "", "newRequestId", "onViewAttachedToWindow", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "put", "tag", "bitmap", "setCurrentRequest", "request", "setCurrentRequestJob", "job", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class t
  implements View.OnAttachStateChangeListener
{
  public ViewTargetRequestDelegate coJ;
  private volatile UUID coK;
  private volatile cb coL;
  public volatile i.a coM;
  public volatile cb coN;
  public boolean coO;
  public boolean coP;
  final g<Object, Bitmap> coQ;
  
  public t()
  {
    AppMethodBeat.i(188275);
    this.coP = true;
    this.coQ = new g();
    AppMethodBeat.o(188275);
  }
  
  private final UUID MW()
  {
    AppMethodBeat.i(188283);
    UUID localUUID = this.coK;
    if ((localUUID != null) && (this.coO) && (coil.util.d.isMainThread()))
    {
      AppMethodBeat.o(188283);
      return localUUID;
    }
    localUUID = UUID.randomUUID();
    s.s(localUUID, "randomUUID()");
    AppMethodBeat.o(188283);
    return localUUID;
  }
  
  public final UUID a(cb paramcb)
  {
    AppMethodBeat.i(188297);
    s.u(paramcb, "job");
    UUID localUUID = MW();
    this.coK = localUUID;
    this.coL = paramcb;
    AppMethodBeat.o(188297);
    return localUUID;
  }
  
  public final void onViewAttachedToWindow(View paramView)
  {
    AppMethodBeat.i(188306);
    s.u(paramView, "v");
    if (this.coP)
    {
      this.coP = false;
      AppMethodBeat.o(188306);
      return;
    }
    paramView = this.coJ;
    if (paramView != null)
    {
      this.coO = true;
      paramView.ckS.f(paramView.cmE);
    }
    AppMethodBeat.o(188306);
  }
  
  public final void onViewDetachedFromWindow(View paramView)
  {
    AppMethodBeat.i(188315);
    s.u(paramView, "v");
    this.coP = false;
    paramView = this.coJ;
    if (paramView != null) {
      paramView.dispose();
    }
    AppMethodBeat.o(188315);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     coil.memory.t
 * JD-Core Version:    0.7.0.1
 */
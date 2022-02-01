package coil.memory;

import androidx.lifecycle.e;
import androidx.lifecycle.q;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcoil/memory/RequestDelegate;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "()V", "complete", "", "dispose", "onDestroy", "owner", "Landroidx/lifecycle/LifecycleOwner;", "Lcoil/memory/BaseRequestDelegate;", "Lcoil/memory/ViewTargetRequestDelegate;", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class RequestDelegate
  implements e
{
  public void GK() {}
  
  public void dispose() {}
  
  public final void onDestroy(q paramq)
  {
    s.u(paramq, "owner");
    dispose();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     coil.memory.RequestDelegate
 * JD-Core Version:    0.7.0.1
 */
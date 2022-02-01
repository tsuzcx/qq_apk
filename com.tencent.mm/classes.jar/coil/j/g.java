package coil.j;

import androidx.lifecycle.e;
import androidx.lifecycle.j;
import androidx.lifecycle.j.b;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcoil/request/GlobalLifecycle;", "Landroidx/lifecycle/Lifecycle;", "()V", "owner", "Landroidx/lifecycle/LifecycleOwner;", "addObserver", "", "observer", "Landroidx/lifecycle/LifecycleObserver;", "getCurrentState", "Landroidx/lifecycle/Lifecycle$State;", "removeObserver", "toString", "", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends j
{
  public static final g cps;
  private static final q owner;
  
  static
  {
    AppMethodBeat.i(187903);
    cps = new g();
    owner = g..ExternalSyntheticLambda0.INSTANCE;
    AppMethodBeat.o(187903);
  }
  
  private static final j MY()
  {
    return (j)cps;
  }
  
  public final void addObserver(p paramp)
  {
    AppMethodBeat.i(187917);
    s.u(paramp, "observer");
    if (!(paramp instanceof e))
    {
      paramp = (Throwable)new IllegalArgumentException((paramp + " must implement androidx.lifecycle.DefaultLifecycleObserver.").toString());
      AppMethodBeat.o(187917);
      throw paramp;
    }
    ((e)paramp).onStart(owner);
    AppMethodBeat.o(187917);
  }
  
  public final j.b getCurrentState()
  {
    return j.b.bHk;
  }
  
  public final void removeObserver(p paramp)
  {
    AppMethodBeat.i(187927);
    s.u(paramp, "observer");
    AppMethodBeat.o(187927);
  }
  
  public final String toString()
  {
    return "coil.request.GlobalLifecycle";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     coil.j.g
 * JD-Core Version:    0.7.0.1
 */
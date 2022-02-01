package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.j;
import androidx.lifecycle.j.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  private final d ccc;
  public final b ccj;
  
  private c(d paramd)
  {
    AppMethodBeat.i(193335);
    this.ccc = paramd;
    this.ccj = new b();
    AppMethodBeat.o(193335);
  }
  
  public static c b(d paramd)
  {
    AppMethodBeat.i(193340);
    paramd = new c(paramd);
    AppMethodBeat.o(193340);
    return paramd;
  }
  
  public final void m(Bundle paramBundle)
  {
    AppMethodBeat.i(193353);
    this.ccj.m(paramBundle);
    AppMethodBeat.o(193353);
  }
  
  public final void n(Bundle paramBundle)
  {
    AppMethodBeat.i(193349);
    j localj = this.ccc.getLifecycle();
    if (localj.getCurrentState() != j.b.bHh)
    {
      paramBundle = new IllegalStateException("Restarter must be created only during owner's initialization stage");
      AppMethodBeat.o(193349);
      throw paramBundle;
    }
    localj.addObserver(new Recreator(this.ccc));
    this.ccj.a(localj, paramBundle);
    AppMethodBeat.o(193349);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.savedstate.c
 * JD-Core Version:    0.7.0.1
 */
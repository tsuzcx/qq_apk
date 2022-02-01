package androidx.fragment.app;

import androidx.core.f.f;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class e
{
  final g<?> mHost;
  
  private e(g<?> paramg)
  {
    this.mHost = paramg;
  }
  
  public static e a(g<?> paramg)
  {
    AppMethodBeat.i(193780);
    paramg = new e((g)f.checkNotNull(paramg, "callbacks == null"));
    AppMethodBeat.o(193780);
    return paramg;
  }
  
  public final boolean Gk()
  {
    AppMethodBeat.i(193803);
    boolean bool = this.mHost.mFragmentManager.execPendingActions(true);
    AppMethodBeat.o(193803);
    return bool;
  }
  
  public final void noteStateNotSaved()
  {
    AppMethodBeat.i(193794);
    this.mHost.mFragmentManager.noteStateNotSaved();
    AppMethodBeat.o(193794);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.fragment.app.e
 * JD-Core Version:    0.7.0.1
 */
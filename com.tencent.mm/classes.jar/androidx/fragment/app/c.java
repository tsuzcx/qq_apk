package androidx.fragment.app;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class c
{
  final d<?> mHost;
  
  private c(d<?> paramd)
  {
    this.mHost = paramd;
  }
  
  public static c a(d<?> paramd)
  {
    AppMethodBeat.i(212431);
    paramd = new c(paramd);
    AppMethodBeat.o(212431);
    return paramd;
  }
  
  public final boolean execPendingActions()
  {
    AppMethodBeat.i(212436);
    boolean bool = this.mHost.mFragmentManager.execPendingActions();
    AppMethodBeat.o(212436);
    return bool;
  }
  
  public final Fragment findFragmentByWho(String paramString)
  {
    AppMethodBeat.i(212434);
    paramString = this.mHost.mFragmentManager.findFragmentByWho(paramString);
    AppMethodBeat.o(212434);
    return paramString;
  }
  
  public final void noteStateNotSaved()
  {
    AppMethodBeat.i(212435);
    this.mHost.mFragmentManager.noteStateNotSaved();
    AppMethodBeat.o(212435);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.fragment.app.c
 * JD-Core Version:    0.7.0.1
 */
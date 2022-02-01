package a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g<TResult>
{
  final f<TResult> ckQ;
  
  public g()
  {
    AppMethodBeat.i(53005);
    this.ckQ = new f();
    AppMethodBeat.o(53005);
  }
  
  private boolean b(Exception paramException)
  {
    AppMethodBeat.i(53007);
    boolean bool = this.ckQ.b(paramException);
    AppMethodBeat.o(53007);
    return bool;
  }
  
  private boolean trySetResult(TResult paramTResult)
  {
    AppMethodBeat.i(53006);
    boolean bool = this.ckQ.trySetResult(paramTResult);
    AppMethodBeat.o(53006);
    return bool;
  }
  
  public final void Mz()
  {
    AppMethodBeat.i(53008);
    if (!this.ckQ.My())
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Cannot cancel a completed task.");
      AppMethodBeat.o(53008);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(53008);
  }
  
  public final void c(Exception paramException)
  {
    AppMethodBeat.i(53010);
    if (!b(paramException))
    {
      paramException = new IllegalStateException("Cannot set the error on a completed task.");
      AppMethodBeat.o(53010);
      throw paramException;
    }
    AppMethodBeat.o(53010);
  }
  
  public final void setResult(TResult paramTResult)
  {
    AppMethodBeat.i(53009);
    if (!trySetResult(paramTResult))
    {
      paramTResult = new IllegalStateException("Cannot set the result of a completed task.");
      AppMethodBeat.o(53009);
      throw paramTResult;
    }
    AppMethodBeat.o(53009);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     a.g
 * JD-Core Version:    0.7.0.1
 */
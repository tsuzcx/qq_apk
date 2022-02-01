package androidx.core.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e$c<T>
  extends e.b<T>
{
  private final Object mLock;
  
  public e$c(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(195991);
    this.mLock = new Object();
    AppMethodBeat.o(195991);
  }
  
  public final T acquire()
  {
    AppMethodBeat.i(195997);
    synchronized (this.mLock)
    {
      Object localObject2 = super.acquire();
      AppMethodBeat.o(195997);
      return localObject2;
    }
  }
  
  public final boolean release(T paramT)
  {
    AppMethodBeat.i(196006);
    synchronized (this.mLock)
    {
      boolean bool = super.release(paramT);
      AppMethodBeat.o(196006);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.core.f.e.c
 * JD-Core Version:    0.7.0.1
 */
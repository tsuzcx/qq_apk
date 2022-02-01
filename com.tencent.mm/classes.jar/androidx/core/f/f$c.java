package androidx.core.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f$c<T>
  extends f.b<T>
{
  private final Object mLock;
  
  public f$c(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(251340);
    this.mLock = new Object();
    AppMethodBeat.o(251340);
  }
  
  public final T acquire()
  {
    AppMethodBeat.i(251341);
    synchronized (this.mLock)
    {
      Object localObject2 = super.acquire();
      AppMethodBeat.o(251341);
      return localObject2;
    }
  }
  
  public final boolean release(T paramT)
  {
    AppMethodBeat.i(251343);
    synchronized (this.mLock)
    {
      boolean bool = super.release(paramT);
      AppMethodBeat.o(251343);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     androidx.core.f.f.c
 * JD-Core Version:    0.7.0.1
 */
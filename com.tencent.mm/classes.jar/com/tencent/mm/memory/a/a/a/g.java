package com.tencent.mm.memory.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class g<T, V>
  extends e<T, V, a<V>, V>
{
  public g(int paramInt)
  {
    super(paramInt);
  }
  
  protected final T bbd()
  {
    return null;
  }
  
  public final Map<T, V> snapshot()
  {
    return null;
  }
  
  protected final V t(T paramT, V paramV)
  {
    return paramV;
  }
  
  static final class a<T>
  {
    WeakReference<T> cNB;
    T obj;
    
    public a(T paramT)
    {
      AppMethodBeat.i(156519);
      this.obj = null;
      this.cNB = null;
      this.obj = paramT;
      this.cNB = new WeakReference(paramT);
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(156518);
          g.a.this.obj = null;
          AppMethodBeat.o(156518);
        }
      }, 2000L);
      AppMethodBeat.o(156519);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.memory.a.a.a.g
 * JD-Core Version:    0.7.0.1
 */
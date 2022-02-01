package com.tencent.mm.memory.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class g<T, V>
  extends e<T, V, a<V>, V>
{
  public g(int paramInt)
  {
    super(paramInt);
  }
  
  protected final T avY()
  {
    return null;
  }
  
  protected final V r(T paramT, V paramV)
  {
    return paramV;
  }
  
  public final Map<T, V> snapshot()
  {
    return null;
  }
  
  static final class a<T>
  {
    WeakReference<T> cnv;
    T obj;
    
    public a(T paramT)
    {
      AppMethodBeat.i(156519);
      this.obj = null;
      this.cnv = null;
      this.obj = paramT;
      this.cnv = new WeakReference(paramT);
      ap.n(new Runnable()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.memory.a.a.a.g
 * JD-Core Version:    0.7.0.1
 */
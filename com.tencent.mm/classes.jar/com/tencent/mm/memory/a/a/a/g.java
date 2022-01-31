package com.tencent.mm.memory.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class g<T, V>
  extends e<T, V, a<V>, V>
{
  public g(int paramInt)
  {
    super(paramInt);
  }
  
  protected final T XY()
  {
    return null;
  }
  
  protected final V j(T paramT, V paramV)
  {
    return paramV;
  }
  
  public final Map<T, V> snapshot()
  {
    return null;
  }
  
  static final class a<T>
  {
    WeakReference<T> bJz;
    T obj;
    
    public a(T paramT)
    {
      AppMethodBeat.i(115472);
      this.obj = null;
      this.bJz = null;
      this.obj = paramT;
      this.bJz = new WeakReference(paramT);
      al.p(new Runnable()
      {
        public final void run()
        {
          g.a.this.obj = null;
        }
      }, 2000L);
      AppMethodBeat.o(115472);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.memory.a.a.a.g
 * JD-Core Version:    0.7.0.1
 */
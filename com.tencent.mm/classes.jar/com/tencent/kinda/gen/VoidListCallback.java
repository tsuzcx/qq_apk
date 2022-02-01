package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class VoidListCallback
{
  public abstract void call(ArrayList<Integer> paramArrayList);
  
  static final class CppProxy
    extends VoidListCallback
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(190348);
      if (!VoidListCallback.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(190348);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(190344);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(190344);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(190344);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native void native_call(long paramLong, ArrayList<Integer> paramArrayList);
    
    public final void call(ArrayList<Integer> paramArrayList)
    {
      AppMethodBeat.i(190347);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramArrayList = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(190347);
        throw paramArrayList;
      }
      native_call(this.nativeRef, paramArrayList);
      AppMethodBeat.o(190347);
    }
    
    public final void destroy()
    {
      AppMethodBeat.i(190345);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(190345);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(190346);
      destroy();
      super.finalize();
      AppMethodBeat.o(190346);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.gen.VoidListCallback
 * JD-Core Version:    0.7.0.1
 */
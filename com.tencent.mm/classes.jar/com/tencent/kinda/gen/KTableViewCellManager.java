package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class KTableViewCellManager
{
  public abstract void didDelete();
  
  public abstract boolean getEnableDelete();
  
  public abstract KViewLayout getView();
  
  static final class CppProxy
    extends KTableViewCellManager
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(135916);
      if (!KTableViewCellManager.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(135916);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(135910);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(135910);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(135910);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native void native_didDelete(long paramLong);
    
    private native boolean native_getEnableDelete(long paramLong);
    
    private native KViewLayout native_getView(long paramLong);
    
    public final void destroy()
    {
      AppMethodBeat.i(135911);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(135911);
    }
    
    public final void didDelete()
    {
      AppMethodBeat.i(135915);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135915);
        throw localAssertionError;
      }
      native_didDelete(this.nativeRef);
      AppMethodBeat.o(135915);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(135912);
      destroy();
      super.finalize();
      AppMethodBeat.o(135912);
    }
    
    public final boolean getEnableDelete()
    {
      AppMethodBeat.i(135914);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135914);
        throw localAssertionError;
      }
      boolean bool = native_getEnableDelete(this.nativeRef);
      AppMethodBeat.o(135914);
      return bool;
    }
    
    public final KViewLayout getView()
    {
      AppMethodBeat.i(135913);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        localObject = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135913);
        throw ((Throwable)localObject);
      }
      Object localObject = native_getView(this.nativeRef);
      AppMethodBeat.o(135913);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.gen.KTableViewCellManager
 * JD-Core Version:    0.7.0.1
 */
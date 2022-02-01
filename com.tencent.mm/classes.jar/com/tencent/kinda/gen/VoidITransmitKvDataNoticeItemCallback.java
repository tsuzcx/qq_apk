package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class VoidITransmitKvDataNoticeItemCallback
{
  public abstract void call(ITransmitKvData paramITransmitKvData, NoticeItem paramNoticeItem);
  
  static final class CppProxy
    extends VoidITransmitKvDataNoticeItemCallback
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(226761);
      if (!VoidITransmitKvDataNoticeItemCallback.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(226761);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(226760);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(226760);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(226760);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native void native_call(long paramLong, ITransmitKvData paramITransmitKvData, NoticeItem paramNoticeItem);
    
    public final void call(ITransmitKvData paramITransmitKvData, NoticeItem paramNoticeItem)
    {
      AppMethodBeat.i(226765);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramITransmitKvData = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(226765);
        throw paramITransmitKvData;
      }
      native_call(this.nativeRef, paramITransmitKvData, paramNoticeItem);
      AppMethodBeat.o(226765);
    }
    
    public final void destroy()
    {
      AppMethodBeat.i(226762);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(226762);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(226763);
      destroy();
      super.finalize();
      AppMethodBeat.o(226763);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.gen.VoidITransmitKvDataNoticeItemCallback
 * JD-Core Version:    0.7.0.1
 */
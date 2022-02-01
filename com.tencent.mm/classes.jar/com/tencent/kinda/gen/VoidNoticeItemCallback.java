package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class VoidNoticeItemCallback
{
  public abstract void call(NoticeItem paramNoticeItem);
  
  static final class CppProxy
    extends VoidNoticeItemCallback
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(226912);
      if (!VoidNoticeItemCallback.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(226912);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(226911);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(226911);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(226911);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native void native_call(long paramLong, NoticeItem paramNoticeItem);
    
    public final void call(NoticeItem paramNoticeItem)
    {
      AppMethodBeat.i(226918);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramNoticeItem = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(226918);
        throw paramNoticeItem;
      }
      native_call(this.nativeRef, paramNoticeItem);
      AppMethodBeat.o(226918);
    }
    
    public final void destroy()
    {
      AppMethodBeat.i(226913);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(226913);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(226915);
      destroy();
      super.finalize();
      AppMethodBeat.o(226915);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.gen.VoidNoticeItemCallback
 * JD-Core Version:    0.7.0.1
 */
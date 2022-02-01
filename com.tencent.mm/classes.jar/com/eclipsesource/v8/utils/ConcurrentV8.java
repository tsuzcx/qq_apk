package com.eclipsesource.v8.utils;

import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Locker;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ConcurrentV8
{
  private V8 v8;
  
  public ConcurrentV8()
  {
    AppMethodBeat.i(61654);
    this.v8 = null;
    this.v8 = V8.createV8Runtime();
    this.v8.getLocker().release();
    AppMethodBeat.o(61654);
  }
  
  public final V8 getV8()
  {
    return this.v8;
  }
  
  public final void release()
  {
    AppMethodBeat.i(61656);
    if ((this.v8 != null) && (!this.v8.isReleased())) {
      run(new V8Runnable()
      {
        public void run(V8 paramAnonymousV8)
        {
          AppMethodBeat.i(61653);
          if ((paramAnonymousV8 != null) && (!paramAnonymousV8.isReleased())) {
            paramAnonymousV8.release();
          }
          AppMethodBeat.o(61653);
        }
      });
    }
    AppMethodBeat.o(61656);
  }
  
  public final void run(V8Runnable paramV8Runnable)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(61655);
        try
        {
          this.v8.getLocker().acquire();
          paramV8Runnable.run(this.v8);
          if ((this.v8 != null) && (this.v8.getLocker() != null) && (this.v8.getLocker().hasLock()))
          {
            this.v8.getLocker().release();
            AppMethodBeat.o(61655);
            return;
          }
        }
        finally
        {
          paramV8Runnable = finally;
          if ((this.v8 != null) && (this.v8.getLocker() != null) && (this.v8.getLocker().hasLock())) {
            this.v8.getLocker().release();
          }
          AppMethodBeat.o(61655);
          throw paramV8Runnable;
        }
        AppMethodBeat.o(61655);
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.eclipsesource.v8.utils.ConcurrentV8
 * JD-Core Version:    0.7.0.1
 */
package com.eclipsesource.v8.utils;

import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Locker;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ConcurrentV8
{
  private V8 v8;
  
  public ConcurrentV8()
  {
    AppMethodBeat.i(75030);
    this.v8 = null;
    this.v8 = V8.createV8Runtime();
    this.v8.getLocker().release();
    AppMethodBeat.o(75030);
  }
  
  public final V8 getV8()
  {
    return this.v8;
  }
  
  public final void release()
  {
    AppMethodBeat.i(75032);
    if ((this.v8 != null) && (!this.v8.isReleased())) {
      run(new ConcurrentV8.1(this));
    }
    AppMethodBeat.o(75032);
  }
  
  public final void run(V8Runnable paramV8Runnable)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(75031);
        try
        {
          this.v8.getLocker().acquire();
          paramV8Runnable.run(this.v8);
          if ((this.v8 != null) && (this.v8.getLocker() != null) && (this.v8.getLocker().hasLock()))
          {
            this.v8.getLocker().release();
            AppMethodBeat.o(75031);
            return;
          }
        }
        finally
        {
          paramV8Runnable = finally;
          if ((this.v8 != null) && (this.v8.getLocker() != null) && (this.v8.getLocker().hasLock())) {
            this.v8.getLocker().release();
          }
          AppMethodBeat.o(75031);
          throw paramV8Runnable;
        }
        AppMethodBeat.o(75031);
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.eclipsesource.v8.utils.ConcurrentV8
 * JD-Core Version:    0.7.0.1
 */
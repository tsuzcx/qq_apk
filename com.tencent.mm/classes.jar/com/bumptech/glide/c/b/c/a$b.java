package com.bumptech.glide.c.b.c;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface a$b
{
  public static final b aGY = new b()
  {
    public final void c(Throwable paramAnonymousThrowable) {}
  };
  public static final b aGZ = new b()
  {
    public final void c(Throwable paramAnonymousThrowable)
    {
      AppMethodBeat.i(77173);
      Log.isLoggable("GlideExecutor", 6);
      AppMethodBeat.o(77173);
    }
  };
  public static final b aHa = new b()
  {
    public final void c(Throwable paramAnonymousThrowable)
    {
      AppMethodBeat.i(77174);
      paramAnonymousThrowable = new RuntimeException("Request threw uncaught throwable", paramAnonymousThrowable);
      AppMethodBeat.o(77174);
      throw paramAnonymousThrowable;
    }
  };
  public static final b aHb = aGZ;
  
  public abstract void c(Throwable paramThrowable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.bumptech.glide.c.b.c.a.b
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.exoplayer2.h;

import android.os.Looper;
import android.os.SystemClock;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

public final class t
{
  IOException aRd;
  final ExecutorService aZr;
  t.b<? extends t.c> aZs;
  
  public t(String paramString)
  {
    AppMethodBeat.i(95852);
    this.aZr = x.aN(paramString);
    AppMethodBeat.o(95852);
  }
  
  public final <T extends t.c> long a(T paramT, t.a<T> parama, int paramInt)
  {
    AppMethodBeat.i(95853);
    Looper localLooper = Looper.myLooper();
    if (localLooper != null) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      long l = SystemClock.elapsedRealtime();
      new t.b(this, localLooper, paramT, parama, paramInt, l).start(0L);
      AppMethodBeat.o(95853);
      return l;
    }
  }
  
  public final boolean a(t.d paramd)
  {
    AppMethodBeat.i(95855);
    boolean bool2 = false;
    boolean bool1;
    if (this.aZs != null)
    {
      this.aZs.cancel(true);
      bool1 = bool2;
      if (paramd != null)
      {
        this.aZr.execute(new t.e(paramd));
        bool1 = bool2;
      }
    }
    for (;;)
    {
      this.aZr.shutdown();
      AppMethodBeat.o(95855);
      return bool1;
      bool1 = bool2;
      if (paramd != null)
      {
        paramd.pa();
        bool1 = true;
      }
    }
  }
  
  public final void cancelLoading()
  {
    AppMethodBeat.i(95854);
    this.aZs.cancel(false);
    AppMethodBeat.o(95854);
  }
  
  public final boolean isLoading()
  {
    return this.aZs != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.h.t
 * JD-Core Version:    0.7.0.1
 */
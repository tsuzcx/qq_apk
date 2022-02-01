package com.google.android.exoplayer2.a;

import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b.d;
import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e$a
{
  final e beS;
  final Handler handler;
  
  public e$a(Handler paramHandler, e parame)
  {
    AppMethodBeat.i(91769);
    if (parame != null) {}
    for (paramHandler = (Handler)a.checkNotNull(paramHandler);; paramHandler = null)
    {
      this.handler = paramHandler;
      this.beS = parame;
      AppMethodBeat.o(91769);
      return;
    }
  }
  
  public final void e(final d paramd)
  {
    AppMethodBeat.i(91770);
    if (this.beS != null) {
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(91767);
          e.a.this.beS.d(paramd);
          AppMethodBeat.o(91767);
        }
      });
    }
    AppMethodBeat.o(91770);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.a.e.a
 * JD-Core Version:    0.7.0.1
 */
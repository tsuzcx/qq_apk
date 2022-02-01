package com.tencent.mm.app;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class q$a$1
  implements q
{
  q$a$1(q.a parama) {}
  
  public final void onAppBackground(final String paramString)
  {
    AppMethodBeat.i(131786);
    if (this.hgt.getHandler() != null)
    {
      this.hgt.getHandler().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(131784);
          q.a.1.this.hgt.onAppBackground(paramString);
          AppMethodBeat.o(131784);
        }
      });
      AppMethodBeat.o(131786);
      return;
    }
    this.hgt.onAppBackground(paramString);
    AppMethodBeat.o(131786);
  }
  
  public final void onAppForeground(final String paramString)
  {
    AppMethodBeat.i(131785);
    if (this.hgt.getHandler() != null)
    {
      this.hgt.getHandler().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(131783);
          q.a.1.this.hgt.onAppForeground(paramString);
          AppMethodBeat.o(131783);
        }
      });
      AppMethodBeat.o(131785);
      return;
    }
    this.hgt.onAppForeground(paramString);
    AppMethodBeat.o(131785);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.app.q.a.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.e.e.a;

import android.os.Handler;
import com.tencent.e.e.a.a.c;
import com.tencent.e.e.a.a.f;
import com.tencent.e.e.a.a.g;
import com.tencent.e.e.a.a.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e$2
  extends c
{
  e$2(e parame) {}
  
  public final void dUF()
  {
    AppMethodBeat.i(114536);
    synchronized (this.BkG)
    {
      if (!e.c(this.BkG))
      {
        AppMethodBeat.o(114536);
        return;
      }
      if (e.g(this.BkG) == null)
      {
        AppMethodBeat.o(114536);
        return;
      }
      if (e.g(this.BkG).oX(e.a(this.BkG).Bkx))
      {
        long l = e.g(this.BkG).BkW.dUK();
        e.a locala = e.d(this.BkG);
        int i = (int)(e.a(this.BkG).Bkx / f.BkP);
        locala.mCount = 1;
        locala.mMaxCount = i;
        locala.BkM = l;
        l = l + f.BkP - System.currentTimeMillis();
        if (l > 0L) {
          e.e(this.BkG).postDelayed(e.d(this.BkG), l);
        }
      }
      else
      {
        AppMethodBeat.o(114536);
        return;
      }
      e.e(this.BkG).post(e.d(this.BkG));
    }
  }
  
  public final void dUG()
  {
    AppMethodBeat.i(114537);
    if (e.f(this.BkG) != null) {
      e.f(this.BkG);
    }
    AppMethodBeat.o(114537);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.e.e.a.e.2
 * JD-Core Version:    0.7.0.1
 */
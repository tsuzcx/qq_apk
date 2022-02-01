package com.tencent.mm.plugin.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.sdk.platformtools.aq;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

public final class b
  extends a
  implements Runnable
{
  private int errorCode;
  private j tCm;
  private WeakReference<l> tCn;
  
  public b(int paramInt, j paramj)
  {
    AppMethodBeat.i(52500);
    this.errorCode = paramInt;
    this.tCm = paramj;
    this.tCn = new WeakReference(paramj.tGa);
    this.tCm.tGa = null;
    AppMethodBeat.o(52500);
  }
  
  public final boolean execute()
  {
    AppMethodBeat.i(52501);
    final k localk;
    if ((this.errorCode == -2) || (this.errorCode == -3))
    {
      localk = new k(this.tCm);
      localk.tGb = this;
      localk.bZU = this.errorCode;
      localk.tGc = new LinkedList();
      localk.tFe = h.bq(this.tCm.query, false);
      if (this.tCm.handler != null) {
        break label113;
      }
      l locall = (l)this.tCn.get();
      if (locall != null) {
        locall.b(localk);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(52501);
      return true;
      label113:
      this.tCm.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(52499);
          l locall = (l)b.a(b.this).get();
          if (locall != null) {
            locall.b(localk);
          }
          AppMethodBeat.o(52499);
        }
      });
    }
  }
  
  public final int getId()
  {
    return -1;
  }
  
  public final int getPriority()
  {
    return 0;
  }
  
  public final boolean isCancelled()
  {
    return false;
  }
  
  public final void run()
  {
    AppMethodBeat.i(52502);
    try
    {
      execute();
      AppMethodBeat.o(52502);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(52502);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b
 * JD-Core Version:    0.7.0.1
 */
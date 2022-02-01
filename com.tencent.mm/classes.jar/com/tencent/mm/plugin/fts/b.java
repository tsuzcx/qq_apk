package com.tencent.mm.plugin.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

public final class b
  extends a
  implements Runnable
{
  private j BFk;
  private WeakReference<l> BFl;
  private int errorCode;
  
  public b(j paramj)
  {
    AppMethodBeat.i(255039);
    this.errorCode = -2;
    this.BFk = paramj;
    this.BFl = new WeakReference(paramj.BIU);
    this.BFk.BIU = null;
    AppMethodBeat.o(255039);
  }
  
  public final boolean aEv()
  {
    AppMethodBeat.i(52501);
    final k localk;
    if ((this.errorCode == -2) || (this.errorCode == -3))
    {
      localk = new k(this.BFk);
      localk.BIV = this;
      localk.resultCode = this.errorCode;
      localk.BIW = new LinkedList();
      localk.BHY = h.bJ(this.BFk.query, false);
      if (this.BFk.handler != null) {
        break label113;
      }
      l locall = (l)this.BFl.get();
      if (locall != null) {
        locall.b(localk);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(52501);
      return true;
      label113:
      this.BFk.handler.post(new Runnable()
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
      aEv();
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
package com.tencent.mm.plugin.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.sdk.platformtools.ap;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

public final class b
  extends a
  implements Runnable
{
  private int errorCode;
  private j trv;
  private WeakReference<l> trw;
  
  public b(int paramInt, j paramj)
  {
    AppMethodBeat.i(52500);
    this.errorCode = paramInt;
    this.trv = paramj;
    this.trw = new WeakReference(paramj.tvj);
    this.trv.tvj = null;
    AppMethodBeat.o(52500);
  }
  
  public final boolean execute()
  {
    AppMethodBeat.i(52501);
    final k localk;
    if ((this.errorCode == -2) || (this.errorCode == -3))
    {
      localk = new k(this.trv);
      localk.tvk = this;
      localk.bZU = this.errorCode;
      localk.tvl = new LinkedList();
      localk.tun = h.bn(this.trv.query, false);
      if (this.trv.handler != null) {
        break label113;
      }
      l locall = (l)this.trw.get();
      if (locall != null) {
        locall.b(localk);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(52501);
      return true;
      label113:
      this.trv.handler.post(new Runnable()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b
 * JD-Core Version:    0.7.0.1
 */
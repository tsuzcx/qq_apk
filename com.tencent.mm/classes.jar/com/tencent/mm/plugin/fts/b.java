package com.tencent.mm.plugin.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

public final class b
  extends c
  implements Runnable
{
  private com.tencent.mm.plugin.fts.a.a.l HpM;
  private WeakReference<com.tencent.mm.plugin.fts.a.l> HpN;
  private int errorCode;
  
  public b(com.tencent.mm.plugin.fts.a.a.l paraml)
  {
    AppMethodBeat.i(265399);
    this.errorCode = -2;
    this.HpM = paraml;
    this.HpN = new WeakReference(paraml.HtC);
    this.HpM.HtC = null;
    AppMethodBeat.o(265399);
  }
  
  public final boolean aXz()
  {
    AppMethodBeat.i(52501);
    final m localm;
    if ((this.errorCode == -2) || (this.errorCode == -3))
    {
      localm = new m(this.HpM);
      localm.HtE = this;
      localm.resultCode = this.errorCode;
      localm.HtF = new LinkedList();
      localm.FWt = j.cc(this.HpM.query, false);
      if (this.HpM.handler != null) {
        break label113;
      }
      com.tencent.mm.plugin.fts.a.l locall = (com.tencent.mm.plugin.fts.a.l)this.HpN.get();
      if (locall != null) {
        locall.b(localm);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(52501);
      return true;
      label113:
      this.HpM.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(52499);
          com.tencent.mm.plugin.fts.a.l locall = (com.tencent.mm.plugin.fts.a.l)b.a(b.this).get();
          if (locall != null) {
            locall.b(localm);
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
      aXz();
      AppMethodBeat.o(52502);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(52502);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b
 * JD-Core Version:    0.7.0.1
 */
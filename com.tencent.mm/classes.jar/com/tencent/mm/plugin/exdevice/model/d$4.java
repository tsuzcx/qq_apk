package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.service.c.a;

final class d$4
  extends c.a
{
  d$4(d paramd, Runnable paramRunnable)
  {
    super(0);
  }
  
  public final void onServiceConnected()
  {
    AppMethodBeat.i(19100);
    this.val$run.run();
    AppMethodBeat.o(19100);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.d.4
 * JD-Core Version:    0.7.0.1
 */
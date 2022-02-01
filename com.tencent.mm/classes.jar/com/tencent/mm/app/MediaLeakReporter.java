package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.oj;
import com.tencent.mm.sdk.event.IListener;

public class MediaLeakReporter
  extends IListener<oj>
{
  private static boolean hhn = false;
  private int hho;
  private int hhp;
  
  public MediaLeakReporter(int paramInt1, int paramInt2)
  {
    super(f.hfK);
    AppMethodBeat.i(161231);
    this.hho = paramInt1;
    this.hhp = paramInt2;
    this.__eventId = oj.class.getName().hashCode();
    AppMethodBeat.o(161231);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.app.MediaLeakReporter
 * JD-Core Version:    0.7.0.1
 */
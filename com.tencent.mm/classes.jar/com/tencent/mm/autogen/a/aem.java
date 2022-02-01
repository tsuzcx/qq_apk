package com.tencent.mm.autogen.a;

import com.tencent.mars.cdn.CdnLogic.C2CDownloadResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aem
  extends IEvent
{
  public a ijd;
  
  public aem()
  {
    this((byte)0);
  }
  
  private aem(byte paramByte)
  {
    AppMethodBeat.i(369384);
    this.ijd = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(369384);
  }
  
  public static final class a
  {
    public int event = 0;
    public CdnLogic.C2CDownloadResult ije;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.a.aem
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class pn
  extends IEvent
{
  public a fOh;
  
  public pn()
  {
    this((byte)0);
  }
  
  private pn(byte paramByte)
  {
    AppMethodBeat.i(126680);
    this.fOh = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(126680);
  }
  
  public static final class a
  {
    public int fDn;
    public long fOi;
    public boolean fOj = false;
    public int length;
    public String mediaId;
    public int offset;
    public int retCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.pn
 * JD-Core Version:    0.7.0.1
 */
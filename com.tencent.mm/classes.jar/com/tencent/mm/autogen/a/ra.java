package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ra
  extends IEvent
{
  public a hTZ;
  
  public ra()
  {
    this((byte)0);
  }
  
  private ra(byte paramByte)
  {
    AppMethodBeat.i(126680);
    this.hTZ = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(126680);
  }
  
  public static final class a
  {
    public int hId;
    public long hUa;
    public boolean hUb = false;
    public int length;
    public String mediaId;
    public int offset;
    public int retCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.a.ra
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class abe
  extends IEvent
{
  public a ieP;
  
  public abe()
  {
    this((byte)0);
  }
  
  private abe(byte paramByte)
  {
    AppMethodBeat.i(116055);
    this.ieP = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116055);
  }
  
  public static final class a
  {
    public String icx;
    public String id;
    public String ieH;
    public byte[] ieJ;
    public String ieQ;
    public int ieR = 0;
    public int ret;
    public String source;
    public int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.a.abe
 * JD-Core Version:    0.7.0.1
 */
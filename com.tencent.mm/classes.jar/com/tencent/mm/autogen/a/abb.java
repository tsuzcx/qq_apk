package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class abb
  extends IEvent
{
  public a ieG;
  
  public abb()
  {
    this((byte)0);
  }
  
  private abb(byte paramByte)
  {
    AppMethodBeat.i(116052);
    this.ieG = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116052);
  }
  
  public static final class a
  {
    public String id;
    public String ieH;
    public boolean ieI;
    public byte[] ieJ;
    public String source;
    public int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.abb
 * JD-Core Version:    0.7.0.1
 */
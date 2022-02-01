package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class pw
  extends IEvent
{
  public a dVW;
  
  public pw()
  {
    this((byte)0);
  }
  
  private pw(byte paramByte)
  {
    AppMethodBeat.i(168630);
    this.dVW = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(168630);
  }
  
  public static final class a
  {
    public boolean dVX;
    public String dVY;
    public String mediaId;
    public int process;
    public int size;
    public int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.pw
 * JD-Core Version:    0.7.0.1
 */
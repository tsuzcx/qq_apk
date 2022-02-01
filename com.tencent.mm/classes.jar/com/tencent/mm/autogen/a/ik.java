package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ik
  extends IEvent
{
  public a hJT;
  
  public ik()
  {
    this((byte)0);
  }
  
  private ik(byte paramByte)
  {
    AppMethodBeat.i(369411);
    this.hJT = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(369411);
  }
  
  public static final class a
  {
    public Long hJU;
    public int position;
    public int type;
    public String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.autogen.a.ik
 * JD-Core Version:    0.7.0.1
 */
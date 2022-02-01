package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class dy
  extends IEvent
{
  public a hDO;
  
  public dy()
  {
    this((byte)0);
  }
  
  private dy(byte paramByte)
  {
    AppMethodBeat.i(104412);
    this.hDO = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(104412);
  }
  
  public static final class a
  {
    public int state = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.a.dy
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class zj
  extends IEvent
{
  public a icz;
  
  public zj()
  {
    this((byte)0);
  }
  
  private zj(byte paramByte)
  {
    AppMethodBeat.i(125648);
    this.icz = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125648);
  }
  
  public static final class a
  {
    public String id;
    public int type = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.a.zj
 * JD-Core Version:    0.7.0.1
 */
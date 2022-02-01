package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class zk
  extends IEvent
{
  public a icA;
  
  public zk()
  {
    this((byte)0);
  }
  
  private zk(byte paramByte)
  {
    AppMethodBeat.i(125649);
    this.icA = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125649);
  }
  
  public static final class a
  {
    public String id;
    public int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.a.zk
 * JD-Core Version:    0.7.0.1
 */
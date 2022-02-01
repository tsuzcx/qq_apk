package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class abi
  extends IEvent
{
  public a ieT;
  
  public abi()
  {
    this((byte)0);
  }
  
  private abi(byte paramByte)
  {
    AppMethodBeat.i(140992);
    this.ieT = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(140992);
  }
  
  public static final class a
  {
    public int ieU = 0;
    public int ieV = 0;
    public int ieW = 0;
    public int type = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.abi
 * JD-Core Version:    0.7.0.1
 */
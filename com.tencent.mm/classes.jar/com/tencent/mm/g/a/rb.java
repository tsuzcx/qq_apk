package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class rb
  extends IEvent
{
  public a dXE;
  
  public rb()
  {
    this((byte)0);
  }
  
  private rb(byte paramByte)
  {
    AppMethodBeat.i(215177);
    this.dXE = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(215177);
  }
  
  public static final class a
  {
    public boolean dQA = false;
    public String errMsg;
    public long msgId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.rb
 * JD-Core Version:    0.7.0.1
 */
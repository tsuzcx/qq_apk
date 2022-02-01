package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class qq
  extends IEvent
{
  public a dXe;
  
  public qq()
  {
    this((byte)0);
  }
  
  private qq(byte paramByte)
  {
    AppMethodBeat.i(91213);
    this.dXe = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91213);
  }
  
  public static final class a
  {
    public String content;
    public String dRL;
    public String dXf;
    public String toUser;
    public int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.qq
 * JD-Core Version:    0.7.0.1
 */
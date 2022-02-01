package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.util.LinkedList;

public final class wh
  extends IEvent
{
  public a ecr;
  
  public wh()
  {
    this((byte)0);
  }
  
  private wh(byte paramByte)
  {
    AppMethodBeat.i(125646);
    this.ecr = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125646);
  }
  
  public static final class a
  {
    public LinkedList<Long> ecs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.wh
 * JD-Core Version:    0.7.0.1
 */
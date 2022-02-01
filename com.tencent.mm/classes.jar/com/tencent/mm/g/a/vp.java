package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class vp
  extends IEvent
{
  public a ebM;
  
  public vp()
  {
    this((byte)0);
  }
  
  private vp(byte paramByte)
  {
    AppMethodBeat.i(125639);
    this.ebM = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125639);
  }
  
  public static final class a
  {
    public String dHp;
    public String dRS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.vp
 * JD-Core Version:    0.7.0.1
 */
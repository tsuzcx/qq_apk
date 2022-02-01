package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.sdk.event.IEvent;

public final class ug
  extends IEvent
{
  public a hXY;
  
  public ug()
  {
    this((byte)0);
  }
  
  private ug(byte paramByte)
  {
    AppMethodBeat.i(125626);
    this.hXY = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125626);
  }
  
  public static final class a
  {
    public SnsAdClick hXZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.ug
 * JD-Core Version:    0.7.0.1
 */
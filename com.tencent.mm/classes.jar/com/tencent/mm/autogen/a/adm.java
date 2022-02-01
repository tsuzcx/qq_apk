package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class adm
  extends IEvent
{
  public a ihG;
  
  public adm()
  {
    this((byte)0);
  }
  
  private adm(byte paramByte)
  {
    AppMethodBeat.i(91233);
    this.ihG = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91233);
  }
  
  public static final class a
  {
    public int result;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.adm
 * JD-Core Version:    0.7.0.1
 */
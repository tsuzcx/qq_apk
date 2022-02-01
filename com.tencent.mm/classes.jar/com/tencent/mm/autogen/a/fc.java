package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class fc
  extends IEvent
{
  public a hFt;
  
  public fc()
  {
    this((byte)0);
  }
  
  private fc(byte paramByte)
  {
    AppMethodBeat.i(115994);
    this.hFt = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(115994);
  }
  
  public static final class a
  {
    public byte[] data;
    public String hEl;
    public String hEy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.fc
 * JD-Core Version:    0.7.0.1
 */
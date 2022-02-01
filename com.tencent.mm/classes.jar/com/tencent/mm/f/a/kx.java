package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class kx
  extends IEvent
{
  public a fIz;
  
  public kx()
  {
    this((byte)0);
  }
  
  private kx(byte paramByte)
  {
    AppMethodBeat.i(215482);
    this.fIz = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(215482);
  }
  
  public static final class a
  {
    public int fIA;
    public int fIB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.kx
 * JD-Core Version:    0.7.0.1
 */
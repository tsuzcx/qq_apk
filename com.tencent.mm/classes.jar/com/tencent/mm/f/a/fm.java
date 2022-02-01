package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class fm
  extends IEvent
{
  public a fBt;
  
  public fm()
  {
    this((byte)0);
  }
  
  private fm(byte paramByte)
  {
    AppMethodBeat.i(19798);
    this.fBt = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19798);
  }
  
  public static final class a
  {
    public byte[] data;
    public String mac;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.a.fm
 * JD-Core Version:    0.7.0.1
 */
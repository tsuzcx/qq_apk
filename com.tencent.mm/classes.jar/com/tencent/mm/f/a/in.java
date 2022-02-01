package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bje;
import com.tencent.mm.sdk.event.IEvent;

public final class in
  extends IEvent
{
  public a fFH;
  
  public in()
  {
    this((byte)0);
  }
  
  private in(byte paramByte)
  {
    AppMethodBeat.i(209125);
    this.fFH = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(209125);
  }
  
  public static final class a
  {
    public boolean fFI;
    public bje fFJ;
    public long localId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.in
 * JD-Core Version:    0.7.0.1
 */
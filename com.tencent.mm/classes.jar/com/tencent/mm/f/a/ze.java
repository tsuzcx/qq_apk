package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.esk;
import com.tencent.mm.sdk.event.IEvent;

public final class ze
  extends IEvent
{
  public a fYx;
  public b fYy;
  
  public ze()
  {
    this((byte)0);
  }
  
  private ze(byte paramByte)
  {
    AppMethodBeat.i(152988);
    this.fYx = new a();
    this.fYy = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(152988);
  }
  
  public static final class a
  {
    public int actionType;
  }
  
  public static final class b
  {
    public esk fYA;
    public boolean fYz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.ze
 * JD-Core Version:    0.7.0.1
 */
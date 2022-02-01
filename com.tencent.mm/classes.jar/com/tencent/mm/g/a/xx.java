package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.eii;
import com.tencent.mm.sdk.event.IEvent;

public final class xx
  extends IEvent
{
  public a eei;
  public b eej;
  
  public xx()
  {
    this((byte)0);
  }
  
  private xx(byte paramByte)
  {
    AppMethodBeat.i(152988);
    this.eei = new a();
    this.eej = new b();
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
    public boolean eek;
    public eii eel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.a.xx
 * JD-Core Version:    0.7.0.1
 */
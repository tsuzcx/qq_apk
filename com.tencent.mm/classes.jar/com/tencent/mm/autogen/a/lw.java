package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.sdk.event.IEvent;

public final class lw
  extends IEvent
{
  public a hNL;
  public b hNM;
  
  public lw()
  {
    this((byte)0);
  }
  
  private lw(byte paramByte)
  {
    AppMethodBeat.i(125618);
    this.hNL = new a();
    this.hNM = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125618);
  }
  
  public static final class a
  {
    public int hGM;
  }
  
  public static final class b
  {
    public SnsObject hNN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.lw
 * JD-Core Version:    0.7.0.1
 */
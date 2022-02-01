package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.fnt;
import com.tencent.mm.sdk.event.IEvent;

public final class aay
  extends IEvent
{
  public b ieA;
  public a iez;
  
  public aay()
  {
    this((byte)0);
  }
  
  private aay(byte paramByte)
  {
    AppMethodBeat.i(152988);
    this.iez = new a();
    this.ieA = new b();
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
    public boolean ieB;
    public fnt ieC;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.aay
 * JD-Core Version:    0.7.0.1
 */
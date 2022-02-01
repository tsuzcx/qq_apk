package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.sdk.event.IEvent;

public final class rw
  extends IEvent
{
  public a fRa;
  public b fRb;
  
  public rw()
  {
    this((byte)0);
  }
  
  private rw(byte paramByte)
  {
    AppMethodBeat.i(125624);
    this.fRa = new a();
    this.fRb = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125624);
  }
  
  public static final class a
  {
    public String username;
  }
  
  public static final class b
  {
    public cvt fRc;
    public cvt fRd;
    public cvt fRe;
    public cvt fRf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.rw
 * JD-Core Version:    0.7.0.1
 */
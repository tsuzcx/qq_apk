package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.sdk.event.IEvent;

public final class ks
  extends IEvent
{
  public a fIl;
  public b fIm;
  
  public ks()
  {
    this((byte)0);
  }
  
  private ks(byte paramByte)
  {
    AppMethodBeat.i(125618);
    this.fIl = new a();
    this.fIm = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125618);
  }
  
  public static final class a
  {
    public int fBX;
  }
  
  public static final class b
  {
    public SnsObject fIn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.ks
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dom;
import com.tencent.mm.sdk.b.b;

public final class ww
  extends b
{
  public a dMq;
  public b dMr;
  
  public ww()
  {
    this((byte)0);
  }
  
  private ww(byte paramByte)
  {
    AppMethodBeat.i(152988);
    this.dMq = new a();
    this.dMr = new b();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(152988);
  }
  
  public static final class a
  {
    public int actionType;
  }
  
  public static final class b
  {
    public boolean dMs;
    public dom dMt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.a.ww
 * JD-Core Version:    0.7.0.1
 */
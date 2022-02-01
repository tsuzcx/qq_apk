package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.event.IEvent;

public final class qw
  extends IEvent
{
  public a dXo;
  public b dXp;
  
  public qw()
  {
    this((byte)0);
  }
  
  private qw(byte paramByte)
  {
    AppMethodBeat.i(125624);
    this.dXo = new a();
    this.dXp = new b();
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
    public cnb dXq;
    public cnb dXr;
    public cnb dXs;
    public cnb dXt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.qw
 * JD-Core Version:    0.7.0.1
 */
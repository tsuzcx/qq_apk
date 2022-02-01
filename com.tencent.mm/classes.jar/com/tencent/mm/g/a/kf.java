package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.event.IEvent;

public final class kf
  extends IEvent
{
  public a dPf;
  public b dPg;
  
  public kf()
  {
    this((byte)0);
  }
  
  private kf(byte paramByte)
  {
    AppMethodBeat.i(125621);
    this.dPf = new a();
    this.dPg = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125621);
  }
  
  public static final class a
  {
    public String dHp;
  }
  
  public static final class b
  {
    public TimeLineObject dPh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.kf
 * JD-Core Version:    0.7.0.1
 */
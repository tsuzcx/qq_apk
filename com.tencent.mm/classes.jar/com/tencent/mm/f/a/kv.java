package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.event.IEvent;

public final class kv
  extends IEvent
{
  public a fIq;
  public b fIr;
  
  public kv()
  {
    this((byte)0);
  }
  
  private kv(byte paramByte)
  {
    AppMethodBeat.i(125621);
    this.fIq = new a();
    this.fIr = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125621);
  }
  
  public static final class a
  {
    public String fAg;
  }
  
  public static final class b
  {
    public TimeLineObject fIs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.kv
 * JD-Core Version:    0.7.0.1
 */
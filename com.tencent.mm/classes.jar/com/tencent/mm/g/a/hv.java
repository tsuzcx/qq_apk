package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.azt;
import com.tencent.mm.sdk.event.IEvent;

public final class hv
  extends IEvent
{
  public a dMr;
  
  public hv()
  {
    this((byte)0);
  }
  
  private hv(byte paramByte)
  {
    AppMethodBeat.i(168882);
    this.dMr = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(168882);
  }
  
  public static final class a
  {
    public azt dMs;
    public int dMt = -1;
    public long dMu = 0L;
    public long dMv = 0L;
    public int dMw = -1;
    public long feedId;
    public int friendLikeCount = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.hv
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bfw;
import com.tencent.mm.sdk.event.IEvent;

public final class ig
  extends IEvent
{
  public a fFp;
  
  public ig()
  {
    this((byte)0);
  }
  
  private ig(byte paramByte)
  {
    AppMethodBeat.i(168882);
    this.fFp = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(168882);
  }
  
  public static final class a
  {
    public bfw fFq;
    public int fFr = -1;
    public long fFs = 0L;
    public long fFt = 0L;
    public int fFu = -1;
    public long feedId;
    public int friendLikeCount = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.ig
 * JD-Core Version:    0.7.0.1
 */
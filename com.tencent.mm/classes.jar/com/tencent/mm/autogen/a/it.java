package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.brh;
import com.tencent.mm.sdk.event.IEvent;

public final class it
  extends IEvent
{
  public a hKk;
  
  public it()
  {
    this((byte)0);
  }
  
  private it(byte paramByte)
  {
    AppMethodBeat.i(168882);
    this.hKk = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(168882);
  }
  
  public static final class a
  {
    public long feedId;
    public int friendLikeCount = -1;
    public brh hKl;
    public int hKm = -1;
    public long hKn = 0L;
    public long hKo = 0L;
    public int hKp = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.autogen.a.it
 * JD-Core Version:    0.7.0.1
 */
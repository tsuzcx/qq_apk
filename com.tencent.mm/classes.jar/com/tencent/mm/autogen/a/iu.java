package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class iu
  extends IEvent
{
  public a hKq;
  
  public iu()
  {
    this((byte)0);
  }
  
  private iu(byte paramByte)
  {
    AppMethodBeat.i(369417);
    this.hKq = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(369417);
  }
  
  public static final class a
  {
    public int actionType;
    public long feedId;
    public int hKr;
    public int hKs;
    public int hKt;
    public int hKu;
    public int position;
    public String url;
    public int videoDuration;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.autogen.a.iu
 * JD-Core Version:    0.7.0.1
 */
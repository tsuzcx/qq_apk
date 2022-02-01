package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ih
  extends IEvent
{
  public a fFv;
  
  public ih()
  {
    this((byte)0);
  }
  
  private ih(byte paramByte)
  {
    AppMethodBeat.i(281573);
    this.fFv = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(281573);
  }
  
  public static final class a
  {
    public int actionType;
    public int fFw;
    public int fFx;
    public int fFy;
    public long feedId;
    public int position;
    public int videoDuration;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.ih
 * JD-Core Version:    0.7.0.1
 */
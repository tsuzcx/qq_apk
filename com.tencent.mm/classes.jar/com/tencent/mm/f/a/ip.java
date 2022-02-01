package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ip
  extends IEvent
{
  public a fFK;
  
  public ip()
  {
    this((byte)0);
  }
  
  private ip(byte paramByte)
  {
    AppMethodBeat.i(261364);
    this.fFK = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(261364);
  }
  
  public static final class a
  {
    public int fFL;
    public int fFM;
    public long feedId;
    public String mediaId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.a.ip
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class zd
  extends IEvent
{
  public a icq;
  
  public zd()
  {
    this((byte)0);
  }
  
  private zd(byte paramByte)
  {
    AppMethodBeat.i(131794);
    this.icq = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(131794);
  }
  
  public static final class a
  {
    public int sourceType = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.zd
 * JD-Core Version:    0.7.0.1
 */
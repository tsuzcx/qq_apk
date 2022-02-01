package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class sh
  extends IEvent
{
  public a hVu;
  
  public sh()
  {
    this((byte)0);
  }
  
  private sh(byte paramByte)
  {
    AppMethodBeat.i(117615);
    this.hVu = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(117615);
  }
  
  public static final class a
  {
    public int scene;
    public String sessionId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.sh
 * JD-Core Version:    0.7.0.1
 */
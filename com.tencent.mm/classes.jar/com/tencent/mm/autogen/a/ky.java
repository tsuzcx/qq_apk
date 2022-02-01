package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ky
  extends IEvent
{
  public a hMG;
  public b hMH;
  
  public ky()
  {
    this((byte)0);
  }
  
  private ky(byte paramByte)
  {
    AppMethodBeat.i(123477);
    this.hMG = new a();
    this.hMH = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(123477);
  }
  
  public static final class a
  {
    public String url;
  }
  
  public static final class b
  {
    public String appid;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.ky
 * JD-Core Version:    0.7.0.1
 */
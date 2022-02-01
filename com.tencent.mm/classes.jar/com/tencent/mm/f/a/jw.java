package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class jw
  extends IEvent
{
  public a fHj;
  public b fHk;
  
  public jw()
  {
    this((byte)0);
  }
  
  private jw(byte paramByte)
  {
    AppMethodBeat.i(123477);
    this.fHj = new a();
    this.fHk = new b();
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
 * Qualified Name:     com.tencent.mm.f.a.jw
 * JD-Core Version:    0.7.0.1
 */
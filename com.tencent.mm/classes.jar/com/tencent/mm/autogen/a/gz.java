package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class gz
  extends IEvent
{
  public a hHG;
  public b hHH;
  
  public gz()
  {
    this((byte)0);
  }
  
  private gz(byte paramByte)
  {
    AppMethodBeat.i(116025);
    this.hHG = new a();
    this.hHH = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116025);
  }
  
  public static final class a
  {
    public long msgId;
  }
  
  public static final class b
  {
    public String fileName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.gz
 * JD-Core Version:    0.7.0.1
 */
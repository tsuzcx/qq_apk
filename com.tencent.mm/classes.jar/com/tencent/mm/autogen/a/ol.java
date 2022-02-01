package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ol
  extends IEvent
{
  public a hRf;
  public b hRg;
  
  public ol()
  {
    this((byte)0);
  }
  
  private ol(byte paramByte)
  {
    AppMethodBeat.i(149871);
    this.hRf = new a();
    this.hRg = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149871);
  }
  
  public static final class a
  {
    public int action;
    public String filePath;
    public int hRh;
  }
  
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.a.ol
 * JD-Core Version:    0.7.0.1
 */
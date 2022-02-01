package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class em
  extends IEvent
{
  public a hEt;
  public b hEu;
  
  public em()
  {
    this((byte)0);
  }
  
  private em(byte paramByte)
  {
    AppMethodBeat.i(115979);
    this.hEt = new a();
    this.hEu = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(115979);
  }
  
  public static final class a
  {
    public String hEl;
    public String hEr;
  }
  
  public static final class b
  {
    public boolean hEv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.autogen.a.em
 * JD-Core Version:    0.7.0.1
 */
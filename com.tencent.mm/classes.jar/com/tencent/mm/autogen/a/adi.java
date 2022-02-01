package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class adi
  extends IEvent
{
  public a ihs;
  public b iht;
  
  public adi()
  {
    this((byte)0);
  }
  
  private adi(byte paramByte)
  {
    AppMethodBeat.i(91231);
    this.ihs = new a();
    this.iht = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91231);
  }
  
  public static final class a
  {
    public String ihu;
  }
  
  public static final class b
  {
    public int status = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.adi
 * JD-Core Version:    0.7.0.1
 */
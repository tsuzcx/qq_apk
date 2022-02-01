package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class abd
  extends IEvent
{
  public a ieM;
  public b ieN;
  
  public abd()
  {
    this((byte)0);
  }
  
  private abd(byte paramByte)
  {
    AppMethodBeat.i(116054);
    this.ieM = new a();
    this.ieN = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116054);
  }
  
  public static final class a
  {
    public String id;
  }
  
  public static final class b
  {
    public boolean ieO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.abd
 * JD-Core Version:    0.7.0.1
 */
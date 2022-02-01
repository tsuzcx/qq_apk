package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ga
  extends IEvent
{
  public a hGm;
  public b hGn;
  
  public ga()
  {
    this((byte)0);
  }
  
  private ga(byte paramByte)
  {
    AppMethodBeat.i(19801);
    this.hGm = new a();
    this.hGn = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19801);
  }
  
  public static final class a
  {
    public byte[] data;
    public String mac;
  }
  
  public static final class b
  {
    public boolean hEn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.autogen.a.ga
 * JD-Core Version:    0.7.0.1
 */
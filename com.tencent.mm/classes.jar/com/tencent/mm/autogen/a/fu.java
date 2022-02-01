package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class fu
  extends IEvent
{
  public a hGb;
  public b hGc;
  
  public fu()
  {
    this((byte)0);
  }
  
  private fu(byte paramByte)
  {
    AppMethodBeat.i(19795);
    this.hGb = new a();
    this.hGc = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19795);
  }
  
  public static final class a
  {
    public String hGd;
    public long hGe;
    public String mac;
  }
  
  public static final class b
  {
    public boolean hEn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.autogen.a.fu
 * JD-Core Version:    0.7.0.1
 */
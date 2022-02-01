package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class gb
  extends IEvent
{
  public a hGo;
  public b hGp;
  
  public gb()
  {
    this((byte)0);
  }
  
  private gb(byte paramByte)
  {
    AppMethodBeat.i(19802);
    this.hGo = new a();
    this.hGp = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19802);
  }
  
  public static final class a
  {
    public byte[] data;
    public String hEy;
    public String mac;
  }
  
  public static final class b
  {
    public boolean hEn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.autogen.a.gb
 * JD-Core Version:    0.7.0.1
 */
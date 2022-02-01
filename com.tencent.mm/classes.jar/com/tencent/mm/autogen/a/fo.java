package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class fo
  extends IEvent
{
  public a hFL;
  public b hFM;
  
  public fo()
  {
    this((byte)0);
  }
  
  private fo(byte paramByte)
  {
    AppMethodBeat.i(116006);
    this.hFL = new a();
    this.hFM = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116006);
  }
  
  public static final class a
  {
    public byte[] data;
    public String hEl;
    public String hEy;
  }
  
  public static final class b
  {
    public boolean hEn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.fo
 * JD-Core Version:    0.7.0.1
 */
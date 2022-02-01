package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class nv
  extends IEvent
{
  public a hQr;
  
  public nv()
  {
    this((byte)0);
  }
  
  private nv(byte paramByte)
  {
    AppMethodBeat.i(149869);
    this.hQr = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149869);
  }
  
  public static final class a
  {
    public String filePath;
    public int hCh;
    public boolean hCj = false;
    public int subType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.autogen.a.nv
 * JD-Core Version:    0.7.0.1
 */
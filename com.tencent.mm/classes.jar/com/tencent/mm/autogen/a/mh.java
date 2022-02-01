package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class mh
  extends IEvent
{
  public a hOs;
  
  public mh()
  {
    this((byte)0);
  }
  
  private mh(byte paramByte)
  {
    AppMethodBeat.i(369359);
    this.hOs = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(369359);
  }
  
  public static final class a
  {
    public int hOt;
    public long hOu;
    public int hOv;
    public float latitude;
    public float longitude;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.a.mh
 * JD-Core Version:    0.7.0.1
 */
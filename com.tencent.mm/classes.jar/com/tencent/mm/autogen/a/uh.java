package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.sdk.event.IEvent;

public final class uh
  extends IEvent
{
  public a hYa;
  
  public uh()
  {
    this((byte)0);
  }
  
  private uh(byte paramByte)
  {
    AppMethodBeat.i(125627);
    this.hYa = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125627);
  }
  
  public static final class a
  {
    public int errorCode;
    public SnsAdClick hXZ;
    public int hYb;
    public long timestamp;
    public String url;
    public String uxInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.uh
 * JD-Core Version:    0.7.0.1
 */
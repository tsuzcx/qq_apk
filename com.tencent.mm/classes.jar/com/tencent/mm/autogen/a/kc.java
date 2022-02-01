package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class kc
  extends IEvent
{
  public a hLL;
  
  public kc()
  {
    this((byte)0);
  }
  
  private kc(byte paramByte)
  {
    AppMethodBeat.i(140986);
    this.hLL = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(140986);
  }
  
  public static final class a
  {
    public float hLM = 0.0F;
    public float hLN = 0.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.kc
 * JD-Core Version:    0.7.0.1
 */
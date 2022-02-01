package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ek
  extends IEvent
{
  public a dHP;
  
  public ek()
  {
    this((byte)0);
  }
  
  private ek(byte paramByte)
  {
    AppMethodBeat.i(115994);
    this.dHP = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(115994);
  }
  
  public static final class a
  {
    public String brandName;
    public String dGL;
    public byte[] data;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.a.ek
 * JD-Core Version:    0.7.0.1
 */
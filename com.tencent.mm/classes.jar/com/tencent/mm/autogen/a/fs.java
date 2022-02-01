package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class fs
  extends IEvent
{
  public a hFY;
  public b hFZ;
  
  public fs()
  {
    this((byte)0);
  }
  
  private fs(byte paramByte)
  {
    AppMethodBeat.i(116010);
    this.hFY = new a();
    this.hFZ = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116010);
  }
  
  public static final class a
  {
    public boolean clear;
    public int direction;
    public String hEl;
  }
  
  public static final class b
  {
    public boolean hEn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.fs
 * JD-Core Version:    0.7.0.1
 */
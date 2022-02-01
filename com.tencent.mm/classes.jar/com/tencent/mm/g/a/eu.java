package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class eu
  extends IEvent
{
  public a dIc;
  public b dId;
  
  public eu()
  {
    this((byte)0);
  }
  
  private eu(byte paramByte)
  {
    AppMethodBeat.i(116004);
    this.dIc = new a();
    this.dId = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116004);
  }
  
  public static final class a
  {
    public String brandName;
    public boolean dGW = false;
    public int dIe = -1;
  }
  
  public static final class b
  {
    public boolean dGX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.eu
 * JD-Core Version:    0.7.0.1
 */
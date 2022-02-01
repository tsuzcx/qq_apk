package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class fa
  extends IEvent
{
  public a dIs;
  public b dIt;
  
  public fa()
  {
    this((byte)0);
  }
  
  private fa(byte paramByte)
  {
    AppMethodBeat.i(116010);
    this.dIs = new a();
    this.dIt = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116010);
  }
  
  public static final class a
  {
    public boolean clear;
    public String dGL;
    public int direction;
  }
  
  public static final class b
  {
    public boolean dGX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.fa
 * JD-Core Version:    0.7.0.1
 */
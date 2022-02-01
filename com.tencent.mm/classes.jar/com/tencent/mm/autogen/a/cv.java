package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class cv
  extends IEvent
{
  public a hCG;
  
  public cv()
  {
    this((byte)0);
  }
  
  private cv(byte paramByte)
  {
    AppMethodBeat.i(91201);
    this.hCG = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91201);
  }
  
  public static final class a
  {
    public long delay;
    public int fee;
    public String hCH;
    public String hCI;
    public String hCJ;
    public String hCK;
    public String hCL;
    public boolean hCM = true;
    public int source;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.cv
 * JD-Core Version:    0.7.0.1
 */
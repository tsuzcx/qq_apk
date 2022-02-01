package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class fh
  extends IEvent
{
  public a fBj;
  public b fBk;
  
  public fh()
  {
    this((byte)0);
  }
  
  private fh(byte paramByte)
  {
    AppMethodBeat.i(116010);
    this.fBj = new a();
    this.fBk = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116010);
  }
  
  public static final class a
  {
    public boolean clear;
    public int direction;
    public String fzB;
  }
  
  public static final class b
  {
    public boolean fzO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.fh
 * JD-Core Version:    0.7.0.1
 */
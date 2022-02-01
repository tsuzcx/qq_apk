package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class fb
  extends IEvent
{
  public a fAT;
  public b fAU;
  
  public fb()
  {
    this((byte)0);
  }
  
  private fb(byte paramByte)
  {
    AppMethodBeat.i(116004);
    this.fAT = new a();
    this.fAU = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116004);
  }
  
  public static final class a
  {
    public int fAV = -1;
    public String fzM;
    public boolean fzN = false;
  }
  
  public static final class b
  {
    public boolean fzO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.fb
 * JD-Core Version:    0.7.0.1
 */
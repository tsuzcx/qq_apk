package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ef
  extends IEvent
{
  public a fzR;
  public b fzS;
  
  public ef()
  {
    this((byte)0);
  }
  
  private ef(byte paramByte)
  {
    AppMethodBeat.i(115982);
    this.fzR = new a();
    this.fzS = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(115982);
  }
  
  public static final class a
  {
    public String fzB;
    public String fzT;
  }
  
  public static final class b
  {
    public boolean fzO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.ef
 * JD-Core Version:    0.7.0.1
 */
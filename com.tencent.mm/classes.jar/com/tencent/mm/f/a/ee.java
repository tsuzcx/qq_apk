package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ee
  extends IEvent
{
  public a fzP;
  public b fzQ;
  
  public ee()
  {
    this((byte)0);
  }
  
  private ee(byte paramByte)
  {
    AppMethodBeat.i(115981);
    this.fzP = new a();
    this.fzQ = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(115981);
  }
  
  public static final class a
  {
    public String fzB;
    public String fzM;
    public boolean fzN = false;
  }
  
  public static final class b
  {
    public boolean fzO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.ee
 * JD-Core Version:    0.7.0.1
 */
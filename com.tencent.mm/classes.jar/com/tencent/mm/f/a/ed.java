package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ed
  extends IEvent
{
  public a fzK;
  public b fzL;
  
  public ed()
  {
    this((byte)0);
  }
  
  private ed(byte paramByte)
  {
    AppMethodBeat.i(115980);
    this.fzK = new a();
    this.fzL = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(115980);
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
 * Qualified Name:     com.tencent.mm.f.a.ed
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class eh
  extends IEvent
{
  public a fzW;
  public b fzX;
  
  public eh()
  {
    this((byte)0);
  }
  
  private eh(byte paramByte)
  {
    AppMethodBeat.i(115984);
    this.fzW = new a();
    this.fzX = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(115984);
  }
  
  public static final class a
  {
    public boolean fzN = false;
  }
  
  public static final class b
  {
    public boolean fzO;
    public String fzY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.eh
 * JD-Core Version:    0.7.0.1
 */
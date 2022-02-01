package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class eb
  extends IEvent
{
  public a fzD;
  public b fzE;
  
  public eb()
  {
    this((byte)0);
  }
  
  private eb(byte paramByte)
  {
    AppMethodBeat.i(115978);
    this.fzD = new a();
    this.fzE = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(115978);
  }
  
  public static final class a
  {
    public String fzB;
    public String fzF;
  }
  
  public static final class b
  {
    public boolean fzG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.a.eb
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ec
  extends IEvent
{
  public a fzH;
  public b fzI;
  
  public ec()
  {
    this((byte)0);
  }
  
  private ec(byte paramByte)
  {
    AppMethodBeat.i(115979);
    this.fzH = new a();
    this.fzI = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(115979);
  }
  
  public static final class a
  {
    public String fzB;
    public String fzF;
  }
  
  public static final class b
  {
    public boolean fzJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.ec
 * JD-Core Version:    0.7.0.1
 */
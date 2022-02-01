package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.sdk.event.IEvent;

public final class dy
  extends IEvent
{
  public a fzv;
  public b fzw;
  
  public dy()
  {
    this((byte)0);
  }
  
  private dy(byte paramByte)
  {
    AppMethodBeat.i(115975);
    this.fzv = new a();
    this.fzw = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(115975);
  }
  
  public static final class a
  {
    public String fzx;
    public int fzy = 0;
    public q fzz;
    public int opType = 0;
  }
  
  public static final class b
  {
    public q fzz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.dy
 * JD-Core Version:    0.7.0.1
 */
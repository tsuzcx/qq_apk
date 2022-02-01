package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class dr
  extends IEvent
{
  public a fzh;
  
  public dr()
  {
    this((byte)0);
  }
  
  private dr(byte paramByte)
  {
    AppMethodBeat.i(104414);
    this.fzh = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(104414);
  }
  
  public static final class a
  {
    public int fvK;
    public String md5;
    public boolean success;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.dr
 * JD-Core Version:    0.7.0.1
 */
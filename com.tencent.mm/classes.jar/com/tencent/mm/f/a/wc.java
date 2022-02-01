package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class wc
  extends IEvent
{
  public a fVk;
  
  public wc()
  {
    this((byte)0);
  }
  
  private wc(byte paramByte)
  {
    AppMethodBeat.i(227201);
    this.fVk = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(227201);
  }
  
  public static final class a
  {
    public int fVl = 0;
    public int fVm = 0;
    public int fVn = 0;
    public int fVo = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.wc
 * JD-Core Version:    0.7.0.1
 */
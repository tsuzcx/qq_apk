package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class em
  extends IEvent
{
  public a fAp;
  public b fAq;
  
  public em()
  {
    this((byte)0);
  }
  
  private em(byte paramByte)
  {
    AppMethodBeat.i(115989);
    this.fAp = new a();
    this.fAq = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(115989);
  }
  
  public static final class a
  {
    public String fAg;
    public long msgId;
  }
  
  public static final class b
  {
    public boolean fzO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.em
 * JD-Core Version:    0.7.0.1
 */
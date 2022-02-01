package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ex
  extends IEvent
{
  public a hFc;
  public b hFd;
  
  public ex()
  {
    this((byte)0);
  }
  
  private ex(byte paramByte)
  {
    AppMethodBeat.i(115989);
    this.hFc = new a();
    this.hFd = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(115989);
  }
  
  public static final class a
  {
    public String hES;
    public long msgId;
  }
  
  public static final class b
  {
    public boolean hEn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.ex
 * JD-Core Version:    0.7.0.1
 */
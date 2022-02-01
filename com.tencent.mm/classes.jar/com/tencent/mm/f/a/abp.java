package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class abp
  extends IEvent
{
  public a gbw;
  
  public abp()
  {
    this((byte)0);
  }
  
  private abp(byte paramByte)
  {
    AppMethodBeat.i(91233);
    this.gbw = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91233);
  }
  
  public static final class a
  {
    public int result;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.abp
 * JD-Core Version:    0.7.0.1
 */
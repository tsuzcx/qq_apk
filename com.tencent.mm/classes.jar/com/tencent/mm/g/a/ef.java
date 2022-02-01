package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ef
  extends IEvent
{
  public a dHy;
  public b dHz;
  
  public ef()
  {
    this((byte)0);
  }
  
  private ef(byte paramByte)
  {
    AppMethodBeat.i(115989);
    this.dHy = new a();
    this.dHz = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(115989);
  }
  
  public static final class a
  {
    public String dHp;
    public long msgId;
  }
  
  public static final class b
  {
    public boolean dGX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.ef
 * JD-Core Version:    0.7.0.1
 */
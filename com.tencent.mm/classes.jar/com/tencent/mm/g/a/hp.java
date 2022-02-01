package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.storage.ca;

public final class hp
  extends IEvent
{
  public a dMg;
  public b dMh;
  
  public hp()
  {
    this((byte)0);
  }
  
  private hp(byte paramByte)
  {
    AppMethodBeat.i(55662);
    this.dMg = new a();
    this.dMh = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(55662);
  }
  
  public static final class a
  {
    public ca dCM;
  }
  
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.hp
 * JD-Core Version:    0.7.0.1
 */
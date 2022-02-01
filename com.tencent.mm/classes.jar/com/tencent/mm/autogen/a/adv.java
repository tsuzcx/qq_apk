package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class adv
  extends IEvent
{
  public a iig;
  public b iih;
  
  public adv()
  {
    this((byte)0);
  }
  
  private adv(byte paramByte)
  {
    AppMethodBeat.i(19850);
    this.iig = new a();
    this.iih = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19850);
  }
  
  public static final class a
  {
    public int hAf;
    public String username;
  }
  
  public static final class b
  {
    public int iii;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.autogen.a.adv
 * JD-Core Version:    0.7.0.1
 */
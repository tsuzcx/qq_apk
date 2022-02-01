package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ch
  extends IEvent
{
  public a dFr;
  public b dFs;
  
  public ch()
  {
    this((byte)0);
  }
  
  private ch(byte paramByte)
  {
    AppMethodBeat.i(43440);
    this.dFr = new a();
    this.dFs = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(43440);
  }
  
  public static final class a
  {
    public String username;
  }
  
  public static final class b
  {
    public String appId;
    public String[] cze;
    public String nickname;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.ch
 * JD-Core Version:    0.7.0.1
 */
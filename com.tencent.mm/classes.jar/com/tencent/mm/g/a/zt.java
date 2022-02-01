package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class zt
  extends IEvent
{
  public a efM;
  public b efN;
  
  public zt()
  {
    this((byte)0);
  }
  
  private zt(byte paramByte)
  {
    AppMethodBeat.i(91223);
    this.efM = new a();
    this.efN = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91223);
  }
  
  public static final class a
  {
    public String scene;
  }
  
  public static final class b
  {
    public String content;
    public String efO;
    public String url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.a.zt
 * JD-Core Version:    0.7.0.1
 */
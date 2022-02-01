package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ul
  extends IEvent
{
  public a eaM;
  public b eaN;
  
  public ul()
  {
    this((byte)0);
  }
  
  private ul(byte paramByte)
  {
    AppMethodBeat.i(93327);
    this.eaM = new a();
    this.eaN = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(93327);
  }
  
  public static final class a
  {
    public String eaO;
    public String eaP;
    public int eaQ = 0;
  }
  
  public static final class b
  {
    public String eaO;
    public boolean isSuccess = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.a.ul
 * JD-Core Version:    0.7.0.1
 */
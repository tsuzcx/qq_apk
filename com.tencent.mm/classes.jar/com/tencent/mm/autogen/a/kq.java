package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class kq
  extends IEvent
{
  public a hMl;
  public b hMm;
  
  public kq()
  {
    this((byte)0);
  }
  
  private kq(byte paramByte)
  {
    AppMethodBeat.i(89645);
    this.hMl = new a();
    this.hMm = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(89645);
  }
  
  public static final class a
  {
    public int bUl = 0;
    public String url;
  }
  
  public static final class b
  {
    public String hMn;
    public boolean hMo = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.a.kq
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class kn
  extends IEvent
{
  public a hMg;
  public b hMh;
  
  public kn()
  {
    this((byte)0);
  }
  
  private kn(byte paramByte)
  {
    AppMethodBeat.i(89643);
    this.hMg = new a();
    this.hMh = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(89643);
  }
  
  public static final class a
  {
    public int bUl = 0;
    public String param;
  }
  
  public static final class b
  {
    public String hMi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.kn
 * JD-Core Version:    0.7.0.1
 */
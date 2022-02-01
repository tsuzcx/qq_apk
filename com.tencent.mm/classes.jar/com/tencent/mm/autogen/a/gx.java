package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class gx
  extends IEvent
{
  public b hHA;
  public a hHz;
  
  public gx()
  {
    this((byte)0);
  }
  
  private gx(byte paramByte)
  {
    AppMethodBeat.i(116023);
    this.hHz = new a();
    this.hHA = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116023);
  }
  
  public static final class a
  {
    public String fileName;
    public int from = 0;
    public String hHB;
    public int hHC = 0;
    public Runnable hHD;
    public int scene;
  }
  
  public static final class b
  {
    public boolean cVt;
    public String content;
    public int state = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.gx
 * JD-Core Version:    0.7.0.1
 */
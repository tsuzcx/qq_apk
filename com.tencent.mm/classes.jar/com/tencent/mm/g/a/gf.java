package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class gf
  extends IEvent
{
  public a dJV;
  public b dJW;
  
  public gf()
  {
    this((byte)0);
  }
  
  private gf(byte paramByte)
  {
    AppMethodBeat.i(116023);
    this.dJV = new a();
    this.dJW = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116023);
  }
  
  public static final class a
  {
    public String dJX;
    public int dJY = 0;
    public Runnable dJZ;
    public String fileName;
    public int from = 0;
    public int scene;
  }
  
  public static final class b
  {
    public boolean brW;
    public String content;
    public int state = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.gf
 * JD-Core Version:    0.7.0.1
 */
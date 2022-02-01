package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class gm
  extends IEvent
{
  public a fCK;
  public b fCL;
  
  public gm()
  {
    this((byte)0);
  }
  
  private gm(byte paramByte)
  {
    AppMethodBeat.i(116023);
    this.fCK = new a();
    this.fCL = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116023);
  }
  
  public static final class a
  {
    public String fCM;
    public int fCN = 0;
    public Runnable fCO;
    public String fileName;
    public int from = 0;
    public int scene;
  }
  
  public static final class b
  {
    public boolean bby;
    public String content;
    public int state = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.gm
 * JD-Core Version:    0.7.0.1
 */
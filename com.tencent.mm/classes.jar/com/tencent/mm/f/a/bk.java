package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.storage.ca;

public final class bk
  extends IEvent
{
  public a fxc;
  public b fxd;
  
  public bk()
  {
    this((byte)0);
  }
  
  private bk(byte paramByte)
  {
    AppMethodBeat.i(149853);
    this.fxc = new a();
    this.fxd = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149853);
  }
  
  public static final class a
  {
    public ca fvt;
  }
  
  public static final class b
  {
    public int fxe = 0;
    public int fxf = 0;
    public int fxg = 0;
    public int fxh = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.bk
 * JD-Core Version:    0.7.0.1
 */
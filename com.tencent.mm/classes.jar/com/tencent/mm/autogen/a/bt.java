package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.storage.cc;

public final class bt
  extends IEvent
{
  public a hBH;
  public b hBI;
  
  public bt()
  {
    this((byte)0);
  }
  
  private bt(byte paramByte)
  {
    AppMethodBeat.i(149853);
    this.hBH = new a();
    this.hBI = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149853);
  }
  
  public static final class a
  {
    public cc hzO;
  }
  
  public static final class b
  {
    public int hBJ = 0;
    public int hBK = 0;
    public int hBL = 0;
    public int hBM = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.bt
 * JD-Core Version:    0.7.0.1
 */
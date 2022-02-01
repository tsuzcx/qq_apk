package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class kv
  extends IEvent
{
  public a hMu;
  public b hMv;
  
  public kv()
  {
    this((byte)0);
  }
  
  private kv(byte paramByte)
  {
    AppMethodBeat.i(91206);
    this.hMu = new a();
    this.hMv = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91206);
  }
  
  public static final class a
  {
    public boolean hMw = false;
    public int hMx = 0;
    public String hMy;
  }
  
  public static final class b
  {
    public String hMA;
    public String hMz;
    public boolean isSuccess = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.a.kv
 * JD-Core Version:    0.7.0.1
 */
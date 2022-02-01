package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class gc
  extends b
{
  public a drK;
  public b drL;
  
  public gc()
  {
    this((byte)0);
  }
  
  private gc(byte paramByte)
  {
    AppMethodBeat.i(116024);
    this.drK = new a();
    this.drL = new b();
    this.IbR = false;
    this.callback = null;
    AppMethodBeat.o(116024);
  }
  
  public static final class a
  {
    public String fileName;
  }
  
  public static final class b
  {
    public long msgId = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.gc
 * JD-Core Version:    0.7.0.1
 */